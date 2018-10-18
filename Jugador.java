/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

/**
 *
 * @author abel
 */
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.*;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Jugador  implements Serializable{


ArrayList  fichas;
String nombre;
Clip clip;
 AudioInputStream audio;
 
public Jugador(ArrayList fichas){
   

this.fichas=fichas;

}

public boolean equals(Object x){
/*if (!(x instanceof Jugador)) return false;

int c=0;
for(int j=0;j<((Jugador)x).fichas.size();j++)
for(int i=0;i<fichas.size();i++)
if (fichas.get(i).equals(((Jugador)x).fichas.get(j))) c++;   

return (c==fichas.size()&&
        fichas.size()==((Jugador)x).fichas.size());

*/
return nombre.equals(((Jugador)x).nombre);

}

public boolean LLeva(int x){
boolean lleva=false;
for(int i=0;i<fichas.size();i++)
{Ficha f=(Ficha)fichas.get(i);
if (f.e1==x||f.e2==x) lleva=true;
}
return lleva;
}

public Ficha dameFicha(Ficha x){

 for(int i=0;i<fichas.size();i++)
{Ficha f=(Ficha)fichas.get(i);
if (f.seleccionada()) {
                      f.seleccionada(false);
                      
    try{
    audio= AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/domino/ficha.wav"));
    clip = AudioSystem.getClip();
    clip.open(audio);
    clip.start();
   
    }catch(Exception ex){ex.printStackTrace();}
                  
                     return f;}
}
return null;
}

}
