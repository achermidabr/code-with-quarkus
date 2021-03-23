//package br.gov.sc.ima.sinfat.commons.domain;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Index;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@Entity
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//@Table(name = "ENDERECO", indexes = { @Index(name = "endereco_munic_codigo_idx", columnList = "munic_codigo") })
//@SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO", allocationSize = 1, initialValue = 1)
//public class Endereco implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(generator = "SEQ_ENDERECO", strategy = GenerationType.SEQUENCE)
//	@Column(name = "END_CODIGO", unique = true, nullable = false, precision = 22, scale = 0)
//	private Integer endCodigo;
//
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "MUNIC_CODIGO", nullable = false)
//	private Municipio municipio;
//
//	@Column(name = "END_LOGRADOURO", nullable = false, length = 100)
//	private String endLogradouro;
//
//	@Column(name = "END_NUMERO", nullable = false, length = 20)
//	private String endNumero;
//
//	@Column(name = "END_BAIRRO", nullable = true, length = 50)
//	private String endBairro;
//
//	@Column(name = "END_COMPLEMENTO", length = 200)
//	private String endComplemento;
//
//	@Column(name = "END_CAIXA_POSTAL", length = 40)
//	private String endCaixaPostal;
//
//	@Column(name = "END_CEP", nullable = false, length = 8)
//	@Size(min = 8, max = 8, message = "O CEP deve ter 8 dígitos")
//	private String endCep;
//
//	public Endereco() {
//	}
//
//	public Endereco(Integer endCodigo, Municipio municipio, String endLogradouro, String endNumero, String endBairro,
//			String endCep) {
//		this.endCodigo = endCodigo;
//		this.municipio = municipio;
//		this.endLogradouro = endLogradouro;
//		this.endNumero = endNumero;
//		this.endBairro = endBairro;
//		this.endCep = endCep;
//	}
//
//	public Integer getEndCodigo() {
//		return this.endCodigo;
//	}
//
//	public void setEndCodigo(Integer endCodigo) {
//		this.endCodigo = endCodigo;
//	}
//
//	public Municipio getMunicipio() {
//		return this.municipio;
//	}
//
//	public void setMunicipio(Municipio municipio) {
//		this.municipio = municipio;
//	}
//
//	public String getEndLogradouro() {
//		return this.endLogradouro;
//	}
//
//	public void setEndLogradouro(String endLogradouro) {
//		this.endLogradouro = endLogradouro;
//	}
//
//	public String getEndNumero() {
//		return this.endNumero;
//	}
//
//	public void setEndNumero(String endNumero) {
//		this.endNumero = endNumero;
//	}
//
//	public String getEndBairro() {
//		return this.endBairro;
//	}
//
//	public void setEndBairro(String endBairro) {
//		this.endBairro = endBairro;
//	}
//
//	public String getEndComplemento() {
//		return this.endComplemento;
//	}
//
//	public void setEndComplemento(String endComplemento) {
//		this.endComplemento = endComplemento;
//	}
//
//	public String getEndCaixaPostal() {
//		return this.endCaixaPostal;
//	}
//
//	public void setEndCaixaPostal(String endCaixaPostal) {
//		this.endCaixaPostal = endCaixaPostal;
//	}
//
//	public String getEndCep() {
//		return this.endCep;
//	}
//
//	public void setEndCep(String endCep) {
//		this.endCep = endCep;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((endBairro == null) ? 0 : endBairro.hashCode());
//		result = prime * result + ((endCaixaPostal == null) ? 0 : endCaixaPostal.hashCode());
//		result = prime * result + ((endCep == null) ? 0 : endCep.hashCode());
//		result = prime * result + ((endComplemento == null) ? 0 : endComplemento.hashCode());
//		result = prime * result + ((endLogradouro == null) ? 0 : endLogradouro.hashCode());
//		result = prime * result + ((endNumero == null) ? 0 : endNumero.hashCode());
//		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj == null) {
//			return false;
//		}
//		if (getClass() != obj.getClass()) {
//			return false;
//		}
//		Endereco other = (Endereco) obj;
//		if (endBairro == null) {
//			if (other.endBairro != null) {
//				return false;
//			}
//		} else if (!endBairro.equals(other.endBairro)) {
//			return false;
//		}
//		if (endCaixaPostal == null) {
//			if (other.endCaixaPostal != null) {
//				return false;
//			}
//		} else if (!endCaixaPostal.equals(other.endCaixaPostal)) {
//			return false;
//		}
//		if (endCep == null) {
//			if (other.endCep != null) {
//				return false;
//			}
//		} else if (!endCep.equals(other.endCep)) {
//			return false;
//		}
//		if (endComplemento == null) {
//			if (other.endComplemento != null) {
//				return false;
//			}
//		} else if (!endComplemento.equals(other.endComplemento)) {
//			return false;
//		}
//		if (endLogradouro == null) {
//			if (other.endLogradouro != null) {
//				return false;
//			}
//		} else if (!endLogradouro.equals(other.endLogradouro)) {
//			return false;
//		}
//		if (endNumero == null) {
//			if (other.endNumero != null) {
//				return false;
//			}
//		} else if (!endNumero.equals(other.endNumero)) {
//			return false;
//		}
//		if (municipio == null) {
//			if (other.municipio != null) {
//				return false;
//			}
//		} else if (!municipio.equals(other.municipio)) {
//			return false;
//		}
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "Endereco [endCep=" + endCep + ", endCodigo=" + endCodigo + "]";
//	}
//
//	public String montaEnderecoSimples() {
//		StringBuilder sb = new StringBuilder();
//		return sb.append(endLogradouro).append(", ").append(endNumero).append(", ").append(endBairro).toString();
//	}
//
//	public String montaEnderecoCompleto() {
//		StringBuilder sb = new StringBuilder();
//		return sb.append(endLogradouro).append(", ").append(endNumero).append(", ").append(endBairro).append(", CEP: ")
//				.append(endCep).append(". ").append(municipio.getMunicDescricao()).append("-")
//				.append(municipio.getEstado().name()).toString();
//	}
//
//}