package com.example.budjettiharjoitustyo;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.*;

public class Tulot implements Serializable {
    private  double ansio;
    private double etuus;
    private double muuTulos;
    private boolean onkoTuloja;

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

    public void lueTuloTiedostoon(Object tuloOlio){
        File fileStream= new File("Tulotiedot.dat");
              ObjectOutputStream olioTiedosto=null;

              try{
                  olioTiedosto=new ObjectOutputStream(new FileOutputStream(fileStream));
                  olioTiedosto.writeObject(tuloOlio);
                  olioTiedosto.close();
              } catch (IOException | NumberFormatException error) {
                  Alert ioAlert=new Alert(Alert.AlertType.ERROR,"Nyt ei onnistunut!", ButtonType.CLOSE);
              }


    }

    public Object olioTiedostonLuku(){
        File tiedostonNimi=new File("Tulotiedot.dat");
        Tulot lukuolio= null;
        if (!tiedostonNimi.exists()){
            Alert nullAlert=new Alert(Alert.AlertType.ERROR,"Tiedostoa ei ole!", ButtonType.CLOSE);
            int i=0;
            System.exit(i);
        }
        else{
            try{
                boolean tiedostoLoppui=false;
                FileInputStream tiedostoTulo=new FileInputStream(tiedostonNimi);
                ObjectInputStream luetaanTulo=new ObjectInputStream(tiedostoTulo);
                while(!tiedostoLoppui){
                    lukuolio= (Tulot) luetaanTulo.readObject();
                }
                luetaanTulo.close();
            } catch (IOException | ClassNotFoundException e) {
                Alert catcherAlert=new Alert(Alert.AlertType.ERROR,"Tiedostoa ei ole!", ButtonType.CLOSE);
            }

        }
        return lukuolio;
    }

}
