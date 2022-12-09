package com.sosnilosm.AnonymousBookReviews;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sergei Sosnilo
 */
@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index() {
        return "Go to 'http://localhost:8080/graphiql?path=/graphql'";
    }

}