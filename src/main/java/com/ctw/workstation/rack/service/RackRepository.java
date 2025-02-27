package com.ctw.workstation.rack.service;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class RackRepository implements PanacheRepository<Rack> {

    public Rack findById(UUID id) {
        return find("id", id).firstResult();
    }

    public Rack findByName(String name) {
        return find("name", name).firstResult();
    }

}
