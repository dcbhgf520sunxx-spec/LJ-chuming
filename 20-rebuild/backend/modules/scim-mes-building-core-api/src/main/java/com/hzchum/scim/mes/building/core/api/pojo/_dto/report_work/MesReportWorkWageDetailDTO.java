package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("报工审批工价组成明细DTO")
public class MesReportWorkWageDetailDTO {
   @ApiModelProperty("班组生产上报记录ID")
   private Long produceTeamReportId;
   @ApiModelProperty("报工日期")
   private LocalDateTime reportTime;
   @ApiModelProperty("质检通过数量")
   private BigDecimal inspectionQuantity;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("班组信息")
   private NameInfo team;
   @ApiModelProperty("工序信息")
   private NameInfo process;
   @ApiModelProperty("产品信息")
   private ProductInfo product;
   @ApiModelProperty("质检日期")
   private LocalDateTime inspectionDate;
   @ApiModelProperty("质检人")
   private NameInfo inspector;
   @ApiModelProperty("定额配置ID")
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   private String quotaConfigNumber;
   @ApiModelProperty("计算方式")
   private Integer calculationWay;
   @ApiModelProperty("定义类型")
   private String defineType;
   @ApiModelProperty("单价(元)")
   private BigDecimal price;
   @ApiModelProperty("核算量")
   private BigDecimal accountingQuantity;
   @ApiModelProperty("总价(元)")
   private BigDecimal totalPrice;

