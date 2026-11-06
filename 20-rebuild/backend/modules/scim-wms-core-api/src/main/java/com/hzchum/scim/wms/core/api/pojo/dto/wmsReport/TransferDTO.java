package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.DTO;
import java.time.LocalDateTime;
import java.util.List;

public class TransferDTO {
   private Long id;
   private String serialNumber;
   private List<DTO> source;
   private DTO direction;
   private ProjectInfo borrowProject;
   private Boolean boolBorrowReturnNotSelf;
   private Integer transferType;
   private String applicantName;
   private String reviewerName;
   private LocalDateTime transferTime;
   private LocalDateTime createTime;
   private LocalDateTime reviewTime;

   public static TransferDTO.TransferDTOBuilder builder() {
      return new TransferDTO.TransferDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<DTO> getSource() {
      return this.source;
   }

   public DTO getDirection() {
      return this.direction;
   }

   public ProjectInfo getBorrowProject() {
      return this.borrowProject;
   }

   public Boolean getBoolBorrowReturnNotSelf() {
      return this.boolBorrowReturnNotSelf;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getTransferTime() {
      return this.transferTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSource(final List<DTO> source) {
      this.source = source;
   }

   public void setDirection(final DTO direction) {
      this.direction = direction;
   }

   public void setBorrowProject(final ProjectInfo borrowProject) {
      this.borrowProject = borrowProject;
   }

   public void setBoolBorrowReturnNotSelf(final Boolean boolBorrowReturnNotSelf) {
      this.boolBorrowReturnNotSelf = boolBorrowReturnNotSelf;
   }

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setTransferTime(final LocalDateTime transferTime) {
      this.transferTime = transferTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferDTO)) {
         return false;
      }

      TransferDTO other = (TransferDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolBorrowReturnNotSelf = this.getBoolBorrowReturnNotSelf();
         Object other$boolBorrowReturnNotSelf = other.getBoolBorrowReturnNotSelf();
         if (this$boolBorrowReturnNotSelf == null ? other$boolBorrowReturnNotSelf == null : this$boolBorrowReturnNotSelf.equals(other$boolBorrowReturnNotSelf)) {
            Object this$transferType = this.getTransferType();
            Object other$transferType = other.getTransferType();
            if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$source = this.getSource();
                  Object other$source = other.getSource();
                  if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                     Object this$direction = this.getDirection();
                     Object other$direction = other.getDirection();
                     if (this$direction == null ? other$direction == null : this$direction.equals(other$direction)) {
                        Object this$borrowProject = this.getBorrowProject();
                        Object other$borrowProject = other.getBorrowProject();
                        if (this$borrowProject == null ? other$borrowProject == null : this$borrowProject.equals(other$borrowProject)) {
                           Object this$applicantName = this.getApplicantName();
                           Object other$applicantName = other.getApplicantName();
                           if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                              Object this$reviewerName = this.getReviewerName();
                              Object other$reviewerName = other.getReviewerName();
                              if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                 Object this$transferTime = this.getTransferTime();
                                 Object other$transferTime = other.getTransferTime();
                                 if (this$transferTime == null ? other$transferTime == null : this$transferTime.equals(other$transferTime)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                       Object this$reviewTime = this.getReviewTime();
                                       Object other$reviewTime = other.getReviewTime();
                                       return this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime);
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
      return other instanceof TransferDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolBorrowReturnNotSelf = this.getBoolBorrowReturnNotSelf();
      result = result * 59 + ($boolBorrowReturnNotSelf == null ? 43 : $boolBorrowReturnNotSelf.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $direction = this.getDirection();
      result = result * 59 + ($direction == null ? 43 : $direction.hashCode());
      Object $borrowProject = this.getBorrowProject();
      result = result * 59 + ($borrowProject == null ? 43 : $borrowProject.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $transferTime = this.getTransferTime();
      result = result * 59 + ($transferTime == null ? 43 : $transferTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   @Override
   public String toString() {
      return "TransferDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", source="
         + this.getSource()
         + ", direction="
         + this.getDirection()
         + ", borrowProject="
         + this.getBorrowProject()
         + ", boolBorrowReturnNotSelf="
         + this.getBoolBorrowReturnNotSelf()
         + ", transferType="
         + this.getTransferType()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", transferTime="
         + this.getTransferTime()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ")";
   }

   public TransferDTO(
      final Long id,
      final String serialNumber,
      final List<DTO> source,
      final DTO direction,
      final ProjectInfo borrowProject,
      final Boolean boolBorrowReturnNotSelf,
      final Integer transferType,
      final String applicantName,
      final String reviewerName,
      final LocalDateTime transferTime,
      final LocalDateTime createTime,
      final LocalDateTime reviewTime
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.source = source;
      this.direction = direction;
      this.borrowProject = borrowProject;
      this.boolBorrowReturnNotSelf = boolBorrowReturnNotSelf;
      this.transferType = transferType;
      this.applicantName = applicantName;
      this.reviewerName = reviewerName;
      this.transferTime = transferTime;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
   }

   public TransferDTO() {
   }

   public static class TransferDTOBuilder {
      private Long id;
      private String serialNumber;
      private List<DTO> source;
      private DTO direction;
      private ProjectInfo borrowProject;
      private Boolean boolBorrowReturnNotSelf;
      private Integer transferType;
      private String applicantName;
      private String reviewerName;
      private LocalDateTime transferTime;
      private LocalDateTime createTime;
      private LocalDateTime reviewTime;

      TransferDTOBuilder() {
      }

      public TransferDTO.TransferDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferDTO.TransferDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TransferDTO.TransferDTOBuilder source(final List<DTO> source) {
         this.source = source;
         return this;
      }

      public TransferDTO.TransferDTOBuilder direction(final DTO direction) {
         this.direction = direction;
         return this;
      }

      public TransferDTO.TransferDTOBuilder borrowProject(final ProjectInfo borrowProject) {
         this.borrowProject = borrowProject;
         return this;
      }

      public TransferDTO.TransferDTOBuilder boolBorrowReturnNotSelf(final Boolean boolBorrowReturnNotSelf) {
         this.boolBorrowReturnNotSelf = boolBorrowReturnNotSelf;
         return this;
      }

      public TransferDTO.TransferDTOBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public TransferDTO.TransferDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public TransferDTO.TransferDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public TransferDTO.TransferDTOBuilder transferTime(final LocalDateTime transferTime) {
         this.transferTime = transferTime;
         return this;
      }

      public TransferDTO.TransferDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TransferDTO.TransferDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public TransferDTO build() {
         return new TransferDTO(
            this.id,
            this.serialNumber,
            this.source,
            this.direction,
            this.borrowProject,
            this.boolBorrowReturnNotSelf,
            this.transferType,
            this.applicantName,
            this.reviewerName,
            this.transferTime,
            this.createTime,
            this.reviewTime
         );
      }

      @Override
      public String toString() {
         return "TransferDTO.TransferDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", source="
            + this.source
            + ", direction="
            + this.direction
            + ", borrowProject="
            + this.borrowProject
            + ", boolBorrowReturnNotSelf="
            + this.boolBorrowReturnNotSelf
            + ", transferType="
            + this.transferType
            + ", applicantName="
            + this.applicantName
            + ", reviewerName="
            + this.reviewerName
            + ", transferTime="
            + this.transferTime
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
            + ")";
      }
   }
}
