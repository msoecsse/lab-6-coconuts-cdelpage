package coconuts;


// An abstraction of all objects that can be hit by another object
// This captures the Subject side of the Observer pattern; observers of the hit event will take action
//   to process that event
// This is a domain class; do not introduce JavaFX or other GUI components here
public class HitEvent {
    private final int eventType;
    public static final int COCONUT_DESTROYED = 0;
    public static final int COCONUT_HIT_BEACH = 1;
    public static final int COCONUT_HIT_CRAB = 2;

    public HitEvent(int eventType, IslandObject hitter, IslandObject target){
        this.eventType = eventType;
    }

    public int getEventType(){
        return eventType;
    }
}
