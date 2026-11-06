package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.wms.core.api.pojo.dto.common.DTO;
import java.time.LocalDateTime;
import java.util.List;

public class TransferDetailListDTO {
   private Long id;
   private Integer basicClass;
   private String serialNumber;
   private List<DTO> source;
   private DTO direction;
   private Integer transferType;
   private Integer transferCreateType;
   private Boolean boolHasUnfreeze;
   private List<MaterialUnfreezeDTO> unfreezeList;
   private Integer reviewStatus;
   private String applicantName;
   private String reviewerName;
   private LocalDateTime reviewTime;
   private List<TransferDetailDTO> list;

   public static TransferDetailListDTO.TransferDetailListDTOBuilder builder() {
      return new TransferDetailListDTO.TransferDetailListDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
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

   public Integer getTransferType() {
      return this.transferType;
   }

   public Integer getTransferCreateType() {
      return this.transferCreateType;
   }

   public Boolean getBoolHasUnfreeze() {
      return this.boolHasUnfreeze;
   }

   public List<MaterialUnfreezeDTO> getUnfreezeList() {
      return this.unfreezeList;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public List<TransferDetailDTO> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
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

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   public void setTransferCreateType(final Integer transferCreateType) {
      this.transferCreateType = transferCreateType;
   }

   public void setBoolHasUnfreeze(final Boolean boolHasUnfreeze) {
      this.boolHasUnfreeze = boolHasUnfreeze;
   }

   public void setUnfreezeList(final List<MaterialUnfreezeDTO> unfreezeList) {
      this.unfreezeList = unfreezeList;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setList(final List<TransferDetailDTO> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferDetailListDTO)) {
         return false;
      }

      TransferDetailListDTO other = (TransferDetailListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$transferType = this.getTransferType();
            Object other$transferType = other.getTransferType();
            if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
               Object this$transferCreateType = this.getTransferCreateType();
               Object other$transferCreateType = other.getTransferCreateType();
               if (this$transferCreateType == null ? other$transferCreateType == null : this$transferCreateType.equals(other$transferCreateType)) {
                  Object this$boolHasUnfreeze = this.getBoolHasUnfreeze();
                  Object other$boolHasUnfreeze = other.getBoolHasUnfreeze();
                  if (this$boolHasUnfreeze == null ? other$boolHasUnfreeze == null : this$boolHasUnfreeze.equals(other$boolHasUnfreeze)) {
                     Object this$reviewStatus = this.getReviewStatus();
                     Object other$reviewStatus = other.getReviewStatus();
                     if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$source = this.getSource();
                           Object other$source = other.getSource();
                           if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                              Object this$direction = this.getDirection();
                              Object other$direction = other.getDirection();
                              if (this$direction == null ? other$direction == null : this$direction.equals(other$direction)) {
                                 Object this$unfreezeList = this.getUnfreezeList();
                                 Object other$unfreezeList = other.getUnfreezeList();
                                 if (this$unfreezeList == null ? other$unfreezeList == null : this$unfreezeList.equals(other$unfreezeList)) {
                                    Object this$applicantName = this.getApplicantName();
                                    Object other$applicantName = other.getApplicantName();
                                    if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                       Object this$reviewerName = this.getReviewerName();
                                       Object other$reviewerName = other.getReviewerName();
                                       if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                          Object this$reviewTime = this.getReviewTime();
                                          Object other$reviewTime = other.getReviewTime();
                                          if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                             Object this$list = this.getList();
                                             Object other$list = other.getList();
                                             return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof TransferDetailListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $transferCreateType = this.getTransferCreateType();
      result = result * 59 + ($transferCreateType == null ? 43 : $transferCreateType.hashCode());
      Object $boolHasUnfreeze = this.getBoolHasUnfreeze();
      result = result * 59 + ($boolHasUnfreeze == null ? 43 : $boolHasUnfreeze.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $direction = this.getDirection();
      result = result * 59 + ($direction == null ? 43 : $direction.hashCode());
      Object $unfreezeList = this.getUnfreezeList();
      result = result * 59 + ($unfreezeList == null ? 43 : $unfreezeList.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "TransferDetailListDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", source="
         + this.getSource()
         + ", direction="
         + this.getDirection()
         + ", transferType="
         + this.getTransferType()
         + ", transferCreateType="
         + this.getTransferCreateType()
         + ", boolHasUnfreeze="
         + this.getBoolHasUnfreeze()
         + ", unfreezeList="
         + this.getUnfreezeList()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", list="
         + this.getList()
         + ")";
   }

   public TransferDetailListDTO(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final List<DTO> source,
      final DTO direction,
      final Integer transferType,
      final Integer transferCreateType,
      final Boolean boolHasUnfreeze,
      final List<MaterialUnfreezeDTO> unfreezeList,
      final Integer reviewStatus,
      final String applicantName,
      final String reviewerName,
      final LocalDateTime reviewTime,
      final List<TransferDetailDTO> list
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.source = source;
      this.direction = direction;
      this.transferType = transferType;
      this.transferCreateType = transferCreateType;
      this.boolHasUnfreeze = boolHasUnfreeze;
      this.unfreezeList = unfreezeList;
      this.reviewStatus = reviewStatus;
      this.applicantName = applicantName;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
      this.list = list;
   }

   public TransferDetailListDTO() {
   }

   public static class TransferDetailListDTOBuilder {
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private List<DTO> source;
      private DTO direction;
      private Integer transferType;
      private Integer transferCreateType;
      private Boolean boolHasUnfreeze;
      private List<MaterialUnfreezeDTO> unfreezeList;
      private Integer reviewStatus;
      private String applicantName;
      private String reviewerName;
      private LocalDateTime reviewTime;
      private List<TransferDetailDTO> list;

      TransferDetailListDTOBuilder() {
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder source(final List<DTO> source) {
         this.source = source;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder direction(final DTO direction) {
         this.direction = direction;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder transferCreateType(final Integer transferCreateType) {
         this.transferCreateType = transferCreateType;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder boolHasUnfreeze(final Boolean boolHasUnfreeze) {
         this.boolHasUnfreeze = boolHasUnfreeze;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder unfreezeList(final List<MaterialUnfreezeDTO> unfreezeList) {
         this.unfreezeList = unfreezeList;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public TransferDetailListDTO.TransferDetailListDTOBuilder list(final List<TransferDetailDTO> list) {
         this.list = list;
         return this;
      }

      public TransferDetailListDTO build() {
         return new TransferDetailListDTO(
            this.id,
            this.basicClass,
            this.serialNumber,
            this.source,
            this.direction,
            this.transferType,
            this.transferCreateType,
            this.boolHasUnfreeze,
            this.unfreezeList,
            this.reviewStatus,
            this.applicantName,
            this.reviewerName,
            this.reviewTime,
            this.list
         );
      }

      @Override
      public String toString() {
         return "TransferDetailListDTO.TransferDetailListDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", source="
            + this.source
            + ", direction="
            + this.direction
            + ", transferType="
            + this.transferType
            + ", transferCreateType="
            + this.transferCreateType
            + ", boolHasUnfreeze="
            + this.boolHasUnfreeze
            + ", unfreezeList="
            + this.unfreezeList
            + ", reviewStatus="
            + this.reviewStatus
            + ", applicantName="
            + this.applicantName
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ", list="
            + this.list
            + ")";
      }
   }
}
