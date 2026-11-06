package com.hzchum.scim.plan.core.api.pojo.dtoParam.change;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.ChangeScopeEnum;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactBasicChangeDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("构件变更请求类")
public class TechChangeSaveDtoParam {
   @EnumValidator(value = ChangeScopeEnum.class, message = "变更范围有误!")
   @ApiModelProperty("变更范围:1区域 2单体 4批次")
   private Integer changeScopeEnum;
   @ApiModelProperty("单体id")
   @NotNull(message = "单体id不能为空!!!")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("批次Id")
   private Long areaBatchId;
   @NotNull(message = "变更原因不能为空!")
   @ApiModelProperty("变更原因id")
   private Long changeReasonId;
   @ApiModelProperty("变更文件附件ID列表")
   private List<Long> attachmentIds;
   @ApiModelProperty("描述")
   @Size(max = 255, message = "描述超出字数限制!")
   private String remark;
   @ApiModelProperty("导入的变更清单缓存key")
   private String redisKey;
   @Valid
   @ApiModelProperty(name = "artifactBasicChangeDTOParam", value = "构件基础信息变更列表")
   private ArtifactBasicChangeDTOParam artifactBasicChangeDTOParam;
   @Valid
   @ApiModelProperty(name = "updateArtifactList", value = "变更修改构件列表")
   private List<TechChangeArtifactUpdateDtoParam> updateArtifactList;
   @Valid
   @ApiModelProperty(name = "delArtifactList", value = "变更删除构件列表")
   private List<TechChangeArtifactDelDtoParam> delArtifactList;

   public static TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder builder() {
      return new TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder();
   }

   public TechChangeSaveDtoParam(
      final Integer changeScopeEnum,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long changeReasonId,
      final List<Long> attachmentIds,
      final String remark,
      final String redisKey,
      final ArtifactBasicChangeDTOParam artifactBasicChangeDTOParam,
      final List<TechChangeArtifactUpdateDtoParam> updateArtifactList,
      final List<TechChangeArtifactDelDtoParam> delArtifactList
   ) {
      this.changeScopeEnum = changeScopeEnum;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.changeReasonId = changeReasonId;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.redisKey = redisKey;
      this.artifactBasicChangeDTOParam = artifactBasicChangeDTOParam;
      this.updateArtifactList = updateArtifactList;
      this.delArtifactList = delArtifactList;
   }

   public TechChangeSaveDtoParam() {
   }

