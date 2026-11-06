import { useStore as J } from "vuex";
import { ref as c } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as h } from "vue";
import { createBlock as U } from "vue";
import { withCtx as p } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as v } from "vue";
import { createTextVNode as $ } from "vue";
import { ElNotification as Q } from "element-plus";
import { ElInput as X } from "element-plus";
import { ElFormItem as Z } from "element-plus";
import { ElForm as L } from "element-plus";
import { computed as F } from "vue";
import { watch as O } from "vue";
import { nextTick as ee } from "vue";
import { resolveDirective as P } from "vue";
import { createElementBlock as H } from "vue";
import { toDisplayString as ae } from "vue";
import { withDirectives as M } from "vue";
import { unref as b } from "vue";
import { createCommentVNode as le } from "vue";
import { withModifiers as te } from "vue";
import { normalizeClass as oe } from "vue";
import { Plus as ne } from "@element-plus/icons-vue";
import { ElIcon as se } from "element-plus";
import { ElPopover as ie } from "element-plus";
import { inject as re } from "vue";
import { isRef as ue } from "vue";
import { ElDatePicker as de } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { vLoading as pe } from "element-plus";
import { bH as K, lk as me, _ as G, ll as fe, lm as _e, ln as be, i as ve, b as R, iW as ye, ai as ge, u as he, e6 as Ce, ec as Ve, D as we, eb as xe } from "../../../../../shared/runtime.js";
import { u as Te } from "../../../../../modules/useTableTotal-3d22365a.js";
import { u as Se } from "../../../../../modules/useTableHeight-90797a0b.js";
import ke from "../components/purchase-select.vue.js";
import { g as De } from "../../../../../modules/index-1f7d934b.js";
const Be = { style: { "text-align": "right" } }, Ie = { __name: "add-supplier", emits: ["close"], setup(A, { emit: D }) {
  const C = D, e = J(), k = c(), r = c(false), u = { name: "", socialCode: "", supplierClass: K.LOGISTICS.V, supplierClassification: K.LOGISTICS.V }, d = c({ ...u }), y = { name: [{ required: true, message: "请输入供应商名称", trigger: "blur" }, { min: 2, max: 32, message: "长度在 2 到 32 个字符", trigger: "blur" }], supplierClass: [{ required: true, message: "请选择供应商分类", trigger: "blur" }] };
  function B() {
    d.value = { ...u };
  }
  async function I() {
    const w = await k.value.validate();
    try {
      w && (r.value = true, await me([{ ...d.value }]), V(), B(), Q({ title: "新增成功", type: "success" }), e.dispatch("config/fetchSuppliers"));
    } catch (i) {
      console.log("新增供应商", i);
    } finally {
      r.value = false;
    }
  }
  function V() {
    C("close");
  }
  return (w, i) => {
    const f = X, x = Z, s = N("common-button"), E = L;
    return h(), U(E, { ref_key: "formRef", ref: k, model: d.value, rules: y, size: "default", "label-width": "100px" }, { default: p(() => [n(x, { label: "物流单位", prop: "name" }, { default: p(() => [n(f, { modelValue: d.value.name, "onUpdate:modelValue": i[0] || (i[0] = (T) => d.value.name = T), maxlength: "32", "show-word-limit": "", placeholder: "请输入供应商名称" }, null, 8, ["modelValue"])]), _: 1 }), n(x, { label: "社会统一代码", prop: "socialCode" }, { default: p(() => [n(f, { modelValue: d.value.socialCode, "onUpdate:modelValue": i[1] || (i[1] = (T) => d.value.socialCode = T), placeholder: "请输入社会统一代码", maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), v("div", Be, [n(s, { loading: r.value, type: "primary", size: "default", onClick: I }, { default: p(() => i[2] || (i[2] = [$("提 交")])), _: 1, __: [2] }, 8, ["loading"]), n(s, { size: "default", onClick: V }, { default: p(() => i[3] || (i[3] = [$("关闭")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"]);
  };
} };
const Ee = { class: "customize-option-item" }, Ne = { class: "flex-rsc label" }, Ae = { key: 0, class: "extra-label" }, ze = { key: 1 }, He = { __name: "index", props: { modelValue: { type: [Number, String, Array] }, basicClass: { type: Number }, logisticsCreateable: { type: Boolean, default: false }, showType: { type: Boolean, default: true }, type: { type: Number }, mode: { type: String, default: "contained" }, typeMode: { type: String, default: "cross" }, showHide: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择供应商" }, isAnnual: { type: Boolean, default: false } }, emits: ["change", "info-change", "update:modelValue"], setup(A, { emit: D }) {
  const C = D, e = A, k = { add: ["scm_supplier:add"] }, r = c(false), u = c(), { loaded: d, suppliers: y, supplierKV: B } = fe(E), { annualLoaded: I, annualSuppliers: V, annualSupplierKV: w } = _e(), i = F(() => e.isAnnual ? I : d), f = F(() => {
    let l = [];
    if (e.isAnnual ? l = V.value : l = e.showHide ? y.value : y.value.filter((a) => a.boolHide === be.FALSE.V), e.basicClass) {
      if (e.mode === "contained") return l == null ? void 0 : l.filter((a) => (a.basicClass & e.basicClass) === a.basicClass);
      if (e.mode === "contain") return l == null ? void 0 : l.filter((a) => (a.basicClass & e.basicClass) === e.basicClass);
      if (e.mode === "cross") return l == null ? void 0 : l.filter((a) => a.basicClass & e.basicClass);
    }
    if (e.type) {
      if (e.typeMode === "contained") return l == null ? void 0 : l.filter((a) => (a.type & e.type) === a.type);
      if (e.typeMode === "contain") return l == null ? void 0 : l.filter((a) => (a.type & e.type) === e.type);
      if (e.typeMode === "cross") return l == null ? void 0 : l.filter((a) => a.type & e.type);
    }
    return l;
  });
  O(() => e.modelValue, (l) => {
    u.value = l;
  }, { immediate: true });
  function x(l) {
    let a = l;
    R(a) && (a = void 0);
    const g = !ge(a, e.modelValue), o = R(a) && R(e.modelValue);
    g && !o && (C("update:modelValue", a), C("change", a), s(a, e.modelValue));
  }
  function s(l, a) {
    const g = e.isAnnual ? w.value : B.value, o = l ? g[l] : null, t = a ? g[a] : null;
    C("info-change", o, t);
  }
  function E() {
    ve(u.value) ? s(u.value) : z();
  }
  function T() {
    r.value = false;
  }
  function z() {
    ee(() => {
      if (!(R(f.value) || u.value) && e.default) {
        u.value = f.value[0].id, x(u.value);
        return;
      }
    });
  }
  return (l, a) => {
    const g = N("common-select"), o = ne, t = se, j = ie, q = P("parse-enum"), m = P("permission");
    return h(), H("span", { class: oe([{ "show-add-icon": e.logisticsCreateable }, "supplier-sn-select-container"]) }, [n(g, { modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (_) => u.value = _), clearable: e.clearable, "collapse-tags": e.collapseTags, disabled: e.disabled, filterable: e.filterable, loading: !i.value, multiple: e.multiple, options: f.value, placeholder: e.placeholder, size: e.size, class: "supplier-sn-select", onChange: x }, { view: p(({ data: _ }) => [v("span", Ee, [v("span", Ne, [v("span", null, ae(_.name), 1)]), v("span", null, [e.showType ? (h(), H("span", Ae, [a[3] || (a[3] = v("span", { class: "title" }, "类型：", -1)), M(v("span", null, null, 512), [[q, { e: b(ye), v: _.basicClass, bit: true, split: " | " }]])])) : le("", true)])])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "filterable", "loading", "multiple", "options", "placeholder", "size"]), n(j, { visible: r.value, "onUpdate:visible": a[2] || (a[2] = (_) => r.value = _), placement: "top", width: "450" }, { reference: p(() => [e.logisticsCreateable ? (h(), H("span", { key: 0, class: "add-icon pointer", onClick: a[1] || (a[1] = te((_) => r.value = !r.value, ["stop"])) }, [M((h(), U(t, { color: "#1881ef" }, { default: p(() => [n(o)]), _: 1 })), [[m, k.add]])])) : (h(), H("span", ze))]), default: p(() => [n(Ie, { onClose: T })]), _: 1 }, 8, ["visible"])], 2);
  };
} }, Re = G(He, [["__scopeId", "data-v-794ff36a"]]);
const Ue = { class: "print-container box-container" }, je = { class: "head-container" }, qe = { __name: "expend-detail", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(A, { emit: D }) {
  const C = c(), e = A, k = D, { visible: r, handleClose: u } = he({ emit: k, props: e, field: "visible", showHook: E, closeHook: T }), { projectId: d } = re("common"), y = c(false), { tableRef: B, maxHeight: I } = Se(), { requestData: V, total: w, getSummaries: i } = Te(false, { defineData: ["paymentAmount"] }), f = c([]), x = [{ text: "上周", value: () => {
    const o = /* @__PURE__ */ new Date(), t = /* @__PURE__ */ new Date();
    return t.setTime(t.getTime() - 3600 * 1e3 * 24 * 7), [t, o];
  } }, { text: "上个月", value: () => {
    const o = /* @__PURE__ */ new Date(), t = /* @__PURE__ */ new Date();
    return t.setTime(t.getTime() - 3600 * 1e3 * 24 * 30), [t, o];
  } }, { text: "最近三个月", value: () => {
    const o = /* @__PURE__ */ new Date(), t = /* @__PURE__ */ new Date();
    return t.setTime(t.getTime() - 3600 * 1e3 * 24 * 90), [t, o];
  } }], s = c({ StartTime: void 0, endTime: void 0, number: void 0, supplierId: void 0 });
  function E() {
    l();
  }
  function T() {
    Ce(s.value);
  }
  const z = c([]);
  async function l() {
    y.value = true;
    try {
      const { content: o, totalElements: t } = await De({ projectId: d.value, ...V, ...s.value });
      z.value = Ve(o, ["expenseType"]), w.value = t;
    } catch (o) {
      console.log("获取项目支出信息失败" + o);
    } finally {
      y.value = false;
    }
  }
  const a = c([["paymentTime", ["parse-time", "{y}-{m}-{d}"]], ["paymentAmount", ["to-thousand", we.YUAN]]]), g = (o) => {
    (o == null ? void 0 : o.length) > 1 ? (s.value.StartTime = o[0], s.value.endTime = o[1]) : (s.value.StartTime = void 0, s.value.endTime = void 0);
  };
  return O(s, async (o) => {
    await l();
  }, { deep: true }), (o, t) => {
    const j = N("print-table"), q = de, m = ce, _ = N("common-table"), W = N("common-drawer"), Y = pe;
    return h(), U(W, { ref_key: "drawerRef", ref: C, modelValue: b(r), "onUpdate:modelValue": t[3] || (t[3] = (S) => ue(r) ? r.value = S : null), "append-to-body": true, "before-close": b(u), destroyOnClose: true, size: "55%", title: "项目支出明细" }, { content: p(() => [v("div", Ue, [n(j, { params: { ...s.value, projectId: b(d) }, "api-key": "expendInfoV2", size: "default", type: "warning" }, null, 8, ["params"])]), v("div", je, [n(q, { modelValue: f.value, "onUpdate:modelValue": t[0] || (t[0] = (S) => f.value = S), shortcuts: x, "end-placeholder": "结束日期", "range-separator": "-", "start-placeholder": "开始日期", type: "daterange", "unlink-panels": "", "value-format": "x", onChange: g }, null, 8, ["modelValue"]), n(Re, { modelValue: s.value.supplierId, "onUpdate:modelValue": t[1] || (t[1] = (S) => s.value.supplierId = S), "basic-class": s.value.basicClass, type: s.value.purchaseType, clearable: "", filterable: "", mode: "contain", placeholder: "筛选供应商", style: { width: "180px" } }, null, 8, ["modelValue", "basic-class", "type"]), n(ke, { modelValue: s.value.number, "onUpdate:modelValue": t[2] || (t[2] = (S) => s.value.number = S), clearable: true, detailable: false, "project-id": b(d), style: { width: "300px" } }, null, 8, ["modelValue", "project-id"])]), M((h(), U(_, { ref_key: "tableRef", ref: B, data: z.value, "data-format": a.value, "max-height": b(I), "summary-method": b(i), "show-summary": "", style: { width: "100%" } }, { default: p(() => [n(m, { align: "center", label: "序号", "min-width": "60", type: "index" }), n(m, { align: "center", label: "日期", prop: "paymentTime" }), n(m, { align: "center", label: "供应商", prop: "supplier.supplierName", "show-overflow-tooltip": "" }), n(m, { align: "center", label: "采购合同号", "min-width": "120", prop: "contractNumber", "show-overflow-tooltip": "" }), n(m, { align: "center", label: "凭证号", prop: "voucherNumber" }), n(m, { align: "center", label: "审批编号", prop: "approvalNumber" }), n(m, { align: "center", label: "支付金额", prop: "paymentAmount" }), n(m, { align: "center", label: "创建人", prop: "user.name" })]), _: 1 }, 8, ["data", "data-format", "max-height", "summary-method"])), [[Y, y.value]]), n(xe, { "request-data": b(V), total: b(w), onHandleChange: l }, null, 8, ["request-data", "total"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ge = G(qe, [["__scopeId", "data-v-13d483c5"]]);
export {
  Ge as default
};
