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
public class Gestionador {
    int max=10;
    celula [][]tabla1= new celula[max][max];
    String [][]tabla2= new String[max][max];
    String [][]tabla3= new String[max][max];
    
    public Gestionador(){
    }
    
    public String Ingresardatos(int i, int j, String n, String d, double f){
        celula C= new celula(n,d,f);
        this.tabla1[i][j]=C;
        System.out.println("tabla["+(i+1)+"] ["+(j+1)+"] "+tabla1[i][j].mostrarcelula());
        return "Agregado exitosamente";
    }
    
    public String mostrartabla(){
        String dato="<html>";
        for(int i=0;i<max;i++){
            for (int j=0;j<max;j++){
                try{
                    tabla2[i][j]=tabla1[i][j].mostrarcelula();
                    dato=dato+tabla2[i][j];
                }
                catch (NullPointerException ex){
                    if (tabla1[i][j]==null){
                        tabla2[i][j]=" * ";
                        dato=dato+" * ";
                    }
                }
            }
            dato=dato+"<p>";
        }
        return dato;
    }
    
    
    public String compararmatriz(){
        String nuevodato="<html>";
        int v;
        for(int i=0;i<max;i++){
            for(int j=0;j<max;j++){
                //comparacion de las casillas vecinas
                v=0;
                for (int k=i-1;k<=3;k++){
                    for (int l=j-1;l<=3;l++){
                        if(!(k==i && l==j)){
                            try{
                                if(" V ".equals(tabla2[k][l])){
                                    v++;
                                }
                            }
                            catch(ArrayIndexOutOfBoundsException gaea){}
                        }  
                    }    
                }
                //fin de la comparacion
                if(" M ".equals(tabla2[i][j]) && v>2){
                    nuevodato=nuevodato+" V ";
                }
                else{
                    if(" V ".equals(tabla2[i][j]) && v<3){
                        nuevodato=nuevodato+" M ";
                    }   
                    else{
                        nuevodato=nuevodato+tabla2[i][j];
                    }
                }
            }
            nuevodato=nuevodato+"<p>";
        }
        return nuevodato;
    }
}
