package com.example.demorest.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Juan on 19/10/20.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpsertProductRequest {
    private String id;
    private String name;
    private double price;
}
