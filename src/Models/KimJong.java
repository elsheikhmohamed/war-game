package Models;

import city.cs.engine.*;

public class KimJong extends Walker {

    private static final Shape KimJongShape = new PolygonShape(
            0.64f,2.86f, -0.08f,-0.14f, 0.06f,-4.39f,
            2.38f,-4.3f, 2.62f,0.23f, 1.52f,2.83f);

    private static final BodyImage image =
            new BodyImage("data/img/kimJong.png", 9.1f);


    public KimJong(World world) {
        super(world, KimJongShape);
        addImage(image);
    }
}
