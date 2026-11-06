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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingTopTaskOrder对象", description = "")
@Entity
@TableName("mes_building_top_task_order")
@Table(name = "mes_building_top_task_order")
public class MesBuildingTopTaskOrder extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
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
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @TableField("order_number")
   @Column(name = "order_number", columnDefinition = "varchar(500)  COMMENT '任务工单号'", nullable = false)
   private String orderNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", notes = "生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default '1' COMMENT '生产线类型 1传统线 2智能线'", nullable = true)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "productionLineId", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id")
   private Long productionLineId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   @TableField("complete_time")
   @Column(name = "complete_time", columnDefinition = "datetime  COMMENT '完成日期'", nullable = true)
   private LocalDateTime completeTime;

   public static MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder builder() {
      return new MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder();
   }

   public MesBuildingTopTaskOrder() {
   }

   public MesBuildingTopTaskOrder(
      final Long id,
      final Long projectId,
      final String orderNumber,
      final Integer quantity,
      final Integer productionLineTypeEnum,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long productionLineId,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.orderNumber = orderNumber;
      this.quantity = quantity;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.productionLineId = productionLineId;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   @JsonProperty("id")
   public MesBuildingTopTaskOrder setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTopTaskOrder setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingTopTaskOrder setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTopTaskOrder setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTopTaskOrder setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingTopTaskOrder setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTopTaskOrder setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingTopTaskOrder setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTopTaskOrder setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTopTaskOrder setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingTopTaskOrder setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTopTaskOrder(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", quantity="
         + this.getQuantity()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTopTaskOrder)) {
         return false;
      }

      MesBuildingTopTaskOrder other = (MesBuildingTopTaskOrder)o;
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
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
               Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
               if (this$productionLineTypeEnum == null
                  ? other$productionLineTypeEnum == null
                  : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$areaBatchId = this.getAreaBatchId();
                        Object other$areaBatchId = other.getAreaBatchId();
                        if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                           Object this$productionLineId = this.getProductionLineId();
                           Object other$productionLineId = other.getProductionLineId();
                           if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                              Object this$orderNumber = this.getOrderNumber();
                              Object other$orderNumber = other.getOrderNumber();
                              if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                 Object this$askCompleteTime = this.getAskCompleteTime();
                                 Object other$askCompleteTime = other.getAskCompleteTime();
                                 if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                    Object this$completeTime = this.getCompleteTime();
                                    Object other$completeTime = other.getCompleteTime();
                                    return this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime);
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
      return other instanceof MesBuildingTopTaskOrder;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesBuildingTopTaskOrderBuilder {
      private Long id;
      private Long projectId;
      private String orderNumber;
      private Integer quantity;
      private Integer productionLineTypeEnum;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long productionLineId;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;

      MesBuildingTopTaskOrderBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      public MesBuildingTopTaskOrder build() {
         return new MesBuildingTopTaskOrder(
            this.id,
            this.projectId,
            this.orderNumber,
            this.quantity,
            this.productionLineTypeEnum,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.productionLineId,
            this.askCompleteTime,
            this.completeTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTopTaskOrder.MesBuildingTopTaskOrderBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", orderNumber="
            + this.orderNumber
            + ", quantity="
            + this.quantity
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", productionLineId="
            + this.productionLineId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ")";
      }
   }
}
