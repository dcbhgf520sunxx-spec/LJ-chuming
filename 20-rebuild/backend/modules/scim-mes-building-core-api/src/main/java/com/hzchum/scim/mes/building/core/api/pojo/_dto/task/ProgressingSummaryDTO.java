package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ProgressingSummaryDTO", description = "在制品统计")
public class ProgressingSummaryDTO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty("单位")
   @JsonProperty("unit")
   @JSONField(name = "unit")
   private String unit;
   @ApiModelProperty(name = "rawNetWeight", notes = "原材料出库量")
   @JsonProperty("rawNetWeight")
   @JSONField(name = "rawNetWeight")
   private BigDecimal rawNetWeight;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务量(净重)")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "processDTOList", notes = "工序信息")
   @JsonProperty("processDTOList")
   @JSONField(name = "processDTOList")
   private List<ProduceStatisticsProcessDTO> processDTOList;
   @ApiModelProperty(name = "totalNetWeight", notes = "合计量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;

   public static ProgressingSummaryDTO.ProgressingSummaryDTOBuilder builder() {
      return new ProgressingSummaryDTO.ProgressingSummaryDTOBuilder();
   }

   public ProgressingSummaryDTO() {
   }

   public ProgressingSummaryDTO(
      final ProjectDetailDO project,
      final String unit,
      final BigDecimal rawNetWeight,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final List<ProduceStatisticsProcessDTO> processDTOList,
      final BigDecimal totalNetWeight
   ) {
      this.project = project;
      this.unit = unit;
      this.rawNetWeight = rawNetWeight;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.processDTOList = processDTOList;
      this.totalNetWeight = totalNetWeight;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getRawNetWeight() {
      return this.rawNetWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public List<ProduceStatisticsProcessDTO> getProcessDTOList() {
      return this.processDTOList;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   @JsonProperty("project")
   public ProgressingSummaryDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("unit")
   public ProgressingSummaryDTO setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   @JsonProperty("rawNetWeight")
   public ProgressingSummaryDTO setRawNetWeight(final BigDecimal rawNetWeight) {
      this.rawNetWeight = rawNetWeight;
      return this;
   }

   @JsonProperty("taskQuantity")
   public ProgressingSummaryDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public ProgressingSummaryDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("processDTOList")
   public ProgressingSummaryDTO setProcessDTOList(final List<ProduceStatisticsProcessDTO> processDTOList) {
      this.processDTOList = processDTOList;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProgressingSummaryDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProgressingSummaryDTO(project="
         + this.getProject()
         + ", unit="
         + this.getUnit()
         + ", rawNetWeight="
         + this.getRawNetWeight()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", processDTOList="
         + this.getProcessDTOList()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProgressingSummaryDTO)) {
         return false;
      }

      ProgressingSummaryDTO other = (ProgressingSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskQuantity = this.getTaskQuantity();
      Object other$taskQuantity = other.getTaskQuantity();
      if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$unit = this.getUnit();
            Object other$unit = other.getUnit();
            if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
               Object this$rawNetWeight = this.getRawNetWeight();
               Object other$rawNetWeight = other.getRawNetWeight();
               if (this$rawNetWeight == null ? other$rawNetWeight == null : this$rawNetWeight.equals(other$rawNetWeight)) {
                  Object this$taskNetWeight = this.getTaskNetWeight();
                  Object other$taskNetWeight = other.getTaskNetWeight();
                  if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                     Object this$processDTOList = this.getProcessDTOList();
                     Object other$processDTOList = other.getProcessDTOList();
                     if (this$processDTOList == null ? other$processDTOList == null : this$processDTOList.equals(other$processDTOList)) {
                        Object this$totalNetWeight = this.getTotalNetWeight();
                        Object other$totalNetWeight = other.getTotalNetWeight();
                        return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
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
      return other instanceof ProgressingSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $rawNetWeight = this.getRawNetWeight();
      result = result * 59 + ($rawNetWeight == null ? 43 : $rawNetWeight.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $processDTOList = this.getProcessDTOList();
      result = result * 59 + ($processDTOList == null ? 43 : $processDTOList.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   public static class ProgressingSummaryDTOBuilder {
      private ProjectDetailDO project;
      private String unit;
      private BigDecimal rawNetWeight;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private List<ProduceStatisticsProcessDTO> processDTOList;
      private BigDecimal totalNetWeight;

      ProgressingSummaryDTOBuilder() {
      }

      @JsonProperty("project")
      public ProgressingSummaryDTO.ProgressingSummaryDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("unit")
      public ProgressingSummaryDTO.ProgressingSummaryDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      @JsonProperty("rawNetWeight")
      public ProgressingSummaryDTO.ProgressingSummaryDTOBuilder rawNetWeight(final BigDecimal rawNetWeight) {
         this.rawNetWeight = rawNetWeight;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ProgressingSummaryDTO.ProgressingSummaryDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public ProgressingSummaryDTO.ProgressingSummaryDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("processDTOList")
      public ProgressingSummaryDTO.ProgressingSummaryDTOBuilder processDTOList(final List<ProduceStatisticsProcessDTO> processDTOList) {
         this.processDTOList = processDTOList;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProgressingSummaryDTO.ProgressingSummaryDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ProgressingSummaryDTO build() {
         return new ProgressingSummaryDTO(
            this.project, this.unit, this.rawNetWeight, this.taskQuantity, this.taskNetWeight, this.processDTOList, this.totalNetWeight
         );
      }

      @Override
      public String toString() {
         return "ProgressingSummaryDTO.ProgressingSummaryDTOBuilder(project="
            + this.project
            + ", unit="
            + this.unit
            + ", rawNetWeight="
            + this.rawNetWeight
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", processDTOList="
            + this.processDTOList
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
