/**@author Diego Henrique Sousa Garcia*/

import java.util.*;

public class TesteGerenciador {


	public static void main (String [] args){

		Gerenciador gerenciador = new Gerenciador();
		Scanner entrada = new Scanner (System.in);
		boolean sair = false;

		do{

			System.out.println("\n-----------------SISTEMA DE GERENCIAMENTO--------------------"); 
			System.out.println("[1] - Cadastrar Cargo"); 
			System.out.println("[2] - Cadastrar Perfil");
			System.out.println("[3] - Cadastrar Usuario");
			System.out.println("[4] - Editar Cargo"); 
			System.out.println("[5] - Editar Perfil");
			System.out.println("[6] - Editar Usuario");
			System.out.println("[7] - Listar os Cargos em ordem alfabetica"); 
			System.out.println("[8] - Listar os Perfis em ordem alfabetica");
			System.out.println("[9] - Remover cargos sem usuarios vinculados");
			System.out.println("[10] - Remover perfis sem usuarios vinculados");
			System.out.println("[0] - Sair");

			int opcao = entrada.nextInt(); 

			switch (opcao) {
				
				case 0: sair = true; break;
				case 1: gerenciador.cadastrarCargo(); break;
				case 2: gerenciador.cadastrarPerfil(); break;
				case 3: gerenciador.cadastrarUsuario(); break;
				case 4: gerenciador.editarCargo(); break;
				case 5: gerenciador.editarPerfil(); break;
				case 6: gerenciador.editarUsuario(); break;
				case 7: gerenciador.ordenarCargos(); break;
				case 8: gerenciador.ordenarPerfis(); break;
				case 9: gerenciador.removerCargo(); break;
				case 10: gerenciador.removerPerfil(); break;
				//case 11: gerenciador.imprimir(gerenciador.getUsuarios()); break; 
				default: System.out.println("Comando invalido!"); break;
			}

		}while(sair == false);
	}
}
