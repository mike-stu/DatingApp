package com.mike.course.app.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotBlank(message = "Name is required")
    private String name;

    @Column
    @NotBlank(message = "Surname is required")
    private String surname;

    @Column
    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @Column
    @NotBlank(message = "Password is required")
    private String password;

    @Embedded
    private Address address;

    @Column
    @NotBlank(message = "Gender is required")
    private String gender;

    @Column
    @NotNull
    private LocalDate dateOfBirth;

    @Column
    private Integer likes;

    @Column
    private String bio;

    @Column
    private LocalDate dateOfRegister;
}
