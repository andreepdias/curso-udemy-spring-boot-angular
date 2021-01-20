package com.andredias.udemy.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {

    @NotEmpty(message = "{field.description.required}")
    private String description;

    @NotEmpty(message = "{field.price.required}")
    private String price;

    @NotEmpty(message = "{field.date.required}")
    private String date;

    @NotNull(message = "{field.clientId.required}")
    private Integer clientId;

}
