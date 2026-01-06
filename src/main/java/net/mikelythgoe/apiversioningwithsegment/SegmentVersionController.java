package net.mikelythgoe.apiversioningwithsegment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegmentVersionController {

    // For segment versioning, version must be major.minor.patch format

    // http://localhost:8080/1.0/hello (matches on /1.0/, /1/, or /1.0.0/, but you can't use /1.1/, /1.0.1/, etc.')
    @GetMapping(value = "/{version}/hello", version = "1")
    public String helloV1point0() {
        return "Hello Version 1";
    }

    // http://localhost:8080/2.0/hello (matches on /2.0/, /2/, or /2.0.0/, but you can't use /2.1/, /2.0.1/, etc.')
    @GetMapping(value = "/{version}/hello", version = "2")
    public String helloV2point0() {
        return "Hello Version 2";
    }

    // http://localhost:8080/3.5/hello (matches on /3.5/, or /3.5.0/, but you can't use /3.6., /3.5.1/, etc.)
    @GetMapping(value = "/{version}/hello", version = "3.5")
    public String helloV3point5() {
        return "Hello Version 3.5";
    }

    // http://localhost:8080/9/hello (matches on /9/, /9.0/, or /9.0.0/, but you can't use /9.0.1/)
    @GetMapping(value = "/{version}/hello", version = "9")
    public String helloV9() {
        return "Hello Version 9";
    }

    // http://localhost:8080/9.9/hello (matches on /9.9/, /9.9.0/, but you can't use /9.0.1/)
    @GetMapping(value = "/{version}/hello", version = "9.9")
    public String helloV9point9() {
        return "Hello Version 9.9";
    }

}
