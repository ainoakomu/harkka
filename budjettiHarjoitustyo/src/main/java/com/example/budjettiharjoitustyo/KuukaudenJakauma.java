package com.example.budjettiharjoitustyo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Luokalla tehdään uusi graafinen nakyma, luetaan tiedostosta ja tuodaan olion tietueita esille
 * Luokan tietueissa ja metodissa vaihda, on kaytetty apuna JavaDocJunkie ja BroCode julkisia opetusvideoita
 * jotka ovat mainittu projektikertomuksessa
 * @author ainok
 */
public class KuukaudenJakauma extends Application {
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

    private  final Label paaTeksti=new Label("Kuukauden budjettisi:");
    private  final Label Tulot=new Label("Tulosi ovat:");
    private  final Label Menot=new Label("Menosi ovat:");
    private  final Text kaikkiTulot=new Text();
    private  final Text kaikkiMenot=new Text();
    private  final Circle ansioYmpyra=new Circle(40);
    private  final Label ansiolb=new Label("Ansiot");
    private  final StackPane ansioStackPane=new StackPane();
    private  final StackPane etuusStackPane=new StackPane();
    private  final Circle etuusYmypyra=new Circle(40);
    private  final Label etuuslb=new Label("Etuudet");
    private  final StackPane muutTulotStackPane=new StackPane();
    private  final Circle muuTuloYmpyra=new Circle(40);
    private  final Label muuTulolb=new Label("Muut tulot");
    private  final StackPane vuokraStackPane=new StackPane();
    private  final Circle vuokraYmpyra=new Circle(40);
    private  final Label vuokralb=new Label("Vuokra");
    private  final StackPane ruokaStackPane=new StackPane();
    private  final Circle ruokaYmpyra=new Circle(40);
    private  final Label ruokalb=new Label("Ruokakulut");
    private  final StackPane muuMenoStackPane=new StackPane();
    private  final Circle muuMenoYmpyra=new Circle(40);
    private  final Label menolb=new Label("Muut menot");
    private  final VBox menoLaatikko=new VBox();
    private  final VBox tuloLaatikko=new VBox();
    private  final HBox ylalaatikko=new HBox();
    private final Text jakaumaTeksti=new Text();


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
    KuukaudenJakauma(Stage naytto, Scene ruutu, Parent root){
        this.naytto=naytto;
        this.ruutu=ruutu;
        this.root=root;
    }

    public String palautaTuloSumma(){
       Tulot alkuolio=new Tulot();
       alkuolio.olioTiedostonLuku();
       Double luku=alkuolio.getMuutosMaara();
       String lukujono=String.valueOf(luku);
       String euro="€";
       return lukujono+euro;
   }

