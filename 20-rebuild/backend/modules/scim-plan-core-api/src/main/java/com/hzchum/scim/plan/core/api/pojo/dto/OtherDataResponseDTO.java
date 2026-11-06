package com.hzchum.scim.plan.core.api.pojo.dto;

import java.util.Date;

public class OtherDataResponseDTO {
   private Long id;
   private String name;
   private Integer type;
   private String remark;
   private Date createTime;
   private String createUserName;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getRemark() {
      return this.remark;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OtherDataResponseDTO)) {
         return false;
      }

      OtherDataResponseDTO other = (OtherDataResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$createTime = this.getCreateTime();
                  Object other$createTime = other.getCreateTime();
                  if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     return this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName);
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
      return other instanceof OtherDataResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   @Override
   public String toString() {
      return "OtherDataResponseDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ", createTime="
         + this.getCreateTime()
         + ", createUserName="
         + this.getCreateUserName()
         + ")";
   }
}
