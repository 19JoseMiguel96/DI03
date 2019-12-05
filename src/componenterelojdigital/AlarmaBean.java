/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenterelojdigital;

import java.beans.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jose Miguel
 */
public class AlarmaBean implements Serializable {

   
    
    public String hora;
    private String minutos;
    private PropertyChangeSupport propertySupport;
    
    
    
    public AlarmaBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
     
    /**
     * Get the value of hora
     *
     * @return the value of hora
     */
    public String getHora() {
        return hora;
    }
    /**
     * Set the value of hora
     *
     * @param hora new value of hora
     */
    public void setHora(String hora) {
        String old = this.hora;
        this.hora = hora;
        this.propertySupport.firePropertyChange("hora", old, hora);
    }
        /**
     * Get the value of hora
     *
     * @return the value of hora
     */
    public String getMinutos() {
        return minutos;
    }
    /**
     * Set the value of hora
     *
     * @param hora new value of hora
     */
    public void setMinutos(String minutos) {
        String old = this.minutos;
        this.minutos = minutos;
        this.propertySupport.firePropertyChange("minutos", old, minutos);
    }
    public static AlarmaBean createAlarmaBean(String alarma){
        AlarmaBean ret = new AlarmaBean();
        ret.hora = alarma;
        ret.minutos = alarma;
        return ret;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(hora);
        sb.append(":");
        sb.append(minutos);
        return sb.toString();
    }
    
}
