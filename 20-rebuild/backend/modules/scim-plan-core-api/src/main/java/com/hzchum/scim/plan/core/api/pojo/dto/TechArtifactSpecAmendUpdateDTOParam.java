package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TechArtifactSpecAmend对象", description = "构件规格修正表 ")
public class TechArtifactSpecAmendUpdateDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "规格修正记录ID不能为空")
   private Long id;
   @ApiModelProperty(name = "newSpecPrefix", value = "修正规格前缀", notes = "修正规格前缀")
   @NotBlank(message = "修正规格前缀不能为空")
   private String newSpecPrefix;
   @ApiModelProperty(name = "newSpecSection", value = "修正规格截面参数", notes = "修正规格截面参数")
   @NotBlank(message = "修正规格截面不能为空")
   private String newSpecSection;

   public static TechArtifactSpecAmendUpdateDTOParam.TechArtifactSpecAmendUpdateDTOParamBuilder builder() {
      return new TechArtifactSpecAmendUpdateDTOParam.TechArtifactSpecAmendUpdateDTOParamBuilder();
   }

   public TechArtifactSpecAmendUpdateDTOParam() {
   }

   public TechArtifactSpecAmendUpdateDTOParam(final Long id, final String newSpecPrefix, final String newSpecSection) {
      this.id = id;
      this.newSpecPrefix = newSpecPrefix;
      this.newSpecSection = newSpecSection;
   }

   public Long getId() {
      return this.id;
   }

   public String getNewSpecPrefix() {
      return this.newSpecPrefix;
   }

   public String getNewSpecSection() {
      return this.newSpecSection;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setNewSpecPrefix(final String newSpecPrefix) {
      this.newSpecPrefix = newSpecPrefix;
   }

   public void setNewSpecSection(final String newSpecSection) {
      this.newSpecSection = newSpecSection;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactSpecAmendUpdateDTOParam)) {
         return false;
      }

      TechArtifactSpecAmendUpdateDTOParam other = (TechArtifactSpecAmendUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$newSpecPrefix = this.getNewSpecPrefix();
         Object other$newSpecPrefix = other.getNewSpecPrefix();
         if (this$newSpecPrefix == null ? other$newSpecPrefix == null : this$newSpecPrefix.equals(other$newSpecPrefix)) {
            Object this$newSpecSection = this.getNewSpecSection();
            Object other$newSpecSection = other.getNewSpecSection();
            return this$newSpecSection == null ? other$newSpecSection == null : this$newSpecSection.equals(other$newSpecSection);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactSpecAmendUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $newSpecPrefix = this.getNewSpecPrefix();
      result = result * 59 + ($newSpecPrefix == null ? 43 : $newSpecPrefix.hashCode());
      Object $newSpecSection = this.getNewSpecSection();
      return result * 59 + ($newSpecSection == null ? 43 : $newSpecSection.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactSpecAmendUpdateDTOParam(id="
         + this.getId()
         + ", newSpecPrefix="
         + this.getNewSpecPrefix()
         + ", newSpecSection="
         + this.getNewSpecSection()
         + ")";
   }

   public static class TechArtifactSpecAmendUpdateDTOParamBuilder {
      private Long id;
      private String newSpecPrefix;
      private String newSpecSection;

      TechArtifactSpecAmendUpdateDTOParamBuilder() {
      }

      public TechArtifactSpecAmendUpdateDTOParam.TechArtifactSpecAmendUpdateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactSpecAmendUpdateDTOParam.TechArtifactSpecAmendUpdateDTOParamBuilder newSpecPrefix(final String newSpecPrefix) {
         this.newSpecPrefix = newSpecPrefix;
         return this;
      }

      public TechArtifactSpecAmendUpdateDTOParam.TechArtifactSpecAmendUpdateDTOParamBuilder newSpecSection(final String newSpecSection) {
         this.newSpecSection = newSpecSection;
         return this;
      }

      public TechArtifactSpecAmendUpdateDTOParam build() {
         return new TechArtifactSpecAmendUpdateDTOParam(this.id, this.newSpecPrefix, this.newSpecSection);
      }

      @Override
      public String toString() {
         return "TechArtifactSpecAmendUpdateDTOParam.TechArtifactSpecAmendUpdateDTOParamBuilder(id="
            + this.id
            + ", newSpecPrefix="
            + this.newSpecPrefix
            + ", newSpecSection="
            + this.newSpecSection
            + ")";
      }
   }
}
