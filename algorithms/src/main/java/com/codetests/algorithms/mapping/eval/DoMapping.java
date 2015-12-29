package com.codetests.algorithms.mapping.eval;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.modelmapper.ModelMapper;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class DoMapping {

	public static void main(String[] args) {
		new DoMapping().checkMappers();
	}
	
	private void checkMappers() {
		Registro populatedRegistro = populateRegistro();
		System.out.println("-------------------------------");
		Registro mappedAsModelMapper = mapAsModelMapper(populatedRegistro);
		System.out.println(mappedAsModelMapper.toString());
		System.out.println("-------------------------------");
		System.out.println(mappedAsModelMapper.getCheckFailure());
		System.out.println("-------------------------------");
		// This fails because of ht field : List<List<String>> checkFailure; 
//		Registro mappedAsDozer = mapAsDozer(populatedRegistro);
//		System.out.println(mappedAsDozer.toString());
		System.out.println(populatedRegistro.equals(mappedAsModelMapper));
	}

	private Registro mapAsDozer(Registro registro) {
		Mapper mapper = new DozerBeanMapper();
        Registro mapped = mapper.map(registro, Registro.class);
        return mapped;
	}
	private Registro mapAsModelMapper(Registro registro) {
		ModelMapper modelMapper = new ModelMapper();
		Registro result = modelMapper.map(registro, Registro.class);
		return result;
	}
	
	private Registro populateRegistro() {
		PodamFactory factory = new PodamFactoryImpl();
		Registro manufacturedPojo = factory.manufacturePojoWithFullData(Registro.class);
		return manufacturedPojo;
	}
}
