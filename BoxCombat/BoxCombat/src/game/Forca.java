package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import jplay.Keyboard;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

public class Forca extends Sprite {

	private int direcao = 3;
	private Keyboard input;
	private boolean move = false;
	private String fc = "";
	private boolean volta = false;
	private boolean reinicia = false;

	public Forca() {
		super(URL.sprite(null), 1);
		this.x = x;
		this.y = y;
		this.setTotalDuration(3000);

		// TODO Auto-generated constructor stub
	}

	public void carregar(Window janela) {
		if (input == null) {
			input = janela.getKeyboard();
			//input.setBehavior(Keyboard.SPACE_KEY, Keyboard.DETECT_EVERY_PRESS);
		}
		// System.out.println(x+ " ,"+ y);
		if (input.keyDown(Keyboard.SPACE_KEY) ) {
			if (reinicia){
				fc = "";
				volta = false;
				reinicia = false;
			}
			if (direcao < 3 || direcao > 8) {

				if (!volta) {
					fc += "|";
					// input = null;
					if (fc.length() >= 50) {
						volta = true;
					}
					direcao = 3;

				} else if (volta) {
					if (fc.length() == 0) {

						// fc = "";
						//volta = false;
					} else {

						fc = fc.substring(0, fc.length() - 1);
					}
					// input = null;
					if (fc.length() == 0) {
						volta = false;
					}
					direcao = 3;
				}

			} else {
				direcao++;
			}

		} else {
			 reinicia = true;
		}

		if (move) {
			update();
			move = false;
		}

		// this.x = x;
		Color c = Color.getHSBColor(5f, 0.6f, 0.3f);
		janela.drawText("For�a: ", 240, 660, c, new Font("Fipps", Font.PLAIN, 20));
		janela.drawText(fc, 350, 660, c, new Font("Fipps", Font.PLAIN, 20));

		// System.out.println(getCurrFrame()); -- mostrar o frame atual
	}

}
