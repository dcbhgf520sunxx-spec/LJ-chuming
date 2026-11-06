package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ProduceStatisticsDTO", description = "生产统计")
public class ProduceStatisticsDTO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty("单位")
   @JsonProperty("unit")
   @JSONField(name = "unit")
   private String unit;
   @ApiModelProperty(name = "rawTotalNetWeight", notes = "原材料累计出库量")
   @JsonProperty("rawTotalNetWeight")
   @JSONField(name = "rawTotalNetWeight")
   private BigDecimal rawTotalNetWeight;
   @ApiModelProperty(name = "rawTotalGrossWeight", notes = "原材料累计出库量(毛重)")
   @JsonProperty("rawTotalGrossWeight")
   @JSONField(name = "rawTotalGrossWeight")
   private BigDecimal rawTotalGrossWeight;
   @ApiModelProperty(name = "rawNetWeight", notes = "原材料本月出库量")
   @JsonProperty("rawNetWeight")
   @JSONField(name = "rawNetWeight")
   private BigDecimal rawNetWeight;
   @ApiModelProperty(name = "rawGrossWeight", notes = "原材料本月出库量(毛重)")
   @JsonProperty("rawGrossWeight")
   @JSONField(name = "rawGrossWeight")
   private BigDecimal rawGrossWeight;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务量(净重)")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务量(毛重)")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "processDTOList", notes = "工序信息")
   @JsonProperty("processDTOList")
   @JSONField(name = "processDTOList")
   private List<ProduceStatisticsProcessDTO> processDTOList;
   @ApiModelProperty(name = "finishNetWeight", notes = "制成品量(净重)")
   @JsonProperty("finishNetWeight")
   @JSONField(name = "finishNetWeight")
   private BigDecimal finishNetWeight;
   @ApiModelProperty(name = "finishGrossWeight", notes = "制成品量(毛重)")
   @JsonProperty("finishGrossWeight")
   @JSONField(name = "finishGrossWeight")
   private BigDecimal finishGrossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "合计量(制成品+在制品)")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "合计量(制成品+在制品)")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "lossNetWeight", notes = "损耗量")
   @JsonProperty("lossNetWeight")
   @JSONField(name = "lossNetWeight")
   private BigDecimal lossNetWeight;
   @ApiModelProperty(name = "lossGrossWeight", notes = "损耗量")
   @JsonProperty("lossGrossWeight")
   @JSONField(name = "lossGrossWeight")
   private BigDecimal lossGrossWeight;
   @ApiModelProperty(name = "lossRate", notes = "损耗率")
   @JsonProperty("lossRate")
   @JSONField(name = "lossRate")
   private BigDecimal lossRate;

   public static ProduceStatisticsDTO.ProduceStatisticsDTOBuilder builder() {
      return new ProduceStatisticsDTO.ProduceStatisticsDTOBuilder();
   }

   public ProduceStatisticsDTO() {
   }

   public ProduceStatisticsDTO(
      final ProjectDetailDO project,
      final String unit,
      final BigDecimal rawTotalNetWeight,
      final BigDecimal rawTotalGrossWeight,
      final BigDecimal rawNetWeight,
      final BigDecimal rawGrossWeight,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final List<ProduceStatisticsProcessDTO> processDTOList,
      final BigDecimal finishNetWeight,
      final BigDecimal finishGrossWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal lossNetWeight,
      final BigDecimal lossGrossWeight,
      final BigDecimal lossRate
   ) {
      this.project = project;
      this.unit = unit;
      this.rawTotalNetWeight = rawTotalNetWeight;
      this.rawTotalGrossWeight = rawTotalGrossWeight;
      this.rawNetWeight = rawNetWeight;
      this.rawGrossWeight = rawGrossWeight;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.processDTOList = processDTOList;
      this.finishNetWeight = finishNetWeight;
      this.finishGrossWeight = finishGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.lossNetWeight = lossNetWeight;
      this.lossGrossWeight = lossGrossWeight;
      this.lossRate = lossRate;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getRawTotalNetWeight() {
      return this.rawTotalNetWeight;
   }

   public BigDecimal getRawTotalGrossWeight() {
      return this.rawTotalGrossWeight;
   }

   public BigDecimal getRawNetWeight() {
      return this.rawNetWeight;
   }

   public BigDecimal getRawGrossWeight() {
      return this.rawGrossWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public List<ProduceStatisticsProcessDTO> getProcessDTOList() {
      return this.processDTOList;
   }

   public BigDecimal getFinishNetWeight() {
      return this.finishNetWeight;
   }

   public BigDecimal getFinishGrossWeight() {
      return this.finishGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getLossNetWeight() {
      return this.lossNetWeight;
   }

   public BigDecimal getLossGrossWeight() {
      return this.lossGrossWeight;
   }

   public BigDecimal getLossRate() {
      return this.lossRate;
   }

   @JsonProperty("project")
   public ProduceStatisticsDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("unit")
   public ProduceStatisticsDTO setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   @JsonProperty("rawTotalNetWeight")
   public ProduceStatisticsDTO setRawTotalNetWeight(final BigDecimal rawTotalNetWeight) {
      this.rawTotalNetWeight = rawTotalNetWeight;
      return this;
   }

   @JsonProperty("rawTotalGrossWeight")
   public ProduceStatisticsDTO setRawTotalGrossWeight(final BigDecimal rawTotalGrossWeight) {
      this.rawTotalGrossWeight = rawTotalGrossWeight;
      return this;
   }

   @JsonProperty("rawNetWeight")
   public ProduceStatisticsDTO setRawNetWeight(final BigDecimal rawNetWeight) {
      this.rawNetWeight = rawNetWeight;
      return this;
   }

   @JsonProperty("rawGrossWeight")
   public ProduceStatisticsDTO setRawGrossWeight(final BigDecimal rawGrossWeight) {
      this.rawGrossWeight = rawGrossWeight;
      return this;
   }

   @JsonProperty("taskQuantity")
   public ProduceStatisticsDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public ProduceStatisticsDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public ProduceStatisticsDTO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("processDTOList")
   public ProduceStatisticsDTO setProcessDTOList(final List<ProduceStatisticsProcessDTO> processDTOList) {
      this.processDTOList = processDTOList;
      return this;
   }

   @JsonProperty("finishNetWeight")
   public ProduceStatisticsDTO setFinishNetWeight(final BigDecimal finishNetWeight) {
      this.finishNetWeight = finishNetWeight;
      return this;
   }

   @JsonProperty("finishGrossWeight")
   public ProduceStatisticsDTO setFinishGrossWeight(final BigDecimal finishGrossWeight) {
      this.finishGrossWeight = finishGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProduceStatisticsDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ProduceStatisticsDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("lossNetWeight")
   public ProduceStatisticsDTO setLossNetWeight(final BigDecimal lossNetWeight) {
      this.lossNetWeight = lossNetWeight;
      return this;
   }

   @JsonProperty("lossGrossWeight")
   public ProduceStatisticsDTO setLossGrossWeight(final BigDecimal lossGrossWeight) {
      this.lossGrossWeight = lossGrossWeight;
      return this;
   }

   @JsonProperty("lossRate")
   public ProduceStatisticsDTO setLossRate(final BigDecimal lossRate) {
      this.lossRate = lossRate;
      return this;
   }

   @Override
   public String toString() {
      return "ProduceStatisticsDTO(project="
         + this.getProject()
         + ", unit="
         + this.getUnit()
         + ", rawTotalNetWeight="
         + this.getRawTotalNetWeight()
         + ", rawTotalGrossWeight="
         + this.getRawTotalGrossWeight()
         + ", rawNetWeight="
         + this.getRawNetWeight()
         + ", rawGrossWeight="
         + this.getRawGrossWeight()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", processDTOList="
         + this.getProcessDTOList()
         + ", finishNetWeight="
         + this.getFinishNetWeight()
         + ", finishGrossWeight="
         + this.getFinishGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", lossNetWeight="
         + this.getLossNetWeight()
         + ", lossGrossWeight="
         + this.getLossGrossWeight()
         + ", lossRate="
         + this.getLossRate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceStatisticsDTO)) {
         return false;
      }

      ProduceStatisticsDTO other = (ProduceStatisticsDTO)o;
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
               Object this$rawTotalNetWeight = this.getRawTotalNetWeight();
               Object other$rawTotalNetWeight = other.getRawTotalNetWeight();
               if (this$rawTotalNetWeight == null ? other$rawTotalNetWeight == null : this$rawTotalNetWeight.equals(other$rawTotalNetWeight)) {
                  Object this$rawTotalGrossWeight = this.getRawTotalGrossWeight();
                  Object other$rawTotalGrossWeight = other.getRawTotalGrossWeight();
                  if (this$rawTotalGrossWeight == null ? other$rawTotalGrossWeight == null : this$rawTotalGrossWeight.equals(other$rawTotalGrossWeight)) {
                     Object this$rawNetWeight = this.getRawNetWeight();
                     Object other$rawNetWeight = other.getRawNetWeight();
                     if (this$rawNetWeight == null ? other$rawNetWeight == null : this$rawNetWeight.equals(other$rawNetWeight)) {
                        Object this$rawGrossWeight = this.getRawGrossWeight();
                        Object other$rawGrossWeight = other.getRawGrossWeight();
                        if (this$rawGrossWeight == null ? other$rawGrossWeight == null : this$rawGrossWeight.equals(other$rawGrossWeight)) {
                           Object this$taskNetWeight = this.getTaskNetWeight();
                           Object other$taskNetWeight = other.getTaskNetWeight();
                           if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                              Object this$taskGrossWeight = this.getTaskGrossWeight();
                              Object other$taskGrossWeight = other.getTaskGrossWeight();
                              if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                 Object this$processDTOList = this.getProcessDTOList();
                                 Object other$processDTOList = other.getProcessDTOList();
                                 if (this$processDTOList == null ? other$processDTOList == null : this$processDTOList.equals(other$processDTOList)) {
                                    Object this$finishNetWeight = this.getFinishNetWeight();
                                    Object other$finishNetWeight = other.getFinishNetWeight();
                                    if (this$finishNetWeight == null ? other$finishNetWeight == null : this$finishNetWeight.equals(other$finishNetWeight)) {
                                       Object this$finishGrossWeight = this.getFinishGrossWeight();
                                       Object other$finishGrossWeight = other.getFinishGrossWeight();
                                       if (this$finishGrossWeight == null
                                          ? other$finishGrossWeight == null
                                          : this$finishGrossWeight.equals(other$finishGrossWeight)) {
                                          Object this$totalNetWeight = this.getTotalNetWeight();
                                          Object other$totalNetWeight = other.getTotalNetWeight();
                                          if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                             Object this$totalGrossWeight = this.getTotalGrossWeight();
                                             Object other$totalGrossWeight = other.getTotalGrossWeight();
                                             if (this$totalGrossWeight == null
                                                ? other$totalGrossWeight == null
                                                : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                Object this$lossNetWeight = this.getLossNetWeight();
                                                Object other$lossNetWeight = other.getLossNetWeight();
                                                if (this$lossNetWeight == null ? other$lossNetWeight == null : this$lossNetWeight.equals(other$lossNetWeight)) {
                                                   Object this$lossGrossWeight = this.getLossGrossWeight();
                                                   Object other$lossGrossWeight = other.getLossGrossWeight();
                                                   if (this$lossGrossWeight == null
                                                      ? other$lossGrossWeight == null
                                                      : this$lossGrossWeight.equals(other$lossGrossWeight)) {
                                                      Object this$lossRate = this.getLossRate();
                                                      Object other$lossRate = other.getLossRate();
                                                      return this$lossRate == null ? other$lossRate == null : this$lossRate.equals(other$lossRate);
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
      return other instanceof ProduceStatisticsDTO;
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
      Object $rawTotalNetWeight = this.getRawTotalNetWeight();
      result = result * 59 + ($rawTotalNetWeight == null ? 43 : $rawTotalNetWeight.hashCode());
      Object $rawTotalGrossWeight = this.getRawTotalGrossWeight();
      result = result * 59 + ($rawTotalGrossWeight == null ? 43 : $rawTotalGrossWeight.hashCode());
      Object $rawNetWeight = this.getRawNetWeight();
      result = result * 59 + ($rawNetWeight == null ? 43 : $rawNetWeight.hashCode());
      Object $rawGrossWeight = this.getRawGrossWeight();
      result = result * 59 + ($rawGrossWeight == null ? 43 : $rawGrossWeight.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $processDTOList = this.getProcessDTOList();
      result = result * 59 + ($processDTOList == null ? 43 : $processDTOList.hashCode());
      Object $finishNetWeight = this.getFinishNetWeight();
      result = result * 59 + ($finishNetWeight == null ? 43 : $finishNetWeight.hashCode());
      Object $finishGrossWeight = this.getFinishGrossWeight();
      result = result * 59 + ($finishGrossWeight == null ? 43 : $finishGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $lossNetWeight = this.getLossNetWeight();
      result = result * 59 + ($lossNetWeight == null ? 43 : $lossNetWeight.hashCode());
      Object $lossGrossWeight = this.getLossGrossWeight();
      result = result * 59 + ($lossGrossWeight == null ? 43 : $lossGrossWeight.hashCode());
      Object $lossRate = this.getLossRate();
      return result * 59 + ($lossRate == null ? 43 : $lossRate.hashCode());
   }

   public static class ProduceStatisticsDTOBuilder {
      private ProjectDetailDO project;
      private String unit;
      private BigDecimal rawTotalNetWeight;
      private BigDecimal rawTotalGrossWeight;
      private BigDecimal rawNetWeight;
      private BigDecimal rawGrossWeight;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private List<ProduceStatisticsProcessDTO> processDTOList;
      private BigDecimal finishNetWeight;
      private BigDecimal finishGrossWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal lossNetWeight;
      private BigDecimal lossGrossWeight;
      private BigDecimal lossRate;

      ProduceStatisticsDTOBuilder() {
      }

      @JsonProperty("project")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("unit")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      @JsonProperty("rawTotalNetWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder rawTotalNetWeight(final BigDecimal rawTotalNetWeight) {
         this.rawTotalNetWeight = rawTotalNetWeight;
         return this;
      }

      @JsonProperty("rawTotalGrossWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder rawTotalGrossWeight(final BigDecimal rawTotalGrossWeight) {
         this.rawTotalGrossWeight = rawTotalGrossWeight;
         return this;
      }

      @JsonProperty("rawNetWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder rawNetWeight(final BigDecimal rawNetWeight) {
         this.rawNetWeight = rawNetWeight;
         return this;
      }

      @JsonProperty("rawGrossWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder rawGrossWeight(final BigDecimal rawGrossWeight) {
         this.rawGrossWeight = rawGrossWeight;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("processDTOList")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder processDTOList(final List<ProduceStatisticsProcessDTO> processDTOList) {
         this.processDTOList = processDTOList;
         return this;
      }

      @JsonProperty("finishNetWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder finishNetWeight(final BigDecimal finishNetWeight) {
         this.finishNetWeight = finishNetWeight;
         return this;
      }

      @JsonProperty("finishGrossWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder finishGrossWeight(final BigDecimal finishGrossWeight) {
         this.finishGrossWeight = finishGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("lossNetWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder lossNetWeight(final BigDecimal lossNetWeight) {
         this.lossNetWeight = lossNetWeight;
         return this;
      }

      @JsonProperty("lossGrossWeight")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder lossGrossWeight(final BigDecimal lossGrossWeight) {
         this.lossGrossWeight = lossGrossWeight;
         return this;
      }

      @JsonProperty("lossRate")
      public ProduceStatisticsDTO.ProduceStatisticsDTOBuilder lossRate(final BigDecimal lossRate) {
         this.lossRate = lossRate;
         return this;
      }

      public ProduceStatisticsDTO build() {
         return new ProduceStatisticsDTO(
            this.project,
            this.unit,
            this.rawTotalNetWeight,
            this.rawTotalGrossWeight,
            this.rawNetWeight,
            this.rawGrossWeight,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.processDTOList,
            this.finishNetWeight,
            this.finishGrossWeight,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.lossNetWeight,
            this.lossGrossWeight,
            this.lossRate
         );
      }

      @Override
      public String toString() {
         return "ProduceStatisticsDTO.ProduceStatisticsDTOBuilder(project="
            + this.project
            + ", unit="
            + this.unit
            + ", rawTotalNetWeight="
            + this.rawTotalNetWeight
            + ", rawTotalGrossWeight="
            + this.rawTotalGrossWeight
            + ", rawNetWeight="
            + this.rawNetWeight
            + ", rawGrossWeight="
            + this.rawGrossWeight
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", processDTOList="
            + this.processDTOList
            + ", finishNetWeight="
            + this.finishNetWeight
            + ", finishGrossWeight="
            + this.finishGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", lossNetWeight="
            + this.lossNetWeight
            + ", lossGrossWeight="
            + this.lossGrossWeight
            + ", lossRate="
            + this.lossRate
            + ")";
      }
   }
}
