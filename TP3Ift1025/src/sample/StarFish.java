package sample;
import javafx.scene.image.Image;

import java.util.Random;

public class StarFish extends Fish{
    private Image imageCrab;
    public StarFish(int level) {
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
        if (this.startRight == true) {
            this.imageCrab = ImageHelpers.flop(this.imageCrab);
        }
        this.vx = 1.3*initializeSpeed(this.level, this.startRight);
    }
}