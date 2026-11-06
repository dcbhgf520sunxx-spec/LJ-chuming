package com.hzchum.scim.cut.core.api.pojo._do;

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

@ApiModel(value = "CutPlatePart对象", description = "")
@Entity
@TableName("cut_plate_part")
@Table(name = "cut_plate_part")
public class CutPlatePart extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cutInstructionId")
   @JsonProperty("cutInstructionId")
   @JSONField(name = "cutInstructionId")
   @TableField("cut_instruction_id")
   @Column(name = "cut_instruction_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutInstructionId;
   @ApiModelProperty(name = "cutTaskId")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutTaskId;
   @ApiModelProperty(name = "partId")
   @JsonProperty("partId")
   @JSONField(name = "partId")
   @TableField("part_id")
   @Column(name = "part_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String partId;
   @ApiModelProperty(name = "quantity")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String quantity;
   @ApiModelProperty(name = "taskId")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String taskId;
   @ApiModelProperty(name = "sendState")
   @JsonProperty("sendState")
   @JSONField(name = "sendState")
   @TableField("send_state")
   @Column(name = "send_state", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = true)
   private String sendState;

   public static CutPlatePart.CutPlatePartBuilder builder() {
      return new CutPlatePart.CutPlatePartBuilder();
   }

   public CutPlatePart() {
   }

   public CutPlatePart(
      final Long id,
      final String cutInstructionId,
      final String cutTaskId,
      final String partId,
      final String quantity,
      final String taskId,
      final String sendState
   ) {
      this.id = id;
      this.cutInstructionId = cutInstructionId;
      this.cutTaskId = cutTaskId;
      this.partId = partId;
      this.quantity = quantity;
      this.taskId = taskId;
      this.sendState = sendState;
   }

   public Long getId() {
      return this.id;
   }

   public String getCutInstructionId() {
      return this.cutInstructionId;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public String getPartId() {
      return this.partId;
   }

   public String getQuantity() {
      return this.quantity;
   }

   public String getTaskId() {
      return this.taskId;
   }

   public String getSendState() {
      return this.sendState;
   }

   @JsonProperty("id")
   public CutPlatePart setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cutInstructionId")
   public CutPlatePart setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
      return this;
   }

   @JsonProperty("cutTaskId")
   public CutPlatePart setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("partId")
   public CutPlatePart setPartId(final String partId) {
      this.partId = partId;
      return this;
   }

   @JsonProperty("quantity")
   public CutPlatePart setQuantity(final String quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("taskId")
   public CutPlatePart setTaskId(final String taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("sendState")
   public CutPlatePart setSendState(final String sendState) {
      this.sendState = sendState;
      return this;
   }

   @Override
   public String toString() {
      return "CutPlatePart(id="
         + this.getId()
         + ", cutInstructionId="
         + this.getCutInstructionId()
         + ", cutTaskId="
         + this.getCutTaskId()
         + ", partId="
         + this.getPartId()
         + ", quantity="
         + this.getQuantity()
         + ", taskId="
         + this.getTaskId()
         + ", sendState="
         + this.getSendState()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutPlatePart)) {
         return false;
      }

      CutPlatePart other = (CutPlatePart)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cutInstructionId = this.getCutInstructionId();
         Object other$cutInstructionId = other.getCutInstructionId();
         if (this$cutInstructionId == null ? other$cutInstructionId == null : this$cutInstructionId.equals(other$cutInstructionId)) {
            Object this$cutTaskId = this.getCutTaskId();
            Object other$cutTaskId = other.getCutTaskId();
            if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
               Object this$partId = this.getPartId();
               Object other$partId = other.getPartId();
               if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$taskId = this.getTaskId();
                     Object other$taskId = other.getTaskId();
                     if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                        Object this$sendState = this.getSendState();
                        Object other$sendState = other.getSendState();
                        return this$sendState == null ? other$sendState == null : this$sendState.equals(other$sendState);
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
      return other instanceof CutPlatePart;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $partId = this.getPartId();
      result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $sendState = this.getSendState();
      return result * 59 + ($sendState == null ? 43 : $sendState.hashCode());
   }

   public static class CutPlatePartBuilder {
      private Long id;
      private String cutInstructionId;
      private String cutTaskId;
      private String partId;
      private String quantity;
      private String taskId;
      private String sendState;

      CutPlatePartBuilder() {
      }

      @JsonProperty("id")
      public CutPlatePart.CutPlatePartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cutInstructionId")
      public CutPlatePart.CutPlatePartBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      @JsonProperty("cutTaskId")
      public CutPlatePart.CutPlatePartBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("partId")
      public CutPlatePart.CutPlatePartBuilder partId(final String partId) {
         this.partId = partId;
         return this;
      }

      @JsonProperty("quantity")
      public CutPlatePart.CutPlatePartBuilder quantity(final String quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("taskId")
      public CutPlatePart.CutPlatePartBuilder taskId(final String taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("sendState")
      public CutPlatePart.CutPlatePartBuilder sendState(final String sendState) {
         this.sendState = sendState;
         return this;
      }

      public CutPlatePart build() {
         return new CutPlatePart(this.id, this.cutInstructionId, this.cutTaskId, this.partId, this.quantity, this.taskId, this.sendState);
      }

      @Override
      public String toString() {
         return "CutPlatePart.CutPlatePartBuilder(id="
            + this.id
            + ", cutInstructionId="
            + this.cutInstructionId
            + ", cutTaskId="
            + this.cutTaskId
            + ", partId="
            + this.partId
            + ", quantity="
            + this.quantity
            + ", taskId="
            + this.taskId
            + ", sendState="
            + this.sendState
            + ")";
      }
   }
}
