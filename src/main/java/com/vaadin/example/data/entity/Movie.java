package com.vaadin.example.data.entity;

public class Movie {

	private Long id;
	private String title;
	private Director director;
	private int releaseYear;
	private String imbdLink;

	public Movie() {
	}

	public Movie(String title, int releaseYear, String imbdLink, Director director) {
		this.title = title;
		this.releaseYear = releaseYear;
		this.imbdLink = imbdLink;
		this.director = director;
	}

	public String getTitle() {
		return title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public String getImbdLink() {
		return imbdLink;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setImbdLink(String imbdLink) {
		this.imbdLink = imbdLink;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return String.format("Movie[title= %s, producer = %d]", title, releaseYear);
	}
}
