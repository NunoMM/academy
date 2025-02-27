package com.ctw.workstation.team.entity;

import com.ctw.workstation.rack.entity.Rack;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public record TeamResponseDTO(UUID id, String name, String product, Timestamp createdAt, Timestamp modifiedAt, String defaultLocation, List<Rack> racks) {
    public TeamResponseDTO(Team team) {
        this(team.getId(), team.getName(), team.getProduct(), team.getCreatedAt(), team.getModifiedAt(), team.getDefaultLocation(), team.getRacks());
    }
}
