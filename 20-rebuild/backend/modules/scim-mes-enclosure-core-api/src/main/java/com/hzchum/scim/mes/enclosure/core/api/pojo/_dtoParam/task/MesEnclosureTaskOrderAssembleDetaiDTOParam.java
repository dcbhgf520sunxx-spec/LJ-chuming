package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureTaskOrderAssembleDetaiDTOParam", description = "构件排产请求类")
public class MesEnclosureTaskOrderAssembleDetaiDTOParam {
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

   public static MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder builder() {
      return new MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder();
   }

   public MesEnclosureTaskOrderAssembleDetaiDTOParam(
      final Long productId,
      final Boolean boolTypesettinglEnum,
      final Integer typesettingAssembleTypeEnum,
      final Boolean boolProcess,
      final Boolean boolSectionSteel,
      final Long projectId,
      final Long groupsId,
      final Integer quantity,
      final LocalDateTime askCompleteTime
   ) {
      this.productId = productId;
      this.boolTypesettinglEnum = boolTypesettinglEnum;
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
      this.boolProcess = boolProcess;
      this.boolSectionSteel = boolSectionSteel;
      this.projectId = projectId;
      this.groupsId = groupsId;
      this.quantity = quantity;
      this.askCompleteTime = askCompleteTime;
   }

   public MesEnclosureTaskOrderAssembleDetaiDTOParam() {
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @JsonProperty("productId")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("boolTypesettinglEnum")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setBoolTypesettinglEnum(final Boolean boolTypesettinglEnum) {
      this.boolTypesettinglEnum = boolTypesettinglEnum;
      return this;
   }

   @JsonProperty("typesettingAssembleTypeEnum")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setTypesettingAssembleTypeEnum(final Integer typesettingAssembleTypeEnum) {
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
      return this;
   }

   @JsonProperty("boolProcess")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   @JsonProperty("boolSectionSteel")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTaskOrderAssembleDetaiDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderAssembleDetaiDTOParam)) {
         return false;
      }

      MesEnclosureTaskOrderAssembleDetaiDTOParam other = (MesEnclosureTaskOrderAssembleDetaiDTOParam)o;
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
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$askCompleteTime = this.getAskCompleteTime();
                              Object other$askCompleteTime = other.getAskCompleteTime();
                              return this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof MesEnclosureTaskOrderAssembleDetaiDTOParam;
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
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderAssembleDetaiDTOParam(productId="
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
         + ", quantity="
         + this.getQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ")";
   }

   public static class MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder {
      private Long productId;
      private Boolean boolTypesettinglEnum;
      private Integer typesettingAssembleTypeEnum;
      private Boolean boolProcess;
      private Boolean boolSectionSteel;
      private Long projectId;
      private Long groupsId;
      private Integer quantity;
      private LocalDateTime askCompleteTime;

      MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder() {
      }

      @JsonProperty("productId")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("boolTypesettinglEnum")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder boolTypesettinglEnum(
         final Boolean boolTypesettinglEnum
      ) {
         this.boolTypesettinglEnum = boolTypesettinglEnum;
         return this;
      }

      @JsonProperty("typesettingAssembleTypeEnum")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder typesettingAssembleTypeEnum(
         final Integer typesettingAssembleTypeEnum
      ) {
         this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
         return this;
      }

      @JsonProperty("boolProcess")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      @JsonProperty("boolSectionSteel")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesEnclosureTaskOrderAssembleDetaiDTOParam build() {
         return new MesEnclosureTaskOrderAssembleDetaiDTOParam(
            this.productId,
            this.boolTypesettinglEnum,
            this.typesettingAssembleTypeEnum,
            this.boolProcess,
            this.boolSectionSteel,
            this.projectId,
            this.groupsId,
            this.quantity,
            this.askCompleteTime
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderAssembleDetaiDTOParam.MesEnclosureTaskOrderAssembleDetaiDTOParamBuilder(productId="
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
            + ", quantity="
            + this.quantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ")";
      }
   }
}
