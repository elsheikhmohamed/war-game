package Models;

import city.cs.engine.*;

public class USATank extends StaticBody {

    private static final Shape usaTankShape = new PolygonShape(
            -0.72f,3.22f, -3.47f,0.35f, -3.34f,-3.04f,
            2.91f,-3.05f, 2.97f,1.15f, 1.15f,3.24f);

    private static final BodyImage image =
            new BodyImage("data/img/usa-tank.png", 7f);


    public USATank(World world) {
        super(world, usaTankShape);
        addImage(image);
    }
}
