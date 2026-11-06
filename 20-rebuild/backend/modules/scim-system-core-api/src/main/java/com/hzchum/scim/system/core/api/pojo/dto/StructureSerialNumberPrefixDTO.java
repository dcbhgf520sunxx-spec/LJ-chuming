package com.hzchum.scim.system.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StructureSerialNumberSpecPrefixDTO", description = "构件编号前缀")
public class StructureSerialNumberPrefixDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀", notes = "编号前缀")
   @JsonProperty("serialNumberPrefix")
   @JSONField(name = "serialNumberPrefix")
   private String serialNumberPrefix;
   @ApiModelProperty(name = "newSerialNumberPrefix", value = "编号前缀（新）", notes = "编号前缀（新）")
   @JsonProperty("newSerialNumberPrefix")
   @JSONField(name = "newSerialNumberPrefix")
   private String newSerialNumberPrefix;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", notes = "生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("变更类型 1新增 2删除 3修改 4未修改")
   private Integer changeType;

   public static StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder builder() {
      return new StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder();
   }

   public StructureSerialNumberPrefixDTO() {
   }

   public StructureSerialNumberPrefixDTO(
      final Long id, final String serialNumberPrefix, final String newSerialNumberPrefix, final Integer productionLineTypeEnum, final Integer changeType
   ) {
      this.id = id;
      this.serialNumberPrefix = serialNumberPrefix;
      this.newSerialNumberPrefix = newSerialNumberPrefix;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.changeType = changeType;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public String getNewSerialNumberPrefix() {
      return this.newSerialNumberPrefix;
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

   @JsonProperty("serialNumberPrefix")
   public void setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
   }

   @JsonProperty("newSerialNumberPrefix")
   public void setNewSerialNumberPrefix(final String newSerialNumberPrefix) {
      this.newSerialNumberPrefix = newSerialNumberPrefix;
   }

   @JsonProperty("productionLineTypeEnum")
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

      if (!(o instanceof StructureSerialNumberPrefixDTO)) {
         return false;
      }

      StructureSerialNumberPrefixDTO other = (StructureSerialNumberPrefixDTO)o;
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
               Object this$serialNumberPrefix = this.getSerialNumberPrefix();
               Object other$serialNumberPrefix = other.getSerialNumberPrefix();
               if (this$serialNumberPrefix == null ? other$serialNumberPrefix == null : this$serialNumberPrefix.equals(other$serialNumberPrefix)) {
                  Object this$newSerialNumberPrefix = this.getNewSerialNumberPrefix();
                  Object other$newSerialNumberPrefix = other.getNewSerialNumberPrefix();
                  return this$newSerialNumberPrefix == null
                     ? other$newSerialNumberPrefix == null
                     : this$newSerialNumberPrefix.equals(other$newSerialNumberPrefix);
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
      return other instanceof StructureSerialNumberPrefixDTO;
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
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $newSerialNumberPrefix = this.getNewSerialNumberPrefix();
      return result * 59 + ($newSerialNumberPrefix == null ? 43 : $newSerialNumberPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "StructureSerialNumberPrefixDTO(id="
         + this.getId()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", newSerialNumberPrefix="
         + this.getNewSerialNumberPrefix()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", changeType="
         + this.getChangeType()
         + ")";
   }

   public static class StructureSerialNumberPrefixDTOBuilder {
      private Long id;
      private String serialNumberPrefix;
      private String newSerialNumberPrefix;
      private Integer productionLineTypeEnum;
      private Integer changeType;

      StructureSerialNumberPrefixDTOBuilder() {
      }

      @JsonProperty("id")
      public StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumberPrefix")
      public StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      @JsonProperty("newSerialNumberPrefix")
      public StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder newSerialNumberPrefix(final String newSerialNumberPrefix) {
         this.newSerialNumberPrefix = newSerialNumberPrefix;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder changeType(final Integer changeType) {
         this.changeType = changeType;
         return this;
      }

      public StructureSerialNumberPrefixDTO build() {
         return new StructureSerialNumberPrefixDTO(this.id, this.serialNumberPrefix, this.newSerialNumberPrefix, this.productionLineTypeEnum, this.changeType);
      }

      @Override
      public String toString() {
         return "StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder(id="
            + this.id
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", newSerialNumberPrefix="
            + this.newSerialNumberPrefix
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", changeType="
            + this.changeType
            + ")";
      }
   }
}
