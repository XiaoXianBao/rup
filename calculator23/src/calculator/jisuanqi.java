package calculator;  //�����������Լ���������Ŀ����
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;//����
import javax.swing.JFrame;//��ʾ����
import javax.swing.JTextField;//�ı���
import javax.swing.WindowConstants;

public class jisuanqi extends JFrame {        ///����show�̳и���JFrame
    private String[] ajm= {                "%","��","X^2","1/X",
                            "ce","c","<<<","��",
                            "7","8","9","*",
                            "4","5","6","��",
                            "1","2","3","+",
                            "+/-","0",".","="    };
    private JButton Ajm[]=new JButton[ajm.length];//��������0-23
    public JTextField t1=new JTextField();
    public JTextField t2=new JTextField();//���������ı���������ʾ�����Լ������������
    String str="";    //�洢�����ֵ����ʾ�������ı���t2
    String str1="";    //�洢���е�������Ľ����ʾ��������ı���t1
    double b=0;    //�洢������������һ���ļ���
    char ch=0;    //�洢�������������һ���ļ���
    public    void kuangjia() {
        java.awt.Container c=getContentPane(); //����
        this.setTitle("������");//����
        this.setVisible(true);//��ʾ����ʾ
        setLayout(null);
        setBounds(1000, 100,620, 900);//������ߵĴ�С��������λ�ã����Ͻ�Ϊ00
            
        for(int i=0;i<ajm.length;i++)
            Ajm[i]=new JButton(ajm[i]);
        //��������
        int begin=0;
        int bend=250;
        for(int i=0;i<ajm.length;)//��ư���λ�ü�������ʾЧ��
            {    int j=0;    
                while(j<4)///�㶨һ�л�һ��
                    {
                    Ajm[i].setBounds(begin, bend, 150, 100);//�����Ĵ�С
                    Ajm[i].setFont(new java.awt.Font("����", Font.BOLD, 45));//������ʾ����������
                    c.add(Ajm[i]);//��������
                    i++;j++;
                    begin+=150;//���ݴ��ڴ�С����������λ��
                    }
            begin=0;bend+=100;
            };
        for(int i=8;i<19;i++)///�������ְ�������ɫΪ��
        { 
            if(i==11||i==15)
                i++;
            Ajm[i].setBackground(Color.white);
        }
        Ajm[21].setBackground(Color.white);//����0�ż�λ�����⣬���Ե�������
        
////////////���������ı������������    
setLayout(null);
t1.setFont(new java.awt.Font("����", Font.BOLD, 40));
this.add(t1);
t1.setBounds(0,0,600,100);
t1.setEnabled(false); //ֻ��    
t1.setText("chengjunfeng");//��ʾ����

this.setLayout(null);
this.add(t2);
t2.setBounds(0,99,600,155);
t2.setFont(new java.awt.Font("����", Font.BOLD, 60));
t2.setEnabled(false); //ֻ��        
t2.setText("First calculator");    
///��������������ʾ���㰴�������������ִ��ʲô    
Ajm[0].addActionListener(new ajm0());//��0�ż������£����������Ӧ�ľ���%������ִ��ajm0�����
Ajm[1].addActionListener(new ajm1());
Ajm[2].addActionListener(new ajm2());
Ajm[3].addActionListener(new ajm3());
Ajm[4].addActionListener(new ajm4());
Ajm[5].addActionListener(new ajm5());
Ajm[6].addActionListener(new ajm6());
Ajm[7].addActionListener(new ajm7());
Ajm[8].addActionListener(new ajm8());
Ajm[9].addActionListener(new ajm9());
Ajm[10].addActionListener(new ajm10());
Ajm[11].addActionListener(new ajm11());
Ajm[12].addActionListener(new ajm12());
Ajm[13].addActionListener(new ajm13());
Ajm[14].addActionListener(new ajm14());
Ajm[15].addActionListener(new ajm15());
Ajm[16].addActionListener(new ajm16());
Ajm[17].addActionListener(new ajm17());
Ajm[18].addActionListener(new ajm18());
Ajm[19].addActionListener(new ajm19());
Ajm[20].addActionListener(new ajm20());
Ajm[21].addActionListener(new ajm21());
Ajm[22].addActionListener(new ajm22());
Ajm[23].addActionListener(new ajm23());


setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//�رշ�ʽ
    }
////����һ���е���������ڼӼ��˳�����أ�������������࣬���������    
class panduan{
    public void pd(char a) {
        if(a==0)//��ʾû�а������
            if(str.length()==0)
                b=0;//����û������ֵ����ֱ�Ӱ����ںţ�
            else
                b=Double.parseDouble(str);//������ֵ�����ں�
        else
            //����ch=�Ӽ��˳������������b��Ϊ��������ʾ��������ı���
        switch ( a) {
        case 43:
            b += Double.parseDouble(str);         
             t2.setText(String.valueOf(b));    
            break;
        case 45:
            b -= Double.parseDouble(str);         
             t2.setText(String.valueOf(b));    
            break;
        case 42:
         b *= Double.parseDouble(str);         
         t2.setText(String.valueOf(b));    
        break;
        case 47:
            
            double aa;
            
            aa= Double.parseDouble(str);    
            if(aa==0)
                {
                t2.setText("��������Ϊ0");
                str1="";
                str="";
                b=0;
                break;
                }
                b=(b/aa);
                t2.setText(String.valueOf(b));    
                break;
            }
    }
}
//////%
class ajm0 implements ActionListener{
            public void actionPerformed(ActionEvent arg0) {

                if(str1.length()==0)
                {
                    t1.setText("0");
                    t2.setText("0");
                    str="";
                    return;
                }//��ʲô��û������ֱ�Ӱ������    
            else if(str.length()==0)
                {
                t1.setText(str1);
                double t=b*b/100;
                str=String.valueOf(t);
                t1.setText(str1);
                t2.setText(str);
                }//��һ��������󣬼�����������ź�û����ֵ�����������b���в���
                //12+12+��ʱ���º�Ӧ���Ƕ�24���в���
            else {
                double dd=Double.parseDouble(str);
                dd=b*dd/100;
                str=String.valueOf(dd);
                t1.setText(str1);
                t2.setText(str);
            }///�������Ƕ���ʹ���¶�����ֵ��ת��24 ��0.24
            }
        }    
//��ȡ���� 4��=2
 class ajm1 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if(str.length()==0)
            {
            t1.setText(str1);
            double t=Math.sqrt(b);
            str=String.valueOf(t);
            t1.setText(str1);
            t2.setText(str);
            }
        else {
            double dd=Double.parseDouble(str);
            dd=Math.sqrt(dd);;
            str= String.valueOf(dd);
            t1.setText(str1);
            t2.setText(str);
            
        }
        }
    }
 ///ȡƽ��
 class ajm2 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if(str.length()==0)
            {
            
            t1.setText(str1);
            double t=b*b;
            str=String.valueOf(t);
            
            t1.setText(str1);
            t2.setText(str);
            }
        else {
            double dd=Double.parseDouble(str);
            dd*=dd;
            str= String.valueOf(dd);
            
            t1.setText(str1);
            t2.setText(str);
        }
        }
    }
 //1/x
 class ajm3 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {

                    if(str.length()==0)
                        {
                        
                        t1.setText(str1);
                        double t=1/b;
                        str=String.valueOf(t);
                        
                        t1.setText(str1);
                        t2.setText(str);
                        }
                    else {
                        double dd=Double.parseDouble(str);
                        dd=1/dd;
                        str= String.valueOf(dd);
                        
                        t1.setText(str1);
                        t2.setText(str);
                    }
            
        }
    } 
