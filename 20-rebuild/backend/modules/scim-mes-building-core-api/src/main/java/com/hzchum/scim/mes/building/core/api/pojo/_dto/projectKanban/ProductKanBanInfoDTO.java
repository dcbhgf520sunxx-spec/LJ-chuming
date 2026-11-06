package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ProductKanBanInfoDTO", description = "构件关联部件零件生产信息")
public class ProductKanBanInfoDTO {
   @ApiModelProperty(name = "artId", value = "构件id", notes = "产品id")
   @JsonProperty("artId")
   @JSONField(name = "artId")
   private Long artId;
   @ApiModelProperty(name = "productId", value = "关联产品id", notes = "关联产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
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
   @ApiModelProperty(name = "usableQuantity", value = "可用数量")
   @JsonProperty("usableQuantity")
   @JSONField(name = "usableQuantity")
   private Integer usableQuantity;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;
   @ApiModelProperty(name = "teamLeaderNames", value = "班组长名集合")
   @JsonProperty("teamLeaderNames")
   @JSONField(name = "teamLeaderNames")
   private List<String> teamLeaderNames;

   public static ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder builder() {
      return new ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder();
   }

   public ProductKanBanInfoDTO() {
   }

   public ProductKanBanInfoDTO(
      final Long artId,
      final Long productId,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final Integer producedQuantity,
      final Integer usableQuantity,
      final String teamLeaderName,
      final List<String> teamLeaderNames
   ) {
      this.artId = artId;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.producedQuantity = producedQuantity;
      this.usableQuantity = usableQuantity;
      this.teamLeaderName = teamLeaderName;
      this.teamLeaderNames = teamLeaderNames;
   }

   public Long getArtId() {
      return this.artId;
   }

   public Long getProductId() {
      return this.productId;
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

   public Integer getUsableQuantity() {
      return this.usableQuantity;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public List<String> getTeamLeaderNames() {
      return this.teamLeaderNames;
   }

   @JsonProperty("artId")
   public ProductKanBanInfoDTO setArtId(final Long artId) {
      this.artId = artId;
      return this;
   }

   @JsonProperty("productId")
   public ProductKanBanInfoDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductKanBanInfoDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProductKanBanInfoDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ProductKanBanInfoDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ProductKanBanInfoDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public ProductKanBanInfoDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public ProductKanBanInfoDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("usableQuantity")
   public ProductKanBanInfoDTO setUsableQuantity(final Integer usableQuantity) {
      this.usableQuantity = usableQuantity;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public ProductKanBanInfoDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @JsonProperty("teamLeaderNames")
   public ProductKanBanInfoDTO setTeamLeaderNames(final List<String> teamLeaderNames) {
      this.teamLeaderNames = teamLeaderNames;
      return this;
   }

   @Override
   public String toString() {
      return "ProductKanBanInfoDTO(artId="
         + this.getArtId()
         + ", productId="
         + this.getProductId()
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
         + ", usableQuantity="
         + this.getUsableQuantity()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", teamLeaderNames="
         + this.getTeamLeaderNames()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductKanBanInfoDTO)) {
         return false;
      }

      ProductKanBanInfoDTO other = (ProductKanBanInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artId = this.getArtId();
      Object other$artId = other.getArtId();
      if (this$artId == null ? other$artId == null : this$artId.equals(other$artId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$producedQuantity = this.getProducedQuantity();
               Object other$producedQuantity = other.getProducedQuantity();
               if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                  Object this$usableQuantity = this.getUsableQuantity();
                  Object other$usableQuantity = other.getUsableQuantity();
                  if (this$usableQuantity == null ? other$usableQuantity == null : this$usableQuantity.equals(other$usableQuantity)) {
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
                                    return this$teamLeaderNames == null ? other$teamLeaderNames == null : this$teamLeaderNames.equals(other$teamLeaderNames);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductKanBanInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artId = this.getArtId();
      result = result * 59 + ($artId == null ? 43 : $artId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usableQuantity = this.getUsableQuantity();
      result = result * 59 + ($usableQuantity == null ? 43 : $usableQuantity.hashCode());
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
      return result * 59 + ($teamLeaderNames == null ? 43 : $teamLeaderNames.hashCode());
   }

   public static class ProductKanBanInfoDTOBuilder {
      private Long artId;
      private Long productId;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private Integer producedQuantity;
      private Integer usableQuantity;
      private String teamLeaderName;
      private List<String> teamLeaderNames;

      ProductKanBanInfoDTOBuilder() {
      }

      @JsonProperty("artId")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder artId(final Long artId) {
         this.artId = artId;
         return this;
      }

      @JsonProperty("productId")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("usableQuantity")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder usableQuantity(final Integer usableQuantity) {
         this.usableQuantity = usableQuantity;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      @JsonProperty("teamLeaderNames")
      public ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder teamLeaderNames(final List<String> teamLeaderNames) {
         this.teamLeaderNames = teamLeaderNames;
         return this;
      }

      public ProductKanBanInfoDTO build() {
         return new ProductKanBanInfoDTO(
            this.artId,
            this.productId,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.producedQuantity,
            this.usableQuantity,
            this.teamLeaderName,
            this.teamLeaderNames
         );
      }

      @Override
      public String toString() {
         return "ProductKanBanInfoDTO.ProductKanBanInfoDTOBuilder(artId="
            + this.artId
            + ", productId="
            + this.productId
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
            + ", usableQuantity="
            + this.usableQuantity
            + ", teamLeaderName="
            + this.teamLeaderName
            + ", teamLeaderNames="
            + this.teamLeaderNames
            + ")";
      }
   }
}
