package com.leisure.forum.servie.impl.exchange;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leisure.forum.constant.AppConstant;
import com.leisure.forum.entity.TopicReply;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.mapper.TopicReplyMapper;
import com.leisure.forum.servie.exchange.ReplyService;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午7:56:12
 */
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private TopicReplyMapper topicReplyMapper;

	@Override
	public TopicReply queryById(Long id) throws ServiceException {
		return topicReplyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TopicReply> queryReplysByTopicIdAndPage(Long topicId, Integer page, Integer pageSize) {
		TopicReply reply = new TopicReply();
		reply.setTopicId(topicId);
		RowBounds rowBounds = new RowBounds((page - 1) * pageSize, pageSize);
		return topicReplyMapper.selectByRowBounds(reply, rowBounds);
	}

	@Override
	public boolean add(TopicReply t) throws ServiceException {
		return topicReplyMapper.insert(t) > 0;
	}

	@Override
	public boolean update(TopicReply t) throws ServiceException {
		return topicReplyMapper.updateByPrimaryKey(t) > 0;
	}

	@Override
	public boolean delete(Long p) throws ServiceException {
		TopicReply record = new TopicReply(p);
		record.setStatus(AppConstant.REPLY_DELETED_STATUS);
		return topicReplyMapper.updateByPrimaryKey(record) > 0;
	}

}
