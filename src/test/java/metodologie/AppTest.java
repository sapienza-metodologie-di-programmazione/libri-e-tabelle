package metodologie;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class AppTest {
    Integer pesce = 11, frodo = 51, enciclopedia = 27, lotr = 664;

    public void checkCsv(String filename, String... tokens) {
        try {
            var csv = Stream.of(Files.readString(Paths.get(filename)).split("[,\n]")).collect(Collectors.toList());
            assertArrayEquals(tokens, csv.toArray());
        } catch (IOException e) {
            fail(String.format("File %s non trovato!", filename));
        }
    }

    @Test
    public void testOccurences1() {
        var counter = App.occurencesCounter();
        assertEquals(pesce, counter.count("pesce", "Enciclopedia dei pesci.txt"));
    }

    @Test
    public void testOccurences2() {
        var counter = App.occurencesCounter();
        assertEquals(pesce, counter.count("pesce", "Enciclopedia dei pesci.txt"));
        counter.save("pesci.txt");
        checkCsv("pesci.txt", "pesce", pesce.toString());
    }

    @Test
    public void testOccurences3() {
        var counter = App.occurencesCounter();

        assertEquals(pesce, counter.count("pesce", "Enciclopedia dei pesci.txt"));
        counter.save("pesci.txt");
        checkCsv("pesci.txt", "pesce", pesce.toString());

        assertEquals(frodo, counter.count("frodo", "Lord of the rings.txt"));
        counter.save("risultati.txt");
        checkCsv("risultati.txt", "pesce", "frodo", pesce.toString(), frodo.toString());
    }

    @Test
    public void testDistinct1() {
        var counter = App.wordsCounter();
        assertEquals(enciclopedia, counter.count("Enciclopedia dei pesci.txt"));
    }

    @Test
    public void testDistinct2() {
        var counter = App.wordsCounter();
        assertEquals(enciclopedia, counter.count("Enciclopedia dei pesci.txt"));
        counter.save("pesci.txt");
        checkCsv("pesci.txt", "Enciclopedia dei pesci.txt", enciclopedia.toString());
    }

    @Test
    public void testDistinct3() {
        var counter = App.wordsCounter();

        assertEquals(enciclopedia, counter.count("Enciclopedia dei pesci.txt"));
        counter.save("pesci.txt");
        checkCsv("pesci.txt", "Enciclopedia dei pesci.txt", enciclopedia.toString());

        assertEquals(lotr, counter.count("Lord of the rings.txt"));
        counter.save("risultati.txt");
        checkCsv("risultati.txt", "Enciclopedia dei pesci.txt", "Lord of the rings.txt", enciclopedia.toString(),
                lotr.toString());
    }

    @Test
    public void testCounters1() {
        var counter = App.countingCounters();

        assertEquals(enciclopedia, counter.count("Enciclopedia dei pesci.txt"));
        counter.save("pesci.txt");
        checkCsv("pesci.txt", "Enciclopedia dei pesci.txt", enciclopedia.toString());

        assertEquals(frodo, counter.count("frodo", "Lord of the rings.txt"));
        counter.save("risultati2.txt");
        checkCsv("risultati2.txt", "Enciclopedia dei pesci.txt", "frodo", enciclopedia.toString(), frodo.toString());
    }
}
