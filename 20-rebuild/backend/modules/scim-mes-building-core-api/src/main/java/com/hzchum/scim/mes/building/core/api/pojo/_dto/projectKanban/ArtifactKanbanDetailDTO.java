package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ArtifactKanbanDetailDTO", description = "构件及构件关联部件零件生产信息")
public class ArtifactKanbanDetailDTO {
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;
   @ApiModelProperty(name = "teamLeaderNames", value = "班组长名集合")
   @JsonProperty("teamLeaderNames")
   @JSONField(name = "teamLeaderNames")
   private List<String> teamLeaderNames;
   @ApiModelProperty(name = "productKanBanInfos", value = "构件关联零部件信息")
   @JsonProperty("productKanBanInfos")
   @JSONField(name = "productKanBanInfos")
   private List<ProductKanBanInfoDTO> productKanBanInfos;

   public static ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder builder() {
      return new ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder();
   }

   public ArtifactKanbanDetailDTO() {
   }

   public ArtifactKanbanDetailDTO(
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final Integer producedQuantity,
      final String teamLeaderName,
      final List<String> teamLeaderNames,
      final List<ProductKanBanInfoDTO> productKanBanInfos
   ) {
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.producedQuantity = producedQuantity;
      this.teamLeaderName = teamLeaderName;
      this.teamLeaderNames = teamLeaderNames;
      this.productKanBanInfos = productKanBanInfos;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public List<String> getTeamLeaderNames() {
      return this.teamLeaderNames;
   }

   public List<ProductKanBanInfoDTO> getProductKanBanInfos() {
      return this.productKanBanInfos;
   }

   @JsonProperty("name")
   public ArtifactKanbanDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactKanbanDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ArtifactKanbanDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ArtifactKanbanDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ArtifactKanbanDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public ArtifactKanbanDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public ArtifactKanbanDetailDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public ArtifactKanbanDetailDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @JsonProperty("teamLeaderNames")
   public ArtifactKanbanDetailDTO setTeamLeaderNames(final List<String> teamLeaderNames) {
      this.teamLeaderNames = teamLeaderNames;
      return this;
   }

   @JsonProperty("productKanBanInfos")
   public ArtifactKanbanDetailDTO setProductKanBanInfos(final List<ProductKanBanInfoDTO> productKanBanInfos) {
      this.productKanBanInfos = productKanBanInfos;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactKanbanDetailDTO(name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", teamLeaderNames="
         + this.getTeamLeaderNames()
         + ", productKanBanInfos="
         + this.getProductKanBanInfos()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactKanbanDetailDTO)) {
         return false;
      }

      ArtifactKanbanDetailDTO other = (ArtifactKanbanDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$producedQuantity = this.getProducedQuantity();
         Object other$producedQuantity = other.getProducedQuantity();
         if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$teamLeaderName = this.getTeamLeaderName();
                           Object other$teamLeaderName = other.getTeamLeaderName();
                           if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
                              Object this$teamLeaderNames = this.getTeamLeaderNames();
                              Object other$teamLeaderNames = other.getTeamLeaderNames();
                              if (this$teamLeaderNames == null ? other$teamLeaderNames == null : this$teamLeaderNames.equals(other$teamLeaderNames)) {
                                 Object this$productKanBanInfos = this.getProductKanBanInfos();
                                 Object other$productKanBanInfos = other.getProductKanBanInfos();
                                 return this$productKanBanInfos == null
                                    ? other$productKanBanInfos == null
                                    : this$productKanBanInfos.equals(other$productKanBanInfos);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactKanbanDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $teamLeaderNames = this.getTeamLeaderNames();
      result = result * 59 + ($teamLeaderNames == null ? 43 : $teamLeaderNames.hashCode());
      Object $productKanBanInfos = this.getProductKanBanInfos();
      return result * 59 + ($productKanBanInfos == null ? 43 : $productKanBanInfos.hashCode());
   }

   public static class ArtifactKanbanDetailDTOBuilder {
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private Integer producedQuantity;
      private String teamLeaderName;
      private List<String> teamLeaderNames;
      private List<ProductKanBanInfoDTO> productKanBanInfos;

      ArtifactKanbanDetailDTOBuilder() {
      }

      @JsonProperty("name")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      @JsonProperty("teamLeaderNames")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder teamLeaderNames(final List<String> teamLeaderNames) {
         this.teamLeaderNames = teamLeaderNames;
         return this;
      }

      @JsonProperty("productKanBanInfos")
      public ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder productKanBanInfos(final List<ProductKanBanInfoDTO> productKanBanInfos) {
         this.productKanBanInfos = productKanBanInfos;
         return this;
      }

      public ArtifactKanbanDetailDTO build() {
         return new ArtifactKanbanDetailDTO(
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.producedQuantity,
            this.teamLeaderName,
            this.teamLeaderNames,
            this.productKanBanInfos
         );
      }

      @Override
      public String toString() {
         return "ArtifactKanbanDetailDTO.ArtifactKanbanDetailDTOBuilder(name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", teamLeaderName="
            + this.teamLeaderName
            + ", teamLeaderNames="
            + this.teamLeaderNames
            + ", productKanBanInfos="
            + this.productKanBanInfos
            + ")";
      }
   }
}
