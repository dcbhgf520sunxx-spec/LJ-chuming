package com.hzchum.scim.system.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "构件规格配置表dto ")
public class StructureSpecDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty("构件规格前缀")
   private String specPrefix;
   @ApiModelProperty("构件规格前缀值（新）")
   private String newSpecPrefix;
   @ApiModelProperty("产品线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("变更类型 1新增 2删除 3修改 4未修改")
   private Integer changeType;

   public static StructureSpecDTO.StructureSpecDTOBuilder builder() {
      return new StructureSpecDTO.StructureSpecDTOBuilder();
   }

   public StructureSpecDTO() {
   }

   public StructureSpecDTO(final Long id, final String specPrefix, final String newSpecPrefix, final Integer productionLineTypeEnum, final Integer changeType) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.newSpecPrefix = newSpecPrefix;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.changeType = changeType;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getNewSpecPrefix() {
      return this.newSpecPrefix;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getChangeType() {
      return this.changeType;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setNewSpecPrefix(final String newSpecPrefix) {
      this.newSpecPrefix = newSpecPrefix;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setChangeType(final Integer changeType) {
      this.changeType = changeType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureSpecDTO)) {
         return false;
      }

      StructureSpecDTO other = (StructureSpecDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
         if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
            Object this$changeType = this.getChangeType();
            Object other$changeType = other.getChangeType();
            if (this$changeType == null ? other$changeType == null : this$changeType.equals(other$changeType)) {
               Object this$specPrefix = this.getSpecPrefix();
               Object other$specPrefix = other.getSpecPrefix();
               if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                  Object this$newSpecPrefix = this.getNewSpecPrefix();
                  Object other$newSpecPrefix = other.getNewSpecPrefix();
                  return this$newSpecPrefix == null ? other$newSpecPrefix == null : this$newSpecPrefix.equals(other$newSpecPrefix);
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
      return other instanceof StructureSpecDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $changeType = this.getChangeType();
      result = result * 59 + ($changeType == null ? 43 : $changeType.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $newSpecPrefix = this.getNewSpecPrefix();
      return result * 59 + ($newSpecPrefix == null ? 43 : $newSpecPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "StructureSpecDTO(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", newSpecPrefix="
         + this.getNewSpecPrefix()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", changeType="
         + this.getChangeType()
         + ")";
   }

   public static class StructureSpecDTOBuilder {
      private Long id;
      private String specPrefix;
      private String newSpecPrefix;
      private Integer productionLineTypeEnum;
      private Integer changeType;

      StructureSpecDTOBuilder() {
      }

      @JsonProperty("id")
      public StructureSpecDTO.StructureSpecDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StructureSpecDTO.StructureSpecDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public StructureSpecDTO.StructureSpecDTOBuilder newSpecPrefix(final String newSpecPrefix) {
         this.newSpecPrefix = newSpecPrefix;
         return this;
      }

      public StructureSpecDTO.StructureSpecDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public StructureSpecDTO.StructureSpecDTOBuilder changeType(final Integer changeType) {
         this.changeType = changeType;
         return this;
      }

      public StructureSpecDTO build() {
         return new StructureSpecDTO(this.id, this.specPrefix, this.newSpecPrefix, this.productionLineTypeEnum, this.changeType);
      }

      @Override
      public String toString() {
         return "StructureSpecDTO.StructureSpecDTOBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", newSpecPrefix="
            + this.newSpecPrefix
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", changeType="
            + this.changeType
            + ")";
      }
   }
}
