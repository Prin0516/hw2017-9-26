import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private Button rightbtn=new Button("→");
    private Button leftbtn=new Button("←");
    private Button firebtn=new Button("Fire");
    private Button autobtn=new Button("Auto move");
    private Button exitbtn=new Button("Exit");
    private Label hitlab=new Label("Hit:0");


    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(50,50,900,800);
        this.setLayout(null);
        rightbtn.setBounds(400,600,50,50);
        leftbtn.setBounds(480,600,50,50);
        firebtn.setBounds(560,600,50,50);
        autobtn.setBounds(100,700,100,50);
        exitbtn.setBounds(750,700,50,50);
        hitlab.setBounds(150,600,50,50);
        this.add(rightbtn);
        this.add(leftbtn);
        this.add(firebtn);
        this.add(autobtn);
        this.add(exitbtn);
        this.add(hitlab);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });





    }
}
