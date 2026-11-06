package com.hzchum.scim.contract.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("物流付款显示信息")
public class LogisticsPaymentInfoDTO {
   @ApiModelProperty("属性:1采购品运输 2制成品运输,3零星运输(V2)")
   private Integer type;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("项目id")
   private Long projectId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("项目名称")
   private String projectName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "purchaseId", value = "订单id")
   private Long purchaseId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "serialNumber", value = "订单号")
   private String serialNumber;
   @ApiModelProperty("总运费")
   private BigDecimal freight;
   @ApiModelProperty("已付款额")
   private BigDecimal paymentAmount;

   public static LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder builder() {
      return new LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder();
   }

   public LogisticsPaymentInfoDTO(
      final Integer type,
      final Long projectId,
      final String projectName,
      final Long purchaseId,
      final String serialNumber,
      final BigDecimal freight,
      final BigDecimal paymentAmount
   ) {
      this.type = type;
      this.projectId = projectId;
      this.projectName = projectName;
      this.purchaseId = purchaseId;
      this.serialNumber = serialNumber;
      this.freight = freight;
      this.paymentAmount = paymentAmount;
   }

   public LogisticsPaymentInfoDTO() {
   }

   public Integer getType() {
      return this.type;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsPaymentInfoDTO)) {
         return false;
      }

      LogisticsPaymentInfoDTO other = (LogisticsPaymentInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$freight = this.getFreight();
                     Object other$freight = other.getFreight();
                     if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                        Object this$paymentAmount = this.getPaymentAmount();
                        Object other$paymentAmount = other.getPaymentAmount();
                        return this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount);
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
      return other instanceof LogisticsPaymentInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      return result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsPaymentInfoDTO(type="
         + this.getType()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", freight="
         + this.getFreight()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ")";
   }

   public static class LogisticsPaymentInfoDTOBuilder {
      private Integer type;
      private Long projectId;
      private String projectName;
      private Long purchaseId;
      private String serialNumber;
      private BigDecimal freight;
      private BigDecimal paymentAmount;

      LogisticsPaymentInfoDTOBuilder() {
      }

      public LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public LogisticsPaymentInfoDTO build() {
         return new LogisticsPaymentInfoDTO(this.type, this.projectId, this.projectName, this.purchaseId, this.serialNumber, this.freight, this.paymentAmount);
      }

      @Override
      public String toString() {
         return "LogisticsPaymentInfoDTO.LogisticsPaymentInfoDTOBuilder(type="
            + this.type
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", purchaseId="
            + this.purchaseId
            + ", serialNumber="
            + this.serialNumber
            + ", freight="
            + this.freight
            + ", paymentAmount="
            + this.paymentAmount
            + ")";
      }
   }
}
