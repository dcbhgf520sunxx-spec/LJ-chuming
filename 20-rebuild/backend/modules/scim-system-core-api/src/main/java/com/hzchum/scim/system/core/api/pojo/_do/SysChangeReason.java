package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "变更原因 ")
@Entity
@Table(name = "sys_change_reason")
public class SysChangeReason extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("名称")
   @Column
   private String name;

   public static SysChangeReason.SysChangeReasonBuilder builder() {
      return new SysChangeReason.SysChangeReasonBuilder();
   }

   public SysChangeReason() {
   }

   public SysChangeReason(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysChangeReason)) {
         return false;
      } else {
         SysChangeReason other = (SysChangeReason)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysChangeReason;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysChangeReason(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class SysChangeReasonBuilder {
      private Long id;
      private String name;

      SysChangeReasonBuilder() {
      }

      public SysChangeReason.SysChangeReasonBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysChangeReason.SysChangeReasonBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysChangeReason build() {
         return new SysChangeReason(this.id, this.name);
      }

      @Override
      public String toString() {
         return "SysChangeReason.SysChangeReasonBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
