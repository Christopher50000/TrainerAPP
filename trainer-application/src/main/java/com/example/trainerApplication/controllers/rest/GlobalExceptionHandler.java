package com.example.trainerApplication.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Slf4j

//request acts as the request that was sent
// Also consider using logs here instead of printing statements
/**
 * This class handles global exceptions across the api service calls
 */
public class GlobalExceptionHandler{

    ObjectMapper objectMapper = new ObjectMapper();


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        urlExceptionOutput(request);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) throws JsonProcessingException {
        urlExceptionOutput(request);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> handleEntityAlreadyExists(EntityExistsException ex, WebRequest request) throws JsonProcessingException {
        urlExceptionOutput(request);
        log.debug("The Entity already Exists for {}",objectMapper.writeValueAsString(request.getParameterMap()));
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleNullException(MethodArgumentTypeMismatchException ex,WebRequest request) throws JsonProcessingException {
        urlExceptionOutput(request);
        String errorMessage = String.format("Invalid type for parameter '%s': expected '%s' but received '%s'",
                ex.getName(), ex.getRequiredType().getSimpleName(), ex.getValue());
        log.debug(errorMessage);
        log.debug("MethodArgumentTypeMismatchException exception for {}",objectMapper.writeValueAsString(request.getParameterMap()));
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }




    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullException(NullPointerException ex,WebRequest request) throws JsonProcessingException {
        urlExceptionOutput(request);
        log.debug("Null exception for {}",objectMapper.writeValueAsString(request.getParameterMap()));
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) throws JsonProcessingException {
        urlExceptionOutput(request);
        log.debug("Uncaught Exception has occurred for {}",objectMapper.writeValueAsString(request.getParameterMap()));
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<String> handleJsonException(JsonProcessingException ex, WebRequest request)
    {   urlExceptionOutput(request);
        log.debug("Json Processing exception");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public void urlExceptionOutput( WebRequest request)
    {
        //Since WebRequest is an interface and ServletWebRequest is a type of webrequest we can grab the urls , also need a way to grab the values
        HttpServletRequest httpRequest= ((ServletWebRequest) request).getRequest();
        System.out.println(httpRequest);
        log.debug("Error occurred in request: {}",httpRequest.getRequestURI());
    }


}
