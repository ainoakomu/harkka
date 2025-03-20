package com.example.budjettiharjoitustyo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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

    public void muutaTuloKokoa(Circle ympyra){

        Tulot alkuOlio=new Tulot();
        alkuOlio.olioTiedostonLuku();
        ympyra.setRadius(ympyra.getRadius()+alkuOlio.getMuutosMaara()/100);
    }

    public void muutaMenoKokoa(Circle ympyra){
        Menot alkuOlio=new Menot();
        alkuOlio.menoOlioTiedostonLuku();
        ympyra.setRadius(ympyra.getRadius()+alkuOlio.getMuutosMaara()/100);
    }


    public void vaihda(Scene scene){
        naytto.setScene(scene);
    }

    public Scene VaihdaValmis() {
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
        Scene ruutu2 = new Scene(root, 500, 500);
        ruutu2.getStylesheets().add(getClass().getResource("/budjettistyle.css").toExternalForm());

        muutaTuloKokoa(ansioYmpyra);
        muutaTuloKokoa(etuusYmypyra);
        muutaTuloKokoa(muuTuloYmpyra);

        muutaMenoKokoa(vuokraYmpyra);
        muutaMenoKokoa(ruokaYmpyra);
        muutaMenoKokoa(muuMenoYmpyra);
        return ruutu2;

    }

}
