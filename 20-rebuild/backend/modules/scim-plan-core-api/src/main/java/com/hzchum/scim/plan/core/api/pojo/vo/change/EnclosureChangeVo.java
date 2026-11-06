package com.hzchum.scim.plan.core.api.pojo.vo.change;

import com.hzchum.scim.plan.core.api.pojo.dto.change.SimplePlan;
import com.hzchum.scim.plan.core.api.pojo.dto.change.SimpleUser;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class EnclosureChangeVo {
   @ApiModelProperty(name = "id", value = "编号", notes = "编号")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目info", notes = "项目info")
   private SimpleUser project;
   @ApiModelProperty(name = "plan", value = "区域info", notes = "区域Info")
   private SimplePlan plan;
   @ApiModelProperty(name = "reasonId", value = "变更原因id", notes = "变更原因id")
   private Long reasonId;
   @ApiModelProperty(name = "reasonName", value = "变更名称", notes = "变更名称")
   private String reasonName;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "版型")
   private String plate;
   @ApiModelProperty(name = "oldQuantity", value = "原数量", notes = "原数量")
   private Integer oldQuantity;
   @ApiModelProperty(name = "newQuantity", value = "变更后数量", notes = "变更后数量")
   private Integer newQuantity;
   @ApiModelProperty(name = "createTime", value = "变更时间", notes = "变更时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "handleTime", value = "处理时间", notes = "处理时间")
   private LocalDateTime handleTime;
   @ApiModelProperty(name = "handleStatusEnum", value = "审核状态", notes = "审核状态")
   private Integer handleStatusEnum;
   @ApiModelProperty(name = "userId", value = "变更提交人id", notes = "变更提交人id")
   private SimpleUser commitUser;
   @ApiModelProperty(name = "handleUser", value = "处理人", notes = "处理人")
   private SimpleUser handleUser;

   public Long getId() {
      return this.id;
   }

   public SimpleUser getProject() {
      return this.project;
   }

   public SimplePlan getPlan() {
      return this.plan;
   }

   public Long getReasonId() {
      return this.reasonId;
   }

   public String getReasonName() {
      return this.reasonName;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getHandleTime() {
      return this.handleTime;
   }

   public Integer getHandleStatusEnum() {
      return this.handleStatusEnum;
   }

   public SimpleUser getCommitUser() {
      return this.commitUser;
   }

   public SimpleUser getHandleUser() {
      return this.handleUser;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final SimpleUser project) {
      this.project = project;
   }

   public void setPlan(final SimplePlan plan) {
      this.plan = plan;
   }

   public void setReasonId(final Long reasonId) {
      this.reasonId = reasonId;
   }

   public void setReasonName(final String reasonName) {
      this.reasonName = reasonName;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
   }

   public void setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setHandleTime(final LocalDateTime handleTime) {
      this.handleTime = handleTime;
   }

   public void setHandleStatusEnum(final Integer handleStatusEnum) {
      this.handleStatusEnum = handleStatusEnum;
   }

   public void setCommitUser(final SimpleUser commitUser) {
      this.commitUser = commitUser;
   }

   public void setHandleUser(final SimpleUser handleUser) {
      this.handleUser = handleUser;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureChangeVo)) {
         return false;
      }

      EnclosureChangeVo other = (EnclosureChangeVo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reasonId = this.getReasonId();
         Object other$reasonId = other.getReasonId();
         if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
            Object this$oldQuantity = this.getOldQuantity();
            Object other$oldQuantity = other.getOldQuantity();
            if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
               Object this$newQuantity = this.getNewQuantity();
               Object other$newQuantity = other.getNewQuantity();
               if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
                  Object this$handleStatusEnum = this.getHandleStatusEnum();
                  Object other$handleStatusEnum = other.getHandleStatusEnum();
                  if (this$handleStatusEnum == null ? other$handleStatusEnum == null : this$handleStatusEnum.equals(other$handleStatusEnum)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$plan = this.getPlan();
                        Object other$plan = other.getPlan();
                        if (this$plan == null ? other$plan == null : this$plan.equals(other$plan)) {
                           Object this$reasonName = this.getReasonName();
                           Object other$reasonName = other.getReasonName();
                           if (this$reasonName == null ? other$reasonName == null : this$reasonName.equals(other$reasonName)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$plate = this.getPlate();
                                    Object other$plate = other.getPlate();
                                    if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                          Object this$handleTime = this.getHandleTime();
                                          Object other$handleTime = other.getHandleTime();
                                          if (this$handleTime == null ? other$handleTime == null : this$handleTime.equals(other$handleTime)) {
                                             Object this$commitUser = this.getCommitUser();
                                             Object other$commitUser = other.getCommitUser();
                                             if (this$commitUser == null ? other$commitUser == null : this$commitUser.equals(other$commitUser)) {
                                                Object this$handleUser = this.getHandleUser();
                                                Object other$handleUser = other.getHandleUser();
                                                return this$handleUser == null ? other$handleUser == null : this$handleUser.equals(other$handleUser);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureChangeVo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $handleStatusEnum = this.getHandleStatusEnum();
      result = result * 59 + ($handleStatusEnum == null ? 43 : $handleStatusEnum.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $plan = this.getPlan();
      result = result * 59 + ($plan == null ? 43 : $plan.hashCode());
      Object $reasonName = this.getReasonName();
      result = result * 59 + ($reasonName == null ? 43 : $reasonName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $handleTime = this.getHandleTime();
      result = result * 59 + ($handleTime == null ? 43 : $handleTime.hashCode());
      Object $commitUser = this.getCommitUser();
      result = result * 59 + ($commitUser == null ? 43 : $commitUser.hashCode());
      Object $handleUser = this.getHandleUser();
      return result * 59 + ($handleUser == null ? 43 : $handleUser.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureChangeVo(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", plan="
         + this.getPlan()
         + ", reasonId="
         + this.getReasonId()
         + ", reasonName="
         + this.getReasonName()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ", createTime="
         + this.getCreateTime()
         + ", handleTime="
         + this.getHandleTime()
         + ", handleStatusEnum="
         + this.getHandleStatusEnum()
         + ", commitUser="
         + this.getCommitUser()
         + ", handleUser="
         + this.getHandleUser()
         + ")";
   }
}
