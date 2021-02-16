package sample;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Random;

public class Fish  {

    protected double width, height;
    protected double x, y;
    protected double vx, vy;
    protected double ax, ay;
    protected int level ;
    protected Color colour;
    protected Image image;
    protected boolean startRight;

    public Fish(int level) {
        Random random = new Random();
        //r.nextInt((max - min) + 1) + min;
        this.width = random.nextInt(120 - 79) + 80;
        this.height = this.width;
        // min + (max - min) * r.nextDouble();
        this.y = (0.2 + (0.8 - 0.2) * random.nextDouble()) * FishHunt.getHeight();
        this.ax = 0;
        this.ay = -100;
        this.vy = random.nextInt(-100 + 201) - 200;
        this.vx = initializeSpeed(this.level, startRight);

        double randomGenerator = Math.random();
        if(randomGenerator > 0.5){
            this.x = -this.width/2;
            this.startRight = false ;
        }else{
            this.x = FishHunt.getHeight() +this.width/2 ;
            this.startRight = true ;
        }
        double randomR = random.nextDouble();
        double randomG = random.nextDouble();
        double randomB = random.nextDouble();
        this.colour = new Color(randomR, randomG, randomB, 1);

        if(this.startRight == false){
            image = ImageHelpers.flop(image);
        }
        image = ImageHelpers.colorize(image, colour);
    }

    public void update(double dt) {
        vx += dt * ax;
        vy += dt * ay;
        x += dt * vx;
        y += dt * vy;
    }
    public double initializeSpeed(int level, boolean startRight){
        if(!startRight) {
            this.vx = 100*Math.pow(level, 1/3) + 200 ;
        }
        else{
            this.vx = -100*Math.pow(level, 1/3) + 200 ;
        }
        return vx;
    }
}