package com.br;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class VerificaTelaConteudo {
	
	private TelaDeLogin telaDeLogin;
	private TelaDeConteudo telaDeConteudo;
	String usuario = "avaliacao_qa_samba@sambatech.com.br";
	
    @Test
    public void logaSistemaAcessaConteuto() {
    
        telaDeLogin = new TelaDeLogin();
        telaDeLogin.abre();
        telaDeLogin.loga(usuario, "12345678");
        telaDeLogin.BuscaObjeto("mn-content");
        telaDeLogin.FechaNavegador();
    }
    
    @Test
    public void VerificaConteudoPesquisaTextual() {
    	telaDeConteudo= new TelaDeConteudo();
    	telaDeConteudo.abre();
    	telaDeConteudo.loga(usuario, "12345678");
    	telaDeConteudo.BuscaObjeto("mn-content");
    	telaDeConteudo.Pesquisa("as-input-061", "Baleada");
    	telaDeConteudo.FechaNavegador();
    }
    
    @Test
    public void VerificaPesquisaFiltroTipo() {
    	telaDeConteudo= new TelaDeConteudo();
    	telaDeConteudo.abre();
    	telaDeConteudo.loga(usuario, "12345678");
    	telaDeConteudo.BuscaObjeto("mn-content");
    	telaDeConteudo.EsperaTempo();
    	telaDeConteudo.PesquisaFiltrosTipo("filter-type", "Audio");
    	telaDeConteudo.PesquisaFiltrosTipo("filter-type", "Imagem");
    	telaDeConteudo.PesquisaFiltrosTipo("filter-type", "Vídeo");
    	telaDeConteudo.FechaNavegador();
    }
    
    @Test
    public void VerificaPesquisaFiltros() {
    	telaDeConteudo= new TelaDeConteudo();
    	telaDeConteudo.abre();
    	telaDeConteudo.loga(usuario, "12345678");
    	telaDeConteudo.BuscaObjeto("mn-content");
    	telaDeConteudo.EsperaTempo();
    	telaDeConteudo.PesquisaFiltros("Active");
    	telaDeConteudo.EsperaTempo();
    	telaDeConteudo.PesquisaFiltros("Inactive");
    	telaDeConteudo.EsperaTempo();
    	telaDeConteudo.PesquisaFiltros("Error");
    	telaDeConteudo.FechaNavegador();
    } 
	
    @Test
    public void VerificaPesquisarCategoria() {
    	telaDeConteudo= new TelaDeConteudo();
    	telaDeConteudo.abre();
    	telaDeConteudo.loga(usuario, "12345678");
    	telaDeConteudo.BuscaObjeto("mn-content");
    	telaDeConteudo.EsperaTempo();
    	telaDeConteudo.PesquisaCategoria("QA");
    	telaDeConteudo.FechaNavegador();
    } 

}
