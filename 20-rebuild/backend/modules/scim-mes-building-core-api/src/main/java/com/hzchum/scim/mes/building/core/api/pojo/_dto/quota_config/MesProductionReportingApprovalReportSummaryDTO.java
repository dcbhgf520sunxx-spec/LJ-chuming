package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("报工审核上报汇总信息DTO")
public class MesProductionReportingApprovalReportSummaryDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("班组生产上报记录ids")
   private String produceTeamReportIds;
   @ApiModelProperty("机构id")
   private Long branchCompanyId;
   @ApiModelProperty("项目")
   private ShowInfo project;
   @ApiModelProperty("单体")
   private ShowInfo monomer;
   @ApiModelProperty("区域")
   private ShowInfo area;
   @ApiModelProperty("批次")
   private ShowInfo areaBatch;
   @ApiModelProperty("产品")
   private ProductInfo product;
   @ApiModelProperty("车间")
   private ShowInfo workshop;
   @ApiModelProperty("班组")
   private ShowInfo team;
   @ApiModelProperty("工序")
   private ShowInfo process;
   @ApiModelProperty("上报数量")
   private BigDecimal reportQuantity;
   @ApiModelProperty("上报重量(kg)")
   private BigDecimal reportWeight;
   @ApiModelProperty("上报日期")
   private LocalDate reportDate;
   @ApiModelProperty("计量单位")
   private String measureUnit;
   @ApiModelProperty("计量量")
   private BigDecimal measurementQuantity;
   @ApiModelProperty("单价(元)")
   private BigDecimal price;
   @ApiModelProperty("金额(元)")
   private BigDecimal amount;
   @ApiModelProperty("定额配置id")
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   private String quotaConfigSerialNumber;
   @ApiModelProperty("定额匹配条件")
   private String quotaMatchingCondition;
   @ApiModelProperty("字典")
   private DictionaryInfo dict;
   @ApiModelProperty("多个产品编号")
   private String productSerialNumbers;
   @ApiModelProperty("审核人")
   private ShowInfo approver;
   @ApiModelProperty(name = "numbers", value = "产品序列号")
   private List<Integer> numbers;
   @ApiModelProperty("图纸产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;
   @ApiModelProperty("上报人")
   private ShowInfo reportPerson;
   @ApiModelProperty("打孔数")
   private BigDecimal perforateQuantity;
   @ApiModelProperty("漆膜厚度(μm)")
   private BigDecimal paintFilmThickness;

   public Long getId() {
      return this.id;
   }

   public String getProduceTeamReportIds() {
      return this.produceTeamReportIds;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public ShowInfo getProject() {
      return this.project;
   }

   public ShowInfo getMonomer() {
      return this.monomer;
   }

   public ShowInfo getArea() {
      return this.area;
   }

   public ShowInfo getAreaBatch() {
      return this.areaBatch;
   }

   public ProductInfo getProduct() {
      return this.product;
   }

   public ShowInfo getWorkshop() {
      return this.workshop;
   }

   public ShowInfo getTeam() {
      return this.team;
   }

   public ShowInfo getProcess() {
      return this.process;
   }

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportWeight() {
      return this.reportWeight;
   }

   public LocalDate getReportDate() {
      return this.reportDate;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMeasurementQuantity() {
      return this.measurementQuantity;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigSerialNumber() {
      return this.quotaConfigSerialNumber;
   }

   public String getQuotaMatchingCondition() {
      return this.quotaMatchingCondition;
   }

   public DictionaryInfo getDict() {
      return this.dict;
   }

   public String getProductSerialNumbers() {
      return this.productSerialNumbers;
   }

   public ShowInfo getApprover() {
      return this.approver;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public ShowInfo getReportPerson() {
      return this.reportPerson;
   }

   public BigDecimal getPerforateQuantity() {
      return this.perforateQuantity;
   }

   public BigDecimal getPaintFilmThickness() {
      return this.paintFilmThickness;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProduceTeamReportIds(final String produceTeamReportIds) {
      this.produceTeamReportIds = produceTeamReportIds;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setProject(final ShowInfo project) {
      this.project = project;
   }

   public void setMonomer(final ShowInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final ShowInfo area) {
      this.area = area;
   }

   public void setAreaBatch(final ShowInfo areaBatch) {
      this.areaBatch = areaBatch;
   }

   public void setProduct(final ProductInfo product) {
      this.product = product;
   }

   public void setWorkshop(final ShowInfo workshop) {
      this.workshop = workshop;
   }

   public void setTeam(final ShowInfo team) {
      this.team = team;
   }

   public void setProcess(final ShowInfo process) {
      this.process = process;
   }

   public void setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
   }

   public void setReportWeight(final BigDecimal reportWeight) {
      this.reportWeight = reportWeight;
   }

   public void setReportDate(final LocalDate reportDate) {
      this.reportDate = reportDate;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
   }

   public void setQuotaConfigSerialNumber(final String quotaConfigSerialNumber) {
      this.quotaConfigSerialNumber = quotaConfigSerialNumber;
   }

   public void setQuotaMatchingCondition(final String quotaMatchingCondition) {
      this.quotaMatchingCondition = quotaMatchingCondition;
   }

   public void setDict(final DictionaryInfo dict) {
      this.dict = dict;
   }

   public void setProductSerialNumbers(final String productSerialNumbers) {
      this.productSerialNumbers = productSerialNumbers;
   }

   public void setApprover(final ShowInfo approver) {
      this.approver = approver;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   public void setReportPerson(final ShowInfo reportPerson) {
      this.reportPerson = reportPerson;
   }

   public void setPerforateQuantity(final BigDecimal perforateQuantity) {
      this.perforateQuantity = perforateQuantity;
   }

   public void setPaintFilmThickness(final BigDecimal paintFilmThickness) {
      this.paintFilmThickness = paintFilmThickness;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalReportSummaryDTO)) {
         return false;
      }

      MesProductionReportingApprovalReportSummaryDTO other = (MesProductionReportingApprovalReportSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$quotaConfigId = this.getQuotaConfigId();
            Object other$quotaConfigId = other.getQuotaConfigId();
            if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
               Object this$produceTeamReportIds = this.getProduceTeamReportIds();
               Object other$produceTeamReportIds = other.getProduceTeamReportIds();
               if (this$produceTeamReportIds == null ? other$produceTeamReportIds == null : this$produceTeamReportIds.equals(other$produceTeamReportIds)) {
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
                              Object this$product = this.getProduct();
                              Object other$product = other.getProduct();
                              if (this$product == null ? other$product == null : this$product.equals(other$product)) {
                                 Object this$workshop = this.getWorkshop();
                                 Object other$workshop = other.getWorkshop();
                                 if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                    Object this$team = this.getTeam();
                                    Object other$team = other.getTeam();
                                    if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                       Object this$process = this.getProcess();
                                       Object other$process = other.getProcess();
                                       if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                          Object this$reportQuantity = this.getReportQuantity();
                                          Object other$reportQuantity = other.getReportQuantity();
                                          if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
                                             Object this$reportWeight = this.getReportWeight();
                                             Object other$reportWeight = other.getReportWeight();
                                             if (this$reportWeight == null ? other$reportWeight == null : this$reportWeight.equals(other$reportWeight)) {
                                                Object this$reportDate = this.getReportDate();
                                                Object other$reportDate = other.getReportDate();
                                                if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                                                   Object this$measureUnit = this.getMeasureUnit();
                                                   Object other$measureUnit = other.getMeasureUnit();
                                                   if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                      Object this$measurementQuantity = this.getMeasurementQuantity();
                                                      Object other$measurementQuantity = other.getMeasurementQuantity();
                                                      if (this$measurementQuantity == null
                                                         ? other$measurementQuantity == null
                                                         : this$measurementQuantity.equals(other$measurementQuantity)) {
                                                         Object this$price = this.getPrice();
                                                         Object other$price = other.getPrice();
                                                         if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                            Object this$amount = this.getAmount();
                                                            Object other$amount = other.getAmount();
                                                            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                               Object this$quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
                                                               Object other$quotaConfigSerialNumber = other.getQuotaConfigSerialNumber();
                                                               if (this$quotaConfigSerialNumber == null
                                                                  ? other$quotaConfigSerialNumber == null
                                                                  : this$quotaConfigSerialNumber.equals(other$quotaConfigSerialNumber)) {
                                                                  Object this$quotaMatchingCondition = this.getQuotaMatchingCondition();
                                                                  Object other$quotaMatchingCondition = other.getQuotaMatchingCondition();
                                                                  if (this$quotaMatchingCondition == null
                                                                     ? other$quotaMatchingCondition == null
                                                                     : this$quotaMatchingCondition.equals(other$quotaMatchingCondition)) {
                                                                     Object this$dict = this.getDict();
                                                                     Object other$dict = other.getDict();
                                                                     if (this$dict == null ? other$dict == null : this$dict.equals(other$dict)) {
                                                                        Object this$productSerialNumbers = this.getProductSerialNumbers();
                                                                        Object other$productSerialNumbers = other.getProductSerialNumbers();
                                                                        if (this$productSerialNumbers == null
                                                                           ? other$productSerialNumbers == null
                                                                           : this$productSerialNumbers.equals(other$productSerialNumbers)) {
                                                                           Object this$approver = this.getApprover();
                                                                           Object other$approver = other.getApprover();
                                                                           if (this$approver == null
                                                                              ? other$approver == null
                                                                              : this$approver.equals(other$approver)) {
                                                                              Object this$numbers = this.getNumbers();
                                                                              Object other$numbers = other.getNumbers();
                                                                              if (this$numbers == null
                                                                                 ? other$numbers == null
                                                                                 : this$numbers.equals(other$numbers)) {
                                                                                 Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                                                 Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                                                 if (this$drawingAndSerialNumber == null
                                                                                    ? other$drawingAndSerialNumber == null
                                                                                    : this$drawingAndSerialNumber.equals(other$drawingAndSerialNumber)) {
                                                                                    Object this$reportPerson = this.getReportPerson();
                                                                                    Object other$reportPerson = other.getReportPerson();
                                                                                    if (this$reportPerson == null
                                                                                       ? other$reportPerson == null
                                                                                       : this$reportPerson.equals(other$reportPerson)) {
                                                                                       Object this$perforateQuantity = this.getPerforateQuantity();
                                                                                       Object other$perforateQuantity = other.getPerforateQuantity();
                                                                                       if (this$perforateQuantity == null
                                                                                          ? other$perforateQuantity == null
                                                                                          : this$perforateQuantity.equals(other$perforateQuantity)) {
                                                                                          Object this$paintFilmThickness = this.getPaintFilmThickness();
                                                                                          Object other$paintFilmThickness = other.getPaintFilmThickness();
                                                                                          return this$paintFilmThickness == null
                                                                                             ? other$paintFilmThickness == null
                                                                                             : this$paintFilmThickness.equals(other$paintFilmThickness);
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
      return other instanceof MesProductionReportingApprovalReportSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $produceTeamReportIds = this.getProduceTeamReportIds();
      result = result * 59 + ($produceTeamReportIds == null ? 43 : $produceTeamReportIds.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $product = this.getProduct();
      result = result * 59 + ($product == null ? 43 : $product.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reportWeight = this.getReportWeight();
      result = result * 59 + ($reportWeight == null ? 43 : $reportWeight.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
      result = result * 59 + ($quotaConfigSerialNumber == null ? 43 : $quotaConfigSerialNumber.hashCode());
      Object $quotaMatchingCondition = this.getQuotaMatchingCondition();
      result = result * 59 + ($quotaMatchingCondition == null ? 43 : $quotaMatchingCondition.hashCode());
      Object $dict = this.getDict();
      result = result * 59 + ($dict == null ? 43 : $dict.hashCode());
      Object $productSerialNumbers = this.getProductSerialNumbers();
      result = result * 59 + ($productSerialNumbers == null ? 43 : $productSerialNumbers.hashCode());
      Object $approver = this.getApprover();
      result = result * 59 + ($approver == null ? 43 : $approver.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      result = result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
      Object $reportPerson = this.getReportPerson();
      result = result * 59 + ($reportPerson == null ? 43 : $reportPerson.hashCode());
      Object $perforateQuantity = this.getPerforateQuantity();
      result = result * 59 + ($perforateQuantity == null ? 43 : $perforateQuantity.hashCode());
      Object $paintFilmThickness = this.getPaintFilmThickness();
      return result * 59 + ($paintFilmThickness == null ? 43 : $paintFilmThickness.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalReportSummaryDTO(id="
         + this.getId()
         + ", produceTeamReportIds="
         + this.getProduceTeamReportIds()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", product="
         + this.getProduct()
         + ", workshop="
         + this.getWorkshop()
         + ", team="
         + this.getTeam()
         + ", process="
         + this.getProcess()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportWeight="
         + this.getReportWeight()
         + ", reportDate="
         + this.getReportDate()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurementQuantity="
         + this.getMeasurementQuantity()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigSerialNumber="
         + this.getQuotaConfigSerialNumber()
         + ", quotaMatchingCondition="
         + this.getQuotaMatchingCondition()
         + ", dict="
         + this.getDict()
         + ", productSerialNumbers="
         + this.getProductSerialNumbers()
         + ", approver="
         + this.getApprover()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ", reportPerson="
         + this.getReportPerson()
         + ", perforateQuantity="
         + this.getPerforateQuantity()
         + ", paintFilmThickness="
         + this.getPaintFilmThickness()
         + ")";
   }
}
