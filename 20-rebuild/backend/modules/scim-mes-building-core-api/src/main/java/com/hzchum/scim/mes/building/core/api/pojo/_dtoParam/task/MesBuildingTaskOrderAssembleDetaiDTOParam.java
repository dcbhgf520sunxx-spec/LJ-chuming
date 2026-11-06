package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingTaskOrderAssembleDetaiDTOParam", description = "部件件排产请求类")
public class MesBuildingTaskOrderAssembleDetaiDTOParam {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "boolTypesettinglEnum", value = "是否母件", notes = "是否母件")
   @JsonProperty("boolTypesettinglEnum")
   @JSONField(name = "boolTypesettinglEnum")
   private Boolean boolTypesettinglEnum;
   @ApiModelProperty(name = "typesettingAssembleTypeEnum", value = "母件类型")
   @JsonProperty("typesettingAssembleTypeEnum")
   @JSONField(name = "typesettingAssembleTypeEnum")
   private Integer typesettingAssembleTypeEnum;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [false 否, true 是]", notes = "是否成品型材 [false 否, true 是]]")
   @JsonProperty("boolSectionSteel")
   @JSONField(name = "boolSectionSteel")
   private Boolean boolSectionSteel;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @NotNull(message = "生产组id")
   private Long groupsId;
   @ApiModelProperty(name = "prodLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("prodLineId")
   @JSONField(name = "prodLineId")
   @NotNull(message = "生产线id")
   private Long prodLineId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @NotNull(message = "区域Id")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   private Long areaBatchId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "排产数量不能为空")
   @Min(value = 1L, message = "排产数量不能小于1")
   private Integer quantity;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @NotNull(message = "要求完成日期不能为空")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "boolOneCode", value = "是否一物一码 [false 否, true 是]", notes = "是否一物一码 [false 否, true 是]]")
   @JsonProperty("boolOneCode")
   @JSONField(name = "boolOneCode")
   private Boolean boolOneCode;

   public static MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder builder() {
      return new MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder();
   }

   public MesBuildingTaskOrderAssembleDetaiDTOParam(
      final Long productId,
      final Boolean boolTypesettinglEnum,
      final Integer typesettingAssembleTypeEnum,
      final Boolean boolProcess,
      final Boolean boolSectionSteel,
      final Long projectId,
      final Long groupsId,
      final Long prodLineId,
      final Long areaId,
      final Long areaBatchId,
      final Integer quantity,
      final LocalDateTime askCompleteTime,
      final Boolean boolOneCode
   ) {
      this.productId = productId;
      this.boolTypesettinglEnum = boolTypesettinglEnum;
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
      this.boolProcess = boolProcess;
      this.boolSectionSteel = boolSectionSteel;
      this.projectId = projectId;
      this.groupsId = groupsId;
      this.prodLineId = prodLineId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.quantity = quantity;
      this.askCompleteTime = askCompleteTime;
      this.boolOneCode = boolOneCode;
   }

   public MesBuildingTaskOrderAssembleDetaiDTOParam() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public Boolean getBoolTypesettinglEnum() {
      return this.boolTypesettinglEnum;
   }

   public Integer getTypesettingAssembleTypeEnum() {
      return this.typesettingAssembleTypeEnum;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProdLineId() {
      return this.prodLineId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   @JsonProperty("productId")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("boolTypesettinglEnum")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setBoolTypesettinglEnum(final Boolean boolTypesettinglEnum) {
      this.boolTypesettinglEnum = boolTypesettinglEnum;
      return this;
   }

   @JsonProperty("typesettingAssembleTypeEnum")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setTypesettingAssembleTypeEnum(final Integer typesettingAssembleTypeEnum) {
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
      return this;
   }

   @JsonProperty("boolProcess")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   @JsonProperty("boolSectionSteel")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("prodLineId")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setProdLineId(final Long prodLineId) {
      this.prodLineId = prodLineId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("boolOneCode")
   public MesBuildingTaskOrderAssembleDetaiDTOParam setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderAssembleDetaiDTOParam)) {
         return false;
      }

      MesBuildingTaskOrderAssembleDetaiDTOParam other = (MesBuildingTaskOrderAssembleDetaiDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$boolTypesettinglEnum = this.getBoolTypesettinglEnum();
         Object other$boolTypesettinglEnum = other.getBoolTypesettinglEnum();
         if (this$boolTypesettinglEnum == null ? other$boolTypesettinglEnum == null : this$boolTypesettinglEnum.equals(other$boolTypesettinglEnum)) {
            Object this$typesettingAssembleTypeEnum = this.getTypesettingAssembleTypeEnum();
            Object other$typesettingAssembleTypeEnum = other.getTypesettingAssembleTypeEnum();
            if (this$typesettingAssembleTypeEnum == null
               ? other$typesettingAssembleTypeEnum == null
               : this$typesettingAssembleTypeEnum.equals(other$typesettingAssembleTypeEnum)) {
               Object this$boolProcess = this.getBoolProcess();
               Object other$boolProcess = other.getBoolProcess();
               if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                  Object this$boolSectionSteel = this.getBoolSectionSteel();
                  Object other$boolSectionSteel = other.getBoolSectionSteel();
                  if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$groupsId = this.getGroupsId();
                        Object other$groupsId = other.getGroupsId();
                        if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                           Object this$prodLineId = this.getProdLineId();
                           Object other$prodLineId = other.getProdLineId();
                           if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$areaBatchId = this.getAreaBatchId();
                                 Object other$areaBatchId = other.getAreaBatchId();
                                 if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                                    Object this$quantity = this.getQuantity();
                                    Object other$quantity = other.getQuantity();
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$boolOneCode = this.getBoolOneCode();
                                       Object other$boolOneCode = other.getBoolOneCode();
                                       if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                                          Object this$askCompleteTime = this.getAskCompleteTime();
                                          Object other$askCompleteTime = other.getAskCompleteTime();
                                          return this$askCompleteTime == null
                                             ? other$askCompleteTime == null
                                             : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof MesBuildingTaskOrderAssembleDetaiDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $boolTypesettinglEnum = this.getBoolTypesettinglEnum();
      result = result * 59 + ($boolTypesettinglEnum == null ? 43 : $boolTypesettinglEnum.hashCode());
      Object $typesettingAssembleTypeEnum = this.getTypesettingAssembleTypeEnum();
      result = result * 59 + ($typesettingAssembleTypeEnum == null ? 43 : $typesettingAssembleTypeEnum.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderAssembleDetaiDTOParam(productId="
         + this.getProductId()
         + ", boolTypesettinglEnum="
         + this.getBoolTypesettinglEnum()
         + ", typesettingAssembleTypeEnum="
         + this.getTypesettingAssembleTypeEnum()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", projectId="
         + this.getProjectId()
         + ", groupsId="
         + this.getGroupsId()
         + ", prodLineId="
         + this.getProdLineId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", quantity="
         + this.getQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ")";
   }

   public static class MesBuildingTaskOrderAssembleDetaiDTOParamBuilder {
      private Long productId;
      private Boolean boolTypesettinglEnum;
      private Integer typesettingAssembleTypeEnum;
      private Boolean boolProcess;
      private Boolean boolSectionSteel;
      private Long projectId;
      private Long groupsId;
      private Long prodLineId;
      private Long areaId;
      private Long areaBatchId;
      private Integer quantity;
      private LocalDateTime askCompleteTime;
      private Boolean boolOneCode;

      MesBuildingTaskOrderAssembleDetaiDTOParamBuilder() {
      }

      @JsonProperty("productId")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("boolTypesettinglEnum")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder boolTypesettinglEnum(final Boolean boolTypesettinglEnum) {
         this.boolTypesettinglEnum = boolTypesettinglEnum;
         return this;
      }

      @JsonProperty("typesettingAssembleTypeEnum")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder typesettingAssembleTypeEnum(
         final Integer typesettingAssembleTypeEnum
      ) {
         this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
         return this;
      }

      @JsonProperty("boolProcess")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      @JsonProperty("boolSectionSteel")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("prodLineId")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder prodLineId(final Long prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("boolOneCode")
      public MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      public MesBuildingTaskOrderAssembleDetaiDTOParam build() {
         return new MesBuildingTaskOrderAssembleDetaiDTOParam(
            this.productId,
            this.boolTypesettinglEnum,
            this.typesettingAssembleTypeEnum,
            this.boolProcess,
            this.boolSectionSteel,
            this.projectId,
            this.groupsId,
            this.prodLineId,
            this.areaId,
            this.areaBatchId,
            this.quantity,
            this.askCompleteTime,
            this.boolOneCode
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderAssembleDetaiDTOParam.MesBuildingTaskOrderAssembleDetaiDTOParamBuilder(productId="
            + this.productId
            + ", boolTypesettinglEnum="
            + this.boolTypesettinglEnum
            + ", typesettingAssembleTypeEnum="
            + this.typesettingAssembleTypeEnum
            + ", boolProcess="
            + this.boolProcess
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", projectId="
            + this.projectId
            + ", groupsId="
            + this.groupsId
            + ", prodLineId="
            + this.prodLineId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", quantity="
            + this.quantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", boolOneCode="
            + this.boolOneCode
            + ")";
      }
   }
}
