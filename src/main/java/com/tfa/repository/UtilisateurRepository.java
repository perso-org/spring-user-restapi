package com.tfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfa.entite.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer >{

}
