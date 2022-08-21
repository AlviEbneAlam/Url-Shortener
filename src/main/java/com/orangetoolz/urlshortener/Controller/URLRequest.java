package com.orangetoolz.urlshortener.Controller;

import antlr.ASTFactory;
import com.orangetoolz.urlshortener.Model.Url;
import com.orangetoolz.urlshortener.Service.UrlEncodeAndDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/url-shortener")
public class URLRequest {


    private UrlEncodeAndDecode urlEncodeAndDecode;

    @Autowired
    public URLRequest(UrlEncodeAndDecode urlEncodeAndDecode){
        this.urlEncodeAndDecode=urlEncodeAndDecode;
    }

    @PostMapping("/getShortUrl")
    public String getShortUrl(@RequestBody Url url){
        return urlEncodeAndDecode.encodeLongUrl(url.getUrl());
    }



    @PostMapping("/getLongUrl")
    public String  getLongUrl(@RequestBody Url url){
        /*return new ModelAndView("redirect:" +  urlEncodeAndDecode.decodeLongUrl(url.getUrl()));*/
        return urlEncodeAndDecode.decodeLongUrl(url.getUrl());

    }



    @GetMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }







}
