package com.hzchum.scim.system.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "清单误差配置VO ")
public class InventoryConfigurationVO {
   @ApiModelProperty("项目Id")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("项目编号")
   private String projectSerialNumber;
   @ApiModelProperty("项目简称")
   private String projectShortName;
   @ApiModelProperty("是否通用配置")
   @NotNull(message = "是否通用配置不可为空")
   private Boolean boolGeneralConfig;
   @ApiModelProperty("清单误差配置详情")
   @NotEmpty(message = "清单误差配置详情不能为空")
   @Valid
   private List<InventoryConfigurationDetailVO> detailDTOList;

   public static InventoryConfigurationVO.InventoryConfigurationVOBuilder builder() {
      return new InventoryConfigurationVO.InventoryConfigurationVOBuilder();
   }

   public InventoryConfigurationVO() {
   }

   public InventoryConfigurationVO(
      final Long projectId,
      final String projectName,
      final String projectSerialNumber,
      final String projectShortName,
      final Boolean boolGeneralConfig,
      final List<InventoryConfigurationDetailVO> detailDTOList
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.projectSerialNumber = projectSerialNumber;
      this.projectShortName = projectShortName;
      this.boolGeneralConfig = boolGeneralConfig;
      this.detailDTOList = detailDTOList;
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

   public Boolean getBoolGeneralConfig() {
      return this.boolGeneralConfig;
   }

   public List<InventoryConfigurationDetailVO> getDetailDTOList() {
      return this.detailDTOList;
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

   public void setBoolGeneralConfig(final Boolean boolGeneralConfig) {
      this.boolGeneralConfig = boolGeneralConfig;
   }

   public void setDetailDTOList(final List<InventoryConfigurationDetailVO> detailDTOList) {
      this.detailDTOList = detailDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryConfigurationVO)) {
         return false;
      }

      InventoryConfigurationVO other = (InventoryConfigurationVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$boolGeneralConfig = this.getBoolGeneralConfig();
         Object other$boolGeneralConfig = other.getBoolGeneralConfig();
         if (this$boolGeneralConfig == null ? other$boolGeneralConfig == null : this$boolGeneralConfig.equals(other$boolGeneralConfig)) {
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
      return other instanceof InventoryConfigurationVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolGeneralConfig = this.getBoolGeneralConfig();
      result = result * 59 + ($boolGeneralConfig == null ? 43 : $boolGeneralConfig.hashCode());
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
      return "InventoryConfigurationVO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", boolGeneralConfig="
         + this.getBoolGeneralConfig()
         + ", detailDTOList="
         + this.getDetailDTOList()
         + ")";
   }

   public static class InventoryConfigurationVOBuilder {
      private Long projectId;
      private String projectName;
      private String projectSerialNumber;
      private String projectShortName;
      private Boolean boolGeneralConfig;
      private List<InventoryConfigurationDetailVO> detailDTOList;

      InventoryConfigurationVOBuilder() {
      }

      public InventoryConfigurationVO.InventoryConfigurationVOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public InventoryConfigurationVO.InventoryConfigurationVOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public InventoryConfigurationVO.InventoryConfigurationVOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      public InventoryConfigurationVO.InventoryConfigurationVOBuilder projectShortName(final String projectShortName) {
         this.projectShortName = projectShortName;
         return this;
      }

      public InventoryConfigurationVO.InventoryConfigurationVOBuilder boolGeneralConfig(final Boolean boolGeneralConfig) {
         this.boolGeneralConfig = boolGeneralConfig;
         return this;
      }

      public InventoryConfigurationVO.InventoryConfigurationVOBuilder detailDTOList(final List<InventoryConfigurationDetailVO> detailDTOList) {
         this.detailDTOList = detailDTOList;
         return this;
      }

      public InventoryConfigurationVO build() {
         return new InventoryConfigurationVO(
            this.projectId, this.projectName, this.projectSerialNumber, this.projectShortName, this.boolGeneralConfig, this.detailDTOList
         );
      }

      @Override
      public String toString() {
         return "InventoryConfigurationVO.InventoryConfigurationVOBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", projectShortName="
            + this.projectShortName
            + ", boolGeneralConfig="
            + this.boolGeneralConfig
            + ", detailDTOList="
            + this.detailDTOList
            + ")";
      }
   }
}
