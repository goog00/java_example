package com.example.regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexTest {

    @Test
    public void regex_tax_id_or_employer_identification_number(){

        String taxIdRegex = "^([07][1-7]|1[0-6]|2[0-7]|[35][0-9]|[468][0-8]|9[0-589])-?\\d{7}$";
        System.out.println("45-4444444".matches(taxIdRegex));
        System.out.println("454444444".matches(taxIdRegex));
        System.out.println("98765432".matches(taxIdRegex));
    }

    @Test
    public void regex_html_tag(){
        String htmlRegex = "(\\<(/?[^\\>]+)\\>)";
        System.out.println("<h2>".matches(htmlRegex));
        System.out.println("</h2>".matches(htmlRegex));
        System.out.println("<p>".matches(htmlRegex));
        System.out.println("<script type='text/javascript'>".matches(htmlRegex));
    }

    @Test
    public void regex_valid_url(){
        String urlRegex = "\b(https?|ftp|file|ldap)://"
                + "[-A-Za-z0-9+&@#/%?=~_|!:,.;]"
                + "*[-A-Za-z0-9+&@#/%=~_|]";

        System.out.println("http://www.leveluplunch.com".matches(urlRegex));
        Assert.assertTrue("http://www.leveluplunch.com".matches(urlRegex));

        assertTrue("http://www.leveluplunch.com/index.html".matches(urlRegex));

        assertTrue("http://leveluplunch.com".matches(urlRegex));

        assertTrue("https://www.leveluplunch.com/examples".matches(urlRegex));

        assertTrue("http://www.leveluplunch.com/examples?abc=123".matches(urlRegex));

        assertTrue("ldap://myhost:389".matches(urlRegex));

        assertTrue("ftp://user:password@host:port/URI?queryParameters".matches(urlRegex));

        assertFalse("www.leveluplunch.com".matches(urlRegex));
    }

    @Test
    public void regex_number_range(){

        String numberRangeRegex = "\\d{3}";
        System.out.println("123".matches(numberRangeRegex));
        System.out.println("222".matches(numberRangeRegex));
        System.out.println("12".matches(numberRangeRegex));

    }

    /**
     * Consecutive duplicated words regex
     * the regex will check if there is a series of words that are duplicated
     */
    @Test
    public void regex_consecutive_duplicated_words(){
        String duplicatedWordRegex = "\\b(\\w+)\\s+\\1\\b";
        System.out.println("so so".matches(duplicatedWordRegex));
        System.out.println("so this,so this".matches(duplicatedWordRegex));
    }

    /**
     * the regex expression will validate the format of a phone number
     */
    @Test
    public void regex_phone_numbers(){
        String phoneNumberRegex = "^(\\([2-9]|[2-9])"
                + "(\\d{2}|\\d{2}\\))"
                + "(-|.|\\s)?\\d{3}(-|.|\\s)?\\d{4}$";
        System.out.println("223-123-1234".matches(phoneNumberRegex));
    }

    /**
     * 邮编
     */
    @Test
    public void regex_zip_code(){

        String zipCodeRegEx = "[0-9]{5}(\\-?[0-9]{4})?$";
        System.out.println("53546".matches(zipCodeRegEx));
    }

    @Test
    public void regex_email_address(){
        String emailRegEx = "^[a-zA-Z0-9'._%+-]+@"
                + "(?:[a-zA-Z0-9-]+\\.)"
                + "+[a-zA-Z]{2,4}$";
        System.out.println("ffff@163.com".matches(emailRegEx));
    }

    @Test
    public void regex_image_file_names(){
        String fileImageTypes = "([^\\s]+(?=\\.(jpg|gif|png))\\.\\2)";
        System.out.println("/assets/images/leveluplunch.jpg".matches(fileImageTypes));
    }


    /**
     * this java code below will show how to retrieve all digits from a string using a regular expression
     */
    @Test
    public void find_all_digits_in_string(){
        String digits = "abc123-abc123_abc123".replaceAll("\\D","");
        System.out.println(digits);
    }

    /**
     * This example will show how write a regular expression to remove
     * everything but numbers from a java string.
     * this is particular helpful if you want to change a string to a number
     * and avoid NumberFormatException
     */
    @Test
    public void remove_all_chars(){
        String digits = "1a2b3c".replaceAll("[^\\d]","");
        System.out.println(digits);
    }

    /**
     * In this example we will use a regular expression a replace html heading elements we showed a similiar example
     *
     */
    @Test
    public void replace_heading_elements(){
        String htmlContent  = "<h2>Replace html heading</h2>";
        String h2Toh3 = htmlContent.replaceAll("<h2[^>]*>(.*?)</h2>","<h3>$1 - HTML replaced</h3>");
        System.out.println(h2Toh3);
    }


    @Test
    public void strip_trailing_spaces(){
        String removeSpace = "       spaces        ";
        String leftTrim = removeSpace.replaceAll("\\s+","");
        System.out.println("---" + leftTrim + "--");
    }

    @Test
    public void split_string_with_regex(){
        String[] stringSplit = Pattern.compile(" ").split("there is a dog");
        Stream.of(stringSplit).peek(System.out::println).count();
    }

    @Test
    public void strip_spaces(){
        String sampleString = "Remove space whitespace";
        String removeSpaces = sampleString.replaceAll("\\s", "");
        System.out.println(removeSpaces);
    }

    @Test
    public void validate_date_regex(){
        String date = "01-01-2016";
        String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
        System.out.println(date.matches(datePattern));
    }



}