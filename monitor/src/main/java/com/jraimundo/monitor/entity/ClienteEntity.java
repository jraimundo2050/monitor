package com.jraimundo.monitor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jraimundo.monitor.model.Cliente;
import com.jraimundo.monitor.model.Produto;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteEntity {
	
    @Id
    @GeneratedValue(generator = "cliente_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
    @Column(name = "idcliente", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
    
    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;
    
    @Column(name = "celular", length = 20, nullable = false)
    private String celular;
    
    @Column(name = "email", length = 60, nullable = false)
    private String email;
    
    @Column(name = "documento", length = 20, nullable = false)
    private String documento;
    
    @Column(name = "contato", length = 80, nullable = false)
    private String contato;

    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable=false)
    private Date data;

    public ClienteEntity() {
    	
    }
    
    public ClienteEntity(Cliente cli) {
    	this.celular = cli.getCelular();
    	this.telefone = cli.getTelefone();
    	this.email = cli.getEmail();
    	this.nome = cli.getNome();
    	this.documento = cli.getDocumento();
    	this.contato = cli.getContato();
    	this.data = cli.getData();
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public ClienteEntity telefone(String email) {
			this.email = email;
			return this;
	}
	
	public ClienteEntity celular(String celular) {
		this.celular = celular;
		return this;
	}
	
	public ClienteEntity documento(String documento) {
		this.documento = documento;
		return this;
	}
	
	public void add(Cliente cliente) {
		this.celular = cliente.getCelular();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.nome = cliente.getNome();
		this.contato = cliente.getContato();
		this.data  = cliente.getData();
		this.documento = cliente.getDocumento();
	}
    
}
