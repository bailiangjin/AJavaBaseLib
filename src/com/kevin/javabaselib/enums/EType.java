package com.kevin.javabaselib.enums;

public enum EType
{
	FAIL(-1), SENDING(0), SERVER_RECEIVEED(1), TARGET_RECEIVEED(2), TARGET_READED(3), CANCELED(4);

	public int value;

	EType(int value)
	{
		this.value = value;
	}

}
