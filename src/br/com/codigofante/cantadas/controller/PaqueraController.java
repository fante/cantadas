package br.com.codigofante.cantadas.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.codigofante.cantadas.modelo.Paquera;
import br.com.codigofante.cantadas.modelo.Repertorio;
import br.com.codigofante.cantadas.modelo.Usuario;
import br.com.codigofante.cantadas.service.PaqueraService;
import br.com.codigofante.cantadas.service.UsuarioService;

@Controller
public class PaqueraController {
	
	@Autowired
	PaqueraService paqueraService;
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("formEnviarSolicitacaoDePaquera")
	public String exibirFormEnviarSolicitacaoDePaquera(Long idPaquerador,Long idPaquerado,Paquera paquera){
		Usuario paquerador = usuarioService.buscaUsuarioPorId(idPaquerador);
		Usuario paquerado = usuarioService.buscaUsuarioPorId(idPaquerado);
		paqueraService.adiciona(paquerador,paquerado,paquera);
		return "usuario/perfil";
	}
	
	@RequestMapping("aceitarPaquera")
	public String aceitarPaquera(Long idPaquera){
		paqueraService.aceitarPaquera(idPaquera);
		return "redirect:perfil";
	}
	
	@RequestMapping("rejeitarPaquera")
	public String rejeitarPaquera(Long idPaquera){
		paqueraService.rejeitarPaquera(idPaquera);
		return "usuario/minhasPaqueras";
	}
	
	@RequestMapping("listarPaquerasDoUsuario")
	public String listaRepertoriosDoUsuario(Usuario usuario, HttpSession sessao,Model model){
		usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		List<Paquera> paquerasDoUsuario = paqueraService.listaPaquerasDoUsuario(usuario);
		model.addAttribute("paquerasDoUsuario", paquerasDoUsuario);
		return "usuario/minhasPaqueras";
	}
	
	@RequestMapping("excluirPaquera")
	public String excluirPaquera(Long idPaquera){
		paqueraService.excluirPaquera(idPaquera);
		return "forward:listarPaquerasDoUsuario";
	}

}
