package com.salinas.temperatura.model;

public class Temperatura {
    private double valor;
    private int escala;

    public Temperatura(double valor, int escala) {
        this.valor = valor;
        this.escala = escala;
    }

    public double convertir(int nuevaEscala) {
        if (escala == nuevaEscala) {
            return valor;
        }
        double valorCelsius = valor;

        switch (escala) {
            case 0: // Celsius
                break;
            case 1: // Fahrenheit
                valorCelsius =  (valor - 32) * 5 / 9;
                break;
            case 2: // Kelvin
                valorCelsius = valor - 273.15;
                break;
        }

        switch (nuevaEscala) {
            case 0: // Celsius
                return valorCelsius;
            case 1: // Fahrenheit
                return valorCelsius * 9 / 5 + 32;
            case 2: // Kelvin
                return valorCelsius + 273.15;
            default:
                return valor;
        }
    }
}
