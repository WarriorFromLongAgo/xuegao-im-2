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
 * <br/> @ClassName：GroupMessage
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/20 18:30:44
 */
@ApiModel(value = "群聊")
@TableName("t_group_message")
public class GroupMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField("msg_type")
    @ApiModelProperty(value = "发消息类型 text文本， image图片，" +
            "custom自定义消息（msg_body为json对象即可，服务端不做校验），voice - 语音")
    private Integer msgType;

    @TableField("msg_body")
    @ApiModelProperty(value = "消息体")
    private String msgBody;

    @TableField("from_user_id")
    @ApiModelProperty(value = "发送者的id")
    private Long fromUserId;

    @TableField("from_user_name")
    @ApiModelProperty(value = "发送者的名称")
    private String fromUserName;

    @TableField("group_id")
    @ApiModelProperty(value = "群组的id")
    private Long groupId;

    @TableField("group_name")
    @ApiModelProperty(value = "群组的名称")
    private String groupName;

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

    public GroupMessage() {
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

    public String getFromusername() {
        return fromUserName;
    }

    public Long getGroupid() {
        return groupId;
    }

    public String getGroupname() {
        return groupName;
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

    public void setFromusername(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public void setGroupid(Long groupId) {
        this.groupId = groupId;
    }

    public void setGroupname(String groupName) {
        this.groupName = groupName;
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
        return "GroupMessage { " +
                "id=" + id +
                ", msgType=" + msgType +
                ", msgBody=" + msgBody +
                ", fromUserId=" + fromUserId +
                ", fromUserName=" + fromUserName +
                ", groupId=" + groupId +
                ", groupName=" + groupName +
                ", deleteFlag=" + deleteFlag +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                "}";
    }
}