package coconuts;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import java.util.Objects;


// JavaFX Controller class for the game - generally, JavaFX elements (other than Image) should be here
public class GameController {

    /**
     * Time between calls to step() (ms)
     */
    private static final double MILLISECONDS_PER_STEP = 1000.0 / 30;
    private Timeline coconutTimeline;
    private boolean started = false;
    private final AudioClip laserSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/sounds/laser-gun-81720.mp3")).toString());


    @FXML
    private Pane gamePane;
    @FXML
    private Pane theBeach;
    private OhCoconutsGameManager theGame;
    @FXML private Label scoreLabel;
    @FXML private Label coconutsCaughtLabel;
    @FXML private Label coconutsDestroyedLabel;

    @FXML
    public void initialize() {
        theGame = new OhCoconutsGameManager((int) (gamePane.getPrefHeight() - theBeach.getPrefHeight()),
                (int) (gamePane.getPrefWidth()), gamePane);
        Scoreboard scoreboard = new Scoreboard(scoreLabel, coconutsCaughtLabel, coconutsDestroyedLabel);
        theGame.attach(scoreboard);

        gamePane.setFocusTraversable(true);

        coconutTimeline = new Timeline(new KeyFrame(Duration.millis(MILLISECONDS_PER_STEP), (_) -> {
            theGame.tryDropCoconut();
            theGame.advanceOneTick();
            if (theGame.done()) {
                coconutTimeline.pause();
                theGame.detach(Objects.requireNonNull(scoreboard));
            }
        }));
        coconutTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    @FXML
    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.RIGHT && !theGame.done()) {
            if(theGame.getCrab() != null) {
                theGame.getCrab().crawl(10);
            }
        } else if (keyEvent.getCode() == KeyCode.LEFT && !theGame.done()) {
            if(theGame.getCrab() != null) {
                theGame.getCrab().crawl(-10);
            }
        } else if (keyEvent.getCode() == KeyCode.UP && !theGame.done()){
            if(theGame.getCrab() != null) {
                int eyeHeight = theGame.getCrab().getEyeHeight();
                int crabCenterX = theGame.getCrab().getCenterX();
                LaserBeam laser = new LaserBeam(theGame, eyeHeight, crabCenterX - 1);
                theGame.addObject(laser);
                laserSound.setVolume(.4);
                laserSound.play();
            }
        }else if (keyEvent.getCode() == KeyCode.SPACE) {
            if (!started) {
                coconutTimeline.play();
                started = true;
            } else {
                coconutTimeline.pause();
                started = false;
            }
        }
    }
}
