package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "productTeamSummaryDTO", description = " ")
public class productTeamSummaryDTO {
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private NameInfo process;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private NameInfo groups;
   @ApiModelProperty(name = "prodLine", notes = "生产线")
   @JsonProperty("prodLine")
   @JSONField(name = "prodLine")
   private NameInfo prodLine;
   @ApiModelProperty(name = "team", notes = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDO team;
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "reportNetWeight", notes = "上报产量(净重)")
   @JsonProperty("reportNetWeight")
   @JSONField(name = "reportNetWeight")
   private BigDecimal reportNetWeight;
   @ApiModelProperty(name = "reportGrossWeight", notes = "上报产量(毛重)")
   @JsonProperty("reportGrossWeight")
   @JSONField(name = "reportGrossWeight")
   private BigDecimal reportGrossWeight;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "netWeight", notes = "产量(净重)")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "产量(毛重)")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "taskTypeEnum", notes = "产品类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;

   public static productTeamSummaryDTO.productTeamSummaryDTOBuilder builder() {
      return new productTeamSummaryDTO.productTeamSummaryDTOBuilder();
   }

   public productTeamSummaryDTO() {
   }

   public productTeamSummaryDTO(
      final WorkshopDetailDO workshop,
      final NameInfo process,
      final NameInfo groups,
      final NameInfo prodLine,
      final IdAndNameDO team,
      final Integer reportQuantity,
      final BigDecimal reportNetWeight,
      final BigDecimal reportGrossWeight,
      final Integer inspectionQuantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer taskTypeEnum
   ) {
      this.workshop = workshop;
      this.process = process;
      this.groups = groups;
      this.prodLine = prodLine;
      this.team = team;
      this.reportQuantity = reportQuantity;
      this.reportNetWeight = reportNetWeight;
      this.reportGrossWeight = reportGrossWeight;
      this.inspectionQuantity = inspectionQuantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.taskTypeEnum = taskTypeEnum;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public NameInfo getGroups() {
      return this.groups;
   }

   public NameInfo getProdLine() {
      return this.prodLine;
   }

   public IdAndNameDO getTeam() {
      return this.team;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportNetWeight() {
      return this.reportNetWeight;
   }

   public BigDecimal getReportGrossWeight() {
      return this.reportGrossWeight;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   @JsonProperty("workshop")
   public productTeamSummaryDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("process")
   public productTeamSummaryDTO setProcess(final NameInfo process) {
      this.process = process;
      return this;
   }

   @JsonProperty("groups")
   public productTeamSummaryDTO setGroups(final NameInfo groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("prodLine")
   public productTeamSummaryDTO setProdLine(final NameInfo prodLine) {
      this.prodLine = prodLine;
      return this;
   }

   @JsonProperty("team")
   public productTeamSummaryDTO setTeam(final IdAndNameDO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("reportQuantity")
   public productTeamSummaryDTO setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("reportNetWeight")
   public productTeamSummaryDTO setReportNetWeight(final BigDecimal reportNetWeight) {
      this.reportNetWeight = reportNetWeight;
      return this;
   }

   @JsonProperty("reportGrossWeight")
   public productTeamSummaryDTO setReportGrossWeight(final BigDecimal reportGrossWeight) {
      this.reportGrossWeight = reportGrossWeight;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public productTeamSummaryDTO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("netWeight")
   public productTeamSummaryDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public productTeamSummaryDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public productTeamSummaryDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "productTeamSummaryDTO(workshop="
         + this.getWorkshop()
         + ", process="
         + this.getProcess()
         + ", groups="
         + this.getGroups()
         + ", prodLine="
         + this.getProdLine()
         + ", team="
         + this.getTeam()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportNetWeight="
         + this.getReportNetWeight()
         + ", reportGrossWeight="
         + this.getReportGrossWeight()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof productTeamSummaryDTO)) {
         return false;
      }

      productTeamSummaryDTO other = (productTeamSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reportQuantity = this.getReportQuantity();
      Object other$reportQuantity = other.getReportQuantity();
      if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
         Object this$inspectionQuantity = this.getInspectionQuantity();
         Object other$inspectionQuantity = other.getInspectionQuantity();
         if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$workshop = this.getWorkshop();
               Object other$workshop = other.getWorkshop();
               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                  Object this$process = this.getProcess();
                  Object other$process = other.getProcess();
                  if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                     Object this$groups = this.getGroups();
                     Object other$groups = other.getGroups();
                     if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                        Object this$prodLine = this.getProdLine();
                        Object other$prodLine = other.getProdLine();
                        if (this$prodLine == null ? other$prodLine == null : this$prodLine.equals(other$prodLine)) {
                           Object this$team = this.getTeam();
                           Object other$team = other.getTeam();
                           if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                              Object this$reportNetWeight = this.getReportNetWeight();
                              Object other$reportNetWeight = other.getReportNetWeight();
                              if (this$reportNetWeight == null ? other$reportNetWeight == null : this$reportNetWeight.equals(other$reportNetWeight)) {
                                 Object this$reportGrossWeight = this.getReportGrossWeight();
                                 Object other$reportGrossWeight = other.getReportGrossWeight();
                                 if (this$reportGrossWeight == null ? other$reportGrossWeight == null : this$reportGrossWeight.equals(other$reportGrossWeight)) {
                                    Object this$netWeight = this.getNetWeight();
                                    Object other$netWeight = other.getNetWeight();
                                    if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                       Object this$grossWeight = this.getGrossWeight();
                                       Object other$grossWeight = other.getGrossWeight();
                                       return this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight);
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
      return other instanceof productTeamSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $prodLine = this.getProdLine();
      result = result * 59 + ($prodLine == null ? 43 : $prodLine.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $reportNetWeight = this.getReportNetWeight();
      result = result * 59 + ($reportNetWeight == null ? 43 : $reportNetWeight.hashCode());
      Object $reportGrossWeight = this.getReportGrossWeight();
      result = result * 59 + ($reportGrossWeight == null ? 43 : $reportGrossWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      return result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
   }

   public static class productTeamSummaryDTOBuilder {
      private WorkshopDetailDO workshop;
      private NameInfo process;
      private NameInfo groups;
      private NameInfo prodLine;
      private IdAndNameDO team;
      private Integer reportQuantity;
      private BigDecimal reportNetWeight;
      private BigDecimal reportGrossWeight;
      private Integer inspectionQuantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer taskTypeEnum;

      productTeamSummaryDTOBuilder() {
      }

      @JsonProperty("workshop")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("process")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder process(final NameInfo process) {
         this.process = process;
         return this;
      }

      @JsonProperty("groups")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder groups(final NameInfo groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("prodLine")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder prodLine(final NameInfo prodLine) {
         this.prodLine = prodLine;
         return this;
      }

      @JsonProperty("team")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder team(final IdAndNameDO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("reportQuantity")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("reportNetWeight")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder reportNetWeight(final BigDecimal reportNetWeight) {
         this.reportNetWeight = reportNetWeight;
         return this;
      }

      @JsonProperty("reportGrossWeight")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder reportGrossWeight(final BigDecimal reportGrossWeight) {
         this.reportGrossWeight = reportGrossWeight;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("netWeight")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public productTeamSummaryDTO build() {
         return new productTeamSummaryDTO(
            this.workshop,
            this.process,
            this.groups,
            this.prodLine,
            this.team,
            this.reportQuantity,
            this.reportNetWeight,
            this.reportGrossWeight,
            this.inspectionQuantity,
            this.netWeight,
            this.grossWeight,
            this.taskTypeEnum
         );
      }

      @Override
      public String toString() {
         return "productTeamSummaryDTO.productTeamSummaryDTOBuilder(workshop="
            + this.workshop
            + ", process="
            + this.process
            + ", groups="
            + this.groups
            + ", prodLine="
            + this.prodLine
            + ", team="
            + this.team
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportNetWeight="
            + this.reportNetWeight
            + ", reportGrossWeight="
            + this.reportGrossWeight
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
