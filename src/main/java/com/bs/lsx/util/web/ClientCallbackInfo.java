package com.bs.lsx.util.web;


import org.apache.log4j.Logger;


public class ClientCallbackInfo
{
	private static final Logger logger = Logger.getLogger(ClientCallbackInfo.class);
	
	protected int callbackType;
	
	protected String openURL;

	public int getCallbackType()
	{
		return callbackType;
	}

	public void setCallbackType(int callbackType)
	{
		this.callbackType = callbackType;
	}

	public String getOpenURL()
	{
		return openURL;
	}

	public void setOpenURL(String openURL)
	{
		this.openURL = openURL;
	}
}
