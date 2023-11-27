# Desing Patterns

## O que são Desing Patterns?
São padrões de projetos que foram criados para solucionar problemas recorrentes da programação orientada a objetos. Esses padrões não são meros techos de código, mas sim conceitos complexo que combinam estratégias para resolver um problema existente.

#### Quem usa?
Programadores de excelência sempre buscam usar esses padrões para solucionar problemas comuns. Consequentemente ganhando segurança e confiabilidade. Podendo ser usados em linguagens orientadas a objetos como Java, C#, Python, etc.

## Tipo de padrões

Atualmente temos 23 padrões catalogados. Eles estão dividos em:
 -  **Creational:** Trata da criação de objetos;
 - **Structural:** Relação entre os objetos e como eles interagem entre si;
 - **Behavioral:** Comunicação entre os objetos, em termos de responsabilidade e algoritmos. 		Chamadas de métodos etc.;

## Pattern Builder
O objeto abaixo, possui uma criação padrão e simples, com construtores, getters e setters:
```java
public class Pessoa {  
 private String nome;  
    private String sobreNome;  
    private String documento;  
    private String email;  
    private String apelido;  
    private LocalDate dataNascimento;  
  
    public Pessoa(String nome, String sobreNome, String documento, String email, String apelido, LocalDate dataNascimento) {  
  this.nome = nome;  
        this.sobreNome = sobreNome;  
        this.documento = documento;  
        this.email = email;  
        this.apelido = apelido;  
        this.dataNascimento = dataNascimento;  
    }  
  
  public String getNome() {  return nome;  }  
  public void setNome(String nome) {this.nome = nome;}  
  public String getSobreNome() {  return sobreNome;  }  
  public void setSobreNome(String sobreNome) {  this.sobreNome = sobreNome;  }  
  public String getDocumento() {  return documento;  }  
  public void setDocumento(String documento) {  this.documento = documento;  }  
  public String getEmail() {  return email;  }  
  public void setEmail(String email) {  this.email = email;  }  
  public String getApelido() {  return apelido;  }  
  public void setApelido(String apelido) {  this.apelido = apelido;  } 
  public LocalDate getDataNascimento() {  return dataNascimento;  }   
  public void setDataNascimento(LocalDate dataNascimento) {  this.dataNascimento = dataNascimento;  }  
}
```

Porém a sua utilização em um ambito geral acaba se tornando complexa devida a falta de especificação de seus atributos a associar o objeto, como no codigo abaixo:

