package com.hzchum.scim.system.core.api.pojo.dto;

public class BranchCompanyConditionVO {
   private String name;
   private String socialCode;
   private Integer enabled;
   private Integer level;

   BranchCompanyConditionVO(final String name, final String socialCode, final Integer enabled, final Integer level) {
      this.name = name;
      this.socialCode = socialCode;
      this.enabled = enabled;
      this.level = level;
   }

   public static BranchCompanyConditionVO.BranchCompanyConditionVOBuilder builder() {
      return new BranchCompanyConditionVO.BranchCompanyConditionVOBuilder();
   }

   public String getName() {
      return this.name;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public Integer getEnabled() {
      return this.enabled;
   }

   public Integer getLevel() {
      return this.level;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setEnabled(final Integer enabled) {
      this.enabled = enabled;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BranchCompanyConditionVO)) {
         return false;
      }

      BranchCompanyConditionVO other = (BranchCompanyConditionVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$enabled = this.getEnabled();
      Object other$enabled = other.getEnabled();
      if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
         Object this$level = this.getLevel();
         Object other$level = other.getLevel();
         if (this$level == null ? other$level == null : this$level.equals(other$level)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$socialCode = this.getSocialCode();
               Object other$socialCode = other.getSocialCode();
               return this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode);
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
      return other instanceof BranchCompanyConditionVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $socialCode = this.getSocialCode();
      return result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
   }

   @Override
   public String toString() {
      return "BranchCompanyConditionVO(name="
         + this.getName()
         + ", socialCode="
         + this.getSocialCode()
         + ", enabled="
         + this.getEnabled()
         + ", level="
         + this.getLevel()
         + ")";
   }

   public static class BranchCompanyConditionVOBuilder {
      private String name;
      private String socialCode;
      private Integer enabled;
      private Integer level;

      BranchCompanyConditionVOBuilder() {
      }

      public BranchCompanyConditionVO.BranchCompanyConditionVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BranchCompanyConditionVO.BranchCompanyConditionVOBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      public BranchCompanyConditionVO.BranchCompanyConditionVOBuilder enabled(final Integer enabled) {
         this.enabled = enabled;
         return this;
      }

      public BranchCompanyConditionVO.BranchCompanyConditionVOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public BranchCompanyConditionVO build() {
         return new BranchCompanyConditionVO(this.name, this.socialCode, this.enabled, this.level);
      }

      @Override
      public String toString() {
         return "BranchCompanyConditionVO.BranchCompanyConditionVOBuilder(name="
            + this.name
            + ", socialCode="
            + this.socialCode
            + ", enabled="
            + this.enabled
            + ", level="
            + this.level
            + ")";
      }
   }
}
