package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class ContractProjectAssetInjectionDTOParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "assetInjectionTime", value = "注资日期", notes = "注资日期")
   @NotNull(message = "注资日期不能为空")
   private LocalDateTime assetInjectionTime;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "contractSignBodyId", value = "签约主体", notes = "签约主体")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyScale", value = "签约主体注资", notes = "签约主体注资")
   @DecimalMin(value = "0.01", message = "签约主体注资不能小于0")
   private BigDecimal contractSignBodyScale;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerScale", value = "项目主体注资", notes = "项目主体注资")
   @DecimalMin(value = "0.01", message = "项目主体注资不能小于0")
   private BigDecimal projectManagerScale;
   @ApiModelProperty(name = "assetInjectionEnum", value = "注资类型", notes = "注资类型")
   @NotNull(message = "注资类型不能为空")
   private String assetInjectionEnum;
   @ApiModelProperty(name = "disburseEnum", value = "支出类型", notes = "支出类型")
   private Integer disburseEnum;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款银行", notes = "收款银行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   private List<Long> attachmentId;
   @ApiModelProperty(name = "incomeOrDisburse", value = "收入支出 0收入，1支出", notes = "收入支出 0收入，1支出")
   private Boolean incomeOrDisburse;
   @ApiModelProperty(name = "creatorUserId", value = "创建人", notes = "创建人")
   private Long creatorUserId;

   public static ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder builder() {
      return new ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder();
   }

   public ContractProjectAssetInjectionDTOParam() {
   }

   public ContractProjectAssetInjectionDTOParam(
      final Long id,
      final LocalDateTime assetInjectionTime,
      final Long projectId,
      final Long contractSignBodyId,
      final BigDecimal contractSignBodyScale,
      final Long projectManagerId,
      final BigDecimal projectManagerScale,
      final String assetInjectionEnum,
      final Integer disburseEnum,
      final String collectionDepositBank,
      final List<Long> attachmentId,
      final Boolean incomeOrDisburse,
      final Long creatorUserId
   ) {
      this.id = id;
      this.assetInjectionTime = assetInjectionTime;
      this.projectId = projectId;
      this.contractSignBodyId = contractSignBodyId;
      this.contractSignBodyScale = contractSignBodyScale;
      this.projectManagerId = projectManagerId;
      this.projectManagerScale = projectManagerScale;
      this.assetInjectionEnum = assetInjectionEnum;
      this.disburseEnum = disburseEnum;
      this.collectionDepositBank = collectionDepositBank;
      this.attachmentId = attachmentId;
      this.incomeOrDisburse = incomeOrDisburse;
      this.creatorUserId = creatorUserId;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getAssetInjectionTime() {
      return this.assetInjectionTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public BigDecimal getContractSignBodyScale() {
      return this.contractSignBodyScale;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public BigDecimal getProjectManagerScale() {
      return this.projectManagerScale;
   }

   public String getAssetInjectionEnum() {
      return this.assetInjectionEnum;
   }

   public Integer getDisburseEnum() {
      return this.disburseEnum;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public Boolean getIncomeOrDisburse() {
      return this.incomeOrDisburse;
   }

   public Long getCreatorUserId() {
      return this.creatorUserId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAssetInjectionTime(final LocalDateTime assetInjectionTime) {
      this.assetInjectionTime = assetInjectionTime;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setContractSignBodyScale(final BigDecimal contractSignBodyScale) {
      this.contractSignBodyScale = contractSignBodyScale;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerScale(final BigDecimal projectManagerScale) {
      this.projectManagerScale = projectManagerScale;
   }

   public void setAssetInjectionEnum(final String assetInjectionEnum) {
      this.assetInjectionEnum = assetInjectionEnum;
   }

   public void setDisburseEnum(final Integer disburseEnum) {
      this.disburseEnum = disburseEnum;
   }

   public void setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setIncomeOrDisburse(final Boolean incomeOrDisburse) {
      this.incomeOrDisburse = incomeOrDisburse;
   }

   public void setCreatorUserId(final Long creatorUserId) {
      this.creatorUserId = creatorUserId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectAssetInjectionDTOParam)) {
         return false;
      }

      ContractProjectAssetInjectionDTOParam other = (ContractProjectAssetInjectionDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$contractSignBodyId = this.getContractSignBodyId();
            Object other$contractSignBodyId = other.getContractSignBodyId();
            if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
               Object this$projectManagerId = this.getProjectManagerId();
               Object other$projectManagerId = other.getProjectManagerId();
               if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                  Object this$disburseEnum = this.getDisburseEnum();
                  Object other$disburseEnum = other.getDisburseEnum();
                  if (this$disburseEnum == null ? other$disburseEnum == null : this$disburseEnum.equals(other$disburseEnum)) {
                     Object this$incomeOrDisburse = this.getIncomeOrDisburse();
                     Object other$incomeOrDisburse = other.getIncomeOrDisburse();
                     if (this$incomeOrDisburse == null ? other$incomeOrDisburse == null : this$incomeOrDisburse.equals(other$incomeOrDisburse)) {
                        Object this$creatorUserId = this.getCreatorUserId();
                        Object other$creatorUserId = other.getCreatorUserId();
                        if (this$creatorUserId == null ? other$creatorUserId == null : this$creatorUserId.equals(other$creatorUserId)) {
                           Object this$assetInjectionTime = this.getAssetInjectionTime();
                           Object other$assetInjectionTime = other.getAssetInjectionTime();
                           if (this$assetInjectionTime == null ? other$assetInjectionTime == null : this$assetInjectionTime.equals(other$assetInjectionTime)) {
                              Object this$contractSignBodyScale = this.getContractSignBodyScale();
                              Object other$contractSignBodyScale = other.getContractSignBodyScale();
                              if (this$contractSignBodyScale == null
                                 ? other$contractSignBodyScale == null
                                 : this$contractSignBodyScale.equals(other$contractSignBodyScale)) {
                                 Object this$projectManagerScale = this.getProjectManagerScale();
                                 Object other$projectManagerScale = other.getProjectManagerScale();
                                 if (this$projectManagerScale == null
                                    ? other$projectManagerScale == null
                                    : this$projectManagerScale.equals(other$projectManagerScale)) {
                                    Object this$assetInjectionEnum = this.getAssetInjectionEnum();
                                    Object other$assetInjectionEnum = other.getAssetInjectionEnum();
                                    if (this$assetInjectionEnum == null
                                       ? other$assetInjectionEnum == null
                                       : this$assetInjectionEnum.equals(other$assetInjectionEnum)) {
                                       Object this$collectionDepositBank = this.getCollectionDepositBank();
                                       Object other$collectionDepositBank = other.getCollectionDepositBank();
                                       if (this$collectionDepositBank == null
                                          ? other$collectionDepositBank == null
                                          : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                          Object this$attachmentId = this.getAttachmentId();
                                          Object other$attachmentId = other.getAttachmentId();
                                          return this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId);
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
      return other instanceof ContractProjectAssetInjectionDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $disburseEnum = this.getDisburseEnum();
      result = result * 59 + ($disburseEnum == null ? 43 : $disburseEnum.hashCode());
      Object $incomeOrDisburse = this.getIncomeOrDisburse();
      result = result * 59 + ($incomeOrDisburse == null ? 43 : $incomeOrDisburse.hashCode());
      Object $creatorUserId = this.getCreatorUserId();
      result = result * 59 + ($creatorUserId == null ? 43 : $creatorUserId.hashCode());
      Object $assetInjectionTime = this.getAssetInjectionTime();
      result = result * 59 + ($assetInjectionTime == null ? 43 : $assetInjectionTime.hashCode());
      Object $contractSignBodyScale = this.getContractSignBodyScale();
      result = result * 59 + ($contractSignBodyScale == null ? 43 : $contractSignBodyScale.hashCode());
      Object $projectManagerScale = this.getProjectManagerScale();
      result = result * 59 + ($projectManagerScale == null ? 43 : $projectManagerScale.hashCode());
      Object $assetInjectionEnum = this.getAssetInjectionEnum();
      result = result * 59 + ($assetInjectionEnum == null ? 43 : $assetInjectionEnum.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $attachmentId = this.getAttachmentId();
      return result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectAssetInjectionDTOParam(id="
         + this.getId()
         + ", assetInjectionTime="
         + this.getAssetInjectionTime()
         + ", projectId="
         + this.getProjectId()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyScale="
         + this.getContractSignBodyScale()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerScale="
         + this.getProjectManagerScale()
         + ", assetInjectionEnum="
         + this.getAssetInjectionEnum()
         + ", disburseEnum="
         + this.getDisburseEnum()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", incomeOrDisburse="
         + this.getIncomeOrDisburse()
         + ", creatorUserId="
         + this.getCreatorUserId()
         + ")";
   }

   public static class ContractProjectAssetInjectionDTOParamBuilder {
      private Long id;
      private LocalDateTime assetInjectionTime;
      private Long projectId;
      private Long contractSignBodyId;
      private BigDecimal contractSignBodyScale;
      private Long projectManagerId;
      private BigDecimal projectManagerScale;
      private String assetInjectionEnum;
      private Integer disburseEnum;
      private String collectionDepositBank;
      private List<Long> attachmentId;
      private Boolean incomeOrDisburse;
      private Long creatorUserId;

      ContractProjectAssetInjectionDTOParamBuilder() {
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder assetInjectionTime(final LocalDateTime assetInjectionTime) {
         this.assetInjectionTime = assetInjectionTime;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder contractSignBodyScale(final BigDecimal contractSignBodyScale) {
         this.contractSignBodyScale = contractSignBodyScale;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder projectManagerScale(final BigDecimal projectManagerScale) {
         this.projectManagerScale = projectManagerScale;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder assetInjectionEnum(final String assetInjectionEnum) {
         this.assetInjectionEnum = assetInjectionEnum;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder disburseEnum(final Integer disburseEnum) {
         this.disburseEnum = disburseEnum;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder attachmentId(final List<Long> attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder incomeOrDisburse(final Boolean incomeOrDisburse) {
         this.incomeOrDisburse = incomeOrDisburse;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder creatorUserId(final Long creatorUserId) {
         this.creatorUserId = creatorUserId;
         return this;
      }

      public ContractProjectAssetInjectionDTOParam build() {
         return new ContractProjectAssetInjectionDTOParam(
            this.id,
            this.assetInjectionTime,
            this.projectId,
            this.contractSignBodyId,
            this.contractSignBodyScale,
            this.projectManagerId,
            this.projectManagerScale,
            this.assetInjectionEnum,
            this.disburseEnum,
            this.collectionDepositBank,
            this.attachmentId,
            this.incomeOrDisburse,
            this.creatorUserId
         );
      }

      @Override
      public String toString() {
         return "ContractProjectAssetInjectionDTOParam.ContractProjectAssetInjectionDTOParamBuilder(id="
            + this.id
            + ", assetInjectionTime="
            + this.assetInjectionTime
            + ", projectId="
            + this.projectId
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", contractSignBodyScale="
            + this.contractSignBodyScale
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerScale="
            + this.projectManagerScale
            + ", assetInjectionEnum="
            + this.assetInjectionEnum
            + ", disburseEnum="
            + this.disburseEnum
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", attachmentId="
            + this.attachmentId
            + ", incomeOrDisburse="
            + this.incomeOrDisburse
            + ", creatorUserId="
            + this.creatorUserId
            + ")";
      }
   }
}
