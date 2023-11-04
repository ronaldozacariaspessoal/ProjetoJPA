package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {
	@Id
	private String cpf;
	private String sexo;
	private int idade;
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "numero_conta")
	private Conta conta;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	
	
	
	public Pessoa(String cpf, String sexo, int idade, String nome, Conta conta, Endereco endereco) {
		super();
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
		this.nome = nome;
		this.conta = conta;
		this.endereco = endereco;
	}
	
	public Pessoa() {
		
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setTelefones(List<Telefone> telefone) {
		this.telefones = telefone;
	}
	
	public void getTelefones(List<Telefone> telefone) {
		this.telefones = telefone;
	}

	@Override
	public String toString() {
		return "Pessoa [" + (cpf != null ? "cpf=" + cpf + ", " : "") + (sexo != null ? "sexo=" + sexo + ", " : "")
				+ "idade=" + idade + ", " + (nome != null ? "nome=" + nome + ", " : "")
				+ (conta != null ? "conta=" + conta + ", " : "")
				+ (endereco != null ? "endereco=" + endereco + ", " : "")
				+ (telefones != null ? "telefones=" + telefones : "") + "]";
	}

	

}
