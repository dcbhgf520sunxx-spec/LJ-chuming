package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingProcessDTO对象", description = "")
public class MesBuildingMachinePartProcessDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "price", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式 [0 重量, 1 长度，2 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;

   public static MesBuildingMachinePartProcessDTO.MesBuildingMachinePartProcessDTOBuilder builder() {
      return new MesBuildingMachinePartProcessDTO.MesBuildingMachinePartProcessDTOBuilder();
   }

   public MesBuildingMachinePartProcessDTO() {
   }

   public MesBuildingMachinePartProcessDTO(final Long id, final String name, final BigDecimal price, final Integer wageQuotaType) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.wageQuotaType = wageQuotaType;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingMachinePartProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("price")
   public MesBuildingMachinePartProcessDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingMachinePartProcessDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartProcessDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", price="
         + this.getPrice()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartProcessDTO)) {
         return false;
      }

      MesBuildingMachinePartProcessDTO other = (MesBuildingMachinePartProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wageQuotaType = this.getWageQuotaType();
         Object other$wageQuotaType = other.getWageQuotaType();
         if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesBuildingMachinePartProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesBuildingMachinePartProcessDTOBuilder {
      private Long id;
      private String name;
      private BigDecimal price;
      private Integer wageQuotaType;

      MesBuildingMachinePartProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartProcessDTO.MesBuildingMachinePartProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingMachinePartProcessDTO.MesBuildingMachinePartProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("price")
      public MesBuildingMachinePartProcessDTO.MesBuildingMachinePartProcessDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingMachinePartProcessDTO.MesBuildingMachinePartProcessDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public MesBuildingMachinePartProcessDTO build() {
         return new MesBuildingMachinePartProcessDTO(this.id, this.name, this.price, this.wageQuotaType);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartProcessDTO.MesBuildingMachinePartProcessDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", price="
            + this.price
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
