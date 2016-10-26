package com.guitar.handler;

import com.guitar.model.Manufacturer;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 * Created by sorinaccio on 10/26/2016.
 */
@Component
@RepositoryEventHandler(Manufacturer.class)
public class ManufacturerEventHandler {

    @HandleBeforeCreate
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void handleBeforeCreate(Manufacturer m) {


        if(!m.getActive()) {
            throw new IllegalArgumentException("New manufacturers must be active");
        }
    }
}
