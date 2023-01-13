package com.sparta.springcrud0.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseDto<D> {
    //private HttpMethod httpMethod;
    //private HttpStatus httpStatus;
    private final String resultCode;
    private final String message;
    private final D data;
}
