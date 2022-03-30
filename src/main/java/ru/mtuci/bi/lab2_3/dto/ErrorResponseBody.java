package ru.mtuci.bi.lab2_3.dto;

public class ErrorResponseBody {

    private String errorCode;
    private String errorMessage;

    public ErrorResponseBody(int errorCode, String errorMessage) {
        this.errorCode = String.valueOf(errorCode);
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
