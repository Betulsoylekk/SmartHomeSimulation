package Entity.Sensor;

public class TemperatureSensor implements Sensor {
    private int currentTemperature;
    public TemperatureSensor(int initialTemperature) {
        this.currentTemperature = initialTemperature;
    }

    @Override
    public Integer getSensedValue() {
        return this.currentTemperature;
    }

    @Override
    public void setSensedValue(Object sensedValue) {
        this.currentTemperature = (Integer) sensedValue;
    }
}
