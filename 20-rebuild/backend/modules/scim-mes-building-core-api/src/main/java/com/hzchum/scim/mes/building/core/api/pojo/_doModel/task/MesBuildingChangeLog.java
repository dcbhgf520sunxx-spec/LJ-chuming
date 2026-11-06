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

@ApiModel(value = "MesBuildingChangeLog对象", description = "变更数据操作日志")
@Entity
@TableName("mes_building_change_log")
@Table(name = "mes_building_change_log")
@org.hibernate.annotations.Table(appliesTo = "mes_building_change_log", comment = "变更数据操作日志")
public class MesBuildingChangeLog extends BaseEntity<Long> {
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
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "changeId", value = "构件变更记录表id", notes = "构件变更记录表id")
   @JsonProperty("changeId")
   @JSONField(name = "changeId")
   @TableField("change_id")
   @Column(name = "change_id", columnDefinition = "bigint(20)  COMMENT '构件变更记录表id'", nullable = false)
   private Long changeId;
   @ApiModelProperty(name = "tableId", value = "构件变更记录表id", notes = "构件变更记录表id")
   @JsonProperty("tableId")
   @JSONField(name = "tableId")
   @TableField("table_id")
   @Column(name = "table_id", columnDefinition = "bigint(20)  COMMENT '构件变更记录表id'", nullable = false)
   private Long tableId;
   @ApiModelProperty(name = "oldQuantity", value = "变更前的数量", notes = "变更前的数量")
   @JsonProperty("oldQuantity")
   @JSONField(name = "oldQuantity")
   @TableField("old_quantity")
   @Column(name = "old_quantity", columnDefinition = "int(11) default '0'  COMMENT '变更前的数量'", nullable = false)
   private Integer oldQuantity;
   @ApiModelProperty(name = "changeQuantity", value = "变更减少数量", notes = "变更减少数量")
   @JsonProperty("changeQuantity")
   @JSONField(name = "changeQuantity")
   @TableField("change_quantity")
   @Column(name = "change_quantity", columnDefinition = "int(11) default '0' COMMENT '变更减少数量'", nullable = false)
   private Integer changeQuantity;
   @ApiModelProperty(name = "quantity", value = "变更后的数量", notes = "变更后的数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '变更后的数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "type", value = "数据类型 1:入库汇总 2:入库记录 4:完成记录 ", notes = "数据类型 1:入库汇总 2:入库记录 4:完成记录 ")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '数据类型 1:入库汇总 2:入库记录 4:完成记录 '", nullable = false)
   private Integer type;

   public static MesBuildingChangeLog.MesBuildingChangeLogBuilder builder() {
      return new MesBuildingChangeLog.MesBuildingChangeLogBuilder();
   }

   public MesBuildingChangeLog() {
   }

   public MesBuildingChangeLog(
      final Long id,
      final Long productId,
      final Long changeId,
      final Long tableId,
      final Integer oldQuantity,
      final Integer changeQuantity,
      final Integer quantity,
      final Long userId,
      final Integer taskTypeEnum,
      final Integer type
   ) {
      this.id = id;
      this.productId = productId;
      this.changeId = changeId;
      this.tableId = tableId;
      this.oldQuantity = oldQuantity;
      this.changeQuantity = changeQuantity;
      this.quantity = quantity;
      this.userId = userId;
      this.taskTypeEnum = taskTypeEnum;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getChangeId() {
      return this.changeId;
   }

   public Long getTableId() {
      return this.tableId;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getChangeQuantity() {
      return this.changeQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public MesBuildingChangeLog setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingChangeLog setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("changeId")
   public MesBuildingChangeLog setChangeId(final Long changeId) {
      this.changeId = changeId;
      return this;
   }

   @JsonProperty("tableId")
   public MesBuildingChangeLog setTableId(final Long tableId) {
      this.tableId = tableId;
      return this;
   }

   @JsonProperty("oldQuantity")
   public MesBuildingChangeLog setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
      return this;
   }

   @JsonProperty("changeQuantity")
   public MesBuildingChangeLog setChangeQuantity(final Integer changeQuantity) {
      this.changeQuantity = changeQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingChangeLog setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingChangeLog setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingChangeLog setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingChangeLog setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingChangeLog(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", changeId="
         + this.getChangeId()
         + ", tableId="
         + this.getTableId()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", changeQuantity="
         + this.getChangeQuantity()
         + ", quantity="
         + this.getQuantity()
         + ", userId="
         + this.getUserId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingChangeLog)) {
         return false;
      }

      MesBuildingChangeLog other = (MesBuildingChangeLog)o;
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
            Object this$changeId = this.getChangeId();
            Object other$changeId = other.getChangeId();
            if (this$changeId == null ? other$changeId == null : this$changeId.equals(other$changeId)) {
               Object this$tableId = this.getTableId();
               Object other$tableId = other.getTableId();
               if (this$tableId == null ? other$tableId == null : this$tableId.equals(other$tableId)) {
                  Object this$oldQuantity = this.getOldQuantity();
                  Object other$oldQuantity = other.getOldQuantity();
                  if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
                     Object this$changeQuantity = this.getChangeQuantity();
                     Object other$changeQuantity = other.getChangeQuantity();
                     if (this$changeQuantity == null ? other$changeQuantity == null : this$changeQuantity.equals(other$changeQuantity)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$taskTypeEnum = this.getTaskTypeEnum();
                              Object other$taskTypeEnum = other.getTaskTypeEnum();
                              if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                 Object this$type = this.getType();
                                 Object other$type = other.getType();
                                 return this$type == null ? other$type == null : this$type.equals(other$type);
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
      return other instanceof MesBuildingChangeLog;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $changeId = this.getChangeId();
      result = result * 59 + ($changeId == null ? 43 : $changeId.hashCode());
      Object $tableId = this.getTableId();
      result = result * 59 + ($tableId == null ? 43 : $tableId.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $changeQuantity = this.getChangeQuantity();
      result = result * 59 + ($changeQuantity == null ? 43 : $changeQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   public static class MesBuildingChangeLogBuilder {
      private Long id;
      private Long productId;
      private Long changeId;
      private Long tableId;
      private Integer oldQuantity;
      private Integer changeQuantity;
      private Integer quantity;
      private Long userId;
      private Integer taskTypeEnum;
      private Integer type;

      MesBuildingChangeLogBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("changeId")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder changeId(final Long changeId) {
         this.changeId = changeId;
         return this;
      }

      @JsonProperty("tableId")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder tableId(final Long tableId) {
         this.tableId = tableId;
         return this;
      }

      @JsonProperty("oldQuantity")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder oldQuantity(final Integer oldQuantity) {
         this.oldQuantity = oldQuantity;
         return this;
      }

      @JsonProperty("changeQuantity")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder changeQuantity(final Integer changeQuantity) {
         this.changeQuantity = changeQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingChangeLog.MesBuildingChangeLogBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesBuildingChangeLog build() {
         return new MesBuildingChangeLog(
            this.id,
            this.productId,
            this.changeId,
            this.tableId,
            this.oldQuantity,
            this.changeQuantity,
            this.quantity,
            this.userId,
            this.taskTypeEnum,
            this.type
         );
      }

      @Override
      public String toString() {
         return "MesBuildingChangeLog.MesBuildingChangeLogBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", changeId="
            + this.changeId
            + ", tableId="
            + this.tableId
            + ", oldQuantity="
            + this.oldQuantity
            + ", changeQuantity="
            + this.changeQuantity
            + ", quantity="
            + this.quantity
            + ", userId="
            + this.userId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", type="
            + this.type
            + ")";
      }
   }
}
