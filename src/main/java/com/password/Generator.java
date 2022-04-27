package com.password;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.Collections;


public class Generator {

    private final Random r = SecureRandom.getInstanceStrong();

    public Generator() throws NoSuchAlgorithmException{}

    public String generate(int passwordLength, int numOfDigits, int numOfSpecials) {

        int numOfLettersNeeded = passwordLength - numOfDigits - numOfSpecials;
        
        String lLetters = "abcdefghijklmnopqrstuvwxyz";
        String uLetters = lLetters.toUpperCase();
        
        char[] letters = lLetters.concat(uLetters).toCharArray();
        int lettersLength = letters.length;

        char[] symbols = "!£$%^&*()[]{}~#'@;:<>?".toCharArray();
        int sizeOfSymbolsArray = symbols.length;

        ArrayList<String> pwContainer = new ArrayList<>();

        IntStream.range(0, numOfLettersNeeded)
            .forEach(
                     x -> {char temp = letters[r.nextInt(lettersLength-1)];
                            pwContainer.add(String.valueOf(temp));}
                 );

        r.ints(numOfDigits, 1, 10)
            .boxed()
            .map(String::valueOf)
            .forEach(pwContainer::add);

        r.ints(numOfSpecials, 1, sizeOfSymbolsArray)        
            .boxed()
            .map(y -> symbols[y])
            .map(String::valueOf)
            .forEach(pwContainer::add);

        IntStream.range(0, r.nextInt(3, 9))
            .boxed()
            .forEach(u -> Collections.shuffle(pwContainer, r));
            
        return pwContainer.stream()
            .reduce("", String::concat);
    }
}