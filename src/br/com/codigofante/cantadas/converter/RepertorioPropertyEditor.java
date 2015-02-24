package br.com.codigofante.cantadas.converter;

import java.beans.PropertyEditorSupport;

import br.com.codigofante.cantadas.modelo.Repertorio;
import br.com.codigofante.cantadas.service.RepertorioService;

public class RepertorioPropertyEditor extends PropertyEditorSupport {

	private RepertorioService repertorioService;
	
	public RepertorioPropertyEditor(RepertorioService repertorioService) {
        this.repertorioService = repertorioService;
    }
	
	@Override
    public void setAsText(String text) {
        Long idRepertorio = new Long(text);
        Repertorio repertorioEncontrado = repertorioService.buscaRepertorioPeloId(idRepertorio);
        super.setValue(repertorioEncontrado);
    }
}
