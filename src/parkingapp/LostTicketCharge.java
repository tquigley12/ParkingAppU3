package parkingapp;

/**
 * This is the routine to determine charge for a lost ticket.
 * 
 * @author tquigley1
 */
public class LostTicketCharge implements ChargeStrategy {

    private int checkInTime;
    private int checkOutTime;
    private final double LOST_TICKET_CHARGE = 25.00;
    
    public LostTicketCharge(int checkInTime, int checkOutTime) {
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
        
    @Override
    public double getCharge(int checkInTime, int checkOutTime) {
        return LOST_TICKET_CHARGE;
    }

}
