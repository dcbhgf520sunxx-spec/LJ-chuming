package com.hzchum.scim.mes.building.core.api.pojo._dto.craft;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class MesBuildingPaintCalculateRecordDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "serialNumber", value = "计算记录编号", notes = "计算记录编号")
   private String serialNumber;
   @ApiModelProperty("油漆用量列表")
   private List<MesBuildingPaintCalculateConsumptionDTO> paintCalculateConsumptionList;
   @ApiModelProperty("构件种类列表")
   private List<MesPaintStructureClassDTO> structureClassList;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;

   public static MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder builder() {
      return new MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder();
   }

   public MesBuildingPaintCalculateRecordDTO(
      final Long id,
      final Long projectId,
      final ProjectInfo project,
      final String serialNumber,
      final List<MesBuildingPaintCalculateConsumptionDTO> paintCalculateConsumptionList,
      final List<MesPaintStructureClassDTO> structureClassList,
      final Long createUserId,
      final String createUserName,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.project = project;
      this.serialNumber = serialNumber;
      this.paintCalculateConsumptionList = paintCalculateConsumptionList;
      this.structureClassList = structureClassList;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.createTime = createTime;
   }

   public MesBuildingPaintCalculateRecordDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<MesBuildingPaintCalculateConsumptionDTO> getPaintCalculateConsumptionList() {
      return this.paintCalculateConsumptionList;
   }

   public List<MesPaintStructureClassDTO> getStructureClassList() {
      return this.structureClassList;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPaintCalculateConsumptionList(final List<MesBuildingPaintCalculateConsumptionDTO> paintCalculateConsumptionList) {
      this.paintCalculateConsumptionList = paintCalculateConsumptionList;
   }

   public void setStructureClassList(final List<MesPaintStructureClassDTO> structureClassList) {
      this.structureClassList = structureClassList;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPaintCalculateRecordDTO)) {
         return false;
      }

      MesBuildingPaintCalculateRecordDTO other = (MesBuildingPaintCalculateRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$paintCalculateConsumptionList = this.getPaintCalculateConsumptionList();
                     Object other$paintCalculateConsumptionList = other.getPaintCalculateConsumptionList();
                     if (this$paintCalculateConsumptionList == null
                        ? other$paintCalculateConsumptionList == null
                        : this$paintCalculateConsumptionList.equals(other$paintCalculateConsumptionList)) {
                        Object this$structureClassList = this.getStructureClassList();
                        Object other$structureClassList = other.getStructureClassList();
                        if (this$structureClassList == null ? other$structureClassList == null : this$structureClassList.equals(other$structureClassList)) {
                           Object this$createUserName = this.getCreateUserName();
                           Object other$createUserName = other.getCreateUserName();
                           if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                              Object this$createTime = this.getCreateTime();
                              Object other$createTime = other.getCreateTime();
                              return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof MesBuildingPaintCalculateRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $paintCalculateConsumptionList = this.getPaintCalculateConsumptionList();
      result = result * 59 + ($paintCalculateConsumptionList == null ? 43 : $paintCalculateConsumptionList.hashCode());
      Object $structureClassList = this.getStructureClassList();
      result = result * 59 + ($structureClassList == null ? 43 : $structureClassList.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPaintCalculateRecordDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", paintCalculateConsumptionList="
         + this.getPaintCalculateConsumptionList()
         + ", structureClassList="
         + this.getStructureClassList()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class MesBuildingPaintCalculateRecordDTOBuilder {
      private Long id;
      private Long projectId;
      private ProjectInfo project;
      private String serialNumber;
      private List<MesBuildingPaintCalculateConsumptionDTO> paintCalculateConsumptionList;
      private List<MesPaintStructureClassDTO> structureClassList;
      private Long createUserId;
      private String createUserName;
      private LocalDateTime createTime;

      MesBuildingPaintCalculateRecordDTOBuilder() {
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder paintCalculateConsumptionList(
         final List<MesBuildingPaintCalculateConsumptionDTO> paintCalculateConsumptionList
      ) {
         this.paintCalculateConsumptionList = paintCalculateConsumptionList;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder structureClassList(
         final List<MesPaintStructureClassDTO> structureClassList
      ) {
         this.structureClassList = structureClassList;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public MesBuildingPaintCalculateRecordDTO build() {
         return new MesBuildingPaintCalculateRecordDTO(
            this.id,
            this.projectId,
            this.project,
            this.serialNumber,
            this.paintCalculateConsumptionList,
            this.structureClassList,
            this.createUserId,
            this.createUserName,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPaintCalculateRecordDTO.MesBuildingPaintCalculateRecordDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", serialNumber="
            + this.serialNumber
            + ", paintCalculateConsumptionList="
            + this.paintCalculateConsumptionList
            + ", structureClassList="
            + this.structureClassList
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
