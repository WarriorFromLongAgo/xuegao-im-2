package com.xuegao.im.domain.doo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <br/> @PackageName：com.xuegao.xuegaoimbase.domain.doo
 * <br/> @ClassName：FriendMessage
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/20 18:15:42
 */
@ApiModel(value = "私聊聊天记录表")
@TableName("t_friend_message")
public class FriendMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField("msg_type")
    @ApiModelProperty(value = "发消息类型 text - 文本，" +
            "                  image - 图片," +
            "                  custom - 自定义消息（msg_body为json对象即可，服务端不做校验）" +
            "                  voice - 语音" +
            "                  video - 视频")
    private String msgType;

    @TableField("msg_body")
    @ApiModelProperty(value = "消息体")
    private String msgBody;

    @TableField("from_user_id")
    @ApiModelProperty(value = "发送者的id")
    private Long fromUserId;

    @TableField("target_user_id")
    @ApiModelProperty(value = "接收者的id")
    private Long targetUserId;

    @TableField("delete_flag")
    @ApiModelProperty(value = "是否删除，0未删除，1已删除")
    private Integer deleteFlag;

    @TableField("create_id")
    @ApiModelProperty(value = "创建人id")
    private Long createId;

    @TableField("create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField("update_id")
    @ApiModelProperty(value = "修改人id")
    private Long updateId;

    @TableField("update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    public FriendMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Long targetUserId) {
        this.targetUserId = targetUserId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FriendMessage{" +
                "id=" + id +
                ", msgType=" + msgType +
                ", msgBody='" + msgBody + '\'' +
                ", fromUserId=" + fromUserId +
                ", targetUserId=" + targetUserId +
                ", deleteFlag=" + deleteFlag +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                '}';
    }
}