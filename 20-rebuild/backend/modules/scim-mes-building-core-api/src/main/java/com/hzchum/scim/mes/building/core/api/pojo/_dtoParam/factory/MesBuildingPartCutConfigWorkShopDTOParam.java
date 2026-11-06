package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingPartCutConfigWorkShopDOParam对象", description = "查询零件切割任务配置（型材）")
public class MesBuildingPartCutConfigWorkShopDTOParam {
   @ApiModelProperty(name = "partProdMode", notes = "零件生产模式1 数控切割 2 半自动切割")
   @JsonProperty("partProdMode")
   private Integer partProdMode;
   @ApiModelProperty(name = "processType", notes = "工序类型4 下料类 8 钻孔类")
   @JsonProperty("processType")
   private Integer processType;
   @ApiModelProperty(name = "partType", notes = "零件类型1 板材零件 2 型材零件")
   @JsonProperty("partType")
   private Integer partType;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   private Long teamId;
   @ApiModelProperty(name = "partFeatureList", value = "零件特征", notes = "零件特征")
   @JsonProperty("partFeatureList")
   @JSONField(name = "partFeatureList")
   private List<Long> partFeatureList;

   public static MesBuildingPartCutConfigWorkShopDTOParam.MesBuildingPartCutConfigWorkShopDTOParamBuilder builder() {
      return new MesBuildingPartCutConfigWorkShopDTOParam.MesBuildingPartCutConfigWorkShopDTOParamBuilder();
   }

   public MesBuildingPartCutConfigWorkShopDTOParam() {
   }

   public MesBuildingPartCutConfigWorkShopDTOParam(
      final Integer partProdMode, final Integer processType, final Integer partType, final Long teamId, final List<Long> partFeatureList
   ) {
      this.partProdMode = partProdMode;
      this.processType = processType;
      this.partType = partType;
      this.teamId = teamId;
      this.partFeatureList = partFeatureList;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public List<Long> getPartFeatureList() {
      return this.partFeatureList;
   }

   @JsonProperty("partProdMode")
   public MesBuildingPartCutConfigWorkShopDTOParam setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @JsonProperty("processType")
   public MesBuildingPartCutConfigWorkShopDTOParam setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   @JsonProperty("partType")
   public MesBuildingPartCutConfigWorkShopDTOParam setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingPartCutConfigWorkShopDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("partFeatureList")
   public MesBuildingPartCutConfigWorkShopDTOParam setPartFeatureList(final List<Long> partFeatureList) {
      this.partFeatureList = partFeatureList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartCutConfigWorkShopDTOParam)) {
         return false;
      }

      MesBuildingPartCutConfigWorkShopDTOParam other = (MesBuildingPartCutConfigWorkShopDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$partProdMode = this.getPartProdMode();
      Object other$partProdMode = other.getPartProdMode();
      if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
         Object this$processType = this.getProcessType();
         Object other$processType = other.getProcessType();
         if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
            Object this$partType = this.getPartType();
            Object other$partType = other.getPartType();
            if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$partFeatureList = this.getPartFeatureList();
                  Object other$partFeatureList = other.getPartFeatureList();
                  return this$partFeatureList == null ? other$partFeatureList == null : this$partFeatureList.equals(other$partFeatureList);
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
      return other instanceof MesBuildingPartCutConfigWorkShopDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $partFeatureList = this.getPartFeatureList();
      return result * 59 + ($partFeatureList == null ? 43 : $partFeatureList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPartCutConfigWorkShopDTOParam(partProdMode="
         + this.getPartProdMode()
         + ", processType="
         + this.getProcessType()
         + ", partType="
         + this.getPartType()
         + ", teamId="
         + this.getTeamId()
         + ", partFeatureList="
         + this.getPartFeatureList()
         + ")";
   }

   public static class MesBuildingPartCutConfigWorkShopDTOParamBuilder {
      private Integer partProdMode;
      private Integer processType;
      private Integer partType;
      private Long teamId;
      private List<Long> partFeatureList;

      MesBuildingPartCutConfigWorkShopDTOParamBuilder() {
      }

      @JsonProperty("partProdMode")
      public MesBuildingPartCutConfigWorkShopDTOParam.MesBuildingPartCutConfigWorkShopDTOParamBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      @JsonProperty("processType")
      public MesBuildingPartCutConfigWorkShopDTOParam.MesBuildingPartCutConfigWorkShopDTOParamBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      @JsonProperty("partType")
      public MesBuildingPartCutConfigWorkShopDTOParam.MesBuildingPartCutConfigWorkShopDTOParamBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingPartCutConfigWorkShopDTOParam.MesBuildingPartCutConfigWorkShopDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("partFeatureList")
      public MesBuildingPartCutConfigWorkShopDTOParam.MesBuildingPartCutConfigWorkShopDTOParamBuilder partFeatureList(final List<Long> partFeatureList) {
         this.partFeatureList = partFeatureList;
         return this;
      }

      public MesBuildingPartCutConfigWorkShopDTOParam build() {
         return new MesBuildingPartCutConfigWorkShopDTOParam(this.partProdMode, this.processType, this.partType, this.teamId, this.partFeatureList);
      }

      @Override
      public String toString() {
         return "MesBuildingPartCutConfigWorkShopDTOParam.MesBuildingPartCutConfigWorkShopDTOParamBuilder(partProdMode="
            + this.partProdMode
            + ", processType="
            + this.processType
            + ", partType="
            + this.partType
            + ", teamId="
            + this.teamId
            + ", partFeatureList="
            + this.partFeatureList
            + ")";
      }
   }
}
