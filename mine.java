package oss_mine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
																		/*
																		 * �׽�Ʈ ȯ��
																		 * OS		:	Windows 10
																		 * Display	:	1920*1080
																		 * OS���� ������ ����� �ٸ��� ���ϼ� ����
																		 */

public class mine extends JFrame {										// 	JFrame ��� *�� Ŭ���� ��ü�� JFrame��� �����ϸ� �ɵ�?
	JPanel 		jp 			=	new JPanel();							//  �������� �����ϱ� ���� �г� ����
	JPanel 		jp2			=	new JPanel();							//  ���¹�ư�� �����ϱ� ���� �г� ����
	JButton 	reset		=	new JButton();							//  ���� ��ư ����
	Random 		rnd 		=	new Random();							//  ���� ��ġ�� ���� �����Լ� ����
	int[][] 	mine 		=	new int[10][10];						// 	�ʱ� ���̵����� ���ڸ� ���� 10x10 �迭 ����
	int[][] 	mine2 		=	new int[15][15];						// 	�߱� ���̵����� ���ڸ� ���� 15x15 �迭 ����
	int[][]	 	mine3 		=	new int[20][20];						// 	��� ���̵����� ���ڸ� ���� 20x20 �迭 ����						
	JButton 	jb[][] 		=	new JButton[10][10];					// 	�ʱ� ���̵��� ���� 10x10 ��ư ����
	JButton 	jb2[][] 	= 	new JButton[15][15];					// 	�߱� ���̵��� ���� 15x15 ��ư ����
	JButton     jb3[][]		= 	new JButton[20][20];					// 	��� ���̵��� ���� 20x20 ��ư ����
	JMenuBar	 mb 		=	new JMenuBar();							//	�޴��� ����
	JMenu 		menu 		=	new JMenu("����");						//	�޴��ٿ� '����'�̶�� �׸� ����
	
