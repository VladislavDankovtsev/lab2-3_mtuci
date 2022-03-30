package ru.mtuci.bi.lab2_3.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.mtuci.bi.lab2_3.dto.ErrorResponseBody;
import ru.mtuci.bi.lab2_3.exception.ClientArgumentException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@EnableWebMvc
public class ControllerExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(ClientArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity handleValidationException(ClientArgumentException e) {
        logger.error("ClientArgumentException: {}",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponseBody(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity handleException(Exception e) {
        logger.error("Exception {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));

    }

}
