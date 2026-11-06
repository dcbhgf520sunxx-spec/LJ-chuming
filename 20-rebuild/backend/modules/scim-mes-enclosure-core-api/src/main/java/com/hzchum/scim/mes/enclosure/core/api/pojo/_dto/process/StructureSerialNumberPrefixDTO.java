package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

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
   @ApiModelProperty(name = "structureClassificationId", value = "构件科目id", notes = "构件科目id")
   @JsonProperty("structureClassificationId")
   @JSONField(name = "structureClassificationId")
   private Long structureClassificationId;
   @ApiModelProperty(name = "productionLineType", value = "生产线类型 1传统线 2智能线", notes = "生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineType")
   @JSONField(name = "productionLineType")
   private Integer productionLineType;

   public static StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder builder() {
      return new StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder();
   }

   public StructureSerialNumberPrefixDTO() {
   }

   public StructureSerialNumberPrefixDTO(final Long id, final String serialNumberPrefix, final Long structureClassificationId, final Integer productionLineType) {
      this.id = id;
      this.serialNumberPrefix = serialNumberPrefix;
      this.structureClassificationId = structureClassificationId;
      this.productionLineType = productionLineType;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public Integer getProductionLineType() {
      return this.productionLineType;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("serialNumberPrefix")
   public void setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
   }

   @JsonProperty("structureClassificationId")
   public void setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
   }

   @JsonProperty("productionLineType")
   public void setProductionLineType(final Integer productionLineType) {
      this.productionLineType = productionLineType;
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
         Object this$structureClassificationId = this.getStructureClassificationId();
         Object other$structureClassificationId = other.getStructureClassificationId();
         if (this$structureClassificationId == null
            ? other$structureClassificationId == null
            : this$structureClassificationId.equals(other$structureClassificationId)) {
            Object this$productionLineType = this.getProductionLineType();
            Object other$productionLineType = other.getProductionLineType();
            if (this$productionLineType == null ? other$productionLineType == null : this$productionLineType.equals(other$productionLineType)) {
               Object this$serialNumberPrefix = this.getSerialNumberPrefix();
               Object other$serialNumberPrefix = other.getSerialNumberPrefix();
               return this$serialNumberPrefix == null ? other$serialNumberPrefix == null : this$serialNumberPrefix.equals(other$serialNumberPrefix);
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
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $productionLineType = this.getProductionLineType();
      result = result * 59 + ($productionLineType == null ? 43 : $productionLineType.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      return result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "StructureSerialNumberPrefixDTO(id="
         + this.getId()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", productionLineType="
         + this.getProductionLineType()
         + ")";
   }

   public static class StructureSerialNumberPrefixDTOBuilder {
      private Long id;
      private String serialNumberPrefix;
      private Long structureClassificationId;
      private Integer productionLineType;

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

      @JsonProperty("structureClassificationId")
      public StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      @JsonProperty("productionLineType")
      public StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder productionLineType(final Integer productionLineType) {
         this.productionLineType = productionLineType;
         return this;
      }

      public StructureSerialNumberPrefixDTO build() {
         return new StructureSerialNumberPrefixDTO(this.id, this.serialNumberPrefix, this.structureClassificationId, this.productionLineType);
      }

      @Override
      public String toString() {
         return "StructureSerialNumberPrefixDTO.StructureSerialNumberPrefixDTOBuilder(id="
            + this.id
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", productionLineType="
            + this.productionLineType
            + ")";
      }
   }
}
