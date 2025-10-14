package coconuts;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Scoreboard extends VBox implements Observer {
    private int coconutsDestroyed = 0;
    private int coconutsHitBeach = 0;
    private Label destroyedLabel;
    private Label hitBeachLabel;
    private Label scoreLabel;

    public Scoreboard(Label scoreLabel, Label hitBeachLabel, Label destroyedLabel) {
        this.scoreLabel = scoreLabel;
        this.hitBeachLabel = hitBeachLabel;
        this.destroyedLabel = destroyedLabel;
    }

    public Scoreboard() {
        this.scoreLabel = new Label("Score: 0");
        this.hitBeachLabel = new Label("Coconuts Hit Beach: 0");
        this.destroyedLabel = new Label("Coconuts Destroyed: 0");
        this.getChildren().addAll(scoreLabel,destroyedLabel,hitBeachLabel);
    }

    @Override
    public void update(HitEvent e){
        boolean gameover = false;
        int eventType = e.getEventType();
        if(eventType == HitEvent.COCONUT_DESTROYED){
            coconutsDestroyed++;
            Platform.runLater(() -> destroyedLabel.setText("Coconuts Destroyed: "+ coconutsDestroyed));
        } else if (eventType == HitEvent.COCONUT_HIT_BEACH) {
            coconutsHitBeach++;
            Platform.runLater(() -> hitBeachLabel.setText("Coconuts Hit Beach: "+ coconutsHitBeach));
        } else if (eventType == HitEvent.COCONUT_HIT_CRAB){
            // TODO ADD HITTING CRAB TO END GAME LATER
            gameover = true;
        }
        int totalScore = coconutsDestroyed * 10 - coconutsHitBeach * 2;
        if(gameover){
            Platform.runLater(() -> scoreLabel.setText("Score: "+totalScore+" GAME OVER WOMPWOMP"));
        } else{
            Platform.runLater(() -> scoreLabel.setText("Score: "+totalScore));
        }
    }
}
