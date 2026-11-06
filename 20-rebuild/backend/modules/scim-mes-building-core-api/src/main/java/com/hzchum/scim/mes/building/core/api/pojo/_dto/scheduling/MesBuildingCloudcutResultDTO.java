package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingCloudcutResultDTO", description = "云切助手作业下结果")
public class MesBuildingCloudcutResultDTO {
   private Long id;
   private Long cloudcutId;
   private String fileName;
   private String filePath;
   private LocalDateTime importTime;
   private Long importUserId;
   private Long machineToolId;
   private Integer cutSendStatus;
   private LocalDateTime cutSendTime;
   private Long cutSendUserId;
   private Integer cutStatus;
   private LocalDateTime askCompleteTime;
   private LocalDateTime completeTime;
   private Integer partType;
   private Integer pageNumber = 1;
   private Integer pageSize = 10;

   public static MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder builder() {
      return new MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder();
   }

   public MesBuildingCloudcutResultDTO() {
   }

   public MesBuildingCloudcutResultDTO(
      final Long id,
      final Long cloudcutId,
      final String fileName,
      final String filePath,
      final LocalDateTime importTime,
      final Long importUserId,
      final Long machineToolId,
      final Integer cutSendStatus,
      final LocalDateTime cutSendTime,
      final Long cutSendUserId,
      final Integer cutStatus,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Integer partType,
      final Integer pageNumber,
      final Integer pageSize
   ) {
      this.id = id;
      this.cloudcutId = cloudcutId;
      this.fileName = fileName;
      this.filePath = filePath;
      this.importTime = importTime;
      this.importUserId = importUserId;
      this.machineToolId = machineToolId;
      this.cutSendStatus = cutSendStatus;
      this.cutSendTime = cutSendTime;
      this.cutSendUserId = cutSendUserId;
      this.cutStatus = cutStatus;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.partType = partType;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
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

   public LocalDateTime getImportTime() {
      return this.importTime;
   }

   public Long getImportUserId() {
      return this.importUserId;
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

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
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

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCloudcutResultDTO)) {
         return false;
      }

      MesBuildingCloudcutResultDTO other = (MesBuildingCloudcutResultDTO)o;
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
                              Object this$pageNumber = this.getPageNumber();
                              Object other$pageNumber = other.getPageNumber();
                              if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                                 Object this$pageSize = this.getPageSize();
                                 Object other$pageSize = other.getPageSize();
                                 if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
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
      return other instanceof MesBuildingCloudcutResultDTO;
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
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
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

   @Override
   public String toString() {
      return "MesBuildingCloudcutResultDTO(id="
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
         + ", partType="
         + this.getPartType()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }

   public static class MesBuildingCloudcutResultDTOBuilder {
      private Long id;
      private Long cloudcutId;
      private String fileName;
      private String filePath;
      private LocalDateTime importTime;
      private Long importUserId;
      private Long machineToolId;
      private Integer cutSendStatus;
      private LocalDateTime cutSendTime;
      private Long cutSendUserId;
      private Integer cutStatus;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Integer partType;
      private Integer pageNumber;
      private Integer pageSize;

      MesBuildingCloudcutResultDTOBuilder() {
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder cloudcutId(final Long cloudcutId) {
         this.cloudcutId = cloudcutId;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder importTime(final LocalDateTime importTime) {
         this.importTime = importTime;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder importUserId(final Long importUserId) {
         this.importUserId = importUserId;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder machineToolId(final Long machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder cutSendStatus(final Integer cutSendStatus) {
         this.cutSendStatus = cutSendStatus;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder cutSendTime(final LocalDateTime cutSendTime) {
         this.cutSendTime = cutSendTime;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder cutSendUserId(final Long cutSendUserId) {
         this.cutSendUserId = cutSendUserId;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder cutStatus(final Integer cutStatus) {
         this.cutStatus = cutStatus;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      public MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder pageSize(final Integer pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public MesBuildingCloudcutResultDTO build() {
         return new MesBuildingCloudcutResultDTO(
            this.id,
            this.cloudcutId,
            this.fileName,
            this.filePath,
            this.importTime,
            this.importUserId,
            this.machineToolId,
            this.cutSendStatus,
            this.cutSendTime,
            this.cutSendUserId,
            this.cutStatus,
            this.askCompleteTime,
            this.completeTime,
            this.partType,
            this.pageNumber,
            this.pageSize
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCloudcutResultDTO.MesBuildingCloudcutResultDTOBuilder(id="
            + this.id
            + ", cloudcutId="
            + this.cloudcutId
            + ", fileName="
            + this.fileName
            + ", filePath="
            + this.filePath
            + ", importTime="
            + this.importTime
            + ", importUserId="
            + this.importUserId
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
            + ", partType="
            + this.partType
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ")";
      }
   }
}
