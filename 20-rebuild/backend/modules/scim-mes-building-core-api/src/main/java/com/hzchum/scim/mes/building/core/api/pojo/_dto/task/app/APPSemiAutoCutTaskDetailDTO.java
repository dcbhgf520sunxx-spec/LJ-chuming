package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;

@ApiModel(value = "APPQuantityAndMeteDTO", description = "半自动切割任务详情")
public class APPSemiAutoCutTaskDetailDTO {
   private Long id;
   private String projectName;
   private String projectNumber;
   private String orderNumber;
   private LocalDateTime completeTime;
   private LocalDateTime askCompleteTime;
   private String userName;
   private String cutName;
   private String thickness;
   private String material;
   private Integer quantity;
   private Integer completeQuantity;
   private BigDecimal completeWeight;
   @ApiModelProperty(name = "schedulingDate", value = "排产日期", notes = "排产日期")
   @JsonProperty("schedulingDate")
   @JSONField(name = "schedulingDate")
   private LocalDateTime schedulingDate;
   @ApiModelProperty(name = "nestCutPlateId", notes = "nestCutPlateId")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   private Long nestCutPlateId;
   @ApiModelProperty("零件排产id")
   private Long machinePartSchedulingId;
   @ApiModelProperty(name = "thumbnailUrl")
   @JsonProperty("thumbnailUrl")
   @TableField("thumbnail_url")
   @Column(name = "thumbnail_url", columnDefinition = "varchar(1000)  COMMENT '缩略图下载地址'", nullable = false)
   private String thumbnailUrl;
   @ApiModelProperty(name = "cuttingReportMethod", value = "切割报工方式", notes = "切割报工方式")
   @JsonProperty("cuttingReportMethod")
   @JSONField(name = "cuttingReportMethod")
   private Integer cuttingReportMethod;
   @ApiModelProperty(name = "drillReportMethod", value = "钻孔报工方式", notes = "钻孔报工方式")
   @JsonProperty("drillReportMethod")
   @JSONField(name = "drillReportMethod")
   private Integer drillReportMethod;
   @ApiModelProperty(name = "boolCanAppReport", value = "是否可以APP上报", notes = "是否可以APP上报")
   @JsonProperty("boolCanAppReport")
   private Boolean boolCanAppReport;
   private List<SemiAutoCutPartDTO> semiAutoCutPartDTOList;
   private String plateHeight;
   private String plateWidth;
   private String fileNameNest;
   private String guid;
   private Integer cutCount;
   @ApiModelProperty("是否存在领料审批通过")
   private Boolean boolPickingApproved;

   public static APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder builder() {
      return new APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder();
   }

   public APPSemiAutoCutTaskDetailDTO() {
   }

