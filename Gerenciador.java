import java.util.*;
/**Classe responsável pelo gerenciamento dos usuários, cargos e perfis.
 * Ela é composta por métodos de cadastros, edição, remoção e ordenação.*/
public class Gerenciador{

	private List<Cargo> cargos;
	private List<Perfil> perfis;
	private List<Usuario> usuarios;
	private Scanner entrada;
	
	/**Cria três Listas inicialmente vazias. Elas representam um conjunto de usários, cargos e perfis.*/	
	
	public Gerenciador(){

		cargos = new ArrayList<>();
		perfis = new ArrayList<>();
		usuarios = new ArrayList<>();
		entrada = new Scanner(System.in);
	}
	
	/**Retorna os cargos de uma lista.*/
	
	public List<Cargo> getCargos(){
		
		return cargos;
	}
	
	/**Retorna os perfis de uma lista.*/
	
	public List<Perfil> getPerfis(){
		
		return perfis;
	}
	
	/**Retorna os usuarios de uma lista.*/
	
	public List<Usuario> getUsuarios(){
		
		return usuarios;
	}

	/**Insere um novo cargo na lista de cargos e garante que só sejam cadastrados cargos com nomes diferentes.*/
	
	public void cadastrarCargo(){
		
		if(cargos.isEmpty()){	
	
			System.out.print("\nDigite o nome do Cargo: ");
			String nome = entrada.nextLine();
		
			Cargo cargo = new Cargo(nome);
			cargos.add(cargo);
		}
		else{
			
			System.out.print("\nDigite o nome do Cargo: ");
			String nome = entrada.nextLine();
			
			Cargo cargo = new Cargo(nome);
			
			if(cargos.contains(cargo)){
				
				System.out.print("\nEste Cargo ja foi cadastrado no Sistema");
			}
			else{
				
				cargos.add(cargo);
			}
		}
	}
	
	/**Insere um novo Perfil na lista de perfis e garante que só sejam cadastrados perfis com nomes diferentes.*/
	
	public void cadastrarPerfil(){
	
		if(perfis.isEmpty()){	
	
			System.out.print("\nDigite o nome do Perfil: ");
			String nome = entrada.nextLine();
		
			Perfil perfil = new Perfil(nome);
			perfis.add(perfil);
		}
		else{
			
			System.out.print("\nDigite o nome do Perfil: ");
			String nome = entrada.nextLine();
			
			Perfil perfil = new Perfil(nome);
			
			if(perfis.contains(perfil)){
				
				System.out.print("\nEste Perfil ja foi cadastrado no Sistema");
			}
			else{
				
				perfis.add(perfil);
			}
		}
	}
	
	/**Insere um novo Usuário na lista de usuários e garante que só sejam cadastrados usuários com CPFs diferentes 
	 * e estes só podem ter cargos e perfis previamente cadastrados no sistema.
	 * @return -1 se houve algum problema no cadastro,
	 * @return 0 se houve sucesso no cadastro.
	 */
	
	public int cadastrarUsuario(){

		boolean sair = false;
		ArrayList<Perfil> perfs = new ArrayList<>();
		Cargo cargo = null;
	
		System.out.print("\nDigite o nome do Usuario: ");
		String nome = entrada.next();

		System.out.print("\nDigite o CPF do Usuario: ");
		String cpf = entrada.next();
		
		if(cpfRepetido(cpf)){
			
			System.out.print("\n Este cpf ja foi cadastrado nop sistema");
			
			return -1;
		}
	
		System.out.print("\nDigite a Data de Nascimento do Usuario: ");
		String dataNascimento = entrada.next();
	
		System.out.print("\nDigite o sexo (M ou F) do Usuario: ");
		String sexo = entrada.next();

		do{
			
			System.out.print("\nSelecione o cargo do usuario na lista abaixo: ");
			System.out.print("\n[0] - Sair");

			apresentarLista(cargos);
			
			int opcao = entrada.nextInt();
			
			if(opcao == 0){
				
				sair = true;
			
			}else{
			
				if(opcao < 1 || opcao > cargos.size()){
					
					System.out.print("\nComando invalido, nao foi possível cadastrar o Cargo do usuário. Tente novamente.");
			
				}
				else{
			
					cargo = cargos.get(opcao-1);
					
					sair = true;
				}
			}
	
		}while(sair == false);
		
		if(cargo == null){
			
			return -1;
		}
		
		sair = false;
		
		do{
			
			System.out.print("\nSelecione os perfis do usuario na lista abaixo: ");
			System.out.print("\n[0] - Sair");

			apresentarLista(perfis);
			
			int opcao = entrada.nextInt();
			
			if(opcao == 0){
				
				sair = true;
			
			}else{
			
				if(opcao < 1 || opcao > perfis.size()){
					
					System.out.print("\nComando invalido, nao foi possível cadastrar o Perfil do usuário. Tente novamente.");
			
				}
				else{
			
					Perfil perfil = perfis.get(opcao-1);
					perfs.add(perfil);
			
					System.out.print("\n Deseja adicionar mais algum perfil para o usuario?");
					System.out.print("\n[1] - Sim");
					System.out.print("\n[Outro numero inteiro] - Nao");
					System.out.print("\n");
				
					opcao = entrada.nextInt();
				
					if(opcao != 1){
					
						sair = true;
					}
				}
			}
	
		}while(sair == false);
		
		Usuario usuario = new Usuario (nome, cpf, dataNascimento, sexo, cargo, perfs);
		usuarios.add(usuario);
		
		return 0;
	}
	
