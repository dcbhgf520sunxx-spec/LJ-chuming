package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ContractProjectAssetInjectionDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "assetInjectionTime", value = "注资日期", notes = "注资日期")
   private LocalDateTime assetInjectionTime;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "CapitalContributor", value = "注资方", notes = "注资方")
   private NameInfo capitalContributor;
   @ApiModelProperty(name = "capitalContributorAmount", value = "注资方金额", notes = "注资方金额")
   private BigDecimal capitalContributorAmount;
   @ApiModelProperty(name = "assetInjectionName", value = "注资类型 1:银行转账2银行承兑4商业承兑", notes = "注资类型 1:银行转账2银行承兑4商业承兑")
   private String assetInjectionName;
   @ApiModelProperty(name = "incomeOrDisburse", value = "收入支出 0收入，1支出", notes = "收入支出 0收入，1支出")
   private Boolean incomeOrDisburse;
   @ApiModelProperty(name = "creatorUser", value = "填报人", notes = "填报人")
   private NameInfo creatorUser;
   @ApiModelProperty(name = "putUserName", value = "最后操作人", notes = "最后操作人")
   private String putUserName;
   @ApiModelProperty(name = "updateTime", value = "修改时间", notes = "修改时间")
   private LocalDateTime updateTime;
   @ApiModelProperty(name = "attachment", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachment;

   public static ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder builder() {
      return new ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder();
   }

   public ContractProjectAssetInjectionDTO() {
   }

   public ContractProjectAssetInjectionDTO(
      final Long id,
      final LocalDateTime assetInjectionTime,
      final ProjectInfo project,
      final NameInfo capitalContributor,
      final BigDecimal capitalContributorAmount,
      final String assetInjectionName,
      final Boolean incomeOrDisburse,
      final NameInfo creatorUser,
      final String putUserName,
      final LocalDateTime updateTime,
      final List<AttachmentDTO> attachment
   ) {
      this.id = id;
      this.assetInjectionTime = assetInjectionTime;
      this.project = project;
      this.capitalContributor = capitalContributor;
      this.capitalContributorAmount = capitalContributorAmount;
      this.assetInjectionName = assetInjectionName;
      this.incomeOrDisburse = incomeOrDisburse;
      this.creatorUser = creatorUser;
      this.putUserName = putUserName;
      this.updateTime = updateTime;
      this.attachment = attachment;
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

   public NameInfo getCapitalContributor() {
      return this.capitalContributor;
   }

   public BigDecimal getCapitalContributorAmount() {
      return this.capitalContributorAmount;
   }

   public String getAssetInjectionName() {
      return this.assetInjectionName;
   }

   public Boolean getIncomeOrDisburse() {
      return this.incomeOrDisburse;
   }

   public NameInfo getCreatorUser() {
      return this.creatorUser;
   }

   public String getPutUserName() {
      return this.putUserName;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public List<AttachmentDTO> getAttachment() {
      return this.attachment;
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

   public void setCapitalContributor(final NameInfo capitalContributor) {
      this.capitalContributor = capitalContributor;
   }

   public void setCapitalContributorAmount(final BigDecimal capitalContributorAmount) {
      this.capitalContributorAmount = capitalContributorAmount;
   }

   public void setAssetInjectionName(final String assetInjectionName) {
      this.assetInjectionName = assetInjectionName;
   }

   public void setIncomeOrDisburse(final Boolean incomeOrDisburse) {
      this.incomeOrDisburse = incomeOrDisburse;
   }

   public void setCreatorUser(final NameInfo creatorUser) {
      this.creatorUser = creatorUser;
   }

   public void setPutUserName(final String putUserName) {
      this.putUserName = putUserName;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setAttachment(final List<AttachmentDTO> attachment) {
      this.attachment = attachment;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectAssetInjectionDTO)) {
         return false;
      }

      ContractProjectAssetInjectionDTO other = (ContractProjectAssetInjectionDTO)o;
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
                  Object this$capitalContributor = this.getCapitalContributor();
                  Object other$capitalContributor = other.getCapitalContributor();
                  if (this$capitalContributor == null ? other$capitalContributor == null : this$capitalContributor.equals(other$capitalContributor)) {
                     Object this$capitalContributorAmount = this.getCapitalContributorAmount();
                     Object other$capitalContributorAmount = other.getCapitalContributorAmount();
                     if (this$capitalContributorAmount == null
                        ? other$capitalContributorAmount == null
                        : this$capitalContributorAmount.equals(other$capitalContributorAmount)) {
                        Object this$assetInjectionName = this.getAssetInjectionName();
                        Object other$assetInjectionName = other.getAssetInjectionName();
                        if (this$assetInjectionName == null ? other$assetInjectionName == null : this$assetInjectionName.equals(other$assetInjectionName)) {
                           Object this$creatorUser = this.getCreatorUser();
                           Object other$creatorUser = other.getCreatorUser();
                           if (this$creatorUser == null ? other$creatorUser == null : this$creatorUser.equals(other$creatorUser)) {
                              Object this$putUserName = this.getPutUserName();
                              Object other$putUserName = other.getPutUserName();
                              if (this$putUserName == null ? other$putUserName == null : this$putUserName.equals(other$putUserName)) {
                                 Object this$updateTime = this.getUpdateTime();
                                 Object other$updateTime = other.getUpdateTime();
                                 if (this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime)) {
                                    Object this$attachment = this.getAttachment();
                                    Object other$attachment = other.getAttachment();
                                    return this$attachment == null ? other$attachment == null : this$attachment.equals(other$attachment);
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
      return other instanceof ContractProjectAssetInjectionDTO;
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
      Object $capitalContributor = this.getCapitalContributor();
      result = result * 59 + ($capitalContributor == null ? 43 : $capitalContributor.hashCode());
      Object $capitalContributorAmount = this.getCapitalContributorAmount();
      result = result * 59 + ($capitalContributorAmount == null ? 43 : $capitalContributorAmount.hashCode());
      Object $assetInjectionName = this.getAssetInjectionName();
      result = result * 59 + ($assetInjectionName == null ? 43 : $assetInjectionName.hashCode());
      Object $creatorUser = this.getCreatorUser();
      result = result * 59 + ($creatorUser == null ? 43 : $creatorUser.hashCode());
      Object $putUserName = this.getPutUserName();
      result = result * 59 + ($putUserName == null ? 43 : $putUserName.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $attachment = this.getAttachment();
      return result * 59 + ($attachment == null ? 43 : $attachment.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectAssetInjectionDTO(id="
         + this.getId()
         + ", assetInjectionTime="
         + this.getAssetInjectionTime()
         + ", project="
         + this.getProject()
         + ", capitalContributor="
         + this.getCapitalContributor()
         + ", capitalContributorAmount="
         + this.getCapitalContributorAmount()
         + ", assetInjectionName="
         + this.getAssetInjectionName()
         + ", incomeOrDisburse="
         + this.getIncomeOrDisburse()
         + ", creatorUser="
         + this.getCreatorUser()
         + ", putUserName="
         + this.getPutUserName()
         + ", updateTime="
         + this.getUpdateTime()
         + ", attachment="
         + this.getAttachment()
         + ")";
   }

   public static class ContractProjectAssetInjectionDTOBuilder {
      private Long id;
      private LocalDateTime assetInjectionTime;
      private ProjectInfo project;
      private NameInfo capitalContributor;
      private BigDecimal capitalContributorAmount;
      private String assetInjectionName;
      private Boolean incomeOrDisburse;
      private NameInfo creatorUser;
      private String putUserName;
      private LocalDateTime updateTime;
      private List<AttachmentDTO> attachment;

      ContractProjectAssetInjectionDTOBuilder() {
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder assetInjectionTime(final LocalDateTime assetInjectionTime) {
         this.assetInjectionTime = assetInjectionTime;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder capitalContributor(final NameInfo capitalContributor) {
         this.capitalContributor = capitalContributor;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder capitalContributorAmount(final BigDecimal capitalContributorAmount) {
         this.capitalContributorAmount = capitalContributorAmount;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder assetInjectionName(final String assetInjectionName) {
         this.assetInjectionName = assetInjectionName;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder incomeOrDisburse(final Boolean incomeOrDisburse) {
         this.incomeOrDisburse = incomeOrDisburse;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder creatorUser(final NameInfo creatorUser) {
         this.creatorUser = creatorUser;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder putUserName(final String putUserName) {
         this.putUserName = putUserName;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder attachment(final List<AttachmentDTO> attachment) {
         this.attachment = attachment;
         return this;
      }

      public ContractProjectAssetInjectionDTO build() {
         return new ContractProjectAssetInjectionDTO(
            this.id,
            this.assetInjectionTime,
            this.project,
            this.capitalContributor,
            this.capitalContributorAmount,
            this.assetInjectionName,
            this.incomeOrDisburse,
            this.creatorUser,
            this.putUserName,
            this.updateTime,
            this.attachment
         );
      }

      @Override
      public String toString() {
         return "ContractProjectAssetInjectionDTO.ContractProjectAssetInjectionDTOBuilder(id="
            + this.id
            + ", assetInjectionTime="
            + this.assetInjectionTime
            + ", project="
            + this.project
            + ", capitalContributor="
            + this.capitalContributor
            + ", capitalContributorAmount="
            + this.capitalContributorAmount
            + ", assetInjectionName="
            + this.assetInjectionName
            + ", incomeOrDisburse="
            + this.incomeOrDisburse
            + ", creatorUser="
            + this.creatorUser
            + ", putUserName="
            + this.putUserName
            + ", updateTime="
            + this.updateTime
            + ", attachment="
            + this.attachment
            + ")";
      }
   }
}
