
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author danie
 */
@Stateful
public class CidadeDao extends DAOGenerico<Cidade> implements Serializable{
    public CidadeDao(){
        super();
        classePersistente = Cidade.class;
    }
}
