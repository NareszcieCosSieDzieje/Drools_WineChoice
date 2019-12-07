package com.sample;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class wineChooser {

	public static void main(String[] args) {

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		//KieRuntimeLogger kLogger = ks.getLoggers().newFileLogger(kSession, "test"); czy uzywac?
	}

	public static class Exchange {
		private String question;
		private String answer;
		
		public Exchange(String q) {
			this.question = q;
		}
		
		public Exchange(String q, String a) {
			this.question = q;
			this.answer = a;
		}
		
		public void setAnswer(String a) {
			this.answer = a;
		}
	}
	
	public static class UserInterface{
		// obsluga javafx'a i dzialanie z droolsem
	}
	
	
	
}