	/**Altera o nome de um cargo previamente cadastrado por um novo nome informado.
	*A alteração ocorre na lista de cargos e em todos os usuários com o cargo alterado */

	public void editarCargo(){


		System.out.print("\nDigite o Cargo que voce deseja editar: ");
		String nome = entrada.nextLine();
		
		Cargo cargo_antigo = new Cargo(nome);

		if(cargos.contains(cargo_antigo)){

			System.out.print("\nDigite o nome do novo Cargo que substituirah ");
			System.out.print(nome);
			System.out.print(": ");
			String nome_novo = entrada.nextLine();

			Cargo cargo_novo = new Cargo(nome_novo);

			for(Cargo cargo : cargos){

				if(cargo.equals(cargo_antigo)){

					cargos.set(cargos.indexOf(cargo),cargo_novo);
							
				}
			}
			
			for(Usuario usuario : usuarios){
				
				if(cargo_antigo.equals(usuario.getCargo())){
					
					usuario.setCargo(cargo_novo);
				}
			}
			System.out.println("Cargo alterado com sucesso! Confira o novo cargo na lista abaixo:");
			ordenarCargos();
		}
		else{
			
			System.out.println("Este Cargo ainda nao estah cadastrado no sistema.");
			System.out.println("Os cargos cadastrados sao os seguintes: ");
			ordenarCargos();
		}
	}	
	
	/**Altera o nome de um Perfil previamente cadastrado por um novo nome informado.
	*A alteração ocorre na lista de perfis e em todos os usuários com o perfil alterado */

	public void editarPerfil(){

		System.out.print("\nDigite o Perfil que voce deseja editar: ");
		String nome = entrada.nextLine();
		
		Perfil perfil_antigo = new Perfil(nome);
		
		if(perfis.contains(perfil_antigo)){

			System.out.print("\nDigite o nome do novo Perfil que substituirah ");
			System.out.print(nome);
			System.out.print(": ");
			String nome_novo = entrada.nextLine();
		
			Perfil perfil_novo = new Perfil(nome_novo);

			for(Perfil perfil : perfis){

				if(perfil.equals(perfil_antigo)){
					
					perfis.set(perfis.indexOf(perfil),perfil_novo);
				}
			}
			
			for(Usuario usuario : usuarios){
				
				for(Perfil perfil : usuario.getPerfis()){
				
					if(perfil_antigo.equals(perfil)){
					
						perfil.setNome(nome_novo);
						
						System.out.print("deu certo");
					}
				}
			}
			System.out.println("Perfil alterado com sucesso! Confira o novo perfil na lista abaixo:");
			ordenarPerfis();
		}
		else{
			
			System.out.println("Este Perfil ainda nao estah cadastrado no sistema.");
			System.out.println("Os perfis cadastrados sao os seguintes: ");
			ordenarPerfis();
		}
	}
	
	/**Altera os atributos de um usuário previamente cadastrado por um novo atributo informado.
	*A alteração de perfis do usuário, altera a lista de perfis previamente cadastrada.
	*A alteração do cargo de um usuário, altera a lista de cargos previamente cadastrada.*/

