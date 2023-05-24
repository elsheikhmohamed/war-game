
package game;
import java.awt.*;
import java.lang.management.MemoryUsage;

import Control.ControlPanel;
import Control.KimController;
import Control.TrumpController;
import Control.USATankController;
import Levels.*;
import Models.Mask;

import javax.swing.*;

/**
 * A world with some bodies.
 */
public class Game {

    /**The World in which the bodies move and interact.*/
    public static GameLevel level;

    /**A graphical display of the world (a specialised JPanel).*/
    private static GameView view;
    private TrumpController trumpController;
    private KimController kimController;
    private USATankController usaTankController;
    public JFrame frame;

    /** Initialise a new Game.*/
    public Game() {

        // initialize level to Level1
        level = new Level1(this);

        // make a view
        view = new GameView(level, 800, 336);
        view.setZoom(16);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        view.addMouseListener(new MouseHandler(level, view));
        trumpController = new TrumpController(level.getTrump(),this);
        view.addKeyListener(trumpController);

        frame = new JFrame("Throne war");

        // make the game respond to the controller events

        kimController = new KimController(level.getKim());
        view.addKeyListener(kimController);

        usaTankController = new USATankController(level.getTank1());
        view.addKeyListener(usaTankController);
        view.addMouseListener(new GiveFocus(view));


        // add the view to a frame (Java top level window)
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // to display the GUI in the game
        ControlPanel controlPanel = new ControlPanel();
        frame.add(controlPanel.getMainPanel(), BorderLayout.NORTH);

        ImageIcon wIcon = new ImageIcon("data/img/w icon.png");
        frame.setIconImage(wIcon.getImage());

        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

//        uncomment this to make a debugging view
//        JFrame debugView = new DebugViewer(level, 800, 336);

        // start our game world simulation!
        level.start();
    }

    public void setLevel(GameLevel level){
        this.level.stop();
        this.frame.remove(view);
        this.view.setWorld(level);

        this.level = level;
        this.levelUpdates();
        this.level.start();
    }

    public void goToNextLevel(){
        // updates frame, game mode, and controller for Trump to be used in the next level
        if (level instanceof Level1){
            level.stop();
            frame.remove(view);
            GameLevel.gameMusic.stop();
            view.setWorld(level);
            level = new Level2(this);
            levelUpdates();
            level.start();
        }
        // updates frame, game mode, and controller for Trump to be used in the next level
        else if (level instanceof Level2){
            level.stop();
            frame.remove(view);
            GameLevel.gameMusic.stop();
            view.setWorld(level);
            level = new Level3(this);
            levelUpdates();
            level.start();
        }
        // updates frame, game mode, and controller for Trump to be used in the next level
        else if (level instanceof Level3){
            level.stop();
            frame.remove(view);
            GameLevel.gameMusic.stop();
            view.setWorld(level);
            level = new Level4(this);
            levelUpdates();
            level.start();
            System.out.println("Game completed");
        }
        else if (level instanceof Level4){
            JDialog diaScore = new JDialog(frame,true);
            HighScore highScore = new HighScore(this);
            diaScore.getContentPane().add(highScore.getPnlScores());
            diaScore.pack();
            diaScore.setVisible(true);


        }

    }

    private void levelUpdates() {
        view = new GameView(level, 800, 336);
        trumpController.updateTrump(level.getTrump());
        MouseHandler mh = new MouseHandler(level, view);
        view.addMouseListener(mh);
        view.addMouseListener(new GiveFocus(view));
        frame.add(view);
        view.setWorld(level);
        frame.pack();
        trumpController.updateTrump(level.getTrump());
        trumpController = new TrumpController(level.getTrump(),this);
        view.addKeyListener(trumpController);
    }

    public static GameLevel getLevel() {
        return level;
    }

    public static GameView getView() {
        return view;
    }
    public Mask getMask() {
        return level.getMask();
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();
    }

}
