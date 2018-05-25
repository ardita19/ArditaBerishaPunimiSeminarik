import javax.swing.*;
public class AppointmentsModel
{  private boolean checkvalue;

    private int[][] appointments=new int[7][8];
    private String[] output=new String[7];

    public boolean check(int i,int j)
    {  boolean a=false;
        if(j>=8 && j<=16)
        {a=true;}
        return a;
    }
    public boolean checkinsert(int i,int j)
    {  checkvalue=true;
        if(j>=8 && j<=16 && i!=-1){
            for(int k=0;k<8;k++){
                if(appointments[i][k]==j)
                {
                    checkvalue=false;
                    break;
                }
            }
        }
        return checkvalue;

    }
    public boolean insert(int i,int j)
    {  boolean a=false;

        if(j>=8 && j<=16 && i!=-1){


            appointments[i][j-8]=j;

            a=true;

        }
        return a;

    }



    public boolean delete(int i,int j)
    {  boolean a=false;

        for(int k=0;k<8;k++)
        {
            if(appointments[i][k]==j)
            {
                appointments[i][k]=0;
                a=true;
            }}

        return a;
    }


   

    public int[][] getAppointments()
    {
        return appointments;
    }


}