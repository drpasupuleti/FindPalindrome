package com.core.palindrome;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    org.slf4j.Logger log = LoggerFactory.getLogger(PalindromeServiceImpl.class);

    /**
     * This service takes the page URL and looks if the page text contains the palindrome
     *
     * @param pageUrl
     * @return
     */
    @Override
    public String findPalindrome(String pageUrl) {

        if (pageUrl.endsWith(".txt")) {
            try {
                java.net.URL oracle = new URL(pageUrl);
                BufferedReader bReader = new BufferedReader(
                        new InputStreamReader(oracle.openStream()));

                log.info("What does the page contain " + bReader.readLine());

                // It is used to read a line
                String line;

                StringBuffer cleanText = new StringBuffer();

                while ((line = bReader.readLine()) != null) {
                    // remove punctuation, whitespace and caps
                    String charsInaLine = line.toLowerCase().replaceAll("[\\W]", "");
                    cleanText.append(charsInaLine);
                }

                System.out.println("Cleaned text: " + cleanText);

                // Now, verify if the text that is extracted from the file contains a palindrome
                StringBuffer originalString = new StringBuffer();
                for (int i = 0; i < cleanText.length(); i++) {
                    Character cha = cleanText.charAt(i);
                    originalString.append(cha);
                    StringBuffer stringTobeReversed = new StringBuffer(originalString);
                    // If the string contains more than 4 and reverse string equals to original string
                    if (originalString.length() >= 4 && stringTobeReversed.reverse().toString().
                            equalsIgnoreCase(originalString.toString())) {
                        log.info("This page text contains a palindrome!!!");
                        return "This page text contains a palindrome";
                    }

                }
            } catch (Exception e) {
                log.error("Exception while finding palindrome " + e);
            }
            return "This string doesn't contain a palindrome";
        }
        return "Please provide a page url that ends with .txt";
    }


}
