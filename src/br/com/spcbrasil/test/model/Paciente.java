package br.com.spcbrasil.test.model;

public class Paciente {

	private String nome;
	private char sexo;
	private float peso;
	private int idade;
	private float altura;

	public Paciente() {
		this.nome = "";
	}

	public Paciente(String nome, char sexo, float peso, int idade, float altura) {
		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.idade = idade;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
}