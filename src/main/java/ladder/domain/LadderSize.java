package ladder.domain;

public class LadderSize {
    private final long width;
    private final long height;

    private LadderSize(long width, long height) {
        this.width = width;
        this.height = height;
    }

    public static LadderSize of(Players players, long height) {
        return new LadderSize(players.size(), height);
    }

    public long width() {
        return width;
    }

    public long height() {
        return height;
    }
}
