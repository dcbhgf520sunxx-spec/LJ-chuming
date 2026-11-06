package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAssemble;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("定额配置部件DTO")
public class MesQuotaConfigAssembleDTO extends MesQuotaConfigAssemble {
   @ApiModelProperty("机构idList")
   private List<Long> branchCompanyIdList;
   @ApiModelProperty("机构List")
   private List<ShowInfo> branchCompanyList;
   @ApiModelProperty("车间idList")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间List")
   private List<ShowInfo> workshopList;
   @ApiModelProperty("部件种类idList")
   private List<Long> assembleClassIdList;
   @ApiModelProperty("部件种类List")
   private List<ShowInfo> assembleClassList;
   @ApiModelProperty("工序")
   private ShowInfo process;
   @ApiModelProperty("条件List")
   private List<MesQuotaConfigAssembleConditionDTO> conditionList;

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

   public List<Long> getAssembleClassIdList() {
      return CollUtil.isEmpty(this.assembleClassIdList) && StrUtil.isNotBlank(super.getAssembleClassIds())
         ? Convert.toList(Long.class, super.getAssembleClassIds().split(","))
         : this.assembleClassIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigAssembleDTO)) {
         return false;
      }

      MesQuotaConfigAssembleDTO other = (MesQuotaConfigAssembleDTO)o;
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
                  Object this$assembleClassIdList = this.getAssembleClassIdList();
                  Object other$assembleClassIdList = other.getAssembleClassIdList();
                  if (this$assembleClassIdList == null ? other$assembleClassIdList == null : this$assembleClassIdList.equals(other$assembleClassIdList)) {
                     Object this$assembleClassList = this.getAssembleClassList();
                     Object other$assembleClassList = other.getAssembleClassList();
                     if (this$assembleClassList == null ? other$assembleClassList == null : this$assembleClassList.equals(other$assembleClassList)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigAssembleDTO;
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
      Object $assembleClassIdList = this.getAssembleClassIdList();
      result = result * 59 + ($assembleClassIdList == null ? 43 : $assembleClassIdList.hashCode());
      Object $assembleClassList = this.getAssembleClassList();
      result = result * 59 + ($assembleClassList == null ? 43 : $assembleClassList.hashCode());
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

   public List<ShowInfo> getAssembleClassList() {
      return this.assembleClassList;
   }

   public ShowInfo getProcess() {
      return this.process;
   }

   public List<MesQuotaConfigAssembleConditionDTO> getConditionList() {
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

   public void setAssembleClassIdList(final List<Long> assembleClassIdList) {
      this.assembleClassIdList = assembleClassIdList;
   }

   public void setAssembleClassList(final List<ShowInfo> assembleClassList) {
      this.assembleClassList = assembleClassList;
   }

   public void setProcess(final ShowInfo process) {
      this.process = process;
   }

   public void setConditionList(final List<MesQuotaConfigAssembleConditionDTO> conditionList) {
      this.conditionList = conditionList;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigAssembleDTO(branchCompanyIdList="
         + this.getBranchCompanyIdList()
         + ", branchCompanyList="
         + this.getBranchCompanyList()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopList="
         + this.getWorkshopList()
         + ", assembleClassIdList="
         + this.getAssembleClassIdList()
         + ", assembleClassList="
         + this.getAssembleClassList()
         + ", process="
         + this.getProcess()
         + ", conditionList="
         + this.getConditionList()
         + ")";
   }
}
