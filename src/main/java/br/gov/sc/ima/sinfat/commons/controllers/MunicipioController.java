package br.gov.sc.ima.sinfat.commons.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.gov.sc.ima.sinfat.commons.domain.Municipalizacao;
import br.gov.sc.ima.sinfat.commons.domain.Municipio;
import br.gov.sc.ima.sinfat.commons.repositories.MunicipalizacaoRepository;
import br.gov.sc.ima.sinfat.commons.repositories.MunicipioRepository;
import br.gov.sc.ima.sinfat.dtos.MunicipalizacaoDto;
import br.gov.sc.ima.sinfat.enums.EstadoEnum;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

@Path("")
public class MunicipioController {
	
	@Inject
	MunicipioRepository mRepo;
	@Inject
	MunicipalizacaoRepository mzRepo;
	
    @GET
    @Path("/hello-resteasy")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
    
    @GET
    @Path("/municipios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMunicipios(
    		@QueryParam("page") @DefaultValue("0") int pageIndex,
            @QueryParam("size") @DefaultValue("100") int pageSize) {
    	Page page = Page.of(pageIndex, pageSize);
    	PanacheQuery<Municipio> pqm = mRepo.findAll(Sort.ascending("estado","municDescricao"));
        List<Municipio> munics = pqm.page(page).list();
        return Response.ok(munics).build();
    }
    
    @GET
    @Path("/municipios/{estado}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMunicipios(
    		@PathParam("estado") @DefaultValue("SC") EstadoEnum estado,
    		@QueryParam("page") @DefaultValue("0") int pageIndex,
            @QueryParam("size") @DefaultValue("100") int pageSize) {
    	Page page = Page.of(pageIndex, pageSize);
        List<Municipio> munics = mRepo.find("estado",Sort.ascending("municDescricao"),estado)
        		                     .page(page)
        		                     .list();
        return Response.ok(munics).build();
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/municipio/{id}")
    public Response getMunicipioById(
    		@PathParam("id") Integer id, 
    		@QueryParam("tipo") @DefaultValue("id") String tipo) {
    	Optional<Municipio> r = Optional.empty();
    	if(tipo.toLowerCase().equals("id")) {
    		r = mRepo.findByMunicCodigo(id);
    	}else if(tipo.toLowerCase().equals("ibge")) {
    		r = mRepo.findByMunicCodigoIbge(id);
    	}else if(tipo.toLowerCase().equals("tom")) {
    		r = mRepo.findByMunicCodigoTOM(id);
    	}    	
    	return Response.ok(r.isPresent()?r:"{}").build();
    }
    
    @GET
    @Path("/municipios/licenciados")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getMunicipiosLicenciados() {
    	Optional<List<Municipalizacao>> ms = mzRepo.findByMunizDataFimIsNullOrderByMunicipioMunicDescricao();
    	
		if(ms.isPresent()){
			List<MunicipalizacaoDto> result = ms.get().stream()
					.map(m -> new MunicipalizacaoDto(
							m.getMunicCodigo(),m.getNivel(),
							m.getMunizDataInicio(),m.getMunicipio().getMunicDescricao(),
							m.getMunicipio().getMunicCodigoIbge(),m.getMunicipio().getEstado()))
					.collect(Collectors.toList());
			return Response.ok(result).build();
		}else{
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}