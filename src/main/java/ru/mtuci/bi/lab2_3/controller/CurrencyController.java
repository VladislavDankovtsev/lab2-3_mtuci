package ru.mtuci.bi.lab2_3.controller;

import org.springframework.web.bind.annotation.*;
import ru.mtuci.bi.lab2_3.dto.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @GetMapping("/codes")
    public List<CurrencyCodeResponseDto> getListCodes(){
        CurrencyCodeResponseDto currencyCodeResponseDto = new CurrencyCodeResponseDto();
        currencyCodeResponseDto.setCode("USD");
        currencyCodeResponseDto.setName("Доллар США");
        CurrencyCodeResponseDto currencyCodeResponseDto2 = new CurrencyCodeResponseDto();
        currencyCodeResponseDto2.setCode("EUR");
        currencyCodeResponseDto2.setName("Евро");
        List<CurrencyCodeResponseDto> codeResponseDtoList = new ArrayList<>();
        codeResponseDtoList.add(currencyCodeResponseDto);
        codeResponseDtoList.add(currencyCodeResponseDto2);
        return codeResponseDtoList;
    }

    @GetMapping("/RUB/{code}")
    public CurrencyRUBResponseDto getCurrencyRUB(@PathVariable("code") String code){
        if(code.equals("INR")) {
            CurrencyRUBResponseDto currencyRUBResponseDto = new CurrencyRUBResponseDto();
            currencyRUBResponseDto.setCode("INR");
            currencyRUBResponseDto.setName("Индийских рупий");
            currencyRUBResponseDto.setNominal(10);
            currencyRUBResponseDto.setValue(15.2964);
            return currencyRUBResponseDto;
        }
        return null;
    }

    @GetMapping("/conversion")
    public CurrencyConversionResponseDto getCurrencyConversion(@RequestParam("code") String code, @RequestParam("value") double value){
        CurrencyConversionResponseDto currencyConversionResponseDto = new CurrencyConversionResponseDto();
        if(code.equals("USD")){
            currencyConversionResponseDto.setCode("USD");
            currencyConversionResponseDto.setName("Доллар США");
            currencyConversionResponseDto.setValue(8.57);
        }
        return currencyConversionResponseDto;
    }

    @PostMapping("/conversion")
    public CurrencyValueResponseDto simplePost2(@RequestBody CurrencyValueRequestDto requestDto){
        CurrencyValueResponseDto responseDto = new CurrencyValueResponseDto();
        responseDto.setCodeIn(requestDto.getCodeIn());
        responseDto.setCodeOut(requestDto.getCodeOut());
        responseDto.setValueIn(requestDto.getValue());
        if(requestDto.getCodeIn().equals("USD")&&requestDto.getCodeOut().equals("EUR")){
            responseDto.setValueOut(requestDto.getValue()*0.9138);
        }
        return responseDto;
    }

}
