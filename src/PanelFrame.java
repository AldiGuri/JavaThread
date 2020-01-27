import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelFrame extends JFrame
{
    
    private JButton StartThreads;
    private JPanel Panel;
    private JLabel Etiket;
    
    private static final Color[] ngjyrat = { Color.BLACK, Color.BLUE,
    		 Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
    		 Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
    		 Color.RED, Color.WHITE, Color.YELLOW };


    public PanelFrame()
    {
    	super( "Thread" );
        
    	Etiket = new JLabel( "" );
    	
        StartThreads = new JButton( "Start Threads" );
        StartThreads.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent event )
                    {
                    	Funksioni F = new Funksioni();
                    	F.start();
                    	Ngjyra N = new Ngjyra();
                    	N.start();
                    }
                }
        );

        
        Panel = new JPanel();
        Etiket.setHorizontalAlignment(JLabel.CENTER);
        
        add( Etiket,BorderLayout.NORTH );
        add( Panel, BorderLayout.CENTER ); 
        add( StartThreads, BorderLayout.SOUTH );
        
    }

    class Funksioni extends Thread {
    	public void run() {
    		 try {
    			 System.out.println("Llogaritja duke u kryer");
    			 
    			 for(int i = 0; i < 1000; i++) {
    				 
    				 Etiket.setText("Vlera e Y = "+ (i*2+5));
    				Thread.sleep(4000);
    			 }
    			 
    		 }catch (InterruptedException e) {
    			 System.out.println("Thread underpre.");
    	 		}
    		 	System.out.println("Thread duke perfunduar.");
    	 	}
    	}
    
    class Ngjyra extends Thread {
    	 public void run() {
    		 try {
    			 
    			 for(int i = 0; i < ngjyrat.length; i++) {
    				 System.out.println(ngjyrat[i]);
    				 
    				 Panel.setBackground(ngjyrat[i]);
    				 Panel.repaint(); 
    				Thread.sleep(8000);
    			 }
    		 }catch (InterruptedException e) {
    			 System.out.println("Thread underpre.");
    	 		}
    		 System.out.println("Thread duke perfunduar.");
    	 }

    	
    	}
    
}
