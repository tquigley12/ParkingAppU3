package parkingapp;

/**
 *
 * This class contains methods for time related activities for the parking garage application.
 * Class TimeRoutine employs the Singleton Pattern.
 * 
 * @author tquigley1
 */
public enum TimeRoutine {
    INSTANCE;
    
    private final static int CHECK_IN_BEGIN_TIME = 7;
    private final static int CHECK_IN_END_TIME = 12;
    private final static int CHECK_OUT_BEGIN_TIME = 13;
    private final static int CHECK_OUT_END_TIME = 23;
    
private TimeRoutine() {
    
}

    /**
     * This method randomly generates a check in time and returns the value.
     * @return integer value for check in time.
     */
    public static int getCheckInTime() {
        int checkInTime = (int) (Math.random() * (CHECK_IN_END_TIME - CHECK_IN_BEGIN_TIME + 1) + CHECK_IN_BEGIN_TIME);
        return checkInTime;
    }
    
    /**
     * This method randomly generates a check out time and returns the value.
     * @return integer value for check out time.
     */
    public static int getCheckOutTime() {
        int checkOutTime = (int) (Math.random() * (CHECK_OUT_END_TIME - CHECK_OUT_BEGIN_TIME + 1) + CHECK_OUT_BEGIN_TIME);
        return checkOutTime;
    }
    
    /**
     * This method returns the closing time for the parking garage.
     * @return integer value for closing time.
     */
    public static int getClosingTime() {
        return CHECK_OUT_END_TIME;
    }
    
}
