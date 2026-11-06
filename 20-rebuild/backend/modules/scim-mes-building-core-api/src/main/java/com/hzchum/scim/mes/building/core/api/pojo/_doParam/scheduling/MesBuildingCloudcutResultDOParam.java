package com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling;

import io.swagger.annotations.ApiModel;
import java.util.Date;

@ApiModel(value = "MesBuildingCloudcutResultDOParam", description = "云切结果")
public class MesBuildingCloudcutResultDOParam {
   private Long id;
   private Long cloudcutId;
   private String fileName;
   private String filePath;
   private Date importTime;
   private Long importUser;
   private Long machineToolId;
   private Integer cutSendStatus;
   private Date cutSendTime;
   private Long cutSendUserId;
   private Integer cutStatus;
   private Date askCompleteTime;
   private Date completeTime;

   public static MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder builder() {
      return new MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder();
   }

   public MesBuildingCloudcutResultDOParam(
      final Long id,
      final Long cloudcutId,
      final String fileName,
      final String filePath,
      final Date importTime,
      final Long importUser,
      final Long machineToolId,
      final Integer cutSendStatus,
      final Date cutSendTime,
      final Long cutSendUserId,
      final Integer cutStatus,
      final Date askCompleteTime,
      final Date completeTime
   ) {
      this.id = id;
      this.cloudcutId = cloudcutId;
      this.fileName = fileName;
      this.filePath = filePath;
      this.importTime = importTime;
      this.importUser = importUser;
      this.machineToolId = machineToolId;
      this.cutSendStatus = cutSendStatus;
      this.cutSendTime = cutSendTime;
      this.cutSendUserId = cutSendUserId;
      this.cutStatus = cutStatus;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
   }

   public MesBuildingCloudcutResultDOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getCloudcutId() {
      return this.cloudcutId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public Date getImportTime() {
      return this.importTime;
   }

   public Long getImportUser() {
      return this.importUser;
   }

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public Integer getCutSendStatus() {
      return this.cutSendStatus;
   }

   public Date getCutSendTime() {
      return this.cutSendTime;
   }

   public Long getCutSendUserId() {
      return this.cutSendUserId;
   }

   public Integer getCutStatus() {
      return this.cutStatus;
   }

   public Date getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Date getCompleteTime() {
      return this.completeTime;
   }

   public MesBuildingCloudcutResultDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setCloudcutId(final Long cloudcutId) {
      this.cloudcutId = cloudcutId;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setFilePath(final String filePath) {
      this.filePath = filePath;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setImportTime(final Date importTime) {
      this.importTime = importTime;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setImportUser(final Long importUser) {
      this.importUser = importUser;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setCutSendStatus(final Integer cutSendStatus) {
      this.cutSendStatus = cutSendStatus;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setCutSendTime(final Date cutSendTime) {
      this.cutSendTime = cutSendTime;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setCutSendUserId(final Long cutSendUserId) {
      this.cutSendUserId = cutSendUserId;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setCutStatus(final Integer cutStatus) {
      this.cutStatus = cutStatus;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setAskCompleteTime(final Date askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   public MesBuildingCloudcutResultDOParam setCompleteTime(final Date completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCloudcutResultDOParam(id="
         + this.getId()
         + ", cloudcutId="
         + this.getCloudcutId()
         + ", fileName="
         + this.getFileName()
         + ", filePath="
         + this.getFilePath()
         + ", importTime="
         + this.getImportTime()
         + ", importUser="
         + this.getImportUser()
         + ", machineToolId="
         + this.getMachineToolId()
         + ", cutSendStatus="
         + this.getCutSendStatus()
         + ", cutSendTime="
         + this.getCutSendTime()
         + ", cutSendUserId="
         + this.getCutSendUserId()
         + ", cutStatus="
         + this.getCutStatus()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCloudcutResultDOParam)) {
         return false;
      }

      MesBuildingCloudcutResultDOParam other = (MesBuildingCloudcutResultDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cloudcutId = this.getCloudcutId();
         Object other$cloudcutId = other.getCloudcutId();
         if (this$cloudcutId == null ? other$cloudcutId == null : this$cloudcutId.equals(other$cloudcutId)) {
            Object this$importUser = this.getImportUser();
            Object other$importUser = other.getImportUser();
            if (this$importUser == null ? other$importUser == null : this$importUser.equals(other$importUser)) {
               Object this$machineToolId = this.getMachineToolId();
               Object other$machineToolId = other.getMachineToolId();
               if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
                  Object this$cutSendStatus = this.getCutSendStatus();
                  Object other$cutSendStatus = other.getCutSendStatus();
                  if (this$cutSendStatus == null ? other$cutSendStatus == null : this$cutSendStatus.equals(other$cutSendStatus)) {
                     Object this$cutSendUserId = this.getCutSendUserId();
                     Object other$cutSendUserId = other.getCutSendUserId();
                     if (this$cutSendUserId == null ? other$cutSendUserId == null : this$cutSendUserId.equals(other$cutSendUserId)) {
                        Object this$cutStatus = this.getCutStatus();
                        Object other$cutStatus = other.getCutStatus();
                        if (this$cutStatus == null ? other$cutStatus == null : this$cutStatus.equals(other$cutStatus)) {
                           Object this$fileName = this.getFileName();
                           Object other$fileName = other.getFileName();
                           if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                              Object this$filePath = this.getFilePath();
                              Object other$filePath = other.getFilePath();
                              if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                                 Object this$importTime = this.getImportTime();
                                 Object other$importTime = other.getImportTime();
                                 if (this$importTime == null ? other$importTime == null : this$importTime.equals(other$importTime)) {
                                    Object this$cutSendTime = this.getCutSendTime();
                                    Object other$cutSendTime = other.getCutSendTime();
                                    if (this$cutSendTime == null ? other$cutSendTime == null : this$cutSendTime.equals(other$cutSendTime)) {
                                       Object this$askCompleteTime = this.getAskCompleteTime();
                                       Object other$askCompleteTime = other.getAskCompleteTime();
                                       if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                          Object this$completeTime = this.getCompleteTime();
                                          Object other$completeTime = other.getCompleteTime();
                                          return this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime);
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
      return other instanceof MesBuildingCloudcutResultDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cloudcutId = this.getCloudcutId();
      result = result * 59 + ($cloudcutId == null ? 43 : $cloudcutId.hashCode());
      Object $importUser = this.getImportUser();
      result = result * 59 + ($importUser == null ? 43 : $importUser.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $cutSendStatus = this.getCutSendStatus();
      result = result * 59 + ($cutSendStatus == null ? 43 : $cutSendStatus.hashCode());
      Object $cutSendUserId = this.getCutSendUserId();
      result = result * 59 + ($cutSendUserId == null ? 43 : $cutSendUserId.hashCode());
      Object $cutStatus = this.getCutStatus();
      result = result * 59 + ($cutStatus == null ? 43 : $cutStatus.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $importTime = this.getImportTime();
      result = result * 59 + ($importTime == null ? 43 : $importTime.hashCode());
      Object $cutSendTime = this.getCutSendTime();
      result = result * 59 + ($cutSendTime == null ? 43 : $cutSendTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesBuildingCloudcutResultDOParamBuilder {
      private Long id;
      private Long cloudcutId;
      private String fileName;
      private String filePath;
      private Date importTime;
      private Long importUser;
      private Long machineToolId;
      private Integer cutSendStatus;
      private Date cutSendTime;
      private Long cutSendUserId;
      private Integer cutStatus;
      private Date askCompleteTime;
      private Date completeTime;

      MesBuildingCloudcutResultDOParamBuilder() {
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder cloudcutId(final Long cloudcutId) {
         this.cloudcutId = cloudcutId;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder importTime(final Date importTime) {
         this.importTime = importTime;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder importUser(final Long importUser) {
         this.importUser = importUser;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder machineToolId(final Long machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder cutSendStatus(final Integer cutSendStatus) {
         this.cutSendStatus = cutSendStatus;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder cutSendTime(final Date cutSendTime) {
         this.cutSendTime = cutSendTime;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder cutSendUserId(final Long cutSendUserId) {
         this.cutSendUserId = cutSendUserId;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder cutStatus(final Integer cutStatus) {
         this.cutStatus = cutStatus;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder askCompleteTime(final Date askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder completeTime(final Date completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      public MesBuildingCloudcutResultDOParam build() {
         return new MesBuildingCloudcutResultDOParam(
            this.id,
            this.cloudcutId,
            this.fileName,
            this.filePath,
            this.importTime,
            this.importUser,
            this.machineToolId,
            this.cutSendStatus,
            this.cutSendTime,
            this.cutSendUserId,
            this.cutStatus,
            this.askCompleteTime,
            this.completeTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCloudcutResultDOParam.MesBuildingCloudcutResultDOParamBuilder(id="
            + this.id
            + ", cloudcutId="
            + this.cloudcutId
            + ", fileName="
            + this.fileName
            + ", filePath="
            + this.filePath
            + ", importTime="
            + this.importTime
            + ", importUser="
            + this.importUser
            + ", machineToolId="
            + this.machineToolId
            + ", cutSendStatus="
            + this.cutSendStatus
            + ", cutSendTime="
            + this.cutSendTime
            + ", cutSendUserId="
            + this.cutSendUserId
            + ", cutStatus="
            + this.cutStatus
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ")";
      }
   }
}
