package coconuts;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Scoreboard extends VBox implements Observer {
    private int coconutsDestroyed;
    private int coconutsHitBeach;
    private Label destroyedLabel = new Label("Coconuts Destroyed: 0");
    private Label hitBeachLabel = new Label("Coconuts Hit Beach: 0");
    private Label titleLabel = new Label("Scoreboard");

    public Scoreboard() {
        this.getChildren().addAll(titleLabel,destroyedLabel,hitBeachLabel);
        this.setStyle("-fx-padding: 10; -fx-background-color: lightyellow; -fx-border-color: brown;");
    }

    @Override
    public void update(HitEvent e){
        IslandObject hitter = e.getHitter();
        IslandObject target = e.getTarget();

        if(hitter instanceof LaserBeam && target instanceof Coconut){
            coconutsDestroyed++;
            Platform.runLater(() ->
                    destroyedLabel.setText("Coconuts Destroyed: "+coconutsDestroyed));
        }

        if(hitter instanceof Beach && target instanceof Coconut){
            coconutsHitBeach++;
            Platform.runLater(() ->
                    destroyedLabel.setText("Coconuts Hit Beach: "+coconutsHitBeach));
        }
    }

}
