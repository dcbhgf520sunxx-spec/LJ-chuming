package com.hzchum.scim.project.core.api.pojo.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("安装量类")
public class ProjectInstallMeteDO {
   @ApiModelProperty(name = "actualQuantity", value = "实际安装数量", notes = "实际安装数量")
   private BigDecimal actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度mm)", notes = "实际量(重量kg/长度mm)")
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "实际安装面积(mm2)", notes = "实际安装面积(mm2)")
   private BigDecimal actualTotalArea;

   public BigDecimal getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public void setActualQuantity(final BigDecimal actualQuantity) {
      this.actualQuantity = actualQuantity;
   }

   public void setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
   }

   public void setActualTotalArea(final BigDecimal actualTotalArea) {
      this.actualTotalArea = actualTotalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallMeteDO)) {
         return false;
      }

      ProjectInstallMeteDO other = (ProjectInstallMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$actualQuantity = this.getActualQuantity();
      Object other$actualQuantity = other.getActualQuantity();
      if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
         Object this$actualMete = this.getActualMete();
         Object other$actualMete = other.getActualMete();
         if (this$actualMete == null ? other$actualMete == null : this$actualMete.equals(other$actualMete)) {
            Object this$actualTotalArea = this.getActualTotalArea();
            Object other$actualTotalArea = other.getActualTotalArea();
            return this$actualTotalArea == null ? other$actualTotalArea == null : this$actualTotalArea.equals(other$actualTotalArea);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInstallMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      return result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallMeteDO(actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ")";
   }
}
