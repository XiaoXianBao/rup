package calculator;  //包名，根据自己创建的项目而定
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;//按键
import javax.swing.JFrame;//显示窗口
import javax.swing.JTextField;//文本框
import javax.swing.WindowConstants;

public class jisuanqi extends JFrame {        ///主类show继承父类JFrame
    private String[] ajm= {                "%","√","X^2","1/X",
                            "ce","c","<<<","÷",
                            "7","8","9","*",
                            "4","5","6","－",
                            "1","2","3","+",
                            "+/-","0",".","="    };
    private JButton Ajm[]=new JButton[ajm.length];//按键数组0-23
    public JTextField t1=new JTextField();
    public JTextField t2=new JTextField();//创建两个文本款用于显示输入以及计算结果的情况
    String str="";    //存储输入的值，显示在下面文本框t2
    String str1="";    //存储所有点击按键的结果显示于上面的文本框t1
    double b=0;    //存储计算结果用于下一步的计算
    char ch=0;    //存储运算符号用于下一步的计算
    public    void kuangjia() {
        java.awt.Container c=getContentPane(); //容器
        this.setTitle("计算器");//标题
        this.setVisible(true);//表示可显示
        setLayout(null);
        setBounds(1000, 100,620, 900);//弹出宽高的大小，弹出的位置，左上角为00
            
        for(int i=0;i<ajm.length;i++)
            Ajm[i]=new JButton(ajm[i]);
        //建立按键
        int begin=0;
        int bend=250;
        for(int i=0;i<ajm.length;)//设计按键位置即界面显示效果
            {    int j=0;    
                while(j<4)///搞定一行换一行
                    {
                    Ajm[i].setBounds(begin, bend, 150, 100);//按键的大小
                    Ajm[i].setFont(new java.awt.Font("宋体", Font.BOLD, 45));//按键显示的字体属性
                    c.add(Ajm[i]);//加入容器
                    i++;j++;
                    begin+=150;//根据窗口大小调整按键的位置
                    }
            begin=0;bend+=100;
            };
        for(int i=8;i<19;i++)///设置数字按键的颜色为白
        { 
            if(i==11||i==15)
                i++;
            Ajm[i].setBackground(Color.white);
        }
        Ajm[21].setBackground(Color.white);//由于0号键位置特殊，所以单独设置
        
////////////上下两个文本框的属性设置    
setLayout(null);
t1.setFont(new java.awt.Font("宋体", Font.BOLD, 40));
this.add(t1);
t1.setBounds(0,0,600,100);
t1.setEnabled(false); //只读    
t1.setText("chengjunfeng");//显示内容

this.setLayout(null);
this.add(t2);
t2.setBounds(0,99,600,155);
t2.setFont(new java.awt.Font("宋体", Font.BOLD, 60));
t2.setEnabled(false); //只读        
t2.setText("First calculator");    
///建立监视器，表示当你按下这个按键将会执行什么    
Ajm[0].addActionListener(new ajm0());//当0号键被按下，这个按键对应的就是%，将会执行ajm0这个类
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


setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭方式
    }
////这是一个有点特殊的类于加减乘除类相关，可先跳过这个类，看下面的类    
class panduan{
    public void pd(char a) {
        if(a==0)//表示没有按运算键
            if(str.length()==0)
                b=0;//而且没有输入值，如直接按等于号，
            else
                b=Double.parseDouble(str);//有输入值按等于号
        else
            //考虑ch=加减乘除的四种情况，b作为计算结果显示在下面的文本框
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
                t2.setText("除数不能为0");
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
                }//当什么都没有输入直接按的情况    
            else if(str.length()==0)
                {
                t1.setText(str1);
                double t=b*b/100;
                str=String.valueOf(t);
                t1.setText(str1);
                t2.setText(str);
                }//有一定的输入后，即按了运算符号后还没输入值的情况，即对b进行操作
                //12+12+这时候按下后应当是对24进行操作
            else {
                double dd=Double.parseDouble(str);
                dd=b*dd/100;
                str=String.valueOf(dd);
                t1.setText(str1);
                t2.setText(str);
            }///否则则是对正使用下对输入值的转变24 变0.24
            }
        }    
