package org.max.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyGameTest {


    @Test
    void playerNoRiskAndWin () {
        //Given
        Player player = new Player("Ivan", false);
        List <Door> doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        Game game = new Game(player, doors);
        //When
        Door result = game.round(0);
        //Then
        Assertions.assertEquals(true, result.isPrize());
    }

    @Test
    void playerNoRiskAndLoose () {
        //Given
        Player player = new Player("Ivan", false);
        List <Door> doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(true));
        doors.add(new Door(false));
        Game game = new Game(player, doors);
        //When
        Door result = game.round(0);
        //Then
        Assertions.assertEquals(false, result.isPrize());
    }

    @Test
    void playerRiskAndLoose () {
        //Given
        Player player = new Player("Ivan", true);
        List <Door> doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        Game game = new Game(player, doors);
        //When
        Door result = game.round(0);
        //Then
        Assertions.assertEquals(false, result.isPrize());
    }

    @Test
    void playerRiskAndWin () {
        //Given
        Player player = new Player("Ivan", true);
        List <Door> doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(true));
        doors.add(new Door(false));
        Game game = new Game(player, doors);
        //When
        Door result = game.round(0);
        //Then
        Assertions.assertEquals(true,result.isPrize());
    }
}
