package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    @DisplayName("포인트를 생성한다. 양방향으로 이동을 설정할 수는 없다.")
    public void create() {
        assertThatThrownBy(() -> Point.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("왼쪽으로 이동한다.")
    public void left() {
        assertThat(Point.of(true, false).direction()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("오른쪽으로 이동한다.")
    public void right() {
        assertThat(Point.of(false, true).direction()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("아래로 이동한다.")
    public void down() {
        assertThat(Point.of(false, false).direction()).isEqualTo(Direction.DOWN);
    }

    @Test
    @DisplayName("시작점을 생성한다. 왼쪽으로는 이동이 불가능하다.")
    public void create_first() {
        assertThat(Point.first(true).direction()).isEqualTo(Direction.RIGHT);
        assertThat(Point.first(false).direction()).isEqualTo(Direction.DOWN);
    }

    @Test
    @DisplayName("종료점을 생성한다. 오른쪽으로는 이동이 불가능하다.")
    public void create_last() {
        assertThat(Point.first(true).last().direction()).isEqualTo(Direction.LEFT);
        assertThat(Point.first(false).last().direction()).isEqualTo(Direction.DOWN);
    }


    @Test
    @DisplayName("이전 포인트를 기준을 다음 포인트를 생성한다. 이전 포인트의 오른쪽이 이동가능한 경우 다음 포인트의 오른쪽은 이동설정은 불가능하다.")
    public void create_next() {
        assertThat(Point.of(false, true).next(false).direction()).isEqualTo(Direction.LEFT);
        assertThat(Point.of(false, false).next(true).direction()).isEqualTo(Direction.RIGHT);
        assertThat(Point.of(false, false).next(false).direction()).isEqualTo(Direction.DOWN);
        assertThat(Point.of(false, true).next(true).direction()).isEqualTo(Direction.LEFT);
    }
}
