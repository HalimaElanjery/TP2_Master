package ht.fds.mbds.elanjery.tp2tests;

import ht.fds.mbds.elanjery.tp2tests.outil.meteo.MeteoTool;

public class TestMeteo {
    public static void main(String[] args) {
        MeteoTool meteo = new MeteoTool();
        double lat = 48.85;   // Paris
        double lon = 2.35;

        System.out.println("Pluie aujourd'hui seulement : " + meteo.isPluiePrevue(lat, lon, 0, 1));
        System.out.println("Pluie demain seulement      : " + meteo.isPluiePrevue(lat, lon, 1, 1));
        System.out.println("Pluie dans 2 jours          : " + meteo.isPluiePrevue(lat, lon, 2, 1));
        System.out.println("Pluie sur 3 jours dès auj.  : " + meteo.isPluiePrevue(lat, lon, 0, 3));
    }
}