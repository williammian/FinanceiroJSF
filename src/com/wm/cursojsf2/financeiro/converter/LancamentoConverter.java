package com.wm.cursojsf2.financeiro.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.wm.cursojsf2.financeiro.model.Lancamento;
import com.wm.cursojsf2.financeiro.repository.Lancamentos;
import com.wm.cursojsf2.financeiro.util.Repositorios;

@FacesConverter(forClass=Lancamento.class)
public class LancamentoConverter implements Converter {

	private Repositorios repositoriosBean = new Repositorios();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Lancamento retorno = null;
		Lancamentos lancamentos = this.repositoriosBean.getLancamentos();
		
		if (value != null && !value.equals("")) {
			retorno = lancamentos.porCodigo(new Integer(value));
			
			if (retorno == null) {
				String descricaoErro = "Lançamento não existe.";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						descricaoErro, descricaoErro);
				throw new ConverterException(message);
			}
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Integer codigo = ((Lancamento) value).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}

}
