package org.msc.cse.nasa.feed.result;

public class Posts {
	
	int id;
	String slug;
	String url;
	String title;
	String title_plain;
	String content;
	String excerpt;
	String date;
	String modified;
	Categories[] categories;
	Tags[] tags;
	CustomFields custom_fields;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle_plain() {
		return title_plain;
	}
	public void setTitle_plain(String title_plain) {
		this.title_plain = title_plain;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExcerpt() {
		return excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public Categories[] getCategories() {
		return categories;
	}
	public void setCategories(Categories[] categories) {
		this.categories = categories;
	}
	public Tags[] getTags() {
		return tags;
	}
	public void setTags(Tags[] tags) {
		this.tags = tags;
	}
	public CustomFields getCustom_fields() {
		return custom_fields;
	}
	public void setCustom_fields(CustomFields custom_fields) {
		this.custom_fields = custom_fields;
	}
	
	

}
