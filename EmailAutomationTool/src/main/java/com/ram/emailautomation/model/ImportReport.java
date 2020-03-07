package com.ram.emailautomation.model;

public class ImportReport 
{

	private Long insertions;
	private Long duplicates;

	public ImportReport()
	{
		
	}

	public Long getInsertions() {
		return insertions;
	}

	public void setInsertions(Long insertions) {
		this.insertions = insertions;
	}

	public Long getDuplicates() {
		return duplicates;
	}

	public void setDuplicates(Long duplicates) {
		this.duplicates = duplicates;
	}

	@Override
	public String toString() {
		return "ImportReport[insertions=" + insertions + ", duplicates=" + duplicates + "]";
	}
}
