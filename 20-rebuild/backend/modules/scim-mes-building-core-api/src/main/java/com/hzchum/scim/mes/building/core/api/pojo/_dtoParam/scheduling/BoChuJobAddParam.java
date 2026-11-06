package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "BoChuJobAddParam", description = "柏楚作业添加接口参数")
public class BoChuJobAddParam {
   private Integer parent_id;
   private String title;
   private Integer type;
   private Integer read_only = 0;

   public static BoChuJobAddParam.BoChuJobAddParamBuilder builder() {
      return new BoChuJobAddParam.BoChuJobAddParamBuilder();
   }

   public BoChuJobAddParam(final Integer parent_id, final String title, final Integer type, final Integer read_only) {
      this.parent_id = parent_id;
      this.title = title;
      this.type = type;
      this.read_only = read_only;
   }

   public BoChuJobAddParam() {
   }

   public Integer getParent_id() {
      return this.parent_id;
   }

   public String getTitle() {
      return this.title;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getRead_only() {
      return this.read_only;
   }

   public BoChuJobAddParam setParent_id(final Integer parent_id) {
      this.parent_id = parent_id;
      return this;
   }

   public BoChuJobAddParam setTitle(final String title) {
      this.title = title;
      return this;
   }

   public BoChuJobAddParam setType(final Integer type) {
      this.type = type;
      return this;
   }

   public BoChuJobAddParam setRead_only(final Integer read_only) {
      this.read_only = read_only;
      return this;
   }

   @Override
   public String toString() {
      return "BoChuJobAddParam(parent_id="
         + this.getParent_id()
         + ", title="
         + this.getTitle()
         + ", type="
         + this.getType()
         + ", read_only="
         + this.getRead_only()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuJobAddParam)) {
         return false;
      }

      BoChuJobAddParam other = (BoChuJobAddParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$parent_id = this.getParent_id();
      Object other$parent_id = other.getParent_id();
      if (this$parent_id == null ? other$parent_id == null : this$parent_id.equals(other$parent_id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$read_only = this.getRead_only();
            Object other$read_only = other.getRead_only();
            if (this$read_only == null ? other$read_only == null : this$read_only.equals(other$read_only)) {
               Object this$title = this.getTitle();
               Object other$title = other.getTitle();
               return this$title == null ? other$title == null : this$title.equals(other$title);
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
      return other instanceof BoChuJobAddParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $parent_id = this.getParent_id();
      result = result * 59 + ($parent_id == null ? 43 : $parent_id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $read_only = this.getRead_only();
      result = result * 59 + ($read_only == null ? 43 : $read_only.hashCode());
      Object $title = this.getTitle();
      return result * 59 + ($title == null ? 43 : $title.hashCode());
   }

   public static class BoChuJobAddParamBuilder {
      private Integer parent_id;
      private String title;
      private Integer type;
      private Integer read_only;

      BoChuJobAddParamBuilder() {
      }

      public BoChuJobAddParam.BoChuJobAddParamBuilder parent_id(final Integer parent_id) {
         this.parent_id = parent_id;
         return this;
      }

      public BoChuJobAddParam.BoChuJobAddParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public BoChuJobAddParam.BoChuJobAddParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public BoChuJobAddParam.BoChuJobAddParamBuilder read_only(final Integer read_only) {
         this.read_only = read_only;
         return this;
      }

      public BoChuJobAddParam build() {
         return new BoChuJobAddParam(this.parent_id, this.title, this.type, this.read_only);
      }

      @Override
      public String toString() {
         return "BoChuJobAddParam.BoChuJobAddParamBuilder(parent_id="
            + this.parent_id
            + ", title="
            + this.title
            + ", type="
            + this.type
            + ", read_only="
            + this.read_only
            + ")";
      }
   }
}
