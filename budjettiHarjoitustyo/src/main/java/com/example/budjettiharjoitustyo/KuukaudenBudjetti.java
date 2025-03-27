package com.example.budjettiharjoitustyo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Budjetin kasittelyyn luotu kayttoliittyma ja toiminnallisuus
 * Luodaan alkunakyma ja kasitellaan Menot- ja Tulot-luokan tietueita,
 * seka kaytetaan VaihdaNakyman luokan metodeja
 */
public class KuukaudenBudjetti extends Application {
    /**
     * kehotus tayttamisesta tuloille
     */
    private final Label taytaTulot = new Label("Täytä tulot:");
    /**
     * tekstikentta ansioille
     */
    private final TextField taytaAnsio = new TextField();
    /**
     * ansiokentan tunniste teksti
     */
    private final Label ansiolb = new Label("Ansio:");
    /**
     * etuuskentan tunniste teksti
     */
    private final Label etuuslb = new Label("Etuus:");
    /**
     * muiden tulojen kentan tunniste teksti
     */
    private final Label muuTulolb = new Label("Muut tulot:");
    /**
     * tekstikentta muille ansioille
     */
    private final TextField taytaMuutAnsiot = new TextField();
    /**
     * tekstikentta etuuksille
     */
    private final TextField taytaEtuus = new TextField();
    /**
     * asettelu tuloiden teksikentille
     */
    private final VBox tuloLaatikko = new VBox();
    /**
     * kehotus tayttaa menot
     */
    private final Label taytaMenot = new Label("Täytä menot:");
    /**
     * tekstikentta vuokralle
     */
    private final TextField taytaVuokra = new TextField();
    /**
     * tekstikentta ruokakulujen taytolle
     */
    private final TextField taytaRuoka = new TextField();
    /**
     * tekstikentta muille menoille
     */
    private final TextField taytaMuutMenot = new TextField();
    /**
     * vuokran tunniste teksti
     */
    private final Label vuokralb = new Label("Vuokra:");
    /**
     * ruokakulujen tunniste teksti
     */
    private final Label ruokalb = new Label("Ruokakulut:");
    /**
     * muiden menojen tunniste teksti
     */
    private final Label muuMenotlb = new Label("Muut menot:");
    /**
     * toiminnalisuuden nappula
     */
    private final Button valmis = new Button("Valmis");
    /**
     * luettu etuuskentant muuttuja
     */
    private double luettuEtuus = 0;
    /**
     * luetun ansiokentan muuttuja
     */
    private double luettuAnsio = 0;
    /**
     * luetun muiden tulojen kentan muuttuja
     */
    private double luettuMuuTulo=0;
    /**
     * luetun vuokrakentan muuttuja
     */
    private double luettuVuokra=0;
    /**
     * luetun ruokakulukentan muuttuja
     */
    private double luettuRuoka=0;
    /**
     * luetun muiden menojen kentan muuttuja
     */
    private double luettuMuuMeno=0;

    /**
     * luokan paametodi jolla kaynnistetaan
     *
     * @param args kaynnistyksen aloitus
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Luokan parametriton alustaja
     */
    public KuukaudenBudjetti(){

    }

