package com.example.budjettiharjoitustyo;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KuukaudenBudjetti extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root=new BorderPane();
        Scene ruutu=new Scene(root,300,300);
        primaryStage.setScene(ruutu);
        ruutu.getStylesheets().add(getClass().getResource("/budjettistyle.css").toExternalForm());
        primaryStage.setTitle("Täytä budjetti");

        //layout
        Label taytaTulot=new Label("Täytä tulot:");
        TextField taytaAnsio=new TextField();
        taytaAnsio.setMaxWidth(60);
        TextField taytaEtuus=new TextField();
        taytaEtuus.setMaxWidth(60);
        TextField taytaMuutAnsiot =new TextField();
        taytaMuutAnsiot.setMaxWidth(60);
        Label ansiolb =new Label("Ansio:");
        Label etuuslb =new Label("Etuus:");
        Label muuTulolb =new Label("Muut tulot:");

        VBox tuloLaatikko=new VBox();
        tuloLaatikko.setSpacing(10);
        tuloLaatikko.setPadding(new Insets(10,10,10,10));
        tuloLaatikko.getChildren().addAll(taytaTulot, ansiolb,taytaAnsio, etuuslb,taytaEtuus, muuTulolb, taytaMuutAnsiot);

        //toinen puoli
        Label taytaMenot=new Label("Täytä menot:");
        TextField taytaVuokra=new TextField();
        taytaVuokra.setMaxWidth(60);
        TextField taytaRuoka=new TextField();
        taytaRuoka.setMaxWidth(60);
        TextField taytaMuutMenot=new TextField();
        taytaMuutMenot.setMaxWidth(60);
        Label vuokralb =new Label("Vuokra:");
        Label ruokalb =new Label("Ruokakulut:");
        Label muuMenotlb =new Label("Muut menot:");

        VBox menoLaatikko=new VBox();
        menoLaatikko.setPadding(new Insets(10,10,10,10));
        menoLaatikko.setSpacing(10);
        menoLaatikko.getChildren().addAll(taytaMenot, vuokralb,taytaVuokra, ruokalb,taytaRuoka, muuMenotlb,taytaMuutMenot);

        //Hbox for the looks
        HBox tekstikentat=new HBox();
        tekstikentat.setSpacing(100);
        tekstikentat.setPadding(new Insets(10,10,10,10));
        tekstikentat.getChildren().addAll(tuloLaatikko,menoLaatikko);
        Button valmis=new Button("Valmis");


        //root alignment
        root.setTop(tekstikentat);
        root.setCenter(valmis);



        valmis.setOnAction(e-> {
            //luetaan tulojen textfieldeistä arvot
            double luettuEtuus=0;
            double luettuAnsio=0;
            double luettuMuuTulo=0;
            double luettuVuokra=0;
            double luettuRuoka=0;
            double luettuMuuMeno=0;
            try {
                luettuAnsio = Double.parseDouble(String.valueOf(taytaAnsio.getText()));
                luettuEtuus = Double.parseDouble(String.valueOf(taytaEtuus.getText()));
                luettuMuuTulo = Double.parseDouble(String.valueOf(taytaMuutAnsiot.getText()));
                //luetaan menoista
                luettuVuokra = Double.parseDouble(String.valueOf(taytaVuokra.getText()));
                luettuRuoka = Double.parseDouble(String.valueOf(taytaRuoka.getText()));
                luettuMuuMeno = Double.parseDouble(String.valueOf(taytaMuutMenot.getText()));
            } catch (NullPointerException error) {
                Alert nullAlert=new Alert(Alert.AlertType.WARNING,"Kirjoita tulot muodossa 0.0", ButtonType.CLOSE);
            }

            //tulo-olio
            Tulot ansioOlio = new Tulot(luettuAnsio, luettuEtuus, luettuMuuTulo);

            if ((ansioOlio.getAnsio() == 0) && (ansioOlio.getEtuus() == 0) && (ansioOlio.getMuuTulos() == 0)) {
                Alert isTuloAlert=new Alert(Alert.AlertType.WARNING,"Sinulla ei ole tuloja, täytä tulot!", ButtonType.CLOSE);
                ansioOlio.setOnkoTuloja(false);
            } else {
                ansioOlio.setOnkoTuloja(true);
                ansioOlio.lueTuloTiedostoon(ansioOlio);
            }
            //menoolio
            Menot menoOlio = new Menot(luettuVuokra, luettuRuoka, luettuMuuMeno);
            //onkomenoja
            if ((menoOlio.getVuokra() == 0) && (menoOlio.getRuoka() == 0) && (menoOlio.getMuuMeno() == 0)) {
                menoOlio.setOnkoMenoja(false);
                Alert isMenoAlert=new Alert(Alert.AlertType.WARNING,"Sinulla ei ole meonoja, täytä menot!", ButtonType.CLOSE);
            } else {
                menoOlio.setOnkoMenoja(true);
                menoOlio.lueMenoTiedostoon(menoOlio);
            }

            //
            VaihdaNakuma olio=new VaihdaNakuma(primaryStage,ruutu,root);
            olio.vaihda(olio.VaihdaValmis());

        });
        primaryStage.show();
    }

}
