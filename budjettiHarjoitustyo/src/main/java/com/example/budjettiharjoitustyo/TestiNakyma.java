package com.example.budjettiharjoitustyo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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
        StackPane ansioYmpyraPaneeli =new StackPane();
        StackPane etuusYmpyraPaneeli=new StackPane();
        StackPane tuloYmpyraPaneeli=new StackPane();
        


        //tuloille
        Circle ansioYmpyra=new Circle(40);
        Label ansiolb=new Label("Ansiot");
        ansioYmpyraPaneeli.getChildren().addAll(ansioYmpyra,ansiolb);
        ansioYmpyra.setFill(Color.AQUAMARINE);
        Circle etuusYmypyra=new Circle(40);
        Label etuuslb=new Label("Etuudet");
        etuusYmpyraPaneeli.getChildren().addAll(etuusYmypyra,etuuslb);
        etuusYmypyra.setFill(Color.AZURE);
        Circle muuTuloYmpyra=new Circle(40);
        Label muuTulolb=new Label("Muut tulot");
        tuloYmpyraPaneeli.getChildren().addAll(muuTuloYmpyra,muuTulolb);
        muuTuloYmpyra.setFill(Color.AQUA);


        VBox tuloLaatikko=new VBox();
        tuloLaatikko.getChildren().addAll(ansioYmpyraPaneeli,etuusYmpyraPaneeli,tuloYmpyraPaneeli);
        tuloLaatikko.setAlignment(Pos.BOTTOM_RIGHT);
        tuloLaatikko.setSpacing(10);

        //menooille sama
        StackPane vuokraYmpyraPaneeli =new StackPane();
        StackPane ruokaYmpyraPaneeli=new StackPane();
        StackPane menoYmpyraPaneeli=new StackPane();
        Circle vuokraYmpyra=new Circle(40);
        Label vuokralb=new Label("Vuokra");
        vuokraYmpyra.setFill(Color.FUCHSIA);
        vuokraYmpyraPaneeli.getChildren().addAll(vuokraYmpyra,vuokralb);
        Circle ruokaYmpyra=new Circle(40);
        Label ruokalb=new Label("Ruoka");
        ruokaYmpyra.setFill(Color.FIREBRICK);
        ruokaYmpyraPaneeli.getChildren().addAll(ruokaYmpyra,ruokalb);
        Circle muuMenoYmpyra=new Circle(40);
        Label menolb=new Label("Muut menot");
        muuMenoYmpyra.setFill(Color.RED);
        menoYmpyraPaneeli.getChildren().addAll(muuMenoYmpyra,menolb);

        VBox menoLaatikko=new VBox();
        menoLaatikko.getChildren().addAll(vuokraYmpyraPaneeli,ruokaYmpyraPaneeli,menoYmpyraPaneeli);
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
