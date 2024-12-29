package Entity;

import Entity.ControlPanel.ControlPanel;

public class User {
    private ControlPanel controlPanel;
    public User(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }
    public void openLights(){
        controlPanel.openLights();
    };
    public void closeLights(){
        controlPanel.closeLights();
    };
    public void lockTheDoor(){controlPanel.lockTheDoor();};
    public void unlockTheDoor(){
        controlPanel.unlockTheDoor();
    };
}
