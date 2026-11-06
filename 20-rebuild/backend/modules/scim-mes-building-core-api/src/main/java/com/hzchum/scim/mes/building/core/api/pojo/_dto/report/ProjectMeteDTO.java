package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectMeteDTO", description = "项目产量统计")
public class ProjectMeteDTO {
   @ApiModelProperty(name = "projectInfo", value = "项目")
   @JsonProperty("projectInfo")
   @JSONField(name = "projectInfo")
   private ProjectInfo projectInfo;
   @ApiModelProperty(name = "taskMete", value = "排产量（kg）")
   @JsonProperty("taskMete")
   @JSONField(name = "taskMete")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskMete;
   @ApiModelProperty(name = "mete", value = "产量（kg）")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @ApiModelProperty(name = "loseMete", value = "钢材损耗量（kg）")
   @JsonProperty("loseMete")
   @JSONField(name = "loseMete")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal loseMete;
   @ApiModelProperty(name = "ratio", value = "占比")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;
   @ApiModelProperty(name = "序号", value = "序号(下载使用)")
   @JsonProperty("index")
   @JSONField(name = "index")
   @JsonInclude(Include.NON_NULL)
   private Long index;
   @ApiModelProperty(name = "projectSimpleInfo", value = "项目编号家简称")
   @JsonProperty("projectSimpleInfo")
   @JSONField(name = "projectSimpleInfo")
   @JsonInclude(Include.NON_NULL)
   private String projectSimpleInfo;

   public static ProjectMeteDTO.ProjectMeteDTOBuilder builder() {
      return new ProjectMeteDTO.ProjectMeteDTOBuilder();
   }

   public ProjectMeteDTO() {
   }

   public ProjectMeteDTO(
      final ProjectInfo projectInfo,
      final BigDecimal taskMete,
      final BigDecimal mete,
      final BigDecimal loseMete,
      final BigDecimal ratio,
      final Long index,
      final String projectSimpleInfo
   ) {
      this.projectInfo = projectInfo;
      this.taskMete = taskMete;
      this.mete = mete;
      this.loseMete = loseMete;
      this.ratio = ratio;
      this.index = index;
      this.projectSimpleInfo = projectSimpleInfo;
   }

   public ProjectInfo getProjectInfo() {
      return this.projectInfo;
   }