	ImageIcon icon0 = new ImageIcon("images/mine0.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon1 = new ImageIcon("images/mine1.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon2 = new ImageIcon("images/mine2.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon3 = new ImageIcon("images/mine3.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon4 = new ImageIcon("images/mine4.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon5 = new ImageIcon("images/mine5.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon6 = new ImageIcon("images/mine6.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon7 = new ImageIcon("images/mine7.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon8 = new ImageIcon("images/mine8.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon9 = new ImageIcon("images/mine9.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon_mine = new ImageIcon("images/mine.png");			//	���� ǥ�� �� �̹��� ����
	ImageIcon icon_reset = new ImageIcon("images/reset.png");		//  ���� ǥ�� �� �̹��� ����
	ImageIcon icon_flag = new ImageIcon("images/flag.png");			//  ��� ǥ�� �� �̹��� ����
	ImageIcon icon_flagx = new ImageIcon("images/flagx.png");		//  �߸��� ��ġ�� ��� ��ġ�� �˷��� �̹��� ����
	ImageIcon logo = new ImageIcon("images/logo.png");				//  ���� �ΰ� ���� �� �̹��� ����
	

public mine() {
	super("����ã��"); 																				// Ÿ��Ʋ ����
	setResizable(true);																				// ������ ������ ���������ϰ� ����
																									/* 
																									 * �ٸ� ���̵����� �ٸ� ���̵��� �Ѿ��
																									 * ������ ����� �����ϱ� ������
																									 * ������ ������ �ݵ�� �ٽ� �ݾ��ٰ�
																									 */
	this.setIconImage(logo.getImage());																// ����� ���� ��ܿ� ���� ������ ���� �̹����� ����
	
	if(level == 0) level = 1;																		// �������� ������ 0(�ʱⰪ�� 0��)�� ��� 1�� ������.
	if(level == 1) {																				// ���� ���� 1(�ʱ޴ܰ�)�� ���
																									// �޴��� ���� ����
		menu.add(new JMenuItem("���� �����ϱ�")).addActionListener(new ActionListener() { 				// �޴��ٿ��� �ٽ��ϱ� Ŭ����
			public void actionPerformed(ActionEvent e) { dispose();	new mine();	} });				// �͸����ʷ� ó��
		menu.addSeparator(); 																		// �޴��ٿ� �ٱ߱�
		menu.add(new JMenuItem("�ʱ�")).addActionListener(new ActionListener() { 						// �޴��ٿ��� �ʱ޸޴� ���ý� �͸����ʷ� ó��
			public void actionPerformed(ActionEvent e) { dispose();	new mine();	} });				// �������� �̹� 1�� ��Ȳ���� �ʱ��� ���ý� â�� �ݰ� �ٽ� ���⸸ ��
		menu.add(new JMenuItem("�߱�")).addActionListener(new ActionListener() { 						// �޴��ٿ��� �߱޸޴� ���ý� �͸����ʷ� ó��
			public void actionPerformed(ActionEvent e) {level = 2;	dispose();	new mine();	} });	// �߱��� ���ý� �������� 2���� �������ְ� ���ý� â�� �ݰ� �ٽ� ���⸸ ��
		menu.add(new JMenuItem("���")).addActionListener(new ActionListener() {						// �޴��ٿ��� ��޸޴� ���ý� �͸����ʷ� ó��
			public void actionPerformed(ActionEvent e) {level = 3;	dispose();	new mine();	} });	// ����� ���ý� �������� 3���� �������ְ� ���ý� â�� �ݰ� �ٽ� ���⸸ ��
		menu.addSeparator(); 																		// �޴��ٿ� �ٱ߱�
		menu.add(new JMenuItem("����")).addActionListener(new ActionListener() { 						// �޴��ٿ��� ����޴� ���ý�
			public void actionPerformed(ActionEvent e) {System.exit(0);} });						// ���������� �͸����ʷ� ó����.
	    																							/*
	    																							 * Ȯ���ϰ� �����Ҷ����� �ݵ��
	    																							 * �� ��ɾ� (System.exit(0);) �� ����� ��
	    																							 * */
		mb.add(menu); 																				// �޴���(mb)�� �޴�(menu)�� �߰�
		this.setJMenuBar(mb);																		// ����(this) ������(JFrame)�� �޴��ٸ� �߰���
		this.setLayout(new BorderLayout());															// ���� �������� ���̾ƿ��� ����(BorderLayout)
		add(jp);																					// �������� �����ϱ� ���� �г��� �� �����ӿ� �߰�
		add(jp2, "North");																			// ���� ��ư�� ��� ���� �г��� ���ʿ� �߰���
		jp2.add(reset); 																			// �гο� ���� ��ư �߰�
		reset.setIcon(icon_reset);																	// ���¹�ư ������ ����
		reset.setBorderPainted(false);																// ��ư�� �ܰ����� �Ⱥ��̰� ����
		reset.setContentAreaFilled(false);															// ��ư�� ���ο��� ä��� �Ⱥ��̰� ����(�Ķ���)
		reset.setFocusPainted(false);																// ��ư�� ��Ŀ��(���콺�� �ö� ����)�� ����� �׵θ��� �Ⱥ��̰� ������
		reset.addActionListener(new ActionListener() { 												// ���¹�ư�� ��������
			public void actionPerformed(ActionEvent e) {											// �͸����ʷ� ó����. �ڵ尡 �ܼ��ϸ鼭 �׼Ǹ����ʰ� �ʿ��Ҷ��� �͸����ʷ� ó���ϴ°� ����
				JOptionPane.showMessageDialog(null, "'����'�Ǿ����ϴ�.");								// ���� ��ư Ŭ���� "'����'�Ǿ����ϴ�."��� �޽����� ��� �˾�â�� ���
				dispose();																			// �ش� �������� ����.
				new mine();																			// ���� �ҷ���()
			}
		});
		for(; ; ) {																					// ���� ��ġ�� ���� �ݺ���
			for(int i, j, count = 0; count < 10;) {													// i, j, count ���� �� �ʱ�ȭ
				i=rnd.nextInt(10);																	// i���� 0 ~ 9 ������ ���� ����
				j=rnd.nextInt(10);																	// j���� 0 ~ 9 ������ ���� ����
																									// --------------------------------------------------
				if(mine[i][j] != -1) {																// -mine[i][j] �迭 ���� -1�� �ƴϸ� (���ڰ� ��ġ���� �ʾ�����)	-
					mine[i][j] = -1;																// -mine[i][j] �迭�� -1�� ����							-
					count++;																		// -count���� ����										-
				}																					// -�ߺ����� �ɷ����� ������								-
			}																						// --------------------------------------------------
			break;																					// ����(count�� 10���� ������?)�� �������� ������ �ݺ��� ����
		}

		for(int i = 0; i < 10; i++) {																// ��ư ������ ���� �ݺ���
			for(int j = 0; j < 10; j++) {															// 
				if(mine[i][j] == 0) { 																// mine�迭 i,j�� �迭 ���� 0�� ���
					jb[i][j] = new JButton();														// jb(JButton)[i][j]�� ����
					jb[i][j].setPreferredSize(new Dimension(20, 20));								// jb[i][j]�� ��ư ����� ����
					jb[i][j].addActionListener(new ButtonListener());								// �Ϲݹ�ư Ŭ���� �����ϱ� ���� �׼Ǹ�����(ButtonListener) ����
					jb[i][j].addMouseListener(new clickListener());									// ����� ǥ���ϱ� ���� ��Ŭ���� üũ�� ���콺 ������(clickListener)����
					jb[i][j].setBackground(Color.DARK_GRAY);
					jp.add(jb[i][j]);																// jp(JPanel)�� jb[i][j]�� �߰�
				}
				else if(mine[i][j] != 0) { 															// mine�迭 i,j�� �迭 ���� 0�� �ƴҰ��
					jb[i][j] = new JButton();														// jb(JButton)[i][j]�� ����
					jb[i][j].setPreferredSize(new Dimension(20, 20));								// jb[i][j]�� ��ư ����� ����
					jb[i][j].addActionListener(new MineListener());									// ���ڹ�ư Ŭ���� �����ϱ� ���� �׼Ǹ�����(MineListener) ����
					jb[i][j].addMouseListener(new clickListener());									// ����� ǥ���ϱ� ���� ��Ŭ���� üũ�� ���콺 ������(clickListener)����
					jb[i][j].setBackground(Color.DARK_GRAY);
					jp.add(jb[i][j]);																// jp(JPanel)�� jb[i][j]�� �߰�
				}
			}
		}

		for(int i=0; i<10; i++) {																	// ���� �ֺ� ĭ�� ���ڸ� ä��� ���� �ݺ���
			for(int j=0; j<10; j++) {
				int count=0;																		// ���ڸ� üũ�ϱ� ���� ���� ����
				if(mine[i][j] != -1) {																// mine[i][j] ��ġ�� �迭���� ���ڰ���(-1) �ƴϸ�
					if(i >= 0 && j >= 0 && i <= 9 && j <= 9) {										// �迭�� ������ ����� �������� ����
						if(i-1 >= 0 && j-1 >= 0)				// -------------------------------- //
							if(mine[i-1][j-1] == -1) count ++;	//				1		2		3--	//
						if(i-1 >= 0)							//				0		0		0--	// 
							if(mine[i-1][j] == -1) count ++;	//								 -- // 
						if(i-1 >= 0 && j+1 <= 9)				//				4		i,j		5-- // 1~8�� �ڸ��� ���ڰ� �ִ��� üũ�ϰ�
							if(mine[i-1][j+1] == -1) count ++;	//				0		0		0-- // ���ڰ� ������ count�� ����
						if(j-1 >= 0)							//								 -- // 
							if(mine[i][j-1] == -1) count ++;	//				6		7		8-- // 
						if(j+1 <= 9)							//				0		0		0-- // 
							if(mine[i][j+1] == -1) count ++;	// -------------------------------- // 
						if(i+1 <= 9 && j-1 >= 0)
							if(mine[i+1][j-1] == -1) count ++;
						if(i+1 <= 9)
							if(mine[i+1][j] == -1) count ++;
						if(i+1 <= 9 && j+1 <= 9)
							if(mine[i+1][j+1] == -1) count ++;
					}											
					mine[i][j] = count;																// üũ�� ������ mine[i][j]�� count�� ����
				}
				count = 0;																			// �ݺ��ϱ����� count�� �ʱ�ȭ
			}
		}
		ending = false;																				// ���� ���� �������� �ٲ�
		setVisible(true); 																			// ������ ���̱�
		setSize(280, 365); 																			// ������ ������ ���� ������
		setResizable(false);																		// ������ ����� ������ �������� ���ϰ� ���
		this.setLocationRelativeTo(null);															// ȭ�� �߾ӿ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);												// X��ư ������ �ݱ�
																									// ���� ���ϸ� ���μ�����(��׶��忡) ��������
	}
	

																									/*
																									 * �Ʒ� �߱޺��� ��޴ܰ������
																									 * �ʱ� ���� level���� �񱳿�
																									 * ��ư�� ���ڹ迭�� �������
																									 * �⺻���� �ٸ���
																									 * ��� ������ ����
																									 */
	if(level == 2) {
		setResizable(true);
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("����");

		menu.add(new JMenuItem("���� �����ϱ�")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new mine();
			}
		});
		menu.addSeparator();
		menu.add(new JMenuItem("�ʱ�")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 1;
				dispose();
				new mine();
			}
		});
		menu.add(new JMenuItem("�߱�")).addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				dispose();
				new mine();
			}
		});
		menu.add(new JMenuItem("���")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 3;
				dispose();
				new mine();
			}
		});
	
		menu.addSeparator();
	
		menu.add(new JMenuItem("����")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mb.add(menu);
	
		this.setJMenuBar(mb);
	
		this.setLayout(new BorderLayout());
		add(jp);
		add(jp2, "North");
		jp2.add(reset);
		
		reset.setIcon(icon_reset);
		reset.setBorderPainted(false);
		reset.setContentAreaFilled(false);
		reset.setFocusPainted(false);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "'����'�Ǿ����ϴ�.");
				dispose();
				new mine();
			}
		});

		for(; ; ) {
			for(int i, j, count = 0; count < 30;) {
				i=rnd.nextInt(15);
				j=rnd.nextInt(15);
				if(mine2[i][j] != -1) {
					mine2[i][j] = -1;
					count++;
				}
			}
			break;
		}
	
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
			if(mine2[i][j] == 0) {
				jb2[i][j] = new JButton();
				jb2[i][j].setPreferredSize(new Dimension(20,20));
				jb2[i][j].addActionListener(new ButtonListener());
				jb2[i][j].addMouseListener(new clickListener());
				jb2[i][j].setBackground(Color.DARK_GRAY);
    	
				jp.add(jb2[i][j]);
			}
			else if(mine2[i][j] != 0) {
				jb2[i][j] = new JButton();
				jb2[i][j].setPreferredSize(new Dimension(20,20));
				jb2[i][j].addActionListener(new MineListener());
				jb2[i][j].addMouseListener(new clickListener());
				jb2[i][j].setBackground(Color.DARK_GRAY);
				jp.add(jb2[i][j]);
			}
			}
		}
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				int count=0;
				if(mine2[i][j] != -1) {
					if(i >= 0 && j >= 0 && i <= 14 && j <= 14) {
						if(i-1 >= 0 && j-1 >= 0)
							if(mine2[i-1][j-1] == -1) count ++;
						if(i-1 >= 0)
							if(mine2[i-1][j] == -1) count ++;
						if(i-1 >= 0 && j+1 <= 14)
							if(mine2[i-1][j+1] == -1) count ++;
						if(j-1 >= 0)
							if(mine2[i][j-1] == -1) count ++;
						if(j+1 <= 14)
							if(mine2[i][j+1] == -1) count ++;
						if(i+1 <= 14 && j-1 >= 0)
							if(mine2[i+1][j-1] == -1) count ++;
						if(i+1 <= 14)
							if(mine2[i+1][j] == -1) count ++;
						if(i+1 <= 14 && j+1 <= 14)
							if(mine2[i+1][j+1] == -1) count ++;
					}
					mine2[i][j] = count;
				}
				count = 0;
			}
		}
		
		ending = false;
		setVisible(true);
		setSize(400, 490);
		setResizable(false);
		this.setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
																									/*
																									 * ���⼭���� 
																									 * ���� 3
																									 */
	
	if(level == 3) {
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("����");

		menu.add(new JMenuItem("���� �����ϱ�")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					new mine();
			}
		});
		menu.addSeparator();
		menu.add(new JMenuItem("�ʱ�")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 1;
				dispose();
				new mine();
			}
		});
		menu.add(new JMenuItem("�߱�")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 2;
				dispose();
				new mine();
			}
		});
		menu.add(new JMenuItem("���")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new mine();
			}
		});
	
		menu.addSeparator();
	
		menu.add(new JMenuItem("����")).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mb.add(menu);
		
		
		this.setJMenuBar(mb);
	
		this.setLayout(new BorderLayout());
		add(jp);
		add(jp2, "North");
		jp2.add(reset);
		reset.setIcon(icon_reset);
		reset.setBorderPainted(false);
		reset.setContentAreaFilled(false);
		reset.setFocusPainted(false);
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "'����'�Ǿ����ϴ�.");
					dispose();
					new mine();
			}
		});
		

		for(; ; ) {
			for(int i, j, count = 0; count < 40;) {
				i=rnd.nextInt(20);
				j=rnd.nextInt(20);
				if(mine3[i][j] != -1) {
					mine3[i][j] = -1;
					count++;
				}
			}
			break;
		}
	
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
			if(mine3[i][j] == 0) {
				jb3[i][j] = new JButton();
				jb3[i][j].setPreferredSize(new Dimension(20,20));
				jb3[i][j].addActionListener(new ButtonListener());
				jb3[i][j].addMouseListener(new clickListener());
				jb3[i][j].setBackground(Color.DARK_GRAY);
				jp.add(jb3[i][j]);
			}
			else if(mine3[i][j] != 0) {
				jb3[i][j] = new JButton();
				jb3[i][j].setPreferredSize(new Dimension(20,20));
				jb3[i][j].addActionListener(new MineListener());
				jb3[i][j].addMouseListener(new clickListener());
				jb3[i][j].setBackground(Color.DARK_GRAY);
				jp.add(jb3[i][j]);
			}
		}
	}
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				int count=0;
				if(mine3[i][j] != -1) {
					if(i >= 0 && j >= 0 && i <= 19 && j <= 19) {
						if(i-1 >= 0 && j-1 >= 0)
							if(mine3[i-1][j-1] == -1) count ++;
						if(i-1 >= 0)
							if(mine3[i-1][j] == -1) count ++;
						if(i-1 >= 0 && j+1 <= 19)
							if(mine3[i-1][j+1] == -1) count ++;
						if(j-1 >= 0)
							if(mine3[i][j-1] == -1) count ++;
						if(j+1 <= 19)
							if(mine3[i][j+1] == -1) count ++;
						if(i+1 <= 19 && j-1 >= 0)
							if(mine3[i+1][j-1] == -1) count ++;
						if(i+1 <= 19)
							if(mine3[i+1][j] == -1) count ++;
						if(i+1 <= 19 && j+1 <= 19)
							if(mine3[i+1][j+1] == -1) count ++;
					}
					mine3[i][j] = count;
				}
				count = 0;
			}
		}
		
		ending = false;
		setVisible(true);
		setSize(520, 615);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

