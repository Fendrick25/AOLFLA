package com.fla.aol.inventorysystem.product.exception;

import com.fla.aol.inventorysystem.common.api.ApiError;
import com.fla.aol.inventorysystem.common.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ProductException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception){
        List<String> details = new ArrayList<>();
        details.add(exception.getMessage());

        ApiError err = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND)
                .message("Data not found")
                .errors(details)
                .build();

        return new ResponseEntity<>(err, err.getStatus());
    }
}
