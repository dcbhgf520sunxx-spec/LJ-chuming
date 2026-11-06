package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("构件规格修正修改VORequest类")
public class TechArtifactSpecAmendUpdateVORequest {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty("修正后构件种类表Id")
   private Long newStructureClassId;
   @NotBlank(groups = Update.class, message = "修正规格不能为空")
   @ApiModelProperty(name = "newSpecification", value = "修正规格", notes = "修正规格")
   private String newSpecification;
   @NotBlank(groups = Update.class, message = "修正规格前缀不能为空")
   @ApiModelProperty(name = "newSpecPrefix", value = "修正规格前缀", notes = "修正规格前缀")
   private String newSpecPrefix;
   @NotBlank(groups = Update.class, message = "修正后名称不能为空")
   @ApiModelProperty(name = "newName", value = "修正后名称")
   private String newName;
   @ApiModelProperty(name = "userId", value = "修正人ID", notes = "修正人ID")
   private Long userId;
   @NotNull(groups = Update.class, message = "构件审核表Id不能为空")
   @ApiModelProperty(name = "artifactRecordId", value = "构件审核表Id", notes = "构件审核表Id")
   private Long artifactRecordId;
   @ApiModelProperty(name = "plJudge", value = "判断是否需要重组", notes = "判断是否需要重组")
   private Boolean plJudge;
   @ApiModelProperty(name = "artifactId", value = "构件记录id", notes = "构件记录id")
   private Long artifactId;
   @ApiModelProperty(name = "techUnitRecordVOList", value = "部件列表", notes = "部件列表")
   private List<TechUnitRecordVO> techUnitRecordVOList;

   public Long getId() {
      return this.id;
   }

   public Long getNewStructureClassId() {
      return this.newStructureClassId;
   }

   public String getNewSpecification() {
      return this.newSpecification;
   }

   public String getNewSpecPrefix() {
      return this.newSpecPrefix;
   }

   public String getNewName() {
      return this.newName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getArtifactRecordId() {
      return this.artifactRecordId;
   }

   public Boolean getPlJudge() {
      return this.plJudge;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public List<TechUnitRecordVO> getTechUnitRecordVOList() {
      return this.techUnitRecordVOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setNewStructureClassId(final Long newStructureClassId) {
      this.newStructureClassId = newStructureClassId;
   }

   public void setNewSpecification(final String newSpecification) {
      this.newSpecification = newSpecification;
   }

   public void setNewSpecPrefix(final String newSpecPrefix) {
      this.newSpecPrefix = newSpecPrefix;
   }

   public void setNewName(final String newName) {
      this.newName = newName;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setArtifactRecordId(final Long artifactRecordId) {
      this.artifactRecordId = artifactRecordId;
   }

   public void setPlJudge(final Boolean plJudge) {
      this.plJudge = plJudge;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setTechUnitRecordVOList(final List<TechUnitRecordVO> techUnitRecordVOList) {
      this.techUnitRecordVOList = techUnitRecordVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactSpecAmendUpdateVORequest)) {
         return false;
      }

      TechArtifactSpecAmendUpdateVORequest other = (TechArtifactSpecAmendUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$newStructureClassId = this.getNewStructureClassId();
         Object other$newStructureClassId = other.getNewStructureClassId();
         if (this$newStructureClassId == null ? other$newStructureClassId == null : this$newStructureClassId.equals(other$newStructureClassId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$artifactRecordId = this.getArtifactRecordId();
               Object other$artifactRecordId = other.getArtifactRecordId();
               if (this$artifactRecordId == null ? other$artifactRecordId == null : this$artifactRecordId.equals(other$artifactRecordId)) {
                  Object this$plJudge = this.getPlJudge();
                  Object other$plJudge = other.getPlJudge();
                  if (this$plJudge == null ? other$plJudge == null : this$plJudge.equals(other$plJudge)) {
                     Object this$artifactId = this.getArtifactId();
                     Object other$artifactId = other.getArtifactId();
                     if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                        Object this$newSpecification = this.getNewSpecification();
                        Object other$newSpecification = other.getNewSpecification();
                        if (this$newSpecification == null ? other$newSpecification == null : this$newSpecification.equals(other$newSpecification)) {
                           Object this$newSpecPrefix = this.getNewSpecPrefix();
                           Object other$newSpecPrefix = other.getNewSpecPrefix();
                           if (this$newSpecPrefix == null ? other$newSpecPrefix == null : this$newSpecPrefix.equals(other$newSpecPrefix)) {
                              Object this$newName = this.getNewName();
                              Object other$newName = other.getNewName();
                              if (this$newName == null ? other$newName == null : this$newName.equals(other$newName)) {
                                 Object this$techUnitRecordVOList = this.getTechUnitRecordVOList();
                                 Object other$techUnitRecordVOList = other.getTechUnitRecordVOList();
                                 return this$techUnitRecordVOList == null
                                    ? other$techUnitRecordVOList == null
                                    : this$techUnitRecordVOList.equals(other$techUnitRecordVOList);
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
      return other instanceof TechArtifactSpecAmendUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $newStructureClassId = this.getNewStructureClassId();
      result = result * 59 + ($newStructureClassId == null ? 43 : $newStructureClassId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $artifactRecordId = this.getArtifactRecordId();
      result = result * 59 + ($artifactRecordId == null ? 43 : $artifactRecordId.hashCode());
      Object $plJudge = this.getPlJudge();
      result = result * 59 + ($plJudge == null ? 43 : $plJudge.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $newSpecification = this.getNewSpecification();
      result = result * 59 + ($newSpecification == null ? 43 : $newSpecification.hashCode());
      Object $newSpecPrefix = this.getNewSpecPrefix();
      result = result * 59 + ($newSpecPrefix == null ? 43 : $newSpecPrefix.hashCode());
      Object $newName = this.getNewName();
      result = result * 59 + ($newName == null ? 43 : $newName.hashCode());
      Object $techUnitRecordVOList = this.getTechUnitRecordVOList();
      return result * 59 + ($techUnitRecordVOList == null ? 43 : $techUnitRecordVOList.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactSpecAmendUpdateVORequest(id="
         + this.getId()
         + ", newStructureClassId="
         + this.getNewStructureClassId()
         + ", newSpecification="
         + this.getNewSpecification()
         + ", newSpecPrefix="
         + this.getNewSpecPrefix()
         + ", newName="
         + this.getNewName()
         + ", userId="
         + this.getUserId()
         + ", artifactRecordId="
         + this.getArtifactRecordId()
         + ", plJudge="
         + this.getPlJudge()
         + ", artifactId="
         + this.getArtifactId()
         + ", techUnitRecordVOList="
         + this.getTechUnitRecordVOList()
         + ")";
   }
}