private class ButtonListener implements ActionListener  { 											// ���ڰ� �ƴ� ��ư Ŭ�������� ����Ǵ� �׼Ǹ�����
	public void actionPerformed(ActionEvent e) {													
		if(level == 1) {																			// level���� 1�϶�
			for(int i = 0; i < 10; i++) {															// �ش� ��ư�� �迭���� ã�� ���� �ݺ���
				for(int j = 0; j < 10; j++) {
					if(e.getSource() == jb[i][j] && jb[i][j].getBackground() == Color.DARK_GRAY) {	// �Ѿ�� e ���� jb[i][j]�� ���� ���� ��׶����÷��� DARK_GRAY��
						check(i, j);																// check�� (i,j)���� �Ѱ���
					}
				}
			}
		}
																									/*
																									 * level���� 2�ΰ���
																									 * level���� 3�ΰ�쵵
																									 * �ݺ����� Ƚ���� �ٸ���
																									 * �Ȱ���
																									 */
		if(level == 2) {
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 15; j++) {
					if(e.getSource() == jb2[i][j]&& jb2[i][j].getBackground() == Color.DARK_GRAY) {
						check(i, j);
					}
				}
			}
		}
		if(level == 3) {
			for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++) {
					if(e.getSource() == jb3[i][j]&& jb3[i][j].getBackground() == Color.DARK_GRAY) {
						check(i, j);
					}
				}
			}
		}
	}
}

