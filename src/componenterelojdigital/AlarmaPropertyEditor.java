/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package componenterelojdigital;

import java.awt.Component;
import java.beans.*;

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
        AlarmaBean ret = (AlarmaBean) super.getValue();
        ret.setHora(editor.hora.getValue().toString());
        ret.setMinutos(editor.minutos.getValue().toString());
        return ret;
    }

    @Override
    public void setValue(Object alarma) {
        if(alarma==null){
            alarma = new AlarmaBean();
        }
        super.setValue(alarma);

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
        AlarmaBean bean = (AlarmaBean) getValue();
        StringBuffer ret = new StringBuffer();
        ret.append(AlarmaBean.class.getName());
        ret.append(".createAlarmaBean(\"");
        ret.append(bean.getHora());
        ret.append(":");
        ret.append(bean.getMinutos());
        ret.append("\")");
        return ret.toString();
    }



}
