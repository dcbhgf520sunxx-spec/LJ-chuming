package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ProjectPurchaseReceivingDTOParam", description = "确认自制收货请求类")
public class ProjectPurchaseReceivingDTOParam {
   @ApiModelProperty("项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("合同id不能为空")
   @NotNull(message = "合同id不能为空")
   private Long contractId;
   @ApiModelProperty("本次所选产品")
   @Valid
   @NotEmpty(message = "所选产品不能为空！")
   @Size(min = 1, message = "所选产品不能为空！")
   private List<ProjectPurchaseReceiveDTOParam> receiveDTOParam;

   public static ProjectPurchaseReceivingDTOParam.ProjectPurchaseReceivingDTOParamBuilder builder() {
      return new ProjectPurchaseReceivingDTOParam.ProjectPurchaseReceivingDTOParamBuilder();
   }

   public ProjectPurchaseReceivingDTOParam() {
   }

   public ProjectPurchaseReceivingDTOParam(final Long projectId, final Long contractId, final List<ProjectPurchaseReceiveDTOParam> receiveDTOParam) {
      this.projectId = projectId;
      this.contractId = contractId;
      this.receiveDTOParam = receiveDTOParam;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getContractId() {
      return this.contractId;
   }

   public List<ProjectPurchaseReceiveDTOParam> getReceiveDTOParam() {
      return this.receiveDTOParam;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setContractId(final Long contractId) {
      this.contractId = contractId;
   }

   public void setReceiveDTOParam(final List<ProjectPurchaseReceiveDTOParam> receiveDTOParam) {
      this.receiveDTOParam = receiveDTOParam;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPurchaseReceivingDTOParam)) {
         return false;
      }

      ProjectPurchaseReceivingDTOParam other = (ProjectPurchaseReceivingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$contractId = this.getContractId();
         Object other$contractId = other.getContractId();
         if (this$contractId == null ? other$contractId == null : this$contractId.equals(other$contractId)) {
            Object this$receiveDTOParam = this.getReceiveDTOParam();
            Object other$receiveDTOParam = other.getReceiveDTOParam();
            return this$receiveDTOParam == null ? other$receiveDTOParam == null : this$receiveDTOParam.equals(other$receiveDTOParam);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectPurchaseReceivingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $contractId = this.getContractId();
      result = result * 59 + ($contractId == null ? 43 : $contractId.hashCode());
      Object $receiveDTOParam = this.getReceiveDTOParam();
      return result * 59 + ($receiveDTOParam == null ? 43 : $receiveDTOParam.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPurchaseReceivingDTOParam(projectId="
         + this.getProjectId()
         + ", contractId="
         + this.getContractId()
         + ", receiveDTOParam="
         + this.getReceiveDTOParam()
         + ")";
   }

   public static class ProjectPurchaseReceivingDTOParamBuilder {
      private Long projectId;
      private Long contractId;
      private List<ProjectPurchaseReceiveDTOParam> receiveDTOParam;

      ProjectPurchaseReceivingDTOParamBuilder() {
      }

      public ProjectPurchaseReceivingDTOParam.ProjectPurchaseReceivingDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectPurchaseReceivingDTOParam.ProjectPurchaseReceivingDTOParamBuilder contractId(final Long contractId) {
         this.contractId = contractId;
         return this;
      }

      public ProjectPurchaseReceivingDTOParam.ProjectPurchaseReceivingDTOParamBuilder receiveDTOParam(
         final List<ProjectPurchaseReceiveDTOParam> receiveDTOParam
      ) {
         this.receiveDTOParam = receiveDTOParam;
         return this;
      }

      public ProjectPurchaseReceivingDTOParam build() {
         return new ProjectPurchaseReceivingDTOParam(this.projectId, this.contractId, this.receiveDTOParam);
      }

      @Override
      public String toString() {
         return "ProjectPurchaseReceivingDTOParam.ProjectPurchaseReceivingDTOParamBuilder(projectId="
            + this.projectId
            + ", contractId="
            + this.contractId
            + ", receiveDTOParam="
            + this.receiveDTOParam
            + ")";
      }
   }
}
