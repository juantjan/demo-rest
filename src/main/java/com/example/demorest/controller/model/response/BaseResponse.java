package com.example.demorest.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Juan on 19/10/20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private String errorMessage;
    private Integer errorCode;
    private boolean success;
}
