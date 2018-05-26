import javax.swing.*;
public class AppointmentsModel
{  private boolean checkvalue;

    private int[][] appointments=new int[7][8];
    private String[] output=new String[7];
    private String[] day=new String[7];
    private String listday ="";

    public boolean check(int i,int j)
    {  boolean a=false;
        if(j>=8 && j<=16)
        {a=true;}
        return a;
    }

    public boolean insert(int i,int j)
    {  boolean a=false;
                if(appointments[i][j - 8] != j) {
                    appointments[i][j - 8] = j;

                    a = true;

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
    public int returnDayIndex(String day) {
        int givenDay = -1;
        switch (day) {
            case "MO":

                givenDay = 0;
                break;
            case "TU":

                givenDay = 1;
                break;
            case "WE":

                givenDay = 2;
                break;
            case "TH":

                givenDay = 3;
                break;
            case "FR":

                givenDay = 4;
                break;
            case "SA":

                givenDay = 5;
                break;
            case "SU":

                givenDay = 6;
                break;
            default: {

            }
        }
        return givenDay;
    }
    public void dayName()
    {
                day[0]="MONDAY";
                day[1]="TUESDAY";
                day[2]="WEDNESDAY";
                day[3]="THURSDAY";
                day[4]="FRIDAY";
                day[5]="SATURDAY";
                day[6]="SUNDAY";
    }

    public String[] getPrintingValues()
    {
        for(int i=0;i<7;i++)
        {

            output[i]=day[i]+"       ";
            for(int j=0;j<8;j++)
            { if(appointments[i][j]!=0){
                output[i]+=appointments[i][j]+":00     ";
            }
            }
        }
        return output;
    }
    public String listing (int daynumber)
    {   listday=day[daynumber]+"     ";
        for(int j=0;j<8;j++)
        { if(appointments[daynumber][j]!=0){
            listday+=appointments[daynumber][j]+":00 ";
        }
        }
        return listday;
    }
}