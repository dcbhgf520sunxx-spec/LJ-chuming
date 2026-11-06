package com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ReportSaveVORequest", description = "")
public class ReportSaveVORequest {
   @ApiModelProperty(name = "boolAssistEnum", notes = "是否是协同")
   @JsonProperty("boolAssistEnum")
   @JSONField(name = "boolAssistEnum")
   private Boolean boolAssistEnum;
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "nextProcessId", notes = "下一道工序id[零件专用]")
   @JsonProperty("nextProcessId")
   @JSONField(name = "nextProcessId")
   private Long nextProcessId;
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "reportType", notes = "上报类型 0正常上报 1异常上报", value = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Boolean reportType;
   @ApiModelProperty(name = "numberList", notes = "上报编号列表", value = "上报编号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;
   @ApiModelProperty(name = "assistGroupId", notes = "协同任务任务上报生产组id", value = "协同任务任务上报生产组id")
   @JsonProperty("assistGroupId")
   @JSONField(name = "assistGroupId")
   private Long assistGroupId;
   @ApiModelProperty(name = "assistLineId", notes = "协同任务任务上报生产线id", value = "协同任务任务上报生产线id")
   @JsonProperty("assistLineId")
   @JSONField(name = "assistLineId")
   private Long assistLineId;

   public ReportSaveVORequest(
      final Boolean boolAssistEnum,
      final Integer reportQuantity,
      final Long nextProcessId,
      final Long id,
      final Boolean reportType,
      final List<Integer> numberList,
      final Long assistGroupId,
      final Long assistLineId
   ) {
      this.boolAssistEnum = boolAssistEnum;
      this.reportQuantity = reportQuantity;
      this.nextProcessId = nextProcessId;
      this.id = id;
      this.reportType = reportType;
      this.numberList = numberList;
      this.assistGroupId = assistGroupId;
      this.assistLineId = assistLineId;
   }

   public ReportSaveVORequest() {
   }

   public Boolean getBoolAssistEnum() {
      return this.boolAssistEnum;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Long getNextProcessId() {
      return this.nextProcessId;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getReportType() {
      return this.reportType;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Long getAssistGroupId() {
      return this.assistGroupId;
   }

   public Long getAssistLineId() {
      return this.assistLineId;
   }

   @JsonProperty("boolAssistEnum")
   public ReportSaveVORequest setBoolAssistEnum(final Boolean boolAssistEnum) {
      this.boolAssistEnum = boolAssistEnum;
      return this;
   }

   @JsonProperty("reportQuantity")
   public ReportSaveVORequest setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("nextProcessId")
   public ReportSaveVORequest setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   @JsonProperty("id")
   public ReportSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("reportType")
   public ReportSaveVORequest setReportType(final Boolean reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("numberList")
   public ReportSaveVORequest setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @JsonProperty("assistGroupId")
   public ReportSaveVORequest setAssistGroupId(final Long assistGroupId) {
      this.assistGroupId = assistGroupId;
      return this;
   }

   @JsonProperty("assistLineId")
   public ReportSaveVORequest setAssistLineId(final Long assistLineId) {
      this.assistLineId = assistLineId;
      return this;
   }

   @Override
   public String toString() {
      return "ReportSaveVORequest(boolAssistEnum="
         + this.getBoolAssistEnum()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", nextProcessId="
         + this.getNextProcessId()
         + ", id="
         + this.getId()
         + ", reportType="
         + this.getReportType()
         + ", numberList="
         + this.getNumberList()
         + ", assistGroupId="
         + this.getAssistGroupId()
         + ", assistLineId="
         + this.getAssistLineId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReportSaveVORequest)) {
         return false;
      }

      ReportSaveVORequest other = (ReportSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolAssistEnum = this.getBoolAssistEnum();
      Object other$boolAssistEnum = other.getBoolAssistEnum();
      if (this$boolAssistEnum == null ? other$boolAssistEnum == null : this$boolAssistEnum.equals(other$boolAssistEnum)) {
         Object this$reportQuantity = this.getReportQuantity();
         Object other$reportQuantity = other.getReportQuantity();
         if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
            Object this$nextProcessId = this.getNextProcessId();
            Object other$nextProcessId = other.getNextProcessId();
            if (this$nextProcessId == null ? other$nextProcessId == null : this$nextProcessId.equals(other$nextProcessId)) {
               Object this$id = this.getId();
               Object other$id = other.getId();
               if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                  Object this$reportType = this.getReportType();
                  Object other$reportType = other.getReportType();
                  if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                     Object this$assistGroupId = this.getAssistGroupId();
                     Object other$assistGroupId = other.getAssistGroupId();
                     if (this$assistGroupId == null ? other$assistGroupId == null : this$assistGroupId.equals(other$assistGroupId)) {
                        Object this$assistLineId = this.getAssistLineId();
                        Object other$assistLineId = other.getAssistLineId();
                        if (this$assistLineId == null ? other$assistLineId == null : this$assistLineId.equals(other$assistLineId)) {
                           Object this$numberList = this.getNumberList();
                           Object other$numberList = other.getNumberList();
                           return this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList);
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
      return other instanceof ReportSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolAssistEnum = this.getBoolAssistEnum();
      result = result * 59 + ($boolAssistEnum == null ? 43 : $boolAssistEnum.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $nextProcessId = this.getNextProcessId();
      result = result * 59 + ($nextProcessId == null ? 43 : $nextProcessId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $assistGroupId = this.getAssistGroupId();
      result = result * 59 + ($assistGroupId == null ? 43 : $assistGroupId.hashCode());
      Object $assistLineId = this.getAssistLineId();
      result = result * 59 + ($assistLineId == null ? 43 : $assistLineId.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }
}
