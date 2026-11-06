package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task;

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

@ApiModel(value = "EnclosurePrint对象", description = "")
@Entity
@TableName("enclosure_print")
@Table(name = "enclosure_print")
public class EnclosurePrint extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "taskId")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = true)
   private Long taskId;
   @ApiModelProperty(name = "warehouseId")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint(20)  COMMENT '库存记录Id'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "userId", value = "打印用户id", notes = "打印用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '打印用户id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "打印用户名称", notes = "打印用户名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '打印用户名称'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "printTime")
   @JsonProperty("printTime")
   @JSONField(name = "printTime")
   @TableField("print_time")
   @Column(name = "print_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime printTime;

   public static EnclosurePrint.EnclosurePrintBuilder builder() {
      return new EnclosurePrint.EnclosurePrintBuilder();
   }

   public EnclosurePrint() {
   }

   public EnclosurePrint(
      final Long id, final Long taskId, final Long warehouseId, final Long userId, final String userName, final Integer quantity, final LocalDateTime printTime
   ) {
      this.id = id;
      this.taskId = taskId;
      this.warehouseId = warehouseId;
      this.userId = userId;
      this.userName = userName;
      this.quantity = quantity;
      this.printTime = printTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   @JsonProperty("id")
   public EnclosurePrint setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public EnclosurePrint setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("warehouseId")
   public EnclosurePrint setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("userId")
   public EnclosurePrint setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public EnclosurePrint setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("quantity")
   public EnclosurePrint setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("printTime")
   public EnclosurePrint setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosurePrint(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", quantity="
         + this.getQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosurePrint)) {
         return false;
      }

      EnclosurePrint other = (EnclosurePrint)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$printTime = this.getPrintTime();
                        Object other$printTime = other.getPrintTime();
                        return this$printTime == null ? other$printTime == null : this$printTime.equals(other$printTime);
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
      return other instanceof EnclosurePrint;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $printTime = this.getPrintTime();
      return result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
   }

   public static class EnclosurePrintBuilder {
      private Long id;
      private Long taskId;
      private Long warehouseId;
      private Long userId;
      private String userName;
      private Integer quantity;
      private LocalDateTime printTime;

      EnclosurePrintBuilder() {
      }

      @JsonProperty("id")
      public EnclosurePrint.EnclosurePrintBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public EnclosurePrint.EnclosurePrintBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("warehouseId")
      public EnclosurePrint.EnclosurePrintBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("userId")
      public EnclosurePrint.EnclosurePrintBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public EnclosurePrint.EnclosurePrintBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("quantity")
      public EnclosurePrint.EnclosurePrintBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("printTime")
      public EnclosurePrint.EnclosurePrintBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      public EnclosurePrint build() {
         return new EnclosurePrint(this.id, this.taskId, this.warehouseId, this.userId, this.userName, this.quantity, this.printTime);
      }

      @Override
      public String toString() {
         return "EnclosurePrint.EnclosurePrintBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", warehouseId="
            + this.warehouseId
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", quantity="
            + this.quantity
            + ", printTime="
            + this.printTime
            + ")";
      }
   }
}
