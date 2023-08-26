package com.nicolasf.restwebservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("v1/person")
    public PersonV1 getFirstVersionPerson () {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionPerson () {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionPersonReqParam () {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionPersonReqParam () {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionPersonReqHeader () {
        return new PersonV1("Bob Charlie Header");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionPersonReqHeader () {
        return new PersonV2(new Name("Bob", "Charlie Header"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionPersonReqAccept () {
        return new PersonV1("Bob Charlie Accept Header");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionPersonReqAccept () {
        return new PersonV2(new Name("Bob", "Charlie Accept Header"));
    }
}
