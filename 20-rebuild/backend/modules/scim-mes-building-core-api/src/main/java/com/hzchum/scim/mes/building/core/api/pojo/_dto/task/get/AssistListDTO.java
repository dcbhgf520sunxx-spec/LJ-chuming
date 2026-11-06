package com.hzchum.scim.mes.building.core.api.pojo._dto.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssistListDTO", description = "班组协同列表")
public class AssistListDTO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "leaderName", notes = "班组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;

   public static AssistListDTO.AssistListDTOBuilder builder() {
      return new AssistListDTO.AssistListDTOBuilder();
   }

   public AssistListDTO() {
   }

   public AssistListDTO(
      final Long id, final Long teamId, final String leaderName, final Long processId, final String processName, final String productionLineName
   ) {
      this.id = id;
      this.teamId = teamId;
      this.leaderName = leaderName;
      this.processId = processId;
      this.processName = processName;
      this.productionLineName = productionLineName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   @JsonProperty("id")
   public AssistListDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamId")
   public AssistListDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("leaderName")
   public AssistListDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("processId")
   public AssistListDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public AssistListDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productionLineName")
   public AssistListDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @Override
   public String toString() {
      return "AssistListDTO(id="
         + this.getId()
         + ", teamId="
         + this.getTeamId()
         + ", leaderName="
         + this.getLeaderName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssistListDTO)) {
         return false;
      }

      AssistListDTO other = (AssistListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$leaderName = this.getLeaderName();
               Object other$leaderName = other.getLeaderName();
               if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$productionLineName = this.getProductionLineName();
                     Object other$productionLineName = other.getProductionLineName();
                     return this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName);
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
      return other instanceof AssistListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      return result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
   }

   public static class AssistListDTOBuilder {
      private Long id;
      private Long teamId;
      private String leaderName;
      private Long processId;
      private String processName;
      private String productionLineName;

      AssistListDTOBuilder() {
      }

      @JsonProperty("id")
      public AssistListDTO.AssistListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamId")
      public AssistListDTO.AssistListDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("leaderName")
      public AssistListDTO.AssistListDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("processId")
      public AssistListDTO.AssistListDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public AssistListDTO.AssistListDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productionLineName")
      public AssistListDTO.AssistListDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      public AssistListDTO build() {
         return new AssistListDTO(this.id, this.teamId, this.leaderName, this.processId, this.processName, this.productionLineName);
      }

      @Override
      public String toString() {
         return "AssistListDTO.AssistListDTOBuilder(id="
            + this.id
            + ", teamId="
            + this.teamId
            + ", leaderName="
            + this.leaderName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", productionLineName="
            + this.productionLineName
            + ")";
      }
   }
}
