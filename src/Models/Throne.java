package Models;

import Levels.GameLevel;
import city.cs.engine.*;

public class Throne extends StaticBody {
    private static Boolean throneCollide;

    private static final Shape thronShape = new PolygonShape(
            -0.96f,2.21f, -2.53f,0.02f,
            -2.84f,-3.95f, 3.18f,-3.97f,
            2.35f,-0.47f, 0.63f,2.84f);

    private static final BodyImage image =
            new BodyImage("data/img/throne.png", 9f);

    public Throne(GameLevel w) {
        super(w,thronShape);
        addImage(image);
        throneCollide = true; // check the collision of the White House
    }

    public static Boolean getHouseCollide() {
        return throneCollide;
    }
}