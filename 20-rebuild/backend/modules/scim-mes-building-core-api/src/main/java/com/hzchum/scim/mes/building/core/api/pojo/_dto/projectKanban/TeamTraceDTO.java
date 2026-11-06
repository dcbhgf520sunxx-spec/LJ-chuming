package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class TeamTraceDTO {
   @ApiModelProperty(name = "workshopName", notes = "车间名称")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productLineName", notes = "生产线名称")
   @JsonProperty("productLineName")
   @JSONField(name = "productLineName")
   private String productLineName;
   @ApiModelProperty(name = "groupName", notes = "生产组名称")
   @JsonProperty("groupName")
   @JSONField(name = "groupName")
   private String groupName;
   @ApiModelProperty(name = "groupId", notes = "生产组id")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "userId", notes = "班组长id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", notes = "班组长")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "produceTeamRecourseList", notes = "生产班组信息")
   @JsonProperty("produceTeamRecourseList")
   @JSONField(name = "produceTeamRecourseList")
   private List<produceTeamRecourseDTO> produceTeamRecourseList;
   @ApiModelProperty(name = "InspectionTeamRecourseList", notes = "质检班组信息")
   @JsonProperty("InspectionTeamRecourseList")
   @JSONField(name = "InspectionTeamRecourseList")
   private List<InspectionTeamRecourseDTO> InspectionTeamRecourseList;

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProductLineName() {
      return this.productLineName;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public List<produceTeamRecourseDTO> getProduceTeamRecourseList() {
      return this.produceTeamRecourseList;
   }

   public List<InspectionTeamRecourseDTO> getInspectionTeamRecourseList() {
      return this.InspectionTeamRecourseList;
   }

   @JsonProperty("workshopName")
   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @JsonProperty("productLineName")
   public void setProductLineName(final String productLineName) {
      this.productLineName = productLineName;
   }

   @JsonProperty("groupName")
   public void setGroupName(final String groupName) {
      this.groupName = groupName;
   }

   @JsonProperty("groupId")
   public void setGroupId(final Long groupId) {
      this.groupId = groupId;
   }

   @JsonProperty("teamId")
   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   @JsonProperty("userId")
   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @JsonProperty("userName")
   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @JsonProperty("produceTeamRecourseList")
   public void setProduceTeamRecourseList(final List<produceTeamRecourseDTO> produceTeamRecourseList) {
      this.produceTeamRecourseList = produceTeamRecourseList;
   }

   @JsonProperty("InspectionTeamRecourseList")
   public void setInspectionTeamRecourseList(final List<InspectionTeamRecourseDTO> InspectionTeamRecourseList) {
      this.InspectionTeamRecourseList = InspectionTeamRecourseList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamTraceDTO)) {
         return false;
      }

      TeamTraceDTO other = (TeamTraceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupId = this.getGroupId();
      Object other$groupId = other.getGroupId();
      if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$workshopName = this.getWorkshopName();
               Object other$workshopName = other.getWorkshopName();
               if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                  Object this$productLineName = this.getProductLineName();
                  Object other$productLineName = other.getProductLineName();
                  if (this$productLineName == null ? other$productLineName == null : this$productLineName.equals(other$productLineName)) {
                     Object this$groupName = this.getGroupName();
                     Object other$groupName = other.getGroupName();
                     if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
                        Object this$userName = this.getUserName();
                        Object other$userName = other.getUserName();
                        if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                           Object this$produceTeamRecourseList = this.getProduceTeamRecourseList();
                           Object other$produceTeamRecourseList = other.getProduceTeamRecourseList();
                           if (this$produceTeamRecourseList == null
                              ? other$produceTeamRecourseList == null
                              : this$produceTeamRecourseList.equals(other$produceTeamRecourseList)) {
                              Object this$InspectionTeamRecourseList = this.getInspectionTeamRecourseList();
                              Object other$InspectionTeamRecourseList = other.getInspectionTeamRecourseList();
                              return this$InspectionTeamRecourseList == null
                                 ? other$InspectionTeamRecourseList == null
                                 : this$InspectionTeamRecourseList.equals(other$InspectionTeamRecourseList);
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
      return other instanceof TeamTraceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productLineName = this.getProductLineName();
      result = result * 59 + ($productLineName == null ? 43 : $productLineName.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $produceTeamRecourseList = this.getProduceTeamRecourseList();
      result = result * 59 + ($produceTeamRecourseList == null ? 43 : $produceTeamRecourseList.hashCode());
      Object $InspectionTeamRecourseList = this.getInspectionTeamRecourseList();
      return result * 59 + ($InspectionTeamRecourseList == null ? 43 : $InspectionTeamRecourseList.hashCode());
   }

   @Override
   public String toString() {
      return "TeamTraceDTO(workshopName="
         + this.getWorkshopName()
         + ", productLineName="
         + this.getProductLineName()
         + ", groupName="
         + this.getGroupName()
         + ", groupId="
         + this.getGroupId()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", produceTeamRecourseList="
         + this.getProduceTeamRecourseList()
         + ", InspectionTeamRecourseList="
         + this.getInspectionTeamRecourseList()
         + ")";
   }
}
