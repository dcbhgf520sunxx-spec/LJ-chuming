package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class BatchDeviceOutboundDTOParam {
   private Boolean boolPartyA;
   private Long applicantId;
   private String applicantName;
   private LocalDateTime outboundTime;
   private Long receiveId;
   private List<DeviceOutboundDTOParam> list;

   public static BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder builder() {
      return new BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder();
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public Long getReceiveId() {
      return this.receiveId;
   }

   public List<DeviceOutboundDTOParam> getList() {
      return this.list;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setReceiveId(final Long receiveId) {
      this.receiveId = receiveId;
   }

   public void setList(final List<DeviceOutboundDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchDeviceOutboundDTOParam)) {
         return false;
      }

      BatchDeviceOutboundDTOParam other = (BatchDeviceOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolPartyA = this.getBoolPartyA();
      Object other$boolPartyA = other.getBoolPartyA();
      if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
         Object this$applicantId = this.getApplicantId();
         Object other$applicantId = other.getApplicantId();
         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
            Object this$receiveId = this.getReceiveId();
            Object other$receiveId = other.getReceiveId();
            if (this$receiveId == null ? other$receiveId == null : this$receiveId.equals(other$receiveId)) {
               Object this$applicantName = this.getApplicantName();
               Object other$applicantName = other.getApplicantName();
               if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                  Object this$outboundTime = this.getOutboundTime();
                  Object other$outboundTime = other.getOutboundTime();
                  if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BatchDeviceOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $receiveId = this.getReceiveId();
      result = result * 59 + ($receiveId == null ? 43 : $receiveId.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "BatchDeviceOutboundDTOParam(boolPartyA="
         + this.getBoolPartyA()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", receiveId="
         + this.getReceiveId()
         + ", list="
         + this.getList()
         + ")";
   }

   public BatchDeviceOutboundDTOParam(
      final Boolean boolPartyA,
      final Long applicantId,
      final String applicantName,
      final LocalDateTime outboundTime,
      final Long receiveId,
      final List<DeviceOutboundDTOParam> list
   ) {
      this.boolPartyA = boolPartyA;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.outboundTime = outboundTime;
      this.receiveId = receiveId;
      this.list = list;
   }

   public BatchDeviceOutboundDTOParam() {
   }

   public static class BatchDeviceOutboundDTOParamBuilder {
      private Boolean boolPartyA;
      private Long applicantId;
      private String applicantName;
      private LocalDateTime outboundTime;
      private Long receiveId;
      private List<DeviceOutboundDTOParam> list;

      BatchDeviceOutboundDTOParamBuilder() {
      }

      public BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder receiveId(final Long receiveId) {
         this.receiveId = receiveId;
         return this;
      }

      public BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder list(final List<DeviceOutboundDTOParam> list) {
         this.list = list;
         return this;
      }

      public BatchDeviceOutboundDTOParam build() {
         return new BatchDeviceOutboundDTOParam(this.boolPartyA, this.applicantId, this.applicantName, this.outboundTime, this.receiveId, this.list);
      }

      @Override
      public String toString() {
         return "BatchDeviceOutboundDTOParam.BatchDeviceOutboundDTOParamBuilder(boolPartyA="
            + this.boolPartyA
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", outboundTime="
            + this.outboundTime
            + ", receiveId="
            + this.receiveId
            + ", list="
            + this.list
            + ")";
      }
   }
}
