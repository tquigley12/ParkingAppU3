package parkingapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class tests a suite of classes and methods in the parkingapp package.
 * 
 * @author tquigley1
 */
@RunWith (Suite.class)
@Suite.SuiteClasses (
        {
            ParkingAppTest.class,
            CheckInTest.class,
            CheckOutTest.class,
            CloseGarageTest.class

        }
)
        
public class MyTestSuite {
    
}
