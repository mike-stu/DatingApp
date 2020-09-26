package com.mike.course.app.hobby;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HobbyDto {

    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    private String name;
}
