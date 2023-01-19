package dev.jsx.servicestests;

import com.uni.daos.TeamDAO;
import com.uni.daos.TeamRequestDAO;
import com.uni.daos.UserDAO;
import com.uni.entities.Team;
import com.uni.services.RegistrationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceTest {
    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @Mock
    private TeamDAO teamDAO;

    @Mock
    private UserDAO userDAO;

    @Mock
    private TeamRequestDAO teamRequestDAO;

    @Test
    @DisplayName("Register team")
    public void registerTeamTest() {
        Team team = new Team("Rapids", 1, "Soccer", "Yes");
        when(teamDAO.save(team)).thenReturn(new Team("Rapids", 1, "Soccer", "Yes"));

        Team newTeam = registrationService.registerTeam(team);
        verify(teamDAO, times(1)).save(team);

        assertEquals(team, newTeam);
    }
}
