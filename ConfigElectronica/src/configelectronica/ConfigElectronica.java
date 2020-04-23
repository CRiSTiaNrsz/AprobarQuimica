/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configelectronica;

import java.util.Scanner;


/**
 *
 * @author CRISTIAN
 */
public class ConfigElectronica {

    
    public static void main(String[] args) {
        Quimica q= new Quimica();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite el elemento de la tabla: ");
        String elemento = sc.nextLine();
        
        //si el elemento que digitamos es distinto de la cadena "exit" ejecutamos
        if(!elemento.equalsIgnoreCase("Exit")){
         
            //acotamos el numero de caracteres del elemento que vamos a digitar
            if(elemento.length()<=50 && !elemento.equalsIgnoreCase(" ") && elemento.length()>0 && !elemento.equalsIgnoreCase("  ") && !elemento.equalsIgnoreCase("   ") ){
                
                System.out.println("Digite el numero atomico Z: ");
                String num = sc.nextLine();
                
               //mientras el numero sea distinto de "exit" ejecutamos el codigo
                while(!num.equalsIgnoreCase("Exit") ){
                    //acotamos el numro atomico
                    if(Integer.parseInt(num)<=118 && Integer.parseInt(num)>=0 ){
                    //imprimimos la consifguracion electronica por consola
                    System.out.println(q.Configuracion(num));
                    }else{
                        System.out.println("Digitar un numero entre el 0 y 118");
                    }
                    //en caso se digite exit entonces cerraremos el programa
                    break;
                }
            // en caso que el tamano de de la cadena del elemento que digitamos sea mayor a 50 y menor a 0
            }else if(elemento.length()>50 || elemento.length()<=0){
                System.out.println("El tamaño de elemento digitado es: "+elemento.length() +" Debe ser menor a 51 caracteres y mayor a 0 caracteres");
            }
          
        }else{
           
        }
        
    }
    
}

