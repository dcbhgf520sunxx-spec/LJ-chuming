package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingTaskOrderMachinePartDetailDTOParam", description = "零件任务工单请求类")
public class MesBuildingTaskOrderMachinePartDetailDTOParam {
   @ApiModelProperty(name = "id", value = "切割指令id", notes = "切割指令id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "prodLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("prodLineId")
   @JSONField(name = "prodLineId")
   private Long prodLineId;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @NotNull(message = "要求完成日期不能为空")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "drillGroupsId", value = "钻孔生产组id", notes = "钻孔生产组id")
   @JsonProperty("drillGroupsId")
   @JSONField(name = "drillGroupsId")
   private Long drillGroupsId;
   @ApiModelProperty(name = "drillProcessId", value = "钻孔工序id", notes = "钻孔工序id")
   @JsonProperty("drillProcessId")
   @JSONField(name = "drillProcessId")
   private Long drillProcessId;
   @ApiModelProperty(name = "drillTeamId", value = "钻孔班组id", notes = "钻孔班组id")
   @JsonProperty("drillTeamId")
   @JSONField(name = "drillTeamId")
   private Long drillTeamId;
   @ApiModelProperty(name = "drillprodLineId", value = "钻孔生产线id", notes = "钻孔生产线id")
   @JsonProperty("drillprodLineId")
   @JSONField(name = "drillprodLineId")
   private Long drillprodLineId;
   @ApiModelProperty(name = "drillAskCompleteTime", value = "钻孔要求完成日期", notes = "钻孔要求完成日期")
   @JsonProperty("drillAskCompleteTime")
   @JSONField(name = "drillAskCompleteTime")
   private LocalDateTime drillAskCompleteTime;
   @ApiModelProperty("零件分类 4.成品型材 8.钢板")
   @JsonProperty("productClassificationEnum")
   @JSONField(name = "productClassificationEnum")
   private Integer productClassificationEnum;

   public static MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder builder() {
      return new MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder();
   }

   public MesBuildingTaskOrderMachinePartDetailDTOParam(
      final Long id,
      final Long groupsId,
      final Long prodLineId,
      final Long cutConfigId,
      final LocalDateTime askCompleteTime,
      final Long drillGroupsId,
      final Long drillProcessId,
      final Long drillTeamId,
      final Long drillprodLineId,
      final LocalDateTime drillAskCompleteTime,
      final Integer productClassificationEnum
   ) {
      this.id = id;
      this.groupsId = groupsId;
      this.prodLineId = prodLineId;
      this.cutConfigId = cutConfigId;
      this.askCompleteTime = askCompleteTime;
      this.drillGroupsId = drillGroupsId;
      this.drillProcessId = drillProcessId;
      this.drillTeamId = drillTeamId;
      this.drillprodLineId = drillprodLineId;
      this.drillAskCompleteTime = drillAskCompleteTime;
      this.productClassificationEnum = productClassificationEnum;
   }

   public MesBuildingTaskOrderMachinePartDetailDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProdLineId() {
      return this.prodLineId;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getDrillGroupsId() {
      return this.drillGroupsId;
   }

   public Long getDrillProcessId() {
      return this.drillProcessId;
   }

   public Long getDrillTeamId() {
      return this.drillTeamId;
   }

   public Long getDrillprodLineId() {
      return this.drillprodLineId;
   }

   public LocalDateTime getDrillAskCompleteTime() {
      return this.drillAskCompleteTime;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   @JsonProperty("id")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("prodLineId")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setProdLineId(final Long prodLineId) {
      this.prodLineId = prodLineId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("drillGroupsId")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setDrillGroupsId(final Long drillGroupsId) {
      this.drillGroupsId = drillGroupsId;
      return this;
   }

   @JsonProperty("drillProcessId")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setDrillProcessId(final Long drillProcessId) {
      this.drillProcessId = drillProcessId;
      return this;
   }

   @JsonProperty("drillTeamId")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setDrillTeamId(final Long drillTeamId) {
      this.drillTeamId = drillTeamId;
      return this;
   }

   @JsonProperty("drillprodLineId")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setDrillprodLineId(final Long drillprodLineId) {
      this.drillprodLineId = drillprodLineId;
      return this;
   }

   @JsonProperty("drillAskCompleteTime")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setDrillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
      this.drillAskCompleteTime = drillAskCompleteTime;
      return this;
   }

   @JsonProperty("productClassificationEnum")
   public MesBuildingTaskOrderMachinePartDetailDTOParam setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderMachinePartDetailDTOParam)) {
         return false;
      }

