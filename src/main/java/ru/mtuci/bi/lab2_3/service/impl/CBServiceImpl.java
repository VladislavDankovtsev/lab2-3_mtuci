package ru.mtuci.bi.lab2_3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.mtuci.bi.lab2_3.dto.cb.CbDto;
import ru.mtuci.bi.lab2_3.service.CBService;

@Service
public class CBServiceImpl implements CBService {

    private static final String URL_CB = "https://www.cbr-xml-daily.ru/daily_json.js";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CbDto getData() {
        ResponseEntity<CbDto> responseEntity = restTemplate
                .exchange(URL_CB, HttpMethod.GET, null, CbDto.class);
        return responseEntity.getBody();
    }
}