    public String palautaMenoSumma(){
        Menot alkuolio=new Menot();
        alkuolio.menoOlioTiedostonLuku();
        Double luku=alkuolio.getMenoMuutosMaara();
        String lukujono=String.valueOf(luku);
        String euro="€";
        return lukujono+euro;
    }
    public String palautaAnsio(){
        Tulot testiOlio=new Tulot();
        testiOlio.olioTiedostonLuku();
        double ansioLuku=testiOlio.getAnsio();
        String ansioLukuJono=String.valueOf(ansioLuku);
        String euro="€";
        return ansioLukuJono+euro;
    }
    public String palautaEtuus(){
        Tulot testiOlio=new Tulot();
        testiOlio.olioTiedostonLuku();
        double ansioLuku=testiOlio.getEtuus();
        String ansioLukuJono=String.valueOf(ansioLuku);
        String euro="€";
        return ansioLukuJono+euro;
    }
    public String palautaMuuTulo(){
        Tulot testiOlio=new Tulot();
        testiOlio.olioTiedostonLuku();
        double ansioLuku=testiOlio.getMuuTulos();
        String ansioLukuJono=String.valueOf(ansioLuku);
        String euro="€";
        return ansioLukuJono+euro;
    }
    public String palautaVuokra(){
        Menot testiOlio=new Menot();
        testiOlio.menoOlioTiedostonLuku();
        double ansioLuku=testiOlio.getVuokra();
        String ansioLukuJono=String.valueOf(ansioLuku);
        String euro="€";
        return ansioLukuJono+euro;
    }
    public String palautaRuoka(){
        Menot testiOlio=new Menot();
        testiOlio.menoOlioTiedostonLuku();
        double ansioLuku=testiOlio.getRuoka();
        String ansioLukuJono=String.valueOf(ansioLuku);
        String euro="€";
        return ansioLukuJono+euro;
    }
    public String palautaMuuMeno(){
        Menot testiOlio=new Menot();
        testiOlio.menoOlioTiedostonLuku();
        double ansioLuku=testiOlio.getMuuMeno();
        String ansioLukuJono=String.valueOf(ansioLuku);
        String euro="€";
        return ansioLukuJono+euro;
    }
    public String rahaJakauma(){
        Tulot tuloOlio=new Tulot();
        Menot menoOlio=new Menot();
        tuloOlio.olioTiedostonLuku();
        menoOlio.menoOlioTiedostonLuku();
        double tuloja=tuloOlio.getMuutosMaara();
        double menoja=menoOlio.getMenoMuutosMaara();
        String lause="";
        if (tuloja>menoja){
            double ylimaarainenTulo=tuloja-menoja;
            String tuloTekstina=String.valueOf(ylimaarainenTulo);
            String balanssi="Balanssi";
            String huomautusteksti="\nHei menee hyvin! Voisit laittaa säästöön!";
            String euro="€";
            lause= tuloTekstina+euro+balanssi+huomautusteksti;
        }
        else if (tuloja==menoja){
            double tasapeli =0.0;
            String tasaTekstina=String.valueOf(tasapeli);
            String huomautusteksti="\nYksikin ostos ja käy huonosti...";
            String euro="€";
            String balanssi="Balanssi";
            lause= tasaTekstina+euro+balanssi+huomautusteksti;
        }
        else {
            double alijaamainenTulo=tuloja-menoja;
            String menoTekstina =String.valueOf(alijaamainenTulo);
            String huomautusTeksti="\nOlet pahasti miinuksella, ei hyvä :c";
            String euro="€";
            String balanssi="Balanssi";
            lause= menoTekstina+euro+balanssi+huomautusTeksti;
        }
        return lause;
    }

    /**
     * Asetetaan annettu scene-ilmentyma uudeksi sceneksi, jolloin ilmentyma vaihtuu
     * @param scene annetu scene, mihin grafiikka vaihdetaan
     */
    public void vaihda(Scene scene){
        naytto.setScene(scene);
    }

