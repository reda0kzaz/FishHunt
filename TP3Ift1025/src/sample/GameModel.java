package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.Random;

/* Le GameModel est le nerf vivant du jeu, il permet de faire toutes les intéractions nécéssaires au bon déroulement
   de ou des parties lancées. Il s'occupe essentiellement de déterminer les positions des différentes composantes du
   jeu et aussi de faire la mise à jour au fur et à mesure que l'on avance.

 *   Développé par : Reda Laalej et Reda Kzaz
 *   Date: 14-04-2020
 * */

public class GameModel {

    private GroupBubbles[] bubbles;
    private static double posEcranY = 0;
    private double showBubbles = 0;
    private Bullet[] bullet = new Bullet[10];
    private int a = 0;

    public GameModel(){

        bubbles = new GroupBubbles[3];

        //Générer 3 groupes de 5 bulles dans les listes de bulles
        for(int i = 0; i < 3 ; i++){
            bubbles[i] = new GroupBubbles(posEcranY);
        }
    }

    public void drawCible(ImageView imageViewCible, double x, double y) {
        double weight = imageViewCible.getBoundsInLocal().getWidth();
        double height = imageViewCible.getBoundsInLocal().getHeight();
        double newX = x - (weight / 2);
        double newY = y - (height / 2);
        imageViewCible.setX(newX);
        imageViewCible.setY(newY);
    }

    public void drawBullet(double x, double y) {
        bullet[a%10] = new Bullet(x,y);
        a++;
    }

    public void update(double deltaTime) {

        //Mise a jour des bulles
        for(int i = 0; i < 3; i++){
            bubbles[i].update(deltaTime);
        }

        //A chaque 3 secondes, on regenère les bulles
        showBubbles += deltaTime;
        if(showBubbles > 3){
            for(int j = 0; j < 3; j++){
                bubbles[j] = new GroupBubbles(posEcranY);
            }
            showBubbles = 0;
        }

        //Mise a jour de la balle
        for(int i = 0; i < Math.min(a, 10); i++){
            this.bullet[i].update(deltaTime);
        }
    }

    public void draw(GraphicsContext context) {
        GraphicsContext contextGame = FishHuntSubScene.getContextGame();
//        //dessiner les bulles
//        for(int i = 0; i < 3; i++){
//            bubbles[i].draw(contextGame, 100, posEcranY);
//        }

        for(int i = 0; i < Math.min(a, 10); i++){
            this.bullet[i].drawBullet(contextGame);
        }

        contextGame.setFill(Color.WHITE);
        contextGame.setFont(new Font(25));
        contextGame.fillText("200m", 250, 50);


    }


}