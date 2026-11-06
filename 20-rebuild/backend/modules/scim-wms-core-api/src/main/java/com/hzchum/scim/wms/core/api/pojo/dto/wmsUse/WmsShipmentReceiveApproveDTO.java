package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class WmsShipmentReceiveApproveDTO implements Serializable {
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "发运领用审核编号")
   private String serialNumber;
   @ApiModelProperty(name = "applicantId", value = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "outboundMete", value = "出库总量")
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 ReviewStatusEnum")
   private Integer reviewStatus;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID")
   private Long approveRecordId;
   @ApiModelProperty(name = "wmsShipmentReceiveApproveDetailDTOS", value = "本次发运领用明细信息")
   private List<WmsShipmentReceiveApproveDetailDTO> wmsShipmentReceiveApproveDetailDTOS;
   @ApiModelProperty(name = "wmsApproveRecordFlowDTO", value = "审批日志信息", notes = "审批日志信息")
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;
   @ApiModelProperty(name = "outboundListDTOS", value = "出库信息集合")
   private List<IdAndNameDTO> outboundListDTOS;
   @ApiModelProperty(name = "materialType", value = "领料类型")
   private String materialType;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public List<WmsShipmentReceiveApproveDetailDTO> getWmsShipmentReceiveApproveDetailDTOS() {
      return this.wmsShipmentReceiveApproveDetailDTOS;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
   }

   public List<IdAndNameDTO> getOutboundListDTOS() {
      return this.outboundListDTOS;
   }

   public String getMaterialType() {
      return this.materialType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setWmsShipmentReceiveApproveDetailDTOS(final List<WmsShipmentReceiveApproveDetailDTO> wmsShipmentReceiveApproveDetailDTOS) {
      this.wmsShipmentReceiveApproveDetailDTOS = wmsShipmentReceiveApproveDetailDTOS;
   }

   public void setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   public void setOutboundListDTOS(final List<IdAndNameDTO> outboundListDTOS) {
      this.outboundListDTOS = outboundListDTOS;
   }

   public void setMaterialType(final String materialType) {
      this.materialType = materialType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsShipmentReceiveApproveDTO)) {
         return false;
      }

      WmsShipmentReceiveApproveDTO other = (WmsShipmentReceiveApproveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applicantId = this.getApplicantId();
         Object other$applicantId = other.getApplicantId();
         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$approveRecordId = this.getApproveRecordId();
               Object other$approveRecordId = other.getApproveRecordId();
               if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$applicantName = this.getApplicantName();
                     Object other$applicantName = other.getApplicantName();
                     if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                        Object this$outboundMete = this.getOutboundMete();
                        Object other$outboundMete = other.getOutboundMete();
                        if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                           Object this$wmsShipmentReceiveApproveDetailDTOS = this.getWmsShipmentReceiveApproveDetailDTOS();
                           Object other$wmsShipmentReceiveApproveDetailDTOS = other.getWmsShipmentReceiveApproveDetailDTOS();
                           if (this$wmsShipmentReceiveApproveDetailDTOS == null
                              ? other$wmsShipmentReceiveApproveDetailDTOS == null
                              : this$wmsShipmentReceiveApproveDetailDTOS.equals(other$wmsShipmentReceiveApproveDetailDTOS)) {
                              Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                              Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                              if (this$wmsApproveRecordFlowDTO == null
                                 ? other$wmsApproveRecordFlowDTO == null
                                 : this$wmsApproveRecordFlowDTO.equals(other$wmsApproveRecordFlowDTO)) {
                                 Object this$outboundListDTOS = this.getOutboundListDTOS();
                                 Object other$outboundListDTOS = other.getOutboundListDTOS();
                                 if (this$outboundListDTOS == null ? other$outboundListDTOS == null : this$outboundListDTOS.equals(other$outboundListDTOS)) {
                                    Object this$materialType = this.getMaterialType();
                                    Object other$materialType = other.getMaterialType();
                                    return this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType);
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
      return other instanceof WmsShipmentReceiveApproveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $wmsShipmentReceiveApproveDetailDTOS = this.getWmsShipmentReceiveApproveDetailDTOS();
      result = result * 59 + ($wmsShipmentReceiveApproveDetailDTOS == null ? 43 : $wmsShipmentReceiveApproveDetailDTOS.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      result = result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
      Object $outboundListDTOS = this.getOutboundListDTOS();
      result = result * 59 + ($outboundListDTOS == null ? 43 : $outboundListDTOS.hashCode());
      Object $materialType = this.getMaterialType();
      return result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
   }

   @Override
   public String toString() {
      return "WmsShipmentReceiveApproveDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", wmsShipmentReceiveApproveDetailDTOS="
         + this.getWmsShipmentReceiveApproveDetailDTOS()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ", outboundListDTOS="
         + this.getOutboundListDTOS()
         + ", materialType="
         + this.getMaterialType()
         + ")";
   }
}
