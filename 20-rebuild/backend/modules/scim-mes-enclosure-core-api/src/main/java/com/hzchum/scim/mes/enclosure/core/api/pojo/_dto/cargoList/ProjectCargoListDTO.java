package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目物流公司费用信息类")
public class ProjectCargoListDTO {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("物流公司id")
   private Long supplierId;
   @ApiModelProperty("物流公司名称")
   private String supplierName;
   @ApiModelProperty("发运物流费")
   private BigDecimal freight;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListDTO)) {
         return false;
      }

      ProjectCargoListDTO other = (ProjectCargoListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$supplierName = this.getSupplierName();
               Object other$supplierName = other.getSupplierName();
               if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                  Object this$freight = this.getFreight();
                  Object other$freight = other.getFreight();
                  return this$freight == null ? other$freight == null : this$freight.equals(other$freight);
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
      return other instanceof ProjectCargoListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $freight = this.getFreight();
      return result * 59 + ($freight == null ? 43 : $freight.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListDTO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", freight="
         + this.getFreight()
         + ")";
   }
}
