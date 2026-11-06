import { l as t, lz as b, dA as s, lA as h, lB as y, lC as D, lD as E } from "../shared/runtime.js";
import { g as T } from "./project-information-053c195b.js";
import { ref as c } from "vue";
function I(e) {
  return t({ module: "crm", url: "business/center/list", method: "get", cancelKey: false, params: e });
}
function v(e) {
  return t({ module: "crm", url: "business/center/enterprise/summary", method: "get", params: e });
}
function R(e) {
  return t({ module: "crm", url: "business/center/enterprise/detail", method: "get", params: e });
}
function F(e) {
  return t({ module: "crm", url: "business/center/enterprise/detail/downLoad", method: "get", responseType: "blob", params: e });
}
const $ = { get: I };
function w(e) {
  return t({ module: "crm", url: "business/center/supplier/list", method: "get", cancelKey: false, params: e });
}
function G(e) {
  return t({ module: "crm", url: "business/center/supplier/summary", method: "get", params: e });
}
function A(e) {
  return t({ module: "crm", url: "business/center/supplier/detail", method: "get", params: e });
}
function L(e) {
  return t({ module: "crm", url: "business/center/supplier/detail/downLoad", method: "get", responseType: "blob", params: e });
}
function V(e) {
  return t({ module: "crm", url: "supplier/warehousing/ca/locked", method: "post", data: e });
}
const B = { get: w };
function C(e) {
  return t({ module: "crm", url: "business/center/government/list", method: "get", cancelKey: false, params: e });
}
function M(e) {
  return t({ module: "crm", url: "business/center/government/summary", method: "get", params: e });
}
function N(e) {
  return t({ module: "crm", url: "business/center/government/detail", method: "get", params: e });
}
function K(e) {
  return t({ module: "crm", url: "business/center/government/detail/downLoad", method: "get", responseType: "blob", params: e });
}
function U(e) {
  return t({ module: "crm", url: "government/warehousing/ca/locked", method: "post", data: e });
}
const j = { get: C };
function _(e) {
  return t({ module: "crm", url: "business/center/platform/list", method: "get", cancelKey: false, params: e });
}
function W(e) {
  return t({ module: "crm", url: "business/center/platform/summary", method: "get", params: e });
}
function O(e) {
  return t({ module: "crm", url: "business/center/platform/detail", method: "get", params: e });
}
function q(e) {
  return t({ module: "crm", url: "business/center/platform/detail/downLoad", method: "get", responseType: "blob", params: e });
}
function J(e) {
  return t({ module: "crm", url: "bidding/platform/warehousing/ca/locked", method: "post", data: e });
}
const x = { get: _ };
function z() {
  const e = c([]), l = c({}), m = c({});
  async function d({ pageEnum: r, countryType: a }) {
    try {
      const o = await b({ crmPageManagementConfigEnum: r, crmCountryTypeEnum: a });
      console.log(o, "ressss"), e.value = o.filter((i) => i.fieldName !== "附件" && i.fieldName !== "跟进证明" && i.fieldName !== "资格预审通知文件");
    } catch (o) {
      console.log(o, "获取列表数据");
    }
  }
  async function g({ params: r, pageEnum: a, tenderType: o, crmSpecialBubmissionStatusEnum: i, crmSettlementBusinessTypeEnum: u, crmApplyTechnologyBiddingRecordId: p }) {
    try {
      let n = {};
      switch (a) {
        case s.FIRM_RECORD_CONFIG.V:
          n = await R({ id: r.id });
          break;
        case s.PROJECT_SIGN_IN_CONFIG.V:
          n = await T({ id: r.id });
          break;
        case s.SUPPLIER_INTO_RECORD_CONFIG.V:
          n = await A({ id: r.id });
          break;
        case s.GOVERNMENT_RECORD_CONFIG.V:
          n = await N({ id: r.id });
          break;
        case s.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V:
          n = await O({ id: r.id });
          break;
        case s.PROJECT_TRACK_DOWN.V:
          n = await D(r.id);
          break;
        case s.QUALIFICATION_REVIEW.V:
          n = await y({ id: r.id });
          break;
        case s.APPLICATION_TENDER.V:
          n = await h({ crmTenderRequirementTypeEnum: o, id: r.id, crmSpecialBubmissionStatusEnum: i, crmSettlementBusinessTypeEnum: u, crmApplyTechnologyBiddingRecordId: p });
          break;
      }
      l.value = n;
    } catch (n) {
      console.log(n);
    }
  }
  async function f({ params: r, tenderType: a, crmSpecialBubmissionStatusEnum: o, crmApplyTechnologyBiddingRecordId: i }) {
    try {
      const u = await E({ crmProjectInformationWarehousingId: r.id, crmTenderRequirementTypeEnum: a, crmSpecialBubmissionStatusEnum: o, crmApplyTechnologyBiddingRecordId: i });
      m.value = u;
    } catch (u) {
      console.log(u);
    }
  }
  return { formItemList: e, serchFormDetail: l, chargePersonalDatail: m, fetchFormItemList: d, fetchFormDetail: g, fetchUserChargeDetail: f };
}
export {
  $ as a,
  q as b,
  x as c,
  v as d,
  j as e,
  F as f,
  W as g,
  M as h,
  K as i,
  U as j,
  B as k,
  G as l,
  L as m,
  V as n,
  J as s,
  z as u
};
