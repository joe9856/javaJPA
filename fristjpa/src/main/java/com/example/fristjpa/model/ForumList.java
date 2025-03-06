package com.example.fristjpa.model;

import java.util.List;

public class ForumList {
	
	private List<Forum> forum;

	public List<Forum> getForum() {
		return forum;
	}

	public void setForum(List<Forum> forum) {
		this.forum = forum;
	}

	public ForumList(List<Forum> forum) {
		super();
		this.forum = forum;
	}
}
