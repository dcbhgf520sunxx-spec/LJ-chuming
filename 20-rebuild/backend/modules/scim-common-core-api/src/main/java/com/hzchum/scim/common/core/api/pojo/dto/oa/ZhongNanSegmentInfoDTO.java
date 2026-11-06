package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("OA返回对象")
public class ZhongNanSegmentInfoDTO {
   @JsonProperty("分部名称")
   private String subcompanydesc;
   @JsonProperty("分部编码")
   private String subcompanycode;
   @JsonProperty("上级分部id")
   private String supsubcomid;
   @JsonProperty("分部id")
   private String id;
   @JsonProperty("分部简称")
   private String subcompanyname;

   public static ZhongNanSegmentInfoDTO.ZhongNanSegmentInfoDTOBuilder builder() {
      return new ZhongNanSegmentInfoDTO.ZhongNanSegmentInfoDTOBuilder();
   }

   public ZhongNanSegmentInfoDTO() {
   }

   public ZhongNanSegmentInfoDTO(
      final String subcompanydesc, final String subcompanycode, final String supsubcomid, final String id, final String subcompanyname
   ) {
      this.subcompanydesc = subcompanydesc;
      this.subcompanycode = subcompanycode;
      this.supsubcomid = supsubcomid;
      this.id = id;
      this.subcompanyname = subcompanyname;
   }

   public String getSubcompanydesc() {
      return this.subcompanydesc;
   }

   public String getSubcompanycode() {
      return this.subcompanycode;
   }

   public String getSupsubcomid() {
      return this.supsubcomid;
   }

   public String getId() {
      return this.id;
   }

   public String getSubcompanyname() {
      return this.subcompanyname;
   }

   @JsonProperty("分部名称")
   public ZhongNanSegmentInfoDTO setSubcompanydesc(final String subcompanydesc) {
      this.subcompanydesc = subcompanydesc;
      return this;
   }

   @JsonProperty("分部编码")
   public ZhongNanSegmentInfoDTO setSubcompanycode(final String subcompanycode) {
      this.subcompanycode = subcompanycode;
      return this;
   }

   @JsonProperty("上级分部id")
   public ZhongNanSegmentInfoDTO setSupsubcomid(final String supsubcomid) {
      this.supsubcomid = supsubcomid;
      return this;
   }

   @JsonProperty("分部id")
   public ZhongNanSegmentInfoDTO setId(final String id) {
      this.id = id;
      return this;
   }

   @JsonProperty("分部简称")
   public ZhongNanSegmentInfoDTO setSubcompanyname(final String subcompanyname) {
      this.subcompanyname = subcompanyname;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanSegmentInfoDTO)) {
         return false;
      }

      ZhongNanSegmentInfoDTO other = (ZhongNanSegmentInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$subcompanydesc = this.getSubcompanydesc();
      Object other$subcompanydesc = other.getSubcompanydesc();
      if (this$subcompanydesc == null ? other$subcompanydesc == null : this$subcompanydesc.equals(other$subcompanydesc)) {
         Object this$subcompanycode = this.getSubcompanycode();
         Object other$subcompanycode = other.getSubcompanycode();
         if (this$subcompanycode == null ? other$subcompanycode == null : this$subcompanycode.equals(other$subcompanycode)) {
            Object this$supsubcomid = this.getSupsubcomid();
            Object other$supsubcomid = other.getSupsubcomid();
            if (this$supsubcomid == null ? other$supsubcomid == null : this$supsubcomid.equals(other$supsubcomid)) {
               Object this$id = this.getId();
               Object other$id = other.getId();
               if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                  Object this$subcompanyname = this.getSubcompanyname();
                  Object other$subcompanyname = other.getSubcompanyname();
                  return this$subcompanyname == null ? other$subcompanyname == null : this$subcompanyname.equals(other$subcompanyname);
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
      return other instanceof ZhongNanSegmentInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $subcompanydesc = this.getSubcompanydesc();
      result = result * 59 + ($subcompanydesc == null ? 43 : $subcompanydesc.hashCode());
      Object $subcompanycode = this.getSubcompanycode();
      result = result * 59 + ($subcompanycode == null ? 43 : $subcompanycode.hashCode());
      Object $supsubcomid = this.getSupsubcomid();
      result = result * 59 + ($supsubcomid == null ? 43 : $supsubcomid.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $subcompanyname = this.getSubcompanyname();
      return result * 59 + ($subcompanyname == null ? 43 : $subcompanyname.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanSegmentInfoDTO(subcompanydesc="
         + this.getSubcompanydesc()
         + ", subcompanycode="
         + this.getSubcompanycode()
         + ", supsubcomid="
         + this.getSupsubcomid()
         + ", id="
         + this.getId()
         + ", subcompanyname="
         + this.getSubcompanyname()
         + ")";
   }

   public static class ZhongNanSegmentInfoDTOBuilder {
      private String subcompanydesc;
      private String subcompanycode;
      private String supsubcomid;
      private String id;
      private String subcompanyname;

      ZhongNanSegmentInfoDTOBuilder() {
      }

      @JsonProperty("分部名称")
      public ZhongNanSegmentInfoDTO.ZhongNanSegmentInfoDTOBuilder subcompanydesc(final String subcompanydesc) {
         this.subcompanydesc = subcompanydesc;
         return this;
      }

      @JsonProperty("分部编码")
      public ZhongNanSegmentInfoDTO.ZhongNanSegmentInfoDTOBuilder subcompanycode(final String subcompanycode) {
         this.subcompanycode = subcompanycode;
         return this;
      }

      @JsonProperty("上级分部id")
      public ZhongNanSegmentInfoDTO.ZhongNanSegmentInfoDTOBuilder supsubcomid(final String supsubcomid) {
         this.supsubcomid = supsubcomid;
         return this;
      }

      @JsonProperty("分部id")
      public ZhongNanSegmentInfoDTO.ZhongNanSegmentInfoDTOBuilder id(final String id) {
         this.id = id;
         return this;
      }

      @JsonProperty("分部简称")
      public ZhongNanSegmentInfoDTO.ZhongNanSegmentInfoDTOBuilder subcompanyname(final String subcompanyname) {
         this.subcompanyname = subcompanyname;
         return this;
      }

      public ZhongNanSegmentInfoDTO build() {
         return new ZhongNanSegmentInfoDTO(this.subcompanydesc, this.subcompanycode, this.supsubcomid, this.id, this.subcompanyname);
      }

      @Override
      public String toString() {
         return "ZhongNanSegmentInfoDTO.ZhongNanSegmentInfoDTOBuilder(subcompanydesc="
            + this.subcompanydesc
            + ", subcompanycode="
            + this.subcompanycode
            + ", supsubcomid="
            + this.supsubcomid
            + ", id="
            + this.id
            + ", subcompanyname="
            + this.subcompanyname
            + ")";
      }
   }
}
