package com.hzchum.scim.system.core.api.pojo.dto;

import java.io.Serializable;
import java.util.List;

public class AddressResponseVO implements Serializable {
   private static final long serialVersionUID = 1L;
   private Long id;
   private String name;
   private Long locationId;
   private String locationName;
   private List<AddressResponseVO> children;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getLocationId() {
      return this.locationId;
   }

   public String getLocationName() {
      return this.locationName;
   }

   public List<AddressResponseVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setLocationId(final Long locationId) {
      this.locationId = locationId;
   }

   public void setLocationName(final String locationName) {
      this.locationName = locationName;
   }

   public void setChildren(final List<AddressResponseVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddressResponseVO)) {
         return false;
      }

      AddressResponseVO other = (AddressResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$locationId = this.getLocationId();
         Object other$locationId = other.getLocationId();
         if (this$locationId == null ? other$locationId == null : this$locationId.equals(other$locationId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$locationName = this.getLocationName();
               Object other$locationName = other.getLocationName();
               if (this$locationName == null ? other$locationName == null : this$locationName.equals(other$locationName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AddressResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $locationId = this.getLocationId();
      result = result * 59 + ($locationId == null ? 43 : $locationId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $locationName = this.getLocationName();
      result = result * 59 + ($locationName == null ? 43 : $locationName.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "AddressResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", locationId="
         + this.getLocationId()
         + ", locationName="
         + this.getLocationName()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
