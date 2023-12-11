package com.api.urlshortener.utils;

import java.math.BigInteger;

public class Base62Converter {

    private static final String BASE_62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encodeToBase62(String input) {
        if (input == null){
            return "";
        };

        BigInteger value = BigInteger.ZERO;
        for (char ch : input.toCharArray()){
            value = value.multiply(BigInteger.valueOf(256)).add(BigInteger.valueOf(ch));
        };

        StringBuilder encoded = new StringBuilder();

        while (!value.equals(BigInteger.ZERO)) {
            BigInteger[] divRem = value.divideAndRemainder(BigInteger.valueOf(62));
            int remainder = divRem[1].intValue();
            encoded.insert(0, BASE_62_CHARS.charAt(remainder));
            value = divRem[0];
        }

        return encoded.toString();
    }

}