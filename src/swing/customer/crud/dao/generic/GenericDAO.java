/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.customer.crud.dao.generic;

import annotations.TipoChave;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import swing.customer.crud.domain.Persistencia;

/**
 *
 * @author W10
 */
public abstract class GenericDAO<T extends Persistencia> implements IGenericDAO<T>{

    protected Map<Class, Map<Long, T>> map;
    
    public abstract Class<T> getTipoClasse();
    
    public abstract void alterarLogica(T entity, T entityCadastrado);
    
    //Método para capturar chave única de objeto através de anotação
    public Long getChave(T entity){
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)){
               TipoChave tipoChave = field.getAnnotation(TipoChave.class);
               String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    Long value = (Long) method.invoke(entity);
                    return value;
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        }
      return null;
    }
    
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
         Long chave = getChave(entity);
         T objetoCadastrado = mapaInterno.get(chave);
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
     Long chave = getChave(entity);
     if (mapaInterno.containsKey(chave)) {
            return false;
      }
     // Uso de método que pega chave através de anotação
     
     mapaInterno.put(chave, entity);
     return true;
    }
    
    
}
