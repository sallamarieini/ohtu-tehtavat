package ohtuesimerkki;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class StatisticsTest {

    Statistics statistics;

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void setUp() {
        statistics = new Statistics(readerStub);
    }

    @Test
    public void findsTheCorrectPlayer() {
        Player p = statistics.search("Kurri");
        assertEquals("Kurri", p.getName());
    }

    @Test
    public void returnsNullIfPlayerNotFound() {
        Player p = statistics.search("Peter");
        assertEquals(null, p);
    }

    @Test
    public void findsPlayersOfTeam() {
        List<Player> p = statistics.team("EDM");
        assertEquals(3, p.size());
    }

    @Test
    public void findsTopScorers() {
        List<Player> p = statistics.topScorers(3);
        assertEquals("Gretzky", p.get(0).getName());
    }

}
