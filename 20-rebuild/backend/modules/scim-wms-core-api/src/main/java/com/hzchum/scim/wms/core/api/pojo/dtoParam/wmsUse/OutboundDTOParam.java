package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class OutboundDTOParam {
   private Long id;
   private LocalDateTime userUpdateTime;
   private LocalDateTime createTime;
   private LocalDateTime reviewTime;
   private Map<String, String> applicant;
   private Integer basicClass;
   private Integer reviewStatus;
   private String serialNumber;
   private String applicantSN;
   private String defaultName;
   private Long defaultId;
   private Boolean boolCross;
   private Boolean boolPartyA;
   private String remark;
   private List<OutboundDetailDTO> list;

   public static OutboundDTOParam.OutboundDTOParamBuilder builder() {
      return new OutboundDTOParam.OutboundDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Map<String, String> getApplicant() {
      return this.applicant;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getApplicantSN() {
      return this.applicantSN;
   }

   public String getDefaultName() {
      return this.defaultName;
   }

   public Long getDefaultId() {
      return this.defaultId;
   }

   public Boolean getBoolCross() {
      return this.boolCross;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<OutboundDetailDTO> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setApplicant(final Map<String, String> applicant) {
      this.applicant = applicant;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplicantSN(final String applicantSN) {
      this.applicantSN = applicantSN;
   }

   public void setDefaultName(final String defaultName) {
      this.defaultName = defaultName;
   }

   public void setDefaultId(final Long defaultId) {
      this.defaultId = defaultId;
   }

   public void setBoolCross(final Boolean boolCross) {
      this.boolCross = boolCross;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setList(final List<OutboundDetailDTO> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDTOParam)) {
         return false;
      }

      OutboundDTOParam other = (OutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$defaultId = this.getDefaultId();
               Object other$defaultId = other.getDefaultId();
               if (this$defaultId == null ? other$defaultId == null : this$defaultId.equals(other$defaultId)) {
                  Object this$boolCross = this.getBoolCross();
                  Object other$boolCross = other.getBoolCross();
                  if (this$boolCross == null ? other$boolCross == null : this$boolCross.equals(other$boolCross)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$userUpdateTime = this.getUserUpdateTime();
                        Object other$userUpdateTime = other.getUserUpdateTime();
                        if (this$userUpdateTime == null ? other$userUpdateTime == null : this$userUpdateTime.equals(other$userUpdateTime)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                              Object this$reviewTime = this.getReviewTime();
                              Object other$reviewTime = other.getReviewTime();
                              if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                 Object this$applicant = this.getApplicant();
                                 Object other$applicant = other.getApplicant();
                                 if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$applicantSN = this.getApplicantSN();
                                       Object other$applicantSN = other.getApplicantSN();
                                       if (this$applicantSN == null ? other$applicantSN == null : this$applicantSN.equals(other$applicantSN)) {
                                          Object this$defaultName = this.getDefaultName();
                                          Object other$defaultName = other.getDefaultName();
                                          if (this$defaultName == null ? other$defaultName == null : this$defaultName.equals(other$defaultName)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $defaultId = this.getDefaultId();
      result = result * 59 + ($defaultId == null ? 43 : $defaultId.hashCode());
      Object $boolCross = this.getBoolCross();
      result = result * 59 + ($boolCross == null ? 43 : $boolCross.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantSN = this.getApplicantSN();
      result = result * 59 + ($applicantSN == null ? 43 : $applicantSN.hashCode());
      Object $defaultName = this.getDefaultName();
      result = result * 59 + ($defaultName == null ? 43 : $defaultName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDTOParam(id="
         + this.getId()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", applicant="
         + this.getApplicant()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantSN="
         + this.getApplicantSN()
         + ", defaultName="
         + this.getDefaultName()
         + ", defaultId="
         + this.getDefaultId()
         + ", boolCross="
         + this.getBoolCross()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", remark="
         + this.getRemark()
         + ", list="
         + this.getList()
         + ")";
   }

   public OutboundDTOParam(
      final Long id,
      final LocalDateTime userUpdateTime,
      final LocalDateTime createTime,
      final LocalDateTime reviewTime,
      final Map<String, String> applicant,
      final Integer basicClass,
      final Integer reviewStatus,
      final String serialNumber,
      final String applicantSN,
      final String defaultName,
      final Long defaultId,
      final Boolean boolCross,
      final Boolean boolPartyA,
      final String remark,
      final List<OutboundDetailDTO> list
   ) {
      this.id = id;
      this.userUpdateTime = userUpdateTime;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
      this.applicant = applicant;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.serialNumber = serialNumber;
      this.applicantSN = applicantSN;
      this.defaultName = defaultName;
      this.defaultId = defaultId;
      this.boolCross = boolCross;
      this.boolPartyA = boolPartyA;
      this.remark = remark;
      this.list = list;
   }

   public OutboundDTOParam() {
   }

   public static class OutboundDTOParamBuilder {
      private Long id;
      private LocalDateTime userUpdateTime;
      private LocalDateTime createTime;
      private LocalDateTime reviewTime;
      private Map<String, String> applicant;
      private Integer basicClass;
      private Integer reviewStatus;
      private String serialNumber;
      private String applicantSN;
      private String defaultName;
      private Long defaultId;
      private Boolean boolCross;
      private Boolean boolPartyA;
      private String remark;
      private List<OutboundDetailDTO> list;

      OutboundDTOParamBuilder() {
      }

      public OutboundDTOParam.OutboundDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder applicant(final Map<String, String> applicant) {
         this.applicant = applicant;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder applicantSN(final String applicantSN) {
         this.applicantSN = applicantSN;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder defaultName(final String defaultName) {
         this.defaultName = defaultName;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder defaultId(final Long defaultId) {
         this.defaultId = defaultId;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder boolCross(final Boolean boolCross) {
         this.boolCross = boolCross;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OutboundDTOParam.OutboundDTOParamBuilder list(final List<OutboundDetailDTO> list) {
         this.list = list;
         return this;
      }

      public OutboundDTOParam build() {
         return new OutboundDTOParam(
            this.id,
            this.userUpdateTime,
            this.createTime,
            this.reviewTime,
            this.applicant,
            this.basicClass,
            this.reviewStatus,
            this.serialNumber,
            this.applicantSN,
            this.defaultName,
            this.defaultId,
            this.boolCross,
            this.boolPartyA,
            this.remark,
            this.list
         );
      }

      @Override
      public String toString() {
         return "OutboundDTOParam.OutboundDTOParamBuilder(id="
            + this.id
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
            + ", applicant="
            + this.applicant
            + ", basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
            + ", serialNumber="
            + this.serialNumber
            + ", applicantSN="
            + this.applicantSN
            + ", defaultName="
            + this.defaultName
            + ", defaultId="
            + this.defaultId
            + ", boolCross="
            + this.boolCross
            + ", boolPartyA="
            + this.boolPartyA
            + ", remark="
            + this.remark
            + ", list="
            + this.list
            + ")";
      }
   }
}
