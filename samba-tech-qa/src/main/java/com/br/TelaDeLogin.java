package com.br;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TelaDeLogin {
	WebDriver driver;
	
	   // construtor e atributo driver
	   public void abre() {
		   System.setProperty("webdriver.chrome.driver","C:\\Selenium-3.0.1\\c24\\chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.get("http://52.2.166.124:8085/auth/login");
		   }
	 
	   public PaginaInterna loga(String usuario, String senha) {
	 
	      // preenche usuário e senha
		   driver.findElement(By.name("j_username")).sendKeys(usuario);
		   driver.findElement(By.name("j_password")).sendKeys(senha);
	 
	      // submete o formulário
		   driver.findElement(By.id("login")).click();
		   
		   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 
	      return new PaginaInterna(driver);
	   }
	   
	   public PaginaInterna BuscaObjeto(String objeto) {
		  driver.findElement(By.id(objeto)).click();
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  return new PaginaInterna(driver);
	   }
	   
	   public void TrataErro(String objeto){
		   
			  WebElement element = null;
			try{
				  element = driver.findElement(By.id(objeto));
				  }catch (Exception e){
					}
			     Assert.assertNotNull(element);
			     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());

		    }
	   
	   public void TrataErrobyId(String objeto){
		   
			  String menssagem = null;
			try{
				  WebElement element = driver.findElement(By.id("password_incorrect"));
				  
				  //Após verificar se e possível logar com usuário invalido, 
				  //Verifica se a mensagem de erro foi exibida
				  menssagem = element.getText();
				  }catch (Exception e){
					}
			     Assert.assertNotNull(menssagem);
			     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	   }
	   
	   
	   public boolean TrataErrobyTexto(String texto){
		   WebElement span = driver.findElement(By.tagName("span"));
		   String bodyspan = span.getText();
		   return bodyspan.contains(texto);
	   }
	   
	   public PaginaInterna AcessaRecuperarSenha(String usuario){
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.findElement(By.id("forgot-pwd-link")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.findElement(By.name("email")).sendKeys(usuario);
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.findElement(By.tagName("BUTTON")).click();
			  
			  return new PaginaInterna(driver);
	   }
	   
	   public void EsperaTempo (){  
		   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   }
	   
	   // fecha navegador
	   public void FechaNavegador(){
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 driver.quit();
		 }
	}