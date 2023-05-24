package game;

import Levels.GameLevel;
import Models.Covid;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private GameLevel world;
    private GameView view;

    public MouseHandler(GameLevel w, GameView v){
        world = w;
        view = v;
    }

    @Override
    public void mousePressed(MouseEvent e) {
       Point point = e.getPoint(); // gets the point of the mouse
       Vec2 vec =  view.viewToWorld(point);  // making it as a vector

       Covid covid = new Covid(world);
       vec = vec.sub(covid.getPosition());
       covid.setLinearVelocity(vec.mul(2)); // speed of covid coming out
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
