package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProcessSummaryDeatil", description = "工序详情")
public class ProcessSummaryDetailsDTO {
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "userNames", notes = "上报人")
   @JsonProperty("userNames")
   @JSONField(name = "userNames")
   private String userNames;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "teamTraceList", notes = "生产对应的班组汇总信息")
   @JsonProperty("teamTraceList")
   @JSONField(name = "teamTraceList")
   private List<TeamTraceDTO> teamTraceList;

   public static ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder builder() {
      return new ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder();
   }

   public ProcessSummaryDetailsDTO() {
   }

   public ProcessSummaryDetailsDTO(
      final Long processId,
      final String name,
      final String userNames,
      final Integer completeQuantity,
      final Integer inspectionQuantity,
      final List<TeamTraceDTO> teamTraceList
   ) {
      this.processId = processId;
      this.name = name;
      this.userNames = userNames;
      this.completeQuantity = completeQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.teamTraceList = teamTraceList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getName() {
      return this.name;
   }

   public String getUserNames() {
      return this.userNames;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public List<TeamTraceDTO> getTeamTraceList() {
      return this.teamTraceList;
   }

   @JsonProperty("processId")
   public ProcessSummaryDetailsDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("name")
   public ProcessSummaryDetailsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("userNames")
   public ProcessSummaryDetailsDTO setUserNames(final String userNames) {
      this.userNames = userNames;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ProcessSummaryDetailsDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public ProcessSummaryDetailsDTO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("teamTraceList")
   public ProcessSummaryDetailsDTO setTeamTraceList(final List<TeamTraceDTO> teamTraceList) {
      this.teamTraceList = teamTraceList;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessSummaryDetailsDTO(processId="
         + this.getProcessId()
         + ", name="
         + this.getName()
         + ", userNames="
         + this.getUserNames()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", teamTraceList="
         + this.getTeamTraceList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessSummaryDetailsDTO)) {
         return false;
      }

      ProcessSummaryDetailsDTO other = (ProcessSummaryDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$inspectionQuantity = this.getInspectionQuantity();
            Object other$inspectionQuantity = other.getInspectionQuantity();
            if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$userNames = this.getUserNames();
                  Object other$userNames = other.getUserNames();
                  if (this$userNames == null ? other$userNames == null : this$userNames.equals(other$userNames)) {
                     Object this$teamTraceList = this.getTeamTraceList();
                     Object other$teamTraceList = other.getTeamTraceList();
                     return this$teamTraceList == null ? other$teamTraceList == null : this$teamTraceList.equals(other$teamTraceList);
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
      return other instanceof ProcessSummaryDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $userNames = this.getUserNames();
      result = result * 59 + ($userNames == null ? 43 : $userNames.hashCode());
      Object $teamTraceList = this.getTeamTraceList();
      return result * 59 + ($teamTraceList == null ? 43 : $teamTraceList.hashCode());
   }

   public static class ProcessSummaryDetailsDTOBuilder {
      private Long processId;
      private String name;
      private String userNames;
      private Integer completeQuantity;
      private Integer inspectionQuantity;
      private List<TeamTraceDTO> teamTraceList;

      ProcessSummaryDetailsDTOBuilder() {
      }

      @JsonProperty("processId")
      public ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("name")
      public ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("userNames")
      public ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder userNames(final String userNames) {
         this.userNames = userNames;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("teamTraceList")
      public ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder teamTraceList(final List<TeamTraceDTO> teamTraceList) {
         this.teamTraceList = teamTraceList;
         return this;
      }

      public ProcessSummaryDetailsDTO build() {
         return new ProcessSummaryDetailsDTO(this.processId, this.name, this.userNames, this.completeQuantity, this.inspectionQuantity, this.teamTraceList);
      }

      @Override
      public String toString() {
         return "ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder(processId="
            + this.processId
            + ", name="
            + this.name
            + ", userNames="
            + this.userNames
            + ", completeQuantity="
            + this.completeQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", teamTraceList="
            + this.teamTraceList
            + ")";
      }
   }
}
