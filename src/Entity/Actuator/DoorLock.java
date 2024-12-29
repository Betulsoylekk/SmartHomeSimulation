package Entity.Actuator;

public class DoorLock implements Actuator {
    private boolean isLocked;

    public DoorLock() {
        this.isLocked = true;
    }

    @Override
    // Validate the value, if it passes validations, perform the action.
    // Otherwise, print current situation!
    public Boolean performAction(Object shouldDoorUnlocked) {
        // Validations
        boolean theDoorShouldUnlockAndItIsAlreadyUnlocked = ((Boolean) shouldDoorUnlocked && !getIsLocked());
        boolean theDoorShouldNotUnlockAndItIsLocked = (!(Boolean)shouldDoorUnlocked && getIsLocked());
        // Control
        if(theDoorShouldUnlockAndItIsAlreadyUnlocked || theDoorShouldNotUnlockAndItIsLocked){
            return getIsLocked();
        }
        // Handle
        setIsLocked(!(Boolean)shouldDoorUnlocked);
        return getIsLocked();
    }
    private boolean getIsLocked() {
        return this.isLocked;
    }
    private void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
}
