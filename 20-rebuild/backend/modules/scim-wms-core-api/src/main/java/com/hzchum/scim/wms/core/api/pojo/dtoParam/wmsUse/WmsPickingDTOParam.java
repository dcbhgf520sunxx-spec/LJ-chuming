package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class WmsPickingDTOParam {
   private Long projectId;
   private Long mesWorkshopId;
   private Long applicantId;
   private String applicantName;
   private String taskOrderNumber;
   private String materialType;
   private BigDecimal pickingMete;
   private BigDecimal outboundMete;
   private BigDecimal pickingArea;
   private BigDecimal handlingArea;
   private BigDecimal pickingLength;
   private BigDecimal handlingLength;
   private Integer transactStatus;
   private Long taskOrderId;
   private Boolean boolAuto;
   private List<WmsPickingDetailDTOParam> List;
   private List<LocalDateTime> times;

   public static WmsPickingDTOParam.WmsPickingDTOParamBuilder builder() {
      return new WmsPickingDTOParam.WmsPickingDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public String getMaterialType() {
      return this.materialType;
   }

   public BigDecimal getPickingMete() {
      return this.pickingMete;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getPickingArea() {
      return this.pickingArea;
   }

   public BigDecimal getHandlingArea() {
      return this.handlingArea;
   }

   public BigDecimal getPickingLength() {
      return this.pickingLength;
   }

   public BigDecimal getHandlingLength() {
      return this.handlingLength;
   }

   public Integer getTransactStatus() {
      return this.transactStatus;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Boolean getBoolAuto() {
      return this.boolAuto;
   }

   public List<WmsPickingDetailDTOParam> getList() {
      return this.List;
   }

   public List<LocalDateTime> getTimes() {
      return this.times;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setMaterialType(final String materialType) {
      this.materialType = materialType;
   }

   public void setPickingMete(final BigDecimal pickingMete) {
      this.pickingMete = pickingMete;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setPickingArea(final BigDecimal pickingArea) {
      this.pickingArea = pickingArea;
   }

   public void setHandlingArea(final BigDecimal handlingArea) {
      this.handlingArea = handlingArea;
   }

   public void setPickingLength(final BigDecimal pickingLength) {
      this.pickingLength = pickingLength;
   }

   public void setHandlingLength(final BigDecimal handlingLength) {
      this.handlingLength = handlingLength;
   }

   public void setTransactStatus(final Integer transactStatus) {
      this.transactStatus = transactStatus;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setBoolAuto(final Boolean boolAuto) {
      this.boolAuto = boolAuto;
   }

   public void setList(final List<WmsPickingDetailDTOParam> List) {
      this.List = List;
   }

   public void setTimes(final List<LocalDateTime> times) {
      this.times = times;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingDTOParam)) {
         return false;
      }

      WmsPickingDTOParam other = (WmsPickingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$mesWorkshopId = this.getMesWorkshopId();
         Object other$mesWorkshopId = other.getMesWorkshopId();
         if (this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId)) {
            Object this$applicantId = this.getApplicantId();
            Object other$applicantId = other.getApplicantId();
            if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
               Object this$transactStatus = this.getTransactStatus();
               Object other$transactStatus = other.getTransactStatus();
               if (this$transactStatus == null ? other$transactStatus == null : this$transactStatus.equals(other$transactStatus)) {
                  Object this$taskOrderId = this.getTaskOrderId();
                  Object other$taskOrderId = other.getTaskOrderId();
                  if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                     Object this$boolAuto = this.getBoolAuto();
                     Object other$boolAuto = other.getBoolAuto();
                     if (this$boolAuto == null ? other$boolAuto == null : this$boolAuto.equals(other$boolAuto)) {
                        Object this$applicantName = this.getApplicantName();
                        Object other$applicantName = other.getApplicantName();
                        if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                           Object this$taskOrderNumber = this.getTaskOrderNumber();
                           Object other$taskOrderNumber = other.getTaskOrderNumber();
                           if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                              Object this$materialType = this.getMaterialType();
                              Object other$materialType = other.getMaterialType();
                              if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                                 Object this$pickingMete = this.getPickingMete();
                                 Object other$pickingMete = other.getPickingMete();
                                 if (this$pickingMete == null ? other$pickingMete == null : this$pickingMete.equals(other$pickingMete)) {
                                    Object this$outboundMete = this.getOutboundMete();
                                    Object other$outboundMete = other.getOutboundMete();
                                    if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                       Object this$pickingArea = this.getPickingArea();
                                       Object other$pickingArea = other.getPickingArea();
                                       if (this$pickingArea == null ? other$pickingArea == null : this$pickingArea.equals(other$pickingArea)) {
                                          Object this$handlingArea = this.getHandlingArea();
                                          Object other$handlingArea = other.getHandlingArea();
                                          if (this$handlingArea == null ? other$handlingArea == null : this$handlingArea.equals(other$handlingArea)) {
                                             Object this$pickingLength = this.getPickingLength();
                                             Object other$pickingLength = other.getPickingLength();
                                             if (this$pickingLength == null ? other$pickingLength == null : this$pickingLength.equals(other$pickingLength)) {
                                                Object this$handlingLength = this.getHandlingLength();
                                                Object other$handlingLength = other.getHandlingLength();
                                                if (this$handlingLength == null
                                                   ? other$handlingLength == null
                                                   : this$handlingLength.equals(other$handlingLength)) {
                                                   Object this$List = this.getList();
                                                   Object other$List = other.getList();
                                                   if (this$List == null ? other$List == null : this$List.equals(other$List)) {
                                                      Object this$times = this.getTimes();
                                                      Object other$times = other.getTimes();
                                                      return this$times == null ? other$times == null : this$times.equals(other$times);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsPickingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $transactStatus = this.getTransactStatus();
      result = result * 59 + ($transactStatus == null ? 43 : $transactStatus.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $boolAuto = this.getBoolAuto();
      result = result * 59 + ($boolAuto == null ? 43 : $boolAuto.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $pickingMete = this.getPickingMete();
      result = result * 59 + ($pickingMete == null ? 43 : $pickingMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $pickingArea = this.getPickingArea();
      result = result * 59 + ($pickingArea == null ? 43 : $pickingArea.hashCode());
      Object $handlingArea = this.getHandlingArea();
      result = result * 59 + ($handlingArea == null ? 43 : $handlingArea.hashCode());
      Object $pickingLength = this.getPickingLength();
      result = result * 59 + ($pickingLength == null ? 43 : $pickingLength.hashCode());
      Object $handlingLength = this.getHandlingLength();
      result = result * 59 + ($handlingLength == null ? 43 : $handlingLength.hashCode());
      Object $List = this.getList();
      result = result * 59 + ($List == null ? 43 : $List.hashCode());
      Object $times = this.getTimes();
      return result * 59 + ($times == null ? 43 : $times.hashCode());
   }

   @Override
   public String toString() {
      return "WmsPickingDTOParam(projectId="
         + this.getProjectId()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", materialType="
         + this.getMaterialType()
         + ", pickingMete="
         + this.getPickingMete()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", pickingArea="
         + this.getPickingArea()
         + ", handlingArea="
         + this.getHandlingArea()
         + ", pickingLength="
         + this.getPickingLength()
         + ", handlingLength="
         + this.getHandlingLength()
         + ", transactStatus="
         + this.getTransactStatus()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", boolAuto="
         + this.getBoolAuto()
         + ", List="
         + this.getList()
         + ", times="
         + this.getTimes()
         + ")";
   }

   public WmsPickingDTOParam(
      final Long projectId,
      final Long mesWorkshopId,
      final Long applicantId,
      final String applicantName,
      final String taskOrderNumber,
      final String materialType,
      final BigDecimal pickingMete,
      final BigDecimal outboundMete,
      final BigDecimal pickingArea,
      final BigDecimal handlingArea,
      final BigDecimal pickingLength,
      final BigDecimal handlingLength,
      final Integer transactStatus,
      final Long taskOrderId,
      final Boolean boolAuto,
      final List<WmsPickingDetailDTOParam> List,
      final List<LocalDateTime> times
   ) {
      this.projectId = projectId;
      this.mesWorkshopId = mesWorkshopId;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.taskOrderNumber = taskOrderNumber;
      this.materialType = materialType;
      this.pickingMete = pickingMete;
      this.outboundMete = outboundMete;
      this.pickingArea = pickingArea;
      this.handlingArea = handlingArea;
      this.pickingLength = pickingLength;
      this.handlingLength = handlingLength;
      this.transactStatus = transactStatus;
      this.taskOrderId = taskOrderId;
      this.boolAuto = boolAuto;
      this.List = List;
      this.times = times;
   }

   public WmsPickingDTOParam() {
   }

   public static class WmsPickingDTOParamBuilder {
      private Long projectId;
      private Long mesWorkshopId;
      private Long applicantId;
      private String applicantName;
      private String taskOrderNumber;
      private String materialType;
      private BigDecimal pickingMete;
      private BigDecimal outboundMete;
      private BigDecimal pickingArea;
      private BigDecimal handlingArea;
      private BigDecimal pickingLength;
      private BigDecimal handlingLength;
      private Integer transactStatus;
      private Long taskOrderId;
      private Boolean boolAuto;
      private List<WmsPickingDetailDTOParam> List;
      private List<LocalDateTime> times;

      WmsPickingDTOParamBuilder() {
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder materialType(final String materialType) {
         this.materialType = materialType;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder pickingMete(final BigDecimal pickingMete) {
         this.pickingMete = pickingMete;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder pickingArea(final BigDecimal pickingArea) {
         this.pickingArea = pickingArea;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder handlingArea(final BigDecimal handlingArea) {
         this.handlingArea = handlingArea;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder pickingLength(final BigDecimal pickingLength) {
         this.pickingLength = pickingLength;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder handlingLength(final BigDecimal handlingLength) {
         this.handlingLength = handlingLength;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder transactStatus(final Integer transactStatus) {
         this.transactStatus = transactStatus;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder boolAuto(final Boolean boolAuto) {
         this.boolAuto = boolAuto;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder List(final List<WmsPickingDetailDTOParam> List) {
         this.List = List;
         return this;
      }

      public WmsPickingDTOParam.WmsPickingDTOParamBuilder times(final List<LocalDateTime> times) {
         this.times = times;
         return this;
      }

      public WmsPickingDTOParam build() {
         return new WmsPickingDTOParam(
            this.projectId,
            this.mesWorkshopId,
            this.applicantId,
            this.applicantName,
            this.taskOrderNumber,
            this.materialType,
            this.pickingMete,
            this.outboundMete,
            this.pickingArea,
            this.handlingArea,
            this.pickingLength,
            this.handlingLength,
            this.transactStatus,
            this.taskOrderId,
            this.boolAuto,
            this.List,
            this.times
         );
      }

      @Override
      public String toString() {
         return "WmsPickingDTOParam.WmsPickingDTOParamBuilder(projectId="
            + this.projectId
            + ", mesWorkshopId="
            + this.mesWorkshopId
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", materialType="
            + this.materialType
            + ", pickingMete="
            + this.pickingMete
            + ", outboundMete="
            + this.outboundMete
            + ", pickingArea="
            + this.pickingArea
            + ", handlingArea="
            + this.handlingArea
            + ", pickingLength="
            + this.pickingLength
            + ", handlingLength="
            + this.handlingLength
            + ", transactStatus="
            + this.transactStatus
            + ", taskOrderId="
            + this.taskOrderId
            + ", boolAuto="
            + this.boolAuto
            + ", List="
            + this.List
            + ", times="
            + this.times
            + ")";
      }
   }
}
