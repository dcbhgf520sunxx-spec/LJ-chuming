package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("配套件(辅材)DTO类")
public class TechStandardPartDetailDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty("入库Id")
   private Long whId;
   @ApiModelProperty(name = "productId", value = "产品Id", notes = "产品Id")
   private Long productId;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体id ")
   private Long monomerId;
   @ApiModelProperty(name = "monomerId", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "classifyFullName", value = "分类全称 ")
   private String classifyFullName;
   @ApiModelProperty(name = "classifyId", value = "科目id")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   private String classifyName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   private Long dictionaryId;
   @ApiModelProperty(name = "category", value = "品类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlan", value = "围护计划")
   private NameInfo enclosurePlan;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   private Integer relationType;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
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
   @ApiModelProperty(name = "boolInbound", value = "是否入库 0未入库 1 wms已入库", notes = "是否入库 0未入库 1 wms已入库")
   private Boolean boolInbound;
   @ApiModelProperty(name = "configStatus", value = "配置状态 0未配置  1已配置  默认0", notes = "配置状态 0未配置  1已配置  默认0")
   @JsonProperty("configStatus")
   @JSONField(name = "configStatus")
   private Boolean configStatus;
   @ApiModelProperty("入库数量")
   private Integer warehouseQuantity;
   @ApiModelProperty(name = "warehouseMete", value = "入库核算量", notes = "入库核算量")
   private BigDecimal warehouseMete;
   @ApiModelProperty("是否无需上报 true 不上报(即入即安) false 上报 ")
   private Boolean boolNoReport;

   public static TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder builder() {
      return new TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder();
   }

   public TechStandardPartDetailDTO() {
   }

   public TechStandardPartDetailDTO(
      final Long id,
      final Long whId,
      final Long productId,
      final ProjectInfo project,
      final Long monomerId,
      final NameInfo monomer,
      final String name,
      final NameInfo area,
      final String classifyFullName,
      final Long classifyId,
      final String classifyName,
      final String serialNumber,
      final String specification,
      final BigDecimal quantity,
      final Long dictionaryId,
      final Integer category,
      final NameInfo enclosurePlan,
      final Integer relationType,
      final Integer useProperty,
      final String measureUnit,
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
      final Boolean boolInbound,
      final Boolean configStatus,
      final Integer warehouseQuantity,
      final BigDecimal warehouseMete,
      final Boolean boolNoReport
   ) {
      this.id = id;
      this.whId = whId;
      this.productId = productId;
      this.project = project;
      this.monomerId = monomerId;
      this.monomer = monomer;
      this.name = name;
      this.area = area;
      this.classifyFullName = classifyFullName;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.dictionaryId = dictionaryId;
      this.category = category;
      this.enclosurePlan = enclosurePlan;
      this.relationType = relationType;
      this.useProperty = useProperty;
      this.measureUnit = measureUnit;
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
      this.boolInbound = boolInbound;
      this.configStatus = configStatus;
      this.warehouseQuantity = warehouseQuantity;
      this.warehouseMete = warehouseMete;
      this.boolNoReport = boolNoReport;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWhId() {
      return this.whId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public String getName() {
      return this.name;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getClassifyFullName() {
      return this.classifyFullName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
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

   public String getMeasureUnit() {
      return this.measureUnit;
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

   public Boolean getBoolInbound() {
      return this.boolInbound;
   }

   public Boolean getConfigStatus() {
      return this.configStatus;
   }

   public Integer getWarehouseQuantity() {
      return this.warehouseQuantity;
   }

   public BigDecimal getWarehouseMete() {
      return this.warehouseMete;
   }

   public Boolean getBoolNoReport() {
      return this.boolNoReport;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWhId(final Long whId) {
      this.whId = whId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setClassifyFullName(final String classifyFullName) {
      this.classifyFullName = classifyFullName;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
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

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
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

   public void setBoolInbound(final Boolean boolInbound) {
      this.boolInbound = boolInbound;
   }

   @JsonProperty("configStatus")
   public void setConfigStatus(final Boolean configStatus) {
      this.configStatus = configStatus;
   }

   public void setWarehouseQuantity(final Integer warehouseQuantity) {
      this.warehouseQuantity = warehouseQuantity;
   }

   public void setWarehouseMete(final BigDecimal warehouseMete) {
      this.warehouseMete = warehouseMete;
   }

   public void setBoolNoReport(final Boolean boolNoReport) {
      this.boolNoReport = boolNoReport;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartDetailDTO)) {
         return false;
      }

      TechStandardPartDetailDTO other = (TechStandardPartDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$whId = this.getWhId();
         Object other$whId = other.getWhId();
         if (this$whId == null ? other$whId == null : this$whId.equals(other$whId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$dictionaryId = this.getDictionaryId();
                     Object other$dictionaryId = other.getDictionaryId();
                     if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$relationType = this.getRelationType();
                           Object other$relationType = other.getRelationType();
                           if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                              Object this$useProperty = this.getUseProperty();
                              Object other$useProperty = other.getUseProperty();
                              if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                                 Object this$boolWeightTypeEnum = this.getBoolWeightTypeEnum();
                                 Object other$boolWeightTypeEnum = other.getBoolWeightTypeEnum();
                                 if (this$boolWeightTypeEnum == null
                                    ? other$boolWeightTypeEnum == null
                                    : this$boolWeightTypeEnum.equals(other$boolWeightTypeEnum)) {
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
                                                   Object this$boolInbound = this.getBoolInbound();
                                                   Object other$boolInbound = other.getBoolInbound();
                                                   if (this$boolInbound == null ? other$boolInbound == null : this$boolInbound.equals(other$boolInbound)) {
                                                      Object this$configStatus = this.getConfigStatus();
                                                      Object other$configStatus = other.getConfigStatus();
                                                      if (this$configStatus == null ? other$configStatus == null : this$configStatus.equals(other$configStatus)
                                                         )
                                                       {
                                                         Object this$warehouseQuantity = this.getWarehouseQuantity();
                                                         Object other$warehouseQuantity = other.getWarehouseQuantity();
                                                         if (this$warehouseQuantity == null
                                                            ? other$warehouseQuantity == null
                                                            : this$warehouseQuantity.equals(other$warehouseQuantity)) {
                                                            Object this$boolNoReport = this.getBoolNoReport();
                                                            Object other$boolNoReport = other.getBoolNoReport();
                                                            if (this$boolNoReport == null
                                                               ? other$boolNoReport == null
                                                               : this$boolNoReport.equals(other$boolNoReport)) {
                                                               Object this$project = this.getProject();
                                                               Object other$project = other.getProject();
                                                               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                  Object this$monomer = this.getMonomer();
                                                                  Object other$monomer = other.getMonomer();
                                                                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                                     Object this$name = this.getName();
                                                                     Object other$name = other.getName();
                                                                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                        Object this$area = this.getArea();
                                                                        Object other$area = other.getArea();
                                                                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                                           Object this$classifyFullName = this.getClassifyFullName();
                                                                           Object other$classifyFullName = other.getClassifyFullName();
                                                                           if (this$classifyFullName == null
                                                                              ? other$classifyFullName == null
                                                                              : this$classifyFullName.equals(other$classifyFullName)) {
                                                                              Object this$classifyName = this.getClassifyName();
                                                                              Object other$classifyName = other.getClassifyName();
                                                                              if (this$classifyName == null
                                                                                 ? other$classifyName == null
                                                                                 : this$classifyName.equals(other$classifyName)) {
                                                                                 Object this$serialNumber = this.getSerialNumber();
                                                                                 Object other$serialNumber = other.getSerialNumber();
                                                                                 if (this$serialNumber == null
                                                                                    ? other$serialNumber == null
                                                                                    : this$serialNumber.equals(other$serialNumber)) {
                                                                                    Object this$specification = this.getSpecification();
                                                                                    Object other$specification = other.getSpecification();
                                                                                    if (this$specification == null
                                                                                       ? other$specification == null
                                                                                       : this$specification.equals(other$specification)) {
                                                                                       Object this$quantity = this.getQuantity();
                                                                                       Object other$quantity = other.getQuantity();
                                                                                       if (this$quantity == null
                                                                                          ? other$quantity == null
                                                                                          : this$quantity.equals(other$quantity)) {
                                                                                          Object this$enclosurePlan = this.getEnclosurePlan();
                                                                                          Object other$enclosurePlan = other.getEnclosurePlan();
                                                                                          if (this$enclosurePlan == null
                                                                                             ? other$enclosurePlan == null
                                                                                             : this$enclosurePlan.equals(other$enclosurePlan)) {
                                                                                             Object this$measureUnit = this.getMeasureUnit();
                                                                                             Object other$measureUnit = other.getMeasureUnit();
                                                                                             if (this$measureUnit == null
                                                                                                ? other$measureUnit == null
                                                                                                : this$measureUnit.equals(other$measureUnit)) {
                                                                                                Object this$mete = this.getMete();
                                                                                                Object other$mete = other.getMete();
                                                                                                if (this$mete == null
                                                                                                   ? other$mete == null
                                                                                                   : this$mete.equals(other$mete)) {
                                                                                                   Object this$accountingUnit = this.getAccountingUnit();
                                                                                                   Object other$accountingUnit = other.getAccountingUnit();
                                                                                                   if (this$accountingUnit == null
                                                                                                      ? other$accountingUnit == null
                                                                                                      : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                                      Object this$remark = this.getRemark();
                                                                                                      Object other$remark = other.getRemark();
                                                                                                      if (this$remark == null
                                                                                                         ? other$remark == null
                                                                                                         : this$remark.equals(other$remark)) {
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
                                                                                                                  Object this$warehouseMete = this.getWarehouseMete();
                                                                                                                  Object other$warehouseMete = other.getWarehouseMete();
                                                                                                                  return this$warehouseMete == null
                                                                                                                     ? other$warehouseMete == null
                                                                                                                     : this$warehouseMete.equals(
                                                                                                                        other$warehouseMete
                                                                                                                     );
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
      return other instanceof TechStandardPartDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $whId = this.getWhId();
      result = result * 59 + ($whId == null ? 43 : $whId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
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
      Object $boolInbound = this.getBoolInbound();
      result = result * 59 + ($boolInbound == null ? 43 : $boolInbound.hashCode());
      Object $configStatus = this.getConfigStatus();
      result = result * 59 + ($configStatus == null ? 43 : $configStatus.hashCode());
      Object $warehouseQuantity = this.getWarehouseQuantity();
      result = result * 59 + ($warehouseQuantity == null ? 43 : $warehouseQuantity.hashCode());
      Object $boolNoReport = this.getBoolNoReport();
      result = result * 59 + ($boolNoReport == null ? 43 : $boolNoReport.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $classifyFullName = this.getClassifyFullName();
      result = result * 59 + ($classifyFullName == null ? 43 : $classifyFullName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $enclosurePlan = this.getEnclosurePlan();
      result = result * 59 + ($enclosurePlan == null ? 43 : $enclosurePlan.hashCode());
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
      Object $warehouseMete = this.getWarehouseMete();
      return result * 59 + ($warehouseMete == null ? 43 : $warehouseMete.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartDetailDTO(id="
         + this.getId()
         + ", whId="
         + this.getWhId()
         + ", productId="
         + this.getProductId()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomer="
         + this.getMonomer()
         + ", name="
         + this.getName()
         + ", area="
         + this.getArea()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlan="
         + this.getEnclosurePlan()
         + ", relationType="
         + this.getRelationType()
         + ", useProperty="
         + this.getUseProperty()
         + ", measureUnit="
         + this.getMeasureUnit()
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
         + ", boolInbound="
         + this.getBoolInbound()
         + ", configStatus="
         + this.getConfigStatus()
         + ", warehouseQuantity="
         + this.getWarehouseQuantity()
         + ", warehouseMete="
         + this.getWarehouseMete()
         + ", boolNoReport="
         + this.getBoolNoReport()
         + ")";
   }

   public static class TechStandardPartDetailDTOBuilder {
      private Long id;
      private Long whId;
      private Long productId;
      private ProjectInfo project;
      private Long monomerId;
      private NameInfo monomer;
      private String name;
      private NameInfo area;
      private String classifyFullName;
      private Long classifyId;
      private String classifyName;
      private String serialNumber;
      private String specification;
      private BigDecimal quantity;
      private Long dictionaryId;
      private Integer category;
      private NameInfo enclosurePlan;
      private Integer relationType;
      private Integer useProperty;
      private String measureUnit;
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
      private Boolean boolInbound;
      private Boolean configStatus;
      private Integer warehouseQuantity;
      private BigDecimal warehouseMete;
      private Boolean boolNoReport;

      TechStandardPartDetailDTOBuilder() {
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder whId(final Long whId) {
         this.whId = whId;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder classifyFullName(final String classifyFullName) {
         this.classifyFullName = classifyFullName;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder enclosurePlan(final NameInfo enclosurePlan) {
         this.enclosurePlan = enclosurePlan;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder boolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
         this.boolWeightTypeEnum = boolWeightTypeEnum;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder lastEditorId(final Long lastEditorId) {
         this.lastEditorId = lastEditorId;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder boolArtifactImport(final Boolean boolArtifactImport) {
         this.boolArtifactImport = boolArtifactImport;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder boolInbound(final Boolean boolInbound) {
         this.boolInbound = boolInbound;
         return this;
      }

      @JsonProperty("configStatus")
      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder configStatus(final Boolean configStatus) {
         this.configStatus = configStatus;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder warehouseQuantity(final Integer warehouseQuantity) {
         this.warehouseQuantity = warehouseQuantity;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder warehouseMete(final BigDecimal warehouseMete) {
         this.warehouseMete = warehouseMete;
         return this;
      }

      public TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder boolNoReport(final Boolean boolNoReport) {
         this.boolNoReport = boolNoReport;
         return this;
      }

      public TechStandardPartDetailDTO build() {
         return new TechStandardPartDetailDTO(
            this.id,
            this.whId,
            this.productId,
            this.project,
            this.monomerId,
            this.monomer,
            this.name,
            this.area,
            this.classifyFullName,
            this.classifyId,
            this.classifyName,
            this.serialNumber,
            this.specification,
            this.quantity,
            this.dictionaryId,
            this.category,
            this.enclosurePlan,
            this.relationType,
            this.useProperty,
            this.measureUnit,
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
            this.boolInbound,
            this.configStatus,
            this.warehouseQuantity,
            this.warehouseMete,
            this.boolNoReport
         );
      }

      @Override
      public String toString() {
         return "TechStandardPartDetailDTO.TechStandardPartDetailDTOBuilder(id="
            + this.id
            + ", whId="
            + this.whId
            + ", productId="
            + this.productId
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomer="
            + this.monomer
            + ", name="
            + this.name
            + ", area="
            + this.area
            + ", classifyFullName="
            + this.classifyFullName
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", dictionaryId="
            + this.dictionaryId
            + ", category="
            + this.category
            + ", enclosurePlan="
            + this.enclosurePlan
            + ", relationType="
            + this.relationType
            + ", useProperty="
            + this.useProperty
            + ", measureUnit="
            + this.measureUnit
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
            + ", boolInbound="
            + this.boolInbound
            + ", configStatus="
            + this.configStatus
            + ", warehouseQuantity="
            + this.warehouseQuantity
            + ", warehouseMete="
            + this.warehouseMete
            + ", boolNoReport="
            + this.boolNoReport
            + ")";
      }
   }
}
