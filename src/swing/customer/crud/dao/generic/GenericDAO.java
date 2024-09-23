/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.customer.crud.dao.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import swing.customer.crud.domain.Persistencia;

/**
 *
 * @author W10
 */
public abstract class GenericDAO<T extends Persistencia> implements IGenericDAO<T>{

    protected Map<Class, Map<Long, T>> map;
    
    public abstract Class<T> getTipoClasse();
    
    public abstract void alterarLogica(T entity, T entityCadastrado);
    
    public GenericDAO(){
     this.map = new HashMap();
     Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        if(mapaInterno == null){
            mapaInterno = new HashMap<>();
            this.map.put(getTipoClasse(), mapaInterno);
        }
    }
    @Override
    public Collection<T> buscarTodos(){
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
       return mapaInterno.values();
     
    }

    @Override
    public T consultar(Long valor){
       Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
       return mapaInterno.get(valor); 
    }

    @Override
    public void alterar(T entity){
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
         T objetoCadastrado = mapaInterno.get(entity.getCodigo());
         if (objetoCadastrado != null) {
            alterarLogica(entity, objetoCadastrado);
        }
    }

    @Override
    public void excluir(Long valor){
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        T objetoCadastrado = mapaInterno.get(valor);

       if (objetoCadastrado != null) {
           this.map.remove(valor, objetoCadastrado);
        }
    }

    @Override
    public Boolean cadastrar(T entity){
     Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
     if (mapaInterno.containsKey(entity.getCodigo())) {
            return false;
      }
     mapaInterno.put(entity.getCodigo(), entity);
     return true;
    }
    
    
}
