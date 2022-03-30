package ru.mtuci.bi.lab2_3.service;

import ru.mtuci.bi.lab2_3.dto.*;

import java.util.List;

public interface CurrencyProcessingService {

    List<CurrencyCodeResponseDto> listCurrencyCode();
    CurrencyRUBResponseDto getCurrencyRUB(String code);
    CurrencyConversionResponseDto getCurrencyConversion(String code,double value);
    CurrencyValueResponseDto CurrencyValue(CurrencyValueRequestDto requestDto);

}
