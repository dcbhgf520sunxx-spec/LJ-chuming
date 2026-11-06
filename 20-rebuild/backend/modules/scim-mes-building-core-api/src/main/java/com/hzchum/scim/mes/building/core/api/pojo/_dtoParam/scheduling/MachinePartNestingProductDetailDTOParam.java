package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;

@ApiModel(value = "MachinePartNestingProductDetailDTOParam", description = "零件套料排产零件查询")
public class MachinePartNestingProductDetailDTOParam {
   @ApiModelProperty("工单号集合")
   @JsonProperty("taskOrderIds")
   @JSONField(name = "taskOrderIds")
   private List<Long> taskOrderIds;
   @ApiModelProperty("年月集合")
   @JsonProperty("monthList")
   @JSONField(name = "monthList")
   private List<Long> monthList;
   @ApiModelProperty("项目id")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   private List<Long> projectIds;
   @ApiModelProperty("生产组id")
   @JsonProperty("groupsIds")
   @JSONField(name = "groupsIds")
   private List<Long> groupsIds;
   @ApiModelProperty("车间id")
   @JsonProperty("workshopIds")
   @JSONField(name = "workshopIds")
   private List<Long> workshopIds;
   @ApiModelProperty(name = "yearMonthArray", value = "日期")
   @JsonProperty("yearMonthArray")
   @JSONField(name = "yearMonthArray")
   private List<Long> yearMonthArray;
   @ApiModelProperty("组装后的日期")
   @JsonProperty("yearMonth")
   @JSONField(name = "yearMonth")
   private String yearMonth;
   @ApiModelProperty(name = "yearMonthArrayStr", value = "日期")
   @JsonProperty("yearMonthArrayStr")
   @JSONField(name = "yearMonthArrayStr")
   private List<String> yearMonthArrayStr;
   @ApiModelProperty("零件类型")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   private String partType;
   @ApiModelProperty("零件来源")
   @JsonProperty("partSource")
   @JSONField(name = "partSource")
   private String partSource;
   @ApiModelProperty("厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private List<String> thick;
   @ApiModelProperty("最小宽度")
   @JsonProperty("minWidth")
   @JSONField(name = "minWidth")
   private BigDecimal minWidth;
   @ApiModelProperty("最大宽度")
   @JsonProperty("maxWidth")
   @JSONField(name = "maxWidth")
   private BigDecimal maxWidth;
   @ApiModelProperty("最小长度")
   @JsonProperty("minLength")
   @JSONField(name = "minLength")
   private BigDecimal minLength;
   @ApiModelProperty("最大长度")
   @JsonProperty("maxLength")
   @JSONField(name = "maxLength")
   private BigDecimal maxLength;
   @ApiModelProperty("零件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty("是否有图纸")
   @JsonProperty("boolDxfEnum")
   @JSONField(name = "boolDxfEnum")
   private Boolean boolDxfEnum;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private List<Integer> taskTypeEnum;
   @ApiModelProperty(name = "sendNestingStatus", value = "下发状态")
   @JsonProperty("sendNestingStatus")
   @JSONField(name = "sendNestingStatus")
   private Boolean sendNestingStatus;
   @ApiModelProperty("页码")
   @JsonProperty("pageNumber")
   @JSONField(name = "pageNumber")
   private Integer pageNumber;
   @ApiModelProperty("每页数量")
   @JsonProperty("pageSize")
   @JSONField(name = "pageSize")
   private Integer pageSize;
   @ApiModelProperty("是否矩形有空")
   @JsonProperty("isRectangle")
   @JSONField(name = "isRectangle")
   private List<Integer> isRectangle;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "零件类型 1.零件板 2.翼腹板 4成品型材 ")
   @JsonProperty("steelPlateTypeEnum")
   @JSONField(name = "steelPlateTypeEnum")
   @NotEmpty(message = "零件类型不能为空")
   private List<Integer> steelPlateTypeEnum;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   private Boolean boolProcess;
   @ApiModelProperty("下发到套料软件状态")
   private Integer issuedToNestingSoftwareStatus;
   @ApiModelProperty("零件材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty("是否直发件(0:否,1:是)")
   private Boolean boolSendDirectly;

   public static MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder builder() {
      return new MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder();
   }

   public MachinePartNestingProductDetailDTOParam(
      final List<Long> taskOrderIds,
      final List<Long> monthList,
      final List<Long> projectIds,
      final List<Long> groupsIds,
      final List<Long> workshopIds,
      final List<Long> yearMonthArray,
      final String yearMonth,
      final List<String> yearMonthArrayStr,
      final String partType,
      final String partSource,
      final List<String> thick,
      final BigDecimal minWidth,
      final BigDecimal maxWidth,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final String serialNumber,
      final Boolean boolDxfEnum,
      final List<Integer> taskTypeEnum,
      final Boolean sendNestingStatus,
      final Integer pageNumber,
      final Integer pageSize,
      final List<Integer> isRectangle,
      final List<Integer> steelPlateTypeEnum,
      final String specification,
      final Boolean boolProcess,
      final Integer issuedToNestingSoftwareStatus,
      final String material,
      final Boolean boolSendDirectly
   ) {
      this.taskOrderIds = taskOrderIds;
      this.monthList = monthList;
      this.projectIds = projectIds;
      this.groupsIds = groupsIds;
      this.workshopIds = workshopIds;
      this.yearMonthArray = yearMonthArray;
      this.yearMonth = yearMonth;
      this.yearMonthArrayStr = yearMonthArrayStr;
      this.partType = partType;
      this.partSource = partSource;
      this.thick = thick;
      this.minWidth = minWidth;
      this.maxWidth = maxWidth;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.serialNumber = serialNumber;
      this.boolDxfEnum = boolDxfEnum;
      this.taskTypeEnum = taskTypeEnum;
      this.sendNestingStatus = sendNestingStatus;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.isRectangle = isRectangle;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.specification = specification;
      this.boolProcess = boolProcess;
      this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
      this.material = material;
      this.boolSendDirectly = boolSendDirectly;
   }

   public MachinePartNestingProductDetailDTOParam() {
   }

   public List<Long> getTaskOrderIds() {
      return this.taskOrderIds;
   }

   public List<Long> getMonthList() {
      return this.monthList;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public List<Long> getGroupsIds() {
      return this.groupsIds;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public List<Long> getYearMonthArray() {
      return this.yearMonthArray;
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public List<String> getYearMonthArrayStr() {
      return this.yearMonthArrayStr;
   }

   public String getPartType() {
      return this.partType;
   }

   public String getPartSource() {
      return this.partSource;
   }

   public List<String> getThick() {
      return this.thick;
   }

   public BigDecimal getMinWidth() {
      return this.minWidth;
   }

   public BigDecimal getMaxWidth() {
      return this.maxWidth;
   }

   public BigDecimal getMinLength() {
      return this.minLength;
   }

   public BigDecimal getMaxLength() {
      return this.maxLength;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Boolean getBoolDxfEnum() {
      return this.boolDxfEnum;
   }

   public List<Integer> getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Boolean getSendNestingStatus() {
      return this.sendNestingStatus;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public List<Integer> getIsRectangle() {
      return this.isRectangle;
   }

   public List<Integer> getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Integer getIssuedToNestingSoftwareStatus() {
      return this.issuedToNestingSoftwareStatus;
   }

   public String getMaterial() {
      return this.material;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   @JsonProperty("taskOrderIds")
   public MachinePartNestingProductDetailDTOParam setTaskOrderIds(final List<Long> taskOrderIds) {
      this.taskOrderIds = taskOrderIds;
      return this;
   }

   @JsonProperty("monthList")
   public MachinePartNestingProductDetailDTOParam setMonthList(final List<Long> monthList) {
      this.monthList = monthList;
      return this;
   }

   @JsonProperty("projectIds")
   public MachinePartNestingProductDetailDTOParam setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("groupsIds")
   public MachinePartNestingProductDetailDTOParam setGroupsIds(final List<Long> groupsIds) {
      this.groupsIds = groupsIds;
      return this;
   }

   @JsonProperty("workshopIds")
   public MachinePartNestingProductDetailDTOParam setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   @JsonProperty("yearMonthArray")
   public MachinePartNestingProductDetailDTOParam setYearMonthArray(final List<Long> yearMonthArray) {
      this.yearMonthArray = yearMonthArray;
      return this;
   }

   @JsonProperty("yearMonth")
   public MachinePartNestingProductDetailDTOParam setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
      return this;
   }

   @JsonProperty("yearMonthArrayStr")
   public MachinePartNestingProductDetailDTOParam setYearMonthArrayStr(final List<String> yearMonthArrayStr) {
      this.yearMonthArrayStr = yearMonthArrayStr;
      return this;
   }

   @JsonProperty("partType")
   public MachinePartNestingProductDetailDTOParam setPartType(final String partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("partSource")
   public MachinePartNestingProductDetailDTOParam setPartSource(final String partSource) {
      this.partSource = partSource;
      return this;
   }

   @JsonProperty("thick")
   public MachinePartNestingProductDetailDTOParam setThick(final List<String> thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("minWidth")
   public MachinePartNestingProductDetailDTOParam setMinWidth(final BigDecimal minWidth) {
      this.minWidth = minWidth;
      return this;
   }

   @JsonProperty("maxWidth")
   public MachinePartNestingProductDetailDTOParam setMaxWidth(final BigDecimal maxWidth) {
      this.maxWidth = maxWidth;
      return this;
   }

   @JsonProperty("minLength")
   public MachinePartNestingProductDetailDTOParam setMinLength(final BigDecimal minLength) {
      this.minLength = minLength;
      return this;
   }

   @JsonProperty("maxLength")
   public MachinePartNestingProductDetailDTOParam setMaxLength(final BigDecimal maxLength) {
      this.maxLength = maxLength;
      return this;
   }

   @JsonProperty("serialNumber")
   public MachinePartNestingProductDetailDTOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("boolDxfEnum")
   public MachinePartNestingProductDetailDTOParam setBoolDxfEnum(final Boolean boolDxfEnum) {
      this.boolDxfEnum = boolDxfEnum;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MachinePartNestingProductDetailDTOParam setTaskTypeEnum(final List<Integer> taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("sendNestingStatus")
   public MachinePartNestingProductDetailDTOParam setSendNestingStatus(final Boolean sendNestingStatus) {
      this.sendNestingStatus = sendNestingStatus;
      return this;
   }

   @JsonProperty("pageNumber")
   public MachinePartNestingProductDetailDTOParam setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
      return this;
   }

   @JsonProperty("pageSize")
   public MachinePartNestingProductDetailDTOParam setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
      return this;
   }

   @JsonProperty("isRectangle")
   public MachinePartNestingProductDetailDTOParam setIsRectangle(final List<Integer> isRectangle) {
      this.isRectangle = isRectangle;
      return this;
   }

   @JsonProperty("steelPlateTypeEnum")
   public MachinePartNestingProductDetailDTOParam setSteelPlateTypeEnum(final List<Integer> steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @JsonProperty("specification")
   public MachinePartNestingProductDetailDTOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("boolProcess")
   public MachinePartNestingProductDetailDTOParam setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   public MachinePartNestingProductDetailDTOParam setIssuedToNestingSoftwareStatus(final Integer issuedToNestingSoftwareStatus) {
      this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
      return this;
   }

   @JsonProperty("material")
   public MachinePartNestingProductDetailDTOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MachinePartNestingProductDetailDTOParam setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingProductDetailDTOParam(taskOrderIds="
         + this.getTaskOrderIds()
         + ", monthList="
         + this.getMonthList()
         + ", projectIds="
         + this.getProjectIds()
         + ", groupsIds="
         + this.getGroupsIds()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", yearMonthArray="
         + this.getYearMonthArray()
         + ", yearMonth="
         + this.getYearMonth()
         + ", yearMonthArrayStr="
         + this.getYearMonthArrayStr()
         + ", partType="
         + this.getPartType()
         + ", partSource="
         + this.getPartSource()
         + ", thick="
         + this.getThick()
         + ", minWidth="
         + this.getMinWidth()
         + ", maxWidth="
         + this.getMaxWidth()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", boolDxfEnum="
         + this.getBoolDxfEnum()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", sendNestingStatus="
         + this.getSendNestingStatus()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", isRectangle="
         + this.getIsRectangle()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", specification="
         + this.getSpecification()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", issuedToNestingSoftwareStatus="
         + this.getIssuedToNestingSoftwareStatus()
         + ", material="
         + this.getMaterial()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingProductDetailDTOParam)) {
         return false;
      }

      MachinePartNestingProductDetailDTOParam other = (MachinePartNestingProductDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolDxfEnum = this.getBoolDxfEnum();
      Object other$boolDxfEnum = other.getBoolDxfEnum();
      if (this$boolDxfEnum == null ? other$boolDxfEnum == null : this$boolDxfEnum.equals(other$boolDxfEnum)) {
         Object this$sendNestingStatus = this.getSendNestingStatus();
         Object other$sendNestingStatus = other.getSendNestingStatus();
         if (this$sendNestingStatus == null ? other$sendNestingStatus == null : this$sendNestingStatus.equals(other$sendNestingStatus)) {
            Object this$pageNumber = this.getPageNumber();
            Object other$pageNumber = other.getPageNumber();
            if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
               Object this$pageSize = this.getPageSize();
               Object other$pageSize = other.getPageSize();
               if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                  Object this$boolProcess = this.getBoolProcess();
                  Object other$boolProcess = other.getBoolProcess();
                  if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                     Object this$issuedToNestingSoftwareStatus = this.getIssuedToNestingSoftwareStatus();
                     Object other$issuedToNestingSoftwareStatus = other.getIssuedToNestingSoftwareStatus();
                     if (this$issuedToNestingSoftwareStatus == null
                        ? other$issuedToNestingSoftwareStatus == null
                        : this$issuedToNestingSoftwareStatus.equals(other$issuedToNestingSoftwareStatus)) {
                        Object this$boolSendDirectly = this.getBoolSendDirectly();
                        Object other$boolSendDirectly = other.getBoolSendDirectly();
                        if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                           Object this$taskOrderIds = this.getTaskOrderIds();
                           Object other$taskOrderIds = other.getTaskOrderIds();
                           if (this$taskOrderIds == null ? other$taskOrderIds == null : this$taskOrderIds.equals(other$taskOrderIds)) {
                              Object this$monthList = this.getMonthList();
                              Object other$monthList = other.getMonthList();
                              if (this$monthList == null ? other$monthList == null : this$monthList.equals(other$monthList)) {
                                 Object this$projectIds = this.getProjectIds();
                                 Object other$projectIds = other.getProjectIds();
                                 if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                    Object this$groupsIds = this.getGroupsIds();
                                    Object other$groupsIds = other.getGroupsIds();
                                    if (this$groupsIds == null ? other$groupsIds == null : this$groupsIds.equals(other$groupsIds)) {
                                       Object this$workshopIds = this.getWorkshopIds();
                                       Object other$workshopIds = other.getWorkshopIds();
                                       if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                                          Object this$yearMonthArray = this.getYearMonthArray();
                                          Object other$yearMonthArray = other.getYearMonthArray();
                                          if (this$yearMonthArray == null ? other$yearMonthArray == null : this$yearMonthArray.equals(other$yearMonthArray)) {
                                             Object this$yearMonth = this.getYearMonth();
                                             Object other$yearMonth = other.getYearMonth();
                                             if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
                                                Object this$yearMonthArrayStr = this.getYearMonthArrayStr();
                                                Object other$yearMonthArrayStr = other.getYearMonthArrayStr();
                                                if (this$yearMonthArrayStr == null
                                                   ? other$yearMonthArrayStr == null
                                                   : this$yearMonthArrayStr.equals(other$yearMonthArrayStr)) {
                                                   Object this$partType = this.getPartType();
                                                   Object other$partType = other.getPartType();
                                                   if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                                                      Object this$partSource = this.getPartSource();
                                                      Object other$partSource = other.getPartSource();
                                                      if (this$partSource == null ? other$partSource == null : this$partSource.equals(other$partSource)) {
                                                         Object this$thick = this.getThick();
                                                         Object other$thick = other.getThick();
                                                         if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                            Object this$minWidth = this.getMinWidth();
                                                            Object other$minWidth = other.getMinWidth();
                                                            if (this$minWidth == null ? other$minWidth == null : this$minWidth.equals(other$minWidth)) {
                                                               Object this$maxWidth = this.getMaxWidth();
                                                               Object other$maxWidth = other.getMaxWidth();
                                                               if (this$maxWidth == null ? other$maxWidth == null : this$maxWidth.equals(other$maxWidth)) {
                                                                  Object this$minLength = this.getMinLength();
                                                                  Object other$minLength = other.getMinLength();
                                                                  if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)
                                                                     )
                                                                   {
                                                                     Object this$maxLength = this.getMaxLength();
                                                                     Object other$maxLength = other.getMaxLength();
                                                                     if (this$maxLength == null
                                                                        ? other$maxLength == null
                                                                        : this$maxLength.equals(other$maxLength)) {
                                                                        Object this$serialNumber = this.getSerialNumber();
                                                                        Object other$serialNumber = other.getSerialNumber();
                                                                        if (this$serialNumber == null
                                                                           ? other$serialNumber == null
                                                                           : this$serialNumber.equals(other$serialNumber)) {
                                                                           Object this$taskTypeEnum = this.getTaskTypeEnum();
                                                                           Object other$taskTypeEnum = other.getTaskTypeEnum();
                                                                           if (this$taskTypeEnum == null
                                                                              ? other$taskTypeEnum == null
                                                                              : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                                                              Object this$isRectangle = this.getIsRectangle();
                                                                              Object other$isRectangle = other.getIsRectangle();
                                                                              if (this$isRectangle == null
                                                                                 ? other$isRectangle == null
                                                                                 : this$isRectangle.equals(other$isRectangle)) {
                                                                                 Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                                                                                 Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                                                                                 if (this$steelPlateTypeEnum == null
                                                                                    ? other$steelPlateTypeEnum == null
                                                                                    : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                                                                                    Object this$specification = this.getSpecification();
                                                                                    Object other$specification = other.getSpecification();
                                                                                    if (this$specification == null
                                                                                       ? other$specification == null
                                                                                       : this$specification.equals(other$specification)) {
                                                                                       Object this$material = this.getMaterial();
                                                                                       Object other$material = other.getMaterial();
                                                                                       return this$material == null
                                                                                          ? other$material == null
                                                                                          : this$material.equals(other$material);
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MachinePartNestingProductDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolDxfEnum = this.getBoolDxfEnum();
      result = result * 59 + ($boolDxfEnum == null ? 43 : $boolDxfEnum.hashCode());
      Object $sendNestingStatus = this.getSendNestingStatus();
      result = result * 59 + ($sendNestingStatus == null ? 43 : $sendNestingStatus.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $issuedToNestingSoftwareStatus = this.getIssuedToNestingSoftwareStatus();
      result = result * 59 + ($issuedToNestingSoftwareStatus == null ? 43 : $issuedToNestingSoftwareStatus.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $taskOrderIds = this.getTaskOrderIds();
      result = result * 59 + ($taskOrderIds == null ? 43 : $taskOrderIds.hashCode());
      Object $monthList = this.getMonthList();
      result = result * 59 + ($monthList == null ? 43 : $monthList.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $groupsIds = this.getGroupsIds();
      result = result * 59 + ($groupsIds == null ? 43 : $groupsIds.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $yearMonthArray = this.getYearMonthArray();
      result = result * 59 + ($yearMonthArray == null ? 43 : $yearMonthArray.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $yearMonthArrayStr = this.getYearMonthArrayStr();
      result = result * 59 + ($yearMonthArrayStr == null ? 43 : $yearMonthArrayStr.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $partSource = this.getPartSource();
      result = result * 59 + ($partSource == null ? 43 : $partSource.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $minWidth = this.getMinWidth();
      result = result * 59 + ($minWidth == null ? 43 : $minWidth.hashCode());
      Object $maxWidth = this.getMaxWidth();
      result = result * 59 + ($maxWidth == null ? 43 : $maxWidth.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      result = result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $isRectangle = this.getIsRectangle();
      result = result * 59 + ($isRectangle == null ? 43 : $isRectangle.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   public static class MachinePartNestingProductDetailDTOParamBuilder {
      private List<Long> taskOrderIds;
      private List<Long> monthList;
      private List<Long> projectIds;
      private List<Long> groupsIds;
      private List<Long> workshopIds;
      private List<Long> yearMonthArray;
      private String yearMonth;
      private List<String> yearMonthArrayStr;
      private String partType;
      private String partSource;
      private List<String> thick;
      private BigDecimal minWidth;
      private BigDecimal maxWidth;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private String serialNumber;
      private Boolean boolDxfEnum;
      private List<Integer> taskTypeEnum;
      private Boolean sendNestingStatus;
      private Integer pageNumber;
      private Integer pageSize;
      private List<Integer> isRectangle;
      private List<Integer> steelPlateTypeEnum;
      private String specification;
      private Boolean boolProcess;
      private Integer issuedToNestingSoftwareStatus;
      private String material;
      private Boolean boolSendDirectly;

      MachinePartNestingProductDetailDTOParamBuilder() {
      }

      @JsonProperty("taskOrderIds")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder taskOrderIds(final List<Long> taskOrderIds) {
         this.taskOrderIds = taskOrderIds;
         return this;
      }

      @JsonProperty("monthList")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder monthList(final List<Long> monthList) {
         this.monthList = monthList;
         return this;
      }

      @JsonProperty("projectIds")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("groupsIds")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder groupsIds(final List<Long> groupsIds) {
         this.groupsIds = groupsIds;
         return this;
      }

      @JsonProperty("workshopIds")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      @JsonProperty("yearMonthArray")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder yearMonthArray(final List<Long> yearMonthArray) {
         this.yearMonthArray = yearMonthArray;
         return this;
      }

      @JsonProperty("yearMonth")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder yearMonth(final String yearMonth) {
         this.yearMonth = yearMonth;
         return this;
      }

      @JsonProperty("yearMonthArrayStr")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder yearMonthArrayStr(final List<String> yearMonthArrayStr) {
         this.yearMonthArrayStr = yearMonthArrayStr;
         return this;
      }

      @JsonProperty("partType")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder partType(final String partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("partSource")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder partSource(final String partSource) {
         this.partSource = partSource;
         return this;
      }

      @JsonProperty("thick")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder thick(final List<String> thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("minWidth")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder minWidth(final BigDecimal minWidth) {
         this.minWidth = minWidth;
         return this;
      }

      @JsonProperty("maxWidth")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder maxWidth(final BigDecimal maxWidth) {
         this.maxWidth = maxWidth;
         return this;
      }

      @JsonProperty("minLength")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      @JsonProperty("maxLength")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      @JsonProperty("serialNumber")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("boolDxfEnum")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder boolDxfEnum(final Boolean boolDxfEnum) {
         this.boolDxfEnum = boolDxfEnum;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder taskTypeEnum(final List<Integer> taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("sendNestingStatus")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder sendNestingStatus(final Boolean sendNestingStatus) {
         this.sendNestingStatus = sendNestingStatus;
         return this;
      }

      @JsonProperty("pageNumber")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      @JsonProperty("pageSize")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder pageSize(final Integer pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      @JsonProperty("isRectangle")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder isRectangle(final List<Integer> isRectangle) {
         this.isRectangle = isRectangle;
         return this;
      }

      @JsonProperty("steelPlateTypeEnum")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder steelPlateTypeEnum(final List<Integer> steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      @JsonProperty("specification")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("boolProcess")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder issuedToNestingSoftwareStatus(
         final Integer issuedToNestingSoftwareStatus
      ) {
         this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
         return this;
      }

      @JsonProperty("material")
      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public MachinePartNestingProductDetailDTOParam build() {
         return new MachinePartNestingProductDetailDTOParam(
            this.taskOrderIds,
            this.monthList,
            this.projectIds,
            this.groupsIds,
            this.workshopIds,
            this.yearMonthArray,
            this.yearMonth,
            this.yearMonthArrayStr,
            this.partType,
            this.partSource,
            this.thick,
            this.minWidth,
            this.maxWidth,
            this.minLength,
            this.maxLength,
            this.serialNumber,
            this.boolDxfEnum,
            this.taskTypeEnum,
            this.sendNestingStatus,
            this.pageNumber,
            this.pageSize,
            this.isRectangle,
            this.steelPlateTypeEnum,
            this.specification,
            this.boolProcess,
            this.issuedToNestingSoftwareStatus,
            this.material,
            this.boolSendDirectly
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingProductDetailDTOParam.MachinePartNestingProductDetailDTOParamBuilder(taskOrderIds="
            + this.taskOrderIds
            + ", monthList="
            + this.monthList
            + ", projectIds="
            + this.projectIds
            + ", groupsIds="
            + this.groupsIds
            + ", workshopIds="
            + this.workshopIds
            + ", yearMonthArray="
            + this.yearMonthArray
            + ", yearMonth="
            + this.yearMonth
            + ", yearMonthArrayStr="
            + this.yearMonthArrayStr
            + ", partType="
            + this.partType
            + ", partSource="
            + this.partSource
            + ", thick="
            + this.thick
            + ", minWidth="
            + this.minWidth
            + ", maxWidth="
            + this.maxWidth
            + ", minLength="
            + this.minLength
            + ", maxLength="
            + this.maxLength
            + ", serialNumber="
            + this.serialNumber
            + ", boolDxfEnum="
            + this.boolDxfEnum
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", sendNestingStatus="
            + this.sendNestingStatus
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ", isRectangle="
            + this.isRectangle
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", specification="
            + this.specification
            + ", boolProcess="
            + this.boolProcess
            + ", issuedToNestingSoftwareStatus="
            + this.issuedToNestingSoftwareStatus
            + ", material="
            + this.material
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ")";
      }
   }
}
