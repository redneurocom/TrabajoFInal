import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Datos del paciente
        String[] nombresPacientes = new String[100];
        String[] apellidosPacientes = new String[100];
        boolean[] sexoPacientes = new boolean[100]; // true = hombre, false = mujer
        int[] dniPacientes = new int[100];
        String[] fechaNacimientoPacientes = new String[100];
        int[] numeroContactoPacientes = new int[100];
        String[] emailPacientes = new String[100];
        String[] especialidades = {"Cardiología", "Dermatología", "Pediatría", "Neurología"};
        String[][] doctores = {
                {"Dr. Carrion Perez", "Dr. Lopez Martinez", "Dr. Garcia Fernandez", "Dr. Sanchez Ruiz", "Dr. Diaz Gomez"},
                {"Dr. Torres Hernandez", "Dr. Ramirez Jimenez", "Dr. Flores Morales", "Dr. Rivera Ortiz", "Dr. Gomez Castro"},
                {"Dr. Romero Chavez", "Dr. Herrera Mendoza", "Dr. Vargas Soto", "Dr. Castillo Delgado", "Dr. Guzman Ramos"},
                {"Dr. Mendoza Cruz", "Dr. Soto Ortiz", "Dr. Delgado Morales", "Dr. Ramos Herrera", "Dr. Castro Romero"}
        };
        String[] fechasDisponibles = {"01/12/2024", "02/12/2024", "03/12/2024", "04/12/2024", "05/12/2024"};
        String[][] horasDisponibles = {
                {"09:00", "10:00", "11:00", "14:00", "15:00"},
                {"09:00", "10:00", "11:00", "14:00", "15:00"},
                {"09:00", "10:00", "11:00", "14:00", "15:00"},
                {"09:00", "10:00", "11:00", "14:00", "15:00"}
        };
        String[][] citas = new String[100][6]; // bidimensional con Max 100 citas con 6 atributos
        int totalCitas = 0;

        Scanner scanner = new Scanner(System.in);

        // Menú principal
        int opcion;
        //bucle do - while
        do {
            System.out.println("Sistema de Gestión de Consultas Médicas");
            System.out.println("1. Reservar Cita");
            System.out.println("2. Verificar Citas");
            System.out.println("3. Actualizar Estado de Cita");
            System.out.println("4. Generar Reporte de Producción");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                //Menu Reservar Cita
                case 1:
                    if (totalCitas < citas.length) {
                        System.out.println("Reservar Cita");


                        System.out.print("Ingrese el nombre del paciente: ");
                        nombresPacientes[totalCitas] = scanner.nextLine();

                        System.out.print("Ingrese el apellido del paciente: ");
                        apellidosPacientes[totalCitas] = scanner.nextLine();

                        System.out.print("Ingrese el sexo del paciente (1 para hombre, 0 para mujer): ");
                        sexoPacientes[totalCitas] = scanner.nextInt() == 1;
                        scanner.nextLine();

                        System.out.print("Ingrese el DNI del paciente: ");
                        dniPacientes[totalCitas] = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese la fecha de nacimiento del paciente (dd/mm/yyyy): ");
                        fechaNacimientoPacientes[totalCitas] = scanner.nextLine();

                        System.out.print("Ingrese el número de contacto principal del paciente: ");
                        numeroContactoPacientes[totalCitas] = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el email del paciente: ");
                        emailPacientes[totalCitas] = scanner.nextLine();


                        System.out.println("Especialidades disponibles:");
                        for (int i = 0; i < especialidades.length; i++) {
                            System.out.println((i + 1) + ". " + especialidades[i]);
                        }
                        System.out.print("Seleccione una especialidad: ");
                        int especialidadSeleccionada = scanner.nextInt();
                        scanner.nextLine();

                        if (especialidadSeleccionada < 1 || especialidadSeleccionada > especialidades.length) {
                            System.out.println("Opción inválida. Inténtelo nuevamente.");
                            break;
                        }
                        citas[totalCitas][0] = especialidades[especialidadSeleccionada - 1];

                        // Selección del medico
                        System.out.println("Doctores disponibles:");
                        for (int i = 0; i < doctores[especialidadSeleccionada - 1].length; i++) {
                            System.out.println((i + 1) + ". " + doctores[especialidadSeleccionada - 1][i]);
                        }
                        System.out.print("Seleccione un doctor: ");
                        int doctorSeleccionado = scanner.nextInt();
                        scanner.nextLine();

                        if (doctorSeleccionado < 1 || doctorSeleccionado > doctores[especialidadSeleccionada - 1].length) {
                            System.out.println("Opción inválida. Inténtelo nuevamente.");
                            break;
                        }
                        citas[totalCitas][1] = doctores[especialidadSeleccionada - 1][doctorSeleccionado - 1];

                        //Seleccionar dia de cita
                        int fechaSeleccionada;
                        do {
                            System.out.println("Fechas disponibles para la cita:");
                            for (int i = 0; i < fechasDisponibles.length; i++) {
                                System.out.println((i + 1) + ". " + fechasDisponibles[i]);
                            }
                            System.out.print("Seleccione una fecha: ");
                            fechaSeleccionada = scanner.nextInt();
                            scanner.nextLine();

                            if (fechaSeleccionada < 1 || fechaSeleccionada > fechasDisponibles.length) {
                                System.out.println("Opción inválida. Inténtelo nuevamente.");
                            }
                        } while (fechaSeleccionada < 1 || fechaSeleccionada > fechasDisponibles.length);

                        citas[totalCitas][2] = fechasDisponibles[fechaSeleccionada - 1];

                        //Seleccionar hora de cita
                        int horaSeleccionada;
                        do {
                            System.out.println("Horas disponibles para la cita:");
                            for (int i = 0; i < horasDisponibles[doctorSeleccionado - 1].length; i++) {
                                System.out.println((i + 1) + ". " + horasDisponibles[doctorSeleccionado - 1][i]);
                            }
                            System.out.print("Seleccione una hora: ");
                            horaSeleccionada = scanner.nextInt();
                            scanner.nextLine();

                            if (horaSeleccionada < 1 || horaSeleccionada > horasDisponibles[doctorSeleccionado - 1].length) {
                                System.out.println("Opción inválida. Inténtelo nuevamente.");
                            }
                        } while (horaSeleccionada < 1 || horaSeleccionada > horasDisponibles[doctorSeleccionado - 1].length);

                        citas[totalCitas][3] = horasDisponibles[doctorSeleccionado - 1][horaSeleccionada - 1];
                        citas[totalCitas][4] = "Pendiente";
                        citas[totalCitas][5] = "CITA" + (totalCitas + 1); //Codigo secuencial de cita
                        totalCitas++;

                        System.out.println("¡Cita reservada exitosamente! Código de cita: " + citas[totalCitas - 1][5] + ". Costo: $50");
                    } else {
                        System.out.println("No se pueden reservar más citas.");
                    }
                    break;
                //Menu verificacion de citas
                case 2:
                    System.out.println("Verificar Citas");
                    System.out.print("Ingrese el código de la cita: ");
                    String codigoCita = scanner.nextLine();
                    boolean citaEncontrada = false;
                    for (int i = 0; i < totalCitas; i++) {
                        if (citas[i][5].equals(codigoCita)) {
                            System.out.println("Paciente: " + nombresPacientes[i] + " " + apellidosPacientes[i]);
                            System.out.println("Sexo: " + (sexoPacientes[i] ? "Hombre" : "Mujer"));
                            System.out.println("DNI: " + dniPacientes[i]);
                            System.out.println("Fecha de Nacimiento: " + fechaNacimientoPacientes[i]);
                            System.out.println("Número de Contacto: " + numeroContactoPacientes[i]);
                            System.out.println("Email: " + emailPacientes[i]);
                            System.out.println("Especialidad: " + citas[i][0]);
                            System.out.println("Médico: " + citas[i][1]);
                            System.out.println("Fecha: " + citas[i][2]);
                            System.out.println("Hora: " + citas[i][3]);
                            System.out.println("Estado: " + citas[i][4]);
                            citaEncontrada = true;
                            break;
                        }
                    }
                    if (!citaEncontrada) {
                        System.out.println("Cita no encontrada.");
                    }
                    break;
                //Menu Actualizar estado de cita
                case 3:
                    System.out.println("Actualizar Estado de Cita");
                    System.out.print("Ingrese el código de la cita a actualizar: ");
                    codigoCita = scanner.nextLine();
                    citaEncontrada = false;
                    for (int i = 0; i < totalCitas; i++) {
                        if (citas[i][5].equals(codigoCita)) {
                            System.out.println("Estados disponibles: ");
                            System.out.println("1. Pendiente");
                            System.out.println("2. Confirmada");
                            System.out.println("3. Cancelada");
                            System.out.println("4. Atendida"); //Solo las citas atendidas suman ingresos
                            System.out.print("Seleccione el nuevo estado: ");
                            int nuevoEstado = scanner.nextInt();
                            scanner.nextLine();

                            switch (nuevoEstado) {
                                case 1:
                                    citas[i][4] = "Pendiente";
                                    break;
                                case 2:
                                    citas[i][4] = "Confirmada";
                                    break;
                                case 3:
                                    citas[i][4] = "Cancelada";
                                    break;
                                case 4:
                                    citas[i][4] = "Atendida";
                                    break;
                                default:
                                    System.out.println("Estado inválido.");
                            }
                            System.out.println("Estado actualizado correctamente.");
                            citaEncontrada = true;
                            break;
                        }
                    }
                    if (!citaEncontrada) {
                        System.out.println("Cita no encontrada.");
                    }
                    break;
                //Menu Generar reporte de produccion
                case 4:
                    System.out.println("Generar Reporte de Producción de Citas");
                    int[] citasPorEspecialidad = new int[especialidades.length];
                    int[][] citasPorDoctor = new int[especialidades.length][5];
                    int[] citasPorEstado = new int[4]; // Pendiente, Confirmada, Cancelada, Atendida
                    int[] ingresosPorDoctor = new int[especialidades.length * 5];
                    int totalIngresos = 0;
                    for (int i = 0; i < totalCitas; i++) {
                        for (int j = 0; j < especialidades.length; j++) {
                            if (citas[i][0].equals(especialidades[j])) {
                                citasPorEspecialidad[j]++;
                                for (int k = 0; k < doctores[j].length; k++) {
                                    if (citas[i][1].equals(doctores[j][k])) {
                                        citasPorDoctor[j][k]++;
                                        // Sumar ingresos si la cita está atendida
                                        if (citas[i][4].equals("Atendida")) {
                                            ingresosPorDoctor[j * 5 + k] += 50;
                                            totalIngresos += 50;
                                        }
                                    }
                                }
                            }
                        }
                        switch (citas[i][4]) {
                            case "Pendiente":
                                citasPorEstado[0]++;
                                break;
                            case "Confirmada":
                                citasPorEstado[1]++;
                                break;
                            case "Cancelada":
                                citasPorEstado[2]++;
                                break;
                            case "Atendida":
                                citasPorEstado[3]++;
                                break;
                        }
                    }
                    System.out.println("Producción por Especialidad:");
                    for (int i = 0; i < especialidades.length; i++) {
                        System.out.println(especialidades[i] + ": " + citasPorEspecialidad[i] + " citas");
                        for (int j = 0; j < doctores[i].length; j++) {
                            System.out.println("   " + doctores[i][j] + ": " + citasPorDoctor[i][j] + " citas, Ingresos: $" + ingresosPorDoctor[i * 5 + j]);
                        }
                    }
                    System.out.println("Resumen de Citas por Estado:");
                    System.out.println("Pendiente: " + citasPorEstado[0]);
                    System.out.println("Confirmada: " + citasPorEstado[1]);
                    System.out.println("Cancelada: " + citasPorEstado[2]);
                    System.out.println("Atendida: " + citasPorEstado[3]);
                    System.out.println("Total de Ingresos por Citas Atendidas: $" + totalIngresos);
                    break;
                //Menu Salir
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5); // bucle termina cuando la opcion es igual a 5 (salir)

        scanner.close();
    }
}