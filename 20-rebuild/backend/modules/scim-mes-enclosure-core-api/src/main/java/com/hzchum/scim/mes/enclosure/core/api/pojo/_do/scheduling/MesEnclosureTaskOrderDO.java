package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureTaskOrderDO", description = "任务工单分配表")
public class MesEnclosureTaskOrderDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
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
   @ApiModelProperty(name = "processTypeEnum", value = "零件工单类型", notes = "零件工单类型")
   @JsonProperty("processTypeEnum")
   @JSONField(name = "processTypeEnum")
   private Integer processTypeEnum;
   @ApiModelProperty(name = "layWayConfigId", value = "下料配置id", notes = "下料配置id")
   @JsonProperty("layWayConfigId")
   @JSONField(name = "layWayConfigId")
   private Long layWayConfigId;
   @ApiModelProperty(name = "cutConfigId", value = "下料切割配置id", notes = "下料切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;

   public static MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder builder() {
      return new MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder();
   }

   public MesEnclosureTaskOrderDO() {
   }

   public MesEnclosureTaskOrderDO(
      final Long id,
      final Long groupsId,
      final Long projectId,
      final Integer productType,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Boolean status,
      final Long userId,
      final String orderNumber,
      final Integer quantity,
      final Integer printQuantity,
      final Integer processTypeEnum,
      final Long layWayConfigId,
      final Long cutConfigId
   ) {
      this.id = id;
      this.groupsId = groupsId;
      this.projectId = projectId;
      this.productType = productType;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.status = status;
      this.userId = userId;
      this.orderNumber = orderNumber;
      this.quantity = quantity;
      this.printQuantity = printQuantity;
      this.processTypeEnum = processTypeEnum;
      this.layWayConfigId = layWayConfigId;
      this.cutConfigId = cutConfigId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public Integer getProcessTypeEnum() {
      return this.processTypeEnum;
   }

   public Long getLayWayConfigId() {
      return this.layWayConfigId;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   @JsonProperty("id")
   public MesEnclosureTaskOrderDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureTaskOrderDO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureTaskOrderDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureTaskOrderDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTaskOrderDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureTaskOrderDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureTaskOrderDO setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTaskOrderDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesEnclosureTaskOrderDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureTaskOrderDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesEnclosureTaskOrderDO setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("processTypeEnum")
   public MesEnclosureTaskOrderDO setProcessTypeEnum(final Integer processTypeEnum) {
      this.processTypeEnum = processTypeEnum;
      return this;
   }

   @JsonProperty("layWayConfigId")
   public MesEnclosureTaskOrderDO setLayWayConfigId(final Long layWayConfigId) {
      this.layWayConfigId = layWayConfigId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesEnclosureTaskOrderDO setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderDO(id="
         + this.getId()
         + ", groupsId="
         + this.getGroupsId()
         + ", projectId="
         + this.getProjectId()
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
         + ", processTypeEnum="
         + this.getProcessTypeEnum()
         + ", layWayConfigId="
         + this.getLayWayConfigId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderDO)) {
         return false;
      }

      MesEnclosureTaskOrderDO other = (MesEnclosureTaskOrderDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                              Object this$processTypeEnum = this.getProcessTypeEnum();
                              Object other$processTypeEnum = other.getProcessTypeEnum();
                              if (this$processTypeEnum == null ? other$processTypeEnum == null : this$processTypeEnum.equals(other$processTypeEnum)) {
                                 Object this$layWayConfigId = this.getLayWayConfigId();
                                 Object other$layWayConfigId = other.getLayWayConfigId();
                                 if (this$layWayConfigId == null ? other$layWayConfigId == null : this$layWayConfigId.equals(other$layWayConfigId)) {
                                    Object this$cutConfigId = this.getCutConfigId();
                                    Object other$cutConfigId = other.getCutConfigId();
                                    if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
                                       Object this$askCompleteTime = this.getAskCompleteTime();
                                       Object other$askCompleteTime = other.getAskCompleteTime();
                                       if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskOrderDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
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
      Object $processTypeEnum = this.getProcessTypeEnum();
      result = result * 59 + ($processTypeEnum == null ? 43 : $processTypeEnum.hashCode());
      Object $layWayConfigId = this.getLayWayConfigId();
      result = result * 59 + ($layWayConfigId == null ? 43 : $layWayConfigId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   public static class MesEnclosureTaskOrderDOBuilder {
      private Long id;
      private Long groupsId;
      private Long projectId;
      private Integer productType;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Boolean status;
      private Long userId;
      private String orderNumber;
      private Integer quantity;
      private Integer printQuantity;
      private Integer processTypeEnum;
      private Long layWayConfigId;
      private Long cutConfigId;

      MesEnclosureTaskOrderDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("processTypeEnum")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder processTypeEnum(final Integer processTypeEnum) {
         this.processTypeEnum = processTypeEnum;
         return this;
      }

      @JsonProperty("layWayConfigId")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder layWayConfigId(final Long layWayConfigId) {
         this.layWayConfigId = layWayConfigId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      public MesEnclosureTaskOrderDO build() {
         return new MesEnclosureTaskOrderDO(
            this.id,
            this.groupsId,
            this.projectId,
            this.productType,
            this.askCompleteTime,
            this.completeTime,
            this.status,
            this.userId,
            this.orderNumber,
            this.quantity,
            this.printQuantity,
            this.processTypeEnum,
            this.layWayConfigId,
            this.cutConfigId
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderDO.MesEnclosureTaskOrderDOBuilder(id="
            + this.id
            + ", groupsId="
            + this.groupsId
            + ", projectId="
            + this.projectId
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
            + ", processTypeEnum="
            + this.processTypeEnum
            + ", layWayConfigId="
            + this.layWayConfigId
            + ", cutConfigId="
            + this.cutConfigId
            + ")";
      }
   }
}
