package Navigation;

import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

public class Robot {


    /*
     *
     * Check orientation
     * Check position.
     *
     * Expected position.
     * Check if it is consistent
     * Illegal Positions.
     */

    public static void main(String[] args) {

        RobotPosition robot = new RobotPosition();
        Map map = new Map();


        robot.setRobotXCoordinate(20);
        robot.setRobotYCoordinate(5);


        robot.changeRobotOrientation(95);

        robot.moveRobotDistance(200);

        robot.outPutPosition();

    }

}
/*
 * Changelog: Goal has changed from a non camera solution to a camera solution.
 *
  */