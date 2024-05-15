package metodologie;

public class App {
    @SuppressWarnings("unchecked")
    public static <T extends OccurencesCounter & Csv> T occurencesCounter() {
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends DistinctWordCounter & Csv> T wordsCounter() {
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends OccurencesCounter & DistinctWordCounter & Csv> T countingCounters() {
        return null;
    }
}
