package com.mike.course.app.hobby;

import com.mike.course.app.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Hobby {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long userId;

    @Column
    private String name;
}
