package br.com.costumer.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.costumer.model.Endereco;
import br.com.costumer.model.Status;
import br.com.costumer.services.DataServices;

@Controller
@RequestMapping("/enderecos")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addEndereco(@RequestBody Endereco endereco) {
		
		String enderecoIsEmpty = "";
		
		if(StringUtils.isBlank(endereco.getRua())) {
			enderecoIsEmpty += " rua,";
		} 
		if(StringUtils.isBlank(endereco.getNumero())) {
			enderecoIsEmpty += " numero,";
		} 
		if(StringUtils.isBlank(endereco.getCep())) {
			enderecoIsEmpty += " cep,";
		} 
		if(StringUtils.isBlank(endereco.getCidade())) {
			enderecoIsEmpty += " cidade,";
		} 
		if(StringUtils.isBlank(endereco.getEstado())) {
			enderecoIsEmpty += " estado,";
		}
		
		if(StringUtils.isNotEmpty(enderecoIsEmpty)){
			enderecoIsEmpty = enderecoIsEmpty.substring(0, enderecoIsEmpty.length()-1);
			return new Status(1, "The fields:" + enderecoIsEmpty + " is required");
		}
		
		try {
			dataServices.addEntity(endereco);
			return new Status(1, "Endereco added Successfully !");
		} catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody String getEndereco(@PathVariable("id") long id) {
		Endereco endereco = null;
		String json = "";
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();;
		try {
			endereco = dataServices.getEntityById(id);
			if(endereco != null){
				json = mapper.writeValueAsString(endereco);
			} 
		} catch (Exception e) {
			json = "Id not found!";
		}
		return json;
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status updateEndereco(@RequestBody Endereco endereco) {
		
		String enderecoIsEmpty = "";
		
		if(endereco.getId() == 0) {
			return new Status(1, "Id is required for update");
		}
		
		if(StringUtils.isBlank(endereco.getRua())) {
			enderecoIsEmpty += " rua,";
		} 
		if(StringUtils.isBlank(endereco.getNumero())) {
			enderecoIsEmpty += " numero,";
		} 
		if(StringUtils.isBlank(endereco.getCep())) {
			enderecoIsEmpty += " cep,";
		} 
		if(StringUtils.isBlank(endereco.getCidade())) {
			enderecoIsEmpty += " cidade,";
		} 
		if(StringUtils.isBlank(endereco.getEstado())) {
			enderecoIsEmpty += " estado,";
		}
		
		if(StringUtils.isNotEmpty(enderecoIsEmpty)){
			enderecoIsEmpty = enderecoIsEmpty.substring(0, enderecoIsEmpty.length()-1);
			return new Status(1, "The fields:" + enderecoIsEmpty + " is required");
		}
		
		try {
			dataServices.updateEntity(endereco);
			return new Status(1, "Endereco updated Successfully !");
		} catch (Exception e) {
			return new Status(0, "Id not found for update!");
		}
	}
	
	
	
	@RequestMapping(value = "/cep/{id}", method = RequestMethod.GET)
	public @ResponseBody String getCEP(@PathVariable("id") String cep) {
		Endereco endereco = null;
		String json = "";
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();;
		try {
			endereco = dataServices.getCEP(cep);
			if(endereco != null){
				json = mapper.writeValueAsString(endereco);
			} else {
				json = "CEP invalido!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Endereco> getEndereco() {

		List<Endereco> enderecoList = null;
		try {
			enderecoList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return enderecoList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteEndereco(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Endereco deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, "Id not found for delete");
		}

	}
}
