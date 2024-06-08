package Closed_types;

public enum EnumScore {
    LOVE(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40) {
        @Override
        public EnumScore next() { throw new UnsupportedOperationException(); }
    };

    private final int value;

    public int value() { return value; }
    public EnumScore next() { return values()[ordinal() + 1]; }

    private EnumScore(int value) { this.value = value; }
}


