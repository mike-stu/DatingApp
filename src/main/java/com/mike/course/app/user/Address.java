package com.mike.course.app.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address {

    @Column
    @NotBlank(message = "Country is required")
    private String country;

    @Column
    @NotBlank(message = "State is required")
    private String state;

    @Column
    @NotBlank(message = "City is required")
    private String city;
}
