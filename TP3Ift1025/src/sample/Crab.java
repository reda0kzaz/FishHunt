package sample;
import javafx.scene.image.Image;

import java.util.Random;

public class Crab extends Fish {
    private Image imageCrab;
//    private boolean startRight;

    public Crab(int level) {
        super(level);
        Random random = new Random();
        //r.nextInt((max - min) + 1) + min;
        this.width = random.nextInt(120 - 79) + 80;
        imageCrab = ImageHelpers.colorize(this.imageCrab, colour);
        this.height = this.width;
        this.ax = 0;
        this.ay = 0;
        this.vy = 0;
        imageCrab = new Image("/images/fish/crabe.png");
        if(this.startRight == true){
            this.imageCrab = ImageHelpers.flop(this.imageCrab);
        }
        this.vx = initializeSpeed(this.level, this.startRight);

    }


    public double initializeSpeed(double level, boolean startRight){
        if(!startRight) {
            this.vx = 100*Math.pow(level, 1/3) + 200 ;
        }
        else{
            this.vx = -100*Math.pow(level, 1/3) + 200 ;
        }
        this.vx*=1.3 ;
        return vx;
    }

}