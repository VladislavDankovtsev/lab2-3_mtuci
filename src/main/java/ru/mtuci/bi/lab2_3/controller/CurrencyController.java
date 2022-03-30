package ru.mtuci.bi.lab2_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.bi.lab2_3.dto.*;
import ru.mtuci.bi.lab2_3.exception.ClientArgumentException;
import ru.mtuci.bi.lab2_3.service.CurrencyProcessingService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyProcessingService service;

    @GetMapping("/codes")
    public List<CurrencyCodeResponseDto> getListCodes(){
        return service.listCurrencyCode();
    }

    @GetMapping("/RUB/{code}")
    public CurrencyRUBResponseDto getCurrencyRUB(@PathVariable("code") String code){
        return service.getCurrencyRUB(code);
    }

    @GetMapping("/conversion")
    public CurrencyConversionResponseDto getCurrencyConversion(@RequestParam("code") String code, @RequestParam("value") double value){
        return service.getCurrencyConversion(code, value);
    }

    @PostMapping("/conversion")
    public ResponseEntity<CurrencyValueResponseDto> CurrencyValue(@RequestBody CurrencyValueRequestDto requestDto) throws Exception {
        return ResponseEntity.ok(service.CurrencyValue(requestDto));
    }

}
