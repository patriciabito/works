package com.br;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInterna {
	   private WebDriver driver;
	 
	   public PaginaInterna(WebDriver driver) {
	      this.driver = driver;
	   }
	 
	   public boolean estaLogado(String usuario) {
	      String usuarioLogado = null;
		if (driver.getPageSource().contains(usuario) == true)
	    	  usuarioLogado = usuario;
	      return usuarioLogado.equals(usuario);
	   }
	}