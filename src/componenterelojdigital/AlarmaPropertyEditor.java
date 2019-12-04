/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package componenterelojdigital;

import java.awt.Component;
import java.beans.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AddressBean property editor. This can be used as a property editor for properties using this bean.
 * @author Wade Chandler
 * @version 1.0
 */
public class AlarmaPropertyEditor extends PropertyEditorSupport {

    private PanelAlarma editor = null;

    public AlarmaPropertyEditor() {
        this.editor = new PanelAlarma();
    }

    @Override
    public Component getCustomEditor() {
        return editor;
    }

    @Override
    public String[] getTags() {
        return null;
    }
    
    @Override
    public Object getValue() {
        if(super.getValue()==null){
            setValue(null);
        }
        Alarma ret = (Alarma) super.getValue();
        ret.setHora(editor.hora.getText());
        return ret;
    }

    @Override
    public void setValue(Object hora) {
        if(hora==null){
            hora = new Alarma();
        }
        super.setValue(hora);

    }

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public String getAsText(){
        return super.getAsText();
    }

    @Override
    public void setAsText(String text){
        throw new IllegalArgumentException("Please use the editor.");
    }
    
    @Override
    public String getJavaInitializationString() {
        Alarma bean = (Alarma) getValue();
        StringBuffer ret = new StringBuffer();
        ret.append(Alarma.class.getName());
        ret.append(".createAlarmaBean(\"");
        ret.append(bean.getHora());
        ret.append("\")");
        return ret.toString();
    }



}
