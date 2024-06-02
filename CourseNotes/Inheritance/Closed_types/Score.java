package Closed_types;

public class Score {
    public static final Score LOVE = new Score(0, "LOVE", 0);
    public static final Score FIFTEEN = new Score(1, "FIFTEEN", 15);
    public static final Score THIRTY = new Score(2, "THIRTY", 30);
    public static final Score FORTY = new Score(3, "FORTY", 40) {
        @Override
        public Score next() { throw new UnsupportedOperationException(); }
    };
    private static final Score[] values = {LOVE, FIFTEEN, THIRTY, FORTY};

    public static Score[] values() { return values.clone(); }

    private final int ordinal;
    private final String name;
    private final int value;

    public int ordinal() { return ordinal; }
    public String name() { return name; }
    public int value() { return value; }
    public Score next() { return values[ordinal + 1]; }

    private Score(int ordinal, String name, int value) {
        this.ordinal = ordinal;
        this.name = name;
        this.value = value;
    }
    
    
//    public String getScoreInFrench(Score score) {
//        switch (score) {
//            case LOVE -> { return "zéro"; }
//            case FIFTEEN -> { return "quinze"; }
//            case THIRTY -> { return "trente"; }
//            default -> { return "quarante"; }
//        }
//    }
    
    
//    public String getScoreInFrench2(Score score) {
//        return switch (score) {
//            case LOVE -> "zéro";
//            case FIFTEEN -> "quinze";
//            case THIRTY -> "trente";
//            case FORTY -> "quarante";
//        };
//    }

    public String toString(GameState state) {
        return switch (state) {
            case GameState.Regular(var serverScore, var receiverScore) ->
                    serverScore.value() + "-" + receiverScore.value();
            case GameState.Advantage(var server) ->
                    "advantage " + (server ? "server" : "receiver");
            case GameState.Won(var server) ->
                    "won by the " + (server ? "server" : "receiver");
        };
    }
}
