package org.incubyte_automationtest.incubyte_automation_test;

import java.util.Random;

public class Utilities {

	public static String generateRandomString() {
		int lengthOfString = 10;
        String charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        
        for(int i=0; i<lengthOfString ; i++) {
        	int index = random.nextInt(charPool.length());
        	randomString.append(charPool.charAt(index));
        }
		return randomString.toString();
	}
	
}
