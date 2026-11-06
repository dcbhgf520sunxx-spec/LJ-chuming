package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.common.enums.PriceModifySceneEnum;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectStatisticsConfigLink;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目统计配置关联DTO类")
public class MesContractProjectStatisticsConfigLinkDTO extends MesContractProjectStatisticsConfigLink {
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "statisticsModeName", value = "统计模式名称", notes = "统计模式名称")
   private String statisticsModeName;
   @ApiModelProperty(name = "configPriceName", value = "配置价格修改场景名称", notes = "配置价格修改场景名称")
   private String configPriceName;
   @ApiModelProperty(name = "individualPriceName", value = "单个价格修改场景名称", notes = "单个价格修改场景名称")
   private String individualPriceName;

   public String getStatisticsModeName() {
      return this.statisticsModeName != null ? this.statisticsModeName : StatisticsConfigStatisticsModeEnum.getNameByType(this.getStatisticsMode());
   }

   public String getConfigPriceName() {
      return this.configPriceName != null ? this.configPriceName : PriceModifySceneEnum.getNameByType(this.getConfigPrice());
   }

   public String getIndividualPriceName() {
      return this.individualPriceName != null ? this.individualPriceName : PriceModifySceneEnum.getNameByType(this.getIndividualPrice());
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectStatisticsConfigLinkDTO)) {
         return false;
      }

      MesContractProjectStatisticsConfigLinkDTO other = (MesContractProjectStatisticsConfigLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$statisticsModeName = this.getStatisticsModeName();
         Object other$statisticsModeName = other.getStatisticsModeName();
         if (this$statisticsModeName == null ? other$statisticsModeName == null : this$statisticsModeName.equals(other$statisticsModeName)) {
            Object this$configPriceName = this.getConfigPriceName();
            Object other$configPriceName = other.getConfigPriceName();
            if (this$configPriceName == null ? other$configPriceName == null : this$configPriceName.equals(other$configPriceName)) {
               Object this$individualPriceName = this.getIndividualPriceName();
               Object other$individualPriceName = other.getIndividualPriceName();
               return this$individualPriceName == null ? other$individualPriceName == null : this$individualPriceName.equals(other$individualPriceName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectStatisticsConfigLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $statisticsModeName = this.getStatisticsModeName();
      result = result * 59 + ($statisticsModeName == null ? 43 : $statisticsModeName.hashCode());
      Object $configPriceName = this.getConfigPriceName();
      result = result * 59 + ($configPriceName == null ? 43 : $configPriceName.hashCode());
      Object $individualPriceName = this.getIndividualPriceName();
      return result * 59 + ($individualPriceName == null ? 43 : $individualPriceName.hashCode());
   }

   public String getProjectName() {
      return this.projectName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setStatisticsModeName(final String statisticsModeName) {
      this.statisticsModeName = statisticsModeName;
   }

   public void setConfigPriceName(final String configPriceName) {
      this.configPriceName = configPriceName;
   }

   public void setIndividualPriceName(final String individualPriceName) {
      this.individualPriceName = individualPriceName;
   }

   @Override
   public String toString() {
      return "MesContractProjectStatisticsConfigLinkDTO(super="
         + super.toString()
         + ", projectName="
         + this.getProjectName()
         + ", statisticsModeName="
         + this.getStatisticsModeName()
         + ", configPriceName="
         + this.getConfigPriceName()
         + ", individualPriceName="
         + this.getIndividualPriceName()
         + ")";
   }
}
