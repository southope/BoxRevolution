package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;

import jplay.Keyboard;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

public class Mira extends Sprite{
	
	
	private int direcao = 3;
	private Keyboard input;
	private boolean move = false;
	private String fc = "";

	public Mira(int x, int y) {
		super(URL.sprite("mira completa recortada3.png"), 46);
		this.x = x;
		this.y = y;
		this.setTotalDuration(3000);
		
		
		
		// TODO Auto-generated constructor stub
	}
	public void mover(Window janela, int x){
		if (input == null){
			input = janela.getKeyboard();
		}
		//System.out.println(x+ " ,"+ y);
		if (input.keyDown(Keyboard.UP_KEY)){
			
			    if (direcao != 1){
				setSequence(0, 46);
				direcao = 1;
				
			}
			move = true;
		}else if (input.keyDown(Keyboard.DOWN_KEY)){
			
			if (direcao != 2){
				setSequence(0, 46);
				direcao = 2;
			}
			move = true;
		}else if (input.keyDown(Keyboard.SPACE_KEY)){
			
				if (fc.length() <= 50){
				fc += "|";
				input = null;
				}
				
			}
		
		
		if (move){
			update();
			move = false;
		}
		this.x = x;
		Color c = Color.getHSBColor(5f, 0.6f, 0.3f);
		janela.drawText("Angulo: "+getCurrFrame()*2, 550, 690, c, new Font("Fipps", Font.PLAIN, 20));
		janela.drawText("For�a: ", 240, 660, c, new Font("Fipps", Font.PLAIN, 20));
		janela.drawText(fc, 350, 660, c, new Font("Fipps", Font.PLAIN, 20));
		janela.drawText("Vento: ", 560, 70, c, new Font("Fipps", Font.PLAIN, 20));
		//System.out.println(getCurrFrame()); -- mostrar o frame atual
	}

}
