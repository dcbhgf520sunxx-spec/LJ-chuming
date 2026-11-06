package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

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
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamName", notes = "班组名称")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;

   public static AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder builder() {
      return new AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder();
   }

   public AppTaskMissingDetailsDTO() {
   }

   public AppTaskMissingDetailsDTO(
      final Long productId,
      final Integer productTypeEnum,
      final Integer missingQuantity,
      final String serialNumber,
      final String specification,
      final Long teamId,
      final String teamName
   ) {
      this.productId = productId;
      this.productTypeEnum = productTypeEnum;
      this.missingQuantity = missingQuantity;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.teamId = teamId;
      this.teamName = teamName;
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

   public String getSpecification() {
      return this.specification;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
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

   @JsonProperty("specification")
   public AppTaskMissingDetailsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("teamId")
   public AppTaskMissingDetailsDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamName")
   public AppTaskMissingDetailsDTO setTeamName(final String teamName) {
      this.teamName = teamName;
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
         + ", specification="
         + this.getSpecification()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
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
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$teamName = this.getTeamName();
                        Object other$teamName = other.getTeamName();
                        return this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName);
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
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $teamName = this.getTeamName();
      return result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
   }

   public static class AppTaskMissingDetailsDTOBuilder {
      private Long productId;
      private Integer productTypeEnum;
      private Integer missingQuantity;
      private String serialNumber;
      private String specification;
      private Long teamId;
      private String teamName;

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

      @JsonProperty("specification")
      public AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("teamId")
      public AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("teamName")
      public AppTaskMissingDetailsDTO.AppTaskMissingDetailsDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public AppTaskMissingDetailsDTO build() {
         return new AppTaskMissingDetailsDTO(
            this.productId, this.productTypeEnum, this.missingQuantity, this.serialNumber, this.specification, this.teamId, this.teamName
         );
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
            + ", specification="
            + this.specification
            + ", teamId="
            + this.teamId
            + ", teamName="
            + this.teamName
            + ")";
      }
   }
}
