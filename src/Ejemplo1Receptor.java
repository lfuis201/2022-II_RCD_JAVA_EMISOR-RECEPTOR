import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Ejemplo1Receptor {
	
	public static void main (String[] args){
		
		System.out.print("Introduce el puerto: \n");
	 	
	 	Scanner sc = new Scanner(System.in);
	 	
		int puerto = sc.nextInt();
		
		final int MAX_LON = 450;

		try{
			
			System.out.print("Servidor encendido \n");
		 	
			
			DatagramSocket miSocket = new DatagramSocket(puerto);
			byte[] almacen = new byte[MAX_LON];
			
			DatagramPacket datagrama = new DatagramPacket(almacen, MAX_LON);
			miSocket.receive(datagrama);
			String mensaje = new String(almacen);
			System.out.println(mensaje);
			miSocket.close();
			
			System.out.print("Servidor apagado \n");

		}catch (Exception ex ){
			ex.printStackTrace();
		}		
	}
}