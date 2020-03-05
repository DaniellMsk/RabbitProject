package com.danila.rabbit.model;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Rabbit {
    private Integer id;
    private String name;
    private Integer age;
}
