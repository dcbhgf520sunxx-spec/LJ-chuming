package com.hzchum.scim.system.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "组立规格配置类 ")
public class AssembleSpecDTOParam {
   @ApiModelProperty("规格前缀id")
   private Long id;
   @ApiModelProperty(name = "assembleConfigId", value = "部件配置id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   private Long assembleConfigId;
   @ApiModelProperty("规格前缀")
   @NotBlank(message = "规格前缀不能为空")
   @Size(min = 1, max = 32, message = "组立规格前缀长度超出范围")
   private String specPrefix;
   @ApiModelProperty("规格前缀（新）")
   private String newSpecPrefix;
   @ApiModelProperty("规格索引")
   @NotNull(message = "索引不能为空")
   @Min(0L)
   @Max(4L)
   private Integer specIndex;
   @ApiModelProperty("规格索引（新）")
   private Integer newSpecIndex;
   @ApiModelProperty("变更类型 1新增 2删除 3修改 4未修改")
   private Integer changeType;

   public static AssembleSpecDTOParam.AssembleSpecDTOParamBuilder builder() {
      return new AssembleSpecDTOParam.AssembleSpecDTOParamBuilder();
   }

   public AssembleSpecDTOParam() {
   }

   public AssembleSpecDTOParam(
      final Long id,
      final Long assembleConfigId,
      final String specPrefix,
      final String newSpecPrefix,
      final Integer specIndex,
      final Integer newSpecIndex,
      final Integer changeType
   ) {
      this.id = id;
      this.assembleConfigId = assembleConfigId;
      this.specPrefix = specPrefix;
      this.newSpecPrefix = newSpecPrefix;
      this.specIndex = specIndex;
      this.newSpecIndex = newSpecIndex;
      this.changeType = changeType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getNewSpecPrefix() {
      return this.newSpecPrefix;
   }

   public Integer getSpecIndex() {
      return this.specIndex;
   }

   public Integer getNewSpecIndex() {
      return this.newSpecIndex;
   }

   public Integer getChangeType() {
      return this.changeType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("assembleConfigId")
   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setNewSpecPrefix(final String newSpecPrefix) {
      this.newSpecPrefix = newSpecPrefix;
   }

   public void setSpecIndex(final Integer specIndex) {
      this.specIndex = specIndex;
   }

   public void setNewSpecIndex(final Integer newSpecIndex) {
      this.newSpecIndex = newSpecIndex;
   }

   public void setChangeType(final Integer changeType) {
      this.changeType = changeType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleSpecDTOParam)) {
         return false;
      }

      AssembleSpecDTOParam other = (AssembleSpecDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleConfigId = this.getAssembleConfigId();
         Object other$assembleConfigId = other.getAssembleConfigId();
         if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
            Object this$specIndex = this.getSpecIndex();
            Object other$specIndex = other.getSpecIndex();
            if (this$specIndex == null ? other$specIndex == null : this$specIndex.equals(other$specIndex)) {
               Object this$newSpecIndex = this.getNewSpecIndex();
               Object other$newSpecIndex = other.getNewSpecIndex();
               if (this$newSpecIndex == null ? other$newSpecIndex == null : this$newSpecIndex.equals(other$newSpecIndex)) {
                  Object this$changeType = this.getChangeType();
                  Object other$changeType = other.getChangeType();
                  if (this$changeType == null ? other$changeType == null : this$changeType.equals(other$changeType)) {
                     Object this$specPrefix = this.getSpecPrefix();
                     Object other$specPrefix = other.getSpecPrefix();
                     if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                        Object this$newSpecPrefix = this.getNewSpecPrefix();
                        Object other$newSpecPrefix = other.getNewSpecPrefix();
                        return this$newSpecPrefix == null ? other$newSpecPrefix == null : this$newSpecPrefix.equals(other$newSpecPrefix);
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
      return other instanceof AssembleSpecDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $specIndex = this.getSpecIndex();
      result = result * 59 + ($specIndex == null ? 43 : $specIndex.hashCode());
      Object $newSpecIndex = this.getNewSpecIndex();
      result = result * 59 + ($newSpecIndex == null ? 43 : $newSpecIndex.hashCode());
      Object $changeType = this.getChangeType();
      result = result * 59 + ($changeType == null ? 43 : $changeType.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $newSpecPrefix = this.getNewSpecPrefix();
      return result * 59 + ($newSpecPrefix == null ? 43 : $newSpecPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleSpecDTOParam(id="
         + this.getId()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", newSpecPrefix="
         + this.getNewSpecPrefix()
         + ", specIndex="
         + this.getSpecIndex()
         + ", newSpecIndex="
         + this.getNewSpecIndex()
         + ", changeType="
         + this.getChangeType()
         + ")";
   }

   public static class AssembleSpecDTOParamBuilder {
      private Long id;
      private Long assembleConfigId;
      private String specPrefix;
      private String newSpecPrefix;
      private Integer specIndex;
      private Integer newSpecIndex;
      private Integer changeType;

      AssembleSpecDTOParamBuilder() {
      }

      public AssembleSpecDTOParam.AssembleSpecDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("assembleConfigId")
      public AssembleSpecDTOParam.AssembleSpecDTOParamBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      public AssembleSpecDTOParam.AssembleSpecDTOParamBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public AssembleSpecDTOParam.AssembleSpecDTOParamBuilder newSpecPrefix(final String newSpecPrefix) {
         this.newSpecPrefix = newSpecPrefix;
         return this;
      }

      public AssembleSpecDTOParam.AssembleSpecDTOParamBuilder specIndex(final Integer specIndex) {
         this.specIndex = specIndex;
         return this;
      }

      public AssembleSpecDTOParam.AssembleSpecDTOParamBuilder newSpecIndex(final Integer newSpecIndex) {
         this.newSpecIndex = newSpecIndex;
         return this;
      }

      public AssembleSpecDTOParam.AssembleSpecDTOParamBuilder changeType(final Integer changeType) {
         this.changeType = changeType;
         return this;
      }

      public AssembleSpecDTOParam build() {
         return new AssembleSpecDTOParam(
            this.id, this.assembleConfigId, this.specPrefix, this.newSpecPrefix, this.specIndex, this.newSpecIndex, this.changeType
         );
      }

      @Override
      public String toString() {
         return "AssembleSpecDTOParam.AssembleSpecDTOParamBuilder(id="
            + this.id
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", specPrefix="
            + this.specPrefix
            + ", newSpecPrefix="
            + this.newSpecPrefix
            + ", specIndex="
            + this.specIndex
            + ", newSpecIndex="
            + this.newSpecIndex
            + ", changeType="
            + this.changeType
            + ")";
      }
   }
}
