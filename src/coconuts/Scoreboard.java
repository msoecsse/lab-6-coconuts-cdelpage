package coconuts;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Scoreboard extends VBox implements Observer {
    private int coconutsDestroyed = 0;
    private int coconutsHitBeach = 0;
    private Label destroyedLabel = new Label("Coconuts Destroyed: 0");
    private Label hitBeachLabel = new Label("Coconuts Hit Beach: 0");
    private Label titleLabel = new Label("Scoreboard");

    public Scoreboard() {
        this.getChildren().addAll(titleLabel,destroyedLabel,hitBeachLabel);
        this.setStyle("-fx-padding: 10; -fx-background-color: lightyellow; -fx-border-color: brown;");
    }

    @Override
    public void update(HitEvent e){
        int eventType = e.getEventType();
        if(eventType == HitEvent.COCONUT_DESTROYED){
            coconutsDestroyed++;
            Platform.runLater(() -> destroyedLabel.setText("Coconuts Destroyed: "+ coconutsDestroyed));
        } else if (eventType == HitEvent.COCONUT_HIT_BEACH) {
            coconutsHitBeach++;
            Platform.runLater(() -> hitBeachLabel.setText("Coconuts Hit Beach: "+ coconutsHitBeach));
        } // TODO ADD HITTING CRAB TO END GAME LATER
    }
}
