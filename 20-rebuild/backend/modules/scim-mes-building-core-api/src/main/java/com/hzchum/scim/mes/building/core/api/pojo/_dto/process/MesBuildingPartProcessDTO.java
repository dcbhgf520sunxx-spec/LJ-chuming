package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingPartProcessDTO对象", description = "")
public class MesBuildingPartProcessDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名称", value = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "productCategoryType", value = "产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]", notes = "产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]")
   @JsonProperty("productCategoryType")
   @JSONField(name = "productCategoryType")
   private Integer productCategoryType;
   @ApiModelProperty(name = "type", notes = "工序类型", value = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式", notes = "零件生产方式[1 数控切割 2 半自动切割]")
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   private Integer partProdMode;

   public static MesBuildingPartProcessDTO.MesBuildingPartProcessDTOBuilder builder() {
      return new MesBuildingPartProcessDTO.MesBuildingPartProcessDTOBuilder();
   }

   public MesBuildingPartProcessDTO() {
   }

   public MesBuildingPartProcessDTO(final Long id, final String name, final Integer productCategoryType, final Integer type, final Integer partProdMode) {
      this.id = id;
      this.name = name;
      this.productCategoryType = productCategoryType;
      this.type = type;
      this.partProdMode = partProdMode;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductCategoryType() {
      return this.productCategoryType;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   @JsonProperty("id")
   public MesBuildingPartProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingPartProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("productCategoryType")
   public MesBuildingPartProcessDTO setProductCategoryType(final Integer productCategoryType) {
      this.productCategoryType = productCategoryType;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingPartProcessDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("partProdMode")
   public MesBuildingPartProcessDTO setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPartProcessDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productCategoryType="
         + this.getProductCategoryType()
         + ", type="
         + this.getType()
         + ", partProdMode="
         + this.getPartProdMode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartProcessDTO)) {
         return false;
      }

      MesBuildingPartProcessDTO other = (MesBuildingPartProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productCategoryType = this.getProductCategoryType();
         Object other$productCategoryType = other.getProductCategoryType();
         if (this$productCategoryType == null ? other$productCategoryType == null : this$productCategoryType.equals(other$productCategoryType)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$partProdMode = this.getPartProdMode();
               Object other$partProdMode = other.getPartProdMode();
               if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesBuildingPartProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productCategoryType = this.getProductCategoryType();
      result = result * 59 + ($productCategoryType == null ? 43 : $productCategoryType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesBuildingPartProcessDTOBuilder {
      private Long id;
      private String name;
      private Integer productCategoryType;
      private Integer type;
      private Integer partProdMode;

      MesBuildingPartProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPartProcessDTO.MesBuildingPartProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingPartProcessDTO.MesBuildingPartProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productCategoryType")
      public MesBuildingPartProcessDTO.MesBuildingPartProcessDTOBuilder productCategoryType(final Integer productCategoryType) {
         this.productCategoryType = productCategoryType;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingPartProcessDTO.MesBuildingPartProcessDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("partProdMode")
      public MesBuildingPartProcessDTO.MesBuildingPartProcessDTOBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      public MesBuildingPartProcessDTO build() {
         return new MesBuildingPartProcessDTO(this.id, this.name, this.productCategoryType, this.type, this.partProdMode);
      }

      @Override
      public String toString() {
         return "MesBuildingPartProcessDTO.MesBuildingPartProcessDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productCategoryType="
            + this.productCategoryType
            + ", type="
            + this.type
            + ", partProdMode="
            + this.partProdMode
            + ")";
      }
   }
}
