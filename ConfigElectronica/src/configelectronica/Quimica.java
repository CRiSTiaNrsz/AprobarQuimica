/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configelectronica;

import java.io.*;
import javax.swing.JOptionPane;


/**
 *
 * @author CRISTIAN
 */
public class Quimica {
   private int valoresElectrones[] = {2, 2, 6, 2, 6, 2, 10, 6, 2, 10, 6, 2, 14, 10, 6, 2, 14, 10, 6};
	private String NivelyOrbital[] = {"1s", "2s", "2p", "3s", "3p", "4s", "3d", "4p", "5s", "4d", "5p", "6s", "4f", "5d", "6p", "7s", "5f", "6d", "7p"};
	private int suma, electrones, n, diferencia;
	private String resultado, elementos, eyz[];//eyz=elementos y numero atomico
	private boolean encontrado;//comienza con falso por defecto
	private FileReader fr;
	private BufferedReader lector;
        private int s=0,numAtomico;

	public Quimica() {
		suma = 0;
		n = 0;
		resultado = "";
	}

	public String Configuracion(String z) {
           
		try {
                        //abrimos el archivo externo donde se encuentra los elementos de la tabla periodica con su numero atomico
			fr = new FileReader("abc.dic");
                 
                        //leemos del archivo ya abierto en la linea anterior
			lector = new BufferedReader(fr);
                        
                        //Aca lee el contenido exacto que esta escrito en Dic.dic
			elementos = lector.readLine();
                        
                        //na=[1,H,2,He,3,Li,.......Uuo]
			eyz = elementos.split("%");//aca era split("[%]+")
                       
                        //buscamos en todo el arreglo
			for (int x = 0; x < eyz.length; x++) {
                            //si el parametro "elemento" es igual a un elemento del arreglo
				if (eyz[x].equals(z) ) {
                                    /*if(eyz[x].equalsIgnoreCase("Exit")){
                                        break;
                                    }*/
                                    if(eyz[x].equals("0")){
                                        System.out.println("1s0");
                                    }
                                    //asignamos a electrones una posicion antes del elemento encontrado
                                    //porque en ese orden se ha definido el orden el numero atomico y su simbolo
					electrones = Integer.parseInt(eyz[x]);
                                        //System.out.println("El numero de electrones totales es:"+electrones);
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al leer diccionario");
		}
                //si el parametro "elemento" no se ha encontrado en el arreglo entonces decimos
                // que el elemento que estamos digitando no es un elemnto quimico
		if (electrones < 0) {
			resultado = "Elemento no encontrado";
		} else {
                    //en caso si se haya encontrado el elemento en el arreglo
			int contador = -1;
                        
                        //mientras encontrado sea verdadero
			while (!encontrado) {
				contador++;
				n = contador;
                                //el valor de suma viene a ser la iteracion de los subniveles de la config. electronica
				suma = suma + valoresElectrones[contador];
                                // entrado= la evaluacion si el numero de electrones del elemento es menor a la variablesuma
				encontrado = (suma < electrones) ? false : true;
			}
                        //obtenemos la cantidad de electrones que falta para completar el numero atomico ya que no completa
                        //totalmente un subnivel
			diferencia = valoresElectrones[n] - (suma - electrones);
                    
			for (int x = 0; x < n; x++) {
                            //concatenamos el resultado añadiendo los niveles con los subniveles
                            //resultado = resultado + NivelyOrbital[x] + "<sup>" + valoresElectrones[x] + "</sup> ";
				resultado = resultado + NivelyOrbital[x]  + valoresElectrones[x]+" " ;
                                s=s+valoresElectrones[x];
			}
             
                        //resultado = "<html>" + resultado + NivelyOrbital[n] + "<sup>" + diferencia + "</sup>";
			resultado =  resultado + NivelyOrbital[n] + diferencia+" " ;
                        numAtomico=s+diferencia;
                        System.out.println("El Z del elemento es: "+numAtomico);
		}
		return resultado;
	}
}
