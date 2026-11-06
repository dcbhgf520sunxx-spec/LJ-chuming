package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;

@ApiModel(value = "MesBuildingCutConfigDTO", description = "MES垫块配置DTO ")
public class MesBuildingSpacerParallelDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
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
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "thick", value = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private BigDecimal thick;
   @ApiModelProperty(name = "boolUpload", value = "dxf是否上传")
   @JsonProperty("boolUpload")
   @JSONField(name = "boolUpload")
   private Boolean boolUpload;
   @ApiModelProperty(name = "boolHaveHole", value = "是否有孔 true 有孔 false 无孔")
   @TableField("bool_have_hole")
   @Column(name = "bool_have_hole", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否有孔 1有 0无'")
   private Boolean boolHaveHole;
   @ApiModelProperty(name = "holeNumber", value = "孔的数量")
   @JsonProperty("holeNumber")
   @JSONField(name = "holeNumber")
   private Long holeNumber;
   @ApiModelProperty(name = "picturePath", value = "dxf图片路径")
   @JsonProperty("picturePath")
   @JSONField(name = "picturePath")
   private String picturePath;

   public static MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder builder() {
      return new MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder();
   }

   public MesBuildingSpacerParallelDTO() {
   }

   public MesBuildingSpacerParallelDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String remark,
      final BigDecimal thick,
      final Boolean boolUpload,
      final Boolean boolHaveHole,
      final Long holeNumber,
      final String picturePath
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.remark = remark;
      this.thick = thick;
      this.boolUpload = boolUpload;
      this.boolHaveHole = boolHaveHole;
      this.holeNumber = holeNumber;
      this.picturePath = picturePath;
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

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public Boolean getBoolUpload() {
      return this.boolUpload;
   }

   public Boolean getBoolHaveHole() {
      return this.boolHaveHole;
   }

   public Long getHoleNumber() {
      return this.holeNumber;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   @JsonProperty("id")
   public MesBuildingSpacerParallelDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingSpacerParallelDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingSpacerParallelDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingSpacerParallelDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingSpacerParallelDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingSpacerParallelDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingSpacerParallelDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingSpacerParallelDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingSpacerParallelDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingSpacerParallelDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingSpacerParallelDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public MesBuildingSpacerParallelDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingSpacerParallelDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingSpacerParallelDTO setThick(final BigDecimal thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("boolUpload")
   public MesBuildingSpacerParallelDTO setBoolUpload(final Boolean boolUpload) {
      this.boolUpload = boolUpload;
      return this;
   }

   public MesBuildingSpacerParallelDTO setBoolHaveHole(final Boolean boolHaveHole) {
      this.boolHaveHole = boolHaveHole;
      return this;
   }

   @JsonProperty("holeNumber")
   public MesBuildingSpacerParallelDTO setHoleNumber(final Long holeNumber) {
      this.holeNumber = holeNumber;
      return this;
   }

   @JsonProperty("picturePath")
   public MesBuildingSpacerParallelDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSpacerParallelDTO(id="
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
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", remark="
         + this.getRemark()
         + ", thick="
         + this.getThick()
         + ", boolUpload="
         + this.getBoolUpload()
         + ", boolHaveHole="
         + this.getBoolHaveHole()
         + ", holeNumber="
         + this.getHoleNumber()
         + ", picturePath="
         + this.getPicturePath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSpacerParallelDTO)) {
         return false;
      }

      MesBuildingSpacerParallelDTO other = (MesBuildingSpacerParallelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$boolUpload = this.getBoolUpload();
            Object other$boolUpload = other.getBoolUpload();
            if (this$boolUpload == null ? other$boolUpload == null : this$boolUpload.equals(other$boolUpload)) {
               Object this$boolHaveHole = this.getBoolHaveHole();
               Object other$boolHaveHole = other.getBoolHaveHole();
               if (this$boolHaveHole == null ? other$boolHaveHole == null : this$boolHaveHole.equals(other$boolHaveHole)) {
                  Object this$holeNumber = this.getHoleNumber();
                  Object other$holeNumber = other.getHoleNumber();
                  if (this$holeNumber == null ? other$holeNumber == null : this$holeNumber.equals(other$holeNumber)) {
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
                                       Object this$totalNetWeight = this.getTotalNetWeight();
                                       Object other$totalNetWeight = other.getTotalNetWeight();
                                       if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                          Object this$grossWeight = this.getGrossWeight();
                                          Object other$grossWeight = other.getGrossWeight();
                                          if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                             Object this$totalGrossWeight = this.getTotalGrossWeight();
                                             Object other$totalGrossWeight = other.getTotalGrossWeight();
                                             if (this$totalGrossWeight == null
                                                ? other$totalGrossWeight == null
                                                : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                Object this$surfaceArea = this.getSurfaceArea();
                                                Object other$surfaceArea = other.getSurfaceArea();
                                                if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$thick = this.getThick();
                                                      Object other$thick = other.getThick();
                                                      if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                         Object this$picturePath = this.getPicturePath();
                                                         Object other$picturePath = other.getPicturePath();
                                                         return this$picturePath == null
                                                            ? other$picturePath == null
                                                            : this$picturePath.equals(other$picturePath);
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
      return other instanceof MesBuildingSpacerParallelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolUpload = this.getBoolUpload();
      result = result * 59 + ($boolUpload == null ? 43 : $boolUpload.hashCode());
      Object $boolHaveHole = this.getBoolHaveHole();
      result = result * 59 + ($boolHaveHole == null ? 43 : $boolHaveHole.hashCode());
      Object $holeNumber = this.getHoleNumber();
      result = result * 59 + ($holeNumber == null ? 43 : $holeNumber.hashCode());
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
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $picturePath = this.getPicturePath();
      return result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
   }

   public static class MesBuildingSpacerParallelDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String remark;
      private BigDecimal thick;
      private Boolean boolUpload;
      private Boolean boolHaveHole;
      private Long holeNumber;
      private String picturePath;

      MesBuildingSpacerParallelDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("boolUpload")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder boolUpload(final Boolean boolUpload) {
         this.boolUpload = boolUpload;
         return this;
      }

      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder boolHaveHole(final Boolean boolHaveHole) {
         this.boolHaveHole = boolHaveHole;
         return this;
      }

      @JsonProperty("holeNumber")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder holeNumber(final Long holeNumber) {
         this.holeNumber = holeNumber;
         return this;
      }

      @JsonProperty("picturePath")
      public MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      public MesBuildingSpacerParallelDTO build() {
         return new MesBuildingSpacerParallelDTO(
            this.id,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.remark,
            this.thick,
            this.boolUpload,
            this.boolHaveHole,
            this.holeNumber,
            this.picturePath
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSpacerParallelDTO.MesBuildingSpacerParallelDTOBuilder(id="
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
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", remark="
            + this.remark
            + ", thick="
            + this.thick
            + ", boolUpload="
            + this.boolUpload
            + ", boolHaveHole="
            + this.boolHaveHole
            + ", holeNumber="
            + this.holeNumber
            + ", picturePath="
            + this.picturePath
            + ")";
      }
   }
}
