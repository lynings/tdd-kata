package pers.lyning.kata.marsrover;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pers.lyning.kata.marsrover.exceptions.CommandIncorrectException;
import pers.lyning.kata.testing.SystemOutputCapture;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class RoverTest {

    @Rule
    public final ExpectedException expectedEx = ExpectedException.none();
    @Rule
    public final SystemOutputCapture outputCapture = SystemOutputCapture.init();

    private final Grid grid = new Grid(new Range(5, 5));

    /*** receive test start ***/

    @Test
    public void a_step_forward_to_north() {
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F"});

        assertThat(currentPosition.getX()).isEqualTo(0);
        assertThat(currentPosition.getY()).isEqualTo(1);
    }

    @Test
    public void a_step_forward_to_south() {
        Position initialPosition = new Position(1, 1, DirectionEnum.SOUTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F"});

        assertThat(currentPosition.getX()).isEqualTo(1);
        assertThat(currentPosition.getY()).isEqualTo(0);
    }

    @Test
    public void a_step_forward_to_west() {
        Position initialPosition = new Position(1, 1, DirectionEnum.WEST);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F"});

        assertThat(currentPosition.getX()).isEqualTo(0);
        assertThat(currentPosition.getY()).isEqualTo(1);
    }

    @Test
    public void a_step_forward_to_east() {
        Position initialPosition = new Position(1, 1, DirectionEnum.EAST);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F"});

        assertThat(currentPosition.getX()).isEqualTo(2);
        assertThat(currentPosition.getY()).isEqualTo(1);
    }

    @Test
    public void a_step_backward_to_north() {
        Position initialPosition = new Position(1, 1, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"B"});

        assertThat(currentPosition.getX()).isEqualTo(1);
        assertThat(currentPosition.getY()).isEqualTo(0);
    }

    @Test
    public void a_step_backward_to_south() {
        Position initialPosition = new Position(1, 1, DirectionEnum.SOUTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"B"});

        assertThat(currentPosition.getX()).isEqualTo(1);
        assertThat(currentPosition.getY()).isEqualTo(2);
    }

    @Test
    public void a_step_backward_to_west() {
        Position initialPosition = new Position(1, 1, DirectionEnum.WEST);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"B"});

        assertThat(currentPosition.getX()).isEqualTo(2);
        assertThat(currentPosition.getY()).isEqualTo(1);
    }

    @Test
    public void a_step_backward_to_east() {
        Position initialPosition = new Position(1, 1, DirectionEnum.EAST);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"B"});

        assertThat(currentPosition.getX()).isEqualTo(0);
        assertThat(currentPosition.getY()).isEqualTo(1);
    }

    @Test
    public void turn_left_should_return_west_when_given_direction_is_north() {
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"L"});

        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.WEST);
    }

    @Test
    public void turn_left_should_return_south_when_given_direction_is_west() {
        Position initialPosition = new Position(0, 0, DirectionEnum.WEST);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"L"});

        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.SOUTH);
    }

    @Test
    public void turn_left_should_return_east_when_given_direction_is_south() {
        Position initialPosition = new Position(0, 0, DirectionEnum.SOUTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"L"});

        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.EAST);
    }

    @Test
    public void turn_left_should_return_north_when_given_direction_is_east() {
        Position initialPosition = new Position(0, 0, DirectionEnum.EAST);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"L"});

        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.NORTH);
    }

    @Test
    public void turn_right_should_return_east_when_given_direction_is_north() {
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"R"});

        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.EAST);
    }

    @Test
    public void turn_right_should_return_south_when_given_direction_is_east() {
        Position initialPosition = new Position(0, 0, DirectionEnum.EAST);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"R"});

        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.SOUTH);
    }

    @Test
    public void turn_right_should_return_west_when_given_direction_is_south() {
        Position initialPosition = new Position(0, 0, DirectionEnum.SOUTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"R"});

        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.WEST);
    }

    @Test
    public void turn_right_should_return_north_when_given_direction_is_west() {
        Position initialPosition = new Position(0, 0, DirectionEnum.WEST);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"R"});

        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.NORTH);
    }

    @Test
    public void receive_FF() {
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F", "F"});

        assertThat(currentPosition.getX()).isEqualTo(0);
        assertThat(currentPosition.getY()).isEqualTo(2);
        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.NORTH);
    }

    @Test
    public void receive_FFR() {
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F", "F", "R"});

        assertThat(currentPosition.getX()).isEqualTo(0);
        assertThat(currentPosition.getY()).isEqualTo(2);
        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.EAST);
    }

    @Test
    public void receive_FFLBB() {
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F", "F", "L", "B", "B"});

        assertThat(currentPosition.getX()).isEqualTo(2);
        assertThat(currentPosition.getY()).isEqualTo(2);
        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.WEST);
    }

    @Test
    public void receive_FFLBBRFFFLBBB() {
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F", "F", "L", "B", "B", "R", "F", "F", "F", "L", "B", "B", "B"});

        assertThat(currentPosition.getX()).isEqualTo(0);
        assertThat(currentPosition.getY()).isEqualTo(0);
        assertThat(currentPosition.getDirection()).isEqualTo(DirectionEnum.WEST);
    }

    @Test
    public void should_report_obstacle_when_encounters_an_obstacle() {
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Grid grid = new Grid(new Range(5, 5), Arrays.asList(new Obstacle(1, 1)));
        Rover rover = new Rover(initialPosition, grid);
        rover.receive(new String[]{"F", "R", "F"});

        assertThat(outputCapture.toString()).isEqualTo("position(1,1) encounters an obstacle!");
    }

    @Test
    public void should_move_to_last_possible_point_when_encounters_an_obstacle() {
        Grid grid = new Grid(new Range(5, 5), Arrays.asList(new Obstacle(1, 1)));

        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        Rover rover = new Rover(initialPosition, grid);
        Position currentPosition = rover.receive(new String[]{"F", "R", "F", "F"});

        assertThat(currentPosition.getX()).isNotEqualTo(0);
        assertThat(currentPosition.getY()).isNotEqualTo(2);
    }

    @Test
    public void should_fail_when_given_command_incorrect() {
        expectedEx.expect(CommandIncorrectException.class);
        expectedEx.expectMessage("command 'N' incorrect!");
        // given
        Grid grid = new Grid(new Range(5, 5), Arrays.asList(new Obstacle(1, 1)));
        Position initialPosition = new Position(0, 0, DirectionEnum.NORTH);
        // when
        Rover rover = new Rover(initialPosition, grid);
        rover.receive(new String[]{"F", "R", "N"});
        // then
    }
    /*** receive test end ***/
}
