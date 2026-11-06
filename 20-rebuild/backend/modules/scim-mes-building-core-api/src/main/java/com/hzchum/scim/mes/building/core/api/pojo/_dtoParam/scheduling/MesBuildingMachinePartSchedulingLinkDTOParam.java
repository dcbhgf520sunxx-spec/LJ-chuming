package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingMachinePartSchedulingLinkDTOParam", description = "零件排产信息")
public class MesBuildingMachinePartSchedulingLinkDTOParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "orderId", value = "工单id", notes = "工单id")
   @JsonProperty("orderId")
   @JSONField(name = "orderId")
   private String orderId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "排产数量不能为空")
   private Integer quantity;
   @ApiModelProperty(name = "needSchedulingMonth", value = "零件需要排产的日期")
   @JsonProperty("needSchedulingMonth")
   @JSONField(name = "needSchedulingMonth")
   @NotNull(message = "零件需要排产的日期")
   private LocalDateTime needSchedulingMonth;
   @ApiModelProperty(name = "wastageRate", value = "损耗率", notes = "损耗率")
   @JsonProperty("wastageRate")
   @JSONField(name = "wastageRate")
   private BigDecimal wastageRate = BigDecimal.ZERO;

   public static MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder builder() {
      return new MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder();
   }

   public MesBuildingMachinePartSchedulingLinkDTOParam(
      final Long id,
      final String orderId,
      final Long projectId,
      final Long productId,
      final Integer quantity,
      final LocalDateTime needSchedulingMonth,
      final BigDecimal wastageRate
   ) {
      this.id = id;
      this.orderId = orderId;
      this.projectId = projectId;
      this.productId = productId;
      this.quantity = quantity;
      this.needSchedulingMonth = needSchedulingMonth;
      this.wastageRate = wastageRate;
   }

   public MesBuildingMachinePartSchedulingLinkDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public String getOrderId() {
      return this.orderId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getNeedSchedulingMonth() {
      return this.needSchedulingMonth;
   }

   public BigDecimal getWastageRate() {
      return this.wastageRate;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSchedulingLinkDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("orderId")
   public MesBuildingMachinePartSchedulingLinkDTOParam setOrderId(final String orderId) {
      this.orderId = orderId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingMachinePartSchedulingLinkDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingMachinePartSchedulingLinkDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSchedulingLinkDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("needSchedulingMonth")
   public MesBuildingMachinePartSchedulingLinkDTOParam setNeedSchedulingMonth(final LocalDateTime needSchedulingMonth) {
      this.needSchedulingMonth = needSchedulingMonth;
      return this;
   }

   @JsonProperty("wastageRate")
   public MesBuildingMachinePartSchedulingLinkDTOParam setWastageRate(final BigDecimal wastageRate) {
      this.wastageRate = wastageRate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingLinkDTOParam(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", projectId="
         + this.getProjectId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", needSchedulingMonth="
         + this.getNeedSchedulingMonth()
         + ", wastageRate="
         + this.getWastageRate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingLinkDTOParam)) {
         return false;
      }

      MesBuildingMachinePartSchedulingLinkDTOParam other = (MesBuildingMachinePartSchedulingLinkDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$orderId = this.getOrderId();
                  Object other$orderId = other.getOrderId();
                  if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
                     Object this$needSchedulingMonth = this.getNeedSchedulingMonth();
                     Object other$needSchedulingMonth = other.getNeedSchedulingMonth();
                     if (this$needSchedulingMonth == null ? other$needSchedulingMonth == null : this$needSchedulingMonth.equals(other$needSchedulingMonth)) {
                        Object this$wastageRate = this.getWastageRate();
                        Object other$wastageRate = other.getWastageRate();
                        return this$wastageRate == null ? other$wastageRate == null : this$wastageRate.equals(other$wastageRate);
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
      return other instanceof MesBuildingMachinePartSchedulingLinkDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $needSchedulingMonth = this.getNeedSchedulingMonth();
      result = result * 59 + ($needSchedulingMonth == null ? 43 : $needSchedulingMonth.hashCode());
      Object $wastageRate = this.getWastageRate();
      return result * 59 + ($wastageRate == null ? 43 : $wastageRate.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingLinkDTOParamBuilder {
      private Long id;
      private String orderId;
      private Long projectId;
      private Long productId;
      private Integer quantity;
      private LocalDateTime needSchedulingMonth;
      private BigDecimal wastageRate;

      MesBuildingMachinePartSchedulingLinkDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("orderId")
      public MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder orderId(final String orderId) {
         this.orderId = orderId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("needSchedulingMonth")
      public MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder needSchedulingMonth(
         final LocalDateTime needSchedulingMonth
      ) {
         this.needSchedulingMonth = needSchedulingMonth;
         return this;
      }

      @JsonProperty("wastageRate")
      public MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder wastageRate(final BigDecimal wastageRate) {
         this.wastageRate = wastageRate;
         return this;
      }

      public MesBuildingMachinePartSchedulingLinkDTOParam build() {
         return new MesBuildingMachinePartSchedulingLinkDTOParam(
            this.id, this.orderId, this.projectId, this.productId, this.quantity, this.needSchedulingMonth, this.wastageRate
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingLinkDTOParam.MesBuildingMachinePartSchedulingLinkDTOParamBuilder(id="
            + this.id
            + ", orderId="
            + this.orderId
            + ", projectId="
            + this.projectId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", needSchedulingMonth="
            + this.needSchedulingMonth
            + ", wastageRate="
            + this.wastageRate
            + ")";
      }
   }
}
