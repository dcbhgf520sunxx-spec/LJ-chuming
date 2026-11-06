package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectSimpleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesSimpleTeamDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.SimpleWorkShopDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "InspectRealtimeInfoDTO", description = "")
public class InspectRealtimeInfoDTO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", notes = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", notes = "项目", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectSimpleDTO project;
   @ApiModelProperty(name = "workshop", notes = "车间", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private SimpleWorkShopDTO workshop;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty("构件类型 1普通构件 2次构件")
   @JsonProperty("artifactType")
   @JSONField(name = "artifactType")
   private Integer artifactType;
   @ApiModelProperty("产品种类")
   @JsonProperty(" classificationId")
   @JSONField(name = " classificationId")
   private Long classificationId;
   @ApiModelProperty(name = "processName", notes = "工序", value = "工序")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "serialNumber", notes = "编号", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "team", notes = "班组", value = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private MesSimpleTeamDTO team;
   @ApiModelProperty(name = "status", notes = "状态", value = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "inspectUserNames", notes = "质检人", value = "质检人")
   @JsonProperty("inspectUserNames")
   @JSONField(name = "inspectUserNames")
   private List<String> inspectUserNames;
   @ApiModelProperty(name = "inspectUserId", notes = "质检人id", value = "质检人id")
   @JsonProperty("inspectUserId")
   @JSONField(name = "inspectUserId")
   private Long inspectUserId;
   @ApiModelProperty(name = "name", notes = "质检人", value = "质检人")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   private Integer number;
   @ApiModelProperty("问题二级分类名称")
   private String levelTwoTypeName;
   @ApiModelProperty("问题编号")
   private String qhseNumber;

   public static InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder builder() {
      return new InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public ProjectSimpleDTO getProject() {
      return this.project;
   }

   public SimpleWorkShopDTO getWorkshop() {
      return this.workshop;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public MesSimpleTeamDTO getTeam() {
      return this.team;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getSpecification() {
      return this.specification;
   }

   public List<String> getInspectUserNames() {
      return this.inspectUserNames;
   }

   public Long getInspectUserId() {
      return this.inspectUserId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getLevelTwoTypeName() {
      return this.levelTwoTypeName;
   }

   public String getQhseNumber() {
      return this.qhseNumber;
   }

   @JsonProperty("id")
   public InspectRealtimeInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public InspectRealtimeInfoDTO setProject(final ProjectSimpleDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("workshop")
   public InspectRealtimeInfoDTO setWorkshop(final SimpleWorkShopDTO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("monomerId")
   public InspectRealtimeInfoDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("productId")
   public InspectRealtimeInfoDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public InspectRealtimeInfoDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("artifactType")
   public InspectRealtimeInfoDTO setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @JsonProperty(" classificationId")
   public InspectRealtimeInfoDTO setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   @JsonProperty("processName")
   public InspectRealtimeInfoDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("serialNumber")
   public InspectRealtimeInfoDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("team")
   public InspectRealtimeInfoDTO setTeam(final MesSimpleTeamDTO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("status")
   public InspectRealtimeInfoDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("specification")
   public InspectRealtimeInfoDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("inspectUserNames")
   public InspectRealtimeInfoDTO setInspectUserNames(final List<String> inspectUserNames) {
      this.inspectUserNames = inspectUserNames;
      return this;
   }

   @JsonProperty("inspectUserId")
   public InspectRealtimeInfoDTO setInspectUserId(final Long inspectUserId) {
      this.inspectUserId = inspectUserId;
      return this;
   }

   @JsonProperty("name")
   public InspectRealtimeInfoDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public InspectRealtimeInfoDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public InspectRealtimeInfoDTO setLevelTwoTypeName(final String levelTwoTypeName) {
      this.levelTwoTypeName = levelTwoTypeName;
      return this;
   }

   public InspectRealtimeInfoDTO setQhseNumber(final String qhseNumber) {
      this.qhseNumber = qhseNumber;
      return this;
   }

   @Override
   public String toString() {
      return "InspectRealtimeInfoDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", monomerId="
         + this.getMonomerId()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", artifactType="
         + this.getArtifactType()
         + ", classificationId="
         + this.getClassificationId()
         + ", processName="
         + this.getProcessName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", team="
         + this.getTeam()
         + ", status="
         + this.getStatus()
         + ", specification="
         + this.getSpecification()
         + ", inspectUserNames="
         + this.getInspectUserNames()
         + ", inspectUserId="
         + this.getInspectUserId()
         + ", name="
         + this.getName()
         + ", number="
         + this.getNumber()
         + ", levelTwoTypeName="
         + this.getLevelTwoTypeName()
         + ", qhseNumber="
         + this.getQhseNumber()
         + ")";
   }

   public InspectRealtimeInfoDTO(
      final Long id,
      final ProjectSimpleDTO project,
      final SimpleWorkShopDTO workshop,
      final Long monomerId,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer artifactType,
      final Long classificationId,
      final String processName,
      final String serialNumber,
      final MesSimpleTeamDTO team,
      final Integer status,
      final String specification,
      final List<String> inspectUserNames,
      final Long inspectUserId,
      final String name,
      final Integer number,
      final String levelTwoTypeName,
      final String qhseNumber
   ) {
      this.id = id;
      this.project = project;
      this.workshop = workshop;
      this.monomerId = monomerId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.artifactType = artifactType;
      this.classificationId = classificationId;
      this.processName = processName;
      this.serialNumber = serialNumber;
      this.team = team;
      this.status = status;
      this.specification = specification;
      this.inspectUserNames = inspectUserNames;
      this.inspectUserId = inspectUserId;
      this.name = name;
      this.number = number;
      this.levelTwoTypeName = levelTwoTypeName;
      this.qhseNumber = qhseNumber;
   }

   public InspectRealtimeInfoDTO() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectRealtimeInfoDTO)) {
         return false;
      }

      InspectRealtimeInfoDTO other = (InspectRealtimeInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$artifactType = this.getArtifactType();
                  Object other$artifactType = other.getArtifactType();
                  if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                     Object this$classificationId = this.getClassificationId();
                     Object other$classificationId = other.getClassificationId();
                     if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$inspectUserId = this.getInspectUserId();
                           Object other$inspectUserId = other.getInspectUserId();
                           if (this$inspectUserId == null ? other$inspectUserId == null : this$inspectUserId.equals(other$inspectUserId)) {
                              Object this$number = this.getNumber();
                              Object other$number = other.getNumber();
                              if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$workshop = this.getWorkshop();
                                    Object other$workshop = other.getWorkshop();
                                    if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                       Object this$processName = this.getProcessName();
                                       Object other$processName = other.getProcessName();
                                       if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$team = this.getTeam();
                                             Object other$team = other.getTeam();
                                             if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$inspectUserNames = this.getInspectUserNames();
                                                   Object other$inspectUserNames = other.getInspectUserNames();
                                                   if (this$inspectUserNames == null
                                                      ? other$inspectUserNames == null
                                                      : this$inspectUserNames.equals(other$inspectUserNames)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$levelTwoTypeName = this.getLevelTwoTypeName();
                                                         Object other$levelTwoTypeName = other.getLevelTwoTypeName();
                                                         if (this$levelTwoTypeName == null
                                                            ? other$levelTwoTypeName == null
                                                            : this$levelTwoTypeName.equals(other$levelTwoTypeName)) {
                                                            Object this$qhseNumber = this.getQhseNumber();
                                                            Object other$qhseNumber = other.getQhseNumber();
                                                            return this$qhseNumber == null
                                                               ? other$qhseNumber == null
                                                               : this$qhseNumber.equals(other$qhseNumber);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof InspectRealtimeInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $inspectUserId = this.getInspectUserId();
      result = result * 59 + ($inspectUserId == null ? 43 : $inspectUserId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $inspectUserNames = this.getInspectUserNames();
      result = result * 59 + ($inspectUserNames == null ? 43 : $inspectUserNames.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $levelTwoTypeName = this.getLevelTwoTypeName();
      result = result * 59 + ($levelTwoTypeName == null ? 43 : $levelTwoTypeName.hashCode());
      Object $qhseNumber = this.getQhseNumber();
      return result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
   }

   public static class InspectRealtimeInfoDTOBuilder {
      private Long id;
      private ProjectSimpleDTO project;
      private SimpleWorkShopDTO workshop;
      private Long monomerId;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer artifactType;
      private Long classificationId;
      private String processName;
      private String serialNumber;
      private MesSimpleTeamDTO team;
      private Integer status;
      private String specification;
      private List<String> inspectUserNames;
      private Long inspectUserId;
      private String name;
      private Integer number;
      private String levelTwoTypeName;
      private String qhseNumber;

      InspectRealtimeInfoDTOBuilder() {
      }

      @JsonProperty("id")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder project(final ProjectSimpleDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("workshop")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder workshop(final SimpleWorkShopDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("monomerId")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("productId")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("artifactType")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      @JsonProperty(" classificationId")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      @JsonProperty("processName")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("serialNumber")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("team")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder team(final MesSimpleTeamDTO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("status")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("specification")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("inspectUserNames")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder inspectUserNames(final List<String> inspectUserNames) {
         this.inspectUserNames = inspectUserNames;
         return this;
      }

      @JsonProperty("inspectUserId")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder inspectUserId(final Long inspectUserId) {
         this.inspectUserId = inspectUserId;
         return this;
      }

      @JsonProperty("name")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder levelTwoTypeName(final String levelTwoTypeName) {
         this.levelTwoTypeName = levelTwoTypeName;
         return this;
      }

      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder qhseNumber(final String qhseNumber) {
         this.qhseNumber = qhseNumber;
         return this;
      }

      public InspectRealtimeInfoDTO build() {
         return new InspectRealtimeInfoDTO(
            this.id,
            this.project,
            this.workshop,
            this.monomerId,
            this.productId,
            this.taskTypeEnum,
            this.artifactType,
            this.classificationId,
            this.processName,
            this.serialNumber,
            this.team,
            this.status,
            this.specification,
            this.inspectUserNames,
            this.inspectUserId,
            this.name,
            this.number,
            this.levelTwoTypeName,
            this.qhseNumber
         );
      }

      @Override
      public String toString() {
         return "InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", monomerId="
            + this.monomerId
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", artifactType="
            + this.artifactType
            + ", classificationId="
            + this.classificationId
            + ", processName="
            + this.processName
            + ", serialNumber="
            + this.serialNumber
            + ", team="
            + this.team
            + ", status="
            + this.status
            + ", specification="
            + this.specification
            + ", inspectUserNames="
            + this.inspectUserNames
            + ", inspectUserId="
            + this.inspectUserId
            + ", name="
            + this.name
            + ", number="
            + this.number
            + ", levelTwoTypeName="
            + this.levelTwoTypeName
            + ", qhseNumber="
            + this.qhseNumber
            + ")";
      }
   }
}
