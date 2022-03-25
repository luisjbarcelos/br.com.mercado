package br.com.mercado.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercado.JPAUtil.Factory;
import br.com.mercado.domain.Produto;

public class ProdutoDAO {

private static EntityManager gerente;
    
    
    public static void cadastrar(Produto produto) {
        
        try {
            
        	gerente = Factory.RetornaEntityManager();
              
              gerente.getTransaction().begin();

              gerente.persist(produto);

              gerente.getTransaction().commit();
            
              
            System.out.println("Produto cadastrado com sucesso!!");

        }catch (Exception erro) {
                erro.printStackTrace();
                System.out.println("Não foi possível cadastrar esse produto");
        }finally {
            
            
            gerente.close();
        }
    }
    
    public static List<Produto> listar(){
        
        try {
            
        	 gerente = Factory.RetornaEntityManager();
            
            
             gerente.getTransaction().begin();
             
             String jpql = "SELECT p FROM Produto p ORDER BY p.id";
            
             return gerente.createQuery(jpql, Produto.class).getResultList();

             
        }catch (Exception erro) {
            erro.printStackTrace();
            System.out.println("Não foi possível listar os produtos");
        }finally {
            
            gerente.close();
        }
        
        return null;
    }
    
    public static void editar(Produto produto) {
        try {
            
        	  gerente = Factory.RetornaEntityManager();
              
              gerente.getTransaction().begin();
              
              gerente.merge(produto);

              gerente.getTransaction().commit();
            
              
                System.out.println("Produto editado com sucesso!!");

        }catch (Exception erro) {
                erro.printStackTrace();
                System.out.println("Não tem produto com esse id");
        }finally {
            
            
            gerente.close();
        }
    }
    
    public static List<Produto> listarPorNome(String nome){
        
        try {
            
        	 gerente = Factory.RetornaEntityManager();
            
            
             gerente.getTransaction().begin();
             
             String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome ";
            
             return gerente.createQuery(jpql, Produto.class).setParameter("nome" , nome ).getResultList();

             
        }catch (Exception erro) {
            erro.printStackTrace();
            System.out.println("Não foi possível listar os produtos com esse nome");
        }finally {
            
            gerente.close();
        }
        
        return null;
	
}

    public static void deletar(Produto produto) {
        try {

        gerente = Factory.RetornaEntityManager();

        gerente.getTransaction().begin();

        produto = gerente.merge(produto);

        gerente.remove(produto);

        gerente.getTransaction().commit();

        System.out.println("Produto deletado com sucesso!!");


    }catch (Exception erro) {
        erro.printStackTrace();
        System.out.println("Não foi possível deletar o produto os produtos com esse nome");
    }finally {

        gerente.close();
    }

}
}