private class MineListener implements ActionListener  { 												// ������ ��ư�� Ŭ�������� ����Ǵ� �׼Ǹ�����
	public void actionPerformed(ActionEvent e) {
		if(ending == false) JOptionPane.showMessageDialog(null, "�ƽ����ϴ�. ���ڸ� Ŭ���߽��ϴ�.");{			// �������� false�� ��� "�ƽ����ϴ�. ���ڸ� Ŭ���߽��ϴ�."��� �޽����� ��� �˾�â�� ���
		
		if(level == 1) {																				// ���ڷ� ������ ��� ��ư�� ��ġ�� ��Ÿ���� ���� �ݺ���
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(mine[i][j] == -1) {																// �ش� i, j�� ��ġ�� �ִ� ��ư�� ������ ���
							jb[i][j].setBackground(Color.DARK_GRAY);									// ��׶����÷��� �⺻���� �ٲ�
							jb[i][j].setIcon(icon_mine);												// �����ܿ� ���� �̹����� ����
							ending=true;																// �������� ending�� true�� �ٲ� || ������ ���� �� �ٸ� ���� �� ��ư �������� ���� ���� �ϱ� ������
						}
						else if (mine[i][j] != -1 && jb[i][j].getBackground() != Color.DARK_GRAY) {		// �ش� i, j�� ��ġ�� �ִ� ��ư�� ���ڰ� �ƴϸ鼭 �⺻���� �ƴҰ�� (����� �������)
							jb[i][j].setBorderPainted(false);											// BorderPainted ���� false�� �ٲ�
							jb[i][j].setBackground(Color.DARK_GRAY);									// ��׶����÷��� �⺻���� �ٲ�
							jb[i][j].setIcon(icon_flagx);												// ��߿� x ǥ�õ� �������� ����
						}
						else
							jb[i][j].setBorderPainted(false);											// �� ���� ���(���ڰ� �ƴϸ鼭 ��ߵ� �Ȳ������)
						
					jb[i][j].setBorderPainted(false);													// ���ڹ�ư�� �ƴ� ��� ��ư�� Ŭ���ص� ������ ���� �����ϱ� ���� false���� ����
					jb[i][j].setBackground(Color.DARK_GRAY);											// ��׶����÷��� �⺻���� ����
				}
			}
		}																								// �Ʒ� ���� ��� ����
		if(level == 2) {
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 15; j++) {
					if(mine2[i][j] == -1) {
						jb2[i][j].setIcon(icon_mine);
						jb2[i][j].setBorderPainted(false);
						ending=true;
					}
					else if (mine2[i][j] != -1 && jb2[i][j].getBackground() != Color.DARK_GRAY) {
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setBackground(Color.DARK_GRAY);
						jb2[i][j].setIcon(icon_flagx);
					}
					else
						jb2[i][j].setBorderPainted(false);
					
					jb2[i][j].setBorderPainted(false);
					jb2[i][j].setBackground(Color.DARK_GRAY);
				}
			}
		}	
		if(level == 3) {
			for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++) {
					if(mine3[i][j] == -1){
						jb3[i][j].setIcon(icon_mine);
						jb3[i][j].setBorderPainted(false);
						ending=true;
					}
					else if (mine3[i][j] != -1 && jb3[i][j].getBackground() != Color.DARK_GRAY) {
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setBackground(Color.DARK_GRAY);
						jb3[i][j].setIcon(icon_flagx);
					}
					else
						jb3[i][j].setBorderPainted(false);
				}
			}
		}
	}
	}
}


