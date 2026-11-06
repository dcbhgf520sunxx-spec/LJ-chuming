package com.hzchum.scim.system.core.api.pojo.dto.steel;

import io.swagger.annotations.ApiModelProperty;

public class SteelClassifyLinkDTO {
   @ApiModelProperty("科目id")
   private Long classifyId;
   @ApiModelProperty("科目名称")
   private String classifyName;
   @ApiModelProperty("科目路径")
   private String path;

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getPath() {
      return this.path;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelClassifyLinkDTO)) {
         return false;
      }

      SteelClassifyLinkDTO other = (SteelClassifyLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$classifyName = this.getClassifyName();
         Object other$classifyName = other.getClassifyName();
         if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
            Object this$path = this.getPath();
            Object other$path = other.getPath();
            return this$path == null ? other$path == null : this$path.equals(other$path);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelClassifyLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   @Override
   public String toString() {
      return "SteelClassifyLinkDTO(classifyId=" + this.getClassifyId() + ", classifyName=" + this.getClassifyName() + ", path=" + this.getPath() + ")";
   }
}
