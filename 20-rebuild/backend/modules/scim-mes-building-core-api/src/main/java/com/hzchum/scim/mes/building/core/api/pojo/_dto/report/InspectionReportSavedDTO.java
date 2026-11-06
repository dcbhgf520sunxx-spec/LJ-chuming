package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "InspectionReportSavedDTO", description = "")
public class InspectionReportSavedDTO {
   @ApiModelProperty(name = "reportNumberId", notes = "reportNumberId")
   @JsonProperty("reportNumberId")
   @JSONField(name = "reportNumberId")
   @NotNull(message = "id不能为空")
   private Long reportNumberId;
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   @NotNull(message = "上报数量不能为空")
   private Integer reportQuantity;
   @ApiModelProperty(name = "taskProcessId", value = "工序详情表id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "paintThicknessList", value = "漆膜检测记录")
   @JsonProperty("paintThicknessList")
   @JSONField(name = "paintThicknessList")
   private List<PaintThicknessSaveDTO> paintThicknessList;

   public InspectionReportSavedDTO(
      final Long reportNumberId, final Integer reportQuantity, final Long taskProcessId, final List<PaintThicknessSaveDTO> paintThicknessList
   ) {
      this.reportNumberId = reportNumberId;
      this.reportQuantity = reportQuantity;
      this.taskProcessId = taskProcessId;
      this.paintThicknessList = paintThicknessList;
   }

   public InspectionReportSavedDTO() {
   }

   public Long getReportNumberId() {
      return this.reportNumberId;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public List<PaintThicknessSaveDTO> getPaintThicknessList() {
      return this.paintThicknessList;
   }

   @JsonProperty("reportNumberId")
   public InspectionReportSavedDTO setReportNumberId(final Long reportNumberId) {
      this.reportNumberId = reportNumberId;
      return this;
   }

   @JsonProperty("reportQuantity")
   public InspectionReportSavedDTO setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("taskProcessId")
   public InspectionReportSavedDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("paintThicknessList")
   public InspectionReportSavedDTO setPaintThicknessList(final List<PaintThicknessSaveDTO> paintThicknessList) {
      this.paintThicknessList = paintThicknessList;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionReportSavedDTO(reportNumberId="
         + this.getReportNumberId()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", paintThicknessList="
         + this.getPaintThicknessList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionReportSavedDTO)) {
         return false;
      }

      InspectionReportSavedDTO other = (InspectionReportSavedDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reportNumberId = this.getReportNumberId();
      Object other$reportNumberId = other.getReportNumberId();
      if (this$reportNumberId == null ? other$reportNumberId == null : this$reportNumberId.equals(other$reportNumberId)) {
         Object this$reportQuantity = this.getReportQuantity();
         Object other$reportQuantity = other.getReportQuantity();
         if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$paintThicknessList = this.getPaintThicknessList();
               Object other$paintThicknessList = other.getPaintThicknessList();
               return this$paintThicknessList == null ? other$paintThicknessList == null : this$paintThicknessList.equals(other$paintThicknessList);
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
      return other instanceof InspectionReportSavedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportNumberId = this.getReportNumberId();
      result = result * 59 + ($reportNumberId == null ? 43 : $reportNumberId.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $paintThicknessList = this.getPaintThicknessList();
      return result * 59 + ($paintThicknessList == null ? 43 : $paintThicknessList.hashCode());
   }
}