///ce  str��� ��t2û��ʾ
 class ajm4 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str="";
            t2.setText(str);
        
        }
    }
//��ȫ����գ���ȫ��Ϊ��ʼ״̬
 class ajm5 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str="";
            t2.setText(str);
            str1="";
            t1.setText(str1);
            b=0;
            ch=0;
        }
    }
///�˸�����Ը���������ֽ���һ����ɾ����������һ��ɾ��һ��
 class ajm6 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if(str.length()==0)
                t2.setText("");//�յĻ�ɾ��Ҳ�ǿգ�������ʾ�վͶ���
            
            else {
            char ss[]=str.toCharArray();//��strת��Ϊ������в���
            
            ss[str.length()-1]= 32;    //32��acsii���б�ʾΪ�ո񣬽�Ҫɾ�������ֱ�ɿո�
            str= String.valueOf(ss);//���½��������ַ���
            str=str.trim();//ɾ���ո�����������Ǹ�����û����str���ȼ�һ
            t2.setText(str);//����ʾ������֮ǰ������һ����
            //javaӦ����ֱ��ɾ���ķ���ֻ�����Ҳ��ᣬ�����ҵ�˼·�е�����
            }//��Ϊ�գ�����������ֻ�ûɾ��
        }
    }
 ///�ºţ��ղ������ĵ�һ�����������������
 class ajm7 extends panduan implements ActionListener{//�̳�pandaunΪ���࣬�Ϳ��Ե������ķ���pd
        public void actionPerformed(ActionEvent arg0) {
            int r;
            r=str1.length();
            if(r>0&&str.length()==0)//str1��Ϊ�գ�strΪ�գ�1����������������12+15  2�����������������12+15+
            {
                char a[]=str1.toCharArray();
                if(a[r-1]<48||a[r-1]>57)//����acsii�룻�ж����һ���ǲ��������
                {            
                    a[str1.length()-1]=47;
                    str1=String.valueOf(a);
                    t1.setText(str1);
                    ch=47;//�ǵĻ��Ͱ�����ɳ���/
                    return;
                }
            }
            
            if(str.length()==0)//�¿�
            {str1=new String("0");
            t2.setText("0");
            }//��ʼ״̬���£�
            str1+=str+new String("��");    //��str��������ż���str1���棬��ʾ��t1��    
            t1.setText(str1);
            this.pd(ch);//ִ����һ���������
//Ҳ����˵��12+15���㰴�¡£���ô��ִ����һ��ch��ʾ�������+��b�ͱ��27����һ����������/,��������һ��ֵ����һ�ΰ��������=ʱ����ִ��27/����һ�������ֵ
            ch=47;
            t1.setText(str1);
            str="";//��ʱstrû���ˣ����ÿշ����´�����
        }
    }
 //����7������str�ַ�������
 class ajm8 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=7;
            t2.setText(str);
        }
    }
 class ajm9 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=8;
            t2.setText(str);
        }
    }
 class ajm10 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=9;
            t2.setText(str);
        }
    } 
 ///*�������
 class ajm11 extends panduan implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            int r;
            r=str1.length();
            if(r>0&&str.length()==0)
            {
                char a[]=str1.toCharArray();
                if(a[r-1]<48||a[r-1]>57)
                {            
                    a[str1.length()-1]=42;
                    str1=String.valueOf(a);
                    t1.setText(str1);
                    ch=42;
                    return;
                }
            }//
            
            if(str.length()==0)//�¿�
            {str1=new String("1");
            t2.setText("0");
            b=1;
            }//��ʼ״̬��*��
            str1+=str+new String("*");            
            t1.setText(str1);
            this.pd(ch);//ִ����һ���������
            ch=42;
            t1.setText(str1);
            str="";
            
        }
    }
 class ajm12 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=4;
            t2.setText(str);
        }
    }
 class ajm13 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=5;
            t2.setText(str);
        }
    }
 class ajm14 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=6;
            t2.setText(str);
        }
    }
 //�����������
 class ajm15 extends panduan implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            
            int r;
            r=str1.length();
            if(r>0&&str.length()==0)
            {
                char a[]=str1.toCharArray();
                if(a[r-1]<48||a[r-1]>57)
                {            
                    a[str1.length()-1]=45;
                    str1=String.valueOf(a);
                    t1.setText(str1);
                    ch=45;
                    return;
                }
            }//
            
            if(str.length()==0)//�¿�
            {str1=new String("0");
            t2.setText("0");
            }//��ʼ״̬��-��
            str1+=str+new String("-");            
            t1.setText(str1);
            this.pd(ch);//ִ����һ���������
            ch=45;
            t1.setText(str1);
            str="";
        
        }
    }
 class ajm16 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=1;
            t2.setText(str);
        }
    }
 class ajm17 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=2;
            t2.setText(str);
        }
    }
 class ajm18 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=3;
            t2.setText(str);
        }
    }
 ///�Ӻ���ǰ������
 class ajm19 extends panduan implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {        
            int r;
            r=str1.length();
            if(r>0&&str.length()==0)
            {
                char a[]=str1.toCharArray();
                if(a[r-1]<48||a[r-1]>57)
                {            
                    a[str1.length()-1]=43;
                    str1=String.valueOf(a);
                    t1.setText(str1);
                    ch=43;
                    return;
                }
            }/////��������������������Ž��в���        
            if(str.length()==0)//�¿�
                {str1=new String("0");
                t2.setText("0");
                }//��ʼ״̬��+��        
            str1+=str+new String("+");            
            t1.setText(str1);
            this.pd(ch);//ִ����һ���������
            ch=43;
            t1.setText(str1);
            str="";
        }
    }
