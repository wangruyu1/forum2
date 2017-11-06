package com.leisure.forum.servie.base;

import java.util.List;

import com.leisure.forum.exception.ServiceException;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午3:47:42
 */
public interface BaseService<T, P> {
	default T queryById(P id) throws ServiceException {
		return null;
	}

	default List<T> queryCount() throws ServiceException {
		return null;
	}

	default List<T> queryListByPage(int page, int pageSize) throws ServiceException {
		return null;
	}

	default boolean add(T t) throws ServiceException {
		return false;
	}

	default boolean update(T t) throws ServiceException {
		return false;
	}

	default boolean delete(P p) throws ServiceException {
		return false;
	}
}
