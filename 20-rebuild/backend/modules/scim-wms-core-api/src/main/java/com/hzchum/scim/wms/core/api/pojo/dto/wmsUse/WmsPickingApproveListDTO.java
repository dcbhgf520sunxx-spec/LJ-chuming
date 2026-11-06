package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class WmsPickingApproveListDTO {
   @ApiModelProperty(name = "id", value = "领料审核单ID")
   private Long id;
   @ApiModelProperty(name = "createTime", value = "领料单创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "serialNumber", value = "领料审核单号")
   private String serialNumber;
   @ApiModelProperty(name = "pickingList", value = "领料单ID和编号集合")
   private List<IdAndNameDTO> pickingList;
   @ApiModelProperty(name = "outboundList", value = "出库单ID和编号集合")
   private List<IdAndNameDTO> outboundList;
   @ApiModelProperty(name = "projectList", value = "领料项目ID和编号集合")
   private List<ProjectInfo> projectList;
   @ApiModelProperty(name = "mesWorkshopList", value = "领料车间ID和名称集合")
   private List<IdAndNameDTO> mesWorkshopList;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "outboundMete", value = "出库总量")
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "outboundArea", value = "出库总面积(钢板适用)")
   private BigDecimal outboundArea;
   @ApiModelProperty(name = "outboundLength", value = "出库总长度(型材适用)")
   private BigDecimal outboundLength;
   @ApiModelProperty(name = "completePickingList", value = "齐套领料单ID和编号集合")
   private List<IdAndNameDTO> completePickingList;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 ReviewStatusEnum")
   private Integer reviewStatus;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID")
   private Long approveRecordId;

   public static WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder builder() {
      return new WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<IdAndNameDTO> getPickingList() {
      return this.pickingList;
   }

   public List<IdAndNameDTO> getOutboundList() {
      return this.outboundList;
   }

   public List<ProjectInfo> getProjectList() {
      return this.projectList;
   }

   public List<IdAndNameDTO> getMesWorkshopList() {
      return this.mesWorkshopList;
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

   public List<IdAndNameDTO> getCompletePickingList() {
      return this.completePickingList;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPickingList(final List<IdAndNameDTO> pickingList) {
      this.pickingList = pickingList;
   }

   public void setOutboundList(final List<IdAndNameDTO> outboundList) {
      this.outboundList = outboundList;
   }

   public void setProjectList(final List<ProjectInfo> projectList) {
      this.projectList = projectList;
   }

   public void setMesWorkshopList(final List<IdAndNameDTO> mesWorkshopList) {
      this.mesWorkshopList = mesWorkshopList;
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

   public void setCompletePickingList(final List<IdAndNameDTO> completePickingList) {
      this.completePickingList = completePickingList;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingApproveListDTO)) {
         return false;
      }

      WmsPickingApproveListDTO other = (WmsPickingApproveListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$approveRecordId = this.getApproveRecordId();
            Object other$approveRecordId = other.getApproveRecordId();
            if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
               Object this$createTime = this.getCreateTime();
               Object other$createTime = other.getCreateTime();
               if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$pickingList = this.getPickingList();
                     Object other$pickingList = other.getPickingList();
                     if (this$pickingList == null ? other$pickingList == null : this$pickingList.equals(other$pickingList)) {
                        Object this$outboundList = this.getOutboundList();
                        Object other$outboundList = other.getOutboundList();
                        if (this$outboundList == null ? other$outboundList == null : this$outboundList.equals(other$outboundList)) {
                           Object this$projectList = this.getProjectList();
                           Object other$projectList = other.getProjectList();
                           if (this$projectList == null ? other$projectList == null : this$projectList.equals(other$projectList)) {
                              Object this$mesWorkshopList = this.getMesWorkshopList();
                              Object other$mesWorkshopList = other.getMesWorkshopList();
                              if (this$mesWorkshopList == null ? other$mesWorkshopList == null : this$mesWorkshopList.equals(other$mesWorkshopList)) {
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
                                             Object this$completePickingList = this.getCompletePickingList();
                                             Object other$completePickingList = other.getCompletePickingList();
                                             return this$completePickingList == null
                                                ? other$completePickingList == null
                                                : this$completePickingList.equals(other$completePickingList);
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
      return other instanceof WmsPickingApproveListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $pickingList = this.getPickingList();
      result = result * 59 + ($pickingList == null ? 43 : $pickingList.hashCode());
      Object $outboundList = this.getOutboundList();
      result = result * 59 + ($outboundList == null ? 43 : $outboundList.hashCode());
      Object $projectList = this.getProjectList();
      result = result * 59 + ($projectList == null ? 43 : $projectList.hashCode());
      Object $mesWorkshopList = this.getMesWorkshopList();
      result = result * 59 + ($mesWorkshopList == null ? 43 : $mesWorkshopList.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $outboundArea = this.getOutboundArea();
      result = result * 59 + ($outboundArea == null ? 43 : $outboundArea.hashCode());
      Object $outboundLength = this.getOutboundLength();
      result = result * 59 + ($outboundLength == null ? 43 : $outboundLength.hashCode());
      Object $completePickingList = this.getCompletePickingList();
      return result * 59 + ($completePickingList == null ? 43 : $completePickingList.hashCode());
   }

   @Override
   public String toString() {
      return "WmsPickingApproveListDTO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", pickingList="
         + this.getPickingList()
         + ", outboundList="
         + this.getOutboundList()
         + ", projectList="
         + this.getProjectList()
         + ", mesWorkshopList="
         + this.getMesWorkshopList()
         + ", applicantName="
         + this.getApplicantName()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", outboundArea="
         + this.getOutboundArea()
         + ", outboundLength="
         + this.getOutboundLength()
         + ", completePickingList="
         + this.getCompletePickingList()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ")";
   }

   public WmsPickingApproveListDTO(
      final Long id,
      final LocalDateTime createTime,
      final String serialNumber,
      final List<IdAndNameDTO> pickingList,
      final List<IdAndNameDTO> outboundList,
      final List<ProjectInfo> projectList,
      final List<IdAndNameDTO> mesWorkshopList,
      final String applicantName,
      final BigDecimal outboundMete,
      final BigDecimal outboundArea,
      final BigDecimal outboundLength,
      final List<IdAndNameDTO> completePickingList,
      final Integer reviewStatus,
      final Long approveRecordId
   ) {
      this.id = id;
      this.createTime = createTime;
      this.serialNumber = serialNumber;
      this.pickingList = pickingList;
      this.outboundList = outboundList;
      this.projectList = projectList;
      this.mesWorkshopList = mesWorkshopList;
      this.applicantName = applicantName;
      this.outboundMete = outboundMete;
      this.outboundArea = outboundArea;
      this.outboundLength = outboundLength;
      this.completePickingList = completePickingList;
      this.reviewStatus = reviewStatus;
      this.approveRecordId = approveRecordId;
   }

   public WmsPickingApproveListDTO() {
   }

   public static class WmsPickingApproveListDTOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private String serialNumber;
      private List<IdAndNameDTO> pickingList;
      private List<IdAndNameDTO> outboundList;
      private List<ProjectInfo> projectList;
      private List<IdAndNameDTO> mesWorkshopList;
      private String applicantName;
      private BigDecimal outboundMete;
      private BigDecimal outboundArea;
      private BigDecimal outboundLength;
      private List<IdAndNameDTO> completePickingList;
      private Integer reviewStatus;
      private Long approveRecordId;

      WmsPickingApproveListDTOBuilder() {
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder pickingList(final List<IdAndNameDTO> pickingList) {
         this.pickingList = pickingList;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder outboundList(final List<IdAndNameDTO> outboundList) {
         this.outboundList = outboundList;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder projectList(final List<ProjectInfo> projectList) {
         this.projectList = projectList;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder mesWorkshopList(final List<IdAndNameDTO> mesWorkshopList) {
         this.mesWorkshopList = mesWorkshopList;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder outboundArea(final BigDecimal outboundArea) {
         this.outboundArea = outboundArea;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder outboundLength(final BigDecimal outboundLength) {
         this.outboundLength = outboundLength;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder completePickingList(final List<IdAndNameDTO> completePickingList) {
         this.completePickingList = completePickingList;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public WmsPickingApproveListDTO build() {
         return new WmsPickingApproveListDTO(
            this.id,
            this.createTime,
            this.serialNumber,
            this.pickingList,
            this.outboundList,
            this.projectList,
            this.mesWorkshopList,
            this.applicantName,
            this.outboundMete,
            this.outboundArea,
            this.outboundLength,
            this.completePickingList,
            this.reviewStatus,
            this.approveRecordId
         );
      }

      @Override
      public String toString() {
         return "WmsPickingApproveListDTO.WmsPickingApproveListDTOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", serialNumber="
            + this.serialNumber
            + ", pickingList="
            + this.pickingList
            + ", outboundList="
            + this.outboundList
            + ", projectList="
            + this.projectList
            + ", mesWorkshopList="
            + this.mesWorkshopList
            + ", applicantName="
            + this.applicantName
            + ", outboundMete="
            + this.outboundMete
            + ", outboundArea="
            + this.outboundArea
            + ", outboundLength="
            + this.outboundLength
            + ", completePickingList="
            + this.completePickingList
            + ", reviewStatus="
            + this.reviewStatus
            + ", approveRecordId="
            + this.approveRecordId
            + ")";
      }
   }
}
