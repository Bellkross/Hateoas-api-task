package com.gl.procamp.hateoasapi.service;

import com.gl.procamp.hateoasapi.entity.User;
import com.gl.procamp.hateoasapi.util.UserResource;
import com.gl.procamp.hateoasapi.util.UserResourceAssembler;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private final Map<Integer, User> map = new HashMap<>();
    private final UserResourceAssembler assembler;

    public UserService() {
        fillMap();
        assembler = new UserResourceAssembler();
    }

    private void fillMap() {
        map.put(0, new User(0, "DefaultName0", User.Status.ENABLED));
        map.put(1, new User(1, "DefaultName1", User.Status.DISABLED));
    }

    public Collection<UserResource> getUsers() {
        return map.values()
                .stream()
                .map(assembler::toResource)
                .collect(toList());
    }

    public UserResource getUser(Integer id) {
        return assembler.toResource(map.get(id));
    }

    public UserResource changeStatus(Integer id) {
        User current = map.get(id);
        if (current.getStatus().equals(User.Status.ENABLED)) {
            current.setStatus(User.Status.DISABLED);
        }
        return assembler.toResource(current);
    }

}
