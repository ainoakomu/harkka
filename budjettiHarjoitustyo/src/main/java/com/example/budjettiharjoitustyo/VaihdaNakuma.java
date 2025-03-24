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

/**
 * Luokalla tehdään uusi graafinen nakyma, sekä metodit muuttamaan ympyran kokoa
 * Luokan tietueissa ja metodissa vaihda, on kaytetty apuna JavaDocJunkie ja BroCode julkisia opetusvideoita
 * jotka ovat mainittu projektikertomuksessa
 * @author ainok
 */
public class VaihdaNakuma extends Application {
    /**
     * luokalle kaytettavissa oleva stage-ilmentyma
     */
    private Stage naytto;
    /**
     * luokalle kaytettavissa oleva scene-ilmentyma
     */
    private Scene ruutu;
    /**
     * luokalle kaytettavissa oleva parent-ilmentyma
     */
    private Parent root;

    /**
     * luodaan kaynnistys ja uusi stage-ilmentyma
     * @param primaryStage luodaan uusi paastage
     */
    public void start(Stage primaryStage)  {
    }

    /**
     * ohjeman paametodi ja kaynnistys
     * @param args tekee kaynnistyksen
     */
    public static void main(String[] args){
        Application.launch(args);
    }

    /**
     * luodaan alustaja, jolla on graafisen nakyman tietueita
     * @param naytto alustajalle annetaan stage
     * @param ruutu alustajalle annetaan scene
     * @param root alustajalle annetaan parent
     */
    VaihdaNakuma(Stage naytto, Scene ruutu, Parent root){
        this.naytto=naytto;
        this.ruutu=ruutu;
        this.root=root;
    }

    /**
     * muokataan Circle-tyypin sadetta luetun Tulot-luokan objektin arvojen koon mukaan
     * @param ympyra annettu tulot-ympyra minka sade muutetaan
     */
    public void muutaTuloKokoa(Circle ympyra){
        Tulot alkuOlio=new Tulot();
        alkuOlio.olioTiedostonLuku();
        if (alkuOlio.getMuutosMaara()>=1000){
            ympyra.setRadius(ympyra.getRadius()+alkuOlio.getMuutosMaara()/100);
        }
        if (alkuOlio.getMuutosMaara()<1000){
            ympyra.setRadius(ympyra.getRadius()+alkuOlio.getMuutosMaara());
        }
    }

    /**
     * muokataan Circle-tyypin sadetta luetun Menot-luokan objektin arvojen koon mukaan
     * @param ympyra annettu menot-ympyra minka sade muutetaan
     */
    public void muutaMenoKokoa(Circle ympyra){
        Menot alkuOlio=new Menot();
        alkuOlio.menoOlioTiedostonLuku();
        if (alkuOlio.getMuutosMaara()>=1000){
            ympyra.setRadius(ympyra.getRadius()+alkuOlio.getMuutosMaara()/100);
        }
        if (alkuOlio.getMuutosMaara()<1000){
            ympyra.setRadius(ympyra.getRadius()+alkuOlio.getMuutosMaara());
        }
    }

    /**
     * Asetetaan annettu scene-ilmentyma uudeksi sceneksi, jolloin ilmentyma vaihtuu
     * @param scene annetu scene, mihin grafiikka vaihdetaan
     */
    public void vaihda(Scene scene){
        naytto.setScene(scene);
    }

