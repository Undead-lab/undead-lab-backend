package io.wootlab.data.security;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class SecurityEndpoint {

    @Get("/connected")
    public HttpResponse connected(){
        return HttpResponse.ok();
    }
}
