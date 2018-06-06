package com.testcomp.testweb;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class AdvertiserController {  
  
    @RequestMapping(value = "/advertiser", method = RequestMethod.POST)  
    public Response createAdvertiser(@RequestBody @Valid AdvertiserParam advertiserParam) {  
        return new Response().success();
    }  
  
    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.GET)  
    public Response getAdvertiser(@PathVariable("id") String advertiserId) {  
    	return new Response().success();
    }  
}  