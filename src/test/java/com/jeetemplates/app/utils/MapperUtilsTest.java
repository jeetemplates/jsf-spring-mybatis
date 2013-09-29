/**
 * 
 */
package com.jeetemplates.app.utils;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.service.dto.HelloWorldDTO;
import com.jeetemplates.app.util.MapperUtils;

/**
 * Test class of {@link MapperUtils}.
 * 
 * @author jeetemplates
 */
public class MapperUtilsTest {

	/**
	 * Test of method {@link MapperUtils#map(Object, Class)}.
	 */
	@Test
	public void testMap(){
		HelloWorld entity = new HelloWorld();
		entity.setFirstName("first name");
		entity.setLastName("last name");
		HelloWorldDTO dto = (HelloWorldDTO) MapperUtils.map(entity, HelloWorldDTO.class);
		Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getLastName(), dto.getLastName());
		Assert.assertEquals(entity.getFirstName(), dto.getFirstName());
	}
	
	/**
	 * Test of method {@link MapperUtils#mapAsList(Iterable, Class)}.
	 */
	@Test
	public void testMapAsList(){
		List<HelloWorld> listEntities = new ArrayList<HelloWorld>();
		HelloWorld entity = new HelloWorld();
		entity.setFirstName("first name");
		entity.setLastName("last name");
		HelloWorld entity2 = new HelloWorld();
		entity2.setFirstName("first name 2");
		entity2.setLastName("last name 2");
		listEntities.add(entity);
		listEntities.add(entity2);
		@SuppressWarnings("unchecked")
		List<HelloWorldDTO> listDto =  (List<HelloWorldDTO>) MapperUtils.mapAsList(listEntities, HelloWorldDTO.class);
		Assert.assertNotNull(listDto);
		Assert.assertEquals(listEntities.size(), listDto.size());
		
		HelloWorldDTO dto1 = listDto.get(0);
		Assert.assertEquals(entity.getFirstName(), dto1.getFirstName());
		Assert.assertEquals(entity.getLastName(), dto1.getLastName());
	}
	
}
