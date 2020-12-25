package org.btm.lightApp;

public class LEDLightImple implements ISwitch {

	//Implementation Logic
	@Override
	public void SOn() {
		System.out.println("LED Light Turned On");
	}

	@Override
	public void SOff() {
		System.out.println("LED Light Turned Off");
	}

}