	public void editarUsuario(){
		
		boolean sair = false;
		do{
			System.out.println("Qual usuario voce deseja editar?");
			System.out.println("[1] - Procurar por Nome"); 
			System.out.println("[2] - Procurar por CPF");
			System.out.println("[0] - Sair");


			int opcao = entrada.nextInt();
			int posCpf = 0;
			int posNome = 0;
			
			switch (opcao) {
				
				case 1: posNome = procurarPorNome();break;
				case 2: posCpf = procurarPorCpf();break;
				case 0 : sair = true; break;
				default: System.out.println("Comando invalido!"); break;
			}

			if(opcao == 1 && posNome >= 0){
				
				System.out.println("Qual atributo do Usuario voce deseja editar?"); 
				System.out.println("[1] - Editar Nome"); 
				System.out.println("[2] - Editar CPF");
				System.out.println("[3] - Editar Data de Nascimento");
				System.out.println("[4] - Editar Sexo"); 
				System.out.println("[5] - Editar Cargo");
				System.out.println("[6] - Editar Perfis");
				System.out.println("[0] - Sair");

				opcao = entrada.nextInt();

				switch (opcao) {
				
					case 0: sair = true; break;
					case 1: editarNome(posNome); break;
					case 2: editarCpf(posNome); break;
					case 3: editarDataNascimento(posNome); break;
					case 4: editarSexo(posNome); break;
					case 5: editarCargoUsuario(posNome); break;
					case 6: editarPerfilUsuario(posNome); break;
					default: System.out.println("Comando invalido!");break;
				}
			}
			if(opcao == 2 && posCpf >= 0){

				System.out.println("Qual atributo do Usuario voce deseja editar?"); 
				System.out.println("[1] - Editar Nome"); 
				System.out.println("[2] - Editar CPF");
				System.out.println("[3] - Editar Data de Nascimento");
				System.out.println("[4] - Editar Sexo"); 
				System.out.println("[5] - Editar Cargo");
				System.out.println("[6] - Editar Perfis");
				System.out.println("[0] - Sair");

				opcao = entrada.nextInt();

				switch (opcao) {
				
					case 0: sair = true; break;
					case 1: editarNome(posCpf); break;
					case 2: editarCpf(posCpf); break;
					case 3: editarDataNascimento(posCpf); break;
					case 4: editarSexo(posCpf); break;
					case 5: editarCargoUsuario(posNome); break;
					case 6: editarPerfilUsuario(posCpf); break;
					default: System.out.println("Comando invalido!"); break;
				}
			}

		}while(sair == false);	
	}
	
	/**Lista e imprime em ordem alfabética os cargos do sistema*/

	public void ordenarCargos(){
		
		Collections.sort(cargos);
		imprimir(cargos);
		
	}
	
	/**Lista e imprime em ordem alfabética os perfis do sistema*/
	
	public void ordenarPerfis(){
		
		Collections.sort(perfis);
		imprimir(perfis);
	}
	
	/**Remove um Cargo do sistema se este não tiver nenhum usuário vinculado*/

	public void removerCargo(){

		int cont = 0;

		List<Cargo> cargosRemovidos = new ArrayList<>();

		for(Cargo cargo : cargos){

			for(Usuario usuario : usuarios){
			
				if(cargo.equals(usuario.getCargo())){
			
					break;
				}
				else{

					cont++;
				}

				if(cont == usuarios.size()){

					cargosRemovidos.add(cargo);
				}
			}
			cont = 0;
		}
		
		cargos.removeAll(cargosRemovidos);
	}
	
	/**Remove um Perfil do sistema se este não tiver nenhum usuário vinculado*/

	public void removerPerfil(){

		int cont = 0;

		List<Perfil> perfisRemovidos = new ArrayList<>();

		for(Perfil perfil : perfis){

			for(Usuario usuario : usuarios){

				if(usuario.getPerfis().contains(perfil)){
			
					break;
				}
				else{

					cont++;
				}
	
				if(cont == usuarios.size()){

					perfisRemovidos.add(perfil);
				}	
				
			}
			cont = 0;
		}
		
		perfis.removeAll(perfisRemovidos);
	}
	
	/**Método genérico para imprimir listas.*/
	
	public <T> void imprimir(List <T> lista){

		for(T elemento : lista){
			
			System.out.print("\n");
			System.out.println(elemento);
		}
	}
	