    /**
     * grafiikan aloitus, jossa luodaan aloitusnakyma
     *
     * @param primaryStage grafiikan kayttama stage
     */
    @Override
    public void start(Stage primaryStage) {
        //rootpaneeli ja sen asettelu
        BorderPane root = new BorderPane();
        Scene ruutu = new Scene(root, 300, 300);
        primaryStage.setScene(ruutu);

        //kaytetaan tehtya stylesheet tyylia
        ruutu.getStylesheets().add(getClass().getResource("/budjettistyle.css").toExternalForm());
        primaryStage.setTitle("Täytä budjetti muodossa 0.0");

        //asetellaan textfieldit ja labelit halutusti
        taytaAnsio.setMaxWidth(60);
        taytaEtuus.setMaxWidth(60);
        taytaMuutAnsiot.setMaxWidth(60);

        //lisataa vertikaaliboksiin ja asetellaan
        tuloLaatikko.setSpacing(10);
        tuloLaatikko.setPadding(new Insets(10, 10, 10, 10));
        tuloLaatikko.getChildren().addAll(taytaTulot, ansiolb, taytaAnsio, etuuslb, taytaEtuus, muuTulolb, taytaMuutAnsiot);

        //tehdaan menoille omat samanlaiset textfieldit ja labelit
        taytaVuokra.setMaxWidth(60);
        taytaRuoka.setMaxWidth(60);
        taytaMuutMenot.setMaxWidth(60);

        //lisataan vertikaaliboksiin ja asetellaan
        VBox menoLaatikko = new VBox();
        menoLaatikko.setPadding(new Insets(10, 10, 10, 10));
        menoLaatikko.setSpacing(10);
        menoLaatikko.getChildren().addAll(taytaMenot, vuokralb, taytaVuokra, ruokalb, taytaRuoka, muuMenotlb, taytaMuutMenot);

        //tehdään uusi horizontalboksi, johon asetellaan verticalboksit
        HBox tekstikentat = new HBox();
        tekstikentat.setSpacing(100);
        tekstikentat.setPadding(new Insets(10, 10, 10, 10));
        tekstikentat.getChildren().addAll(tuloLaatikko, menoLaatikko);

        //asetellaan luotu HBox ja Button rootpaneeliin
        root.setTop(tekstikentat);
        root.setCenter(valmis);

        // nappulasta kaynnistyy textfieldin luku
        valmis.setOnAction(e -> {

            //yritetaan parseta numerot talteen
            try {
                //luetaan tulo puolelta
                luettuAnsio = Double.parseDouble(String.valueOf(taytaAnsio.getText()));
                luettuEtuus = Double.parseDouble(String.valueOf(taytaEtuus.getText()));
                luettuMuuTulo = Double.parseDouble(String.valueOf(taytaMuutAnsiot.getText()));
                //luetaan menoista
                luettuVuokra = Double.parseDouble(String.valueOf(taytaVuokra.getText()));
                luettuRuoka = Double.parseDouble(String.valueOf(taytaRuoka.getText()));
                luettuMuuMeno = Double.parseDouble(String.valueOf(taytaMuutMenot.getText()));
            }
            //jos ei ole kirjoitettu oikeassa muodossa, annetaan pop-up ikkuna ja yritetaan uudestaan
            catch (NumberFormatException error) {
                Alert nullAlert = new Alert(Alert.AlertType.WARNING, "Kirjoita tulot muodossa 0.0", ButtonType.CLOSE);
                nullAlert.showAndWait();
                return;
            }
            //luodaan Tulot-ilmentyman olio ja annetaan luetut tiedot
            Tulot ansioOlio = new Tulot(luettuAnsio, luettuEtuus, luettuMuuTulo);
            //jos ansioita ei ole taytetty, ei anneta jatkaa
            if ((ansioOlio.getAnsio() == 0) && (ansioOlio.getEtuus() == 0) && (ansioOlio.getMuuTulos() == 0)) {
                Alert isTuloAlert = new Alert(Alert.AlertType.WARNING, "Sinulla ei ole tuloja, täytä tulot!", ButtonType.CLOSE);
                isTuloAlert.showAndWait();
                ansioOlio.setOnkoTuloja(false);
                return;
            }
            //jos tuloja on, voidaan jatkaa ja lukea tiedostoon
            else {
                ansioOlio.setOnkoTuloja(true);
                ansioOlio.lueTuloTiedostoon(ansioOlio);
            }
            //luodaan Menot-luokan olio ja annetaan luetut arvot
            Menot menoOlio = new Menot(luettuVuokra, luettuRuoka, luettuMuuMeno);

            //jos luetut tiedot ovat 0, ei voida jatkaa ja annetaan pop-up varoitus
            if ((menoOlio.getVuokra() == 0) && (menoOlio.getRuoka() == 0) && (menoOlio.getMuuMeno() == 0)) {
                menoOlio.setOnkoMenoja(false);
                Alert isMenoAlert = new Alert(Alert.AlertType.WARNING, "Sinulla ei ole meonoja, täytä menot!", ButtonType.CLOSE);
                isMenoAlert.showAndWait();
                return;
            }
            //jos menoja on taytetty, voidaan jatkaa tiedostoon kirjoittamiseen
            else {
                menoOlio.setOnkoMenoja(true);
                menoOlio.lueMenoTiedostoon(menoOlio);
            }
            //luodaan nakyman vaihdon olio, annetaan nykyisen ikkunan tiedot
            KuukaudenJakauma olio = new KuukaudenJakauma(primaryStage, ruutu, root);
            olio.vaihda(olio.uusiNakyma());
        });
        //naytetaan ikkuna
        primaryStage.show();
    }
}
