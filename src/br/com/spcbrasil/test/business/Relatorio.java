package br.com.spcbrasil.test.business;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.spcbrasil.test.model.Paciente;

public class Relatorio {

	public static long getQtdPacientes(List<Paciente> pacientes) {
		return pacientes.stream().count();
	}

	public static double getMediaIdadePorSexo(List<Paciente> pacientes, char sexo) {
		return pacientes.stream().filter(p -> p.getSexo() == sexo).mapToInt(p -> p.getIdade()).average().orElse(0);
	}

	public static long getQtdPacientesPorSexoIntervaloAlturaPesoMinimo(List<Paciente> pacientes, char sexo,
			float altMin, float altMax, float pesoMin) {
		return pacientes.stream().filter(
				p -> p.getSexo() == sexo && p.getAltura() >= altMin && p.getAltura() <= altMax && p.getPeso() > pesoMin)
				.count();
	}

	public static long getQtdPacientesIntervaloIdade(List<Paciente> pacientes, int idadeMin, int idadeMax) {
		return pacientes.stream().filter(p -> p.getIdade() >= 18 && p.getIdade() <= 25).count();
	}

	public static String getPacienteMaisVelho(List<Paciente> pacientes) {
		return pacientes.stream().max(Comparator.comparing(Paciente::getIdade)).map(p -> p.getNome())
				.orElse("Lista de pacientes vazia!");
	}

	public static String getPacienteMaisBaixoPorSexo(List<Paciente> pacientes, char sexo) {
		return pacientes.stream().filter(p -> p.getSexo() == sexo).min(Comparator.comparing(Paciente::getAltura))
				.map(p -> p.getNome()).orElse("Lista de pacientes vazia!");
	}

	public static String getMultiplosPacientesMaisVelhos(List<Paciente> pacientes) {
		String nomes = pacientes.stream()
				.filter(p -> p.getIdade() == pacientes.stream().mapToInt(Paciente::getIdade).max().orElse(-1))
				.map(p -> p.getNome()).collect(Collectors.joining("; "));
		return !nomes.isBlank() ? nomes : "Lista de pacientes vazia!";
	}

	public static String getMultiplosPacienteMaisBaixosPorSexo(List<Paciente> pacientes, char sexo) {
		String nomes = pacientes.stream()
				.filter(p -> p.getAltura() == pacientes.stream().filter(ps -> ps.getSexo() == sexo)
						.mapToDouble(Paciente::getAltura).min().orElse(-1))
				.map(p -> p.getNome()).collect(Collectors.joining("; "));
		return !nomes.isBlank() ? nomes : "Lista de pacientes vazia!";
	}
}