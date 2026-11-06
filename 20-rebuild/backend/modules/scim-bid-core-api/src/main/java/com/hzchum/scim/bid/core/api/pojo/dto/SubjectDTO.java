package com.hzchum.scim.bid.core.api.pojo.dto;

import com.baomidou.mybatisplus.core.conditions.update.Update;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SubjectDTO {
   @NotNull(message = "科目id不能为空", groups = Update.class)
   private Long subjectId;
   private Long pid;
   private String name;
   private Integer level;
   private String unitName;
   private Long unitId;
   private String path;
   private Integer isLast;
   @NotBlank(message = "代号不能为空", groups = Update.class)
   private String code;
   @NotNull(message = "流水不能为空", groups = Update.class)
   @Min(value = 1L, message = "流水号最小值为1", groups = Update.class)
   private Integer number;

   public Long getSubjectId() {
      return this.subjectId;
   }

   public Long getPid() {
      return this.pid;
   }

   public String getName() {
      return this.name;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public Long getUnitId() {
      return this.unitId;
   }

   public String getPath() {
      return this.path;
   }

   public Integer getIsLast() {
      return this.isLast;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getNumber() {
      return this.number;
   }

   public void setSubjectId(final Long subjectId) {
      this.subjectId = subjectId;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setUnitName(final String unitName) {
      this.unitName = unitName;
   }

   public void setUnitId(final Long unitId) {
      this.unitId = unitId;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setIsLast(final Integer isLast) {
      this.isLast = isLast;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectDTO)) {
         return false;
      }

      SubjectDTO other = (SubjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$subjectId = this.getSubjectId();
      Object other$subjectId = other.getSubjectId();
      if (this$subjectId == null ? other$subjectId == null : this$subjectId.equals(other$subjectId)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$level = this.getLevel();
            Object other$level = other.getLevel();
            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
               Object this$unitId = this.getUnitId();
               Object other$unitId = other.getUnitId();
               if (this$unitId == null ? other$unitId == null : this$unitId.equals(other$unitId)) {
                  Object this$isLast = this.getIsLast();
                  Object other$isLast = other.getIsLast();
                  if (this$isLast == null ? other$isLast == null : this$isLast.equals(other$isLast)) {
                     Object this$number = this.getNumber();
                     Object other$number = other.getNumber();
                     if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$unitName = this.getUnitName();
                           Object other$unitName = other.getUnitName();
                           if (this$unitName == null ? other$unitName == null : this$unitName.equals(other$unitName)) {
                              Object this$path = this.getPath();
                              Object other$path = other.getPath();
                              if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                 Object this$code = this.getCode();
                                 Object other$code = other.getCode();
                                 return this$code == null ? other$code == null : this$code.equals(other$code);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $subjectId = this.getSubjectId();
      result = result * 59 + ($subjectId == null ? 43 : $subjectId.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $unitId = this.getUnitId();
      result = result * 59 + ($unitId == null ? 43 : $unitId.hashCode());
      Object $isLast = this.getIsLast();
      result = result * 59 + ($isLast == null ? 43 : $isLast.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectDTO(subjectId="
         + this.getSubjectId()
         + ", pid="
         + this.getPid()
         + ", name="
         + this.getName()
         + ", level="
         + this.getLevel()
         + ", unitName="
         + this.getUnitName()
         + ", unitId="
         + this.getUnitId()
         + ", path="
         + this.getPath()
         + ", isLast="
         + this.getIsLast()
         + ", code="
         + this.getCode()
         + ", number="
         + this.getNumber()
         + ")";
   }
}
