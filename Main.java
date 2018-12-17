package faketaxi;

/**
 *
 * @author carloschavez
 * FINAL PROJECT FOR CIS 112
 * SIMULATION OF UBER
 * Date: December 16, 2018
 */
public class Main {
    
    public static void main(String[] args) {
        //loads FakeTaxi
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(FakeTaxi.class);
            }
        }.start();
        FakeTaxi startUpTest = FakeTaxi.waitForStartUpTest();
        
    }
}

