package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductTeamSummaryDetailDTO", description = "")
public class ProductTeamSummaryDetailDTO {
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "areaBatch", notes = "批次")
   @JsonProperty("areaBatch")
   @JSONField(name = "areaBatch")
   private NameInfo areaBatch;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private NameInfo process;
   @ApiModelProperty(name = "teamUser", notes = "班组长")
   @JsonProperty("teamUser")
   @JSONField(name = "teamUser")
   private NameInfo teamUser;
   @ApiModelProperty(name = "id", value = "产品id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "reportUserName", value = "上报用户")
   @JsonProperty("reportUserName")
   @JSONField(name = "reportUserName")
   private String reportUserName;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "reportNetWeight", notes = "上报产量(净重)")
   @JsonProperty("reportNetWeight")
   @JSONField(name = "reportNetWeight")
   private BigDecimal reportNetWeight;
   @ApiModelProperty(name = "reportGrossWeight", notes = "上报产量(毛重)")
   @JsonProperty("reportGrossWeight")
   @JSONField(name = "reportGrossWeight")
   private BigDecimal reportGrossWeight;
   @ApiModelProperty("上报人id")
   private Long reporterId;
   @ApiModelProperty("上报日期")
   private String reportingDate;
   @ApiModelProperty("上报人名称")
   private String reporterName;
   @ApiModelProperty("结构类型名称")
   private String structureTypeName;

   public static ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder builder() {
      return new ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder();
   }

   public ProductTeamSummaryDetailDTO() {
   }

   public ProductTeamSummaryDetailDTO(
      final WorkshopDetailDO workshop,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final NameInfo areaBatch,
      final NameInfo process,
      final NameInfo teamUser,
      final Long id,
      final String name,
      final String serialNumber,
      final String specification,
      final String reportUserName,
      final String material,
      final BigDecimal length,
      final BigDecimal grossWeight,
      final BigDecimal netWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final Integer quantity,
      final Integer reportQuantity,
      final BigDecimal reportNetWeight,
      final BigDecimal reportGrossWeight,
      final Long reporterId,
      final String reportingDate,
      final String reporterName,
      final String structureTypeName
   ) {
      this.workshop = workshop;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.areaBatch = areaBatch;
      this.process = process;
      this.teamUser = teamUser;
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.reportUserName = reportUserName;
      this.material = material;
      this.length = length;
      this.grossWeight = grossWeight;
      this.netWeight = netWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.quantity = quantity;
      this.reportQuantity = reportQuantity;
      this.reportNetWeight = reportNetWeight;
      this.reportGrossWeight = reportGrossWeight;
      this.reporterId = reporterId;
      this.reportingDate = reportingDate;
      this.reporterName = reporterName;
      this.structureTypeName = structureTypeName;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public NameInfo getAreaBatch() {
      return this.areaBatch;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public NameInfo getTeamUser() {
      return this.teamUser;
   }

   public Long getId() {
      return this.id;
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

   public String getReportUserName() {
      return this.reportUserName;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportNetWeight() {
      return this.reportNetWeight;
   }

   public BigDecimal getReportGrossWeight() {
      return this.reportGrossWeight;
   }

   public Long getReporterId() {
      return this.reporterId;
   }

   public String getReportingDate() {
      return this.reportingDate;
   }

   public String getReporterName() {
      return this.reporterName;
   }

   public String getStructureTypeName() {
      return this.structureTypeName;
   }

   @JsonProperty("workshop")
   public ProductTeamSummaryDetailDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("project")
   public ProductTeamSummaryDetailDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ProductTeamSummaryDetailDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public ProductTeamSummaryDetailDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("areaBatch")
   public ProductTeamSummaryDetailDTO setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
      return this;
   }

   @JsonProperty("process")
   public ProductTeamSummaryDetailDTO setProcess(final NameInfo process) {
      this.process = process;
      return this;
   }

   @JsonProperty("teamUser")
   public ProductTeamSummaryDetailDTO setTeamUser(final NameInfo teamUser) {
      this.teamUser = teamUser;
      return this;
   }

   @JsonProperty("id")
   public ProductTeamSummaryDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductTeamSummaryDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductTeamSummaryDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProductTeamSummaryDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("reportUserName")
   public ProductTeamSummaryDetailDTO setReportUserName(final String reportUserName) {
      this.reportUserName = reportUserName;
      return this;
   }

   @JsonProperty("material")
   public ProductTeamSummaryDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public ProductTeamSummaryDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("grossWeight")
   public ProductTeamSummaryDetailDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("netWeight")
   public ProductTeamSummaryDetailDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ProductTeamSummaryDetailDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProductTeamSummaryDetailDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("quantity")
   public ProductTeamSummaryDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("reportQuantity")
   public ProductTeamSummaryDetailDTO setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("reportNetWeight")
   public ProductTeamSummaryDetailDTO setReportNetWeight(final BigDecimal reportNetWeight) {
      this.reportNetWeight = reportNetWeight;
      return this;
   }

   @JsonProperty("reportGrossWeight")
   public ProductTeamSummaryDetailDTO setReportGrossWeight(final BigDecimal reportGrossWeight) {
      this.reportGrossWeight = reportGrossWeight;
      return this;
   }

   public ProductTeamSummaryDetailDTO setReporterId(final Long reporterId) {
      this.reporterId = reporterId;
      return this;
   }

   public ProductTeamSummaryDetailDTO setReportingDate(final String reportingDate) {
      this.reportingDate = reportingDate;
      return this;
   }

   public ProductTeamSummaryDetailDTO setReporterName(final String reporterName) {
      this.reporterName = reporterName;
      return this;
   }

   public ProductTeamSummaryDetailDTO setStructureTypeName(final String structureTypeName) {
      this.structureTypeName = structureTypeName;
      return this;
   }

   @Override
   public String toString() {
      return "ProductTeamSummaryDetailDTO(workshop="
         + this.getWorkshop()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", process="
         + this.getProcess()
         + ", teamUser="
         + this.getTeamUser()
         + ", id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", reportUserName="
         + this.getReportUserName()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", quantity="
         + this.getQuantity()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportNetWeight="
         + this.getReportNetWeight()
         + ", reportGrossWeight="
         + this.getReportGrossWeight()
         + ", reporterId="
         + this.getReporterId()
         + ", reportingDate="
         + this.getReportingDate()
         + ", reporterName="
         + this.getReporterName()
         + ", structureTypeName="
         + this.getStructureTypeName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductTeamSummaryDetailDTO)) {
         return false;
      }

      ProductTeamSummaryDetailDTO other = (ProductTeamSummaryDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$reportQuantity = this.getReportQuantity();
            Object other$reportQuantity = other.getReportQuantity();
            if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
               Object this$reporterId = this.getReporterId();
               Object other$reporterId = other.getReporterId();
               if (this$reporterId == null ? other$reporterId == null : this$reporterId.equals(other$reporterId)) {
                  Object this$workshop = this.getWorkshop();
                  Object other$workshop = other.getWorkshop();
                  if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$areaBatch = this.getAreaBatch();
                              Object other$areaBatch = other.getAreaBatch();
                              if (this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch)) {
                                 Object this$process = this.getProcess();
                                 Object other$process = other.getProcess();
                                 if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                    Object this$teamUser = this.getTeamUser();
                                    Object other$teamUser = other.getTeamUser();
                                    if (this$teamUser == null ? other$teamUser == null : this$teamUser.equals(other$teamUser)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$reportUserName = this.getReportUserName();
                                                Object other$reportUserName = other.getReportUserName();
                                                if (this$reportUserName == null
                                                   ? other$reportUserName == null
                                                   : this$reportUserName.equals(other$reportUserName)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$grossWeight = this.getGrossWeight();
                                                         Object other$grossWeight = other.getGrossWeight();
                                                         if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                            Object this$netWeight = this.getNetWeight();
                                                            Object other$netWeight = other.getNetWeight();
                                                            if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                               Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                               Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                               if (this$totalGrossWeight == null
                                                                  ? other$totalGrossWeight == null
                                                                  : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                  Object this$totalNetWeight = this.getTotalNetWeight();
                                                                  Object other$totalNetWeight = other.getTotalNetWeight();
                                                                  if (this$totalNetWeight == null
                                                                     ? other$totalNetWeight == null
                                                                     : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                     Object this$reportNetWeight = this.getReportNetWeight();
                                                                     Object other$reportNetWeight = other.getReportNetWeight();
                                                                     if (this$reportNetWeight == null
                                                                        ? other$reportNetWeight == null
                                                                        : this$reportNetWeight.equals(other$reportNetWeight)) {
                                                                        Object this$reportGrossWeight = this.getReportGrossWeight();
                                                                        Object other$reportGrossWeight = other.getReportGrossWeight();
                                                                        if (this$reportGrossWeight == null
                                                                           ? other$reportGrossWeight == null
                                                                           : this$reportGrossWeight.equals(other$reportGrossWeight)) {
                                                                           Object this$reportingDate = this.getReportingDate();
                                                                           Object other$reportingDate = other.getReportingDate();
                                                                           if (this$reportingDate == null
                                                                              ? other$reportingDate == null
                                                                              : this$reportingDate.equals(other$reportingDate)) {
                                                                              Object this$reporterName = this.getReporterName();
                                                                              Object other$reporterName = other.getReporterName();
                                                                              if (this$reporterName == null
                                                                                 ? other$reporterName == null
                                                                                 : this$reporterName.equals(other$reporterName)) {
                                                                                 Object this$structureTypeName = this.getStructureTypeName();
                                                                                 Object other$structureTypeName = other.getStructureTypeName();
                                                                                 return this$structureTypeName == null
                                                                                    ? other$structureTypeName == null
                                                                                    : this$structureTypeName.equals(other$structureTypeName);
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
      return other instanceof ProductTeamSummaryDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reporterId = this.getReporterId();
      result = result * 59 + ($reporterId == null ? 43 : $reporterId.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $teamUser = this.getTeamUser();
      result = result * 59 + ($teamUser == null ? 43 : $teamUser.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $reportUserName = this.getReportUserName();
      result = result * 59 + ($reportUserName == null ? 43 : $reportUserName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $reportNetWeight = this.getReportNetWeight();
      result = result * 59 + ($reportNetWeight == null ? 43 : $reportNetWeight.hashCode());
      Object $reportGrossWeight = this.getReportGrossWeight();
      result = result * 59 + ($reportGrossWeight == null ? 43 : $reportGrossWeight.hashCode());
      Object $reportingDate = this.getReportingDate();
      result = result * 59 + ($reportingDate == null ? 43 : $reportingDate.hashCode());
      Object $reporterName = this.getReporterName();
      result = result * 59 + ($reporterName == null ? 43 : $reporterName.hashCode());
      Object $structureTypeName = this.getStructureTypeName();
      return result * 59 + ($structureTypeName == null ? 43 : $structureTypeName.hashCode());
   }

   public static class ProductTeamSummaryDetailDTOBuilder {
      private WorkshopDetailDO workshop;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private NameInfo areaBatch;
      private NameInfo process;
      private NameInfo teamUser;
      private Long id;
      private String name;
      private String serialNumber;
      private String specification;
      private String reportUserName;
      private String material;
      private BigDecimal length;
      private BigDecimal grossWeight;
      private BigDecimal netWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private Integer quantity;
      private Integer reportQuantity;
      private BigDecimal reportNetWeight;
      private BigDecimal reportGrossWeight;
      private Long reporterId;
      private String reportingDate;
      private String reporterName;
      private String structureTypeName;

      ProductTeamSummaryDetailDTOBuilder() {
      }

      @JsonProperty("workshop")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("project")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder areaBatch(final NameInfo areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("process")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder process(final NameInfo process) {
         this.process = process;
         return this;
      }

      @JsonProperty("teamUser")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder teamUser(final NameInfo teamUser) {
         this.teamUser = teamUser;
         return this;
      }

      @JsonProperty("id")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("reportUserName")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder reportUserName(final String reportUserName) {
         this.reportUserName = reportUserName;
         return this;
      }

      @JsonProperty("material")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("length")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("grossWeight")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("netWeight")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("quantity")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("reportQuantity")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("reportNetWeight")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder reportNetWeight(final BigDecimal reportNetWeight) {
         this.reportNetWeight = reportNetWeight;
         return this;
      }

      @JsonProperty("reportGrossWeight")
      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder reportGrossWeight(final BigDecimal reportGrossWeight) {
         this.reportGrossWeight = reportGrossWeight;
         return this;
      }

      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder reporterId(final Long reporterId) {
         this.reporterId = reporterId;
         return this;
      }

      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder reportingDate(final String reportingDate) {
         this.reportingDate = reportingDate;
         return this;
      }

      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder reporterName(final String reporterName) {
         this.reporterName = reporterName;
         return this;
      }

      public ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder structureTypeName(final String structureTypeName) {
         this.structureTypeName = structureTypeName;
         return this;
      }

      public ProductTeamSummaryDetailDTO build() {
         return new ProductTeamSummaryDetailDTO(
            this.workshop,
            this.project,
            this.monomer,
            this.area,
            this.areaBatch,
            this.process,
            this.teamUser,
            this.id,
            this.name,
            this.serialNumber,
            this.specification,
            this.reportUserName,
            this.material,
            this.length,
            this.grossWeight,
            this.netWeight,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.quantity,
            this.reportQuantity,
            this.reportNetWeight,
            this.reportGrossWeight,
            this.reporterId,
            this.reportingDate,
            this.reporterName,
            this.structureTypeName
         );
      }

      @Override
      public String toString() {
         return "ProductTeamSummaryDetailDTO.ProductTeamSummaryDetailDTOBuilder(workshop="
            + this.workshop
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", areaBatch="
            + this.areaBatch
            + ", process="
            + this.process
            + ", teamUser="
            + this.teamUser
            + ", id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", reportUserName="
            + this.reportUserName
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", grossWeight="
            + this.grossWeight
            + ", netWeight="
            + this.netWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", quantity="
            + this.quantity
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportNetWeight="
            + this.reportNetWeight
            + ", reportGrossWeight="
            + this.reportGrossWeight
            + ", reporterId="
            + this.reporterId
            + ", reportingDate="
            + this.reportingDate
            + ", reporterName="
            + this.reporterName
            + ", structureTypeName="
            + this.structureTypeName
            + ")";
      }
   }
}
