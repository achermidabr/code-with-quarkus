//package br.gov.sc.ima.sinfat.commons.domain;
//
//import java.time.LocalDate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;
//
//@Entity
//@Table(name = "MUNICIPALIZACAO")
//public class Municipalizacao implements java.io.Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "municipio"))
//	@Id
//	@GeneratedValue(generator = "generator")
//	@Column(name = "MUNIC_CODIGO", unique = true, nullable = false, precision = 22, scale = 0)
//	private Integer municCodigo;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "END_CODIGO", nullable = false)
//	private Endereco endereco;
//
//	@Column(name = "NIVEL_CODIGO", nullable = false)
//	private Integer nivel;
//
//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	private Municipio municipio;
//
//	@Column(name = "MUNIZ_NUMERO", nullable = false, length = 50)
//	private String munizNumero;
//
//	@Column(name = "MUNIZ_DATA_INICIO", nullable = false, length = 7)
//	private LocalDate munizDataInicio;
//
//	@Column(name = "MUNIZ_DATA_FIM", length = 7)
//	private LocalDate munizDataFim;
//
//	@Column(name = "MUNIZ_ORGAO", nullable = false, length = 200)
//	private String munizOrgao;
//
//	@Column(name = "MUNIZ_NIVEL_ATIV_DIFERENCIADO", nullable = false, length = 1)
//	private char munizNivelAtivDiferenciado;
//
//	public Municipalizacao() {
//		municipio = new Municipio();
//		endereco = new Endereco();
//	}
//
//	public Municipalizacao(Endereco endereco, Integer nivel, Municipio municipio, String munizNumero,
//			LocalDate munizDataInicio) {
//		this.endereco = endereco;
//		this.nivel = nivel;
//		this.municipio = municipio;
//		this.munizNumero = munizNumero;
//		this.munizDataInicio = munizDataInicio;
//	}
//
//	public Municipalizacao(Endereco endereco, Integer nivel, Municipio municipio, String munizNumero,
//			LocalDate munizDataInicio, LocalDate munizDataFim) {
//		this.endereco = endereco;
//		this.nivel = nivel;
//		this.municipio = municipio;
//		this.munizNumero = munizNumero;
//		this.munizDataInicio = munizDataInicio;
//		this.munizDataFim = munizDataFim;
//	}
//
//	public Integer getMunicCodigo() {
//		return this.municCodigo;
//	}
//
//	public void setMunicCodigo(Integer municCodigo) {
//		this.municCodigo = municCodigo;
//	}
//
//	public Endereco getEndereco() {
//		return this.endereco;
//	}
//
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}
//
//	public Integer getNivel() {
//		return this.nivel;
//	}
//
//	public void setNivel(Integer nivel) {
//		this.nivel = nivel;
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
//	public String getMunizNumero() {
//		return this.munizNumero;
//	}
//
//	public void setMunizNumero(String munizNumero) {
//		this.munizNumero = munizNumero;
//	}
//
//	public String getMunizOrgao() {
//		return munizOrgao;
//	}
//
//	public void setMunizOrgao(String munizOrgao) {
//		this.munizOrgao = munizOrgao;
//	}
//
//	public LocalDate getMunizDataInicio() {
//		return this.munizDataInicio;
//	}
//
//	public void setMunizDataInicio(LocalDate munizDataInicio) {
//		this.munizDataInicio = munizDataInicio;
//	}
//
//	public LocalDate getMunizDataFim() {
//		return this.munizDataFim;
//	}
//
//	public void setMunizDataFim(LocalDate munizDataFim) {
//		this.munizDataFim = munizDataFim;
//	}
//
//	public char getMunizNivelAtivDiferenciado() {
//		return munizNivelAtivDiferenciado;
//	}
//
//	public void setMunizNivelAtivDiferenciado(char munizNivelAtivDiferenciado) {
//		this.munizNivelAtivDiferenciado = munizNivelAtivDiferenciado;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((municCodigo == null) ? 0 : municCodigo.hashCode());
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
//		Municipalizacao other = (Municipalizacao) obj;
//		if (municCodigo == null) {
//			if (other.municCodigo != null) {
//				return false;
//			}
//		} else if (!municCodigo.equals(other.municCodigo)) {
//			return false;
//		}
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "Municipalizacao [municCodigo=" + municCodigo + ", munizNumero=" + munizNumero + ", munizOrgao="
//				+ munizOrgao + "]";
//	}
//
//}