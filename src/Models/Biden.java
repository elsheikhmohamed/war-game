package Models;

import city.cs.engine.*;
import city.cs.engine.Shape;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Biden extends StaticBody {

    private static int bidenHealth=7;
    private static SoundClip covidSound;

    private static final Shape BidenShape = new PolygonShape(
            -1.22f,3.1f, -1.42f,-0.3f, -0.93f,-3.73f,
            0.61f,-3.74f, 1.09f,-0.08f, 0.74f,3.06f, -0.69f,3.38f
    );

    private static final BodyImage image =
            new BodyImage("data/img/BidenStanding.png", 11f);
    private static final BodyImage image2 =
            new BodyImage("data/img/BidenLayingdown.png", 15f);

    static {
        try {
            covidSound = new SoundClip("data/music/covid.wav");
            covidSound.setVolume(0.3);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Biden(World world) {
        super(world, BidenShape);
        addImage(image);
    }
    public void decreaseHealth(){
        if (bidenHealth>0){ // it wont let it count down after it reaches zero
            bidenHealth--;  // decreases the health
        }
        covidSound.play();
        if (bidenHealth == 0) { // if Biden gets hit 7 times he dies
            covidSound.stop();
            this.removeAllImages(); // removes the current image
            this.addImage(image2); // replaces the current image with a new one


        }
    }
    public static int getBidenHealth() {
        return bidenHealth;
    }
}
