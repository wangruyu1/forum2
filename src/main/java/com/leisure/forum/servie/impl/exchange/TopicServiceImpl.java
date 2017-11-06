package com.leisure.forum.servie.impl.exchange;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leisure.forum.constant.AppConstant;
import com.leisure.forum.entity.Topic;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.mapper.TopicMapper;
import com.leisure.forum.servie.exchange.TopicService;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午3:53:40
 */
@Service
public class TopicServiceImpl implements TopicService {
	@Autowired
	private TopicMapper topicMapper;

	@Override
	public Topic queryById(Long id) throws ServiceException {
		return topicMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Topic> queryListByEntityAndPage(Topic topic, Integer page, Integer pageSize) {
		RowBounds rowBounds = new RowBounds((page - 1) * pageSize, pageSize);
		return topicMapper.selectByRowBounds(topic, rowBounds);
	}

	@Override
	public boolean add(Topic t) throws ServiceException {
		return topicMapper.insert(t) > 0;
	}

	@Override
	public boolean update(Topic t) throws ServiceException {
		return topicMapper.updateByPrimaryKey(t) > 0;
	}

	@Override
	public boolean delete(Long id) throws ServiceException {
		Topic record = new Topic();
		record.setId(id);
		record.setStatus(AppConstant.TOPIC_DELETED_STATUS);
		return topicMapper.updateByPrimaryKey(record) > 0;
	}

}
