package com.hzchum.scim.plan.core.api.pojo._do;

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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechEnclosureChange对象", description = "围护变更表")
@Entity
@TableName("tech_enclosure_change")
@Table(name = "tech_enclosure_change")
public class TechEnclosureChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "planId", value = "区域Id", notes = "区域Id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '计划Id'", nullable = false)
   private Long planId;
   @ApiModelProperty(name = "enclosureId", value = "围护id", notes = "围护id")
   @JsonProperty("enclosureId")
   @JSONField(name = "enclosureId")
   @TableField("enclosure_id")
   @Column(name = "enclosure_id", columnDefinition = "bigint(20)  COMMENT '围护id'", nullable = false)
   private Long enclosureId;
   @ApiModelProperty(name = "oldQuantity", value = "原数量", notes = "原数量")
   @JsonProperty("oldQuantity")
   @JSONField(name = "oldQuantity")
   @TableField("old_quantity")
   @Column(name = "old_quantity", columnDefinition = "int(11)  COMMENT '原数量'", nullable = false)
   private Integer oldQuantity;
   @ApiModelProperty(name = "newQuantity", value = "变更后数量", notes = "变更后数量")
   @JsonProperty("newQuantity")
   @JSONField(name = "newQuantity")
   @TableField("new_quantity")
   @Column(name = "new_quantity", columnDefinition = "int(11)  COMMENT '变更后数量'", nullable = false)
   private Integer newQuantity;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64) COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64) COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11) comment '围护品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件' ", nullable = true)
   private Integer category;
   @ApiModelProperty(name = "plate", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   @TableField("plate")
   @Column(name = "plate", columnDefinition = "varchar(255) comment '版型'", nullable = false)
   private String plate;
   @ApiModelProperty(name = "userId", value = "变更提交人id", notes = "变更提交人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '变更提交人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "handleStatusEnum", value = "处理状态 1未处理 2处理通过 4驳回 HandleStatusEnum", notes = "处理状态 1未处理 2处理通过 4驳回")
   @JsonProperty("handleStatusEnum")
   @JSONField(name = "handleStatusEnum")
   @TableField("handle_status_enum")
   @Column(name = "handle_status_enum", columnDefinition = "int(11) default '1' COMMENT '处理状态 1未处理 2处理通过 4驳回'", nullable = false)
   private Integer handleStatusEnum;
   @ApiModelProperty(name = "handleUserId", value = "处理人", notes = "处理人")
   @JsonProperty("handleUserId")
   @JSONField(name = "handleUserId")
   @TableField("handle_user_id")
   @Column(name = "handle_user_id", columnDefinition = "bigint(20)  COMMENT '处理人'", nullable = true)
   private Long handleUserId;
   @ApiModelProperty(name = "handleTime", value = "处理时间", notes = "处理时间")
   @JsonProperty("handleTime")
   @JSONField(name = "handleTime")
   @TableField("handle_time")
   @Column(name = "handle_time", columnDefinition = "datetime(6)  COMMENT '处理时间'", nullable = true)
   private LocalDateTime handleTime;
   @ApiModelProperty(name = "reasonId", value = "变更原因id", notes = "变更原因id")
   @JsonProperty("reasonId")
   @JSONField(name = "reasonId")
   @TableField("reason_id")
   @Column(name = "reason_id", columnDefinition = "bigint(20)  COMMENT '变更原因id'", nullable = false)
   private Long reasonId;
   @ApiModelProperty(name = "changeRemark", value = "备注", notes = "备注")
   @JsonProperty("changeRemark")
   @JSONField(name = "changeRemark")
   @TableField("change_remark")
   @Column(name = "change_remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String changeRemark;

   public static TechEnclosureChange.TechEnclosureChangeBuilder builder() {
      return new TechEnclosureChange.TechEnclosureChangeBuilder();
   }

   public TechEnclosureChange() {
   }

   public TechEnclosureChange(
      final Long id,
      final Long projectId,
      final Long planId,
      final Long enclosureId,
      final Integer oldQuantity,
      final Integer newQuantity,
      final String name,
      final String serialNumber,
      final Integer category,
      final String plate,
      final Long userId,
      final Integer handleStatusEnum,
      final Long handleUserId,
      final LocalDateTime handleTime,
      final Long reasonId,
      final String changeRemark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.planId = planId;
      this.enclosureId = enclosureId;
      this.oldQuantity = oldQuantity;
      this.newQuantity = newQuantity;
      this.name = name;
      this.serialNumber = serialNumber;
      this.category = category;
      this.plate = plate;
      this.userId = userId;
      this.handleStatusEnum = handleStatusEnum;
      this.handleUserId = handleUserId;
      this.handleTime = handleTime;
      this.reasonId = reasonId;
      this.changeRemark = changeRemark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Long getEnclosureId() {
      return this.enclosureId;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getPlate() {
      return this.plate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getHandleStatusEnum() {
      return this.handleStatusEnum;
   }

   public Long getHandleUserId() {
      return this.handleUserId;
   }

   public LocalDateTime getHandleTime() {
      return this.handleTime;
   }

   public Long getReasonId() {
      return this.reasonId;
   }

   public String getChangeRemark() {
      return this.changeRemark;
   }

   @JsonProperty("id")
   public TechEnclosureChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public TechEnclosureChange setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("planId")
   public TechEnclosureChange setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("enclosureId")
   public TechEnclosureChange setEnclosureId(final Long enclosureId) {
      this.enclosureId = enclosureId;
      return this;
   }

   @JsonProperty("oldQuantity")
   public TechEnclosureChange setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
      return this;
   }

   @JsonProperty("newQuantity")
   public TechEnclosureChange setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
      return this;
   }

   @JsonProperty("name")
   public TechEnclosureChange setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechEnclosureChange setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("category")
   public TechEnclosureChange setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("plate")
   public TechEnclosureChange setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("userId")
   public TechEnclosureChange setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("handleStatusEnum")
   public TechEnclosureChange setHandleStatusEnum(final Integer handleStatusEnum) {
      this.handleStatusEnum = handleStatusEnum;
      return this;
   }

   @JsonProperty("handleUserId")
   public TechEnclosureChange setHandleUserId(final Long handleUserId) {
      this.handleUserId = handleUserId;
      return this;
   }

   @JsonProperty("handleTime")
   public TechEnclosureChange setHandleTime(final LocalDateTime handleTime) {
      this.handleTime = handleTime;
      return this;
   }

   @JsonProperty("reasonId")
   public TechEnclosureChange setReasonId(final Long reasonId) {
      this.reasonId = reasonId;
      return this;
   }

   @JsonProperty("changeRemark")
   public TechEnclosureChange setChangeRemark(final String changeRemark) {
      this.changeRemark = changeRemark;
      return this;
   }

   @Override
   public String toString() {
      return "TechEnclosureChange(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", planId="
         + this.getPlanId()
         + ", enclosureId="
         + this.getEnclosureId()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", category="
         + this.getCategory()
         + ", plate="
         + this.getPlate()
         + ", userId="
         + this.getUserId()
         + ", handleStatusEnum="
         + this.getHandleStatusEnum()
         + ", handleUserId="
         + this.getHandleUserId()
         + ", handleTime="
         + this.getHandleTime()
         + ", reasonId="
         + this.getReasonId()
         + ", changeRemark="
         + this.getChangeRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureChange)) {
         return false;
      }

      TechEnclosureChange other = (TechEnclosureChange)o;
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
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$enclosureId = this.getEnclosureId();
               Object other$enclosureId = other.getEnclosureId();
               if (this$enclosureId == null ? other$enclosureId == null : this$enclosureId.equals(other$enclosureId)) {
                  Object this$oldQuantity = this.getOldQuantity();
                  Object other$oldQuantity = other.getOldQuantity();
                  if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
                     Object this$newQuantity = this.getNewQuantity();
                     Object other$newQuantity = other.getNewQuantity();
                     if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$handleStatusEnum = this.getHandleStatusEnum();
                              Object other$handleStatusEnum = other.getHandleStatusEnum();
                              if (this$handleStatusEnum == null ? other$handleStatusEnum == null : this$handleStatusEnum.equals(other$handleStatusEnum)) {
                                 Object this$handleUserId = this.getHandleUserId();
                                 Object other$handleUserId = other.getHandleUserId();
                                 if (this$handleUserId == null ? other$handleUserId == null : this$handleUserId.equals(other$handleUserId)) {
                                    Object this$reasonId = this.getReasonId();
                                    Object other$reasonId = other.getReasonId();
                                    if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$plate = this.getPlate();
                                             Object other$plate = other.getPlate();
                                             if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                Object this$handleTime = this.getHandleTime();
                                                Object other$handleTime = other.getHandleTime();
                                                if (this$handleTime == null ? other$handleTime == null : this$handleTime.equals(other$handleTime)) {
                                                   Object this$changeRemark = this.getChangeRemark();
                                                   Object other$changeRemark = other.getChangeRemark();
                                                   return this$changeRemark == null ? other$changeRemark == null : this$changeRemark.equals(other$changeRemark);
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
      return other instanceof TechEnclosureChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $enclosureId = this.getEnclosureId();
      result = result * 59 + ($enclosureId == null ? 43 : $enclosureId.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $handleStatusEnum = this.getHandleStatusEnum();
      result = result * 59 + ($handleStatusEnum == null ? 43 : $handleStatusEnum.hashCode());
      Object $handleUserId = this.getHandleUserId();
      result = result * 59 + ($handleUserId == null ? 43 : $handleUserId.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $handleTime = this.getHandleTime();
      result = result * 59 + ($handleTime == null ? 43 : $handleTime.hashCode());
      Object $changeRemark = this.getChangeRemark();
      return result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
   }

   public static class TechEnclosureChangeBuilder {
      private Long id;
      private Long projectId;
      private Long planId;
      private Long enclosureId;
      private Integer oldQuantity;
      private Integer newQuantity;
      private String name;
      private String serialNumber;
      private Integer category;
      private String plate;
      private Long userId;
      private Integer handleStatusEnum;
      private Long handleUserId;
      private LocalDateTime handleTime;
      private Long reasonId;
      private String changeRemark;

      TechEnclosureChangeBuilder() {
      }

      @JsonProperty("id")
      public TechEnclosureChange.TechEnclosureChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public TechEnclosureChange.TechEnclosureChangeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("planId")
      public TechEnclosureChange.TechEnclosureChangeBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("enclosureId")
      public TechEnclosureChange.TechEnclosureChangeBuilder enclosureId(final Long enclosureId) {
         this.enclosureId = enclosureId;
         return this;
      }

      @JsonProperty("oldQuantity")
      public TechEnclosureChange.TechEnclosureChangeBuilder oldQuantity(final Integer oldQuantity) {
         this.oldQuantity = oldQuantity;
         return this;
      }

      @JsonProperty("newQuantity")
      public TechEnclosureChange.TechEnclosureChangeBuilder newQuantity(final Integer newQuantity) {
         this.newQuantity = newQuantity;
         return this;
      }

      @JsonProperty("name")
      public TechEnclosureChange.TechEnclosureChangeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechEnclosureChange.TechEnclosureChangeBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("category")
      public TechEnclosureChange.TechEnclosureChangeBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("plate")
      public TechEnclosureChange.TechEnclosureChangeBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("userId")
      public TechEnclosureChange.TechEnclosureChangeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("handleStatusEnum")
      public TechEnclosureChange.TechEnclosureChangeBuilder handleStatusEnum(final Integer handleStatusEnum) {
         this.handleStatusEnum = handleStatusEnum;
         return this;
      }

      @JsonProperty("handleUserId")
      public TechEnclosureChange.TechEnclosureChangeBuilder handleUserId(final Long handleUserId) {
         this.handleUserId = handleUserId;
         return this;
      }

      @JsonProperty("handleTime")
      public TechEnclosureChange.TechEnclosureChangeBuilder handleTime(final LocalDateTime handleTime) {
         this.handleTime = handleTime;
         return this;
      }

      @JsonProperty("reasonId")
      public TechEnclosureChange.TechEnclosureChangeBuilder reasonId(final Long reasonId) {
         this.reasonId = reasonId;
         return this;
      }

      @JsonProperty("changeRemark")
      public TechEnclosureChange.TechEnclosureChangeBuilder changeRemark(final String changeRemark) {
         this.changeRemark = changeRemark;
         return this;
      }

      public TechEnclosureChange build() {
         return new TechEnclosureChange(
            this.id,
            this.projectId,
            this.planId,
            this.enclosureId,
            this.oldQuantity,
            this.newQuantity,
            this.name,
            this.serialNumber,
            this.category,
            this.plate,
            this.userId,
            this.handleStatusEnum,
            this.handleUserId,
            this.handleTime,
            this.reasonId,
            this.changeRemark
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureChange.TechEnclosureChangeBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", planId="
            + this.planId
            + ", enclosureId="
            + this.enclosureId
            + ", oldQuantity="
            + this.oldQuantity
            + ", newQuantity="
            + this.newQuantity
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", category="
            + this.category
            + ", plate="
            + this.plate
            + ", userId="
            + this.userId
            + ", handleStatusEnum="
            + this.handleStatusEnum
            + ", handleUserId="
            + this.handleUserId
            + ", handleTime="
            + this.handleTime
            + ", reasonId="
            + this.reasonId
            + ", changeRemark="
            + this.changeRemark
            + ")";
      }
   }
}
