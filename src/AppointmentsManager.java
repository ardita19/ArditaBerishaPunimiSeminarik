public class AppointmentsManager

{ public static void main(String[] args)
{
    AppointmentsReader reader = new AppointmentsReader();
    AppointmentsModel model = new AppointmentsModel();
    AppointmentsWritter writter = new AppointmentsWritter("Appointments");
    AppointmentsController controller =
            new AppointmentsController(reader, model,writter);

    controller.proccesing();
}
}