///����ת��������ǰ��%
 class ajm20 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if(str.length()==0)
            {
            t1.setText(str1);
            double t=-b;
            str=String.valueOf(t);
            t1.setText(str1);
            t2.setText(str);
            }
        else {
            double dd=Double.parseDouble(str);
            str= String.valueOf(-dd);
            t1.setText(str1);
            t2.setText(str);
        }
        }
    }
 class ajm21 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=0;
            t2.setText(str);
        }
    }
 class ajm22 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str+=".";
            t2.setText(str);
        }
    }
 //�ȺŵĲ���
 class ajm23 extends panduan implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            int r;
            r=str1.length();
            if(r>0&&str.length()==0)//����ǰ�棻�������ﲻ�Ƕ�ch�������¸�ֵ������ֱ�����b
            {
                char a[]=str1.toCharArray();
                if(a[r-1]<48||a[r-1]>57)
                {            
                    t1.setText("0");
                    t2.setText(String.valueOf(b));
                    return;
                }
            }    
            this.pd(ch);
            t1.setText("0");
            str1="";
            str="";
            ch=0;
        }//���ں�֮��ȫ����0�����س�ʼ״̬
    }
    public static void main(String[] args) {//������
        jisuanqi s=new jisuanqi();
        s.kuangjia();//ֱ�Ӷ�������Ķ��󣬵��÷������Զ�ִ����
    }
}