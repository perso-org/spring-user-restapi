package com.tfa.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tfa.entite.Utilisateur;
import com.tfa.service.UtilisateurService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/utilisateurs")
public class UtilisateurController {

	private final UtilisateurService service;
	
	@PostMapping("creation")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Utilisateur> creationUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur utilisateur2 = service.creationUtilisateur(utilisateur);
		return new ResponseEntity<>(utilisateur2,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Utilisateur> obtenirUtilisateur(@PathVariable int id) {
		
		Utilisateur utilisateur = service.obtenirUtilisateur(id);
		return Objects.nonNull(utilisateur) ? ResponseEntity.ok(utilisateur) :
			new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
	}
	
	@GetMapping
	public ResponseEntity<List<Utilisateur>> obtenirUtilisateurs() {
		List<Utilisateur> utilisateurs = service.obtenirUtilisateurs();
		return Objects.nonNull(utilisateurs) && !utilisateurs.isEmpty() ? ResponseEntity.ok(utilisateurs) :
			new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
	}
}
