package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("涂涂装工艺构件类型DTO类")
public class MesCoatingProcessArtifactTypeDTO {
   @ApiModelProperty(name = "artifactTypeId", value = "构件类型ID", notes = "构件类型ID")
   private Long artifactTypeId;
   @ApiModelProperty(name = "artifactTypeName", value = "构件类型名称", notes = "构件类型名称")
   private String artifactTypeName;
   @ApiModelProperty(name = "listQuantity", value = "清单数量", notes = "清单数量")
   private Integer listQuantity;
   @ApiModelProperty(name = "associatedQuantity", value = "已关联数量", notes = "已关联数量")
   private Integer associatedQuantity;
   @ApiModelProperty(name = "operableQuantity", value = "可操作数量", notes = "可操作数量")
   private Integer operableQuantity;

   public Long getArtifactTypeId() {
      return this.artifactTypeId;
   }

   public String getArtifactTypeName() {
      return this.artifactTypeName;
   }

   public Integer getListQuantity() {
      return this.listQuantity;
   }

   public Integer getAssociatedQuantity() {
      return this.associatedQuantity;
   }

   public Integer getOperableQuantity() {
      return this.operableQuantity;
   }

   public void setArtifactTypeId(final Long artifactTypeId) {
      this.artifactTypeId = artifactTypeId;
   }

   public void setArtifactTypeName(final String artifactTypeName) {
      this.artifactTypeName = artifactTypeName;
   }

   public void setListQuantity(final Integer listQuantity) {
      this.listQuantity = listQuantity;
   }

   public void setAssociatedQuantity(final Integer associatedQuantity) {
      this.associatedQuantity = associatedQuantity;
   }

   public void setOperableQuantity(final Integer operableQuantity) {
      this.operableQuantity = operableQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingProcessArtifactTypeDTO)) {
         return false;
      }

      MesCoatingProcessArtifactTypeDTO other = (MesCoatingProcessArtifactTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactTypeId = this.getArtifactTypeId();
      Object other$artifactTypeId = other.getArtifactTypeId();
      if (this$artifactTypeId == null ? other$artifactTypeId == null : this$artifactTypeId.equals(other$artifactTypeId)) {
         Object this$listQuantity = this.getListQuantity();
         Object other$listQuantity = other.getListQuantity();
         if (this$listQuantity == null ? other$listQuantity == null : this$listQuantity.equals(other$listQuantity)) {
            Object this$associatedQuantity = this.getAssociatedQuantity();
            Object other$associatedQuantity = other.getAssociatedQuantity();
            if (this$associatedQuantity == null ? other$associatedQuantity == null : this$associatedQuantity.equals(other$associatedQuantity)) {
               Object this$operableQuantity = this.getOperableQuantity();
               Object other$operableQuantity = other.getOperableQuantity();
               if (this$operableQuantity == null ? other$operableQuantity == null : this$operableQuantity.equals(other$operableQuantity)) {
                  Object this$artifactTypeName = this.getArtifactTypeName();
                  Object other$artifactTypeName = other.getArtifactTypeName();
                  return this$artifactTypeName == null ? other$artifactTypeName == null : this$artifactTypeName.equals(other$artifactTypeName);
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
      return other instanceof MesCoatingProcessArtifactTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactTypeId = this.getArtifactTypeId();
      result = result * 59 + ($artifactTypeId == null ? 43 : $artifactTypeId.hashCode());
      Object $listQuantity = this.getListQuantity();
      result = result * 59 + ($listQuantity == null ? 43 : $listQuantity.hashCode());
      Object $associatedQuantity = this.getAssociatedQuantity();
      result = result * 59 + ($associatedQuantity == null ? 43 : $associatedQuantity.hashCode());
      Object $operableQuantity = this.getOperableQuantity();
      result = result * 59 + ($operableQuantity == null ? 43 : $operableQuantity.hashCode());
      Object $artifactTypeName = this.getArtifactTypeName();
      return result * 59 + ($artifactTypeName == null ? 43 : $artifactTypeName.hashCode());
   }

   @Override
   public String toString() {
      return "MesCoatingProcessArtifactTypeDTO(artifactTypeId="
         + this.getArtifactTypeId()
         + ", artifactTypeName="
         + this.getArtifactTypeName()
         + ", listQuantity="
         + this.getListQuantity()
         + ", associatedQuantity="
         + this.getAssociatedQuantity()
         + ", operableQuantity="
         + this.getOperableQuantity()
         + ")";
   }
}
