package Entity;

public interface Mediator {
    void regulateTemperature();
    void regulateLightBulb(boolean shouldLightOpen);
    void regulateDoorLock(boolean shouldDoorUnlocked);
    void displayResults();
}
