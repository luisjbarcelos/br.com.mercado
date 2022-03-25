package br.com.mercado.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercado.JPAUtil.Factory;
import br.com.mercado.domain.Usuario;

public class UsuarioDAO {
	
	private static EntityManager gerente;
	public static List<Usuario> retornaEmailEncontrado(String nome) {

        try {
              gerente = Factory.RetornaEntityManager();
              
              gerente.getTransaction().begin();

              String jpql = "SELECT u FROM Usuario u WHERE u.nome = :nome";

              List<Usuario> listarPorNome = gerente.createQuery(jpql, Usuario.class).setParameter("nome" , nome ).getResultList();
              
              
             
              gerente.getTransaction().commit();
            
              
              return listarPorNome;

              
        }catch (Exception erro) {
                erro.printStackTrace();
                System.out.println("Não foi possível cadastrar esse produto");
        }finally {
            
            
            gerente.close();
        }
        
        return null;
    }
    
    
    public static List<Usuario> retornaSenhaEncontrada(String senha) {

        try {
              gerente = Factory.RetornaEntityManager();
              
              gerente.getTransaction().begin();

              String jpql = "SELECT u FROM Usuario u WHERE u.senha = :senha";

              List<Usuario> listarPorSenha = gerente.createQuery(jpql, Usuario.class).setParameter("senha" , senha ).getResultList();
              
             
              gerente.getTransaction().commit();
            
              
              return listarPorSenha;

              
        }catch (Exception erro) {
                erro.printStackTrace();
                System.out.println("Não foi possível cadastrar esse produto");
        }finally {
            
            
            gerente.close();
        }
        
        return null;
    }
    
    
public static void cadastrar(Usuario user) {
        
        try {
            
              gerente = Factory.RetornaEntityManager();
              
              gerente.getTransaction().begin();

              gerente.persist(user);

              gerente.getTransaction().commit();
            
              
            System.out.println("Usuário cadastrado com sucesso!!");

        }catch (Exception erro) {
                erro.printStackTrace();
                System.out.println("Não foi possível cadastrar esse usuario");
        }finally {
            
            
            gerente.close();
        }
    }
}
