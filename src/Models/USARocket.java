package Models;

import city.cs.engine.*;

public class USARocket extends DynamicBody {

    private static final Shape booksShape = new CircleShape(1.6f);

    private static final BodyImage image =
            new BodyImage("data/img/TrumpRocket.png", 5f);

    public USARocket(World w) {
        super(w,booksShape);
        addImage(image);

    }
}