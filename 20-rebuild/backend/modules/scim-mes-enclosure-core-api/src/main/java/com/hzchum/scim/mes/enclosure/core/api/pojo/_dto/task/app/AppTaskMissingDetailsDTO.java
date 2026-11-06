package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AppTaskMissingDetailsDTO", description = "缺件详情 ")
public class AppTaskMissingDetailsDTO {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productTypeEnum", notes = "产品类型")
   @JsonProperty("productTypeEnum")
   @JSONField(name = "productTypeEnum")
   private Integer productTypeEnum;
   @ApiModelProperty(name = "missingQuantity", notes = "缺少数量")
   @JsonProperty("missingQuantity")
   @JSONField(name = "missingQuantity")
   private Integer missingQuantity;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;

   public static AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder builder() {
      return new AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder();
   }

   public AppTaskMissingDetailsDTO() {
   }

   public AppTaskMissingDetailsDTO(final Long productId, final Integer productTypeEnum, final Integer missingQuantity, final String serialNumber) {
      this.productId = productId;
      this.productTypeEnum = productTypeEnum;
      this.missingQuantity = missingQuantity;
      this.serialNumber = serialNumber;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Integer getMissingQuantity() {
      return this.missingQuantity;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   @JsonProperty("productId")
   public AppTaskMissingDetailsDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productTypeEnum")
   public AppTaskMissingDetailsDTO setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
      return this;
   }

   @JsonProperty("missingQuantity")
   public AppTaskMissingDetailsDTO setMissingQuantity(final Integer missingQuantity) {
      this.missingQuantity = missingQuantity;
      return this;
   }

   @JsonProperty("serialNumber")
   public AppTaskMissingDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskMissingDetailsDTO(productId="
         + this.getProductId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", missingQuantity="
         + this.getMissingQuantity()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTaskMissingDetailsDTO)) {
         return false;
      }

      AppTaskMissingDetailsDTO other = (AppTaskMissingDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productTypeEnum = this.getProductTypeEnum();
         Object other$productTypeEnum = other.getProductTypeEnum();
         if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
            Object this$missingQuantity = this.getMissingQuantity();
            Object other$missingQuantity = other.getMissingQuantity();
            if (this$missingQuantity == null ? other$missingQuantity == null : this$missingQuantity.equals(other$missingQuantity)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof AppTaskMissingDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $missingQuantity = this.getMissingQuantity();
      result = result * 59 + ($missingQuantity == null ? 43 : $missingQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class AppTaskMissingDetailsDTOBuilder {
      private Long productId;
      private Integer productTypeEnum;
      private Integer missingQuantity;
      private String serialNumber;

      AppTaskMissingDetailsDTOBuilder() {
      }

      @JsonProperty("productId")
      public AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productTypeEnum")
      public AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder productTypeEnum(final Integer productTypeEnum) {
         this.productTypeEnum = productTypeEnum;
         return this;
      }

      @JsonProperty("missingQuantity")
      public AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder missingQuantity(final Integer missingQuantity) {
         this.missingQuantity = missingQuantity;
         return this;
      }

      @JsonProperty("serialNumber")
      public AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AppTaskMissingDetailsDTO build() {
         return new AppTaskMissingDetailsDTO(this.productId, this.productTypeEnum, this.missingQuantity, this.serialNumber);
      }

      @Override
      public String toString() {
         return "AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder(productId="
            + this.productId
            + ", productTypeEnum="
            + this.productTypeEnum
            + ", missingQuantity="
            + this.missingQuantity
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
