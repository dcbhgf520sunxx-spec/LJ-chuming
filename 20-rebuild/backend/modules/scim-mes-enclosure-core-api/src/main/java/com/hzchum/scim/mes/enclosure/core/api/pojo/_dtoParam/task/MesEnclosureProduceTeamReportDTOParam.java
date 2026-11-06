package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesEnclosureTaskProduceTeamReportDTOParam", description = "")
public class MesEnclosureProduceTeamReportDTOParam {
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "boolAssistEnum", notes = "是否是协同")
   @JsonProperty("boolAssistEnum")
   @JSONField(name = "boolAssistEnum")
   private Boolean boolAssistEnum;
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamId", notes = "teamId")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "reportType", notes = "上报类型 0正常上报 1异常上报", value = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Boolean reportType;
   @ApiModelProperty(name = "numberList", notes = "上报编号列表", value = "上报编号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;

   public static MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder builder() {
      return new MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder();
   }

   public MesEnclosureProduceTeamReportDTOParam(
      final Integer reportQuantity, final Boolean boolAssistEnum, final Long id, final Long teamId, final Boolean reportType, final List<Integer> numberList
   ) {
      this.reportQuantity = reportQuantity;
      this.boolAssistEnum = boolAssistEnum;
      this.id = id;
      this.teamId = teamId;
      this.reportType = reportType;
      this.numberList = numberList;
   }

   public MesEnclosureProduceTeamReportDTOParam() {
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Boolean getBoolAssistEnum() {
      return this.boolAssistEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Boolean getReportType() {
      return this.reportType;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   @JsonProperty("reportQuantity")
   public MesEnclosureProduceTeamReportDTOParam setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("boolAssistEnum")
   public MesEnclosureProduceTeamReportDTOParam setBoolAssistEnum(final Boolean boolAssistEnum) {
      this.boolAssistEnum = boolAssistEnum;
      return this;
   }

   @JsonProperty("id")
   public MesEnclosureProduceTeamReportDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureProduceTeamReportDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("reportType")
   public MesEnclosureProduceTeamReportDTOParam setReportType(final Boolean reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("numberList")
   public MesEnclosureProduceTeamReportDTOParam setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProduceTeamReportDTOParam(reportQuantity="
         + this.getReportQuantity()
         + ", boolAssistEnum="
         + this.getBoolAssistEnum()
         + ", id="
         + this.getId()
         + ", teamId="
         + this.getTeamId()
         + ", reportType="
         + this.getReportType()
         + ", numberList="
         + this.getNumberList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProduceTeamReportDTOParam)) {
         return false;
      }

      MesEnclosureProduceTeamReportDTOParam other = (MesEnclosureProduceTeamReportDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reportQuantity = this.getReportQuantity();
      Object other$reportQuantity = other.getReportQuantity();
      if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
         Object this$boolAssistEnum = this.getBoolAssistEnum();
         Object other$boolAssistEnum = other.getBoolAssistEnum();
         if (this$boolAssistEnum == null ? other$boolAssistEnum == null : this$boolAssistEnum.equals(other$boolAssistEnum)) {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$reportType = this.getReportType();
                  Object other$reportType = other.getReportType();
                  if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProduceTeamReportDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $boolAssistEnum = this.getBoolAssistEnum();
      result = result * 59 + ($boolAssistEnum == null ? 43 : $boolAssistEnum.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   public static class MesEnclosureProduceTeamReportDTOParamBuilder {
      private Integer reportQuantity;
      private Boolean boolAssistEnum;
      private Long id;
      private Long teamId;
      private Boolean reportType;
      private List<Integer> numberList;

      MesEnclosureProduceTeamReportDTOParamBuilder() {
      }

      @JsonProperty("reportQuantity")
      public MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("boolAssistEnum")
      public MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder boolAssistEnum(final Boolean boolAssistEnum) {
         this.boolAssistEnum = boolAssistEnum;
         return this;
      }

      @JsonProperty("id")
      public MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("reportType")
      public MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder reportType(final Boolean reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("numberList")
      public MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public MesEnclosureProduceTeamReportDTOParam build() {
         return new MesEnclosureProduceTeamReportDTOParam(this.reportQuantity, this.boolAssistEnum, this.id, this.teamId, this.reportType, this.numberList);
      }

      @Override
      public String toString() {
         return "MesEnclosureProduceTeamReportDTOParam.MesEnclosureProduceTeamReportDTOParamBuilder(reportQuantity="
            + this.reportQuantity
            + ", boolAssistEnum="
            + this.boolAssistEnum
            + ", id="
            + this.id
            + ", teamId="
            + this.teamId
            + ", reportType="
            + this.reportType
            + ", numberList="
            + this.numberList
            + ")";
      }
   }
}
