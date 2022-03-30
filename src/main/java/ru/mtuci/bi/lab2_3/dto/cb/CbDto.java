package ru.mtuci.bi.lab2_3.dto.cb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CbDto {
    @JsonProperty("Date")
    private ZonedDateTime date;
    @JsonProperty("PreviousDate")
    private ZonedDateTime previousDate;
    @JsonProperty("PreviousURL")
    private String previousURL;
    @JsonProperty("Timestamp")
    private ZonedDateTime timestamp;
    @JsonProperty("Valute")
    private CbValute valute;

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public ZonedDateTime getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(ZonedDateTime previousDate) {
        this.previousDate = previousDate;
    }

    public String getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public CbValute getValute() {
        return valute;
    }

    public void setValute(CbValute valute) {
        this.valute = valute;
    }
}
