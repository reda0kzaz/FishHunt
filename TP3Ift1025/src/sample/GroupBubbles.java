package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Random;

/* La classe GroupeBulles permet la création de 3 groupes de  5 bulles chacune
 *   Développé par : Reda Laalej et Reda Kzaz
 *   Date: 14-04-2020
 * */

public class GroupBubbles {
    private double posBubbleX, posBubbleY;
    private ArrayList<Bubble> bubbles;
    private Random random;
    private double posBulleInitiale = 500, width = 350;

    public GroupBubbles(double fenetreY){
        random = new Random();
        posBubbleX = (double) this.random.nextDouble() * width;
        posBubbleY = fenetreY + posBulleInitiale;
        bubbles = new ArrayList<>();

        for(int i=0; i<5; i++){
            bubbles.add(new Bubble(posBubbleX + random.nextDouble() * 41 - 20, posBubbleY));
        }
    }

    public void update(double dt){
        for (Bubble bubble : bubbles){
            bubble.update(dt);
        }
    }

    public void draw(GraphicsContext context, double fenetreX, double fenetreY){
        for (Bubble bubble : bubbles){
            bubble.draw(context, fenetreX, fenetreY);
        }
    }
}