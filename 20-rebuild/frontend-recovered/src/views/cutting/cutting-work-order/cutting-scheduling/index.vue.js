import { ref as f } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as l } from "vue";
import { withCtx as i } from "vue";
import { Fragment as C } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as $ } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as W } from "../../../../modules/scheduling-2b0c95c3.js";
import { c as z } from "../../../../modules/nestingList-7bbadefb.js";
import { x as Q, o as q, G as j, P as F } from "../../../../shared/runtime.js";
import G from "./module/header.vue.js";
import L from "./module/detail/index.vue.js";
import J from "../../template/steel-plate-list.vue.js";
import { a as b } from "../../../../modules/cutting-457c256f.js";
import "../../../../modules/project-data-5e9d497a.js";
import "./module/detail/machine-dialog/index.vue.js";
import "../../../../modules/machine-10301ee2.js";
import "../../template/detail.vue.js";
const K = { class: "app-container" }, pe = { __name: "index", setup(X) {
  const _ = f(), h = f(0), w = f(false), k = f({}), y = f({}), v = f(false), D = { add: false, edit: false, del: false, download: false }, { crud: n, columns: u } = Q({ title: "切割排产", sort: [], permission: { ...b }, optShow: { ...D }, crudApi: { ...W }, hasPagination: true }, _), { maxHeight: P } = q({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 });
  async function V(c) {
    k.value = c, w.value = true;
  }
  function A(c) {
    y.value = c, v.value = true;
  }
  function B(c) {
    h.value = c, h.value === 1 ? n.crudApi = { ...z } : n.crudApi = { ...W }, n.data = [], n.toQuery();
  }
  function H() {
    n.toQuery();
  }
  return (c, d) => {
    const o = E, M = O, N = x("common-button"), S = x("common-table"), T = U;
    return a(), g("div", K, [r(t(G), { onChange: B }), R((a(), l(S, { ref_key: "tableRef", ref: _, data: t(n).data, "empty-text": t(n).emptyText, "max-height": t(P) - 50, style: { width: "100%" } }, { default: i(() => [r(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(n).data && h.value === 0 ? (a(), g(C, { key: 0 }, [t(u).visible("workshopInf") ? (a(), l(o, { key: "workshopInf", align: "center", prop: "workshopInf", "show-overflow-tooltip": true, label: "车间", "min-width": "40" }, { default: i((e) => [p("span", null, m(e.row.cutMachine.workshopInf), 1)]), _: 1 })) : s("", true), t(u).visible("machineName") ? (a(), l(o, { key: "machineName", align: "center", prop: "machineName", "show-overflow-tooltip": true, label: "设备名称", "min-width": "40" }, { default: i((e) => [r(M, { style: { width: "100%" }, effect: "plain" }, { default: i(() => [p("span", null, m(e.row.cutMachine.machineName), 1)]), _: 2 }, 1024)]), _: 1 })) : s("", true)], 64)) : (a(), g(C, { key: 1 }, [t(u).visible("projectName") ? (a(), l(o, { key: "projectName", "show-overflow-tooltip": true, label: "项目名称", align: "center", "min-width": "90" }, { default: i((e) => [p("span", null, m(e.row.projectName), 1)]), _: 1 })) : s("", true)], 64)), t(u).visible("plateNum") ? (a(), l(o, { key: "plateNum", align: "center", prop: "plateNum", "show-overflow-tooltip": true, label: "任务数（张）", "min-width": "40" }, { default: i((e) => [p("span", null, m(e.row.plateNum ? e.row.plateNum : 0), 1)]), _: 1 })) : s("", true), t(u).visible("plateWeight") ? (a(), l(o, { key: "plateWeight", align: "center", prop: "plateWeight", "show-overflow-tooltip": true, label: "任务量（kg）", "min-width": "40" }, { default: i((e) => [p("span", null, m(e.row.plateWeight ? e.row.plateWeight : 0), 1)]), _: 1 })) : s("", true), t(u).visible("finishNum") ? (a(), l(o, { key: "finishNum", align: "center", prop: "finishNum", "show-overflow-tooltip": true, label: "完成数（张）", "min-width": "40" }, { default: i((e) => [p("span", null, m(e.row.finishNum ? e.row.finishNum : 0), 1)]), _: 1 })) : s("", true), t(u).visible("finishWeight") ? (a(), l(o, { key: "finishWeight", align: "center", prop: "finishWeight", "show-overflow-tooltip": true, label: "完成量（kg）", "min-width": "40" }, { default: i((e) => [p("span", null, m(e.row.finishWeight ? e.row.finishWeight : 0), 1)]), _: 1 })) : s("", true), h.value === 0 && t(j)(t(b).detailMachine) ? (a(), l(o, { key: 6, label: "操作", align: "center", "min-width": "90" }, { default: i((e) => [r(N, { type: "primary", size: "default", onClick: (I) => V(e.row) }, { default: i(() => d[2] || (d[2] = [$("查 看")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 1 })) : h.value === 1 && t(j)(t(b).detailProject) ? (a(), l(o, { key: 7, label: "操作", align: "center", "min-width": "90" }, { default: i((e) => [r(N, { icon: "el-icon-view", type: "primary", size: "default", onClick: (I) => A(e.row) }, null, 8, ["onClick"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[T, t(n).loading]]), r(t(F)), r(L, { onColesHook: H, "detail-data": k.value, visible: w.value, "onUpdate:visible": d[0] || (d[0] = (e) => w.value = e) }, null, 8, ["detail-data", "visible"]), r(J, { "detail-data": y.value, visible: v.value, "onUpdate:visible": d[1] || (d[1] = (e) => v.value = e) }, null, 8, ["detail-data", "visible"])]);
  };
} };
export {
  pe as default
};
