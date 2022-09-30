import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Ejemplo1Receptor {
	
	public static void main (String[] args){
		
		
		System.out.print("Introduce el puerto: \n");
	 	
		//Creamos el scaner para recibir el input del usuario
	 	Scanner sc = new Scanner(System.in);
	 	
	 	//creamos la variable puerto de tipo int
		int puerto = sc.nextInt();
		
		// creamos la variable MAX_LON que sera el tamaño del buffer en relacion a
		// n caracteres
		
		final int MAX_LON = 450;

		try{
			
			System.out.print("Servidor encendido \n");
		 	
			// creamos el primer datagram con el puerto como parametro
			DatagramSocket miSocket = new DatagramSocket(puerto);
			
			// creamos el almacenamiento para el mensaje y se le asigna el tamaño
			// determinado en la variable MAX_LON
			
			byte[] almacen = new byte[MAX_LON];
			
			// creamos el segundo datagaram con el almacenamiento y tamaño MAX_LON
			// como parametros
			DatagramPacket datagrama = new DatagramPacket(almacen, MAX_LON);
			
			// recibimos el datamgram en misocket
			miSocket.receive(datagrama);
			
			//asignamos la variable mensaje con el almacenamiento
			String mensaje = new String(almacen);
			
			//imprimimos el mensaje
			System.out.println(mensaje);
			
			//cerramos el socket e imprimimos que el servidor esta apagado
			miSocket.close();
			
			System.out.print("Servidor apagado \n");

		}catch (Exception ex ){
			ex.printStackTrace();
		}		
	}
}