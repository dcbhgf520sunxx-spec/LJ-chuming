package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("外协可入库详细信息")
public class SinglePartArtifactPrintDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名", notes = "单体名")
   private String monomerName;
   @ApiModelProperty(name = "planId", value = "区域id", notes = "区域id")
   private Long planId;
   @ApiModelProperty(name = "areaName", value = "区域名", notes = "区域名")
   private String areaName;
   @ApiModelProperty(value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(value = "车间名", notes = "车间名")
   private String workshopName;
   @ApiModelProperty(value = "工厂id", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty(value = "工厂名", notes = "工厂名")
   private String factoryName;
   @ApiModelProperty(value = "数量", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(value = "已入库数量", notes = "已入库数量")
   private Integer reportQuantity;
   @ApiModelProperty(value = "可入库数量", notes = "可入库数量")
   private Integer needQuantity;
   @ApiModelProperty(value = "已打印数量", notes = "打印数量")
   private Integer printQuantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(value = "一物一码号", notes = "一物一码号")
   private Integer number;
   @ApiModelProperty(value = "是否全部上报 打印 1是 0否", notes = "是否全部上报 1是 0否")
   private Boolean boolAllReport;
   @ApiModelProperty(value = "操作人ID", notes = "操作人ID")
   private Long operationId;
   @ApiModelProperty(value = "操作人名", notes = "操作人名")
   private String operationName;
   @ApiModelProperty(value = "打印人ID", notes = "打印人ID")
   private Long printUserId;
   @ApiModelProperty(value = "打印人名", notes = "打印人名")
   private String printUserName;
   @ApiModelProperty(value = "打印时间", notes = "打印时间")
   private LocalDateTime printTime;
   @ApiModelProperty(name = "bool_assist", value = "是否是外协构件", notes = "是否是外协构件")
   private Boolean boolAssist;

   public static SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder builder() {
      return new SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder();
   }

   public SinglePartArtifactPrintDTO() {
   }

   public SinglePartArtifactPrintDTO(
      final Long id,
      final ProjectInfo project,
      final Long monomerId,
      final String monomerName,
      final Long planId,
      final String areaName,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Long workshopId,
      final String workshopName,
      final Long factoryId,
      final String factoryName,
      final Integer quantity,
      final Integer reportQuantity,
      final Integer needQuantity,
      final Integer printQuantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer number,
      final Boolean boolAllReport,
      final Long operationId,
      final String operationName,
      final Long printUserId,
      final String printUserName,
      final LocalDateTime printTime,
      final Boolean boolAssist
   ) {
      this.id = id;
      this.project = project;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.planId = planId;
      this.areaName = areaName;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.quantity = quantity;
      this.reportQuantity = reportQuantity;
      this.needQuantity = needQuantity;
      this.printQuantity = printQuantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.number = number;
      this.boolAllReport = boolAllReport;
      this.operationId = operationId;
      this.operationName = operationName;
      this.printUserId = printUserId;
      this.printUserName = printUserName;
      this.printTime = printTime;
      this.boolAssist = boolAssist;
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

   public Long getPlanId() {
      return this.planId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getProductId() {
      return this.productId;
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

   public String getMaterial() {
      return this.material;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Boolean getBoolAllReport() {
      return this.boolAllReport;
   }

   public Long getOperationId() {
      return this.operationId;
   }

   public String getOperationName() {
      return this.operationName;
   }

   public Long getPrintUserId() {
      return this.printUserId;
   }

   public String getPrintUserName() {
      return this.printUserName;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
   }

   public void setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setBoolAllReport(final Boolean boolAllReport) {
      this.boolAllReport = boolAllReport;
   }

   public void setOperationId(final Long operationId) {
      this.operationId = operationId;
   }

   public void setOperationName(final String operationName) {
      this.operationName = operationName;
   }

   public void setPrintUserId(final Long printUserId) {
      this.printUserId = printUserId;
   }

   public void setPrintUserName(final String printUserName) {
      this.printUserName = printUserName;
   }

   public void setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
   }

   public void setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SinglePartArtifactPrintDTO)) {
         return false;
      }

      SinglePartArtifactPrintDTO other = (SinglePartArtifactPrintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$factoryId = this.getFactoryId();
                     Object other$factoryId = other.getFactoryId();
                     if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$reportQuantity = this.getReportQuantity();
                           Object other$reportQuantity = other.getReportQuantity();
                           if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
                              Object this$needQuantity = this.getNeedQuantity();
                              Object other$needQuantity = other.getNeedQuantity();
                              if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                                 Object this$printQuantity = this.getPrintQuantity();
                                 Object other$printQuantity = other.getPrintQuantity();
                                 if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                    Object this$number = this.getNumber();
                                    Object other$number = other.getNumber();
                                    if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                       Object this$boolAllReport = this.getBoolAllReport();
                                       Object other$boolAllReport = other.getBoolAllReport();
                                       if (this$boolAllReport == null ? other$boolAllReport == null : this$boolAllReport.equals(other$boolAllReport)) {
                                          Object this$operationId = this.getOperationId();
                                          Object other$operationId = other.getOperationId();
                                          if (this$operationId == null ? other$operationId == null : this$operationId.equals(other$operationId)) {
                                             Object this$printUserId = this.getPrintUserId();
                                             Object other$printUserId = other.getPrintUserId();
                                             if (this$printUserId == null ? other$printUserId == null : this$printUserId.equals(other$printUserId)) {
                                                Object this$boolAssist = this.getBoolAssist();
                                                Object other$boolAssist = other.getBoolAssist();
                                                if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
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
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$specification = this.getSpecification();
                                                                  Object other$specification = other.getSpecification();
                                                                  if (this$specification == null
                                                                     ? other$specification == null
                                                                     : this$specification.equals(other$specification)) {
                                                                     Object this$material = this.getMaterial();
                                                                     Object other$material = other.getMaterial();
                                                                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                        Object this$workshopName = this.getWorkshopName();
                                                                        Object other$workshopName = other.getWorkshopName();
                                                                        if (this$workshopName == null
                                                                           ? other$workshopName == null
                                                                           : this$workshopName.equals(other$workshopName)) {
                                                                           Object this$factoryName = this.getFactoryName();
                                                                           Object other$factoryName = other.getFactoryName();
                                                                           if (this$factoryName == null
                                                                              ? other$factoryName == null
                                                                              : this$factoryName.equals(other$factoryName)) {
                                                                              Object this$netWeight = this.getNetWeight();
                                                                              Object other$netWeight = other.getNetWeight();
                                                                              if (this$netWeight == null
                                                                                 ? other$netWeight == null
                                                                                 : this$netWeight.equals(other$netWeight)) {
                                                                                 Object this$grossWeight = this.getGrossWeight();
                                                                                 Object other$grossWeight = other.getGrossWeight();
                                                                                 if (this$grossWeight == null
                                                                                    ? other$grossWeight == null
                                                                                    : this$grossWeight.equals(other$grossWeight)) {
                                                                                    Object this$operationName = this.getOperationName();
                                                                                    Object other$operationName = other.getOperationName();
                                                                                    if (this$operationName == null
                                                                                       ? other$operationName == null
                                                                                       : this$operationName.equals(other$operationName)) {
                                                                                       Object this$printUserName = this.getPrintUserName();
                                                                                       Object other$printUserName = other.getPrintUserName();
                                                                                       if (this$printUserName == null
                                                                                          ? other$printUserName == null
                                                                                          : this$printUserName.equals(other$printUserName)) {
                                                                                          Object this$printTime = this.getPrintTime();
                                                                                          Object other$printTime = other.getPrintTime();
                                                                                          return this$printTime == null
                                                                                             ? other$printTime == null
                                                                                             : this$printTime.equals(other$printTime);
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
      return other instanceof SinglePartArtifactPrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolAllReport = this.getBoolAllReport();
      result = result * 59 + ($boolAllReport == null ? 43 : $boolAllReport.hashCode());
      Object $operationId = this.getOperationId();
      result = result * 59 + ($operationId == null ? 43 : $operationId.hashCode());
      Object $printUserId = this.getPrintUserId();
      result = result * 59 + ($printUserId == null ? 43 : $printUserId.hashCode());
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
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
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $operationName = this.getOperationName();
      result = result * 59 + ($operationName == null ? 43 : $operationName.hashCode());
      Object $printUserName = this.getPrintUserName();
      result = result * 59 + ($printUserName == null ? 43 : $printUserName.hashCode());
      Object $printTime = this.getPrintTime();
      return result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
   }

   @Override
   public String toString() {
      return "SinglePartArtifactPrintDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", planId="
         + this.getPlanId()
         + ", areaName="
         + this.getAreaName()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", quantity="
         + this.getQuantity()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", number="
         + this.getNumber()
         + ", boolAllReport="
         + this.getBoolAllReport()
         + ", operationId="
         + this.getOperationId()
         + ", operationName="
         + this.getOperationName()
         + ", printUserId="
         + this.getPrintUserId()
         + ", printUserName="
         + this.getPrintUserName()
         + ", printTime="
         + this.getPrintTime()
         + ", boolAssist="
         + this.getBoolAssist()
         + ")";
   }

   public static class SinglePartArtifactPrintDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private Long monomerId;
      private String monomerName;
      private Long planId;
      private String areaName;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Long workshopId;
      private String workshopName;
      private Long factoryId;
      private String factoryName;
      private Integer quantity;
      private Integer reportQuantity;
      private Integer needQuantity;
      private Integer printQuantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer number;
      private Boolean boolAllReport;
      private Long operationId;
      private String operationName;
      private Long printUserId;
      private String printUserName;
      private LocalDateTime printTime;
      private Boolean boolAssist;

      SinglePartArtifactPrintDTOBuilder() {
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder boolAllReport(final Boolean boolAllReport) {
         this.boolAllReport = boolAllReport;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder operationId(final Long operationId) {
         this.operationId = operationId;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder operationName(final String operationName) {
         this.operationName = operationName;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder printUserId(final Long printUserId) {
         this.printUserId = printUserId;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder printUserName(final String printUserName) {
         this.printUserName = printUserName;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      public SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder boolAssist(final Boolean boolAssist) {
         this.boolAssist = boolAssist;
         return this;
      }

      public SinglePartArtifactPrintDTO build() {
         return new SinglePartArtifactPrintDTO(
            this.id,
            this.project,
            this.monomerId,
            this.monomerName,
            this.planId,
            this.areaName,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.workshopId,
            this.workshopName,
            this.factoryId,
            this.factoryName,
            this.quantity,
            this.reportQuantity,
            this.needQuantity,
            this.printQuantity,
            this.netWeight,
            this.grossWeight,
            this.number,
            this.boolAllReport,
            this.operationId,
            this.operationName,
            this.printUserId,
            this.printUserName,
            this.printTime,
            this.boolAssist
         );
      }

      @Override
      public String toString() {
         return "SinglePartArtifactPrintDTO.SinglePartArtifactPrintDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", planId="
            + this.planId
            + ", areaName="
            + this.areaName
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", quantity="
            + this.quantity
            + ", reportQuantity="
            + this.reportQuantity
            + ", needQuantity="
            + this.needQuantity
            + ", printQuantity="
            + this.printQuantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", number="
            + this.number
            + ", boolAllReport="
            + this.boolAllReport
            + ", operationId="
            + this.operationId
            + ", operationName="
            + this.operationName
            + ", printUserId="
            + this.printUserId
            + ", printUserName="
            + this.printUserName
            + ", printTime="
            + this.printTime
            + ", boolAssist="
            + this.boolAssist
            + ")";
      }
   }
}
