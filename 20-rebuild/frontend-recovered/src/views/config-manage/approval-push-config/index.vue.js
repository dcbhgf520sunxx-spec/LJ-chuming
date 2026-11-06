import { ref as k } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as r } from "vue";
import { withCtx as h } from "vue";
import { toDisplayString as R } from "vue";
import { createCommentVNode as d } from "vue";
import { ElMessageBox as U } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElSwitch as D } from "element-plus";
import { vLoading as P } from "element-plus";
import { l as f, x as K, cz as m, o as N, cA as b, cB as l, G as w, an as O } from "../../../shared/runtime.js";
import H from "./module/header.vue.js";
import I from "./module/form.vue.js";
function M(a) {
  return f({ url: "/api/notification/approve/config/getPushApproveList", method: "get", params: a });
}
function $(a) {
  return f({ url: "/api/notification/approve/config/save", method: "post", data: a });
}
function q(a) {
  return f({ url: "/api/notification/approve/config/update", method: "post", data: a });
}
function z(a) {
  return f({ url: "/api/notification/approve/config/delete", method: "post", data: a });
}
function G(a) {
  return f({ url: "/api/notification/approve/config/status", method: "put", params: a });
}
const Y = { get: M, add: $, edit: q, del: z }, j = { class: "app-container" }, J = { class: "head-container" }, ee = { __name: "index", setup(a) {
  const C = { batchAdd: false, add: true, edit: false, del: true, download: false }, g = k(), { crud: p, columns: u, CRUD: _ } = K({ title: "审批推送配置", sort: [], permission: { ...m }, optShow: { ...C }, crudApi: { ...Y }, hasPagination: false, formStore: false }, g), { maxHeight: S } = N({ paginate: false });
  async function x(i, s) {
    try {
      await U.confirm('此操作将 "' + l.VL[s] + '" ' + b.VL[i.appType] + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const t = { id: i.id, status: i.status };
      await G(t), p.refresh(), p.notify(l.VL[s] + "成功", _.NOTIFICATION_TYPE.SUCCESS);
    } catch (t) {
      console.log("变更状态失败", t, s), i.status = i.status === l.TRUE.V ? l.FALSE.V : l.TRUE.V;
    }
  }
  return _.HOOK.handleRefresh = (i, s) => {
    s.data.content = s.data;
  }, (i, s) => {
    const t = F, T = D, V = B("common-table"), E = P;
    return n(), A("div", j, [v("div", J, [c(e(H), { ref: "header" }, null, 512)]), L((n(), r(V, { ref_key: "tableRef", ref: g, data: e(p).data, "empty-text": e(p).emptyText, "max-height": e(S), style: { width: "100%" }, "row-key": "id", onSelectionChange: e(p).selectionChangeHandler }, { default: h(() => [c(t, { type: "selection", width: "55", align: "center" }), c(t, { label: "序号", type: "index", align: "center", width: "60" }), e(u).visible("appType") ? (n(), r(t, { align: "center", key: "appType", prop: "appType", label: "appType", width: "90" }, { default: h((o) => [v("div", null, R(o.row.appType ? e(b).VL[o.row.appType] : "-"), 1)]), _: 1 })) : d("", true), e(u).visible("appKey") ? (n(), r(t, { align: "center", key: "appKey", prop: "appKey", label: "appKey" })) : d("", true), e(u).visible("appSecret") ? (n(), r(t, { align: "center", key: "appSecret", prop: "appSecret", label: "appSecret" })) : d("", true), e(u).visible("robotCode") ? (n(), r(t, { align: "center", key: "robotCode", prop: "robotCode", label: "robotCode" })) : d("", true), e(u).visible("status") ? (n(), r(t, { key: "status", prop: "status", label: "状态", align: "center", width: "100" }, { default: h((o) => [c(T, { modelValue: o.row.status, "onUpdate:modelValue": (y) => o.row.status = y, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(l).TRUE.V, "inactive-value": e(l).FALSE.V, disabled: !e(w)(e(m).editStatus), onChange: (y) => x(o.row, o.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 })) : d("", true), e(w)([...e(m).edit, ...e(m).del]) ? (n(), r(t, { key: 5, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: h((o) => [c(e(O), { data: o.row, permission: e(m) }, null, 8, ["data", "permission"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[E, e(p).loading]]), c(e(I))]);
  };
} };
export {
  ee as default
};
