package Models;

import Collision.CovidCollision;
import Levels.GameLevel;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Covid extends DynamicBody {

    private static final Shape CovidShape = new CircleShape(.5f);

    private static final BodyImage image =
            new BodyImage("data/img/covid.png", 2f);

    public Covid(GameLevel w) {
        super(w,CovidShape);
        addImage(image);
        Vec2 trupPos = w.getTrump().getPosition(); // covid img respawns from Trump
        setPosition(trupPos);

        CovidCollision CovidColli = new CovidCollision(this);
        this.addCollisionListener(CovidColli);

    }
}