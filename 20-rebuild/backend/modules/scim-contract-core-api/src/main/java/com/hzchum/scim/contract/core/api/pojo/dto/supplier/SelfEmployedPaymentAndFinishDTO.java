package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;

@ApiModel("自合营付款与结算")
public class SelfEmployedPaymentAndFinishDTO {
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("银行信息")
   private Map<String, String> paymentDto;
   @ApiModelProperty("采购合同累计付款和累计开票")
   private List<SupplierSelfEmployedDto> invoiceDto;

   SelfEmployedPaymentAndFinishDTO(final String projectName, final Map<String, String> paymentDto, final List<SupplierSelfEmployedDto> invoiceDto) {
      this.projectName = projectName;
      this.paymentDto = paymentDto;
      this.invoiceDto = invoiceDto;
   }

   public static SelfEmployedPaymentAndFinishDTO.SelfEmployedPaymentAndFinishDTOBuilder builder() {
      return new SelfEmployedPaymentAndFinishDTO.SelfEmployedPaymentAndFinishDTOBuilder();
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Map<String, String> getPaymentDto() {
      return this.paymentDto;
   }

   public List<SupplierSelfEmployedDto> getInvoiceDto() {
      return this.invoiceDto;
   }

   public SelfEmployedPaymentAndFinishDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public SelfEmployedPaymentAndFinishDTO setPaymentDto(final Map<String, String> paymentDto) {
      this.paymentDto = paymentDto;
      return this;
   }

   public SelfEmployedPaymentAndFinishDTO setInvoiceDto(final List<SupplierSelfEmployedDto> invoiceDto) {
      this.invoiceDto = invoiceDto;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SelfEmployedPaymentAndFinishDTO)) {
         return false;
      }

      SelfEmployedPaymentAndFinishDTO other = (SelfEmployedPaymentAndFinishDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$paymentDto = this.getPaymentDto();
         Object other$paymentDto = other.getPaymentDto();
         if (this$paymentDto == null ? other$paymentDto == null : this$paymentDto.equals(other$paymentDto)) {
            Object this$invoiceDto = this.getInvoiceDto();
            Object other$invoiceDto = other.getInvoiceDto();
            return this$invoiceDto == null ? other$invoiceDto == null : this$invoiceDto.equals(other$invoiceDto);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SelfEmployedPaymentAndFinishDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $paymentDto = this.getPaymentDto();
      result = result * 59 + ($paymentDto == null ? 43 : $paymentDto.hashCode());
      Object $invoiceDto = this.getInvoiceDto();
      return result * 59 + ($invoiceDto == null ? 43 : $invoiceDto.hashCode());
   }

   @Override
   public String toString() {
      return "SelfEmployedPaymentAndFinishDTO(projectName="
         + this.getProjectName()
         + ", paymentDto="
         + this.getPaymentDto()
         + ", invoiceDto="
         + this.getInvoiceDto()
         + ")";
   }

   public static class SelfEmployedPaymentAndFinishDTOBuilder {
      private String projectName;
      private Map<String, String> paymentDto;
      private List<SupplierSelfEmployedDto> invoiceDto;

      SelfEmployedPaymentAndFinishDTOBuilder() {
      }

      public SelfEmployedPaymentAndFinishDTO.SelfEmployedPaymentAndFinishDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SelfEmployedPaymentAndFinishDTO.SelfEmployedPaymentAndFinishDTOBuilder paymentDto(final Map<String, String> paymentDto) {
         this.paymentDto = paymentDto;
         return this;
      }

      public SelfEmployedPaymentAndFinishDTO.SelfEmployedPaymentAndFinishDTOBuilder invoiceDto(final List<SupplierSelfEmployedDto> invoiceDto) {
         this.invoiceDto = invoiceDto;
         return this;
      }

      public SelfEmployedPaymentAndFinishDTO build() {
         return new SelfEmployedPaymentAndFinishDTO(this.projectName, this.paymentDto, this.invoiceDto);
      }

      @Override
      public String toString() {
         return "SelfEmployedPaymentAndFinishDTO.SelfEmployedPaymentAndFinishDTOBuilder(projectName="
            + this.projectName
            + ", paymentDto="
            + this.paymentDto
            + ", invoiceDto="
            + this.invoiceDto
            + ")";
      }
   }
}
