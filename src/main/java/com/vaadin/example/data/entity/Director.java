package com.vaadin.example.data.entity;

public class Director {

	private Long id;
	private String name;

	public Director() {

	}

	public Director(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
