package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@ResponseBody
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//    }

    //lives at /hello/goodbye

//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring";
//    }

    //lives at /hello/hello
    //Handles requests of the form/hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    //Handles requests in the form of /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    //lives at /hello/form
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='result' method='post'>" +
                            "<input type='text' name='name'>" +
                            "<select name='language'>" +
                                "<option value=''>--Select a language--</option>" +
                                "<option value='english'>English</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='german'>German</option>" +
                                "<option value='elvish'>Elvish</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="result")
    public String createMessage (@RequestParam String name, @RequestParam String language){
        String translateHello = "";

        if (Objects.equals(language, "english")) {
            translateHello = "Hello"; }
        if (Objects.equals(language, "spanish")) {
            translateHello = "Hola";}
        if (Objects.equals(language, "french")) {
            translateHello = "Bonjour";}
        if (Objects.equals(language, "german")) {
            translateHello = "Hallo";}
        if (Objects.equals(language, "elvish")) {
            translateHello = "Aiya";
        }

        return translateHello + ", " + name + "!";
    }

}
