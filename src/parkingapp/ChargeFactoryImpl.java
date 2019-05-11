package parkingapp;

/**
 * This is the implementation class of the Charge Factory Pattern construct.  Class
 * ChargeFactoryImpl employs the enum Singleton Pattern.
 * 
 * @author tquigley1
 */
public enum ChargeFactoryImpl implements ChargeFactory {
    INSTANCE;
    
    private ChargeFactoryImpl() {
    
    }
    
    /**
     * This method returns an object containing the charge strategy.
     * @param chargeStrategy is a string value that determines which charge routine to call.
     * @param checkInTime is the check in time for a vehicle into the parking garage.
     * @param checkOutTime is the check out time for a vehicle from the parking garage.
     * @return the ChargeStrategy object.
     */
    @Override
    public ChargeStrategy make(String chargeStrategy, int checkInTime, int checkOutTime) {
        switch (chargeStrategy) {
            case "minimum maximum":
                return new MinimumMaximumCharge(checkInTime, checkOutTime);
            case "special event":
                return new SpecialEventCharge(checkInTime, checkOutTime);
            case "lost ticket":
                return new LostTicketCharge(checkInTime, checkOutTime);
        }

        return null;
    }

}
