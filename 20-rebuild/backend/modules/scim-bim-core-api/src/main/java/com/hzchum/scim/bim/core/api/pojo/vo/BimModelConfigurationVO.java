package com.hzchum.scim.bim.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("bim导入模式配置类VO")
public class BimModelConfigurationVO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "importMode", value = "导入模式")
   private Integer importMode;
   @ApiModelProperty(name = "edition", value = "Tekla版本")
   private Integer edition;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getImportMode() {
      return this.importMode;
   }

   public Integer getEdition() {
      return this.edition;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setImportMode(final Integer importMode) {
      this.importMode = importMode;
   }

   public void setEdition(final Integer edition) {
      this.edition = edition;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelConfigurationVO)) {
         return false;
      }

      BimModelConfigurationVO other = (BimModelConfigurationVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$importMode = this.getImportMode();
               Object other$importMode = other.getImportMode();
               if (this$importMode == null ? other$importMode == null : this$importMode.equals(other$importMode)) {
                  Object this$edition = this.getEdition();
                  Object other$edition = other.getEdition();
                  return this$edition == null ? other$edition == null : this$edition.equals(other$edition);
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
      return other instanceof BimModelConfigurationVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $importMode = this.getImportMode();
      result = result * 59 + ($importMode == null ? 43 : $importMode.hashCode());
      Object $edition = this.getEdition();
      return result * 59 + ($edition == null ? 43 : $edition.hashCode());
   }

   @Override
   public String toString() {
      return "BimModelConfigurationVO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", importMode="
         + this.getImportMode()
         + ", edition="
         + this.getEdition()
         + ")";
   }
}
