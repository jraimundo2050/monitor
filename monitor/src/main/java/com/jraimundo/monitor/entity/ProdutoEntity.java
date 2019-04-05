package com.jraimundo.monitor.entity;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTO_TELVENDA")
public class ProdutoEntity {
	
	@Id
    @GeneratedValue(generator = "produto_telvenda_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "produto_telvenda_seq", sequenceName = "produto_telvenda_seq", allocationSize = 1)
    @Column(name = "idproduto", unique = true, nullable = false)	
	private Long id;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;

	@Column(name = "unidade", length = 5, nullable = false)	
	private String unidade;

	@Column(name = "marca", length = 50, nullable = false)	
	private String Marca;

	@Column(name = "codantigo", length = 20, nullable = false)	
	private String codAntigo;
	
	@Column(name = "quanitdade", precision = 6, scale = 2, nullable = false)	
	private BigDecimal quantidade;
	
	@Column(name = "preco", precision = 6, scale = 2, nullable = false)	
	private BigDecimal preco;
	
	@Column(name = "codigoBarra1", length = 20, nullable = false)	
	private String codigoBarra1;

	@Column(name = "codigoBarra2", length = 20, nullable = false)	
	private String codigoBarra2;
	
	@Lob
	@Column(name = "foto", nullable = true)	
	private Byte[] foto;

	public ProdutoEntity() {
		
	}
	
	public ProdutoEntity(Long id, String nome, String descricao, String unidade, String marca, String codAntigo,
			BigDecimal quantidade, BigDecimal preco, String codigoBarra1, String codigoBarra2, Byte[] foto) {
		super();
		this.id = id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProdutoEntity other = (ProdutoEntity) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "ProdutoEntity [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", unidade=" + unidade
				+ ", Marca=" + Marca + ", codAntigo=" + codAntigo + ", quantidade=" + quantidade + ", preco=" + preco
				+ ", codigoBarra1=" + codigoBarra1 + ", codigoBarra2=" + codigoBarra2 + ", foto="
				+ Arrays.toString(foto) + "]";
	}


}
