package parkingapp;

/**
 * This class describes the vehicle objects in the Parking Garage application.
 * 
 * @author tquigley1
 */
public class Vehicle {
    private final int vehicleID;
    private final int checkInTime;
    private int checkOutTime;
    private double vehicleCharge;
    private boolean lostTicket;
    private boolean specialEvent;
    
    /**
     * This constructor is used to add a vehicle object in the CheckIn class.
     * @param vehicleID is the identification number of the vehicle in the Parking Garage application.
     * @param checkInTime is the check in time of the vehicle.
     * @param specialEvent is the boolean value that specifies whether the vehicle is in the garage for a special event.
     */
    public Vehicle(int vehicleID, int checkInTime, boolean specialEvent) {
        this.vehicleID = vehicleID;
        this.checkInTime = checkInTime;
        checkOutTime = 0;
        vehicleCharge = 0.00;
        lostTicket = false;
        this.specialEvent = specialEvent;
    }

    /**
     * This constructor is used to add a vehicle when the ArrayList is populated from the text file in the ParkingApp class.
     * @param vehicleID is the identification number of the vehicle in the Parking Garage application.
     * @param checkInTime is the check in time of the vehicle.
     * @param checkOutTime is the check out time of the vehicle.
     * @param vehicleCharge is the charge that the vehicle has been assessed.
     * @param lostTicket is the boolean value that specifies whether the vehicle has a lost ticket.
     * @param specialEvent is the boolean value that specifies whether the vehicle is in the garage for a special event.
     */
    public Vehicle(int vehicleID, int checkInTime, int checkOutTime, double vehicleCharge, boolean lostTicket, boolean specialEvent) {
        this.vehicleID = vehicleID;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.vehicleCharge = vehicleCharge;
        this.lostTicket = lostTicket;
        this.specialEvent = specialEvent;
    }

    /**
     * Get the vehicleID.
     * @return vehicleID.
     */
    public int getVehicleID() {
        return vehicleID;
    }

    /**
     * Get the checkInTime.
     * @return checkInTime.
     */
    public int getCheckInTime() {
        return checkInTime;
    }

    /**
     * Get the checkOutTime.
     * @return checkOutTime.
     */
    public int getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * Get the vehicleCharge.
     * @return vehicleCharge.
     */
    public double getVehicleCharge() {
        return vehicleCharge;
    }

    /**
     * Get the lostTicket variable.
     * @return lostTicket.
     */
    public boolean getLostTicket() {
        return lostTicket;
    }
    
    /**
     * Get the specialEvent variable.
     * @return specialEvent.
     */
    public boolean getSpecialEvent() {
        return specialEvent;
    }
    
    /**
     * Set the checkOutTime.
     * @param checkOutTime is integer value for vehicle check out time.
     */
    public void setCheckOutTime(int checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    /**
     * Set the vehicleCharge.
     * @param vehicleCharge is a double value for the charge assessed to the vehicle.
     */
    public void setVehicleCharge(double vehicleCharge) {
        this.vehicleCharge = vehicleCharge;
    }

    /**
     * Set the lostTicket variable.
     * @param lostTicket is a boolean value that specifies whether the vehicle has a lost ticket.
     */
    public void setLostTicket(boolean lostTicket) {
        this.lostTicket = lostTicket;
    }
    
    /**
     * Set the specialEvent variable.
     * @param specialEvent is a boolean value specifies whether the vehicle is parked for a special event.
     */
    public void setSpecialEvent(boolean specialEvent) {
        this.specialEvent = specialEvent;
    }
    
}
