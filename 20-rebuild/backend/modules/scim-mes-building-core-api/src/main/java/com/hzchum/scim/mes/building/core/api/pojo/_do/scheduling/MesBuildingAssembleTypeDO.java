package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingAssembleTypeDO", description = "组装类型信息")
public class MesBuildingAssembleTypeDO {
   @ApiModelProperty(name = "assembleConfigid", value = "组装配置id")
   @JsonProperty("assembleConfigid")
   @JSONField(name = "assembleConfigid")
   private Long assembleConfigId;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   private Integer mesProductEnum;

   public static MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder builder() {
      return new MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder();
   }

   public MesBuildingAssembleTypeDO(
      final Long assembleConfigId,
      final String name,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final Integer mesProductEnum
   ) {
      this.assembleConfigId = assembleConfigId;
      this.name = name;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.mesProductEnum = mesProductEnum;
   }

   public MesBuildingAssembleTypeDO() {
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("assembleConfigid")
   public MesBuildingAssembleTypeDO setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingAssembleTypeDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAssembleTypeDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingAssembleTypeDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingAssembleTypeDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public MesBuildingAssembleTypeDO setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleTypeDO(assembleConfigId="
         + this.getAssembleConfigId()
         + ", name="
         + this.getName()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleTypeDO)) {
         return false;
      }

      MesBuildingAssembleTypeDO other = (MesBuildingAssembleTypeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$assembleConfigId = this.getAssembleConfigId();
      Object other$assembleConfigId = other.getAssembleConfigId();
      if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$mesProductEnum = this.getMesProductEnum();
            Object other$mesProductEnum = other.getMesProductEnum();
            if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$netWeight = this.getNetWeight();
                  Object other$netWeight = other.getNetWeight();
                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                     Object this$totalNetWeight = this.getTotalNetWeight();
                     Object other$totalNetWeight = other.getTotalNetWeight();
                     return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
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
      return other instanceof MesBuildingAssembleTypeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   public static class MesBuildingAssembleTypeDOBuilder {
      private Long assembleConfigId;
      private String name;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private Integer mesProductEnum;

      MesBuildingAssembleTypeDOBuilder() {
      }

      @JsonProperty("assembleConfigid")
      public MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesBuildingAssembleTypeDO build() {
         return new MesBuildingAssembleTypeDO(this.assembleConfigId, this.name, this.quantity, this.netWeight, this.totalNetWeight, this.mesProductEnum);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleTypeDO.MesBuildingAssembleTypeDOBuilder(assembleConfigId="
            + this.assembleConfigId
            + ", name="
            + this.name
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
