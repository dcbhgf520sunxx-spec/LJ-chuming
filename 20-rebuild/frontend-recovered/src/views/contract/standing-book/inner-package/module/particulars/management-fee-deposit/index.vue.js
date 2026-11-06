import { ref as m } from "vue";
import { inject as V } from "vue";
import { reactive as j } from "vue";
import { watch as $ } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as t } from "vue";
import { withCtx as n } from "vue";
import { unref as i } from "vue";
import { createBlock as h } from "vue";
import { createTextVNode as H } from "vue";
import { createCommentVNode as x } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as p } from "vue";
import { Fragment as N } from "vue";
import { ElButton as T } from "element-plus";
import { ElCol as M } from "element-plus";
import { ElRow as S } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { ElTable as A } from "element-plus";
import { _ as F, o as P, G as R, bV as d, eb as z, l8 as G, ec as L } from "../../../../../../../shared/runtime.js";
import U from "./module/dialog.vue.js";
import { W } from "../../../../../../../modules/contract-9b18cc88.js";
import "../../../../../../../modules/data-039b7fd9.js";
const J = { class: "table-container" }, K = { class: "sum-text" }, O = { key: 0, class: "sum-text" }, Q = { key: 1, class: "sum-text" }, X = { key: 0, class: "sum-text" }, Y = { key: 1, class: "sum-text" }, Z = { key: 0, class: "sum-text" }, ee = { key: 1, class: "sum-text" }, te = { __name: "index", setup(ae) {
  const { maxHeight: k } = P({ extraBox: [".el-button-group", ".create-container"], mainBox: [".app-container", ".drawer-container"], paginate: true, extraHeight: 20 }), u = m([]), g = m(0), _ = m(false), w = V("parent_data"), { projectInfo: f } = w, b = j({ pageNumber: 1, pageSize: 10 }), r = async () => {
    try {
      const { content: a, totalElements: l } = await G({ projectId: f.project.id, ...b });
      u.value = L(a), g.value = l;
    } catch {
    }
  };
  r();
  const D = (a) => a ? (a = parseFloat(a), `(${a * 100 / 100}%)`) : "", v = () => {
    _.value = true;
  };
  return $(f, (a) => {
    a.projectAttribute === 1 || r();
  }, { deep: true }), (a, l) => {
    const B = T, C = M, E = S, o = q, I = A;
    return s(), c(N, null, [t(E, { class: "create-container" }, { default: n(() => [t(C, { span: 2 }, { default: n(() => [i(R)(i(W).innerPackAge.manageFree.add) ? (s(), h(B, { key: 0, icon: "el-icon-plus", type: "primary", onClick: v }, { default: n(() => l[1] || (l[1] = [H("创建 ")])), _: 1, __: [1] })) : x("", true)]), _: 1 })]), _: 1 }), y("div", J, [t(I, { data: u.value, "max-height": i(k), style: { width: "100%" } }, { default: n(() => [t(o, { align: "center", label: "序号", "min-width": "60", type: "index" }), t(o, { align: "center", label: "日期", prop: "dateTime", width: "110" }), t(o, { align: "center", label: "收入", prop: "income", width: "110" }), t(o, { align: "center", label: "保证金" }, { default: n(() => [t(o, { align: "center", label: "扣除金额", "min-width": "130", prop: "securityDeductIncome" }, { default: n(({ row: { securityDeductIncome: e } }) => [y("span", K, p(e ? "-" + i(d)(e) : "-"), 1)]), _: 1 }), t(o, { align: "center", label: "退还记录", "min-width": "130", prop: "securityRecord" }, { default: n(({ row: { securityRecord: e } }) => [e ? (s(), c("span", O, p(`${i(d)(e)}`), 1)) : (s(), c("span", Q, "-"))]), _: 1 })]), _: 1 }), t(o, { align: "center", label: "管理费" }, { default: n(() => [t(o, { align: "center", label: "扣除记录", "min-width": "130", prop: "managementDeductIncome" }, { default: n(({ row: e }) => [e.managementDeductIncome ? (s(), c("span", X, p(`-${e.managementDeductIncome ? i(d)(e.managementDeductIncome) : ""} ${D(e.rate)}`), 1)) : (s(), c("span", Y, "-"))]), _: 1 }), t(o, { align: "center", label: "退还记录", "min-width": "130", prop: "managementRecord" }, { default: n(({ row: { managementRecord: e } }) => [e ? (s(), c("span", Z, p(`${i(d)(e)}`), 1)) : (s(), c("span", ee, "-"))]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), t(z, { requestData: b, total: g.value, onHandleChange: r }, null, 8, ["requestData", "total"])]), _.value ? (s(), h(U, { key: 0, ref: "dialogRef", onHandleVisible: l[0] || (l[0] = (e) => _.value = false), onUpdateList: r }, null, 512)) : x("", true)], 64);
  };
} }, re = F(te, [["__scopeId", "data-v-44344f4f"]]);
export {
  re as default
};
