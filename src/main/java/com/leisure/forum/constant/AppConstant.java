package com.leisure.forum.constant;

public interface AppConstant {
	// menu
	/**
	 * 子菜单分隔符
	 */
	String SUB_MENU_DELIMITER = ",";
	/**
	 * 跟菜单parent_id
	 */
	Long ROOT_MENU_PARENT_ID = -1l;
	// exchange topic
	/**
	 * 交流区主题分页大小
	 */
	Integer EXCHAGE_TOPIC_PAGE_SIZE = null;

	// topic
	/**
	 * 删除状态
	 */
	Integer TOPIC_DELETED_STATUS = -1;
	/**
	 * 有效状态
	 */
	Integer TOPIC_AVILIABLE_STATUS = 1;
	// 交流区回复pagesize
	/**
	 * 返回数据数量
	 */
	Integer EXCHANGE_REPLY_PAGE_SIZE = 30;
	/**
	 * 回复删除状态
	 */
	Integer REPLY_DELETED_STATUS = -1;
	/**
	 * 回复可用状态
	 */
	Integer REPLY_AVILIABLE_STATUS = -1;
}
