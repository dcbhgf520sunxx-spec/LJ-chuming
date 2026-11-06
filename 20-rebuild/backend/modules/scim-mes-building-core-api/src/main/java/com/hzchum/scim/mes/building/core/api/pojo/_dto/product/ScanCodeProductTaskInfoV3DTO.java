package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("产品V3信息DTO")
public class ScanCodeProductTaskInfoV3DTO {
   @ApiModelProperty(notes = "产品任务Id")
   private Long taskId;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(notes = "码号")
   private Integer number;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;

   public static ScanCodeProductTaskInfoV3DTO.ScanCodeProductTaskInfoV3DTOBuilder builder() {
      return new ScanCodeProductTaskInfoV3DTO.ScanCodeProductTaskInfoV3DTOBuilder();
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScanCodeProductTaskInfoV3DTO)) {
         return false;
      }

      ScanCodeProductTaskInfoV3DTO other = (ScanCodeProductTaskInfoV3DTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               return this$productType == null ? other$productType == null : this$productType.equals(other$productType);
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
      return other instanceof ScanCodeProductTaskInfoV3DTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $productType = this.getProductType();
      return result * 59 + ($productType == null ? 43 : $productType.hashCode());
   }

   @Override
   public String toString() {
      return "ScanCodeProductTaskInfoV3DTO(taskId="
         + this.getTaskId()
         + ", productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", productType="
         + this.getProductType()
         + ")";
   }

   public ScanCodeProductTaskInfoV3DTO(final Long taskId, final Long productId, final Integer number, final Integer productType) {
      this.taskId = taskId;
      this.productId = productId;
      this.number = number;
      this.productType = productType;
   }

   public ScanCodeProductTaskInfoV3DTO() {
   }

   public static class ScanCodeProductTaskInfoV3DTOBuilder {
      private Long taskId;
      private Long productId;
      private Integer number;
      private Integer productType;

      ScanCodeProductTaskInfoV3DTOBuilder() {
      }

      public ScanCodeProductTaskInfoV3DTO.ScanCodeProductTaskInfoV3DTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public ScanCodeProductTaskInfoV3DTO.ScanCodeProductTaskInfoV3DTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ScanCodeProductTaskInfoV3DTO.ScanCodeProductTaskInfoV3DTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public ScanCodeProductTaskInfoV3DTO.ScanCodeProductTaskInfoV3DTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ScanCodeProductTaskInfoV3DTO build() {
         return new ScanCodeProductTaskInfoV3DTO(this.taskId, this.productId, this.number, this.productType);
      }

      @Override
      public String toString() {
         return "ScanCodeProductTaskInfoV3DTO.ScanCodeProductTaskInfoV3DTOBuilder(taskId="
            + this.taskId
            + ", productId="
            + this.productId
            + ", number="
            + this.number
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
