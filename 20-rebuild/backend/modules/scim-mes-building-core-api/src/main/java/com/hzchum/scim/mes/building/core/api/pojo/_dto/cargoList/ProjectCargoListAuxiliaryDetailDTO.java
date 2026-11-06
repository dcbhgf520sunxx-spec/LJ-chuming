package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;

@ApiModel(description = "发运量-配套件")
public class ProjectCargoListAuxiliaryDetailDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名", notes = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名", notes = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255)  COMMENT '单位'", nullable = false)
   private String measureUnit;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "quantity", value = "清单数", notes = "清单数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "cargoQuantity", value = "发运数", notes = "发运数")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "cargoMete", value = "发运量", notes = "发运量")
   private BigDecimal cargoMete;
   @ApiModelProperty(name = "unCargoQuantity", value = "未发运数", notes = "未发运数")
   @JsonProperty("unCargoQuantity")
   @JSONField(name = "unCargoQuantity")
   private Integer unCargoQuantity;
   @ApiModelProperty(name = "unCargoMete", value = "未发运量", notes = "未发运量")
   private BigDecimal unCargoMete;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 2  COMMENT '关联类型 2构件 4围护'")
   private Integer relationType;
   @ApiModelProperty(name = "boolWeightTypeEnum", value = "(核算单位)是否重量类型 true是 false否", notes = "(核算单位)是否重量类型 true是 false否")
   @TableField("bool_weight_type_enum")
   @Column(name = "bool_weight_type_enum", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '(核算单位)是否重量类型 1是 0否'")
   private Boolean boolWeightTypeEnum;
   @ApiModelProperty(name = "packageList", value = "打包列表", notes = "打包列表")
   private List<MesBuildingPackage> packageList;

   public static ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder builder() {
      return new ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public BigDecimal getCargoMete() {
      return this.cargoMete;
   }

   public Integer getUnCargoQuantity() {
      return this.unCargoQuantity;
   }

   public BigDecimal getUnCargoMete() {
      return this.unCargoMete;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Boolean getBoolWeightTypeEnum() {
      return this.boolWeightTypeEnum;
   }

   public List<MesBuildingPackage> getPackageList() {
      return this.packageList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("monomerName")
   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   @JsonProperty("areaId")
   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   @JsonProperty("areaName")
   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @JsonProperty("cargoQuantity")
   public void setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
   }

   public void setCargoMete(final BigDecimal cargoMete) {
      this.cargoMete = cargoMete;
   }

   @JsonProperty("unCargoQuantity")
   public void setUnCargoQuantity(final Integer unCargoQuantity) {
      this.unCargoQuantity = unCargoQuantity;
   }

   public void setUnCargoMete(final BigDecimal unCargoMete) {
      this.unCargoMete = unCargoMete;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setBoolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
      this.boolWeightTypeEnum = boolWeightTypeEnum;
   }

   public void setPackageList(final List<MesBuildingPackage> packageList) {
      this.packageList = packageList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListAuxiliaryDetailDTO)) {
         return false;
      }

      ProjectCargoListAuxiliaryDetailDTO other = (ProjectCargoListAuxiliaryDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$cargoQuantity = this.getCargoQuantity();
                  Object other$cargoQuantity = other.getCargoQuantity();
                  if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                     Object this$unCargoQuantity = this.getUnCargoQuantity();
                     Object other$unCargoQuantity = other.getUnCargoQuantity();
                     if (this$unCargoQuantity == null ? other$unCargoQuantity == null : this$unCargoQuantity.equals(other$unCargoQuantity)) {
                        Object this$relationType = this.getRelationType();
                        Object other$relationType = other.getRelationType();
                        if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                           Object this$boolWeightTypeEnum = this.getBoolWeightTypeEnum();
                           Object other$boolWeightTypeEnum = other.getBoolWeightTypeEnum();
                           if (this$boolWeightTypeEnum == null ? other$boolWeightTypeEnum == null : this$boolWeightTypeEnum.equals(other$boolWeightTypeEnum)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$monomerName = this.getMonomerName();
                                 Object other$monomerName = other.getMonomerName();
                                 if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                    Object this$areaName = this.getAreaName();
                                    Object other$areaName = other.getAreaName();
                                    if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$measureUnit = this.getMeasureUnit();
                                                Object other$measureUnit = other.getMeasureUnit();
                                                if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$mete = this.getMete();
                                                      Object other$mete = other.getMete();
                                                      if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                         Object this$accountingUnit = this.getAccountingUnit();
                                                         Object other$accountingUnit = other.getAccountingUnit();
                                                         if (this$accountingUnit == null
                                                            ? other$accountingUnit == null
                                                            : this$accountingUnit.equals(other$accountingUnit)) {
                                                            Object this$cargoMete = this.getCargoMete();
                                                            Object other$cargoMete = other.getCargoMete();
                                                            if (this$cargoMete == null ? other$cargoMete == null : this$cargoMete.equals(other$cargoMete)) {
                                                               Object this$unCargoMete = this.getUnCargoMete();
                                                               Object other$unCargoMete = other.getUnCargoMete();
                                                               if (this$unCargoMete == null
                                                                  ? other$unCargoMete == null
                                                                  : this$unCargoMete.equals(other$unCargoMete)) {
                                                                  Object this$packageList = this.getPackageList();
                                                                  Object other$packageList = other.getPackageList();
                                                                  return this$packageList == null
                                                                     ? other$packageList == null
                                                                     : this$packageList.equals(other$packageList);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectCargoListAuxiliaryDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $unCargoQuantity = this.getUnCargoQuantity();
      result = result * 59 + ($unCargoQuantity == null ? 43 : $unCargoQuantity.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $boolWeightTypeEnum = this.getBoolWeightTypeEnum();
      result = result * 59 + ($boolWeightTypeEnum == null ? 43 : $boolWeightTypeEnum.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $cargoMete = this.getCargoMete();
      result = result * 59 + ($cargoMete == null ? 43 : $cargoMete.hashCode());
      Object $unCargoMete = this.getUnCargoMete();
      result = result * 59 + ($unCargoMete == null ? 43 : $unCargoMete.hashCode());
      Object $packageList = this.getPackageList();
      return result * 59 + ($packageList == null ? 43 : $packageList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListAuxiliaryDetailDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", remark="
         + this.getRemark()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", cargoMete="
         + this.getCargoMete()
         + ", unCargoQuantity="
         + this.getUnCargoQuantity()
         + ", unCargoMete="
         + this.getUnCargoMete()
         + ", relationType="
         + this.getRelationType()
         + ", boolWeightTypeEnum="
         + this.getBoolWeightTypeEnum()
         + ", packageList="
         + this.getPackageList()
         + ")";
   }

   public ProjectCargoListAuxiliaryDetailDTO() {
   }

   public ProjectCargoListAuxiliaryDetailDTO(
      final Long id,
      final ProjectInfo project,
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final String name,
      final String serialNumber,
      final String specification,
      final String measureUnit,
      final String remark,
      final Integer quantity,
      final BigDecimal mete,
      final String accountingUnit,
      final Integer cargoQuantity,
      final BigDecimal cargoMete,
      final Integer unCargoQuantity,
      final BigDecimal unCargoMete,
      final Integer relationType,
      final Boolean boolWeightTypeEnum,
      final List<MesBuildingPackage> packageList
   ) {
      this.id = id;
      this.project = project;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.remark = remark;
      this.quantity = quantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.cargoQuantity = cargoQuantity;
      this.cargoMete = cargoMete;
      this.unCargoQuantity = unCargoQuantity;
      this.unCargoMete = unCargoMete;
      this.relationType = relationType;
      this.boolWeightTypeEnum = boolWeightTypeEnum;
      this.packageList = packageList;
   }

   public static class ProjectCargoListAuxiliaryDetailDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private String name;
      private String serialNumber;
      private String specification;
      private String measureUnit;
      private String remark;
      private Integer quantity;
      private BigDecimal mete;
      private String accountingUnit;
      private Integer cargoQuantity;
      private BigDecimal cargoMete;
      private Integer unCargoQuantity;
      private BigDecimal unCargoMete;
      private Integer relationType;
      private Boolean boolWeightTypeEnum;
      private List<MesBuildingPackage> packageList;

      ProjectCargoListAuxiliaryDetailDTOBuilder() {
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("monomerName")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaId")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaName")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("name")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder cargoMete(final BigDecimal cargoMete) {
         this.cargoMete = cargoMete;
         return this;
      }

      @JsonProperty("unCargoQuantity")
      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder unCargoQuantity(final Integer unCargoQuantity) {
         this.unCargoQuantity = unCargoQuantity;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder unCargoMete(final BigDecimal unCargoMete) {
         this.unCargoMete = unCargoMete;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder boolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
         this.boolWeightTypeEnum = boolWeightTypeEnum;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder packageList(final List<MesBuildingPackage> packageList) {
         this.packageList = packageList;
         return this;
      }

      public ProjectCargoListAuxiliaryDetailDTO build() {
         return new ProjectCargoListAuxiliaryDetailDTO(
            this.id,
            this.project,
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.name,
            this.serialNumber,
            this.specification,
            this.measureUnit,
            this.remark,
            this.quantity,
            this.mete,
            this.accountingUnit,
            this.cargoQuantity,
            this.cargoMete,
            this.unCargoQuantity,
            this.unCargoMete,
            this.relationType,
            this.boolWeightTypeEnum,
            this.packageList
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListAuxiliaryDetailDTO.ProjectCargoListAuxiliaryDetailDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", remark="
            + this.remark
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", cargoMete="
            + this.cargoMete
            + ", unCargoQuantity="
            + this.unCargoQuantity
            + ", unCargoMete="
            + this.unCargoMete
            + ", relationType="
            + this.relationType
            + ", boolWeightTypeEnum="
            + this.boolWeightTypeEnum
            + ", packageList="
            + this.packageList
            + ")";
      }
   }
}
