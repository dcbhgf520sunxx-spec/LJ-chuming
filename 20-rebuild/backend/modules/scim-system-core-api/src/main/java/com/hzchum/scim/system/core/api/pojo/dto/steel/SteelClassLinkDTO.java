package com.hzchum.scim.system.core.api.pojo.dto.steel;

import io.swagger.annotations.ApiModelProperty;

public class SteelClassLinkDTO {
   @ApiModelProperty("特征id")
   private Long steelId;
   @ApiModelProperty("特征名称")
   private String steelName;
   @ApiModelProperty("物料基础类型 钢板,型材")
   private Long basicClassId;
   @ApiModelProperty("科目IDid")
   private Long classifyId;
   @ApiModelProperty("科目名")
   private String classifyName;

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSteelName() {
      return this.steelName;
   }

   public Long getBasicClassId() {
      return this.basicClassId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setSteelName(final String steelName) {
      this.steelName = steelName;
   }

   public void setBasicClassId(final Long basicClassId) {
      this.basicClassId = basicClassId;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelClassLinkDTO)) {
         return false;
      }

      SteelClassLinkDTO other = (SteelClassLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelId = this.getSteelId();
      Object other$steelId = other.getSteelId();
      if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
         Object this$basicClassId = this.getBasicClassId();
         Object other$basicClassId = other.getBasicClassId();
         if (this$basicClassId == null ? other$basicClassId == null : this$basicClassId.equals(other$basicClassId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$steelName = this.getSteelName();
               Object other$steelName = other.getSteelName();
               if (this$steelName == null ? other$steelName == null : this$steelName.equals(other$steelName)) {
                  Object this$classifyName = this.getClassifyName();
                  Object other$classifyName = other.getClassifyName();
                  return this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName);
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
      return other instanceof SteelClassLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $basicClassId = this.getBasicClassId();
      result = result * 59 + ($basicClassId == null ? 43 : $basicClassId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $steelName = this.getSteelName();
      result = result * 59 + ($steelName == null ? 43 : $steelName.hashCode());
      Object $classifyName = this.getClassifyName();
      return result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
   }

   @Override
   public String toString() {
      return "SteelClassLinkDTO(steelId="
         + this.getSteelId()
         + ", steelName="
         + this.getSteelName()
         + ", basicClassId="
         + this.getBasicClassId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ")";
   }

   public SteelClassLinkDTO(final Long steelId, final String steelName, final Long basicClassId, final Long classifyId, final String classifyName) {
      this.steelId = steelId;
      this.steelName = steelName;
      this.basicClassId = basicClassId;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
   }

   public SteelClassLinkDTO() {
   }
}
