package com.ctw.workstation.rack.entity;

import com.ctw.workstation.CommonData;
import com.ctw.workstation.team.entity.Team;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Collate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "t_rack")
public class Rack {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "serial_number", length = 20, nullable = false)
    @NotNull
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @NotNull
    public Status status;

    @Column(name = "default_location", length = 20, nullable = false)
    @NotNull
    private String defaultLocation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "assembled_at")
    public Timestamp assembledAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    @NotNull
    public Timestamp createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = false)
    @NotNull
    public Timestamp modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false, insertable = false)
    public Team team;

    public Rack(String serialNumber, Status status, String defaultLocation) {
        this.serialNumber = serialNumber;
        this.status = status;
        this.defaultLocation = defaultLocation;
    }

    public Rack() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public Timestamp getAssembledAt() {
        return assembledAt;
    }

    public void setAssembledAt(Timestamp assembledAt) {
        this.assembledAt = assembledAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    /*

    private String name;
    private Status status;
    private String teamId;


    public enum Status {ACTIVE, INACTIVE}

    private Rack(String name, Status status, String teamId) {
        super(name);
        this.id = super.getId();
        this.serialNumber = UUID.randomUUID().toString();
        this.status = status;
        this.teamId = teamId;
    }

    public void setName(String name) { this.name = name; }

    public String getSerialNumber() { return serialNumber; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getTeamId() { return teamId; }
    public void setTeamId(String teamId) { this.teamId = teamId; }

    public static class RackBuilder {

        private String id;
        private String serialNumber;
        private String name;
        private Status status;
        private String teamId;

        public RackBuilder(String name, String serialNumber, Status status, String teamId) {
            this.id = id;
            this.name = name;
            this.serialNumber = serialNumber;
            this.status = status;
            this.teamId = teamId;
        }

        public Rack build() {
            return new Rack(name, status, teamId);
        }

    }
    */

}