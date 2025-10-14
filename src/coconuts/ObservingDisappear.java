package coconuts;

import javafx.scene.layout.Pane;

public class ObservingDisappear implements DisappearObserver {
    private final Pane gamePane;

    public ObservingDisappear(Pane gamePane) {
        this.gamePane = gamePane;
    }

    @Override
    public void DUpdate(IslandObject obj) {
        if (obj.getImageView() != null) {
            gamePane.getChildren().remove(obj.getImageView());
        }
    }
}