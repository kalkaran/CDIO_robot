package Navigation;


import static java.lang.Math.sqrt;

public class RobotPosition {
    /*
     * Changelog Goal has changed from a non camera solution to a camera solution.
     *
     * This is meant to be for the robots positioning on the map.
     *
     * The robot has a:
     * size / volume.
     * orientation
     * and specific sides/points of the robot will be used to interact with the environment.
     * Robot 'Center will be corrected according to turning axis of the robot'
     *
     * set Orientation
     * get Orientation
     * change Orientation
     *
     *
     * Turning Distance!
     */

    private int robotOrientation = 0;
    // These values Below will be hard coded and set based on the robot.
    //Center point is turningcenter of the robot
    // collection point is where the balls have to be to be collected
    // delivery point is the exit point of the balls
    private int robotLengthX = 30;
    private int robotLengthY = 20;
    private int robotCenterPointX = 10;
    private int robotCenterPointY = 10;

    private int collectionPointX = 30;
    private int collectionPointY = 10;

    private int deliveryPointX = 0;
    private int deliveryPointY = 10;

    private int robotXCoordinate;
    private int robotYCoordinate;

    public void setRobotXCoordinate(int robotXCoordinate) {
        this.robotXCoordinate = robotXCoordinate;
    }

    public void setRobotYCoordinate(int robotYCoordinate) {
        this.robotYCoordinate = robotYCoordinate;
    }

    public int getRobotXCoordinate() {
        return this.robotXCoordinate;
    }

    public int getRobotYCoordinate() {
        return robotYCoordinate;
    }

    /**
     * Use this method to change the orientation - do this at the start.
     *
     * @param changeInDegrees
     */
    public void changeRobotOrientation(int changeInDegrees) {
        int previousOrientation = getRobotOrientation();
        int newOrientation = previousOrientation + changeInDegrees;
        setRobotOrientation(newOrientation);
    }

    /**
     * This is a control method for setting the orientation of the robot
     * should not be accessed directly use changeRobotOrientation instead.
     * <p>
     * Robot orientation starts at 0. Needs to be corrected.
     * <p>
     * Used to control the degrees, and enforce values between 0 and 359
     *
     * @param robotOrientation
     */
    private void setRobotOrientation(int robotOrientation) {
        robotOrientation = robotOrientation % 360;
        if (robotOrientation < 0) {
            robotOrientation = robotOrientation + 360;
        }
        this.robotOrientation = robotOrientation;
    }


    public int getRobotOrientation() {
        return robotOrientation;
    }

    /**
     * This method is made to get the turning distances of the robot.
     * nb. the robot will not be circular, front and back will have different radius from center.
     *
     * @return radius
     */
    public int getTurningDistance() {
        int maxDistX;
        int maxDistY;
        int maxDist;
        if (this.robotCenterPointX > (this.robotLengthX - this.robotCenterPointX)) {
            maxDistX = this.robotCenterPointX;
        } else {
            maxDistX = this.robotLengthX - this.robotCenterPointX;
        }

        if (this.robotCenterPointY > (this.robotLengthY - this.robotCenterPointY)) {
            maxDistY = this.robotCenterPointY;
        } else {
            maxDistY = this.robotLengthY - this.robotCenterPointY;
        }

//        if( maxDistY < maxDistX){
//            maxDist = maxDistX;
//        } else{
//            maxDist = maxDistY;
//        }

        int radius = (int) sqrt(maxDistX * maxDistX + maxDistY * maxDistY);
        return radius;

    }


    public void moveRobotDistance(int distance) {
        int orientation = getRobotOrientation();
        int startX = getRobotXCoordinate();
        int startY = getRobotYCoordinate();

        int changeY = (int) Math.sin(orientation) * distance;
        int changeX = (int) Math.cos(orientation) * distance;

        int newX = startX + changeX;
        int newY = startY + changeY;


    }

}



