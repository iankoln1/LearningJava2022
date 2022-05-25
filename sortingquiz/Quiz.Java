import javax.swing.JFrame;
import javax.swing.ButtonGroup;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SortingQuiz extends JFrame implements ActionListener {

	JLabel label;
	JRadioButton Buttons[] = new JRadioButton[5];
	JButton btnNext, btnResult;
	ButtonGroup bg;
	int count = 0;
	static int current = 0;
	int x = 1;
	int y = 1;
	int now = 0;
	int m[] = new int[10];
	int griff = 0;
	int raven = 0;
	int slyth = 0;
	int huff = 0;
	String house;
	
	
	
	public static void main(String[] args) {
		SortingQuiz quiz = new SortingQuiz("quiz");
		if(current > 7) {
			quiz.setVisible(false);
		}
	}

	SortingQuiz(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			Buttons[i] = new JRadioButton();
			add(Buttons[i]);
			bg.add(Buttons[i]);
			Buttons[i].setFont(new Font("Arial", Font.PLAIN, 15));

		}
		
		btnNext = new JButton("Next");
		btnResult = new JButton("Result");
		btnResult.setVisible(false);
		btnResult.addActionListener(this);
		btnNext.addActionListener(this);
		add(btnNext);
		add(btnResult);
		setData();
		
		label.setBounds(30,40,1000,20);
		Buttons[0].setBounds(50,80,1000,20);
		Buttons[1].setBounds(50,110,1000,20);
		Buttons[2].setBounds(50,140,1000,20);
		Buttons[3].setBounds(50,170,1000,20);
		btnNext.setBounds(100,240,100,30);
		btnResult.setBounds(270,240,100,30);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(1000,800);
		Font f=Buttons[0].getFont();
		
		f=f.deriveFont(10);
		Buttons[0].setFont(f);
		Buttons[1].setFont(f);
		Buttons[2].setFont(f);
		Buttons[3].setFont(f);
		label.setFont(f);
		
		
	}
	void setData() {
		Buttons[4].setSelected(true);
		if(current == 0) {
			label.setText("After you have died, what would you most like people to do when they hear your name?");
			Buttons[0].setText("Think with admiration of your achievements");
			Buttons[1].setText("Ask for more stories about your adventures");
			Buttons[2].setText("I don't care what people think when I die; it's what they think when I'm alive that counts");
			Buttons[3].setText("Miss you, but smile");
		}
		if(current == 1) {
			label.setText("Which of the following would you most hate people to call you?");
			Buttons[0].setText("Ignorant");
			Buttons[1].setText("Cowardly");
			Buttons[2].setText("Ordinary");
			Buttons[3].setText("Selfish");
		}
		if(current == 2) {
			label.setText("What would you rather invent a potion that would give you");
			Buttons[0].setText("Wisdom?");
			Buttons[1].setText("Glory?");
			Buttons[2].setText("Power?");
			Buttons[3].setText("Love?");
		}
		if(current == 3) {
			label.setText("How would you like to be known to history?");
			Buttons[0].setText("The Wise");
			Buttons[1].setText("The Bold");
			Buttons[2].setText("The Great");
			Buttons[3].setText("The Good");
		}
		if(current == 4) {
			label.setText("You enter an enchanted garden. What do you look at first?");
			Buttons[0].setText("The silver leafed tree bearing golden apples");
			Buttons[1].setText("The statue of an old wizard with a strangely twinkling eye");
			Buttons[2].setText("The bubbling pool, in the depths of which something luminous is swirling?");
			Buttons[3].setText("The fat red toadstools that appear to be talking to each other");
		}
		if(current == 5) {
			label.setText("What kind of instrument most pleases your ear?");
			Buttons[0].setText("The piano");
			Buttons[1].setText("The drum");
			Buttons[2].setText("The violin");
			Buttons[3].setText("The trumpet");
		}
		if(current == 6) {
			label.setText("Four boxes are placed before you. Which would you try and open");
			Buttons[0].setText("The ornate golden casket, standing on clawed feet, whose inscription warns that both secret knowledge and unbearable temptation lie within.");
			Buttons[1].setText("The small pewter box, unassuming and plain, with a scratched message upon it that reads \" open only for the worthy.\"");
			Buttons[2].setText("The gleaming jet black box with a silver lock and key, marked with a mysterious rune that you know to be the mark of Merlin.");
			Buttons[3].setText("The small tortoiseshell box, embellished with gold, inside which some small creature seems to be squeaking.");
		}
		if(current == 7) {
			label.setText("Four goblets are placed before you. Which would you choose to drink?");
			Buttons[0].setText("The foaming, frothing, silvery liquid that sparkles as though containing ground diamonds.");
			Buttons[1].setText("The golden liquid so bright that it hurts the eye, and which makes sunspots dance all around the room.");
			Buttons[2].setText("The mysterious black liquid that gleams like ink, and gives off fumes that make you see strange visions.");
			Buttons[3].setText("The smooth, thick, richly purple drink that gives off a delicious smell of chocolate and plums.");
		}
		
		
		
		label.setBounds(30,40,450,20);
		for(int i =0,j=0; i<=90; i+=30,j++) {
			Buttons[j].setBounds(50,80+i,200,20);
		}
	}
	void checkAns() {
		if(current==0) {
			if(Buttons[0].isSelected()) {
				raven++;
			}
			if(Buttons[1].isSelected()) {
				griff++;
			}
			if(Buttons[2].isSelected()) {
				slyth++;
			}
			if(Buttons[3].isSelected()) {
				huff++;
			}
		}
		if(current==1) {
			if(Buttons[0].isSelected()) {
				raven++;
			}
			if(Buttons[1].isSelected()) {
				griff++;
			}
			if(Buttons[2].isSelected()) {
				slyth++;
			}
			if(Buttons[3].isSelected()) {
				huff++;
			}
		}
		if(current==2) {
			if(Buttons[0].isSelected()) {
				raven++;
			}
			if(Buttons[1].isSelected()) {
				griff++;
			}
			if(Buttons[2].isSelected()) {
				slyth++;
			}
			if(Buttons[3].isSelected()) {
				huff++;
			}
		}
		if(current==3) {
			if(Buttons[0].isSelected()) {
				raven++;
			}
			if(Buttons[1].isSelected()) {
				griff++;
			}
			if(Buttons[2].isSelected()) {
				slyth++;
			}
			if(Buttons[3].isSelected()) {
				huff++;
			}
		}
		if(current==4) {
			if(Buttons[0].isSelected()) {
				raven++;
			}
			if(Buttons[1].isSelected()) {
				griff++;
			}
			if(Buttons[2].isSelected()) {
				slyth++;
			}
			if(Buttons[3].isSelected()) {
				huff++;
			}
			if(current==5) {
				if(Buttons[0].isSelected()) {
					raven++;
				}
				if(Buttons[1].isSelected()) {
					griff++;
				}
				if(Buttons[2].isSelected()) {
					slyth++;
				}
				if(Buttons[3].isSelected()) {
					huff++;
				}
				if(current==6) {
					if(Buttons[0].isSelected()) {
						raven++;
					}
					if(Buttons[1].isSelected()) {
						griff++;
					}
					if(Buttons[2].isSelected()) {
						slyth++;
					}
					if(Buttons[3].isSelected()) {
						huff++;
					}
					if(current==7) {
						if(Buttons[0].isSelected()) {
							raven++;
						}
						if(Buttons[1].isSelected()) {
							griff++;
						}
						if(Buttons[2].isSelected()) {
							slyth++;
						}
						if(Buttons[3].isSelected()) {
							huff++;
						}
					}
				}
			}
		}
	}
	
	void calcResult() {
        if (raven > griff && raven > slyth && raven > huff) {
            house = " Ravenclaw";
        } else if (griff > raven && griff > slyth && griff > huff) {
            house = " Gryffindor";
        } else if (slyth > raven && slyth > griff && slyth > huff) {
            house =  " Slytherin";
        } else if (huff > raven && huff > griff && huff > slyth) {
            house =  " Hufflepuff";
        } 
    }
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNext) {
			checkAns();
			current++;
			setData();
			
			
			if(current==7) {
				calcResult();
				btnNext.setEnabled(false);
				btnResult.setVisible(true);
				btnResult.setText("Result");
			}
		}
		if(e.getSource()==btnResult) {
			JFrame window = new JFrame();
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			window.setTitle("Fight Game");
			JOptionPane.showMessageDialog(this, "Your House is" + house + "\nClose this message to Fight!");
			FightingGame gamepanel = new FightingGame();
			window.add(gamepanel);
			window.setLocationRelativeTo(null);
			window.setVisible(false);
			window.pack();
			current++;
			FightingGame f = new FightingGame();
			current++;
			f.run();
			window.setVisible(true);
			
		}
		
	}
	
}
