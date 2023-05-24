package Models;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class KoreaTank extends StaticBody {
    private static int rocketCount=0;

    private static final Shape usaTankShape = new PolygonShape(
            -3.96f,1.15f, -3.52f,-3.28f, 6.87f,-3.28f, 6.07f,0.28f, -2.62f,1.55f);

    private static final BodyImage image =
            new BodyImage("data/img/korea-tank.png", 7f);

    private static SoundClip tankSound;
    static {
        try {
            tankSound = new SoundClip("data/music/pewpew.wav");
            tankSound.setVolume(0.3);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public KoreaTank(World world) {
        super(world, usaTankShape);
        addImage(image);

    }

    public void addRockets(){
        rocketCount++;
        tankSound.play();
        if (rocketCount == 3){ // if the tank takes 3 rockets then it disappears
            this.destroy();

        }
    }

    public static int getRocketCount(){
        return rocketCount;
    }
    public void setRocketCount(int rc){
        rocketCount = rc;
    }


}
