package org.generation.ecommercedb.controller;

import java.util.List;

import org.generation.ecommercedb.model.Producto;
import org.generation.ecommercedb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/productos")
public class ProductoController {
	private final ProductoService productoService;

	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
}//constructor
	
	@GetMapping //http://localhost:8080/api/productos/
	public List<Producto> getAllProductos(){
		return productoService.getAllProductos();
	}//GetAllProductos
	
	@GetMapping(path="{prodId}")
	public Producto getProducto(@PathVariable("prodId") Long id) {
		return productoService.getProducto(id);
	}//getProducto
	
	@DeleteMapping(path="{prodId}")
	public Producto deleteProducto(@PathVariable("prodId") Long id) {
		return productoService.deleteProducto(id);
	}//getProducto
	
	@PostMapping
	public Producto adProducto(@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}//addProducto
	
	@PutMapping(path="{prodId}")
	public Producto uptadeProducto(@PathVariable("prodId") Long id,
		@RequestParam(required = false) String nombre,
		@RequestParam(required = false) String descripcion,
		@RequestParam(required = false) String imagen,
		@RequestParam(required = false) Double precio) {
		return productoService.updateProducto(id, nombre, descripcion, imagen, precio);
	}//getProducto
	
	
}//class ProductoController

