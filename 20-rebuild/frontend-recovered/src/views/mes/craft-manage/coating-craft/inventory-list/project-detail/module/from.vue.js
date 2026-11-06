import { ref as m } from "vue";
import { inject as U } from "vue";
import { ElMessage as Z } from "element-plus";
import { resolveComponent as C } from "vue";
import { openBlock as w } from "vue";
import { createBlock as A } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as b } from "vue";
import { unref as d } from "vue";
import { createElementBlock as ee } from "vue";
import { createCommentVNode as N } from "vue";
import { createElementVNode as te } from "vue";
import { ElDescriptionsItem as ae } from "element-plus";
import { ElDescriptions as le } from "element-plus";
import { ElRadio as oe } from "element-plus";
import { ElRadioGroup as ne } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElForm as re } from "element-plus";
import { b as de } from "../../../../../../../modules/coating-list-667107a8.js";
import { l as f, _ as ue, m as ce, ef as L, ao as me, aw as pe } from "../../../../../../../shared/runtime.js";
function fe(o) {
  return f({ url: "/api/mes/building/wage-manage/coating-process/artifact-type-list", method: "get", params: o });
}
function ke(o) {
  return f({ url: "/api/mes/building/wage-manage/coating-process/artifact-list", method: "get", params: o });
}
function we(o) {
  return f({ url: "/api/mes/building/wage-manage/coating-process", method: "post", data: o });
}
function Te(o) {
  return f({ url: "/api/mes/building/wage-manage/coating-process/no-painting-required", method: "put", data: o });
}
function ge(o) {
  return f({ url: `/api/mes/building/wage-manage/coating-process/detail/${o}`, method: "get" });
}
function _e(o) {
  return f({ url: "/api/mes/building/wage-manage/coating-process/add-artifact-list", method: "put", data: o });
}
const xe = { get: fe };
const be = { key: 0, class: "create-type" }, ye = { __name: "from", props: { selectedQuantity: { type: Number, default: 0 }, selectedSurfaceArea: { type: Number, default: 0 } }, setup(o) {
  var E;
  const { globalProject: y } = ce(["globalProject"]), j = m(), T = m(), B = m(), i = m(), g = m(true), k = m([]), x = { detailList: [{ paintType: L.PRIMER.V }, { paintType: L.INTERMEDIATE_PAINT.V }, { paintType: L.TOPCOAT.V }], contractProjectId: (E = y.value) == null ? void 0 : E.id }, { CRUD: D, crud: V, form: u } = me(x, T), I = U("getArtiList"), P = { thickness: [{ required: true, message: "请输入干膜厚度", trigger: "blur" }], paintBrand: [{ required: true, message: "请输入油漆品牌", trigger: "blur" }] }, { tableValidate: M, wrongCellMask: z } = pe({ rules: P });
  function O(n) {
    n && (u.detailList = x.detailList, i.value = void 0);
  }
  D.HOOK.beforeValidateCU = () => {
    const n = u.detailList[0], { validResult: e, dealList: c } = M([n]);
    if (!e) return e;
    let r = false;
    if (u.detailList.map((v) => {
      v.paintBrand && !v.thickness && (r = true);
    }), r) return Z.error("录入油漆品牌，干膜厚度为必填"), !r;
  };
  async function F() {
    var n;
    try {
      const { content: e } = await de({ contractProjectId: (n = y.value) == null ? void 0 : n.id });
      k.value = e.map((c) => ({ L: c.serialNumber, V: c.id }));
    } catch (e) {
      console.log(e);
    }
  }
  async function S(n) {
    try {
      const e = await ge(n);
      u.detailList = e.detailList.map((c) => c);
    } catch (e) {
      console.log(e);
    }
  }
  async function q() {
    try {
      await _e({ ...u, id: i.value });
    } catch (n) {
      console.log(n);
    }
  }
  function G(n) {
    S(n);
  }
  function Q() {
    g.value || (V.crudApi.add = q), V.submitCU(), $(), I();
  }
  const $ = U("getCoatingList");
  function H() {
    g.value = true, i.value = void 0;
  }
  return (n, e) => {
    const c = C("common-button"), r = ae, v = le, R = oe, K = ne, J = C("common-select"), _ = se, h = ie, W = C("common-table"), X = re, Y = C("common-drawer");
    return w(), A(Y, { ref_key: "drawerRef", ref: j, "append-to-body": "", "close-on-click-modal": false, visible: d(V).status.cu > 0, title: "涂装工艺录入", "before-close": d(V).cancelCU, onOpen: F, onClose: H, size: "40%" }, { titleRight: l(() => [a(c, { type: "success", size: "default", onClick: Q }, { default: l(() => e[2] || (e[2] = [p("保存")])), _: 1, __: [2] })]), content: l(() => [a(v, { column: 2, border: "" }, { default: l(() => [a(r, { label: "项目", align: "center", span: 2 }, { default: l(() => {
      var t, s;
      return [p(b((t = d(y)) == null ? void 0 : t.serialNumber) + " " + b((s = d(y)) == null ? void 0 : s.shortName), 1)];
    }), _: 1 }), a(r, { label: "构件数量", align: "center", span: 1 }, { default: l(() => [p(b(o.selectedQuantity) + "件", 1)]), _: 1 }), a(r, { label: "总面积", align: "center", span: 1 }, { default: l(() => [p(b(o.selectedSurfaceArea) + "m²", 1)]), _: 1 })]), _: 1 }), a(X, { ref_key: "formRef", ref: T, model: d(u), size: "default", "label-width": "80px" }, { default: l(() => [k.value.length > 0 ? (w(), ee("div", be, [a(K, { modelValue: g.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => g.value = t), onChange: O, style: { "margin-top": "10px" } }, { default: l(() => [a(R, { value: true }, { default: l(() => e[3] || (e[3] = [p("创建新工艺")])), _: 1, __: [3] }), a(R, { value: false }, { default: l(() => e[4] || (e[4] = [p("加入到原有工艺")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"]), g.value ? N("", true) : (w(), A(J, { key: 0, modelValue: i.value, "onUpdate:modelValue": e[1] || (e[1] = (t) => i.value = t), options: k.value, class: "select", type: "enum", onChange: G }, null, 8, ["modelValue", "options"]))])) : N("", true), a(W, { ref_key: "tableRef", ref: B, data: d(u).detailList, "cell-class-name": d(z), "return-source-data": "", "show-empty-symbol": false, style: { "margin-top": "10px" } }, { default: l(() => [a(_, { prop: "paintType", label: "油漆类型", align: "center" }, { default: l(({ row: t }) => [te("span", null, b(d(L).VL[t.paintType]), 1)]), _: 1 }), a(_, { prop: "paintBrand", label: "油漆品牌", align: "center" }, { default: l(({ row: t }) => [a(h, { modelValue: t.paintBrand, "onUpdate:modelValue": (s) => t.paintBrand = s, modelModifiers: { trim: true }, disabled: i.value !== void 0, type: "text", placeholder: "油漆品牌", size: "default", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), a(_, { prop: "paintCategory", label: "油漆种类", align: "center" }, { default: l(({ row: t }) => [a(h, { modelValue: t.paintCategory, "onUpdate:modelValue": (s) => t.paintCategory = s, modelModifiers: { trim: true }, disabled: i.value !== void 0, type: "text", placeholder: "油漆种类", size: "default", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), a(_, { prop: "thickness", label: "干膜厚度", align: "center" }, { default: l(({ row: t }) => [a(h, { modelValue: t.thickness, "onUpdate:modelValue": (s) => t.thickness = s, modelModifiers: { trim: true }, disabled: i.value !== void 0, oninput: "value=value.replace(/[^\\d.]/g, '')", type: "text", placeholder: "干膜厚度", size: "default", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), a(_, { prop: "remark", label: "备注", align: "center" }, { default: l(({ row: t }) => [a(h, { modelValue: t.remark, "onUpdate:modelValue": (s) => t.remark = s, modelModifiers: { trim: true }, disabled: i.value !== void 0, rows: 2, type: "textarea", size: "default", maxlength: "100", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, Ve = ue(ye, [["__scopeId", "data-v-fff07c9e"]]), Ee = Object.freeze(Object.defineProperty({ __proto__: null, default: Ve }, Symbol.toStringTag, { value: "Module" }));
export {
  we as a,
  xe as c,
  Ee as f,
  ke as g,
  Ve as m,
  Te as s
};
