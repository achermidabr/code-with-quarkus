//package br.gov.sc.ima.sinfat.commons.domain;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.Index;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import org.hibernate.annotations.Immutable;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import br.gov.sc.ima.sinfat.commons.enums.EstadoEnum;
//
//
//@Entity
//@Immutable
//@Table(name = "MUNICIPIO", indexes = { @Index(name = "municipio_reg_codigo_idx", columnList = "reg_codigo") })
//public class Municipio implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name = "MUNIC_CODIGO", unique = true, nullable = false, precision = 22, scale = 0)
//	private Integer municCodigo;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "REG_CODIGO")
//	@JsonIgnore
//	private Regional regional;
//
//	@Enumerated(EnumType.STRING)
//	@Column(name = "ESTAD_UF", nullable = false, length = 2)
//	@NotNull
//	@Size(min = 2, max = 2)
//	private EstadoEnum estado;
//
//	@Column(name = "MUNIC_CEP", nullable = true, precision = 22, scale = 0)
//	private Integer municCep;
//
//	@Column(name = "MUNIC_DESCRICAO", nullable = false, length = 100)
//	@NotNull
//	@Size(min = 2, max = 100)
//	private String municDescricao;
//
//	@Column(name = "MUNIC_CODIGO_IBGE", precision = 22, scale = 0)
//	private Integer municCodigoIbge;
//	
//	@Column(name = "MUNICIPIO_CODIGO_SGPE", precision = 22, scale = 0, nullable = true)
//	private Integer municCodigoTOM;
//
//	public Municipio() {
//		estado = EstadoEnum.SC;
//	}
//
//	public Municipio(Integer municCodigo) {
//		this.municCodigo = municCodigo;
//		estado = EstadoEnum.SC;
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
//	public Regional getRegional() {
//		return this.regional;
//	}
//
//	public void setRegional(Regional regional) {
//		this.regional = regional;
//	}
//
//	public EstadoEnum getEstado() {
//		return this.estado;
//	}
//
//	public void setEstado(EstadoEnum estado) {
//		this.estado = estado;
//	}
//
//	public String getMunicDescricao() {
//		return this.municDescricao;
//	}
//
//	public void setMunicDescricao(String municDescricao) {
//		this.municDescricao = municDescricao;
//	}
//
//	public Integer getMunicCodigoIbge() {
//		return this.municCodigoIbge;
//	}
//
//	public void setMunicCodigoIbge(Integer municCodigoIbge) {
//		this.municCodigoIbge = municCodigoIbge;
//	}
//
//	public Integer getMunicCep() {
//		return this.municCep;
//	}
//
//	public void setMunicCep(Integer municCep) {
//		this.municCep = municCep;
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
//		Municipio other = (Municipio) obj;
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
//}