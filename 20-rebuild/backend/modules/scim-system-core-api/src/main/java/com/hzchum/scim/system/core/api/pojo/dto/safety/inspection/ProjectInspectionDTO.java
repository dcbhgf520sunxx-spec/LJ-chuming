package com.hzchum.scim.system.core.api.pojo.dto.safety.inspection;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("巡检点DTO")
public class ProjectInspectionDTO {
   @ApiModelProperty(name = "id", notes = "巡检点id")
   private Long id;
   @ApiModelProperty(name = "name", value = "巡检点名字", notes = "巡检点名字")
   private String name;
   @ApiModelProperty(name = "status", value = "巡检点状态", notes = "巡检点状态")
   private Integer status;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "sortNumber", value = "排序序号", notes = "排序序号")
   private Integer sortNumber;
   @ApiModelProperty(name = "point", notes = "点位")
   private String point;
   @ApiModelProperty(name = "pointName", notes = "点位名称")
   private String pointName;
   @ApiModelProperty(name = "aroundRadius", notes = "半径")
   private Long aroundRadius;
   @ApiModelProperty(name = "attachmentDTO", value = "附件", notes = "点位照片附件")
   private AttachmentDTO attachmentDTO;
   @ApiModelProperty(name = "inspectionTimeList", value = "巡检时间", notes = "巡检时间")
   private List<LocalDateTime> inspectionTimeList;
   @ApiModelProperty(name = "mandatoryInspection", value = "是否强制巡检")
   private boolean mandatoryInspection;
   @ApiModelProperty(name = "nfcSoleId", value = "nfc唯一id", notes = "nfc唯一id")
   private String nfcSoleId;
   @ApiModelProperty(name = "inspectionAttachmentList", value = "巡检附件", notes = "巡检附件")
   private List<AttachmentDTO> inspectionAttachmentList;

   public static ProjectInspectionDTO.ProjectInspectionDTOBuilder builder() {
      return new ProjectInspectionDTO.ProjectInspectionDTOBuilder();
   }

   public ProjectInspectionDTO() {
   }

   public ProjectInspectionDTO(
      final Long id,
      final String name,
      final Integer status,
      final Long projectId,
      final Integer sortNumber,
      final String point,
      final String pointName,
      final Long aroundRadius,
      final AttachmentDTO attachmentDTO,
      final List<LocalDateTime> inspectionTimeList,
      final boolean mandatoryInspection,
      final String nfcSoleId,
      final List<AttachmentDTO> inspectionAttachmentList
   ) {
      this.id = id;
      this.name = name;
      this.status = status;
      this.projectId = projectId;
      this.sortNumber = sortNumber;
      this.point = point;
      this.pointName = pointName;
      this.aroundRadius = aroundRadius;
      this.attachmentDTO = attachmentDTO;
      this.inspectionTimeList = inspectionTimeList;
      this.mandatoryInspection = mandatoryInspection;
      this.nfcSoleId = nfcSoleId;
      this.inspectionAttachmentList = inspectionAttachmentList;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public String getPoint() {
      return this.point;
   }

   public String getPointName() {
      return this.pointName;
   }

   public Long getAroundRadius() {
      return this.aroundRadius;
   }

   public AttachmentDTO getAttachmentDTO() {
      return this.attachmentDTO;
   }

   public List<LocalDateTime> getInspectionTimeList() {
      return this.inspectionTimeList;
   }

   public boolean isMandatoryInspection() {
      return this.mandatoryInspection;
   }

   public String getNfcSoleId() {
      return this.nfcSoleId;
   }

   public List<AttachmentDTO> getInspectionAttachmentList() {
      return this.inspectionAttachmentList;
   }

   public ProjectInspectionDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ProjectInspectionDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ProjectInspectionDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectInspectionDTO setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   public ProjectInspectionDTO setPoint(final String point) {
      this.point = point;
      return this;
   }

   public ProjectInspectionDTO setPointName(final String pointName) {
      this.pointName = pointName;
      return this;
   }

   public ProjectInspectionDTO setAroundRadius(final Long aroundRadius) {
      this.aroundRadius = aroundRadius;
      return this;
   }

   public ProjectInspectionDTO setAttachmentDTO(final AttachmentDTO attachmentDTO) {
      this.attachmentDTO = attachmentDTO;
      return this;
   }

   public ProjectInspectionDTO setInspectionTimeList(final List<LocalDateTime> inspectionTimeList) {
      this.inspectionTimeList = inspectionTimeList;
      return this;
   }

   public ProjectInspectionDTO setMandatoryInspection(final boolean mandatoryInspection) {
      this.mandatoryInspection = mandatoryInspection;
      return this;
   }

   public ProjectInspectionDTO setNfcSoleId(final String nfcSoleId) {
      this.nfcSoleId = nfcSoleId;
      return this;
   }

   public ProjectInspectionDTO setInspectionAttachmentList(final List<AttachmentDTO> inspectionAttachmentList) {
      this.inspectionAttachmentList = inspectionAttachmentList;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", status="
         + this.getStatus()
         + ", projectId="
         + this.getProjectId()
         + ", sortNumber="
         + this.getSortNumber()
         + ", point="
         + this.getPoint()
         + ", pointName="
         + this.getPointName()
         + ", aroundRadius="
         + this.getAroundRadius()
         + ", attachmentDTO="
         + this.getAttachmentDTO()
         + ", inspectionTimeList="
         + this.getInspectionTimeList()
         + ", mandatoryInspection="
         + this.isMandatoryInspection()
         + ", nfcSoleId="
         + this.getNfcSoleId()
         + ", inspectionAttachmentList="
         + this.getInspectionAttachmentList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionDTO)) {
         return false;
      }

      ProjectInspectionDTO other = (ProjectInspectionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isMandatoryInspection() != other.isMandatoryInspection()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$sortNumber = this.getSortNumber();
               Object other$sortNumber = other.getSortNumber();
               if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
                  Object this$aroundRadius = this.getAroundRadius();
                  Object other$aroundRadius = other.getAroundRadius();
                  if (this$aroundRadius == null ? other$aroundRadius == null : this$aroundRadius.equals(other$aroundRadius)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$point = this.getPoint();
                        Object other$point = other.getPoint();
                        if (this$point == null ? other$point == null : this$point.equals(other$point)) {
                           Object this$pointName = this.getPointName();
                           Object other$pointName = other.getPointName();
                           if (this$pointName == null ? other$pointName == null : this$pointName.equals(other$pointName)) {
                              Object this$attachmentDTO = this.getAttachmentDTO();
                              Object other$attachmentDTO = other.getAttachmentDTO();
                              if (this$attachmentDTO == null ? other$attachmentDTO == null : this$attachmentDTO.equals(other$attachmentDTO)) {
                                 Object this$inspectionTimeList = this.getInspectionTimeList();
                                 Object other$inspectionTimeList = other.getInspectionTimeList();
                                 if (this$inspectionTimeList == null
                                    ? other$inspectionTimeList == null
                                    : this$inspectionTimeList.equals(other$inspectionTimeList)) {
                                    Object this$nfcSoleId = this.getNfcSoleId();
                                    Object other$nfcSoleId = other.getNfcSoleId();
                                    if (this$nfcSoleId == null ? other$nfcSoleId == null : this$nfcSoleId.equals(other$nfcSoleId)) {
                                       Object this$inspectionAttachmentList = this.getInspectionAttachmentList();
                                       Object other$inspectionAttachmentList = other.getInspectionAttachmentList();
                                       return this$inspectionAttachmentList == null
                                          ? other$inspectionAttachmentList == null
                                          : this$inspectionAttachmentList.equals(other$inspectionAttachmentList);
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
      return other instanceof ProjectInspectionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isMandatoryInspection() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $aroundRadius = this.getAroundRadius();
      result = result * 59 + ($aroundRadius == null ? 43 : $aroundRadius.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $pointName = this.getPointName();
      result = result * 59 + ($pointName == null ? 43 : $pointName.hashCode());
      Object $attachmentDTO = this.getAttachmentDTO();
      result = result * 59 + ($attachmentDTO == null ? 43 : $attachmentDTO.hashCode());
      Object $inspectionTimeList = this.getInspectionTimeList();
      result = result * 59 + ($inspectionTimeList == null ? 43 : $inspectionTimeList.hashCode());
      Object $nfcSoleId = this.getNfcSoleId();
      result = result * 59 + ($nfcSoleId == null ? 43 : $nfcSoleId.hashCode());
      Object $inspectionAttachmentList = this.getInspectionAttachmentList();
      return result * 59 + ($inspectionAttachmentList == null ? 43 : $inspectionAttachmentList.hashCode());
   }

   public static class ProjectInspectionDTOBuilder {
      private Long id;
      private String name;
      private Integer status;
      private Long projectId;
      private Integer sortNumber;
      private String point;
      private String pointName;
      private Long aroundRadius;
      private AttachmentDTO attachmentDTO;
      private List<LocalDateTime> inspectionTimeList;
      private boolean mandatoryInspection;
      private String nfcSoleId;
      private List<AttachmentDTO> inspectionAttachmentList;

      ProjectInspectionDTOBuilder() {
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder pointName(final String pointName) {
         this.pointName = pointName;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder aroundRadius(final Long aroundRadius) {
         this.aroundRadius = aroundRadius;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder attachmentDTO(final AttachmentDTO attachmentDTO) {
         this.attachmentDTO = attachmentDTO;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder inspectionTimeList(final List<LocalDateTime> inspectionTimeList) {
         this.inspectionTimeList = inspectionTimeList;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder mandatoryInspection(final boolean mandatoryInspection) {
         this.mandatoryInspection = mandatoryInspection;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder nfcSoleId(final String nfcSoleId) {
         this.nfcSoleId = nfcSoleId;
         return this;
      }

      public ProjectInspectionDTO.ProjectInspectionDTOBuilder inspectionAttachmentList(final List<AttachmentDTO> inspectionAttachmentList) {
         this.inspectionAttachmentList = inspectionAttachmentList;
         return this;
      }

      public ProjectInspectionDTO build() {
         return new ProjectInspectionDTO(
            this.id,
            this.name,
            this.status,
            this.projectId,
            this.sortNumber,
            this.point,
            this.pointName,
            this.aroundRadius,
            this.attachmentDTO,
            this.inspectionTimeList,
            this.mandatoryInspection,
            this.nfcSoleId,
            this.inspectionAttachmentList
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionDTO.ProjectInspectionDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", status="
            + this.status
            + ", projectId="
            + this.projectId
            + ", sortNumber="
            + this.sortNumber
            + ", point="
            + this.point
            + ", pointName="
            + this.pointName
            + ", aroundRadius="
            + this.aroundRadius
            + ", attachmentDTO="
            + this.attachmentDTO
            + ", inspectionTimeList="
            + this.inspectionTimeList
            + ", mandatoryInspection="
            + this.mandatoryInspection
            + ", nfcSoleId="
            + this.nfcSoleId
            + ", inspectionAttachmentList="
            + this.inspectionAttachmentList
            + ")";
      }
   }
}
