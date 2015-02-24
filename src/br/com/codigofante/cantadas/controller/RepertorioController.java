package br.com.codigofante.cantadas.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.codigofante.cantadas.modelo.Cantada;
import br.com.codigofante.cantadas.modelo.Repertorio;
import br.com.codigofante.cantadas.modelo.Usuario;
import br.com.codigofante.cantadas.service.RepertorioService;
import br.com.codigofante.cantadas.service.UsuarioService;

@Controller
public class RepertorioController {
	
	@Autowired
	RepertorioService repertorioService;
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("formAdicionaRepertorio")
	public String formAdicionaRepertorio(){
		return "repertorio/adicionaRepertorio";
	}

	@RequestMapping("adicionaRepertorio")
	public String adicionaRepertorio(Repertorio repertorio,HttpSession sessao){
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		repertorioService.adicionaNovoRepertorio(repertorio,usuario);
		return "forward:listarRepertoriosDoUsuario";
	}
	
	@RequestMapping("listarRepertoriosDoUsuario")
	public String listaRepertoriosDoUsuario(Usuario usuario, HttpSession sessao,Model model){
		usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		List<Repertorio> repertorios = repertorioService.listaRepertoriosDoUsuario(usuario);
		model.addAttribute("repertoriosDoUsuario", repertorios);
		return "repertorio/listaRepertoriosDoUsuario";
	}
	
	@RequestMapping("excluirRepertorio")
	public String excluirRepertorio(Long idRepertorio){
		Repertorio repertorio = repertorioService.buscaRepertorioPeloId(idRepertorio);
		repertorioService.excluirRepertorio(repertorio);
		return "forward:listarRepertoriosDoUsuario";
	}
	
	@RequestMapping("carregaRepertorioParaAtualizar")
	public String carregaFormAtualizarRepertorio(Long idRepertorio,Model model){
		Repertorio repertorio = repertorioService.buscaRepertorioPeloId(idRepertorio);
		model.addAttribute("repertorioEncontrado", repertorio);
		return "repertorio/formAtualizarRepertorio";
	}
	
	@RequestMapping("atualizarRepertorio")
	public String atualizarRepertorio(Repertorio repertorio,HttpSession sessao){
		repertorioService.atualizarRepertorio(repertorio,sessao);
		return "repertorio/formAtualizarRepertorio";
	}
}
