/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.customer.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import swing.customer.crud.dao.generic.GenericDAO;
import swing.customer.crud.domain.Cliente;



/**
 * @author israel.alves
 */
public class ClienteMapDAO extends GenericDAO<Cliente> implements IClienteDAO {

    

      public ClienteMapDAO() {
        super();

      }
      
      @Override
      public Class<Cliente> getTipoClasse() {
        return Cliente.class;
        
        
      } 
      
      @Override
      public void alterarLogica(Cliente cliente, Cliente clienteCadastrado) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
      }
//    private Map<Long, Cliente> map;
//
//    public ClienteMapDAO() {
//        this.map = new HashMap<>();
//    }
//
//    @Override
//    public Boolean cadastrar(Cliente cliente) {
//        if (this.map.containsKey(cliente.getCpf())) {
//            return false;
//        }
//        this.map.put(cliente.getCpf(), cliente);
//        return true;
//    }
//
//    @Override
//    public void excluir(Long cpf) {
//        Cliente clienteCadastrado = this.map.get(cpf);
//
//        if (clienteCadastrado != null) {
//            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
//        }
//    }
//
//    @Override
//    public void alterar(Cliente cliente) {
//        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
//        if (clienteCadastrado != null) {
//            clienteCadastrado.setNome(cliente.getNome());
//            clienteCadastrado.setTel(cliente.getTel());
//            clienteCadastrado.setNumero(cliente.getNumero());
//            clienteCadastrado.setEnd(cliente.getEnd());
//            clienteCadastrado.setCidade(cliente.getCidade());
//            clienteCadastrado.setEstado(cliente.getEstado());
//        }
//    }
//
//    @Override
//    public Cliente consultar(Long cpf) {
//        return this.map.get(cpf);
//    }
//
//    @Override
//    public Collection<Cliente> buscarTodos() {
//        return this.map.values();
//    }

    
}