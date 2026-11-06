import { ref as U } from "vue";
import { computed as v } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as i } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as c } from "vue";
import { ElMessageBox as R } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { InfoFilled as L } from "@element-plus/icons-vue";
import { ElIcon as M } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { ElSwitch as q } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as K, e as Y, _ as G } from "./module/form.vue.js";
import { l as h, o as z, x as J, eq as _, D as W, G as x, aS as p, an as X } from "../../../../shared/runtime.js";
import Z from "./module/header.vue.js";
function tt(o) {
  return h({ url: "api/system/project-other-apportionment/list", method: "get", params: o });
}
function et(o) {
  return h({ url: "api/system/project-other-apportionment", method: "post", data: o });
}
function ot(o) {
  return h({ url: "api/system/project-other-apportionment", method: "put", data: o });
}
function at(o) {
  return h({ url: `api/system/project-other-apportionment/${o}`, method: "delete" });
}
function nt(o) {
  return h({ url: "api/system/project-other-apportionment/status", method: "put", params: o });
}
const rt = { get: tt, add: et, edit: ot, del: at }, it = { class: "app-container" }, st = { class: "head-container" }, lt = { style: { display: "inline-block" } }, mt = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, setup(o) {
  const u = o, b = U(), { maxHeight: j } = z({ paginate: true }), k = { add: true, edit: false, del: false, download: false }, C = v(() => u.projectData ? rt : K), E = v(() => u.projectData ? nt : Y), { crud: s, columns: d, CRUD: y } = J({ title: "其它分摊", sort: [], permission: { ..._ }, optShow: { ...k }, crudApi: { ...C.value }, dataPath: "", hasPagination: false }, b), S = v(() => [["price", ["to-thousand", W.YUAN]]]);
  async function V(a, l) {
    try {
      await R.confirm('此操作将 "' + p.VL[l] + '" 类型 ' + a.type + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await E.value({ id: a.id, status: l }), s.refresh(), s.notify(p.VL[l] + "成功", y.NOTIFICATION_TYPE.SUCCESS);
    } catch (e) {
      console.log("变更其它分摊状态", e), a.status = a.status === p.TRUE.V ? p.FALSE.V : p.TRUE.V;
    }
  }
  return y.HOOK.beforeRefresh = (a, l) => {
    var e;
    u.projectData && (a.query.projectId = (e = u.projectData) == null ? void 0 : e.contractProjectId, a.dataPath = "content");
  }, y.HOOK.beforeToAdd = () => {
    var a;
    u.projectData && (s.form.contractProjectId = (a = u.projectData) == null ? void 0 : a.contractProjectId);
  }, (a, l) => {
    const e = H, D = L, T = M, A = $, I = q, P = B("common-table"), N = Q;
    return n(), F("div", it, [w("div", st, [r(t(Z))]), O((n(), i(P, { ref_key: "tableRef", ref: b, data: t(s).data, "empty-text": t(s).emptyText, "data-format": S.value, "max-height": t(j), style: { width: "100%" }, "row-key": "id", onSelectionChange: t(s).selectionChangeHandler }, { default: f(() => [r(e, { label: "序号", type: "index", align: "center", width: "60" }), t(d).visible("type") ? (n(), i(e, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "类型", align: "center" })) : c("", true), t(d).visible(" workshopName") ? (n(), i(e, { key: "workshopName", prop: "workshopName", "show-overflow-tooltip": true, label: "车间" })) : c("", true), t(d).visible("inventoryQuantity") ? (n(), i(e, { key: "inventoryQuantity", prop: "inventoryQuantity", "show-overflow-tooltip": true, label: "入库量" })) : c("", true), t(d).visible("unit") ? (n(), i(e, { key: "unit", prop: "unit", "show-overflow-tooltip": true, label: "计量单位", align: "center" })) : c("", true), t(d).visible("price") ? (n(), i(e, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价", align: "center" })) : c("", true), t(d).visible("status") ? (n(), i(e, { key: "status", prop: "status", label: "状态", align: "center", width: "80px" }, { header: f(() => [r(A, { class: "item", effect: "light", content: "", placement: "top" }, { default: f(() => [w("div", lt, [l[0] || (l[0] = w("span", null, "状态", -1)), r(T, null, { default: f(() => [r(D)]), _: 1 })])]), _: 1 })]), default: f((m) => [r(I, { modelValue: m.row.status, "onUpdate:modelValue": (g) => m.row.status = g, disabled: !t(x)(t(_).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": t(p).TRUE.V, "inactive-value": t(p).FALSE.V, onChange: (g) => V(m.row, m.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : c("", true), t(x)([...t(_).edit, ...t(_).del]) ? (n(), i(e, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: f((m) => [r(t(X), { data: m.row }, null, 8, ["data"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height", "onSelectionChange"])), [[N, t(s).loading]]), r(t(G))]);
  };
} };
export {
  mt as default
};
