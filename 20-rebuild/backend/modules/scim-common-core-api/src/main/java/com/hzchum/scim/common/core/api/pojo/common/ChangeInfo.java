package com.hzchum.scim.common.core.api.pojo.common;

import cn.hutool.core.collection.CollUtil;
import java.util.List;

public class ChangeInfo<T> {
   List<T> createList = CollUtil.newArrayList((T[])(new Object[0]));
   List<T> updateList = CollUtil.newArrayList((T[])(new Object[0]));
   List<T> deleteList = CollUtil.newArrayList((T[])(new Object[0]));
   List<T> unchangeList = CollUtil.newArrayList((T[])(new Object[0]));

   public List<T> getCreateList() {
      return this.createList;
   }

   public List<T> getUpdateList() {
      return this.updateList;
   }

   public List<T> getDeleteList() {
      return this.deleteList;
   }

   public List<T> getUnchangeList() {
      return this.unchangeList;
   }

   public void setCreateList(final List<T> createList) {
      this.createList = createList;
   }

   public void setUpdateList(final List<T> updateList) {
      this.updateList = updateList;
   }

   public void setDeleteList(final List<T> deleteList) {
      this.deleteList = deleteList;
   }

   public void setUnchangeList(final List<T> unchangeList) {
      this.unchangeList = unchangeList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ChangeInfo)) {
         return false;
      }

      ChangeInfo<?> other = (ChangeInfo<?>)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createList = this.getCreateList();
      Object other$createList = other.getCreateList();
      if (this$createList == null ? other$createList == null : this$createList.equals(other$createList)) {
         Object this$updateList = this.getUpdateList();
         Object other$updateList = other.getUpdateList();
         if (this$updateList == null ? other$updateList == null : this$updateList.equals(other$updateList)) {
            Object this$deleteList = this.getDeleteList();
            Object other$deleteList = other.getDeleteList();
            if (this$deleteList == null ? other$deleteList == null : this$deleteList.equals(other$deleteList)) {
               Object this$unchangeList = this.getUnchangeList();
               Object other$unchangeList = other.getUnchangeList();
               return this$unchangeList == null ? other$unchangeList == null : this$unchangeList.equals(other$unchangeList);
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
      return other instanceof ChangeInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createList = this.getCreateList();
      result = result * 59 + ($createList == null ? 43 : $createList.hashCode());
      Object $updateList = this.getUpdateList();
      result = result * 59 + ($updateList == null ? 43 : $updateList.hashCode());
      Object $deleteList = this.getDeleteList();
      result = result * 59 + ($deleteList == null ? 43 : $deleteList.hashCode());
      Object $unchangeList = this.getUnchangeList();
      return result * 59 + ($unchangeList == null ? 43 : $unchangeList.hashCode());
   }

   @Override
   public String toString() {
      return "ChangeInfo(createList="
         + this.getCreateList()
         + ", updateList="
         + this.getUpdateList()
         + ", deleteList="
         + this.getDeleteList()
         + ", unchangeList="
         + this.getUnchangeList()
         + ")";
   }
}
