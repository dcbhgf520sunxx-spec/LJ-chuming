package com.hzchum.scim.business.core.api.pojo.doModel;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "BusinessProductionControlCheckInfo对象", description = "商务管理-生产控制审核信息 ")
@TableName("business_production_control_check_info")
@Table(name = "business_production_control_check_info")
public class BusinessProductionControlCheckInfo extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @Column
   private Long projectId;
   @ApiModelProperty(name = "status", value = "审核状态 1未审核 2通过 4驳回")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status")
   private Integer status;
   @ApiModelProperty(name = "createUserId", value = "创建人（编辑人）")
   @JsonProperty("createUserId")
   @JSONField(name = "createUserId")
   @TableField("create_user_id")
   @Column(name = "create_user_id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人（编辑人）")
   @Column
   private String createUserName;
   @ApiModelProperty(name = "checkUserId", value = "审核人")
   @JsonProperty("checkUserId")
   @JSONField(name = "checkUserId")
   @TableField("check_user_id")
   @Column(name = "check_user_id")
   private Long checkUserId;
   @ApiModelProperty(name = "checkUserName", value = "创建人（编辑人）")
   @Column
   private String checkUserName;
   @ApiModelProperty(name = "checkTime", value = "审核时间")
   @JsonProperty("checkTime")
   @JSONField(name = "checkTime")
   @TableField("check_time")
   @Column(name = "check_time")
   private LocalDateTime checkTime;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;

   public static BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder builder() {
      return new BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder();
   }

   public BusinessProductionControlCheckInfo() {
   }

   public BusinessProductionControlCheckInfo(
      final Long id,
      final Long projectId,
      final Integer status,
      final Long createUserId,
      final String createUserName,
      final Long checkUserId,
      final String checkUserName,
      final LocalDateTime checkTime,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.status = status;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.checkUserId = checkUserId;
      this.checkUserName = checkUserName;
      this.checkTime = checkTime;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCheckUserId() {
      return this.checkUserId;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public LocalDateTime getCheckTime() {
      return this.checkTime;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public BusinessProductionControlCheckInfo setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessProductionControlCheckInfo setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("status")
   public BusinessProductionControlCheckInfo setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("createUserId")
   public BusinessProductionControlCheckInfo setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public BusinessProductionControlCheckInfo setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @JsonProperty("checkUserId")
   public BusinessProductionControlCheckInfo setCheckUserId(final Long checkUserId) {
      this.checkUserId = checkUserId;
      return this;
   }

   public BusinessProductionControlCheckInfo setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
      return this;
   }

   @JsonProperty("checkTime")
   public BusinessProductionControlCheckInfo setCheckTime(final LocalDateTime checkTime) {
      this.checkTime = checkTime;
      return this;
   }

   @JsonProperty("remark")
   public BusinessProductionControlCheckInfo setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessProductionControlCheckInfo(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", status="
         + this.getStatus()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", checkUserId="
         + this.getCheckUserId()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", checkTime="
         + this.getCheckTime()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessProductionControlCheckInfo)) {
         return false;
      }

      BusinessProductionControlCheckInfo other = (BusinessProductionControlCheckInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$checkUserId = this.getCheckUserId();
                  Object other$checkUserId = other.getCheckUserId();
                  if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                        Object this$checkUserName = this.getCheckUserName();
                        Object other$checkUserName = other.getCheckUserName();
                        if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                           Object this$checkTime = this.getCheckTime();
                           Object other$checkTime = other.getCheckTime();
                           if (this$checkTime == null ? other$checkTime == null : this$checkTime.equals(other$checkTime)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BusinessProductionControlCheckInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkTime = this.getCheckTime();
      result = result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class BusinessProductionControlCheckInfoBuilder {
      private Long id;
      private Long projectId;
      private Integer status;
      private Long createUserId;
      private String createUserName;
      private Long checkUserId;
      private String checkUserName;
      private LocalDateTime checkTime;
      private String remark;

      BusinessProductionControlCheckInfoBuilder() {
      }

      @JsonProperty("id")
      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("status")
      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("createUserId")
      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      @JsonProperty("checkUserId")
      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder checkUserId(final Long checkUserId) {
         this.checkUserId = checkUserId;
         return this;
      }

      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder checkUserName(final String checkUserName) {
         this.checkUserName = checkUserName;
         return this;
      }

      @JsonProperty("checkTime")
      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder checkTime(final LocalDateTime checkTime) {
         this.checkTime = checkTime;
         return this;
      }

      @JsonProperty("remark")
      public BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public BusinessProductionControlCheckInfo build() {
         return new BusinessProductionControlCheckInfo(
            this.id, this.projectId, this.status, this.createUserId, this.createUserName, this.checkUserId, this.checkUserName, this.checkTime, this.remark
         );
      }

      @Override
      public String toString() {
         return "BusinessProductionControlCheckInfo.BusinessProductionControlCheckInfoBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", status="
            + this.status
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", checkUserId="
            + this.checkUserId
            + ", checkUserName="
            + this.checkUserName
            + ", checkTime="
            + this.checkTime
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
