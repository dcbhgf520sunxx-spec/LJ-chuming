package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplusDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;

public class WmsSurplusDetailDTO extends WmsSurplusDetail {
   private ProjectInfoDTO project;
   private BriefIdAndNameDTO warehouse;
   private BriefIdAndNameDTO supplier;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inputVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amountExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPriceExcludingVAT;

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsSurplusDetailDTO)) {
         return false;
      }

      WmsSurplusDetailDTO other = (WmsSurplusDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$warehouse = this.getWarehouse();
         Object other$warehouse = other.getWarehouse();
         if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
            Object this$supplier = this.getSupplier();
            Object other$supplier = other.getSupplier();
            if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
               Object this$inputVAT = this.getInputVAT();
               Object other$inputVAT = other.getInputVAT();
               if (this$inputVAT == null ? other$inputVAT == null : this$inputVAT.equals(other$inputVAT)) {
                  Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                  Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                  if (this$amountExcludingVAT == null ? other$amountExcludingVAT == null : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                     Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                     Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                     return this$unitPriceExcludingVAT == null
                        ? other$unitPriceExcludingVAT == null
                        : this$unitPriceExcludingVAT.equals(other$unitPriceExcludingVAT);
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
      return other instanceof WmsSurplusDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      return result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
   }

   @Override
   public String toString() {
      return "WmsSurplusDetailDTO(project="
         + this.getProject()
         + ", warehouse="
         + this.getWarehouse()
         + ", supplier="
         + this.getSupplier()
         + ", inputVAT="
         + this.getInputVAT()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ")";
   }
}
