package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

@RestController
public class AreaCodeController {
    @GetMapping("/area-code")
    public String getJson() {
        HashMap<String, Object> result = new HashMap<>();
        String jsonInString = "";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(
                "https://apis.data.go.kr/B551011/KorService1/areaCode1?MobileOS=WIN&MobileApp=WinApp&_type=json&serviceKey=LPhPo3MNpGaHtvgCQhDznSNi+JbhWeTb8Sgx21UlYWvZwaNnN2xZdvi7DtZ0dd2OdkFDsx9gHBT47W63hbyiRQ==")
                .build();
        System.out.println("uri 연결 성공");
        ResponseEntity<?> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);

        result.put("statusCode", resultMap.getStatusCode());
        result.put("header", resultMap.getHeaders());
        result.put("body", resultMap.getBody());

        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonInString = mapper.writeValueAsString(resultMap.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
}