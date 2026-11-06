package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TechChangeRecordExPortDTO", description = "变更记录下载DTO")
public class TechChangeRecordExPortDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "orderNumber", value = "序号")
   private String orderNumber;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "createTimeDate", value = "变更日期")
   private String createTimeDate;
   @ApiModelProperty(name = "serialNumber", value = "变更编号")
   private String serialNumber;
   @ApiModelProperty(name = "userName", value = "发起人")
   private String userName;
   @ApiModelProperty(name = "changeReasonName", value = "变更原因")
   private String changeReasonName;
   @ApiModelProperty(name = "artifactNames", value = "涉及构件")
   private String artifactNames;
   @ApiModelProperty(name = "checkUserName", value = "审核人")
   private String checkUserName;
   @ApiModelProperty(name = "checkStatusName", value = "状态")
   private String checkStatusName;

   public static TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder builder() {
      return new TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder();
   }

   public TechChangeRecordExPortDTO() {
   }

   public TechChangeRecordExPortDTO(
      final Long id,
      final String orderNumber,
      final String projectName,
      final String monomerName,
      final String createTimeDate,
      final String serialNumber,
      final String userName,
      final String changeReasonName,
      final String artifactNames,
      final String checkUserName,
      final String checkStatusName
   ) {
      this.id = id;
      this.orderNumber = orderNumber;
      this.projectName = projectName;
      this.monomerName = monomerName;
      this.createTimeDate = createTimeDate;
      this.serialNumber = serialNumber;
      this.userName = userName;
      this.changeReasonName = changeReasonName;
      this.artifactNames = artifactNames;
      this.checkUserName = checkUserName;
      this.checkStatusName = checkStatusName;
   }

   public Long getId() {
      return this.id;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getCreateTimeDate() {
      return this.createTimeDate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getChangeReasonName() {
      return this.changeReasonName;
   }

   public String getArtifactNames() {
      return this.artifactNames;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public String getCheckStatusName() {
      return this.checkStatusName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setCreateTimeDate(final String createTimeDate) {
      this.createTimeDate = createTimeDate;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setChangeReasonName(final String changeReasonName) {
      this.changeReasonName = changeReasonName;
   }

   public void setArtifactNames(final String artifactNames) {
      this.artifactNames = artifactNames;
   }

   public void setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
   }

   public void setCheckStatusName(final String checkStatusName) {
      this.checkStatusName = checkStatusName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeRecordExPortDTO)) {
         return false;
      }

      TechChangeRecordExPortDTO other = (TechChangeRecordExPortDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$orderNumber = this.getOrderNumber();
         Object other$orderNumber = other.getOrderNumber();
         if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$monomerName = this.getMonomerName();
               Object other$monomerName = other.getMonomerName();
               if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                  Object this$createTimeDate = this.getCreateTimeDate();
                  Object other$createTimeDate = other.getCreateTimeDate();
                  if (this$createTimeDate == null ? other$createTimeDate == null : this$createTimeDate.equals(other$createTimeDate)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$userName = this.getUserName();
                        Object other$userName = other.getUserName();
                        if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                           Object this$changeReasonName = this.getChangeReasonName();
                           Object other$changeReasonName = other.getChangeReasonName();
                           if (this$changeReasonName == null ? other$changeReasonName == null : this$changeReasonName.equals(other$changeReasonName)) {
                              Object this$artifactNames = this.getArtifactNames();
                              Object other$artifactNames = other.getArtifactNames();
                              if (this$artifactNames == null ? other$artifactNames == null : this$artifactNames.equals(other$artifactNames)) {
                                 Object this$checkUserName = this.getCheckUserName();
                                 Object other$checkUserName = other.getCheckUserName();
                                 if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                                    Object this$checkStatusName = this.getCheckStatusName();
                                    Object other$checkStatusName = other.getCheckStatusName();
                                    return this$checkStatusName == null ? other$checkStatusName == null : this$checkStatusName.equals(other$checkStatusName);
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
      return other instanceof TechChangeRecordExPortDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $createTimeDate = this.getCreateTimeDate();
      result = result * 59 + ($createTimeDate == null ? 43 : $createTimeDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $changeReasonName = this.getChangeReasonName();
      result = result * 59 + ($changeReasonName == null ? 43 : $changeReasonName.hashCode());
      Object $artifactNames = this.getArtifactNames();
      result = result * 59 + ($artifactNames == null ? 43 : $artifactNames.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkStatusName = this.getCheckStatusName();
      return result * 59 + ($checkStatusName == null ? 43 : $checkStatusName.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeRecordExPortDTO(id="
         + this.getId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", createTimeDate="
         + this.getCreateTimeDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", userName="
         + this.getUserName()
         + ", changeReasonName="
         + this.getChangeReasonName()
         + ", artifactNames="
         + this.getArtifactNames()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", checkStatusName="
         + this.getCheckStatusName()
         + ")";
   }

   public static class TechChangeRecordExPortDTOBuilder {
      private Long id;
      private String orderNumber;
      private String projectName;
      private String monomerName;
      private String createTimeDate;
      private String serialNumber;
      private String userName;
      private String changeReasonName;
      private String artifactNames;
      private String checkUserName;
      private String checkStatusName;

      TechChangeRecordExPortDTOBuilder() {
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder createTimeDate(final String createTimeDate) {
         this.createTimeDate = createTimeDate;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder changeReasonName(final String changeReasonName) {
         this.changeReasonName = changeReasonName;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder artifactNames(final String artifactNames) {
         this.artifactNames = artifactNames;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder checkUserName(final String checkUserName) {
         this.checkUserName = checkUserName;
         return this;
      }

      public TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder checkStatusName(final String checkStatusName) {
         this.checkStatusName = checkStatusName;
         return this;
      }

      public TechChangeRecordExPortDTO build() {
         return new TechChangeRecordExPortDTO(
            this.id,
            this.orderNumber,
            this.projectName,
            this.monomerName,
            this.createTimeDate,
            this.serialNumber,
            this.userName,
            this.changeReasonName,
            this.artifactNames,
            this.checkUserName,
            this.checkStatusName
         );
      }

      @Override
      public String toString() {
         return "TechChangeRecordExPortDTO.TechChangeRecordExPortDTOBuilder(id="
            + this.id
            + ", orderNumber="
            + this.orderNumber
            + ", projectName="
            + this.projectName
            + ", monomerName="
            + this.monomerName
            + ", createTimeDate="
            + this.createTimeDate
            + ", serialNumber="
            + this.serialNumber
            + ", userName="
            + this.userName
            + ", changeReasonName="
            + this.changeReasonName
            + ", artifactNames="
            + this.artifactNames
            + ", checkUserName="
            + this.checkUserName
            + ", checkStatusName="
            + this.checkStatusName
            + ")";
      }
   }
}
