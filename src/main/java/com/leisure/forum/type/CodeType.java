package com.leisure.forum.type;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午2:51:35
 */
public interface CodeType {
	// exception
	/**
	 * 参数错误
	 */
	int PARAM_ERROR = 1;
	/**
	 * 未知异常
	 */
	int UNKNOW_EXCEPTION = -1;

	// http返回信息
	/**
	 * 操作成功
	 */
	int OPERATION_SUCCESS = 1;
	/**
	 * 操作失败
	 */
	int OPERATION_FAILED = -1;
}
