package com.hzchum.scim.bid.core.api.pojo.vo;

import java.util.List;

public class SubjectTreeVO {
   private Long subjectId;
   private Long pid;
   private String name;
   private Integer level;
   private String code;
   private Integer number;
   private String unitName;
   private String path;
   private Boolean boolLastEnum;
   private List<SubjectTreeVO> children;

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

   public String getCode() {
      return this.code;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public String getPath() {
      return this.path;
   }

   public Boolean getBoolLastEnum() {
      return this.boolLastEnum;
   }

   public List<SubjectTreeVO> getChildren() {
      return this.children;
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

   public void setCode(final String code) {
      this.code = code;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setUnitName(final String unitName) {
      this.unitName = unitName;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setBoolLastEnum(final Boolean boolLastEnum) {
      this.boolLastEnum = boolLastEnum;
   }

   public void setChildren(final List<SubjectTreeVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectTreeVO)) {
         return false;
      }

      SubjectTreeVO other = (SubjectTreeVO)o;
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
               Object this$number = this.getNumber();
               Object other$number = other.getNumber();
               if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                  Object this$boolLastEnum = this.getBoolLastEnum();
                  Object other$boolLastEnum = other.getBoolLastEnum();
                  if (this$boolLastEnum == null ? other$boolLastEnum == null : this$boolLastEnum.equals(other$boolLastEnum)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$code = this.getCode();
                        Object other$code = other.getCode();
                        if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                           Object this$unitName = this.getUnitName();
                           Object other$unitName = other.getUnitName();
                           if (this$unitName == null ? other$unitName == null : this$unitName.equals(other$unitName)) {
                              Object this$path = this.getPath();
                              Object other$path = other.getPath();
                              if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                 Object this$children = this.getChildren();
                                 Object other$children = other.getChildren();
                                 return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof SubjectTreeVO;
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
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolLastEnum = this.getBoolLastEnum();
      result = result * 59 + ($boolLastEnum == null ? 43 : $boolLastEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectTreeVO(subjectId="
         + this.getSubjectId()
         + ", pid="
         + this.getPid()
         + ", name="
         + this.getName()
         + ", level="
         + this.getLevel()
         + ", code="
         + this.getCode()
         + ", number="
         + this.getNumber()
         + ", unitName="
         + this.getUnitName()
         + ", path="
         + this.getPath()
         + ", boolLastEnum="
         + this.getBoolLastEnum()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
