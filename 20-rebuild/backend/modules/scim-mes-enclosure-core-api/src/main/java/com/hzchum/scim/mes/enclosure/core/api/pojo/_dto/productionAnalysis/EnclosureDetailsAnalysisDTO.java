package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.projectKanban.ProcessSummaryDetailsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectKanBanDTO", description = "项目看板")
public class EnclosureDetailsAnalysisDTO {
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
   @ApiModelProperty(name = "surplusLength", notes = "剩余任务长度")
   @JsonProperty("surplusLength")
   @JSONField(name = "surplusLength")
   private Integer surplusLength;
   @ApiModelProperty(name = "surplusArea", notes = "剩余任务面积")
   @JsonProperty("surplusArea")
   @JSONField(name = "surplusArea")
   private Integer surplusArea;
   @ApiModelProperty(name = "taskQuantity", notes = "本月任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private Integer taskLength;
   @ApiModelProperty(name = "taskArea", notes = "任务面积")
   @JsonProperty("taskArea")
   @JSONField(name = "taskArea")
   private Integer taskArea;
   @ApiModelProperty(name = "inProductionQuantity", notes = "在制品数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "inProductionLength", notes = "在制品长度")
   @JsonProperty("inProductionLength")
   @JSONField(name = "inProductionLength")
   private Integer inProductionLength;
   @ApiModelProperty(name = "inProductionArea", notes = "在制品面积")
   @JsonProperty("inProductionArea")
   @JSONField(name = "inProductionArea")
   private Integer inProductionArea;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private Integer completeLength;
   @ApiModelProperty(name = "completeArea", notes = "完成长度")
   @JsonProperty("completeArea")
   @JSONField(name = "completeArea")
   private Integer completeArea;
   @ApiModelProperty(name = "processSummaryList", notes = "工序完成详情")
   @JsonProperty("processSummaryList")
   @JSONField(name = "processSummaryList")
   private List<ProcessSummaryDetailsDTO> processSummaryList;

   public static EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder builder() {
      return new EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder();
   }

   public EnclosureDetailsAnalysisDTO() {
   }

   public EnclosureDetailsAnalysisDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final Long id,
      final String name,
      final String material,
      final String serialNumber,
      final Integer surplusTaskQuantity,
      final Integer surplusLength,
      final Integer surplusArea,
      final Integer taskQuantity,
      final Integer taskLength,
      final Integer taskArea,
      final Integer inProductionQuantity,
      final Integer inProductionLength,
      final Integer inProductionArea,
      final Integer completeQuantity,
      final Integer completeLength,
      final Integer completeArea,
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
      this.surplusLength = surplusLength;
      this.surplusArea = surplusArea;
      this.taskQuantity = taskQuantity;
      this.taskLength = taskLength;
      this.taskArea = taskArea;
      this.inProductionQuantity = inProductionQuantity;
      this.inProductionLength = inProductionLength;
      this.inProductionArea = inProductionArea;
      this.completeQuantity = completeQuantity;
      this.completeLength = completeLength;
      this.completeArea = completeArea;
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

   public Integer getSurplusLength() {
      return this.surplusLength;
   }

   public Integer getSurplusArea() {
      return this.surplusArea;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getTaskLength() {
      return this.taskLength;
   }

   public Integer getTaskArea() {
      return this.taskArea;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getInProductionLength() {
      return this.inProductionLength;
   }

   public Integer getInProductionArea() {
      return this.inProductionArea;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getCompleteLength() {
      return this.completeLength;
   }

   public Integer getCompleteArea() {
      return this.completeArea;
   }

   public List<ProcessSummaryDetailsDTO> getProcessSummaryList() {
      return this.processSummaryList;
   }

   @JsonProperty("project")
   public EnclosureDetailsAnalysisDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public EnclosureDetailsAnalysisDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public EnclosureDetailsAnalysisDTO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("id")
   public EnclosureDetailsAnalysisDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public EnclosureDetailsAnalysisDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("material")
   public EnclosureDetailsAnalysisDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("serialNumber")
   public EnclosureDetailsAnalysisDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("surplusTaskQuantity")
   public EnclosureDetailsAnalysisDTO setSurplusTaskQuantity(final Integer surplusTaskQuantity) {
      this.surplusTaskQuantity = surplusTaskQuantity;
      return this;
   }

   @JsonProperty("surplusLength")
   public EnclosureDetailsAnalysisDTO setSurplusLength(final Integer surplusLength) {
      this.surplusLength = surplusLength;
      return this;
   }

   @JsonProperty("surplusArea")
   public EnclosureDetailsAnalysisDTO setSurplusArea(final Integer surplusArea) {
      this.surplusArea = surplusArea;
      return this;
   }

   @JsonProperty("taskQuantity")
   public EnclosureDetailsAnalysisDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskLength")
   public EnclosureDetailsAnalysisDTO setTaskLength(final Integer taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("taskArea")
   public EnclosureDetailsAnalysisDTO setTaskArea(final Integer taskArea) {
      this.taskArea = taskArea;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public EnclosureDetailsAnalysisDTO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("inProductionLength")
   public EnclosureDetailsAnalysisDTO setInProductionLength(final Integer inProductionLength) {
      this.inProductionLength = inProductionLength;
      return this;
   }

   @JsonProperty("inProductionArea")
   public EnclosureDetailsAnalysisDTO setInProductionArea(final Integer inProductionArea) {
      this.inProductionArea = inProductionArea;
      return this;
   }

   @JsonProperty("completeQuantity")
   public EnclosureDetailsAnalysisDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeLength")
   public EnclosureDetailsAnalysisDTO setCompleteLength(final Integer completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeArea")
   public EnclosureDetailsAnalysisDTO setCompleteArea(final Integer completeArea) {
      this.completeArea = completeArea;
      return this;
   }

   @JsonProperty("processSummaryList")
   public EnclosureDetailsAnalysisDTO setProcessSummaryList(final List<ProcessSummaryDetailsDTO> processSummaryList) {
      this.processSummaryList = processSummaryList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureDetailsAnalysisDTO)) {
         return false;
      }

      EnclosureDetailsAnalysisDTO other = (EnclosureDetailsAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$surplusTaskQuantity = this.getSurplusTaskQuantity();
         Object other$surplusTaskQuantity = other.getSurplusTaskQuantity();
         if (this$surplusTaskQuantity == null ? other$surplusTaskQuantity == null : this$surplusTaskQuantity.equals(other$surplusTaskQuantity)) {
            Object this$surplusLength = this.getSurplusLength();
            Object other$surplusLength = other.getSurplusLength();
            if (this$surplusLength == null ? other$surplusLength == null : this$surplusLength.equals(other$surplusLength)) {
               Object this$surplusArea = this.getSurplusArea();
               Object other$surplusArea = other.getSurplusArea();
               if (this$surplusArea == null ? other$surplusArea == null : this$surplusArea.equals(other$surplusArea)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$taskLength = this.getTaskLength();
                     Object other$taskLength = other.getTaskLength();
                     if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                        Object this$taskArea = this.getTaskArea();
                        Object other$taskArea = other.getTaskArea();
                        if (this$taskArea == null ? other$taskArea == null : this$taskArea.equals(other$taskArea)) {
                           Object this$inProductionQuantity = this.getInProductionQuantity();
                           Object other$inProductionQuantity = other.getInProductionQuantity();
                           if (this$inProductionQuantity == null
                              ? other$inProductionQuantity == null
                              : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                              Object this$inProductionLength = this.getInProductionLength();
                              Object other$inProductionLength = other.getInProductionLength();
                              if (this$inProductionLength == null ? other$inProductionLength == null : this$inProductionLength.equals(other$inProductionLength)
                                 )
                               {
                                 Object this$inProductionArea = this.getInProductionArea();
                                 Object other$inProductionArea = other.getInProductionArea();
                                 if (this$inProductionArea == null ? other$inProductionArea == null : this$inProductionArea.equals(other$inProductionArea)) {
                                    Object this$completeQuantity = this.getCompleteQuantity();
                                    Object other$completeQuantity = other.getCompleteQuantity();
                                    if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                       Object this$completeLength = this.getCompleteLength();
                                       Object other$completeLength = other.getCompleteLength();
                                       if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
                                          Object this$completeArea = this.getCompleteArea();
                                          Object other$completeArea = other.getCompleteArea();
                                          if (this$completeArea == null ? other$completeArea == null : this$completeArea.equals(other$completeArea)) {
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
      return other instanceof EnclosureDetailsAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $surplusTaskQuantity = this.getSurplusTaskQuantity();
      result = result * 59 + ($surplusTaskQuantity == null ? 43 : $surplusTaskQuantity.hashCode());
      Object $surplusLength = this.getSurplusLength();
      result = result * 59 + ($surplusLength == null ? 43 : $surplusLength.hashCode());
      Object $surplusArea = this.getSurplusArea();
      result = result * 59 + ($surplusArea == null ? 43 : $surplusArea.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $taskArea = this.getTaskArea();
      result = result * 59 + ($taskArea == null ? 43 : $taskArea.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $inProductionLength = this.getInProductionLength();
      result = result * 59 + ($inProductionLength == null ? 43 : $inProductionLength.hashCode());
      Object $inProductionArea = this.getInProductionArea();
      result = result * 59 + ($inProductionArea == null ? 43 : $inProductionArea.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeArea = this.getCompleteArea();
      result = result * 59 + ($completeArea == null ? 43 : $completeArea.hashCode());
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

   @Override
   public String toString() {
      return "EnclosureDetailsAnalysisDTO(project="
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
         + ", surplusLength="
         + this.getSurplusLength()
         + ", surplusArea="
         + this.getSurplusArea()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskLength="
         + this.getTaskLength()
         + ", taskArea="
         + this.getTaskArea()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", inProductionLength="
         + this.getInProductionLength()
         + ", inProductionArea="
         + this.getInProductionArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeArea="
         + this.getCompleteArea()
         + ", processSummaryList="
         + this.getProcessSummaryList()
         + ")";
   }

   public static class EnclosureDetailsAnalysisDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private Long id;
      private String name;
      private String material;
      private String serialNumber;
      private Integer surplusTaskQuantity;
      private Integer surplusLength;
      private Integer surplusArea;
      private Integer taskQuantity;
      private Integer taskLength;
      private Integer taskArea;
      private Integer inProductionQuantity;
      private Integer inProductionLength;
      private Integer inProductionArea;
      private Integer completeQuantity;
      private Integer completeLength;
      private Integer completeArea;
      private List<ProcessSummaryDetailsDTO> processSummaryList;

      EnclosureDetailsAnalysisDTOBuilder() {
      }

      @JsonProperty("project")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("id")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("material")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("serialNumber")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("surplusTaskQuantity")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder surplusTaskQuantity(final Integer surplusTaskQuantity) {
         this.surplusTaskQuantity = surplusTaskQuantity;
         return this;
      }

      @JsonProperty("surplusLength")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder surplusLength(final Integer surplusLength) {
         this.surplusLength = surplusLength;
         return this;
      }

      @JsonProperty("surplusArea")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder surplusArea(final Integer surplusArea) {
         this.surplusArea = surplusArea;
         return this;
      }

      @JsonProperty("taskQuantity")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskLength")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder taskLength(final Integer taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("taskArea")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder taskArea(final Integer taskArea) {
         this.taskArea = taskArea;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("inProductionLength")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder inProductionLength(final Integer inProductionLength) {
         this.inProductionLength = inProductionLength;
         return this;
      }

      @JsonProperty("inProductionArea")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder inProductionArea(final Integer inProductionArea) {
         this.inProductionArea = inProductionArea;
         return this;
      }

      @JsonProperty("completeQuantity")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeLength")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder completeLength(final Integer completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeArea")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder completeArea(final Integer completeArea) {
         this.completeArea = completeArea;
         return this;
      }

      @JsonProperty("processSummaryList")
      public EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder processSummaryList(final List<ProcessSummaryDetailsDTO> processSummaryList) {
         this.processSummaryList = processSummaryList;
         return this;
      }

      public EnclosureDetailsAnalysisDTO build() {
         return new EnclosureDetailsAnalysisDTO(
            this.project,
            this.monomer,
            this.areaDetail,
            this.id,
            this.name,
            this.material,
            this.serialNumber,
            this.surplusTaskQuantity,
            this.surplusLength,
            this.surplusArea,
            this.taskQuantity,
            this.taskLength,
            this.taskArea,
            this.inProductionQuantity,
            this.inProductionLength,
            this.inProductionArea,
            this.completeQuantity,
            this.completeLength,
            this.completeArea,
            this.processSummaryList
         );
      }

      @Override
      public String toString() {
         return "EnclosureDetailsAnalysisDTO.EnclosureDetailsAnalysisDTOBuilder(project="
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
            + ", surplusLength="
            + this.surplusLength
            + ", surplusArea="
            + this.surplusArea
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskLength="
            + this.taskLength
            + ", taskArea="
            + this.taskArea
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", inProductionLength="
            + this.inProductionLength
            + ", inProductionArea="
            + this.inProductionArea
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeLength="
            + this.completeLength
            + ", completeArea="
            + this.completeArea
            + ", processSummaryList="
            + this.processSummaryList
            + ")";
      }
   }
}
