package com.nicolasf.restwebservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Expose a REST API
@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello-world") //, method = RequestMethod.GET) // When using @RestController, @GetMapping is a shortcut for @RequestMapping(method=GET)
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) { // @PathVariable is used to map the {name} variable to the String name parameter
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
