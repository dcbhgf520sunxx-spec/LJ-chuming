package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesWipStatisticsDTO", description = "在制品统计")
public class MesWipStatisticsDTO {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "weight", notes = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;

   public static MesWipStatisticsDTO.MesWipStatisticsDTOBuilder builder() {
      return new MesWipStatisticsDTO.MesWipStatisticsDTOBuilder();
   }

   public MesWipStatisticsDTO() {
   }

   public MesWipStatisticsDTO(
      final Long projectId, final String projectName, final Long processId, final String processName, final Integer quantity, final BigDecimal weight
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.processId = processId;
      this.processName = processName;
      this.quantity = quantity;
      this.weight = weight;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   @JsonProperty("projectId")
   public MesWipStatisticsDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectName")
   public MesWipStatisticsDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("processId")
   public MesWipStatisticsDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesWipStatisticsDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("quantity")
   public MesWipStatisticsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("weight")
   public MesWipStatisticsDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @Override
   public String toString() {
      return "MesWipStatisticsDTO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", quantity="
         + this.getQuantity()
         + ", weight="
         + this.getWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWipStatisticsDTO)) {
         return false;
      }

      MesWipStatisticsDTO other = (MesWipStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$weight = this.getWeight();
                     Object other$weight = other.getWeight();
                     return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
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
      return other instanceof MesWipStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   public static class MesWipStatisticsDTOBuilder {
      private Long projectId;
      private String projectName;
      private Long processId;
      private String processName;
      private Integer quantity;
      private BigDecimal weight;

      MesWipStatisticsDTOBuilder() {
      }

      @JsonProperty("projectId")
      public MesWipStatisticsDTO.MesWipStatisticsDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectName")
      public MesWipStatisticsDTO.MesWipStatisticsDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("processId")
      public MesWipStatisticsDTO.MesWipStatisticsDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesWipStatisticsDTO.MesWipStatisticsDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("quantity")
      public MesWipStatisticsDTO.MesWipStatisticsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("weight")
      public MesWipStatisticsDTO.MesWipStatisticsDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public MesWipStatisticsDTO build() {
         return new MesWipStatisticsDTO(this.projectId, this.projectName, this.processId, this.processName, this.quantity, this.weight);
      }

      @Override
      public String toString() {
         return "MesWipStatisticsDTO.MesWipStatisticsDTOBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", quantity="
            + this.quantity
            + ", weight="
            + this.weight
            + ")";
      }
   }
}
