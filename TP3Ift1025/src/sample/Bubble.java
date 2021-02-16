package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

/* La classe CreerBulle permet la construction et création d'une bulle
 *   Développé par : Reda Laalej et Reda Kzaz
 *   Date: 14-04-2020
 * */

public class Bubble {
    private double x, y;
    private double vy;
    private int rayon;
    private Color colour;
    private Random random;
    private double width =350;

    public Bubble(double x, double y){
        this.random = new Random();
        this.x = x;
        this.y = y;
        this.vy = -(this.random.nextDouble() * 100 + width);
        colour = Color.rgb(0,0, 255, 0.4);
        rayon = random.nextInt(31) + 10;
    }

    public void update(double dt) {this.y += dt * this.vy;}

    public void draw(GraphicsContext context, double fenetreX, double fenetreY){
        double xAffiche = this.x - fenetreX;
        double yAffiche = this.y - fenetreY;
        context.setFill(this.colour);
        context.fillOval(xAffiche, yAffiche, rayon, rayon);
    }
}