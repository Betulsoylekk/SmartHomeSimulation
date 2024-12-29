package Helper;

import Entity.*;
import Entity.Actuator.DoorLock;
import Entity.Actuator.LightBulb;
import Entity.Actuator.Thermostat;
import Entity.Sensor.LightSensor;
import Entity.Sensor.MotionSensor;
import Entity.Sensor.Sensor;
import Entity.Sensor.TemperatureSensor;

import java.util.Random;

public class Helper {
    private static final int INITIAL_MAXIMUM_TEMP_VALUE = Simulation.INITIAL_MAXIMUM_TEMP_VALUE;
    private static final int INITIAL_MINIMUM_TEMP_VALUE = Simulation.INITIAL_MINIMUM_TEMP_VALUE;
    private static final int DURATION = Simulation.SIMULATION_DURATION;
    private static Random random = new Random();
    public Helper(){
    }
    public static int generateRandTemperatureValue(){
        return random.nextInt(INITIAL_MINIMUM_TEMP_VALUE - DURATION,INITIAL_MAXIMUM_TEMP_VALUE + DURATION);
    }
    public static boolean generateRandBooleanValue(){
        return random.nextBoolean();
    }

    public static void display(String context){
        System.out.println(context);
    }
    public static Mediator setUpMediator(){
        Sensor temperatureSensor = new TemperatureSensor(generateRandTemperatureValue());
        Sensor lightSensor = new LightSensor();
        Sensor motionSensor = new MotionSensor();
        Thermostat thermostat = new Thermostat(INITIAL_MINIMUM_TEMP_VALUE, INITIAL_MAXIMUM_TEMP_VALUE);
        LightBulb lightBulb = new LightBulb();
        DoorLock doorLock = new DoorLock();
        Mediator smartHome = new SmartHome(temperatureSensor,lightSensor,motionSensor,thermostat,lightBulb,doorLock);
        return smartHome;
    }
}
