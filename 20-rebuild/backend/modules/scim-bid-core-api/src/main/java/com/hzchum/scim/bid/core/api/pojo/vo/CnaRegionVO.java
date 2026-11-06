package com.hzchum.scim.bid.core.api.pojo.vo;

import java.util.List;

public class CnaRegionVO {
   private Long id;
   private Long pid;
   private String name;
   private String code;
   private Integer level;
   private String path;
   private List<CnaRegionVO> children;

   public Long getId() {
      return this.id;
   }

   public Long getPid() {
      return this.pid;
   }

   public String getName() {
      return this.name;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getPath() {
      return this.path;
   }

   public List<CnaRegionVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setChildren(final List<CnaRegionVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CnaRegionVO)) {
         return false;
      }

      CnaRegionVO other = (CnaRegionVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$level = this.getLevel();
            Object other$level = other.getLevel();
            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$code = this.getCode();
                  Object other$code = other.getCode();
                  if (this$code == null ? other$code == null : this$code.equals(other$code)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CnaRegionVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "CnaRegionVO(id="
         + this.getId()
         + ", pid="
         + this.getPid()
         + ", name="
         + this.getName()
         + ", code="
         + this.getCode()
         + ", level="
         + this.getLevel()
         + ", path="
         + this.getPath()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
