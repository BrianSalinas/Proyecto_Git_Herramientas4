package com.example.laboratorio_1;
public class Vocales {
    //se utiliza la encapsulacion para poder trabajar con las variables
    private String frase;

    //se crea el contructor con la unica propiedad del objeto Vocales
    public Vocales(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    //En este metodo se procede a contar las vocales dentro de la frase ingresada
    public String contarFrases(){
        Integer cantidad = 0, cantidadC=0;
        for(int i = 0;i<frase.length();i++) {
            // se realiza un ciclo for que va a recorrer cada una de las letras del la cadena
            if(frase.charAt(i)=='a' || frase.charAt(i)=='e' || frase.charAt(i)=='i' || frase.charAt(i)=='o' || frase.charAt(i)=='u'||
                    frase.charAt(i)=='A' || frase.charAt(i)=='E' || frase.charAt(i)=='I' || frase.charAt(i)=='O' || frase.charAt(i)=='U')
                cantidad++;
            else
                cantidadC++;
        }
        String res ="Cantidad de vocales: " + cantidad;
        return res;
    }
    public String contarNVocales(){
        Integer cantidad = 0, cantidadNV=0;
        for(int i = 0;i<frase.length();i++) {
            // se realiza un ciclo for que va a recorrer cada una de las letras del la cadena
            if(frase.charAt(i)!='a' && frase.charAt(i)!='e' && frase.charAt(i)!='i' && frase.charAt(i)!='o' && frase.charAt(i)!='u'&&
                    frase.charAt(i)!='A' && frase.charAt(i)!='E' && frase.charAt(i)!='I' && frase.charAt(i)!='O' && frase.charAt(i)!='U')
                cantidadNV++;
        }
        String res ="Cantidad de no vocales: " + cantidadNV;
        return res;
    }
}