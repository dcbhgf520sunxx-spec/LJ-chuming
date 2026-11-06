package com.hzchum.scim.project.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("施工资料")
public class DataConstructionDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "dataConstructionConfigId", value = "施工资料配置")
   @NotNull(message = "施工资料配置不能为空")
   private Long dataConstructionConfigId;

   public static DataConstructionDTOParam.DataConstructionDTOParamBuilder builder() {
      return new DataConstructionDTOParam.DataConstructionDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getDataConstructionConfigId() {
      return this.dataConstructionConfigId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setDataConstructionConfigId(final Long dataConstructionConfigId) {
      this.dataConstructionConfigId = dataConstructionConfigId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DataConstructionDTOParam)) {
         return false;
      } else {
         DataConstructionDTOParam other = (DataConstructionDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$dataConstructionConfigId = this.getDataConstructionConfigId();
               Object other$dataConstructionConfigId = other.getDataConstructionConfigId();
               return this$dataConstructionConfigId == null
                  ? other$dataConstructionConfigId == null
                  : this$dataConstructionConfigId.equals(other$dataConstructionConfigId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DataConstructionDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $dataConstructionConfigId = this.getDataConstructionConfigId();
      return result * 59 + ($dataConstructionConfigId == null ? 43 : $dataConstructionConfigId.hashCode());
   }

   @Override
   public String toString() {
      return "DataConstructionDTOParam(projectId=" + this.getProjectId() + ", dataConstructionConfigId=" + this.getDataConstructionConfigId() + ")";
   }

   public DataConstructionDTOParam() {
   }

   public DataConstructionDTOParam(final Long projectId, final Long dataConstructionConfigId) {
      this.projectId = projectId;
      this.dataConstructionConfigId = dataConstructionConfigId;
   }

   public static class DataConstructionDTOParamBuilder {
      private Long projectId;
      private Long dataConstructionConfigId;

      DataConstructionDTOParamBuilder() {
      }

      public DataConstructionDTOParam.DataConstructionDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public DataConstructionDTOParam.DataConstructionDTOParamBuilder dataConstructionConfigId(final Long dataConstructionConfigId) {
         this.dataConstructionConfigId = dataConstructionConfigId;
         return this;
      }

      public DataConstructionDTOParam build() {
         return new DataConstructionDTOParam(this.projectId, this.dataConstructionConfigId);
      }

      @Override
      public String toString() {
         return "DataConstructionDTOParam.DataConstructionDTOParamBuilder(projectId="
            + this.projectId
            + ", dataConstructionConfigId="
            + this.dataConstructionConfigId
            + ")";
      }
   }
}
