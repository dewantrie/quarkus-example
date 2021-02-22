package com.cluncur.presentation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import com.cluncur.domain.dto.CreateUserDTO;
import com.cluncur.domain.models.User;
import com.cluncur.services.UserService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    
    @Inject
    UserService userService;

    @POST
    public User save(@RequestBody CreateUserDTO user) {
        return userService.save(user);
    }
}
