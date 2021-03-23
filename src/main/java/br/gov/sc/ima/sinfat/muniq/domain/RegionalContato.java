package br.gov.sc.ima.sinfat.muniq.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.sc.ima.sinfat.muniq.enums.TipoContatoEnum;

@Entity
@Table(name = "REGIONAL_CONTATO")
public class RegionalContato implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "regCodigo", column = @Column(name = "REG_CODIGO", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "regctContato", column = @Column(name = "REGCT_CONTATO", nullable = false, length = 100)) })
	private RegionalContatoId id;

	@Column(name = "TIPO_CONTATO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoContatoEnum tipoContato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REG_CODIGO", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Regional regional;

	@Column(name = "REGCT_PRINCIPAL", nullable = false, length = 1)
	private char regctPrincipal;

	public RegionalContato() {
		regional = new Regional();
	}

	public RegionalContato(RegionalContatoId id, TipoContatoEnum tipoContato, Regional regional, char regctPrincipal) {
		this.id = id;
		this.tipoContato = tipoContato;
		this.regional = regional;
		this.regctPrincipal = regctPrincipal;
	}

	public RegionalContatoId getId() {
		return this.id;
	}

	public void setId(RegionalContatoId id) {
		this.id = id;
	}

	public TipoContatoEnum getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContatoEnum tipoContato) {
		this.tipoContato = tipoContato;
	}

	public Regional getRegional() {
		return this.regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public char getRegctPrincipal() {
		return this.regctPrincipal;
	}

	public void setRegctPrincipal(char regctPrincipal) {
		this.regctPrincipal = regctPrincipal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RegionalContato other = (RegionalContato) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "RegionalContato [id=" + id.getRegCodigo() + ", regional=" + regional.getRegCodigo() + ", tipoContato="
				+ tipoContato + "]";
	}

}