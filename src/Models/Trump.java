package Models;

import city.cs.engine.*;

public class Trump extends Walker {
    private static final Shape studentShape = new PolygonShape(
            -0.06f,3.66f, -1.39f,1.6f, -1.04f,-3.84f,
            1.15f,-3.9f, 1.07f,-0.37f, 0.72f,3.33f);

    private static final BodyImage image =
            new BodyImage("data/img/trump.png", 8f);

    public Trump(World world) {
        super(world, studentShape);
        addImage(image);
    }
}