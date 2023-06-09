package com.naveen.firstApp;

import org.json.JSONObject;
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
        public String getCurrentWeather(){     
       try {
HttpResponse<JsonNode> response = Unirest.get("https://api.open-meteo.com/v1/forecast")
                      .queryString("daily","temperature_2m_max,temperature_2m_min,sunrise,sunset")
                      .queryString("longitude",83.22)
                      .queryString("latitude",17.72)
                      .queryString("current_weather",true)
                      .queryString("forecast_days",1)
                      .queryString("timezone","auto")
                      .header("content-type","application/json")
                      .asJson();
                      System.out.println("response  1"+response.getBody());
                      System.out.println("----------------------");
                        System.out.println("response  3"+response.getBody().getObject());

                    String myobj = response.getBody().toString();
                     return myobj;
              
                   //System.out.println("sss"+myobj);
    } catch (UnirestException e) {
        e.printStackTrace();
    }
   return "success";
       
        
    }
}

