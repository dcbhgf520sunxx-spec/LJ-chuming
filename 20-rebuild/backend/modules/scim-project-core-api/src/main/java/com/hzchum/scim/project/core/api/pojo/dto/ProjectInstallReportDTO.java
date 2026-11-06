package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "ProjectInstallReport对象", description = "项目安装填报表 ")
public class ProjectInstallReportDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "supplier", value = "分包商")
   private NameInfo supplier;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型(2构件 , 4围护 , 8配套件)")
   private Integer productType;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品ID(构件、围护、配套件id)", notes = "产品ID(构件、围护、配套件id)")
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "reportQuantity", value = "填报数量", notes = "填报数量")
   private BigDecimal reportQuantity;
   @ApiModelProperty(name = "reportMete", value = "填报量(重量kg/长度mm)", notes = "填报量(重量kg/长度mm)")
   private BigDecimal reportMete;
   @ApiModelProperty(name = "reportTotalArea", value = "填报总面积(mm2)", notes = "填报总面积(mm2)")
   private BigDecimal reportTotalArea;
   @ApiModelProperty(name = "supplierId", value = "安装供应商id", notes = "安装供应商id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "安装供应商名称", notes = "安装供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量", notes = "实际数量")
   @JsonInclude(Include.NON_NULL)
   private Integer actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度m)", notes = "实际量(重量kg/长度mm)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "实际总面积(mm2)", notes = "实际总面积(mm2)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal actualTotalArea;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;
   @ApiModelProperty(name = "reportMethod", value = "填报方式 1:app端 0:pc端", notes = "填报方式 1:app端 0:pc端")
   private Integer reportMethod;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "createTime", value = "上报时间", notes = "上报时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "reportUserName", value = "上报人", notes = "上报人")
   private String reportUserName;

   public static ProjectInstallReportDTO.ProjectInstallReportDTOBuilder builder() {
      return new ProjectInstallReportDTO.ProjectInstallReportDTOBuilder();
   }

   public ProjectInstallReportDTO() {
   }

   public ProjectInstallReportDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final NameInfo monomer,
      final Long areaId,
      final NameInfo area,
      final NameInfo supplier,
      final Integer projectType,
      final Integer productType,
      final Integer category,
      final Long productId,
      final String serialNumber,
      final String name,
      final String specification,
      final BigDecimal length,
      final BigDecimal netWeight,
      final BigDecimal reportQuantity,
      final BigDecimal reportMete,
      final BigDecimal reportTotalArea,
      final Long supplierId,
      final String supplierName,
      final Integer auditStatus,
      final Integer actualQuantity,
      final BigDecimal actualMete,
      final BigDecimal actualTotalArea,
      final LocalDateTime auditTime,
      final Long auditUserId,
      final String auditUserName,
      final Integer reportMethod,
      final String measureUnit,
      final String accountingUnit,
      final LocalDateTime createTime,
      final String reportUserName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.monomer = monomer;
      this.areaId = areaId;
      this.area = area;
      this.supplier = supplier;
      this.projectType = projectType;
      this.productType = productType;
      this.category = category;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.length = length;
      this.netWeight = netWeight;
      this.reportQuantity = reportQuantity;
      this.reportMete = reportMete;
      this.reportTotalArea = reportTotalArea;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.auditStatus = auditStatus;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
      this.auditTime = auditTime;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.reportMethod = reportMethod;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.createTime = createTime;
      this.reportUserName = reportUserName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public NameInfo getSupplier() {
      return this.supplier;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportMete() {
      return this.reportMete;
   }

   public BigDecimal getReportTotalArea() {
      return this.reportTotalArea;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Integer getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getReportMethod() {
      return this.reportMethod;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getReportUserName() {
      return this.reportUserName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setSupplier(final NameInfo supplier) {
      this.supplier = supplier;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
   }

   public void setReportMete(final BigDecimal reportMete) {
      this.reportMete = reportMete;
   }

   public void setReportTotalArea(final BigDecimal reportTotalArea) {
      this.reportTotalArea = reportTotalArea;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setActualQuantity(final Integer actualQuantity) {
      this.actualQuantity = actualQuantity;
   }

   public void setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
   }

   public void setActualTotalArea(final BigDecimal actualTotalArea) {
      this.actualTotalArea = actualTotalArea;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setReportMethod(final Integer reportMethod) {
      this.reportMethod = reportMethod;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReportUserName(final String reportUserName) {
      this.reportUserName = reportUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallReportDTO)) {
         return false;
      }

      ProjectInstallReportDTO other = (ProjectInstallReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$supplierId = this.getSupplierId();
                              Object other$supplierId = other.getSupplierId();
                              if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                 Object this$auditStatus = this.getAuditStatus();
                                 Object other$auditStatus = other.getAuditStatus();
                                 if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                    Object this$actualQuantity = this.getActualQuantity();
                                    Object other$actualQuantity = other.getActualQuantity();
                                    if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
                                       Object this$auditUserId = this.getAuditUserId();
                                       Object other$auditUserId = other.getAuditUserId();
                                       if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                          Object this$reportMethod = this.getReportMethod();
                                          Object other$reportMethod = other.getReportMethod();
                                          if (this$reportMethod == null ? other$reportMethod == null : this$reportMethod.equals(other$reportMethod)) {
                                             Object this$monomer = this.getMonomer();
                                             Object other$monomer = other.getMonomer();
                                             if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                Object this$area = this.getArea();
                                                Object other$area = other.getArea();
                                                if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                   Object this$supplier = this.getSupplier();
                                                   Object other$supplier = other.getSupplier();
                                                   if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                                      Object this$serialNumber = this.getSerialNumber();
                                                      Object other$serialNumber = other.getSerialNumber();
                                                      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)
                                                         )
                                                       {
                                                         Object this$name = this.getName();
                                                         Object other$name = other.getName();
                                                         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$length = this.getLength();
                                                               Object other$length = other.getLength();
                                                               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                  Object this$netWeight = this.getNetWeight();
                                                                  Object other$netWeight = other.getNetWeight();
                                                                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)
                                                                     )
                                                                   {
                                                                     Object this$reportQuantity = this.getReportQuantity();
                                                                     Object other$reportQuantity = other.getReportQuantity();
                                                                     if (this$reportQuantity == null
                                                                        ? other$reportQuantity == null
                                                                        : this$reportQuantity.equals(other$reportQuantity)) {
                                                                        Object this$reportMete = this.getReportMete();
                                                                        Object other$reportMete = other.getReportMete();
                                                                        if (this$reportMete == null
                                                                           ? other$reportMete == null
                                                                           : this$reportMete.equals(other$reportMete)) {
                                                                           Object this$reportTotalArea = this.getReportTotalArea();
                                                                           Object other$reportTotalArea = other.getReportTotalArea();
                                                                           if (this$reportTotalArea == null
                                                                              ? other$reportTotalArea == null
                                                                              : this$reportTotalArea.equals(other$reportTotalArea)) {
                                                                              Object this$supplierName = this.getSupplierName();
                                                                              Object other$supplierName = other.getSupplierName();
                                                                              if (this$supplierName == null
                                                                                 ? other$supplierName == null
                                                                                 : this$supplierName.equals(other$supplierName)) {
                                                                                 Object this$actualMete = this.getActualMete();
                                                                                 Object other$actualMete = other.getActualMete();
                                                                                 if (this$actualMete == null
                                                                                    ? other$actualMete == null
                                                                                    : this$actualMete.equals(other$actualMete)) {
                                                                                    Object this$actualTotalArea = this.getActualTotalArea();
                                                                                    Object other$actualTotalArea = other.getActualTotalArea();
                                                                                    if (this$actualTotalArea == null
                                                                                       ? other$actualTotalArea == null
                                                                                       : this$actualTotalArea.equals(other$actualTotalArea)) {
                                                                                       Object this$auditTime = this.getAuditTime();
                                                                                       Object other$auditTime = other.getAuditTime();
                                                                                       if (this$auditTime == null
                                                                                          ? other$auditTime == null
                                                                                          : this$auditTime.equals(other$auditTime)) {
                                                                                          Object this$auditUserName = this.getAuditUserName();
                                                                                          Object other$auditUserName = other.getAuditUserName();
                                                                                          if (this$auditUserName == null
                                                                                             ? other$auditUserName == null
                                                                                             : this$auditUserName.equals(other$auditUserName)) {
                                                                                             Object this$measureUnit = this.getMeasureUnit();
                                                                                             Object other$measureUnit = other.getMeasureUnit();
                                                                                             if (this$measureUnit == null
                                                                                                ? other$measureUnit == null
                                                                                                : this$measureUnit.equals(other$measureUnit)) {
                                                                                                Object this$accountingUnit = this.getAccountingUnit();
                                                                                                Object other$accountingUnit = other.getAccountingUnit();
                                                                                                if (this$accountingUnit == null
                                                                                                   ? other$accountingUnit == null
                                                                                                   : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                                   Object this$createTime = this.getCreateTime();
                                                                                                   Object other$createTime = other.getCreateTime();
                                                                                                   if (this$createTime == null
                                                                                                      ? other$createTime == null
                                                                                                      : this$createTime.equals(other$createTime)) {
                                                                                                      Object this$reportUserName = this.getReportUserName();
                                                                                                      Object other$reportUserName = other.getReportUserName();
                                                                                                      return this$reportUserName == null
                                                                                                         ? other$reportUserName == null
                                                                                                         : this$reportUserName.equals(other$reportUserName);
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
      return other instanceof ProjectInstallReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $reportMethod = this.getReportMethod();
      result = result * 59 + ($reportMethod == null ? 43 : $reportMethod.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reportMete = this.getReportMete();
      result = result * 59 + ($reportMete == null ? 43 : $reportMete.hashCode());
      Object $reportTotalArea = this.getReportTotalArea();
      result = result * 59 + ($reportTotalArea == null ? 43 : $reportTotalArea.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      result = result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reportUserName = this.getReportUserName();
      return result * 59 + ($reportUserName == null ? 43 : $reportUserName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallReportDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomer="
         + this.getMonomer()
         + ", areaId="
         + this.getAreaId()
         + ", area="
         + this.getArea()
         + ", supplier="
         + this.getSupplier()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportMete="
         + this.getReportMete()
         + ", reportTotalArea="
         + this.getReportTotalArea()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", reportMethod="
         + this.getReportMethod()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", createTime="
         + this.getCreateTime()
         + ", reportUserName="
         + this.getReportUserName()
         + ")";
   }

   public static class ProjectInstallReportDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private NameInfo monomer;
      private Long areaId;
      private NameInfo area;
      private NameInfo supplier;
      private Integer projectType;
      private Integer productType;
      private Integer category;
      private Long productId;
      private String serialNumber;
      private String name;
      private String specification;
      private BigDecimal length;
      private BigDecimal netWeight;
      private BigDecimal reportQuantity;
      private BigDecimal reportMete;
      private BigDecimal reportTotalArea;
      private Long supplierId;
      private String supplierName;
      private Integer auditStatus;
      private Integer actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;
      private LocalDateTime auditTime;
      private Long auditUserId;
      private String auditUserName;
      private Integer reportMethod;
      private String measureUnit;
      private String accountingUnit;
      private LocalDateTime createTime;
      private String reportUserName;

      ProjectInstallReportDTOBuilder() {
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder supplier(final NameInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder reportQuantity(final BigDecimal reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder reportMete(final BigDecimal reportMete) {
         this.reportMete = reportMete;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder reportTotalArea(final BigDecimal reportTotalArea) {
         this.reportTotalArea = reportTotalArea;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder actualQuantity(final Integer actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder reportMethod(final Integer reportMethod) {
         this.reportMethod = reportMethod;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectInstallReportDTO.ProjectInstallReportDTOBuilder reportUserName(final String reportUserName) {
         this.reportUserName = reportUserName;
         return this;
      }

      public ProjectInstallReportDTO build() {
         return new ProjectInstallReportDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.monomer,
            this.areaId,
            this.area,
            this.supplier,
            this.projectType,
            this.productType,
            this.category,
            this.productId,
            this.serialNumber,
            this.name,
            this.specification,
            this.length,
            this.netWeight,
            this.reportQuantity,
            this.reportMete,
            this.reportTotalArea,
            this.supplierId,
            this.supplierName,
            this.auditStatus,
            this.actualQuantity,
            this.actualMete,
            this.actualTotalArea,
            this.auditTime,
            this.auditUserId,
            this.auditUserName,
            this.reportMethod,
            this.measureUnit,
            this.accountingUnit,
            this.createTime,
            this.reportUserName
         );
      }

      @Override
      public String toString() {
         return "ProjectInstallReportDTO.ProjectInstallReportDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", monomer="
            + this.monomer
            + ", areaId="
            + this.areaId
            + ", area="
            + this.area
            + ", supplier="
            + this.supplier
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportMete="
            + this.reportMete
            + ", reportTotalArea="
            + this.reportTotalArea
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", auditStatus="
            + this.auditStatus
            + ", actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", actualTotalArea="
            + this.actualTotalArea
            + ", auditTime="
            + this.auditTime
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", reportMethod="
            + this.reportMethod
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", createTime="
            + this.createTime
            + ", reportUserName="
            + this.reportUserName
            + ")";
      }
   }
}
