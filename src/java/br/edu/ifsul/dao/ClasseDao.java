
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Classe;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author danie
 */
@Stateful
public class ClasseDao extends DAOGenerico<Classe> implements Serializable{
    public ClasseDao(){
        super();
        classePersistente = Classe.class;
    }
}
