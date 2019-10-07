package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AeroportoDao;
import br.edu.ifsul.dao.CidadeDao;
import br.edu.ifsul.dao.ClasseDao;
import br.edu.ifsul.modelo.Aeroporto;
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
@Named(value="controleAeroporto")
@ViewScoped
public class ControleAeroporto implements Serializable{
    @EJB
    private  AeroportoDao dao;
    private  Aeroporto objeto;
    @EJB
    private CidadeDao daoCidade;
    
    public ControleAeroporto() {
    }
    
    public String listar(){
        return "/privado/Aeroporto/listar?faces-redirect=true";
    }
    public void novo(){
        objeto = new  Aeroporto();
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
    
    public  AeroportoDao getDao() {
        return dao;
    }

    public void setDao( AeroportoDao dao) {
        this.dao = dao;
    }

    public  Aeroporto getObjeto() {
        return objeto;
    }

    public void setObjeto( Aeroporto objeto) {
        this.objeto = objeto;
    }

    public CidadeDao getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDao daoCidade) {
        this.daoCidade = daoCidade;
    }
        
    
}
