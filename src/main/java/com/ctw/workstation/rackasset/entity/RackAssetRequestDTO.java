package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public record RackAssetRequestDTO(UUID id, String name, String product, Timestamp createdAt, Timestamp modifiedAt, String defaultLocation, List<Rack> racks) {
    public RackAssetRequestDTO(Team team) {
        this(team.getId(), team.getName(), team.getProduct(), team.getCreatedAt(), team.getModifiedAt(), team.getDefaultLocation(), team.getRacks());
    }
}
