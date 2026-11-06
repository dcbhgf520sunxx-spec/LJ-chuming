package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessSummaryDeatil", description = "工序详情")
public class ProcessSummaryDetailsDTO {
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;

   public static ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder builder() {
      return new ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder();
   }

   public ProcessSummaryDetailsDTO() {
   }

   public ProcessSummaryDetailsDTO(final String name, final Integer completeQuantity, final Integer inspectionQuantity) {
      this.name = name;
      this.completeQuantity = completeQuantity;
      this.inspectionQuantity = inspectionQuantity;
   }

   public String getName() {
      return this.name;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   @JsonProperty("name")
   public ProcessSummaryDetailsDTO setName(final String name) {
      this.name = name;
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

   @Override
   public String toString() {
      return "ProcessSummaryDetailsDTO(name="
         + this.getName()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
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

      Object this$completeQuantity = this.getCompleteQuantity();
      Object other$completeQuantity = other.getCompleteQuantity();
      if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessSummaryDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProcessSummaryDetailsDTOBuilder {
      private String name;
      private Integer completeQuantity;
      private Integer inspectionQuantity;

      ProcessSummaryDetailsDTOBuilder() {
      }

      @JsonProperty("name")
      public ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder name(final String name) {
         this.name = name;
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

      public ProcessSummaryDetailsDTO build() {
         return new ProcessSummaryDetailsDTO(this.name, this.completeQuantity, this.inspectionQuantity);
      }

      @Override
      public String toString() {
         return "ProcessSummaryDetailsDTO.ProcessSummaryDetailsDTOBuilder(name="
            + this.name
            + ", completeQuantity="
            + this.completeQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ")";
      }
   }
}
