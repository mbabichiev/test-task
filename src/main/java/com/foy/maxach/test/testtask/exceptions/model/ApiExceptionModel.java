package com.foy.maxach.test.testtask.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiExceptionModel {
    private String message;
    private LocalDateTime time;
    private String url;
}
