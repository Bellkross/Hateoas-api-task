package com.gl.procamp.hateoasapi.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private Integer userId;
    private String name;
    private Status status;

    public enum Status {ENABLED, DISABLED}

}
