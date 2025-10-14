package coconuts;

import javafx.scene.layout.Pane;

public class ObservingDisplay implements DisappearObserver {
    private final Pane gamePane;

    public ObservingDisplay(Pane gamePane) {
        this.gamePane = gamePane;
    }

    @Override
    public void DUpdate(IslandObject obj) {
        if (obj.getImageView() != null) {
            gamePane.getChildren().remove(obj.getImageView());
        }
    }
}