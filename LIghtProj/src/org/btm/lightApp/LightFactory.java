package org.btm.lightApp;

public class LightFactory {
	
	public static ISwitch getLight(String type)
	{
		if(type.equalsIgnoreCase("LedLight"))
			return new LEDLightImple();
		if(type.equalsIgnoreCase("tubeLight"))
			return new TubeLightImpl();
		else
		{
			System.out.println("No Such Light Found");
			return null;
		}
		
	}

}
