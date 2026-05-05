package com.purchase.order.purchase_order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.Security;

@SpringBootApplication
public class PurchaseOrderServiceApplication {

	static {
		try {
			Security.insertProviderAt(
				(java.security.Provider) Class.forName("oracle.security.pki.OraclePKIProvider")
					.getConstructor().newInstance(), 3);
		} catch (Exception ignored) {}
	}

	public static void main(String[] args) {
		SpringApplication.run(PurchaseOrderServiceApplication.class, args);
	}

}
