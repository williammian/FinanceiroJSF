package com.wm.cursojsf2.financeiro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wm.cursojsf2.financeiro.model.Pessoa;
import com.wm.cursojsf2.financeiro.util.HibernateUtil;

public class TesteHibernate {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		List<Pessoa> pessoas = session.createCriteria(Pessoa.class)
				.add(Restrictions.gt("codigo", 3))
				.list();
		
		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + " - " + p.getNome());
		}
		
		session.close();
	}

}
