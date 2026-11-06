import { ref as b } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as a } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as R } from "vue";
import { ElMessageBox as U } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElTag as D } from "element-plus";
import { vLoading as Q } from "element-plus";
import { l as g, x as j, mA as y, o as H, mB as m, G as $, P as G } from "../../../../shared/runtime.js";
import L from "./module/header.vue.js";
function M(p) {
  return g({ url: "/api/enclosure/entities", method: "get", params: p });
}
function z(p) {
  return g({ url: "/api/enclosure/examine", method: "post", data: p });
}
const q = { get: M }, F = { class: "app-container" }, I = { class: "head-container" }, J = { key: 0 }, X = { __name: "index", setup(p) {
  const k = { add: false, edit: false, del: false, download: false }, x = b([["createTime", "parse-time"], ["handleTime", "parse-time"]]), E = b(), { crud: u, columns: n } = j({ title: "变更审批", permission: { ...y }, sort: [], invisibleColumns: [], optShow: { ...k }, dataPath: "", crudApi: { ...q } }), { maxHeight: T } = H({ paginate: true });
  function f(d, l) {
    U.confirm(`是否确认${m.VL[l]}`, "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        await z({ id: d.id, handleStatusEnum: l }), d.handleStatusEnum = l, u.toQuery();
      } catch (t) {
        console.log("取消", t);
      }
    });
  }
  return (d, l) => {
    const t = A, w = _("common-button"), C = D, S = _("common-table"), N = Q;
    return o(), v("div", F, [B("div", I, [s(e(L))]), P((o(), a(S, { ref_key: "tableRef", ref: E, data: e(u).data, "data-format": x.value, "empty-text": e(u).emptyText, "max-height": e(T), "row-key": "id", style: { width: "100%" } }, { default: c(() => [s(t, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("createTime") ? (o(), a(t, { key: 0, prop: "createTime", "show-overflow-tooltip": true, label: "变更时间", width: "130", align: "center" })) : i("", true), e(n).visible("commitUser.name") ? (o(), a(t, { key: "commitUser.name", prop: "commitUser.name", "show-overflow-tooltip": true, label: "变更人", align: "center" })) : i("", true), e(n).visible("reasonName") ? (o(), a(t, { key: 2, prop: "reasonName", "show-overflow-tooltip": true, label: "变更原因", align: "center" })) : i("", true), e(n).visible("project.name") ? (o(), a(t, { key: "project.name ", prop: "project.name", "show-overflow-tooltip": true, label: "所属项目", "min-width": "180px" })) : i("", true), e(n).visible("plan.name") ? (o(), a(t, { key: 4, "show-overflow-tooltip": true, prop: "plan.name", label: "区域", "min-width": "100px" })) : i("", true), e(n).visible("name") ? (o(), a(t, { key: 5, "show-overflow-tooltip": true, prop: "name", label: "名称", "min-width": "90px" })) : i("", true), e(n).visible("serialNumber") ? (o(), a(t, { key: 6, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100" })) : i("", true), e(n).visible("plate") ? (o(), a(t, { key: 7, prop: "plate", "show-overflow-tooltip": true, label: "版型", "min-width": "110" })) : i("", true), e(n).visible("oldQuantity") ? (o(), a(t, { key: 8, prop: "oldQuantity", label: "原清单数量", align: "center", "show-overflow-tooltip": true, "min-width": "90" })) : i("", true), e(n).visible("newQuantity") ? (o(), a(t, { key: 9, prop: "newQuantity", label: "变更后清单数量", align: "center", "show-overflow-tooltip": true, "min-width": "90" })) : i("", true), e(n).visible("handleUser.name") ? (o(), a(t, { key: 10, prop: "handleUser.name", "show-overflow-tooltip": true, label: "处理人", width: "110", align: "center" })) : i("", true), e(n).visible("handleTime") ? (o(), a(t, { key: 11, prop: "handleTime", "show-overflow-tooltip": true, label: "处理时间", width: "130", align: "center" })) : i("", true), s(t, { label: "状态", width: "140px", align: "center", fixed: "right" }, { default: c(({ row: { sourceRow: r } }) => [r.handleStatusEnum && r.handleStatusEnum === e(m).PENDING.V && e($)(e(y).audit) ? (o(), v("span", J, [s(w, { size: "default", type: "success", onClick: (V) => f(r, e(m).PASS.V) }, { default: c(() => l[0] || (l[0] = [h(" 通过 ")])), _: 2, __: [0] }, 1032, ["onClick"]), s(w, { size: "default", type: "danger", onClick: (V) => f(r, e(m).REJECT.V) }, { default: c(() => l[1] || (l[1] = [h(" 驳回 ")])), _: 2, __: [1] }, 1032, ["onClick"])])) : (o(), a(C, { key: 1, type: e(m).V[r.handleStatusEnum].TAG, effect: "plain" }, { default: c(() => [h(R(e(m).VL[r.handleStatusEnum]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[N, e(u).loading]]), s(e(G))]);
  };
} };
export {
  X as default
};
