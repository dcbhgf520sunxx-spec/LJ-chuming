package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class WmsPickingApproveDTO implements Serializable {
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "领料审核单编号")
   private String serialNumber;
   @ApiModelProperty(name = "applicantId", value = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "outboundMete", value = "出库总量")
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "outboundArea", value = "出库总面积(钢板适用)")
   private BigDecimal outboundArea;
   @ApiModelProperty(name = "outboundLength", value = "出库总长度(型材适用)")
   private BigDecimal outboundLength;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 ReviewStatusEnum")
   private Integer reviewStatus;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID")
   private Long approveRecordId;
   @ApiModelProperty(name = "wmsPickingApproveDetailDTOList", value = "本次领料单信息")
   private List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOList;
   @ApiModelProperty(name = "wmsApproveRecordFlowDTO", value = "审批日志信息", notes = "审批日志信息")
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;
   @ApiModelProperty(name = "wmsPickingDTOList", value = "排产领料信息集合")
   private List<IdAndNameDTO> wmsPickingDTOList;
   @ApiModelProperty(name = "outboundListDTOS", value = "出库信息集合")
   private List<IdAndNameDTO> outboundListDTOS;
   @ApiModelProperty(name = "wmsPickingDetailDTO", value = "领料明细信息纬度展示")
   private List<WmsPickingDetailDTO> wmsPickingDetailDTO;
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

   public BigDecimal getOutboundArea() {
      return this.outboundArea;
   }

   public BigDecimal getOutboundLength() {
      return this.outboundLength;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public List<WmsPickingApproveDetailDTO> getWmsPickingApproveDetailDTOList() {
      return this.wmsPickingApproveDetailDTOList;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
   }

   public List<IdAndNameDTO> getWmsPickingDTOList() {
      return this.wmsPickingDTOList;
   }

   public List<IdAndNameDTO> getOutboundListDTOS() {
      return this.outboundListDTOS;
   }

   public List<WmsPickingDetailDTO> getWmsPickingDetailDTO() {
      return this.wmsPickingDetailDTO;
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

   public void setOutboundArea(final BigDecimal outboundArea) {
      this.outboundArea = outboundArea;
   }

   public void setOutboundLength(final BigDecimal outboundLength) {
      this.outboundLength = outboundLength;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setWmsPickingApproveDetailDTOList(final List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOList) {
      this.wmsPickingApproveDetailDTOList = wmsPickingApproveDetailDTOList;
   }

   public void setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   public void setWmsPickingDTOList(final List<IdAndNameDTO> wmsPickingDTOList) {
      this.wmsPickingDTOList = wmsPickingDTOList;
   }

   public void setOutboundListDTOS(final List<IdAndNameDTO> outboundListDTOS) {
      this.outboundListDTOS = outboundListDTOS;
   }

   public void setWmsPickingDetailDTO(final List<WmsPickingDetailDTO> wmsPickingDetailDTO) {
      this.wmsPickingDetailDTO = wmsPickingDetailDTO;
   }

   public void setMaterialType(final String materialType) {
      this.materialType = materialType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingApproveDTO)) {
         return false;
      }

      WmsPickingApproveDTO other = (WmsPickingApproveDTO)o;
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
                           Object this$outboundArea = this.getOutboundArea();
                           Object other$outboundArea = other.getOutboundArea();
                           if (this$outboundArea == null ? other$outboundArea == null : this$outboundArea.equals(other$outboundArea)) {
                              Object this$outboundLength = this.getOutboundLength();
                              Object other$outboundLength = other.getOutboundLength();
                              if (this$outboundLength == null ? other$outboundLength == null : this$outboundLength.equals(other$outboundLength)) {
                                 Object this$wmsPickingApproveDetailDTOList = this.getWmsPickingApproveDetailDTOList();
                                 Object other$wmsPickingApproveDetailDTOList = other.getWmsPickingApproveDetailDTOList();
                                 if (this$wmsPickingApproveDetailDTOList == null
                                    ? other$wmsPickingApproveDetailDTOList == null
                                    : this$wmsPickingApproveDetailDTOList.equals(other$wmsPickingApproveDetailDTOList)) {
                                    Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                                    Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                                    if (this$wmsApproveRecordFlowDTO == null
                                       ? other$wmsApproveRecordFlowDTO == null
                                       : this$wmsApproveRecordFlowDTO.equals(other$wmsApproveRecordFlowDTO)) {
                                       Object this$wmsPickingDTOList = this.getWmsPickingDTOList();
                                       Object other$wmsPickingDTOList = other.getWmsPickingDTOList();
                                       if (this$wmsPickingDTOList == null
                                          ? other$wmsPickingDTOList == null
                                          : this$wmsPickingDTOList.equals(other$wmsPickingDTOList)) {
                                          Object this$outboundListDTOS = this.getOutboundListDTOS();
                                          Object other$outboundListDTOS = other.getOutboundListDTOS();
                                          if (this$outboundListDTOS == null
                                             ? other$outboundListDTOS == null
                                             : this$outboundListDTOS.equals(other$outboundListDTOS)) {
                                             Object this$wmsPickingDetailDTO = this.getWmsPickingDetailDTO();
                                             Object other$wmsPickingDetailDTO = other.getWmsPickingDetailDTO();
                                             if (this$wmsPickingDetailDTO == null
                                                ? other$wmsPickingDetailDTO == null
                                                : this$wmsPickingDetailDTO.equals(other$wmsPickingDetailDTO)) {
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
      return other instanceof WmsPickingApproveDTO;
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
      Object $outboundArea = this.getOutboundArea();
      result = result * 59 + ($outboundArea == null ? 43 : $outboundArea.hashCode());
      Object $outboundLength = this.getOutboundLength();
      result = result * 59 + ($outboundLength == null ? 43 : $outboundLength.hashCode());
      Object $wmsPickingApproveDetailDTOList = this.getWmsPickingApproveDetailDTOList();
      result = result * 59 + ($wmsPickingApproveDetailDTOList == null ? 43 : $wmsPickingApproveDetailDTOList.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      result = result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
      Object $wmsPickingDTOList = this.getWmsPickingDTOList();
      result = result * 59 + ($wmsPickingDTOList == null ? 43 : $wmsPickingDTOList.hashCode());
      Object $outboundListDTOS = this.getOutboundListDTOS();
      result = result * 59 + ($outboundListDTOS == null ? 43 : $outboundListDTOS.hashCode());
      Object $wmsPickingDetailDTO = this.getWmsPickingDetailDTO();
      result = result * 59 + ($wmsPickingDetailDTO == null ? 43 : $wmsPickingDetailDTO.hashCode());
      Object $materialType = this.getMaterialType();
      return result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
   }

   @Override
   public String toString() {
      return "WmsPickingApproveDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", outboundArea="
         + this.getOutboundArea()
         + ", outboundLength="
         + this.getOutboundLength()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", wmsPickingApproveDetailDTOList="
         + this.getWmsPickingApproveDetailDTOList()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ", wmsPickingDTOList="
         + this.getWmsPickingDTOList()
         + ", outboundListDTOS="
         + this.getOutboundListDTOS()
         + ", wmsPickingDetailDTO="
         + this.getWmsPickingDetailDTO()
         + ", materialType="
         + this.getMaterialType()
         + ")";
   }
}