   public APPSemiAutoCutTaskDetailDTO(
      final Long id,
      final String projectName,
      final String projectNumber,
      final String orderNumber,
      final LocalDateTime completeTime,
      final LocalDateTime askCompleteTime,
      final String userName,
      final String cutName,
      final String thickness,
      final String material,
      final Integer quantity,
      final Integer completeQuantity,
      final BigDecimal completeWeight,
      final LocalDateTime schedulingDate,
      final Long nestCutPlateId,
      final Long machinePartSchedulingId,
      final String thumbnailUrl,
      final Integer cuttingReportMethod,
      final Integer drillReportMethod,
      final Boolean boolCanAppReport,
      final List<SemiAutoCutPartDTO> semiAutoCutPartDTOList,
      final String plateHeight,
      final String plateWidth,
      final String fileNameNest,
      final String guid,
      final Integer cutCount,
      final Boolean boolPickingApproved
   ) {
      this.id = id;
      this.projectName = projectName;
      this.projectNumber = projectNumber;
      this.orderNumber = orderNumber;
      this.completeTime = completeTime;
      this.askCompleteTime = askCompleteTime;
      this.userName = userName;
      this.cutName = cutName;
      this.thickness = thickness;
      this.material = material;
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.completeWeight = completeWeight;
      this.schedulingDate = schedulingDate;
      this.nestCutPlateId = nestCutPlateId;
      this.machinePartSchedulingId = machinePartSchedulingId;
      this.thumbnailUrl = thumbnailUrl;
      this.cuttingReportMethod = cuttingReportMethod;
      this.drillReportMethod = drillReportMethod;
      this.boolCanAppReport = boolCanAppReport;
      this.semiAutoCutPartDTOList = semiAutoCutPartDTOList;
      this.plateHeight = plateHeight;
      this.plateWidth = plateWidth;
      this.fileNameNest = fileNameNest;
      this.guid = guid;
      this.cutCount = cutCount;
      this.boolPickingApproved = boolPickingApproved;
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectNumber() {
      return this.projectNumber;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getCutName() {
      return this.cutName;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteWeight() {
      return this.completeWeight;
   }

   public LocalDateTime getSchedulingDate() {
      return this.schedulingDate;
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public Long getMachinePartSchedulingId() {
      return this.machinePartSchedulingId;
   }

   public String getThumbnailUrl() {
      return this.thumbnailUrl;
   }

   public Integer getCuttingReportMethod() {
      return this.cuttingReportMethod;
   }

   public Integer getDrillReportMethod() {
      return this.drillReportMethod;
   }

   public Boolean getBoolCanAppReport() {
      return this.boolCanAppReport;
   }

   public List<SemiAutoCutPartDTO> getSemiAutoCutPartDTOList() {
      return this.semiAutoCutPartDTOList;
   }

   public String getPlateHeight() {
      return this.plateHeight;
   }

   public String getPlateWidth() {
      return this.plateWidth;
   }

   public String getFileNameNest() {
      return this.fileNameNest;
   }

   public String getGuid() {
      return this.guid;
   }

   public Integer getCutCount() {
      return this.cutCount;
   }

   public Boolean getBoolPickingApproved() {
      return this.boolPickingApproved;
   }

   public APPSemiAutoCutTaskDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setProjectNumber(final String projectNumber) {
      this.projectNumber = projectNumber;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setCutName(final String cutName) {
      this.cutName = cutName;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setCompleteWeight(final BigDecimal completeWeight) {
      this.completeWeight = completeWeight;
      return this;
   }

   @JsonProperty("schedulingDate")
   public APPSemiAutoCutTaskDetailDTO setSchedulingDate(final LocalDateTime schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("nestCutPlateId")
   public APPSemiAutoCutTaskDetailDTO setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setMachinePartSchedulingId(final Long machinePartSchedulingId) {
      this.machinePartSchedulingId = machinePartSchedulingId;
      return this;
   }

   @JsonProperty("thumbnailUrl")
   public APPSemiAutoCutTaskDetailDTO setThumbnailUrl(final String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
      return this;
   }

   @JsonProperty("cuttingReportMethod")
   public APPSemiAutoCutTaskDetailDTO setCuttingReportMethod(final Integer cuttingReportMethod) {
      this.cuttingReportMethod = cuttingReportMethod;
      return this;
   }

   @JsonProperty("drillReportMethod")
   public APPSemiAutoCutTaskDetailDTO setDrillReportMethod(final Integer drillReportMethod) {
      this.drillReportMethod = drillReportMethod;
      return this;
   }

   @JsonProperty("boolCanAppReport")
   public APPSemiAutoCutTaskDetailDTO setBoolCanAppReport(final Boolean boolCanAppReport) {
      this.boolCanAppReport = boolCanAppReport;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setSemiAutoCutPartDTOList(final List<SemiAutoCutPartDTO> semiAutoCutPartDTOList) {
      this.semiAutoCutPartDTOList = semiAutoCutPartDTOList;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setPlateHeight(final String plateHeight) {
      this.plateHeight = plateHeight;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setPlateWidth(final String plateWidth) {
      this.plateWidth = plateWidth;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setFileNameNest(final String fileNameNest) {
      this.fileNameNest = fileNameNest;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setCutCount(final Integer cutCount) {
      this.cutCount = cutCount;
      return this;
   }

   public APPSemiAutoCutTaskDetailDTO setBoolPickingApproved(final Boolean boolPickingApproved) {
      this.boolPickingApproved = boolPickingApproved;
      return this;
   }

   @Override
   public String toString() {
      return "APPSemiAutoCutTaskDetailDTO(id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ", projectNumber="
         + this.getProjectNumber()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", completeTime="
         + this.getCompleteTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", userName="
         + this.getUserName()
         + ", cutName="
         + this.getCutName()
         + ", thickness="
         + this.getThickness()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeWeight="
         + this.getCompleteWeight()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", nestCutPlateId="
         + this.getNestCutPlateId()
         + ", machinePartSchedulingId="
         + this.getMachinePartSchedulingId()
         + ", thumbnailUrl="
         + this.getThumbnailUrl()
         + ", cuttingReportMethod="
         + this.getCuttingReportMethod()
         + ", drillReportMethod="
         + this.getDrillReportMethod()
         + ", boolCanAppReport="
         + this.getBoolCanAppReport()
         + ", semiAutoCutPartDTOList="
         + this.getSemiAutoCutPartDTOList()
         + ", plateHeight="
         + this.getPlateHeight()
         + ", plateWidth="
         + this.getPlateWidth()
         + ", fileNameNest="
         + this.getFileNameNest()
         + ", guid="
         + this.getGuid()
         + ", cutCount="
         + this.getCutCount()
         + ", boolPickingApproved="
         + this.getBoolPickingApproved()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPSemiAutoCutTaskDetailDTO)) {
         return false;
      }

      APPSemiAutoCutTaskDetailDTO other = (APPSemiAutoCutTaskDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$nestCutPlateId = this.getNestCutPlateId();
               Object other$nestCutPlateId = other.getNestCutPlateId();
               if (this$nestCutPlateId == null ? other$nestCutPlateId == null : this$nestCutPlateId.equals(other$nestCutPlateId)) {
                  Object this$machinePartSchedulingId = this.getMachinePartSchedulingId();
                  Object other$machinePartSchedulingId = other.getMachinePartSchedulingId();
                  if (this$machinePartSchedulingId == null
                     ? other$machinePartSchedulingId == null
                     : this$machinePartSchedulingId.equals(other$machinePartSchedulingId)) {
                     Object this$cuttingReportMethod = this.getCuttingReportMethod();
                     Object other$cuttingReportMethod = other.getCuttingReportMethod();
                     if (this$cuttingReportMethod == null ? other$cuttingReportMethod == null : this$cuttingReportMethod.equals(other$cuttingReportMethod)) {
                        Object this$drillReportMethod = this.getDrillReportMethod();
                        Object other$drillReportMethod = other.getDrillReportMethod();
                        if (this$drillReportMethod == null ? other$drillReportMethod == null : this$drillReportMethod.equals(other$drillReportMethod)) {
                           Object this$boolCanAppReport = this.getBoolCanAppReport();
                           Object other$boolCanAppReport = other.getBoolCanAppReport();
                           if (this$boolCanAppReport == null ? other$boolCanAppReport == null : this$boolCanAppReport.equals(other$boolCanAppReport)) {
                              Object this$cutCount = this.getCutCount();
                              Object other$cutCount = other.getCutCount();
                              if (this$cutCount == null ? other$cutCount == null : this$cutCount.equals(other$cutCount)) {
                                 Object this$boolPickingApproved = this.getBoolPickingApproved();
                                 Object other$boolPickingApproved = other.getBoolPickingApproved();
                                 if (this$boolPickingApproved == null
                                    ? other$boolPickingApproved == null
                                    : this$boolPickingApproved.equals(other$boolPickingApproved)) {
                                    Object this$projectName = this.getProjectName();
                                    Object other$projectName = other.getProjectName();
                                    if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                       Object this$projectNumber = this.getProjectNumber();
                                       Object other$projectNumber = other.getProjectNumber();
                                       if (this$projectNumber == null ? other$projectNumber == null : this$projectNumber.equals(other$projectNumber)) {
                                          Object this$orderNumber = this.getOrderNumber();
                                          Object other$orderNumber = other.getOrderNumber();
                                          if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                             Object this$completeTime = this.getCompleteTime();
                                             Object other$completeTime = other.getCompleteTime();
                                             if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                                                Object this$askCompleteTime = this.getAskCompleteTime();
                                                Object other$askCompleteTime = other.getAskCompleteTime();
                                                if (this$askCompleteTime == null
                                                   ? other$askCompleteTime == null
                                                   : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                   Object this$userName = this.getUserName();
                                                   Object other$userName = other.getUserName();
                                                   if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                      Object this$cutName = this.getCutName();
                                                      Object other$cutName = other.getCutName();
                                                      if (this$cutName == null ? other$cutName == null : this$cutName.equals(other$cutName)) {
                                                         Object this$thickness = this.getThickness();
                                                         Object other$thickness = other.getThickness();
                                                         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                            Object this$material = this.getMaterial();
                                                            Object other$material = other.getMaterial();
                                                            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                               Object this$completeWeight = this.getCompleteWeight();
                                                               Object other$completeWeight = other.getCompleteWeight();
                                                               if (this$completeWeight == null
                                                                  ? other$completeWeight == null
                                                                  : this$completeWeight.equals(other$completeWeight)) {
                                                                  Object this$schedulingDate = this.getSchedulingDate();
                                                                  Object other$schedulingDate = other.getSchedulingDate();
                                                                  if (this$schedulingDate == null
                                                                     ? other$schedulingDate == null
                                                                     : this$schedulingDate.equals(other$schedulingDate)) {
                                                                     Object this$thumbnailUrl = this.getThumbnailUrl();
                                                                     Object other$thumbnailUrl = other.getThumbnailUrl();
                                                                     if (this$thumbnailUrl == null
                                                                        ? other$thumbnailUrl == null
                                                                        : this$thumbnailUrl.equals(other$thumbnailUrl)) {
                                                                        Object this$semiAutoCutPartDTOList = this.getSemiAutoCutPartDTOList();
                                                                        Object other$semiAutoCutPartDTOList = other.getSemiAutoCutPartDTOList();
                                                                        if (this$semiAutoCutPartDTOList == null
                                                                           ? other$semiAutoCutPartDTOList == null
                                                                           : this$semiAutoCutPartDTOList.equals(other$semiAutoCutPartDTOList)) {
                                                                           Object this$plateHeight = this.getPlateHeight();
                                                                           Object other$plateHeight = other.getPlateHeight();
                                                                           if (this$plateHeight == null
                                                                              ? other$plateHeight == null
                                                                              : this$plateHeight.equals(other$plateHeight)) {
                                                                              Object this$plateWidth = this.getPlateWidth();
                                                                              Object other$plateWidth = other.getPlateWidth();
                                                                              if (this$plateWidth == null
                                                                                 ? other$plateWidth == null
                                                                                 : this$plateWidth.equals(other$plateWidth)) {
                                                                                 Object this$fileNameNest = this.getFileNameNest();
                                                                                 Object other$fileNameNest = other.getFileNameNest();
                                                                                 if (this$fileNameNest == null
                                                                                    ? other$fileNameNest == null
                                                                                    : this$fileNameNest.equals(other$fileNameNest)) {
                                                                                    Object this$guid = this.getGuid();
                                                                                    Object other$guid = other.getGuid();
                                                                                    return this$guid == null
                                                                                       ? other$guid == null
                                                                                       : this$guid.equals(other$guid);
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof APPSemiAutoCutTaskDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $machinePartSchedulingId = this.getMachinePartSchedulingId();
      result = result * 59 + ($machinePartSchedulingId == null ? 43 : $machinePartSchedulingId.hashCode());
      Object $cuttingReportMethod = this.getCuttingReportMethod();
      result = result * 59 + ($cuttingReportMethod == null ? 43 : $cuttingReportMethod.hashCode());
      Object $drillReportMethod = this.getDrillReportMethod();
      result = result * 59 + ($drillReportMethod == null ? 43 : $drillReportMethod.hashCode());
      Object $boolCanAppReport = this.getBoolCanAppReport();
      result = result * 59 + ($boolCanAppReport == null ? 43 : $boolCanAppReport.hashCode());
      Object $cutCount = this.getCutCount();
      result = result * 59 + ($cutCount == null ? 43 : $cutCount.hashCode());
      Object $boolPickingApproved = this.getBoolPickingApproved();
      result = result * 59 + ($boolPickingApproved == null ? 43 : $boolPickingApproved.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectNumber = this.getProjectNumber();
      result = result * 59 + ($projectNumber == null ? 43 : $projectNumber.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $cutName = this.getCutName();
      result = result * 59 + ($cutName == null ? 43 : $cutName.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $completeWeight = this.getCompleteWeight();
      result = result * 59 + ($completeWeight == null ? 43 : $completeWeight.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      result = result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
      Object $thumbnailUrl = this.getThumbnailUrl();
      result = result * 59 + ($thumbnailUrl == null ? 43 : $thumbnailUrl.hashCode());
      Object $semiAutoCutPartDTOList = this.getSemiAutoCutPartDTOList();
      result = result * 59 + ($semiAutoCutPartDTOList == null ? 43 : $semiAutoCutPartDTOList.hashCode());
      Object $plateHeight = this.getPlateHeight();
      result = result * 59 + ($plateHeight == null ? 43 : $plateHeight.hashCode());
      Object $plateWidth = this.getPlateWidth();
      result = result * 59 + ($plateWidth == null ? 43 : $plateWidth.hashCode());
      Object $fileNameNest = this.getFileNameNest();
      result = result * 59 + ($fileNameNest == null ? 43 : $fileNameNest.hashCode());
      Object $guid = this.getGuid();
      return result * 59 + ($guid == null ? 43 : $guid.hashCode());
   }

   public static class APPSemiAutoCutTaskDetailDTOBuilder {
      private Long id;
      private String projectName;
      private String projectNumber;
      private String orderNumber;
      private LocalDateTime completeTime;
      private LocalDateTime askCompleteTime;
      private String userName;
      private String cutName;
      private String thickness;
      private String material;
      private Integer quantity;
      private Integer completeQuantity;
      private BigDecimal completeWeight;
      private LocalDateTime schedulingDate;
      private Long nestCutPlateId;
      private Long machinePartSchedulingId;
      private String thumbnailUrl;
      private Integer cuttingReportMethod;
      private Integer drillReportMethod;
      private Boolean boolCanAppReport;
      private List<SemiAutoCutPartDTO> semiAutoCutPartDTOList;
      private String plateHeight;
      private String plateWidth;
      private String fileNameNest;
      private String guid;
      private Integer cutCount;
      private Boolean boolPickingApproved;

      APPSemiAutoCutTaskDetailDTOBuilder() {
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder projectNumber(final String projectNumber) {
         this.projectNumber = projectNumber;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder cutName(final String cutName) {
         this.cutName = cutName;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder completeWeight(final BigDecimal completeWeight) {
         this.completeWeight = completeWeight;
         return this;
      }

      @JsonProperty("schedulingDate")
      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder schedulingDate(final LocalDateTime schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("nestCutPlateId")
      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder nestCutPlateId(final Long nestCutPlateId) {
         this.nestCutPlateId = nestCutPlateId;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder machinePartSchedulingId(final Long machinePartSchedulingId) {
         this.machinePartSchedulingId = machinePartSchedulingId;
         return this;
      }

      @JsonProperty("thumbnailUrl")
      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder thumbnailUrl(final String thumbnailUrl) {
         this.thumbnailUrl = thumbnailUrl;
         return this;
      }

      @JsonProperty("cuttingReportMethod")
      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder cuttingReportMethod(final Integer cuttingReportMethod) {
         this.cuttingReportMethod = cuttingReportMethod;
         return this;
      }

      @JsonProperty("drillReportMethod")
      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder drillReportMethod(final Integer drillReportMethod) {
         this.drillReportMethod = drillReportMethod;
         return this;
      }

      @JsonProperty("boolCanAppReport")
      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder boolCanAppReport(final Boolean boolCanAppReport) {
         this.boolCanAppReport = boolCanAppReport;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder semiAutoCutPartDTOList(final List<SemiAutoCutPartDTO> semiAutoCutPartDTOList) {
         this.semiAutoCutPartDTOList = semiAutoCutPartDTOList;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder plateHeight(final String plateHeight) {
         this.plateHeight = plateHeight;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder plateWidth(final String plateWidth) {
         this.plateWidth = plateWidth;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder fileNameNest(final String fileNameNest) {
         this.fileNameNest = fileNameNest;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder cutCount(final Integer cutCount) {
         this.cutCount = cutCount;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder boolPickingApproved(final Boolean boolPickingApproved) {
         this.boolPickingApproved = boolPickingApproved;
         return this;
      }

      public APPSemiAutoCutTaskDetailDTO build() {
         return new APPSemiAutoCutTaskDetailDTO(
            this.id,
            this.projectName,
            this.projectNumber,
            this.orderNumber,
            this.completeTime,
            this.askCompleteTime,
            this.userName,
            this.cutName,
            this.thickness,
            this.material,
            this.quantity,
            this.completeQuantity,
            this.completeWeight,
            this.schedulingDate,
            this.nestCutPlateId,
            this.machinePartSchedulingId,
            this.thumbnailUrl,
            this.cuttingReportMethod,
            this.drillReportMethod,
            this.boolCanAppReport,
            this.semiAutoCutPartDTOList,
            this.plateHeight,
            this.plateWidth,
            this.fileNameNest,
            this.guid,
            this.cutCount,
            this.boolPickingApproved
         );
      }

      @Override
      public String toString() {
         return "APPSemiAutoCutTaskDetailDTO.APPSemiAutoCutTaskDetailDTOBuilder(id="
            + this.id
            + ", projectName="
            + this.projectName
            + ", projectNumber="
            + this.projectNumber
            + ", orderNumber="
            + this.orderNumber
            + ", completeTime="
            + this.completeTime
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", userName="
            + this.userName
            + ", cutName="
            + this.cutName
            + ", thickness="
            + this.thickness
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeWeight="
            + this.completeWeight
            + ", schedulingDate="
            + this.schedulingDate
            + ", nestCutPlateId="
            + this.nestCutPlateId
            + ", machinePartSchedulingId="
            + this.machinePartSchedulingId
            + ", thumbnailUrl="
            + this.thumbnailUrl
            + ", cuttingReportMethod="
            + this.cuttingReportMethod
            + ", drillReportMethod="
            + this.drillReportMethod
            + ", boolCanAppReport="
            + this.boolCanAppReport
            + ", semiAutoCutPartDTOList="
            + this.semiAutoCutPartDTOList
            + ", plateHeight="
            + this.plateHeight
            + ", plateWidth="
            + this.plateWidth
            + ", fileNameNest="
            + this.fileNameNest
            + ", guid="
            + this.guid
            + ", cutCount="
            + this.cutCount
            + ", boolPickingApproved="
            + this.boolPickingApproved
            + ")";
      }
   }
}
