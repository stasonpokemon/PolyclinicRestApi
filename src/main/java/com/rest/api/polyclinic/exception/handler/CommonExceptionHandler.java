package com.rest.api.polyclinic.exception.handler;

import com.rest.api.polyclinic.exception.NotFoundException;
import com.rest.api.polyclinic.exception.dto.ErrorTypeResponseDTO;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The CommonExceptionHandler class for handling exceptions.
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorTypeResponseDTO> notFoundExceptionHandler(
            NotFoundException notFoundException) {

        log.info("Caught NotFoundException: {}", notFoundException.getMessage());

        return new ResponseEntity<>(ErrorTypeResponseDTO.builder()
                .time(LocalDateTime.now())
                .message(notFoundException.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorTypeResponseDTO> methodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException methodArgumentNotValidException) {

        List<String> errors = methodArgumentNotValidException.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).toList();

        log.info("Caught MethodArgumentNotValidException: {}", errors);

        return new ResponseEntity<>(ErrorTypeResponseDTO.builder()
                .time(LocalDateTime.now())
                .message(errors).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorTypeResponseDTO> propertyReferenceExceptionHandler(
            PropertyReferenceException propertyReferenceException) {

        log.info("Caught PropertyReferenceException: {}", propertyReferenceException.getMessage());

        return new ResponseEntity<>(ErrorTypeResponseDTO.builder()
                .time(LocalDateTime.now())
                .message(propertyReferenceException.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorTypeResponseDTO> handleValidationException(HttpMessageNotReadableException httpMessageNotReadableException) {

                 log.info("Caught PropertyReferenceException: {}", httpMessageNotReadableException.getMessage());


        return new ResponseEntity<>(ErrorTypeResponseDTO.builder()
                .time(LocalDateTime.now())
                .message(httpMessageNotReadableException.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}


