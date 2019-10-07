
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aeroporto;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author danie
 */
@Stateful
public class AeroportoDao extends DAOGenerico<Aeroporto> implements Serializable{
    public AeroportoDao(){
        super();
        classePersistente = Aeroporto.class;
    }
}
