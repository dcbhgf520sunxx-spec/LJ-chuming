import { ref as E } from "vue";
import { computed as b } from "vue";
import { onMounted as oe } from "vue";
import { nextTick as te } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as g } from "vue";
import { createBlock as V } from "vue";
import { withCtx as u } from "vue";
import { createVNode as n } from "vue";
import { unref as a } from "vue";
import { createTextVNode as ne } from "vue";
import { createCommentVNode as B } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as se } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as ie } from "vue";
import { renderList as re } from "vue";
import { Minus as ue } from "@element-plus/icons-vue";
import { ElInput as de } from "element-plus";
import { ElFormItem as me } from "element-plus";
import { ElDatePicker as pe } from "element-plus";
import { ElForm as ce } from "element-plus";
import { vLoading as fe } from "element-plus";
import { _ as ge, g8 as ye, ao as Ce, x4 as be, x5 as P, gv as F, gA as Ve, b as _e, b4 as Ie, iW as ve, R as he, S as Ee } from "../../../../../shared/runtime.js";
import { g as Re, c as Te } from "../../../../../modules/supplier-evaluation-config-2fb6916b.js";
import { _ as Ae } from "../../../../../modules/region-cascader-39b54da2.js";
const Ue = { class: "form" }, Oe = { class: "rule-row" }, Se = { class: "rule-row rule-row-evaluation" }, ke = { class: "rule-row" }, we = { class: "rule-row" }, Ne = { class: "rule-row" }, qe = { class: "rule-row" }, xe = { class: "rule-row" }, Le = { style: { "line-height": "32px", "margin-left": "-26px" } }, Be = { class: "item-center" }, De = { __name: "form", setup(Pe) {
  const R = E(), T = E({ name: "", phone: "", email: "" }), _ = E([]), k = E([]), Q = { name: "", shortName: "", area: [], address: "", socialCode: "", registrationDate: "", businessTerm: "", legalRepresentative: "", registeredCapital: "", enterpriseType: "", enterpriseTypeName: "", bankName: "", contacts: [{ ...T.value }], bankAccount: "", website: "", companyEmail: "", companyPhone: "", mainBusiness: "", files: [], attachments: [], supplierClass: [], supplierClassification: void 0, evaluationCategoryName: "", classifyId: void 0, qualificationsId: void 0, supplierQualificationId: void 0 }, p = { MATERIAL: "MATERIAL", PURCHASE_SERVICE: "PURCHASE_SERVICE", LABOR: "LABOR", LOGISTICS_OUTSOURCE: "LOGISTICS_OUTSOURCE", OTHER: "OTHER" }, w = { mainBusiness: "请输入主营业务", area: "请选择地区", address: "请输入详细地址", socialCode: "请输入社会统一代码", registrationDate: "请选择成立日期", legalRepresentative: "请输入法定代表人", registeredCapital: "请输入注册资本", bankName: "请输入开户行名称", bankAccount: "请输入银行账户", qualificationsId: "请选择供应商资质" }, z = { [p.MATERIAL]: ["mainBusiness", "area", "address", "socialCode", "legalRepresentative", "bankName", "bankAccount"], [p.PURCHASE_SERVICE]: ["socialCode", "legalRepresentative", "bankName", "bankAccount"], [p.LABOR]: ["mainBusiness", "area", "address", "socialCode", "registrationDate", "legalRepresentative", "registeredCapital", "bankName", "bankAccount", "qualificationsId"], [p.LOGISTICS_OUTSOURCE]: ["mainBusiness", "area", "address", "socialCode", "registrationDate", "legalRepresentative", "registeredCapital", "bankName", "bankAccount"], [p.OTHER]: [] }, H = ye(["enterprise_type"]), { crud: i, form: o, CRUD: C } = Ce(Q, R), I = b(() => J(G.value)), N = b(() => new Set(z[I.value] || [])), v = b(() => N.value.has("qualificationsId")), q = b(() => I.value === p.MATERIAL || I.value === p.LABOR || I.value === p.LOGISTICS_OUTSOURCE), G = b(() => {
    if (o.evaluationCategoryName) return o.evaluationCategoryName;
    const l = _.value.find((e) => e.id === o.classifyId);
    return (l == null ? void 0 : l.name) || "";
  }), M = b(() => {
    const l = {}, e = N.value;
    return Object.keys(w).forEach((m) => {
      if (!e.has(m)) return;
      const d = m === "area" || m === "registrationDate" || m === "qualificationsId" ? "change" : "blur";
      l[m] = [{ required: true, message: w[m], trigger: d }];
    }), { name: [{ required: true, message: "请输入供应商名称", trigger: "blur" }, { min: 2, max: 32, message: "长度在 2 到 32 个字符", trigger: "blur" }], shortName: [{ required: true, message: "请输入供应商简称", trigger: "blur" }, { min: 2, max: 12, message: "长度在 2 到 12 个字符", trigger: "blur" }], supplierClass: [{ required: true, message: "请选择供应商分类", trigger: "change" }], classifyId: [{ required: true, message: "请选择评价分类", trigger: "change" }], website: [{ pattern: be, message: "请填写正确的公司官网网址", trigger: "blur" }], companyEmail: [{ pattern: P, message: "请填写正确的公司邮箱", trigger: "blur" }], companyPhone: [{ pattern: F, message: "请填写正确的公司电话【手机号/固话】", trigger: "blur" }], ...l };
  }), x = { email: [{ pattern: P, message: "请填写正确的个人邮箱", trigger: "blur" }], phone: [{ pattern: F, message: "请填写正确的联系电话【手机号/固话】", trigger: "blur" }] };
  oe(() => {
    ee();
  }), C.HOOK.beforeEditDetailLoaded = async (l, e) => {
    var m, d, r;
    try {
      const s = { ...e }, O = [s.countryId, s.provinceId, s.cityId, s.regionId];
      s.area = O.filter((h) => !(!h || h === "")), s.files = s.attachments || [], s.supplierClass = Ve(s.supplierClassification), s.classifyId = U(s.classifyId, (m = s.scmSupplierConfigDTO) == null ? void 0 : m.id, s.evaluationCategoryId), s.evaluationCategoryName = U(s.evaluationCategoryName, s.classifyName, (d = s.scmSupplierConfigDTO) == null ? void 0 : d.name, (r = s.evaluationCategory) == null ? void 0 : r.name), s.qualificationsId = U(s.qualificationsId, s.qualificationId, s.supplierQualificationId), s.supplierQualificationId = s.qualificationsId, _e(s.contacts) && (s.contacts = [{ ...T.value }]), Object.assign(l.form, s), A(s.classifyId);
    } catch {
      l.notify("获取供应商详情失败", C.NOTIFICATION_TYPE.ERROR);
    }
  }, C.HOOK.beforeSubmit = async () => {
    i.form.attachments = i.form.files.map((l) => l.id), i.form.contacts = i.form.contacts.filter((l) => l.name || l.phone || l.email), i.form.evaluationCategoryId = void 0, i.form.supplierQualificationId = v.value ? i.form.qualificationsId : void 0, v.value || (i.form.qualificationsId = void 0, i.form.qualificationId = void 0, i.form.supplierQualificationId = void 0);
  };
  function $(l = []) {
    ["countryId", "provinceId", "cityId", "regionId"].forEach((m, d) => {
      i.form[m] = l && l[d] || void 0;
    });
  }
  function Y(l) {
    let e = 0;
    l && l.forEach((m) => {
      e |= m;
    }), i.form.supplierClassification = e;
  }
  function j(l) {
    A(l);
  }
  function K(l) {
    i.form.supplierQualificationId = l;
  }
  function W(l) {
    return !q.value || l !== 0 ? [] : [{ required: true, message: "请输入联系人", trigger: "blur" }];
  }
  function X(l) {
    const e = [...x.phone];
    return q.value && l === 0 && e.unshift({ required: true, message: "请输入联系电话", trigger: "blur" }), e;
  }
  function A(l) {
    const e = _.value.find((m) => m.id === l);
    i.form.evaluationCategoryName = (e == null ? void 0 : e.name) || "", i.form.classifyId = l, v.value || (i.form.qualificationsId = void 0, i.form.qualificationId = void 0, i.form.supplierQualificationId = void 0), te(() => {
      var m;
      (m = R.value) == null || m.clearValidate();
    });
  }
  function J(l = "") {
    const e = Z(l);
    return e ? e.includes("劳务分包") ? p.LABOR : e.includes("物资类") ? p.MATERIAL : e.includes("采购类") || e.includes("服务类") ? p.PURCHASE_SERVICE : e.includes("物流") || e.includes("外协加工") ? p.LOGISTICS_OUTSOURCE : p.OTHER : p.OTHER;
  }
  function Z(l) {
    return String(l || "").replace(/\s/g, "");
  }
  async function ee() {
    try {
      const [l, e] = await Promise.allSettled([Re(), Te()]);
      l.status === "fulfilled" && (_.value = L(l.value)), e.status === "fulfilled" && (k.value = L(e.value)), A(i.form.classifyId);
    } catch (l) {
      console.log("供应商单个新增-评价配置读取失败", l);
    }
  }
  function L(l) {
    var e;
    return Array.isArray(l) ? l : Array.isArray(l == null ? void 0 : l.content) ? l.content : Array.isArray((e = l == null ? void 0 : l.data) == null ? void 0 : e.content) ? l.data.content : Array.isArray(l == null ? void 0 : l.records) ? l.records : Array.isArray(l == null ? void 0 : l.list) ? l.list : Array.isArray(l == null ? void 0 : l.data) ? l.data : [];
  }
  function U(...l) {
    return l.find((e) => e != null && e !== "");
  }
  return (l, e) => {
    const m = S("common-button"), d = de, r = me, s = S("common-select"), O = pe, h = ce, le = S("common-dialog"), ae = fe;
    return g(), V(le, { "before-close": a(i).cancelCU, "close-on-click-modal": false, "show-close": true, title: a(i).status.title, visible: a(i).status.cu > 0, "append-to-body": "", fullscreen: "", width: "80%" }, { titleRight: u(() => [n(m, { loading: a(i).status.cu === a(C).STATUS.PROCESSING, size: "default", type: "primary", onClick: a(i).submitCU }, { default: u(() => e[21] || (e[21] = [ne(" 提 交 ")])), _: 1, __: [21] }, 8, ["loading", "onClick"]), a(i).status.add > a(C).STATUS.NORMAL ? (g(), V(a(Ie), { key: 0, type: "crud" })) : B("", true)]), default: u(() => [c("div", Ue, [se((g(), V(h, { ref_key: "formRef", ref: R, disabled: a(i).status.cu === a(C).STATUS.PROCESSING, model: a(o), rules: M.value, class: "demo-form", "label-width": "100px", size: "default" }, { default: u(() => [c("div", Oe, [n(r, { label: "供应商名称", prop: "name" }, { default: u(() => [n(d, { modelValue: a(o).name, "onUpdate:modelValue": e[0] || (e[0] = (t) => a(o).name = t), maxlength: "32", placeholder: "请输入供应商名称", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "供应商简称", prop: "shortName" }, { default: u(() => [n(d, { modelValue: a(o).shortName, "onUpdate:modelValue": e[1] || (e[1] = (t) => a(o).shortName = t), maxlength: "12", placeholder: "请输入供应商简称", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "供应商分类", prop: "supplierClass" }, { default: u(() => [n(s, { modelValue: a(o).supplierClass, "onUpdate:modelValue": e[2] || (e[2] = (t) => a(o).supplierClass = t), options: a(ve).ENUM, clearable: "", multiple: "", placeholder: "请选择供应商分类", size: "large", style: { width: "100%" }, type: "enum", onChange: Y }, null, 8, ["modelValue", "options"])]), _: 1 })]), c("div", Se, [n(r, { label: "评价分类", prop: "classifyId" }, { default: u(() => [n(s, { modelValue: a(o).classifyId, "onUpdate:modelValue": e[3] || (e[3] = (t) => a(o).classifyId = t), options: _.value, clearable: "", placeholder: "请选择评价分类", size: "large", style: { width: "100%" }, onChange: j }, null, 8, ["modelValue", "options"])]), _: 1 }), v.value ? (g(), V(r, { key: 0, label: "供应商资质", prop: "qualificationsId" }, { default: u(() => [n(s, { modelValue: a(o).qualificationsId, "onUpdate:modelValue": e[4] || (e[4] = (t) => a(o).qualificationsId = t), options: k.value, clearable: "", placeholder: "请选择供应商资质", size: "large", style: { width: "100%" }, onChange: K }, null, 8, ["modelValue", "options"])]), _: 1 })) : B("", true)]), c("div", ke, [n(r, { label: "主营业务", prop: "mainBusiness" }, { default: u(() => [n(d, { modelValue: a(o).mainBusiness, "onUpdate:modelValue": e[5] || (e[5] = (t) => a(o).mainBusiness = t), maxlength: "32", placeholder: "请输入主营业务" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "选择地区", prop: "area" }, { default: u(() => [n(a(Ae), { ref: "region", modelValue: a(o).area, "onUpdate:modelValue": e[6] || (e[6] = (t) => a(o).area = t), clearable: "", filterable: "", style: { width: "100%" }, onChange: $ }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "详细地址", prop: "address" }, { default: u(() => [n(d, { modelValue: a(o).address, "onUpdate:modelValue": e[7] || (e[7] = (t) => a(o).address = t), maxlength: "250", placeholder: "请您输入详细地址" }, null, 8, ["modelValue"])]), _: 1 })]), c("div", we, [n(r, { label: "社会统一代码", prop: "socialCode" }, { default: u(() => [n(d, { modelValue: a(o).socialCode, "onUpdate:modelValue": e[8] || (e[8] = (t) => a(o).socialCode = t), maxlength: "18", placeholder: "请输入社会统一代码" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "成立日期", prop: "registrationDate" }, { default: u(() => [n(O, { modelValue: a(o).registrationDate, "onUpdate:modelValue": e[9] || (e[9] = (t) => a(o).registrationDate = t), placeholder: "选择日期", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "营业期限", prop: "businessTerm" }, { default: u(() => [n(d, { modelValue: a(o).businessTerm, "onUpdate:modelValue": e[10] || (e[10] = (t) => a(o).businessTerm = t), maxlength: "32", placeholder: "请输入营业期限" }, null, 8, ["modelValue"])]), _: 1 })]), c("div", Ne, [n(r, { label: "法定代表人", prop: "legalRepresentative" }, { default: u(() => [n(d, { modelValue: a(o).legalRepresentative, "onUpdate:modelValue": e[11] || (e[11] = (t) => a(o).legalRepresentative = t), maxlength: "32", placeholder: "请输入法定代表人" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "注册资本", prop: "registeredCapital" }, { default: u(() => [n(d, { modelValue: a(o).registeredCapital, "onUpdate:modelValue": e[12] || (e[12] = (t) => a(o).registeredCapital = t), maxlength: "32", placeholder: "请输入注册资本" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "企业类型", prop: "enterpriseType" }, { default: u(() => [n(s, { modelValue: a(o).enterpriseType, "onUpdate:modelValue": e[13] || (e[13] = (t) => a(o).enterpriseType = t), options: a(H).enterprise_type, clearable: "", placeholder: "请选择企业类型", size: "large", style: { width: "100%" }, type: "dict" }, null, 8, ["modelValue", "options"])]), _: 1 })]), c("div", qe, [n(r, { label: "开户行名称", prop: "bankName" }, { default: u(() => [n(d, { modelValue: a(o).bankName, "onUpdate:modelValue": e[14] || (e[14] = (t) => a(o).bankName = t), maxlength: "32", placeholder: "请输入开户行名称" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "银行账户", prop: "bankAccount" }, { default: u(() => [n(d, { modelValue: a(o).bankAccount, "onUpdate:modelValue": e[15] || (e[15] = (t) => a(o).bankAccount = t), maxlength: "32", placeholder: "请输入银行账户" }, null, 8, ["modelValue"])]), _: 1 }), n(r)]), c("div", xe, [n(r, { label: "公司官网", prop: "website" }, { default: u(() => [n(d, { modelValue: a(o).website, "onUpdate:modelValue": e[16] || (e[16] = (t) => a(o).website = t), maxlength: "64", placeholder: "请输入公司官网网址" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "公司邮箱", prop: "companyEmail" }, { default: u(() => [n(d, { modelValue: a(o).companyEmail, "onUpdate:modelValue": e[17] || (e[17] = (t) => a(o).companyEmail = t), maxlength: "64", placeholder: "请输入公司邮箱" }, null, 8, ["modelValue"])]), _: 1 }), n(r, { label: "公司电话", prop: "companyPhone" }, { default: u(() => [n(d, { modelValue: a(o).companyPhone, "onUpdate:modelValue": e[18] || (e[18] = (t) => a(o).companyPhone = t), maxlength: "32", placeholder: "请输入公司电话" }, null, 8, ["modelValue"])]), _: 1 })]), (g(true), D(ie, null, re(a(o).contacts, (t, f) => (g(), D("div", { key: f, class: "rule-row" }, [n(r, { prop: `contacts[${f}].name`, rules: W(f), label: "联系人" }, { default: u(() => [n(d, { modelValue: t.name, "onUpdate:modelValue": (y) => t.name = y, maxlength: "32", placeholder: "请输入联系人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules"]), n(r, { prop: `contacts[${f}].phone`, rules: X(f), label: "联系电话" }, { default: u(() => [n(d, { modelValue: t.phone, "onUpdate:modelValue": (y) => t.phone = y, maxlength: "32", placeholder: "请输入联系电话" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules"]), n(r, { prop: `contacts[${f}].email`, rules: x.email, label: "个人邮箱" }, { default: u(() => [n(d, { modelValue: t.email, "onUpdate:modelValue": (y) => t.email = y, maxlength: "64", placeholder: "请输入个人邮箱" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules"]), c("div", Le, [f === a(o).contacts.length - 1 ? (g(), V(m, { key: 0, circle: "", icon: "el-icon-plus", size: "default", type: "primary", onClick: e[19] || (e[19] = (y) => a(o).contacts.push({ ...T.value })) })) : (g(), V(m, { key: 1, circle: "", icon: a(ue), size: "default", type: "danger", onClick: (y) => a(o).contacts.splice(f, 1) }, null, 8, ["icon", "onClick"]))])]))), 128)), c("div", Be, [n(he, { files: a(o).files, "onUpdate:files": e[20] || (e[20] = (t) => a(o).files = t), "download-perm": a(i).permission.downloadAttachments, "file-classify": a(Ee).SUPPLIER_ATT.V, "show-download": !!a(o).id, style: { padding: "10px 30px 0" } }, null, 8, ["files", "download-perm", "file-classify", "show-download"])])]), _: 1 }, 8, ["disabled", "model", "rules"])), [[ae, a(i).editDetailLoading]])])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, Ge = ge(De, [["__scopeId", "data-v-a3866d34"]]);
export {
  Ge as default
};
