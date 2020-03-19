/**Classe que representa um Perfil do sistema de gereciamento
 * e implementa a interface Comparable.
 */
public class Perfil implements Comparable<Perfil>{
	
	private String nome; // atributo privado

	/**Cria um novo perfil inicializado com um nome.
	 * @param nome: String que representa o nome do perfil.
	 */
	public Perfil(String nome){
	
		this.nome = nome;
	}
	
	/** Este método permite que outras classes possam obter o nome do perfil sem acessá-lo diretamente.
	 * @return String: retorna o nome do perfil.
	 **/
	
	public String getNome(){

		return nome;
	}
	
	/** Este método permite que o objeto altere seu nome.
	 * @param nome: String que representa o novo nome do Perfil.
	 **/

	public void setNome(String nome){

		this.nome = nome;
	}

	@Override // Este comando garante que você esteja sobrescrevendo um método e não criando um novo.
	
	/**Método sobrescrito da Classe Object.
	* @return String: retorna uma representação em String do objeto Perfil.
	* */
	
	public String toString(){
	
		return  nome;
	
	}

	@Override // Este comando garante que você esteja sobrescrevendo um método e não criando um novo.
	
	/**Método sobrescrito da Classe Object. Indica se dois objetos da classe Perfil são iguais em termos de conteúdo 
	 * ao comparar os seus atributos.
	 * @param obj: objeto da Classe Object que será comparado. 
	 * @return boolean: retorna true se os objetos são iguais e false caso contrário.
	 * */
	public boolean equals(Object obj){

		if(this == obj){  // teste de igualdade de referência, se os dois objetos estão no mesmo endereço, então eles são iguais.

			return true;
		}

		else if(!(obj instanceof Perfil)){  // verifica se obj é da mesma classe de Perfil, se eles são de classes diferentes, 
											//então são diferentes.
			return false;
		}
		else{

			Perfil outro = (Perfil) obj;  // operação de casting, o objeto outro recebe a referência de obj no tipo dinâmico Perfil,
										// assim podemos acessar os seus atributos
			return nome.equals(outro.nome); // retorna verdadeiro se o atributo nome da Classe Perfil é igual ao atributo do objeto outro
		}
	}

	@Override // Este comando garante que você esteja sobrescrevendo um método e não criando um novo.
	
	/**Método sobrescrito da interface Comparable. Ele é necessário para a utilização do método sort da classe Collections, cujo
	 * o objetivo é a ordenação.
	 * @return int: retorna 1 se o codigo Ascii de nome é maior que o de "perfil.nome", 0 se são iguais e -1 se é menor.
	 * */
	public int compareTo( Perfil perfil ) { 

		return this.nome.compareTo(perfil.nome); 
	}	
}
