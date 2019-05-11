package parkingapp;

/**
 * This is the routine to determine charge for a vehicle that presents a ticket for a 
 * special event upon exiting the parking garage.
 * 
 * @author tquigley1
 */
public class SpecialEventCharge implements ChargeStrategy {

    private int checkInTime;
    private int checkOutTime;
    private final double SPECIAL_EVENT_CHARGE = 20.00;
        
    public SpecialEventCharge(int checkInTime, int checkOutTime) {
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
    
    @Override
    public double getCharge(int checkInTime, int checkOutTime) {
        return SPECIAL_EVENT_CHARGE;
    }
    
}
