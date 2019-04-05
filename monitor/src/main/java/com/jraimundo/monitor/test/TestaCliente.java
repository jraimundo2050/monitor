package com.jraimundo.monitor.test;

import java.util.Date;
import java.util.List;

import com.jraimundo.monitor.entity.ClienteEntity;
import com.jraimundo.monitor.model.Cliente;
import com.jraimundo.monitor.service.ClienteService;

public class TestaCliente {

	public static void main(String[] args) {

		//salvaCliTest();
		//consultaCliPelaChaveTest(); 
		// consultaCliPorDocumentoTest();
		//deleteCliChaveTest();
		//listaTodos();
	//	listaPorNome();
		listaPorTelefone();
		
		
		
	}

	private static void listaPorTelefone() {
		ClienteService cliService = new ClienteService();
		List<ClienteEntity> clientes = cliService.listByTelefone("1004");
		
		for (ClienteEntity cliEntity : clientes) {
			Cliente cliente = cliService.entityToModelCli(cliEntity);  
			System.out.println(cliente.toString() + "\n");
		}
	}

	private static void listaPorNome() {
		ClienteService cliService = new ClienteService();
		List<ClienteEntity> clientes = cliService.listByName("aninha");
		
		for (ClienteEntity cliEntity : clientes) {
			Cliente cliente = cliService.entityToModelCli(cliEntity);  
			System.out.println(cliente.toString() + "\n");
		}
	}

	private static void listaTodos() {
		
		ClienteService cliService = new ClienteService();
		List<ClienteEntity> clientes = cliService.listAll();
		
		for (ClienteEntity cliEntity : clientes) {
			Cliente cliente = cliService.entityToModelCli(cliEntity);  
			System.out.println(cliente.toString() + "\n");
		}
		
	}

	@SuppressWarnings("unused")
	private static void deleteCliChaveTest() {
		// apaga um cliente pela chave
		Cliente c = new Cliente();
		ClienteService cliService = new ClienteService();
		c = cliService.findId(5L);
		if ( cliService.delete(5L) ) {
			System.out.println("Cliente: " + c.getNome() + " excluido com sucesso !");
		} else {
			System.out.println("Cliente não encontrado !");
		}
	}

	@SuppressWarnings("unused")
	private static void consultaCliPorDocumentoTest() {
		Cliente c = new Cliente();
		ClienteService cliService = new ClienteService();
		c = cliService.findByDocumento("999.999.999.99");
		System.out.println(c.toString());
	}

	@SuppressWarnings("unused")
	private static void consultaCliPelaChaveTest() {
		Cliente c = new Cliente();
		ClienteService cliService = new ClienteService();
		c = cliService.findId(7L);
		System.out.println(c.toString());
	}

	@SuppressWarnings("unused")
	private static void salvaCliTest() {

		Cliente c = new Cliente();

		c.setNome("Ana Clara Morais Santos"); 
		c.setTelefone("(79) 8888-8888");
		c.setCelular("(79) 44444-6666");
		c.setEmail("anaclaras@gmail.com");
		c.setDocumento("222.222.999.99");
		c.setContato("Aninha");
		c.setData(new Date());

		ClienteService cliService = new ClienteService();
		cliService.salvar(c);
		c = cliService.entityToModelCli();
		System.out.println(c.toString());
	
	}
}
