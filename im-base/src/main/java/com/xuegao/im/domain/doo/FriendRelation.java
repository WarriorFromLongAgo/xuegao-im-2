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
 * <br/> @ClassName：FriendRelation
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/20 18:12:44
 */
@ApiModel(value = "用户关系表")
@TableName("t_friend_relation")
public class FriendRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField("user_id_1")
    @ApiModelProperty(value = "用户id 1")
    private Long userId1;

    @TableField("user_id_2")
    @ApiModelProperty(value = "用户id 2")
    private Long userId2;

    @TableField("mutual_relation")
    @ApiModelProperty(value = "是否互相关注，0没有互相关注， 1互相关注")
    private Integer mutualRelation;

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

    public FriendRelation() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserid1() {
        return userId1;
    }

    public Long getUserid2() {
        return userId2;
    }

    public Integer getMutualrelation() {
        return mutualRelation;
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

    public void setUserid1(Long userId1) {
        this.userId1 = userId1;
    }

    public void setUserid2(Long userId2) {
        this.userId2 = userId2;
    }

    public void setMutualrelation(Integer mutualRelation) {
        this.mutualRelation = mutualRelation;
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

    @Override    public String toString() {        return "FriendRelation{" +
            "id=" + id +
            ", userId1=" + userId1 +
            ", userId2=" + userId2 +
            ", mutualRelation=" + mutualRelation +
            ", deleteFlag=" + deleteFlag +
            ", createId=" + createId +
            ", createTime=" + createTime +
            ", updateId=" + updateId +
            ", updateTime=" + updateTime +
            "}";
    }
}