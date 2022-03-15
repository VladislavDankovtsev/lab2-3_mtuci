package ru.mtuci.bi.lab2_3.controller;

import org.springframework.web.bind.annotation.*;
import ru.mtuci.bi.lab2_3.dto.Person;

import java.util.logging.Logger;

@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = Logger.getLogger(TestController.class.getName());

    @GetMapping("")
    public String simpleGet(){
        return "Hello, this is Get-request";
    }

    @GetMapping("/simple")
    public String simpleGet2(){
        return "Hi, this is Get-request";
    }

    @GetMapping("/pathParam/{name}")
    public String getUsePathParam(@PathVariable("name") String name){
        return "Hello, "+name;
    }

    @GetMapping("/query")
    public String getUseQueryParam(@RequestParam("age") Integer age){
        return "Hello, "+age;
    }

    @PostMapping("")
    public Person simplePost(){
        Person  person = new Person();
        return person;
    }

    @PostMapping("/post")
    public Person simplePost2(@RequestBody Person person){
        logger.info(person.getName());
        logger.warning(person.getEmail());
        person.setAge(1000);
        return person;
    }

}
