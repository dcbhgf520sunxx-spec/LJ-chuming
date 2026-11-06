package com.hzchum.scim.bim.core.api.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.vo.BimArtifactStatusDetailVO;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@ApiModel("bim桥梁产品基础汇总")
@JsonInclude(Include.NON_NULL)
public class BimBridgeProductMeteGroupVO {
   @ApiModelProperty("文件id")
   private Long fileId;
   @ApiModelProperty("单体信息")
   private NameInfo monomer;
   @ApiModelProperty("区域信息")
   private AreaInfoDTO area;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("总净重")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("占比%")
   private Double proportion;
   @ApiModelProperty("构件elementIds")
   private Set<String> elementIds;
   @ApiModelProperty("构件基础信息")
   List<BimArtifactStatusDetailVO> basicsVOS;

   public Long getFileId() {
      return this.fileId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public AreaInfoDTO getArea() {
      return this.area;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Double getProportion() {
      return this.proportion;
   }

   public Set<String> getElementIds() {
      return this.elementIds;
   }

   public List<BimArtifactStatusDetailVO> getBasicsVOS() {
      return this.basicsVOS;
   }

   public void setFileId(final Long fileId) {
      this.fileId = fileId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final AreaInfoDTO area) {
      this.area = area;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setProportion(final Double proportion) {
      this.proportion = proportion;
   }

   public void setElementIds(final Set<String> elementIds) {
      this.elementIds = elementIds;
   }

   public void setBasicsVOS(final List<BimArtifactStatusDetailVO> basicsVOS) {
      this.basicsVOS = basicsVOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimBridgeProductMeteGroupVO)) {
         return false;
      }

      BimBridgeProductMeteGroupVO other = (BimBridgeProductMeteGroupVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$fileId = this.getFileId();
      Object other$fileId = other.getFileId();
      if (this$fileId == null ? other$fileId == null : this$fileId.equals(other$fileId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$proportion = this.getProportion();
            Object other$proportion = other.getProportion();
            if (this$proportion == null ? other$proportion == null : this$proportion.equals(other$proportion)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$totalNetWeight = this.getTotalNetWeight();
                     Object other$totalNetWeight = other.getTotalNetWeight();
                     if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                        Object this$totalGrossWeight = this.getTotalGrossWeight();
                        Object other$totalGrossWeight = other.getTotalGrossWeight();
                        if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                           Object this$elementIds = this.getElementIds();
                           Object other$elementIds = other.getElementIds();
                           if (this$elementIds == null ? other$elementIds == null : this$elementIds.equals(other$elementIds)) {
                              Object this$basicsVOS = this.getBasicsVOS();
                              Object other$basicsVOS = other.getBasicsVOS();
                              return this$basicsVOS == null ? other$basicsVOS == null : this$basicsVOS.equals(other$basicsVOS);
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
      return other instanceof BimBridgeProductMeteGroupVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fileId = this.getFileId();
      result = result * 59 + ($fileId == null ? 43 : $fileId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $proportion = this.getProportion();
      result = result * 59 + ($proportion == null ? 43 : $proportion.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $elementIds = this.getElementIds();
      result = result * 59 + ($elementIds == null ? 43 : $elementIds.hashCode());
      Object $basicsVOS = this.getBasicsVOS();
      return result * 59 + ($basicsVOS == null ? 43 : $basicsVOS.hashCode());
   }

   @Override
   public String toString() {
      return "BimBridgeProductMeteGroupVO(fileId="
         + this.getFileId()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", proportion="
         + this.getProportion()
         + ", elementIds="
         + this.getElementIds()
         + ", basicsVOS="
         + this.getBasicsVOS()
         + ")";
   }
}
