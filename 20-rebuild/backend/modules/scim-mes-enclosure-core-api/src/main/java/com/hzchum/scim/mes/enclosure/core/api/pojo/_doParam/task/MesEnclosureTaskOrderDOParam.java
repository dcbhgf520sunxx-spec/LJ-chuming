package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureTaskOrderDOParam", description = "任务工单分配表 ")
public class MesEnclosureTaskOrderDOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", value = "区域id", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "status", value = "状态 [0 暂停, 1 正常]", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Boolean status;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "printQuantity", value = "打印次数", notes = "打印次数")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   private Integer printQuantity;

   protected MesEnclosureTaskOrderDOParam(final MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilder<?, ?> b) {
      this.id = b.id;
      this.factoryId = b.factoryId;
      this.workshopId = b.workshopId;
      this.productionLineId = b.productionLineId;
      this.groupsId = b.groupsId;
      this.projectId = b.projectId;
      this.monomerId = b.monomerId;
      this.planId = b.planId;
      this.productType = b.productType;
      this.askCompleteTime = b.askCompleteTime;
      this.completeTime = b.completeTime;
      this.status = b.status;
      this.userId = b.userId;
      this.orderNumber = b.orderNumber;
      this.quantity = b.quantity;
      this.printQuantity = b.printQuantity;
   }

   public static MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilder<?, ?> builder() {
      return new MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilderImpl();
   }

   public MesEnclosureTaskOrderDOParam() {
   }

   public MesEnclosureTaskOrderDOParam(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Integer productType,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Boolean status,
      final Long userId,
      final String orderNumber,
      final Integer quantity,
      final Integer printQuantity
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.productType = productType;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.status = status;
      this.userId = userId;
      this.orderNumber = orderNumber;
      this.quantity = quantity;
      this.printQuantity = printQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   @JsonProperty("id")
   public MesEnclosureTaskOrderDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTaskOrderDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureTaskOrderDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTaskOrderDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureTaskOrderDOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureTaskOrderDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureTaskOrderDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureTaskOrderDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureTaskOrderDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTaskOrderDOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureTaskOrderDOParam setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureTaskOrderDOParam setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTaskOrderDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesEnclosureTaskOrderDOParam setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureTaskOrderDOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesEnclosureTaskOrderDOParam setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderDOParam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", productType="
         + this.getProductType()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", quantity="
         + this.getQuantity()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderDOParam)) {
         return false;
      }

      MesEnclosureTaskOrderDOParam other = (MesEnclosureTaskOrderDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$groupsId = this.getGroupsId();
                  Object other$groupsId = other.getGroupsId();
                  if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$planId = this.getPlanId();
                           Object other$planId = other.getPlanId();
                           if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                 Object this$status = this.getStatus();
                                 Object other$status = other.getStatus();
                                 if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$printQuantity = this.getPrintQuantity();
                                          Object other$printQuantity = other.getPrintQuantity();
                                          if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                             Object this$askCompleteTime = this.getAskCompleteTime();
                                             Object other$askCompleteTime = other.getAskCompleteTime();
                                             if (this$askCompleteTime == null
                                                ? other$askCompleteTime == null
                                                : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                Object this$completeTime = this.getCompleteTime();
                                                Object other$completeTime = other.getCompleteTime();
                                                if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                                                   Object this$orderNumber = this.getOrderNumber();
                                                   Object other$orderNumber = other.getOrderNumber();
                                                   return this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskOrderDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   public abstract static class MesEnclosureTaskOrderDOParamBuilder<C extends MesEnclosureTaskOrderDOParam, B extends MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilder<C, B>> {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Integer productType;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Boolean status;
      private Long userId;
      private String orderNumber;
      private Integer quantity;
      private Integer printQuantity;

      protected abstract B self();

      public abstract C build();

      @JsonProperty("id")
      public B id(final Long id) {
         this.id = id;
         return this.self();
      }

      @JsonProperty("factoryId")
      public B factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this.self();
      }

      @JsonProperty("workshopId")
      public B workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this.self();
      }

      @JsonProperty("productionLineId")
      public B productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this.self();
      }

      @JsonProperty("groupsId")
      public B groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this.self();
      }

      @JsonProperty("projectId")
      public B projectId(final Long projectId) {
         this.projectId = projectId;
         return this.self();
      }

      @JsonProperty("monomerId")
      public B monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this.self();
      }

      @JsonProperty("planId")
      public B planId(final Long planId) {
         this.planId = planId;
         return this.self();
      }

      @JsonProperty("productType")
      public B productType(final Integer productType) {
         this.productType = productType;
         return this.self();
      }

      @JsonProperty("askCompleteTime")
      public B askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this.self();
      }

      @JsonProperty("completeTime")
      public B completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this.self();
      }

      @JsonProperty("status")
      public B status(final Boolean status) {
         this.status = status;
         return this.self();
      }

      @JsonProperty("userId")
      public B userId(final Long userId) {
         this.userId = userId;
         return this.self();
      }

      @JsonProperty("orderNumber")
      public B orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this.self();
      }

      @JsonProperty("quantity")
      public B quantity(final Integer quantity) {
         this.quantity = quantity;
         return this.self();
      }

      @JsonProperty("printQuantity")
      public B printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this.self();
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", productType="
            + this.productType
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ", orderNumber="
            + this.orderNumber
            + ", quantity="
            + this.quantity
            + ", printQuantity="
            + this.printQuantity
            + ")";
      }
   }

   private static final class MesEnclosureTaskOrderDOParamBuilderImpl
      extends MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilder<MesEnclosureTaskOrderDOParam, MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilderImpl> {
      private MesEnclosureTaskOrderDOParamBuilderImpl() {
      }

      protected MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilderImpl self() {
         return this;
      }

      @Override
      public MesEnclosureTaskOrderDOParam build() {
         return new MesEnclosureTaskOrderDOParam(this);
      }
   }
}
