package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class Controller {
    GameModel gameModel;

    public Controller(){gameModel = new GameModel();}

    public void drawCible(ImageView imageViewCible, double x, double y) {gameModel.drawCible(imageViewCible, x,y);}

    public void drawBullet(double x, double y) {gameModel.drawBullet(x,y);}

    public void update(double deltaTime) {gameModel.update(deltaTime);}

    public void draw(GraphicsContext context) {gameModel.draw(context);}
}
