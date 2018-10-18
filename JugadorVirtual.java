/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import javax.sound.sampled.AudioSystem;

/**
 *
 * @author abel
 */
public class JugadorVirtual extends Jugador{

public JugadorVirtual(ArrayList fichas){
    super(fichas);  
}

public Ficha dameFicha(Ficha x){
    
if (x!=null)
  {
      for(int i=0;i<fichas.size();i++)
    {Ficha f=(Ficha)fichas.get(i);
      if (f.e1==x.e1||f.e1==x.e2) { try{
    audio= AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/domino/ficha.wav"));
    clip = AudioSystem.getClip();
    clip.open(audio);
    clip.start();
   
    }catch(Exception ex){ex.printStackTrace();}
          
                                     f.punta=f.e1;    
                                    return f;}
      if (f.e2==x.e1||f.e2==x.e2) { try{
    audio= AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/domino/ficha.wav"));
    clip = AudioSystem.getClip();
    clip.open(audio);
    clip.start();
   
    }catch(Exception ex){ex.printStackTrace();}
          
          f.punta=f.e2;    
                                    return f;}
    }
  }
else {try{
    audio= AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/domino/ficha.wav"));
    clip = AudioSystem.getClip();
    clip.open(audio);
    clip.start();
   
    }catch(Exception ex){ex.printStackTrace();}
    
       Ficha f=(Ficha)fichas.get(0);f.punta=f.e1;
      return f; }

return null;
}



}
