package com.example.newsarticle.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NesArticil {
    @NotNull(message = "must be not null")
    private int id;
    @NotNull(message = "must be not null")
    @Size(max=100,message = "maximum value is 100")
    private String title;
    @NotNull(message = "must be not null")
    @Size(min=3 , max = 20,message = " must be minmum vakue is 3 and max is 20")
    private String auther;
    @NotNull(message = "must be not null")
    @Size(max=200 ,message = "must be lese then 200")
    private String content;
    @NotNull(message = "must be not null")
    @Pattern(regexp ="^(politics|sports|coordinator|technology)$")
    private String catogary;
    @NotNull(message = "must be not null")
    private String  imageUrl;
    private boolean isPublished;
    private LocalDate  publishDate;


}
