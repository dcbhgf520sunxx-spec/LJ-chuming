package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "CAPP bim列表信息 响应参数")
public class CappCraftCardBimVO {
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名称", notes = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private Integer productCount;
   @ApiModelProperty(name = "productNetWeight", value = "产品净重", notes = "产品净重")
   private BigDecimal productNetWeight;
   @ApiModelProperty(name = "cappCraftCardProductBimVOList", value = "CAPP bim产品列表信息", notes = "CAPP bim产品列表信息")
   private List<CappCraftCardProductBimVO> cappCraftCardProductBimVOList;

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getProductCount() {
      return this.productCount;
   }

   public BigDecimal getProductNetWeight() {
      return this.productNetWeight;
   }

   public List<CappCraftCardProductBimVO> getCappCraftCardProductBimVOList() {
      return this.cappCraftCardProductBimVOList;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setProductCount(final Integer productCount) {
      this.productCount = productCount;
   }

   public void setProductNetWeight(final BigDecimal productNetWeight) {
      this.productNetWeight = productNetWeight;
   }

   public void setCappCraftCardProductBimVOList(final List<CappCraftCardProductBimVO> cappCraftCardProductBimVOList) {
      this.cappCraftCardProductBimVOList = cappCraftCardProductBimVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardBimVO)) {
         return false;
      }

      CappCraftCardBimVO other = (CappCraftCardBimVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$productCount = this.getProductCount();
            Object other$productCount = other.getProductCount();
            if (this$productCount == null ? other$productCount == null : this$productCount.equals(other$productCount)) {
               Object this$monomerName = this.getMonomerName();
               Object other$monomerName = other.getMonomerName();
               if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                  Object this$areaName = this.getAreaName();
                  Object other$areaName = other.getAreaName();
                  if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                     Object this$productNetWeight = this.getProductNetWeight();
                     Object other$productNetWeight = other.getProductNetWeight();
                     if (this$productNetWeight == null ? other$productNetWeight == null : this$productNetWeight.equals(other$productNetWeight)) {
                        Object this$cappCraftCardProductBimVOList = this.getCappCraftCardProductBimVOList();
                        Object other$cappCraftCardProductBimVOList = other.getCappCraftCardProductBimVOList();
                        return this$cappCraftCardProductBimVOList == null
                           ? other$cappCraftCardProductBimVOList == null
                           : this$cappCraftCardProductBimVOList.equals(other$cappCraftCardProductBimVOList);
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
      return other instanceof CappCraftCardBimVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productCount = this.getProductCount();
      result = result * 59 + ($productCount == null ? 43 : $productCount.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $productNetWeight = this.getProductNetWeight();
      result = result * 59 + ($productNetWeight == null ? 43 : $productNetWeight.hashCode());
      Object $cappCraftCardProductBimVOList = this.getCappCraftCardProductBimVOList();
      return result * 59 + ($cappCraftCardProductBimVOList == null ? 43 : $cappCraftCardProductBimVOList.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardBimVO(monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", productCount="
         + this.getProductCount()
         + ", productNetWeight="
         + this.getProductNetWeight()
         + ", cappCraftCardProductBimVOList="
         + this.getCappCraftCardProductBimVOList()
         + ")";
   }

   public CappCraftCardBimVO(
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Integer productCount,
      final BigDecimal productNetWeight,
      final List<CappCraftCardProductBimVO> cappCraftCardProductBimVOList
   ) {
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.productCount = productCount;
      this.productNetWeight = productNetWeight;
      this.cappCraftCardProductBimVOList = cappCraftCardProductBimVOList;
   }

   public CappCraftCardBimVO() {
   }
}
