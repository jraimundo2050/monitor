package com.jraimundo.monitor.enumerador;

public enum tipoEmpresaEnum {

	SIMPLES(1), PRESUMIDO(2), REAL(3), 	MICROEMPREENDEDOR(4);
	
	private final int tipo;

	tipoEmpresaEnum(int tipo){
	        this.tipo = tipo;
	}
	
	public int getTipo(){
	        return this.tipo;
	}	
	
}
