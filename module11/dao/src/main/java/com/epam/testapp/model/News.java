package com.epam.testapp.model;

import java.io.Serializable;
import java.util.Date;


public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * field that contains unique identification number of news item.
	 */
	private Integer id;

	/**
	 * field that contains title of news.
	 */
	private String title;

	/**
	 * field that contains date of news.
	 */
	private Date postDate;

	/**
	 * field that contains short description of news.
	 */
	private String brief;

	/**
	 * field that contains full content of news item.
	 */
	private String content;

	/**
	 * Constructor with all class' fields as a parameters
	 * 
	 * @param id
	 *            contains unique identification number of news item.
	 * @param title
	 *            contains title of news.
	 * @param postDate
	 *            contains date of news.
	 * @param brief
	 *            contains short description of news.
	 * @param content
	 *            contains full content of news item.
	 */
	public News(Integer id, String title, Date postDate, String brief,
			String content) {
		this.id = id;
		this.title = title;
		this.postDate = postDate;
		this.brief = brief;
		this.content = content;
	}

	/**
	 * Default constructor
	 */
	public News() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Override method toString for current entity
	 */
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", postDate=" + postDate
				+ ", brief=" + brief + ", content=" + content + "]";
	}

	/**
	 * Override method hashCode for current entity
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((postDate == null) ? 0 : postDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Override method equals for current entity
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (postDate == null) {
			if (other.postDate != null)
				return false;
		} else if (!postDate.equals(other.postDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
