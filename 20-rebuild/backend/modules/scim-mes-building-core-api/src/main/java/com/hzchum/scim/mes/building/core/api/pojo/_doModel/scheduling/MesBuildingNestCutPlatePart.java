package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

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

@ApiModel(value = "MesBuildingNestCutPlatePart对象", description = "")
@Entity
@TableName("mes_building_nest_cut_plate_part")
@Table(name = "mes_building_nest_cut_plate_part")
public class MesBuildingNestCutPlatePart extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cutInstructionId", value = "切割指令号=nc文件编号", notes = "切割指令号=nc文件编号")
   @JsonProperty("cutInstructionId")
   @JSONField(name = "cutInstructionId")
   @TableField("cut_instruction_id")
   @Column(name = "cut_instruction_id", columnDefinition = "varchar(255)  COMMENT '切割指令号=nc文件编号'", nullable = true)
   private String cutInstructionId;
   @ApiModelProperty(name = "mesBuildingNestCutPlateId", value = "切割指令号=nc文件编号", notes = "切割指令号=nc文件编号")
   @JsonProperty("mesBuildingNestCutPlateId")
   @JSONField(name = "mesBuildingNestCutPlateId")
   @TableField("mes_building_nest_cut_plate_id")
   @Column(name = "mes_building_nest_cut_plate_id", columnDefinition = "bigint(20)  COMMENT '切割指令id'", nullable = false)
   private Long mesBuildingNestCutPlateId;
   @ApiModelProperty(name = "cutTaskId")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutTaskId;
   @ApiModelProperty(name = "taskOrderId")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'")
   private Long taskOrderId;
   @ApiModelProperty(name = "partId")
   @JsonProperty("partId")
   @JSONField(name = "partId")
   @TableField("part_id")
   @Column(name = "part_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = true)
   private Long partId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = true)
   private Integer quantity;
   @ApiModelProperty(name = "complete_quantity", value = "完成数量", notes = "完成数量")
   @JsonProperty("complete_quantity")
   @JSONField(name = "complete_quantity")
   @TableField("complete_quantity")
   @Column(name = "complete_quantity", columnDefinition = "int(11) default '0' COMMENT '完成数量'", nullable = true)
   private Integer completeQuantity;
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
   @ApiModelProperty(name = "boolCompleteEnum", value = "是否完成", notes = "是否完成")
   @JsonProperty("boolCompleteEnum")
   @JSONField(name = "boolCompleteEnum")
   @TableField("bool_complete_enum")
   @Column(name = "bool_complete_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否完成' ", nullable = false)
   private Boolean boolCompleteEnum;
   @ApiModelProperty(name = "labelStatus", value = "打标状态", notes = "打标状态")
   @JsonProperty("labelStatus")
   @JSONField(name = "labelStatus")
   @TableField("label_status")
   @Column(name = "label_status", columnDefinition = "tinyint(1) default '0' COMMENT '打标状态' ", nullable = false)
   private Integer labelStatus;

   public static MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder builder() {
      return new MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder();
   }

   public MesBuildingNestCutPlatePart() {
   }

   public MesBuildingNestCutPlatePart(
      final Long id,
      final String cutInstructionId,
      final Long mesBuildingNestCutPlateId,
      final String cutTaskId,
      final Long taskOrderId,
      final Long partId,
      final Integer quantity,
      final Integer completeQuantity,
      final String taskId,
      final String sendState,
      final Boolean boolCompleteEnum,
      final Integer labelStatus
   ) {
      this.id = id;
      this.cutInstructionId = cutInstructionId;
      this.mesBuildingNestCutPlateId = mesBuildingNestCutPlateId;
      this.cutTaskId = cutTaskId;
      this.taskOrderId = taskOrderId;
      this.partId = partId;
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.taskId = taskId;
      this.sendState = sendState;
      this.boolCompleteEnum = boolCompleteEnum;
      this.labelStatus = labelStatus;
   }

   public Long getId() {
      return this.id;
   }

   public String getCutInstructionId() {
      return this.cutInstructionId;
   }

   public Long getMesBuildingNestCutPlateId() {
      return this.mesBuildingNestCutPlateId;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getPartId() {
      return this.partId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public String getTaskId() {
      return this.taskId;
   }

   public String getSendState() {
      return this.sendState;
   }

   public Boolean getBoolCompleteEnum() {
      return this.boolCompleteEnum;
   }

   public Integer getLabelStatus() {
      return this.labelStatus;
   }

   @JsonProperty("id")
   public MesBuildingNestCutPlatePart setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cutInstructionId")
   public MesBuildingNestCutPlatePart setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
      return this;
   }

   @JsonProperty("mesBuildingNestCutPlateId")
   public MesBuildingNestCutPlatePart setMesBuildingNestCutPlateId(final Long mesBuildingNestCutPlateId) {
      this.mesBuildingNestCutPlateId = mesBuildingNestCutPlateId;
      return this;
   }

   @JsonProperty("cutTaskId")
   public MesBuildingNestCutPlatePart setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingNestCutPlatePart setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("partId")
   public MesBuildingNestCutPlatePart setPartId(final Long partId) {
      this.partId = partId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingNestCutPlatePart setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("complete_quantity")
   public MesBuildingNestCutPlatePart setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingNestCutPlatePart setTaskId(final String taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("sendState")
   public MesBuildingNestCutPlatePart setSendState(final String sendState) {
      this.sendState = sendState;
      return this;
   }

   @JsonProperty("boolCompleteEnum")
   public MesBuildingNestCutPlatePart setBoolCompleteEnum(final Boolean boolCompleteEnum) {
      this.boolCompleteEnum = boolCompleteEnum;
      return this;
   }

   @JsonProperty("labelStatus")
   public MesBuildingNestCutPlatePart setLabelStatus(final Integer labelStatus) {
      this.labelStatus = labelStatus;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestCutPlatePart(id="
         + this.getId()
         + ", cutInstructionId="
         + this.getCutInstructionId()
         + ", mesBuildingNestCutPlateId="
         + this.getMesBuildingNestCutPlateId()
         + ", cutTaskId="
         + this.getCutTaskId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", partId="
         + this.getPartId()
         + ", quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", taskId="
         + this.getTaskId()
         + ", sendState="
         + this.getSendState()
         + ", boolCompleteEnum="
         + this.getBoolCompleteEnum()
         + ", labelStatus="
         + this.getLabelStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestCutPlatePart)) {
         return false;
      }

      MesBuildingNestCutPlatePart other = (MesBuildingNestCutPlatePart)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$mesBuildingNestCutPlateId = this.getMesBuildingNestCutPlateId();
         Object other$mesBuildingNestCutPlateId = other.getMesBuildingNestCutPlateId();
         if (this$mesBuildingNestCutPlateId == null
            ? other$mesBuildingNestCutPlateId == null
            : this$mesBuildingNestCutPlateId.equals(other$mesBuildingNestCutPlateId)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$partId = this.getPartId();
               Object other$partId = other.getPartId();
               if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$completeQuantity = this.getCompleteQuantity();
                     Object other$completeQuantity = other.getCompleteQuantity();
                     if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                        Object this$boolCompleteEnum = this.getBoolCompleteEnum();
                        Object other$boolCompleteEnum = other.getBoolCompleteEnum();
                        if (this$boolCompleteEnum == null ? other$boolCompleteEnum == null : this$boolCompleteEnum.equals(other$boolCompleteEnum)) {
                           Object this$labelStatus = this.getLabelStatus();
                           Object other$labelStatus = other.getLabelStatus();
                           if (this$labelStatus == null ? other$labelStatus == null : this$labelStatus.equals(other$labelStatus)) {
                              Object this$cutInstructionId = this.getCutInstructionId();
                              Object other$cutInstructionId = other.getCutInstructionId();
                              if (this$cutInstructionId == null ? other$cutInstructionId == null : this$cutInstructionId.equals(other$cutInstructionId)) {
                                 Object this$cutTaskId = this.getCutTaskId();
                                 Object other$cutTaskId = other.getCutTaskId();
                                 if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
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
      return other instanceof MesBuildingNestCutPlatePart;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mesBuildingNestCutPlateId = this.getMesBuildingNestCutPlateId();
      result = result * 59 + ($mesBuildingNestCutPlateId == null ? 43 : $mesBuildingNestCutPlateId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $partId = this.getPartId();
      result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $boolCompleteEnum = this.getBoolCompleteEnum();
      result = result * 59 + ($boolCompleteEnum == null ? 43 : $boolCompleteEnum.hashCode());
      Object $labelStatus = this.getLabelStatus();
      result = result * 59 + ($labelStatus == null ? 43 : $labelStatus.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $sendState = this.getSendState();
      return result * 59 + ($sendState == null ? 43 : $sendState.hashCode());
   }

   public static class MesBuildingNestCutPlatePartBuilder {
      private Long id;
      private String cutInstructionId;
      private Long mesBuildingNestCutPlateId;
      private String cutTaskId;
      private Long taskOrderId;
      private Long partId;
      private Integer quantity;
      private Integer completeQuantity;
      private String taskId;
      private String sendState;
      private Boolean boolCompleteEnum;
      private Integer labelStatus;

      MesBuildingNestCutPlatePartBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cutInstructionId")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      @JsonProperty("mesBuildingNestCutPlateId")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder mesBuildingNestCutPlateId(final Long mesBuildingNestCutPlateId) {
         this.mesBuildingNestCutPlateId = mesBuildingNestCutPlateId;
         return this;
      }

      @JsonProperty("cutTaskId")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("partId")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder partId(final Long partId) {
         this.partId = partId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("complete_quantity")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder taskId(final String taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("sendState")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder sendState(final String sendState) {
         this.sendState = sendState;
         return this;
      }

      @JsonProperty("boolCompleteEnum")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder boolCompleteEnum(final Boolean boolCompleteEnum) {
         this.boolCompleteEnum = boolCompleteEnum;
         return this;
      }

      @JsonProperty("labelStatus")
      public MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder labelStatus(final Integer labelStatus) {
         this.labelStatus = labelStatus;
         return this;
      }

      public MesBuildingNestCutPlatePart build() {
         return new MesBuildingNestCutPlatePart(
            this.id,
            this.cutInstructionId,
            this.mesBuildingNestCutPlateId,
            this.cutTaskId,
            this.taskOrderId,
            this.partId,
            this.quantity,
            this.completeQuantity,
            this.taskId,
            this.sendState,
            this.boolCompleteEnum,
            this.labelStatus
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestCutPlatePart.MesBuildingNestCutPlatePartBuilder(id="
            + this.id
            + ", cutInstructionId="
            + this.cutInstructionId
            + ", mesBuildingNestCutPlateId="
            + this.mesBuildingNestCutPlateId
            + ", cutTaskId="
            + this.cutTaskId
            + ", taskOrderId="
            + this.taskOrderId
            + ", partId="
            + this.partId
            + ", quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", taskId="
            + this.taskId
            + ", sendState="
            + this.sendState
            + ", boolCompleteEnum="
            + this.boolCompleteEnum
            + ", labelStatus="
            + this.labelStatus
            + ")";
      }
   }
}
