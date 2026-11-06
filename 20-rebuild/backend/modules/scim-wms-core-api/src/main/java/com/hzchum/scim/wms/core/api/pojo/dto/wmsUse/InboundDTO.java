package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.IdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class InboundDTO {
   @ApiModelProperty(name = "purchaseOrder", value = "采购订单", notes = "采购订单")
   private BriefPurchaseOrderDTO purchaseOrder;
   @ApiModelProperty(name = "id", value = "入库单id", notes = "入库单id")
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "采购物料基础类型", notes = "采购物料基础类型")
   private Integer basicClass;
   @ApiModelProperty(name = "serialNumber", value = "入库单号", notes = "入库单号")
   private String serialNumber;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "shipmentNumber", value = "物流单号", notes = "物流单号")
   private String shipmentNumber;
   @ApiModelProperty(name = "loadingWeight", value = "过磅重量", notes = "过磅重量")
   private BigDecimal loadingWeight;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   private Integer reviewStatus;
   @ApiModelProperty(name = "supplyType", value = "类型  1自采 2甲供", notes = "类型  1自采 2甲供")
   private Integer supplyType;
   @ApiModelProperty(name = "attachments", value = "质检附件信息", notes = "质检附件信息")
   @JsonInclude(Include.NON_NULL)
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "qualityTestingEnum", value = "质检状态", notes = "质检状态")
   @JsonInclude(Include.NON_NULL)
   private Integer qualityTestingEnum;
   @ApiModelProperty(name = "qualityTestingRemark", value = "质检备注", notes = "质检备注")
   @JsonInclude(Include.NON_NULL)
   private String qualityTestingRemark;
   @ApiModelProperty(name = "logisticsOrder", value = "物流订单", notes = "物流订单")
   private LogisticsOrder logisticsOrder;
   @ApiModelProperty(name = "list", value = "入库详情", notes = "入库详情")
   private List<InboundDetailDTO> list;
   @ApiModelProperty(name = "logistics", value = "物流信息", notes = "物流信息")
   private LogisticsOrder logistics;
   @ApiModelProperty(name = "approveRecordId", value = "审批的日志ID", notes = "审批的日志ID")
   private Long approveRecordId;
   @ApiModelProperty(name = "editMoney", value = "当前是否可操作金额", notes = "当前是否可操作金额")
   private Boolean editMoney;
   @ApiModelProperty(name = "editFreight", value = "当前是否可操作运费信息", notes = "当前是否可操作运费信息")
   private Boolean editFreight;
   @ApiModelProperty(name = "wmsApproveRecordFlowDTO", value = "审批日志信息", notes = "审批日志信息")
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "qualityTestingUserName", value = "质检人名称", notes = "质检人名称")
   private String qualityTestingUserName;
   @ApiModelProperty(name = "createTime", value = "入库日期  创建时间", notes = "入库日期  创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "sumAmount", value = "累计入库额", notes = "累计入库额")
   private BigDecimal sumAmount;
   @ApiModelProperty(name = "sumLoadingWeight", value = "累计入库量", notes = "累计入库量")
   private BigDecimal sumLoadingWeight;
   @ApiModelProperty(name = "surplusFreight", value = "剩余可操作运费", notes = "剩余可操作运费")
   private BigDecimal surplusFreight;
   @ApiModelProperty(name = "jsonData", value = "入库初始数据", notes = "入库初始数据")
   private String jsonData;
   @ApiModelProperty(name = "inboundWay", value = "入库方式", notes = "入库方式")
   private Integer inboundWay;
   @ApiModelProperty(name = "mesWorkshop", value = "车间(中南定制)", notes = "车间(中南定制)")
   private IdAndNameDTO mesWorkshop;

   public static InboundDTO.InboundDTOBuilder builder() {
      return new InboundDTO.InboundDTOBuilder();
   }

   public BriefPurchaseOrderDTO getPurchaseOrder() {
      return this.purchaseOrder;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getSupplyType() {
      return this.supplyType;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Integer getQualityTestingEnum() {
      return this.qualityTestingEnum;
   }

   public String getQualityTestingRemark() {
      return this.qualityTestingRemark;
   }

   public LogisticsOrder getLogisticsOrder() {
      return this.logisticsOrder;
   }

   public List<InboundDetailDTO> getList() {
      return this.list;
   }

   public LogisticsOrder getLogistics() {
      return this.logistics;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Boolean getEditMoney() {
      return this.editMoney;
   }

   public Boolean getEditFreight() {
      return this.editFreight;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTOS() {
      return this.wmsApproveRecordFlowDTOS;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getQualityTestingUserName() {
      return this.qualityTestingUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public BigDecimal getSumAmount() {
      return this.sumAmount;
   }

   public BigDecimal getSumLoadingWeight() {
      return this.sumLoadingWeight;
   }

   public BigDecimal getSurplusFreight() {
      return this.surplusFreight;
   }

   public String getJsonData() {
      return this.jsonData;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
   }

   public IdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public void setPurchaseOrder(final BriefPurchaseOrderDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setSupplyType(final Integer supplyType) {
      this.supplyType = supplyType;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setQualityTestingEnum(final Integer qualityTestingEnum) {
      this.qualityTestingEnum = qualityTestingEnum;
   }

   public void setQualityTestingRemark(final String qualityTestingRemark) {
      this.qualityTestingRemark = qualityTestingRemark;
   }

   public void setLogisticsOrder(final LogisticsOrder logisticsOrder) {
      this.logisticsOrder = logisticsOrder;
   }

   public void setList(final List<InboundDetailDTO> list) {
      this.list = list;
   }

   public void setLogistics(final LogisticsOrder logistics) {
      this.logistics = logistics;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setEditMoney(final Boolean editMoney) {
      this.editMoney = editMoney;
   }

   public void setEditFreight(final Boolean editFreight) {
      this.editFreight = editFreight;
   }

   public void setWmsApproveRecordFlowDTOS(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS) {
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setQualityTestingUserName(final String qualityTestingUserName) {
      this.qualityTestingUserName = qualityTestingUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSumAmount(final BigDecimal sumAmount) {
      this.sumAmount = sumAmount;
   }

   public void setSumLoadingWeight(final BigDecimal sumLoadingWeight) {
      this.sumLoadingWeight = sumLoadingWeight;
   }

   public void setSurplusFreight(final BigDecimal surplusFreight) {
      this.surplusFreight = surplusFreight;
   }

   public void setJsonData(final String jsonData) {
      this.jsonData = jsonData;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   public void setMesWorkshop(final IdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDTO)) {
         return false;
      }

      InboundDTO other = (InboundDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$supplyType = this.getSupplyType();
               Object other$supplyType = other.getSupplyType();
               if (this$supplyType == null ? other$supplyType == null : this$supplyType.equals(other$supplyType)) {
                  Object this$qualityTestingEnum = this.getQualityTestingEnum();
                  Object other$qualityTestingEnum = other.getQualityTestingEnum();
                  if (this$qualityTestingEnum == null ? other$qualityTestingEnum == null : this$qualityTestingEnum.equals(other$qualityTestingEnum)) {
                     Object this$approveRecordId = this.getApproveRecordId();
                     Object other$approveRecordId = other.getApproveRecordId();
                     if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                        Object this$editMoney = this.getEditMoney();
                        Object other$editMoney = other.getEditMoney();
                        if (this$editMoney == null ? other$editMoney == null : this$editMoney.equals(other$editMoney)) {
                           Object this$editFreight = this.getEditFreight();
                           Object other$editFreight = other.getEditFreight();
                           if (this$editFreight == null ? other$editFreight == null : this$editFreight.equals(other$editFreight)) {
                              Object this$inboundWay = this.getInboundWay();
                              Object other$inboundWay = other.getInboundWay();
                              if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                                 Object this$purchaseOrder = this.getPurchaseOrder();
                                 Object other$purchaseOrder = other.getPurchaseOrder();
                                 if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$licensePlate = this.getLicensePlate();
                                       Object other$licensePlate = other.getLicensePlate();
                                       if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                          Object this$shipmentNumber = this.getShipmentNumber();
                                          Object other$shipmentNumber = other.getShipmentNumber();
                                          if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                             Object this$loadingWeight = this.getLoadingWeight();
                                             Object other$loadingWeight = other.getLoadingWeight();
                                             if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                                                Object this$attachments = this.getAttachments();
                                                Object other$attachments = other.getAttachments();
                                                if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                                   Object this$qualityTestingRemark = this.getQualityTestingRemark();
                                                   Object other$qualityTestingRemark = other.getQualityTestingRemark();
                                                   if (this$qualityTestingRemark == null
                                                      ? other$qualityTestingRemark == null
                                                      : this$qualityTestingRemark.equals(other$qualityTestingRemark)) {
                                                      Object this$logisticsOrder = this.getLogisticsOrder();
                                                      Object other$logisticsOrder = other.getLogisticsOrder();
                                                      if (this$logisticsOrder == null
                                                         ? other$logisticsOrder == null
                                                         : this$logisticsOrder.equals(other$logisticsOrder)) {
                                                         Object this$list = this.getList();
                                                         Object other$list = other.getList();
                                                         if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                                            Object this$logistics = this.getLogistics();
                                                            Object other$logistics = other.getLogistics();
                                                            if (this$logistics == null ? other$logistics == null : this$logistics.equals(other$logistics)) {
                                                               Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                                               Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                                               if (this$wmsApproveRecordFlowDTOS == null
                                                                  ? other$wmsApproveRecordFlowDTOS == null
                                                                  : this$wmsApproveRecordFlowDTOS.equals(other$wmsApproveRecordFlowDTOS)) {
                                                                  Object this$applicantName = this.getApplicantName();
                                                                  Object other$applicantName = other.getApplicantName();
                                                                  if (this$applicantName == null
                                                                     ? other$applicantName == null
                                                                     : this$applicantName.equals(other$applicantName)) {
                                                                     Object this$qualityTestingUserName = this.getQualityTestingUserName();
                                                                     Object other$qualityTestingUserName = other.getQualityTestingUserName();
                                                                     if (this$qualityTestingUserName == null
                                                                        ? other$qualityTestingUserName == null
                                                                        : this$qualityTestingUserName.equals(other$qualityTestingUserName)) {
                                                                        Object this$createTime = this.getCreateTime();
                                                                        Object other$createTime = other.getCreateTime();
                                                                        if (this$createTime == null
                                                                           ? other$createTime == null
                                                                           : this$createTime.equals(other$createTime)) {
                                                                           Object this$sumAmount = this.getSumAmount();
                                                                           Object other$sumAmount = other.getSumAmount();
                                                                           if (this$sumAmount == null
                                                                              ? other$sumAmount == null
                                                                              : this$sumAmount.equals(other$sumAmount)) {
                                                                              Object this$sumLoadingWeight = this.getSumLoadingWeight();
                                                                              Object other$sumLoadingWeight = other.getSumLoadingWeight();
                                                                              if (this$sumLoadingWeight == null
                                                                                 ? other$sumLoadingWeight == null
                                                                                 : this$sumLoadingWeight.equals(other$sumLoadingWeight)) {
                                                                                 Object this$surplusFreight = this.getSurplusFreight();
                                                                                 Object other$surplusFreight = other.getSurplusFreight();
                                                                                 if (this$surplusFreight == null
                                                                                    ? other$surplusFreight == null
                                                                                    : this$surplusFreight.equals(other$surplusFreight)) {
                                                                                    Object this$jsonData = this.getJsonData();
                                                                                    Object other$jsonData = other.getJsonData();
                                                                                    if (this$jsonData == null
                                                                                       ? other$jsonData == null
                                                                                       : this$jsonData.equals(other$jsonData)) {
                                                                                       Object this$mesWorkshop = this.getMesWorkshop();
                                                                                       Object other$mesWorkshop = other.getMesWorkshop();
                                                                                       return this$mesWorkshop == null
                                                                                          ? other$mesWorkshop == null
                                                                                          : this$mesWorkshop.equals(other$mesWorkshop);
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
      return other instanceof InboundDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $supplyType = this.getSupplyType();
      result = result * 59 + ($supplyType == null ? 43 : $supplyType.hashCode());
      Object $qualityTestingEnum = this.getQualityTestingEnum();
      result = result * 59 + ($qualityTestingEnum == null ? 43 : $qualityTestingEnum.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $editMoney = this.getEditMoney();
      result = result * 59 + ($editMoney == null ? 43 : $editMoney.hashCode());
      Object $editFreight = this.getEditFreight();
      result = result * 59 + ($editFreight == null ? 43 : $editFreight.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $qualityTestingRemark = this.getQualityTestingRemark();
      result = result * 59 + ($qualityTestingRemark == null ? 43 : $qualityTestingRemark.hashCode());
      Object $logisticsOrder = this.getLogisticsOrder();
      result = result * 59 + ($logisticsOrder == null ? 43 : $logisticsOrder.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $logistics = this.getLogistics();
      result = result * 59 + ($logistics == null ? 43 : $logistics.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      result = result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $qualityTestingUserName = this.getQualityTestingUserName();
      result = result * 59 + ($qualityTestingUserName == null ? 43 : $qualityTestingUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $sumAmount = this.getSumAmount();
      result = result * 59 + ($sumAmount == null ? 43 : $sumAmount.hashCode());
      Object $sumLoadingWeight = this.getSumLoadingWeight();
      result = result * 59 + ($sumLoadingWeight == null ? 43 : $sumLoadingWeight.hashCode());
      Object $surplusFreight = this.getSurplusFreight();
      result = result * 59 + ($surplusFreight == null ? 43 : $surplusFreight.hashCode());
      Object $jsonData = this.getJsonData();
      result = result * 59 + ($jsonData == null ? 43 : $jsonData.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      return result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
   }

   @Override
   public String toString() {
      return "InboundDTO(purchaseOrder="
         + this.getPurchaseOrder()
         + ", id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", supplyType="
         + this.getSupplyType()
         + ", attachments="
         + this.getAttachments()
         + ", qualityTestingEnum="
         + this.getQualityTestingEnum()
         + ", qualityTestingRemark="
         + this.getQualityTestingRemark()
         + ", logisticsOrder="
         + this.getLogisticsOrder()
         + ", list="
         + this.getList()
         + ", logistics="
         + this.getLogistics()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", editMoney="
         + this.getEditMoney()
         + ", editFreight="
         + this.getEditFreight()
         + ", wmsApproveRecordFlowDTOS="
         + this.getWmsApproveRecordFlowDTOS()
         + ", applicantName="
         + this.getApplicantName()
         + ", qualityTestingUserName="
         + this.getQualityTestingUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", sumAmount="
         + this.getSumAmount()
         + ", sumLoadingWeight="
         + this.getSumLoadingWeight()
         + ", surplusFreight="
         + this.getSurplusFreight()
         + ", jsonData="
         + this.getJsonData()
         + ", inboundWay="
         + this.getInboundWay()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ")";
   }

   public InboundDTO(
      final BriefPurchaseOrderDTO purchaseOrder,
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final String licensePlate,
      final String shipmentNumber,
      final BigDecimal loadingWeight,
      final Integer reviewStatus,
      final Integer supplyType,
      final List<AttachmentDTO> attachments,
      final Integer qualityTestingEnum,
      final String qualityTestingRemark,
      final LogisticsOrder logisticsOrder,
      final List<InboundDetailDTO> list,
      final LogisticsOrder logistics,
      final Long approveRecordId,
      final Boolean editMoney,
      final Boolean editFreight,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS,
      final String applicantName,
      final String qualityTestingUserName,
      final LocalDateTime createTime,
      final BigDecimal sumAmount,
      final BigDecimal sumLoadingWeight,
      final BigDecimal surplusFreight,
      final String jsonData,
      final Integer inboundWay,
      final IdAndNameDTO mesWorkshop
   ) {
      this.purchaseOrder = purchaseOrder;
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.licensePlate = licensePlate;
      this.shipmentNumber = shipmentNumber;
      this.loadingWeight = loadingWeight;
      this.reviewStatus = reviewStatus;
      this.supplyType = supplyType;
      this.attachments = attachments;
      this.qualityTestingEnum = qualityTestingEnum;
      this.qualityTestingRemark = qualityTestingRemark;
      this.logisticsOrder = logisticsOrder;
      this.list = list;
      this.logistics = logistics;
      this.approveRecordId = approveRecordId;
      this.editMoney = editMoney;
      this.editFreight = editFreight;
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
      this.applicantName = applicantName;
      this.qualityTestingUserName = qualityTestingUserName;
      this.createTime = createTime;
      this.sumAmount = sumAmount;
      this.sumLoadingWeight = sumLoadingWeight;
      this.surplusFreight = surplusFreight;
      this.jsonData = jsonData;
      this.inboundWay = inboundWay;
      this.mesWorkshop = mesWorkshop;
   }

   public InboundDTO() {
   }

   public static class InboundDTOBuilder {
      private BriefPurchaseOrderDTO purchaseOrder;
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private String licensePlate;
      private String shipmentNumber;
      private BigDecimal loadingWeight;
      private Integer reviewStatus;
      private Integer supplyType;
      private List<AttachmentDTO> attachments;
      private Integer qualityTestingEnum;
      private String qualityTestingRemark;
      private LogisticsOrder logisticsOrder;
      private List<InboundDetailDTO> list;
      private LogisticsOrder logistics;
      private Long approveRecordId;
      private Boolean editMoney;
      private Boolean editFreight;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS;
      private String applicantName;
      private String qualityTestingUserName;
      private LocalDateTime createTime;
      private BigDecimal sumAmount;
      private BigDecimal sumLoadingWeight;
      private BigDecimal surplusFreight;
      private String jsonData;
      private Integer inboundWay;
      private IdAndNameDTO mesWorkshop;

      InboundDTOBuilder() {
      }

      public InboundDTO.InboundDTOBuilder purchaseOrder(final BriefPurchaseOrderDTO purchaseOrder) {
         this.purchaseOrder = purchaseOrder;
         return this;
      }

      public InboundDTO.InboundDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InboundDTO.InboundDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InboundDTO.InboundDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InboundDTO.InboundDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public InboundDTO.InboundDTOBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public InboundDTO.InboundDTOBuilder loadingWeight(final BigDecimal loadingWeight) {
         this.loadingWeight = loadingWeight;
         return this;
      }

      public InboundDTO.InboundDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public InboundDTO.InboundDTOBuilder supplyType(final Integer supplyType) {
         this.supplyType = supplyType;
         return this;
      }

      public InboundDTO.InboundDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public InboundDTO.InboundDTOBuilder qualityTestingEnum(final Integer qualityTestingEnum) {
         this.qualityTestingEnum = qualityTestingEnum;
         return this;
      }

      public InboundDTO.InboundDTOBuilder qualityTestingRemark(final String qualityTestingRemark) {
         this.qualityTestingRemark = qualityTestingRemark;
         return this;
      }

      public InboundDTO.InboundDTOBuilder logisticsOrder(final LogisticsOrder logisticsOrder) {
         this.logisticsOrder = logisticsOrder;
         return this;
      }

      public InboundDTO.InboundDTOBuilder list(final List<InboundDetailDTO> list) {
         this.list = list;
         return this;
      }

      public InboundDTO.InboundDTOBuilder logistics(final LogisticsOrder logistics) {
         this.logistics = logistics;
         return this;
      }

      public InboundDTO.InboundDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public InboundDTO.InboundDTOBuilder editMoney(final Boolean editMoney) {
         this.editMoney = editMoney;
         return this;
      }

      public InboundDTO.InboundDTOBuilder editFreight(final Boolean editFreight) {
         this.editFreight = editFreight;
         return this;
      }

      public InboundDTO.InboundDTOBuilder wmsApproveRecordFlowDTOS(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS) {
         this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
         return this;
      }

      public InboundDTO.InboundDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public InboundDTO.InboundDTOBuilder qualityTestingUserName(final String qualityTestingUserName) {
         this.qualityTestingUserName = qualityTestingUserName;
         return this;
      }

      public InboundDTO.InboundDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public InboundDTO.InboundDTOBuilder sumAmount(final BigDecimal sumAmount) {
         this.sumAmount = sumAmount;
         return this;
      }

      public InboundDTO.InboundDTOBuilder sumLoadingWeight(final BigDecimal sumLoadingWeight) {
         this.sumLoadingWeight = sumLoadingWeight;
         return this;
      }

      public InboundDTO.InboundDTOBuilder surplusFreight(final BigDecimal surplusFreight) {
         this.surplusFreight = surplusFreight;
         return this;
      }

      public InboundDTO.InboundDTOBuilder jsonData(final String jsonData) {
         this.jsonData = jsonData;
         return this;
      }

      public InboundDTO.InboundDTOBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public InboundDTO.InboundDTOBuilder mesWorkshop(final IdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public InboundDTO build() {
         return new InboundDTO(
            this.purchaseOrder,
            this.id,
            this.basicClass,
            this.serialNumber,
            this.licensePlate,
            this.shipmentNumber,
            this.loadingWeight,
            this.reviewStatus,
            this.supplyType,
            this.attachments,
            this.qualityTestingEnum,
            this.qualityTestingRemark,
            this.logisticsOrder,
            this.list,
            this.logistics,
            this.approveRecordId,
            this.editMoney,
            this.editFreight,
            this.wmsApproveRecordFlowDTOS,
            this.applicantName,
            this.qualityTestingUserName,
            this.createTime,
            this.sumAmount,
            this.sumLoadingWeight,
            this.surplusFreight,
            this.jsonData,
            this.inboundWay,
            this.mesWorkshop
         );
      }

      @Override
      public String toString() {
         return "InboundDTO.InboundDTOBuilder(purchaseOrder="
            + this.purchaseOrder
            + ", id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", licensePlate="
            + this.licensePlate
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", loadingWeight="
            + this.loadingWeight
            + ", reviewStatus="
            + this.reviewStatus
            + ", supplyType="
            + this.supplyType
            + ", attachments="
            + this.attachments
            + ", qualityTestingEnum="
            + this.qualityTestingEnum
            + ", qualityTestingRemark="
            + this.qualityTestingRemark
            + ", logisticsOrder="
            + this.logisticsOrder
            + ", list="
            + this.list
            + ", logistics="
            + this.logistics
            + ", approveRecordId="
            + this.approveRecordId
            + ", editMoney="
            + this.editMoney
            + ", editFreight="
            + this.editFreight
            + ", wmsApproveRecordFlowDTOS="
            + this.wmsApproveRecordFlowDTOS
            + ", applicantName="
            + this.applicantName
            + ", qualityTestingUserName="
            + this.qualityTestingUserName
            + ", createTime="
            + this.createTime
            + ", sumAmount="
            + this.sumAmount
            + ", sumLoadingWeight="
            + this.sumLoadingWeight
            + ", surplusFreight="
            + this.surplusFreight
            + ", jsonData="
            + this.jsonData
            + ", inboundWay="
            + this.inboundWay
            + ", mesWorkshop="
            + this.mesWorkshop
            + ")";
      }
   }
}
