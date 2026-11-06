package com.hzchum.scim.wms.core.api.pojo.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;

public class AttachmentDTO {
   private Long id;
   private String name;
   @JsonInclude(Include.NON_EMPTY)
   private String imageUrl;
   @JsonInclude(Include.NON_EMPTY)
   private String tinyImageUrl;
   private Long createUserId;
   private String createUserName;
   private Integer type;
   private LocalDateTime createTime;

   public static AttachmentDTO.AttachmentDTOBuilder builder() {
      return new AttachmentDTO.AttachmentDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public String getTinyImageUrl() {
      return this.tinyImageUrl;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setImageUrl(final String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public void setTinyImageUrl(final String tinyImageUrl) {
      this.tinyImageUrl = tinyImageUrl;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AttachmentDTO)) {
         return false;
      }

      AttachmentDTO other = (AttachmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$imageUrl = this.getImageUrl();
                  Object other$imageUrl = other.getImageUrl();
                  if (this$imageUrl == null ? other$imageUrl == null : this$imageUrl.equals(other$imageUrl)) {
                     Object this$tinyImageUrl = this.getTinyImageUrl();
                     Object other$tinyImageUrl = other.getTinyImageUrl();
                     if (this$tinyImageUrl == null ? other$tinyImageUrl == null : this$tinyImageUrl.equals(other$tinyImageUrl)) {
                        Object this$createUserName = this.getCreateUserName();
                        Object other$createUserName = other.getCreateUserName();
                        if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AttachmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $imageUrl = this.getImageUrl();
      result = result * 59 + ($imageUrl == null ? 43 : $imageUrl.hashCode());
      Object $tinyImageUrl = this.getTinyImageUrl();
      result = result * 59 + ($tinyImageUrl == null ? 43 : $tinyImageUrl.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "AttachmentDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", imageUrl="
         + this.getImageUrl()
         + ", tinyImageUrl="
         + this.getTinyImageUrl()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", type="
         + this.getType()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public AttachmentDTO(
      final Long id,
      final String name,
      final String imageUrl,
      final String tinyImageUrl,
      final Long createUserId,
      final String createUserName,
      final Integer type,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.name = name;
      this.imageUrl = imageUrl;
      this.tinyImageUrl = tinyImageUrl;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.type = type;
      this.createTime = createTime;
   }

   public AttachmentDTO() {
   }

   public static class AttachmentDTOBuilder {
      private Long id;
      private String name;
      private String imageUrl;
      private String tinyImageUrl;
      private Long createUserId;
      private String createUserName;
      private Integer type;
      private LocalDateTime createTime;

      AttachmentDTOBuilder() {
      }

      public AttachmentDTO.AttachmentDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AttachmentDTO.AttachmentDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AttachmentDTO.AttachmentDTOBuilder imageUrl(final String imageUrl) {
         this.imageUrl = imageUrl;
         return this;
      }

      public AttachmentDTO.AttachmentDTOBuilder tinyImageUrl(final String tinyImageUrl) {
         this.tinyImageUrl = tinyImageUrl;
         return this;
      }

      public AttachmentDTO.AttachmentDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public AttachmentDTO.AttachmentDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public AttachmentDTO.AttachmentDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public AttachmentDTO.AttachmentDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public AttachmentDTO build() {
         return new AttachmentDTO(this.id, this.name, this.imageUrl, this.tinyImageUrl, this.createUserId, this.createUserName, this.type, this.createTime);
      }

      @Override
      public String toString() {
         return "AttachmentDTO.AttachmentDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", imageUrl="
            + this.imageUrl
            + ", tinyImageUrl="
            + this.tinyImageUrl
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", type="
            + this.type
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
