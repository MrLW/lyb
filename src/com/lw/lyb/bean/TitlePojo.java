package com.lw.lyb.bean;
/**
 *  ����ӵ�POJO/�����
 * @author lw
 *
 */
public class TitlePojo {

	private String name ;
	private Integer count;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "TitlePojo [name=" + name + ", count=" + count + "]";
	} 
	
}
