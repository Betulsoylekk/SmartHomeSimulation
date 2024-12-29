package Entity.Sensor;

import Helper.Helper;

public class MotionSensor implements Sensor {
    // If is motion detected door is unlocked
    // Otherwise, door is locked and motion is not detected.
    private boolean isMotionDetected;

    public MotionSensor() {
        this.isMotionDetected = false;
    }

    @Override
    public Boolean getSensedValue() {
        return this.isMotionDetected;
    }
    // If is motion detected door is unlocked
    // Otherwise, door is locked and motion is not detected.
    @Override
    public void setSensedValue(Object shouldDoorUnlock) {
        this.isMotionDetected = (Boolean) shouldDoorUnlock;
    }
}
