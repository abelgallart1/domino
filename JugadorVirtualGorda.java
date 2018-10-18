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
public class JugadorVirtualGorda extends JugadorVirtual{
   
   
     
     // Arboljuego arbol;  
     
    public JugadorVirtualGorda(ArrayList fichas){
    super(fichas);  
            
    
}

    
public Ficha dameFicha(Ficha x){
if (x!=null)
    
    
  { try{
    audio= AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/domino/ficha.wav"));
    clip = AudioSystem.getClip();
    clip.open(audio);
    clip.start();
   
    }catch(Exception ex){ex.printStackTrace();}
      
      ArrayList llevo=new ArrayList();
   
      for(int i=0;i<fichas.size();i++)
      {        
       Ficha f=(Ficha)fichas.get(i);
             
       if (f.e1==x.e1||f.e1==x.e2) { f.punta=f.e1;
                                    llevo.add(f);
                                     }
                                    
                                        
       if (f.e2==x.e1||f.e2==x.e2) { f.punta=f.e2;    
                                     llevo.add(f);
                                                               
                                    }
       }
   
    int mayor=-1;Ficha MAYOR=null; 
    for(int i=0;i<llevo.size();i++)
     {Ficha f=(Ficha)llevo.get(i);
      int aux=f.e1+f.e2;
      if (mayor<aux) {mayor=aux;MAYOR=f;}
    
     }
    if (MAYOR!=null) return MAYOR;   
  
  }
else {try{
    audio= AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/domino/ficha.wav"));
    clip = AudioSystem.getClip();
    clip.open(audio);
    clip.start();
   
    }catch(Exception ex){ex.printStackTrace();}
    
     int mayor=0;Ficha MAYOR=null; 
     for(int i=0;i<fichas.size();i++)
     {Ficha f=(Ficha)fichas.get(i);
      int aux=f.e1+f.e2;
      if (mayor<aux) {mayor=aux;MAYOR=f;}
     }
     MAYOR.punta=MAYOR.e1;
    return MAYOR;  }

return null;
}



    
    
    
}
