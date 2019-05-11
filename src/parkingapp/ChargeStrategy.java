package parkingapp;

/**
 * This is the interface for the charge strategy routine.
 * 
 * @author tquigley1
 */
public interface ChargeStrategy {
    
    double getCharge(int checkInTime, int checkOutTime);
            
}
