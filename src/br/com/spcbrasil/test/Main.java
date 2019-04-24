package br.com.spcbrasil.test;

import java.util.ArrayList;
import java.util.List;

import br.com.spcbrasil.test.business.Relatorio;
import br.com.spcbrasil.test.contracts.ILogger;
import br.com.spcbrasil.test.data.DataLoader;
import br.com.spcbrasil.test.log.ConsoleLogger;
import br.com.spcbrasil.test.log.TextLogger;
import br.com.spcbrasil.test.model.Paciente;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		ILogger logger = new TextLogger();
		List<Paciente> pacientes = DataLoader.getDataFromXML(new ArrayList<>());
		logger.log("Quantidade de pacientes:");
		logger.log(Relatorio.getQtdPacientes(pacientes), "paciente(s)");
		logger.log("Média de idade dos homens: ");
		logger.log(Relatorio.getMediaIdadePorSexo(pacientes, 'M'), "anos");
		logger.log("Quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg: ");
		logger.log(Relatorio.getQtdPacientesPorSexoIntervaloAlturaPesoMinimo(pacientes, 'F', 1.60f, 1.70f, 70),
				"mulher(es)");
		logger.log("Quantidade de pessoas com idade entre 18 e 25: ");
		logger.log(Relatorio.getQtdPacientesIntervaloIdade(pacientes, 18, 25), "pessoa(s)");
		logger.log("Nome do paciente mais velho:", Relatorio.getPacienteMaisVelho(pacientes));
		logger.log("Nome da mulher mais baixa:", Relatorio.getPacienteMaisBaixoPorSexo(pacientes, 'F'));
		logger.log("Nome do(s) paciente(s) mais velho(s):", Relatorio.getMultiplosPacientesMaisVelhos(pacientes));
		logger.log("Nome da(s) mulher(es) mais baixa(s):",
				Relatorio.getMultiplosPacienteMaisBaixosPorSexo(pacientes, 'F'));
	}
}