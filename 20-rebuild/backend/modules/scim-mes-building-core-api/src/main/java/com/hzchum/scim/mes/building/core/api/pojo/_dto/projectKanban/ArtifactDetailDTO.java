package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;

@ApiModel(value = "ArtifactDetailDTO", description = "构件工序详情")
public class ArtifactDetailDTO {
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
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "area", notes = "面积（㎡）")
   @JsonProperty("area")
   @JSONField(name = "area")
   @TableField("area")
   @Column(name = "area")
   private BigDecimal area;
   @ApiModelProperty(name = "drawingNumber", notes = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   private String drawingNumber;
   @ApiModelProperty(name = "assembleSerialNumber", notes = "组立号")
   @JsonProperty("assembleSerialNumber")
   @JSONField(name = "assembleSerialNumber")
   private String assembleSerialNumber;
   @ApiModelProperty(name = "processSummaryDetailsList", notes = "工序汇总")
   @JsonProperty("processSummaryDetailsList")
   @JSONField(name = "processSummaryDetailsList")
   private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;

   public static ArtifactDetailDTO.ArtifactDetailDTOBuilder builder() {
      return new ArtifactDetailDTO.ArtifactDetailDTOBuilder();
   }

   public ArtifactDetailDTO() {
   }

   public ArtifactDetailDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal area,
      final String drawingNumber,
      final String assembleSerialNumber,
      final List<ProcessSummaryDetailsDTO> processSummaryDetailsList
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.area = area;
      this.drawingNumber = drawingNumber;
      this.assembleSerialNumber = assembleSerialNumber;
      this.processSummaryDetailsList = processSummaryDetailsList;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getAssembleSerialNumber() {
      return this.assembleSerialNumber;
   }

   public List<ProcessSummaryDetailsDTO> getProcessSummaryDetailsList() {
      return this.processSummaryDetailsList;
   }

   @JsonProperty("id")
   public ArtifactDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ArtifactDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ArtifactDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ArtifactDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ArtifactDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public ArtifactDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ArtifactDetailDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public ArtifactDetailDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("area")
   public ArtifactDetailDTO setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("drawingNumber")
   public ArtifactDetailDTO setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("assembleSerialNumber")
   public ArtifactDetailDTO setAssembleSerialNumber(final String assembleSerialNumber) {
      this.assembleSerialNumber = assembleSerialNumber;
      return this;
   }

   @JsonProperty("processSummaryDetailsList")
   public ArtifactDetailDTO setProcessSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
      this.processSummaryDetailsList = processSummaryDetailsList;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactDetailDTO(id="
         + this.getId()
         + ", name="
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
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", area="
         + this.getArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", assembleSerialNumber="
         + this.getAssembleSerialNumber()
         + ", processSummaryDetailsList="
         + this.getProcessSummaryDetailsList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactDetailDTO)) {
         return false;
      }

      ArtifactDetailDTO other = (ArtifactDetailDTO)o;
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
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$netWeight = this.getNetWeight();
                           Object other$netWeight = other.getNetWeight();
                           if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                              Object this$grossWeight = this.getGrossWeight();
                              Object other$grossWeight = other.getGrossWeight();
                              if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                 Object this$area = this.getArea();
                                 Object other$area = other.getArea();
                                 if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                    Object this$drawingNumber = this.getDrawingNumber();
                                    Object other$drawingNumber = other.getDrawingNumber();
                                    if (this$drawingNumber == null ? other$drawingNumber == null : this$drawingNumber.equals(other$drawingNumber)) {
                                       Object this$assembleSerialNumber = this.getAssembleSerialNumber();
                                       Object other$assembleSerialNumber = other.getAssembleSerialNumber();
                                       if (this$assembleSerialNumber == null
                                          ? other$assembleSerialNumber == null
                                          : this$assembleSerialNumber.equals(other$assembleSerialNumber)) {
                                          Object this$processSummaryDetailsList = this.getProcessSummaryDetailsList();
                                          Object other$processSummaryDetailsList = other.getProcessSummaryDetailsList();
                                          return this$processSummaryDetailsList == null
                                             ? other$processSummaryDetailsList == null
                                             : this$processSummaryDetailsList.equals(other$processSummaryDetailsList);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactDetailDTO;
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
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $assembleSerialNumber = this.getAssembleSerialNumber();
      result = result * 59 + ($assembleSerialNumber == null ? 43 : $assembleSerialNumber.hashCode());
      Object $processSummaryDetailsList = this.getProcessSummaryDetailsList();
      return result * 59 + ($processSummaryDetailsList == null ? 43 : $processSummaryDetailsList.hashCode());
   }

   public static class ArtifactDetailDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal area;
      private String drawingNumber;
      private String assembleSerialNumber;
      private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;

      ArtifactDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("area")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("drawingNumber")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("assembleSerialNumber")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder assembleSerialNumber(final String assembleSerialNumber) {
         this.assembleSerialNumber = assembleSerialNumber;
         return this;
      }

      @JsonProperty("processSummaryDetailsList")
      public ArtifactDetailDTO.ArtifactDetailDTOBuilder processSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
         this.processSummaryDetailsList = processSummaryDetailsList;
         return this;
      }

      public ArtifactDetailDTO build() {
         return new ArtifactDetailDTO(
            this.id,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.grossWeight,
            this.area,
            this.drawingNumber,
            this.assembleSerialNumber,
            this.processSummaryDetailsList
         );
      }

      @Override
      public String toString() {
         return "ArtifactDetailDTO.ArtifactDetailDTOBuilder(id="
            + this.id
            + ", name="
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
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", area="
            + this.area
            + ", drawingNumber="
            + this.drawingNumber
            + ", assembleSerialNumber="
            + this.assembleSerialNumber
            + ", processSummaryDetailsList="
            + this.processSummaryDetailsList
            + ")";
      }
   }
}
