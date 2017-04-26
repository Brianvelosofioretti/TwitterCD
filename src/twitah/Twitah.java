/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitah;

/**
 *
 * @author Brian
 */
import javax.swing.JOptionPane;

public class Twitah {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Metodos.conecta();



    
 /**
 * Application menu
 */
       int select;
             
       do {
  select = Integer.parseInt(JOptionPane.showInputDialog("1. Nuevo estado \n 2.TimeLine \n 3.BuscarTwit \n 4.Mensaje  \n5. salir"));
    switch(select){
        
        case 1:Metodos.twitear(JOptionPane.showInputDialog("Introducir nuevo Estado"));
            break;
        case 2:Metodos.lineaTiempo();
            break;
        case 3:Metodos.buscarTwit(JOptionPane.showInputDialog("Introduce el hastag"));   
            break;
        case 4:Metodos.enviarMensaje(JOptionPane.showInputDialog("Introduce destinatario"),JOptionPane.showInputDialog("Introduce el mensaje"));
            break;
        
    }
  
          }while(select<5);
    }
}
