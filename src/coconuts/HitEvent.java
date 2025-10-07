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
public class HitEvent implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final IslandObject hitter;
    private final IslandObject target;

    public HitEvent(IslandObject hitter, IslandObject target){
        this.hitter = hitter;
        this.target = target;
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllObservers(HitEvent e) {
        for(Observer o : observers){
            o.update(e);
        }
    }

    public IslandObject getHitter(){
        return hitter;
    }

    public IslandObject getTarget(){
        return target;
    }
}
