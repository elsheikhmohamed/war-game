package Models;

import Levels.GameLevel;
import city.cs.engine.*;

public class WhiteHouse extends StaticBody {
    private static Boolean houseCollide;

    private static final Shape houseShape = new PolygonShape(
            -2.21f,1.34f, -3.66f,-0.34f, -1.26f,-2.03f,
            1.52f,-2.02f, 3.63f,-0.82f, 1.39f,1.58f, -1.39f,1.63f);

    private static final BodyImage image =
            new BodyImage("data/img/whiteHouse.png", 6f);

    public WhiteHouse(GameLevel w) {
        super(w,houseShape);
        addImage(image);
        houseCollide = true; // check the collision of the White House
    }

    public static Boolean getHouseCollide() {
        return houseCollide;
    }
}