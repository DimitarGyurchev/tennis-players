package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.enitities.SponsorEntity;
import com.softuni.tennis_players.domain.enums.SponsorEnum;
import com.softuni.tennis_players.repositories.SponsorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SponsorServiceTest {
    private SponsorService toTest;
    @Mock
    private SponsorRepository mockSponsorRepository;
    @BeforeEach
    void setUp() {
        toTest = new SponsorService(mockSponsorRepository);
    }
    @Test
    void testGetAllSponsors(){
        SponsorEntity testSponsor = new SponsorEntity()
                .setSponsorName(SponsorEnum.NIKE);

        SponsorEntity testSponsor2 = new SponsorEntity()
                .setSponsorName(SponsorEnum.ADIDAS);

        List<SponsorEntity> listOfSponsors = new ArrayList<>();
        listOfSponsors.add(testSponsor);
        listOfSponsors.add(testSponsor2);
        when(mockSponsorRepository.findAll()).thenReturn(listOfSponsors);
        List<SponsorEntity> listOfAllSponsorsReturnedByRepository = toTest.getAllSponsors();
        Assertions.assertEquals(2, listOfAllSponsorsReturnedByRepository.size());
    }
}
