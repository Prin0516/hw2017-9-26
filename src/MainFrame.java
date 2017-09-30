import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends Frame {
    private Button rightbtn=new Button("-->");
    private Button leftbtn=new Button("<--");
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
    private Timer t1,t2;
    private int gunlabX,gunlabY,trilabX,trilabY,y,a,hit=0;
    private Random rnd=new Random();
    private boolean boo=true;
    private boolean boo1=true;
    private boolean boo2=true;


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
        sunlab.setBounds(500,100,30,30);
        this.add(sunlab);
        linelab.setBounds(80,550,800,10);
        this.add(linelab);
        gunlab.setBounds(trilab.getX()+35,trilab.getY()-10,30,30);
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
                t2.stop();
                int a=trilab.getX();
                trilab.setLocation(a+10,trilab.getY());
                gunlab.setLocation(trilab.getX()+35,trilab.getY()-10);
                if(trilab.getX()>=800){
                    trilab.setLocation(800,trilab.getY());
                    gunlab.setLocation(trilab.getX()+35,trilab.getY()-10);
                }
                gunlabX=trilab.getX()+35;
                gunlabY=gunlab.getY();

            }
        });
        leftbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.stop();
                int b=trilab.getX();
                trilab.setLocation(b-10,trilab.getY());
                gunlab.setLocation(trilab.getX()+35,trilab.getY()-10);
                if(trilab.getX()<=60){
                    trilab.setLocation(60,trilab.getY());
                    gunlab.setLocation(trilab.getX()+35,trilab.getY()-10);
                }
                gunlabX=trilab.getX()+35;
                gunlabY=gunlab.getY();
                a=trilab.getY()-35;
            }
        });
        firebtn.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                t1.start();
                t2.stop();
            }
        });
        autobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.stop();
                t2.start();
            }
        });

        t1=new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.stop();
                time();
            }
        });
        y=trilab.getY()-10;
        t2=new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(boo2==true){
                    time();
                    if(gunlabY<=0){
                        boo2=false;
                    }
                }else if(boo2==false){
                    time2();
                     boo2=true;
                }
            }
        });
        gunlabX=trilab.getX()+35;
        gunlabY=gunlab.getY();
        a=trilab.getY()-35;}

    public void time(){

        if(boo==true){
            gunlab.setLocation(gunlabX,gunlabY--);
            if(gunlabY<=0){
                boo=false;
            }
            if(gunlab.getX()>=sunlab.getX()-25&&gunlab.getX()<=sunlab.getX()+15&&gunlab.getY()==sunlab.getY()+30){
                gunlab.setLocation(gunlabX,a);
                gunlabY=a;
                hit++;
                hitlab.setText(Integer.toString(hit));
                int sunX=3,sunY=3;
                while(sunX%10!=0){
                    sunX=rnd.nextInt(785)+95;
                    sunY=rnd.nextInt(310)+30;
                }
                sunlab.setLocation(sunX,sunY);
            }
        }else if(boo==false){
            gunlab.setLocation(gunlabX,a);
            gunlabY=a;
            if(gunlab.getY()==a){
                boo=true;
            }
        }
    }
    public void time2(){
        trilabX=trilab.getX();
        trilabY=trilab.getY();
        if(boo1==true){
            trilab.setLocation(trilabX+=10,trilabY);
            gunlab.setLocation(trilab.getX()+35,trilab.getY()-10);
            if(trilabX>=800){
                boo1=false;
            }
            gunlabX=trilab.getX()+35;
            gunlabY=gunlab.getY();
        }else{
            trilab.setLocation(trilabX-=10,trilabY);
            gunlab.setLocation(trilab.getX()+35,trilab.getY()-10);
            if(trilabX<=80){
                boo1=true;
            }
            gunlabX=trilab.getX()+35;
            gunlabY=gunlab.getY();
        }
    }
    }

