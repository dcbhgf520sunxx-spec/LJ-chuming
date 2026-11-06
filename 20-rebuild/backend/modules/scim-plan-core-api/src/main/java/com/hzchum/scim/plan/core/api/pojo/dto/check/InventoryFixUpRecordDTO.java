package com.hzchum.scim.plan.core.api.pojo.dto.check;

import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecUncorrectedDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("待确认的清单导入记录")
public class InventoryFixUpRecordDTO {
   @ApiModelProperty(name = "id", value = "清单操作记录Id")
   private Long id;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "buildingType", value = "建筑类型 1建钢 2桥梁")
   private Integer buildingType;
   @ApiModelProperty(name = "importType", value = "导入类型: 1增量导入 2覆盖导入")
   private Integer importType;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "BoolSpecificationRevision", value = "是否需要规格修正", notes = "是否需要规格修正")
   private Boolean BoolSpecificationRevision;
   @ApiModelProperty(name = "boolRepetition", value = "是否与单体中已有构件重复")
   private Boolean boolRepetition;
   @ApiModelProperty(name = "mesProductEnum", value = "mes产品分类")
   private Integer mesProductEnum;
   @ApiModelProperty(name = "artifactRecordDTOList", value = "重复的构件清单记录")
   private List<TechArtifactRecordDTO> artifactRecordDTOList;
   @ApiModelProperty(name = "artifactSpecUncorrectedDTOS", value = "待规格修正的构件列表")
   private List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOS;
   @ApiModelProperty(name = "artifactSpecUncorrectedDTOSPL", value = "待规格修正的PL构件列表")
   private List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOSPL;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "区域名称", value = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "批次名称", value = "批次名称")
   private String areaBatchName;
   @ApiModelProperty(name = "unBoardAssembledQuantity", value = "未组立数量")
   private Integer unBoardAssembledQuantity;
   @ApiModelProperty(name = "boardAssembledQuantity", value = "已组立数量")
   private Integer boardAssembledQuantity;

   public Long getId() {
      return this.id;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getBuildingType() {
      return this.buildingType;
   }

   public Integer getImportType() {
      return this.importType;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolSpecificationRevision() {
      return this.BoolSpecificationRevision;
   }

   public Boolean getBoolRepetition() {
      return this.boolRepetition;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public List<TechArtifactRecordDTO> getArtifactRecordDTOList() {
      return this.artifactRecordDTOList;
   }

   public List<TechArtifactSpecUncorrectedDTO> getArtifactSpecUncorrectedDTOS() {
      return this.artifactSpecUncorrectedDTOS;
   }

   public List<TechArtifactSpecUncorrectedDTO> getArtifactSpecUncorrectedDTOSPL() {
      return this.artifactSpecUncorrectedDTOSPL;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public Integer getUnBoardAssembledQuantity() {
      return this.unBoardAssembledQuantity;
   }

   public Integer getBoardAssembledQuantity() {
      return this.boardAssembledQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setBuildingType(final Integer buildingType) {
      this.buildingType = buildingType;
   }

   public void setImportType(final Integer importType) {
      this.importType = importType;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolSpecificationRevision(final Boolean BoolSpecificationRevision) {
      this.BoolSpecificationRevision = BoolSpecificationRevision;
   }

   public void setBoolRepetition(final Boolean boolRepetition) {
      this.boolRepetition = boolRepetition;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   public void setArtifactRecordDTOList(final List<TechArtifactRecordDTO> artifactRecordDTOList) {
      this.artifactRecordDTOList = artifactRecordDTOList;
   }

   public void setArtifactSpecUncorrectedDTOS(final List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOS) {
      this.artifactSpecUncorrectedDTOS = artifactSpecUncorrectedDTOS;
   }

   public void setArtifactSpecUncorrectedDTOSPL(final List<TechArtifactSpecUncorrectedDTO> artifactSpecUncorrectedDTOSPL) {
      this.artifactSpecUncorrectedDTOSPL = artifactSpecUncorrectedDTOSPL;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
   }

   public void setUnBoardAssembledQuantity(final Integer unBoardAssembledQuantity) {
      this.unBoardAssembledQuantity = unBoardAssembledQuantity;
   }

   public void setBoardAssembledQuantity(final Integer boardAssembledQuantity) {
      this.boardAssembledQuantity = boardAssembledQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryFixUpRecordDTO)) {
         return false;
      }

      InventoryFixUpRecordDTO other = (InventoryFixUpRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$buildingType = this.getBuildingType();
            Object other$buildingType = other.getBuildingType();
            if (this$buildingType == null ? other$buildingType == null : this$buildingType.equals(other$buildingType)) {
               Object this$importType = this.getImportType();
               Object other$importType = other.getImportType();
               if (this$importType == null ? other$importType == null : this$importType.equals(other$importType)) {
                  Object this$BoolSpecificationRevision = this.getBoolSpecificationRevision();
                  Object other$BoolSpecificationRevision = other.getBoolSpecificationRevision();
                  if (this$BoolSpecificationRevision == null
                     ? other$BoolSpecificationRevision == null
                     : this$BoolSpecificationRevision.equals(other$BoolSpecificationRevision)) {
                     Object this$boolRepetition = this.getBoolRepetition();
                     Object other$boolRepetition = other.getBoolRepetition();
                     if (this$boolRepetition == null ? other$boolRepetition == null : this$boolRepetition.equals(other$boolRepetition)) {
                        Object this$mesProductEnum = this.getMesProductEnum();
                        Object other$mesProductEnum = other.getMesProductEnum();
                        if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                           Object this$unBoardAssembledQuantity = this.getUnBoardAssembledQuantity();
                           Object other$unBoardAssembledQuantity = other.getUnBoardAssembledQuantity();
                           if (this$unBoardAssembledQuantity == null
                              ? other$unBoardAssembledQuantity == null
                              : this$unBoardAssembledQuantity.equals(other$unBoardAssembledQuantity)) {
                              Object this$boardAssembledQuantity = this.getBoardAssembledQuantity();
                              Object other$boardAssembledQuantity = other.getBoardAssembledQuantity();
                              if (this$boardAssembledQuantity == null
                                 ? other$boardAssembledQuantity == null
                                 : this$boardAssembledQuantity.equals(other$boardAssembledQuantity)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$artifactRecordDTOList = this.getArtifactRecordDTOList();
                                    Object other$artifactRecordDTOList = other.getArtifactRecordDTOList();
                                    if (this$artifactRecordDTOList == null
                                       ? other$artifactRecordDTOList == null
                                       : this$artifactRecordDTOList.equals(other$artifactRecordDTOList)) {
                                       Object this$artifactSpecUncorrectedDTOS = this.getArtifactSpecUncorrectedDTOS();
                                       Object other$artifactSpecUncorrectedDTOS = other.getArtifactSpecUncorrectedDTOS();
                                       if (this$artifactSpecUncorrectedDTOS == null
                                          ? other$artifactSpecUncorrectedDTOS == null
                                          : this$artifactSpecUncorrectedDTOS.equals(other$artifactSpecUncorrectedDTOS)) {
                                          Object this$artifactSpecUncorrectedDTOSPL = this.getArtifactSpecUncorrectedDTOSPL();
                                          Object other$artifactSpecUncorrectedDTOSPL = other.getArtifactSpecUncorrectedDTOSPL();
                                          if (this$artifactSpecUncorrectedDTOSPL == null
                                             ? other$artifactSpecUncorrectedDTOSPL == null
                                             : this$artifactSpecUncorrectedDTOSPL.equals(other$artifactSpecUncorrectedDTOSPL)) {
                                             Object this$projectName = this.getProjectName();
                                             Object other$projectName = other.getProjectName();
                                             if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                Object this$monomerName = this.getMonomerName();
                                                Object other$monomerName = other.getMonomerName();
                                                if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                   Object this$areaName = this.getAreaName();
                                                   Object other$areaName = other.getAreaName();
                                                   if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                      Object this$areaBatchName = this.getAreaBatchName();
                                                      Object other$areaBatchName = other.getAreaBatchName();
                                                      return this$areaBatchName == null
                                                         ? other$areaBatchName == null
                                                         : this$areaBatchName.equals(other$areaBatchName);
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
      return other instanceof InventoryFixUpRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $buildingType = this.getBuildingType();
      result = result * 59 + ($buildingType == null ? 43 : $buildingType.hashCode());
      Object $importType = this.getImportType();
      result = result * 59 + ($importType == null ? 43 : $importType.hashCode());
      Object $BoolSpecificationRevision = this.getBoolSpecificationRevision();
      result = result * 59 + ($BoolSpecificationRevision == null ? 43 : $BoolSpecificationRevision.hashCode());
      Object $boolRepetition = this.getBoolRepetition();
      result = result * 59 + ($boolRepetition == null ? 43 : $boolRepetition.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $unBoardAssembledQuantity = this.getUnBoardAssembledQuantity();
      result = result * 59 + ($unBoardAssembledQuantity == null ? 43 : $unBoardAssembledQuantity.hashCode());
      Object $boardAssembledQuantity = this.getBoardAssembledQuantity();
      result = result * 59 + ($boardAssembledQuantity == null ? 43 : $boardAssembledQuantity.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $artifactRecordDTOList = this.getArtifactRecordDTOList();
      result = result * 59 + ($artifactRecordDTOList == null ? 43 : $artifactRecordDTOList.hashCode());
      Object $artifactSpecUncorrectedDTOS = this.getArtifactSpecUncorrectedDTOS();
      result = result * 59 + ($artifactSpecUncorrectedDTOS == null ? 43 : $artifactSpecUncorrectedDTOS.hashCode());
      Object $artifactSpecUncorrectedDTOSPL = this.getArtifactSpecUncorrectedDTOSPL();
      result = result * 59 + ($artifactSpecUncorrectedDTOSPL == null ? 43 : $artifactSpecUncorrectedDTOSPL.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      return result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryFixUpRecordDTO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", buildingType="
         + this.getBuildingType()
         + ", importType="
         + this.getImportType()
         + ", remark="
         + this.getRemark()
         + ", BoolSpecificationRevision="
         + this.getBoolSpecificationRevision()
         + ", boolRepetition="
         + this.getBoolRepetition()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", artifactRecordDTOList="
         + this.getArtifactRecordDTOList()
         + ", artifactSpecUncorrectedDTOS="
         + this.getArtifactSpecUncorrectedDTOS()
         + ", artifactSpecUncorrectedDTOSPL="
         + this.getArtifactSpecUncorrectedDTOSPL()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", unBoardAssembledQuantity="
         + this.getUnBoardAssembledQuantity()
         + ", boardAssembledQuantity="
         + this.getBoardAssembledQuantity()
         + ")";
   }
}
