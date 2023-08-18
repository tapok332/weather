package com.example.weather.utils.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class ErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1905122041950251207L;
    private final List<ErrorDetails> errorDetails;

    public static ErrorResponse of(ErrorDetails errorDetails) {
        return new ErrorResponse(List.of(errorDetails));
    }

    public static ErrorResponse of(List<ErrorDetails> errorDetails) {
        return new ErrorResponse(errorDetails);
    }
}
