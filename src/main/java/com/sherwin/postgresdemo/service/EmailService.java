package com.sherwin.postgresdemo.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {

    private static final String YOUR_DOMAIN_NAME = System.getenv("MAILGUN_DOMAIN"); //TODO put your domain name here
    public static String API_KEY = System.getenv("MAILGUN_API_KEY"); //TODO put your Private API Key here

    public void sendSimpleMessage() throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/"
                + YOUR_DOMAIN_NAME + "/messages")
                .basicAuth("api", API_KEY)
                .field("from", "Sherwin W sherwin.water@gmail.com")
                .field("to", "sherwin.water2@gmail.com")//TODO put your emails here
                .field("subject", "Hello From Students")
//                .field("text", "Testing Students")
                .field("html","<html><a href='http://stackoverflow.com'>HTML version of the body</a></html>")
                .asJson();
//        return request.getBody();
    }

    public static JsonNode createTemplate() throws UnirestException {

        HttpResponse <JsonNode> request = Unirest.post("https://api.mailgun.net/v3/"
                + YOUR_DOMAIN_NAME + "/templates")
                .basicAuth("api", API_KEY)
                .field("name", "template.name")
                .field("description", "template description")
                .asJson();

        return request.getBody();
    }

}
