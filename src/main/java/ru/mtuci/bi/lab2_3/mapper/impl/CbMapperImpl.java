package ru.mtuci.bi.lab2_3.mapper.impl;

import org.springframework.stereotype.Component;
import ru.mtuci.bi.lab2_3.dto.cb.CbDto;
import ru.mtuci.bi.lab2_3.dto.cb.CbOneValute;
import ru.mtuci.bi.lab2_3.dto.cb.CbValute;
import ru.mtuci.bi.lab2_3.mapper.CbMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class CbMapperImpl implements CbMapper {
    @Override
    public List<CbOneValute> getAll(CbDto cbDto) {
        CbValute valute = cbDto.getValute();
        List<CbOneValute> list = new ArrayList<>();
        list.add(valute.getAud());
        list.add(valute.getEur());
        list.add(valute.getGbp());
        list.add(valute.getNok());
        list.add(valute.getUsd());
        return list;
    }
}
