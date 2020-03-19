import java.util.*;

/**Classe que representa um Usuário do sistema de gereciamento.*/

public class Usuario{

	// atributos privados
	
	private String nome;	
	private String cpf;
	private String dataNascimento;
	private String sexo;
	private Cargo cargo;
	private ArrayList<Perfil> perfis;
	private Date dataCadastro;
	
	/**Cria um novo Usuário inicializado com os parametros e a data de Cadastro.
	 * @param nome: String que representa o nome do usuário.
	 * @param cpf: String que representa o CPF do usuário.
	 * @param dataNascimento: String que representa a data de nascimento do usuário.
	 * @param sexo: String que representa o sexo do usuário, M ou F.
	 * @param cargo: atributo da classe Cargo que representa o cargo do usuário.
	 * @param perfis: ArrayLisyt com os perfis do usuário.
	 */

	public Usuario(String nome, String cpf, String dataNascimento, String sexo, Cargo cargo, ArrayList<Perfil> perfis){

		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cargo = cargo;
		this.perfis = perfis;
		dataCadastro = new Date();
	}
	
	/**Retorna a data de cadastro do usuário.
	*@return Date. */

	public Date getData(){

		return dataCadastro;
	}
	
	/**Retorna o nome do usuário.
	*@return String. */
	 
	public String getNome(){

		return nome;
	}
	
	/**Altera o nome do usuário.
	*@param String que representa o novo nome do usuário. */

	public void setNome(String nome){

		this.nome = nome;
	}
	
	/**Retorna o CPF do usuário.
	*@return String. */
	
	public String getCpf(){

		return cpf;
	}
	
	/**Altera o CPF do usuário.
	*@param String que representa o CPF alterado. */

	public void setCpf(String cpf){

		this.cpf = cpf;
	}
	
	/**Retorna a data de nascimento do usuário.
	*@return String. */
	
	public String getDataNascimento(){

		return dataNascimento;
	}
	
	/**Altera a data de nascimento do usuário.
	*@param String que representa a data de nascimento modificada.*/

	public void setDataNascimento(String dataNascimento){
	
		this.dataNascimento = dataNascimento;
	}
	
	/**Retorna o sexo do usuário.
	*@return String. */
	
	public String getSexo(){

		return sexo;
	}
	
	/**Altera o sexo do usuário.
	*@param String que representa o sexo editado.*/
	
	public void setSexo(String sexo){

		this.sexo = sexo;
	}
	
	/**Retorna o cargo do usuário.
	*@return Cargo. */
	
	public Cargo getCargo(){

		return cargo;
	}
	
	/**Altera o cargo do usuário.
	*@param Cargo que representa o novo cargo do usuário.*/
	
	public void setCargo(Cargo cargo){

		this.cargo = cargo;
	}
	
	/**Retorna um ArrayList de perfis do usuário
	*@return ArrayList<Perfil>.*/
	
	public ArrayList<Perfil> getPerfis(){

		return perfis;
	}
	
	@Override // Este comando garante que você esteja sobrescrevendo um método e não criando um novo.
	
	/**Método sobrescrito da Classe Object.
	* @return String: retorna uma representação em String do objeto Usuário.
	* */
	public String toString(){


		String valores =  new String("");  // instancia uma String vazia
        	
		for(Perfil perfil: perfis) {    //percorre um ArrayList de perfis
            
			valores += perfil.getNome();  //incrementa o nome do perfil em valores 
            		valores += "\n";     // incrementa a quebra de linha em valores
        	}
	
		return "\nNome: " + nome + "\nCPF: " + cpf + "\nData de Nascimento: " + dataNascimento + " \nSexo: " + sexo + " " + "\nCargo: " +cargo + "\nPerfis: "  + valores + 
			
			"Data de Cadastro: " + dataCadastro;
	}
}
