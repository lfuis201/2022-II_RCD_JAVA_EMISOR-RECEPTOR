import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Ejemplo1Emisor {

	public static void main (String[] args) {
		
		//Creamos el scaner para recibir el input del usuario
		Scanner sc = new Scanner(System.in);
		
		//creamos las variables: ip, puerto y mensaje
		
		String ip;
		int puerto;
		String mensaje;
		
		//Pedimos al usuario que igrese su mensaje
		System.out.println ("Ingrese el mensaje: ");
		
		//recibimos el mensaje del usuario
		mensaje = sc.nextLine();
		
		//Pedimos al usuario que igrese la ip del servidor
		System.out.println ("Ingrese la ip: ");
		
		//recibimos la ip del servidor
		ip = sc.nextLine();
		
		//Pedimos al usuario que igrese el puerto del servidor
		System.out.println ("Ingrese el puerto: ");
		
		//recibimos el puerto el servidor
		puerto = sc.nextInt();
	
	
		try{
			
			
			//Determinamos la ip del servidor con el metodo "getbyname"
			InetAddress maRe = InetAddress.getByName(ip);
			
			// Creamos un nuevo datagram
			DatagramSocket miSocket = new DatagramSocket();
			
			//Determinamos el mensaje 
			byte[] almacen = mensaje.getBytes();
			
			// Creamos un nuevo datagram con los parametros establecidos previamente
			DatagramPacket datagrama = new DatagramPacket(almacen, almacen.length, maRe, puerto);

			// enviamos el datagrama
			miSocket.send(datagrama);
			
			// cerramos el datagrama
			miSocket.close();
			
			System.out.println ("Se enviado el mensaje correctamente");
			
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}