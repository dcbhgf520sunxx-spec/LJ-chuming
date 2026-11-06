package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.MesBuildingTaskOrderDOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.Size;

@ApiModel(value = "MesBuildingTaskOrderDTOParam", description = "任务工单分配表 ")
public class MesBuildingTaskOrderDTOParam extends MesBuildingTaskOrderDOParam {
   @ApiModelProperty(name = "artifactSchedulingList", value = "构件排产", notes = "构件排产")
   @JsonProperty("artifactSchedulingList")
   @JSONField(name = "artifactSchedulingList")
   private List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList;
   @ApiModelProperty(name = "assembleDetailList", value = "部件详情列表", notes = "部件详情列表")
   @JsonProperty("assembleDetailList")
   @JSONField(name = "assembleDetailList")
   private List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList;
   @ApiModelProperty(name = "machinePartDetailList", value = "零件详情列表", notes = "零件详情列表")
   @JsonProperty("machinePartDetailList")
   @JSONField(name = "machinePartDetailList")
   private List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList;
   @ApiModelProperty(name = "prunedList", value = "剔除部件列表", notes = "剔除部件列表")
   @JsonProperty("prunedList")
   @JSONField(name = "prunedList")
   private List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList;
   @ApiModelProperty(name = "matchingDetailList", value = "匹配构件信息", notes = "匹配构件信息")
   @JsonProperty("matchingDetailList")
   @JSONField(name = "matchingDetailList")
   private List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "inputOrderNumber", value = "自定义任务工单", notes = "自定义任务工单")
   @JsonProperty("inputOrderNumber")
   @JSONField(name = "inputOrderNumber")
   @Size(max = 30, min = 2, message = "自定义任务工单长度不能超过30个字符,不能小于2个字符")
   private String inputOrderNumber;

   protected MesBuildingTaskOrderDTOParam(final MesBuildingTaskOrderDTOParam.MesBuildingTaskOrderDTOParamBuilder<?, ?> b) {
      super(b);
      this.artifactSchedulingList = b.artifactSchedulingList;
      this.assembleDetailList = b.assembleDetailList;
      this.machinePartDetailList = b.machinePartDetailList;
      this.prunedList = b.prunedList;
      this.matchingDetailList = b.matchingDetailList;
      this.productType = b.productType;
      this.productionLineTypeEnum = b.productionLineTypeEnum;
      this.inputOrderNumber = b.inputOrderNumber;
   }

   public static MesBuildingTaskOrderDTOParam.MesBuildingTaskOrderDTOParamBuilder<?, ?> builder() {
      return new MesBuildingTaskOrderDTOParam.MesBuildingTaskOrderDTOParamBuilderImpl();
   }

   public MesBuildingTaskOrderDTOParam(
      final List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList,
      final List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList,
      final List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList,
      final List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList,
      final List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList,
      final Integer productType,
      final Integer productionLineTypeEnum,
      final String inputOrderNumber
   ) {
      this.artifactSchedulingList = artifactSchedulingList;
      this.assembleDetailList = assembleDetailList;
      this.machinePartDetailList = machinePartDetailList;
      this.prunedList = prunedList;
      this.matchingDetailList = matchingDetailList;
      this.productType = productType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.inputOrderNumber = inputOrderNumber;
   }

   public MesBuildingTaskOrderDTOParam() {
   }

   public List<MesBuildingTaskOrderArtifactDetailDTOParam> getArtifactSchedulingList() {
      return this.artifactSchedulingList;
   }

   public List<MesBuildingTaskOrderAssembleDetaiDTOParam> getAssembleDetailList() {
      return this.assembleDetailList;
   }

   public List<MesBuildingTaskOrderMachinePartDetailDTOParam> getMachinePartDetailList() {
      return this.machinePartDetailList;
   }

   public List<MesBuildingTaskOrderAssembleDetaiDTOParam> getPrunedList() {
      return this.prunedList;
   }

   public List<MesBuildingTaskOrderMatchingDTOParam> getMatchingDetailList() {
      return this.matchingDetailList;
   }

   @Override
   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public String getInputOrderNumber() {
      return this.inputOrderNumber;
   }

   @JsonProperty("artifactSchedulingList")
   public MesBuildingTaskOrderDTOParam setArtifactSchedulingList(final List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList) {
      this.artifactSchedulingList = artifactSchedulingList;
      return this;
   }

   @JsonProperty("assembleDetailList")
   public MesBuildingTaskOrderDTOParam setAssembleDetailList(final List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList) {
      this.assembleDetailList = assembleDetailList;
      return this;
   }

   @JsonProperty("machinePartDetailList")
   public MesBuildingTaskOrderDTOParam setMachinePartDetailList(final List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList) {
      this.machinePartDetailList = machinePartDetailList;
      return this;
   }

   @JsonProperty("prunedList")
   public MesBuildingTaskOrderDTOParam setPrunedList(final List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList) {
      this.prunedList = prunedList;
      return this;
   }

   @JsonProperty("matchingDetailList")
   public MesBuildingTaskOrderDTOParam setMatchingDetailList(final List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList) {
      this.matchingDetailList = matchingDetailList;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingTaskOrderDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTaskOrderDTOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("inputOrderNumber")
   public MesBuildingTaskOrderDTOParam setInputOrderNumber(final String inputOrderNumber) {
      this.inputOrderNumber = inputOrderNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderDTOParam(artifactSchedulingList="
         + this.getArtifactSchedulingList()
         + ", assembleDetailList="
         + this.getAssembleDetailList()
         + ", machinePartDetailList="
         + this.getMachinePartDetailList()
         + ", prunedList="
         + this.getPrunedList()
         + ", matchingDetailList="
         + this.getMatchingDetailList()
         + ", productType="
         + this.getProductType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", inputOrderNumber="
         + this.getInputOrderNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderDTOParam)) {
         return false;
      }

      MesBuildingTaskOrderDTOParam other = (MesBuildingTaskOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
         if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
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
                     Object this$prunedList = this.getPrunedList();
                     Object other$prunedList = other.getPrunedList();
                     if (this$prunedList == null ? other$prunedList == null : this$prunedList.equals(other$prunedList)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $artifactSchedulingList = this.getArtifactSchedulingList();
      result = result * 59 + ($artifactSchedulingList == null ? 43 : $artifactSchedulingList.hashCode());
      Object $assembleDetailList = this.getAssembleDetailList();
      result = result * 59 + ($assembleDetailList == null ? 43 : $assembleDetailList.hashCode());
      Object $machinePartDetailList = this.getMachinePartDetailList();
      result = result * 59 + ($machinePartDetailList == null ? 43 : $machinePartDetailList.hashCode());
      Object $prunedList = this.getPrunedList();
      result = result * 59 + ($prunedList == null ? 43 : $prunedList.hashCode());
      Object $matchingDetailList = this.getMatchingDetailList();
      result = result * 59 + ($matchingDetailList == null ? 43 : $matchingDetailList.hashCode());
      Object $inputOrderNumber = this.getInputOrderNumber();
      return result * 59 + ($inputOrderNumber == null ? 43 : $inputOrderNumber.hashCode());
   }

   public abstract static class MesBuildingTaskOrderDTOParamBuilder<C extends MesBuildingTaskOrderDTOParam, B extends MesBuildingTaskOrderDTOParam.MesBuildingTaskOrderDTOParamBuilder<C, B>>
      extends MesBuildingTaskOrderDOParam.MesBuildingTaskOrderDOParamBuilder<C, B> {
      private List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList;
      private List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList;
      private List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList;
      private List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList;
      private List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList;
      private Integer productType;
      private Integer productionLineTypeEnum;
      private String inputOrderNumber;

      protected abstract B self();

      public abstract C build();

      @JsonProperty("artifactSchedulingList")
      public B artifactSchedulingList(final List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList) {
         this.artifactSchedulingList = artifactSchedulingList;
         return this.self();
      }

      @JsonProperty("assembleDetailList")
      public B assembleDetailList(final List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList) {
         this.assembleDetailList = assembleDetailList;
         return this.self();
      }

      @JsonProperty("machinePartDetailList")
      public B machinePartDetailList(final List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList) {
         this.machinePartDetailList = machinePartDetailList;
         return this.self();
      }

      @JsonProperty("prunedList")
      public B prunedList(final List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList) {
         this.prunedList = prunedList;
         return this.self();
      }

      @JsonProperty("matchingDetailList")
      public B matchingDetailList(final List<MesBuildingTaskOrderMatchingDTOParam> matchingDetailList) {
         this.matchingDetailList = matchingDetailList;
         return this.self();
      }

      @JsonProperty("productType")
      public B productType(final Integer productType) {
         this.productType = productType;
         return this.self();
      }

      @JsonProperty("productionLineTypeEnum")
      public B productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this.self();
      }

      @JsonProperty("inputOrderNumber")
      public B inputOrderNumber(final String inputOrderNumber) {
         this.inputOrderNumber = inputOrderNumber;
         return this.self();
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderDTOParam.MesBuildingTaskOrderDTOParamBuilder(super="
            + super.toString()
            + ", artifactSchedulingList="
            + this.artifactSchedulingList
            + ", assembleDetailList="
            + this.assembleDetailList
            + ", machinePartDetailList="
            + this.machinePartDetailList
            + ", prunedList="
            + this.prunedList
            + ", matchingDetailList="
            + this.matchingDetailList
            + ", productType="
            + this.productType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", inputOrderNumber="
            + this.inputOrderNumber
            + ")";
      }
   }

   private static final class MesBuildingTaskOrderDTOParamBuilderImpl
      extends MesBuildingTaskOrderDTOParam.MesBuildingTaskOrderDTOParamBuilder<MesBuildingTaskOrderDTOParam, MesBuildingTaskOrderDTOParam.MesBuildingTaskOrderDTOParamBuilderImpl> {
      private MesBuildingTaskOrderDTOParamBuilderImpl() {
      }

      protected MesBuildingTaskOrderDTOParam.MesBuildingTaskOrderDTOParamBuilderImpl self() {
         return this;
      }

      @Override
      public MesBuildingTaskOrderDTOParam build() {
         return new MesBuildingTaskOrderDTOParam(this);
      }
   }
}
