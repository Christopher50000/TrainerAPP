package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Setting Route that is public
    @GetMapping("/")
    public String home()
    {
        return "Hello,Home";
    }

    @GetMapping("/secured")
    public String secured()
    {
        return "Hello, Secured";
    }
}
