
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
		}

		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(50,60,450,20);
		jb[0].setBounds(60,90,100,20);
		jb[1].setBounds(60,120,100,20);
		jb[2].setBounds(60,150,100,20);
		jb[3].setBounds(60,180,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}

		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1:  Who invented Java Programming?");
			jb[0].setText("James Gosling");jb[1].setText("Guido van Rossum");jb[2].setText("Bjarne Stroustrup");jb[3].setText("Dennis Ritchie");
		}
		if(current==1)
		{
			l.setText("Que2: Which component is used to compile, debug and execute the java programs?");
			jb[0].setText("JRE");jb[1].setText("JDK");jb[2].setText("JIT");jb[3].setText("JVM");
		}
		if(current==2)
		{
			l.setText("Que3: What is the extension of java code files?");
			jb[0].setText(".js");jb[1].setText(".txt");jb[2].setText(".java");jb[3].setText(".class");
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in which package");
			jb[0].setText("awt");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("lang");
		}
		if(current==4)
		{
			l.setText("Que5:  What is the extension of compiled java classes?");
			jb[0].setText(".class");jb[1].setText(".txt");jb[2].setText(".java");jb[3].setText(".js");
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword");
			jb[0].setText("class");jb[1].setText("get");jb[2].setText("int");jb[3].setText("if");
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class ");
			jb[0].setText("Swing");jb[1].setText("ActionEvent");jb[2].setText("Actionperformed");jb[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Que8: which one among these is not a function of Object class");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");
		}
		if(current==8)
		{
			l.setText("Que9: which function is not present in Applet class");
			jb[0].setText("main");jb[1].setText("int");jb[2].setText("start");jb[3].setText("destroy");
		}
		if(current==9)
		{
			l.setText("Que10: Which one among these is not a valid component");
			jb[0].setText("JButton");jb[1].setText("JButtonGroup");jb[2].setText("JList");jb[3].setText("JTextArea");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[0].isSelected());
		if(current==1)
			return(jb[1].isSelected());
		if(current==2)
			return(jb[2].isSelected());
		if(current==3)
			return(jb[3].isSelected());
		if(current==4)
			return(jb[0].isSelected());
		if(current==5)
			return(jb[1].isSelected());
		if(current==6)
			return(jb[2].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[0].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
	}


}
