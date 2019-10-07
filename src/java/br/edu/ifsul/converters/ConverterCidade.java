package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danie
 */

@Named(value="converterCidade")
@RequestScoped
public class ConverterCidade  implements Serializable,Converter{

    @PersistenceContext(unitName="aeroporto_webPU")
    private EntityManager em; 
    // converte da tela pro objeto 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Cidade.class,Integer.parseInt(string));
    }
    // converte do objeto pra tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if(t == null){
            return null;
        }
        
        Cidade obj = (Cidade) t;
        return obj.getId().toString();
    }
}
