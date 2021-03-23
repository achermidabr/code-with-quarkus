package br.gov.sc.ima.sinfat.commons.repositories;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import br.gov.sc.ima.sinfat.commons.domain.Municipio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Repository
public class MunicipioRepository implements PanacheRepository<Municipio> {

	@Cacheable
	public Optional<Municipio> findByMunicCodigoIbge(Integer ibge) {
		return Optional.ofNullable(find("municCodigoIbge", ibge).firstResult());
	}

	@Cacheable
	public Optional<Municipio> findByMunicCodigoTOM(Integer tom) {
		return Optional.ofNullable(find("municCodigoTOM", tom).firstResult());
	}
	
	@Cacheable
	public Optional<Municipio> findByMunicCodigo(Integer id) {
		return Optional.ofNullable(find("municCodigo", id).firstResult());
	}
}
