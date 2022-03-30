package ru.mtuci.bi.lab2_3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.bi.lab2_3.dto.*;
import ru.mtuci.bi.lab2_3.dto.cb.CbDto;
import ru.mtuci.bi.lab2_3.dto.cb.CbOneValute;
import ru.mtuci.bi.lab2_3.dto.cb.CbValute;
import ru.mtuci.bi.lab2_3.exception.ClientArgumentException;
import ru.mtuci.bi.lab2_3.mapper.CbMapper;
import ru.mtuci.bi.lab2_3.service.CBService;
import ru.mtuci.bi.lab2_3.service.CurrencyProcessingService;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyProcessingServiceImpl implements CurrencyProcessingService {

    private final NumberFormat formatter = new DecimalFormat("#0.00");

    @Autowired
    private CBService cbService;
    @Autowired
    private CbMapper mapper;

    @Override
    public List<CurrencyCodeResponseDto> listCurrencyCode() {
        CbDto cbDto = cbService.getData();
        List<CbOneValute> list = mapper.getAll(cbDto);
        List<CurrencyCodeResponseDto> responseList = new ArrayList<>();
        for (CbOneValute cbOneValute : list) {
            CurrencyCodeResponseDto responseDto = new CurrencyCodeResponseDto();
            responseDto.setName(cbOneValute.getName());
            responseDto.setCode(cbOneValute.getCharCode());
            responseList.add(responseDto);
        }
        return responseList;
    }

    @Override
    public CurrencyRUBResponseDto getCurrencyRUB(String code) {
        CbDto cbDto = cbService.getData();
        List<CbOneValute> list = mapper.getAll(cbDto);
        CurrencyRUBResponseDto responseDto = new CurrencyRUBResponseDto();
        for (CbOneValute obj : list) {
            if (code.equals(obj.getCharCode())) {
                responseDto.setCode(obj.getCharCode());
                responseDto.setName(obj.getName());
                responseDto.setNominal(obj.getNominal());
                responseDto.setValue(obj.getValue());
                return responseDto;
            }
        }
        throw new ClientArgumentException("По заданному коду валюты ничего не найдено");
    }

    @Override
    public CurrencyConversionResponseDto getCurrencyConversion(String code, double value) {
        CbDto cbDto = cbService.getData();
        List<CbOneValute> list = mapper.getAll(cbDto);
        CurrencyConversionResponseDto responseDto = new CurrencyConversionResponseDto();
        for (CbOneValute obj : list) {
            if (code.equals(obj.getCharCode())) {
                double result  = value * obj.getNominal()/(obj.getValue());
                responseDto.setCode(obj.getCharCode());
                responseDto.setName(obj.getName());
                responseDto.setValue(Double.parseDouble(formatter.format(result).replace(",",".")));
                return responseDto;
            }
        }
        throw new ClientArgumentException("По '"+code+"' коду валюты ничего не найдено");
    }

    @Override
    public CurrencyValueResponseDto CurrencyValue(CurrencyValueRequestDto requestDto) {

        CbDto cbDto = cbService.getData();
        List<CbOneValute> list = mapper.getAll(cbDto);
        CbOneValute oneValuteIn = new CbOneValute();
        CbOneValute oneValuteOut = new CbOneValute();
        for (CbOneValute obj : list) {
            if (requestDto.getCodeIn().equals(obj.getCharCode())) {
                oneValuteIn = obj;
            }
            if (requestDto.getCodeOut().equals(obj.getCharCode())) {
                oneValuteOut = obj;
            }
        }

        double result = 0.0123;
        CurrencyValueResponseDto responseDto = new CurrencyValueResponseDto();
        responseDto.setCodeIn(requestDto.getCodeIn());
        responseDto.setCodeOut(requestDto.getCodeOut());
        responseDto.setValueIn(requestDto.getValue());
        responseDto.setValueOut(Double.parseDouble(formatter.format(result).replace(",",".")));
        return responseDto;

    }

}
