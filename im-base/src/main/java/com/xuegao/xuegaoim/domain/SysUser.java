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
 * <br/> @ClassName：SysUser
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/20 18:03:20
 */
@ApiModel(value = "用户信息基础表")
@TableName("sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "key")
    private Long id;

    @TableField("user_code")
    @ApiModelProperty(value = "用户号，后台自动生成，纯数字")
    private String userCode;

    @TableField("username")
    @ApiModelProperty(value = "用户登录账号")
    private String username;

    @TableField("password")
    @ApiModelProperty(value = "密码")
    private String password;

    @TableField("nickname")
    @ApiModelProperty(value = "用户昵称，展示给自己和他人")
    private String nickname;

    @TableField("head_image")
    @ApiModelProperty(value = "头像")
    private String headImage;

    @TableField("status")
    @ApiModelProperty(value = "0正常，1停用")
    private Integer status;

    @TableField("delete_flag")
    @ApiModelProperty(value = "0未删除，1已删除")
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

    public SysUser() {
    }

    public Long getId() {
        return id;
    }

    public String getUsercode() {
        return userCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getHeadimage() {
        return headImage;
    }

    public Integer getStatus() {
        return status;
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

    public void setUsercode(String userCode) {
        this.userCode = userCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHeadimage(String headImage) {
        this.headImage = headImage;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "SysUser{" +
                "id=" + id +
                ", userCode=" + userCode +
                ", username=" + username +
                ", password=" + password +
                ", nickname=" + nickname +
                ", headImage=" + headImage +
                ", status=" + status +
                ", deleteFlag=" + deleteFlag +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                "}";
    }
}
