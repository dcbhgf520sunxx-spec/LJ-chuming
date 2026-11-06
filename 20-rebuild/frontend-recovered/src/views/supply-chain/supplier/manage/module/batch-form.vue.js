import { ref as V } from "vue";
import { computed as x } from "vue";
import { onMounted as q } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as L } from "vue";
import { createBlock as P } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { unref as n } from "vue";
import { createTextVNode as G } from "vue";
import { createElementVNode as d } from "vue";
import { withModifiers as j } from "vue";
import { ElTableColumn as K } from "element-plus";
import { InfoFilled as Q } from "@element-plus/icons-vue";
import { ElIcon as W } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { ElInput as X } from "element-plus";
import { ElForm as Y } from "element-plus";
import { a_ as Z, o as ee, b4 as le, iW as te, aw as oe } from "../../../../../shared/runtime.js";
import { g as ae } from "../../../../../modules/supplier-evaluation-config-2fb6916b.js";
import { u as ne } from "../../../../../modules/use-table-operate-4f84437f.js";
const ie = { style: { display: "inline-block" } }, se = { style: { display: "inline-block" } }, pe = { __name: "batch-form", setup(re) {
  const f = V([]), v = x(() => ({ name: [{ min: 2, max: 32, message: "长度在 2 到 32 个字符", trigger: "blur" }], shortName: [{ min: 2, max: 12, message: "长度在 2 到 12 个字符", trigger: "blur" }], classification: [{ required: true, message: "请选择供应商分类", trigger: "blur" }], classifyId: [{ required: true, message: "请选择评价分类", trigger: "change" }] })), U = { list: [] }, A = { name: "", shortName: "", classification: [], supplierClassification: void 0, classifyId: void 0, evaluationCategoryName: "" }, h = V(), { CRUD: m, crud: u, form: c, ADD_FORM: S } = Z(U, h), g = x(() => u.bStatus.cu > m.STATUS.NORMAL), { init: I, addRow: R, removeRow: N } = ne(A, 10), { tableValidate: k, cleanUpData: B, wrongCellMask: E } = oe({ rules: v }), { maxHeight: T } = ee({ mainBox: ".supplier-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, g);
  S.init = () => I(c.list), m.HOOK.beforeValidateBCU = () => {
    const { validResult: e, dealList: t } = k(c.list);
    if (e) c.list = t;
    else return e;
  }, u.submitBatchFormFormat = (e) => B(e.list).map((r) => {
    const i = { ...r };
    return i.evaluationCategoryId = void 0, i.qualificationId = void 0, i.supplierQualificationId = void 0, i;
  });
  function M(e, t) {
    let r = 0;
    e && e.forEach((i) => {
      r |= i;
    }), t.supplierClassification = r;
  }
  function O(e, t) {
    const r = f.value.find((i) => i.id === e);
    t.evaluationCategoryName = (r == null ? void 0 : r.name) || "", t.classifyId = e;
  }
  q(() => {
    z();
  });
  async function z() {
    try {
      const [e] = await Promise.allSettled([ae()]);
      e.status === "fulfilled" && (f.value = F(e.value));
    } catch (e) {
      console.log("供应商批量新增-评价配置读取失败", e);
    }
  }
  function F(e) {
    var t;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((t = e == null ? void 0 : e.data) == null ? void 0 : t.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  return (e, t) => {
    const r = p("common-button"), i = K, y = Q, b = W, w = J, _ = X, C = p("common-select"), H = p("common-table"), D = Y, $ = p("common-dialog");
    return L(), P($, { "append-to-body": "", "close-on-click-modal": false, "before-close": n(u).cancelBCU, visible: g.value, title: n(u).bStatus.title, "show-close": true, "custom-class": "supplier-batch-add", width: "80%", top: "10vh" }, { titleRight: a(() => [l(r, { size: "default", type: "success", icon: "el-icon-plus", onClick: t[0] || (t[0] = (o) => n(R)(n(c).list)) }), l(r, { loading: n(u).bStatus.cu === n(m).STATUS.PROCESSING, type: "primary", size: "default", onClick: n(u).submitBCU }, { default: a(() => t[1] || (t[1] = [G(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), l(n(le), { type: "crudBatch" })]), default: a(() => [d("div", null, [l(D, { ref_key: "formRef", ref: h, model: n(c), disabled: n(u).bStatus.cu === n(m).STATUS.PROCESSING }, { default: a(() => [l(H, { data: n(c).list, "return-source-data": "", "show-empty-symbol": false, "empty-text": "暂无数据", "max-height": n(T), "default-expand-all": "", "cell-class-name": n(E), style: { width: "100%" }, "row-key": "uid" }, { default: a(() => [l(i, { label: "序号", type: "index", align: "center", width: "60" }), l(i, { prop: "name", label: "供应商名称", "min-width": "180" }, { header: a(() => [l(w, { class: "item", effect: "light", content: "长度在 2 到 32 个字符", placement: "top" }, { default: a(() => [d("div", ie, [t[2] || (t[2] = d("span", null, "供应商名称", -1)), l(b, null, { default: a(() => [l(y)]), _: 1 })])]), _: 1 })]), default: a((o) => [l(_, { modelValue: o.row.name, "onUpdate:modelValue": (s) => o.row.name = s, size: "default", style: { width: "100%" }, placeholder: "供应商名称", maxlength: "32", clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(i, { prop: "shortName", label: "供应商简称", "min-width": "150" }, { header: a(() => [l(w, { class: "item", effect: "light", content: "长度在 2 到 12 个字符", placement: "top" }, { default: a(() => [d("div", se, [t[3] || (t[3] = d("span", null, "供应商简称", -1)), l(b, null, { default: a(() => [l(y)]), _: 1 })])]), _: 1 })]), default: a((o) => [l(_, { modelValue: o.row.shortName, "onUpdate:modelValue": (s) => o.row.shortName = s, size: "default", style: { width: "100%" }, placeholder: "供应商简称", maxlength: "12", clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(i, { prop: "socialCode", label: "社会统一代码", "min-width": "150" }, { default: a((o) => [l(_, { modelValue: o.row.socialCode, "onUpdate:modelValue": (s) => o.row.socialCode = s, size: "default", style: { width: "100%" }, placeholder: "社会统一代码", maxlength: "18", clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(i, { prop: "classification", label: "供应商分类", "min-width": "180" }, { default: a((o) => [l(C, { modelValue: o.row.classification, "onUpdate:modelValue": (s) => o.row.classification = s, options: n(te).ENUM, multiple: "", clearable: "", type: "enum", placeholder: "供应商分类", style: { width: "100%" }, onChange: (s) => M(s, o.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), l(i, { prop: "classifyId", label: "评价分类", "min-width": "180" }, { default: a((o) => [l(C, { modelValue: o.row.classifyId, "onUpdate:modelValue": (s) => o.row.classifyId = s, options: f.value, clearable: "", placeholder: "评价分类", style: { width: "100%" }, onChange: (s) => O(s, o.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), l(i, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: a((o) => [l(r, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: j((s) => n(N)(n(c).list, o.$index), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["model", "disabled"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  pe as default
};
