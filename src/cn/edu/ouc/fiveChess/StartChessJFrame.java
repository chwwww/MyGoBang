package cn.edu.ouc.fiveChess;  
import java.awt.event.*;  
import java.awt.*;  
  
import javax.swing.*;  
/* 
 五子棋主框架類，程序啟動類 
 */  
public class StartChessJFrame extends JFrame {  
  private ChessBoard chessBoard;  
  private JPanel toolbar;  
  private JButton startButton,backButton,exitButton;  
    
  private JMenuBar menuBar;  
  private JMenu sysMenu;  
  private JMenuItem startMenuItem,exitMenuItem,backMenuItem;  
  //重新开始，退出，和悔棋菜单项  
  public StartChessJFrame(){  
      setTitle("单机版五子棋");//设置标题  
      chessBoard=new ChessBoard();  
              
      Container contentPane=getContentPane();  
      contentPane.add(chessBoard);  
      chessBoard.setOpaque(true);  //设置为不透明
        
      MyItemListener lis=new MyItemListener();  
      toolbar=new JPanel();//工具面板实例化  
      //三个按钮初始化  
      startButton=new JButton("重新开始");  
      exitButton=new JButton("退出");  
      backButton=new JButton("悔棋");  
      //将工具面板按钮用FlowLayout布局  
      toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));  
      //将三个按钮添加到工具面板  
      toolbar.add(startButton);  
      toolbar.add(exitButton);  
      toolbar.add(backButton);  
      //将三个按钮注册监听事件  
      startButton.addActionListener(lis);  
      exitButton.addActionListener(lis);  
      backButton.addActionListener(lis);  
      //将工具面板布局到界面”南方“也就是下方  
      add(toolbar,BorderLayout.SOUTH);  
      add(chessBoard);//将面板对象添加到窗体上  
      //设置界面关闭事件  
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      //setSize(800,800);  
      pack();//自适应大小  
        
  }  
    
  private class MyItemListener implements ActionListener{  
      public void actionPerformed(ActionEvent e){  
          Object obj=e.getSource();//获得事件源  
          if(obj==StartChessJFrame.this.startMenuItem||obj==startButton){  
              //重新开始  
              //JFiveFrame.this内部类引用外部类  
              System.out.println("重新开始");  
              chessBoard.restartGame();  
          }  
          else if (obj==exitMenuItem||obj==exitButton)  
              System.exit(0);  
          else if (obj==backMenuItem||obj==backButton){  
              System.out.println("悔棋...");  
              chessBoard.goback();  
          }  
      }  
  }  
    
    
    
  public static void main(String[] args){  
      StartChessJFrame f=new StartChessJFrame();//创建主框架  
      f.setVisible(true);//显示主框架  
        
  }  
}  