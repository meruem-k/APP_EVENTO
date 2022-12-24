package com.example.pruebafinal;

public class registrarEvento {
    private String evento;
    private String importancia;
    private String observacion;
    private String fechaString;
    private String nombre;


    public registrarEvento(String nombre, String evento, String importancia, String observacion, String fechaString) {
        this.evento = evento;
        this.importancia = importancia;
        this.observacion = observacion;
        this.fechaString = fechaString;
        this.nombre= nombre ;
    }
    public boolean isNull(){
        if(evento.equals("")&& importancia.equals("")&&observacion.equals("")&&fechaString.equals("")){
            return false;

        }else{
            return true;
        }
    }



    //CONSTRUCTORESS
    public void setEvento(String evento) {
        this.evento = evento;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEvento() {
        return evento;
    }

    public String getImportancia() {
        return importancia;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getFechaString() {
        return fechaString;
    }
}
