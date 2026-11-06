import { _ as q, l1 as G, G as f, a as b, dp as H, j0 as y } from "../../../../../../../shared/runtime.js";
import { inject as L } from "vue";
import { ref as g } from "vue";
import { computed as N } from "vue";
import { watchEffect as U } from "vue";
import { toRefs as W } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as u } from "vue";
import { withCtx as l } from "vue";
import { unref as n } from "vue";
import { createBlock as s } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as C } from "vue";
import { renderList as K } from "vue";
import { withDirectives as Q } from "vue";
import { toDisplayString as _ } from "vue";
import { normalizeStyle as D } from "vue";
import { resolveDynamicComponent as X } from "vue";
import { defineAsyncComponent as k } from "vue";
import { ElButton as Y } from "element-plus";
import { ElCol as Z } from "element-plus";
import { ElTooltip as ee } from "element-plus";
import { ElRow as te } from "element-plus";
import { W as E } from "../../../../../../../modules/contract-9b18cc88.js";
const ae = { class: "header-container" }, ne = { class: "btn-container" }, le = { key: 0, class: "endLog-table-container" }, se = { class: "item-label" }, oe = { __name: "ProjectInfo", props: { isShowInfo: { type: Boolean, default: true } }, setup(F) {
  const w = F, { endLogTableData: I, projectInfo: d } = L("info_parent_data");
  console.log(d);
  const { _commonAttribute: A } = L("parent_data"), h = g(""), M = g(null), S = g(false), O = { collection: k(() => y(() => import("./establish/collection.vue.js"), ["static/js/collection-a7643677.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/data-039b7fd9.js", "static/css/collection-2fbdf760.css"])), billing: k(() => y(() => import("./establish/billing.vue.js"), ["static/js/billing-54bc4405.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/data-039b7fd9.js", "static/css/billing-ceadbf0c.css"])), capital: k(() => y(() => import("./establish/capital.vue.js"), ["static/js/capital-143d3c79.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/data-039b7fd9.js", "static/css/capital-cba19842.css"])), settle: k(() => y(() => import("./establish/settle.vue.js"), ["static/js/settle-1c55d7e1.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/self-healing-6f411a5c.js", "static/css/settle-fba92ebf.css"])) }, $ = N(() => O[h.value]), v = async (o) => {
    h.value = o, S.value = true;
  }, x = g([]), R = N(() => d.projectAttribute === 2);
  function B(o) {
    return "isShow" in o ? o.isShow : true;
  }
  return U(() => {
    const { projectName: o, income: t, expense: r, remainingSum: m, projectManagerName: P, projectManagerAmount: T, contractSignBodyName: V, contractSignBodyAmount: e } = W(I);
    x.value = [{ label: "项目", value: o, tooltip: true, label_span: 2, value_span: 8 }, { label: "类型", value: G.VL[I.projectAttribute], label_span: 2, value_span: 5 }, { label: "项目经理", value: d.projectManagerName, defaultValue: "-", label_span: 2, value_span: 5 }, { label: "收入", value: t, style: "color: #09945a; font-weight: 700", label_span: 2, value_span: 8 }, { label: "支出", value: r, style: "color: #fcb507; font-weight: 700", label_span: 2, value_span: 5 }, { label: "项目结余", value: m, style: "color: #409EFF; font-weight: 700", label_span: 2, value_span: 5 }, { label: V, value: e, style: "color: #409EFF; font-weight: 700", label_span: 6, value_span: 6, tooltip: false, endTxt: "结余", isShow: R.value }, { label: P, value: T, style: "color: #409EFF; font-weight: 700", label_span: 3, value_span: 9, endTxt: "结余", isShow: R.value }];
  }), (o, t) => {
    const r = Y, m = Z, P = ee, T = te, V = J("ellipsis");
    return a(), i(C, null, [j("div", ae, [u(H, { "header-title": "" }, { headerLeft: l(() => [j("div", ne, [n(A).btnType === "income" && n(f)(n(E).innerPackAge.collection.add) ? (a(), s(r, { key: 0, type: "success", onClick: t[0] || (t[0] = (e) => v("collection")) }, { default: l(() => [u(b, { class: "icon", "icon-class": "contract-collection" }), t[5] || (t[5] = p(" 创建收款 "))]), _: 1 })) : c("", true), n(A).btnType === "income" && n(f)(n(E).innerPackAge.billing.add) ? (a(), s(r, { key: 1, type: "warning", onClick: t[1] || (t[1] = (e) => v("billing")) }, { default: l(() => [u(b, { class: "icon", "icon-class": "contract-invoice" }), t[6] || (t[6] = p(" 创建开票 "))]), _: 1 })) : c("", true), n(A).btnType === "register" && n(f)(n(E).innerPackAge.register.add) ? (a(), s(r, { key: 2, type: "primary", onClick: t[2] || (t[2] = (e) => v("capital")) }, { default: l(() => [u(b, { class: "icon", "icon-class": "contract-register" }), t[7] || (t[7] = p(" 创建注资 "))]), _: 1 })) : c("", true), n(f)(n(E).innerPackAge.settle.add) ? (a(), s(r, { key: 3, disabled: n(d).status === 8, size: "default", type: "primary", onClick: t[3] || (t[3] = (e) => v("settle")) }, { default: l(() => [u(b, { class: "icon", "icon-class": "contract-settle" }), t[8] || (t[8] = p(" 项目结算 "))]), _: 1 }, 8, ["disabled"])) : c("", true)])]), _: 1 })]), w.isShowInfo ? (a(), i("div", le, [u(T, null, { default: l(() => [(a(true), i(C, null, K(x.value, (e, z) => (a(), i(C, { key: z }, [B(e) ? (a(), s(m, { key: 0, span: e.label_span, class: "col-container center" }, { default: l(() => [Q((a(), i("span", se, [p(_(e.label) + " " + _(e.endTxt ?? ""), 1)])), [[V]])]), _: 2 }, 1032, ["span"])) : c("", true), B(e) ? (a(), s(m, { key: 1, span: e.value_span, class: "col-container value-col" }, { default: l(() => [e.tooltip ? (a(), s(P, { key: 0, content: e.value, placement: "right-start" }, { default: l(() => [j("span", { style: D(e.style) }, _(e.value), 5)]), _: 2 }, 1032, ["content"])) : e.defaultValue && !e.value ? (a(), i("span", { key: 1, style: D(e.style) }, _(e.defaultValue), 5)) : (a(), i("span", { key: 2, style: D(e.style) }, _(e.value), 5))]), _: 2 }, 1032, ["span"])) : c("", true)], 64))), 128))]), _: 1 })])) : c("", true), (a(), s(X($.value), { ref_key: "currentComRef", ref: M, visible: S.value, "onUpdate:visible": t[4] || (t[4] = (e) => S.value = e) }, null, 40, ["visible"]))], 64);
  };
} }, ue = q(oe, [["__scopeId", "data-v-8ec718f8"]]);
export {
  ue as default
};
