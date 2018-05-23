/**
 * Created by LED-COM on 5/23/2018.
 */
import javax.swing.*;
public class AppointmentsController
{
    private AppointmentsReader reader;
    private AppointmentsModel model;
    private AppointmentsWritter writter;
    private int[][] appointments;
    private String[] output=new String[7];
    private String listforday;


    public AppointmentsController(AppointmentsReader r,AppointmentsModel m,AppointmentsWritter w)
    {
        reader=r;
        model=m;
        writter=w;
    }

    public void proccesing()
    {
        char command = reader.readCommand("Command (I,L,D,P) and amount:");

        switch(command)
        {
            case 'I':
            {
                String day=reader.readDay("Write the first two letters of the day and the hour during 8-16 that you want to insert (EX: MO12)");
                if(this.returnDay(day)!=-1){
                    int hour=reader.readTime();

                    if(model.checkinsert(this.returnDay(day),hour) ){
                        boolean isvalid=model.insert(this.returnDay(day),hour);
                        if(!isvalid)
                        {

                            writter.error("The given time is not during the working hours");

                        }
                    }
                    else{writter.error("The date given is already chosen");}


                }
                else{writter.error("Error: Invalid input format");}

            }
            break;
            case 'L':
            {
                String day=reader.readDay("Write the first two letters of the day that you want to list");
                appointments=model.getAppointments();
                if(this.returnDay(day)!=-1){
                    int daynumber=returnDay(day);
                    listforday=returnDayName(daynumber)+"     ";
                    for(int j=0;j<8;j++)
                    { if(appointments[daynumber][j]!=0){
                        listforday+=appointments[daynumber][j]+":00 ";
                    }
                    }
                    writter.print(listforday,"","","","","","");
                }
                else{writter.error("Error: Invalid Day");}

                break;
            }
            case 'D':
            {
                String day=reader.readDay("Write the first two letters of the day and the hour during 8-16 that you want to delete (EX: MO12)");
                if(this.returnDay(day)!=-1){

                    int hour=reader.readTime();
                    if(model.check(this.returnDay(day),hour)){
                        boolean a=model.delete(this.returnDay(day),hour);
                        if(!a){writter.error("The given time is already not in the list");}
                    }
                    else{writter.error("The time given is not during the working hours");}
                }

                else{writter.error("Error: Invalid input format");}

                break;
            }
            case 'P':
            {
                appointments=model.getAppointments();
                for(int i=0;i<7;i++)
                {

                    output[i]=returnDayName(i)+"       ";
                    for(int j=0;j<8;j++)
                    { if(appointments[i][j]!=0){
                        output[i]+=appointments[i][j]+":00     ";
                    }
                    }




                }
                writter.print(output[0],output[1],output[2],output[3],output[4],output[5],output[6]);
                break;

            }
            default :
            {
                writter.error("ERROR.Invalid command given");
            }

        }
        this.proccesing();
    }

    public int returnDay(String day)
    {
        int givenDay=-1;
        switch(day)
        {
            case "MO":

                givenDay=0;
                break;
            case "TU":

                givenDay=1;
                break;
            case "WE":

                givenDay=2;
                break;
            case "TH":

                givenDay=3;
                break;
            case "FR":

                givenDay=4;
                break;
            case "SA":

                givenDay=5;
                break;
            case "SU":

                givenDay=6;
                break;
            default :
            {

            }
        }
        return givenDay;
    }

    public String returnDayName(int day)
    {  String dayname="";
        switch(day)
        {
            case 0:
                dayname="MONDAY";
                break;
            case 1:
                dayname="TUESDAY";
                break;
            case 2:
                dayname="WEDNESDAY";
                break;
            case 3:
                dayname="THURSDAY";
                break;
            case 4:
                dayname="FRIDAY";
                break;
            case 5:
                dayname="SATURDAY";
                break;
            case 6:
                dayname="SUNDAY";
                break;

            default:{JOptionPane.showMessageDialog(null,"Error");}



        }
        return dayname;
    }
}

