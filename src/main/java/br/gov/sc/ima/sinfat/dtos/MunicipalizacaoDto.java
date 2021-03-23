package br.gov.sc.ima.sinfat.dtos;

import java.time.LocalDate;

import br.gov.sc.ima.sinfat.enums.EstadoEnum;

public class MunicipalizacaoDto  implements Comparable<MunicipalizacaoDto>{
		private Integer municCodigo;
		private Integer nivel;
		private LocalDate munizDataInicio;
		private String nome;
		private Integer ibge;
		private EstadoEnum uf;
		
		public MunicipalizacaoDto() {
			super();
		}
		public MunicipalizacaoDto(Integer municCodigo, Integer nivel, LocalDate munizDataInicio, String nome,
				Integer ibge, EstadoEnum uf) {
			super();
			this.municCodigo = municCodigo;
			this.nivel = nivel;
			this.munizDataInicio = munizDataInicio;
			this.nome = nome;
			this.ibge = ibge;
			this.uf = uf;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getIbge() {
			return ibge;
		}

		public void setIbge(Integer ibge) {
			this.ibge = ibge;
		}

		public EstadoEnum getUf() {
			return uf;
		}

		public void setUf(EstadoEnum uf) {
			this.uf = uf;
		}

		public Integer getMunicCodigo() {
			return municCodigo;
		}
		public void setMunicCodigo(Integer municCodigo) {
			this.municCodigo = municCodigo;
		}
		public Integer getNivel() {
			return nivel;
		}
		public void setNivel(Integer nivel) {
			this.nivel = nivel;
		}
		public LocalDate getMunizDataInicio() {
			return munizDataInicio;
		}
		public void setMunizDataInicio(LocalDate munizDataInicio) {
			this.munizDataInicio = munizDataInicio;
		}

		@Override
		public int compareTo(MunicipalizacaoDto o) {
			return this.getNome().compareTo(o.getNome());
		}
}
