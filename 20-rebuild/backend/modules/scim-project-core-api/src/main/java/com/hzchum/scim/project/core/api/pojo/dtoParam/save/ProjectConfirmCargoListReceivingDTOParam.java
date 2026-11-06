package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("确认自制收货请求类")
public class ProjectConfirmCargoListReceivingDTOParam {
   @NotNull(message = "项目id不能为空")
   @ApiModelProperty("项目id")
   private Long projectId;
   @NotNull(message = "发运表id不能为空")
   @ApiModelProperty("发运表id")
   private Long cargoListId;
   @NotNull(message = "是否问题收货不能为空")
   @ApiModelProperty(name = "boolProblemReceiving", value = "是否问题收货 1问题收货 0正常收货 ")
   private Boolean boolProblemReceiving;
   @Size(max = 1024, message = "问题收货描述超出字数限制")
   @ApiModelProperty(name = "problemDesc", value = "问题收货描述 ")
   private String problemDesc;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public Boolean getBoolProblemReceiving() {
      return this.boolProblemReceiving;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
   }

   public void setBoolProblemReceiving(final Boolean boolProblemReceiving) {
      this.boolProblemReceiving = boolProblemReceiving;
   }

   public void setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectConfirmCargoListReceivingDTOParam)) {
         return false;
      }

      ProjectConfirmCargoListReceivingDTOParam other = (ProjectConfirmCargoListReceivingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$cargoListId = this.getCargoListId();
         Object other$cargoListId = other.getCargoListId();
         if (this$cargoListId == null ? other$cargoListId == null : this$cargoListId.equals(other$cargoListId)) {
            Object this$boolProblemReceiving = this.getBoolProblemReceiving();
            Object other$boolProblemReceiving = other.getBoolProblemReceiving();
            if (this$boolProblemReceiving == null ? other$boolProblemReceiving == null : this$boolProblemReceiving.equals(other$boolProblemReceiving)) {
               Object this$problemDesc = this.getProblemDesc();
               Object other$problemDesc = other.getProblemDesc();
               return this$problemDesc == null ? other$problemDesc == null : this$problemDesc.equals(other$problemDesc);
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
      return other instanceof ProjectConfirmCargoListReceivingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $boolProblemReceiving = this.getBoolProblemReceiving();
      result = result * 59 + ($boolProblemReceiving == null ? 43 : $boolProblemReceiving.hashCode());
      Object $problemDesc = this.getProblemDesc();
      return result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectConfirmCargoListReceivingDTOParam(projectId="
         + this.getProjectId()
         + ", cargoListId="
         + this.getCargoListId()
         + ", boolProblemReceiving="
         + this.getBoolProblemReceiving()
         + ", problemDesc="
         + this.getProblemDesc()
         + ")";
   }
}
