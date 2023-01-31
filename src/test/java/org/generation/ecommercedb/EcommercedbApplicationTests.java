package org.generation.ecommercedb;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.ecommercedb.model.Producto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
class EcommercedbApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Prueba el método POST de productos")
	public void pruebaPOST() throws Exception {
		Producto p = new Producto();
		p.setNombre("Emprendimientos de Esdras");
		p.setDescripion("Tacos de asada");
		p.setImagen("tacosasada.jpg");
		p.setPrecio(45.55);
		this.mockMvc.perform( post("/api/productos/").contentType(MediaType.APPLICATION_JSON)
				.content( asJsonString(p))
				).andDo( print() )
		.andExpect( status().isOk() )
		.andExpect(content().string(containsString("tacosasada.jpg") ));
	}//pruebaPOST
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString

	
	
	@Test
	@DisplayName("Prueba el método PUT de productos para actualizar el nombre de una imagen")
	public void pruebaPUT() throws Exception {
		this.mockMvc.perform( put("/api/productos/3").queryParam("imagen", "tacos.jpg") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect(content().string(containsString("tacos.jpg") ));
	}//pruebaPUT
	
	@Test
	@DisplayName("Prueba el método DELETE de productos")
	@Disabled("Se deshabilita temporalmente para no borrar ")
	public void pruebaDELETE() throws Exception {
		this.mockMvc.perform( delete("/api/productos/4") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect(content().string(containsString("Emprendimiento de Esdras") ));
	}//pruebaDELETE
	

	@Test
	@DisplayName("Prueba el método GET de productos con el id=1 y su contenido")
	public void pruebaGET() throws Exception {
		this.mockMvc.perform( get("/api/productos/1") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect(content().string(containsString("tortas.jpg") ));
	}//pruebaGET
	
}//class EcommercedbApplicationTests
