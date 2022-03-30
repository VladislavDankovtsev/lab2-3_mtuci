package ru.mtuci.bi.lab2_3.mapper;

import ru.mtuci.bi.lab2_3.dto.cb.CbDto;
import ru.mtuci.bi.lab2_3.dto.cb.CbOneValute;
import ru.mtuci.bi.lab2_3.dto.cb.CbValute;

import java.util.List;

public interface CbMapper {
    List<CbOneValute> getAll(CbDto cbDto);
}
