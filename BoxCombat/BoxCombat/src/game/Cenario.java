package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import jplay.*;
public class Cenario {
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Mira mira;
	private Forca forca;
	
	public Cenario(Window window){
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("cenario.scn"));
		jogador = new Jogador(1159, 520);
		mira = new Mira(1159, 450);
		forca = new Forca();
		
		run();
	}

	private void run() {
		// TODO Auto-generated method stub
		Keyboard input = janela.getKeyboard();
		while(true){
			cena.draw();
			jogador.draw();
			mira.draw();
			jogador.mover(janela);
			mira.mover(janela, (int)jogador.getX()-90);
			forca.draw();
			forca.carregar(janela);
			Color c = Color.getHSBColor(5f, 0.6f, 0.3f);
			//janela.drawText("Jogador-1", 50, 690, c, new Font("Fipps", Font.PLAIN, 20));
			janela.drawText("Jogador-2", 1050, 690, c, new Font("Fipps", Font.PLAIN, 20));
			janela.update();
			
			if(input.keyDown(KeyEvent.VK_ESCAPE)){
				janela.setSize(640, 480);
				new Login(janela);
				}
		}
		
	}

}
