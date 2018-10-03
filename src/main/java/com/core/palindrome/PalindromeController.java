package com.core.palindrome;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The basic idea of this controller is to take the request from the front-end and returns the response appropiately.
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/findPalindrome")
public class PalindromeController {

    private org.slf4j.Logger log = LoggerFactory.getLogger(PalindromeController.class);

    @Autowired
    private PalindromeService palindromeService;

    @PostMapping
    public String findPalindrome(@RequestBody String pageURL) {
        log.info("Page URL is " + pageURL);
        return palindromeService.findPalindrome(pageURL);
    }
}