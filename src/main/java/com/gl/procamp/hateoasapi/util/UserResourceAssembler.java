package com.gl.procamp.hateoasapi.util;

import com.gl.procamp.hateoasapi.entity.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

    private final String GET_USER_BY_ID_REQUEST = "http://localhost:8080/users/%s";
    private final String CHANGE_USER_STATE_REQUEST = "http://localhost:8080/users/%s/changeState";

    public UserResourceAssembler() {
        super(User.class, UserResource.class);
    }

    @Override
    public UserResource toResource(final User user) {
        UserResource resource = new UserResource(
                user.getUserId(),
                user.getName(),
                user.getStatus()
        );
        resource.add(new Link(String.format(GET_USER_BY_ID_REQUEST, user.getUserId()), Link.REL_SELF));
        if (!user.getStatus().equals(User.Status.DISABLED)) {
            resource.add(new Link(String.format(CHANGE_USER_STATE_REQUEST, user.getUserId()), Link.REL_SELF));
        }
        return resource;
    }

}
