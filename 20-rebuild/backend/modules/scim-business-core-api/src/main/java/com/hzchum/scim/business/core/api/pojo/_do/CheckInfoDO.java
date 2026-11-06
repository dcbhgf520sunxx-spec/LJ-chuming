package com.hzchum.scim.business.core.api.pojo._do;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import java.time.LocalDateTime;

public class CheckInfoDO {
   private Long id;
   private ProjectInfo project;
   private NameInfo monomer;
   private NameInfo enclosurePlan;
   private Integer projectType;
   private Integer type;
   private Integer status;
   private Long createUserId;
   private String createUserName;
   private LocalDateTime createTime;
   private String checkUserId;
   private String checkUserName;
   private LocalDateTime checkTime;
   private String remark;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getEnclosurePlan() {
      return this.enclosurePlan;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCheckUserId() {
      return this.checkUserId;
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

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setEnclosurePlan(final NameInfo enclosurePlan) {
      this.enclosurePlan = enclosurePlan;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setCheckUserId(final String checkUserId) {
      this.checkUserId = checkUserId;
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

      if (!(o instanceof CheckInfoDO)) {
         return false;
      }

      CheckInfoDO other = (CheckInfoDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$enclosurePlan = this.getEnclosurePlan();
                           Object other$enclosurePlan = other.getEnclosurePlan();
                           if (this$enclosurePlan == null ? other$enclosurePlan == null : this$enclosurePlan.equals(other$enclosurePlan)) {
                              Object this$createUserName = this.getCreateUserName();
                              Object other$createUserName = other.getCreateUserName();
                              if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                 Object this$createTime = this.getCreateTime();
                                 Object other$createTime = other.getCreateTime();
                                 if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                    Object this$checkUserId = this.getCheckUserId();
                                    Object other$checkUserId = other.getCheckUserId();
                                    if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
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
      return other instanceof CheckInfoDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $enclosurePlan = this.getEnclosurePlan();
      result = result * 59 + ($enclosurePlan == null ? 43 : $enclosurePlan.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkTime = this.getCheckTime();
      result = result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CheckInfoDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", enclosurePlan="
         + this.getEnclosurePlan()
         + ", projectType="
         + this.getProjectType()
         + ", type="
         + this.getType()
         + ", status="
         + this.getStatus()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", checkUserId="
         + this.getCheckUserId()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", checkTime="
         + this.getCheckTime()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
