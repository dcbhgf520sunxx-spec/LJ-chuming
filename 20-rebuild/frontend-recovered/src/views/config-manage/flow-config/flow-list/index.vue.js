import { ref as w } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as D } from "vue";
import { unref as t } from "vue";
import { createTextVNode as F } from "vue";
import { createCommentVNode as _ } from "vue";
import { createVNode as f } from "vue";
import { withDirectives as A } from "vue";
import { ElMessageBox as P } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { ElSwitch as H } from "element-plus";
import { ElCard as I } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as M, e as Q } from "../../../../modules/flow-config-2bf9a9d0.js";
import { _ as j, x as q, dW as b, o as G, G as K, dX as h } from "../../../../shared/runtime.js";
import W from "./module/header.vue.js";
import X from "../module/form.vue.js";
const Y = { style: { "line-height": "28px" } }, z = { class: "head-container" }, J = { __name: "index", emits: ["click-line"], setup(Z, { expose: k, emit: B }) {
  const y = B, g = w(false), T = { add: true, edit: false, del: true, download: false }, v = w(), N = w(), { crud: s, columns: x, CRUD: C } = q({ title: "流程列表", sort: [], permission: { ...b }, optShow: { ...T }, crudApi: { ...M }, hasPagination: false }, v, N), { maxHeight: L } = G({ wrapperBox: ".dict-box", paginate: false, extraHeight: 190 });
  function U(o) {
    o && y("click-line", o);
  }
  C.HOOK.handleRefresh = (o, e) => {
    var l, a, m, p;
    e.data.content = e.data, (l = e.data.content) == null || l.forEach((n) => {
      var d;
      n.originStatus = n.status, n.processFlowStr = (d = n == null ? void 0 : n.relatedProcessList) == null ? void 0 : d.join("、");
    }), ((m = (a = e == null ? void 0 : e.data) == null ? void 0 : a.content) == null ? void 0 : m.length) > 0 && y("click-line", (p = e == null ? void 0 : e.data) == null ? void 0 : p.content[0]);
  };
  async function $(o, e) {
    try {
      await P.confirm(`此操作将把 “${o.name}” 状态更改为 “${h.VL[e]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Q({ id: o.id }), s.notify(`“${o.name}数据” 状态变更为 “${h.VL[e]}” 成功`, C.NOTIFICATION_TYPE.SUCCESS), s.refresh();
    } catch (l) {
      console.log(l), o.status = o.originStatus;
    }
  }
  return k({ toQuery: s.toQuery }), (o, e) => {
    const l = E("common-button"), a = R, m = H, p = E("common-table"), n = I, d = O;
    return r(), c(n, { class: "line-box box-card" }, { header: u(() => [V("span", Y, D(t(s).title), 1), t(K)(t(b).add) ? (r(), c(l, { key: 0, type: "success", icon: "el-icon-plus", onClick: e[0] || (e[0] = (i) => g.value = true) }, { default: u(() => e[2] || (e[2] = [F(" 新增流程 ")])), _: 1, __: [2] })) : _("", true)]), default: u(() => [V("div", z, [f(t(W))]), A((r(), c(p, { ref_key: "tableRef", ref: v, "highlight-current-row": "", data: t(s).data, "empty-text": t(s).emptyText, "max-height": t(L), stripe: false, style: { width: "100%", "margin-top": "10px" }, onCurrentChange: U, "return-source-data": "", showEmptySymbol: false }, { default: u(() => [f(a, { label: "序号", type: "index", align: "center", width: "60" }), t(x).visible("name") ? (r(), c(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "流程名称", align: "center" })) : _("", true), t(x).visible("status") ? (r(), c(a, { key: "status", prop: "status", "show-overflow-tooltip": true, label: "启用状态", align: "center", width: "90px" }, { default: u(({ row: i }) => [f(m, { modelValue: i.status, "onUpdate:modelValue": (S) => i.status = S, "active-value": t(h).ENABLED.V, "inactive-value": t(h).UN_ENABLE.V, class: "drawer-switch", onChange: (S) => $(i, i.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onChange"])]), _: 1 })) : _("", true), t(x).visible("processFlowStr") ? (r(), c(a, { key: "processFlowStr", prop: "processFlowStr", "show-overflow-tooltip": true, label: "相关流程", "min-width": "140px", align: "center" })) : _("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[d, t(s).loading]]), f(X, { visible: g.value, "onUpdate:visible": e[1] || (e[1] = (i) => g.value = i), onSuccess: t(s).toQuery, permission: t(b) }, null, 8, ["visible", "onSuccess", "permission"])]), _: 1 });
  };
} }, ae = j(J, [["__scopeId", "data-v-20192405"]]);
export {
  ae as default
};
