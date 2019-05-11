package parkingapp;

import static java.lang.Character.toUpperCase;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class describes the check-in functions of the Parking Garage.
 * 
 * @author tquigley1
 */
public class CheckInStation {
    private char action;
    private boolean validAction = false;
    private boolean specialEvent;
    Scanner keyboard = new Scanner(System.in);
        
    /**
     * This is the constructor for class CheckInStation.  Logic is invoked to create menu
     * options for the user to input choices and to process the input.
     * @param vehicle is ArrayList containing all the vehicle objects in the parking garage application.
     */
    public CheckInStation(ArrayList<Vehicle> vehicle) {
        writeCheckInMenu();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        validAction = verifyCheckInAction(action);
        while (!validAction) {
            System.out.println("Invalid action.  Please re-enter. ");
            System.out.println("");
            writeCheckInMenu();
            action = toUpperCase(keyboard.nextLine().charAt(0));
            validAction = verifyCheckInAction(action);
        }
        if (action == '2') {
            specialEvent = true;
        } else {
            specialEvent = false;
        }
        processCheckInInput(action, vehicle, specialEvent);
    }
    
    /**
     * Display the check in menu.
     */
    private void writeCheckInMenu() {
        System.out.println("");
        System.out.println("Best Value Parking Garage");
        System.out.println("");
        System.out.println("=========================");
        System.out.println("");
        System.out.println("1 - Check/In");
        System.out.println("");
        System.out.println("2 - Special Event");
        System.out.println("");
        System.out.println("3 - Close Garage");
        System.out.println("");
        System.out.print("==> ");
    }

    /**
     * Check whether the user input is valid.
     * @param action is user input action.
     * @return boolean value of 'true' if user input is valid, 'false' otherwise.
     */
    private boolean verifyCheckInAction(char action) {
        boolean checkInAction;
        switch (action) {
            case '1':
            case '2':
            case '3':
                checkInAction = true;
                break;
            default:
                checkInAction = false;
                break;
        }
        return checkInAction;
    }
    
    /**
     * If user input is valid, instantiate objects to either check in a vehicle or close the garage.
     * @param action is user input action.
     * @param vehicle is ArrayList containing all the vehicle objects in the parking garage application.
     * @param specialEvent is boolean value that specifies whether the vehicle has checked in for a special event.
     */
    private void processCheckInInput(char action, ArrayList<Vehicle> vehicle, boolean specialEvent) {
        switch (action) {
            case '1':
            case '2':
                CheckIn checkIn = new CheckIn(vehicle, specialEvent);
                break;
            case '3':
                CloseGarage closeGarage = new CloseGarage(vehicle);
                break;
        }
    }

}
