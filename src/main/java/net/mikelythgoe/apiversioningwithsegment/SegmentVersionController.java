package net.mikelythgoe.apiversioningwithsegment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegmentVersionController {

    @GetMapping(value = "/{version}/hello", version = "1.0")
    public String helloV1() {
        return "Hello Version One";
    }

    @GetMapping(value = "/{version}/hello", version = "2.0")
    public String helloV2() {
        return "Hello Version Two";
    }
}
