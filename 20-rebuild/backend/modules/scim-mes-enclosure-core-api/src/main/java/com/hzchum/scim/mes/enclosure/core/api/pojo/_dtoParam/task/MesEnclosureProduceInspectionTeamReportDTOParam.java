package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("MesEnclosureProduceInspectionTeamReportDTOParam")
public class MesEnclosureProduceInspectionTeamReportDTOParam {
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

   public static MesEnclosureProduceInspectionTeamReportDTOParam.MesEnclosureProduceInspectionTeamReportDTOParamBuilder builder() {
      return new MesEnclosureProduceInspectionTeamReportDTOParam.MesEnclosureProduceInspectionTeamReportDTOParamBuilder();
   }

   public MesEnclosureProduceInspectionTeamReportDTOParam() {
   }

   public MesEnclosureProduceInspectionTeamReportDTOParam(final Long id, final Long teamId, final Integer reportQuantity, final List<Integer> numberList) {
      this.id = id;
      this.teamId = teamId;
      this.reportQuantity = reportQuantity;
      this.numberList = numberList;
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
   public MesEnclosureProduceInspectionTeamReportDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureProduceInspectionTeamReportDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("reportQuantity")
   public MesEnclosureProduceInspectionTeamReportDTOParam setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("numberList")
   public MesEnclosureProduceInspectionTeamReportDTOParam setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProduceInspectionTeamReportDTOParam(id="
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

      if (!(o instanceof MesEnclosureProduceInspectionTeamReportDTOParam)) {
         return false;
      }

      MesEnclosureProduceInspectionTeamReportDTOParam other = (MesEnclosureProduceInspectionTeamReportDTOParam)o;
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
      return other instanceof MesEnclosureProduceInspectionTeamReportDTOParam;
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

   public static class MesEnclosureProduceInspectionTeamReportDTOParamBuilder {
      private Long id;
      private Long teamId;
      private Integer reportQuantity;
      private List<Integer> numberList;

      MesEnclosureProduceInspectionTeamReportDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProduceInspectionTeamReportDTOParam.MesEnclosureProduceInspectionTeamReportDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureProduceInspectionTeamReportDTOParam.MesEnclosureProduceInspectionTeamReportDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("reportQuantity")
      public MesEnclosureProduceInspectionTeamReportDTOParam.MesEnclosureProduceInspectionTeamReportDTOParamBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("numberList")
      public MesEnclosureProduceInspectionTeamReportDTOParam.MesEnclosureProduceInspectionTeamReportDTOParamBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public MesEnclosureProduceInspectionTeamReportDTOParam build() {
         return new MesEnclosureProduceInspectionTeamReportDTOParam(this.id, this.teamId, this.reportQuantity, this.numberList);
      }

      @Override
      public String toString() {
         return "MesEnclosureProduceInspectionTeamReportDTOParam.MesEnclosureProduceInspectionTeamReportDTOParamBuilder(id="
            + this.id
            + ", teamId="
            + this.teamId
            + ", reportQuantity="
            + this.reportQuantity
            + ", numberList="
            + this.numberList
            + ")";
      }
   }
}
