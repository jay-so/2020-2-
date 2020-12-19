package management;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class App {
	private final String ID = "java";
	private final String PASS = "java";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;
	private JPanel currPanel;
	private JTextField nameInput;
	private JTextField amountInput;
	private JTextField searchInput;
	private JTable table;
	private JTable ntable;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//가게 조회 panel구성(searchPanel)
		ImagePanel searchPanel = new ImagePanel(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\Activation.jpg").getImage());
		searchPanel.setSize(1800, 750);
		frame.getContentPane().add(searchPanel);
		searchPanel.setVisible(false);
		//가게 조회 버튼
		JButton searchBtn = new JButton("가게 조회");
		searchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 22));
			
				
		//가게 피드백 panel구성(fbPanel)
		ImagePanel fbPanel = new ImagePanel(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\Activation.jpg").getImage());
		fbPanel.setSize(1800, 750);
		frame.getContentPane().add(fbPanel);
		fbPanel.setVisible(false);
		//피드백 버튼
		JButton fbBtn = new JButton("가게 피드백");
		fbBtn.setFont(new Font("맑은 고딕", Font.BOLD, 22));
				
		//공지사항 panel구성(ntPanel)
		ImagePanel ntPanel = new ImagePanel(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\Activation.jpg").getImage());
		ntPanel.setSize(1800, 750);
		frame.getContentPane().add(ntPanel);
		ntPanel.setVisible(false);
		//공지사항 버튼
		JButton ntBtn = new JButton("공지 사항");
		ntBtn.setFont(new Font("맑은 고딕", Font.BOLD, 22));
				
		//모범업소 panel구성(exPanel)
		ImagePanel exPanel = new ImagePanel(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\Activation.jpg").getImage());
		exPanel.setSize(1800, 750);
		frame.getContentPane().add(exPanel);
		exPanel.setVisible(false);
		//모범업소 버튼
		JButton exBtn = new JButton("모범 업소");
		exBtn.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		
		//다른 Panel에 있을 때 searchBtn이 생겨남
		searchBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\searchBtn.jpg"));
		searchBtn.setPressedIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\searchBtnClicked.jpg"));
		searchBtn.setBorder(null);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//searchBtn빼고 다 색 바꾸기
				searchBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\searchBtnClicked.jpg"));
				fbBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\fbBtn.jpg"));
				ntBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ntBtn.jpg"));
				exBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\exBtn.jpg"));
				currPanel.setVisible(false);
				searchPanel.setVisible(true);
				currPanel = searchPanel;	//누르면 searchPanel로 변경
				searchPanel.add(searchBtn);
				searchPanel.add(fbBtn);		//searchPanel에 fbBtn추가
				searchPanel.add(ntBtn);		//searchPanel에 ntBtn추가
				searchPanel.add(exBtn);		//searchPanel에 exBtn추가
			}
		});
		searchBtn.setBounds(29, 123, 259, 40);
		
				
		//다른 Panel에 있을 때 fbBtn이 생겨남
		fbBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\fbBtn.jpg"));
		fbBtn.setPressedIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\fbBtnClicked.jpg"));
		fbBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fbBtn빼고 다 색 바꾸기
				fbBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\fbBtnClicked.jpg"));
				searchBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\searchBtn.jpg"));
				ntBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ntBtn.jpg"));
				exBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\exBtn.jpg"));
				currPanel.setVisible(false);
				fbPanel.setVisible(true);
				currPanel = fbPanel;		//누르면 fbPanel로 변경
				fbPanel.add(fbBtn);
				fbPanel.add(searchBtn);		//fbPanel에 searchBtn추가
				fbPanel.add(ntBtn);			//fbPanel에 ntBtn추가
				fbPanel.add(exBtn);			//fbPanel에 exBtn추가
			}
		});
		fbBtn.setBounds(29, 182, 259, 40);
		fbBtn.setBorder(null);
	
		
		//다른 Panel에 있을 때 ntBtn이 생겨남
		ntBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ntBtn.jpg"));
		ntBtn.setPressedIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ntBtnClicked.jpg"));
		ntBtn.setBorder(null);
		ntBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ntBtn빼고 다 색 바꾸기
				ntBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ntBtnClicked.jpg"));
				searchBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\searchBtn.jpg"));
				fbBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\fbBtn.jpg"));
				exBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\exBtn.jpg"));
				currPanel.setVisible(false);
				ntPanel.setVisible(true);
				currPanel = ntPanel;		//누르면 ntPanel로 변경
				ntPanel.add(ntBtn);
				ntPanel.add(searchBtn);		//ntPanel에 searchBtn추가
				ntPanel.add(fbBtn);			//ntPanel에 fbBtn추가
				ntPanel.add(exBtn);			//ntPanel에 exBtn추가
			}
		});
		ntBtn.setBounds(29, 241, 259, 40);
		
		//다른 Panel에 있을 때 exBtn이 생겨남
		exBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\exBtn.jpg"));
		exBtn.setPressedIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\exBtnClicked.jpg"));
		exBtn.setBorder(null);
		exBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//exBtn빼고 다 색 바꾸기
				exBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\exBtnClicked.jpg"));
				searchBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\searchBtn.jpg"));
				fbBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\fbBtn.jpg"));
				ntBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ntBtn.jpg"));
				currPanel.setVisible(false);
				exPanel.setVisible(true);
				currPanel = exPanel;		//누르면 exPanel로 변경
				exPanel.add(exBtn);
				exPanel.add(searchBtn);		//exPanel에 searchBtn추가
				exPanel.add(fbBtn);			//exPanel에 fbBtn추가
				exPanel.add(ntBtn);			//exPanel에 exBtn추가
			}
		});
		exBtn.setBounds(29, 300, 259, 40);
		
		
		/**
		 * 로그인 화면 구성
		 */
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\theme.jpg").getImage());
	    loginPanel.setBounds(0, 0, 1572, 670);
	    currPanel = loginPanel;
	    frame.setPreferredSize(loginPanel.getDim());
	    frame.setSize(loginPanel.getDim());
	    frame.setPreferredSize(loginPanel.getDim());
	    frame.getContentPane().add(loginPanel);
	       
	    //로그인 ID
	    idField = new JTextField();
	    idField.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
	    idField.setBounds(1223, 313, 296, 43);
	    loginPanel.add(idField);
	    idField.setColumns(10);
	    idField.setBorder(null);
	       
	    //로그인 PW
	    passField = new JPasswordField();
	    passField.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
	    passField.setBounds(1223, 389, 296, 43);
	    passField.setBorder(null);
	    loginPanel.add(passField);
	       
	    //로그인 버튼(logInBtn)
	    JButton logInBtn = new JButton("");
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ID.equals(idField.getText()) && PASS.equals(passField.getText())){
					JOptionPane.showMessageDialog(null,"로그인에 성공했습니다.");
					loginPanel.setVisible(false);
					searchPanel.setVisible(true);
					currPanel = searchPanel;		//loginBtn을 누르면 searchPanel로 변경
					searchPanel.add(searchBtn);		//searchPanel에 searchBtn추가
					//searchBtn만 색 바꾸기
					searchBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\searchBtnClicked.jpg"));
					searchPanel.add(fbBtn);			//searchPanel에 fbBtn추가
					searchPanel.add(ntBtn);			//searchPanel에 ntBtn추가
					searchPanel.add(exBtn);			//searchPanel에 exBtn추가
				}else{
					JOptionPane.showMessageDialog(null,"로그인에 실패했습니다.");
				}
			}
		});
		logInBtn.setBorder(null);
		logInBtn.setBounds(1183, 460, 338, 38);
		loginPanel.add(logInBtn);
		logInBtn.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\loginbtn.jpg"));
		logInBtn.setPressedIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\loginbtnClicked.jpg"));	
		frame.pack();
		
		
		/**
		 * 가게 조회 화면 구성(searchPanel)
		 */
		searchPanel.setLayout(null);
		JLabel lblSearch = new JLabel("Search :");
		lblSearch.setBounds(337, 76, 83, 40);
		lblSearch.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		searchPanel.add(lblSearch);
		
		//조회칸 설정
		searchInput = new JTextField();
		searchInput.setBounds(432, 76, 1080, 40);
		searchInput.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		searchPanel.add(searchInput);
		searchInput.setColumns(10);
		
		// 가게조회-테이블 패널
		JPanel tp = new JPanel();
		tp.setBounds(337, 140, 1175, 467);
		searchPanel.add(tp);
		
		//출력 테이블
		String[][] data = TDAO.getstores(); // mysql 데이터 삽입
		String[] headers = new String[] {"지역","시장명","상호명","업종","위치"}; //테이블 헤더
		JTable table = new JTable(data,headers);
		table.setRowHeight(30); //테이블 행 높이 조절
		table.setFont(new Font("맑은 고딕",Font.BOLD,15));
		table.setAlignmentX(0); //테이블 정렬
		tp.add(table);
		table.setPreferredScrollableViewportSize(new Dimension(1155,430));
		tp.add(new JScrollPane(table)); //테이블을 스크롤이 가능하게 변경
		tp.setOpaque(false);
		
		//hear꾸미기 설정
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(92,179, 255));
		header.setForeground(new Color(255,255,255));
		header.setFont(new Font("맑은 고딕", Font.BOLD,15));
		
		//table 데이터 검색
		searchInput.addKeyListener(new KeyAdapter(){
		  public void keyReleased(KeyEvent e){
				String search = searchInput.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		
		//테이블 열간격 조절 - 20이 최소 값
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(20);
		columnModels.getColumn(1).setPreferredWidth(20);
		columnModels.getColumn(3).setPreferredWidth(20);
		columnModels.getColumn(4).setPreferredWidth(250);
		
		// 테이블 내용 가운데 정렬
		  DefaultTableCellRenderer dt = new  DefaultTableCellRenderer();
		  dt.setHorizontalAlignment(SwingConstants.CENTER); //가운데로 정렬
		  TableColumnModel tm = table.getColumnModel(); //정렬할 테이블의 칼럼모델을 가져옴
		  for(int i =0;i<tm.getColumnCount();i++) {
			  tm.getColumn(i).setCellRenderer(dt);
		  }
		
		
		frame.getContentPane().add(fbPanel);
		fbPanel.setVisible(false);
		
		
		/**
		 * 가게 피드백 화면 구성(fbPanel)
		 */
		JLabel lblName = new JLabel("시장명");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 33));
		lblName.setBounds(378, 123, 139, 49);
		fbPanel.add(lblName);
		
		JLabel lblType = new JLabel("지역");
		lblType.setFont(new Font("맑은 고딕", Font.BOLD, 33));
		lblType.setBounds(378, 203, 139, 49);
		fbPanel.add(lblType);
		
		JLabel lblAmount = new JLabel("가게명");
		lblAmount.setFont(new Font("맑은 고딕", Font.BOLD, 33));
		lblAmount.setBounds(378, 284, 139, 49);
		fbPanel.add(lblAmount);
		
		JLabel lblNote = new JLabel("내용");
		lblNote.setFont(new Font("맑은 고딕", Font.BOLD, 33));
		lblNote.setBounds(378, 370, 139, 49);
		fbPanel.add(lblNote);
		
		nameInput = new JTextField();
		nameInput.setFont(new Font("맑은 고딕", Font.BOLD, 33));
		nameInput.setBounds(527, 123, 935, 49);
		fbPanel.add(nameInput);
		nameInput.setColumns(10);
		
		String[] typeArr = new String[]{"서울", "경기"};
		JComboBox typeInput = new JComboBox(typeArr);
		typeInput.setFont(new Font("맑은 고딕", Font.PLAIN, 33));
		typeInput.setBounds(527, 203, 935, 49);
		fbPanel.add(typeInput);
		typeInput.setBackground(Color.WHITE);
		
		amountInput = new JTextField();
		amountInput.setFont(new Font("맑은 고딕", Font.PLAIN, 33));
		amountInput.setColumns(10);
		amountInput.setBounds(527, 284, 935, 49);
		fbPanel.add(amountInput);
		
		JTextArea noteInput = new JTextArea();
		noteInput.setFont(new Font("맑은 고딕", Font.PLAIN, 33));
		noteInput.setBounds(527, 370, 935, 161);
		fbPanel.add(noteInput);
		noteInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JButton saveButton = new JButton("저장");
		saveButton.setBackground(new Color(188, 233, 183));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{					
					boolean fileExists = new File("./data.csv").exists();
					FileWriter fw = new FileWriter("./data.csv", true);
					if(!fileExists){
						fw.append("시장명, 위치, 가계명, 내용\n");
					}
					String name = nameInput.getText();
					String type = (String) typeInput.getSelectedItem();
					String amount = amountInput.getText();
					String note = noteInput.getText();
					fw.append(name + "," + type + "," + amount + "," + note + "\n");
					nameInput.setText("");
					amountInput.setText("");
					typeInput.setSelectedIndex(0);
					noteInput.setText("");
					JOptionPane.showMessageDialog(null, "데이터가 저장되었습니다.");
					fw.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "데이터 저장을 실패했습니다.");
				}
			}
		});
		saveButton.setFont(new Font("맑은 고딕", Font.PLAIN, 33));
		saveButton.setBounds(850, 554, 228, 49);
		fbPanel.add(saveButton);
		
		frame.pack();
		
		/**
		 * 공지사항 구성(ntPanel)
		 */
       
		ntPanel.setLayout(null);
		JLabel ntcLabel = new JLabel("Notice");
		ntcLabel.setBounds(746, 51, 340, 83);
		ntcLabel.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\Notice_image.PNG"));
		ntPanel.add(ntcLabel);
		
		//공지사항-테이블 패널
		JPanel ntcpanel = new JPanel();
		ntcpanel.setBackground(Color.WHITE);
		ntcpanel.setBounds(337, 140, 1175, 467);
		ntPanel.add(ntcpanel);
		  
		  
		String[][] ndata = NDAO.getcontents(); //mysql 데이터 불러옴
		String[] nheaders = new String[] {"번호","날짜","내용"}; //테이블 헤더
		JTable ntable = new JTable(ndata,nheaders);
		ntable.setRowHeight(30);
		ntable.setFont(new Font("맑은 고딕",Font.BOLD,15));
		ntable.setAlignmentX(0);
		ntcpanel.add(ntable);
		ntable.setPreferredScrollableViewportSize(new Dimension(1146,473)); //테이블 크기 
		ntcpanel.add(new JScrollPane(ntable));
		ntcpanel.setOpaque(false);
		  
		  
		//테이블 헤더 설정
		JTableHeader nheader = ntable.getTableHeader();
		nheader.setBackground(new Color(92,179,255));
		nheader.setForeground(new Color(255,255,255));
		nheader.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		  
		//테이블 열간격 조절 
		TableColumnModel columnModel = ntable.getColumnModel(); 
		for (int column = 0; column < ntable.getColumnCount(); column++) { 
			int width = 3; // 최소 열 간격 = 10 
		for (int row = 0; row < ntable.getRowCount(); row++) { 
			TableCellRenderer renderer = ntable.getCellRenderer(row, column); 
			Component comp = ntable.prepareRenderer(renderer, row, column); 
			width = Math.max(comp.getPreferredSize().width +1 , width);  
		} 
		if(width > 300) 
			width=300; 
			columnModel.getColumn(column).setPreferredWidth(width); 
		} 
			  
		//테이블 내용 가운데 정렬
		DefaultTableCellRenderer dtcr = new  DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); //가운데로 정렬
		TableColumnModel tcm = ntable.getColumnModel(); //정렬할 테이블의 칼럼모델을 가져옴
		for(int i =0;i<3;i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		
		/**
		 * 모범업소 안내 화면 구성(exPanel)
		 */		
		//모범업소 안내 화면 구성(exPanel)
		JButton fkBtn = new JButton("식품 안전나라");
		fkBtn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		fkBtn.setBackground(new Color(188, 233, 183));
		fkBtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            try{
               Desktop.getDesktop().browse(new URI("https://www.foodsafetykorea.go.kr"));
            } catch(Exception e) {
               JOptionPane.showMessageDialog(null, "링크에 연결할 수 없습니다.");
            }
          }
       });
       fkBtn.setBounds(814, 470, 230, 50);
       exPanel.add(fkBtn);
       
       JLabel fk1 = new JLabel("");
       fk1.setBounds(320, 60, 430, 550);
       fk1.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ex1.png"));
       exPanel.add(fk1);
       JLabel fk2 = new JLabel("");
       fk2.setBounds(750, 100, 350, 310);
       fk2.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ex2.png"));
       exPanel.add(fk2);
      
       JButton mfdsBtn = new JButton("식품의약품안전처");
       mfdsBtn.setFont(new Font("맑은 고딕", Font.BOLD, 24));
       mfdsBtn.setBackground(new Color(188, 233, 183));
       mfdsBtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            try{
               Desktop.getDesktop().browse(new URI("https://www.mfds.go.kr"));
            } catch(Exception e) {
               JOptionPane.showMessageDialog(null, "링크에 연결할 수 없습니다.");
            }
          }
       });
       mfdsBtn.setBounds(814, 530, 230, 50);
       exPanel.add(mfdsBtn);
       
       JLabel mfds = new JLabel("");
       mfds.setBounds(1110, 60, 430, 550);
       mfds.setIcon(new ImageIcon("C:\\Users\\delig\\eclipse-workspace\\Java-version-202006\\자바 팀플_최종\\src\\Image\\ex3.jpg"));
       exPanel.add(mfds);	
	}
}
