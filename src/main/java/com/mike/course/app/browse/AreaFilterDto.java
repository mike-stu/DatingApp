package com.mike.course.app.browse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AreaFilterDto {
    private Long id;

    private String country;

    private String state;

    private String city;

    private String gender;
}
