package org.btm.lightApp;

public class TubeLightImpl implements ISwitch
{
	//Implementation Logic
	@Override
	public void SOn()
	{
		System.out.println("TubeLight Turn On");
	}

	@Override
	public void SOff() {
		System.out.println("TubeLight Turn Off");
	}
	
}
