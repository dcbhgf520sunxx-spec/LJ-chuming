package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ContractProjectAssetInjectionPutDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "assetInjectionTime", value = "注资日期", notes = "注资日期")
   private LocalDateTime assetInjectionTime;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private ProjectInfo project;
   @ApiModelProperty(name = "contractSignBodyId", value = "签约主体", notes = "签约主体")
   private NameInfo contractSignBody;
   @ApiModelProperty(name = "contractSignBodyScale", value = "签约主体注资", notes = "签约主体注资")
   private BigDecimal contractSignBodyScale;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理id")
   private NameInfo projectManager;
   @ApiModelProperty(name = "projectManagerScale", value = "项目经理注资", notes = "项目经理注资")
   private BigDecimal projectManagerScale;
   @ApiModelProperty(name = "assetInjectionEnum", value = "注资类型INJECTION_TYPE", notes = "注资类型INJECTION_TYPE")
   private String assetInjectionEnum;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款银行", notes = "收款银行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "attachment", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachment;
   @ApiModelProperty(name = "incomeOrDisburse", value = "收入支出 1收入，0支出", notes = "收入支出 1收入，0支出")
   private Boolean incomeOrDisburse;
   @ApiModelProperty(name = "creatorUser", value = "填报人", notes = "填报人")
   private NameInfo user;

   public static ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder builder() {
      return new ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder();
   }

   public ContractProjectAssetInjectionPutDTO() {
   }

   public ContractProjectAssetInjectionPutDTO(
      final Long id,
      final LocalDateTime assetInjectionTime,
      final ProjectInfo project,
      final NameInfo contractSignBody,
      final BigDecimal contractSignBodyScale,
      final NameInfo projectManager,
      final BigDecimal projectManagerScale,
      final String assetInjectionEnum,
      final String collectionDepositBank,
      final List<AttachmentDTO> attachment,
      final Boolean incomeOrDisburse,
      final NameInfo user
   ) {
      this.id = id;
      this.assetInjectionTime = assetInjectionTime;
      this.project = project;
      this.contractSignBody = contractSignBody;
      this.contractSignBodyScale = contractSignBodyScale;
      this.projectManager = projectManager;
      this.projectManagerScale = projectManagerScale;
      this.assetInjectionEnum = assetInjectionEnum;
      this.collectionDepositBank = collectionDepositBank;
      this.attachment = attachment;
      this.incomeOrDisburse = incomeOrDisburse;
      this.user = user;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getAssetInjectionTime() {
      return this.assetInjectionTime;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getContractSignBody() {
      return this.contractSignBody;
   }

   public BigDecimal getContractSignBodyScale() {
      return this.contractSignBodyScale;
   }

   public NameInfo getProjectManager() {
      return this.projectManager;
   }

   public BigDecimal getProjectManagerScale() {
      return this.projectManagerScale;
   }

   public String getAssetInjectionEnum() {
      return this.assetInjectionEnum;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public List<AttachmentDTO> getAttachment() {
      return this.attachment;
   }

   public Boolean getIncomeOrDisburse() {
      return this.incomeOrDisburse;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAssetInjectionTime(final LocalDateTime assetInjectionTime) {
      this.assetInjectionTime = assetInjectionTime;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setContractSignBody(final NameInfo contractSignBody) {
      this.contractSignBody = contractSignBody;
   }

   public void setContractSignBodyScale(final BigDecimal contractSignBodyScale) {
      this.contractSignBodyScale = contractSignBodyScale;
   }

   public void setProjectManager(final NameInfo projectManager) {
      this.projectManager = projectManager;
   }

   public void setProjectManagerScale(final BigDecimal projectManagerScale) {
      this.projectManagerScale = projectManagerScale;
   }

   public void setAssetInjectionEnum(final String assetInjectionEnum) {
      this.assetInjectionEnum = assetInjectionEnum;
   }

   public void setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
   }

   public void setAttachment(final List<AttachmentDTO> attachment) {
      this.attachment = attachment;
   }

   public void setIncomeOrDisburse(final Boolean incomeOrDisburse) {
      this.incomeOrDisburse = incomeOrDisburse;
   }

   public void setUser(final NameInfo user) {
      this.user = user;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectAssetInjectionPutDTO)) {
         return false;
      }

      ContractProjectAssetInjectionPutDTO other = (ContractProjectAssetInjectionPutDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$incomeOrDisburse = this.getIncomeOrDisburse();
         Object other$incomeOrDisburse = other.getIncomeOrDisburse();
         if (this$incomeOrDisburse == null ? other$incomeOrDisburse == null : this$incomeOrDisburse.equals(other$incomeOrDisburse)) {
            Object this$assetInjectionTime = this.getAssetInjectionTime();
            Object other$assetInjectionTime = other.getAssetInjectionTime();
            if (this$assetInjectionTime == null ? other$assetInjectionTime == null : this$assetInjectionTime.equals(other$assetInjectionTime)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$contractSignBody = this.getContractSignBody();
                  Object other$contractSignBody = other.getContractSignBody();
                  if (this$contractSignBody == null ? other$contractSignBody == null : this$contractSignBody.equals(other$contractSignBody)) {
                     Object this$contractSignBodyScale = this.getContractSignBodyScale();
                     Object other$contractSignBodyScale = other.getContractSignBodyScale();
                     if (this$contractSignBodyScale == null
                        ? other$contractSignBodyScale == null
                        : this$contractSignBodyScale.equals(other$contractSignBodyScale)) {
                        Object this$projectManager = this.getProjectManager();
                        Object other$projectManager = other.getProjectManager();
                        if (this$projectManager == null ? other$projectManager == null : this$projectManager.equals(other$projectManager)) {
                           Object this$projectManagerScale = this.getProjectManagerScale();
                           Object other$projectManagerScale = other.getProjectManagerScale();
                           if (this$projectManagerScale == null
                              ? other$projectManagerScale == null
                              : this$projectManagerScale.equals(other$projectManagerScale)) {
                              Object this$assetInjectionEnum = this.getAssetInjectionEnum();
                              Object other$assetInjectionEnum = other.getAssetInjectionEnum();
                              if (this$assetInjectionEnum == null ? other$assetInjectionEnum == null : this$assetInjectionEnum.equals(other$assetInjectionEnum)
                                 )
                               {
                                 Object this$collectionDepositBank = this.getCollectionDepositBank();
                                 Object other$collectionDepositBank = other.getCollectionDepositBank();
                                 if (this$collectionDepositBank == null
                                    ? other$collectionDepositBank == null
                                    : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                    Object this$attachment = this.getAttachment();
                                    Object other$attachment = other.getAttachment();
                                    if (this$attachment == null ? other$attachment == null : this$attachment.equals(other$attachment)) {
                                       Object this$user = this.getUser();
                                       Object other$user = other.getUser();
                                       return this$user == null ? other$user == null : this$user.equals(other$user);
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
      return other instanceof ContractProjectAssetInjectionPutDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $incomeOrDisburse = this.getIncomeOrDisburse();
      result = result * 59 + ($incomeOrDisburse == null ? 43 : $incomeOrDisburse.hashCode());
      Object $assetInjectionTime = this.getAssetInjectionTime();
      result = result * 59 + ($assetInjectionTime == null ? 43 : $assetInjectionTime.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractSignBody = this.getContractSignBody();
      result = result * 59 + ($contractSignBody == null ? 43 : $contractSignBody.hashCode());
      Object $contractSignBodyScale = this.getContractSignBodyScale();
      result = result * 59 + ($contractSignBodyScale == null ? 43 : $contractSignBodyScale.hashCode());
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $projectManagerScale = this.getProjectManagerScale();
      result = result * 59 + ($projectManagerScale == null ? 43 : $projectManagerScale.hashCode());
      Object $assetInjectionEnum = this.getAssetInjectionEnum();
      result = result * 59 + ($assetInjectionEnum == null ? 43 : $assetInjectionEnum.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $attachment = this.getAttachment();
      result = result * 59 + ($attachment == null ? 43 : $attachment.hashCode());
      Object $user = this.getUser();
      return result * 59 + ($user == null ? 43 : $user.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectAssetInjectionPutDTO(id="
         + this.getId()
         + ", assetInjectionTime="
         + this.getAssetInjectionTime()
         + ", project="
         + this.getProject()
         + ", contractSignBody="
         + this.getContractSignBody()
         + ", contractSignBodyScale="
         + this.getContractSignBodyScale()
         + ", projectManager="
         + this.getProjectManager()
         + ", projectManagerScale="
         + this.getProjectManagerScale()
         + ", assetInjectionEnum="
         + this.getAssetInjectionEnum()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", attachment="
         + this.getAttachment()
         + ", incomeOrDisburse="
         + this.getIncomeOrDisburse()
         + ", user="
         + this.getUser()
         + ")";
   }

   public static class ContractProjectAssetInjectionPutDTOBuilder {
      private Long id;
      private LocalDateTime assetInjectionTime;
      private ProjectInfo project;
      private NameInfo contractSignBody;
      private BigDecimal contractSignBodyScale;
      private NameInfo projectManager;
      private BigDecimal projectManagerScale;
      private String assetInjectionEnum;
      private String collectionDepositBank;
      private List<AttachmentDTO> attachment;
      private Boolean incomeOrDisburse;
      private NameInfo user;

      ContractProjectAssetInjectionPutDTOBuilder() {
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder assetInjectionTime(final LocalDateTime assetInjectionTime) {
         this.assetInjectionTime = assetInjectionTime;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder contractSignBody(final NameInfo contractSignBody) {
         this.contractSignBody = contractSignBody;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder contractSignBodyScale(final BigDecimal contractSignBodyScale) {
         this.contractSignBodyScale = contractSignBodyScale;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder projectManager(final NameInfo projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder projectManagerScale(final BigDecimal projectManagerScale) {
         this.projectManagerScale = projectManagerScale;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder assetInjectionEnum(final String assetInjectionEnum) {
         this.assetInjectionEnum = assetInjectionEnum;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder attachment(final List<AttachmentDTO> attachment) {
         this.attachment = attachment;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder incomeOrDisburse(final Boolean incomeOrDisburse) {
         this.incomeOrDisburse = incomeOrDisburse;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      public ContractProjectAssetInjectionPutDTO build() {
         return new ContractProjectAssetInjectionPutDTO(
            this.id,
            this.assetInjectionTime,
            this.project,
            this.contractSignBody,
            this.contractSignBodyScale,
            this.projectManager,
            this.projectManagerScale,
            this.assetInjectionEnum,
            this.collectionDepositBank,
            this.attachment,
            this.incomeOrDisburse,
            this.user
         );
      }

      @Override
      public String toString() {
         return "ContractProjectAssetInjectionPutDTO.ContractProjectAssetInjectionPutDTOBuilder(id="
            + this.id
            + ", assetInjectionTime="
            + this.assetInjectionTime
            + ", project="
            + this.project
            + ", contractSignBody="
            + this.contractSignBody
            + ", contractSignBodyScale="
            + this.contractSignBodyScale
            + ", projectManager="
            + this.projectManager
            + ", projectManagerScale="
            + this.projectManagerScale
            + ", assetInjectionEnum="
            + this.assetInjectionEnum
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", attachment="
            + this.attachment
            + ", incomeOrDisburse="
            + this.incomeOrDisburse
            + ", user="
            + this.user
            + ")";
      }
   }
}
