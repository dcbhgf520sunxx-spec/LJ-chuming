import { ref as f } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as T } from "vue";
import { withDirectives as w } from "vue";
import { vShow as k } from "vue";
import { unref as t } from "vue";
import { createVNode as r } from "vue";
import { withCtx as u } from "vue";
import { createBlock as V } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as B } from "vue";
import { createCommentVNode as R } from "vue";
import { Fragment as D } from "vue";
import { ElInput as U } from "element-plus";
import { ms as x, B as M, q, C as _, G as O, E as W, t3 as $, Y as z, t4 as G, t5 as H, t0 as Q, t6 as v } from "../../../../../shared/runtime.js";
import F from "../../../../supply-chain/components/audit-records.vue.js";
const X = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, APPtotal: { type: [Number, String], default: void 0 }, subTotal: { type: [Number, String], default: void 0 }, rejTotal: { type: [Number, String], default: void 0 } }, emits: ["currentChange", "handleUpload"], setup(d, { emit: I }) {
  const N = { monomerId: void 0, dataType: x.BLUEPRINT.V }, y = I, { crud: o, query: s } = M(N), m = f(false), i = d, p = f(false), a = f({});
  async function b() {
    try {
      m.value = true, await z(G, { projectId: o.query.projectId, dataType: o.query.dataType, monomerId: o.query.monomerId });
    } catch (n) {
      console.log("根据单体下载", n);
    } finally {
      m.value = false;
    }
  }
  function A(n) {
    y("currentChange", n);
  }
  function L(n) {
    const e = n;
    a.value.moduleType = H.PLAN_MANAGEMENT.V, a.value.componentNameList = [Q.PLAN_CONSTRUCTION_BLUEPRINT.V], e === 1 ? (a.value.reviewStatus = v.WITHDRAW.V, a.value.waitMeCheck = true, a.value.meLaunch = false) : e === 2 ? (a.value.reviewStatus = v.WITHDRAW.V, a.value.waitMeCheck = false, a.value.meLaunch = true) : e === 3 && (a.value.reviewStatus = v.REJECT.V, a.value.waitMeCheck = false, a.value.meLaunch = false), p.value = true;
  }
  return (n, e) => {
    const P = U, g = j("common-button"), S = E("permission");
    return c(), h(D, null, [T("div", null, [w(T("div", null, [r(t(q), { ref: "monomerSelectRef", modelValue: t(s).monomerId, "onUpdate:modelValue": e[0] || (e[0] = (l) => t(s).monomerId = l), default: false, "project-id": i.projectId, class: "filter-item", clearable: "", onChange: t(o).toQuery, onGetCurrentInfo: A }, null, 8, ["modelValue", "project-id", "onChange"]), r(P, { modelValue: t(s).fileName, "onUpdate:modelValue": e[1] || (e[1] = (l) => t(s).fileName = l), class: "filter-item", clearable: "", placeholder: "输入文件名搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), r(t(_))], 512), [[k, t(o).searchToggle]]), r(t(W), { permission: t(o).permission }, { optLeft: u(() => [w((c(), V(g, { class: "filter-item", size: "default", type: "warning", onClick: e[2] || (e[2] = (l) => y("handleUpload")) }, { default: u(() => e[6] || (e[6] = [C(" 文件导入 ")])), _: 1, __: [6] })), [[S, t(o).permission.import]])]), viewLeft: u(() => [d.projectId && t(O)(t(o).permission.download) ? (c(), V(g, { key: 0, disabled: !d.projectId || t(o).data.length === 0, loading: m.value, icon: "el-icon-download", size: "default", type: "warning", onClick: e[3] || (e[3] = (l) => b()) }, { default: u(() => [C(B(t(s).monomerId ? "下载本单体下所有文件" : "下载项目下所有文件"), 1)]), _: 1 }, 8, ["disabled", "loading"])) : R("", true), r(F, { "module-type": t(H).PLAN_MANAGEMENT.V, "component-name-list": t(Q).PLAN_CONSTRUCTION_BLUEPRINT.V, APPtotal: i.APPtotal, "rej-total": i.rejTotal, subTotal: i.subTotal, style: { "margin-left": "10px", "padding-right": "10px" }, onHandleSuccess: () => t(o).toQuery() }, null, 8, ["module-type", "component-name-list", "APPtotal", "rej-total", "subTotal"])]), _: 1 }, 8, ["permission"])]), r($, { modelValue: p.value, "onUpdate:modelValue": e[4] || (e[4] = (l) => p.value = l), form: a.value, onSuccess: e[5] || (e[5] = (l) => t(o).toQuery()) }, null, 8, ["modelValue", "form"])], 64);
  };
} };
export {
  X as default
};
