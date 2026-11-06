package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CrmBiddingPlatformWarehousingDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "serial_number", notes = "备案编号")
   private String serialNumber;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "部门名称", notes = "部门名称")
   private String departmentName;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "biddingPlatformName", value = "招标平台名称", notes = "招标平台名称")
   private String biddingPlatformName;
   @ApiModelProperty(name = "reasonForRegistration", value = "报名事由", notes = "报名事由")
   private String reasonForRegistration;
   @ApiModelProperty(name = "countryId", value = "国家id", notes = "国家id")
   private Long countryId;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "省份id", notes = "省份id")
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   private Long cityId;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   private String regionName;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "attachmentIds", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   private String acceptanceAddress;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "CALockDate", value = "锁定日期", notes = "锁定日期")
   private LocalDate caLockDate;
   @ApiModelProperty(name = "platformFees", value = "平台费用", notes = "平台费用")
   private BigDecimal platformFees;
   @ApiModelProperty(name = "cost", value = "费用(万元)", notes = "备案费用")
   private BigDecimal cost;

   public static CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder builder() {
      return new CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder();
   }

   public CrmBiddingPlatformWarehousingDetailDTO() {
   }

   public CrmBiddingPlatformWarehousingDetailDTO(
      final Long id,
      final String serialNumber,
      final Long informantUserId,
      final String informantUserName,
      final Long departmentId,
      final String departmentName,
      final LocalDateTime informantDateTime,
      final String biddingPlatformName,
      final String reasonForRegistration,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final List<Long> regionList,
      final String regionNameList,
      final String address,
      final List<AttachmentDTO> attachmentIds,
      final List<AttachmentDTO> attachmentDTOList,
      final String acceptanceAddress,
      final LocalDateTime deadlineForAcceptanceTime,
      final String remark,
      final LocalDate caLockDate,
      final BigDecimal platformFees
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.informantDateTime = informantDateTime;
      this.biddingPlatformName = biddingPlatformName;
      this.reasonForRegistration = reasonForRegistration;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.regionList = regionList;
      this.regionNameList = regionNameList;
      this.address = address;
      this.attachmentIds = attachmentIds;
      this.attachmentDTOList = attachmentDTOList;
      this.acceptanceAddress = acceptanceAddress;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.remark = remark;
      this.caLockDate = caLockDate;
      this.platformFees = platformFees;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getBiddingPlatformName() {
      return this.biddingPlatformName;
   }

   public String getReasonForRegistration() {
      return this.reasonForRegistration;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public String getAddress() {
      return this.address;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public String getAcceptanceAddress() {
      return this.acceptanceAddress;
   }

   public LocalDateTime getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDate getCaLockDate() {
      return this.caLockDate;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public BigDecimal getPlatformFees() {
      return this.platformFees;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setBiddingPlatformName(final String biddingPlatformName) {
      this.biddingPlatformName = biddingPlatformName;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setReasonForRegistration(final String reasonForRegistration) {
      this.reasonForRegistration = reasonForRegistration;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setAcceptanceAddress(final String acceptanceAddress) {
      this.acceptanceAddress = acceptanceAddress;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setCaLockDate(final LocalDate caLockDate) {
      this.caLockDate = caLockDate;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setCost(final BigDecimal cost) {
      this.cost = cost;
      return this;
   }

   public CrmBiddingPlatformWarehousingDetailDTO setPlatformFees(final BigDecimal platformFees) {
      this.platformFees = platformFees;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBiddingPlatformWarehousingDetailDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", biddingPlatformName="
         + this.getBiddingPlatformName()
         + ", reasonForRegistration="
         + this.getReasonForRegistration()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", regionList="
         + this.getRegionList()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", address="
         + this.getAddress()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", acceptanceAddress="
         + this.getAcceptanceAddress()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", remark="
         + this.getRemark()
         + ", caLockDate="
         + this.getCaLockDate()
         + ", platformFees="
         + this.getPlatformFees()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBiddingPlatformWarehousingDetailDTO)) {
         return false;
      }

      CrmBiddingPlatformWarehousingDetailDTO other = (CrmBiddingPlatformWarehousingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantUserId = this.getInformantUserId();
         Object other$informantUserId = other.getInformantUserId();
         if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
            Object this$departmentId = this.getDepartmentId();
            Object other$departmentId = other.getDepartmentId();
            if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
               Object this$countryId = this.getCountryId();
               Object other$countryId = other.getCountryId();
               if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
                  Object this$provinceId = this.getProvinceId();
                  Object other$provinceId = other.getProvinceId();
                  if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                     Object this$cityId = this.getCityId();
                     Object other$cityId = other.getCityId();
                     if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                        Object this$regionId = this.getRegionId();
                        Object other$regionId = other.getRegionId();
                        if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$informantUserName = this.getInformantUserName();
                              Object other$informantUserName = other.getInformantUserName();
                              if (this$informantUserName == null ? other$informantUserName == null : this$informantUserName.equals(other$informantUserName)) {
                                 Object this$departmentName = this.getDepartmentName();
                                 Object other$departmentName = other.getDepartmentName();
                                 if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                                    Object this$informantDateTime = this.getInformantDateTime();
                                    Object other$informantDateTime = other.getInformantDateTime();
                                    if (this$informantDateTime == null
                                       ? other$informantDateTime == null
                                       : this$informantDateTime.equals(other$informantDateTime)) {
                                       Object this$biddingPlatformName = this.getBiddingPlatformName();
                                       Object other$biddingPlatformName = other.getBiddingPlatformName();
                                       if (this$biddingPlatformName == null
                                          ? other$biddingPlatformName == null
                                          : this$biddingPlatformName.equals(other$biddingPlatformName)) {
                                          Object this$reasonForRegistration = this.getReasonForRegistration();
                                          Object other$reasonForRegistration = other.getReasonForRegistration();
                                          if (this$reasonForRegistration == null
                                             ? other$reasonForRegistration == null
                                             : this$reasonForRegistration.equals(other$reasonForRegistration)) {
                                             Object this$countryName = this.getCountryName();
                                             Object other$countryName = other.getCountryName();
                                             if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                                                Object this$provinceName = this.getProvinceName();
                                                Object other$provinceName = other.getProvinceName();
                                                if (this$provinceName == null ? other$provinceName == null : this$provinceName.equals(other$provinceName)) {
                                                   Object this$cityName = this.getCityName();
                                                   Object other$cityName = other.getCityName();
                                                   if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                                      Object this$regionName = this.getRegionName();
                                                      Object other$regionName = other.getRegionName();
                                                      if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                                         Object this$regionList = this.getRegionList();
                                                         Object other$regionList = other.getRegionList();
                                                         if (this$regionList == null ? other$regionList == null : this$regionList.equals(other$regionList)) {
                                                            Object this$regionNameList = this.getRegionNameList();
                                                            Object other$regionNameList = other.getRegionNameList();
                                                            if (this$regionNameList == null
                                                               ? other$regionNameList == null
                                                               : this$regionNameList.equals(other$regionNameList)) {
                                                               Object this$address = this.getAddress();
                                                               Object other$address = other.getAddress();
                                                               if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                                  Object this$attachmentIds = this.getAttachmentIds();
                                                                  Object other$attachmentIds = other.getAttachmentIds();
                                                                  if (this$attachmentIds == null
                                                                     ? other$attachmentIds == null
                                                                     : this$attachmentIds.equals(other$attachmentIds)) {
                                                                     Object this$attachmentDTOList = this.getAttachmentDTOList();
                                                                     Object other$attachmentDTOList = other.getAttachmentDTOList();
                                                                     if (this$attachmentDTOList == null
                                                                        ? other$attachmentDTOList == null
                                                                        : this$attachmentDTOList.equals(other$attachmentDTOList)) {
                                                                        Object this$acceptanceAddress = this.getAcceptanceAddress();
                                                                        Object other$acceptanceAddress = other.getAcceptanceAddress();
                                                                        if (this$acceptanceAddress == null
                                                                           ? other$acceptanceAddress == null
                                                                           : this$acceptanceAddress.equals(other$acceptanceAddress)) {
                                                                           Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                                                                           Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                                                                           if (this$deadlineForAcceptanceTime == null
                                                                              ? other$deadlineForAcceptanceTime == null
                                                                              : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)
                                                                                 )
                                                                               {
                                                                                 Object this$caLockDate = this.getCaLockDate();
                                                                                 Object other$caLockDate = other.getCaLockDate();
                                                                                 if (this$caLockDate == null
                                                                                    ? other$caLockDate == null
                                                                                    : this$caLockDate.equals(other$caLockDate)) {
                                                                                    Object this$platformFees = this.getPlatformFees();
                                                                                    Object other$platformFees = other.getPlatformFees();
                                                                                    return this$platformFees == null
                                                                                       ? other$platformFees == null
                                                                                       : this$platformFees.equals(other$platformFees);
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
      return other instanceof CrmBiddingPlatformWarehousingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $biddingPlatformName = this.getBiddingPlatformName();
      result = result * 59 + ($biddingPlatformName == null ? 43 : $biddingPlatformName.hashCode());
      Object $reasonForRegistration = this.getReasonForRegistration();
      result = result * 59 + ($reasonForRegistration == null ? 43 : $reasonForRegistration.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $regionList = this.getRegionList();
      result = result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $acceptanceAddress = this.getAcceptanceAddress();
      result = result * 59 + ($acceptanceAddress == null ? 43 : $acceptanceAddress.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $caLockDate = this.getCaLockDate();
      result = result * 59 + ($caLockDate == null ? 43 : $caLockDate.hashCode());
      Object $platformFees = this.getPlatformFees();
      return result * 59 + ($platformFees == null ? 43 : $platformFees.hashCode());
   }

   public static class CrmBiddingPlatformWarehousingDetailDTOBuilder {
      private Long id;
      private String serialNumber;
      private Long informantUserId;
      private String informantUserName;
      private Long departmentId;
      private String departmentName;
      private LocalDateTime informantDateTime;
      private String biddingPlatformName;
      private String reasonForRegistration;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private List<Long> regionList;
      private String regionNameList;
      private String address;
      private List<AttachmentDTO> attachmentIds;
      private List<AttachmentDTO> attachmentDTOList;
      private String acceptanceAddress;
      private LocalDateTime deadlineForAcceptanceTime;
      private String remark;
      private LocalDate caLockDate;
      private BigDecimal platformFees;

      CrmBiddingPlatformWarehousingDetailDTOBuilder() {
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder biddingPlatformName(final String biddingPlatformName) {
         this.biddingPlatformName = biddingPlatformName;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder reasonForRegistration(final String reasonForRegistration) {
         this.reasonForRegistration = reasonForRegistration;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder regionList(final List<Long> regionList) {
         this.regionList = regionList;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder attachmentIds(final List<AttachmentDTO> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder acceptanceAddress(final String acceptanceAddress) {
         this.acceptanceAddress = acceptanceAddress;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder deadlineForAcceptanceTime(
         final LocalDateTime deadlineForAcceptanceTime
      ) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder caLockDate(final LocalDate caLockDate) {
         this.caLockDate = caLockDate;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder platformFees(final BigDecimal platformFees) {
         this.platformFees = platformFees;
         return this;
      }

      public CrmBiddingPlatformWarehousingDetailDTO build() {
         return new CrmBiddingPlatformWarehousingDetailDTO(
            this.id,
            this.serialNumber,
            this.informantUserId,
            this.informantUserName,
            this.departmentId,
            this.departmentName,
            this.informantDateTime,
            this.biddingPlatformName,
            this.reasonForRegistration,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.regionList,
            this.regionNameList,
            this.address,
            this.attachmentIds,
            this.attachmentDTOList,
            this.acceptanceAddress,
            this.deadlineForAcceptanceTime,
            this.remark,
            this.caLockDate,
            this.platformFees
         );
      }

      @Override
      public String toString() {
         return "CrmBiddingPlatformWarehousingDetailDTO.CrmBiddingPlatformWarehousingDetailDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", departmentId="
            + this.departmentId
            + ", departmentName="
            + this.departmentName
            + ", informantDateTime="
            + this.informantDateTime
            + ", biddingPlatformName="
            + this.biddingPlatformName
            + ", reasonForRegistration="
            + this.reasonForRegistration
            + ", countryId="
            + this.countryId
            + ", countryName="
            + this.countryName
            + ", provinceId="
            + this.provinceId
            + ", provinceName="
            + this.provinceName
            + ", cityId="
            + this.cityId
            + ", cityName="
            + this.cityName
            + ", regionId="
            + this.regionId
            + ", regionName="
            + this.regionName
            + ", regionList="
            + this.regionList
            + ", regionNameList="
            + this.regionNameList
            + ", address="
            + this.address
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ", acceptanceAddress="
            + this.acceptanceAddress
            + ", deadlineForAcceptanceTime="
            + this.deadlineForAcceptanceTime
            + ", remark="
            + this.remark
            + ", caLockDate="
            + this.caLockDate
            + ", platformFees="
            + this.platformFees
            + ")";
      }
   }
}
