package com.example.budjettiharjoitustyo;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.*;

public class Tulot implements Serializable {
    private  double ansio;
    private double etuus;
    private double muuTulos;
    private boolean onkoTuloja;
    private double muutosMaara;

    public Tulot(){

    }

    public Tulot(double ansio,double etuus,double muuTulo){
        this.ansio=ansio;
        this.etuus=etuus;
        this.muuTulos=muuTulo;

    }

    //get ja set
    public double getAnsio() {
        return ansio;
    }

    public void setAnsio(double ansio) {
        this.ansio = ansio;
    }

    public double getEtuus() {
        return etuus;
    }

    public void setEtuus(double etuus) {
        this.etuus = etuus;
    }

    public double getMuuTulos() {
        return muuTulos;
    }

    public void setMuuTulos(double muuTulos) {
        this.muuTulos = muuTulos;
    }

    public void setOnkoTuloja(boolean onkoTuloja) {
        this.onkoTuloja = onkoTuloja;
    }
    public boolean getOnkoTuloja(){
        return onkoTuloja;
    }

    public double getMuutosMaara() {
        return muutosMaara;
    }

    public void setMuutosMaara(double muutosMaara) {
        this.muutosMaara = muutosMaara;
    }

    public void lueTuloTiedostoon(Object tuloOlio){
        File fileStream= new File("Tulotiedot.dat");
              ObjectOutputStream olioTiedosto=null;

              try{
                  olioTiedosto=new ObjectOutputStream(new FileOutputStream(fileStream));
                  olioTiedosto.writeObject(tuloOlio);
                  olioTiedosto.close();
              } catch (IOException | NumberFormatException error) {
                  Alert ioAlert=new Alert(Alert.AlertType.ERROR,"Nyt ei onnistunut!", ButtonType.CLOSE);
                  ioAlert.showAndWait();
              }


    }

    public void olioTiedostonLuku(){
        File tiedostonNimi=new File("Tulotiedot.dat");
        if (!tiedostonNimi.exists()){
            Alert nullAlert=new Alert(Alert.AlertType.ERROR,"Tiedostoa ei ole!", ButtonType.CLOSE);
            nullAlert.showAndWait();
            System.exit(0);
        }
        else{
            try{
                FileInputStream tiedostoTulo=new FileInputStream(tiedostonNimi);
                ObjectInputStream luetaanTulo=new ObjectInputStream(tiedostoTulo);
                Object luettu =luetaanTulo.readObject();
                if(luettu instanceof Tulot) {
                    Tulot olio=(Tulot)luettu;
                    this.muutosMaara =olio.getAnsio()+olio.getEtuus()+olio.getMuuTulos();
                }
                else{
                    Alert catcherAlert=new Alert(Alert.AlertType.ERROR,"Tiedosto ei ole double!", ButtonType.CLOSE);
                    catcherAlert.showAndWait();
                    return;
                    }
            } catch (IOException | ClassNotFoundException e) {
                Alert catcherAlert=new Alert(Alert.AlertType.ERROR,"Ei onnistunut", ButtonType.CLOSE);
                catcherAlert.showAndWait();
            }
        }
    }

}
