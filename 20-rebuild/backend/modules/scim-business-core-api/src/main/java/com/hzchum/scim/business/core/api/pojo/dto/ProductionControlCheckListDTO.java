package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import java.time.LocalDateTime;

public class ProductionControlCheckListDTO {
   private Long id;
   private ProjectInfo project;
   private Integer status;
   private String createUserName;
   private String createTime;
   private String checkUserName;
   private LocalDateTime checkTime;
   private String remark;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public LocalDateTime getCheckTime() {
      return this.checkTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final String createTime) {
      this.createTime = createTime;
   }

   public void setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
   }

   public void setCheckTime(final LocalDateTime checkTime) {
      this.checkTime = checkTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionControlCheckListDTO)) {
         return false;
      }

      ProductionControlCheckListDTO other = (ProductionControlCheckListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$createUserName = this.getCreateUserName();
               Object other$createUserName = other.getCreateUserName();
               if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                  Object this$createTime = this.getCreateTime();
                  Object other$createTime = other.getCreateTime();
                  if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                     Object this$checkUserName = this.getCheckUserName();
                     Object other$checkUserName = other.getCheckUserName();
                     if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                        Object this$checkTime = this.getCheckTime();
                        Object other$checkTime = other.getCheckTime();
                        if (this$checkTime == null ? other$checkTime == null : this$checkTime.equals(other$checkTime)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ProductionControlCheckListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkTime = this.getCheckTime();
      result = result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionControlCheckListDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", status="
         + this.getStatus()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", checkTime="
         + this.getCheckTime()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
