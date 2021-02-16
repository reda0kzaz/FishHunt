package sample;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Random;

public class NormalFish extends Fish {
    private boolean startRight;//De quel cote le Fish va commencer
    protected boolean isAlive ;
    private double frameRate = 8; // 8 frame par sec
    private double tempsTotal = 0;
    private Image[] framesR, framesL;
    private Image image;
    private boolean isRight;//vue du poisson

    public NormalFish(int level){
        super(level);
        Random random = new Random();
//        //r.nextInt((max - min) + 1) + min;
//        this.width = random.nextInt(120 - 79) + 80;
//        this.height = this.width ;
//        // min + (max - min) * r.nextDouble();
//        this.y = (0.2+(0.8-0.2)*random.nextDouble())*FishHunt.getHeight() ;
//        this.ax = 0;
//        this.ay = -100;
//        this.vy = random.nextInt(-100 +201) -200 ;
        framesL =  new Image[]{
                new Image("/sample/00.png"),
                new Image("/sample/01.png"),
                new Image("/sample/02.png"),
                new Image("/sample/03.png"),
                new Image("/sample/04.png"),
                new Image("/sample/05.png"),
                new Image("/sample/06.png"),
                new Image("/sample/07.png")
        };
        int randImage = random.nextInt(8);
        image = this.framesL[randImage];
//        double randomGenerator = Math.random();
//        if(randomGenerator > 0.5){
//            this.x = -this.width/2;
//            this.startRight = false ;
//        }else{
//            this.x = FishHunt.getHeight() +this.width/2 ;
//            this.startRight = true ;
//        }
//        double randomR = random.nextDouble();
//        double randomG = random.nextDouble();
//        double randomB = random.nextDouble();
//        this.colour = new Color(randomR, randomG, randomB, 1);
//
//        if(this.startRight == false){
//            image = ImageHelpers.flop(image);
//        }
//
//        image = ImageHelpers.colorize(image, colour);


    }


    //    public void initializeSpeed(int level, boolean startRight){
//        if(!startRight) {
//            this.vx = 100*Math.pow(level, 1/3) + 200 ;
//        }
//        else{
//            this.vx = -100*Math.pow(level, 1/3) + 200 ;
//        }
//    }
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }
}