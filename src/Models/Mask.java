package Models;

import Collision.MaskCollision;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Mask extends DynamicBody {
    private static int maskCount =0;

    private static final Shape MaskShape = new CircleShape(1f);

    private static final BodyImage image =
            new BodyImage("data/img/mask.png", 2f);

    private static SoundClip MaskSound;
    static {
        try {
            MaskSound = new SoundClip("data/music/mask.wav");
            MaskSound.setVolume(0.4);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /***
     * timer to respawn mask down from the top of the screen
     * @param w displays world
     */
    public Mask(World w) {
        super(w, MaskShape);
        addImage(image);
        float x = (float) Math.random()*20; // to make masks respawn from the sky in different locations
        setPosition(new Vec2(x, 10));
        MaskCollision FlagDes = new MaskCollision(this);  // creates a new mask
        this.addCollisionListener(FlagDes); // makes the mask disappear whenever it hits the ground
    }

    /***
     * mask count increases by 1 everytime it gets hit by covid
     */
    public void DestroyMask(){
        maskCount++;
        MaskSound.play(); // plays the sound of the mask event
        this.destroy();
    }

    public static int getMaskCount() {return maskCount;}
    public void setMaskCount(int mc){
        maskCount = mc;
    }


}