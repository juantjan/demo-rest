package com.example.demorest.controller.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Juan on 19/10/20.
 */
@Data
@NoArgsConstructor
@Builder
public class BaseSingleResponse<T> extends BaseResponse  {

    private T value;

    public BaseSingleResponse (String errorMessage, Integer errorCode, boolean success, T value) {
        super(errorMessage, errorCode, success);
        this.value = value;
    }

    public BaseSingleResponse(T value) {
        super((String)null, (Integer)null, true);
        this.value = value;
    }
}
