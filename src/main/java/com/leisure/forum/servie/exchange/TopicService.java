package com.leisure.forum.servie.exchange;

import java.util.List;

import com.leisure.forum.entity.Topic;
import com.leisure.forum.servie.base.BaseService;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午3:46:26
 */
public interface TopicService extends BaseService<Topic, Long> {

	List<Topic> queryListByEntityAndPage(Topic topic, Integer page, Integer pageSize);


}
