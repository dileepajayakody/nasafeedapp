package org.msc.cse.nasa.feed.result;

public class NasaFeedResult {
	
	String status;
	int count;
	int count_total;
	int pages;
	Posts[] posts;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCount_total() {
		return count_total;
	}
	public void setCount_total(int count_total) {
		this.count_total = count_total;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Posts[] getPosts() {
		return posts;
	}
	public void setPosts(Posts[] posts) {
		this.posts = posts;
	}
	
	

}
