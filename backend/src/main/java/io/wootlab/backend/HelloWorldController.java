package io.wootlab.backend;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloWorldController {

    @Get("/hello")
    public String hello() {
        return "Hello world";
    }

}