package com.ctw.workstation.team.service;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository teamRepository;

    private static TeamService instance = null;

    public static TeamService getInstance() {
        if (instance == null) {
            instance = new TeamService();
        }
        return instance;
    }

    private TeamService() {
        teamRepository = new TeamRepository();
    }

    //@Transactional
    public List<TeamResponseDTO> getAllTeams() {
        List<Team> teams = teamRepository.listAll();
        //return teams;
        return teams.stream().map(TeamResponseDTO::new).collect(Collectors.toList());
    }

    public TeamResponseDTO getTeamDTOById(UUID id) {
        Team team = teamRepository.findById(id);
        return new TeamResponseDTO(team);
    }

    public Team getTeamById(UUID id) {
        return teamRepository.findById(id);
    }

    @Transactional
    public TeamResponseDTO addTeam(TeamRequestDTO request) {
        Team team = new Team(request.name(), request.product(), request.defaultLocation());
        teamRepository.persist(team);
        teamRepository.flush();
        return new TeamResponseDTO(team);
    }

    @Transactional
    public void removeTeam(UUID id) {
        teamRepository.delete(teamRepository.findById(id));
    }

    @Transactional
    public TeamResponseDTO updateTeam(Team existingTeam, TeamRequestDTO givenTeam) {
        existingTeam.setName(givenTeam.name());
        existingTeam.setProduct(givenTeam.product());
        existingTeam.setDefaultLocation(givenTeam.defaultLocation());

        teamRepository.getEntityManager().merge(existingTeam);

        return new TeamResponseDTO(existingTeam);
    }


}
