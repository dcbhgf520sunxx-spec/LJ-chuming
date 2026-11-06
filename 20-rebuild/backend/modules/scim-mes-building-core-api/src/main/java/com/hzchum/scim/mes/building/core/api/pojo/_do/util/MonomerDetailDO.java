package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MonomerDetailDO", description = "项目基础信息")
public class MonomerDetailDO {
   @ApiModelProperty(name = "id", notes = "单体id", value = "单体id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名", value = "单体名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "areaList", notes = "区域信息", value = "区域信息")
   @JsonProperty("areaList")
   @JSONField(name = "areaList")
   @JsonInclude(Include.NON_NULL)
   private List<AreaDetailDO> areaList;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "总净重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "buildingTypeEnum", notes = "建筑类型 buildingTypeEnum 1建钢类型 2桥梁类型 4网架类型")
   private Integer buildingTypeEnum;

   public static MonomerDetailDO.MonomerDetailDOBuilder builder() {
      return new MonomerDetailDO.MonomerDetailDOBuilder();
   }

   public MonomerDetailDO() {
   }

   public MonomerDetailDO(
      final Long id, final String name, final List<AreaDetailDO> areaList, final Integer quantity, final BigDecimal netWeight, final Integer buildingTypeEnum
   ) {
      this.id = id;
      this.name = name;
      this.areaList = areaList;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.buildingTypeEnum = buildingTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<AreaDetailDO> getAreaList() {
      return this.areaList;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getBuildingTypeEnum() {
      return this.buildingTypeEnum;
   }

   @JsonProperty("id")
   public MonomerDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MonomerDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("areaList")
   public MonomerDetailDO setAreaList(final List<AreaDetailDO> areaList) {
      this.areaList = areaList;
      return this;
   }

   @JsonProperty("quantity")
   public MonomerDetailDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MonomerDetailDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public MonomerDetailDO setBuildingTypeEnum(final Integer buildingTypeEnum) {
      this.buildingTypeEnum = buildingTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MonomerDetailDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", areaList="
         + this.getAreaList()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", buildingTypeEnum="
         + this.getBuildingTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonomerDetailDO)) {
         return false;
      }

      MonomerDetailDO other = (MonomerDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$buildingTypeEnum = this.getBuildingTypeEnum();
            Object other$buildingTypeEnum = other.getBuildingTypeEnum();
            if (this$buildingTypeEnum == null ? other$buildingTypeEnum == null : this$buildingTypeEnum.equals(other$buildingTypeEnum)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$areaList = this.getAreaList();
                  Object other$areaList = other.getAreaList();
                  if (this$areaList == null ? other$areaList == null : this$areaList.equals(other$areaList)) {
                     Object this$netWeight = this.getNetWeight();
                     Object other$netWeight = other.getNetWeight();
                     return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof MonomerDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $buildingTypeEnum = this.getBuildingTypeEnum();
      result = result * 59 + ($buildingTypeEnum == null ? 43 : $buildingTypeEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $areaList = this.getAreaList();
      result = result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class MonomerDetailDOBuilder {
      private Long id;
      private String name;
      private List<AreaDetailDO> areaList;
      private Integer quantity;
      private BigDecimal netWeight;
      private Integer buildingTypeEnum;

      MonomerDetailDOBuilder() {
      }

      @JsonProperty("id")
      public MonomerDetailDO.MonomerDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MonomerDetailDO.MonomerDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("areaList")
      public MonomerDetailDO.MonomerDetailDOBuilder areaList(final List<AreaDetailDO> areaList) {
         this.areaList = areaList;
         return this;
      }

      @JsonProperty("quantity")
      public MonomerDetailDO.MonomerDetailDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MonomerDetailDO.MonomerDetailDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MonomerDetailDO.MonomerDetailDOBuilder buildingTypeEnum(final Integer buildingTypeEnum) {
         this.buildingTypeEnum = buildingTypeEnum;
         return this;
      }

      public MonomerDetailDO build() {
         return new MonomerDetailDO(this.id, this.name, this.areaList, this.quantity, this.netWeight, this.buildingTypeEnum);
      }

      @Override
      public String toString() {
         return "MonomerDetailDO.MonomerDetailDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", areaList="
            + this.areaList
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", buildingTypeEnum="
            + this.buildingTypeEnum
            + ")";
      }
   }
}
