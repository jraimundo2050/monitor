package com.jraimundo.monitor.model;

import com.jraimundo.monitor.enumerador.tipoEmpresaEnum;

public class Empresa {
	
	private Long id;
	private String cnpj;
	private String inscEstadual;
	private String inscMunicipal;
	private String razaoSocial;
	private String nomeFantasia;
	private String telefone1;
	private String telefone2;
	private String email;
	private String urlDoSite;
	private tipoEmpresaEnum tipoEmpresa;
	private Endereco endereco;

}
