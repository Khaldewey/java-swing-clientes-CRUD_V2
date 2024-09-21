
package swing.customer.crud.dao;

import java.util.Collection;
import swing.customer.crud.domain.Produto;

/**
 *
 * @author W10
 */
public interface IProdutoDAO {
    public Boolean cadastrar(Produto produto);

    public void excluir(Long codigo);

    public void alterar(Produto produto);

    public Produto consultar(Long codigo);

    public Collection<Produto> buscarTodos();
}
