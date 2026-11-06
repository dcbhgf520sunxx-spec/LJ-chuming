package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiOperation("项目台账-自营成本支出信息")
public class ProjectLedgerSeltSupportPaymentDto {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("立项日期")
   private LocalDateTime createDate;
   @ApiModelProperty("签订主体")
   private NameInfo signer;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("业务负责人")
   private NameInfo user;
   @ApiModelProperty("订单类型")
   private Integer businessType;
   @ApiModelProperty("项目状态")
   private Integer projectStatus;
   @ApiModelProperty("发包方")
   private SupplierInfo supplier;
   @ApiModelProperty("材料/分包/租赁信息")
   private List<ProjectLedgerSeltSupportPaymentDetailDto> detail;

   ProjectLedgerSeltSupportPaymentDto(
      final ProjectInfo project,
      final LocalDateTime createDate,
      final NameInfo signer,
      final BigDecimal contractAmount,
      final NameInfo user,
      final Integer businessType,
      final Integer projectStatus,
      final SupplierInfo supplier,
      final List<ProjectLedgerSeltSupportPaymentDetailDto> detail
   ) {
      this.project = project;
      this.createDate = createDate;
      this.signer = signer;
      this.contractAmount = contractAmount;
      this.user = user;
      this.businessType = businessType;
      this.projectStatus = projectStatus;
      this.supplier = supplier;
      this.detail = detail;
   }

   public static ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder builder() {
      return new ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public LocalDateTime getCreateDate() {
      return this.createDate;
   }

   public NameInfo getSigner() {
      return this.signer;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectStatus() {
      return this.projectStatus;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public List<ProjectLedgerSeltSupportPaymentDetailDto> getDetail() {
      return this.detail;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setCreateDate(final LocalDateTime createDate) {
      this.createDate = createDate;
   }

   public void setSigner(final NameInfo signer) {
      this.signer = signer;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setUser(final NameInfo user) {
      this.user = user;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectStatus(final Integer projectStatus) {
      this.projectStatus = projectStatus;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setDetail(final List<ProjectLedgerSeltSupportPaymentDetailDto> detail) {
      this.detail = detail;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerSeltSupportPaymentDto)) {
         return false;
      }

      ProjectLedgerSeltSupportPaymentDto other = (ProjectLedgerSeltSupportPaymentDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessType = this.getBusinessType();
      Object other$businessType = other.getBusinessType();
      if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
         Object this$projectStatus = this.getProjectStatus();
         Object other$projectStatus = other.getProjectStatus();
         if (this$projectStatus == null ? other$projectStatus == null : this$projectStatus.equals(other$projectStatus)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$createDate = this.getCreateDate();
               Object other$createDate = other.getCreateDate();
               if (this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate)) {
                  Object this$signer = this.getSigner();
                  Object other$signer = other.getSigner();
                  if (this$signer == null ? other$signer == null : this$signer.equals(other$signer)) {
                     Object this$contractAmount = this.getContractAmount();
                     Object other$contractAmount = other.getContractAmount();
                     if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                        Object this$user = this.getUser();
                        Object other$user = other.getUser();
                        if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                           Object this$supplier = this.getSupplier();
                           Object other$supplier = other.getSupplier();
                           if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectLedgerSeltSupportPaymentDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectStatus = this.getProjectStatus();
      result = result * 59 + ($projectStatus == null ? 43 : $projectStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $createDate = this.getCreateDate();
      result = result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
      Object $signer = this.getSigner();
      result = result * 59 + ($signer == null ? 43 : $signer.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $detail = this.getDetail();
      return result * 59 + ($detail == null ? 43 : $detail.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerSeltSupportPaymentDto(project="
         + this.getProject()
         + ", createDate="
         + this.getCreateDate()
         + ", signer="
         + this.getSigner()
         + ", contractAmount="
         + this.getContractAmount()
         + ", user="
         + this.getUser()
         + ", businessType="
         + this.getBusinessType()
         + ", projectStatus="
         + this.getProjectStatus()
         + ", supplier="
         + this.getSupplier()
         + ", detail="
         + this.getDetail()
         + ")";
   }

   public static class ProjectLedgerSeltSupportPaymentDtoBuilder {
      private ProjectInfo project;
      private LocalDateTime createDate;
      private NameInfo signer;
      private BigDecimal contractAmount;
      private NameInfo user;
      private Integer businessType;
      private Integer projectStatus;
      private SupplierInfo supplier;
      private List<ProjectLedgerSeltSupportPaymentDetailDto> detail;

      ProjectLedgerSeltSupportPaymentDtoBuilder() {
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder createDate(final LocalDateTime createDate) {
         this.createDate = createDate;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder signer(final NameInfo signer) {
         this.signer = signer;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder projectStatus(final Integer projectStatus) {
         this.projectStatus = projectStatus;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder detail(final List<ProjectLedgerSeltSupportPaymentDetailDto> detail) {
         this.detail = detail;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDto build() {
         return new ProjectLedgerSeltSupportPaymentDto(
            this.project, this.createDate, this.signer, this.contractAmount, this.user, this.businessType, this.projectStatus, this.supplier, this.detail
         );
      }

      @Override
      public String toString() {
         return "ProjectLedgerSeltSupportPaymentDto.ProjectLedgerSeltSupportPaymentDtoBuilder(project="
            + this.project
            + ", createDate="
            + this.createDate
            + ", signer="
            + this.signer
            + ", contractAmount="
            + this.contractAmount
            + ", user="
            + this.user
            + ", businessType="
            + this.businessType
            + ", projectStatus="
            + this.projectStatus
            + ", supplier="
            + this.supplier
            + ", detail="
            + this.detail
            + ")";
      }
   }
}
