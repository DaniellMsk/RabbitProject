package com.danila.rabbit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class RabbitInput {
    private String name;
    private Integer age;
}
