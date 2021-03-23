package br.gov.sc.ima.sinfat.muniq.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.sc.ima.sinfat.muniq.enums.TipoContatoEnum;

@Entity
@Table(name = "REGIONAL")
@SequenceGenerator(name = "SEQ_REGIONAL", sequenceName = "SEQ_REGIONAL", allocationSize = 1)
public class Regional implements java.io.Serializable {

	private static final long serialVersionUID = -8568975821865698697L;

	@Id
	@GeneratedValue(generator = "SEQ_REGIONAL")
	@Column(name = "REG_CODIGO", unique = true, nullable = false, precision = 22, scale = 0)
	private Integer regCodigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "END_CODIGO", nullable = false)
	private Endereco endereco;

	@Column(name = "REG_DESCRICAO", nullable = false, length = 100)
	private String regDescricao;

	@Column(name = "REG_RESUMO", nullable = false, length = 50)
	private String regResumo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "regional")
	@Cascade(CascadeType.SAVE_UPDATE)
	@JsonIgnore
	private Set<Municipio> municipios = new HashSet<Municipio>(0);

	@OneToMany(fetch = FetchType.LAZY)
	private List<RegionalContato> regionalContatos;

//	private LocalDate inicioAtividades;
//	private LocalDate fimAtividades;
//
//	@Column(name = "reg_email", nullable = false, length = 120)
//	@Email(message="O e-mail está em formato inválido.")
//	private String email;
//	@Column(name = "reg_telefone", nullable = false, length = 14)
//	private String telefone;

	public Regional() {
	}

	public Regional(Integer regCodigo, String regDescricao, String regResumo) {
		super();
		this.regCodigo = regCodigo;
		this.regDescricao = regDescricao;
		this.regResumo = regResumo;
	}

	public Regional(Integer regCodigo, Endereco endereco, String regDescricao, String regSigla, String regResumo,
			LocalDate inicioAtividades) {
		this.regCodigo = regCodigo;
		this.endereco = endereco;
		this.regDescricao = regDescricao;
		this.regResumo = regResumo;
//		this.inicioAtividades = inicioAtividades;
	}

	public Integer getRegCodigo() {
		return this.regCodigo;
	}

	public void setRegCodigo(Integer regCodigo) {
		this.regCodigo = regCodigo;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getRegDescricao() {
		return this.regDescricao;
	}

	public void setRegDescricao(String regDescricao) {
		this.regDescricao = regDescricao;
	}

	public String getRegResumo() {
		return regResumo;
	}

	public void setRegResumo(String regResumo) {
		this.regResumo = regResumo;
	}

	public Set<Municipio> getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(Set<Municipio> municipios) {
		this.municipios = municipios;
	}

	public List<RegionalContato> getRegionalContatos() {
		return this.regionalContatos;
	}

	public void setRegionalContatos(List<RegionalContato> regionalContatos) {
		this.regionalContatos = regionalContatos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regCodigo == null) ? 0 : regCodigo.hashCode());
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
		Regional other = (Regional) obj;
		if (regCodigo == null) {
			if (other.regCodigo != null) {
				return false;
			}
		} else if (!regCodigo.equals(other.regCodigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Regional [endereco=" + endereco.getEndCodigo() + ", regCodigo=" + regCodigo + ", regDescricao="
				+ regDescricao + "]";
	}
//
//	public LocalDate getInicioAtividades() {
//		return inicioAtividades;
//	}
//
//	public void setInicioAtividades(LocalDate inicioAtividades) {
//		this.inicioAtividades = inicioAtividades;
//	}
//
//	public LocalDate getFimAtividades() {
//		return fimAtividades;
//	}
//
//	public void setFimAtividades(LocalDate fimAtividades) {
//		this.fimAtividades = fimAtividades;
//	}

	public String getTelefone() {
		return pegaContato(TipoContatoEnum.TELEFONE);
	}

	public String getEmail() {
		return pegaContato(TipoContatoEnum.EMAIL);
	}

	private String pegaContato(TipoContatoEnum tipo) {
		Optional<RegionalContato> opc = this.getRegionalContatos().stream().filter(c -> c.getTipoContato() == tipo)
				.findFirst();
		return opc.isEmpty() ? null : opc.get().getId().getRegctContato();
	}
}