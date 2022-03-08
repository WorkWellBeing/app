package com.esprit.pidev.services;

import com.esprit.pidev.entities.Formulaire;

public interface FormulaireService {
	Formulaire addfrom(Formulaire form);
	Formulaire addf(Formulaire  q, Long id);
}
