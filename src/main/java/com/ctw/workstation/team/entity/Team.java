package com.ctw.workstation.team.entity;

import com.ctw.workstation.rack.entity.Rack;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "t_team")
public class Team {

    //@Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 20, nullable = false)
    @NotNull
    private String name;

    @Column(name = "product", length = 20, nullable = false)
    @NotNull
    private String product;

    //@Schema(hidden = true)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    @NotNull
    public Timestamp createdAt;

    //@Schema(hidden = true)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = false)
    @NotNull
    public Timestamp modifiedAt;

    @Column(name = "default_location", length = 20, nullable = false)
    @NotNull
    private String defaultLocation;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Rack> racks;

    public Team(String name, String product, String defaultLocation) {
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
    }

    public Team() {}

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public void setRacks(List<Rack> racks) {
        this.racks = racks;
    }

    /*
    private String id;
    private String name;
    private String product;

    private Team(String name, String product) {
        super(name);
        this.id = super.getId();
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public static class TeamBuilder {

        private String id;
        private String name;
        private String product;

        public TeamBuilder(String name, String product) {

            this.id = id;
            this.name = name;
            this.product = product;
        }

        public Team build() {
            return new Team(name, product);
        }

    }
    */

}
