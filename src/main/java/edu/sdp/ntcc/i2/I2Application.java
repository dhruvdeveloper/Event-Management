package edu.sdp.ntcc.i2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class I2Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(I2Application.class, args);
            openHomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
    }

}