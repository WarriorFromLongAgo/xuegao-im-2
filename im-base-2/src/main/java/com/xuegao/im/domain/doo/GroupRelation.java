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
 * <br/> @ClassName：GroupRelation
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/20 18:27:31
 */
@ApiModel(value = "群与人的关系表")
@TableName("t_group_relation")
public class GroupRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField("user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @TableField("group_id")
    @ApiModelProperty(value = "群id")
    private Long groupId;

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

    public GroupRelation() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserid() {
        return userId;
    }

    public Long getGroupid() {
        return groupId;
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

    public void setUserid(Long userId) {
        this.userId = userId;
    }

    public void setGroupid(Long groupId) {
        this.groupId = groupId;
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
        return "GroupRelation { " +
                "id=" + id +
                ", userId=" + userId +
                ", groupId=" + groupId +
                ", deleteFlag=" + deleteFlag +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                "}";
    }
}