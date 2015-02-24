package br.com.codigofante.cantadas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.codigofante.cantadas.converter.RepertorioPropertyEditor;
import br.com.codigofante.cantadas.modelo.Cantada;
import br.com.codigofante.cantadas.modelo.Repertorio;
import br.com.codigofante.cantadas.modelo.Usuario;
import br.com.codigofante.cantadas.service.CantadaService;
import br.com.codigofante.cantadas.service.RepertorioService;

@Controller
public class CantadaController {
	
	@Autowired
	RepertorioService repertorioService;
	@Autowired
	CantadaService cantadaService;
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Repertorio.class, new RepertorioPropertyEditor(repertorioService));
	}

	@RequestMapping("formAdicionaCantada")
	public String formAdicionaCantada(Usuario usuario,HttpSession sessao,Model model,BindingResult result, @ModelAttribute("cantadas") Cantada cantada){
		usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		List<Repertorio> repertorios = repertorioService.listaRepertoriosDoUsuario(usuario);
		model.addAttribute("repertoriosDoUsuario", repertorios);
		return "cantada/adicionaCantada";
	}
	
	@RequestMapping("adicionaCantada")
	public String adicionaCantada(Cantada cantada,BindingResult result){
		cantadaService.adicionaCantada(cantada);
		return "forward:listarCantadasDoRepertorio?idRepertorio="+cantada.getRepertorio().getIdRepertorio();
	}
	
	@RequestMapping("listarCantadasDoRepertorio")
	public String listaCantadasDoRepertorio(Long idRepertorio,Model model){
		List<Cantada> cantadas = cantadaService.listaCantadasDoRepertorio(idRepertorio);
		model.addAttribute("cantadasDoRepertorio", cantadas);
		return "cantada/listaCantadasDoRepertorio";
	}
	
	@RequestMapping("excluirCantada")
	public String excluirCantada(Long idCantada){
		Long idRepertorio = cantadaService.buscaCantadaPorId(idCantada).getRepertorio().getIdRepertorio();
		cantadaService.excluirCantada(idCantada);
		return "forward:listarCantadasDoRepertorio?idRepertorio="+idRepertorio;
	}
	
	@RequestMapping("carregarCantadaParaAtualizar")
	public String atualizarCantada(Usuario usuario,HttpSession sessao,Model modelCantada,Model modelRepertorios,BindingResult result, @ModelAttribute("cantadas") Cantada cantada,Long idCantada){
		usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		List<Repertorio> repertorios = repertorioService.listaRepertoriosDoUsuario(usuario);
		modelRepertorios.addAttribute("repertoriosDoUsuario", repertorios);
		cantada = cantadaService.buscaCantadaPorId(idCantada);
		modelCantada.addAttribute("cantadaAtual", cantada);
		return "cantada/formAtualizarCantada";
	}
	
	@RequestMapping("atualizaCantada")
	public String atualizaCantada(Cantada novaCantada){
		cantadaService.atualizaCantada(novaCantada);
		return "redirect:";
//		return "forward:listarCantadasDoRepertorio?idRepertorio="+idRepertorio;
	}
	
	
	
}
