package com.mike.course.app.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageDto {

    @NotNull
    private Long fromUserId;

    @NotNull
    private Long toUserId;

    @NotBlank
    private String messageContent;
}
