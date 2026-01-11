package net.mikelythgoe.apiversioningwithsegment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegmentVersionController {
    // For versioning, the version must be major.minor.patch format

    // http://localhost:8080/hello/1.0 (matches on /1.0/, /1/, or /1.0.0/, but you can't use /1.1/, /1.0.1/, etc.')
    @GetMapping(value = "/hello/{version}", version = "1")
    public ResponseEntity<Message> helloV1point0() {
        return ResponseEntity.ok(new Message("Hello Version 1"));

    }

    // http://localhost:8080/2.0/hello (matches on /2.0/, /2/, or /2.0.0/, but you can't use /2.1/, /2.0.1/, etc.')
    // Example: curl --location 'http://localhost:8080/hello/2.0'
    @GetMapping(value = "/hello/{version}", version = "2")
    public ResponseEntity<Message> helloV2point0() {
        return ResponseEntity.ok(new Message("Hello Version 2"));

    }

    // http://localhost:8080/hello/3.5 (matches on /3.5/, or /3.5.0/, but you can't use /3.6., /3.5.1/, etc.)
    @GetMapping(value = "/hello/{version}", version = "3.5")
    public ResponseEntity<Message> helloV3point5() {
        return ResponseEntity.ok(new Message("Hello Version 3.5"));

    }

    // http://localhost:8080/hello/9 (matches on /9/, /9.0/, or /9.0.0/, but you can't use /9.0.1/)
    @GetMapping(value = "/hello/{version}", version = "9")
    public ResponseEntity<Message> helloV9() {
        return ResponseEntity.ok(new Message("Hello Version 9"));

    }

    // http://localhost:8080/hello/9.9 (matches on /9.9/, /9.9.0/, but you can't use /9.0.1/)
    @GetMapping(value = "/hello/{version}", version = "9.9")
    public ResponseEntity<Message> helloV9point9() {
        return ResponseEntity.ok(new Message("Hello Version 9.9"));

    }

}
