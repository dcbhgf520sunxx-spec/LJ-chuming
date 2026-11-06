import { ref as T } from "vue";
import { reactive as A } from "vue";
import { provide as x } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as s } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as N } from "vue";
import { ElMessageBox as L } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as K } from "../../../../modules/common-b3e76e54.js";
import { c as U } from "../../../../modules/artifact-aa863eec.js";
import { x as $, o as j, bv as G, n8 as X, G as q, n9 as C } from "../../../../shared/runtime.js";
import { _ as z } from "../../../../modules/index-3b2628f3.js";
import F from "./module/header.vue.js";
import J from "./module/handle-drawer.vue.js";
import W from "./module/detail-drawer.vue.js";
const Y = { class: "app-container" }, Z = { class: "head-container" }, ue = { __name: "index", setup(ee) {
  const w = { get: [""], edit: [""], add: [""], del: [""] }, v = { add: false, edit: false, del: false, download: false }, g = T(), { crud: m, columns: u, CRUD: D } = $({ title: "构件变更", permission: { ...w }, optShow: { ...v }, crudApi: { ...K }, hasPagination: false, dataPath: "" }, g), { maxHeight: Q } = j({ paginate: false }), f = T(false), _ = T(false);
  let y = A({});
  const h = { DECREASE_TASK: { K: "DECREASE_TASK", L: "多余任务处理", V: 1, COLUMNS: [{ label: "任务数", field: "taskQuantity", width: "150px", align: "center", preview: false }] }, EXCEPTION_HANDLE: { K: "EXCEPTION_HANDLE", L: "异常处理", V: 2, COLUMNS: [{ label: "工序", field: "processName", width: "", preview: true }, { label: "类型", field: "reportTypeText", width: "", preview: true }, { label: "生产数量", field: "quantity", width: "150px", align: "center", preview: false }] } };
  x("handleMethodEnum", h), x("handleMethodEnumV", G.key2val(h)), D.HOOK.handleRefresh = (o, n) => {
    n.data = n.data.map((e) => (e.changTypeText = X.VL[e.changeType], e.unproducedMete = e.totalTaskQuantity - e.totalInProductionQuantity || 0, e.needDecreaseTaskMete = e.totalTaskQuantity - e.newQuantity || 0, e.unproducedMete >= e.needDecreaseTaskMete && (e.handleType = h.DECREASE_TASK.V, e.canHandleTotalMete = e.needDecreaseTaskMete), e.unproducedMete < e.needDecreaseTaskMete && (e.handleType = h.EXCEPTION_HANDLE.V, e.canHandleTotalMete = e.totalInProductionQuantity - e.newQuantity), e));
  };
  function M(o) {
    o.status === C.PENDING.V ? L.confirm("处理异常前请通知车间将相关构件进行异常上报后再进行异常处理！", "提示", { confirmButtonText: "仍要处理", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        const n = await U(o.id);
        o.handleType = n, b(f, o);
      } catch (n) {
        console.log("仍要处理", n);
      }
    }) : b(f, o);
  }
  function S(o) {
    b(_, o);
  }
  function b(o, n) {
    o.value = true, y = Object.assign(y, n);
  }
  return (o, n) => {
    const e = R, E = k("common-button"), P = k("common-table"), V = B;
    return l(), O("div", Y, [d("div", Z, [c(t(F))]), H((l(), s(P, { ref_key: "tableRef", ref: g, data: t(m).data, "empty-text": t(m).emptyText, "max-height": t(Q), "row-key": "id", style: { width: "100%" } }, { default: i(() => [c(e, { label: "序号", type: "index", align: "center", width: "60" }), c(t(z), { columns: t(u), showProject: "" }, null, 8, ["columns"]), t(u).visible("userName") ? (l(), s(e, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "变更人" }, { default: i((a) => [d("span", null, p(a.row.userName), 1)]), _: 1 })) : r("", true), t(u).visible("serialNumber") ? (l(), s(e, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "构件编号" }, { default: i((a) => [d("span", null, p(a.row.serialNumber), 1)]), _: 1 })) : r("", true), t(u).visible("oldQuantity") ? (l(), s(e, { key: "oldQuantity", prop: "oldQuantity", "show-overflow-tooltip": true, label: "构件数量", align: "center" }, { default: i((a) => [d("span", null, p(a.row.oldQuantity), 1)]), _: 1 })) : r("", true), t(u).visible("totalInProductionQuantity") ? (l(), s(e, { key: "totalInProductionQuantity", prop: "totalInProductionQuantity", "show-overflow-tooltip": true, label: "已生产量", align: "center" }, { default: i((a) => [d("span", null, p(a.row.totalInProductionQuantity), 1)]), _: 1 })) : r("", true), t(u).visible("changTypeText") ? (l(), s(e, { key: "changTypeText", prop: "changTypeText", "show-overflow-tooltip": true, label: "变更类型", align: "center" }, { default: i((a) => [d("span", null, p(a.row.changTypeText), 1)]), _: 1 })) : r("", true), t(u).visible("newQuantity") ? (l(), s(e, { key: "newQuantity", prop: "newQuantity", "show-overflow-tooltip": true, label: "变更后数量", align: "center" }, { default: i((a) => [d("span", null, p(a.row.newQuantity), 1)]), _: 1 })) : r("", true), t(q)([...w.edit, ...w.del]) ? (l(), s(e, { key: 6, label: "操作", width: "160px", align: "center", fixed: "right" }, { default: i((a) => [a.row.status !== t(C).PROCESSING_COMPLETE.V ? (l(), s(E, { key: 0, size: "default", type: "primary", onClick: (I) => M(a.row) }, { default: i(() => n[2] || (n[2] = [N("处理")])), _: 2, __: [2] }, 1032, ["onClick"])) : r("", true), c(E, { size: "default", type: "info", onClick: (I) => S(a.row) }, { default: i(() => n[3] || (n[3] = [N("查看")])), _: 2, __: [3] }, 1032, ["onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[V, t(m).loading]]), c(t(J), { visible: f.value, "onUpdate:visible": n[0] || (n[0] = (a) => f.value = a), info: t(y), onSuccess: t(m).toQuery }, null, 8, ["visible", "info", "onSuccess"]), c(t(W), { visible: _.value, "onUpdate:visible": n[1] || (n[1] = (a) => _.value = a), info: t(y) }, null, 8, ["visible", "info"])]);
  };
} };
export {
  ue as default
};
