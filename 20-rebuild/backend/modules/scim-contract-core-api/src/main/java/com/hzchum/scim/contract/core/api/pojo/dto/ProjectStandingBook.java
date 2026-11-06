package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel("项目列表返回类")
public class ProjectStandingBook {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "status", value = "项目状态 0：进行中，1：暂停，2：已完工")
   private Integer status;
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty("合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(notes = "项目内容id字符串")
   private String projectContent;
   @ApiModelProperty(notes = "签订日期")
   private LocalDate signingDate;
   @ApiModelProperty(notes = "签约人id")
   private Long signerId;
   @ApiModelProperty(notes = "签约人姓名")
   private String signerName;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁 4围护")
   private Integer projectType;
   @ApiModelProperty(name = "businessType", value = "业务类型 1加工承揽 2项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "orderSourceType", notes = "项目订单来源类型 1内部 2外部")
   private Integer orderSourceType;
   @ApiModelProperty(name = "createTime", notes = "立项时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "startDate", notes = "开工日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", notes = "(计划)完工时期")
   private LocalDate endDate;
   @ApiModelProperty(notes = "实际完工时期")
   private LocalDate completeDate;
   @ApiModelProperty(name = "mode", notes = "项目模式")
   private Integer mode;
   @ApiModelProperty(name = "settlementStatus", notes = "结算状态 0 未结算 1已结算")
   private Integer settlementStatus;
   @ApiModelProperty(name = "alreadyDays", notes = "已用天数")
   private Integer alreadyDays;
   @ApiModelProperty(name = "allDays", notes = "全部天数")
   private Integer allDays;
   @ApiModelProperty("结构类型")
   private Long structureStatus;
   @ApiModelProperty(value = "合同是否有效", notes = "合同是否有效 1.有效 0.无效")
   private Integer isEffective;
   @ApiModelProperty(name = "contractSignBodyId", notes = "合同签订主体id(公司,单位...)")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyId", notes = "合同签订主体名字")
   private String contractSignBodyName;
   @ApiModelProperty(name = "projectAttribute", notes = "项目属性: 1.自营 2.合营 3.包干制 枚举:ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "structureArea", value = "建筑面积")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "projectManagerId", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", notes = "项目经理名字）")
   private String projectManagerName;
   @ApiModelProperty(name = "salesLeaderId", notes = "项目销售员id")
   private Long salesLeaderId;
   @ApiModelProperty(name = "salesLeaderName", notes = "项目销售员名字")
   private String salesLeaderName;
   @ApiModelProperty(name = "infoSource", value = "信息来源")
   private Long infoSource;
   @ApiModelProperty(name = "user_id", notes = "创建项目的用户id")
   private Long userId;
   @ApiModelProperty(name = "user_name", notes = "创建项目的用户姓名")
   private String userName;
   @ApiModelProperty(name = "pId", notes = "父合同id")
   private Long pId;
   @ApiModelProperty(name = "structureStatusName", notes = "结构类型名称")
   private String structureStatusName;
   @ApiModelProperty(name = "infoSourceName", value = "信息来源名称")
   private String infoSourceName;
   @ApiModelProperty(name = "unitType", value = "单位类型 1.吨 2.平方米")
   private Integer unitType;
   @ApiModelProperty(name = "prepayments", notes = "预付款（元）")
   private BigDecimal prepayments;

   public Long getId() {
      return this.id;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public String getProjectContent() {
      return this.projectContent;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public LocalDate getCompleteDate() {
      return this.completeDate;
   }

   public Integer getMode() {
      return this.mode;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Integer getAlreadyDays() {
      return this.alreadyDays;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public Long getStructureStatus() {
      return this.structureStatus;
   }

   public Integer getIsEffective() {
      return this.isEffective;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public Long getInfoSource() {
      return this.infoSource;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getPId() {
      return this.pId;
   }

   public String getStructureStatusName() {
      return this.structureStatusName;
   }

   public String getInfoSourceName() {
      return this.infoSourceName;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public BigDecimal getPrepayments() {
      return this.prepayments;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setCompleteDate(final LocalDate completeDate) {
      this.completeDate = completeDate;
   }

   public void setMode(final Integer mode) {
      this.mode = mode;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setAlreadyDays(final Integer alreadyDays) {
      this.alreadyDays = alreadyDays;
   }

   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   public void setStructureStatus(final Long structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setIsEffective(final Integer isEffective) {
      this.isEffective = isEffective;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
   }

   public void setInfoSource(final Long infoSource) {
      this.infoSource = infoSource;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setPId(final Long pId) {
      this.pId = pId;
   }

   public void setStructureStatusName(final String structureStatusName) {
      this.structureStatusName = structureStatusName;
   }

   public void setInfoSourceName(final String infoSourceName) {
      this.infoSourceName = infoSourceName;
   }

   public void setUnitType(final Integer unitType) {
      this.unitType = unitType;
   }

   public void setPrepayments(final BigDecimal prepayments) {
      this.prepayments = prepayments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectStandingBook)) {
         return false;
      }

      ProjectStandingBook other = (ProjectStandingBook)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$signerId = this.getSignerId();
            Object other$signerId = other.getSignerId();
            if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
               Object this$projectType = this.getProjectType();
               Object other$projectType = other.getProjectType();
               if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                  Object this$businessType = this.getBusinessType();
                  Object other$businessType = other.getBusinessType();
                  if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                     Object this$orderSourceType = this.getOrderSourceType();
                     Object other$orderSourceType = other.getOrderSourceType();
                     if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
                        Object this$mode = this.getMode();
                        Object other$mode = other.getMode();
                        if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
                           Object this$settlementStatus = this.getSettlementStatus();
                           Object other$settlementStatus = other.getSettlementStatus();
                           if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                              Object this$alreadyDays = this.getAlreadyDays();
                              Object other$alreadyDays = other.getAlreadyDays();
                              if (this$alreadyDays == null ? other$alreadyDays == null : this$alreadyDays.equals(other$alreadyDays)) {
                                 Object this$allDays = this.getAllDays();
                                 Object other$allDays = other.getAllDays();
                                 if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                                    Object this$structureStatus = this.getStructureStatus();
                                    Object other$structureStatus = other.getStructureStatus();
                                    if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
                                       Object this$isEffective = this.getIsEffective();
                                       Object other$isEffective = other.getIsEffective();
                                       if (this$isEffective == null ? other$isEffective == null : this$isEffective.equals(other$isEffective)) {
                                          Object this$contractSignBodyId = this.getContractSignBodyId();
                                          Object other$contractSignBodyId = other.getContractSignBodyId();
                                          if (this$contractSignBodyId == null
                                             ? other$contractSignBodyId == null
                                             : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                                             Object this$projectAttribute = this.getProjectAttribute();
                                             Object other$projectAttribute = other.getProjectAttribute();
                                             if (this$projectAttribute == null
                                                ? other$projectAttribute == null
                                                : this$projectAttribute.equals(other$projectAttribute)) {
                                                Object this$projectManagerId = this.getProjectManagerId();
                                                Object other$projectManagerId = other.getProjectManagerId();
                                                if (this$projectManagerId == null
                                                   ? other$projectManagerId == null
                                                   : this$projectManagerId.equals(other$projectManagerId)) {
                                                   Object this$salesLeaderId = this.getSalesLeaderId();
                                                   Object other$salesLeaderId = other.getSalesLeaderId();
                                                   if (this$salesLeaderId == null
                                                      ? other$salesLeaderId == null
                                                      : this$salesLeaderId.equals(other$salesLeaderId)) {
                                                      Object this$infoSource = this.getInfoSource();
                                                      Object other$infoSource = other.getInfoSource();
                                                      if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                                                         Object this$userId = this.getUserId();
                                                         Object other$userId = other.getUserId();
                                                         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                            Object this$pId = this.getPId();
                                                            Object other$pId = other.getPId();
                                                            if (this$pId == null ? other$pId == null : this$pId.equals(other$pId)) {
                                                               Object this$unitType = this.getUnitType();
                                                               Object other$unitType = other.getUnitType();
                                                               if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
                                                                  Object this$serialNumber = this.getSerialNumber();
                                                                  Object other$serialNumber = other.getSerialNumber();
                                                                  if (this$serialNumber == null
                                                                     ? other$serialNumber == null
                                                                     : this$serialNumber.equals(other$serialNumber)) {
                                                                     Object this$name = this.getName();
                                                                     Object other$name = other.getName();
                                                                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                        Object this$shortName = this.getShortName();
                                                                        Object other$shortName = other.getShortName();
                                                                        if (this$shortName == null
                                                                           ? other$shortName == null
                                                                           : this$shortName.equals(other$shortName)) {
                                                                           Object this$contractAmount = this.getContractAmount();
                                                                           Object other$contractAmount = other.getContractAmount();
                                                                           if (this$contractAmount == null
                                                                              ? other$contractAmount == null
                                                                              : this$contractAmount.equals(other$contractAmount)) {
                                                                              Object this$projectContent = this.getProjectContent();
                                                                              Object other$projectContent = other.getProjectContent();
                                                                              if (this$projectContent == null
                                                                                 ? other$projectContent == null
                                                                                 : this$projectContent.equals(other$projectContent)) {
                                                                                 Object this$signingDate = this.getSigningDate();
                                                                                 Object other$signingDate = other.getSigningDate();
                                                                                 if (this$signingDate == null
                                                                                    ? other$signingDate == null
                                                                                    : this$signingDate.equals(other$signingDate)) {
                                                                                    Object this$signerName = this.getSignerName();
                                                                                    Object other$signerName = other.getSignerName();
                                                                                    if (this$signerName == null
                                                                                       ? other$signerName == null
                                                                                       : this$signerName.equals(other$signerName)) {
                                                                                       Object this$createTime = this.getCreateTime();
                                                                                       Object other$createTime = other.getCreateTime();
                                                                                       if (this$createTime == null
                                                                                          ? other$createTime == null
                                                                                          : this$createTime.equals(other$createTime)) {
                                                                                          Object this$startDate = this.getStartDate();
                                                                                          Object other$startDate = other.getStartDate();
                                                                                          if (this$startDate == null
                                                                                             ? other$startDate == null
                                                                                             : this$startDate.equals(other$startDate)) {
                                                                                             Object this$endDate = this.getEndDate();
                                                                                             Object other$endDate = other.getEndDate();
                                                                                             if (this$endDate == null
                                                                                                ? other$endDate == null
                                                                                                : this$endDate.equals(other$endDate)) {
                                                                                                Object this$completeDate = this.getCompleteDate();
                                                                                                Object other$completeDate = other.getCompleteDate();
                                                                                                if (this$completeDate == null
                                                                                                   ? other$completeDate == null
                                                                                                   : this$completeDate.equals(other$completeDate)) {
                                                                                                   Object this$contractSignBodyName = this.getContractSignBodyName();
                                                                                                   Object other$contractSignBodyName = other.getContractSignBodyName();
                                                                                                   if (this$contractSignBodyName == null
                                                                                                      ? other$contractSignBodyName == null
                                                                                                      : this$contractSignBodyName.equals(
                                                                                                         other$contractSignBodyName
                                                                                                      )) {
                                                                                                      Object this$structureArea = this.getStructureArea();
                                                                                                      Object other$structureArea = other.getStructureArea();
                                                                                                      if (this$structureArea == null
                                                                                                         ? other$structureArea == null
                                                                                                         : this$structureArea.equals(other$structureArea)) {
                                                                                                         Object this$projectManagerName = this.getProjectManagerName();
                                                                                                         Object other$projectManagerName = other.getProjectManagerName();
                                                                                                         if (this$projectManagerName == null
                                                                                                            ? other$projectManagerName == null
                                                                                                            : this$projectManagerName.equals(
                                                                                                               other$projectManagerName
                                                                                                            )) {
                                                                                                            Object this$salesLeaderName = this.getSalesLeaderName();
                                                                                                            Object other$salesLeaderName = other.getSalesLeaderName();
                                                                                                            if (this$salesLeaderName == null
                                                                                                               ? other$salesLeaderName == null
                                                                                                               : this$salesLeaderName.equals(
                                                                                                                  other$salesLeaderName
                                                                                                               )) {
                                                                                                               Object this$userName = this.getUserName();
                                                                                                               Object other$userName = other.getUserName();
                                                                                                               if (this$userName == null
                                                                                                                  ? other$userName == null
                                                                                                                  : this$userName.equals(other$userName)) {
                                                                                                                  Object this$structureStatusName = this.getStructureStatusName();
                                                                                                                  Object other$structureStatusName = other.getStructureStatusName();
                                                                                                                  if (this$structureStatusName == null
                                                                                                                     ? other$structureStatusName == null
                                                                                                                     : this$structureStatusName.equals(
                                                                                                                        other$structureStatusName
                                                                                                                     )) {
                                                                                                                     Object this$infoSourceName = this.getInfoSourceName();
                                                                                                                     Object other$infoSourceName = other.getInfoSourceName();
                                                                                                                     if (this$infoSourceName == null
                                                                                                                        ? other$infoSourceName == null
                                                                                                                        : this$infoSourceName.equals(
                                                                                                                           other$infoSourceName
                                                                                                                        )) {
                                                                                                                        Object this$prepayments = this.getPrepayments();
                                                                                                                        Object other$prepayments = other.getPrepayments();
                                                                                                                        return this$prepayments == null
                                                                                                                           ? other$prepayments == null
                                                                                                                           : this$prepayments.equals(
                                                                                                                              other$prepayments
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectStandingBook;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $alreadyDays = this.getAlreadyDays();
      result = result * 59 + ($alreadyDays == null ? 43 : $alreadyDays.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $isEffective = this.getIsEffective();
      result = result * 59 + ($isEffective == null ? 43 : $isEffective.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $pId = this.getPId();
      result = result * 59 + ($pId == null ? 43 : $pId.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $completeDate = this.getCompleteDate();
      result = result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $structureStatusName = this.getStructureStatusName();
      result = result * 59 + ($structureStatusName == null ? 43 : $structureStatusName.hashCode());
      Object $infoSourceName = this.getInfoSourceName();
      result = result * 59 + ($infoSourceName == null ? 43 : $infoSourceName.hashCode());
      Object $prepayments = this.getPrepayments();
      return result * 59 + ($prepayments == null ? 43 : $prepayments.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectStandingBook(id="
         + this.getId()
         + ", status="
         + this.getStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", projectContent="
         + this.getProjectContent()
         + ", signingDate="
         + this.getSigningDate()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", projectType="
         + this.getProjectType()
         + ", businessType="
         + this.getBusinessType()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", createTime="
         + this.getCreateTime()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", completeDate="
         + this.getCompleteDate()
         + ", mode="
         + this.getMode()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", alreadyDays="
         + this.getAlreadyDays()
         + ", allDays="
         + this.getAllDays()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", isEffective="
         + this.getIsEffective()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", structureArea="
         + this.getStructureArea()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", infoSource="
         + this.getInfoSource()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", pId="
         + this.getPId()
         + ", structureStatusName="
         + this.getStructureStatusName()
         + ", infoSourceName="
         + this.getInfoSourceName()
         + ", unitType="
         + this.getUnitType()
         + ", prepayments="
         + this.getPrepayments()
         + ")";
   }

   public ProjectStandingBook(
      final Long id,
      final Integer status,
      final String serialNumber,
      final String name,
      final String shortName,
      final BigDecimal contractAmount,
      final String projectContent,
      final LocalDate signingDate,
      final Long signerId,
      final String signerName,
      final Integer projectType,
      final Integer businessType,
      final Integer orderSourceType,
      final LocalDateTime createTime,
      final LocalDate startDate,
      final LocalDate endDate,
      final LocalDate completeDate,
      final Integer mode,
      final Integer settlementStatus,
      final Integer alreadyDays,
      final Integer allDays,
      final Long structureStatus,
      final Integer isEffective,
      final Long contractSignBodyId,
      final String contractSignBodyName,
      final Integer projectAttribute,
      final BigDecimal structureArea,
      final Long projectManagerId,
      final String projectManagerName,
      final Long salesLeaderId,
      final String salesLeaderName,
      final Long infoSource,
      final Long userId,
      final String userName,
      final Long pId,
      final String structureStatusName,
      final String infoSourceName,
      final Integer unitType,
      final BigDecimal prepayments
   ) {
      this.id = id;
      this.status = status;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.contractAmount = contractAmount;
      this.projectContent = projectContent;
      this.signingDate = signingDate;
      this.signerId = signerId;
      this.signerName = signerName;
      this.projectType = projectType;
      this.businessType = businessType;
      this.orderSourceType = orderSourceType;
      this.createTime = createTime;
      this.startDate = startDate;
      this.endDate = endDate;
      this.completeDate = completeDate;
      this.mode = mode;
      this.settlementStatus = settlementStatus;
      this.alreadyDays = alreadyDays;
      this.allDays = allDays;
      this.structureStatus = structureStatus;
      this.isEffective = isEffective;
      this.contractSignBodyId = contractSignBodyId;
      this.contractSignBodyName = contractSignBodyName;
      this.projectAttribute = projectAttribute;
      this.structureArea = structureArea;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.salesLeaderId = salesLeaderId;
      this.salesLeaderName = salesLeaderName;
      this.infoSource = infoSource;
      this.userId = userId;
      this.userName = userName;
      this.pId = pId;
      this.structureStatusName = structureStatusName;
      this.infoSourceName = infoSourceName;
      this.unitType = unitType;
      this.prepayments = prepayments;
   }

   public ProjectStandingBook() {
   }
}