      MesBuildingTaskOrderMachinePartDetailDTOParam other = (MesBuildingTaskOrderMachinePartDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$prodLineId = this.getProdLineId();
            Object other$prodLineId = other.getProdLineId();
            if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
               Object this$cutConfigId = this.getCutConfigId();
               Object other$cutConfigId = other.getCutConfigId();
               if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
                  Object this$drillGroupsId = this.getDrillGroupsId();
                  Object other$drillGroupsId = other.getDrillGroupsId();
                  if (this$drillGroupsId == null ? other$drillGroupsId == null : this$drillGroupsId.equals(other$drillGroupsId)) {
                     Object this$drillProcessId = this.getDrillProcessId();
                     Object other$drillProcessId = other.getDrillProcessId();
                     if (this$drillProcessId == null ? other$drillProcessId == null : this$drillProcessId.equals(other$drillProcessId)) {
                        Object this$drillTeamId = this.getDrillTeamId();
                        Object other$drillTeamId = other.getDrillTeamId();
                        if (this$drillTeamId == null ? other$drillTeamId == null : this$drillTeamId.equals(other$drillTeamId)) {
                           Object this$drillprodLineId = this.getDrillprodLineId();
                           Object other$drillprodLineId = other.getDrillprodLineId();
                           if (this$drillprodLineId == null ? other$drillprodLineId == null : this$drillprodLineId.equals(other$drillprodLineId)) {
                              Object this$productClassificationEnum = this.getProductClassificationEnum();
                              Object other$productClassificationEnum = other.getProductClassificationEnum();
                              if (this$productClassificationEnum == null
                                 ? other$productClassificationEnum == null
                                 : this$productClassificationEnum.equals(other$productClassificationEnum)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskOrderMachinePartDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $drillGroupsId = this.getDrillGroupsId();
      result = result * 59 + ($drillGroupsId == null ? 43 : $drillGroupsId.hashCode());
      Object $drillProcessId = this.getDrillProcessId();
      result = result * 59 + ($drillProcessId == null ? 43 : $drillProcessId.hashCode());
      Object $drillTeamId = this.getDrillTeamId();
      result = result * 59 + ($drillTeamId == null ? 43 : $drillTeamId.hashCode());
      Object $drillprodLineId = this.getDrillprodLineId();
      result = result * 59 + ($drillprodLineId == null ? 43 : $drillprodLineId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $drillAskCompleteTime = this.getDrillAskCompleteTime();
      return result * 59 + ($drillAskCompleteTime == null ? 43 : $drillAskCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderMachinePartDetailDTOParam(id="
         + this.getId()
         + ", groupsId="
         + this.getGroupsId()
         + ", prodLineId="
         + this.getProdLineId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", drillGroupsId="
         + this.getDrillGroupsId()
         + ", drillProcessId="
         + this.getDrillProcessId()
         + ", drillTeamId="
         + this.getDrillTeamId()
         + ", drillprodLineId="
         + this.getDrillprodLineId()
         + ", drillAskCompleteTime="
         + this.getDrillAskCompleteTime()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ")";
   }

   public static class MesBuildingTaskOrderMachinePartDetailDTOParamBuilder {
      private Long id;
      private Long groupsId;
      private Long prodLineId;
      private Long cutConfigId;
      private LocalDateTime askCompleteTime;
      private Long drillGroupsId;
      private Long drillProcessId;
      private Long drillTeamId;
      private Long drillprodLineId;
      private LocalDateTime drillAskCompleteTime;
      private Integer productClassificationEnum;

      MesBuildingTaskOrderMachinePartDetailDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("prodLineId")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder prodLineId(final Long prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder askCompleteTime(
         final LocalDateTime askCompleteTime
      ) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("drillGroupsId")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder drillGroupsId(final Long drillGroupsId) {
         this.drillGroupsId = drillGroupsId;
         return this;
      }

      @JsonProperty("drillProcessId")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder drillProcessId(final Long drillProcessId) {
         this.drillProcessId = drillProcessId;
         return this;
      }

      @JsonProperty("drillTeamId")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder drillTeamId(final Long drillTeamId) {
         this.drillTeamId = drillTeamId;
         return this;
      }

      @JsonProperty("drillprodLineId")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder drillprodLineId(final Long drillprodLineId) {
         this.drillprodLineId = drillprodLineId;
         return this;
      }

      @JsonProperty("drillAskCompleteTime")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder drillAskCompleteTime(
         final LocalDateTime drillAskCompleteTime
      ) {
         this.drillAskCompleteTime = drillAskCompleteTime;
         return this;
      }

      @JsonProperty("productClassificationEnum")
      public MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder productClassificationEnum(
         final Integer productClassificationEnum
      ) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      public MesBuildingTaskOrderMachinePartDetailDTOParam build() {
         return new MesBuildingTaskOrderMachinePartDetailDTOParam(
            this.id,
            this.groupsId,
            this.prodLineId,
            this.cutConfigId,
            this.askCompleteTime,
            this.drillGroupsId,
            this.drillProcessId,
            this.drillTeamId,
            this.drillprodLineId,
            this.drillAskCompleteTime,
            this.productClassificationEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderMachinePartDetailDTOParam.MesBuildingTaskOrderMachinePartDetailDTOParamBuilder(id="
            + this.id
            + ", groupsId="
            + this.groupsId
            + ", prodLineId="
            + this.prodLineId
            + ", cutConfigId="
            + this.cutConfigId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", drillGroupsId="
            + this.drillGroupsId
            + ", drillProcessId="
            + this.drillProcessId
            + ", drillTeamId="
            + this.drillTeamId
            + ", drillprodLineId="
            + this.drillprodLineId
            + ", drillAskCompleteTime="
            + this.drillAskCompleteTime
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ")";
      }
   }
}
