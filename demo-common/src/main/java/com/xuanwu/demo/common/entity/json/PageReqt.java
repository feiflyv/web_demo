/*
 * Copyright (c) 2015 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package com.xuanwu.demo.common.entity.json;

import java.util.Map;

/**
 * @Description 分页请求
 * @author Beck Wu
 * @Data 2015年4月27日
 * @Version 1.0.0
 */
public class PageReqt {

	/** 页码：1 ~ n */
	private Integer page;
	
	/** 每页大小 */
	private Integer count;
	
	/** 查询参数 */
	private Map<String, Object> params;
	
	/** 排序参数 */
	private Map<String, String> sorts;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public Map<String, Object> getParams() {
		return params;
	}
	
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	public Map<String, String> getSorts() {
		return sorts;
	}
	
	public void setSorts(Map<String, String> sorts) {
		this.sorts = sorts;
	}
}
