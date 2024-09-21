/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package swing.customer.crud.dao.generic;

import java.util.Collection;
import swing.customer.crud.domain.Persistencia;

/**
 *
 * @author W10
 */
public interface IGenericDAO <T extends Persistencia>{
    public Boolean cadastrar(T entity);

    public void excluir(Long valor);

    public void alterar(T entity);

    public T consultar(Long valor);

    public Collection<T> buscarTodos();
}
