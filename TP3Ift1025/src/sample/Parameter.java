package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Parameter {

    protected double largeur, hauteur;
    protected double x, y;

    protected double vx, vy;
    protected double ax, ay;


    protected Color colour;

    public void update(double dt) {
        vx += dt * ax;
        vy += dt * ay;
        x += dt * vx;
        y += dt * vy;

//        // Force à rester dans les bornes de l'écran
//        if (x + largeur > FishHunt.getWidth() ) {
//            vx *= -1;
//        }
//
//        // A traiter dans une autre classe aussi pour le cas ou la meduse est tombe sur l'ocean
////        if (y + hauteur > 0.75*highSeaTower.getHeight() ) {
////            vy *= -1;
////        }
//
//        x = Math.min(x, HighSeaTower.getWidth() - largeur);
//        x = Math.max(x, 0);
////        y = Math.min(y, highSeaTower.getHeight() - hauteur);
////        y = Math.max(y, 0);
//    }

//    public abstract void draw(GraphicsContext context);
//
//    public abstract void draw(GraphicsContext context, double fenetreX, double fenetreY);
//
//
//    public abstract void drawInit(GraphicsContext context);

//        public void setAy ( double ay){
//            this.ay = ay;
//        }
//        public void setVy ( double vy){
//            this.vy = vy;
//        }
//    }
    }
}