   public BigDecimal getTaskMete() {
      return this.taskMete;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getLoseMete() {
      return this.loseMete;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public Long getIndex() {
      return this.index;
   }

   public String getProjectSimpleInfo() {
      return this.projectSimpleInfo;
   }

   @JsonProperty("projectInfo")
   public ProjectMeteDTO setProjectInfo(final ProjectInfo projectInfo) {
      this.projectInfo = projectInfo;
      return this;
   }

   @JsonProperty("taskMete")
   public ProjectMeteDTO setTaskMete(final BigDecimal taskMete) {
      this.taskMete = taskMete;
      return this;
   }

   @JsonProperty("mete")
   public ProjectMeteDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("loseMete")
   public ProjectMeteDTO setLoseMete(final BigDecimal loseMete) {
      this.loseMete = loseMete;
      return this;
   }

   @JsonProperty("ratio")
   public ProjectMeteDTO setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
      return this;
   }

   @JsonProperty("index")
   public ProjectMeteDTO setIndex(final Long index) {
      this.index = index;
      return this;
   }

   @JsonProperty("projectSimpleInfo")
   public ProjectMeteDTO setProjectSimpleInfo(final String projectSimpleInfo) {
      this.projectSimpleInfo = projectSimpleInfo;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectMeteDTO(projectInfo="
         + this.getProjectInfo()
         + ", taskMete="
         + this.getTaskMete()
         + ", mete="
         + this.getMete()
         + ", loseMete="
         + this.getLoseMete()
         + ", ratio="
         + this.getRatio()
         + ", index="
         + this.getIndex()
         + ", projectSimpleInfo="
         + this.getProjectSimpleInfo()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectMeteDTO)) {
         return false;
      }

      ProjectMeteDTO other = (ProjectMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$index = this.getIndex();
      Object other$index = other.getIndex();
      if (this$index == null ? other$index == null : this$index.equals(other$index)) {
         Object this$projectInfo = this.getProjectInfo();
         Object other$projectInfo = other.getProjectInfo();
         if (this$projectInfo == null ? other$projectInfo == null : this$projectInfo.equals(other$projectInfo)) {
            Object this$taskMete = this.getTaskMete();
            Object other$taskMete = other.getTaskMete();
            if (this$taskMete == null ? other$taskMete == null : this$taskMete.equals(other$taskMete)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                  Object this$loseMete = this.getLoseMete();
                  Object other$loseMete = other.getLoseMete();
                  if (this$loseMete == null ? other$loseMete == null : this$loseMete.equals(other$loseMete)) {
                     Object this$ratio = this.getRatio();
                     Object other$ratio = other.getRatio();
                     if (this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio)) {
                        Object this$projectSimpleInfo = this.getProjectSimpleInfo();
                        Object other$projectSimpleInfo = other.getProjectSimpleInfo();
                        return this$projectSimpleInfo == null ? other$projectSimpleInfo == null : this$projectSimpleInfo.equals(other$projectSimpleInfo);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $projectInfo = this.getProjectInfo();
      result = result * 59 + ($projectInfo == null ? 43 : $projectInfo.hashCode());
      Object $taskMete = this.getTaskMete();
      result = result * 59 + ($taskMete == null ? 43 : $taskMete.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $loseMete = this.getLoseMete();
      result = result * 59 + ($loseMete == null ? 43 : $loseMete.hashCode());
      Object $ratio = this.getRatio();
      result = result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
      Object $projectSimpleInfo = this.getProjectSimpleInfo();
      return result * 59 + ($projectSimpleInfo == null ? 43 : $projectSimpleInfo.hashCode());
   }

   public static class ProjectMeteDTOBuilder {
      private ProjectInfo projectInfo;
      private BigDecimal taskMete;
      private BigDecimal mete;
      private BigDecimal loseMete;
      private BigDecimal ratio;
      private Long index;
      private String projectSimpleInfo;

      ProjectMeteDTOBuilder() {
      }

      @JsonProperty("projectInfo")
      public ProjectMeteDTO.ProjectMeteDTOBuilder projectInfo(final ProjectInfo projectInfo) {
         this.projectInfo = projectInfo;
         return this;
      }

      @JsonProperty("taskMete")
      public ProjectMeteDTO.ProjectMeteDTOBuilder taskMete(final BigDecimal taskMete) {
         this.taskMete = taskMete;
         return this;
      }

      @JsonProperty("mete")
      public ProjectMeteDTO.ProjectMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("loseMete")
      public ProjectMeteDTO.ProjectMeteDTOBuilder loseMete(final BigDecimal loseMete) {
         this.loseMete = loseMete;
         return this;
      }

      @JsonProperty("ratio")
      public ProjectMeteDTO.ProjectMeteDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      @JsonProperty("index")
      public ProjectMeteDTO.ProjectMeteDTOBuilder index(final Long index) {
         this.index = index;
         return this;
      }

      @JsonProperty("projectSimpleInfo")
      public ProjectMeteDTO.ProjectMeteDTOBuilder projectSimpleInfo(final String projectSimpleInfo) {
         this.projectSimpleInfo = projectSimpleInfo;
         return this;
      }

      public ProjectMeteDTO build() {
         return new ProjectMeteDTO(this.projectInfo, this.taskMete, this.mete, this.loseMete, this.ratio, this.index, this.projectSimpleInfo);
      }

      @Override
      public String toString() {
         return "ProjectMeteDTO.ProjectMeteDTOBuilder(projectInfo="
            + this.projectInfo
            + ", taskMete="
            + this.taskMete
            + ", mete="
            + this.mete
            + ", loseMete="
            + this.loseMete
            + ", ratio="
            + this.ratio
            + ", index="
            + this.index
            + ", projectSimpleInfo="
            + this.projectSimpleInfo
            + ")";
      }
   }
}
