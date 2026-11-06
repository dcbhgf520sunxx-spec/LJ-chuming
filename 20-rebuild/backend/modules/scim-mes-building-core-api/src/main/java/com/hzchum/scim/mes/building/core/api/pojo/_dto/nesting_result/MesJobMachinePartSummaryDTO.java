package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("作业零件汇总信息DTO")
public class MesJobMachinePartSummaryDTO {
   @ApiModelProperty("作业id")
   private Integer jobId;
   @ApiModelProperty("总数")
   private BigDecimal totalQuantity;
   @ApiModelProperty("已套料总数")
   private BigDecimal nestedTotalQuantity;
   @ApiModelProperty("已报总数")
   private BigDecimal reportedTotalQuantity;

   public static MesJobMachinePartSummaryDTO.MesJobMachinePartSummaryDTOBuilder builder() {
      return new MesJobMachinePartSummaryDTO.MesJobMachinePartSummaryDTOBuilder();
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public BigDecimal getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getNestedTotalQuantity() {
      return this.nestedTotalQuantity;
   }

   public BigDecimal getReportedTotalQuantity() {
      return this.reportedTotalQuantity;
   }

   public void setJobId(final Integer jobId) {
      this.jobId = jobId;
   }

   public void setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setNestedTotalQuantity(final BigDecimal nestedTotalQuantity) {
      this.nestedTotalQuantity = nestedTotalQuantity;
   }

   public void setReportedTotalQuantity(final BigDecimal reportedTotalQuantity) {
      this.reportedTotalQuantity = reportedTotalQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesJobMachinePartSummaryDTO)) {
         return false;
      }

      MesJobMachinePartSummaryDTO other = (MesJobMachinePartSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jobId = this.getJobId();
      Object other$jobId = other.getJobId();
      if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
         Object this$totalQuantity = this.getTotalQuantity();
         Object other$totalQuantity = other.getTotalQuantity();
         if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
            Object this$nestedTotalQuantity = this.getNestedTotalQuantity();
            Object other$nestedTotalQuantity = other.getNestedTotalQuantity();
            if (this$nestedTotalQuantity == null ? other$nestedTotalQuantity == null : this$nestedTotalQuantity.equals(other$nestedTotalQuantity)) {
               Object this$reportedTotalQuantity = this.getReportedTotalQuantity();
               Object other$reportedTotalQuantity = other.getReportedTotalQuantity();
               return this$reportedTotalQuantity == null ? other$reportedTotalQuantity == null : this$reportedTotalQuantity.equals(other$reportedTotalQuantity);
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
      return other instanceof MesJobMachinePartSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $nestedTotalQuantity = this.getNestedTotalQuantity();
      result = result * 59 + ($nestedTotalQuantity == null ? 43 : $nestedTotalQuantity.hashCode());
      Object $reportedTotalQuantity = this.getReportedTotalQuantity();
      return result * 59 + ($reportedTotalQuantity == null ? 43 : $reportedTotalQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesJobMachinePartSummaryDTO(jobId="
         + this.getJobId()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", nestedTotalQuantity="
         + this.getNestedTotalQuantity()
         + ", reportedTotalQuantity="
         + this.getReportedTotalQuantity()
         + ")";
   }

   public MesJobMachinePartSummaryDTO() {
   }

   public MesJobMachinePartSummaryDTO(
      final Integer jobId, final BigDecimal totalQuantity, final BigDecimal nestedTotalQuantity, final BigDecimal reportedTotalQuantity
   ) {
      this.jobId = jobId;
      this.totalQuantity = totalQuantity;
      this.nestedTotalQuantity = nestedTotalQuantity;
      this.reportedTotalQuantity = reportedTotalQuantity;
   }

   public static class MesJobMachinePartSummaryDTOBuilder {
      private Integer jobId;
      private BigDecimal totalQuantity;
      private BigDecimal nestedTotalQuantity;
      private BigDecimal reportedTotalQuantity;

      MesJobMachinePartSummaryDTOBuilder() {
      }

      public MesJobMachinePartSummaryDTO.MesJobMachinePartSummaryDTOBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesJobMachinePartSummaryDTO.MesJobMachinePartSummaryDTOBuilder totalQuantity(final BigDecimal totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public MesJobMachinePartSummaryDTO.MesJobMachinePartSummaryDTOBuilder nestedTotalQuantity(final BigDecimal nestedTotalQuantity) {
         this.nestedTotalQuantity = nestedTotalQuantity;
         return this;
      }

      public MesJobMachinePartSummaryDTO.MesJobMachinePartSummaryDTOBuilder reportedTotalQuantity(final BigDecimal reportedTotalQuantity) {
         this.reportedTotalQuantity = reportedTotalQuantity;
         return this;
      }

      public MesJobMachinePartSummaryDTO build() {
         return new MesJobMachinePartSummaryDTO(this.jobId, this.totalQuantity, this.nestedTotalQuantity, this.reportedTotalQuantity);
      }

      @Override
      public String toString() {
         return "MesJobMachinePartSummaryDTO.MesJobMachinePartSummaryDTOBuilder(jobId="
            + this.jobId
            + ", totalQuantity="
            + this.totalQuantity
            + ", nestedTotalQuantity="
            + this.nestedTotalQuantity
            + ", reportedTotalQuantity="
            + this.reportedTotalQuantity
            + ")";
      }
   }
}
