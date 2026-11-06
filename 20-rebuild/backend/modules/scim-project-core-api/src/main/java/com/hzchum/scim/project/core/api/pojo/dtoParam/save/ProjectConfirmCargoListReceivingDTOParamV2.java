package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ProjectConfirmCargoListReceivingDTOParamV2对象", description = "确认自制收货请求类")
public class ProjectConfirmCargoListReceivingDTOParamV2 {
   @ApiModelProperty("项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("发运表id")
   @NotNull(message = "发运表id不能为空")
   private Long cargoListId;
   @ApiModelProperty(name = "boolProblemReceiving", value = "是否问题收货 1问题收货 0正常收货 ")
   @NotNull(message = "是否问题收货不能为空")
   private Boolean boolProblemReceiving;
   @ApiModelProperty(name = "problemAttachmentIds", value = "问题收货附件")
   private List<Long> problemAttachmentIds;
   @ApiModelProperty("本次所选产品")
   @Valid
   @NotEmpty(message = "所选产品不能为空！")
   @Size(min = 1, message = "所选产品不能为空！")
   private List<ProjectReceiveProductDTOParam> receiveProductDTOParam;

   public static ProjectConfirmCargoListReceivingDTOParamV2.ProjectConfirmCargoListReceivingDTOParamV2Builder builder() {
      return new ProjectConfirmCargoListReceivingDTOParamV2.ProjectConfirmCargoListReceivingDTOParamV2Builder();
   }

   public ProjectConfirmCargoListReceivingDTOParamV2() {
   }

   public ProjectConfirmCargoListReceivingDTOParamV2(
      final Long projectId,
      final Long cargoListId,
      final Boolean boolProblemReceiving,
      final List<Long> problemAttachmentIds,
      final List<ProjectReceiveProductDTOParam> receiveProductDTOParam
   ) {
      this.projectId = projectId;
      this.cargoListId = cargoListId;
      this.boolProblemReceiving = boolProblemReceiving;
      this.problemAttachmentIds = problemAttachmentIds;
      this.receiveProductDTOParam = receiveProductDTOParam;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public Boolean getBoolProblemReceiving() {
      return this.boolProblemReceiving;
   }

   public List<Long> getProblemAttachmentIds() {
      return this.problemAttachmentIds;
   }

   public List<ProjectReceiveProductDTOParam> getReceiveProductDTOParam() {
      return this.receiveProductDTOParam;
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

   public void setProblemAttachmentIds(final List<Long> problemAttachmentIds) {
      this.problemAttachmentIds = problemAttachmentIds;
   }

   public void setReceiveProductDTOParam(final List<ProjectReceiveProductDTOParam> receiveProductDTOParam) {
      this.receiveProductDTOParam = receiveProductDTOParam;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectConfirmCargoListReceivingDTOParamV2)) {
         return false;
      }

      ProjectConfirmCargoListReceivingDTOParamV2 other = (ProjectConfirmCargoListReceivingDTOParamV2)o;
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
               Object this$problemAttachmentIds = this.getProblemAttachmentIds();
               Object other$problemAttachmentIds = other.getProblemAttachmentIds();
               if (this$problemAttachmentIds == null ? other$problemAttachmentIds == null : this$problemAttachmentIds.equals(other$problemAttachmentIds)) {
                  Object this$receiveProductDTOParam = this.getReceiveProductDTOParam();
                  Object other$receiveProductDTOParam = other.getReceiveProductDTOParam();
                  return this$receiveProductDTOParam == null
                     ? other$receiveProductDTOParam == null
                     : this$receiveProductDTOParam.equals(other$receiveProductDTOParam);
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
      return other instanceof ProjectConfirmCargoListReceivingDTOParamV2;
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
      Object $problemAttachmentIds = this.getProblemAttachmentIds();
      result = result * 59 + ($problemAttachmentIds == null ? 43 : $problemAttachmentIds.hashCode());
      Object $receiveProductDTOParam = this.getReceiveProductDTOParam();
      return result * 59 + ($receiveProductDTOParam == null ? 43 : $receiveProductDTOParam.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectConfirmCargoListReceivingDTOParamV2(projectId="
         + this.getProjectId()
         + ", cargoListId="
         + this.getCargoListId()
         + ", boolProblemReceiving="
         + this.getBoolProblemReceiving()
         + ", problemAttachmentIds="
         + this.getProblemAttachmentIds()
         + ", receiveProductDTOParam="
         + this.getReceiveProductDTOParam()
         + ")";
   }

   public static class ProjectConfirmCargoListReceivingDTOParamV2Builder {
      private Long projectId;
      private Long cargoListId;
      private Boolean boolProblemReceiving;
      private List<Long> problemAttachmentIds;
      private List<ProjectReceiveProductDTOParam> receiveProductDTOParam;

      ProjectConfirmCargoListReceivingDTOParamV2Builder() {
      }

      public ProjectConfirmCargoListReceivingDTOParamV2.ProjectConfirmCargoListReceivingDTOParamV2Builder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectConfirmCargoListReceivingDTOParamV2.ProjectConfirmCargoListReceivingDTOParamV2Builder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      public ProjectConfirmCargoListReceivingDTOParamV2.ProjectConfirmCargoListReceivingDTOParamV2Builder boolProblemReceiving(
         final Boolean boolProblemReceiving
      ) {
         this.boolProblemReceiving = boolProblemReceiving;
         return this;
      }

      public ProjectConfirmCargoListReceivingDTOParamV2.ProjectConfirmCargoListReceivingDTOParamV2Builder problemAttachmentIds(
         final List<Long> problemAttachmentIds
      ) {
         this.problemAttachmentIds = problemAttachmentIds;
         return this;
      }

      public ProjectConfirmCargoListReceivingDTOParamV2.ProjectConfirmCargoListReceivingDTOParamV2Builder receiveProductDTOParam(
         final List<ProjectReceiveProductDTOParam> receiveProductDTOParam
      ) {
         this.receiveProductDTOParam = receiveProductDTOParam;
         return this;
      }

      public ProjectConfirmCargoListReceivingDTOParamV2 build() {
         return new ProjectConfirmCargoListReceivingDTOParamV2(
            this.projectId, this.cargoListId, this.boolProblemReceiving, this.problemAttachmentIds, this.receiveProductDTOParam
         );
      }

      @Override
      public String toString() {
         return "ProjectConfirmCargoListReceivingDTOParamV2.ProjectConfirmCargoListReceivingDTOParamV2Builder(projectId="
            + this.projectId
            + ", cargoListId="
            + this.cargoListId
            + ", boolProblemReceiving="
            + this.boolProblemReceiving
            + ", problemAttachmentIds="
            + this.problemAttachmentIds
            + ", receiveProductDTOParam="
            + this.receiveProductDTOParam
            + ")";
      }
   }
}
