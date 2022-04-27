package com.password;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "pwGen",
         mixinStandardHelpOptions = true,
         description = "Prints a new password of given length, with given amount of digits and special characters included")
class App implements Callable<Integer> {
    
    @Option(names = {"-l", "--length"},
            description = "desired length of password, the default value is ${DEFAULT-VALUE} ",
            defaultValue = "8")
    int pwLength;

    @Option(names = {"-d", "--digits"},
            description = "number of digits to be included in the password, the default value is ${DEFAULT-VALUE} ",
            defaultValue = "2")
    int numOfDigits;

    @Option(names = {"-s", "--specials"},
            description = "number of special symbols to be included in the password, the default value is ${DEFAULT-VALUE} ",
            defaultValue = "2")
    int numOfspecials;

    @Override
    public Integer call() throws Exception {
        
        Generator generator = new Generator();
        String newPassword = generator.generate(pwLength, numOfDigits, numOfspecials);
        System.out.println(newPassword);
        return  0;
    }
    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }
}