//√取开方 4√=2
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
 ///取平方
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
///ce  str清空 ，t2没显示
 class ajm4 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            str="";
            t2.setText(str);
        
        }
    }
//把全部清空，即全部为初始状态
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
///退格键，对刚输入的数字进行一个个删除操作，点一次删除一个
 class ajm6 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if(str.length()==0)
                t2.setText("");//空的话删了也是空，所以显示空就对了
            
            else {
            char ss[]=str.toCharArray();//将str转化为数组进行操作
            
            ss[str.length()-1]= 32;    //32在acsii码中表示为空格，将要删除的数字变成空格
            str= String.valueOf(ss);//重新将数组变成字符串
            str=str.trim();//删除空格，这样最后面那个数就没有了str长度减一
            t2.setText(str);//再显示出来比之前就少了一个，
            //java应该有直接删除的方法只不过我不会，所以我的思路有点曲折
            }//不为空，刚输入的数字还没删完
        }
    }
 ///÷号，刚才跳过的第一个类在这里就有用了
 class ajm7 extends panduan implements ActionListener{//继承pandaun为父类，就可以调用他的方法pd
        public void actionPerformed(ActionEvent arg0) {
            int r;
            r=str1.length();
            if(r>0&&str.length()==0)//str1不为空，str为空，1；你刚输入的是数字12+15  2：你刚输入的是运算符12+15+
            {
                char a[]=str1.toCharArray();
                if(a[r-1]<48||a[r-1]>57)//又是acsii码；判断最后一个是不是运算符
                {            
                    a[str1.length()-1]=47;
                    str1=String.valueOf(a);
                    t1.setText(str1);
                    ch=47;//是的话就把他变成除号/
                    return;
                }
            }
            
            if(str.length()==0)//下空
            {str1=new String("0");
            t2.setText("0");
            }//初始状态按÷，
            str1+=str+new String("÷");    //把str和运算符号加在str1后面，显示在t1，    
            t1.setText(str1);
            this.pd(ch);//执行上一个运算符；
//也就是说在12+15后你按下÷，那么就执行上一个ch表示的运算符+后，b就变成27，下一个运算符变成/,再输入下一个值，下一次按运算符或=时，就执行27/你下一个输入的值
            ch=47;
            t1.setText(str1);
            str="";//这时str没用了，就置空方便下次输入
        }
    }
 //输入7，存在str字符串后面
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
 ///*与÷类似
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
            
            if(str.length()==0)//下空
            {str1=new String("1");
            t2.setText("0");
            b=1;
            }//初始状态按*，
            str1+=str+new String("*");            
            t1.setText(str1);
            this.pd(ch);//执行上一个运算符；
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
 //减号与÷类似
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
            
            if(str.length()==0)//下空
            {str1=new String("0");
            t2.setText("0");
            }//初始状态按-，
            str1+=str+new String("-");            
            t1.setText(str1);
            this.pd(ch);//执行上一个运算符；
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
 ///加号与前面类似
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
            }/////对连续出现两个运算符号进行操作        
            if(str.length()==0)//下空
                {str1=new String("0");
                t2.setText("0");
                }//初始状态按+，        
            str1+=str+new String("+");            
            t1.setText(str1);
            this.pd(ch);//执行上一个运算符；
            ch=43;
            t1.setText(str1);
            str="";
        }
    }
///正负转换，类似前面%
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
 //等号的操作
 class ajm23 extends panduan implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            int r;
            r=str1.length();
            if(r>0&&str.length()==0)//类似前面；但是这里不是对ch进行重新赋值，而是直接输出b
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
        }//等于号之后全部归0，返回初始状态
    }
    public static void main(String[] args) {//主函数
        jisuanqi s=new jisuanqi();
        s.kuangjia();//直接定义主类的对象，调用方法就自动执行了
    }
}