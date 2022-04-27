package com.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import picocli.CommandLine;

class CliTest {

    @Test
    void cliTest() {
    
        String[] args = {"-l", "10", "-d", "3", "-s", "3"};
        try {
            App app = new App();
            new CommandLine(app).parseArgs(args);
            Assertions.assertEquals(10, app.pwLength);
            Assertions.assertNotEquals(9, app.pwLength);
            Assertions.assertNotEquals(11, app.pwLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}