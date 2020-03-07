package com.ram.emailautomation.model;

import java.util.Arrays;

public class UpdateAssignRecordsDTO 
{

	private long[] ids;
	private String user;
	
	public UpdateAssignRecordsDTO()
	{
		
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UpdateAssignRecordsDTO [ids=" + Arrays.toString(ids) + ", user=" + user + "]";
	}
	
	
}
