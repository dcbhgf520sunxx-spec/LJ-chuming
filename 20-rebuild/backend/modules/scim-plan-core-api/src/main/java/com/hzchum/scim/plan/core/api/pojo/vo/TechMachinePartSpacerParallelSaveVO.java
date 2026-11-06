package com.hzchum.scim.plan.core.api.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel(value = "TechMachinePartSpacerParallelSaveVO", description = "MES垫块配置VO ")
public class TechMachinePartSpacerParallelSaveVO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空", groups = Update.class)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @NotBlank(message = "编号不能为空", groups = {Update.class, Add.class})
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @NotBlank(message = "规格不能为空", groups = {Update.class, Add.class})
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @Pattern(message = "长度只能是非0的正整数", regexp = "^[1-9]\\d*$", groups = {Add.class, Update.class})
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
   @Pattern(message = "厚度只能是非0的正整数", regexp = "^[1-9]\\d*$", groups = {Add.class, Update.class})
   private BigDecimal thick;
   @ApiModelProperty(name = "filePath", value = "dxf文件路径")
   @JsonProperty("filePath")
   @JSONField(name = "filePath")
   @NotBlank(message = "未上传dxf", groups = Add.class)
   private String filePath;

   public static TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder builder() {
      return new TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder();
   }

   public TechMachinePartSpacerParallelSaveVO() {
   }

   public TechMachinePartSpacerParallelSaveVO(
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
      final String filePath
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
      this.filePath = filePath;
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

   public String getFilePath() {
      return this.filePath;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("netWeight")
   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   @JsonProperty("totalNetWeight")
   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   @JsonProperty("grossWeight")
   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   @JsonProperty("totalGrossWeight")
   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   @JsonProperty("surfaceArea")
   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("thick")
   public void setThick(final BigDecimal thick) {
      this.thick = thick;
   }

   @JsonProperty("filePath")
   public void setFilePath(final String filePath) {
      this.filePath = filePath;
   }

   @Override
   public String toString() {
      return "TechMachinePartSpacerParallelSaveVO(id="
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
         + ", filePath="
         + this.getFilePath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechMachinePartSpacerParallelSaveVO)) {
         return false;
      }

      TechMachinePartSpacerParallelSaveVO other = (TechMachinePartSpacerParallelSaveVO)o;
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
                              Object this$totalNetWeight = this.getTotalNetWeight();
                              Object other$totalNetWeight = other.getTotalNetWeight();
                              if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                 Object this$grossWeight = this.getGrossWeight();
                                 Object other$grossWeight = other.getGrossWeight();
                                 if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                    Object this$totalGrossWeight = this.getTotalGrossWeight();
                                    Object other$totalGrossWeight = other.getTotalGrossWeight();
                                    if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                       Object this$surfaceArea = this.getSurfaceArea();
                                       Object other$surfaceArea = other.getSurfaceArea();
                                       if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$thick = this.getThick();
                                             Object other$thick = other.getThick();
                                             if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                Object this$filePath = this.getFilePath();
                                                Object other$filePath = other.getFilePath();
                                                return this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath);
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
      return other instanceof TechMachinePartSpacerParallelSaveVO;
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
      Object $filePath = this.getFilePath();
      return result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
   }

   public static class TechMachinePartSpacerParallelSaveVOBuilder {
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
      private String filePath;

      TechMachinePartSpacerParallelSaveVOBuilder() {
      }

      @JsonProperty("id")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("remark")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("thick")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("filePath")
      public TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      public TechMachinePartSpacerParallelSaveVO build() {
         return new TechMachinePartSpacerParallelSaveVO(
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
            this.filePath
         );
      }

      @Override
      public String toString() {
         return "TechMachinePartSpacerParallelSaveVO.TechMachinePartSpacerParallelSaveVOBuilder(id="
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
            + ", filePath="
            + this.filePath
            + ")";
      }
   }
}
