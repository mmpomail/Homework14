package ru.netology.javaqa.Homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void sortByTicketPriceFirstLowerThanSecond() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 1000, 11, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 1500, 13, 14);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortByTicketPriceFirstBiggerThanSecond() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 2000, 11, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 1500, 13, 14);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortByTicketPriceFirstEqualsSecond() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 2000, 11, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 2000, 13, 14);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortFirstFlightShorterThanSecond() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 1000, 11, 12);
        Ticket ticket2 = new Ticket("Казань", "Санкт-Петербург", 1500, 13, 16);

        int expected = -1;
        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortFirstFlightLongerThanSecond() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 1000, 11, 15);
        Ticket ticket2 = new Ticket("Казань", "Санкт-Петербург", 1500, 13, 16);

        int expected = 1;
        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortFirstFlightEqualsSecond() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 1000, 11, 13);
        Ticket ticket2 = new Ticket("Казань", "Санкт-Петербург", 1500, 13, 15);

        int expected = 0;
        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortByPriceInFlightSearchFewResult() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Казань", 6000, 11, 12);
        Ticket ticket2 = new Ticket("Новосибирск", "Казань", 7000, 11, 15);
        Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Казань", 3000, 10, 13);
        Ticket ticket5 = new Ticket("Санкт-Петербург", "Казань", 7000, 11, 15);

        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);


        Ticket[] expected = {ticket4, ticket1, ticket5};
        Ticket[] actual = souls.search("Санкт-Петербург", "Казань");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceInFlightSearchNullResult() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Казань", 6000, 11, 12);
        Ticket ticket2 = new Ticket("Новосибирск", "Казань", 7000, 11, 15);
        Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Казань", 3000, 10, 13);
        Ticket ticket5 = new Ticket("Санкт-Петербург", "Казань", 7000, 11, 15);

        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);


        Ticket[] expected = {};
        Ticket[] actual = souls.search("Челябинск", "Адлер");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceInFlightSearchOneResult() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Казань", 6000, 11, 12);
        Ticket ticket2 = new Ticket("Новосибирск", "Казань", 7000, 11, 15);
        Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Казань", 3000, 10, 13);
        Ticket ticket5 = new Ticket("Санкт-Петербург", "Казань", 7000, 11, 15);

        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);


        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.search("Екатеринбург", "Владивосток");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void sortByFlightTimeInFlightFewSearchResult() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Казань", 7000, 11, 13);
        Ticket ticket2 = new Ticket("Новосибирск", "Казань", 7000, 11, 15);
        Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Казань", 3000, 10, 13);
        Ticket ticket5 = new Ticket("Адлер", "Пермь", 7000, 11, 15);

        TicketTimeComparator comparator = new TicketTimeComparator();

        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);


        Ticket[] expected = {ticket1, ticket4};
        Ticket[] actual = souls.searchAndSortBy("Санкт-Петербург", "Казань", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByFlightTimeInFlightNullSearchResult() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Казань", 7000, 11, 13);
        Ticket ticket2 = new Ticket("Новосибирск", "Казань", 7000, 11, 15);
        Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Казань", 3000, 10, 13);
        Ticket ticket5 = new Ticket("Адлер", "Пермь", 7000, 11, 15);

        TicketTimeComparator comparator = new TicketTimeComparator();

        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);


        Ticket[] expected = {};
        Ticket[] actual = souls.searchAndSortBy("Челябинск", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByFlightTimeInFlightOneSearchResult() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Казань", 7000, 11, 13);
        Ticket ticket2 = new Ticket("Новосибирск", "Казань", 7000, 11, 15);
        Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Казань", 3000, 10, 13);
        Ticket ticket5 = new Ticket("Адлер", "Пермь", 7000, 11, 15);

        TicketTimeComparator comparator = new TicketTimeComparator();

        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);


        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.searchAndSortBy("Екатеринбург", "Владивосток", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
