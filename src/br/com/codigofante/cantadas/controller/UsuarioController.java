package br.com.codigofante.cantadas.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.codigofante.cantadas.modelo.Paquera;
import br.com.codigofante.cantadas.modelo.Repertorio;
import br.com.codigofante.cantadas.modelo.Usuario;
import br.com.codigofante.cantadas.service.PaqueraService;
import br.com.codigofante.cantadas.service.RepertorioService;
import br.com.codigofante.cantadas.service.UsuarioService;



@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	RepertorioService repertorioService;
	@Autowired
	PaqueraService paqueraService;
	
	@RequestMapping("formAdicionaUsuario")
	public String formAdicionaUsuario(){
		return "usuario/adicionaUsuario";
	}
	
	@RequestMapping("adicionaUsuario")
	public String adicionaUsuarioERepertorioPadrao(Usuario usuario,Repertorio criadas, Repertorio recebidas){
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		usuarioService.adicionaUsuario(usuario);
		repertorioService.criaRepertorioPadrao(criadas, recebidas, usuario);
		return "redirect:";
	}
	
	@RequestMapping("perfil")
	public String exibePerfilDoUsuario(HttpSession sessaoUsuarioLogado){
		Usuario usuario = (Usuario) sessaoUsuarioLogado.getAttribute("usuario");
		List<Usuario> usuariosPreferidos = (List<Usuario>) sessaoUsuarioLogado.getAttribute("usuariosPreferidos");
		return "usuario/perfil";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario,HttpSession sessao){
		if(usuarioService.usuarioExiste(usuario,sessao)){
			return "usuario/perfil";
		}
		return "redirect:";
	}
	
	@RequestMapping("formAlterarDadosDoUsuario")
	public String exibeFormParaAlterarDadosDoUsuario(HttpSession sessao){
		sessao.getAttribute("usuarioLogado");
		return "usuario/formAlterarDados";
	}
	
	@RequestMapping("atualizarDadosDoUsuario")
	public String atualizaDadosDoUsuario(Usuario usuario){
		usuarioService.atualizaDadosDoUsuario(usuario);
		return "usuario/perfil";
	}
	
	@RequestMapping("excluirConta")
	public String excluirConta(Long idUsuario){
		usuarioService.excluirConta(idUsuario);
		return "redirect:";
	}
	
}