    /**
     * luodaan uusi graafinen nakyma, jossa budjetin jakauma ilmaistaan Circle-nodeina.
     * Kaytetaan samaa css-style sheetia kuin muissa luokissa
     * Nodejen kokoa muutetaan
     * @return uusi graafinen nakyma budjetin ilmaisemiseen
     */
    public Scene uusiNakyma() {
        //root paneeli seka tyylittelya
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));
        Label paaTeksti=new Label("Kuukauden budjettisi jakautuma eri kohdille:");
        //jokaiselle tulot-luokan ympyralle oma stackpane, johon laitetaan ympyra ja label
        StackPane ansioYmpyraPaneeli =new StackPane();
        StackPane etuusYmpyraPaneeli=new StackPane();
        StackPane tuloYmpyraPaneeli=new StackPane();

        //tuloiden ilmaisemiseen luodot nodet ja tyylittely
        Circle ansioYmpyra=new Circle(40);
        ansioYmpyra.maxHeight(120);
        ansioYmpyra.maxWidth(120);
        Label ansiolb=new Label("Ansiot");
        ansioYmpyraPaneeli.getChildren().addAll(ansioYmpyra,ansiolb);
        ansioYmpyra.setFill(Color.AQUAMARINE);
        Circle etuusYmypyra=new Circle(40);
        etuusYmypyra.maxWidth(120);
        etuusYmypyra.maxHeight(120);
        Label etuuslb=new Label("Etuudet");
        etuusYmpyraPaneeli.getChildren().addAll(etuusYmypyra,etuuslb);
        etuusYmypyra.setFill(Color.CADETBLUE);
        Circle muuTuloYmpyra=new Circle(40);
        muuTuloYmpyra.maxHeight(120);
        muuTuloYmpyra.maxHeight(120);
        Label muuTulolb=new Label("Muut tulot");
        tuloYmpyraPaneeli.getChildren().addAll(muuTuloYmpyra,muuTulolb);
        muuTuloYmpyra.setFill(Color.AQUA);
        //laitetaan tulot-ympyroiden stackpanet vertikaalisti seka asettelu
        VBox tuloLaatikko=new VBox();
        tuloLaatikko.getChildren().addAll(ansioYmpyraPaneeli,etuusYmpyraPaneeli,muuTuloYmpyra);
        tuloLaatikko.setAlignment(Pos.BOTTOM_RIGHT);
        tuloLaatikko.setSpacing(10);

        //tehdaan menot ympyroille omat stackpaneelit
        /**StackPane vuokraYmpyraPaneeli =new StackPane();
        StackPane ruokaYmpyraPaneeli=new StackPane();
        StackPane menoYmpyraPaneeli=new StackPane();*/
        //luodaan menot ympyroita, asetellaan ja lisataan stackpaneeleihin
        Circle vuokraYmpyra=new Circle(40);
        vuokraYmpyra.maxHeight(120);
        vuokraYmpyra.maxWidth(120);
        Label vuokralb=new Label("Vuokra",vuokraYmpyra);
        vuokraYmpyra.setFill(Color.FUCHSIA);
        //vuokraYmpyraPaneeli.getChildren().addAll(vuokraYmpyra,vuokralb);
        Circle ruokaYmpyra=new Circle(40);
        ruokaYmpyra.maxHeight(120);
        ruokaYmpyra.maxWidth(120);
        Label ruokalb=new Label("Ruoka",ruokaYmpyra);
        ruokaYmpyra.setFill(Color.FIREBRICK);
        //ruokaYmpyraPaneeli.getChildren().addAll(ruokaYmpyra,ruokalb);
        Circle muuMenoYmpyra=new Circle(40);
        muuMenoYmpyra.maxHeight(120);
        muuMenoYmpyra.maxWidth(120);
        Label menolb=new Label("Muut menot",muuMenoYmpyra);
        muuMenoYmpyra.setFill(Color.RED);
        //menoYmpyraPaneeli.getChildren().addAll(muuMenoYmpyra,menolb);
        //asetetaan stackpaneelit vertikaaliboksiin
        VBox menoLaatikko=new VBox();
        menoLaatikko.getChildren().addAll(vuokralb,ruokalb,menolb);
        menoLaatikko.setAlignment(Pos.BOTTOM_LEFT);
        menoLaatikko.setSpacing(10);
        //asetetaan verticalboksit rootpaneeliin
        root.setTop(paaTeksti);
        root.setLeft(tuloLaatikko);
        root.setRight(menoLaatikko);
        Scene ruutu2 = new Scene(root, 500, 500);
        //kaytetaan samaa tyylittelya
        ruutu2.getStylesheets().add(getClass().getResource("/budjettistyle.css").toExternalForm());
        //muutetaan tuloympyroiden kokoa annettujen tulo-olioiden koon mukaan
        muutaTuloKokoa(ansioYmpyra);
        muutaTuloKokoa(etuusYmypyra);
        muutaTuloKokoa(muuTuloYmpyra);
        //muutetaan menoympyroiden koko annettujen meno-olioiden koon mukaan
        muutaMenoKokoa(vuokraYmpyra);
        muutaMenoKokoa(ruokaYmpyra);
        muutaMenoKokoa(muuMenoYmpyra);
        //palautetaan luotu uusi graafinen nakyma
        return ruutu2;

    }

}