	/*Todos os métodos privados foram implementados com o intuito de modularizar o código,
	 *reaproveitá - lo e facilitar sua manutenção.*/

	private void editarNome(int pos){

		System.out.print("Digite o nome do usuario: ");
		String nome = entrada.next();

		usuarios.get(pos).setNome(nome);
					
		System.out.println("Nome alterado com sucesso!");
	}

	private void editarCpf(int pos){

		System.out.print("Digite o CPF do usuario: ");
		String cpf = entrada.next();

		usuarios.get(pos).setCpf(cpf);
					
		System.out.println("CPF alterado com sucesso!");
	}
	private void editarDataNascimento (int pos){

		System.out.print("Digite a Data de Nascimento do usuario: ");
		String dataNascimento = entrada.next();

		usuarios.get(pos).setDataNascimento(dataNascimento);
					
		System.out.println("Data de Nascimento alterada com sucesso!");
	}

	private void editarSexo(int pos){

		System.out.print("Digite o sexo do usuario: ");
		String sexo = entrada.next();

		usuarios.get(pos).setSexo(sexo);
					
		System.out.println("Sexo alterado com sucesso!");
	}

	private void editarCargoUsuario(int pos){

		System.out.print("Digite o novo Cargo do usuario: ");
		String nome = entrada.next();

		Cargo cargo = new Cargo(nome);
		
		for(Cargo c : cargos){
			
			if(c.equals(usuarios.get(pos).getCargo())){
				
				c.setNome(nome);
			}
		}
		usuarios.get(pos).setCargo(cargo);
	
		System.out.println("Cargo alterado com sucesso!");
	}

	private void editarPerfilUsuario(int pos){

		boolean sair = false;		

		do{
			System.out.print("Qual perfil voce deseja editar? : ");
			String nome = entrada.next();
			
			Perfil p = new Perfil(nome);

			if(usuarios.get(pos).getPerfis().contains(p)){

				System.out.print("Qual serah o novo perfil do usuario? : ");
				String nome_novo = entrada.next();
				
				for(Perfil p2 : perfis){
			
					if(p.equals(p2)){
						
						p2.setNome(nome_novo);
					}
				}
				
				for(Perfil perfil : usuarios.get(pos).getPerfis()){
			
					if(perfil.equals(p)){

						perfil.setNome(nome_novo);
					}
				}
				System.out.println("Deseja editar mais algum perfil?");
			
				System.out.println("[1] - Sim"); 
				System.out.println("[Outro numero inteiro] - Nao");

				int opcao = entrada.nextInt();
		
				if(opcao != 1){

					sair = true;
				}
			}
			else{

				System.out.println("Perfil nao encontrado!");

				System.out.println("Deseja tentar novamente?");
			
				System.out.println("[1] - Sim"); 
				System.out.println("[Outro numero inteiro] - Nao");

				int opcao = entrada.nextInt();
		
				if(opcao != 1){

					sair = true;
				}
			}

		}while(sair == false);

	}
	

	private int procurarPorNome(){
		
		System.out.print("\nDigite o Nome do Usuario que voce deseja editar: ");
		String nome = entrada.next();

		for(Usuario usuario : usuarios){
		
			if(usuario.getNome().equals(nome)){

				return usuarios.indexOf(usuario);
			}
		}
		
		

		System.out.println(" Usuario nao encontrado!");

		return -1;			
	}

	private int procurarPorCpf(){
		
		System.out.print("\nDigite o CPF do Usuario que voce deseja editar: ");
		String cpf = entrada.next();

		for(Usuario usuario : usuarios){
		
			if(usuario.getCpf().equals(cpf)){

				return usuarios.indexOf(usuario);
			}
		}

		System.out.println(" O CPF deste usuario nao foi encontrado!");

		return -1;			
	}
	
	
	//Método que apresenta uma lista num formato específico no prompt.
	
	private <T> void apresentarLista(List<T> lista){
		
		int i = 1;
		
		for(T elemento : lista){
			
			System.out.print("\n[" + i + "] -" + elemento);
			i++;
		}
		System.out.print("\n");
	}
	
	private boolean cpfRepetido(String cpf){
		
		for(Usuario usuario: usuarios){
			
			if(usuario.getCpf().equals(cpf)){
				
				return true;
			}
		}
		return false;
	}
}
