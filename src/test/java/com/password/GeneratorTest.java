package com.password;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class GeneratorTest {

    @ParameterizedTest
    @MethodSource
    void testGenerator(int num) {
        String regExp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[\\!\\£\\$\\%\\^\\&\\*\\(\\)\\[\\]\\{\\}\\~\\#\\'\\@\\;\\:\\<\\>\\?]).{"+ num +"}$";
        try {
            Generator generator = new Generator();
            String testString = generator.generate(num, 2, 2);

            Assertions.assertEquals(num, testString.length());
            Assertions.assertTrue(testString.matches(regExp));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }
    private static IntStream testGenerator() {
        Random r = new Random();
        return r.ints(50, 7, 20);
    }
}