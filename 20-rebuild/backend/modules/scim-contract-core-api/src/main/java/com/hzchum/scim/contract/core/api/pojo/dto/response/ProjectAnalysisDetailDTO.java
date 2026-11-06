package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("项目统计类")
public class ProjectAnalysisDetailDTO {
   @ApiModelProperty("时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "name", notes = "项目名称")
   private String name;
   @ApiModelProperty("项目类型")
   private Integer businessType;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("项目编号")
   private String serialNumber;
   private ProjectInfo project;
   @ApiModelProperty(name = "customer_unit", notes = "客户单位名称")
   private String customerUnit;
   @ApiModelProperty("签订主体)")
   private String branchCompanyName;
   @ApiModelProperty("总金额")
   private BigDecimal contractAmount;
   @ApiModelProperty("清单量")
   private BigDecimal deepMete;

   public static ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder builder() {
      return new ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder();
   }

   public ProjectAnalysisDetailDTO() {
   }

   public ProjectAnalysisDetailDTO(
      final LocalDateTime createTime,
      final String name,
      final Integer businessType,
      final String shortName,
      final String serialNumber,
      final ProjectInfo project,
      final String customerUnit,
      final String branchCompanyName,
      final BigDecimal contractAmount,
      final BigDecimal deepMete
   ) {
      this.createTime = createTime;
      this.name = name;
      this.businessType = businessType;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.project = project;
      this.customerUnit = customerUnit;
      this.branchCompanyName = branchCompanyName;
      this.contractAmount = contractAmount;
      this.deepMete = deepMete;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getName() {
      return this.name;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getDeepMete() {
      return this.deepMete;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setDeepMete(final BigDecimal deepMete) {
      this.deepMete = deepMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAnalysisDetailDTO)) {
         return false;
      }

      ProjectAnalysisDetailDTO other = (ProjectAnalysisDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessType = this.getBusinessType();
      Object other$businessType = other.getBusinessType();
      if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
         Object this$createTime = this.getCreateTime();
         Object other$createTime = other.getCreateTime();
         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$shortName = this.getShortName();
               Object other$shortName = other.getShortName();
               if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$customerUnit = this.getCustomerUnit();
                        Object other$customerUnit = other.getCustomerUnit();
                        if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                           Object this$branchCompanyName = this.getBranchCompanyName();
                           Object other$branchCompanyName = other.getBranchCompanyName();
                           if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                              Object this$contractAmount = this.getContractAmount();
                              Object other$contractAmount = other.getContractAmount();
                              if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                 Object this$deepMete = this.getDeepMete();
                                 Object other$deepMete = other.getDeepMete();
                                 return this$deepMete == null ? other$deepMete == null : this$deepMete.equals(other$deepMete);
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
      return other instanceof ProjectAnalysisDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $deepMete = this.getDeepMete();
      return result * 59 + ($deepMete == null ? 43 : $deepMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAnalysisDetailDTO(createTime="
         + this.getCreateTime()
         + ", name="
         + this.getName()
         + ", businessType="
         + this.getBusinessType()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", project="
         + this.getProject()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", deepMete="
         + this.getDeepMete()
         + ")";
   }

   public static class ProjectAnalysisDetailDTOBuilder {
      private LocalDateTime createTime;
      private String name;
      private Integer businessType;
      private String shortName;
      private String serialNumber;
      private ProjectInfo project;
      private String customerUnit;
      private String branchCompanyName;
      private BigDecimal contractAmount;
      private BigDecimal deepMete;

      ProjectAnalysisDetailDTOBuilder() {
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder deepMete(final BigDecimal deepMete) {
         this.deepMete = deepMete;
         return this;
      }

      public ProjectAnalysisDetailDTO build() {
         return new ProjectAnalysisDetailDTO(
            this.createTime,
            this.name,
            this.businessType,
            this.shortName,
            this.serialNumber,
            this.project,
            this.customerUnit,
            this.branchCompanyName,
            this.contractAmount,
            this.deepMete
         );
      }

      @Override
      public String toString() {
         return "ProjectAnalysisDetailDTO.ProjectAnalysisDetailDTOBuilder(createTime="
            + this.createTime
            + ", name="
            + this.name
            + ", businessType="
            + this.businessType
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", project="
            + this.project
            + ", customerUnit="
            + this.customerUnit
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", contractAmount="
            + this.contractAmount
            + ", deepMete="
            + this.deepMete
            + ")";
      }
   }
}
