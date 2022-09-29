import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Ejemplo1Emisor {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String ip;
		int puerto;
		String mensaje;
		
		System.out.println ("Ingrese el mensaje: ");
		
		mensaje = sc.nextLine();
		
		System.out.println ("Ingrese la ip: ");
		
		ip = sc.nextLine();
		
		System.out.println ("Ingrese el puerto: ");
		
		puerto = sc.nextInt();
		

	
		try{
			

			InetAddress maRe = InetAddress.getByName(ip);
			DatagramSocket miSocket = new DatagramSocket();
			byte[] almacen = mensaje.getBytes();
			DatagramPacket datagrama = new DatagramPacket(almacen, almacen.length, maRe, puerto);

			miSocket.send(datagrama);
			miSocket.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}