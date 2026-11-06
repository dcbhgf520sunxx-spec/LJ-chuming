package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class WmsShipmentReceiveApproveListDTO {
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
   @ApiModelProperty(name = "materialType", value = "所属类型")
   private Integer materialType;
   @ApiModelProperty(name = "projectList", value = "所属项目")
   private List<ProjectInfo> projectList;
   @ApiModelProperty(name = "project", value = "领料项目")
   private ProjectInfo project;
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

   public static WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder builder() {
      return new WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder();
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

   public Integer getMaterialType() {
      return this.materialType;
   }

   public List<ProjectInfo> getProjectList() {
      return this.projectList;
   }

   public ProjectInfo getProject() {
      return this.project;
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

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setProjectList(final List<ProjectInfo> projectList) {
      this.projectList = projectList;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
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

      if (!(o instanceof WmsShipmentReceiveApproveListDTO)) {
         return false;
      }

      WmsShipmentReceiveApproveListDTO other = (WmsShipmentReceiveApproveListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialType = this.getMaterialType();
         Object other$materialType = other.getMaterialType();
         if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
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
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                                                if (this$outboundLength == null
                                                   ? other$outboundLength == null
                                                   : this$outboundLength.equals(other$outboundLength)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsShipmentReceiveApproveListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
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
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
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
      return "WmsShipmentReceiveApproveListDTO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", pickingList="
         + this.getPickingList()
         + ", outboundList="
         + this.getOutboundList()
         + ", materialType="
         + this.getMaterialType()
         + ", projectList="
         + this.getProjectList()
         + ", project="
         + this.getProject()
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

   public WmsShipmentReceiveApproveListDTO(
      final Long id,
      final LocalDateTime createTime,
      final String serialNumber,
      final List<IdAndNameDTO> pickingList,
      final List<IdAndNameDTO> outboundList,
      final Integer materialType,
      final List<ProjectInfo> projectList,
      final ProjectInfo project,
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
      this.materialType = materialType;
      this.projectList = projectList;
      this.project = project;
      this.mesWorkshopList = mesWorkshopList;
      this.applicantName = applicantName;
      this.outboundMete = outboundMete;
      this.outboundArea = outboundArea;
      this.outboundLength = outboundLength;
      this.completePickingList = completePickingList;
      this.reviewStatus = reviewStatus;
      this.approveRecordId = approveRecordId;
   }

   public WmsShipmentReceiveApproveListDTO() {
   }

   public static class WmsShipmentReceiveApproveListDTOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private String serialNumber;
      private List<IdAndNameDTO> pickingList;
      private List<IdAndNameDTO> outboundList;
      private Integer materialType;
      private List<ProjectInfo> projectList;
      private ProjectInfo project;
      private List<IdAndNameDTO> mesWorkshopList;
      private String applicantName;
      private BigDecimal outboundMete;
      private BigDecimal outboundArea;
      private BigDecimal outboundLength;
      private List<IdAndNameDTO> completePickingList;
      private Integer reviewStatus;
      private Long approveRecordId;

      WmsShipmentReceiveApproveListDTOBuilder() {
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder pickingList(final List<IdAndNameDTO> pickingList) {
         this.pickingList = pickingList;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder outboundList(final List<IdAndNameDTO> outboundList) {
         this.outboundList = outboundList;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder projectList(final List<ProjectInfo> projectList) {
         this.projectList = projectList;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder mesWorkshopList(final List<IdAndNameDTO> mesWorkshopList) {
         this.mesWorkshopList = mesWorkshopList;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder outboundArea(final BigDecimal outboundArea) {
         this.outboundArea = outboundArea;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder outboundLength(final BigDecimal outboundLength) {
         this.outboundLength = outboundLength;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder completePickingList(final List<IdAndNameDTO> completePickingList) {
         this.completePickingList = completePickingList;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public WmsShipmentReceiveApproveListDTO build() {
         return new WmsShipmentReceiveApproveListDTO(
            this.id,
            this.createTime,
            this.serialNumber,
            this.pickingList,
            this.outboundList,
            this.materialType,
            this.projectList,
            this.project,
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
         return "WmsShipmentReceiveApproveListDTO.WmsShipmentReceiveApproveListDTOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", serialNumber="
            + this.serialNumber
            + ", pickingList="
            + this.pickingList
            + ", outboundList="
            + this.outboundList
            + ", materialType="
            + this.materialType
            + ", projectList="
            + this.projectList
            + ", project="
            + this.project
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
