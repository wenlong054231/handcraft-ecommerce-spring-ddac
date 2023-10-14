package com.DDAC.SpringAngular.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class StripeService {

    @Value("${stripe.secret-key}") // Load your Stripe secret key from application.properties
    private String secretKey;

    public PaymentIntent createPaymentIntent(BigDecimal amount) throws StripeException {
        Stripe.apiKey = secretKey;

        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setAmount(amount.multiply(BigDecimal.valueOf(100)).longValue()) // Convert amount to cents
                .setCurrency("usd")
                .build();

        return PaymentIntent.create(createParams);
    }
}
