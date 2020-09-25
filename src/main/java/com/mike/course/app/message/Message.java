package com.mike.course.app.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long fromUserId;

    @Column
    private Long toUserId;

    @Column
    private String messageContent;

    @Column
    private Boolean messageSeen;

    @Column
    private LocalDateTime dateSent;
}
