package com.hzchum.scim.mes.enclosure.core.api.pojo._do.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessSummaryDeatil", description = "工序详情")
public class ProcessSummaryDetailsDO {
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "sequence", notes = "顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;

   public static ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder builder() {
      return new ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder();
   }

   public ProcessSummaryDetailsDO() {
   }

   public ProcessSummaryDetailsDO(
      final String name, final Long processId, final Integer completeQuantity, final Integer sequence, final Integer inspectionQuantity
   ) {
      this.name = name;
      this.processId = processId;
      this.completeQuantity = completeQuantity;
      this.sequence = sequence;
      this.inspectionQuantity = inspectionQuantity;
   }

   public String getName() {
      return this.name;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   @JsonProperty("name")
   public ProcessSummaryDetailsDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("processId")
   public ProcessSummaryDetailsDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ProcessSummaryDetailsDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("sequence")
   public ProcessSummaryDetailsDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public ProcessSummaryDetailsDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessSummaryDetailsDO(name="
         + this.getName()
         + ", processId="
         + this.getProcessId()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", sequence="
         + this.getSequence()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessSummaryDetailsDO)) {
         return false;
      }

      ProcessSummaryDetailsDO other = (ProcessSummaryDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$sequence = this.getSequence();
            Object other$sequence = other.getSequence();
            if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
               Object this$inspectionQuantity = this.getInspectionQuantity();
               Object other$inspectionQuantity = other.getInspectionQuantity();
               if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof ProcessSummaryDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProcessSummaryDetailsDOBuilder {
      private String name;
      private Long processId;
      private Integer completeQuantity;
      private Integer sequence;
      private Integer inspectionQuantity;

      ProcessSummaryDetailsDOBuilder() {
      }

      @JsonProperty("name")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("processId")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("sequence")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public ProcessSummaryDetailsDO build() {
         return new ProcessSummaryDetailsDO(this.name, this.processId, this.completeQuantity, this.sequence, this.inspectionQuantity);
      }

      @Override
      public String toString() {
         return "ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder(name="
            + this.name
            + ", processId="
            + this.processId
            + ", completeQuantity="
            + this.completeQuantity
            + ", sequence="
            + this.sequence
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ")";
      }
   }
}
