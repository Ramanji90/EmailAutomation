package com.ram.emailautomation.model;

public class AutoCreationReport 
{
	Long creations;
	Long duplicates;
	Long insertions;
	
	public AutoCreationReport()
	{
		
	}

	public Long getCreations() {
		return creations;
	}

	public void setCreations(Long creations) {
		this.creations = creations;
	}

	public Long getDuplicates() {
		return duplicates;
	}

	public void setDuplicates(Long duplicates) {
		this.duplicates = duplicates;
	}

	public Long getInsertions() {
		return insertions;
	}

	public void setInsertions(Long insertions) {
		this.insertions = insertions;
	}

	@Override
	public String toString() {
		return "AutoCreationReport [creations=" + creations + ", duplicates=" + duplicates + ", insertions="
				+ insertions + "]";
	}
	
	

}