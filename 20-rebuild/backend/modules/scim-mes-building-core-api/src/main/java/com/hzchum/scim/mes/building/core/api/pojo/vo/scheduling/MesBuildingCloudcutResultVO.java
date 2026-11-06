package com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling;

import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingCloudcutResultVO", description = "云切结果")
public class MesBuildingCloudcutResultVO {
   private Long id;
   private Long cloudcutId;
   private String fileName;
   private String filePath;
   private LocalDateTime importTime;
   private Long importUserId;
   private String importUserName;
   private Long machineToolId;
   private Integer cutSendStatus;
   private LocalDateTime cutSendTime;
   private Long cutSendUserId;
   private String cutSendUserName;
   private Integer cutStatus;
   private LocalDateTime askCompleteTime;
   private LocalDateTime completeTime;
   private Integer partType;

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

   public LocalDateTime getImportTime() {
      return this.importTime;
   }

   public Long getImportUserId() {
      return this.importUserId;
   }

   public String getImportUserName() {
      return this.importUserName;
   }

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public Integer getCutSendStatus() {
      return this.cutSendStatus;
   }

   public LocalDateTime getCutSendTime() {
      return this.cutSendTime;
   }

   public Long getCutSendUserId() {
      return this.cutSendUserId;
   }

   public String getCutSendUserName() {
      return this.cutSendUserName;
   }

   public Integer getCutStatus() {
      return this.cutStatus;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCloudcutId(final Long cloudcutId) {
      this.cloudcutId = cloudcutId;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setFilePath(final String filePath) {
      this.filePath = filePath;
   }

   public void setImportTime(final LocalDateTime importTime) {
      this.importTime = importTime;
   }

   public void setImportUserId(final Long importUserId) {
      this.importUserId = importUserId;
   }

   public void setImportUserName(final String importUserName) {
      this.importUserName = importUserName;
   }

   public void setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
   }

   public void setCutSendStatus(final Integer cutSendStatus) {
      this.cutSendStatus = cutSendStatus;
   }

   public void setCutSendTime(final LocalDateTime cutSendTime) {
      this.cutSendTime = cutSendTime;
   }

   public void setCutSendUserId(final Long cutSendUserId) {
      this.cutSendUserId = cutSendUserId;
   }

   public void setCutSendUserName(final String cutSendUserName) {
      this.cutSendUserName = cutSendUserName;
   }

   public void setCutStatus(final Integer cutStatus) {
      this.cutStatus = cutStatus;
   }

   public void setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
   }

   public void setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
   }

   public void setPartType(final Integer partType) {
      this.partType = partType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCloudcutResultVO)) {
         return false;
      }

      MesBuildingCloudcutResultVO other = (MesBuildingCloudcutResultVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cloudcutId = this.getCloudcutId();
         Object other$cloudcutId = other.getCloudcutId();
         if (this$cloudcutId == null ? other$cloudcutId == null : this$cloudcutId.equals(other$cloudcutId)) {
            Object this$importUserId = this.getImportUserId();
            Object other$importUserId = other.getImportUserId();
            if (this$importUserId == null ? other$importUserId == null : this$importUserId.equals(other$importUserId)) {
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
                           Object this$partType = this.getPartType();
                           Object other$partType = other.getPartType();
                           if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                              Object this$fileName = this.getFileName();
                              Object other$fileName = other.getFileName();
                              if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                 Object this$filePath = this.getFilePath();
                                 Object other$filePath = other.getFilePath();
                                 if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                                    Object this$importTime = this.getImportTime();
                                    Object other$importTime = other.getImportTime();
                                    if (this$importTime == null ? other$importTime == null : this$importTime.equals(other$importTime)) {
                                       Object this$importUserName = this.getImportUserName();
                                       Object other$importUserName = other.getImportUserName();
                                       if (this$importUserName == null ? other$importUserName == null : this$importUserName.equals(other$importUserName)) {
                                          Object this$cutSendTime = this.getCutSendTime();
                                          Object other$cutSendTime = other.getCutSendTime();
                                          if (this$cutSendTime == null ? other$cutSendTime == null : this$cutSendTime.equals(other$cutSendTime)) {
                                             Object this$cutSendUserName = this.getCutSendUserName();
                                             Object other$cutSendUserName = other.getCutSendUserName();
                                             if (this$cutSendUserName == null
                                                ? other$cutSendUserName == null
                                                : this$cutSendUserName.equals(other$cutSendUserName)) {
                                                Object this$askCompleteTime = this.getAskCompleteTime();
                                                Object other$askCompleteTime = other.getAskCompleteTime();
                                                if (this$askCompleteTime == null
                                                   ? other$askCompleteTime == null
                                                   : this$askCompleteTime.equals(other$askCompleteTime)) {
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
      return other instanceof MesBuildingCloudcutResultVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cloudcutId = this.getCloudcutId();
      result = result * 59 + ($cloudcutId == null ? 43 : $cloudcutId.hashCode());
      Object $importUserId = this.getImportUserId();
      result = result * 59 + ($importUserId == null ? 43 : $importUserId.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $cutSendStatus = this.getCutSendStatus();
      result = result * 59 + ($cutSendStatus == null ? 43 : $cutSendStatus.hashCode());
      Object $cutSendUserId = this.getCutSendUserId();
      result = result * 59 + ($cutSendUserId == null ? 43 : $cutSendUserId.hashCode());
      Object $cutStatus = this.getCutStatus();
      result = result * 59 + ($cutStatus == null ? 43 : $cutStatus.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $importTime = this.getImportTime();
      result = result * 59 + ($importTime == null ? 43 : $importTime.hashCode());
      Object $importUserName = this.getImportUserName();
      result = result * 59 + ($importUserName == null ? 43 : $importUserName.hashCode());
      Object $cutSendTime = this.getCutSendTime();
      result = result * 59 + ($cutSendTime == null ? 43 : $cutSendTime.hashCode());
      Object $cutSendUserName = this.getCutSendUserName();
      result = result * 59 + ($cutSendUserName == null ? 43 : $cutSendUserName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingCloudcutResultVO(id="
         + this.getId()
         + ", cloudcutId="
         + this.getCloudcutId()
         + ", fileName="
         + this.getFileName()
         + ", filePath="
         + this.getFilePath()
         + ", importTime="
         + this.getImportTime()
         + ", importUserId="
         + this.getImportUserId()
         + ", importUserName="
         + this.getImportUserName()
         + ", machineToolId="
         + this.getMachineToolId()
         + ", cutSendStatus="
         + this.getCutSendStatus()
         + ", cutSendTime="
         + this.getCutSendTime()
         + ", cutSendUserId="
         + this.getCutSendUserId()
         + ", cutSendUserName="
         + this.getCutSendUserName()
         + ", cutStatus="
         + this.getCutStatus()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", partType="
         + this.getPartType()
         + ")";
   }
}
