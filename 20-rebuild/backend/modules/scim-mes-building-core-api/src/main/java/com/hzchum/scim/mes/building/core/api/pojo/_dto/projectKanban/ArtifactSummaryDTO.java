package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactSummaryDTO", description = "构件汇总信息")
public class ArtifactSummaryDTO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "drawPath", notes = "图纸")
   @JsonProperty("drawPath")
   @JSONField(name = "drawPath")
   private String drawPath;
   @ApiModelProperty(name = "bimPath", notes = "模型")
   @JsonProperty("bimPath")
   @JSONField(name = "bimPath")
   private String bimPath;

   public static ArtifactSummaryDTO.ArtifactSummaryDTOBuilder builder() {
      return new ArtifactSummaryDTO.ArtifactSummaryDTOBuilder();
   }

   public ArtifactSummaryDTO() {
   }

   public ArtifactSummaryDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final String drawPath,
      final String bimPath
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.drawPath = drawPath;
      this.bimPath = bimPath;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public String getDrawPath() {
      return this.drawPath;
   }

   public String getBimPath() {
      return this.bimPath;
   }

   @JsonProperty("id")
   public ArtifactSummaryDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ArtifactSummaryDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactSummaryDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("quantity")
   public ArtifactSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ArtifactSummaryDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public ArtifactSummaryDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("drawPath")
   public ArtifactSummaryDTO setDrawPath(final String drawPath) {
      this.drawPath = drawPath;
      return this;
   }

   @JsonProperty("bimPath")
   public ArtifactSummaryDTO setBimPath(final String bimPath) {
      this.bimPath = bimPath;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactSummaryDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", drawPath="
         + this.getDrawPath()
         + ", bimPath="
         + this.getBimPath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactSummaryDTO)) {
         return false;
      }

      ArtifactSummaryDTO other = (ArtifactSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$netWeight = this.getNetWeight();
                  Object other$netWeight = other.getNetWeight();
                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                     Object this$grossWeight = this.getGrossWeight();
                     Object other$grossWeight = other.getGrossWeight();
                     if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                        Object this$drawPath = this.getDrawPath();
                        Object other$drawPath = other.getDrawPath();
                        if (this$drawPath == null ? other$drawPath == null : this$drawPath.equals(other$drawPath)) {
                           Object this$bimPath = this.getBimPath();
                           Object other$bimPath = other.getBimPath();
                           return this$bimPath == null ? other$bimPath == null : this$bimPath.equals(other$bimPath);
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
      return other instanceof ArtifactSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $drawPath = this.getDrawPath();
      result = result * 59 + ($drawPath == null ? 43 : $drawPath.hashCode());
      Object $bimPath = this.getBimPath();
      return result * 59 + ($bimPath == null ? 43 : $bimPath.hashCode());
   }

   public static class ArtifactSummaryDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private String drawPath;
      private String bimPath;

      ArtifactSummaryDTOBuilder() {
      }

      @JsonProperty("id")
      public ArtifactSummaryDTO.ArtifactSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ArtifactSummaryDTO.ArtifactSummaryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactSummaryDTO.ArtifactSummaryDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public ArtifactSummaryDTO.ArtifactSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ArtifactSummaryDTO.ArtifactSummaryDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public ArtifactSummaryDTO.ArtifactSummaryDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("drawPath")
      public ArtifactSummaryDTO.ArtifactSummaryDTOBuilder drawPath(final String drawPath) {
         this.drawPath = drawPath;
         return this;
      }

      @JsonProperty("bimPath")
      public ArtifactSummaryDTO.ArtifactSummaryDTOBuilder bimPath(final String bimPath) {
         this.bimPath = bimPath;
         return this;
      }

      public ArtifactSummaryDTO build() {
         return new ArtifactSummaryDTO(this.id, this.name, this.serialNumber, this.quantity, this.netWeight, this.grossWeight, this.drawPath, this.bimPath);
      }

      @Override
      public String toString() {
         return "ArtifactSummaryDTO.ArtifactSummaryDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", drawPath="
            + this.drawPath
            + ", bimPath="
            + this.bimPath
            + ")";
      }
   }
}
