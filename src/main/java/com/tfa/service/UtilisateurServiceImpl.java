package com.tfa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tfa.entite.Utilisateur;
import com.tfa.repository.UtilisateurRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{


	private final UtilisateurRepository repository;
	
	@Override
	public Utilisateur creationUtilisateur(Utilisateur utilisateur) {
		return repository.save(utilisateur);
	}

	@Override
	public Utilisateur obtenirUtilisateur(Integer id) {
		Optional<Utilisateur> usr = repository.findById(id);
		return usr.orElse(null);
	}

	@Override
	public List<Utilisateur> obtenirUtilisateurs() {
		return repository.findAll();
	}

}
