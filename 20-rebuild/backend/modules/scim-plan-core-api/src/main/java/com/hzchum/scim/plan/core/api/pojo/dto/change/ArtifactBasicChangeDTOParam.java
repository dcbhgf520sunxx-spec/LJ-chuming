package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("构件基础信息变更请求类")
public class ArtifactBasicChangeDTOParam {
   @ApiModelProperty("构件id")
   @NotNull(message = "构件id不能为空")
   private Long id;
   @ApiModelProperty("名称")
   @NotBlank(message = "名称不能为空")
   private String name;
   @ApiModelProperty("修改后数量")
   @NotNull(message = "数量不能为空")
   @Min(value = 0L, message = "数量不能小于等于0!")
   @Max(value = 999999999L, message = "数量超出范围!")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "变更单净重(kg)")
   @NotNull(message = "单净重不能为空")
   @DecimalMax(value = "9999999999", message = "单净重超出范围!")
   @DecimalMin(value = "0.000001", message = "单净重不能小于等于0!")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "变更单毛重(kg)")
   @NotNull(message = "单毛重不能为空")
   @DecimalMax(value = "9999999999", message = "单毛重超出范围!")
   @DecimalMin(value = "0", message = "单毛重不能小于等于0!")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "length", value = "长度(mm)")
   @NotNull(message = "长度不能为空")
   @DecimalMax(value = "9999999999", message = "长度超出范围!")
   @DecimalMin(value = "0", message = "长度不能小于等于0!")
   private BigDecimal length;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)")
   @NotNull(message = "单面积不能为空")
   @DecimalMax(value = "9999999999", message = "单面积超出范围!")
   @DecimalMin(value = "0", message = "单面积不能小于等于0!")
   private BigDecimal surfaceArea;
   @ApiModelProperty("喷印编码")
   private String printedCode;

   public static ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder builder() {
      return new ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder();
   }

   public ArtifactBasicChangeDTOParam(
      final Long id,
      final String name,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal length,
      final BigDecimal surfaceArea,
      final String printedCode
   ) {
      this.id = id;
      this.name = name;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.printedCode = printedCode;
   }

   public ArtifactBasicChangeDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactBasicChangeDTOParam)) {
         return false;
      }

      ArtifactBasicChangeDTOParam other = (ArtifactBasicChangeDTOParam)o;
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
               Object this$netWeight = this.getNetWeight();
               Object other$netWeight = other.getNetWeight();
               if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                  Object this$grossWeight = this.getGrossWeight();
                  Object other$grossWeight = other.getGrossWeight();
                  if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$surfaceArea = this.getSurfaceArea();
                        Object other$surfaceArea = other.getSurfaceArea();
                        if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                           Object this$printedCode = this.getPrintedCode();
                           Object other$printedCode = other.getPrintedCode();
                           return this$printedCode == null ? other$printedCode == null : this$printedCode.equals(other$printedCode);
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
      return other instanceof ArtifactBasicChangeDTOParam;
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
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $printedCode = this.getPrintedCode();
      return result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactBasicChangeDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", printedCode="
         + this.getPrintedCode()
         + ")";
   }

   public static class ArtifactBasicChangeDTOParamBuilder {
      private Long id;
      private String name;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal length;
      private BigDecimal surfaceArea;
      private String printedCode;

      ArtifactBasicChangeDTOParamBuilder() {
      }

      public ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder printedCode(final String printedCode) {
         this.printedCode = printedCode;
         return this;
      }

      public ArtifactBasicChangeDTOParam build() {
         return new ArtifactBasicChangeDTOParam(
            this.id, this.name, this.quantity, this.netWeight, this.grossWeight, this.length, this.surfaceArea, this.printedCode
         );
      }

      @Override
      public String toString() {
         return "ArtifactBasicChangeDTOParam.ArtifactBasicChangeDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", printedCode="
            + this.printedCode
            + ")";
      }
   }
}
