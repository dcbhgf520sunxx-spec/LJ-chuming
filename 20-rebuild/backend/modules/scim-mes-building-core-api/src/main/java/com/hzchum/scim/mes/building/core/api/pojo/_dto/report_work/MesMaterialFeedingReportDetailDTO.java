package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReportDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("投料填报详情DTO")
public class MesMaterialFeedingReportDetailDTO extends MesMaterialFeedingReportDetail {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("批次名称")
   private String areaBatchName;
   @ApiModelProperty("车间名称")
   private String workshopName;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMaterialFeedingReportDetailDTO)) {
         return false;
      }

      MesMaterialFeedingReportDetailDTO other = (MesMaterialFeedingReportDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$monomerName = this.getMonomerName();
         Object other$monomerName = other.getMonomerName();
         if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
            Object this$areaBatchName = this.getAreaBatchName();
            Object other$areaBatchName = other.getAreaBatchName();
            if (this$areaBatchName == null ? other$areaBatchName == null : this$areaBatchName.equals(other$areaBatchName)) {
               Object this$workshopName = this.getWorkshopName();
               Object other$workshopName = other.getWorkshopName();
               return this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName);
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
      return other instanceof MesMaterialFeedingReportDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @Override
   public String toString() {
      return "MesMaterialFeedingReportDetailDTO(project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", workshopName="
         + this.getWorkshopName()
         + ")";
   }
}
