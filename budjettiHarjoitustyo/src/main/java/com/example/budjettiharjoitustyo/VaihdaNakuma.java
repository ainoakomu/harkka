package com.example.budjettiharjoitustyo;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class VaihdaNakuma extends Application {
    private Stage naytto;
    private Scene ruutu;
    private Parent root;

    public void start(Stage primaryStage) throws Exception {
    }

    public static void main(String[] args){
        Application.launch(args);
    }

    VaihdaNakuma(Stage naytto, Scene ruutu, Parent root){
        this.naytto=naytto;
        this.ruutu=ruutu;
        this.root=root;
    }

    public Scene VaihdaValmis() {
        BorderPane root = new BorderPane();
        Label paaTeksti=new Label("Kuukauden budjettisi:");


        //tuloille
        VBox tuloLaatikko=new VBox();
        Circle ansioYmpyra=new Circle(40);
        Circle etuusYmypyra=new Circle(40);
        Circle muuTuloYmpyra=new Circle(40);
        ansioYmpyra.setFill(Color.AQUAMARINE);
        etuusYmypyra.setFill(Color.AZURE);
        muuTuloYmpyra.setFill(Color.AQUA);
        tuloLaatikko.getChildren().addAll(ansioYmpyra,etuusYmypyra,muuTuloYmpyra);

        //menooille sama
        VBox menoLaatikko=new VBox();
        Circle vuokraYmpyra=new Circle(40);
        Circle ruokaYmpyra=new Circle(40);
        Circle muuMenoYmpyra=new Circle(40);
        vuokraYmpyra.setFill(Color.FUCHSIA);
        ruokaYmpyra.setFill(Color.FIREBRICK);
        muuMenoYmpyra.setFill(Color.RED);
        menoLaatikko.getChildren().addAll(vuokraYmpyra,ruokaYmpyra,muuMenoYmpyra);


        root.setTop(paaTeksti);
        root.setLeft(tuloLaatikko);
        root.setRight(menoLaatikko);
        Scene ruutu2 = new Scene(root, 300, 300);
        return ruutu2;

    }

    public void vaihda(Scene scene){
        naytto.setScene(scene);
    }


}
