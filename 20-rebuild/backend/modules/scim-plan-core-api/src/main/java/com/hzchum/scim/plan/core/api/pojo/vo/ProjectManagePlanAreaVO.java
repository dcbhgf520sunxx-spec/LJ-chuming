package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanAreaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "项目管理区域VO")
public class ProjectManagePlanAreaVO extends ProjectPlanAreaDTO {
   @ApiModelProperty(name = "supplierId", value = "分包供应商id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "deepenMete", value = "实际深化量")
   private BigDecimal deepenMete;
   @ApiModelProperty(name = "produceMete", value = "实际生产量")
   private BigDecimal produceMete;
   @ApiModelProperty(name = "produceMete", value = "实际发运量")
   private BigDecimal shippingMete;
   @ApiModelProperty(name = "installMete", value = "实际安装量")
   private BigDecimal installMete;

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getDeepenMete() {
      return this.deepenMete;
   }

   public BigDecimal getProduceMete() {
      return this.produceMete;
   }

   public BigDecimal getShippingMete() {
      return this.shippingMete;
   }

   public BigDecimal getInstallMete() {
      return this.installMete;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setDeepenMete(final BigDecimal deepenMete) {
      this.deepenMete = deepenMete;
   }

   public void setProduceMete(final BigDecimal produceMete) {
      this.produceMete = produceMete;
   }

   public void setShippingMete(final BigDecimal shippingMete) {
      this.shippingMete = shippingMete;
   }

   public void setInstallMete(final BigDecimal installMete) {
      this.installMete = installMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManagePlanAreaVO)) {
         return false;
      }

      ProjectManagePlanAreaVO other = (ProjectManagePlanAreaVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$supplierName = this.getSupplierName();
         Object other$supplierName = other.getSupplierName();
         if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
            Object this$deepenMete = this.getDeepenMete();
            Object other$deepenMete = other.getDeepenMete();
            if (this$deepenMete == null ? other$deepenMete == null : this$deepenMete.equals(other$deepenMete)) {
               Object this$produceMete = this.getProduceMete();
               Object other$produceMete = other.getProduceMete();
               if (this$produceMete == null ? other$produceMete == null : this$produceMete.equals(other$produceMete)) {
                  Object this$shippingMete = this.getShippingMete();
                  Object other$shippingMete = other.getShippingMete();
                  if (this$shippingMete == null ? other$shippingMete == null : this$shippingMete.equals(other$shippingMete)) {
                     Object this$installMete = this.getInstallMete();
                     Object other$installMete = other.getInstallMete();
                     return this$installMete == null ? other$installMete == null : this$installMete.equals(other$installMete);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectManagePlanAreaVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $deepenMete = this.getDeepenMete();
      result = result * 59 + ($deepenMete == null ? 43 : $deepenMete.hashCode());
      Object $produceMete = this.getProduceMete();
      result = result * 59 + ($produceMete == null ? 43 : $produceMete.hashCode());
      Object $shippingMete = this.getShippingMete();
      result = result * 59 + ($shippingMete == null ? 43 : $shippingMete.hashCode());
      Object $installMete = this.getInstallMete();
      return result * 59 + ($installMete == null ? 43 : $installMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManagePlanAreaVO(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", deepenMete="
         + this.getDeepenMete()
         + ", produceMete="
         + this.getProduceMete()
         + ", shippingMete="
         + this.getShippingMete()
         + ", installMete="
         + this.getInstallMete()
         + ")";
   }
}
