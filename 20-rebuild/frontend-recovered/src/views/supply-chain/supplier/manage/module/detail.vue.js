import { ref as y } from "vue";
import { onMounted as B } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as x } from "vue";
import { openBlock as m } from "vue";
import { createBlock as I } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as A } from "vue";
import { createVNode as n } from "vue";
import { toDisplayString as r } from "vue";
import { unref as i } from "vue";
import { createTextVNode as V } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as F } from "vue";
import { renderList as P } from "vue";
import { ElFormItem as $ } from "element-plus";
import { ElForm as Q } from "element-plus";
import { vLoading as z } from "element-plus";
import { _ as U, g8 as j, gt as H, w$ as K, iW as M, R as W, S as Y } from "../../../../../shared/runtime.js";
import { g as G, c as J } from "../../../../../modules/supplier-evaluation-config-2fb6916b.js";
const X = { class: "form" }, Z = { class: "rule-row" }, ee = { class: "rule-row" }, le = { class: "rule-row" }, ie = { class: "rule-row" }, ae = { class: "rule-row" }, te = { class: "rule-row" }, se = { class: "rule-row" }, ne = { class: "item-center" }, oe = { __name: "detail", setup(re) {
  const T = y(), v = y([]), b = y([]), L = j(["enterprise_type"]), { crud: p, detail: a, CRUD: g } = H();
  B(() => {
    S();
  }), g.HOOK.beforeDetailLoaded = async (e) => {
    try {
      const l = { ...a }, t = [l.countryId, l.provinceId, l.cityId, l.regionId];
      l.area = t.filter((c) => !(!c || c === "")), l.files = l.attachments || [], l.supplierClassificationLabel = K(M, l.supplierClassification, "、"), C(l), Object.assign(a, l), R(a.enterpriseType);
    } catch {
      e.notify("获取供应商详情失败", g.NOTIFICATION_TYPE.ERROR);
    }
  };
  function R(e) {
    L.value.enterprise_type.forEach((l) => {
      l.value === e && (a.enterpriseTypeName = l.label);
    });
  }
  async function S() {
    try {
      const [e, l] = await Promise.allSettled([G(), J()]);
      e.status === "fulfilled" && (v.value = D(e.value)), l.status === "fulfilled" && (b.value = D(l.value)), C(a);
    } catch (e) {
      console.log("供应商详情-评价配置读取失败", e);
    }
  }
  function C(e = {}) {
    e.evaluationCategoryDisplayName = w(e), e.qualificationDisplayName = k(e);
  }
  function w(e = {}) {
    var f, d, _;
    const l = [e.evaluationCategoryName, e.classifyName, (f = e.scmSupplierConfigDTO) == null ? void 0 : f.name, (d = e.evaluationCategory) == null ? void 0 : d.name].find((u) => N(u));
    if (l) return l;
    const t = h(e.classifyId, e.evaluationCategoryId, (_ = e.scmSupplierConfigDTO) == null ? void 0 : _.id), c = v.value.find((u) => String(u.id) === String(t));
    return (c == null ? void 0 : c.name) || "";
  }
  function k(e = {}) {
    var f;
    const l = [e.qualificationName, e.qualificationsName, e.supplierQualificationName, (f = e.qualification) == null ? void 0 : f.name].find((d) => N(d));
    if (l) return l;
    const t = h(e.qualificationsId, e.qualificationId, e.supplierQualificationId), c = b.value.find((d) => String(d.id) === String(t));
    return (c == null ? void 0 : c.name) || "";
  }
  function h(...e) {
    return e.find((l) => l != null && l !== "");
  }
  function N(e) {
    return e != null && e !== "";
  }
  function D(e) {
    var l;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((l = e == null ? void 0 : e.data) == null ? void 0 : l.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  return (e, l) => {
    const t = $, c = Q, f = O("common-dialog"), d = x("parse-time"), _ = z;
    return m(), I(f, { "append-to-body": "", "close-on-click-modal": false, "before-close": i(p).cancelDetail, visible: i(p).detailVisible, title: i(p).detailTitle, "show-close": true, width: "80%", fullscreen: "" }, { default: o(() => [s("div", X, [A((m(), I(c, { ref_key: "formRef", ref: T, size: "default", "label-width": "100px", class: "demo-form" }, { default: o(() => [s("div", Z, [n(t, { label: "供应商名称", prop: "name" }, { default: o(() => [s("span", null, r(i(a).name), 1)]), _: 1 }), n(t, { label: "供应商分类", prop: "supplierClassificationLabel" }, { default: o(() => [s("div", null, r(i(a).supplierClassificationLabel), 1)]), _: 1 }), n(t, { label: "主营业务", prop: "mainBusiness" }, { default: o(() => [s("div", null, r(i(a).mainBusiness), 1)]), _: 1 })]), s("div", ee, [n(t, { label: "评价", prop: "scoreRating" }, { default: o(() => [s("div", null, r(i(a).scoreRating || "-"), 1)]), _: 1 }), n(t, { label: "评价分类", prop: "classifyId" }, { default: o(() => [s("div", null, r(i(a).evaluationCategoryDisplayName || "-"), 1)]), _: 1 }), n(t)]), s("div", le, [n(t, { label: "地区", prop: "area" }, { default: o(() => [V(r(`${i(a).countryName || ""}${i(a).provinceName || ""}${i(a).cityName || ""}${i(a).regionName || ""}${i(a).address || ""}`), 1)]), _: 1 })]), s("div", ie, [n(t, { label: "社会统一代码", prop: "socialCode" }, { default: o(() => [s("div", null, r(i(a).socialCode), 1)]), _: 1 }), n(t, { label: "成立日期", prop: "registrationDate" }, { default: o(() => [A(s("div", null, null, 512), [[d, { val: i(a).registrationDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), n(t, { label: "营业期限", prop: "businessTerm" }, { default: o(() => [s("div", null, r(i(a).businessTerm), 1)]), _: 1 })]), s("div", ae, [n(t, { label: "法定代表人", prop: "legalRepresentative" }, { default: o(() => [s("div", null, r(i(a).legalRepresentative), 1)]), _: 1 }), n(t, { label: "注册资本", prop: "registeredCapital" }, { default: o(() => [s("div", null, r(i(a).registeredCapital), 1)]), _: 1 }), n(t, { label: "企业类型", prop: "enterpriseType" }, { default: o(() => [s("div", null, r(i(a).enterpriseTypeName), 1)]), _: 1 })]), s("div", te, [n(t, { label: "开户行名称", prop: "bankName" }, { default: o(() => [s("div", null, r(i(a).bankName), 1)]), _: 1 }), n(t, { label: "银行账户", prop: "bankAccount" }, { default: o(() => [s("div", null, r(i(a).bankAccount), 1)]), _: 1 }), n(t)]), s("div", se, [n(t, { label: "公司官网", prop: "website" }, { default: o(() => [s("div", null, r(i(a).website), 1)]), _: 1 }), n(t, { label: "公司邮箱", prop: "companyEmail" }, { default: o(() => [s("div", null, r(i(a).companyEmail), 1)]), _: 1 }), n(t, { label: "公司电话", prop: "companyPhone" }, { default: o(() => [s("div", null, r(i(a).companyPhone), 1)]), _: 1 })]), (m(true), E(F, null, P(i(a).contacts || [], (u, q) => (m(), E("div", { key: q, class: "rule-row" }, [n(t, { label: "联系人" }, { default: o(() => [s("div", null, r(u.name), 1)]), _: 2 }, 1024), n(t, { label: "联系电话" }, { default: o(() => [s("div", null, r(u.phone), 1)]), _: 2 }, 1024), n(t, { label: "个人邮箱" }, { default: o(() => [s("div", null, r(u.email), 1)]), _: 2 }, 1024)]))), 128)), s("div", ne, [n(W, { "show-download": !!i(a).id, uploadable: false, "file-classify": i(Y).SUPPLIER_ATT.V, "download-perm": i(p).permission.downloadAttachments, files: i(a).files, "onUpdate:files": l[0] || (l[0] = (u) => i(a).files = u), style: { padding: "10px 30px 0" } }, null, 8, ["show-download", "file-classify", "download-perm", "files"])])]), _: 1 })), [[_, i(p).detailLoading]])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, fe = U(oe, [["__scopeId", "data-v-5a3c2543"]]);
export {
  fe as default
};