   public Long getProduceTeamReportId() {
      return this.produceTeamReportId;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public BigDecimal getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getTeam() {
      return this.team;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public ProductInfo getProduct() {
      return this.product;
   }

   public LocalDateTime getInspectionDate() {
      return this.inspectionDate;
   }

   public NameInfo getInspector() {
      return this.inspector;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigNumber() {
      return this.quotaConfigNumber;
   }

   public Integer getCalculationWay() {
      return this.calculationWay;
   }

   public String getDefineType() {
      return this.defineType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAccountingQuantity() {
      return this.accountingQuantity;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public void setProduceTeamReportId(final Long produceTeamReportId) {
      this.produceTeamReportId = produceTeamReportId;
   }

   public void setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
   }

   public void setInspectionQuantity(final BigDecimal inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setTeam(final NameInfo team) {
      this.team = team;
   }

   public void setProcess(final NameInfo process) {
      this.process = process;
   }

   public void setProduct(final ProductInfo product) {
      this.product = product;
   }

   public void setInspectionDate(final LocalDateTime inspectionDate) {
      this.inspectionDate = inspectionDate;
   }

   public void setInspector(final NameInfo inspector) {
      this.inspector = inspector;
   }

   public void setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
   }

   public void setQuotaConfigNumber(final String quotaConfigNumber) {
      this.quotaConfigNumber = quotaConfigNumber;
   }

   public void setCalculationWay(final Integer calculationWay) {
      this.calculationWay = calculationWay;
   }

   public void setDefineType(final String defineType) {
      this.defineType = defineType;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAccountingQuantity(final BigDecimal accountingQuantity) {
      this.accountingQuantity = accountingQuantity;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesReportWorkWageDetailDTO)) {
         return false;
      }

      MesReportWorkWageDetailDTO other = (MesReportWorkWageDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$produceTeamReportId = this.getProduceTeamReportId();
      Object other$produceTeamReportId = other.getProduceTeamReportId();
      if (this$produceTeamReportId == null ? other$produceTeamReportId == null : this$produceTeamReportId.equals(other$produceTeamReportId)) {
         Object this$quotaConfigId = this.getQuotaConfigId();
         Object other$quotaConfigId = other.getQuotaConfigId();
         if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
            Object this$calculationWay = this.getCalculationWay();
            Object other$calculationWay = other.getCalculationWay();
            if (this$calculationWay == null ? other$calculationWay == null : this$calculationWay.equals(other$calculationWay)) {
               Object this$reportTime = this.getReportTime();
               Object other$reportTime = other.getReportTime();
               if (this$reportTime == null ? other$reportTime == null : this$reportTime.equals(other$reportTime)) {
                  Object this$inspectionQuantity = this.getInspectionQuantity();
                  Object other$inspectionQuantity = other.getInspectionQuantity();
                  if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$team = this.getTeam();
                        Object other$team = other.getTeam();
                        if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                           Object this$process = this.getProcess();
                           Object other$process = other.getProcess();
                           if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                              Object this$product = this.getProduct();
                              Object other$product = other.getProduct();
                              if (this$product == null ? other$product == null : this$product.equals(other$product)) {
                                 Object this$inspectionDate = this.getInspectionDate();
                                 Object other$inspectionDate = other.getInspectionDate();
                                 if (this$inspectionDate == null ? other$inspectionDate == null : this$inspectionDate.equals(other$inspectionDate)) {
                                    Object this$inspector = this.getInspector();
                                    Object other$inspector = other.getInspector();
                                    if (this$inspector == null ? other$inspector == null : this$inspector.equals(other$inspector)) {
                                       Object this$quotaConfigNumber = this.getQuotaConfigNumber();
                                       Object other$quotaConfigNumber = other.getQuotaConfigNumber();
                                       if (this$quotaConfigNumber == null
                                          ? other$quotaConfigNumber == null
                                          : this$quotaConfigNumber.equals(other$quotaConfigNumber)) {
                                          Object this$defineType = this.getDefineType();
                                          Object other$defineType = other.getDefineType();
                                          if (this$defineType == null ? other$defineType == null : this$defineType.equals(other$defineType)) {
                                             Object this$price = this.getPrice();
                                             Object other$price = other.getPrice();
                                             if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                Object this$accountingQuantity = this.getAccountingQuantity();
                                                Object other$accountingQuantity = other.getAccountingQuantity();
                                                if (this$accountingQuantity == null
                                                   ? other$accountingQuantity == null
                                                   : this$accountingQuantity.equals(other$accountingQuantity)) {
                                                   Object this$totalPrice = this.getTotalPrice();
                                                   Object other$totalPrice = other.getTotalPrice();
                                                   return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
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
      return other instanceof MesReportWorkWageDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $produceTeamReportId = this.getProduceTeamReportId();
      result = result * 59 + ($produceTeamReportId == null ? 43 : $produceTeamReportId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $calculationWay = this.getCalculationWay();
      result = result * 59 + ($calculationWay == null ? 43 : $calculationWay.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $product = this.getProduct();
      result = result * 59 + ($product == null ? 43 : $product.hashCode());
      Object $inspectionDate = this.getInspectionDate();
      result = result * 59 + ($inspectionDate == null ? 43 : $inspectionDate.hashCode());
      Object $inspector = this.getInspector();
      result = result * 59 + ($inspector == null ? 43 : $inspector.hashCode());
      Object $quotaConfigNumber = this.getQuotaConfigNumber();
      result = result * 59 + ($quotaConfigNumber == null ? 43 : $quotaConfigNumber.hashCode());
      Object $defineType = this.getDefineType();
      result = result * 59 + ($defineType == null ? 43 : $defineType.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $accountingQuantity = this.getAccountingQuantity();
      result = result * 59 + ($accountingQuantity == null ? 43 : $accountingQuantity.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "MesReportWorkWageDetailDTO(produceTeamReportId="
         + this.getProduceTeamReportId()
         + ", reportTime="
         + this.getReportTime()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", project="
         + this.getProject()
         + ", team="
         + this.getTeam()
         + ", process="
         + this.getProcess()
         + ", product="
         + this.getProduct()
         + ", inspectionDate="
         + this.getInspectionDate()
         + ", inspector="
         + this.getInspector()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigNumber="
         + this.getQuotaConfigNumber()
         + ", calculationWay="
         + this.getCalculationWay()
         + ", defineType="
         + this.getDefineType()
         + ", price="
         + this.getPrice()
         + ", accountingQuantity="
         + this.getAccountingQuantity()
         + ", totalPrice="
         + this.getTotalPrice()
         + ")";
   }
}
