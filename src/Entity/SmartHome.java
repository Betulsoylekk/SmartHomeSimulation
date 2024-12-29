package Entity;

import Entity.Actuator.DoorLock;
import Entity.Actuator.LightBulb;
import Entity.Actuator.Thermostat;
import Entity.Sensor.LightSensor;
import Entity.Sensor.MotionSensor;
import Entity.Sensor.Sensor;
import Entity.Sensor.TemperatureSensor;
import Helper.Helper;

public class SmartHome implements Mediator{
    private Sensor temperatureSensor;
    private Sensor lightSensor;
    private Sensor motionSensor;
    private Thermostat thermostat;
    private LightBulb lightBulb;
    private DoorLock doorLock;

    public SmartHome(Sensor temperatureSensor, Sensor lightSensor, Sensor motionSensor, Thermostat thermostat, LightBulb lightBulb, DoorLock doorLock) {
        this.temperatureSensor = temperatureSensor;
        this.lightSensor = lightSensor;
        this.motionSensor = motionSensor;
        this.thermostat = thermostat;
        this.lightBulb = lightBulb;
        this.doorLock = doorLock;
        // Display initial results
        this.displayResults();
    }
    public void regulateTemperature(){
        int currentTemperatureValue = getTemperatureSensor().getSensedValue();
        int updatedTemperatureValue = getThermostat().performAction(currentTemperatureValue);
        getTemperatureSensor().setSensedValue(updatedTemperatureValue);
    }
    public void regulateLightBulb(boolean shouldLightOpen) {
        getLightSensor().setSensedValue(shouldLightOpen);
        getLightBulb().performAction(shouldLightOpen);
    }
    public void regulateDoorLock(boolean shouldDoorUnlocked){
        getMotionSensor().setSensedValue(shouldDoorUnlocked);
        getDoorLock().performAction(shouldDoorUnlocked);
    }
    public DoorLock getDoorLock() {
        return doorLock;
    }
    public LightSensor getLightSensor() {
        return (LightSensor) lightSensor;
    }
    public TemperatureSensor getTemperatureSensor() {
        return (TemperatureSensor) temperatureSensor;
    }
    public MotionSensor getMotionSensor() {
        return (MotionSensor) motionSensor;
    }
    public Thermostat getThermostat() {
        return thermostat;
    }
    public LightBulb getLightBulb() {
        return lightBulb;
    }
    public void displayResults(){
        Helper.display("Temperature: " + getTemperatureSensor().getSensedValue() + ", Thermostat State: " + getThermostat().getCurrentState());
        Helper.display("Light: " + (getLightSensor().getSensedValue() ? "open" : "closed"));
        Helper.display("Door: " + (getMotionSensor().getSensedValue() ? "unlocked" : "locked"));
    }
}
