package com.springboot.userinfosys.payload;

import java.util.List;

public class UserResponse {
	private List<UserDto> content;
	private int pageNo;
	private int pageSize;
	private int totalElements;
	private int totalPages;
	private boolean last;
	
	public UserResponse(List<UserDto> content, int pageNo, int pageSize, int totalElements, int totalPages, boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}
	
	public UserResponse() {
		super();
	}
	

	public List<UserDto> getContent() {
		return content;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public boolean isLast() {
		return last;
	}

	public void setContent(List<UserDto> content) {
		this.content = content;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setLast(boolean last) {
		this.last = last;
	}
	

}
