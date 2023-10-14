package com.DDAC.SpringAngular.CheckoutController;

import org.springframework.beans.factory.annotation.Value;

import com.stripe.param.PaymentIntentCreateParams;

public class MyPaymentIntent {
	
	@Value("${stripe.secret.key}")
    private String secretKey; 
	
	public Object getClientSecret() {		
		return secretKey;
	}

	public static MyPaymentIntent create(PaymentIntentCreateParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setClientSecret(String clientSecret) {
		// TODO Auto-generated method stub
		this.secretKey = clientSecret;
	}

}
