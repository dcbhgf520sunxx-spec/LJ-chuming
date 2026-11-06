import { ref as A } from "vue";
import { computed as f } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as $ } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as b } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as F } from "vue";
import { ElMessageBox as O } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { InfoFilled as N } from "@element-plus/icons-vue";
import { ElIcon as H } from "element-plus";
import { ElTooltip as L } from "element-plus";
import { ElSwitch as M } from "element-plus";
import { vLoading as q } from "element-plus";
import { l as s, o as J, x as K, ep as p, D as Y, G as w, aS as d, an as G } from "../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import Q from "./module/form.vue.js";
function W(t) {
  return s({ module: "system", url: "system/odd-job-config/list", method: "get", params: t });
}
function X(t) {
  return s({ module: "system", url: "system/odd-job-config", method: "post", data: t });
}
function Z(t) {
  return s({ module: "system", url: "system/odd-job-config", method: "put", data: t });
}
function tt(t) {
  return s({ module: "system", url: `system/odd-job-config/${t}`, method: "delete" });
}
function et(t) {
  return s({ url: "/api/system/odd-job-config/status", method: "put", params: t });
}
const ot = { get: W, add: X, edit: Z, del: tt };
function at(t) {
  return s({ url: "api/system/project-odd-job-config/list", method: "get", params: t });
}
function nt(t) {
  return s({ url: "api/system/project-odd-job-config", method: "post", data: t });
}
function st(t) {
  return s({ url: "api/system/project-odd-job-config", method: "put", data: t });
}
function it(t) {
  return s({ url: `api/system/project-odd-job-config/${t}`, method: "delete" });
}
function rt(t) {
  return s({ url: "/api/system/project-odd-job-config/status", method: "put", params: t });
}
const dt = { get: at, add: nt, edit: st, del: it }, lt = { class: "app-container" }, ct = { class: "head-container" }, ut = { style: { display: "inline-block" } }, _t = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, setup(t) {
  const l = t, g = A(), { maxHeight: j } = J({ paginate: true }), v = f(() => l.projectData ? dt : ot), x = f(() => l.projectData ? rt : et), C = { add: true, edit: false, del: false, download: false }, { crud: i, CRUD: m } = K({ title: "零工配置", sort: [], permission: { ...p }, dataPath: "", optShow: { ...C }, crudApi: { ...v.value }, hasPagination: false }, g), E = f(() => [["price", ["to-thousand", Y.YUAN]]]);
  async function S(n, r) {
    try {
      await O.confirm('此操作将 "' + d.VL[r] + '" 零工类型 ' + n.oddJobType + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const o = { id: n.id, status: r };
      await x.value(o), i.refresh(), i.notify(d.VL[r] + "成功", m.NOTIFICATION_TYPE.SUCCESS);
    } catch (o) {
      console.log(o), n.status = n.status === d.TRUE.V ? d.FALSE.V : d.TRUE.V;
    }
  }
  return m.HOOK.beforeRefresh = (n, r) => {
    var o;
    l.projectData && (n.query.projectId = (o = l.projectData) == null ? void 0 : o.contractProjectId, n.dataPath = "content");
  }, m.HOOK.beforeToAdd = () => {
    var n;
    l.projectData && (i.form.contractProjectId = (n = l.projectData) == null ? void 0 : n.contractProjectId);
  }, (n, r) => {
    const o = R, T = N, V = H, D = L, k = M, I = U("common-table"), P = q;
    return h(), $("div", lt, [_("div", ct, [a(e(z))]), B((h(), b(I, { ref_key: "tableRef", ref: g, data: e(i).data, "empty-text": e(i).emptyText, "data-format": E.value, "max-height": e(j), style: { width: "100%" }, "row-key": "id", onSelectionChange: e(i).selectionChangeHandler }, { default: u(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { key: "oddJobType", prop: "oddJobType", "show-overflow-tooltip": true, label: "零工类型", align: "center", "min-width": "100px" }), a(o, { key: "unit", prop: "unit", "show-overflow-tooltip": true, label: "计算单位", "min-width": "80px" }), a(o, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价（元）", align: "center", "min-width": "80px" }), a(o, { key: "status", prop: "status", label: "状态", align: "center", width: "80px" }, { header: u(() => [a(D, { class: "item", effect: "light", content: "", placement: "top" }, { default: u(() => [_("div", ut, [r[0] || (r[0] = _("span", null, "状态", -1)), a(V, null, { default: u(() => [a(T)]), _: 1 })])]), _: 1 })]), default: u((c) => [a(k, { modelValue: c.row.status, "onUpdate:modelValue": (y) => c.row.status = y, disabled: !e(w)(e(p).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(d).TRUE.V, "inactive-value": e(d).FALSE.V, onChange: (y) => S(c.row, c.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 }), e(w)([...e(p).edit, ...e(p).del]) ? (h(), b(o, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((c) => [a(e(G), { data: c.row }, null, 8, ["data"])]), _: 1 })) : F("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height", "onSelectionChange"])), [[P, e(i).loading]]), a(e(Q))]);
  };
} };
export {
  _t as default
};
