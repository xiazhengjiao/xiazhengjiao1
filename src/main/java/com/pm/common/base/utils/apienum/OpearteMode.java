package com.pm.common.base.utils.apienum;

public enum OpearteMode {
	Normal(1), New(2), Modifed(3), Deleted(4), Temp(5);

	public final int status;

	OpearteMode(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
}


