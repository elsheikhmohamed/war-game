package game;

import Levels.*;
import Models.Biden;
import Models.Mask;
import Models.KoreaTank;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image lvlBg;
    private static KoreaTank tank;
    private static Mask mask;
    private static Biden biden;
    private static Level4 level4;
    private GameLevel level = Game.getLevel();
    public GameView(World w, int width, int height) {
        super(w, width, height);

        // check the level to change the background accordingly
        if (Game.level instanceof Level1){
            lvlBg = new ImageIcon("data/img/background.gif").getImage();
        }
        else if (Game.level instanceof Level2){
            lvlBg = new ImageIcon("data/img/bg1.jpg").getImage();
        }
        else if (Game.level instanceof Level3){
            lvlBg = new ImageIcon("data/img/bg2.png").getImage();
        }
        else if (Game.level instanceof Level4){
            lvlBg = new ImageIcon("data/img/bg3.jpg").getImage();
        }

    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(lvlBg, 0, 0, this);
    }

    @Override
    public void paintForeground(Graphics2D g) {
        if (Game.level instanceof Level1){
            g.setColor(Color.WHITE);
            g.drawString("Rocket count:" + tank.getRocketCount() ,5,15);
            g.drawString("Hit Korea's tank with 3 rockets and meet Kim",5,27);
            g.drawString("A&D to control Trump and Q to shot rockets", 5,41);
        }
        else if (Game.level instanceof Level2){
            g.setColor(Color.BLACK);
            g.drawString("Mask count:" + mask.getMaskCount() ,5,15);
            g.drawString("Hit at least 5 masks using the LeftClick and go to the right end of the screen",5,27);
        }
        else if (Game.level instanceof Level3){
            g.setColor(Color.BLACK);
            g.drawString("Go to the White House" ,5,15);
        }
        else if (Game.level instanceof Level4){
            g.setColor(Color.BLACK);
            g.drawString("Biden's HP " + biden.getBidenHealth() ,5,15);
            g.drawString("Kill Biden using the LeftClick and go sit on the Throne",5,27);
        }

    }
}