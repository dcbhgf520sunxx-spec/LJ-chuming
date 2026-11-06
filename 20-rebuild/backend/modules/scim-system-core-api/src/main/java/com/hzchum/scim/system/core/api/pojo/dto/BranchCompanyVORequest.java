package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class BranchCompanyVORequest {
   private String name;
   private String socialCode;
   @Range(min = 0L, max = 1L, message = "类型错误")
   private Integer enabled;
   @NotNull(message = "页码不能为空")
   private Integer pageNumber;
   @NotNull(message = "页大小不能为空")
   private Integer pageSize;

   public String getName() {
      return this.name;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public Integer getEnabled() {
      return this.enabled;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
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

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BranchCompanyVORequest)) {
         return false;
      }

      BranchCompanyVORequest other = (BranchCompanyVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$enabled = this.getEnabled();
      Object other$enabled = other.getEnabled();
      if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
         Object this$pageNumber = this.getPageNumber();
         Object other$pageNumber = other.getPageNumber();
         if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
            Object this$pageSize = this.getPageSize();
            Object other$pageSize = other.getPageSize();
            if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BranchCompanyVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $socialCode = this.getSocialCode();
      return result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
   }

   @Override
   public String toString() {
      return "BranchCompanyVORequest(name="
         + this.getName()
         + ", socialCode="
         + this.getSocialCode()
         + ", enabled="
         + this.getEnabled()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }
}
