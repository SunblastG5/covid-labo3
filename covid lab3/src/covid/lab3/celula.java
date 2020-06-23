/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.lab3;

/**
 *
 * @author Usuario
 */
public class celula {
    private String nombre;
    private String dr;
    private double fb;
    private String covid="";
    
    public celula(String n, String d, double f){
        this.nombre=n;
        this.dr=d;
        this.fb=f;     
    }
    
    public String mostrarcelula(){
        if (dr.equals("si")&&fb>38){
            this.covid=" V ";
        }
        else{
            this.covid=" M ";
        }
        return covid;
    }
}
