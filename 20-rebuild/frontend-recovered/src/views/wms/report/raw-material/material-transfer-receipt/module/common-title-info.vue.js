import { computed as k } from "vue";
import { resolveDirective as n } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as r } from "vue";
import { withDirectives as s } from "vue";
import { unref as j } from "vue";
import { createBlock as w } from "vue";
import { createCommentVNode as a } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as m } from "vue";
import { Fragment as b } from "vue";
import { ElTag as x } from "element-plus";
import { _ as v, zd as p } from "../../../../../../shared/runtime.js";
const T = { key: 1, class: "borrow-info" }, g = { key: 0, class: "project-ware-text" }, h = { key: 2, class: "direction-text" }, N = { key: 0, class: "project-ware-text" }, B = { key: 1, class: "public-ware-text" }, D = { key: 2 }, R = { key: 3 }, S = { __name: "common-title-info", props: { detail: { type: Object, default: () => ({ direction: {} }) } }, setup(e) {
  const i = e, y = k(() => i.detail.direction && i.detail.transferType !== p.RETURN_PARTY_A.V);
  return (E, o) => {
    const f = x, _ = n("parse-enum"), c = n("parse-project"), l = n("empty-text");
    return t(), r(b, null, [e.detail.transferType ? s((t(), w(f, { key: 0, effect: "plain", type: e.detail.boolBorrowReturnNotSelf ? "danger" : void 0, style: { "margin-right": "20px" } }, null, 8, ["type"])), [[_, { e: j(p), v: e.detail.transferType }]]) : a("", true), e.detail.borrowProject ? (t(), r("span", T, [o[0] || (o[0] = d("span", { class: "label" }, "借用项目：", -1)), e.detail.direction.project ? s((t(), r("span", g, null, 512)), [[c, { project: e.detail.borrowProject, onlyShortName: true }], [l]]) : a("", true)])) : a("", true), y.value ? (t(), r("span", h, [o[1] || (o[1] = d("span", { class: "label" }, "调拨至：", -1)), e.detail.direction.project ? s((t(), r("span", N, null, 512)), [[c, { project: e.detail.direction.project, onlyShortName: true }], [l]]) : (t(), r("span", B, "公共库")), o[2] || (o[2] = u("   -   ")), e.detail.direction.workshop ? (t(), r("span", D, m(e.detail.direction.workshop.name), 1)) : a("", true), o[3] || (o[3] = u("   -   ")), e.detail.direction.warehouse ? (t(), r("span", R, m(e.detail.direction.warehouse.name), 1)) : a("", true)])) : a("", true)], 64);
  };
} }, P = v(S, [["__scopeId", "data-v-1bd4450b"]]);
export {
  P as default
};
