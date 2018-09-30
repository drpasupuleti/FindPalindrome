import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// This class will check for palindromic strings after removing spaces, lines and punctionations
public class FindPalindrome {

    public static void main(String args[]) throws IOException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File inputFile = new File(classLoader.getResource("lovecraft.txt").getFile());
        System.out.println("File exists ? " + inputFile.exists());

        // Read the file to buffer
        BufferedReader bReader = new BufferedReader(new FileReader(inputFile));

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
                System.out.println("This string is a palindrome!!");
                return;
            }

        }

        System.out.println("This string doesn't contain a palindrome: " + originalString);

    }
}
