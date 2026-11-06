import { resolveComponent as m } from "vue";
import { openBlock as u } from "vue";
import { createBlock as w } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as o } from "vue";
import { unref as e } from "vue";
import { normalizeClass as _ } from "vue";
import { createVNode as s } from "vue";
import { createElementBlock as T } from "vue";
import { createCommentVNode as I } from "vue";
import { isRef as B } from "vue";
import { ElTableColumn as C } from "element-plus";
import { _ as H, t as k, u as D, o as E, bs as f, bB as i } from "../../../../../../../shared/runtime.js";
const z = { class: "tip-header" }, M = { style: { "font-size": "16px", "margin-right": "3px" } }, N = { style: { "margin-right": "3px" } }, P = { __name: "price-all-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(l, { emit: g }) {
  const { decimalPrecision: d } = k(), b = l, h = g, { visible: n, handleClose: y } = D({ emit: h, props: b }), { maxHeight: x } = E({ extraBox: [".el-dialog__header", "tip-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, n);
  return (R, r) => {
    const c = C, V = m("common-table"), v = m("common-dialog");
    return u(), w(v, { "append-to-body": "", modelValue: e(n), "onUpdate:modelValue": r[0] || (r[0] = (t) => B(n) ? n.value = t : null), top: "10vh", width: "600px", "before-close": e(y), title: "运输价格详情", center: false, "close-on-click-modal": false }, { default: p(() => [a("div", z, [a("div", null, [a("span", M, "基础价格：" + o(e(f)(l.detailInfo.price, e(d).shipment)), 1), a("span", { class: _(l.detailInfo.priceType === e(i).WEIGHT.V ? "blue" : "orange") }, o(e(i).V[l.detailInfo.priceType].unit), 3)]), r[1] || (r[1] = a("div", { style: { color: "green", "font-size": "12px", "margin-bottom": "15px" } }, "*没有填写价格的车型，按照基础价格计算", -1))]), s(V, { ref: "detailRef", border: "", data: l.detailInfo.list, "max-height": e(x), style: { width: "100%" }, class: "table-form", "return-source-data": "" }, { default: p(() => [s(c, { label: "序号", type: "index", align: "center", width: "50" }), s(c, { prop: "carModel", label: "车型", align: "center" }), s(c, { prop: "priceType", label: "计价方式", align: "center" }, { default: p((t) => [a("span", null, o(e(i).VL[t.row.priceType]), 1)]), _: 1 }), s(c, { prop: "price", label: "价格", align: "right" }, { default: p((t) => [a("span", N, o(e(f)(t.row.price, e(d).shipment)), 1), t.row.price ? (u(), T("span", { key: 0, class: _(t.row.priceType === e(i).WEIGHT.V ? "blue" : "orange") }, o(e(i).V[t.row.priceType].unit), 3)) : I("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, G = H(P, [["__scopeId", "data-v-68832f5c"]]);
export {
  G as default
};
