package com.wm.cursojsf2.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.wm.cursojsf2.financeiro.model.Pessoa;
import com.wm.cursojsf2.financeiro.util.HibernateUtil;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		
		if (value != null) {
			Session session = HibernateUtil.getSession();
			
			retorno = (Pessoa) session.get(Pessoa.class, new Integer(value));
			
			session.close();
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getCodigo().toString();
		}
		return null;
	}

}