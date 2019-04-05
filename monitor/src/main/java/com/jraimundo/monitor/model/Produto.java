package com.jraimundo.monitor.model;

import java.math.BigDecimal;
import java.util.Arrays;

public class Produto {
	
	private Long idProduto;
	private String nome;
	private String descricao;
	private String unidade;
	private String Marca;
	private String codAntigo;
	private BigDecimal quantidade;
	private BigDecimal preco;
	private String codigoBarra1;
	private String codigoBarra2;
	private Byte[] foto;
	
	public Produto() {
		
	}
	
	public Produto(Long idProduto, String nome, String descricao, String unidade, String marca, String codAntigo,
			BigDecimal quantidade, BigDecimal preco, String codigoBarra1, String codigoBarra2, Byte[] foto) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.unidade = unidade;
		Marca = marca;
		this.codAntigo = codAntigo;
		this.quantidade = quantidade;
		this.preco = preco;
		this.codigoBarra1 = codigoBarra1;
		this.codigoBarra2 = codigoBarra2;
		this.foto = foto;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getCodAntigo() {
		return codAntigo;
	}
	public void setCodAntigo(String codAntigo) {
		this.codAntigo = codAntigo;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public String getCodigoBarra1() {
		return codigoBarra1;
	}
	public void setCodigoBarra1(String codigoBarra1) {
		this.codigoBarra1 = codigoBarra1;
	}
	public String getCodigoBarra2() {
		return codigoBarra2;
	}
	public void setCodigoBarra2(String codigoBarra2) {
		this.codigoBarra2 = codigoBarra2;
	}
	public Byte[] getFoto() {
		return foto;
	}
	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Marca == null) ? 0 : Marca.hashCode());
		result = prime * result + ((codAntigo == null) ? 0 : codAntigo.hashCode());
		result = prime * result + ((codigoBarra1 == null) ? 0 : codigoBarra1.hashCode());
		result = prime * result + ((codigoBarra2 == null) ? 0 : codigoBarra2.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (Marca == null) {
			if (other.Marca != null)
				return false;
		} else if (!Marca.equals(other.Marca))
			return false;
		if (codAntigo == null) {
			if (other.codAntigo != null)
				return false;
		} else if (!codAntigo.equals(other.codAntigo))
			return false;
		if (codigoBarra1 == null) {
			if (other.codigoBarra1 != null)
				return false;
		} else if (!codigoBarra1.equals(other.codigoBarra1))
			return false;
		if (codigoBarra2 == null) {
			if (other.codigoBarra2 != null)
				return false;
		} else if (!codigoBarra2.equals(other.codigoBarra2))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", unidade="
				+ unidade + ", Marca=" + Marca + ", codAntigo=" + codAntigo + ", quantidade=" + quantidade + ", preco="
				+ preco + ", codigoBarra1=" + codigoBarra1 + ", codigoBarra2=" + codigoBarra2 + "]";
	}
	

}
