package Helper;

import Entity.ControlPanel.ControlPanel;
import Entity.Mediator;
import Entity.User;
import Entity.ControlPanel.UserControlPanel;

public class Simulation {
    static final int SIMULATION_DURATION = 20;
    static final int INITIAL_MAXIMUM_TEMP_VALUE = 25;
    static final int INITIAL_MINIMUM_TEMP_VALUE = 20;
    public void run(){
        Helper helper = new Helper();
        helper.display("***- Simulation has been started -***");
        Mediator smartHome = helper.setUpMediator();
        ControlPanel userControlPanel = new UserControlPanel();
        userControlPanel.setMediator(smartHome);
        User user = new User(userControlPanel);
        for (int i = 0; i < SIMULATION_DURATION; i++) {
            // Counter
            helper.display("---------- " + (i + 1)  + " seconds has passed ----------" );
            // Control panel directives from user
            // Helper calculates the possibility for user action if it is true user sends a command
            boolean shouldUserUpdateDoor = Helper.generateRandBooleanValue();
            boolean shouldUserUpdateLightBulb = Helper.generateRandBooleanValue();

            // Checks initial temperature and performs action accordingly
            smartHome.regulateTemperature();

            // If user wants to change something from control panel, program accepts user value.
            // User Light Command
            if(shouldUserUpdateLightBulb){
                // Light Command is decided randomly
                if (Helper.generateRandBooleanValue()) {
                    user.openLights();
                } else {
                    user.closeLights();
                }
            }
            // User Door Command
            if (shouldUserUpdateDoor) {
                // Door Command is decided randomly
                if (Helper.generateRandBooleanValue()) {
                    user.unlockTheDoor();
                } else {
                    user.lockTheDoor();
                }
            }
            smartHome.displayResults();
        }
        helper.display("***- Simulation has been halted -***");
    }
}
