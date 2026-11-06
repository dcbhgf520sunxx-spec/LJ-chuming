import { ref as q } from "vue";
import { inject as f } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as l } from "vue";
import { createBlock as k } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as n } from "vue";
import { unref as t } from "vue";
import { createElementBlock as r } from "vue";
import { createCommentVNode as _ } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as c } from "vue";
import { isRef as O } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElTooltip as K } from "element-plus";
import { ElForm as L } from "element-plus";
import { _ as G, u as z, tC as J, o as Q, i as B, ky as W, ba as X } from "../../../../../../shared/runtime.js";
import Y from "../../../../../wms/material-inbound/raw-material/application/components/common-footer.vue.js";
const Z = { style: { "margin-left": "5px" } }, $ = { key: 0, style: { "margin-left": "10px" } }, ee = { key: 1, style: { "margin-left": "10px" } }, te = { __name: "confirm-dialog", props: { modelValue: { type: Boolean, default: false }, basicClass: { type: Number } }, emits: ["saveSuccess", "update:modelValue"], setup(S, { emit: C }) {
  const H = C, E = S, M = q([]), { visible: m, handleClose: b } = z({ emit: H, props: E, closeHook: U }), { cu: P, form: g, FORM: x } = J(), { maxHeight: R } = Q({ mainBox: ".inbound-application-preview", extraBox: [".el-dialog__header", ".logistics-form-content", ".footer"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, m), y = f("currentMonomer"), h = f("currentArea"), w = f("globalProject");
  x.HOOK.afterSubmit = () => {
    b();
  };
  function U() {
    M.value = [];
  }
  function D(v) {
    return X(v, { props: ["quantity", "mete"] });
  }
  return (v, d) => {
    const s = I, N = K, T = V("common-table"), F = L, j = V("common-dialog"), i = A("empty-text");
    return l(), k(j, { "custom-class": "inbound-application-preview", title: "提交预览", "append-to-body": "", modelValue: t(m), "onUpdate:modelValue": d[0] || (d[0] = (e) => O(m) ? m.value = e : null), width: "1200px", "before-close": t(b), top: "5vh", fullscreen: "" }, { titleAfter: a(() => [u("span", null, [d[1] || (d[1] = p("项目:")), u("span", null, n(t(w).serialNumber), 1), u("span", Z, n(t(w).shortName), 1)]), t(B)(t(y)) ? (l(), r("span", $, "单体:" + n(t(y).name), 1)) : _("", true), t(B)(t(h)) ? (l(), r("span", ee, "区域:" + n(t(h).name), 1)) : _("", true)]), default: a(() => [t(m) ? (l(), k(F, { key: 0, ref: "formRef", model: t(g), disabled: t(P).status.edit === t(x).STATUS.PROCESSING }, { default: a(() => [o(T, { data: t(g).list, "max-height": t(R), "show-summary": "", "summary-method": D, "return-source-data": "", showEmptySymbol: false }, { default: a(() => [o(s, { prop: "serialNumber", label: "编号", align: "center", width: "110px", fixed: "left", "show-overflow-tooltip": "" }), o(s, { prop: "classifyName", label: "名称", align: "center", fixed: "left", "min-width": "150", "show-overflow-tooltip": "" }, { default: a(({ row: e }) => [o(N, { content: e.classifyParentFullName, disabled: !e.classifyParentFullName, "show-after": 500, placement: "top" }, { default: a(() => [c(u("span", null, null, 512), [[i, e.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), o(s, { prop: "specification", label: "规格", align: "center", "min-width": "200px", fixed: "left", "show-overflow-tooltip": "" }, { default: a(({ row: e }) => [o(N, { content: e.specificationLabels, placement: "top" }, { default: a(() => [c(u("span", null, null, 512), [[i, e.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), o(s, { prop: "measureUnit", label: "计量单位", align: "center", "min-width": "70px" }, { default: a(({ row: e }) => [c((l(), r("span", null, [p(n(e.measureUnit), 1)])), [[i]])]), _: 1 }), o(s, { prop: "quantity", label: "数量", align: "center", "min-width": "120px" }, { default: a(({ row: e }) => [c((l(), r("span", null, [p(n(e.quantity), 1)])), [[i]])]), _: 1 }), o(s, { prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "70px" }, { default: a(({ row: e }) => [c((l(), r("span", null, [p(n(e.accountingUnit), 1)])), [[i]])]), _: 1 }), o(s, { prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: a(({ row: e }) => [c((l(), r("span", null, [p(n(e.mete), 1)])), [[i]])]), _: 1 }), o(s, { prop: "color", label: "颜色", align: "center", "min-width": "120px" }, { default: a(({ row: e }) => [c((l(), r("span", null, [p(n(e.color), 1)])), [[i]])]), _: 1 }), o(s, { prop: "brand", label: "品牌", align: "center", "min-width": "120px" }, { default: a(({ row: e }) => [c((l(), r("span", null, [p(n(e.brand), 1)])), [[i]])]), _: 1 }), o(s, { prop: "useProperty", label: "使用范围", align: "center" }, { default: a(({ row: e }) => [c((l(), r("span", null, [p(n(t(W).VL[e.useProperty]), 1)])), [[i]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["model", "disabled"])) : _("", true), o(Y, { class: "footer", "show-total": false, "is-submit": "" })]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = G(te, [["__scopeId", "data-v-b12664bf"]]);
export {
  ne as default
};