    /**
     * luodaan uusi graafinen nakyma, jossa budjetin jakauma.
     * Kaytetaan samaa css-style sheetia kuin muissa luokissa
     *
     * @return uusi graafinen nakyma budjetin ilmaisemiseen
     */
    public Scene uusiNakyma() {
        //root paneeli seka tyylittelya
        BorderPane rootPaneeli= new BorderPane();
        rootPaneeli.setPadding(new Insets(5,5,5,5));
        //teksteja ylalaatikkoon
        kaikkiTulot.setText(palautaTuloSumma());
        kaikkiMenot.setText(palautaMenoSumma());
        jakaumaTeksti.setText(rahaJakauma());
        //ylalaatikon muotoilu
        ylalaatikko.getChildren().addAll(paaTeksti,Tulot,kaikkiTulot,Menot,kaikkiMenot);
        ylalaatikko.setSpacing(10);
        ylalaatikko.setAlignment(Pos.CENTER);


        //ansio ympyra
        ansioYmpyra.setFill(Color.AQUAMARINE);
        //stackpane toiminta
        Text ansioTeksti=new Text(palautaAnsio());
        ansioStackPane.getChildren().addAll(ansioYmpyra,ansioTeksti,ansiolb);
        StackPane.setAlignment(ansiolb, Pos.TOP_CENTER);
        StackPane.setAlignment(ansioYmpyra,Pos.CENTER);
        StackPane.setAlignment(ansioTeksti, Pos.CENTER);

        //etuusympyra
        etuusYmypyra.setFill(Color.CADETBLUE);
        //stackpane toiminta
        Text etuusTeksti=new Text(palautaEtuus());
        etuusStackPane.getChildren().addAll(etuusYmypyra,etuuslb,etuusTeksti);
        StackPane.setAlignment(etuuslb, Pos.TOP_CENTER);
        StackPane.setAlignment(etuusYmypyra, Pos.CENTER);
        StackPane.setAlignment(etuusTeksti, Pos.CENTER);

        //muut tulot ympyra
        muuTuloYmpyra.setFill(Color.AQUA);
        //stackpane toiminta
        Text muuTuloTeksti=new Text(palautaMuuTulo());
        muutTulotStackPane.getChildren().addAll(muuTuloYmpyra,muuTulolb,muuTuloTeksti);
        StackPane.setAlignment(muuTulolb, Pos.TOP_CENTER);
        StackPane.setAlignment(muuTuloYmpyra, Pos.CENTER);
        StackPane.setAlignment(muuTuloTeksti, Pos.CENTER);

        //laitetaan tulot-ympyroiden asettelu
        tuloLaatikko.getChildren().addAll(ansioStackPane,etuusStackPane,muutTulotStackPane);
        tuloLaatikko.setAlignment(Pos.CENTER);
        tuloLaatikko.setSpacing(10);

        //vuokraympyra
        vuokraYmpyra.setFill(Color.FUCHSIA);
        //stackpane
        Text vuokraTeksti=new Text(palautaVuokra());
        vuokraStackPane.getChildren().addAll(vuokraYmpyra,vuokralb,vuokraTeksti);
        StackPane.setAlignment(vuokralb, Pos.TOP_CENTER);
        StackPane.setAlignment(vuokraYmpyra,Pos.CENTER);
        StackPane.setAlignment(vuokraTeksti, Pos.CENTER);

        //ruokaympyra
        ruokaYmpyra.setFill(Color.FIREBRICK);
        //stackpane
        Text ruokaTeksti=new Text(palautaRuoka());
        ruokaStackPane.getChildren().addAll(ruokaYmpyra,ruokalb,ruokaTeksti);
        StackPane.setAlignment(ruokalb, Pos.TOP_CENTER);
        StackPane.setAlignment(ruokaYmpyra, Pos.CENTER);
        StackPane.setAlignment(ruokaTeksti, Pos.CENTER);

        //muumeno ympyra
        muuMenoYmpyra.setFill(Color.RED);
        //stackpane toiminta
        Text muuMenoTeksti=new Text(palautaMuuMeno());
        muuMenoStackPane.getChildren().addAll(muuMenoYmpyra,menolb,muuMenoTeksti);
        StackPane.setAlignment(menolb, Pos.TOP_CENTER);
        StackPane.setAlignment(muuMenoYmpyra, Pos.CENTER);
        StackPane.setAlignment(muuMenoTeksti, Pos.CENTER);

        //asetetaan stackpaneelit vertikaaliboksiin
        menoLaatikko.getChildren().addAll(vuokraStackPane,ruokaStackPane,muuMenoStackPane);
        menoLaatikko.setAlignment(Pos.CENTER);
        menoLaatikko.setSpacing(10);

        //asetetaan verticalboksit rootpaneeliin
        rootPaneeli.setTop(ylalaatikko);
        rootPaneeli.setLeft(tuloLaatikko);
        rootPaneeli.setRight(menoLaatikko);
        rootPaneeli.setCenter(jakaumaTeksti);
        Scene ruutu2 = new Scene(rootPaneeli, 400, 400);

        //kaytetaan samaa tyylittelya
        ruutu2.getStylesheets().add(getClass().getResource("/budjettistyle.css").toExternalForm());
        //palautetaan luotu uusi graafinen nakyma
        return ruutu2;

    }

}
