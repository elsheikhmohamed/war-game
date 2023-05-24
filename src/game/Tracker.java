package game;

import Models.Trump;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Trump trump;
    public Tracker(GameView view, Trump trump) {
        this.view = view;
        this.trump = trump;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(trump.getPosition()));
    }
}