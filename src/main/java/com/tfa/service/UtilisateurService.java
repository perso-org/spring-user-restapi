package com.tfa.service;

import java.util.List;

import com.tfa.entite.Utilisateur;

public interface UtilisateurService {

	Utilisateur creationUtilisateur(Utilisateur utilisateur);
	Utilisateur obtenirUtilisateur(Integer id);
	List<Utilisateur> obtenirUtilisateurs();
}
