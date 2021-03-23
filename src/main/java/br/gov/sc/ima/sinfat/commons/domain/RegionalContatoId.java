//package br.gov.sc.ima.sinfat.commons.domain;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class RegionalContatoId implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	@Column(name = "REG_CODIGO", nullable = false, precision = 10, scale = 0)
//	private long regCodigo;
//
//	@Column(name = "REGCT_CONTATO", nullable = false, length = 100)
//	private String regctContato;
//
//	public RegionalContatoId() {
//	}
//
//	public RegionalContatoId(long regCodigo, String regctContato) {
//		this.regCodigo = regCodigo;
//		this.regctContato = regctContato;
//	}
//
//	public long getRegCodigo() {
//		return this.regCodigo;
//	}
//
//	public void setRegCodigo(long regCodigo) {
//		this.regCodigo = regCodigo;
//	}
//
//	public String getRegctContato() {
//		return this.regctContato;
//	}
//
//	public void setRegctContato(String regctContato) {
//		this.regctContato = regctContato;
//	}
//
//	@Override
//	public boolean equals(Object other) {
//		if (this == other) {
//			return true;
//		}
//		if (other == null) {
//			return false;
//		}
//		if (!(other instanceof RegionalContatoId)) {
//			return false;
//		}
//		RegionalContatoId castOther = (RegionalContatoId) other;
//
//		return (this.getRegCodigo() == castOther.getRegCodigo())
//				&& ((this.getRegctContato() == castOther.getRegctContato())
//						|| (this.getRegctContato() != null && castOther.getRegctContato() != null
//								&& this.getRegctContato().equals(castOther.getRegctContato())));
//	}
//
//	@Override
//	public int hashCode() {
//		int result = 17;
//
//		result = 37 * result + (int) this.getRegCodigo();
//		result = 37 * result + (getRegctContato() == null ? 0 : this.getRegctContato().hashCode());
//		return result;
//	}
//
//	@Override
//	public String toString() {
//		return "RegionalContatoId [regCodigo=" + regCodigo + ", regctContato=" + regctContato + "]";
//	}
//
//}