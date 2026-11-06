package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.Date;

public class UnitSettingResponseVO {
   private Long id;
   private Integer basicClass;
   private String lengthUnit;
   private String weightUnit;
   private Integer lengthRetain;
   private Integer weightRetain;
   private Integer thicknessRetain;
   private Date createTime;
   private Date updateTime;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getLengthUnit() {
      return this.lengthUnit;
   }

   public String getWeightUnit() {
      return this.weightUnit;
   }

   public Integer getLengthRetain() {
      return this.lengthRetain;
   }

   public Integer getWeightRetain() {
      return this.weightRetain;
   }

   public Integer getThicknessRetain() {
      return this.thicknessRetain;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setLengthUnit(final String lengthUnit) {
      this.lengthUnit = lengthUnit;
   }

   public void setWeightUnit(final String weightUnit) {
      this.weightUnit = weightUnit;
   }

   public void setLengthRetain(final Integer lengthRetain) {
      this.lengthRetain = lengthRetain;
   }

   public void setWeightRetain(final Integer weightRetain) {
      this.weightRetain = weightRetain;
   }

   public void setThicknessRetain(final Integer thicknessRetain) {
      this.thicknessRetain = thicknessRetain;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UnitSettingResponseVO)) {
         return false;
      }

      UnitSettingResponseVO other = (UnitSettingResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$lengthRetain = this.getLengthRetain();
            Object other$lengthRetain = other.getLengthRetain();
            if (this$lengthRetain == null ? other$lengthRetain == null : this$lengthRetain.equals(other$lengthRetain)) {
               Object this$weightRetain = this.getWeightRetain();
               Object other$weightRetain = other.getWeightRetain();
               if (this$weightRetain == null ? other$weightRetain == null : this$weightRetain.equals(other$weightRetain)) {
                  Object this$thicknessRetain = this.getThicknessRetain();
                  Object other$thicknessRetain = other.getThicknessRetain();
                  if (this$thicknessRetain == null ? other$thicknessRetain == null : this$thicknessRetain.equals(other$thicknessRetain)) {
                     Object this$lengthUnit = this.getLengthUnit();
                     Object other$lengthUnit = other.getLengthUnit();
                     if (this$lengthUnit == null ? other$lengthUnit == null : this$lengthUnit.equals(other$lengthUnit)) {
                        Object this$weightUnit = this.getWeightUnit();
                        Object other$weightUnit = other.getWeightUnit();
                        if (this$weightUnit == null ? other$weightUnit == null : this$weightUnit.equals(other$weightUnit)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                              Object this$updateTime = this.getUpdateTime();
                              Object other$updateTime = other.getUpdateTime();
                              return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UnitSettingResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $lengthRetain = this.getLengthRetain();
      result = result * 59 + ($lengthRetain == null ? 43 : $lengthRetain.hashCode());
      Object $weightRetain = this.getWeightRetain();
      result = result * 59 + ($weightRetain == null ? 43 : $weightRetain.hashCode());
      Object $thicknessRetain = this.getThicknessRetain();
      result = result * 59 + ($thicknessRetain == null ? 43 : $thicknessRetain.hashCode());
      Object $lengthUnit = this.getLengthUnit();
      result = result * 59 + ($lengthUnit == null ? 43 : $lengthUnit.hashCode());
      Object $weightUnit = this.getWeightUnit();
      result = result * 59 + ($weightUnit == null ? 43 : $weightUnit.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "UnitSettingResponseVO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", lengthUnit="
         + this.getLengthUnit()
         + ", weightUnit="
         + this.getWeightUnit()
         + ", lengthRetain="
         + this.getLengthRetain()
         + ", weightRetain="
         + this.getWeightRetain()
         + ", thicknessRetain="
         + this.getThicknessRetain()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }
}
