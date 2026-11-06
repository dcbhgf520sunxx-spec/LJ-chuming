package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureTaskOrderArtifactDetailDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureTaskOrderAssembleDetaiDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureTaskOrderMachinePartDetailDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureTaskOrderMatchingDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesEnclosureTaskOrderSaveVORequest", description = "保存工单列表")
public class MesEnclosureTaskOrderSaveVORequest {
   @ApiModelProperty(name = "artifactSchedulingList", value = "构件排产列表", notes = "构件排产列表")
   @JsonProperty("artifactSchedulingList")
   @JSONField(name = "artifactSchedulingList")
   private List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList;
   @ApiModelProperty(name = "assembleDetailList", value = "部件详情列表", notes = "部件详情列表")
   @JsonProperty("assembleDetailList")
   @JSONField(name = "assembleDetailList")
   private List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList;
   @ApiModelProperty(name = "machinePartDetailList", value = "零件详情列表", notes = "零件详情列表")
   @JsonProperty("machinePartDetailList")
   @JSONField(name = "machinePartDetailList")
   private List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList;
   @ApiModelProperty(name = "matchingDetailList", value = "匹配构件信息", notes = "匹配构件信息")
   @JsonProperty("matchingDetailList")
   @JSONField(name = "matchingDetailList")
   private List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("单体")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;

   public static MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder builder() {
      return new MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder();
   }

   public MesEnclosureTaskOrderSaveVORequest(
      final List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList,
      final List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList,
      final List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList,
      final List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList,
      final Integer productionLineTypeEnum,
      final Long monomerId
   ) {
      this.artifactSchedulingList = artifactSchedulingList;
      this.assembleDetailList = assembleDetailList;
      this.machinePartDetailList = machinePartDetailList;
      this.matchingDetailList = matchingDetailList;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.monomerId = monomerId;
   }

   public MesEnclosureTaskOrderSaveVORequest() {
   }

   public List<MesEnclosureTaskOrderArtifactDetailDTOParam> getArtifactSchedulingList() {
      return this.artifactSchedulingList;
   }

   public List<MesEnclosureTaskOrderAssembleDetaiDTOParam> getAssembleDetailList() {
      return this.assembleDetailList;
   }

   public List<MesEnclosureTaskOrderMachinePartDetailDTOParam> getMachinePartDetailList() {
      return this.machinePartDetailList;
   }

   public List<MesEnclosureTaskOrderMatchingDTOParam> getMatchingDetailList() {
      return this.matchingDetailList;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   @JsonProperty("artifactSchedulingList")
   public MesEnclosureTaskOrderSaveVORequest setArtifactSchedulingList(final List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList) {
      this.artifactSchedulingList = artifactSchedulingList;
      return this;
   }

   @JsonProperty("assembleDetailList")
   public MesEnclosureTaskOrderSaveVORequest setAssembleDetailList(final List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList) {
      this.assembleDetailList = assembleDetailList;
      return this;
   }

   @JsonProperty("machinePartDetailList")
   public MesEnclosureTaskOrderSaveVORequest setMachinePartDetailList(final List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList) {
      this.machinePartDetailList = machinePartDetailList;
      return this;
   }

   @JsonProperty("matchingDetailList")
   public MesEnclosureTaskOrderSaveVORequest setMatchingDetailList(final List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList) {
      this.matchingDetailList = matchingDetailList;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesEnclosureTaskOrderSaveVORequest setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureTaskOrderSaveVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderSaveVORequest)) {
         return false;
      }

      MesEnclosureTaskOrderSaveVORequest other = (MesEnclosureTaskOrderSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
      Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
      if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$artifactSchedulingList = this.getArtifactSchedulingList();
            Object other$artifactSchedulingList = other.getArtifactSchedulingList();
            if (this$artifactSchedulingList == null ? other$artifactSchedulingList == null : this$artifactSchedulingList.equals(other$artifactSchedulingList)) {
               Object this$assembleDetailList = this.getAssembleDetailList();
               Object other$assembleDetailList = other.getAssembleDetailList();
               if (this$assembleDetailList == null ? other$assembleDetailList == null : this$assembleDetailList.equals(other$assembleDetailList)) {
                  Object this$machinePartDetailList = this.getMachinePartDetailList();
                  Object other$machinePartDetailList = other.getMachinePartDetailList();
                  if (this$machinePartDetailList == null ? other$machinePartDetailList == null : this$machinePartDetailList.equals(other$machinePartDetailList)
                     )
                   {
                     Object this$matchingDetailList = this.getMatchingDetailList();
                     Object other$matchingDetailList = other.getMatchingDetailList();
                     return this$matchingDetailList == null ? other$matchingDetailList == null : this$matchingDetailList.equals(other$matchingDetailList);
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
      return other instanceof MesEnclosureTaskOrderSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $artifactSchedulingList = this.getArtifactSchedulingList();
      result = result * 59 + ($artifactSchedulingList == null ? 43 : $artifactSchedulingList.hashCode());
      Object $assembleDetailList = this.getAssembleDetailList();
      result = result * 59 + ($assembleDetailList == null ? 43 : $assembleDetailList.hashCode());
      Object $machinePartDetailList = this.getMachinePartDetailList();
      result = result * 59 + ($machinePartDetailList == null ? 43 : $machinePartDetailList.hashCode());
      Object $matchingDetailList = this.getMatchingDetailList();
      return result * 59 + ($matchingDetailList == null ? 43 : $matchingDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderSaveVORequest(artifactSchedulingList="
         + this.getArtifactSchedulingList()
         + ", assembleDetailList="
         + this.getAssembleDetailList()
         + ", machinePartDetailList="
         + this.getMachinePartDetailList()
         + ", matchingDetailList="
         + this.getMatchingDetailList()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", monomerId="
         + this.getMonomerId()
         + ")";
   }

   public static class MesEnclosureTaskOrderSaveVORequestBuilder {
      private List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList;
      private List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList;
      private List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList;
      private List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList;
      private Integer productionLineTypeEnum;
      private Long monomerId;

      MesEnclosureTaskOrderSaveVORequestBuilder() {
      }

      @JsonProperty("artifactSchedulingList")
      public MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder artifactSchedulingList(
         final List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList
      ) {
         this.artifactSchedulingList = artifactSchedulingList;
         return this;
      }

      @JsonProperty("assembleDetailList")
      public MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder assembleDetailList(
         final List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList
      ) {
         this.assembleDetailList = assembleDetailList;
         return this;
      }

      @JsonProperty("machinePartDetailList")
      public MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder machinePartDetailList(
         final List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList
      ) {
         this.machinePartDetailList = machinePartDetailList;
         return this;
      }

      @JsonProperty("matchingDetailList")
      public MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder matchingDetailList(
         final List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList
      ) {
         this.matchingDetailList = matchingDetailList;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesEnclosureTaskOrderSaveVORequest build() {
         return new MesEnclosureTaskOrderSaveVORequest(
            this.artifactSchedulingList,
            this.assembleDetailList,
            this.machinePartDetailList,
            this.matchingDetailList,
            this.productionLineTypeEnum,
            this.monomerId
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderSaveVORequest.MesEnclosureTaskOrderSaveVORequestBuilder(artifactSchedulingList="
            + this.artifactSchedulingList
            + ", assembleDetailList="
            + this.assembleDetailList
            + ", machinePartDetailList="
            + this.machinePartDetailList
            + ", matchingDetailList="
            + this.matchingDetailList
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", monomerId="
            + this.monomerId
            + ")";
      }
   }
}
