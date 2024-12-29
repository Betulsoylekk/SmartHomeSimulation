package Entity.Actuator;

import Entity.Actuator.Actuator;

public class LightBulb implements Actuator {
    private boolean isOpen;
    public LightBulb() {
        this.isOpen = false;
    }
    @Override
    // Validate the value, if it passes validations, perform the action.
    // Otherwise, print current situation!
    public Boolean performAction(Object shouldLightOpen) {
        boolean lightShouldBeOpenAndLightIsAlreadyOpen = (Boolean) shouldLightOpen && getIsOpen();
        boolean lightShouldNotBeOpenAndLightIsNotOpen = (!(Boolean) shouldLightOpen && !getIsOpen());
        if(lightShouldBeOpenAndLightIsAlreadyOpen || lightShouldNotBeOpenAndLightIsNotOpen){
            return getIsOpen();
        }
        setIsOpen((Boolean) shouldLightOpen);
        return getIsOpen();
    }

    private boolean getIsOpen() {
        return this.isOpen;
    }

    private void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
