package com.hzchum.scim.common.core.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "chum.config")
public class ConfigProperties {
   private String filePath;
   private String filePath1;
   private String boChuUrl;
   private String url;
   private String companyName;
   private String companyNo;
   private Integer yuanDecimal;
   private Integer projectNameShowMode;
   private Boolean showContractNo;
   private Boolean showProjectFullName;
   private String phone;
   private String password;
   private String email;
   private String ddAppKey;
   private String ddAppSecret;
   private String accessToken;
   private String ddChatid;
   private Boolean enable;
   private String corpId;
   private String token;
   private String aesKey;
   private Boolean backupsData = true;
   private Integer backupsNumber;
   private String userName;
   private String sqlPassWord;
   private String database;
   private String iot;
   private Long weightTimeOut;

   public String getFilePath() {
      return this.filePath;
   }

   public String getFilePath1() {
      return this.filePath1;
   }

   public String getBoChuUrl() {
      return this.boChuUrl;
   }

   public String getUrl() {
      return this.url;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getCompanyNo() {
      return this.companyNo;
   }

   public Integer getYuanDecimal() {
      return this.yuanDecimal;
   }

   public Integer getProjectNameShowMode() {
      return this.projectNameShowMode;
   }

   public Boolean getShowContractNo() {
      return this.showContractNo;
   }

   public Boolean getShowProjectFullName() {
      return this.showProjectFullName;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getPassword() {
      return this.password;
   }

   public String getEmail() {
      return this.email;
   }

   public String getDdAppKey() {
      return this.ddAppKey;
   }

   public String getDdAppSecret() {
      return this.ddAppSecret;
   }

   public String getAccessToken() {
      return this.accessToken;
   }

   public String getDdChatid() {
      return this.ddChatid;
   }

   public Boolean getEnable() {
      return this.enable;
   }

   public String getCorpId() {
      return this.corpId;
   }

   public String getToken() {
      return this.token;
   }

   public String getAesKey() {
      return this.aesKey;
   }

   public Boolean getBackupsData() {
      return this.backupsData;
   }

   public Integer getBackupsNumber() {
      return this.backupsNumber;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getSqlPassWord() {
      return this.sqlPassWord;
   }

   public String getDatabase() {
      return this.database;
   }

   public String getIot() {
      return this.iot;
   }

   public Long getWeightTimeOut() {
      return this.weightTimeOut;
   }

   public void setFilePath(final String filePath) {
      this.filePath = filePath;
   }

   public void setFilePath1(final String filePath1) {
      this.filePath1 = filePath1;
   }

   public void setBoChuUrl(final String boChuUrl) {
      this.boChuUrl = boChuUrl;
   }

   public void setUrl(final String url) {
      this.url = url;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setCompanyNo(final String companyNo) {
      this.companyNo = companyNo;
   }

   public void setYuanDecimal(final Integer yuanDecimal) {
      this.yuanDecimal = yuanDecimal;
   }

   public void setProjectNameShowMode(final Integer projectNameShowMode) {
      this.projectNameShowMode = projectNameShowMode;
   }

   public void setShowContractNo(final Boolean showContractNo) {
      this.showContractNo = showContractNo;
   }

   public void setShowProjectFullName(final Boolean showProjectFullName) {
      this.showProjectFullName = showProjectFullName;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setPassword(final String password) {
      this.password = password;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setDdAppKey(final String ddAppKey) {
      this.ddAppKey = ddAppKey;
   }

   public void setDdAppSecret(final String ddAppSecret) {
      this.ddAppSecret = ddAppSecret;
   }

   public void setAccessToken(final String accessToken) {
      this.accessToken = accessToken;
   }

   public void setDdChatid(final String ddChatid) {
      this.ddChatid = ddChatid;
   }

   public void setEnable(final Boolean enable) {
      this.enable = enable;
   }

   public void setCorpId(final String corpId) {
      this.corpId = corpId;
   }

   public void setToken(final String token) {
      this.token = token;
   }

   public void setAesKey(final String aesKey) {
      this.aesKey = aesKey;
   }

   public void setBackupsData(final Boolean backupsData) {
      this.backupsData = backupsData;
   }

   public void setBackupsNumber(final Integer backupsNumber) {
      this.backupsNumber = backupsNumber;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setSqlPassWord(final String sqlPassWord) {
      this.sqlPassWord = sqlPassWord;
   }

   public void setDatabase(final String database) {
      this.database = database;
   }

   public void setIot(final String iot) {
      this.iot = iot;
   }

   public void setWeightTimeOut(final Long weightTimeOut) {
      this.weightTimeOut = weightTimeOut;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConfigProperties)) {
         return false;
      }

      ConfigProperties other = (ConfigProperties)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yuanDecimal = this.getYuanDecimal();
      Object other$yuanDecimal = other.getYuanDecimal();
      if (this$yuanDecimal == null ? other$yuanDecimal == null : this$yuanDecimal.equals(other$yuanDecimal)) {
         Object this$projectNameShowMode = this.getProjectNameShowMode();
         Object other$projectNameShowMode = other.getProjectNameShowMode();
         if (this$projectNameShowMode == null ? other$projectNameShowMode == null : this$projectNameShowMode.equals(other$projectNameShowMode)) {
            Object this$showContractNo = this.getShowContractNo();
            Object other$showContractNo = other.getShowContractNo();
            if (this$showContractNo == null ? other$showContractNo == null : this$showContractNo.equals(other$showContractNo)) {
               Object this$showProjectFullName = this.getShowProjectFullName();
               Object other$showProjectFullName = other.getShowProjectFullName();
               if (this$showProjectFullName == null ? other$showProjectFullName == null : this$showProjectFullName.equals(other$showProjectFullName)) {
                  Object this$enable = this.getEnable();
                  Object other$enable = other.getEnable();
                  if (this$enable == null ? other$enable == null : this$enable.equals(other$enable)) {
                     Object this$backupsData = this.getBackupsData();
                     Object other$backupsData = other.getBackupsData();
                     if (this$backupsData == null ? other$backupsData == null : this$backupsData.equals(other$backupsData)) {
                        Object this$backupsNumber = this.getBackupsNumber();
                        Object other$backupsNumber = other.getBackupsNumber();
                        if (this$backupsNumber == null ? other$backupsNumber == null : this$backupsNumber.equals(other$backupsNumber)) {
                           Object this$weightTimeOut = this.getWeightTimeOut();
                           Object other$weightTimeOut = other.getWeightTimeOut();
                           if (this$weightTimeOut == null ? other$weightTimeOut == null : this$weightTimeOut.equals(other$weightTimeOut)) {
                              Object this$filePath = this.getFilePath();
                              Object other$filePath = other.getFilePath();
                              if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                                 Object this$filePath1 = this.getFilePath1();
                                 Object other$filePath1 = other.getFilePath1();
                                 if (this$filePath1 == null ? other$filePath1 == null : this$filePath1.equals(other$filePath1)) {
                                    Object this$boChuUrl = this.getBoChuUrl();
                                    Object other$boChuUrl = other.getBoChuUrl();
                                    if (this$boChuUrl == null ? other$boChuUrl == null : this$boChuUrl.equals(other$boChuUrl)) {
                                       Object this$url = this.getUrl();
                                       Object other$url = other.getUrl();
                                       if (this$url == null ? other$url == null : this$url.equals(other$url)) {
                                          Object this$companyName = this.getCompanyName();
                                          Object other$companyName = other.getCompanyName();
                                          if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
                                             Object this$companyNo = this.getCompanyNo();
                                             Object other$companyNo = other.getCompanyNo();
                                             if (this$companyNo == null ? other$companyNo == null : this$companyNo.equals(other$companyNo)) {
                                                Object this$phone = this.getPhone();
                                                Object other$phone = other.getPhone();
                                                if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                                   Object this$password = this.getPassword();
                                                   Object other$password = other.getPassword();
                                                   if (this$password == null ? other$password == null : this$password.equals(other$password)) {
                                                      Object this$email = this.getEmail();
                                                      Object other$email = other.getEmail();
                                                      if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                                                         Object this$ddAppKey = this.getDdAppKey();
                                                         Object other$ddAppKey = other.getDdAppKey();
                                                         if (this$ddAppKey == null ? other$ddAppKey == null : this$ddAppKey.equals(other$ddAppKey)) {
                                                            Object this$ddAppSecret = this.getDdAppSecret();
                                                            Object other$ddAppSecret = other.getDdAppSecret();
                                                            if (this$ddAppSecret == null
                                                               ? other$ddAppSecret == null
                                                               : this$ddAppSecret.equals(other$ddAppSecret)) {
                                                               Object this$accessToken = this.getAccessToken();
                                                               Object other$accessToken = other.getAccessToken();
                                                               if (this$accessToken == null
                                                                  ? other$accessToken == null
                                                                  : this$accessToken.equals(other$accessToken)) {
                                                                  Object this$ddChatid = this.getDdChatid();
                                                                  Object other$ddChatid = other.getDdChatid();
                                                                  if (this$ddChatid == null ? other$ddChatid == null : this$ddChatid.equals(other$ddChatid)) {
                                                                     Object this$corpId = this.getCorpId();
                                                                     Object other$corpId = other.getCorpId();
                                                                     if (this$corpId == null ? other$corpId == null : this$corpId.equals(other$corpId)) {
                                                                        Object this$token = this.getToken();
                                                                        Object other$token = other.getToken();
                                                                        if (this$token == null ? other$token == null : this$token.equals(other$token)) {
                                                                           Object this$aesKey = this.getAesKey();
                                                                           Object other$aesKey = other.getAesKey();
                                                                           if (this$aesKey == null ? other$aesKey == null : this$aesKey.equals(other$aesKey)) {
                                                                              Object this$userName = this.getUserName();
                                                                              Object other$userName = other.getUserName();
                                                                              if (this$userName == null
                                                                                 ? other$userName == null
                                                                                 : this$userName.equals(other$userName)) {
                                                                                 Object this$sqlPassWord = this.getSqlPassWord();
                                                                                 Object other$sqlPassWord = other.getSqlPassWord();
                                                                                 if (this$sqlPassWord == null
                                                                                    ? other$sqlPassWord == null
                                                                                    : this$sqlPassWord.equals(other$sqlPassWord)) {
                                                                                    Object this$database = this.getDatabase();
                                                                                    Object other$database = other.getDatabase();
                                                                                    if (this$database == null
                                                                                       ? other$database == null
                                                                                       : this$database.equals(other$database)) {
                                                                                       Object this$iot = this.getIot();
                                                                                       Object other$iot = other.getIot();
                                                                                       return this$iot == null ? other$iot == null : this$iot.equals(other$iot);
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
      return other instanceof ConfigProperties;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yuanDecimal = this.getYuanDecimal();
      result = result * 59 + ($yuanDecimal == null ? 43 : $yuanDecimal.hashCode());
      Object $projectNameShowMode = this.getProjectNameShowMode();
      result = result * 59 + ($projectNameShowMode == null ? 43 : $projectNameShowMode.hashCode());
      Object $showContractNo = this.getShowContractNo();
      result = result * 59 + ($showContractNo == null ? 43 : $showContractNo.hashCode());
      Object $showProjectFullName = this.getShowProjectFullName();
      result = result * 59 + ($showProjectFullName == null ? 43 : $showProjectFullName.hashCode());
      Object $enable = this.getEnable();
      result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
      Object $backupsData = this.getBackupsData();
      result = result * 59 + ($backupsData == null ? 43 : $backupsData.hashCode());
      Object $backupsNumber = this.getBackupsNumber();
      result = result * 59 + ($backupsNumber == null ? 43 : $backupsNumber.hashCode());
      Object $weightTimeOut = this.getWeightTimeOut();
      result = result * 59 + ($weightTimeOut == null ? 43 : $weightTimeOut.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $filePath1 = this.getFilePath1();
      result = result * 59 + ($filePath1 == null ? 43 : $filePath1.hashCode());
      Object $boChuUrl = this.getBoChuUrl();
      result = result * 59 + ($boChuUrl == null ? 43 : $boChuUrl.hashCode());
      Object $url = this.getUrl();
      result = result * 59 + ($url == null ? 43 : $url.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $companyNo = this.getCompanyNo();
      result = result * 59 + ($companyNo == null ? 43 : $companyNo.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $password = this.getPassword();
      result = result * 59 + ($password == null ? 43 : $password.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $ddAppKey = this.getDdAppKey();
      result = result * 59 + ($ddAppKey == null ? 43 : $ddAppKey.hashCode());
      Object $ddAppSecret = this.getDdAppSecret();
      result = result * 59 + ($ddAppSecret == null ? 43 : $ddAppSecret.hashCode());
      Object $accessToken = this.getAccessToken();
      result = result * 59 + ($accessToken == null ? 43 : $accessToken.hashCode());
      Object $ddChatid = this.getDdChatid();
      result = result * 59 + ($ddChatid == null ? 43 : $ddChatid.hashCode());
      Object $corpId = this.getCorpId();
      result = result * 59 + ($corpId == null ? 43 : $corpId.hashCode());
      Object $token = this.getToken();
      result = result * 59 + ($token == null ? 43 : $token.hashCode());
      Object $aesKey = this.getAesKey();
      result = result * 59 + ($aesKey == null ? 43 : $aesKey.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $sqlPassWord = this.getSqlPassWord();
      result = result * 59 + ($sqlPassWord == null ? 43 : $sqlPassWord.hashCode());
      Object $database = this.getDatabase();
      result = result * 59 + ($database == null ? 43 : $database.hashCode());
      Object $iot = this.getIot();
      return result * 59 + ($iot == null ? 43 : $iot.hashCode());
   }

   @Override
   public String toString() {
      return "ConfigProperties(filePath="
         + this.getFilePath()
         + ", filePath1="
         + this.getFilePath1()
         + ", boChuUrl="
         + this.getBoChuUrl()
         + ", url="
         + this.getUrl()
         + ", companyName="
         + this.getCompanyName()
         + ", companyNo="
         + this.getCompanyNo()
         + ", yuanDecimal="
         + this.getYuanDecimal()
         + ", projectNameShowMode="
         + this.getProjectNameShowMode()
         + ", showContractNo="
         + this.getShowContractNo()
         + ", showProjectFullName="
         + this.getShowProjectFullName()
         + ", phone="
         + this.getPhone()
         + ", password="
         + this.getPassword()
         + ", email="
         + this.getEmail()
         + ", ddAppKey="
         + this.getDdAppKey()
         + ", ddAppSecret="
         + this.getDdAppSecret()
         + ", accessToken="
         + this.getAccessToken()
         + ", ddChatid="
         + this.getDdChatid()
         + ", enable="
         + this.getEnable()
         + ", corpId="
         + this.getCorpId()
         + ", token="
         + this.getToken()
         + ", aesKey="
         + this.getAesKey()
         + ", backupsData="
         + this.getBackupsData()
         + ", backupsNumber="
         + this.getBackupsNumber()
         + ", userName="
         + this.getUserName()
         + ", sqlPassWord="
         + this.getSqlPassWord()
         + ", database="
         + this.getDatabase()
         + ", iot="
         + this.getIot()
         + ", weightTimeOut="
         + this.getWeightTimeOut()
         + ")";
   }
}
