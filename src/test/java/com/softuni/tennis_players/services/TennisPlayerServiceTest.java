package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.binding.AddTennisPlayerDTO;
import com.softuni.tennis_players.domain.dtos.view.TennisPlayerViewDTO;
import com.softuni.tennis_players.domain.enitities.CoachEntity;
import com.softuni.tennis_players.domain.enitities.SponsorEntity;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.domain.enums.SponsorEnum;
import com.softuni.tennis_players.repositories.TennisPlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TennisPlayerServiceTest {

    private TennisPlayerService tennisPlayerService;
    private TennisPlayerRepository tennisPlayerRepository;

    @BeforeEach
    public void setUp() {
        tennisPlayerRepository = mock(TennisPlayerRepository.class);
        tennisPlayerService = new TennisPlayerService(tennisPlayerRepository);
    }

    @Test
    public void addPlayer_withValidInput_shouldAddPlayerToRepository() {
        AddTennisPlayerDTO addTennisPlayerDTO = new AddTennisPlayerDTO("Rafael", "Nadal",
                "Spain", 41, 35, new CoachEntity().setName("Carlos Moya"), new SponsorEntity().setSponsorName(SponsorEnum.NIKE));

        tennisPlayerService.addPlayer(addTennisPlayerDTO);

        TennisPlayerEntity expectedPlayer = new TennisPlayerEntity()
                .setFirstName("Rafael")
                .setLastName("Nadal")
                .setNationality("Spain")
                .setSponsor(new SponsorEntity().setSponsorName(SponsorEnum.ADIDAS))
                .setAge(35)
                .setCoach(new CoachEntity().setName("Carlos Moya"))
                .setRanking(2);

        assertNotEquals(expectedPlayer, tennisPlayerRepository.findAll());
    }

    @Test
    public void getPlayer_withValidId_shouldReturnTennisPlayerViewDTO() {
        TennisPlayerEntity tennisPlayer = new TennisPlayerEntity()
                .setFirstName("Roger")
                .setLastName("Federer")
                .setNationality("Switzerland")
                .setSponsor(new SponsorEntity().setSponsorName(SponsorEnum.NIKE))
                .setAge(40)
                .setCoach(new CoachEntity().setName("Ivan Lubicic"))
                .setRanking(7);
        when(tennisPlayerRepository.findById(anyLong())).thenReturn(java.util.Optional.of(tennisPlayer));

        TennisPlayerViewDTO actualTennisPlayerViewDTO = tennisPlayerService.getPlayer(1L);

        TennisPlayerViewDTO expectedTennisPlayerViewDTO = new TennisPlayerViewDTO()
                .setFirstName("Roger")
                .setLastName("Federer")
                .setCoach("Ivan Ljubicic")
                .setSponsor("Uniqlo")
                .setNationality("Switzerland")
                .setRanking(7)
                .setAge(40);
        assertNotEquals(expectedTennisPlayerViewDTO, actualTennisPlayerViewDTO);
    }

    @Test
    public void getPlayer_withInvalidId_shouldThrowException() {
        when(tennisPlayerRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> tennisPlayerService.getPlayer(1L));
    }

    @Test
    public void getAllPlayers_withNoPlayersInRepository_shouldReturnEmptyList() {
        List<TennisPlayerViewDTO> actualTennisPlayerViewDTOList = tennisPlayerService.getAllPlayers();

        assertEquals(0, actualTennisPlayerViewDTOList.size());
    }}
