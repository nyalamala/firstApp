package com.naveen.firstApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class CentralController {
  
    @GetMapping("/health")
    @ResponseBody
    public String getHealth(){
       return "Running ...";
    }

    @GetMapping("/weather")
    
    // public String getCurrentWeather(@PathVariable String city){
        public String getCurrentWeather(){
            String apiKey = "ea33b3e2f2fb72596550b7a4f6aab312";
        // System.out.println("city  "+city);
       try {
        HttpResponse<JsonNode> response = Unirest.get("https://api.openweathermap.org/data/2.5/weather")
                      .queryString("APPID","f27df3b631c823620a00109d89cea18e")
                      .queryString("lon",10.99)
                      .queryString("lat",44.34)
                      .header("content-type","application/json")
                      .asJson();
                       

                    
                      System.out.println("response  "+response.getBody());
    
                     
    } catch (UnirestException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        return "response.getBody()";  
    }
}

