package coconuts;

import java.util.ArrayList;
import java.util.List;

public class DisappearManager implements DisappearSubject {
    private final List<DisappearObserver> observers = new ArrayList<>();

    @Override
    public void DAttach(DisappearObserver o) {
        observers.add(o);
    }

    @Override
    public void DDetach(DisappearObserver o) {
        observers.remove(o);
    }

    @Override
    public void DNotifyAllObservers(IslandObject obj) {
        for (DisappearObserver o : observers) {
            o.DUpdate(obj);
        }
    }
}
