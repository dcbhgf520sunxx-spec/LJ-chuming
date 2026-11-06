package com.hzchum.scim.mes.building.core.api.pojo._dto.typesetting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingAssembleTaskDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "NestingTaskDTO", description = "套料清单 ")
public class NestingTaskDTO {
   @ApiModelProperty(name = "serialNumber", notes = "套料编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "typesettingAssembleName", notes = "材料属性")
   @JsonProperty("typesettingAssembleName")
   @JSONField(name = "typesettingAssembleName")
   private String typesettingAssembleName;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "套料材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", notes = "母材长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "aLength", notes = "利用长度")
   @JsonProperty("aLength")
   @JSONField(name = "aLength")
   private BigDecimal aLength;
   @ApiModelProperty(name = "lossRate", notes = "损耗率")
   @JsonProperty("lossRate")
   @JSONField(name = "lossRate")
   private BigDecimal lossRate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("部件列表")
   private List<MesBuildingAssembleTaskDTO> assembleList;

   public static NestingTaskDTO.NestingTaskDTOBuilder builder() {
      return new NestingTaskDTO.NestingTaskDTOBuilder();
   }

   public NestingTaskDTO() {
   }

   public NestingTaskDTO(
      final String serialNumber,
      final String typesettingAssembleName,
      final String specification,
      final String material,
      final BigDecimal length,
      final BigDecimal aLength,
      final BigDecimal lossRate,
      final List<MesBuildingAssembleTaskDTO> assembleList
   ) {
      this.serialNumber = serialNumber;
      this.typesettingAssembleName = typesettingAssembleName;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.aLength = aLength;
      this.lossRate = lossRate;
      this.assembleList = assembleList;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getTypesettingAssembleName() {
      return this.typesettingAssembleName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getALength() {
      return this.aLength;
   }

   public BigDecimal getLossRate() {
      return this.lossRate;
   }

   public List<MesBuildingAssembleTaskDTO> getAssembleList() {
      return this.assembleList;
   }

   @JsonProperty("serialNumber")
   public NestingTaskDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("typesettingAssembleName")
   public NestingTaskDTO setTypesettingAssembleName(final String typesettingAssembleName) {
      this.typesettingAssembleName = typesettingAssembleName;
      return this;
   }

   @JsonProperty("specification")
   public NestingTaskDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public NestingTaskDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public NestingTaskDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("aLength")
   public NestingTaskDTO setALength(final BigDecimal aLength) {
      this.aLength = aLength;
      return this;
   }

   @JsonProperty("lossRate")
   public NestingTaskDTO setLossRate(final BigDecimal lossRate) {
      this.lossRate = lossRate;
      return this;
   }

   public NestingTaskDTO setAssembleList(final List<MesBuildingAssembleTaskDTO> assembleList) {
      this.assembleList = assembleList;
      return this;
   }

   @Override
   public String toString() {
      return "NestingTaskDTO(serialNumber="
         + this.getSerialNumber()
         + ", typesettingAssembleName="
         + this.getTypesettingAssembleName()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", aLength="
         + this.getALength()
         + ", lossRate="
         + this.getLossRate()
         + ", assembleList="
         + this.getAssembleList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestingTaskDTO)) {
         return false;
      }

      NestingTaskDTO other = (NestingTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$serialNumber = this.getSerialNumber();
      Object other$serialNumber = other.getSerialNumber();
      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
         Object this$typesettingAssembleName = this.getTypesettingAssembleName();
         Object other$typesettingAssembleName = other.getTypesettingAssembleName();
         if (this$typesettingAssembleName == null ? other$typesettingAssembleName == null : this$typesettingAssembleName.equals(other$typesettingAssembleName)) {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                  Object this$length = this.getLength();
                  Object other$length = other.getLength();
                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                     Object this$aLength = this.getALength();
                     Object other$aLength = other.getALength();
                     if (this$aLength == null ? other$aLength == null : this$aLength.equals(other$aLength)) {
                        Object this$lossRate = this.getLossRate();
                        Object other$lossRate = other.getLossRate();
                        if (this$lossRate == null ? other$lossRate == null : this$lossRate.equals(other$lossRate)) {
                           Object this$assembleList = this.getAssembleList();
                           Object other$assembleList = other.getAssembleList();
                           return this$assembleList == null ? other$assembleList == null : this$assembleList.equals(other$assembleList);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NestingTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $typesettingAssembleName = this.getTypesettingAssembleName();
      result = result * 59 + ($typesettingAssembleName == null ? 43 : $typesettingAssembleName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $aLength = this.getALength();
      result = result * 59 + ($aLength == null ? 43 : $aLength.hashCode());
      Object $lossRate = this.getLossRate();
      result = result * 59 + ($lossRate == null ? 43 : $lossRate.hashCode());
      Object $assembleList = this.getAssembleList();
      return result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
   }

   public static class NestingTaskDTOBuilder {
      private String serialNumber;
      private String typesettingAssembleName;
      private String specification;
      private String material;
      private BigDecimal length;
      private BigDecimal aLength;
      private BigDecimal lossRate;
      private List<MesBuildingAssembleTaskDTO> assembleList;

      NestingTaskDTOBuilder() {
      }

      @JsonProperty("serialNumber")
      public NestingTaskDTO.NestingTaskDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("typesettingAssembleName")
      public NestingTaskDTO.NestingTaskDTOBuilder typesettingAssembleName(final String typesettingAssembleName) {
         this.typesettingAssembleName = typesettingAssembleName;
         return this;
      }

      @JsonProperty("specification")
      public NestingTaskDTO.NestingTaskDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public NestingTaskDTO.NestingTaskDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("length")
      public NestingTaskDTO.NestingTaskDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("aLength")
      public NestingTaskDTO.NestingTaskDTOBuilder aLength(final BigDecimal aLength) {
         this.aLength = aLength;
         return this;
      }

      @JsonProperty("lossRate")
      public NestingTaskDTO.NestingTaskDTOBuilder lossRate(final BigDecimal lossRate) {
         this.lossRate = lossRate;
         return this;
      }

      public NestingTaskDTO.NestingTaskDTOBuilder assembleList(final List<MesBuildingAssembleTaskDTO> assembleList) {
         this.assembleList = assembleList;
         return this;
      }

      public NestingTaskDTO build() {
         return new NestingTaskDTO(
            this.serialNumber, this.typesettingAssembleName, this.specification, this.material, this.length, this.aLength, this.lossRate, this.assembleList
         );
      }

      @Override
      public String toString() {
         return "NestingTaskDTO.NestingTaskDTOBuilder(serialNumber="
            + this.serialNumber
            + ", typesettingAssembleName="
            + this.typesettingAssembleName
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", aLength="
            + this.aLength
            + ", lossRate="
            + this.lossRate
            + ", assembleList="
            + this.assembleList
            + ")";
      }
   }
}
