package parkingapp;

/**
 * This class drives the logic for the charge as a vehicle leaves the parking garage.
 * Class ChargeApp employs the Singleton Pattern and is part of a Factory Pattern
 * construct for the charging routine.
 * 
 * @author tquigley1
 */
public class ChargeApp {

    private static ChargeFactory chargeFactory;
    private final static ChargeApp INSTANCE = null;

    public ChargeApp(ChargeFactory chargeFactory) {
        ChargeApp.chargeFactory = chargeFactory;
    }

    /**
     * This is the core processing method that invokes the Charge Factory Pattern construct.
     * @param chargeType specifies which charge routine to call.
     * @param checkInTime is the check in time of the vehicle to the parking garage.
     * @param checkOutTime is the check out time of the vehicle from the parking garage.
     * @return 
     */
    public static double run(String chargeType, int checkInTime, int checkOutTime) {
        ChargeStrategy chargeStrategy = chargeFactory.make(chargeType, checkInTime, checkOutTime);
        return chargeStrategy.getCharge(checkInTime, checkOutTime);
    }
    
    /**
     * 
     * @return INSTANCE upon instantiation of Singleton object.
     */
    public ChargeApp getInstance() {
        return INSTANCE;
    }

}
