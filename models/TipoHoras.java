package models;

import java.io.Serializable;

public class TipoHoras implements Serializable {
    private int horas;
    private int minutos;

    public TipoHoras(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    @Override
    public String toString() {
        return horas + "h " + minutos + "m";
    }
}
