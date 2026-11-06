package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.task.MesEnclosureTaskOrderDOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesEnclosureTaskOrderDTOParam", description = "任务工单分配表 ")
public class MesEnclosureTaskOrderDTOParam extends MesEnclosureTaskOrderDOParam {
   @ApiModelProperty(name = "artifactSchedulingList", value = "构件排产", notes = "部件排产")
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
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;

   protected MesEnclosureTaskOrderDTOParam(final MesEnclosureTaskOrderDTOParam.MesEnclosureTaskOrderDTOParamBuilder<?, ?> b) {
      super(b);
      this.artifactSchedulingList = b.artifactSchedulingList;
      this.assembleDetailList = b.assembleDetailList;
      this.machinePartDetailList = b.machinePartDetailList;
      this.matchingDetailList = b.matchingDetailList;
      this.productType = b.productType;
      this.productionLineTypeEnum = b.productionLineTypeEnum;
   }

   public static MesEnclosureTaskOrderDTOParam.MesEnclosureTaskOrderDTOParamBuilder<?, ?> builder() {
      return new MesEnclosureTaskOrderDTOParam.MesEnclosureTaskOrderDTOParamBuilderImpl();
   }

   public MesEnclosureTaskOrderDTOParam(
      final List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList,
      final List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList,
      final List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList,
      final List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList,
      final Integer productType,
      final Integer productionLineTypeEnum
   ) {
      this.artifactSchedulingList = artifactSchedulingList;
      this.assembleDetailList = assembleDetailList;
      this.machinePartDetailList = machinePartDetailList;
      this.matchingDetailList = matchingDetailList;
      this.productType = productType;
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public MesEnclosureTaskOrderDTOParam() {
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

   @Override
   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   @JsonProperty("artifactSchedulingList")
   public MesEnclosureTaskOrderDTOParam setArtifactSchedulingList(final List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList) {
      this.artifactSchedulingList = artifactSchedulingList;
      return this;
   }

   @JsonProperty("assembleDetailList")
   public MesEnclosureTaskOrderDTOParam setAssembleDetailList(final List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList) {
      this.assembleDetailList = assembleDetailList;
      return this;
   }

   @JsonProperty("machinePartDetailList")
   public MesEnclosureTaskOrderDTOParam setMachinePartDetailList(final List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList) {
      this.machinePartDetailList = machinePartDetailList;
      return this;
   }

   @JsonProperty("matchingDetailList")
   public MesEnclosureTaskOrderDTOParam setMatchingDetailList(final List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList) {
      this.matchingDetailList = matchingDetailList;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureTaskOrderDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesEnclosureTaskOrderDTOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderDTOParam(artifactSchedulingList="
         + this.getArtifactSchedulingList()
         + ", assembleDetailList="
         + this.getAssembleDetailList()
         + ", machinePartDetailList="
         + this.getMachinePartDetailList()
         + ", matchingDetailList="
         + this.getMatchingDetailList()
         + ", productType="
         + this.getProductType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderDTOParam)) {
         return false;
      }

      MesEnclosureTaskOrderDTOParam other = (MesEnclosureTaskOrderDTOParam)o;
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskOrderDTOParam;
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
      Object $matchingDetailList = this.getMatchingDetailList();
      return result * 59 + ($matchingDetailList == null ? 43 : $matchingDetailList.hashCode());
   }

   public abstract static class MesEnclosureTaskOrderDTOParamBuilder<C extends MesEnclosureTaskOrderDTOParam, B extends MesEnclosureTaskOrderDTOParam.MesEnclosureTaskOrderDTOParamBuilder<C, B>>
      extends MesEnclosureTaskOrderDOParam.MesEnclosureTaskOrderDOParamBuilder<C, B> {
      private List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList;
      private List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList;
      private List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList;
      private List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList;
      private Integer productType;
      private Integer productionLineTypeEnum;

      protected abstract B self();

      public abstract C build();

      @JsonProperty("artifactSchedulingList")
      public B artifactSchedulingList(final List<MesEnclosureTaskOrderArtifactDetailDTOParam> artifactSchedulingList) {
         this.artifactSchedulingList = artifactSchedulingList;
         return this.self();
      }

      @JsonProperty("assembleDetailList")
      public B assembleDetailList(final List<MesEnclosureTaskOrderAssembleDetaiDTOParam> assembleDetailList) {
         this.assembleDetailList = assembleDetailList;
         return this.self();
      }

      @JsonProperty("machinePartDetailList")
      public B machinePartDetailList(final List<MesEnclosureTaskOrderMachinePartDetailDTOParam> machinePartDetailList) {
         this.machinePartDetailList = machinePartDetailList;
         return this.self();
      }

      @JsonProperty("matchingDetailList")
      public B matchingDetailList(final List<MesEnclosureTaskOrderMatchingDTOParam> matchingDetailList) {
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

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderDTOParam.MesEnclosureTaskOrderDTOParamBuilder(super="
            + super.toString()
            + ", artifactSchedulingList="
            + this.artifactSchedulingList
            + ", assembleDetailList="
            + this.assembleDetailList
            + ", machinePartDetailList="
            + this.machinePartDetailList
            + ", matchingDetailList="
            + this.matchingDetailList
            + ", productType="
            + this.productType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ")";
      }
   }

   private static final class MesEnclosureTaskOrderDTOParamBuilderImpl
      extends MesEnclosureTaskOrderDTOParam.MesEnclosureTaskOrderDTOParamBuilder<MesEnclosureTaskOrderDTOParam, MesEnclosureTaskOrderDTOParam.MesEnclosureTaskOrderDTOParamBuilderImpl> {
      private MesEnclosureTaskOrderDTOParamBuilderImpl() {
      }

      protected MesEnclosureTaskOrderDTOParam.MesEnclosureTaskOrderDTOParamBuilderImpl self() {
         return this;
      }

      @Override
      public MesEnclosureTaskOrderDTOParam build() {
         return new MesEnclosureTaskOrderDTOParam(this);
      }
   }
}
