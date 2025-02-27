package com.ctw.workstation.rack.entity;

import com.ctw.workstation.team.entity.Team;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public record RackResponseDTO(UUID id, String serialNumber, Status status, String defaultLocation, Timestamp assembledAt, Timestamp createdAt, Timestamp modifiedAt, Team team) {

    public RackResponseDTO(Rack rack) {
        this(rack.getId(), rack.getSerialNumber(), rack.getStatus(), rack.getDefaultLocation(), rack.getAssembledAt(), rack.getCreatedAt(), rack.getModifiedAt(), rack.getTeam());
    }

}
