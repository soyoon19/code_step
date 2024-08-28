package com.example.code_step.core;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommonResult {
    public static final int ERROR = 1;

    private int code;
    private String message;
    private boolean success = true;
}
