package com.hzchum.scim.mes.building.core.api.pojo._doModel.surplus;

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

@ApiModel(value = "MesBuildingProduceSurplus对象", description = "多余产品表 ")
@Entity
@TableName("mes_building_produce_surplus")
@Table(name = "mes_building_produce_surplus")
public class MesBuildingProduceSurplus extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务工序id'", nullable = false)
   private Long taskProcessId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'", nullable = false)
   private Long schedulingId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "生产数量", notes = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '生产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "handleStatus", value = "处理状态 [1 未处理, 2 报废，4二次利用]", notes = "处理状态 [1 未处理, 2 报废，4二次利用]")
   @JsonProperty("handleStatus")
   @JSONField(name = "handleStatus")
   @TableField("handle_status")
   @Column(name = "handle_status", columnDefinition = "int(11) default '1' COMMENT '处理状态 [1 未处理, 2 报废，4二次利用]'", nullable = false)
   private Integer handleStatus;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "abnormalId")
   @JsonProperty("abnormalId")
   @JSONField(name = "abnormalId")
   @TableField("abnormal_id")
   @Column(name = "abnormal_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = true)
   private Long abnormalId;

   public static MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder builder() {
      return new MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder();
   }

   public MesBuildingProduceSurplus() {
   }

   public MesBuildingProduceSurplus(
      final Long id,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
      final Long schedulingId,
      final Long productId,
      final Integer productType,
      final Integer quantity,
      final Long teamId,
      final Integer handleStatus,
      final String remark,
      final Long userId,
      final Long abnormalId
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.productType = productType;
      this.quantity = quantity;
      this.teamId = teamId;
      this.handleStatus = handleStatus;
      this.remark = remark;
      this.userId = userId;
      this.abnormalId = abnormalId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getHandleStatus() {
      return this.handleStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getAbnormalId() {
      return this.abnormalId;
   }

   @JsonProperty("id")
   public MesBuildingProduceSurplus setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingProduceSurplus setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingProduceSurplus setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProduceSurplus setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingProduceSurplus setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProduceSurplus setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProduceSurplus setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingProduceSurplus setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProduceSurplus setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("handleStatus")
   public MesBuildingProduceSurplus setHandleStatus(final Integer handleStatus) {
      this.handleStatus = handleStatus;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingProduceSurplus setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProduceSurplus setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("abnormalId")
   public MesBuildingProduceSurplus setAbnormalId(final Long abnormalId) {
      this.abnormalId = abnormalId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceSurplus(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", processId="
         + this.getProcessId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", teamId="
         + this.getTeamId()
         + ", handleStatus="
         + this.getHandleStatus()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", abnormalId="
         + this.getAbnormalId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceSurplus)) {
         return false;
      }

      MesBuildingProduceSurplus other = (MesBuildingProduceSurplus)o;
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
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$schedulingId = this.getSchedulingId();
                  Object other$schedulingId = other.getSchedulingId();
                  if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$teamId = this.getTeamId();
                              Object other$teamId = other.getTeamId();
                              if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                 Object this$handleStatus = this.getHandleStatus();
                                 Object other$handleStatus = other.getHandleStatus();
                                 if (this$handleStatus == null ? other$handleStatus == null : this$handleStatus.equals(other$handleStatus)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$abnormalId = this.getAbnormalId();
                                       Object other$abnormalId = other.getAbnormalId();
                                       if (this$abnormalId == null ? other$abnormalId == null : this$abnormalId.equals(other$abnormalId)) {
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
      return other instanceof MesBuildingProduceSurplus;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $handleStatus = this.getHandleStatus();
      result = result * 59 + ($handleStatus == null ? 43 : $handleStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $abnormalId = this.getAbnormalId();
      result = result * 59 + ($abnormalId == null ? 43 : $abnormalId.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesBuildingProduceSurplusBuilder {
      private Long id;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
      private Long schedulingId;
      private Long productId;
      private Integer productType;
      private Integer quantity;
      private Long teamId;
      private Integer handleStatus;
      private String remark;
      private Long userId;
      private Long abnormalId;

      MesBuildingProduceSurplusBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("handleStatus")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder handleStatus(final Integer handleStatus) {
         this.handleStatus = handleStatus;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("abnormalId")
      public MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder abnormalId(final Long abnormalId) {
         this.abnormalId = abnormalId;
         return this;
      }

      public MesBuildingProduceSurplus build() {
         return new MesBuildingProduceSurplus(
            this.id,
            this.taskId,
            this.taskProcessId,
            this.processId,
            this.schedulingId,
            this.productId,
            this.productType,
            this.quantity,
            this.teamId,
            this.handleStatus,
            this.remark,
            this.userId,
            this.abnormalId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProduceSurplus.MesBuildingProduceSurplusBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", processId="
            + this.processId
            + ", schedulingId="
            + this.schedulingId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", teamId="
            + this.teamId
            + ", handleStatus="
            + this.handleStatus
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", abnormalId="
            + this.abnormalId
            + ")";
      }
   }
}
