package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingArtifactSchedulingSurplusAssembleDTO", description = "构件排产所需部件信息汇总")
public class MesBuildingArtifactSchedulingSurplusAssembleDTO {
   @ApiModelProperty(name = "artifactList", value = "可匹配构件信息", notes = "可匹配构件信息")
   @JsonProperty("artifactList")
   @JSONField(name = "artifactList")
   private List<MesBuildingSurplusAssembleMatchingArtifactDTO> artifactList;
   @ApiModelProperty(name = "id", value = "组立id", notes = "组立id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;

   public static MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder builder() {
      return new MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder();
   }

   public MesBuildingArtifactSchedulingSurplusAssembleDTO(
      final List<MesBuildingSurplusAssembleMatchingArtifactDTO> artifactList,
      final Long id,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final BigDecimal length,
      final BigDecimal netWeight
   ) {
      this.artifactList = artifactList;
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.length = length;
      this.netWeight = netWeight;
   }

   public MesBuildingArtifactSchedulingSurplusAssembleDTO() {
   }

   public List<MesBuildingSurplusAssembleMatchingArtifactDTO> getArtifactList() {
      return this.artifactList;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("artifactList")
   public MesBuildingArtifactSchedulingSurplusAssembleDTO setArtifactList(final List<MesBuildingSurplusAssembleMatchingArtifactDTO> artifactList) {
      this.artifactList = artifactList;
      return this;
   }

   @JsonProperty("id")
   public MesBuildingArtifactSchedulingSurplusAssembleDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingArtifactSchedulingSurplusAssembleDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingArtifactSchedulingSurplusAssembleDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactSchedulingSurplusAssembleDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingArtifactSchedulingSurplusAssembleDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingArtifactSchedulingSurplusAssembleDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingSurplusAssembleDTO(artifactList="
         + this.getArtifactList()
         + ", id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSchedulingSurplusAssembleDTO)) {
         return false;
      }

      MesBuildingArtifactSchedulingSurplusAssembleDTO other = (MesBuildingArtifactSchedulingSurplusAssembleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$artifactList = this.getArtifactList();
            Object other$artifactList = other.getArtifactList();
            if (this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactSchedulingSurplusAssembleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder {
      private List<MesBuildingSurplusAssembleMatchingArtifactDTO> artifactList;
      private Long id;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private BigDecimal length;
      private BigDecimal netWeight;

      MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder() {
      }

      @JsonProperty("artifactList")
      public MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder artifactList(
         final List<MesBuildingSurplusAssembleMatchingArtifactDTO> artifactList
      ) {
         this.artifactList = artifactList;
         return this;
      }

      @JsonProperty("id")
      public MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MesBuildingArtifactSchedulingSurplusAssembleDTO build() {
         return new MesBuildingArtifactSchedulingSurplusAssembleDTO(
            this.artifactList, this.id, this.serialNumber, this.specification, this.quantity, this.length, this.netWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingSurplusAssembleDTO.MesBuildingArtifactSchedulingSurplusAssembleDTOBuilder(artifactList="
            + this.artifactList
            + ", id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ")";
      }
   }
}
