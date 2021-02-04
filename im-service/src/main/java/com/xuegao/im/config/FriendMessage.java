package com.xuegao.im.config;

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
    private Integer msgType;

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

    public Integer getMsgtype() {
        return msgType;
    }

    public String getMsgbody() {
        return msgBody;
    }

    public Long getFromuserid() {
        return fromUserId;
    }

    public Long getTargetuserid() {
        return targetUserId;
    }

    public Integer getDeleteflag() {
        return deleteFlag;
    }

    public Long getCreateid() {
        return createId;
    }

    public Date getCreatetime() {
        return createTime;
    }

    public Long getUpdateid() {
        return updateId;
    }

    public Date getUpdatetime() {
        return updateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMsgtype(Integer msgType) {
        this.msgType = msgType;
    }

    public void setMsgbody(String msgBody) {
        this.msgBody = msgBody;
    }

    public void setFromuserid(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public void setTargetuserid(Long targetUserId) {
        this.targetUserId = targetUserId;
    }

    public void setDeleteflag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public void setCreateid(Long createId) {
        this.createId = createId;
    }

    public void setCreatetime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateid(Long updateId) {
        this.updateId = updateId;
    }

    public void setUpdatetime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FriendMessage{" +
                "id=" + id +
                ", msgType=" + msgType +
                ", msgBody=" + msgBody +
                ", fromUserId=" + fromUserId +
                ", targetUserId=" + targetUserId +
                ", deleteFlag=" + deleteFlag +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                "}";
    }
}