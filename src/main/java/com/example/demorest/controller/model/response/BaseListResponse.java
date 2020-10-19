package com.example.demorest.controller.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 19/10/20.
 */
@Data
@NoArgsConstructor
@Builder
public class BaseListResponse <T> extends BaseResponse{
    private List<T> content = new ArrayList();
    public BaseListResponse (String errorMessage, Integer errorCode, boolean success, List<T> content) {
        super(errorMessage, errorCode, success);
        this.content = content;
    }
    public BaseListResponse(List<T> content) {
        super((String)null, (Integer)null, true);
        this.content = content;
    }
}
