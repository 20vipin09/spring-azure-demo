package com.example.springrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MyController {
  
  /*
   * @RequestMapping("/home") public String home() {
   * System.out.println("This is home redirecting to  office!"); return
   * "redirect:/office"; }
   * 
   * @RequestMapping("/office") public String office() {
   * System.out.println("This is office!"); return "redirect:/fun"; }
   * 
   * @RequestMapping("/fun") public String fun() { System.out.println("Have fun");
   * return "redirect:/fun1"; }
   * 
   * @RequestMapping("/fun1") public String fun1() {
   * System.out.println("This is fun1!"); return "redirect:/fun2"; }
   */
  //If you will add "/foo" in your localhost address it will be automatically
  //redirected to fun2 and returns Having FUn 2 as a response,
  
  @RequestMapping("/foo")  
  void handleFoo(HttpServletResponse response) throws IOException {
    response.sendRedirect("/faa");
  }
  
  @RequestMapping("/faa")
  void handleFaa(HttpServletResponse response) throws IOException {
    response.sendRedirect("/baa");
  }
  
  @RequestMapping("/baa")
  void handleBaa(HttpServletResponse response) throws IOException {
    response.sendRedirect("/fun2");
  }
  
  @GetMapping("/fun2")
  public String fun2() {
    System.out.println("This is fun2!");
    return "Having FUn 2";
  }

  @GetMapping("/test-async")
  public Callable<String> getFoobar() {
     return () -> {
        Thread.sleep(121000); //this will cause a timeout
        return "foobar";
     };
  }
  
  @PostMapping("/post")
  public  String postfoo() {
    {
       return "post successful";
    }
 }
}
