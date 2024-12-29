package Entity.Sensor;

import Helper.Helper;

public class LightSensor implements Sensor {
    private boolean isOpen;
    public LightSensor() {
        this.isOpen = false;
    }
    @Override
    public Boolean getSensedValue() {
        return isOpen;
    }
    @Override
    public void setSensedValue(Object sensedValue) {
        this.isOpen = (Boolean) sensedValue;
    }
}
