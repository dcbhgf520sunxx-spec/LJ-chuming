package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class InventoryConfigurationDTO {
   @ApiModelProperty("是否通用配置")
   private Boolean boolGeneralConfig;
   @ApiModelProperty("项目Id")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("项目编号")
   private String projectSerialNumber;
   @ApiModelProperty("项目简称")
   private String projectShortName;
   @ApiModelProperty("清单误差配置详情")
   private List<InventoryConfigurationDetailDTO> detailDTOList;

   public static InventoryConfigurationDTO.InventoryConfigurationDTOBuilder builder() {
      return new InventoryConfigurationDTO.InventoryConfigurationDTOBuilder();
   }

   public InventoryConfigurationDTO() {
   }

   public InventoryConfigurationDTO(
      final Boolean boolGeneralConfig,
      final Long projectId,
      final String projectName,
      final String projectSerialNumber,
      final String projectShortName,
      final List<InventoryConfigurationDetailDTO> detailDTOList
   ) {
      this.boolGeneralConfig = boolGeneralConfig;
      this.projectId = projectId;
      this.projectName = projectName;
      this.projectSerialNumber = projectSerialNumber;
      this.projectShortName = projectShortName;
      this.detailDTOList = detailDTOList;
   }

   public Boolean getBoolGeneralConfig() {
      return this.boolGeneralConfig;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public List<InventoryConfigurationDetailDTO> getDetailDTOList() {
      return this.detailDTOList;
   }

   public void setBoolGeneralConfig(final Boolean boolGeneralConfig) {
      this.boolGeneralConfig = boolGeneralConfig;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
   }

   public void setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
   }

   public void setDetailDTOList(final List<InventoryConfigurationDetailDTO> detailDTOList) {
      this.detailDTOList = detailDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryConfigurationDTO)) {
         return false;
      }

      InventoryConfigurationDTO other = (InventoryConfigurationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolGeneralConfig = this.getBoolGeneralConfig();
      Object other$boolGeneralConfig = other.getBoolGeneralConfig();
      if (this$boolGeneralConfig == null ? other$boolGeneralConfig == null : this$boolGeneralConfig.equals(other$boolGeneralConfig)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$projectSerialNumber = this.getProjectSerialNumber();
               Object other$projectSerialNumber = other.getProjectSerialNumber();
               if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                  Object this$projectShortName = this.getProjectShortName();
                  Object other$projectShortName = other.getProjectShortName();
                  if (this$projectShortName == null ? other$projectShortName == null : this$projectShortName.equals(other$projectShortName)) {
                     Object this$detailDTOList = this.getDetailDTOList();
                     Object other$detailDTOList = other.getDetailDTOList();
                     return this$detailDTOList == null ? other$detailDTOList == null : this$detailDTOList.equals(other$detailDTOList);
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
      return other instanceof InventoryConfigurationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolGeneralConfig = this.getBoolGeneralConfig();
      result = result * 59 + ($boolGeneralConfig == null ? 43 : $boolGeneralConfig.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $detailDTOList = this.getDetailDTOList();
      return result * 59 + ($detailDTOList == null ? 43 : $detailDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryConfigurationDTO(boolGeneralConfig="
         + this.getBoolGeneralConfig()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", detailDTOList="
         + this.getDetailDTOList()
         + ")";
   }

   public static class InventoryConfigurationDTOBuilder {
      private Boolean boolGeneralConfig;
      private Long projectId;
      private String projectName;
      private String projectSerialNumber;
      private String projectShortName;
      private List<InventoryConfigurationDetailDTO> detailDTOList;

      InventoryConfigurationDTOBuilder() {
      }

      public InventoryConfigurationDTO.InventoryConfigurationDTOBuilder boolGeneralConfig(final Boolean boolGeneralConfig) {
         this.boolGeneralConfig = boolGeneralConfig;
         return this;
      }

      public InventoryConfigurationDTO.InventoryConfigurationDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public InventoryConfigurationDTO.InventoryConfigurationDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public InventoryConfigurationDTO.InventoryConfigurationDTOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      public InventoryConfigurationDTO.InventoryConfigurationDTOBuilder projectShortName(final String projectShortName) {
         this.projectShortName = projectShortName;
         return this;
      }

      public InventoryConfigurationDTO.InventoryConfigurationDTOBuilder detailDTOList(final List<InventoryConfigurationDetailDTO> detailDTOList) {
         this.detailDTOList = detailDTOList;
         return this;
      }

      public InventoryConfigurationDTO build() {
         return new InventoryConfigurationDTO(
            this.boolGeneralConfig, this.projectId, this.projectName, this.projectSerialNumber, this.projectShortName, this.detailDTOList
         );
      }

      @Override
      public String toString() {
         return "InventoryConfigurationDTO.InventoryConfigurationDTOBuilder(boolGeneralConfig="
            + this.boolGeneralConfig
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", projectShortName="
            + this.projectShortName
            + ", detailDTOList="
            + this.detailDTOList
            + ")";
      }
   }
}
