package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifact;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("定额配置构件DTO")
public class MesQuotaConfigArtifactDTO extends MesQuotaConfigArtifact {
   @ApiModelProperty("机构idList")
   private List<Long> branchCompanyIdList;
   @ApiModelProperty("机构List")
   private List<ShowInfo> branchCompanyList;
   @ApiModelProperty("车间idList")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间List")
   private List<ShowInfo> workshopList;
   @ApiModelProperty("构件种类idList")
   private List<Long> artifactClassIdList;
   @ApiModelProperty("构件种类List")
   private List<ShowInfo> artifactClassList;
   @ApiModelProperty("构件名称List")
   private List<String> artifactNameList;
   @ApiModelProperty("工序")
   private ShowInfo process;
   @ApiModelProperty("条件List")
   private List<MesQuotaConfigArtifactConditionDTO> conditionList;

   public List<Long> getBranchCompanyIdList() {
      return CollUtil.isEmpty(this.branchCompanyIdList) && StrUtil.isNotBlank(super.getBranchCompanyIds())
         ? Convert.toList(Long.class, super.getBranchCompanyIds().split(","))
         : this.branchCompanyIdList;
   }

   public List<Long> getWorkshopIdList() {
      return CollUtil.isEmpty(this.workshopIdList) && StrUtil.isNotBlank(super.getWorkshopIds())
         ? Convert.toList(Long.class, super.getWorkshopIds().split(","))
         : this.workshopIdList;
   }

   public List<Long> getArtifactClassIdList() {
      return CollUtil.isEmpty(this.artifactClassIdList) && StrUtil.isNotBlank(super.getArtifactClassIds())
         ? Convert.toList(Long.class, super.getArtifactClassIds().split(","))
         : this.artifactClassIdList;
   }

   public List<String> getArtifactNameList() {
      return CollUtil.isEmpty(this.artifactNameList) && StrUtil.isNotBlank(super.getArtifactNames())
         ? Convert.toList(String.class, super.getArtifactNames().split(","))
         : this.artifactNameList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigArtifactDTO)) {
         return false;
      }

      MesQuotaConfigArtifactDTO other = (MesQuotaConfigArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$branchCompanyIdList = this.getBranchCompanyIdList();
      Object other$branchCompanyIdList = other.getBranchCompanyIdList();
      if (this$branchCompanyIdList == null ? other$branchCompanyIdList == null : this$branchCompanyIdList.equals(other$branchCompanyIdList)) {
         Object this$branchCompanyList = this.getBranchCompanyList();
         Object other$branchCompanyList = other.getBranchCompanyList();
         if (this$branchCompanyList == null ? other$branchCompanyList == null : this$branchCompanyList.equals(other$branchCompanyList)) {
            Object this$workshopIdList = this.getWorkshopIdList();
            Object other$workshopIdList = other.getWorkshopIdList();
            if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
               Object this$workshopList = this.getWorkshopList();
               Object other$workshopList = other.getWorkshopList();
               if (this$workshopList == null ? other$workshopList == null : this$workshopList.equals(other$workshopList)) {
                  Object this$artifactClassIdList = this.getArtifactClassIdList();
                  Object other$artifactClassIdList = other.getArtifactClassIdList();
                  if (this$artifactClassIdList == null ? other$artifactClassIdList == null : this$artifactClassIdList.equals(other$artifactClassIdList)) {
                     Object this$artifactClassList = this.getArtifactClassList();
                     Object other$artifactClassList = other.getArtifactClassList();
                     if (this$artifactClassList == null ? other$artifactClassList == null : this$artifactClassList.equals(other$artifactClassList)) {
                        Object this$artifactNameList = this.getArtifactNameList();
                        Object other$artifactNameList = other.getArtifactNameList();
                        if (this$artifactNameList == null ? other$artifactNameList == null : this$artifactNameList.equals(other$artifactNameList)) {
                           Object this$process = this.getProcess();
                           Object other$process = other.getProcess();
                           if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                              Object this$conditionList = this.getConditionList();
                              Object other$conditionList = other.getConditionList();
                              return this$conditionList == null ? other$conditionList == null : this$conditionList.equals(other$conditionList);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $branchCompanyIdList = this.getBranchCompanyIdList();
      result = result * 59 + ($branchCompanyIdList == null ? 43 : $branchCompanyIdList.hashCode());
      Object $branchCompanyList = this.getBranchCompanyList();
      result = result * 59 + ($branchCompanyList == null ? 43 : $branchCompanyList.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $workshopList = this.getWorkshopList();
      result = result * 59 + ($workshopList == null ? 43 : $workshopList.hashCode());
      Object $artifactClassIdList = this.getArtifactClassIdList();
      result = result * 59 + ($artifactClassIdList == null ? 43 : $artifactClassIdList.hashCode());
      Object $artifactClassList = this.getArtifactClassList();
      result = result * 59 + ($artifactClassList == null ? 43 : $artifactClassList.hashCode());
      Object $artifactNameList = this.getArtifactNameList();
      result = result * 59 + ($artifactNameList == null ? 43 : $artifactNameList.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $conditionList = this.getConditionList();
      return result * 59 + ($conditionList == null ? 43 : $conditionList.hashCode());
   }

   public List<ShowInfo> getBranchCompanyList() {
      return this.branchCompanyList;
   }

   public List<ShowInfo> getWorkshopList() {
      return this.workshopList;
   }

   public List<ShowInfo> getArtifactClassList() {
      return this.artifactClassList;
   }

   public ShowInfo getProcess() {
      return this.process;
   }

   public List<MesQuotaConfigArtifactConditionDTO> getConditionList() {
      return this.conditionList;
   }

   public void setBranchCompanyIdList(final List<Long> branchCompanyIdList) {
      this.branchCompanyIdList = branchCompanyIdList;
   }

   public void setBranchCompanyList(final List<ShowInfo> branchCompanyList) {
      this.branchCompanyList = branchCompanyList;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setWorkshopList(final List<ShowInfo> workshopList) {
      this.workshopList = workshopList;
   }

   public void setArtifactClassIdList(final List<Long> artifactClassIdList) {
      this.artifactClassIdList = artifactClassIdList;
   }

   public void setArtifactClassList(final List<ShowInfo> artifactClassList) {
      this.artifactClassList = artifactClassList;
   }

   public void setArtifactNameList(final List<String> artifactNameList) {
      this.artifactNameList = artifactNameList;
   }

   public void setProcess(final ShowInfo process) {
      this.process = process;
   }

   public void setConditionList(final List<MesQuotaConfigArtifactConditionDTO> conditionList) {
      this.conditionList = conditionList;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigArtifactDTO(branchCompanyIdList="
         + this.getBranchCompanyIdList()
         + ", branchCompanyList="
         + this.getBranchCompanyList()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopList="
         + this.getWorkshopList()
         + ", artifactClassIdList="
         + this.getArtifactClassIdList()
         + ", artifactClassList="
         + this.getArtifactClassList()
         + ", artifactNameList="
         + this.getArtifactNameList()
         + ", process="
         + this.getProcess()
         + ", conditionList="
         + this.getConditionList()
         + ")";
   }
}
