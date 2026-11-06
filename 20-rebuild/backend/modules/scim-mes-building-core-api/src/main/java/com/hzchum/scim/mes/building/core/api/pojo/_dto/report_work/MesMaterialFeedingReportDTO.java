package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("投料填报DTO")
public class MesMaterialFeedingReportDTO extends MesMaterialFeedingReport {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("车间idList")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间名称List")
   private List<String> workshopNameList;
   @ApiModelProperty("办理人名称")
   private String userName;
   @ApiModelProperty("详情List")
   private List<MesMaterialFeedingReportDetailDTO> detailList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMaterialFeedingReportDTO)) {
         return false;
      }

      MesMaterialFeedingReportDTO other = (MesMaterialFeedingReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$workshopIdList = this.getWorkshopIdList();
         Object other$workshopIdList = other.getWorkshopIdList();
         if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
            Object this$workshopNameList = this.getWorkshopNameList();
            Object other$workshopNameList = other.getWorkshopNameList();
            if (this$workshopNameList == null ? other$workshopNameList == null : this$workshopNameList.equals(other$workshopNameList)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$detailList = this.getDetailList();
                  Object other$detailList = other.getDetailList();
                  return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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
      return other instanceof MesMaterialFeedingReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $workshopNameList = this.getWorkshopNameList();
      result = result * 59 + ($workshopNameList == null ? 43 : $workshopNameList.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList;
   }

   public List<String> getWorkshopNameList() {
      return this.workshopNameList;
   }

   public String getUserName() {
      return this.userName;
   }

   public List<MesMaterialFeedingReportDetailDTO> getDetailList() {
      return this.detailList;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setWorkshopNameList(final List<String> workshopNameList) {
      this.workshopNameList = workshopNameList;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setDetailList(final List<MesMaterialFeedingReportDetailDTO> detailList) {
      this.detailList = detailList;
   }

   @Override
   public String toString() {
      return "MesMaterialFeedingReportDTO(project="
         + this.getProject()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopNameList="
         + this.getWorkshopNameList()
         + ", userName="
         + this.getUserName()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
