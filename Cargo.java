/**Classe que representa um Cargo do sistema de gereciamento
 * e implementa a interface Comparable
 */
public class Cargo implements Comparable<Cargo>{ 
	
	private String nome; // atributo privado da classe
	
	/**Cria um novo cargo inicializado com um nome.
	 * @param nome: String que representa o nome do cargo.
	 */
	
	public Cargo(String nome){
	
		this.nome = nome;
	}
	
	/** Este método permite que o objeto altere seu nome.
	 * @param nome: String que representa o novo nome do Cargo.
	 **/
	
	public void setNome( String nome){
		
		this.nome = nome;
	}

	@Override // Este comando garante que você esteja sobrescrevendo um método e não criando um novo.
	
	/**Método sobrescrito da Classe Object.
	 * @return String: retorna uma representação em String do objeto Cargo.
	 * */
	
	public String toString(){
	
		return  nome;
	}
	
	@Override // Este comando garante que você esteja sobrescrevendo um método e não criando um novo.
	
	/**Método sobrescrito da Classe Object. Indica se dois objetos da classe Cargo são iguais em termos de conteúdo 
	 * ao comparar os seus atributos.
	 * @param obj: objeto da Classe Object que será comparado. 
	 * @return boolean: retorna true se os objetos são iguais e false caso contrário.
	 * */
	
	public boolean equals(Object obj){

		if(this==obj){  // teste de igualdade de referência, se os dois objetos estão no mesmo endereço, então eles são iguais.

			return true;
		}

		else if(!(obj instanceof Cargo)){    // verifica se obj é da mesma classe de Cargo, se eles são de classes diferentes, 
											//então são diferentes.
			return false;
		}
		else{

			Cargo outro = (Cargo) obj;  // operação de casting, o objeto outro recebe a referência de obj no tipo dinâmico Cargo,
										// assim podemos acessar os seus atributos
			return nome.equals(outro.nome); // retorna verdadeiro se o atributo nome da Classe Cargo é igual ao atributo do objeto outro
		}
	}

	@Override // Este comando garante que você esteja sobrescrevendo um método e não criando um novo.
	
	/**Método sobrescrito da interface Comparable. Ele é necessário para a utilização do método sort da classe Collections, cujo
	 * o objetivo é a ordenação.
	 * @return int: retorna 1 se o codigo Ascii de nome é maior que o de "cargo.nome", 0 se são iguais e -1 se é menor.
	 * */
	public int compareTo( Cargo cargo ) { 

		return this.nome.compareTo(cargo.nome); 

	}
	
}
