package com.sherwin.postgresdemo.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final String YOUR_DOMAIN_NAME = "sandbox3d44072c00514803b9bf5b2e6e5d7f5e.mailgun.org"; //TODO put your domain name here
    public static String API_KEY = "23b5f53d32c0f1ea4ab39a803b844fad-a65173b1-702727b5"; //TODO put your Private API Key here

    public void sendSimpleMessage() throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/"
                + YOUR_DOMAIN_NAME + "/messages")
                .basicAuth("api", API_KEY)
                .field("from", "Sherwin W sherwin.water@gmail.com")
                .field("to", "sherwin.water2@gmail.com")//TODO put your emails here
                .field("subject", "Hello From Students")
                .field("text", "Testing Students")
                .asJson();
//        return request.getBody();
    }
}
