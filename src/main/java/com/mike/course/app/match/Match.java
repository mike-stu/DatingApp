package com.mike.course.app.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Match {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long fromUserId;

    @Column
    private Long toUserId;

    @Column
    private Long likeRate;

}
