package com.bootcamp.perolas.perolas.exeception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private String title;
    private LocalDateTime timestamp;
}
