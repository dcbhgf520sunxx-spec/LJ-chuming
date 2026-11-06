package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TechStandardPartWMSDTO对象", description = "提供给物料展示")
public class TechStandardPartWMSDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   private String classifyName;
   @ApiModelProperty(name = "category", value = "品类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlan", value = "围护计划")
   private NameInfo enclosurePlan;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   private Integer relationType;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "boolWeightTypeEnum", value = "(核算单位)是否重量类型 true是 false否", notes = "(核算单位)是否重量类型 true是 false否")
   private Boolean boolWeightTypeEnum;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "businessId", value = "标准件商务ID")
   private Long businessId;
   @ApiModelProperty(name = "userId", value = "创建用户id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建用户")
   private String userName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "lastEditorId", value = "最后修改用户id")
   private Long lastEditorId;
   @ApiModelProperty("打印数量")
   private Integer printQuantity;
   @ApiModelProperty("打印时间")
   private LocalDateTime printTime;
   @ApiModelProperty(name = "boolArtifactImport", value = "是否关联清单 true是 false否", notes = "是否关联清单 true是 false否")
   private Boolean boolArtifactImport;
   @ApiModelProperty(name = "totalCargoNetweight", value = "总出库", notes = "总出库")
   private BigDecimal totalCargoNetweight;
   @ApiModelProperty(name = "boolUnderReview", value = "是否存在审核中数据", notes = "是否存在审核中数据")
   private Boolean boolUnderReview;
   @ApiModelProperty("是否入库，0未入库 1 wms已入库")
   private Integer boolInbound;

   public static TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder builder() {
      return new TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder();
   }

   public TechStandardPartWMSDTO() {
   }

   public TechStandardPartWMSDTO(
      final Long id,
      final String name,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final String classifyName,
      final Integer category,
      final NameInfo enclosurePlan,
      final Integer relationType,
      final Integer useProperty,
      final String specification,
      final String measureUnit,
      final Integer quantity,
      final BigDecimal mete,
      final String accountingUnit,
      final Boolean boolWeightTypeEnum,
      final String remark,
      final Long businessId,
      final Long userId,
      final String userName,
      final LocalDateTime createTime,
      final Long lastEditorId,
      final Integer printQuantity,
      final LocalDateTime printTime,
      final Boolean boolArtifactImport,
      final BigDecimal totalCargoNetweight,
      final Boolean boolUnderReview,
      final Integer boolInbound
   ) {
      this.id = id;
      this.name = name;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.classifyName = classifyName;
      this.category = category;
      this.enclosurePlan = enclosurePlan;
      this.relationType = relationType;
      this.useProperty = useProperty;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.boolWeightTypeEnum = boolWeightTypeEnum;
      this.remark = remark;
      this.businessId = businessId;
      this.userId = userId;
      this.userName = userName;
      this.createTime = createTime;
      this.lastEditorId = lastEditorId;
      this.printQuantity = printQuantity;
      this.printTime = printTime;
      this.boolArtifactImport = boolArtifactImport;
      this.totalCargoNetweight = totalCargoNetweight;
      this.boolUnderReview = boolUnderReview;
      this.boolInbound = boolInbound;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Integer getCategory() {
      return this.category;
   }

   public NameInfo getEnclosurePlan() {
      return this.enclosurePlan;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
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

   public Boolean getBoolWeightTypeEnum() {
      return this.boolWeightTypeEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getLastEditorId() {
      return this.lastEditorId;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public Boolean getBoolArtifactImport() {
      return this.boolArtifactImport;
   }

   public BigDecimal getTotalCargoNetweight() {
      return this.totalCargoNetweight;
   }

   public Boolean getBoolUnderReview() {
      return this.boolUnderReview;
   }

   public Integer getBoolInbound() {
      return this.boolInbound;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlan(final NameInfo enclosurePlan) {
      this.enclosurePlan = enclosurePlan;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setBoolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
      this.boolWeightTypeEnum = boolWeightTypeEnum;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setLastEditorId(final Long lastEditorId) {
      this.lastEditorId = lastEditorId;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
   }

   public void setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
   }

   public void setBoolArtifactImport(final Boolean boolArtifactImport) {
      this.boolArtifactImport = boolArtifactImport;
   }

   public void setTotalCargoNetweight(final BigDecimal totalCargoNetweight) {
      this.totalCargoNetweight = totalCargoNetweight;
   }

   public void setBoolUnderReview(final Boolean boolUnderReview) {
      this.boolUnderReview = boolUnderReview;
   }

   public void setBoolInbound(final Integer boolInbound) {
      this.boolInbound = boolInbound;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartWMSDTO)) {
         return false;
      }

      TechStandardPartWMSDTO other = (TechStandardPartWMSDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$relationType = this.getRelationType();
            Object other$relationType = other.getRelationType();
            if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
               Object this$useProperty = this.getUseProperty();
               Object other$useProperty = other.getUseProperty();
               if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$boolWeightTypeEnum = this.getBoolWeightTypeEnum();
                     Object other$boolWeightTypeEnum = other.getBoolWeightTypeEnum();
                     if (this$boolWeightTypeEnum == null ? other$boolWeightTypeEnum == null : this$boolWeightTypeEnum.equals(other$boolWeightTypeEnum)) {
                        Object this$businessId = this.getBusinessId();
                        Object other$businessId = other.getBusinessId();
                        if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$lastEditorId = this.getLastEditorId();
                              Object other$lastEditorId = other.getLastEditorId();
                              if (this$lastEditorId == null ? other$lastEditorId == null : this$lastEditorId.equals(other$lastEditorId)) {
                                 Object this$printQuantity = this.getPrintQuantity();
                                 Object other$printQuantity = other.getPrintQuantity();
                                 if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                    Object this$boolArtifactImport = this.getBoolArtifactImport();
                                    Object other$boolArtifactImport = other.getBoolArtifactImport();
                                    if (this$boolArtifactImport == null
                                       ? other$boolArtifactImport == null
                                       : this$boolArtifactImport.equals(other$boolArtifactImport)) {
                                       Object this$boolUnderReview = this.getBoolUnderReview();
                                       Object other$boolUnderReview = other.getBoolUnderReview();
                                       if (this$boolUnderReview == null ? other$boolUnderReview == null : this$boolUnderReview.equals(other$boolUnderReview)) {
                                          Object this$boolInbound = this.getBoolInbound();
                                          Object other$boolInbound = other.getBoolInbound();
                                          if (this$boolInbound == null ? other$boolInbound == null : this$boolInbound.equals(other$boolInbound)) {
                                             Object this$name = this.getName();
                                             Object other$name = other.getName();
                                             if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                Object this$project = this.getProject();
                                                Object other$project = other.getProject();
                                                if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                   Object this$monomer = this.getMonomer();
                                                   Object other$monomer = other.getMonomer();
                                                   if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                      Object this$area = this.getArea();
                                                      Object other$area = other.getArea();
                                                      if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                         Object this$classifyName = this.getClassifyName();
                                                         Object other$classifyName = other.getClassifyName();
                                                         if (this$classifyName == null
                                                            ? other$classifyName == null
                                                            : this$classifyName.equals(other$classifyName)) {
                                                            Object this$enclosurePlan = this.getEnclosurePlan();
                                                            Object other$enclosurePlan = other.getEnclosurePlan();
                                                            if (this$enclosurePlan == null
                                                               ? other$enclosurePlan == null
                                                               : this$enclosurePlan.equals(other$enclosurePlan)) {
                                                               Object this$specification = this.getSpecification();
                                                               Object other$specification = other.getSpecification();
                                                               if (this$specification == null
                                                                  ? other$specification == null
                                                                  : this$specification.equals(other$specification)) {
                                                                  Object this$measureUnit = this.getMeasureUnit();
                                                                  Object other$measureUnit = other.getMeasureUnit();
                                                                  if (this$measureUnit == null
                                                                     ? other$measureUnit == null
                                                                     : this$measureUnit.equals(other$measureUnit)) {
                                                                     Object this$mete = this.getMete();
                                                                     Object other$mete = other.getMete();
                                                                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                        Object this$accountingUnit = this.getAccountingUnit();
                                                                        Object other$accountingUnit = other.getAccountingUnit();
                                                                        if (this$accountingUnit == null
                                                                           ? other$accountingUnit == null
                                                                           : this$accountingUnit.equals(other$accountingUnit)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$userName = this.getUserName();
                                                                              Object other$userName = other.getUserName();
                                                                              if (this$userName == null
                                                                                 ? other$userName == null
                                                                                 : this$userName.equals(other$userName)) {
                                                                                 Object this$createTime = this.getCreateTime();
                                                                                 Object other$createTime = other.getCreateTime();
                                                                                 if (this$createTime == null
                                                                                    ? other$createTime == null
                                                                                    : this$createTime.equals(other$createTime)) {
                                                                                    Object this$printTime = this.getPrintTime();
                                                                                    Object other$printTime = other.getPrintTime();
                                                                                    if (this$printTime == null
                                                                                       ? other$printTime == null
                                                                                       : this$printTime.equals(other$printTime)) {
                                                                                       Object this$totalCargoNetweight = this.getTotalCargoNetweight();
                                                                                       Object other$totalCargoNetweight = other.getTotalCargoNetweight();
                                                                                       return this$totalCargoNetweight == null
                                                                                          ? other$totalCargoNetweight == null
                                                                                          : this$totalCargoNetweight.equals(other$totalCargoNetweight);
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
      return other instanceof TechStandardPartWMSDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolWeightTypeEnum = this.getBoolWeightTypeEnum();
      result = result * 59 + ($boolWeightTypeEnum == null ? 43 : $boolWeightTypeEnum.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $lastEditorId = this.getLastEditorId();
      result = result * 59 + ($lastEditorId == null ? 43 : $lastEditorId.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $boolArtifactImport = this.getBoolArtifactImport();
      result = result * 59 + ($boolArtifactImport == null ? 43 : $boolArtifactImport.hashCode());
      Object $boolUnderReview = this.getBoolUnderReview();
      result = result * 59 + ($boolUnderReview == null ? 43 : $boolUnderReview.hashCode());
      Object $boolInbound = this.getBoolInbound();
      result = result * 59 + ($boolInbound == null ? 43 : $boolInbound.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $enclosurePlan = this.getEnclosurePlan();
      result = result * 59 + ($enclosurePlan == null ? 43 : $enclosurePlan.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $printTime = this.getPrintTime();
      result = result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
      Object $totalCargoNetweight = this.getTotalCargoNetweight();
      return result * 59 + ($totalCargoNetweight == null ? 43 : $totalCargoNetweight.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartWMSDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", classifyName="
         + this.getClassifyName()
         + ", category="
         + this.getCategory()
         + ", enclosurePlan="
         + this.getEnclosurePlan()
         + ", relationType="
         + this.getRelationType()
         + ", useProperty="
         + this.getUseProperty()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", boolWeightTypeEnum="
         + this.getBoolWeightTypeEnum()
         + ", remark="
         + this.getRemark()
         + ", businessId="
         + this.getBusinessId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", lastEditorId="
         + this.getLastEditorId()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ", boolArtifactImport="
         + this.getBoolArtifactImport()
         + ", totalCargoNetweight="
         + this.getTotalCargoNetweight()
         + ", boolUnderReview="
         + this.getBoolUnderReview()
         + ", boolInbound="
         + this.getBoolInbound()
         + ")";
   }

   public static class TechStandardPartWMSDTOBuilder {
      private Long id;
      private String name;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private String classifyName;
      private Integer category;
      private NameInfo enclosurePlan;
      private Integer relationType;
      private Integer useProperty;
      private String specification;
      private String measureUnit;
      private Integer quantity;
      private BigDecimal mete;
      private String accountingUnit;
      private Boolean boolWeightTypeEnum;
      private String remark;
      private Long businessId;
      private Long userId;
      private String userName;
      private LocalDateTime createTime;
      private Long lastEditorId;
      private Integer printQuantity;
      private LocalDateTime printTime;
      private Boolean boolArtifactImport;
      private BigDecimal totalCargoNetweight;
      private Boolean boolUnderReview;
      private Integer boolInbound;

      TechStandardPartWMSDTOBuilder() {
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder enclosurePlan(final NameInfo enclosurePlan) {
         this.enclosurePlan = enclosurePlan;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder boolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
         this.boolWeightTypeEnum = boolWeightTypeEnum;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder lastEditorId(final Long lastEditorId) {
         this.lastEditorId = lastEditorId;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder boolArtifactImport(final Boolean boolArtifactImport) {
         this.boolArtifactImport = boolArtifactImport;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder totalCargoNetweight(final BigDecimal totalCargoNetweight) {
         this.totalCargoNetweight = totalCargoNetweight;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder boolUnderReview(final Boolean boolUnderReview) {
         this.boolUnderReview = boolUnderReview;
         return this;
      }

      public TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder boolInbound(final Integer boolInbound) {
         this.boolInbound = boolInbound;
         return this;
      }

      public TechStandardPartWMSDTO build() {
         return new TechStandardPartWMSDTO(
            this.id,
            this.name,
            this.project,
            this.monomer,
            this.area,
            this.classifyName,
            this.category,
            this.enclosurePlan,
            this.relationType,
            this.useProperty,
            this.specification,
            this.measureUnit,
            this.quantity,
            this.mete,
            this.accountingUnit,
            this.boolWeightTypeEnum,
            this.remark,
            this.businessId,
            this.userId,
            this.userName,
            this.createTime,
            this.lastEditorId,
            this.printQuantity,
            this.printTime,
            this.boolArtifactImport,
            this.totalCargoNetweight,
            this.boolUnderReview,
            this.boolInbound
         );
      }

      @Override
      public String toString() {
         return "TechStandardPartWMSDTO.TechStandardPartWMSDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", classifyName="
            + this.classifyName
            + ", category="
            + this.category
            + ", enclosurePlan="
            + this.enclosurePlan
            + ", relationType="
            + this.relationType
            + ", useProperty="
            + this.useProperty
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", boolWeightTypeEnum="
            + this.boolWeightTypeEnum
            + ", remark="
            + this.remark
            + ", businessId="
            + this.businessId
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", createTime="
            + this.createTime
            + ", lastEditorId="
            + this.lastEditorId
            + ", printQuantity="
            + this.printQuantity
            + ", printTime="
            + this.printTime
            + ", boolArtifactImport="
            + this.boolArtifactImport
            + ", totalCargoNetweight="
            + this.totalCargoNetweight
            + ", boolUnderReview="
            + this.boolUnderReview
            + ", boolInbound="
            + this.boolInbound
            + ")";
      }
   }
}
