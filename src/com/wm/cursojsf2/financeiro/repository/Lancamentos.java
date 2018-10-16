package com.wm.cursojsf2.financeiro.repository;

import java.util.List;

import com.wm.cursojsf2.financeiro.model.Lancamento;

public interface Lancamentos {

	public List<Lancamento> todos();
	public Lancamento guardar(Lancamento lancamento);
	public void remover(Lancamento lancamento);
	
}