package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import cn.hutool.core.bean.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("报工未审核DTO")
public class MesReportWorkUnapprovedDTO {
   @ApiModelProperty("产品类型")
   private Integer productTypeEnum;
   @ApiModelProperty("班组生产上报记录ID")
   private Long produceTeamReportId;
   @ApiModelProperty("报工日期")
   private LocalDateTime reportTime;
   @ApiModelProperty("报工日期最小")
   private LocalDateTime minReportTime;
   @ApiModelProperty("报工日期最大")
   private LocalDateTime maxReportTime;
   @ApiModelProperty("报工计数")
   private Integer reportCount;
   @ApiModelProperty("质检通过数量")
   private BigDecimal inspectionQuantity;
   @ApiModelProperty("车间信息")
   private NameInfo workshop;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("单体信息")
   private NameInfo monomer;
   @ApiModelProperty("班组信息")
   private NameInfo team;
   @ApiModelProperty("工序信息")
   private NameInfo process;
   @ApiModelProperty("工序类型")
   private Integer processType;
   @ApiModelProperty("产品信息")
   private ProductInfo product;
   @ApiModelProperty("质检日期")
   private LocalDateTime inspectionDate;
   @ApiModelProperty("质检人")
   private NameInfo inspector;
   @ApiModelProperty("单位")
   private String unit;
   @ApiModelProperty("核算量")
   private BigDecimal accountingQuantity;
   @ApiModelProperty("定额配置ID")
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   private String quotaConfigNumber;
   @ApiModelProperty("定义类型")
   private String defineType;
   @ApiModelProperty("计算方式")
   private Integer calculationWay;
   @ApiModelProperty("单价(元)")
   private BigDecimal price;
   @ApiModelProperty("总价(元)")
   private BigDecimal totalPrice;
   @ApiModelProperty("总重(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty("任务工单id")
   private Long taskOrderId;
   @ApiModelProperty("任务工单号")
   private String taskOrderNumber;
   @ApiModelProperty("是否是套料任务")
   private Boolean nestTask;
   @ApiModelProperty("子列表")
   private List<MesReportWorkUnapprovedDTO> subList;
   @ApiModelProperty("车间ID")
   private Long workshopId;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("班组ID")
   private Long teamId;
   @ApiModelProperty("产品ID")
   private Long productId;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;
   @ApiModelProperty("构件产品序列号集合")
   private List<Integer> drawingNumbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

   public BigDecimal getTotalWeight() {
      return this.totalWeight == null && this.inspectionQuantity != null && BeanUtil.isNotEmpty(this.product) && this.product.getNetWeight() != null
         ? this.product.getNetWeight().multiply(this.inspectionQuantity)
         : this.totalWeight;
   }

   public Long getWorkshopId() {
      return this.workshopId == null ? this.workshop.getId() : this.workshopId;
   }

   public Long getProjectId() {
      return this.projectId == null ? this.project.getId() : this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId == null ? this.monomer.getId() : this.monomerId;
   }

   public Long getProcessId() {
      return this.processId == null ? this.process.getId() : this.processId;
   }

   public Long getTeamId() {
      return this.teamId == null ? this.team.getId() : this.teamId;
   }

   public Long getProductId() {
      return this.productId == null ? this.product.getId() : this.productId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber == null ? this.product.getSerialNumber() : this.productSerialNumber;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getProduceTeamReportId() {
      return this.produceTeamReportId;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public LocalDateTime getMinReportTime() {
      return this.minReportTime;
   }

   public LocalDateTime getMaxReportTime() {
      return this.maxReportTime;
   }

   public Integer getReportCount() {
      return this.reportCount;
   }

   public BigDecimal getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getTeam() {
      return this.team;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public Integer getProcessType() {
      return this.processType;
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

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getAccountingQuantity() {
      return this.accountingQuantity;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigNumber() {
      return this.quotaConfigNumber;
   }

   public String getDefineType() {
      return this.defineType;
   }

   public Integer getCalculationWay() {
      return this.calculationWay;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public Boolean getNestTask() {
      return this.nestTask;
   }

   public List<MesReportWorkUnapprovedDTO> getSubList() {
      return this.subList;
   }

   public List<Integer> getDrawingNumbers() {
      return this.drawingNumbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProduceTeamReportId(final Long produceTeamReportId) {
      this.produceTeamReportId = produceTeamReportId;
   }

   public void setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
   }

   public void setMinReportTime(final LocalDateTime minReportTime) {
      this.minReportTime = minReportTime;
   }

   public void setMaxReportTime(final LocalDateTime maxReportTime) {
      this.maxReportTime = maxReportTime;
   }

   public void setReportCount(final Integer reportCount) {
      this.reportCount = reportCount;
   }

   public void setInspectionQuantity(final BigDecimal inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   public void setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setTeam(final NameInfo team) {
      this.team = team;
   }

   public void setProcess(final NameInfo process) {
      this.process = process;
   }

   public void setProcessType(final Integer processType) {
      this.processType = processType;
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

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setAccountingQuantity(final BigDecimal accountingQuantity) {
      this.accountingQuantity = accountingQuantity;
   }

   public void setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
   }

   public void setQuotaConfigNumber(final String quotaConfigNumber) {
      this.quotaConfigNumber = quotaConfigNumber;
   }

   public void setDefineType(final String defineType) {
      this.defineType = defineType;
   }

   public void setCalculationWay(final Integer calculationWay) {
      this.calculationWay = calculationWay;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setNestTask(final Boolean nestTask) {
      this.nestTask = nestTask;
   }

   public void setSubList(final List<MesReportWorkUnapprovedDTO> subList) {
      this.subList = subList;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setDrawingNumbers(final List<Integer> drawingNumbers) {
      this.drawingNumbers = drawingNumbers;
   }

   public void setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesReportWorkUnapprovedDTO)) {
         return false;
      }

      MesReportWorkUnapprovedDTO other = (MesReportWorkUnapprovedDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productTypeEnum = this.getProductTypeEnum();
      Object other$productTypeEnum = other.getProductTypeEnum();
      if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
         Object this$produceTeamReportId = this.getProduceTeamReportId();
         Object other$produceTeamReportId = other.getProduceTeamReportId();
         if (this$produceTeamReportId == null ? other$produceTeamReportId == null : this$produceTeamReportId.equals(other$produceTeamReportId)) {
            Object this$reportCount = this.getReportCount();
            Object other$reportCount = other.getReportCount();
            if (this$reportCount == null ? other$reportCount == null : this$reportCount.equals(other$reportCount)) {
               Object this$processType = this.getProcessType();
               Object other$processType = other.getProcessType();
               if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                  Object this$quotaConfigId = this.getQuotaConfigId();
                  Object other$quotaConfigId = other.getQuotaConfigId();
                  if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
                     Object this$calculationWay = this.getCalculationWay();
                     Object other$calculationWay = other.getCalculationWay();
                     if (this$calculationWay == null ? other$calculationWay == null : this$calculationWay.equals(other$calculationWay)) {
                        Object this$taskOrderId = this.getTaskOrderId();
                        Object other$taskOrderId = other.getTaskOrderId();
                        if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                           Object this$nestTask = this.getNestTask();
                           Object other$nestTask = other.getNestTask();
                           if (this$nestTask == null ? other$nestTask == null : this$nestTask.equals(other$nestTask)) {
                              Object this$workshopId = this.getWorkshopId();
                              Object other$workshopId = other.getWorkshopId();
                              if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                 Object this$projectId = this.getProjectId();
                                 Object other$projectId = other.getProjectId();
                                 if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                    Object this$monomerId = this.getMonomerId();
                                    Object other$monomerId = other.getMonomerId();
                                    if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                       Object this$processId = this.getProcessId();
                                       Object other$processId = other.getProcessId();
                                       if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                          Object this$teamId = this.getTeamId();
                                          Object other$teamId = other.getTeamId();
                                          if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                             Object this$productId = this.getProductId();
                                             Object other$productId = other.getProductId();
                                             if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                                Object this$reportTime = this.getReportTime();
                                                Object other$reportTime = other.getReportTime();
                                                if (this$reportTime == null ? other$reportTime == null : this$reportTime.equals(other$reportTime)) {
                                                   Object this$minReportTime = this.getMinReportTime();
                                                   Object other$minReportTime = other.getMinReportTime();
                                                   if (this$minReportTime == null
                                                      ? other$minReportTime == null
                                                      : this$minReportTime.equals(other$minReportTime)) {
                                                      Object this$maxReportTime = this.getMaxReportTime();
                                                      Object other$maxReportTime = other.getMaxReportTime();
                                                      if (this$maxReportTime == null
                                                         ? other$maxReportTime == null
                                                         : this$maxReportTime.equals(other$maxReportTime)) {
                                                         Object this$inspectionQuantity = this.getInspectionQuantity();
                                                         Object other$inspectionQuantity = other.getInspectionQuantity();
                                                         if (this$inspectionQuantity == null
                                                            ? other$inspectionQuantity == null
                                                            : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                                                            Object this$workshop = this.getWorkshop();
                                                            Object other$workshop = other.getWorkshop();
                                                            if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                               Object this$project = this.getProject();
                                                               Object other$project = other.getProject();
                                                               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                  Object this$monomer = this.getMonomer();
                                                                  Object other$monomer = other.getMonomer();
                                                                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                                     Object this$team = this.getTeam();
                                                                     Object other$team = other.getTeam();
                                                                     if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                                                        Object this$process = this.getProcess();
                                                                        Object other$process = other.getProcess();
                                                                        if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                                           Object this$product = this.getProduct();
                                                                           Object other$product = other.getProduct();
                                                                           if (this$product == null
                                                                              ? other$product == null
                                                                              : this$product.equals(other$product)) {
                                                                              Object this$inspectionDate = this.getInspectionDate();
                                                                              Object other$inspectionDate = other.getInspectionDate();
                                                                              if (this$inspectionDate == null
                                                                                 ? other$inspectionDate == null
                                                                                 : this$inspectionDate.equals(other$inspectionDate)) {
                                                                                 Object this$inspector = this.getInspector();
                                                                                 Object other$inspector = other.getInspector();
                                                                                 if (this$inspector == null
                                                                                    ? other$inspector == null
                                                                                    : this$inspector.equals(other$inspector)) {
                                                                                    Object this$unit = this.getUnit();
                                                                                    Object other$unit = other.getUnit();
                                                                                    if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                                                       Object this$accountingQuantity = this.getAccountingQuantity();
                                                                                       Object other$accountingQuantity = other.getAccountingQuantity();
                                                                                       if (this$accountingQuantity == null
                                                                                          ? other$accountingQuantity == null
                                                                                          : this$accountingQuantity.equals(other$accountingQuantity)) {
                                                                                          Object this$quotaConfigNumber = this.getQuotaConfigNumber();
                                                                                          Object other$quotaConfigNumber = other.getQuotaConfigNumber();
                                                                                          if (this$quotaConfigNumber == null
                                                                                             ? other$quotaConfigNumber == null
                                                                                             : this$quotaConfigNumber.equals(other$quotaConfigNumber)) {
                                                                                             Object this$defineType = this.getDefineType();
                                                                                             Object other$defineType = other.getDefineType();
                                                                                             if (this$defineType == null
                                                                                                ? other$defineType == null
                                                                                                : this$defineType.equals(other$defineType)) {
                                                                                                Object this$price = this.getPrice();
                                                                                                Object other$price = other.getPrice();
                                                                                                if (this$price == null
                                                                                                   ? other$price == null
                                                                                                   : this$price.equals(other$price)) {
                                                                                                   Object this$totalPrice = this.getTotalPrice();
                                                                                                   Object other$totalPrice = other.getTotalPrice();
                                                                                                   if (this$totalPrice == null
                                                                                                      ? other$totalPrice == null
                                                                                                      : this$totalPrice.equals(other$totalPrice)) {
                                                                                                      Object this$totalWeight = this.getTotalWeight();
                                                                                                      Object other$totalWeight = other.getTotalWeight();
                                                                                                      if (this$totalWeight == null
                                                                                                         ? other$totalWeight == null
                                                                                                         : this$totalWeight.equals(other$totalWeight)) {
                                                                                                         Object this$taskOrderNumber = this.getTaskOrderNumber();
                                                                                                         Object other$taskOrderNumber = other.getTaskOrderNumber();
                                                                                                         if (this$taskOrderNumber == null
                                                                                                            ? other$taskOrderNumber == null
                                                                                                            : this$taskOrderNumber.equals(other$taskOrderNumber)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$subList = this.getSubList();
                                                                                                            Object other$subList = other.getSubList();
                                                                                                            if (this$subList == null
                                                                                                               ? other$subList == null
                                                                                                               : this$subList.equals(other$subList)) {
                                                                                                               Object this$productSerialNumber = this.getProductSerialNumber();
                                                                                                               Object other$productSerialNumber = other.getProductSerialNumber();
                                                                                                               if (this$productSerialNumber == null
                                                                                                                  ? other$productSerialNumber == null
                                                                                                                  : this$productSerialNumber.equals(
                                                                                                                     other$productSerialNumber
                                                                                                                  )) {
                                                                                                                  Object this$drawingNumbers = this.getDrawingNumbers();
                                                                                                                  Object other$drawingNumbers = other.getDrawingNumbers();
                                                                                                                  if (this$drawingNumbers == null
                                                                                                                     ? other$drawingNumbers == null
                                                                                                                     : this$drawingNumbers.equals(
                                                                                                                        other$drawingNumbers
                                                                                                                     )) {
                                                                                                                     Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                                                                                     Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                                                                                     return this$drawingAndSerialNumber == null
                                                                                                                        ? other$drawingAndSerialNumber == null
                                                                                                                        : this$drawingAndSerialNumber.equals(
                                                                                                                           other$drawingAndSerialNumber
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesReportWorkUnapprovedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $produceTeamReportId = this.getProduceTeamReportId();
      result = result * 59 + ($produceTeamReportId == null ? 43 : $produceTeamReportId.hashCode());
      Object $reportCount = this.getReportCount();
      result = result * 59 + ($reportCount == null ? 43 : $reportCount.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $calculationWay = this.getCalculationWay();
      result = result * 59 + ($calculationWay == null ? 43 : $calculationWay.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $nestTask = this.getNestTask();
      result = result * 59 + ($nestTask == null ? 43 : $nestTask.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $minReportTime = this.getMinReportTime();
      result = result * 59 + ($minReportTime == null ? 43 : $minReportTime.hashCode());
      Object $maxReportTime = this.getMaxReportTime();
      result = result * 59 + ($maxReportTime == null ? 43 : $maxReportTime.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
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
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $accountingQuantity = this.getAccountingQuantity();
      result = result * 59 + ($accountingQuantity == null ? 43 : $accountingQuantity.hashCode());
      Object $quotaConfigNumber = this.getQuotaConfigNumber();
      result = result * 59 + ($quotaConfigNumber == null ? 43 : $quotaConfigNumber.hashCode());
      Object $defineType = this.getDefineType();
      result = result * 59 + ($defineType == null ? 43 : $defineType.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $subList = this.getSubList();
      result = result * 59 + ($subList == null ? 43 : $subList.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $drawingNumbers = this.getDrawingNumbers();
      result = result * 59 + ($drawingNumbers == null ? 43 : $drawingNumbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      return result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesReportWorkUnapprovedDTO(productTypeEnum="
         + this.getProductTypeEnum()
         + ", produceTeamReportId="
         + this.getProduceTeamReportId()
         + ", reportTime="
         + this.getReportTime()
         + ", minReportTime="
         + this.getMinReportTime()
         + ", maxReportTime="
         + this.getMaxReportTime()
         + ", reportCount="
         + this.getReportCount()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", workshop="
         + this.getWorkshop()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", team="
         + this.getTeam()
         + ", process="
         + this.getProcess()
         + ", processType="
         + this.getProcessType()
         + ", product="
         + this.getProduct()
         + ", inspectionDate="
         + this.getInspectionDate()
         + ", inspector="
         + this.getInspector()
         + ", unit="
         + this.getUnit()
         + ", accountingQuantity="
         + this.getAccountingQuantity()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigNumber="
         + this.getQuotaConfigNumber()
         + ", defineType="
         + this.getDefineType()
         + ", calculationWay="
         + this.getCalculationWay()
         + ", price="
         + this.getPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", nestTask="
         + this.getNestTask()
         + ", subList="
         + this.getSubList()
         + ", workshopId="
         + this.getWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", productId="
         + this.getProductId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", drawingNumbers="
         + this.getDrawingNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ")";
   }
}
