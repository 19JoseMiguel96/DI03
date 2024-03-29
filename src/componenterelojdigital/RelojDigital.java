package componenterelojdigital;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;
import java.util.EventObject;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/*
 *
 * @author Jose Miguel
 */
public class RelojDigital extends JLabel implements ActionListener,Serializable {
 /**
 *
 * @author usuario
 */ 
    protected SimpleDateFormat reloj;
    private boolean formato;    
    private AlarmaBean alarma;
    private Timer t;
    private PropertyChangeSupport propertySupport;
    

    public RelojDigital() {
        propertySupport = new PropertyChangeSupport(this);
        reloj = new SimpleDateFormat("hh:mm");        
        t = new Timer(1000, this);
        t.start();
    }
    
    /**
     * Get the value of formato
     *
     * @return the value of formato
     */
    public boolean isFormato() {
        return formato;
    }

    /**
     * Set the value of formato
     *
     * @param formato new value of formato
     */
    public void setFormato(boolean formato) {
        this.formato = formato;
    }

    /**
     * Get the value of reloj
     *
     * @return the value of reloj
     */
    public SimpleDateFormat getReloj() {
        return reloj;
    }

    /**
     * Set the value of reloj
     *
     * @param reloj new value of reloj
     */
    public void setReloj(SimpleDateFormat reloj) {
        this.reloj = reloj;
    }    
    /**
     * Get the value of alarma
     *
     * @return the value of alarma
     */
    public AlarmaBean getAlarma() {
        return alarma;
    }

    /**
     * Set the value of alarma
     *
     * @param alarma new value of alarma
     */
    public void setAlarma(AlarmaBean alarma) {
        AlarmaBean old = this.alarma;
        this.alarma = alarma;
        propertySupport.firePropertyChange("alarma", old, alarma);
    }
    
  public void actionPerformed(ActionEvent e) {
    propertySupport = new PropertyChangeSupport(this);
    Date d = new Date(); 
    //Si formato es true, será formato tipo 24H.
    if(formato==true){
        reloj = new SimpleDateFormat("HH:mm");
        super.setText(reloj.format(d));         
    }
    //Si formato es false, será formato tipo 12h.
    else if (formato == false){
        reloj = new SimpleDateFormat("hh:mm");
        super.setText(reloj.format(d));        
    }
    
  }
  
}
/**
 * 
SonarAlarmaListener miReceptor;
public void addSonarAlarmaListener( SonarAlarmaListener receptor ) {
    // No se permite que intente incorporar mas de un receptor
    if( miReceptor == null ) 
        miReceptor = receptor;
    else {
        System.out.println( "No se soportan multiples Receptores" );
        // Se sale, si se intentan registrar varios objetos Receptor
        System.exit( 0 );
        }
    }
  public void generarMiEvento() {
    miReceptor.capturarSonarAlarma( new SonarAlarmaEvent( this,alarma ) );
    }

    @Override
    public void capturarSonarAlarma(SonarAlarmaEvent ev) {
        //JOptionPane.showMessageDialog(null, "Alarma!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        
    }
  
    public class SonarAlarmaEvent extends EventObject {
        public AlarmaBean alarma;

        public SonarAlarmaEvent(Object source, AlarmaBean alarma) {
            super (source);
            this.alarma = alarma;
        }
    }
interface SonarAlarmaListener extends EventListener {
    void capturarSonarAlarma (SonarAlarmaEvent ev);
}
*/



    

