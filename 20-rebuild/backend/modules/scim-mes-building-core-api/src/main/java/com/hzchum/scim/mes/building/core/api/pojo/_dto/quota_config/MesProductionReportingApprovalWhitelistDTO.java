package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalWhitelist;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("报工审核白名单DTO")
public class MesProductionReportingApprovalWhitelistDTO extends MesProductionReportingApprovalWhitelist {
   @ApiModelProperty("车间idList")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间List")
   private List<ShowInfo> workshopList;
   @ApiModelProperty("工序")
   private ShowInfo process;
   @ApiModelProperty("班组idList")
   private List<Long> teamIdList;
   @ApiModelProperty("班组List")
   private List<ShowInfo> teamList;

   public List<Long> getWorkshopIdList() {
      return CollUtil.isEmpty(this.workshopIdList) && StrUtil.isNotBlank(super.getWorkshopIds())
         ? Convert.toList(Long.class, super.getWorkshopIds().split(","))
         : this.workshopIdList;
   }

   public List<Long> getTeamIdList() {
      return CollUtil.isEmpty(this.teamIdList) && StrUtil.isNotBlank(super.getTeamIds())
         ? Convert.toList(Long.class, super.getTeamIds().split(","))
         : this.teamIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalWhitelistDTO)) {
         return false;
      }

      MesProductionReportingApprovalWhitelistDTO other = (MesProductionReportingApprovalWhitelistDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$workshopIdList = this.getWorkshopIdList();
      Object other$workshopIdList = other.getWorkshopIdList();
      if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
         Object this$workshopList = this.getWorkshopList();
         Object other$workshopList = other.getWorkshopList();
         if (this$workshopList == null ? other$workshopList == null : this$workshopList.equals(other$workshopList)) {
            Object this$process = this.getProcess();
            Object other$process = other.getProcess();
            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
               Object this$teamIdList = this.getTeamIdList();
               Object other$teamIdList = other.getTeamIdList();
               if (this$teamIdList == null ? other$teamIdList == null : this$teamIdList.equals(other$teamIdList)) {
                  Object this$teamList = this.getTeamList();
                  Object other$teamList = other.getTeamList();
                  return this$teamList == null ? other$teamList == null : this$teamList.equals(other$teamList);
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
      return other instanceof MesProductionReportingApprovalWhitelistDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $workshopList = this.getWorkshopList();
      result = result * 59 + ($workshopList == null ? 43 : $workshopList.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $teamIdList = this.getTeamIdList();
      result = result * 59 + ($teamIdList == null ? 43 : $teamIdList.hashCode());
      Object $teamList = this.getTeamList();
      return result * 59 + ($teamList == null ? 43 : $teamList.hashCode());
   }

   public List<ShowInfo> getWorkshopList() {
      return this.workshopList;
   }

   public ShowInfo getProcess() {
      return this.process;
   }

   public List<ShowInfo> getTeamList() {
      return this.teamList;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setWorkshopList(final List<ShowInfo> workshopList) {
      this.workshopList = workshopList;
   }

   public void setProcess(final ShowInfo process) {
      this.process = process;
   }

   public void setTeamIdList(final List<Long> teamIdList) {
      this.teamIdList = teamIdList;
   }

   public void setTeamList(final List<ShowInfo> teamList) {
      this.teamList = teamList;
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalWhitelistDTO(workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopList="
         + this.getWorkshopList()
         + ", process="
         + this.getProcess()
         + ", teamIdList="
         + this.getTeamIdList()
         + ", teamList="
         + this.getTeamList()
         + ")";
   }
}
