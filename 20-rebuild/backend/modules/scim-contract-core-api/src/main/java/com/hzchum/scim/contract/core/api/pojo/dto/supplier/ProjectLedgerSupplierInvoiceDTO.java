package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;

@ApiOperation("项目台账-项目支出信息")
public class ProjectLedgerSupplierInvoiceDTO {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("项目经营类型")
   private Integer projectAttribute;
   @ApiModelProperty("项目经理")
   private NameInfo projectManager;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("供应商")
   private SupplierInfo supplier;
   @ApiModelProperty("采购合同号")
   private String supplierNumber;
   @ApiModelProperty("支付详情")
   private List<ProjectLedgerSupplierInvoiceDetailDTO> detail;

   ProjectLedgerSupplierInvoiceDTO(
      final ProjectInfo project,
      final Integer projectAttribute,
      final NameInfo projectManager,
      final LocalDateTime createTime,
      final SupplierInfo supplier,
      final String supplierNumber,
      final List<ProjectLedgerSupplierInvoiceDetailDTO> detail
   ) {
      this.project = project;
      this.projectAttribute = projectAttribute;
      this.projectManager = projectManager;
      this.createTime = createTime;
      this.supplier = supplier;
      this.supplierNumber = supplierNumber;
      this.detail = detail;
   }

   public static ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder builder() {
      return new ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public NameInfo getProjectManager() {
      return this.projectManager;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public String getSupplierNumber() {
      return this.supplierNumber;
   }

   public List<ProjectLedgerSupplierInvoiceDetailDTO> getDetail() {
      return this.detail;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setProjectManager(final NameInfo projectManager) {
      this.projectManager = projectManager;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setSupplierNumber(final String supplierNumber) {
      this.supplierNumber = supplierNumber;
   }

   public void setDetail(final List<ProjectLedgerSupplierInvoiceDetailDTO> detail) {
      this.detail = detail;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerSupplierInvoiceDTO)) {
         return false;
      }

      ProjectLedgerSupplierInvoiceDTO other = (ProjectLedgerSupplierInvoiceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectAttribute = this.getProjectAttribute();
      Object other$projectAttribute = other.getProjectAttribute();
      if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$projectManager = this.getProjectManager();
            Object other$projectManager = other.getProjectManager();
            if (this$projectManager == null ? other$projectManager == null : this$projectManager.equals(other$projectManager)) {
               Object this$createTime = this.getCreateTime();
               Object other$createTime = other.getCreateTime();
               if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                  Object this$supplier = this.getSupplier();
                  Object other$supplier = other.getSupplier();
                  if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                     Object this$supplierNumber = this.getSupplierNumber();
                     Object other$supplierNumber = other.getSupplierNumber();
                     if (this$supplierNumber == null ? other$supplierNumber == null : this$supplierNumber.equals(other$supplierNumber)) {
                        Object this$detail = this.getDetail();
                        Object other$detail = other.getDetail();
                        return this$detail == null ? other$detail == null : this$detail.equals(other$detail);
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
      return other instanceof ProjectLedgerSupplierInvoiceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $supplierNumber = this.getSupplierNumber();
      result = result * 59 + ($supplierNumber == null ? 43 : $supplierNumber.hashCode());
      Object $detail = this.getDetail();
      return result * 59 + ($detail == null ? 43 : $detail.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerSupplierInvoiceDTO(project="
         + this.getProject()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectManager="
         + this.getProjectManager()
         + ", createTime="
         + this.getCreateTime()
         + ", supplier="
         + this.getSupplier()
         + ", supplierNumber="
         + this.getSupplierNumber()
         + ", detail="
         + this.getDetail()
         + ")";
   }

   public static class ProjectLedgerSupplierInvoiceDTOBuilder {
      private ProjectInfo project;
      private Integer projectAttribute;
      private NameInfo projectManager;
      private LocalDateTime createTime;
      private SupplierInfo supplier;
      private String supplierNumber;
      private List<ProjectLedgerSupplierInvoiceDetailDTO> detail;

      ProjectLedgerSupplierInvoiceDTOBuilder() {
      }

      public ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder projectManager(final NameInfo projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder supplierNumber(final String supplierNumber) {
         this.supplierNumber = supplierNumber;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder detail(final List<ProjectLedgerSupplierInvoiceDetailDTO> detail) {
         this.detail = detail;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDTO build() {
         return new ProjectLedgerSupplierInvoiceDTO(
            this.project, this.projectAttribute, this.projectManager, this.createTime, this.supplier, this.supplierNumber, this.detail
         );
      }

      @Override
      public String toString() {
         return "ProjectLedgerSupplierInvoiceDTO.ProjectLedgerSupplierInvoiceDTOBuilder(project="
            + this.project
            + ", projectAttribute="
            + this.projectAttribute
            + ", projectManager="
            + this.projectManager
            + ", createTime="
            + this.createTime
            + ", supplier="
            + this.supplier
            + ", supplierNumber="
            + this.supplierNumber
            + ", detail="
            + this.detail
            + ")";
      }
   }
}
