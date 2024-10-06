package com.parkinglot.util.randomGenerator;
import java.util.Random;
public class RefNumberGenerator {

        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        private static final Random random = new Random();

        public static String generateRefNumber(int length) {
            StringBuilder refNumber = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                refNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
            }
            return refNumber.toString();
        }

        public static void main(String[] args) {
            String refNumber = generateRefNumber(6);
            System.out.println("Generated Reference Number: " + refNumber);
        }
}