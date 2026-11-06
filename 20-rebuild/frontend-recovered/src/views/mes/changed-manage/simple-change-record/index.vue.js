import { ref as d } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as G } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as a } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as P } from "vue";
import { ElMessageBox as R } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElTag as j } from "element-plus";
import { vLoading as A } from "element-plus";
import { l as E, x as D, mA as N, o as H, mB as r, G as Q, P as M } from "../../../../shared/runtime.js";
import U from "./module/header.vue.js";
function z(c) {
  return E({ module: "plan", url: "artifact/change", method: "get", params: c });
}
function q({ id: c, handleStatusEnum: m }) {
  return E({ module: "plan", url: `artifact/change/handle/${c}/${m}`, method: "put" });
}
const F = { get: z }, I = { class: "app-container" }, J = { class: "head-container" }, K = { key: 0 }, Z = { __name: "index", setup(c) {
  const m = { add: false, edit: false, del: false, download: false }, T = d([["createTime", "parse-time"], ["handleTime", "parse-time"], ["project", "parse-project"]]), b = d(), h = d(false), w = d(false), { crud: f, columns: l } = D({ title: "简易变更记录", permission: { ...N }, sort: [], invisibleColumns: [], optShow: { ...m }, crudApi: { ...F } }, b), { maxHeight: C } = H({ paginate: true });
  function y(g, n) {
    R.confirm(`是否确认${r.VL[n]}`, "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        console.log(r.VL[n]), r.VL[n] === "通过" ? h.value = true : w.value = true, await q({ id: g.id, handleStatusEnum: n }), g.handleStatusEnum = n;
      } catch (t) {
        console.log("取消", t);
      } finally {
        h.value = false, w.value = false;
      }
    });
  }
  return (g, n) => {
    const t = $, _ = k("common-button"), S = j, V = k("common-table"), B = A;
    return o(), x("div", I, [G("div", J, [p(e(U))]), L((o(), a(V, { ref_key: "tableRef", ref: b, data: e(f).data, "data-format": T.value, "empty-text": e(f).emptyText, "max-height": e(C), "row-key": "id", style: { width: "100%" } }, { default: u(() => [p(t, { label: "序号", type: "index", align: "center", width: "60" }), e(l).visible("createTime") ? (o(), a(t, { key: 0, prop: "createTime", "show-overflow-tooltip": true, label: "变更时间", width: "130", align: "center" })) : i("", true), e(l).visible("userName") ? (o(), a(t, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "变更人", align: "center" })) : i("", true), e(l).visible("reasonName") ? (o(), a(t, { key: 2, prop: "reasonName", "show-overflow-tooltip": true, label: "变更原因", align: "center" })) : i("", true), e(l).visible("project") ? (o(), a(t, { key: 3, prop: "project", "show-overflow-tooltip": true, label: "所属项目", "min-width": "180px" })) : i("", true), e(l).visible("monomer.name") ? (o(), a(t, { key: 4, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "100px" })) : i("", true), e(l).visible("area.name") ? (o(), a(t, { key: 5, "show-overflow-tooltip": true, prop: "area.name", label: "区域", "min-width": "100px" })) : i("", true), e(l).visible("name") ? (o(), a(t, { key: 6, "show-overflow-tooltip": true, prop: "name", label: "名称", "min-width": "90px" })) : i("", true), e(l).visible("serialNumber") ? (o(), a(t, { key: 7, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100" })) : i("", true), e(l).visible("specification") ? (o(), a(t, { key: 8, prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "110" })) : i("", true), e(l).visible("oldQuantity") ? (o(), a(t, { key: 9, prop: "oldQuantity", "show-overflow-tooltip": true, label: "原清单数量", width: "100", align: "center" })) : i("", true), e(l).visible("newQuantity") ? (o(), a(t, { key: 10, prop: "newQuantity", "show-overflow-tooltip": true, label: "变更后清单数量(kg)", width: "110", align: "center" })) : i("", true), e(l).visible("oldNetWeight") ? (o(), a(t, { key: 11, prop: "oldNetWeight", "show-overflow-tooltip": true, label: "原单净重(kg)", width: "100", align: "center" })) : i("", true), e(l).visible("newNetWeight") ? (o(), a(t, { key: 12, prop: "newNetWeight", "show-overflow-tooltip": true, label: "变更后单净重", width: "110", align: "center" })) : i("", true), e(l).visible("oldGrossWeight") ? (o(), a(t, { key: 13, prop: "oldGrossWeight", "show-overflow-tooltip": true, label: "原单毛重(kg)", width: "100", align: "center" })) : i("", true), e(l).visible("newGrossWeight") ? (o(), a(t, { key: 14, prop: "newGrossWeight", "show-overflow-tooltip": true, label: "变更后单毛重(kg)", width: "110", align: "center" })) : i("", true), e(l).visible("handleUserName") ? (o(), a(t, { key: 15, prop: "handleUserName", "show-overflow-tooltip": true, label: "处理人", width: "110", align: "center" })) : i("", true), e(l).visible("handleTime") ? (o(), a(t, { key: 16, prop: "handleTime", "show-overflow-tooltip": true, label: "处理时间", width: "130", align: "center" })) : i("", true), p(t, { label: "状态", width: "180px", align: "center", fixed: "right" }, { default: u(({ row: { sourceRow: s } }) => [s.handleStatusEnum && s.handleStatusEnum === e(r).PENDING.V && e(Q)(e(N).audit) ? (o(), x("span", K, [p(_, { loading: h.value, size: "default", type: "success", onClick: (W) => y(s, e(r).PASS.V) }, { default: u(() => n[0] || (n[0] = [v(" 通过 ")])), _: 2, __: [0] }, 1032, ["loading", "onClick"]), p(_, { loading: w.value, size: "default", type: "danger", onClick: (W) => y(s, e(r).REJECT.V) }, { default: u(() => n[1] || (n[1] = [v(" 驳回 ")])), _: 2, __: [1] }, 1032, ["loading", "onClick"])])) : (o(), a(S, { key: 1, type: e(r).V[s.handleStatusEnum].TAG, effect: "plain" }, { default: u(() => [v(P(e(r).VL[s.handleStatusEnum]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[B, e(f).loading]]), p(e(M))]);
  };
} };
export {
  Z as default
};
