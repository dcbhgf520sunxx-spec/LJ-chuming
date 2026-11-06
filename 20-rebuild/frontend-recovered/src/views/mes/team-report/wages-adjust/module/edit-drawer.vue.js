import { ref as l } from "vue";
import { inject as N } from "vue";
import { watch as te } from "vue";
import { computed as ae } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as oe } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as n } from "vue";
import { withCtx as r } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as h } from "vue";
import { createTextVNode as R } from "vue";
import { unref as c } from "vue";
import { createElementVNode as $ } from "vue";
import { Fragment as E } from "vue";
import { renderList as ne } from "vue";
import { toDisplayString as H } from "vue";
import { createCommentVNode as ie } from "vue";
import { isRef as se } from "vue";
import { ElTag as le } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { vLoading as ce } from "element-plus";
import { p as de, t as ue } from "../../../../../modules/index-31ff7034.js";
import { _ as pe, t as me, u as fe, o as ve, i as _e, aT as ye } from "../../../../../shared/runtime.js";
import { _ as be } from "../../../../../modules/index-3b2628f3.js";
import ge from "./edit-preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
const he = { class: "tag-content" }, we = { key: 0, style: { "font-size": "12px", color: "red", "margin-left": "10px" } }, Te = { __name: "edit-drawer", props: { visible: { type: Boolean, default: false }, productType: { type: Number }, productTypeText: { type: String }, detailInfo: { type: Object } }, emits: ["update:visible", "refresh"], setup(i, { emit: L }) {
  const { decimalPrecision: Q } = me(), w = l(), T = L, d = i, { visible: _, handleClose: x } = fe({ emit: T, props: d, field: "visible", closeHook: G }), U = N("permission"), j = [["wageQuotaTypeStr", ["parse-enum", ye], { source: "wageQuotaType" }]], { maxHeight: F } = ve({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, w);
  te(() => d.visible, (a) => {
    a && M();
  }, { immediate: true });
  function M() {
    O(), b.value = false;
  }
  const I = N("organizationType"), q = l(false), y = l(false), m = l([]), p = l([]), s = l(), b = l(false), k = ae(() => m.value.filter((a) => _e(a.price)));
  async function O() {
    var a, e;
    try {
      const { content: o } = await de({ id: (a = d.detailInfo) == null ? void 0 : a.id, productType: d.productType });
      p.value = o, o && o.length && (s.value = (e = o[0]) == null ? void 0 : e.id, V());
    } catch (o) {
      console.log("获取工序", o);
    }
  }
  function W(a) {
    s.value = a.id, V();
  }
  async function V() {
    var a;
    try {
      const { content: e } = await ue({ processId: s.value, productId: (a = d.detailInfo) == null ? void 0 : a.id, productType: d.productType, organizationType: I });
      m.value = e;
    } catch (e) {
      console.log("获取工序", e);
    }
  }
  function A() {
    b.value = true, x();
  }
  function G() {
    s.value = void 0, m.value = [], p.value = [], b.value && T("refresh");
  }
  return (a, e) => {
    var C, B, D, S;
    const o = v("common-button"), J = le, f = re, K = v("common-input-number"), X = v("common-table"), Y = v("common-drawer"), Z = oe("permission"), ee = ce;
    return u(), g(E, null, [n(Y, { ref_key: "drawerRef", ref: w, title: `${i.productTypeText}：${(C = i.detailInfo) != null && C.name ? ((B = i.detailInfo) == null ? void 0 : B.name) + "-" : ""}${(D = i.detailInfo) == null ? void 0 : D.serialNumber}`, modelValue: c(_), "onUpdate:modelValue": e[1] || (e[1] = (t) => se(_) ? _.value = t : null), direction: "rtl", "before-close": c(x), size: "60%" }, { titleRight: r(() => [P((u(), h(o, { type: "primary", size: "default", disabled: !k.value.length, onClick: e[0] || (e[0] = (t) => y.value = true) }, { default: r(() => e[3] || (e[3] = [R("预览并保存")])), _: 1, __: [3] }, 8, ["disabled"])), [[Z, c(U).edit]])]), content: r(() => [$("div", he, [(u(true), g(E, null, ne(p.value, (t) => (u(), h(J, { key: t.id, hit: "", effect: s.value === t.id ? "light" : "plain", type: s.value === t.id ? "success" : "info", onClick: (z) => W(t) }, { default: r(() => [R(H(t.name), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"]))), 128)), !p.value || !p.value.length ? (u(), g("span", we, "*暂未获取到工序")) : ie("", true)]), P((u(), h(X, { ref: "tableRef", "return-source-data": "", "show-empty-symbol": false, "data-format": j, data: m.value, "max-height": c(F), "row-key": "rowId", style: { width: "100%" } }, { default: r(() => [n(f, { label: "序号", type: "index", align: "center", width: "60" }), n(c(be), { showFactory: "", showWorkshop: "", showProductionLine: "", showTeam: "" }), n(f, { align: "center", prop: "prop", label: "结算方式" }, { default: r(({ row: t }) => [$("span", null, H(t.wageQuotaTypeStr), 1)]), _: 1 }), n(f, { align: "center", prop: "wages", label: "定额单价" }), n(f, { align: "center", prop: "price", label: "修改后单价", width: "200" }, { default: r(({ row: t }) => [n(K, { modelValue: t.price, "onUpdate:modelValue": (z) => t.price = z, placeholder: "请输入单价", precision: c(Q).mes, controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[ee, q.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]), n(ge, { visible: y.value, "onUpdate:visible": e[2] || (e[2] = (t) => y.value = t), "modified-data": k.value, data: { processId: s.value, productId: (S = i.detailInfo) == null ? void 0 : S.id, productType: i.productType, organizationType: c(I) }, onSuccess: A }, null, 8, ["visible", "modified-data", "data"])], 64);
  };
} }, De = pe(Te, [["__scopeId", "data-v-0ba8dc02"]]);
export {
  De as default
};
