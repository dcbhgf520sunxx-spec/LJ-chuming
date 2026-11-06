package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProjectCostDTO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "合同编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "项目名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "businessType", notes = "业务类型 1.加工承揽  2.项目承包")
   @JsonProperty("businessType")
   @JSONField(name = "businessType")
   private Integer businessType;
   @ApiModelProperty(name = "collectionAmount", notes = "项目已收款额")
   @JsonProperty("collectionAmount")
   @JSONField(name = "collectionAmount")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "payAmount", notes = "支出金额")
   @JsonProperty("payAmount")
   @JSONField(name = "payAmount")
   private BigDecimal payAmount;

   public static ProjectCostDTO.ProjectCostDTOBuilder builder() {
      return new ProjectCostDTO.ProjectCostDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getPayAmount() {
      return this.payAmount;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("shortName")
   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   @JsonProperty("businessType")
   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   @JsonProperty("collectionAmount")
   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   @JsonProperty("payAmount")
   public void setPayAmount(final BigDecimal payAmount) {
      this.payAmount = payAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCostDTO)) {
         return false;
      }

      ProjectCostDTO other = (ProjectCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$businessType = this.getBusinessType();
         Object other$businessType = other.getBusinessType();
         if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$collectionAmount = this.getCollectionAmount();
                     Object other$collectionAmount = other.getCollectionAmount();
                     if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
                        Object this$payAmount = this.getPayAmount();
                        Object other$payAmount = other.getPayAmount();
                        return this$payAmount == null ? other$payAmount == null : this$payAmount.equals(other$payAmount);
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
      return other instanceof ProjectCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $payAmount = this.getPayAmount();
      return result * 59 + ($payAmount == null ? 43 : $payAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCostDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", businessType="
         + this.getBusinessType()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", payAmount="
         + this.getPayAmount()
         + ")";
   }

   public ProjectCostDTO(
      final Long id,
      final String serialNumber,
      final String name,
      final String shortName,
      final Integer businessType,
      final BigDecimal collectionAmount,
      final BigDecimal payAmount
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.businessType = businessType;
      this.collectionAmount = collectionAmount;
      this.payAmount = payAmount;
   }

   public ProjectCostDTO() {
   }

   public static class ProjectCostDTOBuilder {
      private Long id;
      private String serialNumber;
      private String name;
      private String shortName;
      private Integer businessType;
      private BigDecimal collectionAmount;
      private BigDecimal payAmount;

      ProjectCostDTOBuilder() {
      }

      @JsonProperty("id")
      public ProjectCostDTO.ProjectCostDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectCostDTO.ProjectCostDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ProjectCostDTO.ProjectCostDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public ProjectCostDTO.ProjectCostDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("businessType")
      public ProjectCostDTO.ProjectCostDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      @JsonProperty("collectionAmount")
      public ProjectCostDTO.ProjectCostDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      @JsonProperty("payAmount")
      public ProjectCostDTO.ProjectCostDTOBuilder payAmount(final BigDecimal payAmount) {
         this.payAmount = payAmount;
         return this;
      }

      public ProjectCostDTO build() {
         return new ProjectCostDTO(this.id, this.serialNumber, this.name, this.shortName, this.businessType, this.collectionAmount, this.payAmount);
      }

      @Override
      public String toString() {
         return "ProjectCostDTO.ProjectCostDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", businessType="
            + this.businessType
            + ", collectionAmount="
            + this.collectionAmount
            + ", payAmount="
            + this.payAmount
            + ")";
      }
   }
}
