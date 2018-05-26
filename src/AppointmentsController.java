/**
 * Created by LED-COM on 5/23/2018.
 */
import javax.swing.*;
public class AppointmentsController
{
    private AppointmentsReader reader;
    private AppointmentsModel model;
    private AppointmentsWritter writter;
    private String[] appointments;
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
                if(model.returnDayIndex(day)!=-1) {
                    int hour = reader.readTime();
                    boolean isvalid = model.check(model.returnDayIndex(day), hour);
                    if (isvalid) {
                        boolean isavailable = model.insert(model.returnDayIndex(day), hour);
                        if (!isavailable) {
                            writter.error("The date given is already chosen");
                        }
                    }
                    else
                    {writter.error("The given time is not during the working hours");}
                }
                else{writter.error("Error: Invalid input format");}
            break;
            }
            case 'L':
            {
                String day=reader.readDay("Write the first two letters of the day that you want to list");

                if(model.returnDayIndex(day)!=-1){
                    int daynumber=model.returnDayIndex(day);
                    model.dayName();
                    listforday=model.listing(daynumber);
                    writter.print(listforday,"","","","","","");
                }
                else{writter.error("Error: Invalid Day");}

                break;
            }
            case 'D':
            {
                String day=reader.readDay("Write the first two letters of the day and the hour during 8-16 that you want to delete (EX: MO12)");
                if(model.returnDayIndex(day)!=-1){

                    int hour=reader.readTime();
                    if(model.check(model.returnDayIndex(day),hour)){
                        boolean a=model.delete(model.returnDayIndex(day),hour);
                        if(!a){writter.error("The given time is already not in the list");}
                    }
                    else{writter.error("The time given is not during the working hours");}
                }

                else{writter.error("Error: Invalid input format");}
                break;
            }
            case 'P':
            {   model.dayName();
                appointments=model.getPrintingValues();
                writter.print(appointments[0],appointments[1],appointments[2],appointments[3],appointments[4],appointments[5],appointments[6]);
                break;

            }
            default :
            {
                writter.error("ERROR.Invalid command given");
            }
        }
        this.proccesing();
    }
    }




