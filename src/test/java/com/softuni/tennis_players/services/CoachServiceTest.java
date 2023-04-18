package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.model.AddCoachDTO;
import com.softuni.tennis_players.domain.enitities.CoachEntity;
import com.softuni.tennis_players.repositories.CoachRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CoachServiceTest {

    private CoachService coachService;

    @Mock
    private CoachRepository mockCoachRepository;

    @BeforeEach
    void setUp() {
        coachService = new CoachService(mockCoachRepository);
    }

    @Test
    void testAddCoach() {
        AddCoachDTO addCoachDTO = new AddCoachDTO()
                .setName("Test Coach")
                .setYearOfBirth(1980L)
                .setNationality("Bulgarian");

        coachService.addCoach(addCoachDTO);

        ArgumentCaptor<CoachEntity> argumentCaptor = ArgumentCaptor.forClass(CoachEntity.class);
        verify(mockCoachRepository).save(argumentCaptor.capture());

        CoachEntity savedCoach = argumentCaptor.getValue();

        Assertions.assertEquals(addCoachDTO.getName(), savedCoach.getName());
        Assertions.assertEquals(addCoachDTO.getYearOfBirth(), savedCoach.getYearOfBirth());
        Assertions.assertEquals(addCoachDTO.getNationality(), savedCoach.getNationality());
    }

    @Test
    void testGetAllCoaches() {
        CoachEntity coach1 = new CoachEntity()
                .setName("Coach 1")
                .setYearOfBirth(1975L)
                .setNationality("Bulgarian");

        CoachEntity coach2 = new CoachEntity()
                .setName("Coach 2")
                .setYearOfBirth(1985L)
                .setNationality("American");

        List<CoachEntity> coaches = new ArrayList<>();
        coaches.add(coach1);
        coaches.add(coach2);

        when(mockCoachRepository.findAll()).thenReturn(coaches);

        List<CoachEntity> allCoaches = coachService.getAllCoaches();

        Assertions.assertEquals(2, allCoaches.size());
    }

    @Test
    void testGetCoaches() {
        CoachEntity coach1 = new CoachEntity()
                .setName("Coach 1")
                .setYearOfBirth(1975L)
                .setNationality("Bulgarian");

        CoachEntity coach2 = new CoachEntity()
                .setName("Coach 2")
                .setYearOfBirth(1985L)
                .setNationality("American");

        List<CoachEntity> coaches = new ArrayList<>();
        coaches.add(coach1);
        coaches.add(coach2);

        when(mockCoachRepository.findAll()).thenReturn(coaches);

        List<com.softuni.tennis_players.domain.dtos.binding.AddCoachDTO> coachDTOs = coachService.getCoaches();

        Assertions.assertEquals(2, coachDTOs.size());
        Assertions.assertEquals(coach1.getName(), coachDTOs.get(0).getName());
        Assertions.assertEquals(coach1.getYearOfBirth(), coachDTOs.get(0).getYearOfBirth());
        Assertions.assertEquals(coach1.getNationality(), coachDTOs.get(0).getNationality());
        Assertions.assertEquals(coach2.getName(), coachDTOs.get(1).getName());
        Assertions.assertEquals(coach2.getYearOfBirth(), coachDTOs.get(1).getYearOfBirth());
        Assertions.assertEquals(coach2.getNationality(), coachDTOs.get(1).getNationality());
    }
}
