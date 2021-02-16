package sample;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class FishHuntSubScene extends SubScene {

    private static final int width = 640, height = 480;
    private static Pane rootGame;
    private static Scene sceneGame;
    private static GraphicsContext contextGame;
    private static Canvas canvasGame;

    public FishHuntSubScene(String type) {
        super(new Pane(), width, height);
        rootGame = (Pane) this.getRoot();
        prefHeight(width);
        prefWidth(height);
        rootGame.setMaxSize(width,height);

        if(type == "Score"){
            rootGame.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
        } else{
            rootGame.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        }

        sceneGame = new Scene(rootGame, width, height);
        canvasGame = new Canvas(width, height);
        contextGame = canvasGame.getGraphicsContext2D();
        rootGame.getChildren().add(canvasGame);

        contextGame.setFill(Color.WHITE);
        contextGame.setFont(new Font(25));
        contextGame.fillText("150m", 170, 50);

//        List<Node> children = rootGame.getChildren();
//        System.out.println("Node Game");
//        for(Node v : children){
//            System.out.println(v);
//        }
    }

    public static Pane getRootGame() {
        return rootGame;
    }

    public static Scene getSceneGame() {
        return sceneGame;
    }

    public static GraphicsContext getContextGame() {
        return contextGame;
    }

    public static Canvas getCanvasGame() {
        return canvasGame;
    }
}