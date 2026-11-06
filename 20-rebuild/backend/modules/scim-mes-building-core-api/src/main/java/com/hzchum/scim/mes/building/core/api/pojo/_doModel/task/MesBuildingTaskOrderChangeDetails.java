package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingTaskOrderChangeDetails对象", description = "")
@Entity
@TableName("mes_building_task_order_change_details")
@Table(name = "mes_building_task_order_change_details")
public class MesBuildingTaskOrderChangeDetails extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) default '0' COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "nestCutPlateId", value = "切割id", notes = "切割id")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   @TableField("nest_cut_plate_id")
   @Column(name = "nest_cut_plate_id", columnDefinition = "bigint(20) default '0' COMMENT '切割id'", nullable = true)
   private Long nestCutPlateId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "changeId", value = "协同id", notes = "协同id")
   @JsonProperty("changeId")
   @JSONField(name = "changeId")
   @TableField("change_id")
   @Column(name = "change_id", columnDefinition = "bigint(20) default '0' COMMENT '协同id'", nullable = true)
   private Long changeId;
   @ApiModelProperty(name = "oldTaskId", value = "原任务id", notes = "原任务id")
   @JsonProperty("oldTaskId")
   @JSONField(name = "oldTaskId")
   @TableField("old_task_id")
   @Column(name = "old_task_id", columnDefinition = "bigint(20) default '0' COMMENT '原任务id'", nullable = true)
   private Long oldTaskId;
   @ApiModelProperty(name = "newTaskId", value = "新任务id", notes = "新任务id")
   @JsonProperty("newTaskId")
   @JSONField(name = "newTaskId")
   @TableField("new_task_id")
   @Column(name = "new_task_id", columnDefinition = "bigint(20) default '0' COMMENT '新任务id'", nullable = true)
   private Long newTaskId;
   @ApiModelProperty(name = "oldTaskOrderId", value = "原工单id", notes = "原工单id")
   @JsonProperty("oldTaskOrderId")
   @JSONField(name = "oldTaskOrderId")
   @TableField("old_task_order_id")
   @Column(name = "old_task_order_id", columnDefinition = "bigint(20) default '0' COMMENT '原工单id'", nullable = true)
   private Long oldTaskOrderId;
   @ApiModelProperty(name = "number", value = "一物一码号", notes = "一物一码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11) default '0' COMMENT '一物一码号'", nullable = false)
   private Integer number;
   @ApiModelProperty(name = "newTaskOrderId", value = "现任务工单", notes = "现任务工单")
   @JsonProperty("newTaskOrderId")
   @JSONField(name = "newTaskOrderId")
   @TableField("new_task_order_id")
   @Column(name = "new_task_order_id", columnDefinition = "bigint(20)  COMMENT '现任务工单'", nullable = false)
   private Long newTaskOrderId;

   public static MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder builder() {
      return new MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder();
   }

   public MesBuildingTaskOrderChangeDetails() {
   }

   public MesBuildingTaskOrderChangeDetails(
      final Long id,
      final Long productId,
      final Long nestCutPlateId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Long changeId,
      final Long oldTaskId,
      final Long newTaskId,
      final Long oldTaskOrderId,
      final Integer number,
      final Long newTaskOrderId
   ) {
      this.id = id;
      this.productId = productId;
      this.nestCutPlateId = nestCutPlateId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.changeId = changeId;
      this.oldTaskId = oldTaskId;
      this.newTaskId = newTaskId;
      this.oldTaskOrderId = oldTaskOrderId;
      this.number = number;
      this.newTaskOrderId = newTaskOrderId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getChangeId() {
      return this.changeId;
   }

   public Long getOldTaskId() {
      return this.oldTaskId;
   }

   public Long getNewTaskId() {
      return this.newTaskId;
   }

   public Long getOldTaskOrderId() {
      return this.oldTaskOrderId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getNewTaskOrderId() {
      return this.newTaskOrderId;
   }

   @JsonProperty("id")
   public MesBuildingTaskOrderChangeDetails setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskOrderChangeDetails setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("nestCutPlateId")
   public MesBuildingTaskOrderChangeDetails setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTaskOrderChangeDetails setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskOrderChangeDetails setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("changeId")
   public MesBuildingTaskOrderChangeDetails setChangeId(final Long changeId) {
      this.changeId = changeId;
      return this;
   }

   @JsonProperty("oldTaskId")
   public MesBuildingTaskOrderChangeDetails setOldTaskId(final Long oldTaskId) {
      this.oldTaskId = oldTaskId;
      return this;
   }

   @JsonProperty("newTaskId")
   public MesBuildingTaskOrderChangeDetails setNewTaskId(final Long newTaskId) {
      this.newTaskId = newTaskId;
      return this;
   }

   @JsonProperty("oldTaskOrderId")
   public MesBuildingTaskOrderChangeDetails setOldTaskOrderId(final Long oldTaskOrderId) {
      this.oldTaskOrderId = oldTaskOrderId;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingTaskOrderChangeDetails setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("newTaskOrderId")
   public MesBuildingTaskOrderChangeDetails setNewTaskOrderId(final Long newTaskOrderId) {
      this.newTaskOrderId = newTaskOrderId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderChangeDetails(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", nestCutPlateId="
         + this.getNestCutPlateId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", changeId="
         + this.getChangeId()
         + ", oldTaskId="
         + this.getOldTaskId()
         + ", newTaskId="
         + this.getNewTaskId()
         + ", oldTaskOrderId="
         + this.getOldTaskOrderId()
         + ", number="
         + this.getNumber()
         + ", newTaskOrderId="
         + this.getNewTaskOrderId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderChangeDetails)) {
         return false;
      }

      MesBuildingTaskOrderChangeDetails other = (MesBuildingTaskOrderChangeDetails)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$nestCutPlateId = this.getNestCutPlateId();
            Object other$nestCutPlateId = other.getNestCutPlateId();
            if (this$nestCutPlateId == null ? other$nestCutPlateId == null : this$nestCutPlateId.equals(other$nestCutPlateId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$changeId = this.getChangeId();
                     Object other$changeId = other.getChangeId();
                     if (this$changeId == null ? other$changeId == null : this$changeId.equals(other$changeId)) {
                        Object this$oldTaskId = this.getOldTaskId();
                        Object other$oldTaskId = other.getOldTaskId();
                        if (this$oldTaskId == null ? other$oldTaskId == null : this$oldTaskId.equals(other$oldTaskId)) {
                           Object this$newTaskId = this.getNewTaskId();
                           Object other$newTaskId = other.getNewTaskId();
                           if (this$newTaskId == null ? other$newTaskId == null : this$newTaskId.equals(other$newTaskId)) {
                              Object this$oldTaskOrderId = this.getOldTaskOrderId();
                              Object other$oldTaskOrderId = other.getOldTaskOrderId();
                              if (this$oldTaskOrderId == null ? other$oldTaskOrderId == null : this$oldTaskOrderId.equals(other$oldTaskOrderId)) {
                                 Object this$number = this.getNumber();
                                 Object other$number = other.getNumber();
                                 if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                    Object this$newTaskOrderId = this.getNewTaskOrderId();
                                    Object other$newTaskOrderId = other.getNewTaskOrderId();
                                    return this$newTaskOrderId == null ? other$newTaskOrderId == null : this$newTaskOrderId.equals(other$newTaskOrderId);
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
      return other instanceof MesBuildingTaskOrderChangeDetails;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $changeId = this.getChangeId();
      result = result * 59 + ($changeId == null ? 43 : $changeId.hashCode());
      Object $oldTaskId = this.getOldTaskId();
      result = result * 59 + ($oldTaskId == null ? 43 : $oldTaskId.hashCode());
      Object $newTaskId = this.getNewTaskId();
      result = result * 59 + ($newTaskId == null ? 43 : $newTaskId.hashCode());
      Object $oldTaskOrderId = this.getOldTaskOrderId();
      result = result * 59 + ($oldTaskOrderId == null ? 43 : $oldTaskOrderId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $newTaskOrderId = this.getNewTaskOrderId();
      return result * 59 + ($newTaskOrderId == null ? 43 : $newTaskOrderId.hashCode());
   }

   public static class MesBuildingTaskOrderChangeDetailsBuilder {
      private Long id;
      private Long productId;
      private Long nestCutPlateId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Long changeId;
      private Long oldTaskId;
      private Long newTaskId;
      private Long oldTaskOrderId;
      private Integer number;
      private Long newTaskOrderId;

      MesBuildingTaskOrderChangeDetailsBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("nestCutPlateId")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder nestCutPlateId(final Long nestCutPlateId) {
         this.nestCutPlateId = nestCutPlateId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("changeId")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder changeId(final Long changeId) {
         this.changeId = changeId;
         return this;
      }

      @JsonProperty("oldTaskId")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder oldTaskId(final Long oldTaskId) {
         this.oldTaskId = oldTaskId;
         return this;
      }

      @JsonProperty("newTaskId")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder newTaskId(final Long newTaskId) {
         this.newTaskId = newTaskId;
         return this;
      }

      @JsonProperty("oldTaskOrderId")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder oldTaskOrderId(final Long oldTaskOrderId) {
         this.oldTaskOrderId = oldTaskOrderId;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("newTaskOrderId")
      public MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder newTaskOrderId(final Long newTaskOrderId) {
         this.newTaskOrderId = newTaskOrderId;
         return this;
      }

      public MesBuildingTaskOrderChangeDetails build() {
         return new MesBuildingTaskOrderChangeDetails(
            this.id,
            this.productId,
            this.nestCutPlateId,
            this.taskTypeEnum,
            this.quantity,
            this.changeId,
            this.oldTaskId,
            this.newTaskId,
            this.oldTaskOrderId,
            this.number,
            this.newTaskOrderId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderChangeDetails.MesBuildingTaskOrderChangeDetailsBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", nestCutPlateId="
            + this.nestCutPlateId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", changeId="
            + this.changeId
            + ", oldTaskId="
            + this.oldTaskId
            + ", newTaskId="
            + this.newTaskId
            + ", oldTaskOrderId="
            + this.oldTaskOrderId
            + ", number="
            + this.number
            + ", newTaskOrderId="
            + this.newTaskOrderId
            + ")";
      }
   }
}
