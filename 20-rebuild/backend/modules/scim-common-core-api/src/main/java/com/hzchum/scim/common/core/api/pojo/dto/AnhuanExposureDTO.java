package com.hzchum.scim.common.core.api.pojo.dto;

import java.util.List;

public class AnhuanExposureDTO {
   private String date;
   private List<AttachmentDTO> images;

   public String getDate() {
      return this.date;
   }

   public List<AttachmentDTO> getImages() {
      return this.images;
   }

   public void setDate(final String date) {
      this.date = date;
   }

   public void setImages(final List<AttachmentDTO> images) {
      this.images = images;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AnhuanExposureDTO)) {
         return false;
      } else {
         AnhuanExposureDTO other = (AnhuanExposureDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$images = this.getImages();
               Object other$images = other.getImages();
               return this$images == null ? other$images == null : this$images.equals(other$images);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AnhuanExposureDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $images = this.getImages();
      return result * 59 + ($images == null ? 43 : $images.hashCode());
   }

   @Override
   public String toString() {
      return "AnhuanExposureDTO(date=" + this.getDate() + ", images=" + this.getImages() + ")";
   }
}
