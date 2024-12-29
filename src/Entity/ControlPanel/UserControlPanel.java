package Entity.ControlPanel;

import Entity.ControlPanel.ControlPanel;
import Entity.Mediator;

public class UserControlPanel implements ControlPanel {
    private Mediator mediator;

    public UserControlPanel() {
    }
    @Override
    public void openLights() {
        getMediator().regulateLightBulb(true);
    }

    @Override
    public void closeLights() {
        getMediator().regulateLightBulb(false);
    }

    @Override
    public void lockTheDoor() {
        getMediator().regulateDoorLock(false);
    }

    @Override
    public void unlockTheDoor() {
        getMediator().regulateDoorLock(true);
    }
    private Mediator getMediator() {
        return mediator;
    }
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
