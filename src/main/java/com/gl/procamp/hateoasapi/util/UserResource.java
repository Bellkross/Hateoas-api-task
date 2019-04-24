package com.gl.procamp.hateoasapi.util;

import com.gl.procamp.hateoasapi.entity.User;
import lombok.*;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserResource extends ResourceSupport {

    private Integer userId;
    private String name;
    private User.Status status;

    public enum Status {ENABLED, DISABLED}

}
