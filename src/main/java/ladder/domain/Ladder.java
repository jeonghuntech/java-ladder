package ladder.domain;

import ladder.strategy.PathStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(long width, long height, PathStrategy pathStrategy) {
        this.ladder = generateLadder(width, height, pathStrategy);

        if (height < 2) {
            throw new IllegalArgumentException("최소 높이는 2개 이상입니다.");
        }
    }

    public static Ladder of(int width, int height, PathStrategy pathStrategy) {
        return new Ladder(width, height, pathStrategy);
    }

    private List<Line> generateLadder(long width, long height, PathStrategy pathStrategy) {
        return Stream.generate(() -> Line.of(width, pathStrategy))
                .limit(height)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Line line : ladder) {
            stringBuffer.append(line).append("\n");
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}