package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("报工审核白名单新增修改Param")
public class MesProductionReportingApprovalWhitelistParam {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("车间idList")
   @NotEmpty(message = "车间不能为空")
   private List<Long> workshopIdList;
   @ApiModelProperty("工序id")
   @NotNull(message = "工序不能为空")
   private Long processId;
   @ApiModelProperty("班组idList")
   @NotEmpty(message = "班组不能为空")
   private List<Long> teamIdList;
   @ApiModelProperty("车间ids")
   private String workshopIds;
   @ApiModelProperty("班组ids")
   private String teamIds;

   public String getWorkshopIds() {
      return StrUtil.isBlank(this.workshopIds) && CollUtil.isNotEmpty(this.getWorkshopIdList())
         ? StrUtil.blankToDefault(CollUtil.join(this.getWorkshopIdList(), ","), null)
         : this.workshopIds;
   }

   public String getTeamIds() {
      return StrUtil.isBlank(this.teamIds) && CollUtil.isNotEmpty(this.getTeamIdList())
         ? StrUtil.blankToDefault(CollUtil.join(this.getTeamIdList(), ","), null)
         : this.teamIds;
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public List<Long> getTeamIdList() {
      return this.teamIdList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamIdList(final List<Long> teamIdList) {
      this.teamIdList = teamIdList;
   }

   public void setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
   }

   public void setTeamIds(final String teamIds) {
      this.teamIds = teamIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalWhitelistParam)) {
         return false;
      }

      MesProductionReportingApprovalWhitelistParam other = (MesProductionReportingApprovalWhitelistParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$workshopIdList = this.getWorkshopIdList();
            Object other$workshopIdList = other.getWorkshopIdList();
            if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
               Object this$teamIdList = this.getTeamIdList();
               Object other$teamIdList = other.getTeamIdList();
               if (this$teamIdList == null ? other$teamIdList == null : this$teamIdList.equals(other$teamIdList)) {
                  Object this$workshopIds = this.getWorkshopIds();
                  Object other$workshopIds = other.getWorkshopIds();
                  if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                     Object this$teamIds = this.getTeamIds();
                     Object other$teamIds = other.getTeamIds();
                     return this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds);
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
      return other instanceof MesProductionReportingApprovalWhitelistParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $teamIdList = this.getTeamIdList();
      result = result * 59 + ($teamIdList == null ? 43 : $teamIdList.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $teamIds = this.getTeamIds();
      return result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalWhitelistParam(id="
         + this.getId()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", processId="
         + this.getProcessId()
         + ", teamIdList="
         + this.getTeamIdList()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", teamIds="
         + this.getTeamIds()
         + ")";
   }
}
