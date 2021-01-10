package com.xuegao.xuegaoim.domain;

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
 * <br/> @ClassName：Group
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/20 18:00:55
 */
@ApiModel(value = "群的信息表")
@TableName("sys_group")
public class SysGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "key")
    private Long id;

    @TableField("group_name")
    @ApiModelProperty(value = "群名称")
    private String groupName;

    @TableField("notice")
    @ApiModelProperty(value = "群的公告")
    private String notice;

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

    public SysGroup() {
    }

    public Long getId() {
        return id;
    }

    public String getGroupname() {
        return groupName;
    }

    public String getNotice() {
        return notice;
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

    public void setGroupname(String groupName) {
        this.groupName = groupName;
    }

    public void setNotice(String notice) {
        this.notice = notice;
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
        return "Group{" +
                "id=" + id +
                ", groupName=" + groupName +
                ", notice=" + notice +
                ", deleteFlag=" + deleteFlag +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                "}";
    }
}
