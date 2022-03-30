package ru.mtuci.bi.lab2_3.dto.cb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CbValute {
    @JsonProperty("AUD")
    private CbOneValute aud;
    @JsonProperty("GBP")
    private CbOneValute gbp;
    @JsonProperty("NOK")
    private CbOneValute nok;
    @JsonProperty("USD")
    private CbOneValute usd;
    @JsonProperty("EUR")
    private CbOneValute eur;

    public CbOneValute getAud() {
        return aud;
    }

    public void setAud(CbOneValute aud) {
        this.aud = aud;
    }

    public CbOneValute getGbp() {
        return gbp;
    }

    public void setGbp(CbOneValute gbp) {
        this.gbp = gbp;
    }

    public CbOneValute getNok() {
        return nok;
    }

    public void setNok(CbOneValute nok) {
        this.nok = nok;
    }

    public CbOneValute getUsd() {
        return usd;
    }

    public void setUsd(CbOneValute usd) {
        this.usd = usd;
    }

    public CbOneValute getEur() {
        return eur;
    }

    public void setEur(CbOneValute eur) {
        this.eur = eur;
    }
}
