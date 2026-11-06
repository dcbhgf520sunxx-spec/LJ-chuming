package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class DeptUserTreeResponseVO {
   private Long id;
   private String label;
   private String ddUserId;
   @ApiModelProperty(name = "is_deepen", value = "开启状态 true启用 false禁用")
   private Boolean isDeepen;
   private String phone;
   private Boolean isUser;
   private List<DeptUserTreeResponseVO> children;

   public Long getId() {
      return this.id;
   }

   public String getLabel() {
      return this.label;
   }

   public String getDdUserId() {
      return this.ddUserId;
   }

   public Boolean getIsDeepen() {
      return this.isDeepen;
   }

   public String getPhone() {
      return this.phone;
   }

   public Boolean getIsUser() {
      return this.isUser;
   }

   public List<DeptUserTreeResponseVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   public void setDdUserId(final String ddUserId) {
      this.ddUserId = ddUserId;
   }

   public void setIsDeepen(final Boolean isDeepen) {
      this.isDeepen = isDeepen;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setIsUser(final Boolean isUser) {
      this.isUser = isUser;
   }

   public void setChildren(final List<DeptUserTreeResponseVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeptUserTreeResponseVO)) {
         return false;
      }

      DeptUserTreeResponseVO other = (DeptUserTreeResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$isDeepen = this.getIsDeepen();
         Object other$isDeepen = other.getIsDeepen();
         if (this$isDeepen == null ? other$isDeepen == null : this$isDeepen.equals(other$isDeepen)) {
            Object this$isUser = this.getIsUser();
            Object other$isUser = other.getIsUser();
            if (this$isUser == null ? other$isUser == null : this$isUser.equals(other$isUser)) {
               Object this$label = this.getLabel();
               Object other$label = other.getLabel();
               if (this$label == null ? other$label == null : this$label.equals(other$label)) {
                  Object this$ddUserId = this.getDdUserId();
                  Object other$ddUserId = other.getDdUserId();
                  if (this$ddUserId == null ? other$ddUserId == null : this$ddUserId.equals(other$ddUserId)) {
                     Object this$phone = this.getPhone();
                     Object other$phone = other.getPhone();
                     if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                        Object this$children = this.getChildren();
                        Object other$children = other.getChildren();
                        return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof DeptUserTreeResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isDeepen = this.getIsDeepen();
      result = result * 59 + ($isDeepen == null ? 43 : $isDeepen.hashCode());
      Object $isUser = this.getIsUser();
      result = result * 59 + ($isUser == null ? 43 : $isUser.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $ddUserId = this.getDdUserId();
      result = result * 59 + ($ddUserId == null ? 43 : $ddUserId.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "DeptUserTreeResponseVO(id="
         + this.getId()
         + ", label="
         + this.getLabel()
         + ", ddUserId="
         + this.getDdUserId()
         + ", isDeepen="
         + this.getIsDeepen()
         + ", phone="
         + this.getPhone()
         + ", isUser="
         + this.getIsUser()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
