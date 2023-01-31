package org.generation.ecommercedb.service;

import java.util.Optional;

import org.generation.ecommercedb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface usuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE u.email=?1") //JPQL - Java Persistence Query Lenguage
	Optional<Usuario> findByEmail(String email);
	
}//interfaz usuarioRepository
