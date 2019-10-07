
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author danie
 */
@Stateful
public class PessoaDao extends DAOGenerico<Pessoa> implements Serializable{
    public PessoaDao(){
        super();
        classePersistente = Pessoa.class;
    }
}
