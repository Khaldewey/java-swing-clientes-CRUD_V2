/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.customer.crud.domain;



/**
 *
 * @author W10
 */
public class Produto implements Persistencia {
    
    private Long codigo; 
    private String nome; 

//    @Override
//    public Long getCodigo() {
//        return codigo;
//    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    
}
