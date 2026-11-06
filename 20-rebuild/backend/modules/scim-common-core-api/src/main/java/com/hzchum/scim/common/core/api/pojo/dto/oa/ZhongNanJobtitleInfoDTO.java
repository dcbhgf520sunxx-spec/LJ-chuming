package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("OA返回对象")
public class ZhongNanJobtitleInfoDTO {
   @JsonProperty("岗位id")
   private String id;
   @JsonProperty("岗位名称")
   private String jobtitlename;

   public static ZhongNanJobtitleInfoDTO.ZhongNanJobtitleInfoDTOBuilder builder() {
      return new ZhongNanJobtitleInfoDTO.ZhongNanJobtitleInfoDTOBuilder();
   }

   public ZhongNanJobtitleInfoDTO() {
   }

   public ZhongNanJobtitleInfoDTO(final String id, final String jobtitlename) {
      this.id = id;
      this.jobtitlename = jobtitlename;
   }

   public String getId() {
      return this.id;
   }

   public String getJobtitlename() {
      return this.jobtitlename;
   }

   @JsonProperty("岗位id")
   public ZhongNanJobtitleInfoDTO setId(final String id) {
      this.id = id;
      return this;
   }

   @JsonProperty("岗位名称")
   public ZhongNanJobtitleInfoDTO setJobtitlename(final String jobtitlename) {
      this.jobtitlename = jobtitlename;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ZhongNanJobtitleInfoDTO)) {
         return false;
      } else {
         ZhongNanJobtitleInfoDTO other = (ZhongNanJobtitleInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$jobtitlename = this.getJobtitlename();
               Object other$jobtitlename = other.getJobtitlename();
               return this$jobtitlename == null ? other$jobtitlename == null : this$jobtitlename.equals(other$jobtitlename);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ZhongNanJobtitleInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $jobtitlename = this.getJobtitlename();
      return result * 59 + ($jobtitlename == null ? 43 : $jobtitlename.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanJobtitleInfoDTO(id=" + this.getId() + ", jobtitlename=" + this.getJobtitlename() + ")";
   }

   public static class ZhongNanJobtitleInfoDTOBuilder {
      private String id;
      private String jobtitlename;

      ZhongNanJobtitleInfoDTOBuilder() {
      }

      @JsonProperty("岗位id")
      public ZhongNanJobtitleInfoDTO.ZhongNanJobtitleInfoDTOBuilder id(final String id) {
         this.id = id;
         return this;
      }

      @JsonProperty("岗位名称")
      public ZhongNanJobtitleInfoDTO.ZhongNanJobtitleInfoDTOBuilder jobtitlename(final String jobtitlename) {
         this.jobtitlename = jobtitlename;
         return this;
      }

      public ZhongNanJobtitleInfoDTO build() {
         return new ZhongNanJobtitleInfoDTO(this.id, this.jobtitlename);
      }

      @Override
      public String toString() {
         return "ZhongNanJobtitleInfoDTO.ZhongNanJobtitleInfoDTOBuilder(id=" + this.id + ", jobtitlename=" + this.jobtitlename + ")";
      }
   }
}
