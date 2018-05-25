import javax.swing.*;
public class AppointmentsReader
{  private String input;
    private String input1;
    private int time=-1;

    public char readCommand(String message)
    {  char a='a';

        input1 = JOptionPane.showInputDialog(message);
        if(input1 ==null )
        {System.exit(0);}
        if (   input1.length() > 0) {
            input1=input1.trim().toUpperCase();
            a = input1.charAt(0);
        }

        return a;
    }
    public String readDay(String message)
    {  String a="";
        input=JOptionPane.showInputDialog(message);
        if(input ==null ){System.exit(0);}
        if( input.length()>1){
            input=input.trim().toUpperCase();
            a=input.substring(0,2);
        }
        return a;

    }
    public int readTime()
    {  if(input.length()>0){
        String s=input.substring(2,input.length());
        s=s.trim();
        if(s.length()>0)
        { try {
            time=new Integer(s).intValue();
        } catch (NumberFormatException e) {
        }

        }
    }
        return time;
    }}