package com.br;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TelaDeConteudo extends TelaDeLogin {
	 
	//Realiza Pesquisa utilizando o filtro recebido
	   public PaginaInterna Pesquisa(String objeto, String texto) {
		  
		  driver.findElement(By.id(objeto)).sendKeys(texto);
		  driver.findElement(By.id(objeto)).sendKeys(Keys.ENTER);
		  return new PaginaInterna(driver);
		  
	   }
	   
	   public PaginaInterna PesquisaFiltrosTipo(String objeto, String texto) {
			  
		  driver.findElement(By.id(objeto)).sendKeys(texto);
		  return new PaginaInterna(driver);
		  
	   }
	   
	   public PaginaInterna PesquisaFiltros(String texto) {
			  
		   driver.findElement(By.partialLinkText(texto)).click();
		   return new PaginaInterna(driver);
		  
	   }
	   
	   public PaginaInterna PesquisaCategoria(String categoria) {
			  
		   driver.findElement(By.id("search-channel")).sendKeys(categoria);
		   driver.findElement(By.id("search-channel")).sendKeys(Keys.ENTER);
		   return new PaginaInterna(driver);
		  
	   }
	   
	   
	   
	}