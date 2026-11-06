package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "批量上报DTO", description = "")
public class BatchReportDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "boolAssist", value = "是否协同", notes = "是否协同")
   @JsonProperty("boolAssist")
   @JSONField(name = "boolAssist")
   private Boolean boolAssist;
   @ApiModelProperty(name = "assistLineId", value = "协同产线id", notes = "协同产线id")
   @JsonProperty("assistLineId")
   @JSONField(name = "assistLineId")
   private Long assistLineId;

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public Long getAssistLineId() {
      return this.assistLineId;
   }

   @JsonProperty("id")
   public BatchReportDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boolAssist")
   public BatchReportDTO setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
      return this;
   }

   @JsonProperty("assistLineId")
   public BatchReportDTO setAssistLineId(final Long assistLineId) {
      this.assistLineId = assistLineId;
      return this;
   }

   @Override
   public String toString() {
      return "BatchReportDTO(id=" + this.getId() + ", boolAssist=" + this.getBoolAssist() + ", assistLineId=" + this.getAssistLineId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchReportDTO)) {
         return false;
      }

      BatchReportDTO other = (BatchReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolAssist = this.getBoolAssist();
         Object other$boolAssist = other.getBoolAssist();
         if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
            Object this$assistLineId = this.getAssistLineId();
            Object other$assistLineId = other.getAssistLineId();
            return this$assistLineId == null ? other$assistLineId == null : this$assistLineId.equals(other$assistLineId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BatchReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
      Object $assistLineId = this.getAssistLineId();
      return result * 59 + ($assistLineId == null ? 43 : $assistLineId.hashCode());
   }
}
