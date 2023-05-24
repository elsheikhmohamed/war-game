package Models;

import city.cs.engine.*;

public class Portal extends StaticBody {

    private static final Shape PortalShape = new PolygonShape(
            -0.02f,3.25f, -1.41f,0.0f, -0.82f,-3.63f,
            0.98f,-3.7f, 1.52f,0.3f, 0.4f,3.23f);

    private static final BodyImage image =
            new BodyImage("data/img/portal.png", 9.1f);


    public Portal(World world) {
        super(world, PortalShape);
        addImage(image);
    }
}
