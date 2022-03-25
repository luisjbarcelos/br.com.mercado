package br.com.mercado.execucao;

import java.util.List;
import java.util.Scanner;

import br.com.mercado.DAO.ProdutoDAO;
import br.com.mercado.DAO.UsuarioDAO;
import br.com.mercado.domain.Produto;
import br.com.mercado.domain.Usuario;



public class Principal {

	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		Scanner valor = new Scanner(System.in);
		Scanner res = new Scanner(System.in);
		Scanner res2 = new Scanner(System.in);
		Scanner res3 = new Scanner(System.in);
		Scanner res4 = new Scanner(System.in);
		Scanner res5 = new Scanner(System.in);
		Boolean validaLogin = true; 
		
		
		SISTEMA:
		for(int cont = 0; cont == 0;) {
			System.out.println("---------------//-----------------//----------"); 
			System.out.println("DIGITE 1 PARA LOGAR");
			System.out.println("DIGITE 2 PARA CADASTRAR-SE");
			System.out.println("---------------//-----------------//----------"); 
			int resposta = res3.nextInt();
			
			if(resposta == 1 ) {
				System.out.println("DIGITE SEU NOME: ");
				String nomeUser = res5.nextLine();
				System.out.println("DIGITE SUA SENHA: ");
				String senhaUser = res4.nextLine();
				
				List<Usuario> listarNome = UsuarioDAO.retornaEmailEncontrado(nomeUser);
				List<Usuario> listarSenha = UsuarioDAO.retornaSenhaEncontrada(senhaUser);
				
				if(listarNome.size() == 0 || listarSenha.size() == 0 ) {
					 
					System.out.println("EMAIL NÃO CADASTRADO");
					validaLogin = false;
					
				}else if(!(listarNome.size() == 0) && !(listarSenha.size() ==0) ) {
					 
					System.out.println("ACESSO LIBERADO");
					
					validaLogin = true;
				}
					
				
			}else if(resposta == 2) {
				
				Usuario user = new Usuario();
				
				System.out.println("DIGITE SEU NOME: ");
				 user.setNome(res5.nextLine()); 
				
				System.out.println("DIGITE SUA SENHA: ");
				user.setSenha(res4.nextLine());
				
				
				
				UsuarioDAO.cadastrar(user);
				System.out.println("---------------//-----------------//----------"); 
				System.out.println("AGORA TENTE REALIZAR SEU LOGIN");
				System.out.println("DIGITE SEU NOME: ");
				String nomeUser = res5.nextLine();
				System.out.println("DIGITE SUA SENHA: ");
				String senhaUser = res4.nextLine();
				
				List<Usuario> listarNome = UsuarioDAO.retornaEmailEncontrado(nomeUser);
				List<Usuario> listarSenha = UsuarioDAO.retornaSenhaEncontrada(senhaUser);
				
				if(listarNome.size() == 0 || listarSenha.size() == 0 ) {
					 
					System.out.println("EMAIL NÃO CADASTRADO");
					validaLogin = false;
					
				}else if(!(listarNome.size() == 0) && !(listarSenha.size() ==0) ) {
					System.out.println("---------------//-----------------//----------"); 
					System.out.println("ACESSO LIBERADO");
					System.out.println("---------------//-----------------//----------"); 
					validaLogin = true;
				}
				
			}
			
		

			if(validaLogin == true) {
			
			
			for(int cont10 = 0 ; cont10 ==0;) {
				System.out.println("---------------//-----------------//----------"); 
				System.out.println("ESCOLHA UMA OPÇÃO");
				System.out.println("DIGITE 1 PARA CADASTRAR UM PRODUTO");
				System.out.println("DIGITE 2 PARA LISTAR OS PRODUTOS");
				System.out.println("DIGITE 3 PARA EDITAR UM PRODUTO");
				System.out.println("DIGITE 4 PARA ENCONTRAR UM PRODUTO PELO NOME");
				System.out.println("DIGITE 5 PARA DELETAR UM PRODUTO PELO IDENTIFICADOR");
				System.out.println("DIGITE 6 PARA SAIR");
				System.out.println("---------------//-----------------//----------"); 
			
			
			
			
			int respostas = res.nextInt();
			
			if(respostas == 1) {
				try {

					Produto p1 = new Produto();
					System.out.println("ADICIONE O NOME DO PRODUTO");
					p1.setNome(scan.nextLine()); 
					
					System.out.println("ADICIONE A QUANTIDADE DO PRODUTO");
					p1.setQuant(scan.nextInt());
					
					System.out.println("ADICIONE O VALOR DO PRODUTO");
					p1.setValor(valor.nextDouble());
					
					
					try {

						ProdutoDAO.cadastrar(p1);
						
						
					
					} catch (Exception erro) {
						System.out.println("Erro ao tentar salvar o produto");
						erro.printStackTrace();
					}
					
					
				} catch (Exception error) {
					System.out.println("ERROR 212");
					error.printStackTrace();
				}
			}
			
			else if(respostas==2) {
				
				try {
					

					List<Produto> lista = ProdutoDAO.listar();
				
					
				
					for (int cont2 = 0; cont2 < lista.size(); cont2++) {
						System.out.println("ID PRODUTO: " + lista.get(cont2).getId());
						System.out.println("NOME PRODUTO: " + lista.get(cont2).getNome());
						System.out.println("QUANTIDADE PRODUTO: " + lista.get(cont2).getQuant());
						System.out.println("VALOR PRODUTO: " + lista.get(cont2).getValor());
						System.out.println("--------//--------------------------//-----------");
					}
				} catch (Exception error) {
				}
			}
			
			if(respostas == 3) {
				Scanner res6 = new Scanner(System.in);
				Scanner res7 = new Scanner(System.in);
				Scanner res8 = new Scanner(System.in);
				
				System.out.println("DIGITE O ID DO PRODUTO");
				int id = valor.nextInt();
				
				Produto p1Update = new Produto();
				p1Update.setId(id);
				
				System.out.println("DIGITE O NOVO NOME DO PRODUTO");
				p1Update.setNome(res6.nextLine()); 
				
				System.out.println("DIGITE A NOVA QUANTIDADE DO PRODUTO");
				p1Update.setQuant(res7.nextInt());
				
				System.out.println("DIGITE O NOVO VALOR DO PRODUTO");
				p1Update.setValor(res8.nextDouble());
			
				
				ProdutoDAO.editar(p1Update);
				
				
			}else if(respostas == 4) {
				
				
				Produto p2 = new Produto();
				Scanner res10 = new Scanner(System.in);
				
				
				System.out.println("DIGITE O NOME DO PRODUTO :");
				List<Produto> listarPorNome = ProdutoDAO.listarPorNome(res10.nextLine());
				
				for (int cont5 = 0; cont5 < listarPorNome.size(); cont5++) {
					System.out.println("ID PRODUTO: " + listarPorNome.get(cont5).getId());
					System.out.println("NOME PRODUTO: " + listarPorNome.get(cont5).getNome());
					System.out.println("QUANTIDADE PRODUTO: " + listarPorNome.get(cont5).getQuant());
					System.out.println("VALOR PRODUTO: " + listarPorNome.get(cont5).getValor());
					System.out.println("---------------------------------------------");
				}
				
			
				
			}else if(respostas == 5) {
				
				Produto p = new Produto();
				Scanner res9 = new Scanner(System.in);
				
				System.out.println("DIGITE O ID DO PRODUTO QUE DESEJA DELETAR");
				p.setId(res9.nextInt());
				
				ProdutoDAO.deletar(p);
			}
			else if(respostas == 6) {
				
				continue SISTEMA;
				
			}
			}
			}}}}
	

			
