import java.awt.*;
import java.awt.event.*;

class Shark1 implements ActionListener,KeyListener
{
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28;
Frame f1,f2,f3,f4,f5,f6,f7;
MenuBar mb1,mb2,mb3,mb4,mb5,mb6;
Menu m2,m4,m6,m7,m8,m9,m10;
MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
TextField tf1,tf2,tf3,tf4,tf5,tf6;
TextArea ta1,ta2,ta3;
String s1="coderS",s2="j1d25k16",s3,s4,s5,s6,s7,s8;

Shark1()
{
b1 = new Button("SHARK PROTOTYPE 1.1");
b2 = new Button("SHARK PROTOTYPE 1.2");
b3 = new Button("SHARK PROTOTYPE 1.3");
b4 = new Button("BACK");
b5 = new Button("^");
b6 = new Button("BACK");
b7 = new Button("<");
b8 = new Button("v");
b9 = new Button(">");
b11 = new Button("GRAB");
b13 = new Button("ROTATE >");
b15 = new Button("ARM ^");
b17 = new Button("WRIST ^");
b12 = new Button("RELEASE");
b14 = new Button("ROTATE <");
b16 = new Button("ARM v");
b18 = new Button("WRIST v");
b21 = new Button("CLEAR");
b22 = new Button("CLEAR");
b23 = new Button("BACKTRACK ");
b24 = new Button("SUBMIT");
b25 = new Button("SUBMIT");
b26 = new Button("SHARK PROTOTYPE 1.1");
b27 = new Button("SHARK PROTOTYPE 1.2");
b28 = new Button("SHARK PROTOTYPE 1.3");
l2 = new Label("MACHINE ID :");
l3 = new Label("LAST LOCATION :");
l4 = new Label("LAST MAINTANACE :");
l1 = new Label("MACHINE NAME :");
l5 = new Label("RECENT ACTIVITIES :");
l6 = new Label("..................BODY CONRTOLLER.......................");
l7 = new Label("..................ARM CONTROLLER...................");
l9 = new Label("--------------------------------------------------------------------------------------------------");
l10=new Label("USERNAME");
l11=new Label("PASSWORD");
l12=new Label("MACHINE DETAILS");
tf1 = new TextField(30);
tf2 = new TextField(30);
tf3 = new TextField(30);
tf4 = new TextField(30);
tf5 = new TextField(30);
tf6 = new TextField(30);
ta1 = new TextArea();
ta1.setEditable(false);
ta2 = new TextArea();
ta2.setEditable(false);
ta3 = new TextArea();
ta3.setEditable(false);
m2 = new Menu("FILE");
m4 = new Menu("FILE");
m6 = new Menu("FILE");
m7 = new Menu("FILE");
m8 = new Menu("ADMIN");
m9 = new Menu("FILE");
m10 = new Menu("FILE");
mb1 = new MenuBar();
mb2 = new MenuBar();
mb3 = new MenuBar();
mb4 = new MenuBar();
mb5 = new MenuBar();
mb6 = new MenuBar();
mi1 = new MenuItem("EXIT");
mi2 = new MenuItem("EXIT");
mi3 = new MenuItem("EXIT");
mi4 = new MenuItem("LOG DETAILS");
mi5 = new MenuItem("LOG DETAILS");
mi6 = new MenuItem("BACK");
mi7 = new MenuItem("EXIT");
mi8 = new MenuItem("EDIT");
mi9 = new MenuItem("BACK");
mi10 = new MenuItem("BACK");
f1 = new Frame ("SHARK");
f2 = new Frame ("CONRTOLLER");
//f3 = new Frame ("ARM CONTROLLER");
f4 = new Frame ("LOG DETAILS");
f5 = new Frame ("ADMIN");
f6 = new Frame ("ADMIN");
f7 = new Frame ("SYSTEM SELECTION");

f1.add(b1); // shark 1.1
f1.add(b2); // shark 1.2
f1.add(b3); // shark 1.3
m2.add(mi1);
m8.add(mi8);
mb1.add(m2);
mb1.add(m8);
f1.setMenuBar(mb1);
f2.add(l6);
f2.add(b5); // ^
f2.add(b7); // <
f2.add(b8); // v
f2.add(b9); // >
f2.add(l7);
f2.setMenuBar(mb2);
m4.add(mi4);
m4.add(mi2);
mb2.add(m4);
f2.add(b11); // grab
f2.add(b13); // rotate ri8
f2.add(b15); // arm up
f2.add(b17); // wrist up
f2.add(b12); // relese
f2.add(b14); // rotate left
f2.add(b16); // arm down
f2.add(b18); // wrist down
f4.add(l12);
f4.add(ta3);
f4.add(l5);
f4.add(ta1);
f4.add(b21);
f4.add(l9);
f4.add(b23);
f4.add(ta2);
f4.add(b22);
m7.add(mi6);
m7.add(mi7);
mb4.add(m7);
f4.setMenuBar(mb4);
f5.add(l10);
f5.add(tf5);
f5.add(l11);
f5.add(tf6);
f5.add(b24);
m9.add(mi9);
mb5.add(m9);
f5.setMenuBar(mb5);
m10.add(mi10);
mb6.add(m10);
f6.setMenuBar(mb6);
f6.add(l1);
f6.add(tf1);
f6.add(l2);
f6.add(tf2);
f6.add(l3);
f6.add(tf3);
f6.add(l4);
f6.add(tf4);
f6.add(b25);
f7.add(b26);
f7.add(b27);
f7.add(b28);

b1.addActionListener(this);  // shark 1.1
mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);
mi7.addActionListener(this);
mi8.addActionListener(this);
mi9.addActionListener(this);
mi10.addActionListener(this);
b4.addActionListener(this);
b6.addActionListener(this);
b11.addActionListener(this);
b12.addActionListener(this);
b13.addActionListener(this);
b14.addActionListener(this);
b15.addActionListener(this);
b16.addActionListener(this);
b17.addActionListener(this);
b18.addActionListener(this);
b21.addActionListener(this);
b22.addActionListener(this);
b23.addActionListener(this);
b24.addActionListener(this);
b5.addActionListener(this);
b9.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b25.addActionListener(this);
b26.addActionListener(this);
b9.addKeyListener(this);
b7.addKeyListener(this);
b5.addKeyListener(this);
b8.addKeyListener(this);

f1.setSize(250,300);
f2.setSize(300,250);
f4.setSize(450,500);
f5.setSize(250,225);
f6.setSize(300,400);
f7.setSize(250,300);
f1.setVisible(true);
ta2.setVisible(false);
b22.setVisible(false);
tf6.setEchoChar('*');
f1.setLayout(new FlowLayout());
f2.setLayout(new FlowLayout());
f4.setLayout(new FlowLayout());
f5.setLayout(new FlowLayout());
f6.setLayout(new FlowLayout());
f7.setLayout(new FlowLayout());
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
	f2.setVisible(true);
	}
	else if(e.getSource()==mi1)
	{
	System.exit(0);
	f4.setVisible(false);
	}
	else if(e.getSource()==mi2)
	{
	System.exit(0);
	f4.setVisible(false);
	}
	else if(e.getSource()==mi3)
	{
	System.exit(0);
	f4.setVisible(false);
	}
	if(e.getSource()==b4)
	{
	f2.setVisible(false);
	}
	if(e.getSource()==b6)
	{
	f2.setVisible(false);
	}
	if(e.getSource()==mi4)
	{
	f4.setVisible(true);
	}
	if(e.getSource()==mi5)
	{
	f4.setVisible(true);
	}
	if(e.getSource()==mi6)
	{
	f4.setVisible(false);
	}
	if(e.getSource()==mi7)
	{
	System.exit(0);
	}
	if(e.getSource()==b11)
	{
	ta1.append("OBJECT GRABBED \n");
	}
	if(e.getSource()==b13)
	{
	ta1.append("ARM ROATATED RIGHT \n");
	}
	if(e.getSource()==b15)
	{
	ta1.append("ARM LIFTED UP \n");
	}
	if(e.getSource()==b17)
	{
	ta1.append("WRIST UP \n");
	}
	if(e.getSource()==b12)
	{
	ta1.append("OBJECT RELEASED \n");
	}
	if(e.getSource()==b14)
	{
	ta1.append("ARM ROTATED LEFT \n");
	}
	if(e.getSource()==b16)
	{
	ta1.append("ARM LIFTED DOWN \n");
	}
	if(e.getSource()==b18)
	{
	ta1.append("WRIST DOWN \n");
	}
	if(e.getSource()==b5)
	{
	ta1.append("BODY MOVED FORWARD \n");
	}
	if(e.getSource()==b7)
	{
	ta1.append("BODY MOVED LEFT \n");
	}
	if(e.getSource()==b8)
	{
	ta1.append("BODY MOVED BACKWARD \n");
	}
	if(e.getSource()==b9)
	{
	ta1.append("BODY MOVED RIGHT \n");
	}
	if(e.getSource()==b21)
	{
	ta1.setText("");
	}
	if(e.getSource()==b22)
	{
	ta2.setText("");
	ta2.setVisible(false);
	f4.setSize(450,500);
	b22.setVisible(false);
	}
	if(e.getSource()==b23)
	{
	ta2.setVisible(true);
	b22.setVisible(true);
	f4.setSize(450,675);
	}
	if(e.getSource()==mi8)
	{
	f5.setVisible(true);
	}
	if(e.getSource()==mi9)
	{
	f5.setVisible(false);
	}
	if(e.getSource()==b24)
	{
	String s3=tf5.getText();
	String s4=tf6.getText();
	if(s3.equals(s1)==true&& s4.equals(s2)==true)
	{
	f7.setVisible(true);
	f5.setVisible(false);
	tf5.setText(" ");
	tf6.setText(" ");
	}
	else
	{
	tf5.setText(" ");
	tf6.setText(" ");
	}
	}
	if(e.getSource()==mi10)
	{
	f6.setVisible(false);
	f5.setVisible(true);
	}
	if(e.getSource()==b25)
	{
	s5=tf1.getText();
	s6=tf2.getText();
	s7=tf3.getText();
	s8=tf4.getText();
	ta3.append(s5+"\n");
	ta3.append(s6+"\n");
	ta3.append(s7+"\n");
	ta3.append(s8+"\n");
	}
	if(e.getSource()==b26)
	{
	f6.setVisible(true);
	}

}
public void keyPressed(KeyEvent ke)
{
	int key= ke.getKeyCode();
	switch(key)
	{
	case KeyEvent.VK_RIGHT:
	ta1.append("BODY MOVED RIGHT \n");
	ta2.append("MOVE BODY TO LEFT \n");
	break;
	case KeyEvent.VK_LEFT:
	ta1.append("BODY MOVED LEFT \n");
	ta2.append("MOVE BODY TO RIGHT\n");
	break;
	case KeyEvent.VK_UP:
	ta1.append("BODY MOVED FORWARD \n");
	ta2.append("MOVE BODY BACKWARDS \n");
	break;
	case KeyEvent.VK_DOWN:
	ta1.append("BODY MOVED BACKWARD \n");
	ta2.append("MOVE BODY FORWARD\n");
	break;
	case KeyEvent.VK_Q:
	ta1.append("OBJECT GRABBED \n");
	break;
	case KeyEvent.VK_A:
	ta1.append("OBJECT RELEASED \n");
	break;
	case KeyEvent.VK_W:
	ta1.append("ARM ROTATED RIGHT \n");
	break;
	case KeyEvent.VK_S:
	ta1.append("ARM ROTATED LEFT \n");
	break;
	case KeyEvent.VK_E:
	ta1.append("ARM LIFTED UP \n");
	break;
	case KeyEvent.VK_D:
	ta1.append("ARM LIFTED DOWN \n");
	break;
	case KeyEvent.VK_R:
	ta1.append("WRIST UP \n");
	break;
	case KeyEvent.VK_F:
	ta1.append("WRIST DOWN \n");
	break;
        default:
        
	}
}
public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}

public static void main(String args[])
{
Shark1 x = new Shark1();
}
}