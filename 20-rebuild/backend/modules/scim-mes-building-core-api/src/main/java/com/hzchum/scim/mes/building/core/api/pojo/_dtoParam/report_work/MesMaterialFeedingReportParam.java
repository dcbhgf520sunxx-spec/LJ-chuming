package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("投料填报新增编辑Param")
public class MesMaterialFeedingReportParam {
   @ApiModelProperty("项目id")
   @NotNull(groups = {Add.class, Update.class}, message = "项目不能为空")
   private Long projectId;
   @ApiModelProperty("详情ParamList")
   @NotEmpty(groups = {Add.class, Update.class}, message = "详情不能为空")
   @Valid
   private List<MesMaterialFeedingReportDetailParam> detailParamList;

   public Long getProjectId() {
      return this.projectId;
   }

   public List<MesMaterialFeedingReportDetailParam> getDetailParamList() {
      return this.detailParamList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setDetailParamList(final List<MesMaterialFeedingReportDetailParam> detailParamList) {
      this.detailParamList = detailParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesMaterialFeedingReportParam)) {
         return false;
      } else {
         MesMaterialFeedingReportParam other = (MesMaterialFeedingReportParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$detailParamList = this.getDetailParamList();
               Object other$detailParamList = other.getDetailParamList();
               return this$detailParamList == null ? other$detailParamList == null : this$detailParamList.equals(other$detailParamList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesMaterialFeedingReportParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $detailParamList = this.getDetailParamList();
      return result * 59 + ($detailParamList == null ? 43 : $detailParamList.hashCode());
   }

   @Override
   public String toString() {
      return "MesMaterialFeedingReportParam(projectId=" + this.getProjectId() + ", detailParamList=" + this.getDetailParamList() + ")";
   }
}
