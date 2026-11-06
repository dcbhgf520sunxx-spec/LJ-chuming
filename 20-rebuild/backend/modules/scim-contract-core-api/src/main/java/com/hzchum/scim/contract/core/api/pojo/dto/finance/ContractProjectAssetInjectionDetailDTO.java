package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractProjectAssetInjectionDetailDTO {
   @ApiModelProperty("日期")
   private LocalDateTime assetInjectionTime;
   @ApiModelProperty("供应商信息")
   private SupplierInfo supplier;
   @ApiModelProperty("类型")
   private Integer type;
   @ApiModelProperty("金额")
   private BigDecimal amount;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("签订主体名称")
   private String contractSignBodyName;
   @ApiModelProperty("签订主体id")
   private Long contractSignBodyId;
   @ApiModelProperty("签订主体占比")
   private BigDecimal contractSignBodyRatio;
   @ApiModelProperty("签订主体支付金额")
   private BigDecimal contractSignBodyPayAmount;
   @ApiModelProperty("签订主体剩余金额")
   private BigDecimal contractSignBodyRemainAmount;
   @ApiModelProperty("项目经理名称")
   private String projectManagerName;
   @ApiModelProperty("项目经理id")
   private Long projectManagerId;
   @ApiModelProperty("项目经理占比")
   private BigDecimal projectManagerRatio;
   @ApiModelProperty("项目经理支付金额")
   private BigDecimal projectManagerPayAmount;
   @ApiModelProperty("项目经理剩余金额")
   private BigDecimal projectManagerRemainAmount;

   public static ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder builder() {
      return new ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder();
   }

   public LocalDateTime getAssetInjectionTime() {
      return this.assetInjectionTime;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public BigDecimal getContractSignBodyRatio() {
      return this.contractSignBodyRatio;
   }

   public BigDecimal getContractSignBodyPayAmount() {
      return this.contractSignBodyPayAmount;
   }

   public BigDecimal getContractSignBodyRemainAmount() {
      return this.contractSignBodyRemainAmount;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public BigDecimal getProjectManagerRatio() {
      return this.projectManagerRatio;
   }

   public BigDecimal getProjectManagerPayAmount() {
      return this.projectManagerPayAmount;
   }

   public BigDecimal getProjectManagerRemainAmount() {
      return this.projectManagerRemainAmount;
   }

   public void setAssetInjectionTime(final LocalDateTime assetInjectionTime) {
      this.assetInjectionTime = assetInjectionTime;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setContractSignBodyRatio(final BigDecimal contractSignBodyRatio) {
      this.contractSignBodyRatio = contractSignBodyRatio;
   }

   public void setContractSignBodyPayAmount(final BigDecimal contractSignBodyPayAmount) {
      this.contractSignBodyPayAmount = contractSignBodyPayAmount;
   }

   public void setContractSignBodyRemainAmount(final BigDecimal contractSignBodyRemainAmount) {
      this.contractSignBodyRemainAmount = contractSignBodyRemainAmount;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerRatio(final BigDecimal projectManagerRatio) {
      this.projectManagerRatio = projectManagerRatio;
   }

   public void setProjectManagerPayAmount(final BigDecimal projectManagerPayAmount) {
      this.projectManagerPayAmount = projectManagerPayAmount;
   }

   public void setProjectManagerRemainAmount(final BigDecimal projectManagerRemainAmount) {
      this.projectManagerRemainAmount = projectManagerRemainAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectAssetInjectionDetailDTO)) {
         return false;
      }

      ContractProjectAssetInjectionDetailDTO other = (ContractProjectAssetInjectionDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$contractSignBodyId = this.getContractSignBodyId();
         Object other$contractSignBodyId = other.getContractSignBodyId();
         if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
            Object this$projectManagerId = this.getProjectManagerId();
            Object other$projectManagerId = other.getProjectManagerId();
            if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
               Object this$assetInjectionTime = this.getAssetInjectionTime();
               Object other$assetInjectionTime = other.getAssetInjectionTime();
               if (this$assetInjectionTime == null ? other$assetInjectionTime == null : this$assetInjectionTime.equals(other$assetInjectionTime)) {
                  Object this$supplier = this.getSupplier();
                  Object other$supplier = other.getSupplier();
                  if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                     Object this$amount = this.getAmount();
                     Object other$amount = other.getAmount();
                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$contractSignBodyName = this.getContractSignBodyName();
                           Object other$contractSignBodyName = other.getContractSignBodyName();
                           if (this$contractSignBodyName == null
                              ? other$contractSignBodyName == null
                              : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                              Object this$contractSignBodyRatio = this.getContractSignBodyRatio();
                              Object other$contractSignBodyRatio = other.getContractSignBodyRatio();
                              if (this$contractSignBodyRatio == null
                                 ? other$contractSignBodyRatio == null
                                 : this$contractSignBodyRatio.equals(other$contractSignBodyRatio)) {
                                 Object this$contractSignBodyPayAmount = this.getContractSignBodyPayAmount();
                                 Object other$contractSignBodyPayAmount = other.getContractSignBodyPayAmount();
                                 if (this$contractSignBodyPayAmount == null
                                    ? other$contractSignBodyPayAmount == null
                                    : this$contractSignBodyPayAmount.equals(other$contractSignBodyPayAmount)) {
                                    Object this$contractSignBodyRemainAmount = this.getContractSignBodyRemainAmount();
                                    Object other$contractSignBodyRemainAmount = other.getContractSignBodyRemainAmount();
                                    if (this$contractSignBodyRemainAmount == null
                                       ? other$contractSignBodyRemainAmount == null
                                       : this$contractSignBodyRemainAmount.equals(other$contractSignBodyRemainAmount)) {
                                       Object this$projectManagerName = this.getProjectManagerName();
                                       Object other$projectManagerName = other.getProjectManagerName();
                                       if (this$projectManagerName == null
                                          ? other$projectManagerName == null
                                          : this$projectManagerName.equals(other$projectManagerName)) {
                                          Object this$projectManagerRatio = this.getProjectManagerRatio();
                                          Object other$projectManagerRatio = other.getProjectManagerRatio();
                                          if (this$projectManagerRatio == null
                                             ? other$projectManagerRatio == null
                                             : this$projectManagerRatio.equals(other$projectManagerRatio)) {
                                             Object this$projectManagerPayAmount = this.getProjectManagerPayAmount();
                                             Object other$projectManagerPayAmount = other.getProjectManagerPayAmount();
                                             if (this$projectManagerPayAmount == null
                                                ? other$projectManagerPayAmount == null
                                                : this$projectManagerPayAmount.equals(other$projectManagerPayAmount)) {
                                                Object this$projectManagerRemainAmount = this.getProjectManagerRemainAmount();
                                                Object other$projectManagerRemainAmount = other.getProjectManagerRemainAmount();
                                                return this$projectManagerRemainAmount == null
                                                   ? other$projectManagerRemainAmount == null
                                                   : this$projectManagerRemainAmount.equals(other$projectManagerRemainAmount);
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
      return other instanceof ContractProjectAssetInjectionDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $assetInjectionTime = this.getAssetInjectionTime();
      result = result * 59 + ($assetInjectionTime == null ? 43 : $assetInjectionTime.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $contractSignBodyRatio = this.getContractSignBodyRatio();
      result = result * 59 + ($contractSignBodyRatio == null ? 43 : $contractSignBodyRatio.hashCode());
      Object $contractSignBodyPayAmount = this.getContractSignBodyPayAmount();
      result = result * 59 + ($contractSignBodyPayAmount == null ? 43 : $contractSignBodyPayAmount.hashCode());
      Object $contractSignBodyRemainAmount = this.getContractSignBodyRemainAmount();
      result = result * 59 + ($contractSignBodyRemainAmount == null ? 43 : $contractSignBodyRemainAmount.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $projectManagerRatio = this.getProjectManagerRatio();
      result = result * 59 + ($projectManagerRatio == null ? 43 : $projectManagerRatio.hashCode());
      Object $projectManagerPayAmount = this.getProjectManagerPayAmount();
      result = result * 59 + ($projectManagerPayAmount == null ? 43 : $projectManagerPayAmount.hashCode());
      Object $projectManagerRemainAmount = this.getProjectManagerRemainAmount();
      return result * 59 + ($projectManagerRemainAmount == null ? 43 : $projectManagerRemainAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectAssetInjectionDetailDTO(assetInjectionTime="
         + this.getAssetInjectionTime()
         + ", supplier="
         + this.getSupplier()
         + ", type="
         + this.getType()
         + ", amount="
         + this.getAmount()
         + ", project="
         + this.getProject()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyRatio="
         + this.getContractSignBodyRatio()
         + ", contractSignBodyPayAmount="
         + this.getContractSignBodyPayAmount()
         + ", contractSignBodyRemainAmount="
         + this.getContractSignBodyRemainAmount()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerRatio="
         + this.getProjectManagerRatio()
         + ", projectManagerPayAmount="
         + this.getProjectManagerPayAmount()
         + ", projectManagerRemainAmount="
         + this.getProjectManagerRemainAmount()
         + ")";
   }

   public ContractProjectAssetInjectionDetailDTO(
      final LocalDateTime assetInjectionTime,
      final SupplierInfo supplier,
      final Integer type,
      final BigDecimal amount,
      final ProjectInfo project,
      final String contractSignBodyName,
      final Long contractSignBodyId,
      final BigDecimal contractSignBodyRatio,
      final BigDecimal contractSignBodyPayAmount,
      final BigDecimal contractSignBodyRemainAmount,
      final String projectManagerName,
      final Long projectManagerId,
      final BigDecimal projectManagerRatio,
      final BigDecimal projectManagerPayAmount,
      final BigDecimal projectManagerRemainAmount
   ) {
      this.assetInjectionTime = assetInjectionTime;
      this.supplier = supplier;
      this.type = type;
      this.amount = amount;
      this.project = project;
      this.contractSignBodyName = contractSignBodyName;
      this.contractSignBodyId = contractSignBodyId;
      this.contractSignBodyRatio = contractSignBodyRatio;
      this.contractSignBodyPayAmount = contractSignBodyPayAmount;
      this.contractSignBodyRemainAmount = contractSignBodyRemainAmount;
      this.projectManagerName = projectManagerName;
      this.projectManagerId = projectManagerId;
      this.projectManagerRatio = projectManagerRatio;
      this.projectManagerPayAmount = projectManagerPayAmount;
      this.projectManagerRemainAmount = projectManagerRemainAmount;
   }

   public ContractProjectAssetInjectionDetailDTO() {
   }

   public static class ContractProjectAssetInjectionDetailDTOBuilder {
      private LocalDateTime assetInjectionTime;
      private SupplierInfo supplier;
      private Integer type;
      private BigDecimal amount;
      private ProjectInfo project;
      private String contractSignBodyName;
      private Long contractSignBodyId;
      private BigDecimal contractSignBodyRatio;
      private BigDecimal contractSignBodyPayAmount;
      private BigDecimal contractSignBodyRemainAmount;
      private String projectManagerName;
      private Long projectManagerId;
      private BigDecimal projectManagerRatio;
      private BigDecimal projectManagerPayAmount;
      private BigDecimal projectManagerRemainAmount;

      ContractProjectAssetInjectionDetailDTOBuilder() {
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder assetInjectionTime(final LocalDateTime assetInjectionTime) {
         this.assetInjectionTime = assetInjectionTime;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder contractSignBodyName(final String contractSignBodyName) {
         this.contractSignBodyName = contractSignBodyName;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder contractSignBodyRatio(final BigDecimal contractSignBodyRatio) {
         this.contractSignBodyRatio = contractSignBodyRatio;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder contractSignBodyPayAmount(
         final BigDecimal contractSignBodyPayAmount
      ) {
         this.contractSignBodyPayAmount = contractSignBodyPayAmount;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder contractSignBodyRemainAmount(
         final BigDecimal contractSignBodyRemainAmount
      ) {
         this.contractSignBodyRemainAmount = contractSignBodyRemainAmount;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder projectManagerRatio(final BigDecimal projectManagerRatio) {
         this.projectManagerRatio = projectManagerRatio;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder projectManagerPayAmount(
         final BigDecimal projectManagerPayAmount
      ) {
         this.projectManagerPayAmount = projectManagerPayAmount;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder projectManagerRemainAmount(
         final BigDecimal projectManagerRemainAmount
      ) {
         this.projectManagerRemainAmount = projectManagerRemainAmount;
         return this;
      }

      public ContractProjectAssetInjectionDetailDTO build() {
         return new ContractProjectAssetInjectionDetailDTO(
            this.assetInjectionTime,
            this.supplier,
            this.type,
            this.amount,
            this.project,
            this.contractSignBodyName,
            this.contractSignBodyId,
            this.contractSignBodyRatio,
            this.contractSignBodyPayAmount,
            this.contractSignBodyRemainAmount,
            this.projectManagerName,
            this.projectManagerId,
            this.projectManagerRatio,
            this.projectManagerPayAmount,
            this.projectManagerRemainAmount
         );
      }

      @Override
      public String toString() {
         return "ContractProjectAssetInjectionDetailDTO.ContractProjectAssetInjectionDetailDTOBuilder(assetInjectionTime="
            + this.assetInjectionTime
            + ", supplier="
            + this.supplier
            + ", type="
            + this.type
            + ", amount="
            + this.amount
            + ", project="
            + this.project
            + ", contractSignBodyName="
            + this.contractSignBodyName
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", contractSignBodyRatio="
            + this.contractSignBodyRatio
            + ", contractSignBodyPayAmount="
            + this.contractSignBodyPayAmount
            + ", contractSignBodyRemainAmount="
            + this.contractSignBodyRemainAmount
            + ", projectManagerName="
            + this.projectManagerName
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerRatio="
            + this.projectManagerRatio
            + ", projectManagerPayAmount="
            + this.projectManagerPayAmount
            + ", projectManagerRemainAmount="
            + this.projectManagerRemainAmount
            + ")";
      }
   }
}
