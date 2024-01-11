import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    private static final String HOST = "localhost";
    private static final int PUERTO = 12345;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket(HOST, PUERTO);
            System.out.println("PROGRAMA CLIENTE INICIADO...");

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Genera un identificador único para el cliente
            String idCliente = "CLIENTE-" + System.currentTimeMillis();

            System.out.print("SOY EL " + idCliente + "\nIntroduce identificador a consultar (para salir): ");

            while (true) {
                String idProfesor = scanner.nextLine();
            
                outputStream.writeObject(idProfesor);
                Object respuesta = inputStream.readObject();
            
                if (respuesta instanceof String) {
                    String respuestaString = (String) respuesta;
                    
                    int index = respuestaString.indexOf(':');
                    if (index != -1) {
                        String numeroCliente = respuestaString.substring(7, index);
                        System.out.println("SOY EL " + numeroCliente);
                        respuestaString = respuestaString.substring(index + 1);
                    }
            
                    System.out.println(respuestaString);
                } else {
                    mostrarInformacionProfesor((Profesor) respuesta);
                }
            
                System.out.print("Introduce identificador a consultar (para salir*): ");
                if (idProfesor.equals("*")) {
                    break;
                }
            }

            System.out.println("Fin de cliente...");

            // Cierra los flujos y el socket
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void mostrarInformacionProfesor(Profesor profesor) {
        System.out.println("Nombre: " + profesor.getNombre() +
                ", Especialidad: " + profesor.getEspe().getId() + " " + profesor.getEspe().getNombreEspe());

        System.out.println("Asignaturas:");
        for (Asignatura asignatura : profesor.getAsignaturas()) {
            System.out.println(" - " + asignatura.getId() + " " + asignatura.getNombreAsig());
        }
    }
}
