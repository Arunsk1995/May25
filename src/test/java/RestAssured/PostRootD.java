package RestAssured;

import java.util.ArrayList;

public class PostRootD {
	private long id;
	  
	  private CategoryD category;
	  
	  private String name;
	  
	  private ArrayList<String> photoUrls;
	  
	  private ArrayList<TagsD> tags;
	  
	  private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CategoryD getCategory() {
		return category;
	}

	public void setCategory(CategoryD category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(ArrayList<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public ArrayList<TagsD> getTags() {
		return tags;
	}

	public void setTags(ArrayList<TagsD> tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	  
}