```java
public static void main(String[] args) {  
  Pessoa pessoa = new Pessoa(
	  "Kelven", 
	  "Silva", 
	  "069026387591", 
	  "kelven@gmail.com", 
	  "kelvinho", 
	  LocalDate.of(2002, 3, 4));
}
```
Dificilmente um programador que terá acesso somente ao pacote onde está sendo o utilizado o objeto, entenderia seu contexto e usabilidade. Para solucionar esse problema e torna os códigos mais concisos foi implementado a partir do tipo **Creational** do Design Patterns o padrão **Builder**. Para implementar-mos este padrão a esse código, é nescessário a criação de uma nova classe na qual será encarregada da construção do objeto Pessoa com os mesmo atributos porem com os seguintes métodos:
```java
public class PessoaBuilder {
	...
	public PessoaBuilder nome(String nome) {  
	  this.nome = nome;  
	  return this;  
	}  
	public PessoaBuilder sobreNome(String sobreNome) {  
	  this.sobreNome = sobreNome;  
	  return this;  
	}  
	public PessoaBuilder documento(String documento) {  
	  this.documento = documento;  
	  return this;  
	}   
	public PessoaBuilder email(String email) {  
	  this.email = email;  
	  return this;  
	}  
	public PessoaBuilder apelido(String apelido) {  
	  this.apelido = apelido;  
	  return this;  
	}  
	public PessoaBuilder dataNascimento(LocalDate dataNascimento) {  
	  this.dataNascimento = dataNascimento;  
	  return this;  
	}   
	public Pessoa criaPessoa(){  
	  return new Pessoa(nome, sobreNome, documento, email, apelido, dataNascimento);  
	}
```
Aqui, cada metodo atribuí um valor ao seu respectivo atríbuto e retorna o mesmo objeto (PessoaBuilder) com a atualização realizada. Por fim, todos o dados associados ao PessoaBuilder é utilizado para criar um novo objeto Pessoa construido anteriormente. Tornando, assim, o código mais legível e estruturado:
```java
public class TestePessoaBuilder {  
	 public static void main(String[] args) {  
	 Pessoa pessoa =  
	 new PessoaBuilder().nome("Kelven")  
		  .sobreNome("Cristian")  
		  .documento("8599493481")  
		  .email("kelvencrstn@gmail.com")  
		  .apelido("kelvinho")  
		  .dataNascimento(LocalDate.of(2002, 3, 4))  
		  .criaPessoa();   
	    }  
}
```
Agora, pode-se inferir o contexto de cada dado associado ao objeto sem nescessariamente acessar a classe onde o Objeto é criado. Além de possibilitar a associação dos atríbutos de forma que independe da sua ordem de montagem, graças a fluência de método que é gerada nesse novo código, o que poderia causar erro de compilação se feito na primeira solução. Observe abaixo: 
```java
// Pessoa = nome, sobrenome, documento, email, apelido, data de nascimento
public static void main(String[] args) {  
  Pessoa pessoa = new Pessoa( 
	  "Kelven", 
	  "Silva", 
	   LocalDate.of(2002, 3, 4),
	  "069026387591", 
	  "kelven@gmail.com", 
	  "kelvinho"); 
	  
}
// Aqui ocorreria o erro devido a ordem de associação do atríbutos
```
```java
//Já aqui o objeto pode ser montado em qualquer ordem (fluência de método)
 public static void main(String[] args) {  
 Pessoa pessoa =  
 new PessoaBuilder().nome("Kelven")  
	  .apelido("kelvinho")  
	  .documento("8599493481")  
	  .email("kelvencrstn@gmail.com")  
	  .sobreNome("Cristian") 
	  .dataNascimento(LocalDate.of(2002, 3, 4))  
	  .criaPessoa();   
    }  
```
## Factory Method
O código abaixo deveria ser um código de criação de objetos, porem se analisarmos bem e pensarmos em regras de negócio, está muito suscetível a erros. Devido a responsabilidade de informar se o atríbuto possui dimensões físicas está com o cliente, que está utilizando a classe:
```java
#Classe Produtos
public class Produto {  
	private String descricao;  
    private BigDecimal preco;  
    private Boolean possuiDimensoesFisicas;  
  
    public String getDescricao() { return descricao; }  
	public void setDescricao(String descricao) { this.descricao = descricao; }  
    public BigDecimal getPreco() { return preco; }  
	public void setPreco(BigDecimal preco) { this.preco = preco; }  
	public Boolean getPossuiDimensoesFisicas() { return possuiDimensoesFisicas; }  
	public void setPossuiDimensoesFisicas(Boolean possuiDimensoesFisicas) { this.possuiDimensoesFisicas = possuiDimensoesFisicas; }  
}
```
```java
#Classe Produto Digital
package br.com.dev.desingpatterns.factorymethods;  
public class ProdutoDigital extends Produto{  }
```
```java
#Classe Produto Físico
package br.com.dev.desingpatterns.factorymethods;  
public class ProdutoFisico extends Produto{  }
```
```java
#Main
public static void main(String[] args) {  
	ProdutoFisico produtoFisico = new ProdutoFisico();  
    produtoFisico.setPossuiDimensoesFisicas(true);  
  
    ProdutoDigital produtoDigital = new ProdutoDigital();  
    produtoDigital.setPossuiDimensoesFisicas(false);  
}
```
Suponha esse sistema esteja em produção e que irá feito um inventário dos produtos, e em uma query do banco será selecionado somente os produtos físicos. É necessário que todos os produtos estejam setados de forma correta para que não haja nenhum produto físico fora do inventário. Como citado anteriormente, a forma na qual está sendo definido o atributo "PossuiDimensoesFisicas" está suscetivel a erros. Para contornar a forma como foi projetado o sistema e mitigar esses erros, precisaremos construir um novo método que faça essa atribuição de forma autómatica, supondo que o projeta esteja em produção e seja inviavel a refatoração dos objetos.

Para isso iremos implementar o FactoryMethod, que nós retornará instancias para criação de objetos/Produtos fisicos ou digitais, e nescessario a criação de um ENUM para classificar os produtos proporcionando mais flexibilidade. Além encapsular os atríbutos que tráz mais segurança ao projeto:
```java
#ENUM
public enum TipoProdutoEnum {  
	FISICO,  
    DIGITAL;  
}
``` 
```java
#Factory
public  static Produto getInstance(TipoProdutoEnum tipoProdutoEnum){  
	switch (tipoProdutoEnum){  
		case FISICO:  
			ProdutoFisico produtoFisico = new ProdutoFisico();  
			produtoFisico.setPossuiDimensoesFisicas(true);  
			return produtoFisico;  
		case DIGITAL:  
			ProdutoDigital produtoDigital = new ProdutoDigital();  
			produtoDigital.setPossuiDimensoesFisicas(false);  
			return produtoDigital;  
		default:  
			throw new IllegalArgumentException("Tipo de produto não disponivel");  
	 }  
}
```
```java
public static void main(String[] args) {  
	Produto produtoDigital = ProdutoFactory.getInstance(TipoProdutoEnum.DIGITAL);  
    Produto produtoFisico= ProdutoFactory.getInstance(TipoProdutoEnum.FISICO);
}
