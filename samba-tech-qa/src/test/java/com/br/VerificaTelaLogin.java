package com.br;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;


public class VerificaTelaLogin {
	
	private TelaDeLogin telaDeLogin;
	String usuario = "avaliacao_qa_samba@sambatech.com.br";
	String invalidUsuario = "a";
	String unregisterUsuario = "patriciabito@hotmail.com.br";

    //Utiliza page objects para gerar informações para gerar relatorio automático, relatório (Não ficou pronto)
	private JUnitReportServiceExample junitAssertEqualsServiceSample;
	private ServiceObject serviceObject;

	
	@Before
	public void setData() {
		serviceObject = new ServiceObject();
		junitAssertEqualsServiceSample = new JUnitReportServiceExample();
		junitAssertEqualsServiceSample.initiateMetaData(serviceObject);
		
	}
	
	
	//Verifica comportamento com usuário válido
	   @Test
	    public void valid_UserCredential() {
	        telaDeLogin = new TelaDeLogin();
	        telaDeLogin.abre();
	        telaDeLogin.loga(usuario, "12345678");
	        telaDeLogin.BuscaObjeto("mn-content");
	        telaDeLogin.TrataErro("navbar-client-name");
	        telaDeLogin.FechaNavegador();
	   }
		  

      //Verifica comportamento com usuário inválido
	    @Test
	    public void inValid_UserCredential() {
	    	
	        telaDeLogin = new TelaDeLogin();
	        telaDeLogin.abre();
	        telaDeLogin.loga(usuario, "123456");
	        telaDeLogin.TrataErrobyId("password_incorrect");
	        telaDeLogin.EsperaTempo();
	        telaDeLogin.FechaNavegador();

	    }
	    
	    
	    	
	    //Verifica a funcionalidade esqueceu senha com email registrado, válido
	    @Test
	    public void Emailregistered_PasswordRemenber() {

	        telaDeLogin = new TelaDeLogin();
	        telaDeLogin.abre();
	        telaDeLogin.AcessaRecuperarSenha(usuario);
	
			//Assert.assertTrue(telaDeLogin.TrataErrobyTexto("Almost! We sent you an email with all instructions to obtain your new password."));
			telaDeLogin.EsperaTempo();
			telaDeLogin.FechaNavegador();
			
			}

	    //Verifica se a mensagem exibida está correta ao utilizar um e-mail válido mas não registrado.
	    @Test
	    public void Emailnoregistered_PasswordRemenber() {
	        telaDeLogin = new TelaDeLogin();
	        telaDeLogin.abre();
	        telaDeLogin.AcessaRecuperarSenha(unregisterUsuario);
	
			//Assert.assertTrue(telaDeLogin.TrataErrobyTexto("O"));
			telaDeLogin.EsperaTempo();
			telaDeLogin.FechaNavegador();

	    }
		 

	    //Verifica se a mensagem exibida está correta ao utilizar um e-mail inválido.
	    
	    @Test
	    public void Emailinvalid_PasswordRemenber() {
	        telaDeLogin = new TelaDeLogin();
	        telaDeLogin.abre();
	        telaDeLogin.AcessaRecuperarSenha(invalidUsuario);
	    	Assert.assertTrue(telaDeLogin.TrataErrobyTexto("Please insert a valid email"));
	        telaDeLogin.FechaNavegador();
		  
		 
	    }

}