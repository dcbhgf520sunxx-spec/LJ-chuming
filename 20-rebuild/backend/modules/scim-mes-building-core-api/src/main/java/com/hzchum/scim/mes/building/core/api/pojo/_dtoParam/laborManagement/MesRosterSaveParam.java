package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.EmployeeCategoryEnum;
import com.hzchum.scim.system.core.api.pojo.dto.UserSaveRequestVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel("花名册新增修改Param类")
public class MesRosterSaveParam {
   @NotNull(groups = Update.class, message = "id不能为空")
   @ApiModelProperty("主键ID")
   private Long id;
   @NotBlank(groups = {Add.class, Update.class}, message = "姓名不能为空")
   @Size(groups = {Add.class, Update.class}, max = 64, message = "姓名最大长度为64个字")
   @ApiModelProperty("姓名")
   private String name;
   @Pattern(groups = {Add.class, Update.class}, regexp = "^(\\d{17}(\\d|X))$", message = "无效的身份证号")
   @NotBlank(groups = {Add.class, Update.class}, message = "身份证号不能为空")
   @ApiModelProperty("身份证号")
   private String idNumber;
   @ApiModelProperty("头像附件id")
   private String avatarAttachmentId;
   @NotNull(groups = {Add.class, Update.class}, message = "性别不能为空")
   @ApiModelProperty("性别(0: 男, 1: 女)")
   private Integer sex;
   @ApiModelProperty("年龄")
   private Integer age;
   @NotNull(groups = {Add.class, Update.class}, message = "出生日期")
   @ApiModelProperty("出生日期")
   private String birthDate;
   @NotBlank(groups = {Add.class, Update.class}, message = "民族不能为空")
   @ApiModelProperty("民族")
   private String nation;
   @NotBlank(groups = {Add.class, Update.class}, message = "家庭住址不能为空")
   @Size(groups = {Add.class, Update.class}, max = 100, message = "家庭住址最大长度为100个字")
   @ApiModelProperty("家庭住址")
   private String homeAddress;
   @NotNull(groups = {Add.class, Update.class}, message = "员工类别不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = EmployeeCategoryEnum.class, message = "员工类别不存在")
   @ApiModelProperty("员工类别")
   private Integer employeeCategory;
   @ApiModelProperty("供应商ID(雇主单位)")
   private Long supplierId;
   @NotNull(groups = {Add.class, Update.class}, message = "入职日期不能为空")
   @ApiModelProperty("入职日期")
   private LocalDate entryDate;
   @NotBlank(groups = {Add.class, Update.class}, message = "工种不能为空")
   @ApiModelProperty("工种")
   private String workType;
   @NotNull(groups = {Add.class, Update.class}, message = "证书不能为空")
   @ApiModelProperty("有无证书(0: 无, 1: 有)")
   private Boolean boolCert;
   @Valid
   @ApiModelProperty("证书信息")
   private List<MesRosterSaveParam.CertSaveParam> Certs;
   @ApiModelProperty("证书附件IDs")
   private String certAttachmentIds;
   @ApiModelProperty("体检附件IDs")
   private String physicalExaminationAttachmentIds;
   @ApiModelProperty("状态(1: 在岗, 2: 离职)")
   private Integer status;
   @ApiModelProperty("用户ID")
   private Long userId;
   @Valid
   private UserSaveRequestVO userSaveRequestVO;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public String getAvatarAttachmentId() {
      return this.avatarAttachmentId;
   }

   public Integer getSex() {
      return this.sex;
   }

   public Integer getAge() {
      return this.age;
   }

   public String getBirthDate() {
      return this.birthDate;
   }

   public String getNation() {
      return this.nation;
   }

   public String getHomeAddress() {
      return this.homeAddress;
   }

   public Integer getEmployeeCategory() {
      return this.employeeCategory;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public LocalDate getEntryDate() {
      return this.entryDate;
   }

   public String getWorkType() {
      return this.workType;
   }

   public Boolean getBoolCert() {
      return this.boolCert;
   }

   public List<MesRosterSaveParam.CertSaveParam> getCerts() {
      return this.Certs;
   }

   public String getCertAttachmentIds() {
      return this.certAttachmentIds;
   }

   public String getPhysicalExaminationAttachmentIds() {
      return this.physicalExaminationAttachmentIds;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public UserSaveRequestVO getUserSaveRequestVO() {
      return this.userSaveRequestVO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
   }

   public void setAvatarAttachmentId(final String avatarAttachmentId) {
      this.avatarAttachmentId = avatarAttachmentId;
   }

   public void setSex(final Integer sex) {
      this.sex = sex;
   }

   public void setAge(final Integer age) {
      this.age = age;
   }

   public void setBirthDate(final String birthDate) {
      this.birthDate = birthDate;
   }

   public void setNation(final String nation) {
      this.nation = nation;
   }

   public void setHomeAddress(final String homeAddress) {
      this.homeAddress = homeAddress;
   }

   public void setEmployeeCategory(final Integer employeeCategory) {
      this.employeeCategory = employeeCategory;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setEntryDate(final LocalDate entryDate) {
      this.entryDate = entryDate;
   }

   public void setWorkType(final String workType) {
      this.workType = workType;
   }

   public void setBoolCert(final Boolean boolCert) {
      this.boolCert = boolCert;
   }

   public void setCerts(final List<MesRosterSaveParam.CertSaveParam> Certs) {
      this.Certs = Certs;
   }

   public void setCertAttachmentIds(final String certAttachmentIds) {
      this.certAttachmentIds = certAttachmentIds;
   }

   public void setPhysicalExaminationAttachmentIds(final String physicalExaminationAttachmentIds) {
      this.physicalExaminationAttachmentIds = physicalExaminationAttachmentIds;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserSaveRequestVO(final UserSaveRequestVO userSaveRequestVO) {
      this.userSaveRequestVO = userSaveRequestVO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesRosterSaveParam)) {
         return false;
      }

      MesRosterSaveParam other = (MesRosterSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sex = this.getSex();
         Object other$sex = other.getSex();
         if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
            Object this$age = this.getAge();
            Object other$age = other.getAge();
            if (this$age == null ? other$age == null : this$age.equals(other$age)) {
               Object this$employeeCategory = this.getEmployeeCategory();
               Object other$employeeCategory = other.getEmployeeCategory();
               if (this$employeeCategory == null ? other$employeeCategory == null : this$employeeCategory.equals(other$employeeCategory)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$boolCert = this.getBoolCert();
                     Object other$boolCert = other.getBoolCert();
                     if (this$boolCert == null ? other$boolCert == null : this$boolCert.equals(other$boolCert)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$idNumber = this.getIdNumber();
                                 Object other$idNumber = other.getIdNumber();
                                 if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                                    Object this$avatarAttachmentId = this.getAvatarAttachmentId();
                                    Object other$avatarAttachmentId = other.getAvatarAttachmentId();
                                    if (this$avatarAttachmentId == null
                                       ? other$avatarAttachmentId == null
                                       : this$avatarAttachmentId.equals(other$avatarAttachmentId)) {
                                       Object this$birthDate = this.getBirthDate();
                                       Object other$birthDate = other.getBirthDate();
                                       if (this$birthDate == null ? other$birthDate == null : this$birthDate.equals(other$birthDate)) {
                                          Object this$nation = this.getNation();
                                          Object other$nation = other.getNation();
                                          if (this$nation == null ? other$nation == null : this$nation.equals(other$nation)) {
                                             Object this$homeAddress = this.getHomeAddress();
                                             Object other$homeAddress = other.getHomeAddress();
                                             if (this$homeAddress == null ? other$homeAddress == null : this$homeAddress.equals(other$homeAddress)) {
                                                Object this$entryDate = this.getEntryDate();
                                                Object other$entryDate = other.getEntryDate();
                                                if (this$entryDate == null ? other$entryDate == null : this$entryDate.equals(other$entryDate)) {
                                                   Object this$workType = this.getWorkType();
                                                   Object other$workType = other.getWorkType();
                                                   if (this$workType == null ? other$workType == null : this$workType.equals(other$workType)) {
                                                      Object this$Certs = this.getCerts();
                                                      Object other$Certs = other.getCerts();
                                                      if (this$Certs == null ? other$Certs == null : this$Certs.equals(other$Certs)) {
                                                         Object this$certAttachmentIds = this.getCertAttachmentIds();
                                                         Object other$certAttachmentIds = other.getCertAttachmentIds();
                                                         if (this$certAttachmentIds == null
                                                            ? other$certAttachmentIds == null
                                                            : this$certAttachmentIds.equals(other$certAttachmentIds)) {
                                                            Object this$physicalExaminationAttachmentIds = this.getPhysicalExaminationAttachmentIds();
                                                            Object other$physicalExaminationAttachmentIds = other.getPhysicalExaminationAttachmentIds();
                                                            if (this$physicalExaminationAttachmentIds == null
                                                               ? other$physicalExaminationAttachmentIds == null
                                                               : this$physicalExaminationAttachmentIds.equals(other$physicalExaminationAttachmentIds)) {
                                                               Object this$userSaveRequestVO = this.getUserSaveRequestVO();
                                                               Object other$userSaveRequestVO = other.getUserSaveRequestVO();
                                                               return this$userSaveRequestVO == null
                                                                  ? other$userSaveRequestVO == null
                                                                  : this$userSaveRequestVO.equals(other$userSaveRequestVO);
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
      return other instanceof MesRosterSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $age = this.getAge();
      result = result * 59 + ($age == null ? 43 : $age.hashCode());
      Object $employeeCategory = this.getEmployeeCategory();
      result = result * 59 + ($employeeCategory == null ? 43 : $employeeCategory.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $boolCert = this.getBoolCert();
      result = result * 59 + ($boolCert == null ? 43 : $boolCert.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $avatarAttachmentId = this.getAvatarAttachmentId();
      result = result * 59 + ($avatarAttachmentId == null ? 43 : $avatarAttachmentId.hashCode());
      Object $birthDate = this.getBirthDate();
      result = result * 59 + ($birthDate == null ? 43 : $birthDate.hashCode());
      Object $nation = this.getNation();
      result = result * 59 + ($nation == null ? 43 : $nation.hashCode());
      Object $homeAddress = this.getHomeAddress();
      result = result * 59 + ($homeAddress == null ? 43 : $homeAddress.hashCode());
      Object $entryDate = this.getEntryDate();
      result = result * 59 + ($entryDate == null ? 43 : $entryDate.hashCode());
      Object $workType = this.getWorkType();
      result = result * 59 + ($workType == null ? 43 : $workType.hashCode());
      Object $Certs = this.getCerts();
      result = result * 59 + ($Certs == null ? 43 : $Certs.hashCode());
      Object $certAttachmentIds = this.getCertAttachmentIds();
      result = result * 59 + ($certAttachmentIds == null ? 43 : $certAttachmentIds.hashCode());
      Object $physicalExaminationAttachmentIds = this.getPhysicalExaminationAttachmentIds();
      result = result * 59 + ($physicalExaminationAttachmentIds == null ? 43 : $physicalExaminationAttachmentIds.hashCode());
      Object $userSaveRequestVO = this.getUserSaveRequestVO();
      return result * 59 + ($userSaveRequestVO == null ? 43 : $userSaveRequestVO.hashCode());
   }

   @Override
   public String toString() {
      return "MesRosterSaveParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", idNumber="
         + this.getIdNumber()
         + ", avatarAttachmentId="
         + this.getAvatarAttachmentId()
         + ", sex="
         + this.getSex()
         + ", age="
         + this.getAge()
         + ", birthDate="
         + this.getBirthDate()
         + ", nation="
         + this.getNation()
         + ", homeAddress="
         + this.getHomeAddress()
         + ", employeeCategory="
         + this.getEmployeeCategory()
         + ", supplierId="
         + this.getSupplierId()
         + ", entryDate="
         + this.getEntryDate()
         + ", workType="
         + this.getWorkType()
         + ", boolCert="
         + this.getBoolCert()
         + ", Certs="
         + this.getCerts()
         + ", certAttachmentIds="
         + this.getCertAttachmentIds()
         + ", physicalExaminationAttachmentIds="
         + this.getPhysicalExaminationAttachmentIds()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", userSaveRequestVO="
         + this.getUserSaveRequestVO()
         + ")";
   }

   @ApiModel("花名册证书新增Param参数")
   public static class CertSaveParam {
      @NotBlank(groups = {Add.class, Update.class}, message = "证书类型不能为空")
      @ApiModelProperty("证书类型")
      private String certType;
      @NotNull(groups = {Add.class, Update.class}, message = "到期时间不能为空")
      @ApiModelProperty("到期时间")
      private LocalDateTime expirationTime;

      public String getCertType() {
         return this.certType;
      }

      public LocalDateTime getExpirationTime() {
         return this.expirationTime;
      }

      public void setCertType(final String certType) {
         this.certType = certType;
      }

      public void setExpirationTime(final LocalDateTime expirationTime) {
         this.expirationTime = expirationTime;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         } else if (!(o instanceof MesRosterSaveParam.CertSaveParam)) {
            return false;
         } else {
            MesRosterSaveParam.CertSaveParam other = (MesRosterSaveParam.CertSaveParam)o;
            if (!other.canEqual(this)) {
               return false;
            } else {
               Object this$certType = this.getCertType();
               Object other$certType = other.getCertType();
               if (this$certType == null ? other$certType == null : this$certType.equals(other$certType)) {
                  Object this$expirationTime = this.getExpirationTime();
                  Object other$expirationTime = other.getExpirationTime();
                  return this$expirationTime == null ? other$expirationTime == null : this$expirationTime.equals(other$expirationTime);
               } else {
                  return false;
               }
            }
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof MesRosterSaveParam.CertSaveParam;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $certType = this.getCertType();
         result = result * 59 + ($certType == null ? 43 : $certType.hashCode());
         Object $expirationTime = this.getExpirationTime();
         return result * 59 + ($expirationTime == null ? 43 : $expirationTime.hashCode());
      }

      @Override
      public String toString() {
         return "MesRosterSaveParam.CertSaveParam(certType=" + this.getCertType() + ", expirationTime=" + this.getExpirationTime() + ")";
      }
   }
}
