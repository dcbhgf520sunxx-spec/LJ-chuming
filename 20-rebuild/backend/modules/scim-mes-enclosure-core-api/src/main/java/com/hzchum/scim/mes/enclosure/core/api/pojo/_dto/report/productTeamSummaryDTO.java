package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
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
   @ApiModelProperty(name = "team", notes = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDO team;
   @ApiModelProperty(name = "inspectionQuantity", notes = "数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "netWeight", notes = "产量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
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
      final IdAndNameDO team,
      final Integer inspectionQuantity,
      final BigDecimal netWeight,
      final Integer taskTypeEnum
   ) {
      this.workshop = workshop;
      this.process = process;
      this.groups = groups;
      this.team = team;
      this.inspectionQuantity = inspectionQuantity;
      this.netWeight = netWeight;
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

   public IdAndNameDO getTeam() {
      return this.team;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
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

   @JsonProperty("team")
   public productTeamSummaryDTO setTeam(final IdAndNameDO team) {
      this.team = team;
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
         + ", team="
         + this.getTeam()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", netWeight="
         + this.getNetWeight()
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
                     Object this$team = this.getTeam();
                     Object other$team = other.getTeam();
                     if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                        Object this$netWeight = this.getNetWeight();
                        Object other$netWeight = other.getNetWeight();
                        return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class productTeamSummaryDTOBuilder {
      private WorkshopDetailDO workshop;
      private NameInfo process;
      private NameInfo groups;
      private IdAndNameDO team;
      private Integer inspectionQuantity;
      private BigDecimal netWeight;
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

      @JsonProperty("team")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder team(final IdAndNameDO team) {
         this.team = team;
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

      @JsonProperty("taskTypeEnum")
      public productTeamSummaryDTO.productTeamSummaryDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public productTeamSummaryDTO build() {
         return new productTeamSummaryDTO(this.workshop, this.process, this.groups, this.team, this.inspectionQuantity, this.netWeight, this.taskTypeEnum);
      }

      @Override
      public String toString() {
         return "productTeamSummaryDTO.productTeamSummaryDTOBuilder(workshop="
            + this.workshop
            + ", process="
            + this.process
            + ", groups="
            + this.groups
            + ", team="
            + this.team
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", netWeight="
            + this.netWeight
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
