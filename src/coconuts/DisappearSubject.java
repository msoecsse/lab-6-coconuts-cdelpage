package coconuts;

public interface DisappearSubject {
    void DAttach(DisappearObserver o);
    void DDetach(DisappearObserver o);
    void DNotifyAllObservers(IslandObject obj);
}
