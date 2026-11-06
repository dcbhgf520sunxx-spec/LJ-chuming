import {l as request, j as store} from '../shared/runtime.js';
/** Local company facts only; central customer/licensing identifiers are not inferred. */
export async function getCustomer() {
  const user=store.getters.user || {};
  const config=user.companyName ? {} : await request({url:'/api/config/company/name',method:'get'});
  return {
    name:user.companyName || config?.companyName || null,
    logo:user.companyLogo || config?.companyLogo || null,
    code:null,
    version:null,
    licenseExpiresAt:null,
    unknownFields:['code','version','licenseExpiresAt'],
    source:user.companyName?'current-user-info':'local-company-config'
  };
}
