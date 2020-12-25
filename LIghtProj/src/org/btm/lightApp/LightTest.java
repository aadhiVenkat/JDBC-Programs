package org.btm.lightApp;

import java.util.Scanner;

public class LightTest {

	public static void main(String[] args) {
		// Consumer/Utilization Logic
		Scanner sc=new Scanner(System.in);
		System.out.println("enter light type");
		String type=sc.nextLine();
		ISwitch i=LightFactory.getLight(type);
		if(i!=null)
		{
			i.SOn();
			i.SOff();
		}
	}

}
