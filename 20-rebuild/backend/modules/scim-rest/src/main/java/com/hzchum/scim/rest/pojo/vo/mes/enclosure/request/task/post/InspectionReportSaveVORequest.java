package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "InspectionReportSavedDTO", description = "")
public class InspectionReportSaveVORequest {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamId", value = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @NotNull(message = "生产班组id不能为空")
   private Long teamId;
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   @NotNull(message = "上报数量不能为空")
   private Integer reportQuantity;
   @ApiModelProperty(name = "numberList", notes = "上报编号列表", value = "上报编号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;

   public InspectionReportSaveVORequest(final Long id, final Long teamId, final Integer reportQuantity, final List<Integer> numberList) {
      this.id = id;
      this.teamId = teamId;
      this.reportQuantity = reportQuantity;
      this.numberList = numberList;
   }

   public InspectionReportSaveVORequest() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   @JsonProperty("id")
   public InspectionReportSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamId")
   public InspectionReportSaveVORequest setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("reportQuantity")
   public InspectionReportSaveVORequest setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("numberList")
   public InspectionReportSaveVORequest setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionReportSaveVORequest(id="
         + this.getId()
         + ", teamId="
         + this.getTeamId()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", numberList="
         + this.getNumberList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionReportSaveVORequest)) {
         return false;
      }

      InspectionReportSaveVORequest other = (InspectionReportSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$reportQuantity = this.getReportQuantity();
            Object other$reportQuantity = other.getReportQuantity();
            if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionReportSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }
}
