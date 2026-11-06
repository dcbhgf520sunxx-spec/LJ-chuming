package com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderArtifactDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderAssembleDetaiDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderMachinePartDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderMatchingDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.Size;

@ApiModel(value = "MesBuildingTaskOrderSaveVORequest", description = "保存工单列表")
public class MesBuildingTaskOrderSaveVORequest {
   @ApiModelProperty(name = "artifactSchedulingList", value = "构件排产列表", notes = "构件排产列表")
   @JsonProperty("artifactSchedulingList")
   @JSONField(name = "artifactSchedulingList")
   private List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList;
   @ApiModelProperty(name = "assembleDetailList", value = "部件详情列表", notes = "部件详情列表")
   @JsonProperty("assembleDetailList")
   @JSONField(name = "assembleDetailList")
   private List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList;
   @ApiModelProperty(name = "prunedList", value = "剔除部件列表", notes = "剔除部件列表")
   @JsonProperty("prunedList")
   @JSONField(name = "prunedList")
   private List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList;
   @ApiModelProperty(name = "machinePartDetailList", value = "零件详情列表", notes = "零件详情列表")
   @JsonProperty("machinePartDetailList")
   @JSONField(name = "machinePartDetailList")
   private List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList;
   @ApiModelProperty(name = "matchingDetailList", value = "匹配构件信息", notes = "匹配构件信息")
   @JsonProperty("matchingDetailList")
   @JSONField(name = "matchingDetailList")
   private List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("单体")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "inputOrderNumber", value = "自定义任务工单", notes = "自定义任务工单")
   @JsonProperty("inputOrderNumber")
   @JSONField(name = "inputOrderNumber")
   @Size(max = 30, min = 2, message = "自定义任务工单长度不能超过30个字符,不能小于2个字符")
   private String inputOrderNumber;

   public static MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder builder() {
      return new MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder();
   }

   public MesBuildingTaskOrderSaveVORequest(
      final List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList,
      final List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList,
      final List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList,
      final List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList,
      final List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList,
      final Integer productionLineTypeEnum,
      final Long monomerId,
      final String inputOrderNumber
   ) {
      this.artifactSchedulingList = artifactSchedulingList;
      this.assembleDetailList = assembleDetailList;
      this.prunedList = prunedList;
      this.machinePartDetailList = machinePartDetailList;
      this.matchingDetailList = matchingDetailList;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.monomerId = monomerId;
      this.inputOrderNumber = inputOrderNumber;
   }

   public MesBuildingTaskOrderSaveVORequest() {
   }

   public List<MesBuildingTaskOrderArtifactDetailDTOParam> getArtifactSchedulingList() {
      return this.artifactSchedulingList;
   }

   public List<MesBuildingTaskOrderAssembleDetaiDTOParam> getAssembleDetailList() {
      return this.assembleDetailList;
   }

   public List<MesBuildingTaskOrderAssembleDetaiDTOParam> getPrunedList() {
      return this.prunedList;
   }

   public List<MesBuildingTaskOrderMachinePartDetailDTOParam> getMachinePartDetailList() {
      return this.machinePartDetailList;
   }

   public List<MesBuildingTaskOrderMatchingDTOParam> getMatchingDetailList() {
      return this.matchingDetailList;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getInputOrderNumber() {
      return this.inputOrderNumber;
   }

   @JsonProperty("artifactSchedulingList")
   public MesBuildingTaskOrderSaveVORequest setArtifactSchedulingList(final List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList) {
      this.artifactSchedulingList = artifactSchedulingList;
      return this;
   }

   @JsonProperty("assembleDetailList")
   public MesBuildingTaskOrderSaveVORequest setAssembleDetailList(final List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList) {
      this.assembleDetailList = assembleDetailList;
      return this;
   }

   @JsonProperty("prunedList")
   public MesBuildingTaskOrderSaveVORequest setPrunedList(final List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList) {
      this.prunedList = prunedList;
      return this;
   }

   @JsonProperty("machinePartDetailList")
   public MesBuildingTaskOrderSaveVORequest setMachinePartDetailList(final List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList) {
      this.machinePartDetailList = machinePartDetailList;
      return this;
   }

   @JsonProperty("matchingDetailList")
   public MesBuildingTaskOrderSaveVORequest setMatchingDetailList(final List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList) {
      this.matchingDetailList = matchingDetailList;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTaskOrderSaveVORequest setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingTaskOrderSaveVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("inputOrderNumber")
   public MesBuildingTaskOrderSaveVORequest setInputOrderNumber(final String inputOrderNumber) {
      this.inputOrderNumber = inputOrderNumber;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderSaveVORequest)) {
         return false;
      }

      MesBuildingTaskOrderSaveVORequest other = (MesBuildingTaskOrderSaveVORequest)o;
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
                  Object this$prunedList = this.getPrunedList();
                  Object other$prunedList = other.getPrunedList();
                  if (this$prunedList == null ? other$prunedList == null : this$prunedList.equals(other$prunedList)) {
                     Object this$machinePartDetailList = this.getMachinePartDetailList();
                     Object other$machinePartDetailList = other.getMachinePartDetailList();
                     if (this$machinePartDetailList == null
                        ? other$machinePartDetailList == null
                        : this$machinePartDetailList.equals(other$machinePartDetailList)) {
                        Object this$matchingDetailList = this.getMatchingDetailList();
                        Object other$matchingDetailList = other.getMatchingDetailList();
                        if (this$matchingDetailList == null ? other$matchingDetailList == null : this$matchingDetailList.equals(other$matchingDetailList)) {
                           Object this$inputOrderNumber = this.getInputOrderNumber();
                           Object other$inputOrderNumber = other.getInputOrderNumber();
                           return this$inputOrderNumber == null ? other$inputOrderNumber == null : this$inputOrderNumber.equals(other$inputOrderNumber);
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
      return other instanceof MesBuildingTaskOrderSaveVORequest;
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
      Object $prunedList = this.getPrunedList();
      result = result * 59 + ($prunedList == null ? 43 : $prunedList.hashCode());
      Object $machinePartDetailList = this.getMachinePartDetailList();
      result = result * 59 + ($machinePartDetailList == null ? 43 : $machinePartDetailList.hashCode());
      Object $matchingDetailList = this.getMatchingDetailList();
      result = result * 59 + ($matchingDetailList == null ? 43 : $matchingDetailList.hashCode());
      Object $inputOrderNumber = this.getInputOrderNumber();
      return result * 59 + ($inputOrderNumber == null ? 43 : $inputOrderNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderSaveVORequest(artifactSchedulingList="
         + this.getArtifactSchedulingList()
         + ", assembleDetailList="
         + this.getAssembleDetailList()
         + ", prunedList="
         + this.getPrunedList()
         + ", machinePartDetailList="
         + this.getMachinePartDetailList()
         + ", matchingDetailList="
         + this.getMatchingDetailList()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", monomerId="
         + this.getMonomerId()
         + ", inputOrderNumber="
         + this.getInputOrderNumber()
         + ")";
   }

   public static class MesBuildingTaskOrderSaveVORequestBuilder {
      private List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList;
      private List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList;
      private List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList;
      private List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList;
      private List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList;
      private Integer productionLineTypeEnum;
      private Long monomerId;
      private String inputOrderNumber;

      MesBuildingTaskOrderSaveVORequestBuilder() {
      }

      @JsonProperty("artifactSchedulingList")
      public MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder artifactSchedulingList(
         final List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList
      ) {
         this.artifactSchedulingList = artifactSchedulingList;
         return this;
      }

      @JsonProperty("assembleDetailList")
      public MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder assembleDetailList(
         final List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList
      ) {
         this.assembleDetailList = assembleDetailList;
         return this;
      }

      @JsonProperty("prunedList")
      public MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder prunedList(
         final List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList
      ) {
         this.prunedList = prunedList;
         return this;
      }

      @JsonProperty("machinePartDetailList")
      public MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder machinePartDetailList(
         final List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList
      ) {
         this.machinePartDetailList = machinePartDetailList;
         return this;
      }

      @JsonProperty("matchingDetailList")
      public MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder matchingDetailList(
         final List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList
      ) {
         this.matchingDetailList = matchingDetailList;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("inputOrderNumber")
      public MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder inputOrderNumber(final String inputOrderNumber) {
         this.inputOrderNumber = inputOrderNumber;
         return this;
      }

      public MesBuildingTaskOrderSaveVORequest build() {
         return new MesBuildingTaskOrderSaveVORequest(
            this.artifactSchedulingList,
            this.assembleDetailList,
            this.prunedList,
            this.machinePartDetailList,
            this.matchingDetailList,
            this.productionLineTypeEnum,
            this.monomerId,
            this.inputOrderNumber
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderSaveVORequest.MesBuildingTaskOrderSaveVORequestBuilder(artifactSchedulingList="
            + this.artifactSchedulingList
            + ", assembleDetailList="
            + this.assembleDetailList
            + ", prunedList="
            + this.prunedList
            + ", machinePartDetailList="
            + this.machinePartDetailList
            + ", matchingDetailList="
            + this.matchingDetailList
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", monomerId="
            + this.monomerId
            + ", inputOrderNumber="
            + this.inputOrderNumber
            + ")";
      }
   }
}