private class clickListener implements MouseListener{ 																						// ����� ����� ���� ���콺 ������
	
	/*
	 * ���콺�����ʸ� ����Ҷ� �⺻������ �����Ǵ� �Լ�����
	 * ������� �ʴ��� �־����.
	 */
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		if(level == 1) {
			if(e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {																		// Ŭ���� ��ư�� ���콺 ��Ŭ������ ��
				for(int i = 0; i<10; i++) {																									// ��Ŭ���� ��ư�� ã������ �񱳹�
					for(int j = 0; j<10; j++) {
						if(e.getSource() == jb[i][j] && jb[i][j].isBorderPainted()==true && jb[i][j].getBackground() == Color.DARK_GRAY) {	// ��Ŭ���� ��ư�� �⺻ ���¸�
							jb[i][j].setIcon(icon_flag);																					// ����� ����
							jb[i][j].setBackground(Color.GRAY);																				// ����� Ȯ���ϱ� ���� ��׶��� �÷��� ����
						}
						else if(e.getSource() == jb[i][j] && jb[i][j].isBorderPainted()==true && jb[i][j].getBackground() == Color.GRAY) {	// ����� ���� ��ư�̸�
							jb[i][j].setIcon(null);																							// �ش� ��ư�� �������� �����
							jb[i][j].setBackground(Color.DARK_GRAY);																		// �⺻������� ����
						}																													// ���� ����
					}
				}
			}
		}
		if(level == 2) {
			if(e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {
				for(int i = 0; i<15; i++) {
					for(int j = 0; j<15; j++) {
						if(e.getSource() == jb2[i][j] && jb2[i][j].isBorderPainted()==true && jb2[i][j].getBackground() == Color.DARK_GRAY) {
							jb2[i][j].setIcon(icon_flag);
							jb2[i][j].setBackground(Color.GRAY);
						}
						else if(e.getSource() == jb2[i][j] && jb2[i][j].isBorderPainted()==true && jb2[i][j].getBackground() == Color.GRAY) {
							jb2[i][j].setIcon(null);
							jb2[i][j].setBackground(Color.DARK_GRAY);
						}
					}
				}
			}
		}
		if(level == 3) {
			if(e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {
				for(int i = 0; i<20; i++) {
					for(int j = 0; j<20; j++) {
						if(e.getSource() == jb3[i][j] && jb3[i][j].isBorderPainted()==true && jb3[i][j].getBackground() == Color.DARK_GRAY) {
							jb3[i][j].setIcon(icon_flag);
							jb3[i][j].setBackground(Color.GRAY);
						}
						else if(e.getSource() == jb3[i][j] && jb3[i][j].isBorderPainted()==true && jb3[i][j].getBackground() == Color.GRAY) {
							jb3[i][j].setIcon(null);
							jb3[i][j].setBackground(Color.DARK_GRAY);
						}
					}
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

private void check(int i, int j) {																	// ���ϱ� ���� �Լ�
	if(level == 1) {																				// level���� 1�ϰ��
		try {																						// �迭�� ������ ����� ó���ϱ� ���� try~catch��
			if(mine[i][j] == 0 && jb[i][j].isBorderPainted() == true) {								// �ش� mine[i][j]���� 0�� ���� �����鼭 ��ư�� Ȱ��ȭ�� ���¿� �������
				jb[i][j].setIcon(icon0);															// ����0�� ���ϱ� ���� �̹����� ����
				jb[i][j].setBorderPainted(false);													// ��ư�� �ܰ����� �Ⱥ��̰� ����
				jb[i][j].setContentAreaFilled(false);												// ��ư�� ���ο��� ä��� �Ⱥ��̰� ����(�Ķ���)
				jb[i][j].setFocusPainted(false);													// ��ư�� ��Ŀ��(���콺�� �ö� ����)�� ����� �׵θ��� �Ⱥ��̰� ������
				check(i+1, j);																		// �ֺ��� 0�� �ִ��� Ȯ���ϱ� ����
				check(i-1, j);
				check(i, j+1);
				check(i, j-1);
				check(i+1, j+1);
				check(i-1, j-1);
				check(i-1, j+1);
				check(i+1, j-1);
			}
			else {																					// �׿��� ���
				if(jb[i][j].isBorderPainted() == true) {											// �ش� mine[i][j]�� ���� 0�� �ƴѰ����
																									// �� �Լ��� �ҷ����� ��� ��ü�� ���ڰ� �ƴѰ���̱� ������
																									// ������ ��츦 üũ�� �ʿ�� ����
					switch(mine[i][j]) {															// ����ġ ���̽���
					case 1:																			// 1~9�� ��� �� ���ڿ� �´� �̹����� ������
						jb[i][j].setIcon(icon1);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					case 2:
						jb[i][j].setIcon(icon2);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					case 3:
						jb[i][j].setIcon(icon3);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					case 4:
						jb[i][j].setIcon(icon4);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					case 5:
						jb[i][j].setIcon(icon5);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					case 6:
						jb[i][j].setIcon(icon6);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					case 7:
						jb[i][j].setIcon(icon7);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					case 8:
						jb[i][j].setIcon(icon8);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					case 9:
						jb[i][j].setIcon(icon9);
						jb[i][j].setBorderPainted(false);
						jb[i][j].setContentAreaFilled(false);
						jb[i][j].setFocusPainted(false);
						break;
					}
				}
			}
			victory();																				// �¸� ������ Ȯ���ϱ� ���� ȣ����
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			
		}
	}
	if(level == 2) {																				// ���� �Ȱ���
		try {
			if(mine2[i][j] == 0 && jb2[i][j].isBorderPainted() == true) {
				jb2[i][j].setIcon(icon0);
				jb2[i][j].setBorderPainted(false);
				jb2[i][j].setContentAreaFilled(false);
				jb2[i][j].setFocusPainted(false);
				check(i+1, j);
				check(i-1, j);
				check(i, j+1);
				check(i, j-1);
				check(i+1, j+1);
				check(i-1, j-1);
				check(i-1, j+1);
				check(i+1, j-1);
			}
			else {
				if(jb2[i][j].isBorderPainted() == true) {
					switch(mine2[i][j]) {															
					case 1:																		
						jb2[i][j].setIcon(icon1);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
					case 2:
						jb2[i][j].setIcon(icon2);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
					case 3:
						jb2[i][j].setIcon(icon3);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
					case 4:
						jb2[i][j].setIcon(icon4);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
					case 5:
						jb2[i][j].setIcon(icon5);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
					case 6:
						jb2[i][j].setIcon(icon6);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
					case 7:
						jb2[i][j].setIcon(icon7);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
					case 8:
						jb2[i][j].setIcon(icon8);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
					case 9:
						jb2[i][j].setIcon(icon9);
						jb2[i][j].setBorderPainted(false);
						jb2[i][j].setContentAreaFilled(false);
						jb2[i][j].setFocusPainted(false);
						break;
				}
				}
			}
			victory();
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			
		}
	}
	if(level == 3) {
		try {
			if(mine3[i][j] == 0 && jb3[i][j].isBorderPainted() == true) {
				jb3[i][j].setIcon(icon0);
				jb3[i][j].setBorderPainted(false);
				jb3[i][j].setContentAreaFilled(false);
				jb3[i][j].setFocusPainted(false);
				check(i+1, j);
				check(i-1, j);
				check(i, j+1);
				check(i, j-1);
				check(i+1, j+1);
				check(i-1, j-1);
				check(i-1, j+1);
				check(i+1, j-1);
			}
			else {
				if(jb3[i][j].isBorderPainted() == true) {
					switch(mine3[i][j]) {
					case 1:
						jb3[i][j].setIcon(icon1);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					case 2:
						jb3[i][j].setIcon(icon2);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					case 3:
						jb3[i][j].setIcon(icon3);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					case 4:
						jb3[i][j].setIcon(icon4);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					case 5:
						jb3[i][j].setIcon(icon5);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					case 6:
						jb3[i][j].setIcon(icon6);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					case 7:
						jb3[i][j].setIcon(icon7);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					case 8:
						jb3[i][j].setIcon(icon8);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					case 9:
						jb3[i][j].setIcon(icon9);
						jb3[i][j].setBorderPainted(false);
						jb3[i][j].setContentAreaFilled(false);
						jb3[i][j].setFocusPainted(false);
						break;
					}
				}
			}
			victory();
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			
		}
	}
}

private void victory() {																			// �¸� ������ Ȯ��
	if(level == 1) {
		int count = 0;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(this.mine[i][j] != -1 && this.jb[i][j].isBorderPainted() == false) {				// �ش� i,j�� ���ڰ� �ƴϸ鼭 BorderPainted�� false�� ���
					count++;																		// �� ���ڰ� �ƴϸ鼭 Ŭ���� ��츦 ����
				}
			}
		}
		if(count >= 90) {																			// ���ڰ� �ƴϸ鼭 Ŭ���� ��찡 90�̻��� ���
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(jb[i][j].isBorderPainted() == true) {										// BorderPainted�� true�� ��찡 �ִٸ�
						jb[i][j].setBorderPainted(false);											// false�� ����
						if(mine[i][j] == -1)														// ���ڸ�
							jb[i][j].setIcon(icon_mine);											// ���� �̹����� ������ ����
					}
				}
			}
			if(ending==false) {																		// �������� ������ ���
				JOptionPane.showMessageDialog(null, "�����մϴ�. �¸��߽��ϴ�!");							// �¸� �޽��� ���
				ending = true;																		// �������� ������ ����
			}
		}
	}																								// ���� �Ȱ���
	if(level == 2) {
		int count = 0;
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				if(this.mine2[i][j] != -1 && this.jb2[i][j].isBorderPainted() == false) {
					count++;
				}
			}
		}
		if(count >= 195) {
			for(int i=0; i<15; i++) {
				for(int j=0; j<15; j++) {
					if(jb2[i][j].isBorderPainted() == true) {
						jb2[i][j].setBorderPainted(false);
						if(mine2[i][j] == -1)
							jb2[i][j].setIcon(icon_mine);
					}
				}
			}
			if(ending==false) {
				JOptionPane.showMessageDialog(null, "�����մϴ�. �¸��߽��ϴ�!");
				ending = true;
			}
		}
	}
	if(level == 3) {
		int count = 0;
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				if(this.mine3[i][j] != -1 && this.jb3[i][j].isBorderPainted() == false) {
					count++;
				}
			}
		}
		if(count >= 360) {
			for(int i=0; i<20; i++) {
				for(int j=0; j<20; j++) {
					if(jb3[i][j].isBorderPainted() == true) {
						jb3[i][j].setBorderPainted(false);
						if(mine3[i][j] == -1)
							jb3[i][j].setIcon(icon_mine);
					}
				}
			}
			if(ending==false) {
				JOptionPane.showMessageDialog(null, "�����մϴ�. �¸��߽��ϴ�!");
				ending = true;
			}
		}
	}
}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	new mine();																						// ���α׷� ����� ������ �ҷ�����
	}static int level = 0; static boolean ending = false;											// �������� level ���� �� 0���� �ʱ�ȭ, ending ���� �� false�� �ʱ�ȭ
}