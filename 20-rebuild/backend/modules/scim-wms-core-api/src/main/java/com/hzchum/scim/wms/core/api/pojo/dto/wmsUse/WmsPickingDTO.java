package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class WmsPickingDTO {
   private Long id;
   private ProjectInfoDTO project;
   private IdAndNameDTO mesWorkshop;
   private IdAndNameDTO applicant;
   private String taskOrderNumber;
   private String materialType;
   private BigDecimal outboundQuantity;
   private BigDecimal pickingMete;
   private BigDecimal outboundMete;
   private BigDecimal pickingArea;
   private BigDecimal handlingArea;
   private BigDecimal pickingLength;
   private BigDecimal handlingLength;
   private Integer transactStatus;
   private Long taskOrderId;
   private Boolean boolAuto;
   private List<Long> outboundIds;
   private LocalDateTime createTime;
   private List<WmsPickingDetailDTO> wmsPickingDetailDTOList;
   private Boolean boolOut;

   public Long getId() {
      return this.id;
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public IdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public IdAndNameDTO getApplicant() {
      return this.applicant;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public String getMaterialType() {
      return this.materialType;
   }

   public BigDecimal getOutboundQuantity() {
      return this.outboundQuantity;
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

   public List<Long> getOutboundIds() {
      return this.outboundIds;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public List<WmsPickingDetailDTO> getWmsPickingDetailDTOList() {
      return this.wmsPickingDetailDTOList;
   }

   public Boolean getBoolOut() {
      return this.boolOut;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setMesWorkshop(final IdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setApplicant(final IdAndNameDTO applicant) {
      this.applicant = applicant;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setMaterialType(final String materialType) {
      this.materialType = materialType;
   }

   public void setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
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

   public void setOutboundIds(final List<Long> outboundIds) {
      this.outboundIds = outboundIds;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setWmsPickingDetailDTOList(final List<WmsPickingDetailDTO> wmsPickingDetailDTOList) {
      this.wmsPickingDetailDTOList = wmsPickingDetailDTOList;
   }

   public void setBoolOut(final Boolean boolOut) {
      this.boolOut = boolOut;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingDTO)) {
         return false;
      }

      WmsPickingDTO other = (WmsPickingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$transactStatus = this.getTransactStatus();
         Object other$transactStatus = other.getTransactStatus();
         if (this$transactStatus == null ? other$transactStatus == null : this$transactStatus.equals(other$transactStatus)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$boolAuto = this.getBoolAuto();
               Object other$boolAuto = other.getBoolAuto();
               if (this$boolAuto == null ? other$boolAuto == null : this$boolAuto.equals(other$boolAuto)) {
                  Object this$boolOut = this.getBoolOut();
                  Object other$boolOut = other.getBoolOut();
                  if (this$boolOut == null ? other$boolOut == null : this$boolOut.equals(other$boolOut)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$mesWorkshop = this.getMesWorkshop();
                        Object other$mesWorkshop = other.getMesWorkshop();
                        if (this$mesWorkshop == null ? other$mesWorkshop == null : this$mesWorkshop.equals(other$mesWorkshop)) {
                           Object this$applicant = this.getApplicant();
                           Object other$applicant = other.getApplicant();
                           if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
                              Object this$taskOrderNumber = this.getTaskOrderNumber();
                              Object other$taskOrderNumber = other.getTaskOrderNumber();
                              if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                                 Object this$materialType = this.getMaterialType();
                                 Object other$materialType = other.getMaterialType();
                                 if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                                    Object this$outboundQuantity = this.getOutboundQuantity();
                                    Object other$outboundQuantity = other.getOutboundQuantity();
                                    if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
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
                                                   if (this$pickingLength == null
                                                      ? other$pickingLength == null
                                                      : this$pickingLength.equals(other$pickingLength)) {
                                                      Object this$handlingLength = this.getHandlingLength();
                                                      Object other$handlingLength = other.getHandlingLength();
                                                      if (this$handlingLength == null
                                                         ? other$handlingLength == null
                                                         : this$handlingLength.equals(other$handlingLength)) {
                                                         Object this$outboundIds = this.getOutboundIds();
                                                         Object other$outboundIds = other.getOutboundIds();
                                                         if (this$outboundIds == null ? other$outboundIds == null : this$outboundIds.equals(other$outboundIds)) {
                                                            Object this$createTime = this.getCreateTime();
                                                            Object other$createTime = other.getCreateTime();
                                                            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                               Object this$wmsPickingDetailDTOList = this.getWmsPickingDetailDTOList();
                                                               Object other$wmsPickingDetailDTOList = other.getWmsPickingDetailDTOList();
                                                               return this$wmsPickingDetailDTOList == null
                                                                  ? other$wmsPickingDetailDTOList == null
                                                                  : this$wmsPickingDetailDTOList.equals(other$wmsPickingDetailDTOList);
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
      return other instanceof WmsPickingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $transactStatus = this.getTransactStatus();
      result = result * 59 + ($transactStatus == null ? 43 : $transactStatus.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $boolAuto = this.getBoolAuto();
      result = result * 59 + ($boolAuto == null ? 43 : $boolAuto.hashCode());
      Object $boolOut = this.getBoolOut();
      result = result * 59 + ($boolOut == null ? 43 : $boolOut.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
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
      Object $outboundIds = this.getOutboundIds();
      result = result * 59 + ($outboundIds == null ? 43 : $outboundIds.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $wmsPickingDetailDTOList = this.getWmsPickingDetailDTOList();
      return result * 59 + ($wmsPickingDetailDTOList == null ? 43 : $wmsPickingDetailDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "WmsPickingDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", applicant="
         + this.getApplicant()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", materialType="
         + this.getMaterialType()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
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
         + ", outboundIds="
         + this.getOutboundIds()
         + ", createTime="
         + this.getCreateTime()
         + ", wmsPickingDetailDTOList="
         + this.getWmsPickingDetailDTOList()
         + ", boolOut="
         + this.getBoolOut()
         + ")";
   }
}
