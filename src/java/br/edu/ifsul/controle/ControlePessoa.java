package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PessoaDao;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.util.util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author danie
 */
@Named(value="controlePessoa")
@ViewScoped
public class ControlePessoa implements Serializable{
    @EJB
    private PessoaDao dao;
    private Pessoa objeto;

    public ControlePessoa() {
    }
    
    public String listar(){
        return "/privado/Pessoa/listar?faces-redirect=true";
    }
    public void novo(){
        objeto = new Pessoa();
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
    
    public PessoaDao getDao() {
        return dao;
    }

    public void setDao(PessoaDao dao) {
        this.dao = dao;
    }

    public Pessoa getObjeto() {
        return objeto;
    }

    public void setObjeto(Pessoa objeto) {
        this.objeto = objeto;
    }
    
    
}
