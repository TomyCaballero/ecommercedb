package org.generation.ecommercedb.controller;

import java.util.List;

import org.generation.ecommercedb.model.ChangePassword;
import org.generation.ecommercedb.model.Usuario;
import org.generation.ecommercedb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/usuarios/")
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	//constructor
	
	@GetMapping
	public List<Usuario> getUsuarios(){
		return usuarioService.getAllUsuarios();
	}//getUsuarios
	
	@GetMapping(path="{userId}")
	public Usuario getUsuario(@PathVariable("userid") Long id){
		return usuarioService.getUsuario(id);
	}//getUsuario
	
	@DeleteMapping(path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userid") Long id){
		return usuarioService.deleteUsuario(id);
	}//deleteUsuario
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario){
		return usuarioService.addUsuario(usuario);
	}//addUsuario
	
	@PutMapping(path= "{userId}")//http://localhost:8080/api/productos/1
	public Usuario updateUsuario(@PathVariable("userId") Long id,
			@RequestBody ChangePassword changePassword) {//me pase un old y new passsword ChangePassword pasa un objeto para transferir datos
		return usuarioService.updateUsuario(id,changePassword.getPassword(),changePassword.getNewPassword());//ya tengo el objeto y metodos para la creacion de las contra creando una nueva clase con le segunda opcion
		
	}//delete productos

	
	
//	@PutMapping (path="{userid}")
//	public Usuario updateUsuario(@PathVariable("userid") Long id, @RequestBody ChangePassword changePassword) {
//		return usuarioService.updateUsuario(id, changePassword.getPassword(), 
//				changePassword.getNewPassword());
//	}
//	
	
}//UsuarioController
