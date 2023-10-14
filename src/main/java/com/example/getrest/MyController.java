package com.example.getrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping(value = "/getdata",produces = "application/json")
    public List<MyMode> getData(){
        MyMode.Schema schema=new MyMode.Schema();
        schema.setCustom("customval");
        schema.setType("typeVal");
        schema.setCustomId("customIdVal");

        MyMode myMode=new MyMode("testId","customfield_10072","testNameVal","Source system",true,true,true,true, Arrays.asList("val1","val2","val3"),schema);
        MyMode myMode2=new MyMode("testId","testKeyval","testNameVal","untranslatedNameVal",true,true,true,true, Arrays.asList("val1","val2","val3"),schema);
        MyMode myMode3=new MyMode("testId","testKeyval","testNameVal","untranslatedNameVal",true,true,true,true, Arrays.asList("val1","val2","val3"),schema);

        return Arrays.asList(myMode,myMode2,myMode3);

    }
    @GetMapping(value = "/executedata",produces = "application/json")
    public String getexecutedata(){
        ParameterizedTypeReference<List<MyMode>> typeRef = new ParameterizedTypeReference<List<MyMode>>() {
        };
        ResponseEntity<List<MyMode>> responseEntity = restTemplate.exchange("http://localhost:8099/getdata", HttpMethod.GET, null, typeRef);
        List<MyMode> myModelClasses = responseEntity.getBody();
        HashMap<String,String> mmap=new HashMap<>();
        mmap.put(getCustomDataFor(myModelClasses,"Source system"),"souecesystemVal");
        mmap.put(getCustomDataFor(myModelClasses,"untranslatedNameVal"),"testtttt");
        System.out.println(mmap);
//        ResponseEntity<List<MyMode>> responseEntity3 = restTemplate.exchange(, HttpMethod.POST, null, typeRef);
        ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8099/actualservice", mmap, String.class );

        return response.getBody();
    }
    @PostMapping(value = "/actualservice",consumes = "application/json")
    public String getactuals(@RequestBody ActualModel actualModel){
        return actualModel.getCustomfield_10072();
    }



        private String getCustomDataFor(List<MyMode> myModelClasses, String source_system) {
        return myModelClasses
                .stream()
                .filter(myMode -> myMode.getUntranslatedName().equalsIgnoreCase(source_system))
                .findFirst().get().getKey();
    }
}
