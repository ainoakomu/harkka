package com.example.budjettiharjoitustyo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TestiNakyma extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));

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
        tuloLaatikko.setAlignment(Pos.BOTTOM_RIGHT);
        tuloLaatikko.setSpacing(10);

        //menooille sama
        VBox menoLaatikko=new VBox();
        Circle vuokraYmpyra=new Circle(40);
        Circle ruokaYmpyra=new Circle(40);
        Circle muuMenoYmpyra=new Circle(40);
        vuokraYmpyra.setFill(Color.FUCHSIA);
        ruokaYmpyra.setFill(Color.FIREBRICK);
        muuMenoYmpyra.setFill(Color.RED);
        menoLaatikko.getChildren().addAll(vuokraYmpyra,ruokaYmpyra,muuMenoYmpyra);
        menoLaatikko.setAlignment(Pos.BOTTOM_LEFT);
        menoLaatikko.setSpacing(10);


        root.setTop(paaTeksti);
        root.setLeft(tuloLaatikko);
        root.setRight(menoLaatikko);
        Scene ruutu2 = new Scene(root, 400, 400);
        primaryStage.setScene(ruutu2);
        ruutu2.getStylesheets().add(getClass().getResource("/budjettistyle.css").toExternalForm());
        primaryStage.setTitle("Täytä budjetti");
        primaryStage.show();

    }
}
