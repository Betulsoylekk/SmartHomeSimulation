package Entity.Actuator;

public class Thermostat implements Actuator {
    public STATE getCurrentState() {
        return currentState;
    }
    enum STATE{
        STANDBY,
        COOLING,
        HEATING
    }
    private final int desiredTemperatureLowValue;
    private final int desiredTemperatureHighValue;
    private STATE currentState;

    public Thermostat(int desiredTemperatureLowValue, int desiredTemperatureHighValue) {
        this.currentState = STATE.STANDBY;
        this.desiredTemperatureLowValue = desiredTemperatureLowValue;
        this.desiredTemperatureHighValue = desiredTemperatureHighValue;
    }
    @Override
    // Validate the value, perform the action accordingly.
    // Then send to display to print current situation!
    public Integer performAction(Object desiredValue) {
        // Validation
        boolean isTemperatureInDesiredRange = getDesiredTemperatureLowValue() <= (Integer) desiredValue && (Integer) desiredValue <= getDesiredTemperatureHighValue();

        // Standby state
        if(isTemperatureInDesiredRange){
            this.deactivateTheThermostat();
            return (Integer) desiredValue;
        }
        // Heating state
        if((Integer) desiredValue < getDesiredTemperatureLowValue()){
            this.activateHeatingState();
            // Increase temperature
            return (Integer) desiredValue + 1;
        }
        // Cooling state
        else{
            this.activateCoolingState();
            // Decrease temperature
            return (Integer) desiredValue - 1;
        }
    }
    private void activateHeatingState(){
        this.currentState = STATE.HEATING;
    }

    private void activateCoolingState(){
        this.currentState = STATE.COOLING;
    }
    private void deactivateTheThermostat(){
        this.currentState = STATE.STANDBY;
    }
    private int getDesiredTemperatureHighValue() {
        return desiredTemperatureHighValue;
    }
    private int getDesiredTemperatureLowValue() {
        return desiredTemperatureLowValue;
    }
}