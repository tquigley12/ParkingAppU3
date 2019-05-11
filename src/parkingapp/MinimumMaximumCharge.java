package parkingapp;

/**
 * This is the routine to determine charge for a vehicle that presents a ticket for a 
 * non special event upon exiting the parking garage.
 * 
 * @author tquigley1
 */
public class MinimumMaximumCharge implements ChargeStrategy {

    private int checkInTime;
    private int checkOutTime;
    private double vehicleCharge;
    private final int MINIMUM_TIME = 3;
    private final double MINIMUM_CHARGE = 5.00;
    private final double PER_HOUR_CHARGE = 1.00;
    private final double MAXIMUM_CHARGE_WITH_TICKET = 15.00;
    
    public MinimumMaximumCharge(int checkInTime, int checkOutTime) {
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
    
    @Override
    public double getCharge(int checkInTime, int checkOutTime) {
        vehicleCharge = ((checkOutTime - checkInTime - MINIMUM_TIME) * PER_HOUR_CHARGE) + MINIMUM_CHARGE;
            if (vehicleCharge > MAXIMUM_CHARGE_WITH_TICKET) {
                vehicleCharge = MAXIMUM_CHARGE_WITH_TICKET;
            }
        return vehicleCharge;
    }

}
