package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.util.List;

public class SpecConfigDTO {
   private Long id;
   private String name;
   private Boolean boolDefault;
   private Long standardId;
   private List<SpecConfigDetailDTO> list;
   private Boolean status;

   public static SpecConfigDTO.SpecConfigDTOBuilder builder() {
      return new SpecConfigDTO.SpecConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolDefault() {
      return this.boolDefault;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public List<SpecConfigDetailDTO> getList() {
      return this.list;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBoolDefault(final Boolean boolDefault) {
      this.boolDefault = boolDefault;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setList(final List<SpecConfigDetailDTO> list) {
      this.list = list;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpecConfigDTO)) {
         return false;
      }

      SpecConfigDTO other = (SpecConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolDefault = this.getBoolDefault();
         Object other$boolDefault = other.getBoolDefault();
         if (this$boolDefault == null ? other$boolDefault == null : this$boolDefault.equals(other$boolDefault)) {
            Object this$standardId = this.getStandardId();
            Object other$standardId = other.getStandardId();
            if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$list = this.getList();
                     Object other$list = other.getList();
                     return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof SpecConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolDefault = this.getBoolDefault();
      result = result * 59 + ($boolDefault == null ? 43 : $boolDefault.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "SpecConfigDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", boolDefault="
         + this.getBoolDefault()
         + ", standardId="
         + this.getStandardId()
         + ", list="
         + this.getList()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public SpecConfigDTO(
      final Long id, final String name, final Boolean boolDefault, final Long standardId, final List<SpecConfigDetailDTO> list, final Boolean status
   ) {
      this.id = id;
      this.name = name;
      this.boolDefault = boolDefault;
      this.standardId = standardId;
      this.list = list;
      this.status = status;
   }

   public SpecConfigDTO() {
   }

   public static class SpecConfigDTOBuilder {
      private Long id;
      private String name;
      private Boolean boolDefault;
      private Long standardId;
      private List<SpecConfigDetailDTO> list;
      private Boolean status;

      SpecConfigDTOBuilder() {
      }

      public SpecConfigDTO.SpecConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SpecConfigDTO.SpecConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SpecConfigDTO.SpecConfigDTOBuilder boolDefault(final Boolean boolDefault) {
         this.boolDefault = boolDefault;
         return this;
      }

      public SpecConfigDTO.SpecConfigDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public SpecConfigDTO.SpecConfigDTOBuilder list(final List<SpecConfigDetailDTO> list) {
         this.list = list;
         return this;
      }

      public SpecConfigDTO.SpecConfigDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SpecConfigDTO build() {
         return new SpecConfigDTO(this.id, this.name, this.boolDefault, this.standardId, this.list, this.status);
      }

      @Override
      public String toString() {
         return "SpecConfigDTO.SpecConfigDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", boolDefault="
            + this.boolDefault
            + ", standardId="
            + this.standardId
            + ", list="
            + this.list
            + ", status="
            + this.status
            + ")";
      }
   }
}
