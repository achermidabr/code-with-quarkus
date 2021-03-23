package br.gov.sc.ima.sinfat.commons.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.gov.sc.ima.sinfat.commons.domain.Municipalizacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

@Repository
public class MunicipalizacaoRepository implements PanacheRepository<Municipalizacao> {

	public Optional<List<Municipalizacao>> findByMunizDataFimIsNullOrderByMunicipioMunicDescricao() {
        return Optional.ofNullable(
        		find("munizDataFim is null",Sort.ascending("municipio.municDescricao"))
        		.list());
	}	
}
