package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class InspectionTeamRecourseDTO {
   @ApiModelProperty(name = "productLineName", notes = "生产线名称")
   @JsonProperty("productLineName")
   @JSONField(name = "productLineName")
   private String productLineName;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "groupName", notes = "生产组名称")
   @JsonProperty("groupName")
   @JSONField(name = "groupName")
   private String groupName;
   @ApiModelProperty(name = "groupId", notes = "生产组id")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "userId", notes = "质检人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "userName", notes = "质检人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "createTime", notes = "质检时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "quantity", notes = "质检数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "boolAdoptEnum", notes = "是否质检通过")
   @JsonProperty("boolAdoptEnum")
   @JSONField(name = "boolAdoptEnum")
   private Boolean boolAdoptEnum;
   @ApiModelProperty(name = "processId", notes = "工序Id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "number", value = "构件生产编号", notes = "构件生产编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;

   public String getProductLineName() {
      return this.productLineName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getBoolAdoptEnum() {
      return this.boolAdoptEnum;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("productLineName")
   public void setProductLineName(final String productLineName) {
      this.productLineName = productLineName;
   }

   @JsonProperty("orderNumber")
   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   @JsonProperty("groupName")
   public void setGroupName(final String groupName) {
      this.groupName = groupName;
   }

   @JsonProperty("groupId")
   public void setGroupId(final Long groupId) {
      this.groupId = groupId;
   }

   @JsonProperty("userId")
   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @JsonProperty("teamId")
   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   @JsonProperty("userName")
   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @JsonProperty("createTime")
   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("boolAdoptEnum")
   public void setBoolAdoptEnum(final Boolean boolAdoptEnum) {
      this.boolAdoptEnum = boolAdoptEnum;
   }

   @JsonProperty("processId")
   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @JsonProperty("number")
   public void setNumber(final Integer number) {
      this.number = number;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionTeamRecourseDTO)) {
         return false;
      }

      InspectionTeamRecourseDTO other = (InspectionTeamRecourseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupId = this.getGroupId();
      Object other$groupId = other.getGroupId();
      if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$boolAdoptEnum = this.getBoolAdoptEnum();
                  Object other$boolAdoptEnum = other.getBoolAdoptEnum();
                  if (this$boolAdoptEnum == null ? other$boolAdoptEnum == null : this$boolAdoptEnum.equals(other$boolAdoptEnum)) {
                     Object this$processId = this.getProcessId();
                     Object other$processId = other.getProcessId();
                     if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                        Object this$number = this.getNumber();
                        Object other$number = other.getNumber();
                        if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                           Object this$productLineName = this.getProductLineName();
                           Object other$productLineName = other.getProductLineName();
                           if (this$productLineName == null ? other$productLineName == null : this$productLineName.equals(other$productLineName)) {
                              Object this$orderNumber = this.getOrderNumber();
                              Object other$orderNumber = other.getOrderNumber();
                              if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                 Object this$groupName = this.getGroupName();
                                 Object other$groupName = other.getGroupName();
                                 if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
                                    Object this$userName = this.getUserName();
                                    Object other$userName = other.getUserName();
                                    if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof InspectionTeamRecourseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolAdoptEnum = this.getBoolAdoptEnum();
      result = result * 59 + ($boolAdoptEnum == null ? 43 : $boolAdoptEnum.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $productLineName = this.getProductLineName();
      result = result * 59 + ($productLineName == null ? 43 : $productLineName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionTeamRecourseDTO(productLineName="
         + this.getProductLineName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", groupName="
         + this.getGroupName()
         + ", groupId="
         + this.getGroupId()
         + ", userId="
         + this.getUserId()
         + ", teamId="
         + this.getTeamId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", quantity="
         + this.getQuantity()
         + ", boolAdoptEnum="
         + this.getBoolAdoptEnum()
         + ", processId="
         + this.getProcessId()
         + ", number="
         + this.getNumber()
         + ")";
   }
}
