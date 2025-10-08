package coconuts;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

// An abstraction of all objects that can be hit by another object
// This captures the Subject side of the Observer pattern; observers of the hit event will take action
//   to process that event
// This is a domain class; do not introduce JavaFX or other GUI components here
public class HitEvent {
    private final IslandObject hitter;
    private final IslandObject target;
    private final int eventType;
    public static final int COCONUT_DESTROYED = 0;
    public static final int COCONUT_HIT_BEACH = 1;
    public static final int COCONUT_HIT_CRAB = 2;

    public HitEvent(int eventType, IslandObject hitter, IslandObject target){
        this.hitter = hitter;
        this.target = target;
        this.eventType = eventType;
    }

    public int getEventType(){
        return eventType;
    }

    public IslandObject getHitter(){
        return hitter;
    }

    public IslandObject getTarget(){
        return target;
    }
}
