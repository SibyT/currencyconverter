package com.example.currconv.services;

import com.example.currconv.model.CurrConvertResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class RestService {


    public String callCurrencyExchanger(String base,String target)  {
        RestTemplate restTemplate = new RestTemplate();
        URI url = null;
        try {
            url = new URI("http://api.fixer.io/latest?base="+base);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<CurrConvertResp> response = restTemplate.getForEntity(
                url,
                CurrConvertResp.class);
        return response.getBody().getRates().get(target);
    }

}
