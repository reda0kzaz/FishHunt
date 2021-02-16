package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet {

    private double posX, posY;
    private double vitesse, rayon;
    private Color colour;

    public Bullet(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
        this.vitesse = -300;
        this.rayon = 50;
        this.colour = Color.BLACK;
    }

    public void update(double deltaTime){this.rayon += this.vitesse * deltaTime;}

    public void drawBullet(GraphicsContext context){
        GraphicsContext contextGame = FishHuntSubScene.getContextGame();

        contextGame.setFill(this.colour);
        double newPosX = this.posX - this.rayon;
        double newPosY = this.posY - this.rayon;
        contextGame.fillOval(newPosX, newPosY, 2 * this.rayon, 2 * this.rayon);
    }

}