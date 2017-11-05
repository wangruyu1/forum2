package com.leisure.forum.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "topic")
public class Topic {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 一个分类,例如:数据库,开发语言.
     */
    private Integer type1;

    /**
     * 一个分类，例如:mysql,java。
     */
    private Integer type2;

    /**
     * 用户id,表示该帖子是由那个用户发起。
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 帖子标题.大小限制为300个字符。
     */
    private String title;

    /**
     * 热度,表示帖子的受欢迎程度.可用于排序.
     */
    private Integer score;

    /**
     * 表示帖子分类.置顶帖,精华帖,推荐贴,普通帖等。
     */
    @Column(name = "hot_type")
    private Integer hotType;

    /**
     * 帖子创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 楼主更新帖子时间。不代表回复更新时间。
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 回复数量.
     */
    @Column(name = "reply_count")
    private Integer replyCount;

    /**
     * 1=可用,-1=删除
     */
    private Integer status;

    /**
     * 帖子具体内容。
     */
    private String content;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取一个分类,例如:数据库,开发语言.
     *
     * @return type1 - 一个分类,例如:数据库,开发语言.
     */
    public Integer getType1() {
        return type1;
    }

    /**
     * 设置一个分类,例如:数据库,开发语言.
     *
     * @param type1 一个分类,例如:数据库,开发语言.
     */
    public void setType1(Integer type1) {
        this.type1 = type1;
    }

    /**
     * 获取一个分类，例如:mysql,java。
     *
     * @return type2 - 一个分类，例如:mysql,java。
     */
    public Integer getType2() {
        return type2;
    }

    /**
     * 设置一个分类，例如:mysql,java。
     *
     * @param type2 一个分类，例如:mysql,java。
     */
    public void setType2(Integer type2) {
        this.type2 = type2;
    }

    /**
     * 获取用户id,表示该帖子是由那个用户发起。
     *
     * @return user_id - 用户id,表示该帖子是由那个用户发起。
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id,表示该帖子是由那个用户发起。
     *
     * @param userId 用户id,表示该帖子是由那个用户发起。
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取帖子标题.大小限制为300个字符。
     *
     * @return title - 帖子标题.大小限制为300个字符。
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置帖子标题.大小限制为300个字符。
     *
     * @param title 帖子标题.大小限制为300个字符。
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取热度,表示帖子的受欢迎程度.可用于排序.
     *
     * @return score - 热度,表示帖子的受欢迎程度.可用于排序.
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置热度,表示帖子的受欢迎程度.可用于排序.
     *
     * @param score 热度,表示帖子的受欢迎程度.可用于排序.
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取表示帖子分类.置顶帖,精华帖,推荐贴,普通帖等。
     *
     * @return hot_type - 表示帖子分类.置顶帖,精华帖,推荐贴,普通帖等。
     */
    public Integer getHotType() {
        return hotType;
    }

    /**
     * 设置表示帖子分类.置顶帖,精华帖,推荐贴,普通帖等。
     *
     * @param hotType 表示帖子分类.置顶帖,精华帖,推荐贴,普通帖等。
     */
    public void setHotType(Integer hotType) {
        this.hotType = hotType;
    }

    /**
     * 获取帖子创建时间
     *
     * @return create_time - 帖子创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置帖子创建时间
     *
     * @param createTime 帖子创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取楼主更新帖子时间。不代表回复更新时间。
     *
     * @return update_time - 楼主更新帖子时间。不代表回复更新时间。
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置楼主更新帖子时间。不代表回复更新时间。
     *
     * @param updateTime 楼主更新帖子时间。不代表回复更新时间。
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取回复数量.
     *
     * @return reply_count - 回复数量.
     */
    public Integer getReplyCount() {
        return replyCount;
    }

    /**
     * 设置回复数量.
     *
     * @param replyCount 回复数量.
     */
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    /**
     * 获取1=可用,-1=删除
     *
     * @return status - 1=可用,-1=删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1=可用,-1=删除
     *
     * @param status 1=可用,-1=删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取帖子具体内容。
     *
     * @return content - 帖子具体内容。
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置帖子具体内容。
     *
     * @param content 帖子具体内容。
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}