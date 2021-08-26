package com.Nowek.Mazurczak.Ozga.Server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Tworzy nowe polaczenie dla kazdego klienta
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class Server {
	private static ServerSocket serverSocket=null;
	
	/**
	 * Tworzy nowy socket
	 * @throws IOException
	 */
	public static void initialize() throws IOException 
	{
		serverSocket=new ServerSocket(52137);
	}
	/**
	 * Zamyka polaczenie z serverem
	 * @throws IOException
	 */
	public static void closeServer() throws IOException
	{
		serverSocket.close();
	}
	/**
	 * Metoda uruchamia nowy wontek i czeka na polaczenie
	 * @throws IOException
	 */
	public static void activeWaiting() throws IOException 
	{
		
		while(true)
		{
			ServerOperator serverOperator=new ServerOperator(serverSocket.accept());
			serverOperator.start();
			
		}
	}
}
