package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDao;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.util.util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author danie
 */
@Named(value="controleCidade")
@ViewScoped
public class ControleCidade implements Serializable{
    @EJB
    private CidadeDao dao;
    private Cidade objeto;

    public ControleCidade() {
    }
    
    public String listar(){
        return "/privado/Cidade/listar?faces-redirect=true";
    }
    public void novo(){
        objeto = new Cidade();
    }
    
    public void alterar(Object id){
        try{
            objeto = dao.getObjetctByIdj(id);
            
        }catch(Exception e){
            util.mensagemErro("Erro ao recuperar  objeto: " + util.getMensagemErro(e));
        }
    }
    
    public void remover(Object id){
        try{
            objeto = dao.getObjetctByIdj(id);
            dao.remove(objeto);
            util.mensagemInform("objeto removido com sucesso!");
        }catch(Exception e){
            util.mensagemErro("erro ao remover objeto: "+ util.getMensagemErro(e));
        }
    }

    public void salvar(){
        try{
            if(objeto.getId() == null){
                dao.persist(objeto);
            }else{
                dao.merge(objeto);
            }
            util.mensagemInform("objeto persistido com sucesso!");
        }catch(Exception e ){
            util.mensagemErro("erro ao persistir objeto : "+ util.getMensagemErro(e));
        }
    }
    
    
    public CidadeDao getDao() {
        return dao;
    }

    public void setDao(CidadeDao dao) {
        this.dao = dao;
    }

    public Cidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Cidade objeto) {
        this.objeto = objeto;
    }
    
    
}
