import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends Frame {
    private Button rightbtn=new Button("→");
    private Button leftbtn=new Button("←");
    private Button firebtn=new Button("Fire");
    private Button autobtn=new Button("Auto move");
    private Button exitbtn=new Button("Exit");
    private Label hitlab=new Label("Hit:0");
    private ImageIcon triangle=new ImageIcon("triangle.png");
    private JLabel trilab=new JLabel(triangle);
    private ImageIcon gun=new ImageIcon("gun.png");
    private JLabel gunlab=new JLabel(gun);
    private ImageIcon sun=new ImageIcon("sun.png");
    private JLabel sunlab=new JLabel(sun);
    private ImageIcon line=new ImageIcon("line.png");
    private JLabel linelab=new JLabel(line);
    private Timer t1;
    private int gunlabX,gunlabY,a,hit=0;


    private boolean boo=true;


    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(50,50,1000,800);
        this.setLayout(null);
        rightbtn.setBounds(480,600,50,50);
        leftbtn.setBounds(400,600,50,50);
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
        trilab.setBounds(500,450,100,100);
        this.add(trilab);
        sunlab.setBounds(500,100,100,100);
        this.add(sunlab);
        linelab.setBounds(80,550,800,10);
        this.add(linelab);
        gunlab.setBounds(trilab.getX()+25,trilab.getY()-25,50,50);
        this.add(gunlab);
        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        rightbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=trilab.getX();
                trilab.setLocation(a+5,trilab.getY());
                gunlab.setLocation(trilab.getX()+25,trilab.getY()-25);
                if(trilab.getX()>=800){
                    trilab.setLocation(800,trilab.getY());
                    gunlab.setLocation(trilab.getX()+25,trilab.getY()-25);
                }
                gunlabX=trilab.getX()+25;
                gunlabY=gunlab.getY();
                a=trilab.getY()-25;
            }
        });
        leftbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int b=trilab.getX();
                trilab.setLocation(b-5,trilab.getY());
                gunlab.setLocation(trilab.getX()+25,trilab.getY()-25);
                if(trilab.getX()<=60){
                    trilab.setLocation(60,trilab.getY());
                    gunlab.setLocation(trilab.getX()+25,trilab.getY()-25);
                }
                gunlabX=trilab.getX()+25;
                gunlabY=gunlab.getY();
                a=trilab.getY()-25;
            }
        });
        firebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
            }
        });
        gunlabX=trilab.getX()+25;
        gunlabY=gunlab.getY();
        a=trilab.getY()-25;
        t1=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(boo==true){
                    gunlab.setLocation(gunlabX,gunlabY--);
                    if(gunlabY<=0){
                        boo=false;
                    }
                    if(gunlab.getX()>=sunlab.getX()-25&&gunlab.getX()<=sunlab.getX()+50&&gunlab.getY()==sunlab.getY()+50){
                        gunlab.setLocation(gunlabX,a);
                        gunlabY=a;
                        Random rnd=new Random();
                        int sunX=rnd.nextInt();
//                        sunlab.setLocation();
                        hit++;
                        hitlab.setText(Integer.toString(hit));
                    }
                }else if(boo==false){
                     gunlab.setLocation(gunlabX,a);
                     gunlabY=a;
                    if(gunlab.getY()==a){
                        boo=true;
                    }
                }
            }
        });





    }
}
