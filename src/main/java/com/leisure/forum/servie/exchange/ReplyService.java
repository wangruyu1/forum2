package com.leisure.forum.servie.exchange;

import java.util.List;

import com.leisure.forum.entity.TopicReply;
import com.leisure.forum.servie.base.BaseService;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午7:55:32
 */
public interface ReplyService extends BaseService<TopicReply, Long> {

	List<TopicReply> queryReplysByTopicIdAndPage(Long topicId, Integer page, Integer pageSize);

}
