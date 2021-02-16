package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Jeu de la méduse (HighSeaTower) qui fait sauter la méduse sur des plateformes
 *   Développé par : Reda Kzaz
 *   Date: 14-04-2020
 * */
public class FishHunt extends Application {

    //Déclaration des variables
    private static final int width = 640, height = 480;
    private Pane root;
    private Scene scene;
    private VBox menu;
    Canvas canvas = new Canvas(width, height);
    GraphicsContext context = canvas.getGraphicsContext2D();
    private Button buttonNewGame, buttonScore;
    private ArrayList<String> score;
    private ListView<String> list;
    private boolean gameLaunched = false;

    //Création du controleur de l'application
    Controller controller = new Controller();

    //Récupérer les scenes du jeu
    Pane rootGame = FishHuntSubScene.getRootGame();
    Scene sceneGame = FishHuntSubScene.getSceneGame();
    Canvas canvasGame = FishHuntSubScene.getCanvasGame();
    GraphicsContext contextGame = FishHuntSubScene.getContextGame();

    //Constructeur par défaut
    public FishHunt(){
        root = new Pane();
        root.setMaxSize(width,height);
        root.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        scene = new Scene(root, width, height);
        menu = new VBox();
    }

    public static double getHeight() {return height;}

    //Methode pour créer les boutons
    private void createButtons(){
        buttonNewGame = new Button("Nouvelle Partie!");
        buttonScore = new Button("Meilleurs Scores");
        buttonNewGame.setMaxSize(350, 300);
        buttonScore.setMaxSize(350, 300);

        root.getChildren().add(buttonNewGame);
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(10);
        menu.setLayoutX(250);
        menu.setLayoutY(350);

        buttonNewGame.setOnAction((event) -> {
            FishHuntSubScene subScene = new FishHuntSubScene("NewGame");
            root.getChildren().add(subScene);
            createElementsGame();
//            getNodes(root);
            gameLaunched = true;
            animationTimer(context);
        });
        buttonScore.setOnAction((event) -> {
            FishHuntSubScene subScene = new FishHuntSubScene("Score");
            root.getChildren().add(subScene);
            readFile();
            createHighScore();
            gameLaunched = false;
        });

        menu.getChildren().addAll(buttonNewGame,buttonScore);
        root.getChildren().add(menu);
    }

    //Méthode pour créer la cible (Élément du départ du jeu)
    public void createElementsGame() {
        //Creation de la cible et bullet
        Image cible = new Image("images/cible.png");
        ImageView imageViewCible = new ImageView(cible);
        imageViewCible.setFitHeight(50);
        imageViewCible.setFitWidth(50);

        root.getChildren().add(imageViewCible);

        //Quand la souris bouge, redessiner la cible
        root.setOnMouseMoved((event) -> {
            controller.drawCible(imageViewCible, event.getX(), event.getY());
        });

        //Quand on clique sur la souris, lancer le bullet
        root.setOnMouseClicked((event) -> {
            controller.drawBullet(event.getX(), event.getY());
        });
    }

    //Méthode pour lire le fichier des meilleurs scores
    public void readFile() {
        //ListView
        score = new ArrayList<String>();

        //Lecture du fichier Texte
        try {
            File scoreFile = new File("src/MeilleursScores.txt");
            Scanner readerLine = new Scanner(scoreFile);
            while(readerLine.hasNextLine()){
                String data = readerLine.nextLine();
                score.add(data);
            }
            readerLine.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier score n'a pas été trouvé");
            e.printStackTrace();
        }

        //Obtenir le score et mettre dans ajout
        String[] test = score.get(0).split("-");
        int scoreOb =  Integer.parseInt(test[2].trim());
        if(scoreOb > 20) {
            System.out.println(scoreOb);
        }
    }

    //Méthode pour créer la vue des meilleurs scores
    public void createHighScore(){
        //Création de la liste
        list = new ListView<>();
        list.getItems().setAll(score);
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Création de la box
        VBox boxScore = new VBox();
        Label title = new Label("Meilleurs Scores");
        title.setLayoutX(width/2);
        title.setStyle("-fx-font-size: 100pt;");
        title.setStyle("-fx-text-fill: black;");

        //Creation de l'ajout et retour au menu
        HBox boxAdd = new HBox();
        Label name = new Label("Votre nom :");
        TextField userName = new TextField();
        Button buttonAdd = new Button("Ajouter!");
        HBox boxMenu = new HBox();
        Button backMenu = new Button("Menu");

        //Positions
        boxScore.setLayoutX(10);
        boxScore.setLayoutY(80);
        boxScore.setPrefHeight(300);
        boxScore.setPrefWidth(630);
        boxScore.setPadding(new Insets(0, 20, 10, 20));

        boxAdd.setLayoutX(30);
        boxAdd.setLayoutY(400);
        boxMenu.setLayoutX(width / 2);
        boxMenu.setLayoutY(440);

        //Action pour les boutons

        boxScore.getChildren().addAll(title, list);
        boxAdd.getChildren().addAll(name, userName, buttonAdd);
        boxMenu.getChildren().addAll(backMenu);
        root.getChildren().addAll(boxScore, boxAdd, boxMenu);
    }

    public void getNodes(Pane root){
//        String[] array = (String[]) root.getChildren().toArray();
        System.out.println("Node B");
        List<Node> children = root.getChildren();
        for(Node v : children){
            System.out.println(v);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Création du logo et du titre de l'application
//        primaryStage.getIcons().add(new Image("/images/crabe.png"));
        primaryStage.setTitle("Fish Hunt"); // Titre de la fenetre
        primaryStage.setResizable(false); // Taille de la fenetre fixe

        //Création du Canvas
//        Canvas canvas = new Canvas(width, height);

        //Création du logo
        Image logo = new Image("/images/logo.png");
        ImageView imageViewLogo = new ImageView(logo);
        imageViewLogo.setFitHeight(320);
        imageViewLogo.setFitWidth(350);
        imageViewLogo.setX(150);

        //Ajouter les children au root
        root.getChildren().add(canvas);
//        GraphicsContext context = canvas.getGraphicsContext2D();
        root.getChildren().add(imageViewLogo);

        //Lancer la création des bouttons
        createButtons();

        //Afficher la scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void animationTimer(GraphicsContext context) {
        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = 0;

            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                double deltaTime = (now - lastTime) * 1e-9;

                context.clearRect(0, 0, width, height);

                controller.update(deltaTime);
                controller.draw(context);

                lastTime = now;
            }
        };

        timer.start();
    }
    //Méthode main du jeu
    public static void main(String[] args) {
        launch(args);
    }
}