   public Integer getChangeScopeEnum() {
      return this.changeScopeEnum;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getChangeReasonId() {
      return this.changeReasonId;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getRedisKey() {
      return this.redisKey;
   }

   public ArtifactBasicChangeDTOParam getArtifactBasicChangeDTOParam() {
      return this.artifactBasicChangeDTOParam;
   }

   public List<TechChangeArtifactUpdateDtoParam> getUpdateArtifactList() {
      return this.updateArtifactList;
   }

   public List<TechChangeArtifactDelDtoParam> getDelArtifactList() {
      return this.delArtifactList;
   }

   public void setChangeScopeEnum(final Integer changeScopeEnum) {
      this.changeScopeEnum = changeScopeEnum;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setChangeReasonId(final Long changeReasonId) {
      this.changeReasonId = changeReasonId;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setRedisKey(final String redisKey) {
      this.redisKey = redisKey;
   }

   public void setArtifactBasicChangeDTOParam(final ArtifactBasicChangeDTOParam artifactBasicChangeDTOParam) {
      this.artifactBasicChangeDTOParam = artifactBasicChangeDTOParam;
   }

   public void setUpdateArtifactList(final List<TechChangeArtifactUpdateDtoParam> updateArtifactList) {
      this.updateArtifactList = updateArtifactList;
   }

   public void setDelArtifactList(final List<TechChangeArtifactDelDtoParam> delArtifactList) {
      this.delArtifactList = delArtifactList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeSaveDtoParam)) {
         return false;
      }

      TechChangeSaveDtoParam other = (TechChangeSaveDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$changeScopeEnum = this.getChangeScopeEnum();
      Object other$changeScopeEnum = other.getChangeScopeEnum();
      if (this$changeScopeEnum == null ? other$changeScopeEnum == null : this$changeScopeEnum.equals(other$changeScopeEnum)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$changeReasonId = this.getChangeReasonId();
                  Object other$changeReasonId = other.getChangeReasonId();
                  if (this$changeReasonId == null ? other$changeReasonId == null : this$changeReasonId.equals(other$changeReasonId)) {
                     Object this$attachmentIds = this.getAttachmentIds();
                     Object other$attachmentIds = other.getAttachmentIds();
                     if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                           Object this$redisKey = this.getRedisKey();
                           Object other$redisKey = other.getRedisKey();
                           if (this$redisKey == null ? other$redisKey == null : this$redisKey.equals(other$redisKey)) {
                              Object this$artifactBasicChangeDTOParam = this.getArtifactBasicChangeDTOParam();
                              Object other$artifactBasicChangeDTOParam = other.getArtifactBasicChangeDTOParam();
                              if (this$artifactBasicChangeDTOParam == null
                                 ? other$artifactBasicChangeDTOParam == null
                                 : this$artifactBasicChangeDTOParam.equals(other$artifactBasicChangeDTOParam)) {
                                 Object this$updateArtifactList = this.getUpdateArtifactList();
                                 Object other$updateArtifactList = other.getUpdateArtifactList();
                                 if (this$updateArtifactList == null
                                    ? other$updateArtifactList == null
                                    : this$updateArtifactList.equals(other$updateArtifactList)) {
                                    Object this$delArtifactList = this.getDelArtifactList();
                                    Object other$delArtifactList = other.getDelArtifactList();
                                    return this$delArtifactList == null ? other$delArtifactList == null : this$delArtifactList.equals(other$delArtifactList);
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
      return other instanceof TechChangeSaveDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $changeScopeEnum = this.getChangeScopeEnum();
      result = result * 59 + ($changeScopeEnum == null ? 43 : $changeScopeEnum.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $changeReasonId = this.getChangeReasonId();
      result = result * 59 + ($changeReasonId == null ? 43 : $changeReasonId.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $redisKey = this.getRedisKey();
      result = result * 59 + ($redisKey == null ? 43 : $redisKey.hashCode());
      Object $artifactBasicChangeDTOParam = this.getArtifactBasicChangeDTOParam();
      result = result * 59 + ($artifactBasicChangeDTOParam == null ? 43 : $artifactBasicChangeDTOParam.hashCode());
      Object $updateArtifactList = this.getUpdateArtifactList();
      result = result * 59 + ($updateArtifactList == null ? 43 : $updateArtifactList.hashCode());
      Object $delArtifactList = this.getDelArtifactList();
      return result * 59 + ($delArtifactList == null ? 43 : $delArtifactList.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeSaveDtoParam(changeScopeEnum="
         + this.getChangeScopeEnum()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", changeReasonId="
         + this.getChangeReasonId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", redisKey="
         + this.getRedisKey()
         + ", artifactBasicChangeDTOParam="
         + this.getArtifactBasicChangeDTOParam()
         + ", updateArtifactList="
         + this.getUpdateArtifactList()
         + ", delArtifactList="
         + this.getDelArtifactList()
         + ")";
   }

   public static class TechChangeSaveDtoParamBuilder {
      private Integer changeScopeEnum;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long changeReasonId;
      private List<Long> attachmentIds;
      private String remark;
      private String redisKey;
      private ArtifactBasicChangeDTOParam artifactBasicChangeDTOParam;
      private List<TechChangeArtifactUpdateDtoParam> updateArtifactList;
      private List<TechChangeArtifactDelDtoParam> delArtifactList;

      TechChangeSaveDtoParamBuilder() {
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder changeScopeEnum(final Integer changeScopeEnum) {
         this.changeScopeEnum = changeScopeEnum;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder changeReasonId(final Long changeReasonId) {
         this.changeReasonId = changeReasonId;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder redisKey(final String redisKey) {
         this.redisKey = redisKey;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder artifactBasicChangeDTOParam(final ArtifactBasicChangeDTOParam artifactBasicChangeDTOParam) {
         this.artifactBasicChangeDTOParam = artifactBasicChangeDTOParam;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder updateArtifactList(final List<TechChangeArtifactUpdateDtoParam> updateArtifactList) {
         this.updateArtifactList = updateArtifactList;
         return this;
      }

      public TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder delArtifactList(final List<TechChangeArtifactDelDtoParam> delArtifactList) {
         this.delArtifactList = delArtifactList;
         return this;
      }

      public TechChangeSaveDtoParam build() {
         return new TechChangeSaveDtoParam(
            this.changeScopeEnum,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.changeReasonId,
            this.attachmentIds,
            this.remark,
            this.redisKey,
            this.artifactBasicChangeDTOParam,
            this.updateArtifactList,
            this.delArtifactList
         );
      }

      @Override
      public String toString() {
         return "TechChangeSaveDtoParam.TechChangeSaveDtoParamBuilder(changeScopeEnum="
            + this.changeScopeEnum
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", changeReasonId="
            + this.changeReasonId
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", redisKey="
            + this.redisKey
            + ", artifactBasicChangeDTOParam="
            + this.artifactBasicChangeDTOParam
            + ", updateArtifactList="
            + this.updateArtifactList
            + ", delArtifactList="
            + this.delArtifactList
            + ")";
      }
   }
}
