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
    public void sortFirstFlightEqualsThanSecond() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 1000, 11, 13);
        Ticket ticket2 = new Ticket("Казань", "Санкт-Петербург", 1500, 13, 15);

        int expected = 0;
        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortByPriceInFlightSearchResult() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Казань", 7000, 11, 12);
        Ticket ticket2 = new Ticket("Новосибирск", "Казань", 7000, 11, 15);
        Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Казань", 3000, 10, 13);
        Ticket ticket5 = new Ticket("Адлер", "Пермь", 7000, 11, 15);

        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket4);


        Ticket[] expected = {ticket4, ticket1};
        Ticket[] actual = souls.search("Санкт-Петербург", "Казань");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByFlightTimeInFlightSearchResult() {

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Казань", 7000, 11, 13);
        Ticket ticket2 = new Ticket("Новосибирск", "Казань", 7000, 11, 15);
        Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 10, 16);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Казань", 3000, 10, 13);
        Ticket ticket5 = new Ticket("Адлер", "Пермь", 7000, 11, 15);

        TicketTimeComparator comparator = new TicketTimeComparator();

        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket4);


        Ticket[] expected = {ticket1, ticket4};
        Ticket[] actual = souls.searchAndSortBy("Санкт-Петербург", "Казань", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
