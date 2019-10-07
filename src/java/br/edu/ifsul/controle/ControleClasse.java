package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ClasseDao;
import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.util.util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author danie
 */
@Named(value="controleClasse")
@ViewScoped
public class ControleClasse implements Serializable{
    @EJB
    private ClasseDao dao;
    private Classe objeto;

    public ControleClasse() {
    }
    
    public String listar(){
        return "/privado/Classe/listar?faces-redirect=true";
    }
    public void novo(){
        objeto = new Classe();
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
    
    public ClasseDao getDao() {
        return dao;
    }

    public void setDao(ClasseDao dao) {
        this.dao = dao;
    }

    public Classe getObjeto() {
        return objeto;
    }

    public void setObjeto(Classe objeto) {
        this.objeto = objeto;
    }
    
    
}
