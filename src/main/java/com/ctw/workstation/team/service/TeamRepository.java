package com.ctw.workstation.team.service;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class TeamRepository implements PanacheRepository<Team> {

    public Team findById(UUID id) {
        return find("id", id).firstResult();
    }

    public Team findByName(String name) {
        return find("name", name).firstResult();
    }

}
