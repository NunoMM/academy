package com.ctw.workstation.booking.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "t_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "rack_id", nullable = false)
    public UUID rackId;

    @Column(name = "requester_id", nullable = false)
    public UUID requesterId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_from", nullable = false)
    public Timestamp bookFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_to", nullable = false)
    public Timestamp bookTo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    public Timestamp createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = false)
    public Timestamp modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    public Rack rack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", updatable = false, insertable = false, nullable = false)
    public TeamMember teamMember;

    public Booking(Timestamp bookFrom, Timestamp bookTo, Rack rack, TeamMember teamMember) {
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.rack = rack;
        this.teamMember = teamMember;
    }

    public Booking() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public Timestamp getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(Timestamp bookFrom) {
        this.bookFrom = bookFrom;
    }

    public Timestamp getBookTo() {
        return bookTo;
    }

    public void setBookTo(Timestamp bookTo) {
        this.bookTo = bookTo;
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

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    /*

    private String id;
    private String name;
    private LocalDateTime from;
    private LocalDateTime to;
    private String teamId;
    private String rackId;

    private Booking(String name, String teamId, String rackId, LocalDateTime from, LocalDateTime to){

        super(name);
        this.id = id;
        this.name = name;
        this.teamId = teamId;
        this.rackId = rackId;
        this.from = from;
        this.to = to;

    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getRackId() {
        return rackId;
    }

    public static class BookingBuilder {

        private String id;
        private String name;
        private LocalDateTime from;
        private LocalDateTime to;
        private String teamId;
        private String rackId;

        public BookingBuilder (String name, String teamId, String rackId, LocalDateTime from, LocalDateTime to) {
            this.id = id;
            this.name = name;
            this.teamId = teamId;
            this.rackId = rackId;
            this.from = from;
            this.to = to;
        }

        public BookingBuilder setFrom(LocalDateTime from) {
            this.from = from;
            return this;
        }

        public BookingBuilder setTo(LocalDateTime to) {
            this.to = to;
            return this;
        }

        public BookingBuilder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public BookingBuilder setRackId(String rackId) {
            this.rackId = rackId;
            return this;
        }

        public Booking build() {
            return new Booking(name, teamId, rackId, from, to);
        }

    }

     */
}
