package pers.lyning.kata.marsrover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridPositionerTest {

    @Test
    public void search() {
        // given
        Grid grid = new Grid(new Range(5, 5));
        GridPositioner gridPositioner = new GridPositioner(grid);
        Position initialPosition = new Position(1, 1, DirectionEnum.NORTH);
        // when
        Position nextPosition = gridPositioner.search(initialPosition, 1);
        // then
        assertThat(nextPosition.getX()).isEqualTo(initialPosition.getX());
        assertThat(nextPosition.getY()).isEqualTo(2);
        assertThat(nextPosition.getDirection()).isEqualTo(initialPosition.getDirection());
    }

}