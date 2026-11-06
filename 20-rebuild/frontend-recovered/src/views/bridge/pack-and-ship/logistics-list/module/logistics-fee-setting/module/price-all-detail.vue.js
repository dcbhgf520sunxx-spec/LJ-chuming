import { resolveComponent as m } from "vue";
import { openBlock as u } from "vue";
import { createBlock as w } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as t } from "vue";
import { toDisplayString as o } from "vue";
import { unref as e } from "vue";
import { normalizeClass as _ } from "vue";
import { createVNode as i } from "vue";
import { createElementBlock as T } from "vue";
import { createCommentVNode as I } from "vue";
import { isRef as B } from "vue";
import { ElTableColumn as C } from "element-plus";
import { _ as H, t as k, u as D, o as E, bs as f, bB as s } from "../../../../../../../shared/runtime.js";
const z = { class: "tip-header" }, M = { style: { "font-size": "16px", "margin-right": "3px" } }, N = { style: { "margin-right": "3px" } }, P = { __name: "price-all-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(l, { emit: g }) {
  const { decimalPrecision: p } = k(), b = l, y = g, { visible: n, handleClose: x } = D({ emit: y, props: b }), { maxHeight: h } = E({ extraBox: [".el-dialog__header", "tip-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, n);
  return (R, r) => {
    const c = C, V = m("common-table"), v = m("common-dialog");
    return u(), w(v, { "append-to-body": "", modelValue: e(n), "onUpdate:modelValue": r[0] || (r[0] = (a) => B(n) ? n.value = a : null), top: "10vh", width: "600px", "before-close": e(x), title: "运输价格详情", center: false, "close-on-click-modal": false }, { default: d(() => [t("div", z, [t("div", null, [t("span", M, "基础价格：" + o(e(f)(l.detailInfo.price, e(p).bridge)), 1), t("span", { class: _(l.detailInfo.priceType === e(s).WEIGHT.V ? "blue" : "orange") }, o(e(s).V[l.detailInfo.priceType].unit), 3)]), r[1] || (r[1] = t("div", { style: { color: "green", "font-size": "12px", "margin-bottom": "15px" } }, "*没有填写价格的车型，按照基础价格计算", -1))]), i(V, { ref: "detailRef", border: "", data: l.detailInfo.list, "max-height": e(h), style: { width: "100%" }, class: "table-form", "return-source-data": "" }, { default: d(() => [i(c, { label: "序号", type: "index", align: "center", width: "55" }), i(c, { prop: "carModel", label: "车型", align: "center" }), i(c, { prop: "priceType", label: "计价方式", align: "center" }, { default: d((a) => [t("span", null, o(e(s).VL[a.row.priceType]), 1)]), _: 1 }), i(c, { prop: "price", label: "价格", align: "right" }, { default: d((a) => [t("span", N, o(e(f)(a.row.price, e(p).bridge)), 1), a.row.price ? (u(), T("span", { key: 0, class: _(a.row.priceType === e(s).WEIGHT.V ? "blue" : "orange") }, o(e(s).V[a.row.priceType].unit), 3)) : I("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, G = H(P, [["__scopeId", "data-v-15dc399a"]]);
export {
  G as default
};
