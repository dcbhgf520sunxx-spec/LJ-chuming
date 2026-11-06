package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProcessSummaryDetailsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectKanBanDTO", description = "项目看板")
public class ArtifactDetailsAnalysisDTO {
   @ApiModelProperty(name = "project", notes = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体信息")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "areaDetail", notes = "区域信息")
   @JsonProperty("areaDetail")
   @JSONField(name = "areaDetail")
   private AreaDetailDO areaDetail;
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "surplusTaskQuantity", notes = "剩余任务数量")
   @JsonProperty("surplusTaskQuantity")
   @JSONField(name = "surplusTaskQuantity")
   private Integer surplusTaskQuantity;
   @ApiModelProperty(name = "surplusNetWeight", notes = "剩余任务净重量")
   @JsonProperty("surplusNetWeight")
   @JSONField(name = "surplusNetWeight")
   private Integer surplusNetWeight;
   @ApiModelProperty(name = "surplusGrossWeight", notes = "剩余任务毛重量")
   @JsonProperty("surplusGrossWeight")
   @JSONField(name = "surplusGrossWeight")
   private Integer surplusGrossWeight;
   @ApiModelProperty(name = "taskQuantity", notes = "本月任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private Integer taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重量")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private Integer taskGrossWeight;
   @ApiModelProperty(name = "inProductionQuantity", notes = "在制品数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "inProductionNetWeight", notes = "在制品净重量")
   @JsonProperty("inProductionNetWeight")
   @JSONField(name = "inProductionNetWeight")
   private Integer inProductionNetWeight;
   @ApiModelProperty(name = "inProductionGrossWeight", notes = "在制品毛重量")
   @JsonProperty("inProductionGrossWeight")
   @JSONField(name = "inProductionGrossWeight")
   private Integer inProductionGrossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成净重量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private Integer completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重量")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private Integer completeGrossWeight;
   @ApiModelProperty(name = "processSummaryList", notes = "工序完成详情")
   @JsonProperty("processSummaryList")
   @JSONField(name = "processSummaryList")
   private List<ProcessSummaryDetailsDTO> processSummaryList;

   public static ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder builder() {
      return new ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder();
   }

   public ArtifactDetailsAnalysisDTO() {
   }

   public ArtifactDetailsAnalysisDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final Long id,
      final String name,
      final String material,
      final String serialNumber,
      final Integer surplusTaskQuantity,
      final Integer surplusNetWeight,
      final Integer surplusGrossWeight,
      final Integer taskQuantity,
      final Integer taskNetWeight,
      final Integer taskGrossWeight,
      final Integer inProductionQuantity,
      final Integer inProductionNetWeight,
      final Integer inProductionGrossWeight,
      final Integer completeQuantity,
      final Integer completeNetWeight,
      final Integer completeGrossWeight,
      final List<ProcessSummaryDetailsDTO> processSummaryList
   ) {
      this.project = project;
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.id = id;
      this.name = name;
      this.material = material;
      this.serialNumber = serialNumber;
      this.surplusTaskQuantity = surplusTaskQuantity;
      this.surplusNetWeight = surplusNetWeight;
      this.surplusGrossWeight = surplusGrossWeight;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.inProductionQuantity = inProductionQuantity;
      this.inProductionNetWeight = inProductionNetWeight;
      this.inProductionGrossWeight = inProductionGrossWeight;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.processSummaryList = processSummaryList;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getAreaDetail() {
      return this.areaDetail;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getSurplusTaskQuantity() {
      return this.surplusTaskQuantity;
   }

   public Integer getSurplusNetWeight() {
      return this.surplusNetWeight;
   }

   public Integer getSurplusGrossWeight() {
      return this.surplusGrossWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public Integer getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getInProductionNetWeight() {
      return this.inProductionNetWeight;
   }

   public Integer getInProductionGrossWeight() {
      return this.inProductionGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public Integer getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public List<ProcessSummaryDetailsDTO> getProcessSummaryList() {
      return this.processSummaryList;
   }

   @JsonProperty("project")
   public ArtifactDetailsAnalysisDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ArtifactDetailsAnalysisDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public ArtifactDetailsAnalysisDTO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("id")
   public ArtifactDetailsAnalysisDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ArtifactDetailsAnalysisDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("material")
   public ArtifactDetailsAnalysisDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactDetailsAnalysisDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("surplusTaskQuantity")
   public ArtifactDetailsAnalysisDTO setSurplusTaskQuantity(final Integer surplusTaskQuantity) {
      this.surplusTaskQuantity = surplusTaskQuantity;
      return this;
   }

   @JsonProperty("surplusNetWeight")
   public ArtifactDetailsAnalysisDTO setSurplusNetWeight(final Integer surplusNetWeight) {
      this.surplusNetWeight = surplusNetWeight;
      return this;
   }

   @JsonProperty("surplusGrossWeight")
   public ArtifactDetailsAnalysisDTO setSurplusGrossWeight(final Integer surplusGrossWeight) {
      this.surplusGrossWeight = surplusGrossWeight;
      return this;
   }

   @JsonProperty("taskQuantity")
   public ArtifactDetailsAnalysisDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public ArtifactDetailsAnalysisDTO setTaskNetWeight(final Integer taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public ArtifactDetailsAnalysisDTO setTaskGrossWeight(final Integer taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public ArtifactDetailsAnalysisDTO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("inProductionNetWeight")
   public ArtifactDetailsAnalysisDTO setInProductionNetWeight(final Integer inProductionNetWeight) {
      this.inProductionNetWeight = inProductionNetWeight;
      return this;
   }

   @JsonProperty("inProductionGrossWeight")
   public ArtifactDetailsAnalysisDTO setInProductionGrossWeight(final Integer inProductionGrossWeight) {
      this.inProductionGrossWeight = inProductionGrossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ArtifactDetailsAnalysisDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public ArtifactDetailsAnalysisDTO setCompleteNetWeight(final Integer completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public ArtifactDetailsAnalysisDTO setCompleteGrossWeight(final Integer completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("processSummaryList")
   public ArtifactDetailsAnalysisDTO setProcessSummaryList(final List<ProcessSummaryDetailsDTO> processSummaryList) {
      this.processSummaryList = processSummaryList;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactDetailsAnalysisDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", areaDetail="
         + this.getAreaDetail()
         + ", id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", surplusTaskQuantity="
         + this.getSurplusTaskQuantity()
         + ", surplusNetWeight="
         + this.getSurplusNetWeight()
         + ", surplusGrossWeight="
         + this.getSurplusGrossWeight()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", inProductionNetWeight="
         + this.getInProductionNetWeight()
         + ", inProductionGrossWeight="
         + this.getInProductionGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", processSummaryList="
         + this.getProcessSummaryList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactDetailsAnalysisDTO)) {
         return false;
      }

      ArtifactDetailsAnalysisDTO other = (ArtifactDetailsAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$surplusTaskQuantity = this.getSurplusTaskQuantity();
         Object other$surplusTaskQuantity = other.getSurplusTaskQuantity();
         if (this$surplusTaskQuantity == null ? other$surplusTaskQuantity == null : this$surplusTaskQuantity.equals(other$surplusTaskQuantity)) {
            Object this$surplusNetWeight = this.getSurplusNetWeight();
            Object other$surplusNetWeight = other.getSurplusNetWeight();
            if (this$surplusNetWeight == null ? other$surplusNetWeight == null : this$surplusNetWeight.equals(other$surplusNetWeight)) {
               Object this$surplusGrossWeight = this.getSurplusGrossWeight();
               Object other$surplusGrossWeight = other.getSurplusGrossWeight();
               if (this$surplusGrossWeight == null ? other$surplusGrossWeight == null : this$surplusGrossWeight.equals(other$surplusGrossWeight)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$taskNetWeight = this.getTaskNetWeight();
                     Object other$taskNetWeight = other.getTaskNetWeight();
                     if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                        Object this$taskGrossWeight = this.getTaskGrossWeight();
                        Object other$taskGrossWeight = other.getTaskGrossWeight();
                        if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                           Object this$inProductionQuantity = this.getInProductionQuantity();
                           Object other$inProductionQuantity = other.getInProductionQuantity();
                           if (this$inProductionQuantity == null
                              ? other$inProductionQuantity == null
                              : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                              Object this$inProductionNetWeight = this.getInProductionNetWeight();
                              Object other$inProductionNetWeight = other.getInProductionNetWeight();
                              if (this$inProductionNetWeight == null
                                 ? other$inProductionNetWeight == null
                                 : this$inProductionNetWeight.equals(other$inProductionNetWeight)) {
                                 Object this$inProductionGrossWeight = this.getInProductionGrossWeight();
                                 Object other$inProductionGrossWeight = other.getInProductionGrossWeight();
                                 if (this$inProductionGrossWeight == null
                                    ? other$inProductionGrossWeight == null
                                    : this$inProductionGrossWeight.equals(other$inProductionGrossWeight)) {
                                    Object this$completeQuantity = this.getCompleteQuantity();
                                    Object other$completeQuantity = other.getCompleteQuantity();
                                    if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                       Object this$completeNetWeight = this.getCompleteNetWeight();
                                       Object other$completeNetWeight = other.getCompleteNetWeight();
                                       if (this$completeNetWeight == null
                                          ? other$completeNetWeight == null
                                          : this$completeNetWeight.equals(other$completeNetWeight)) {
                                          Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                          Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                          if (this$completeGrossWeight == null
                                             ? other$completeGrossWeight == null
                                             : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                             Object this$project = this.getProject();
                                             Object other$project = other.getProject();
                                             if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                Object this$monomer = this.getMonomer();
                                                Object other$monomer = other.getMonomer();
                                                if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                   Object this$areaDetail = this.getAreaDetail();
                                                   Object other$areaDetail = other.getAreaDetail();
                                                   if (this$areaDetail == null ? other$areaDetail == null : this$areaDetail.equals(other$areaDetail)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$material = this.getMaterial();
                                                         Object other$material = other.getMaterial();
                                                         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$processSummaryList = this.getProcessSummaryList();
                                                               Object other$processSummaryList = other.getProcessSummaryList();
                                                               return this$processSummaryList == null
                                                                  ? other$processSummaryList == null
                                                                  : this$processSummaryList.equals(other$processSummaryList);
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
      return other instanceof ArtifactDetailsAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $surplusTaskQuantity = this.getSurplusTaskQuantity();
      result = result * 59 + ($surplusTaskQuantity == null ? 43 : $surplusTaskQuantity.hashCode());
      Object $surplusNetWeight = this.getSurplusNetWeight();
      result = result * 59 + ($surplusNetWeight == null ? 43 : $surplusNetWeight.hashCode());
      Object $surplusGrossWeight = this.getSurplusGrossWeight();
      result = result * 59 + ($surplusGrossWeight == null ? 43 : $surplusGrossWeight.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $inProductionNetWeight = this.getInProductionNetWeight();
      result = result * 59 + ($inProductionNetWeight == null ? 43 : $inProductionNetWeight.hashCode());
      Object $inProductionGrossWeight = this.getInProductionGrossWeight();
      result = result * 59 + ($inProductionGrossWeight == null ? 43 : $inProductionGrossWeight.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $areaDetail = this.getAreaDetail();
      result = result * 59 + ($areaDetail == null ? 43 : $areaDetail.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $processSummaryList = this.getProcessSummaryList();
      return result * 59 + ($processSummaryList == null ? 43 : $processSummaryList.hashCode());
   }

   public static class ArtifactDetailsAnalysisDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private Long id;
      private String name;
      private String material;
      private String serialNumber;
      private Integer surplusTaskQuantity;
      private Integer surplusNetWeight;
      private Integer surplusGrossWeight;
      private Integer taskQuantity;
      private Integer taskNetWeight;
      private Integer taskGrossWeight;
      private Integer inProductionQuantity;
      private Integer inProductionNetWeight;
      private Integer inProductionGrossWeight;
      private Integer completeQuantity;
      private Integer completeNetWeight;
      private Integer completeGrossWeight;
      private List<ProcessSummaryDetailsDTO> processSummaryList;

      ArtifactDetailsAnalysisDTOBuilder() {
      }

      @JsonProperty("project")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("id")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("material")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("surplusTaskQuantity")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder surplusTaskQuantity(final Integer surplusTaskQuantity) {
         this.surplusTaskQuantity = surplusTaskQuantity;
         return this;
      }

      @JsonProperty("surplusNetWeight")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder surplusNetWeight(final Integer surplusNetWeight) {
         this.surplusNetWeight = surplusNetWeight;
         return this;
      }

      @JsonProperty("surplusGrossWeight")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder surplusGrossWeight(final Integer surplusGrossWeight) {
         this.surplusGrossWeight = surplusGrossWeight;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder taskNetWeight(final Integer taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder taskGrossWeight(final Integer taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("inProductionNetWeight")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder inProductionNetWeight(final Integer inProductionNetWeight) {
         this.inProductionNetWeight = inProductionNetWeight;
         return this;
      }

      @JsonProperty("inProductionGrossWeight")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder inProductionGrossWeight(final Integer inProductionGrossWeight) {
         this.inProductionGrossWeight = inProductionGrossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder completeNetWeight(final Integer completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder completeGrossWeight(final Integer completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("processSummaryList")
      public ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder processSummaryList(final List<ProcessSummaryDetailsDTO> processSummaryList) {
         this.processSummaryList = processSummaryList;
         return this;
      }

      public ArtifactDetailsAnalysisDTO build() {
         return new ArtifactDetailsAnalysisDTO(
            this.project,
            this.monomer,
            this.areaDetail,
            this.id,
            this.name,
            this.material,
            this.serialNumber,
            this.surplusTaskQuantity,
            this.surplusNetWeight,
            this.surplusGrossWeight,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.inProductionQuantity,
            this.inProductionNetWeight,
            this.inProductionGrossWeight,
            this.completeQuantity,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.processSummaryList
         );
      }

      @Override
      public String toString() {
         return "ArtifactDetailsAnalysisDTO.ArtifactDetailsAnalysisDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", areaDetail="
            + this.areaDetail
            + ", id="
            + this.id
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", serialNumber="
            + this.serialNumber
            + ", surplusTaskQuantity="
            + this.surplusTaskQuantity
            + ", surplusNetWeight="
            + this.surplusNetWeight
            + ", surplusGrossWeight="
            + this.surplusGrossWeight
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", inProductionNetWeight="
            + this.inProductionNetWeight
            + ", inProductionGrossWeight="
            + this.inProductionGrossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", processSummaryList="
            + this.processSummaryList
            + ")";
      }
   }
}
