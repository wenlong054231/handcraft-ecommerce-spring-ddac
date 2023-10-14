package com.DDAC.SpringAngular.CheckoutController;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DDAC.SpringAngular.Service.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {
		
    @Autowired
    private StripeService stripeService; // You can create a service to handle Stripe interactions
    
    @Value("${stripe.secret-key}") // Load your Stripe secret key from application.properties
    private String secretKey;
    
    @CrossOrigin
    @PostMapping("/pay")
    public ResponseEntity<Object> checkout(@RequestBody CheckoutRequest checkoutRequest) {
        try {
            // Call a method in your Stripe service to create a payment intent
            PaymentIntent paymentIntent = stripeService.createPaymentIntent(checkoutRequest.getAmount());
            
            // Return sessionId
            return ResponseEntity.ok(paymentIntent.getId()); 
        } catch (StripeException e) {
            // Handle Stripe API error and return appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment error");
        }
    }
    
    @CrossOrigin
    @PostMapping("/create-session")
    public ResponseEntity<Object> createCheckoutSession(@RequestParam BigDecimal amount) {
        try {
            Stripe.apiKey = secretKey;
            
            long unitAmountCents = amount.multiply(BigDecimal.valueOf(100)).longValue();
            
            SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://web-static-handicraft.s3-website-us-east-1.amazonaws.com/history") // Change to your success URL
                .setCancelUrl("http://web-static-handicraft.s3-website-us-east-1.amazonaws.com/home")   // Change to your cancel URL
                .addLineItem(
                    SessionCreateParams.LineItem.builder()
                        .setPriceData(
                            SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("myr")
                                .setUnitAmount(unitAmountCents)
                                .setProductData(
                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName("Handicraft")
                                        .build()
                                )
                                .build()
                        )
                        .setQuantity((long) 1)
                        .build()
                )
                .build();

            Session session = Session.create(params);
            return ResponseEntity.ok(session.getId());
        } catch (StripeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Session creation error");
        }
    }

}

