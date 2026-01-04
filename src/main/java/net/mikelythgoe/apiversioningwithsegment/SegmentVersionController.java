package net.mikelythgoe.apiversioningwithsegment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegmentVersionController {

    @GetMapping(value = "/{version}/hello", version = "1.0")
    public String helloV1() {
        return "Hello Version One";
    }

    // Version must be major.minor.patch format
    @GetMapping(value = "/{version}/hello", version = "2.0")
    public String helloV2() {
        return "Hello Version Two";
    }

    @GetMapping(value = "/{version}/hello", version = "3.5")
    public String hellov35() {
        return "Hello Version 3.5";
    }

    @GetMapping(value = "/{version}/hello", version = "9.9")
    public String hellov99() {
        return "Hello Version 9.9";
    }
}
