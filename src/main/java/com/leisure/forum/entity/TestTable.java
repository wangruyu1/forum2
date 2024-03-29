package com.leisure.forum.entity;

import javax.persistence.*;

/**
 * 测试集成通用mapper和分页用的表
 * 
 * @author 王如雨
 *
 */
@Table(name = "test_table")
@Deprecated
public class TestTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
}