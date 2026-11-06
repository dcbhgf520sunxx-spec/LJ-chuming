package com.hzchum.scim.plan.core.api.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("待确认部件相关信息")
public class TechUnitRecordBaseVO {
   @ApiModelProperty(name = "artifactId", value = "构件待审核Id")
   @JsonProperty("artifactId")
   @JSONField(name = "artifactId")
   @NotNull(message = "构件待审核Id不能为空")
   private Long artifactId;
   @ApiModelProperty(name = "assembleSpecification", value = "部件规格(如果有多个,默认取第一个)")
   @JsonProperty("assembleSpecification")
   @JSONField(name = "assembleSpecification")
   @NotBlank(message = "部件规格不能为空")
   private String assembleSpecification;
   @ApiModelProperty(name = "assembleSpecPrefix", value = "部件规格前缀(如果有多个,默认取第一个)")
   @JsonProperty("assembleSpecPrefix")
   @JSONField(name = "assembleSpecPrefix")
   @NotBlank(message = "部件规格前缀不能为空")
   private String assembleSpecPrefix;
   @ApiModelProperty(name = "artifactStructureClassId", value = "构件特征定义Id")
   @JsonProperty("artifactStructureClassId")
   @JSONField(name = "artifactStructureClassId")
   @NotNull(message = "构件特征定义不能为空")
   private Long artifactStructureClassId;
   @ApiModelProperty(name = "artifactSpecPrefix", value = "构件规格前缀")
   @JsonProperty("artifactSpecPrefix")
   @JSONField(name = "artifactSpecPrefix")
   @NotBlank(message = "构件规格前缀不能为空")
   private String artifactSpecPrefix;
   @ApiModelProperty(name = "unitRecordVOList", value = "待确认明细列表")
   @NotEmpty(message = "确认的部件(组立)明细不可为空!")
   private List<TechUnitRecordVO> unitRecordVOList;

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getAssembleSpecification() {
      return this.assembleSpecification;
   }

   public String getAssembleSpecPrefix() {
      return this.assembleSpecPrefix;
   }

   public Long getArtifactStructureClassId() {
      return this.artifactStructureClassId;
   }

   public String getArtifactSpecPrefix() {
      return this.artifactSpecPrefix;
   }

   public List<TechUnitRecordVO> getUnitRecordVOList() {
      return this.unitRecordVOList;
   }

   @JsonProperty("artifactId")
   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   @JsonProperty("assembleSpecification")
   public void setAssembleSpecification(final String assembleSpecification) {
      this.assembleSpecification = assembleSpecification;
   }

   @JsonProperty("assembleSpecPrefix")
   public void setAssembleSpecPrefix(final String assembleSpecPrefix) {
      this.assembleSpecPrefix = assembleSpecPrefix;
   }

   @JsonProperty("artifactStructureClassId")
   public void setArtifactStructureClassId(final Long artifactStructureClassId) {
      this.artifactStructureClassId = artifactStructureClassId;
   }

   @JsonProperty("artifactSpecPrefix")
   public void setArtifactSpecPrefix(final String artifactSpecPrefix) {
      this.artifactSpecPrefix = artifactSpecPrefix;
   }

   public void setUnitRecordVOList(final List<TechUnitRecordVO> unitRecordVOList) {
      this.unitRecordVOList = unitRecordVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechUnitRecordBaseVO)) {
         return false;
      }

      TechUnitRecordBaseVO other = (TechUnitRecordBaseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$artifactStructureClassId = this.getArtifactStructureClassId();
         Object other$artifactStructureClassId = other.getArtifactStructureClassId();
         if (this$artifactStructureClassId == null
            ? other$artifactStructureClassId == null
            : this$artifactStructureClassId.equals(other$artifactStructureClassId)) {
            Object this$assembleSpecification = this.getAssembleSpecification();
            Object other$assembleSpecification = other.getAssembleSpecification();
            if (this$assembleSpecification == null ? other$assembleSpecification == null : this$assembleSpecification.equals(other$assembleSpecification)) {
               Object this$assembleSpecPrefix = this.getAssembleSpecPrefix();
               Object other$assembleSpecPrefix = other.getAssembleSpecPrefix();
               if (this$assembleSpecPrefix == null ? other$assembleSpecPrefix == null : this$assembleSpecPrefix.equals(other$assembleSpecPrefix)) {
                  Object this$artifactSpecPrefix = this.getArtifactSpecPrefix();
                  Object other$artifactSpecPrefix = other.getArtifactSpecPrefix();
                  if (this$artifactSpecPrefix == null ? other$artifactSpecPrefix == null : this$artifactSpecPrefix.equals(other$artifactSpecPrefix)) {
                     Object this$unitRecordVOList = this.getUnitRecordVOList();
                     Object other$unitRecordVOList = other.getUnitRecordVOList();
                     return this$unitRecordVOList == null ? other$unitRecordVOList == null : this$unitRecordVOList.equals(other$unitRecordVOList);
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
      return other instanceof TechUnitRecordBaseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $artifactStructureClassId = this.getArtifactStructureClassId();
      result = result * 59 + ($artifactStructureClassId == null ? 43 : $artifactStructureClassId.hashCode());
      Object $assembleSpecification = this.getAssembleSpecification();
      result = result * 59 + ($assembleSpecification == null ? 43 : $assembleSpecification.hashCode());
      Object $assembleSpecPrefix = this.getAssembleSpecPrefix();
      result = result * 59 + ($assembleSpecPrefix == null ? 43 : $assembleSpecPrefix.hashCode());
      Object $artifactSpecPrefix = this.getArtifactSpecPrefix();
      result = result * 59 + ($artifactSpecPrefix == null ? 43 : $artifactSpecPrefix.hashCode());
      Object $unitRecordVOList = this.getUnitRecordVOList();
      return result * 59 + ($unitRecordVOList == null ? 43 : $unitRecordVOList.hashCode());
   }

   @Override
   public String toString() {
      return "TechUnitRecordBaseVO(artifactId="
         + this.getArtifactId()
         + ", assembleSpecification="
         + this.getAssembleSpecification()
         + ", assembleSpecPrefix="
         + this.getAssembleSpecPrefix()
         + ", artifactStructureClassId="
         + this.getArtifactStructureClassId()
         + ", artifactSpecPrefix="
         + this.getArtifactSpecPrefix()
         + ", unitRecordVOList="
         + this.getUnitRecordVOList()
         + ")";
   }
}
