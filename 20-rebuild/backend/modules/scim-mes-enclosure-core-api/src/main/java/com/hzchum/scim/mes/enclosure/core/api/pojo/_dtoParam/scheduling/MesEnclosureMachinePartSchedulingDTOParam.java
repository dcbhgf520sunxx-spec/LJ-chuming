package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@ApiModel(value = "MesEnclosureMachinePartSchedulingDTOParam", description = "零件排产信息")
public class MesEnclosureMachinePartSchedulingDTOParam {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "thick", value = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private String thick;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "linkList", value = "关联产品", notes = "关联产品")
   @JsonProperty("linkList")
   @JSONField(name = "linkList")
   @Length(min = 1, message = "不能为空")
   private List<MesEnclosureMachinePartSchedulingLinkDTOParam> linkList;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;
   @ApiModelProperty(name = "saveType", value = "保存类型 1不套料下发，2套料下发，4追加新工单", notes = "保存类型 1不套料下发，2套料下发，4追加新工单")
   @JsonProperty("saveType")
   @JSONField(name = "saveType")
   @NotNull(message = "保存类型不能为空")
   private Integer saveType;
   @ApiModelProperty(name = "schedulingId", value = "追加的排产id", notes = "追加的排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "drillGroupsId", value = "钻孔生产组id", notes = "钻孔生产组id")
   @JsonProperty("drillGroupsId")
   @JSONField(name = "drillGroupsId")
   private Long drillGroupsId;
   @ApiModelProperty(name = "drillAskCompleteTime", value = "钻孔要求完成日期", notes = "钻孔要求完成日期")
   @JsonProperty("drillAskCompleteTime")
   @JSONField(name = "drillAskCompleteTime")
   private LocalDateTime drillAskCompleteTime;
   @ApiModelProperty(name = "boolOffLine", value = "套料类型 0:正常套料 1:线下套料", notes = "套料类型 0:正常套料 1:线下套料")
   @JsonProperty("boolOffLine")
   @JSONField(name = "boolOffLine")
   @NotNull(message = "套料类型不能为空")
   private Boolean boolOffLine;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   private Long productionLineId;

   public static MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder builder() {
      return new MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder();
   }

   public MesEnclosureMachinePartSchedulingDTOParam(
      final Long productId,
      final String thick,
      final String material,
      final List<MesEnclosureMachinePartSchedulingLinkDTOParam> linkList,
      final Long cutConfigId,
      final Integer saveType,
      final Long schedulingId,
      final Long groupsId,
      final LocalDateTime askCompleteTime,
      final Long drillGroupsId,
      final LocalDateTime drillAskCompleteTime,
      final Boolean boolOffLine,
      final Long productionLineId
   ) {
      this.productId = productId;
      this.thick = thick;
      this.material = material;
      this.linkList = linkList;
      this.cutConfigId = cutConfigId;
      this.saveType = saveType;
      this.schedulingId = schedulingId;
      this.groupsId = groupsId;
      this.askCompleteTime = askCompleteTime;
      this.drillGroupsId = drillGroupsId;
      this.drillAskCompleteTime = drillAskCompleteTime;
      this.boolOffLine = boolOffLine;
      this.productionLineId = productionLineId;
   }

   public MesEnclosureMachinePartSchedulingDTOParam() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getThick() {
      return this.thick;
   }

   public String getMaterial() {
      return this.material;
   }

   public List<MesEnclosureMachinePartSchedulingLinkDTOParam> getLinkList() {
      return this.linkList;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public Integer getSaveType() {
      return this.saveType;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getDrillGroupsId() {
      return this.drillGroupsId;
   }

   public LocalDateTime getDrillAskCompleteTime() {
      return this.drillAskCompleteTime;
   }

   public Boolean getBoolOffLine() {
      return this.boolOffLine;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   @JsonProperty("productId")
   public MesEnclosureMachinePartSchedulingDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("thick")
   public MesEnclosureMachinePartSchedulingDTOParam setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("material")
   public MesEnclosureMachinePartSchedulingDTOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("linkList")
   public MesEnclosureMachinePartSchedulingDTOParam setLinkList(final List<MesEnclosureMachinePartSchedulingLinkDTOParam> linkList) {
      this.linkList = linkList;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesEnclosureMachinePartSchedulingDTOParam setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("saveType")
   public MesEnclosureMachinePartSchedulingDTOParam setSaveType(final Integer saveType) {
      this.saveType = saveType;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureMachinePartSchedulingDTOParam setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureMachinePartSchedulingDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureMachinePartSchedulingDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("drillGroupsId")
   public MesEnclosureMachinePartSchedulingDTOParam setDrillGroupsId(final Long drillGroupsId) {
      this.drillGroupsId = drillGroupsId;
      return this;
   }

   @JsonProperty("drillAskCompleteTime")
   public MesEnclosureMachinePartSchedulingDTOParam setDrillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
      this.drillAskCompleteTime = drillAskCompleteTime;
      return this;
   }

   @JsonProperty("boolOffLine")
   public MesEnclosureMachinePartSchedulingDTOParam setBoolOffLine(final Boolean boolOffLine) {
      this.boolOffLine = boolOffLine;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureMachinePartSchedulingDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureMachinePartSchedulingDTOParam(productId="
         + this.getProductId()
         + ", thick="
         + this.getThick()
         + ", material="
         + this.getMaterial()
         + ", linkList="
         + this.getLinkList()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", saveType="
         + this.getSaveType()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", groupsId="
         + this.getGroupsId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", drillGroupsId="
         + this.getDrillGroupsId()
         + ", drillAskCompleteTime="
         + this.getDrillAskCompleteTime()
         + ", boolOffLine="
         + this.getBoolOffLine()
         + ", productionLineId="
         + this.getProductionLineId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartSchedulingDTOParam)) {
         return false;
      }

      MesEnclosureMachinePartSchedulingDTOParam other = (MesEnclosureMachinePartSchedulingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$saveType = this.getSaveType();
            Object other$saveType = other.getSaveType();
            if (this$saveType == null ? other$saveType == null : this$saveType.equals(other$saveType)) {
               Object this$schedulingId = this.getSchedulingId();
               Object other$schedulingId = other.getSchedulingId();
               if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                  Object this$groupsId = this.getGroupsId();
                  Object other$groupsId = other.getGroupsId();
                  if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                     Object this$drillGroupsId = this.getDrillGroupsId();
                     Object other$drillGroupsId = other.getDrillGroupsId();
                     if (this$drillGroupsId == null ? other$drillGroupsId == null : this$drillGroupsId.equals(other$drillGroupsId)) {
                        Object this$boolOffLine = this.getBoolOffLine();
                        Object other$boolOffLine = other.getBoolOffLine();
                        if (this$boolOffLine == null ? other$boolOffLine == null : this$boolOffLine.equals(other$boolOffLine)) {
                           Object this$productionLineId = this.getProductionLineId();
                           Object other$productionLineId = other.getProductionLineId();
                           if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                              Object this$thick = this.getThick();
                              Object other$thick = other.getThick();
                              if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$linkList = this.getLinkList();
                                    Object other$linkList = other.getLinkList();
                                    if (this$linkList == null ? other$linkList == null : this$linkList.equals(other$linkList)) {
                                       Object this$askCompleteTime = this.getAskCompleteTime();
                                       Object other$askCompleteTime = other.getAskCompleteTime();
                                       if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                          Object this$drillAskCompleteTime = this.getDrillAskCompleteTime();
                                          Object other$drillAskCompleteTime = other.getDrillAskCompleteTime();
                                          return this$drillAskCompleteTime == null
                                             ? other$drillAskCompleteTime == null
                                             : this$drillAskCompleteTime.equals(other$drillAskCompleteTime);
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
      return other instanceof MesEnclosureMachinePartSchedulingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $saveType = this.getSaveType();
      result = result * 59 + ($saveType == null ? 43 : $saveType.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $drillGroupsId = this.getDrillGroupsId();
      result = result * 59 + ($drillGroupsId == null ? 43 : $drillGroupsId.hashCode());
      Object $boolOffLine = this.getBoolOffLine();
      result = result * 59 + ($boolOffLine == null ? 43 : $boolOffLine.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $linkList = this.getLinkList();
      result = result * 59 + ($linkList == null ? 43 : $linkList.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $drillAskCompleteTime = this.getDrillAskCompleteTime();
      return result * 59 + ($drillAskCompleteTime == null ? 43 : $drillAskCompleteTime.hashCode());
   }

   public static class MesEnclosureMachinePartSchedulingDTOParamBuilder {
      private Long productId;
      private String thick;
      private String material;
      private List<MesEnclosureMachinePartSchedulingLinkDTOParam> linkList;
      private Long cutConfigId;
      private Integer saveType;
      private Long schedulingId;
      private Long groupsId;
      private LocalDateTime askCompleteTime;
      private Long drillGroupsId;
      private LocalDateTime drillAskCompleteTime;
      private Boolean boolOffLine;
      private Long productionLineId;

      MesEnclosureMachinePartSchedulingDTOParamBuilder() {
      }

      @JsonProperty("productId")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("thick")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("material")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("linkList")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder linkList(
         final List<MesEnclosureMachinePartSchedulingLinkDTOParam> linkList
      ) {
         this.linkList = linkList;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("saveType")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder saveType(final Integer saveType) {
         this.saveType = saveType;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("drillGroupsId")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder drillGroupsId(final Long drillGroupsId) {
         this.drillGroupsId = drillGroupsId;
         return this;
      }

      @JsonProperty("drillAskCompleteTime")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder drillAskCompleteTime(
         final LocalDateTime drillAskCompleteTime
      ) {
         this.drillAskCompleteTime = drillAskCompleteTime;
         return this;
      }

      @JsonProperty("boolOffLine")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder boolOffLine(final Boolean boolOffLine) {
         this.boolOffLine = boolOffLine;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesEnclosureMachinePartSchedulingDTOParam build() {
         return new MesEnclosureMachinePartSchedulingDTOParam(
            this.productId,
            this.thick,
            this.material,
            this.linkList,
            this.cutConfigId,
            this.saveType,
            this.schedulingId,
            this.groupsId,
            this.askCompleteTime,
            this.drillGroupsId,
            this.drillAskCompleteTime,
            this.boolOffLine,
            this.productionLineId
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureMachinePartSchedulingDTOParam.MesEnclosureMachinePartSchedulingDTOParamBuilder(productId="
            + this.productId
            + ", thick="
            + this.thick
            + ", material="
            + this.material
            + ", linkList="
            + this.linkList
            + ", cutConfigId="
            + this.cutConfigId
            + ", saveType="
            + this.saveType
            + ", schedulingId="
            + this.schedulingId
            + ", groupsId="
            + this.groupsId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", drillGroupsId="
            + this.drillGroupsId
            + ", drillAskCompleteTime="
            + this.drillAskCompleteTime
            + ", boolOffLine="
            + this.boolOffLine
            + ", productionLineId="
            + this.productionLineId
            + ")";
      }
   }
}
