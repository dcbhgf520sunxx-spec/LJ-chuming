import { ref as U } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as u } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as k } from "vue";
import { ElMessageBox as B } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { ElSwitch as A } from "element-plus";
import { vLoading as F } from "element-plus";
import { l as d, x as D, gx as p, o as O, cB as l, G as x, an as H } from "../../../shared/runtime.js";
import P from "./module/header.vue.js";
import I from "./module/form.vue.js";
import M from "./module/batch-form.vue.js";
import "../../../modules/use-table-operate-4f84437f.js";
function $(o) {
  return d({ url: "/api/notification/webhook/config/getWebhookList", method: "get", params: o });
}
function W(o) {
  return d({ url: "/api/notification/webhook/config/save", method: "post", data: o });
}
function j(o) {
  return d({ url: "/api/notification/webhook/config/save", method: "post", data: o });
}
function q(o) {
  return d({ url: "/api/notification/webhook/config/update", method: "post", data: o });
}
function G(o) {
  return d({ url: "/api/notification/webhook/config/delete", method: "post", data: o });
}
function K(o) {
  return d({ url: "/api/notification/webhook/config/status", method: "put", params: o });
}
const Y = { get: $, batchAdd: j, add: W, edit: q, del: G }, z = { class: "app-container" }, J = { class: "head-container" }, ae = { __name: "index", setup(o) {
  const C = { batchAdd: true, add: true, edit: false, del: true, download: false }, b = U(), { crud: c, columns: h, CRUD: v } = D({ title: "WebhookURL配置", sort: [], permission: { ...p }, optShow: { ...C }, crudApi: { ...Y }, hasPagination: false, formStore: false }, b), { maxHeight: T } = O({ paginate: false });
  async function E(i, n) {
    try {
      await B.confirm('此操作将 "' + l.VL[n] + '" ' + i.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const t = { id: i.id, status: i.status };
      await K(t), c.refresh(), c.notify(l.VL[n] + "成功", v.NOTIFICATION_TYPE.SUCCESS);
    } catch (t) {
      console.log("变更状态失败", t, n), i.status = i.status === l.TRUE.V ? l.FALSE.V : l.TRUE.V;
    }
  }
  return v.HOOK.handleRefresh = (i, n) => {
    var t;
    n.data.content = n.data, (t = n.data.content) == null || t.forEach((g) => {
      var w;
      g.notificationTypeNames = (w = g.notificationTypeName) == null ? void 0 : w.join("、");
    });
  }, (i, n) => {
    const t = L, g = A, w = V("common-table"), S = F;
    return s(), N("div", z, [_("div", J, [r(e(P), { ref: "header" }, null, 512)]), R((s(), u(w, { ref_key: "tableRef", ref: b, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(T), style: { width: "100%" }, "row-key": "id", onSelectionChange: e(c).selectionChangeHandler }, { default: m(() => [r(t, { type: "selection", width: "55", align: "center" }), r(t, { label: "序号", type: "index", align: "center", width: "60" }), e(h).visible("name") ? (s(), u(t, { "show-overflow-tooltip": true, align: "center", key: "name", prop: "name", label: "名称" })) : f("", true), e(h).visible("hookUrl") ? (s(), u(t, { "show-overflow-tooltip": true, align: "center", key: "hookUrl", prop: "hookUrl", label: "URL路径" }, { default: m((a) => [_("div", null, k(a.row.hookUrl), 1)]), _: 1 })) : f("", true), e(h).visible("notificationTypeNames") ? (s(), u(t, { "show-overflow-tooltip": true, align: "center", key: "notificationTypeNames", prop: "notificationTypeNames", label: "业务流程类型" }, { default: m((a) => [_("div", null, k(a.row.notificationTypeNames), 1)]), _: 1 })) : f("", true), e(h).visible("status") ? (s(), u(t, { key: "status", prop: "status", label: "状态", align: "center", width: "100" }, { default: m((a) => [r(g, { modelValue: a.row.status, "onUpdate:modelValue": (y) => a.row.status = y, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(l).TRUE.V, "inactive-value": e(l).FALSE.V, disabled: !e(x)(e(p).editStatus), onChange: (y) => E(a.row, a.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 })) : f("", true), e(x)([...e(p).edit, ...e(p).del]) ? (s(), u(t, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: m((a) => [r(e(H), { data: a.row, permission: e(p) }, null, 8, ["data", "permission"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[S, e(c).loading]]), r(e(I)), r(e(M))]);
  };
} };
export {
  ae as default
};
