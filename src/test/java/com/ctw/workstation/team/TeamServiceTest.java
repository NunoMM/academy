package com.ctw.workstation.team;

import com.ctw.workstation.config.CtwAcademyResource;
import com.ctw.workstation.config.CtwAcademyTestProfile;
import com.ctw.workstation.rack.service.RackService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import com.ctw.workstation.team.service.TeamRepository;
import com.ctw.workstation.team.service.TeamService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@QuarkusTest
@TestProfile(CtwAcademyTestProfile.class)
public class TeamServiceTest {

    @Inject
    TeamService teamService;

    @Inject //InjectMock do quarkus
    TeamRepository teamRepository;

    /*
    @Test
    @DisplayName("Add team nope")
    void add_team_nope() {
        TeamRepository mockTeamRepository = Mockito.mock(TeamRepository.class);
        QuarkusMock.installMockForInstance(mockTeamRepository, teamRepository);

        Mockito.doThrow(new IllegalArgumentException("NOPE"))
                .when(mockTeamRepository)
                .persist(Mockito.any(Team.class));

        // Given
        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("TeamName", "Product", "Location");
        // When then
        assertThatThrownBy(() -> teamService.addTeam(teamRequestDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("NOPE");

    }

    @Test
    @DisplayName("Add team")
    void add_team() {
        TeamRepository teamRepository = Mockito.mock(TeamRepository.class);
        QuarkusMock.installMockForType(teamRepository, TeamRepository.class);

        Mockito.doThrow(new IllegalArgumentException("NOPE"))
                .when(teamRepository)
                .persist(Mockito.any(Team.class));


        // Given
        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("TeamName", "Product", "Location");
        // When
        TeamResponseDTO createdTeam = teamService.addTeam(teamRequestDTO);
        // Given
        assertThat(createdTeam)
                .hasNoNullFieldsOrProperties() //remover caso exista algum campo que possa ser null
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(teamRequestDTO);


        //assertThat(teamRepository.findById(createdTeam.id())).isNotNull();
        //assertThat(teamRepository.findByIdOptional((Long) createdTeam.id())).isPresent();


    }
    */


}
