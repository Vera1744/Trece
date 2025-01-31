package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMovie {

    @Test
    public void testNoAdd() {
        MovieManager manager = new MovieManager();

        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddOneMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");

        String[] actual = manager.findAll();
        String[] expected = {"Бладшот"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddTreeMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель\"Белград\"");
        String[] actual = manager.findAll();
        String[] expected = {"Бладшот", "Вперёд", "Отель\"Белград\""};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLast() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель\"Белград\"");
        String[] actual = manager.findLast();
        String[] expected = {"Отель\"Белград\"", "Вперёд", "Бладшот"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOverLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель\"Белград\"");
        manager.addMovie("Джентельмены");

        String[] actual = manager.findLast();
        String[] expected = {"Джентельмены", "Отель\"Белград\"", "Вперёд"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testUnderLimit() {
        MovieManager manager = new MovieManager(3);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");

        String[] actual = manager.findLast();
        String[] expected = {"Вперёд", "Бладшот"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель\"Белград\"");

        String[] actual = manager.findLast();
        String[] expected = {"Отель\"Белград\"", "Вперёд", "Бладшот"};
        Assertions.assertArrayEquals(expected, actual);
    }

}