package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("产品扫码任务详情DTO")
public class ScanCodeProductTaskInfoDetailDTO {
   @ApiModelProperty(notes = "工序名称")
   private String processName;
   @ApiModelProperty(notes = "用户名称")
   private String userName;
   @ApiModelProperty(notes = "质检或上报时间")
   private LocalDateTime inspectionOrReportingTime;
   private BigDecimal quantity;
   @ApiModelProperty(notes = "是否质检")
   private Boolean boolInspection;

   public static ScanCodeProductTaskInfoDetailDTO.ScanCodeProductTaskInfoDetailDTOBuilder builder() {
      return new ScanCodeProductTaskInfoDetailDTO.ScanCodeProductTaskInfoDetailDTOBuilder();
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getInspectionOrReportingTime() {
      return this.inspectionOrReportingTime;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Boolean getBoolInspection() {
      return this.boolInspection;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setInspectionOrReportingTime(final LocalDateTime inspectionOrReportingTime) {
      this.inspectionOrReportingTime = inspectionOrReportingTime;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setBoolInspection(final Boolean boolInspection) {
      this.boolInspection = boolInspection;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScanCodeProductTaskInfoDetailDTO)) {
         return false;
      }

      ScanCodeProductTaskInfoDetailDTO other = (ScanCodeProductTaskInfoDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolInspection = this.getBoolInspection();
      Object other$boolInspection = other.getBoolInspection();
      if (this$boolInspection == null ? other$boolInspection == null : this$boolInspection.equals(other$boolInspection)) {
         Object this$processName = this.getProcessName();
         Object other$processName = other.getProcessName();
         if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
            Object this$userName = this.getUserName();
            Object other$userName = other.getUserName();
            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
               Object this$inspectionOrReportingTime = this.getInspectionOrReportingTime();
               Object other$inspectionOrReportingTime = other.getInspectionOrReportingTime();
               if (this$inspectionOrReportingTime == null
                  ? other$inspectionOrReportingTime == null
                  : this$inspectionOrReportingTime.equals(other$inspectionOrReportingTime)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof ScanCodeProductTaskInfoDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolInspection = this.getBoolInspection();
      result = result * 59 + ($boolInspection == null ? 43 : $boolInspection.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $inspectionOrReportingTime = this.getInspectionOrReportingTime();
      result = result * 59 + ($inspectionOrReportingTime == null ? 43 : $inspectionOrReportingTime.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "ScanCodeProductTaskInfoDetailDTO(processName="
         + this.getProcessName()
         + ", userName="
         + this.getUserName()
         + ", inspectionOrReportingTime="
         + this.getInspectionOrReportingTime()
         + ", quantity="
         + this.getQuantity()
         + ", boolInspection="
         + this.getBoolInspection()
         + ")";
   }

   public ScanCodeProductTaskInfoDetailDTO() {
   }

   public ScanCodeProductTaskInfoDetailDTO(
      final String processName, final String userName, final LocalDateTime inspectionOrReportingTime, final BigDecimal quantity, final Boolean boolInspection
   ) {
      this.processName = processName;
      this.userName = userName;
      this.inspectionOrReportingTime = inspectionOrReportingTime;
      this.quantity = quantity;
      this.boolInspection = boolInspection;
   }

   public static class ScanCodeProductTaskInfoDetailDTOBuilder {
      private String processName;
      private String userName;
      private LocalDateTime inspectionOrReportingTime;
      private BigDecimal quantity;
      private Boolean boolInspection;

      ScanCodeProductTaskInfoDetailDTOBuilder() {
      }

      public ScanCodeProductTaskInfoDetailDTO.ScanCodeProductTaskInfoDetailDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public ScanCodeProductTaskInfoDetailDTO.ScanCodeProductTaskInfoDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ScanCodeProductTaskInfoDetailDTO.ScanCodeProductTaskInfoDetailDTOBuilder inspectionOrReportingTime(final LocalDateTime inspectionOrReportingTime) {
         this.inspectionOrReportingTime = inspectionOrReportingTime;
         return this;
      }

      public ScanCodeProductTaskInfoDetailDTO.ScanCodeProductTaskInfoDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ScanCodeProductTaskInfoDetailDTO.ScanCodeProductTaskInfoDetailDTOBuilder boolInspection(final Boolean boolInspection) {
         this.boolInspection = boolInspection;
         return this;
      }

      public ScanCodeProductTaskInfoDetailDTO build() {
         return new ScanCodeProductTaskInfoDetailDTO(this.processName, this.userName, this.inspectionOrReportingTime, this.quantity, this.boolInspection);
      }

      @Override
      public String toString() {
         return "ScanCodeProductTaskInfoDetailDTO.ScanCodeProductTaskInfoDetailDTOBuilder(processName="
            + this.processName
            + ", userName="
            + this.userName
            + ", inspectionOrReportingTime="
            + this.inspectionOrReportingTime
            + ", quantity="
            + this.quantity
            + ", boolInspection="
            + this.boolInspection
            + ")";
      }
   }
}
