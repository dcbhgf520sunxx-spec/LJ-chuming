package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingSurplusAssembleMatchingArtifactDTO", description = "构件排产所需部件信息汇总")
public class MesBuildingSurplusAssembleMatchingArtifactDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
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
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "artifactSchedulingList", notes = "排产未下发信息")
   @JsonProperty("artifactSchedulingList")
   @JSONField(name = "artifactSchedulingList")
   private List<MesBuildingArtifactSchedulingDTO> artifactSchedulingList;

   public static MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder builder() {
      return new MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder();
   }

   public MesBuildingSurplusAssembleMatchingArtifactDTO(
      final Long id,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final BigDecimal length,
      final BigDecimal netWeight,
      final String name,
      final List<MesBuildingArtifactSchedulingDTO> artifactSchedulingList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.length = length;
      this.netWeight = netWeight;
      this.name = name;
      this.artifactSchedulingList = artifactSchedulingList;
   }

   public MesBuildingSurplusAssembleMatchingArtifactDTO() {
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

   public String getName() {
      return this.name;
   }

   public List<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingList() {
      return this.artifactSchedulingList;
   }

   @JsonProperty("id")
   public MesBuildingSurplusAssembleMatchingArtifactDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingSurplusAssembleMatchingArtifactDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingSurplusAssembleMatchingArtifactDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingSurplusAssembleMatchingArtifactDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingSurplusAssembleMatchingArtifactDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingSurplusAssembleMatchingArtifactDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingSurplusAssembleMatchingArtifactDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("artifactSchedulingList")
   public MesBuildingSurplusAssembleMatchingArtifactDTO setArtifactSchedulingList(final List<MesBuildingArtifactSchedulingDTO> artifactSchedulingList) {
      this.artifactSchedulingList = artifactSchedulingList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSurplusAssembleMatchingArtifactDTO(id="
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
         + ", name="
         + this.getName()
         + ", artifactSchedulingList="
         + this.getArtifactSchedulingList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSurplusAssembleMatchingArtifactDTO)) {
         return false;
      }

      MesBuildingSurplusAssembleMatchingArtifactDTO other = (MesBuildingSurplusAssembleMatchingArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                     if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$artifactSchedulingList = this.getArtifactSchedulingList();
                           Object other$artifactSchedulingList = other.getArtifactSchedulingList();
                           return this$artifactSchedulingList == null
                              ? other$artifactSchedulingList == null
                              : this$artifactSchedulingList.equals(other$artifactSchedulingList);
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
      return other instanceof MesBuildingSurplusAssembleMatchingArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $artifactSchedulingList = this.getArtifactSchedulingList();
      return result * 59 + ($artifactSchedulingList == null ? 43 : $artifactSchedulingList.hashCode());
   }

   public static class MesBuildingSurplusAssembleMatchingArtifactDTOBuilder {
      private Long id;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private BigDecimal length;
      private BigDecimal netWeight;
      private String name;
      private List<MesBuildingArtifactSchedulingDTO> artifactSchedulingList;

      MesBuildingSurplusAssembleMatchingArtifactDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("artifactSchedulingList")
      public MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder artifactSchedulingList(
         final List<MesBuildingArtifactSchedulingDTO> artifactSchedulingList
      ) {
         this.artifactSchedulingList = artifactSchedulingList;
         return this;
      }

      public MesBuildingSurplusAssembleMatchingArtifactDTO build() {
         return new MesBuildingSurplusAssembleMatchingArtifactDTO(
            this.id, this.serialNumber, this.specification, this.quantity, this.length, this.netWeight, this.name, this.artifactSchedulingList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSurplusAssembleMatchingArtifactDTO.MesBuildingSurplusAssembleMatchingArtifactDTOBuilder(id="
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
            + ", name="
            + this.name
            + ", artifactSchedulingList="
            + this.artifactSchedulingList
            + ")";
      }
   }
}
